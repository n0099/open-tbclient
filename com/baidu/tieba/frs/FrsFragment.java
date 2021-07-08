package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceRequestMessage;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsBroadcastCopyGuideDialogView;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsRedpackRunView;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.v0.a;
import d.a.o0.a.g;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.o0.r.s.a;
import d.a.p0.h.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, d.a.p0.u0.d2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, d.a.p0.u0.t0, d.a.p0.w2.t, d.a.p0.u0.e2.l, d.a.p0.e.e.b, d.a.p0.u0.n0, d.a.p0.u0.q0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a2;
    public static d.a.p0.h3.m b2;
    public static volatile long c2;
    public static volatile long d2;
    public static volatile int e2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public d.a.p0.v.a A0;
    public CustomMessageListener A1;
    public final b2 B;
    public d.a.p0.u0.i1.a.a B0;
    public final d.a.p0.h3.s B1;
    public FrsViewData C;
    public d.a.o0.r.s.a C0;
    public final CustomMessageListener C1;
    public String D;
    public boolean D0;
    public final CustomMessageListener D1;
    public d.a.c.e.k.b<TbImageView> E;
    public AddExperiencedModel E0;
    public final g.b E1;
    public long F;
    public boolean F0;
    public final d.a.p0.u0.e2.k F1;
    public long G;
    public boolean G0;
    public final View.OnTouchListener G1;
    public long H;
    public boolean H0;
    public final CustomMessageListener H1;
    public long I;
    public Date I0;
    public final View.OnClickListener I1;
    public long J;
    public int J0;
    public final RecyclerView.OnScrollListener J1;
    public long K;
    public int K0;
    public final d.a.p0.u0.f K1;
    public long L;
    public int L0;
    public final NoNetworkView.b L1;
    public long M;
    public List<LiveHorseRaceData> M0;
    public final CustomMessageListener M1;
    public boolean N;
    public ValueAnimator N0;
    public d.a.c.k.e.w N1;
    public boolean O;
    public Runnable O0;
    public d.a.p0.u0.s0 O1;
    public boolean P;
    public int P0;
    public CustomMessageListener P1;
    public d.a.o0.m0.b Q;
    public d.a.p0.u0.c2.b Q0;
    public CustomMessageListener Q1;
    public boolean R;
    public d.a.p0.u0.j1.a R0;
    public CustomMessageListener R1;
    public boolean S;
    public int S0;
    public CustomMessageListener S1;
    public String T;
    public int T0;
    public CustomMessageListener T1;
    public a.C0611a U;
    public d.a.p0.u0.n2.e U0;
    public CustomMessageListener U1;
    public ThreadCardViewHolder V;
    public d.a.p0.u0.g1.f V0;
    public CustomMessageListener V1;
    public FrsModelController W;
    public boolean W0;
    public CustomMessageListener W1;
    public d.a.p0.u0.o2.h X;
    public boolean X0;
    public HttpMessageListener X1;
    public FrsTabViewController Y;
    public MessageQueue.IdleHandler Y0;
    public CustomMessageListener Y1;
    public d.a.p0.u0.e2.h Z;
    public final CustomMessageListener Z0;
    public d.a.p0.w0.a Z1;
    public d.a.p0.u0.h2.a a0;
    public CustomMessageListener a1;
    public d.a.p0.u0.e2.b b0;
    public CustomMessageListener b1;
    public d.a.p0.u0.u0 c0;
    public CustomMessageListener c1;
    public CustomMessageListener d1;

    /* renamed from: e  reason: collision with root package name */
    public String f15292e;
    public d.a.c.c.g.a e1;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.u0.m1.a f15293f;
    public CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15294g;
    public final d.a.p0.u0.s0 g1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15295h;
    public FrsTabViewController.n h1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15296i;
    public SparseArray<d.a.p0.e.e.a> i0;
    public int i1;
    public String j;
    public boolean j0;
    public CustomMessageListener j1;
    public String k;
    public d.a.p0.u0.m1.e.b k0;
    public CustomMessageListener k1;
    public int l;
    public d.a.p0.u0.o2.a l0;
    public final CustomMessageListener l1;
    public boolean m;
    public d.a.p0.u0.e2.d m0;
    public final CustomMessageListener m1;
    public boolean n;
    public d.a.p0.u0.e2.c n0;
    public final CustomMessageListener n1;
    public String o;
    public d.a.p0.u0.o2.j o0;
    public final AntiHelper.k o1;
    public String p;
    public d.a.p0.u0.e2.a p0;
    public CustomMessageListener p1;
    public int q;
    public d.a.p0.u0.c2.a q0;
    public CustomMessageListener q1;
    public boolean r;
    public d.a.p0.u0.p r0;
    public CustomMessageListener r1;
    public d.a.p0.h3.h0.f s;
    public d.a.p0.u0.o2.c s0;
    public CustomMessageListener s1;
    public boolean t;
    public d.a.o0.z0.a0 t0;
    public CustomMessageListener t1;
    public boolean u;
    public View.OnTouchListener u0;
    public HttpMessageListener u1;
    public VoiceManager v;
    public d.a.p0.u0.r2.a v0;
    public d.a.o0.f0.i v1;
    public View w;
    public d.a.p0.u0.o2.e w0;
    public final CustomMessageListener w1;
    public d.a.p0.u0.q x;
    public boolean x0;
    public CustomMessageListener x1;
    public OvalActionButton y;
    public d.a.p0.u0.w1.b y0;
    public final CustomMessageListener y1;
    public FRSRefreshButton z;
    public d.a.p0.h.a z0;
    public CustomMessageListener z1;

    /* loaded from: classes4.dex */
    public class a implements FrsTabViewController.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15297a;

        public a(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15297a = frsFragment;
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                boolean z = false;
                if (i2 != 1) {
                    d.a.p0.a0.t.b().e(false);
                    this.f15297a.W2(false);
                }
                if (i2 == 502) {
                    this.f15297a.y.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.f15297a.y.setIconFade(0);
                }
                this.f15297a.i1 = i2;
                this.f15297a.S0 = i3;
                if (this.f15297a.Q0 != null) {
                    this.f15297a.Q0.d(this.f15297a.S0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.f15297a.S0);
                this.f15297a.V3();
                d.a.p0.u0.j2.b bVar = d.a.p0.u0.j2.d.h0;
                bVar.f62959d = i2;
                bVar.f62962g = i3;
                bVar.f62960e = -1;
                if (!this.f15297a.F0) {
                    this.f15297a.x.N1(this.f15297a.j2(i2));
                    return;
                }
                d.a.p0.u0.b.e().m(i2 == 1 && this.f15297a.F0, true);
                d.a.p0.u0.a h2 = d.a.p0.u0.a.h();
                if (i2 == 1 && this.f15297a.F0) {
                    z = true;
                }
                h2.p(z, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15298e;

        public a0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15298e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15298e.x.M1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15299a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15299a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.f15299a.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f15299a.z != null) {
                    if (booleanValue) {
                        if (this.f15299a.Y.I() == 0 || this.f15299a.x.E0() || d.a.o0.x.d.h().k()) {
                            return;
                        }
                        this.f15299a.z.f();
                        return;
                    }
                    this.f15299a.z.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15300a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15300a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.f15300a.Y.g0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15301a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15301a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.o0.t.n) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f15301a.C.updateCurrentUserPendant((d.a.o0.t.n) customResponsedMessage.getData());
            this.f15301a.x.W().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f15302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15303f;

        public b1(FrsFragment frsFragment, LiveHorseRaceData liveHorseRaceData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, liveHorseRaceData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15303f = frsFragment;
            this.f15302e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (this.f15303f.C != null && this.f15303f.C.getForum() != null) {
                    str = this.f15303f.C.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.f15303f.p).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.f15302e.getLive_id() != null) {
                    alaInfoData.live_id = this.f15302e.getLive_id().longValue();
                    alaInfoData.screen_direction = this.f15302e.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f15303f.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.f15303f.p)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15304a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15304a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.f15304a.C == null) {
                return;
            }
            d.a.p0.u0.n2.n.d(this.f15304a.C, this.f15304a.getPageContext());
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15305a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15305a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.f15305a.C == null || (userData = this.f15305a.C.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.f15305a.X.O(num);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15306a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15306a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f15306a.z == null || this.f15306a.y == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                this.f15306a.z.setVisibility(8);
                this.f15306a.y.setVisibility(8);
                return;
            }
            this.f15306a.y.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15307a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15307a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f15307a.Y.b(49);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements d.a.p0.u0.w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15308a;

        public d0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15308a = frsFragment;
        }

        @Override // d.a.p0.u0.w0
        public void a(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f15308a.x == null) {
                return;
            }
            boolean z3 = false;
            if (i2 == 1) {
                this.f15308a.x.s1(z ? 0 : 8);
            } else if (i2 == 2) {
                this.f15308a.x.p1(z ? 0 : 8);
            }
            if (!z2) {
                this.f15308a.F0 = z;
            }
            if (this.f15308a.x.W() != null && (i2 == 2 || (this.f15308a.W != null && this.f15308a.W.U()))) {
                this.f15308a.x.W().notifyDataSetChanged();
            }
            if (this.f15308a.F2() != null) {
                FrsTabViewController.o z4 = this.f15308a.F2().z();
                if (z4 != null) {
                    if ((z4.f16083b instanceof FrsCommonTabFragment) && (i2 == 2 || z4.f16082a == 502)) {
                        ((FrsCommonTabFragment) z4.f16083b).b1();
                    } else if ((z4.f16083b instanceof FrsNewAreaFragment) && (i2 == 2 || z4.f16082a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) z4.f16083b;
                        frsNewAreaFragment.B1();
                        if (frsNewAreaFragment.m1() != null) {
                            d.a.p0.u0.e2.g m1 = frsNewAreaFragment.m1();
                            m1.G(!z);
                            if (i2 == 1) {
                                m1.D(!z);
                            } else if (i2 == 2) {
                                m1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = z4.f16083b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).w1();
                        }
                    }
                }
                if (this.f15308a.F2().J() != null) {
                    this.f15308a.F2().J().setmDisallowSlip(z);
                    this.f15308a.F2().d0(z);
                }
            }
            if (this.f15308a.x.Y() != null) {
                d.a.p0.u0.q qVar = this.f15308a.x;
                if (this.f15308a.i2() && !z) {
                    z3 = true;
                }
                qVar.N1(z3);
            }
            if (this.f15308a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.f15308a.getActivity()).showTabHost(!z);
            }
            if (this.f15308a.B0 != null) {
                this.f15308a.B0.f(!z);
            }
            this.f15308a.x.x1(!z);
            if (i2 == 1) {
                this.f15308a.x.o1(!z);
            } else if (i2 == 2) {
                this.f15308a.x.o1(true);
            }
        }

        @Override // d.a.p0.u0.w0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15308a.getContext() == null) {
                return;
            }
            if (i2 != 1) {
                if (i2 != 2 || this.f15308a.x == null) {
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.f15308a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.f15308a.getContext().getString(R.string.frs_move_area_max_num));
                bdTopToast.j(this.f15308a.x.l0());
                return;
            }
            d.a.c.e.p.l.L(this.f15308a.getContext(), R.string.frs_multi_delete_max_num);
        }

        @Override // d.a.p0.u0.w0
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f15308a.x == null) {
                return;
            }
            if (i3 == 1) {
                this.f15308a.x.r1(i2);
            } else if (i3 == 2) {
                this.f15308a.x.q1(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15310f;

        public d1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15310f = frsFragment;
            this.f15309e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f15309e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15309e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15311a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15311a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.f15311a.Y.b(1);
                this.f15311a.r2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15312a;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e0 e0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e0 e0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        public e0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15312a = frsFragment;
        }

        @Override // d.a.p0.h.f.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.f15312a.x.R();
            this.f15312a.x.Q();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.f15312a.Y == null || this.f15312a.Y.z() == null || !(this.f15312a.Y.z().f16083b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.f15312a.Y.z().f16083b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.f15312a.getString(R.string.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.f15312a.C0 == null) {
                        FrsFragment frsFragment = this.f15312a;
                        frsFragment.C0 = new d.a.o0.r.s.a(frsFragment.getActivity());
                    }
                    this.f15312a.C0.setMessage(text);
                    this.f15312a.C0.setPositiveButton(R.string.dialog_known, new a(this));
                    this.f15312a.C0.setCanceledOnTouchOutside(false);
                    this.f15312a.C0.create(this.f15312a.getPageContext());
                    this.f15312a.C0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.f15312a.C0 == null) {
                        FrsFragment frsFragment2 = this.f15312a;
                        frsFragment2.C0 = new d.a.o0.r.s.a(frsFragment2.getActivity());
                    }
                    this.f15312a.C0.setMessage(text);
                    this.f15312a.C0.setPositiveButton(R.string.know, new b(this));
                    this.f15312a.C0.setCanceledOnTouchOutside(false);
                    this.f15312a.C0.create(this.f15312a.getPageContext());
                    this.f15312a.C0.show();
                } else {
                    this.f15312a.x.I1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.f15312a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.x1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.f15312a.n2(deleteThreadHttpResponseMessage.getSuccessItems());
                d.a.p0.u0.b.e().i(deleteThreadHttpResponseMessage.getSuccessItems());
                for (d.a.c.k.e.n nVar : this.f15312a.C.getThreadList()) {
                    if (nVar instanceof a2) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.f15312a.loadMore();
                    return;
                }
                return;
            }
            d.a.c.e.p.l.M(this.f15312a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15314f;

        public e1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15314f = frsFragment;
            this.f15313e = frsRedpackRunView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f15313e.setAlpha(0.0f);
                this.f15313e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                this.f15313e.c();
                this.f15314f.A.removeView(this.f15313e);
                if (this.f15314f.M0 == null || this.f15314f.L0 <= this.f15314f.M0.size() - 1) {
                    this.f15314f.N2();
                    return;
                }
                this.f15314f.A.removeAllViews();
                this.f15314f.A.setVisibility(8);
                this.f15314f.L0 = 0;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15315a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15315a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.h3.w) || this.f15315a.C == null) {
                return;
            }
            this.f15315a.C.updateLikeData((d.a.p0.h3.w) customResponsedMessage.getData());
            this.f15315a.X.R(this.f15315a.C);
            this.f15315a.Y.d(this.f15315a.C, this.f15315a.W.R());
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15316a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f15317e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f0 f15318f;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0198a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15319e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f15320f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f15321g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f15322h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ int f15323i;
                public final /* synthetic */ a j;

                public RunnableC0198a(a aVar, long j, int i2, int i3, float f2, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.j = aVar;
                    this.f15319e = j;
                    this.f15320f = i2;
                    this.f15321g = i3;
                    this.f15322h = f2;
                    this.f15323i = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.f15319e, 0L, 0L, this.f15320f, this.f15321g, this.f15322h, this.f15323i);
                        requestGetMyPostNetMessage.setTag(this.j.f15318f.f15316a.getUniqueId());
                        requestGetMyPostNetMessage.setProZone(2);
                        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                    }
                }
            }

            public a(f0 f0Var, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f0Var, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15318f = f0Var;
                this.f15317e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15318f.f15316a.Y.b(301);
                    d.a.c.e.m.e.a().postDelayed(new RunnableC0198a(this, d.a.c.e.m.b.f((String) this.f15317e.get(d.a.o0.a.g.p), 0L), d.a.c.e.p.l.k(TbadkCoreApplication.getInst()), d.a.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
                }
            }
        }

        public f0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15316a = frsFragment;
        }

        @Override // d.a.o0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(d.a.o0.a.g.o) instanceof String) {
                this.f15316a.j = (String) hashMap.get(d.a.o0.a.g.o);
            }
            if (!(hashMap.get(d.a.o0.a.g.J) instanceof String) || TextUtils.isEmpty((String) hashMap.get(d.a.o0.a.g.J))) {
                return;
            }
            d.a.c.e.m.e.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes4.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15325f;

        public f1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15325f = frsFragment;
            this.f15324e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15325f.A == null || this.f15324e == null) {
                return;
            }
            this.f15325f.N0.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15326a;

        public g(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15326a = frsFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15327a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15327a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f15327a.C == null) {
                return;
            }
            this.f15327a.C.removeGameRankListFromThreadList();
            if (this.f15327a.x != null) {
                this.f15327a.x.F0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15328a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15328a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f15328a.C.getToLoadHorseData().intValue() == 1 && this.f15328a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.f15328a.p));
                this.f15328a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15329a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12819c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.f15329a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.f15329a.getActivity(), updateAttentionMessage.getData().l, this.f15329a.o1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f12817a && updateAttentionMessage.getData().f12820d) {
                    d.a.c.e.p.l.L(this.f15329a.getPageContext().getPageActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements d.a.p0.u0.e2.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15330a;

        public h0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15330a = frsFragment;
        }

        @Override // d.a.p0.u0.e2.k
        public void a(int i2, boolean z, int i3, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.f15330a.a0 == null || this.f15330a.W == null || !this.f15330a.W.u0() || !z || z2 || z3) {
                return;
            }
            this.f15330a.a0.a(i3);
        }
    }

    /* loaded from: classes4.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15331a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15331a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.f15331a.I0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15332a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15332a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f15332a.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15333e;

        public i0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15333e = frsFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f15333e.u0 != null) {
                    this.f15333e.u0.onTouch(view, motionEvent);
                }
                if (this.f15333e.c0 != null && this.f15333e.c0.e() != null) {
                    this.f15333e.c0.e().c(motionEvent);
                }
                if (this.f15333e.y0 != null) {
                    this.f15333e.y0.b(view, motionEvent);
                }
                if (this.f15333e.X != null) {
                    this.f15333e.X.N(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15334a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15334a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.o0.r.q.a0) && this.f15334a.isResumed()) {
                d.a.o0.r.q.a0 a0Var = (d.a.o0.r.q.a0) customResponsedMessage.getData();
                if (this.f15334a.R0 == null) {
                    FrsFragment frsFragment = this.f15334a;
                    frsFragment.R0 = new d.a.p0.u0.j1.a(frsFragment.getPageContext());
                }
                if (this.f15334a.C == null || this.f15334a.C.getForum() == null || TextUtils.isEmpty(this.f15334a.C.getForum().getId())) {
                    return;
                }
                this.f15334a.R0.g(a0Var.f52553a, this.f15334a.C.getForum().getId(), this.f15334a.C.getForum().getName(), a0Var.f52554b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15335a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15335a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.f15335a.x.L1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15336a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15336a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
            if (j.k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || this.f15336a.C.getForum() == null) {
                return;
            }
            this.f15336a.C.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes4.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15337a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (b2Var = (b2) customResponsedMessage.getData()) != null && this.f15337a.isResumed()) {
                FrsFragment frsFragment = this.f15337a;
                frsFragment.T = b2Var.n1() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", b2Var.Q());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15338a;

        public k(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15338a = frsFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f15338a.f3();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f15339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15340f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f15341g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f15342h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f15343i;
        public final /* synthetic */ FrsFragment j;

        public k0(FrsFragment frsFragment, long j, int i2, int i3, float f2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = frsFragment;
            this.f15339e = j;
            this.f15340f = i2;
            this.f15341g = i3;
            this.f15342h = f2;
            this.f15343i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.f15339e, 0L, 0L, this.f15340f, this.f15341g, this.f15342h, this.f15343i);
                requestGetMyPostNetMessage.setTag(this.j.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15344a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k1 f15345e;

            public a(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15345e = k1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f15345e.f15344a.C.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.p0.h3.h0.m(this.f15345e.f15344a.getContext(), "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15344a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg) && this.f15344a.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount > 0) {
                    ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f15344a.C.getForum().getId(), this.f15344a.C.getForum().getName(), "6");
                    forumBroadcastHelper.clipCopy(this.f15344a.T);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.f15344a.getContext());
                screenTopToast.m(this.f15344a.getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(this.f15344a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.f15344a.w.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15346a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15346a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), this.f15346a.p)) {
                this.f15346a.p0.l(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15347e;

        public l0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15347e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.h3.n0.a.o(this.f15347e.j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15348a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15348a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.p0.h.h hVar = (d.a.p0.h.h) customResponsedMessage.getData();
            if (this.f15348a.C == null || this.f15348a.C.getForum() == null || this.f15348a.C.getForum().getDeletedReasonInfo() == null) {
                d.a.p0.h.e.d(0, this.f15348a.getPageContext(), hVar, null, this.f15348a.C.getUserData());
                return;
            }
            d.a.p0.h.i iVar = new d.a.p0.h.i(this.f15348a.C.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f15348a.C.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.f15348a.C.forumRule != null ? this.f15348a.C.forumRule.has_forum_rule.intValue() : 0);
            iVar.i(this.f15348a.C.getForum().getId(), this.f15348a.C.getForum().getName());
            iVar.h(this.f15348a.C.getForum().getImage_url());
            iVar.j(this.f15348a.C.getForum().getUser_level());
            d.a.p0.h.e.d(iVar.f(), this.f15348a.getPageContext(), hVar, iVar, this.f15348a.C.getUserData());
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15349a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15349a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.f15349a.x != null) {
                    this.f15349a.x.W0(msgCount, z);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f15350e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15351f;

        public m0(FrsFragment frsFragment, d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15351f = frsFragment;
            this.f15350e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.r.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f15350e) == null) {
                return;
            }
            aVar.dismiss();
            this.f15351f.E3();
        }
    }

    /* loaded from: classes4.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15352a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15352a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f15352a.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f15352a.Y.z() == null || !(this.f15352a.Y.z().f16083b instanceof BaseFragment) || !((BaseFragment) this.f15352a.Y.z().f16083b).isPrimary() || this.f15352a.x.E0()) {
                this.f15352a.A.setVisibility(8);
                this.f15352a.N = true;
                return;
            }
            this.f15352a.A.setVisibility(0);
            this.f15352a.N = false;
        }
    }

    /* loaded from: classes4.dex */
    public class n extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15353a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15353a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f15353a.getContext() == null || this.f15353a.x == null) {
                return;
            }
            int i2 = 0;
            if (httpResponsedMessage.getError() == 0) {
                BdTopToast bdTopToast = new BdTopToast(this.f15353a.getContext());
                bdTopToast.i(true);
                bdTopToast.h(this.f15353a.getContext().getString(R.string.frs_move_area_move_suc));
                bdTopToast.j(this.f15353a.x.l0());
                if (d.a.p0.u0.a.h().k(d.a.p0.u0.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.f15353a.Y != null && this.f15353a.Y.z() != null && (this.f15353a.Y.z().f16083b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.f15353a.Y.z().f16083b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.Z0();
                    }
                    this.f15353a.o2();
                    d.a.p0.u0.a.h().d();
                    for (d.a.c.k.e.n nVar : this.f15353a.C.getThreadList()) {
                        if (nVar instanceof a2) {
                            i2++;
                            continue;
                        }
                        if (i2 >= 6) {
                            break;
                        }
                    }
                    if (i2 < 6) {
                        this.f15353a.loadMore();
                    }
                }
                d.a.p0.u0.a.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.f15353a.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(this.f15353a.x.l0());
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements d.a.o0.r.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15354a;

        public n0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15354a = frsFragment;
        }

        @Override // d.a.o0.r.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.o0.x.d.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.f15354a.y != null) {
                        this.f15354a.y.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.f15354a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.f15354a.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint));
                bdTopToast.j(this.f15354a.x.l0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n1 extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15355a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(FrsFragment frsFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15355a = frsFragment;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage;
            if (z || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                List<LiveHorseRaceData> arrayList = new ArrayList<>();
                if (z) {
                    arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().a();
                }
                if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                    arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().a();
                }
                if (this.f15355a.M0 != null) {
                    if (this.f15355a.A == null || this.f15355a.A.getVisibility() != 8) {
                        if (this.f15355a.L0 >= this.f15355a.M0.size()) {
                            this.f15355a.M0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = this.f15355a;
                        frsFragment.M0 = frsFragment.M0.subList(0, this.f15355a.L0);
                        this.f15355a.M0.addAll(arrayList);
                        return;
                    }
                    this.f15355a.M0 = new ArrayList();
                    this.f15355a.M0.addAll(arrayList);
                    this.f15355a.L0 = 0;
                    this.f15355a.N2();
                    return;
                }
                this.f15355a.M0 = new ArrayList();
                this.f15355a.L0 = 0;
                this.f15355a.M0.addAll(arrayList);
                this.f15355a.N2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends d.a.o0.f0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15356c;

        public o(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15356c = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.f0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.f15356c.getContext());
                bdTopToast.i(topToastEvent.isSuccess());
                bdTopToast.h(topToastEvent.getContent());
                bdTopToast.j(this.f15356c.x.l0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements d.a.o0.r.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15357a;

        public o0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15357a = frsFragment;
        }

        @Override // d.a.o0.r.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                d.a.o0.x.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.f15357a.y != null) {
                    this.f15357a.y.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15358a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15358a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                this.f15358a.r2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15359a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f15359a.isResumed()) {
                this.f15359a.U3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15360e;

        public p0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15360e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15360e.x != null && view == this.f15360e.x.T() && this.f15360e.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f15360e.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && d.a.c.e.p.l.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.f15360e.x == null || !this.f15360e.x.A0()) {
                        String c2 = this.f15360e.C.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c2)) {
                            d.a.o0.l.a.k(this.f15360e.getPageContext().getPageActivity(), c2);
                        }
                    } else {
                        this.f15360e.x.D1();
                    }
                }
                if (this.f15360e.x != null && view == this.f15360e.x.c0() && this.f15360e.W != null && this.f15360e.W.i0()) {
                    this.f15360e.x.G1();
                    this.f15360e.loadMore();
                }
                if (view != null && this.f15360e.x != null && view == this.f15360e.x.d0()) {
                    if (!ViewHelper.checkUpIsLogin(this.f15360e.getContext())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f15360e.getContext())));
                }
                if (d.a.c.e.p.j.z()) {
                    if (this.f15360e.C == null || this.f15360e.C.getForum() == null) {
                        return;
                    }
                    if (this.f15360e.x != null && view == this.f15360e.x.q0()) {
                        if (this.f15360e.C == null || this.f15360e.C.getForum() == null || StringUtils.isNull(this.f15360e.C.getForum().getId()) || StringUtils.isNull(this.f15360e.C.getForum().getName())) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", this.f15360e.C.getForum().getId()).param("obj_locate", 11));
                        d.a.p0.u0.n2.i.c(this.f15360e.getPageContext(), this.f15360e.C, this.f15360e.C.getForum().getId());
                    }
                    if (this.f15360e.x == null || view != this.f15360e.x.p0()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12402").param("fid", this.f15360e.C.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f15360e.C.getForum().getName()));
                    if (StringUtils.isNull(this.f15360e.C.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.f15360e.getContext(), this.f15360e.C.getForum().getName(), this.f15360e.C.getForum().getId())));
                    return;
                }
                d.a.c.e.p.l.L(this.f15360e.getContext().getApplicationContext(), R.string.network_not_available);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements d.a.p0.u0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15361a;

        public p1(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15361a = frsFragment;
        }

        @Override // d.a.p0.u0.s0
        public void a(int i2, int i3, d.a.p0.u0.b1 b1Var, ArrayList<d.a.c.k.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                this.f15361a.L3();
                if (this.f15361a.k0 != null) {
                    this.f15361a.X.c0(this.f15361a.k0.e(i2));
                }
                d.a.p0.h3.f fVar = new d.a.p0.h3.f();
                if (b1Var != null) {
                    boolean z = b1Var.f62569e == 0;
                    fVar.f57934b = z;
                    fVar.f57935c = b1Var.f62569e;
                    fVar.f57936d = b1Var.f62570f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.f15361a.x.s0();
                        } else if (b1Var.f62571g) {
                            if (ListUtils.getCount(this.f15361a.C.getThreadList()) > 3) {
                                this.f15361a.x.G1();
                            } else {
                                this.f15361a.x.C1();
                            }
                        } else if (b1Var.f62573i) {
                            this.f15361a.x.J1();
                        } else {
                            this.f15361a.x.s0();
                        }
                    }
                } else {
                    b1Var = new d.a.p0.u0.b1();
                    b1Var.f64015c = 1;
                    b1Var.f62571g = false;
                    b1Var.f62573i = false;
                }
                if (i2 == 1) {
                    this.f15361a.R = true;
                    FrsFragment frsFragment = this.f15361a;
                    frsFragment.B1.d(frsFragment.W.getType(), false, fVar);
                } else {
                    this.f15361a.K3(fVar);
                    if (this.f15361a.W.d0() != null) {
                        FrsFragment frsFragment2 = this.f15361a;
                        frsFragment2.C = frsFragment2.W.d0();
                    }
                    this.f15361a.c3();
                }
                if (this.f15361a.O1 != null) {
                    this.f15361a.O1.a(i2, i3, b1Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15362a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f15362a.x != null) {
                    this.f15362a.x.d1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15363a;

        /* renamed from: b  reason: collision with root package name */
        public int f15364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15365c;

        public q0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15365c = frsFragment;
            this.f15363a = 0;
            this.f15364b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f15365c.X != null) {
                    this.f15365c.X.p0(i2);
                    if (i2 == 1) {
                        this.f15365c.X.y();
                    }
                }
                FrsFragment frsFragment = this.f15365c;
                if (frsFragment.Q == null && !frsFragment.R2()) {
                    this.f15365c.Q = new d.a.o0.m0.b();
                    this.f15365c.Q.a(1000);
                }
                if (i2 == 0) {
                    d.a.o0.m0.b bVar = this.f15365c.Q;
                    if (bVar != null) {
                        bVar.e();
                    }
                    d.a.p0.a0.t.b().e(true);
                    this.f15365c.W2(true);
                    this.f15365c.x.I0(this.f15363a, this.f15364b);
                } else {
                    d.a.o0.m0.b bVar2 = this.f15365c.Q;
                    if (bVar2 != null) {
                        bVar2.d();
                    }
                }
                if (this.f15365c.w0 != null) {
                    this.f15365c.w0.i(recyclerView, i2);
                }
                if (i2 == 0) {
                    d.a.p0.u0.n2.l.b(this.f15365c.x, this.f15365c.C, this.f15365c.h(), false, null);
                }
                if (this.f15365c.Y != null && i2 == 1) {
                    this.f15365c.Y.L();
                }
                if (this.f15365c.V == null) {
                    if (this.f15365c.x.i0() != null && !this.f15365c.x.a0() && this.f15365c.x.i0().j() != null && (this.f15365c.x.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.f15365c;
                        frsFragment2.V = (ThreadCardViewHolder) frsFragment2.x.i0().j().getTag();
                    }
                } else if (i2 == 0 && this.f15365c.x.i0() != null && !this.f15365c.x.a0() && this.f15365c.x.i0().j() != null && (this.f15365c.x.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.f15365c;
                    frsFragment3.V = (ThreadCardViewHolder) frsFragment3.x.i0().j().getTag();
                }
                if (i2 == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f15365c.K0 += i3;
                if (this.f15365c.K0 >= this.f15365c.J0 * 2 && i3 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.f15365c.l0 != null) {
                    this.f15365c.l0.j();
                }
                this.f15363a = 0;
                this.f15364b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.f15363a = bdRecyclerView.getFirstVisiblePosition();
                    this.f15364b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.f15365c.w0 != null) {
                    this.f15365c.w0.h(recyclerView, this.f15363a, this.f15364b);
                }
                if (this.f15365c.C == null || this.f15365c.x == null || this.f15365c.x.W() == null) {
                    return;
                }
                this.f15365c.x.e1(this.f15363a, this.f15364b);
                if (this.f15365c.V == null || this.f15365c.V.b() == null) {
                    return;
                }
                this.f15365c.V.b().o(this.f15365c.U);
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class q1 implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15366e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15367e;

            public a(q1 q1Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15367e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f15367e);
                    netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                    netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                    netWork.getNetData();
                }
            }
        }

        public q1(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15366e = frsFragment;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == d.a.p0.u0.u.f63844e) {
                if (this.f15366e.x != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f15366e.p).param("obj_locate", "1"));
                    this.f15366e.x.O1();
                }
            } else if (nVar == null || !(nVar instanceof a2)) {
            } else {
                b2 b2Var = ((a2) nVar).w;
                if (b2Var.C() == null || b2Var.C().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f15366e.getActivity())) {
                    if (b2Var.q() != 1 || ViewHelper.checkUpIsLogin(this.f15366e.getActivity())) {
                        if (b2Var.E() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f15366e.getActivity())) {
                                String a2 = b2Var.E().a();
                                if (StringUtils.isNull(a2) || !d.a.c.e.p.l.D()) {
                                    return;
                                }
                                d.a.o0.l.a.k(this.f15366e.getActivity(), a2);
                            }
                        } else if (b2Var.K() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f15366e.getPageContext().getPageActivity());
                                return;
                            }
                            d.a.o0.r.q.u K = b2Var.K();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f15366e.getPageContext().getPageActivity(), K.a(), K.b(), 2)));
                        } else {
                            d.a.p0.h3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.d(b2Var.c0())) {
                                readThreadHistory.a(b2Var.c0());
                            }
                            String x = b2Var.x();
                            if (x == null || x.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, x)).start();
                                z = true;
                            }
                            String n1 = b2Var.n1();
                            if (n1 == null) {
                                n1 = "";
                            }
                            if (b2Var.m0() == 2 && !n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.f15366e.getPageContext(), new String[]{n1, "", null});
                                return;
                            }
                            if (n1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && n1.length() > 4) {
                                b2Var.v3(n1.substring(3));
                            }
                            if (bdUniqueId.getId() == b2.H3.getId()) {
                                d.a.p0.u0.n2.l.c(b2Var.e1());
                            } else if (bdUniqueId.getId() == b2.q3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", b2Var.n1());
                                TiebaStatic.log(statisticItem);
                            }
                            d.a.p0.u0.n2.m.e(this.f15366e, b2Var, i2, z);
                            FrsFragment frsFragment = this.f15366e;
                            d.a.p0.u0.n2.l.d(frsFragment, frsFragment.C, b2Var);
                        }
                    }
                }
            }
        }

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15368a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15368a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || d.a.c.e.p.k.isEmpty(str) || !str.equals(this.f15368a.p)) {
                    return;
                }
                d.a.p0.u0.n2.i.d(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.f15368a.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15369a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15369a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f15369a.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f15369a.Y.I() == 0 || this.f15369a.Y.z() == null || !(this.f15369a.Y.z().f16083b instanceof BaseFragment) || !((BaseFragment) this.f15369a.Y.z().f16083b).isPrimary() || this.f15369a.x.E0() || d.a.o0.x.d.h().k()) {
                if (this.f15369a.Y.I() != 0) {
                    this.f15369a.z.b();
                    return;
                }
                return;
            }
            this.f15369a.z.f();
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15370a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15370a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f15370a.x == null) {
                return;
            }
            this.f15370a.x.N();
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements d.a.p0.u0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15371a;

        public s0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15371a = frsFragment;
        }

        @Override // d.a.p0.u0.f
        public void a(int i2, int i3, View view, View view2, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, view2, b2Var}) == null) {
                if (i2 != this.f15371a.x.W().c()) {
                    if (i2 != this.f15371a.x.W().j()) {
                        if (i2 != this.f15371a.x.W().i() || this.f15371a.C == null || this.f15371a.C.getUserData() == null || !this.f15371a.C.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.f15371a.C.getBawuCenterUrl();
                        if (d.a.c.e.p.k.isEmpty(bawuCenterUrl) || this.f15371a.C.getForum() == null) {
                            return;
                        }
                        d.a.o0.l.a.l(this.f15371a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.f15371a.C.getForum().getId()).param("uid", this.f15371a.C.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.f15371a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.f15371a.C == null || this.f15371a.C.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.f15371a.C.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f15371a.getPageContext().getPageActivity(), d.a.c.e.m.b.f(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f15371a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    d.a.p0.u0.n2.m.d(this.f15371a.getPageContext(), this.f15371a.C);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15372a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15372a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f15372a.H3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15373e;

        public t0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15373e = frsFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f15373e.W.b0() == 1 && z && !this.f15373e.x.a0()) {
                if (this.f15373e.C != null && !ListUtils.isEmpty(this.f15373e.C.getThreadList())) {
                    this.f15373e.x.G0();
                    return;
                }
                FrsFragment frsFragment = this.f15373e;
                frsFragment.hideNetRefreshView(frsFragment.x.X().j());
                FrsFragment frsFragment2 = this.f15373e;
                frsFragment2.showLoadingView(frsFragment2.x.l0(), true);
                this.f15373e.x.t0(false);
                this.f15373e.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements d.a.p0.h3.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15374a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15375b;

        public u(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15375b = frsFragment;
            this.f15374a = 0L;
        }

        @Override // d.a.p0.h3.s
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f15374a = System.nanoTime();
                if (this.f15375b.x == null) {
                    return;
                }
                if (i2 == 1 || i2 == 2) {
                    this.f15375b.x.G0();
                }
            }
        }

        @Override // d.a.p0.h3.s
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f15375b.f3();
            }
        }

        @Override // d.a.p0.h3.s
        public void c(d.a.p0.h3.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                if ((mVar == null || !("normal_page".equals(this.f15375b.W.Z()) || "frs_page".equals(this.f15375b.W.Z()) || "book_page".equals(this.f15375b.W.Z()))) && !"brand_page".equals(this.f15375b.W.Z())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
                this.f15375b.g3(mVar);
                FrsFragment.b2 = mVar;
            }
        }

        @Override // d.a.p0.h3.s
        public void d(int i2, boolean z, d.a.p0.h3.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f15375b.j0) {
                    this.f15375b.j0 = false;
                    d.a.p0.u0.n2.l.b(this.f15375b.x, this.f15375b.C, this.f15375b.h(), false, null);
                }
                this.f15375b.L3();
                this.f15375b.P = true;
                if (fVar != null && fVar.f57934b) {
                    this.f15375b.x.W().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.c2 = 0L;
                    FrsFragment.d2 = 0L;
                    FrsFragment.e2 = 0;
                } else {
                    FrsFragment.e2 = 1;
                }
                if (!this.f15375b.W.u0() && (i2 == 3 || i2 == 6)) {
                    this.f15375b.n0.k();
                }
                this.f15375b.G = System.currentTimeMillis();
                if (this.f15375b.W.d0() != null) {
                    FrsFragment frsFragment = this.f15375b;
                    frsFragment.C = frsFragment.W.d0();
                }
                this.f15375b.J3(1);
                this.f15375b.B3();
                if (i2 == 7) {
                    this.f15375b.e3(this.f15375b.C.getFrsDefaultTabId());
                    return;
                }
                if (this.f15375b.C.getPage() != null) {
                    FrsFragment frsFragment2 = this.f15375b;
                    frsFragment2.n3(frsFragment2.C.getPage().b());
                }
                if (i2 == 4) {
                    if (!this.f15375b.W.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.f15375b.W.b0() == 1 && !d.a.p0.w0.a.d()) {
                        this.f15375b.C.addRecommendAppToThreadList(this.f15375b);
                    }
                    ArrayList<d.a.c.k.e.n> c2 = this.f15375b.n0.c(false, false, this.f15375b.C.getThreadList(), this.f15375b.s, false);
                    if (c2 != null) {
                        this.f15375b.C.setThreadList(c2);
                        this.f15375b.C.checkLiveStageInThreadList();
                    }
                    if (this.f15375b.W != null) {
                        d.a.p0.u0.j2.c.l(this.f15375b.C, this.f15375b.W.R(), 2, this.f15375b.getContext());
                    }
                    FrsFragment frsFragment3 = this.f15375b;
                    d.a.p0.u0.n2.a.a(frsFragment3, frsFragment3.C.getForum(), this.f15375b.C.getThreadList(), false, this.f15375b.D2());
                    this.f15375b.x.y1(c2, this.f15375b.C);
                    this.f15375b.N3();
                    return;
                }
                this.f15375b.N3();
                if (i2 == 1) {
                    this.f15375b.x.G0();
                } else if (i2 == 2) {
                    this.f15375b.x.G0();
                } else if (i2 == 3 || i2 == 6) {
                    if (this.f15375b.C != null) {
                        this.f15375b.C.clearPostThreadCount();
                    }
                    d.a.p0.u0.o2.c cVar = this.f15375b.s0;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
                this.f15375b.T3();
                if (fVar == null || fVar.f57935c == 0) {
                    if (this.f15375b.C == null) {
                        return;
                    }
                    FrsFragment frsFragment4 = this.f15375b;
                    frsFragment4.C3(frsFragment4.C);
                    this.f15375b.a3(false, i2 == 5);
                    if (this.f15375b.W != null) {
                        if (this.f15375b.C.getActivityHeadData() != null && this.f15375b.C.getActivityHeadData().b() != null && this.f15375b.C.getActivityHeadData().b().size() > 0) {
                            d.a.p0.u0.j2.a.e(this.f15375b.getUniqueId(), 1, this.f15375b.C.getForum(), this.f15375b.W.a0(), 1);
                        }
                        if (this.f15375b.C.getThreadList() != null && this.f15375b.C.getThreadList().size() > 0) {
                            Iterator<d.a.c.k.e.n> it = this.f15375b.C.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                d.a.c.k.e.n next = it.next();
                                if ((next instanceof b2) && ((b2) next).getType() == b2.H3) {
                                    d.a.p0.u0.j2.a.e(this.f15375b.getUniqueId(), 1, this.f15375b.C.getForum(), this.f15375b.W.a0(), 2);
                                    break;
                                }
                            }
                        }
                        d.a.p0.u0.j2.a.f(this.f15375b.getUniqueId(), this.f15375b.C.getThreadList(), this.f15375b.C.getForum(), this.f15375b.W.a0());
                    }
                    this.f15375b.x.R0(i2);
                    FrsFragment.c2 = (System.nanoTime() - this.f15374a) / 1000000;
                    if (fVar != null) {
                        FrsFragment.d2 = fVar.f57937e;
                    }
                } else if (this.f15375b.C == null || ListUtils.isEmpty(this.f15375b.C.getThreadList())) {
                    this.f15375b.K3(fVar);
                } else if (fVar.f57933a) {
                    FrsFragment frsFragment5 = this.f15375b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.net_error_text, fVar.f57936d, Integer.valueOf(fVar.f57935c)));
                }
                this.f15375b.Q3();
                this.f15375b.m2();
                if (this.f15375b.C.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.f15375b.t && this.f15375b.Y.b(49)) {
                    this.f15375b.t = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15376a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15376a = frsFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                d.a.p0.u0.n2.c.a(customResponsedMessage, this.f15376a.x, this.f15376a.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15377a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15377a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof b2) {
                    d.a.p0.u0.n2.l.b(this.f15377a.x, this.f15377a.C, this.f15377a.h(), true, (b2) data);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15378e;

        public v0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15378e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15378e.Y == null) {
                return;
            }
            FrsTabViewController.o z = this.f15378e.Y.z();
            if (z != null && (fragment = z.f16083b) != null && (fragment instanceof d.a.p0.u0.p0)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((d.a.p0.u0.p0) z.f16083b).E0();
                ((d.a.p0.u0.p0) z.f16083b).s();
                return;
            }
            this.f15378e.B0().O1();
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f15379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f15380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15381g;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, privateForumPopInfoData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15381g = frsFragment;
            this.f15379e = privateForumPopInfoData;
            this.f15380f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f15381g.getPageContext(), new String[]{this.f15379e.z()});
                this.f15380f.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements d.a.p0.u0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15382a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w0 f15383e;

            public a(w0 w0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15383e = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f15383e.f15382a.x != null && this.f15383e.f15382a.x.B0()) {
                    this.f15383e.f15382a.loadMore();
                }
            }
        }

        public w0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15382a = frsFragment;
        }

        @Override // d.a.p0.u0.s0
        public void a(int i2, int i3, d.a.p0.u0.b1 b1Var, ArrayList<d.a.c.k.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                d.a.c.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15384e;

        public x(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15384e = frsFragment;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15385a = frsFragment;
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
            this.f15385a.x0 = true;
        }
    }

    /* loaded from: classes4.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15387f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15388g;

        public y(FrsFragment frsFragment, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15388g = frsFragment;
            this.f15386e = i2;
            this.f15387f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f15388g.p).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f15386e));
                UrlManager.getInstance().dealOneLink(this.f15388g.getPageContext(), new String[]{this.f15387f});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15389a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15389a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.f15389a.V == null && this.f15389a.x.i0() != null && !this.f15389a.x.a0() && this.f15389a.x.i0().j() != null && (this.f15389a.x.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.f15389a;
                        frsFragment.V = (ThreadCardViewHolder) frsFragment.x.i0().j().getTag();
                    }
                    if (this.f15389a.V == null || this.f15389a.V.b() == null) {
                        return;
                    }
                    this.f15389a.V.b().o(new a.C0611a(3));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15390e;

        public z(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15390e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15390e.P || !d.a.c.e.p.j.z() || this.f15390e.x.D0()) {
                return;
            }
            this.f15390e.x.T0();
        }
    }

    /* loaded from: classes4.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f15391a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(FrsFragment frsFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i2)};
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
            this.f15391a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f15391a.x == null) {
                return;
            }
            this.f15391a.x.Q0();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1868069978, "Lcom/baidu/tieba/frs/FrsFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1868069978, "Lcom/baidu/tieba/frs/FrsFragment;");
        }
    }

    public FrsFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f15292e = "";
        this.f15295h = false;
        this.f15296i = true;
        this.j = null;
        this.k = null;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = false;
        this.t = false;
        this.u = false;
        this.x = null;
        this.B = null;
        this.C = new FrsViewData();
        this.F = -1L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = false;
        this.P = false;
        this.Q = null;
        this.R = true;
        this.S = true;
        this.U = new a.C0611a(2);
        this.i0 = new SparseArray<>();
        this.j0 = true;
        this.D0 = false;
        this.F0 = false;
        this.H0 = false;
        this.I0 = null;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = 0;
        this.P0 = -1;
        this.T0 = -1;
        this.Y0 = new k(this);
        this.Z0 = new v(this, 2016495);
        this.a1 = new g0(this, 2921005);
        this.b1 = new r0(this, 2921401);
        this.c1 = new c1(this, 2921473);
        this.d1 = new m1(this, 2921467);
        this.e1 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.f1 = new o1(this, 2001624);
        this.g1 = new p1(this);
        this.h1 = new a(this);
        this.j1 = new b(this, 2001606);
        this.k1 = new c(this, 2001607);
        this.l1 = new d(this, 2003019);
        this.m1 = new e(this, 2921470);
        this.n1 = new f(this, 2001352);
        this.o1 = new g(this);
        this.p1 = new h(this, 2001115);
        this.q1 = new i(this, 2921346);
        this.r1 = new j(this, 2001374);
        this.s1 = new l(this, 2001378);
        this.t1 = new m(this, 2001626);
        this.u1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.v1 = new o(this);
        this.w1 = new p(this, 2921391);
        this.x1 = new q(this, 2003020);
        this.y1 = new r(this, 2921463);
        this.z1 = new s(this, 2921587);
        this.A1 = new t(this, 2921588);
        this.B1 = new u(this);
        this.C1 = new b0(this, 2016485);
        this.D1 = new c0(this, 2001194);
        this.E1 = new f0(this);
        this.F1 = new h0(this);
        this.G1 = new i0(this);
        this.H1 = new j0(this, 2004507);
        this.I1 = new p0(this);
        this.J1 = new q0(this);
        this.K1 = new s0(this);
        this.L1 = new t0(this);
        this.M1 = new u0(this, 0);
        this.N1 = new q1(this, null);
        this.O1 = new w0(this);
        this.P1 = new x0(this, 2921033);
        this.Q1 = new y0(this, 2921381);
        this.R1 = new z0(this, 2921414);
        this.S1 = new a1(this, 2921437);
        this.T1 = new g1(this, 2921462);
        this.U1 = new h1(this, 2001223);
        this.V1 = new i1(this, 2921469);
        this.W1 = new j1(this, 2921475);
        this.X1 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.Y1 = new l1(this, 2921515);
    }

    @Override // d.a.p0.w2.t
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x.a0() : invokeV.booleanValue;
    }

    public void A3(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.z = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    @Override // d.a.p0.u0.n0
    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && isAdded() && this.j0 && isLoadingViewAttached()) {
            hideLoadingView(this.x.l0());
        }
    }

    @Override // d.a.p0.u0.e2.l
    public d.a.p0.u0.q B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (d.a.p0.u0.q) invokeV.objValue;
    }

    public BdRecyclerView B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.p0.u0.q qVar = this.x;
            if (qVar == null) {
                return null;
            }
            return qVar.b0();
        }
        return (BdRecyclerView) invokeV.objValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
        achievementActivityConfig.setUrl(stringExtra);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
            achievementActivityConfig.setShareUrl(this.C.getForumActiveInfo().forum_share_url);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
    }

    public d.a.p0.u0.u0 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c0 : (d.a.p0.u0.u0) invokeV.objValue;
    }

    public final boolean C3(d.a.p0.h3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar)) == null) {
            if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
                for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                    if (frsTabInfo.tab_id.intValue() == 502 && d.a.o0.r.d0.b.j().g("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            d.a.p0.u0.g1.f fVar = new d.a.p0.u0.g1.f(m());
            this.V0 = fVar;
            boolean h2 = fVar.h(mVar);
            this.W0 = h2;
            return h2;
        }
        return invokeL.booleanValue;
    }

    public int D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.p0.u0.e2.c cVar = this.n0;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new m0(this, aVar));
            aVar.setContentView(frsBroadcastCopyGuideDialogView);
            aVar.create(getPageContext()).show();
        }
    }

    public View E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.o0.x.d.h().m(new d.a.o0.x.a(getContext()));
            d.a.o0.x.d.h().n(85, 0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (d.a.o0.x.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public FrsTabViewController F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.Y : (FrsTabViewController) invokeV.objValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.o0.x.d.h().m(new d.a.o0.x.b(getContext()));
            d.a.o0.x.d.h().n(85, 0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (d.a.o0.x.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    @Override // d.a.p0.u0.n0
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final FrsTabInfoData G2() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.W == null || (frsViewData = this.C) == null || this.Y == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.C.getEntelechyTabInfo().tab) || (D = this.Y.D()) == 502) {
                return null;
            }
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.C.getEntelechyTabInfo().tab) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && (frsTabInfo.tab_id.intValue() != 505 || this.C.getUserData() == null || this.C.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (D == frsTabInfo.tab_id.intValue()) {
                        i2 = D;
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = i2;
            if (this.C.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.C.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public void G3(View view, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view, str, Boolean.valueOf(z2), list}) == null) {
            this.x.S0();
            this.x.g1(8);
            if (this.v0 == null) {
                this.v0 = new d.a.p0.u0.r2.a(getPageContext(), getNetRefreshListener());
            }
            this.v0.c(str);
            this.v0.b(list);
            this.v0.attachView(view, z2);
        }
    }

    public String H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public void H3() {
        d.a.p0.u0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (qVar = this.x) == null) {
            return;
        }
        qVar.B1();
    }

    public OvalActionButton I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.y : (OvalActionButton) invokeV.objValue;
    }

    public void I3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, str, str2, str3) == null) {
            d.a.p0.u0.n2.e eVar = new d.a.p0.u0.n2.e(str, str2);
            this.U0 = eVar;
            eVar.f(getFragmentActivity(), str3, str2);
        }
    }

    public FRSRefreshButton J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.z : (FRSRefreshButton) invokeV.objValue;
    }

    public final void J3(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.C) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (d.a.c.e.p.k.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", d.a.o0.z0.p0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public int K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            d.a.p0.u0.e2.c cVar = this.n0;
            if (cVar == null) {
                return -1;
            }
            return cVar.h();
        }
        return invokeV.intValue;
    }

    public final void K3(d.a.p0.h3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) {
            if (fVar == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
                this.x.S0();
                showNetRefreshView(this.x.l0(), string, true);
            } else if (340001 == fVar.f57935c) {
                P3(fVar, this.C.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.C.getThreadList())) {
                    O3(fVar);
                }
                if (R2()) {
                    setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            hideLoadingView(this.x.l0());
            this.x.Q1();
            if (this.x.k0() instanceof d.a.p0.u0.k2.d) {
                ((d.a.p0.u0.k2.d) this.x.k0()).d();
            }
        }
    }

    public void M2() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (fRSRefreshButton = this.z) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (K2() != 1 && !this.n0.b(this.C.getThreadListIds())) {
                if (ListUtils.isEmpty(this.C.getThreadList())) {
                    this.x.s0();
                } else {
                    this.x.J1();
                }
            } else if (ListUtils.getCount(this.C.getThreadList()) > 3) {
                this.x.G1();
            } else {
                this.x.C1();
            }
        }
    }

    public final void N2() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || !isResumed() || (list = this.M0) == null || list.size() < 1 || this.L0 > this.M0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.M0.get(this.L0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.L0++;
            N2();
        }
        if (this.A != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.N0 = ofFloat;
            ofFloat.setDuration(600L);
            this.N0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.N0.addListener(new e1(this, frsRedpackRunView));
            this.O0 = new f1(this, frsRedpackRunView);
            d.a.c.e.m.e.a().postDelayed(this.O0, 5000L);
            if (this.A.getChildCount() == 0) {
                this.L0++;
                this.A.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.C;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.C.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.p).param("fname", str));
            }
            LinearLayout linearLayout = this.A;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.Y.z().f16083b).isPrimary() || this.x.E0() || this.N) {
                return;
            }
            this.A.setVisibility(0);
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (K2() == 0 && ListUtils.isEmpty(this.C.getThreadListIds())) {
                if (ListUtils.isEmpty(this.C.getThreadList())) {
                    this.x.s0();
                } else {
                    this.x.J1();
                }
            } else if (ListUtils.getCount(this.C.getThreadList()) > 3) {
                this.x.G1();
            } else {
                this.x.C1();
            }
        }
    }

    @Override // d.a.p0.w2.t
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            d0().R0();
        }
    }

    public final void O2(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            registerListener(2001118, this.M1);
            long j2 = 0;
            if (bundle != null) {
                this.j = bundle.getString("name");
                this.k = bundle.getString("from");
                this.l = bundle.getInt("flag", 0);
                j2 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                this.j = intent.getStringExtra("name");
                this.k = intent.getStringExtra("from");
                this.l = intent.getIntExtra("flag", 0);
                j2 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            }
            if (getArguments() != null) {
                this.m = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
            }
            if (!TextUtils.isEmpty(this.k)) {
                FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.k);
            }
            if (this.mIsLogin) {
                registerListener(2001120, this.M1);
            }
            this.X.H(bundle);
            q2(j2);
        }
    }

    public final void O3(d.a.p0.h3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, fVar) == null) {
            this.x.S0();
            if (fVar.f57933a) {
                showNetRefreshView(this.x.l0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.f57936d, Integer.valueOf(fVar.f57935c)}), true);
            } else {
                showNetRefreshView(this.x.X().j(), fVar.f57936d, true);
            }
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.l == 0) {
                this.x.z1(this.j);
            } else {
                this.x.z1("");
                this.l = 1;
            }
            this.x.v1(this.N1);
            this.x.I(this.J1);
            this.x.w1(this.L1);
            this.x.W().l(this.K1);
        }
    }

    public final void P3(d.a.p0.h3.f fVar, List<RecmForumInfo> list) {
        d.a.p0.u0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, fVar, list) == null) || (qVar = this.x) == null) {
            return;
        }
        qVar.S0();
        this.x.z1(this.j);
        if (this.x.X() != null) {
            G3(this.x.l0(), fVar.f57936d, true, list);
        }
    }

    @Override // d.a.p0.u0.e2.l
    public d.a.p0.u0.o2.h Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.X : (d.a.p0.u0.o2.h) invokeV.objValue;
    }

    public boolean Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final void Q3() {
        boolean a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || k2()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.A(this.C.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (d.a.c.e.p.k.isEmpty(privateForumPopInfoData.y()) || privateForumPopInfoData.x() != Integer.valueOf(this.p))) {
            privateForumPopInfoData.D("create_success");
            privateForumPopInfoData.B(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
            privateForumPopInfoData.E("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.p + "&fn=" + this.j + "&nomenu=1");
            privateForumPopInfoData.C(Integer.valueOf(this.p));
            a3 = frsPrivateCommonDialogView.a(privateForumPopInfoData);
        } else {
            a3 = privateForumPopInfoData.x() == Integer.valueOf(this.p) ? frsPrivateCommonDialogView.a(privateForumPopInfoData) : false;
        }
        if (a3) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new w(this, privateForumPopInfoData, aVar));
            aVar.setCloseButton(new x(this));
            aVar.create(getPageContext()).show();
        }
    }

    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f15295h : invokeV.booleanValue;
    }

    public void R3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (fRSRefreshButton = this.z) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    public final boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (i0() == null) {
                return false;
            }
            FrsViewData i02 = i0();
            d.a.o0.r.q.b0 b0Var = null;
            if (i02.getStar() != null && !StringUtils.isNull(i02.getStar().a())) {
                b0Var = new d.a.o0.r.q.b0();
            } else if (i02.getActivityHeadData() != null && ListUtils.getCount(i02.getActivityHeadData().b()) >= 1) {
                b0Var = i02.getActivityHeadData().b().get(0);
            }
            return b0Var != null;
        }
        return invokeV.booleanValue;
    }

    public void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(str);
            bdTopToast.j(this.x.l0());
        }
    }

    public boolean T2() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            FrsViewData frsViewData = this.C;
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (this.C.getForum().getYuleData() != null && this.C.getForum().getYuleData().a()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                    this.x.E1(this.C.getForum().getYuleData().b());
                    return;
                }
                this.x.r0();
                return;
            }
            this.x.r0();
        }
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (i0() == null) {
                return false;
            }
            FrsViewData i02 = i0();
            return (ListUtils.isEmpty(i02.getShowTopThreadList()) && i02.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || d.a.c.e.p.k.isEmpty(this.p)) {
            return;
        }
        d.a.o0.a.d.y().O(d.a.o0.a.c.X, d.a.c.e.m.b.f(this.p, 0L));
    }

    public void V2(Object obj) {
        d.a.p0.u0.e2.b bVar;
        d.a.c.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, obj) == null) || (bVar = this.b0) == null || (eVar = bVar.j) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void V3() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (voiceManager = this.v) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            d.a.p0.g3.c.g().h(getUniqueId(), z2);
        }
    }

    public void W3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? S2() && !U2() : invokeV.booleanValue;
    }

    public void X3(Object obj) {
        d.a.p0.u0.e2.b bVar;
        d.a.c.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, obj) == null) || (bVar = this.b0) == null || (eVar = bVar.f62630i) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void Y2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, str) == null) && TbadkCoreApplication.isLogin() && !d.a.c.e.p.k.isEmpty(str)) {
            if (this.E0 == null) {
                this.E0 = new AddExperiencedModel(m());
            }
            this.E0.A(this.p, str);
        }
    }

    public void Y3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            if (!this.mIsLogin) {
                FrsViewData frsViewData = this.C;
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    this.C.getAnti().setIfpost(1);
                }
                if (i2 == 0) {
                    ViewHelper.skipToLoginActivity(getActivity());
                }
            } else if (this.C != null) {
                if (i2 == 0) {
                    d.a.p0.u0.n2.n.b(this, 0);
                } else {
                    this.x.K1();
                }
            }
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.l == 1) {
                d.a.c.e.m.h.a().b(new l0(this));
            }
            this.l = 0;
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            n3(!isEmpty ? 1 : 0);
            M3();
            if (isEmpty) {
                return;
            }
            if (!this.W.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.W.b0() == 1 && !d.a.p0.w0.a.d()) {
                this.C.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.W != null) {
                d.a.p0.u0.j2.a.f(getUniqueId(), arrayList, this.C.getForum(), this.W.a0());
            }
            ArrayList<d.a.c.k.e.n> c3 = this.n0.c(false, false, arrayList, this.s, false);
            if (c3 != null) {
                this.C.setThreadList(c3);
                this.x.y1(c3, this.C);
            }
            FrsModelController frsModelController = this.W;
            if (frsModelController != null) {
                d.a.p0.u0.j2.c.l(this.C, frsModelController.R(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.C.getForum()));
        }
    }

    public final void a3(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.C != null && this.Y != null && this.W != null) {
                    if (!this.x.W().k(b2.m3)) {
                        this.C.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.C.getGameTabInfo());
                    this.x.l1(isEmpty);
                    if (!isEmpty) {
                        if (this.w0 == null) {
                            this.w0 = new d.a.p0.u0.o2.e(this, (NoPressedRelativeLayout) this.w);
                        }
                        if (this.y0 == null) {
                            this.y0 = new d.a.p0.u0.w1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.w0 = null;
                        this.y0 = null;
                    }
                    if (this.C.getForum() != null) {
                        this.j = this.C.getForum().getName();
                        this.p = this.C.getForum().getId();
                    }
                    if (this.C.hasTab()) {
                        this.Y.d(this.C, this.W.R());
                    }
                    if (z2) {
                        e2(true, z2);
                    } else {
                        e2(this.R, z2);
                    }
                    d3();
                    if (this.k0 != null) {
                        this.k0.a(this.X, this.C);
                    }
                    if (this.C.getPage() != null) {
                        n3(this.C.getPage().b());
                    }
                    ArrayList<d.a.c.k.e.n> d3 = this.n0.d(z3, true, this.C.getThreadList(), null, z2, false);
                    if (d3 != null) {
                        this.C.setThreadList(d3);
                    }
                    this.C.removeRedundantUserRecommendData();
                    int topThreadSize = this.C.getTopThreadSize();
                    this.q = topThreadSize;
                    if (this.s != null) {
                        this.r = true;
                        this.s.e(topThreadSize);
                        d.a.p0.u0.n2.a.a(this, this.C.getForum(), this.C.getThreadList(), this.r, D2());
                    }
                    if (this.W.b0() == 1) {
                        c3();
                        if (!z2 && this.W.getPn() == 1) {
                            h3();
                        }
                    }
                    if (this.l0 != null) {
                        this.l0.k(this.Y.E());
                    }
                    L3();
                    this.x.a1();
                    this.x.i1(true, false);
                    if (z2 && this.C.isFirstTabEqualAllThread()) {
                        d.a.c.e.m.e.a().post(new z(this));
                    }
                    if (this.C.getForum() != null) {
                        this.x.M(this.C.getForum().getWarningMsg());
                    }
                    if (this.C != null && this.C.getFrsVideoActivityData() != null && d.a.o0.r.d0.b.j().l("frs_video_activity_guide", 0L) == 0) {
                        d.a.c.e.m.e.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.x.A1();
                    if (this.C != null && this.C.getForum() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.C.getForum().getId(), this.C.getForum().getName(), this.C.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.C.getForum().special_forum_type), this.C.getForum().getThemeColorInfo(), this.C.getForum().getMember_num())));
                    }
                    this.B0.e(this.C.bottomMenuList, this.C.getForum());
                    U3();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void b3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.P = false;
            V3();
            d.a.p0.u0.q qVar = this.x;
            if (qVar != null && qVar.i0() != null) {
                this.x.i0().w();
            }
            FrsModelController frsModelController = this.W;
            if (frsModelController != null) {
                frsModelController.G0(i2, true);
            }
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            V3();
            try {
                if (this.C == null) {
                    return;
                }
                this.x.F1();
                this.x.N1(i2());
                if (d.a.p0.u0.o2.h.G(this.C)) {
                    d.a.p0.u0.o2.h.F(this.C);
                }
                if (this.C.getForum() != null) {
                    this.j = this.C.getForum().getName();
                    this.p = this.C.getForum().getId();
                }
                if (this.C.getPage() != null) {
                    n3(this.C.getPage().b());
                }
                this.x.z1(this.j);
                this.x.f1(this.j);
                TbadkCoreApplication.getInst().setDefaultBubble(this.C.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.C.getUserData().getBimg_end_time());
                Z2();
                w3();
                ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
                if (threadList != null) {
                    this.x.y1(threadList, this.C);
                    d.a.p0.u0.n2.c.b(this.x);
                    this.X.m0(w0());
                    this.X.R(this.C);
                    this.Y.d(this.C, this.W.R());
                    this.x.b1();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // d.a.p0.u0.e2.l
    public FrsModelController d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.W : (FrsModelController) invokeV.objValue;
    }

    public boolean d3() {
        InterceptResult invokeV;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            d.a.p0.u0.o2.h hVar = this.X;
            if (hVar != null && (frsModelController = this.W) != null) {
                hVar.w0(frsModelController.Z(), this.C);
            }
            FrsViewData frsViewData = this.C;
            boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
            f2();
            d.a.p0.u0.q qVar = this.x;
            if (qVar != null) {
                qVar.w0();
                this.x.x0();
                FrsViewData frsViewData2 = this.C;
                if (frsViewData2 != null && frsViewData2.getActivityHeadData() != null) {
                    this.x.v0(this.C.getActivityHeadData().a());
                    if (this.C.getActivityHeadData().a() != null && !this.W0 && !this.X0) {
                        H3();
                    }
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.e.e.b
    public void dispatchInjectPluginMessage(d.a.p0.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, dVar) == null) {
            this.r0.a(dVar);
        }
    }

    public final void e2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.W) == null || this.C == null || this.x == null || !z2) {
            return;
        }
        if (!frsModelController.u0() && this.W.b0() == 1) {
            if (!this.W.r0()) {
                this.C.addCardVideoInfoToThreadList();
                this.C.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.x.W().k(d.a.p0.a0.e0.n.k) ? this.C.addHotTopicDataToThreadList() : false)) {
                this.C.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !d.a.p0.w0.a.d()) {
                this.C.addRecommendAppToThreadList(this);
            }
            if (!this.x.W().k(b2.m3)) {
                this.C.removeAlaLiveThreadData();
            }
            this.C.addSchoolRecommendToThreadList();
        }
        if (!this.x.W().k(b2.m3)) {
            this.C.removeAlaInsertLiveData();
            this.C.removeAlaStageLiveDat();
        } else {
            this.C.addInsertLiveDataToThreadList();
            this.C.addStageLiveDataToThreadList();
        }
        this.C.checkLiveStageInThreadList();
        this.C.addNoticeThreadToThreadList();
        if (this.x.W().k(d.a.p0.x0.b.f66187i)) {
            this.C.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.W.u0() || this.W.isNetFirstLoad)) {
            this.C.addUserRecommendToThreadList();
        }
        this.C.addVideoActivityToTop();
    }

    public final void e3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            d3();
            V3();
            try {
                if (this.C == null) {
                    return;
                }
                d.a.p0.u0.y0 y0Var = null;
                this.x.y1(null, this.C);
                this.X.m0(1);
                this.x.b1();
                this.Y.d(this.C, this.W.R());
                d.a.p0.u0.k2.e H = this.Y.H(this.C.getFrsDefaultTabId());
                if (H != null && !TextUtils.isEmpty(H.f63015d)) {
                    y0Var = new d.a.p0.u0.y0();
                    String str = H.f63015d;
                    String str2 = H.f63012a;
                }
                this.W.q(this.C.getFrsDefaultTabId(), 0, y0Var);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            FrsModelController frsModelController = this.W;
            if (frsModelController != null) {
                g2(frsModelController.Z());
            } else {
                g2("normal_page");
            }
        }
    }

    public void f3() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (frsModelController = this.W) != null && frsModelController.b0() == 1) {
            this.X.X(this.C);
        }
    }

    @Override // d.a.p0.u0.d2.a, d.a.p0.u0.t0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    @Override // d.a.p0.u0.q0
    public NavigationBar g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            d.a.p0.u0.q qVar = this.x;
            if (qVar == null) {
                return null;
            }
            return qVar.e0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void g2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            q3("frs_page".equals(str));
            d.a.p0.u0.m1.e.b bVar = this.k0;
            if (bVar != null) {
                bVar.c(this.X, this.x, this.C);
            }
        }
    }

    public final void g3(d.a.p0.h3.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, mVar) == null) {
            try {
                if (!this.P && mVar != null && this.C != null) {
                    this.C.receiveData(mVar);
                    a3(true, false);
                    Looper.myQueue().addIdleHandler(this.Y0);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // d.a.p0.e.e.b
    public d.a.p0.e.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i2)) == null) ? this.i0.get(i2) : (d.a.p0.e.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.p0.u0.d2.a
    public /* bridge */ /* synthetic */ d.a.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.o z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (F2() != null && (z2 = F2().z()) != null) {
                Fragment fragment = z2.f16083b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.C;
                        tbPageTag.sortType = d.a.p0.u0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.f15292e.equals(z2.f16084c)) {
                            tbPageTag.locatePage = "a071";
                        }
                        return tbPageTag;
                    } else if (fragment instanceof FrsFragment) {
                        return null;
                    } else {
                        return ((BaseFragment) fragment).getTbPageTag();
                    }
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this.E == null) {
                this.E = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.v == null) {
                this.v = VoiceManager.instance();
            }
            return this.v;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.p0.u0.t0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.f15296i : invokeV.booleanValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            if (this.q0 == null) {
                this.q0 = new d.a.p0.u0.c2.a(this, d.a.c.e.m.b.d(this.p, 0));
            }
            this.q0.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, view) == null) {
            this.x.g1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, view) == null) {
            super.hideNetRefreshView(view);
            this.x.g1(0);
        }
    }

    @Override // d.a.p0.u0.d2.a
    public FrsViewData i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.C : (FrsViewData) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.S && !this.H0 && j2(this.i1)) {
                FrsModelController frsModelController = this.W;
                return (frsModelController != null && frsModelController.U() && (d.a.p0.u0.b.e().g() || d.a.p0.u0.a.h().j())) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i3(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048661, this, z2) == null) || (frsTabViewController = this.Y) == null) {
            return;
        }
        frsTabViewController.z = z2;
    }

    public final boolean j2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i2)) == null) ? i2 != 506 : invokeI.booleanValue;
    }

    public void j3() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.o z2;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || (frsTabViewController = this.Y) == null || (z2 = frsTabViewController.z()) == null || (fragment = z2.f16083b) == null || !(fragment instanceof d.a.p0.u0.p0)) {
            return;
        }
        ((d.a.p0.u0.p0) fragment).E0();
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            FrsViewData frsViewData = this.C;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.C.getPrivateForumTotalInfo().a() == null || this.C.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public void k3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) {
            this.f15296i = z2;
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            d.a.p0.u0.n2.m.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.k);
        }
    }

    public void l3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
            this.l = i2;
        }
    }

    @Override // d.a.p0.u0.e2.l
    public void loadMore() {
        d.a.p0.u0.e2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (cVar = this.n0) == null) {
            return;
        }
        cVar.i(this.j, this.p, this.C);
    }

    @Override // d.a.p0.w2.t
    public TbPageContext<?> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            if (!k2() && this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                o3(this.C.getPrivateForumTotalInfo().a().private_forum_audit_status, this.C.getPrivateForumTotalInfo().b(), false);
            } else {
                o3(null, null, true);
            }
        }
    }

    public void m3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            this.j = str;
        }
    }

    public final void n2(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.x.b0() == null || this.x.b0().getData() == null) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = threadList.iterator();
        List<d.a.c.k.e.n> data = this.x.b0().getData();
        int i2 = 0;
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), b2Var.c0())) {
                        it.remove();
                        data.remove(next);
                        this.n0.j(next);
                        this.x.b0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void n3(int i2) {
        d.a.p0.u0.e2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048673, this, i2) == null) || (cVar = this.n0) == null) {
            return;
        }
        cVar.m(i2);
    }

    @Override // d.a.p0.u0.n0
    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || this.x == null) {
            return;
        }
        r();
        this.x.b0().scrollToPosition(0);
        this.x.O1();
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || ListUtils.isEmpty(d.a.p0.u0.a.h().i()) || this.x.b0() == null || this.x.b0().getData() == null) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = threadList.iterator();
        List<d.a.c.k.e.n> data = this.x.b0().getData();
        int count = ListUtils.getCount(d.a.p0.u0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(d.a.p0.u0.a.h().i().get(i3).c0(), b2Var.c0())) {
                        it.remove();
                        data.remove(next);
                        this.n0.j(next);
                        this.x.b0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void o3(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048676, this, num, num2, z2) == null) || this.x.j0() == null) {
            return;
        }
        TextView j02 = this.x.j0();
        if (z2) {
            j02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            j02.setText("修改实名认证信息");
            j02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.p + "&nomenu=1";
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            j02.setText("目标已完成" + String.valueOf(num2) + "%");
            j02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.p + "&fn=" + this.j + "&nomenu=1";
            i2 = 1;
        } else {
            j02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        j02.setOnClickListener(new y(this, i2, str));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.F = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.t = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.F = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                t2(intent);
            }
            this.I = currentTimeMillis - this.F;
            this.s = new d.a.p0.h3.h0.f("frs", d.a.p0.h3.h0.f.f57973c);
            if (this.W == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.B1);
                this.W = frsModelController;
                frsModelController.t(this.g1);
                this.W.init();
            }
            this.W.P0(this.D);
            ArrayList<d.a.c.k.e.n> arrayList = null;
            if (intent != null) {
                this.W.k0(intent.getExtras());
            } else if (bundle != null) {
                this.W.k0(bundle);
            } else {
                this.W.k0(null);
            }
            if (intent != null) {
                this.X.H(intent.getExtras());
            } else if (bundle != null) {
                this.X.H(bundle);
            } else {
                this.X.H(null);
            }
            this.v = getVoiceManager();
            this.r0 = new d.a.p0.u0.p(getPageContext(), this);
            P2();
            O2(bundle);
            if (!R2()) {
                d.a.p0.u0.u0 u0Var = new d.a.p0.u0.u0(getActivity(), this.x, this.X);
                this.c0 = u0Var;
                u0Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.v = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(v2()) && !this.D0) {
                int k2 = d.a.o0.r.d0.b.j().k("key_forum_broadcast_edit_tip_number", 0);
                if (k2 < 2) {
                    d.a.o0.r.d0.b.j().v("key_forum_broadcast_edit_tip_number", k2 + 1);
                    D3();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        E3();
                    } else {
                        BdTopToast bdTopToast = new BdTopToast(getContext());
                        bdTopToast.i(false);
                        bdTopToast.h(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint));
                        bdTopToast.j(this.x.l0());
                    }
                } else {
                    E3();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(v2()) && !this.D0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        F3();
                    } else if (Build.VERSION.SDK_INT < 23 || !d.a.o0.r.d0.b.j().g("key_forum_rule_dialog_show_frs", false)) {
                        F3();
                        d.a.o0.r.d0.b.j().t("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    F3();
                }
            }
            if (d.a.o0.x.d.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.y;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new d.a.p0.u0.e2.i();
            int i2 = -1;
            d.a.p0.u0.e2.c cVar = this.n0;
            if (cVar != null && cVar.f() != null) {
                i2 = this.n0.f().A();
                arrayList = this.n0.f().z();
            }
            d.a.p0.u0.e2.c cVar2 = new d.a.p0.u0.e2.c(this, this.F1);
            this.n0 = cVar2;
            cVar2.f().L(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.n0.f().J(arrayList);
            }
            this.a0 = new d.a.p0.u0.h2.a(this);
            this.o0 = new d.a.p0.u0.o2.j(this);
            this.l0 = new d.a.p0.u0.o2.a(getPageContext(), this.W.p0());
            this.b0 = new d.a.p0.u0.e2.b(this);
            this.m0 = new d.a.p0.u0.e2.d(this);
            this.Z = new d.a.p0.u0.e2.h(this);
            this.p0 = new d.a.p0.u0.e2.a(this);
            this.s0 = new d.a.p0.u0.o2.c(this);
            new d.a.p0.u0.e2.e(this, getUniqueId());
            this.z0 = new d.a.p0.h.a(getPageContext(), "frs");
            this.A0 = new d.a.p0.v.a(getPageContext());
            new d.a.p0.u0.i2.c.a(getPageContext());
            registerListener(this.p1);
            registerListener(this.D1);
            registerListener(this.n1);
            registerListener(this.H1);
            registerListener(this.C1);
            registerListener(this.j1);
            registerListener(this.k1);
            registerListener(this.l1);
            registerListener(this.m1);
            registerListener(this.Z0);
            registerListener(this.a1);
            registerListener(this.b1);
            registerListener(this.c1);
            registerListener(this.P1);
            registerListener(this.r1);
            this.s1.setSelfListener(true);
            this.s1.setTag(getPageContext().getUniqueId());
            registerListener(this.s1);
            registerListener(this.f1);
            registerListener(this.t1);
            registerListener(this.q1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.y1);
            this.Q1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.Q1);
            registerListener(this.R1);
            registerListener(this.S1);
            registerListener(this.T1);
            registerListener(this.e1);
            registerListener(this.U1);
            registerListener(this.u1);
            registerListener(this.d1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.z1);
            registerListener(this.A1);
            this.x.t0(false);
            if (!R2() && !this.D0) {
                showLoadingView(this.x.l0(), true);
                this.W.P(3, false);
            }
            d0 d0Var = new d0(this);
            d.a.p0.u0.b.e().o(d0Var);
            d.a.p0.u0.a.h().s(d0Var);
            this.x.t1(new e0(this));
            this.J0 = UtilHelper.getScreenHeight(getActivity());
            this.D0 = true;
            p2(1);
            super.onActivityCreated(bundle);
            this.J = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048678, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            d.a.p0.u0.e2.a aVar = this.p0;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.G0) {
                this.x.K0(i2);
                this.X.K(i2);
                this.Y.S(i2);
                FRSRefreshButton fRSRefreshButton = this.z;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                d.a.p0.u0.r2.a aVar = this.v0;
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
                d.a.p0.u0.i1.a.a aVar2 = this.B0;
                if (aVar2 != null) {
                    aVar2.d(getPageContext(), i2);
                }
                if (this.C0 != null) {
                    d.a.o0.s0.a.a(getPageContext(), this.C0.getRealView());
                }
                d.a.p0.u0.o2.e eVar = this.w0;
                if (eVar != null) {
                    eVar.onChangeSkinType(getPageContext(), i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            super.onCreate(bundle);
            d.a.p0.g3.c.g().i(getUniqueId());
            registerResponsedEventListener(TopToastEvent.class, this.v1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048681, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view = this.w;
            if (view == null) {
                this.w = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
                d.a.p0.u0.m1.a aVar = new d.a.p0.u0.m1.a();
                this.f15293f = aVar;
                this.k0 = aVar.c();
                this.f15292e = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
                this.X = new d.a.p0.u0.o2.h(this, this.f15293f, (FrsHeaderViewContainer) this.w.findViewById(R.id.header_view_container));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.w);
                this.Y = frsTabViewController;
                frsTabViewController.X();
                this.X.q0(this.Y);
                this.Y.b0(this.h1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.f15295h = true;
                }
                this.x = new d.a.p0.u0.q(this, this.I1, this.f15293f, this.f15295h, this.X);
                this.B0 = new d.a.p0.u0.i1.a.a(getPageContext(), this.w);
            } else {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.w.getParent()).removeView(this.w);
                }
                FrsTabViewController frsTabViewController2 = this.Y;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.X();
                }
                this.x.U0();
                this.w.setLeft(0);
                this.w.setRight(d.a.c.e.p.l.k(TbadkCoreApplication.getInst().getContext()));
            }
            this.G0 = true;
            this.K = System.currentTimeMillis() - currentTimeMillis;
            return this.w;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            d.a.p0.g3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.s1);
            unRegisterResponsedEventListener();
            this.o0.Z();
            b2 = null;
            VoiceManager voiceManager = this.v;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.p0.w2.i0.a.c("FRS");
            this.v = null;
            d.a.p0.a0.t.b().e(false);
            FrsViewData frsViewData = this.C;
            if (frsViewData != null && frsViewData.getForum() != null) {
                d.a.p0.u0.g0.a().b(d.a.c.e.m.b.f(this.C.getForum().getId(), 0L));
            }
            d.a.p0.u0.c2.a aVar = this.q0;
            if (aVar != null) {
                aVar.v();
            }
            d.a.p0.u0.q qVar = this.x;
            if (qVar != null) {
                d.a.p0.u0.n2.l.b(qVar, this.C, h(), false, null);
                this.x.L0();
            }
            LinearLayout linearLayout = this.A;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.A.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.N0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.O0 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.O0);
            }
            this.M0 = null;
            super.onDestroy();
            try {
                if (this.Q != null) {
                    this.Q.c();
                }
                if (this.x != null) {
                    this.x.X0();
                }
                System.gc();
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            this.X.I();
            Looper.myQueue().removeIdleHandler(this.Y0);
            FrsModelController frsModelController = this.W;
            if (frsModelController != null) {
                frsModelController.h();
            }
            d.a.p0.u0.u0 u0Var = this.c0;
            if (u0Var != null) {
                u0Var.d();
            }
            d.a.p0.u0.o2.a aVar2 = this.l0;
            if (aVar2 != null) {
                aVar2.i();
            }
            d.a.p0.u0.h2.a aVar3 = this.a0;
            if (aVar3 != null) {
                aVar3.c();
            }
            d.a.p0.u0.o2.e eVar = this.w0;
            if (eVar != null) {
                eVar.g();
            }
            d.a.p0.u0.e2.a aVar4 = this.p0;
            if (aVar4 != null) {
                aVar4.n();
            }
            d.a.p0.h.a aVar5 = this.z0;
            if (aVar5 != null) {
                aVar5.h();
            }
            d.a.p0.v.a aVar6 = this.A0;
            if (aVar6 != null) {
                aVar6.g();
            }
            d.a.p0.w2.g0.a.e().g();
            d.a.p0.u0.n2.n.a();
            FrsTabViewController frsTabViewController = this.Y;
            if (frsTabViewController != null) {
                frsTabViewController.b0(null);
                this.Y.L();
            }
            AddExperiencedModel addExperiencedModel = this.E0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            d.a.p0.u0.b.e().o(null);
            d.a.p0.u0.a.h().s(null);
            d.a.p0.u0.n2.e eVar2 = this.U0;
            if (eVar2 != null) {
                eVar2.d();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            M3();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.c.k.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? B2().getPreLoadHandle() : (d.a.c.k.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048685, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (d.a.p0.u0.b.e().g()) {
                d.a.p0.u0.b.e().k();
                return true;
            } else if (d.a.p0.u0.a.h().j()) {
                d.a.p0.u0.q qVar = this.x;
                if (qVar != null && qVar.C0()) {
                    this.x.Y0();
                    return true;
                }
                d.a.p0.u0.a.h().n();
                return true;
            } else {
                d.a.p0.u0.q qVar2 = this.x;
                if (qVar2 != null) {
                    return qVar2.M0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && R2()) {
            showLoadingView(this.x.l0(), true);
            this.x.u1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.W.G0(3, true);
            B2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && d.a.c.e.p.l.D()) {
            hideNetRefreshView(this.x.X().j());
            showLoadingView(this.x.l0(), true);
            this.x.t0(false);
            this.W.G0(3, true);
        }
    }

    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, intent) == null) || intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.j = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.k = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
        this.n = booleanExtra;
        if (booleanExtra) {
            r2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            super.onPause();
            this.Z.f(false);
            this.R = false;
            this.x.N0();
            VoiceManager voiceManager = this.v;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.x.H0(true);
            d.a.p0.u0.o2.a aVar = this.l0;
            if (aVar != null) {
                aVar.j();
            }
            d.a.o0.a.d.y().E();
            d.a.p0.u0.n2.e eVar = this.U0;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                d.a.p0.u0.o2.h hVar = this.X;
                if (hVar != null) {
                    hVar.L(isPrimary());
                }
                d.a.p0.u0.q qVar = this.x;
                if (qVar != null) {
                    qVar.O0(isPrimary());
                    this.x.H0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048691, this, i2, strArr, iArr) == null) {
            d.a.p0.u0.n2.m.h(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.onResume();
            d.a.p0.u0.q qVar = this.x;
            if (qVar != null) {
                qVar.G0();
                this.x.P0();
            }
            this.Z.f(true);
            this.R = true;
            if (a2) {
                a2 = false;
                d.a.p0.u0.q qVar2 = this.x;
                if (qVar2 != null) {
                    qVar2.O1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.v;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            d.a.p0.u0.q qVar3 = this.x;
            if (qVar3 != null) {
                qVar3.H0(false);
            }
            if (this.x0) {
                b3(6);
                this.x0 = false;
            }
            if (this.I0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    d.a.o0.s.d.f.c().h(true);
                    d.a.o0.s.d.f.c().i(this.I0.getHours(), this.I0.getMinutes());
                    if (this.x != null) {
                        d.a.o0.s.d.f.c().k(m().getPageActivity(), this.x.l0());
                    }
                }
                this.I0 = null;
            }
            U3();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.j);
            bundle.putString("from", this.k);
            this.W.onSaveInstanceState(bundle);
            if (this.v == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            this.v.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.x.b0().stopScroll();
            if (this.x.Z0()) {
                return;
            }
            if (!d.a.c.e.p.l.D()) {
                this.x.s0();
            } else if (this.W.b0() == 1) {
                M3();
                loadMore();
            } else if (this.W.i0()) {
                loadMore();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048695, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        L3();
        this.x.G0();
        d.a.p0.h3.f S = this.W.S();
        boolean isEmpty = ListUtils.isEmpty(this.C.getThreadList());
        if (S != null && isEmpty) {
            if (this.W.V() != 0) {
                this.W.O0();
                this.x.G0();
            } else {
                K3(S);
            }
            this.x.i1(this.C.isStarForum(), false);
            return;
        }
        K3(S);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.v = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            super.onStop();
            d.a.p0.a0.t.b().e(false);
            W2(false);
            FrsViewData frsViewData = this.C;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                d.a.o0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.C.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.v;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (B2() != null) {
                B2().getRecycledViewPool().clear();
            }
            this.X.J();
            d.a.o0.z0.c0.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public final void p2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i2) == null) {
            FrsViewData frsViewData = this.C;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.C.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void p3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) {
            this.S = z2;
        }
    }

    @Override // d.a.p0.u0.e2.l
    public d.a.p0.u0.e2.c q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.n0 : (d.a.p0.u0.e2.c) invokeV.objValue;
    }

    public final void q2(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048702, this, j2) == null) || j2 <= 0) {
            return;
        }
        d.a.c.e.m.e.a().postDelayed(new k0(this, j2, d.a.c.e.p.l.k(TbadkCoreApplication.getInst()), d.a.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public void q3(boolean z2) {
        d.a.p0.u0.o2.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) || (jVar = this.o0) == null) {
            return;
        }
        jVar.b0();
    }

    @Override // d.a.p0.u0.n0
    public void r() {
        d.a.o0.z0.a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (a0Var = this.t0) == null) {
            return;
        }
        a0Var.c(true);
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            this.x.O1();
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) {
            this.H0 = z2;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            d.a.p0.o.d.c().f("page_frs");
            b3(3);
        }
    }

    public d.a.p0.u0.m1.e.b s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.k0 : (d.a.p0.u0.m1.e.b) invokeV.objValue;
    }

    public void s3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048709, this) == null) || this.C == null) {
            return;
        }
        d.a.p0.u0.j2.b bVar = new d.a.p0.u0.j2.b();
        if (this.C.needLog == 1) {
            bVar.f62956a = true;
        } else {
            bVar.f62956a = false;
        }
        if (this.C.getForum() != null) {
            bVar.f62958c = this.C.getForum().getId();
        }
        if (d0() != null) {
            bVar.f62957b = d0().R();
        }
        d.a.p0.u0.j2.b bVar2 = d.a.p0.u0.j2.d.h0;
        if (bVar2 != null) {
            bVar.f62959d = bVar2.f62959d;
            bVar.f62960e = bVar2.f62960e;
        }
        d.a.p0.u0.c2.b bVar3 = new d.a.p0.u0.c2.b(bVar, getTbPageTag(), getUniqueId());
        this.Q0 = bVar3;
        bVar3.d(this.S0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.Q0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.Q0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.Q0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.Q0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            this.k = str;
        }
    }

    @Override // d.a.p0.e.e.b
    public void setInjectPlugin(int i2, d.a.p0.e.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048711, this, i2, aVar) == null) {
            this.i0.put(i2, aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.Y;
            if (frsTabViewController == null || frsTabViewController.z() == null || !(this.Y.z().f16083b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.Y.z().f16083b).setPrimary(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048713, this, view, z2) == null) {
            this.x.g1(8);
            ((FrsActivity) getActivity()).showLoadingView(view, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048714, this, view, str, z2) == null) {
            super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z2, getNetRefreshListener());
            this.x.g1(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048715, this, view, str, z2) == null) {
            super.showNetRefreshViewNoClick(view, str, z2);
            this.x.g1(8);
        }
    }

    @Override // d.a.p0.u0.n0
    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048716, this) == null) && isAdded() && this.j0 && !isLoadingViewAttached()) {
            showLoadingView(this.x.l0(), true);
        }
    }

    public final void t2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048717, this, intent) == null) || intent == null) {
            return;
        }
        if (intent != null) {
            if (!d.a.p0.u0.n2.j.a(this, g(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.D = uri != null ? uri.toString() : null;
        if (uri != null) {
            this.j = uri.getQueryParameter("name");
            this.k = uri.getQueryParameter("from");
            if (!StringUtils.isNull(this.j)) {
                intent.putExtra("name", this.j);
            }
            if (!StringUtils.isNull(this.k)) {
                intent.putExtra("from", this.k);
            }
            TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
        }
        if (!StringUtils.isNull(this.j) || uri == null) {
            return;
        }
        if (d.a.o0.a.g.c(uri)) {
            d.a.o0.a.g.b().d(uri, this.E1);
        } else {
            d.a.p0.u0.n2.g b3 = d.a.p0.u0.n2.m.b(intent);
            if (b3 != null) {
                this.j = b3.f63346a;
                String str = b3.f63347b;
                if (str != null) {
                    str.equals("aidou");
                }
            }
        }
        if (!StringUtils.isNull(this.j)) {
            intent.putExtra("name", this.j);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void t3(boolean z2) {
        d.a.p0.u0.u0 u0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || (u0Var = this.c0) == null) {
            return;
        }
        u0Var.i(z2);
    }

    public ForumWriteData u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            FrsViewData frsViewData = this.C;
            if (frsViewData == null || frsViewData.getForum() == null) {
                return null;
            }
            ForumData forum = this.C.getForum();
            ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.C.getAnti());
            forumWriteData.avatar = forum.getImage_url();
            forumWriteData.forumLevel = forum.getUser_level();
            forumWriteData.specialForumType = forum.special_forum_type;
            forumWriteData.firstDir = forum.getFirst_class();
            forumWriteData.secondDir = forum.getSecond_class();
            UserData userData = this.C.getUserData();
            forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
            forumWriteData.frsTabInfo = G2();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public void u3(int i2) {
        d.a.p0.u0.e2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048720, this, i2) == null) || (cVar = this.n0) == null) {
            return;
        }
        cVar.n(i2);
    }

    public String v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void v3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048722, this, z2) == null) && this.Z1 == null) {
            d.a.p0.w0.a a3 = d.a.p0.w0.a.a(z2);
            this.Z1 = a3;
            d.a.p0.u0.e2.c cVar = this.n0;
            if (cVar != null) {
                cVar.l(a3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            FrsViewData frsViewData = this.C;
            if (frsViewData != null) {
                return d.a.o0.z0.o0.a(2) || (d.a.o0.z0.o0.d() && frsViewData.isFrsVideoAutoPlay);
            }
            return super.videoNeedPreload();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.w2.t
    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            d.a.p0.u0.e2.c cVar = this.n0;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    public d.a.c.k.e.w w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.N1 : (d.a.c.k.e.w) invokeV.objValue;
    }

    public final void w3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || (frsViewData = this.C) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.x.W().setFromCDN(true);
        } else {
            this.x.W().setFromCDN(false);
        }
    }

    @Override // d.a.p0.u0.n0
    public void x(d.a.o0.z0.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, b0Var) == null) || b0Var == null) {
            return;
        }
        this.t0 = b0Var.a();
        this.u0 = b0Var.b();
    }

    public int x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.T0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.T0;
        }
        return invokeV.intValue;
    }

    public void x3(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, ovalActionButton) == null) {
            this.y = ovalActionButton;
        }
    }

    public d.a.p0.u0.e2.d y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.m0 : (d.a.p0.u0.e2.d) invokeV.objValue;
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) {
            this.X0 = z2;
        }
    }

    public d.a.p0.u0.h2.a z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.a0 : (d.a.p0.u0.h2.a) invokeV.objValue;
    }

    public void z3(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048733, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.A = linearLayout;
    }
}
