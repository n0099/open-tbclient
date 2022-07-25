package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import androidx.annotation.Nullable;
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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.liveremind.LiveRemindModel;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
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
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
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
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsBroadcastCopyGuideDialogView;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsRedpackRunView;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
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
import com.repackage.a15;
import com.repackage.a45;
import com.repackage.ab8;
import com.repackage.ae5;
import com.repackage.ag6;
import com.repackage.ak5;
import com.repackage.aq6;
import com.repackage.b45;
import com.repackage.bp6;
import com.repackage.br6;
import com.repackage.c9;
import com.repackage.cb8;
import com.repackage.ci6;
import com.repackage.co6;
import com.repackage.cq6;
import com.repackage.cy5;
import com.repackage.d45;
import com.repackage.d9;
import com.repackage.dh8;
import com.repackage.dm6;
import com.repackage.do6;
import com.repackage.dp6;
import com.repackage.dr4;
import com.repackage.eg;
import com.repackage.em6;
import com.repackage.eo6;
import com.repackage.fi8;
import com.repackage.fj5;
import com.repackage.fo6;
import com.repackage.fp6;
import com.repackage.ge6;
import com.repackage.gm6;
import com.repackage.go6;
import com.repackage.gr6;
import com.repackage.ha5;
import com.repackage.hd6;
import com.repackage.hm6;
import com.repackage.hp6;
import com.repackage.hq6;
import com.repackage.id6;
import com.repackage.ie6;
import com.repackage.im6;
import com.repackage.ip6;
import com.repackage.je6;
import com.repackage.jj5;
import com.repackage.jm6;
import com.repackage.jo4;
import com.repackage.k95;
import com.repackage.kh8;
import com.repackage.kj5;
import com.repackage.kk6;
import com.repackage.km6;
import com.repackage.kn6;
import com.repackage.ko5;
import com.repackage.ko6;
import com.repackage.le6;
import com.repackage.li4;
import com.repackage.lm6;
import com.repackage.lo6;
import com.repackage.md6;
import com.repackage.me6;
import com.repackage.mg6;
import com.repackage.mi4;
import com.repackage.mj5;
import com.repackage.mp6;
import com.repackage.ne6;
import com.repackage.ng;
import com.repackage.ng6;
import com.repackage.ni;
import com.repackage.nj5;
import com.repackage.nm6;
import com.repackage.nn;
import com.repackage.np6;
import com.repackage.ny;
import com.repackage.oh8;
import com.repackage.oi;
import com.repackage.oj8;
import com.repackage.om6;
import com.repackage.op6;
import com.repackage.p98;
import com.repackage.pe5;
import com.repackage.pe6;
import com.repackage.pg8;
import com.repackage.pi;
import com.repackage.pm6;
import com.repackage.po4;
import com.repackage.pp6;
import com.repackage.qg;
import com.repackage.qo4;
import com.repackage.qp6;
import com.repackage.qr6;
import com.repackage.re6;
import com.repackage.ri5;
import com.repackage.rj8;
import com.repackage.rm6;
import com.repackage.rn;
import com.repackage.rq4;
import com.repackage.sc6;
import com.repackage.se5;
import com.repackage.si5;
import com.repackage.sl4;
import com.repackage.sm6;
import com.repackage.sp6;
import com.repackage.t65;
import com.repackage.tc6;
import com.repackage.tg;
import com.repackage.tg6;
import com.repackage.ti5;
import com.repackage.tp6;
import com.repackage.ty4;
import com.repackage.ve6;
import com.repackage.vg8;
import com.repackage.vm4;
import com.repackage.vp6;
import com.repackage.xc6;
import com.repackage.xn;
import com.repackage.xp6;
import com.repackage.yn6;
import com.repackage.yt4;
import com.repackage.za;
import com.repackage.zd6;
import com.repackage.zy5;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.WindowToast;
/* loaded from: classes3.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, gm6, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, me6, p98, sm6, ti5, ge6, je6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean f2;
    public static dh8 g2;
    public static volatile long h2;
    public static volatile long i2;
    public static volatile int j2;
    public static boolean k2;
    public transient /* synthetic */ FieldHolder $fh;
    public eg<TbImageView> A;
    public boolean A0;
    public t65 A1;
    public long B;
    public AddExperiencedModel B0;
    public final CustomMessageListener B1;
    public long C;
    public boolean C0;
    public CustomMessageListener C1;
    public long D;
    public boolean D0;
    public final CustomMessageListener D1;
    public long E;
    public boolean E0;
    public CustomMessageListener E1;
    public long F;
    public Date F0;
    public CustomMessageListener F1;
    public long G;
    public int G0;
    public final kh8 G1;
    public long H;
    public int H0;
    public final CustomMessageListener H1;
    public long I;
    public int I0;
    public final CustomMessageListener I1;
    public boolean J;
    public List<LiveHorseRaceData> J0;
    public final BdUniDispatchSchemeController.b J1;
    public int K;
    public ValueAnimator K0;
    public final rm6 K1;
    public boolean L;
    public Runnable L0;
    public final View.OnTouchListener L1;
    public boolean M;
    public int M0;
    public final View.OnClickListener M1;
    public boolean N;
    public em6 N0;
    public final View.OnClickListener N1;
    public k95 O;
    public ng6 O0;
    public final RecyclerView.OnScrollListener O1;
    public boolean P;
    @Nullable
    public TiePlusEventController P0;
    public final xc6 P1;
    public boolean Q;
    public int Q0;
    public final NoNetworkView.b Q1;
    public String R;
    public int R0;
    public final CustomMessageListener R1;
    public ny.a S;
    public fp6 S0;
    public xn S1;
    public ThreadCardViewHolder T;
    public ag6 T0;
    public le6 T1;
    public FrsModelController U;
    public boolean U0;
    public CustomMessageListener U1;
    public aq6 V;
    public boolean V0;
    public CustomMessageListener V1;
    public FrsTabViewController W;
    public boolean W0;
    public CustomMessageListener W1;
    public om6 X;
    public Object X0;
    public CustomMessageListener X1;
    public yn6 Y;
    public LiveRemindModel Y0;
    public CustomMessageListener Y1;
    public im6 Z;
    public boolean Z0;
    public CustomMessageListener Z1;
    public String a;
    public ne6 a0;
    public boolean a1;
    public CustomMessageListener a2;
    public tg6 b;
    public SparseArray<si5> b0;
    public boolean b1;
    public CustomMessageListener b2;
    public boolean c;
    public boolean c0;
    public int c1;
    public HttpMessageListener c2;
    public boolean d;
    public ci6 d0;
    public MessageQueue.IdleHandler d1;
    public CustomMessageListener d2;
    public boolean e;
    public tp6 e0;
    public final CustomMessageListener e1;
    public gr6 e2;
    public String f;
    public km6 f0;
    public CustomMessageListener f1;
    public String g;
    public jm6 g0;
    public CustomMessageListener g1;
    public int h;
    public cq6 h0;
    public CustomMessageListener h1;
    public boolean i;
    public hm6 i0;
    public CustomMessageListener i1;
    public boolean j;
    public dm6 j0;
    public za j1;
    public String k;
    public CustomMessageListener k1;
    public String l;
    public final le6 l1;
    public int m;
    public FrsTabViewController.o m1;
    public boolean n;
    public int n1;
    public fi8 o;
    public CustomMessageListener o1;
    public boolean p;
    public CustomMessageListener p1;
    public boolean q;
    public hd6 q0;
    public final CustomMessageListener q1;
    public VoiceManager r;
    public vp6 r0;
    public final CustomMessageListener r1;
    public View s;
    public hq6 s0;
    public final CustomMessageListener s1;
    public id6 t;
    public xp6 t0;
    public final AntiHelper.k t1;
    public OvalActionButton u;
    public boolean u0;
    public CustomMessageListener u1;
    public FRSRefreshButton v;
    public kk6 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public fj5 w0;
    public CustomMessageListener w1;
    public final ThreadData x;
    public ko5 x0;
    public CustomMessageListener x1;
    public FrsViewData y;
    public mg6 y0;
    public CustomMessageListener y1;
    public String z;
    public dr4 z0;
    public HttpMessageListener z1;

    /* loaded from: classes3.dex */
    public class a implements FrsTabViewController.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public a(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.o
        public void a(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                boolean z = false;
                if (i != 1) {
                    cy5.b().e(false);
                    this.a.Z3(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.n1 = i;
                this.a.Q0 = i2;
                if (this.a.N0 != null) {
                    this.a.N0.d(this.a.Q0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.Q0);
                this.a.c5();
                eo6 eo6Var = go6.p0;
                eo6Var.e = i;
                eo6Var.h = i2;
                eo6Var.f = -1;
                if (!this.a.C0) {
                    this.a.t.S1(this.a.b3(i));
                    return;
                }
                tc6.f().p(i == 1 && this.a.C0, true);
                sc6 h = sc6.h();
                if (i == 1 && this.a.C0) {
                    z = true;
                }
                h.p(z, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public a0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.R1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.v != null) {
                    if (booleanValue) {
                        if (this.a.W.L() == 0 || this.a.t.H0() || d45.h().k()) {
                            return;
                        }
                        this.a.v.f();
                        return;
                    }
                    this.a.v.b();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.W.l0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.y.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.a.t.X().notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveHorseRaceData a;
        public final /* synthetic */ FrsFragment b;

        public b1(FrsFragment frsFragment, LiveHorseRaceData liveHorseRaceData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, liveHorseRaceData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = "";
                if (this.b.y != null && this.b.y.getForum() != null) {
                    str = this.b.y.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.b.l).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.a.getLive_id() != null) {
                    alaInfoData.live_id = this.a.getLive_id().longValue();
                    alaInfoData.screen_direction = this.a.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.b.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.b.l)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.a.y == null) {
                return;
            }
            sp6.c(this.a.y, this.a.getPageContext());
        }
    }

    /* loaded from: classes3.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.a.y == null || (userData = this.a.y.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.a.V.R(num);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.v == null || this.a.u == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                this.a.v.setVisibility(8);
                this.a.u.setVisibility(8);
                return;
            }
            this.a.u.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.W.b(49);
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements pe6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public d0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.pe6
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.a.t == null) {
                return;
            }
            boolean z3 = false;
            if (i == 1) {
                this.a.t.w1(tc6.f().h());
                this.a.t.x1(z ? 0 : 8);
            } else if (i == 2) {
                this.a.t.t1(z ? 0 : 8);
            }
            if (!z2) {
                this.a.C0 = z;
            }
            if (this.a.t.X() != null && (i == 2 || (this.a.U != null && this.a.U.Y()))) {
                this.a.t.X().notifyDataSetChanged();
            }
            if (this.a.D3() != null) {
                FrsTabViewController.p C = this.a.D3().C();
                if (C != null) {
                    if ((C.b instanceof FrsCommonTabFragment) && (i == 2 || C.a == 502)) {
                        ((FrsCommonTabFragment) C.b).Q1();
                    } else if ((C.b instanceof FrsNewAreaFragment) && (i == 2 || C.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) C.b;
                        frsNewAreaFragment.n2();
                        if (frsNewAreaFragment.Y1() != null) {
                            nm6 Y1 = frsNewAreaFragment.Y1();
                            Y1.J(!z);
                            if (i == 1) {
                                Y1.G(!z);
                            } else if (i == 2) {
                                Y1.G(true);
                            }
                        }
                    } else {
                        Fragment fragment = C.b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).i2();
                        }
                    }
                }
                if (this.a.D3().N() != null) {
                    this.a.D3().N().setmDisallowSlip(z);
                    this.a.D3().i0(z);
                }
            }
            if (this.a.t.Z() != null) {
                id6 id6Var = this.a.t;
                if (this.a.Z2() && !z) {
                    z3 = true;
                }
                id6Var.S1(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.a.getActivity()).D0(!z);
            }
            if (this.a.y0 != null) {
                this.a.y0.f(!z);
            }
            this.a.t.C1(!z);
            if (i == 1) {
                this.a.t.s1(!z);
            } else if (i == 2) {
                this.a.t.s1(true);
            }
        }

        @Override // com.repackage.pe6
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.getContext() == null) {
                return;
            }
            if (i != 1) {
                if (i != 2 || this.a.t == null) {
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0713));
                bdTopToast.j(this.a.t.o0());
                return;
            }
            pi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f071e);
        }

        @Override // com.repackage.pe6
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.a.t == null) {
                return;
            }
            if (i2 == 1) {
                this.a.t.v1(i);
            } else if (i2 == 2) {
                this.a.t.u1(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public d1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.W.b(1);
                this.a.l3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements kj5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e0 e0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) || dr4Var == null) {
                    return;
                }
                dr4Var.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e0 e0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) || dr4Var == null) {
                    return;
                }
                dr4Var.dismiss();
            }
        }

        public e0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.kj5.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.t.T();
            this.a.t.S();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i = 0;
            if (this.a.W == null || this.a.W.C() == null || !(this.a.W.C().b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.W.C().b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(R.string.obfuscated_res_0x7f0f04a3);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.z0 = new dr4(frsFragment.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f04df, new a(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.z0 = new dr4(frsFragment2.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f0989, new b(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else {
                    this.a.t.N1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.j2(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.f3(deleteThreadHttpResponseMessage.getSuccessItems());
                tc6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (nn nnVar : this.a.y.getThreadList()) {
                    if (nnVar instanceof rq4) {
                        i++;
                        continue;
                    }
                    if (i >= 6) {
                        break;
                    }
                }
                if (i < 6) {
                    this.a.b();
                    return;
                }
                return;
            }
            pi.O(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public e1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = frsRedpackRunView;
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
                this.a.setAlpha(0.0f);
                this.a.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                this.a.c();
                this.b.w.removeView(this.a);
                if (this.b.J0 == null || this.b.I0 <= this.b.J0.size() - 1) {
                    this.b.M3();
                    return;
                }
                this.b.w.removeAllViews();
                this.b.w.setVisibility(8);
                this.b.I0 = 0;
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

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof oh8) || this.a.y == null) {
                return;
            }
            this.a.y.updateLikeData((oh8) customResponsedMessage.getData());
            this.a.V.U(this.a.y);
            this.a.W.d(this.a.y, this.a.U.V());
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ f0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0206a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0206a(a aVar, long j, int i, int i2, float f, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f = aVar;
                    this.a = j;
                    this.b = i;
                    this.c = i2;
                    this.d = f;
                    this.e = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.a, 0L, 0L, this.b, this.c, this.d, this.e);
                        requestGetMyPostNetMessage.setTag(this.f.b.a.getUniqueId());
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = f0Var;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.W.b(301);
                    qg.a().postDelayed(new RunnableC0206a(this, ng.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L), pi.k(TbadkCoreApplication.getInst()), pi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_KW) instanceof String) {
                this.a.f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_KW);
            }
            if (!(hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID) instanceof String) || TextUtils.isEmpty((String) hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID))) {
                return;
            }
            qg.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public f1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsRedpackRunView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.w == null || this.a == null) {
                return;
            }
            this.b.K0.start();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public g(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y == null) {
                return;
            }
            this.a.y.removeGameRankListFromThreadList();
            if (this.a.t != null) {
                this.a.t.I0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.y.getToLoadHorseData().intValue() == 1 && this.a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.a.l));
                this.a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.t1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().d) {
                    pi.N(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f02b6);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements rm6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public h0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.rm6
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<nn> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.a.Y == null || this.a.U == null || !this.a.U.x0() || !z || z2 || z3) {
                return;
            }
            this.a.Y.a(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.a.F0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public i0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.a0 != null && this.a.a0.e() != null) {
                    this.a.a0.e().c(motionEvent);
                }
                if (this.a.v0 != null) {
                    this.a.v0.b(view2, motionEvent);
                }
                if (this.a.V != null) {
                    this.a.V.Q(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof po4) && this.a.isResumed()) {
                po4 po4Var = (po4) customResponsedMessage.getData();
                if (this.a.O0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.O0 = new ng6(frsFragment.getPageContext());
                }
                if (this.a.y == null || this.a.y.getForum() == null || TextUtils.isEmpty(this.a.y.getForum().getId())) {
                    return;
                }
                this.a.O0.g(po4Var.a, this.a.y.getForum().getId(), this.a.y.getForum().getName(), po4Var.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.t.Q1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrsFragment f;

        public j0(FrsFragment frsFragment, long j, int i, int i2, float f, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = frsFragment;
            this.a = j;
            this.b = i;
            this.c = i2;
            this.d = f;
            this.e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.a, 0L, 0L, this.b, this.c, this.d, this.e);
                requestGetMyPostNetMessage.setTag(this.f.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (threadData = (ThreadData) customResponsedMessage.getData()) != null && this.a.isResumed()) {
                FrsFragment frsFragment = this.a;
                frsFragment.R = threadData.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", threadData.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public k(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.l4();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public k0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oj8.o(this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            public a(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.y.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.getContext(), "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg) && this.a.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount > 0) {
                    ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                    forumBroadcastHelper.jumpFlutterEditGenear(this.a.y.getForum().getId(), this.a.y.getForum().getName(), "6");
                    forumBroadcastHelper.clipCopy(this.a.R);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f06cf));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f072f));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090a89));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), this.a.l)) {
                this.a.i0.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ FrsFragment b;

        public l0(FrsFragment frsFragment, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dr4 dr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (dr4Var = this.a) == null) {
                return;
            }
            dr4Var.dismiss();
            this.b.L4();
        }
    }

    /* loaded from: classes3.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            mj5 mj5Var = (mj5) customResponsedMessage.getData();
            if (this.a.y == null || this.a.y.getForum() == null || this.a.y.getForum().getDeletedReasonInfo() == null) {
                jj5.d(0, this.a.getPageContext(), mj5Var, null, this.a.y.getUserData());
                return;
            }
            nj5 nj5Var = new nj5(this.a.y.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.y.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.y.forumRule != null ? this.a.y.forumRule.has_forum_rule.intValue() : 0);
            nj5Var.i(this.a.y.getForum().getId(), this.a.y.getForum().getName());
            nj5Var.h(this.a.y.getForum().getImage_url());
            nj5Var.j(this.a.y.getForum().getUser_level());
            jj5.d(nj5Var.f(), this.a.getPageContext(), mj5Var, nj5Var, this.a.y.getUserData());
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                this.a.K = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                this.a.L = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.a.t != null) {
                    this.a.t.a1(this.a.K, this.a.L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements vm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public m0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.vm4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d45.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0650));
                bdTopToast.j(this.a.t.o0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.v == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.C() == null || !(this.a.W.C().b instanceof BaseFragment) || !((BaseFragment) this.a.W.C().b).isPrimary() || this.a.t.H0()) {
                this.a.w.setVisibility(8);
                this.a.J = true;
                return;
            }
            this.a.w.setVisibility(0);
            this.a.J = false;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.a.getContext() == null || this.a.t == null) {
                return;
            }
            int i = 0;
            if (httpResponsedMessage.getError() == 0) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(true);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0718));
                bdTopToast.j(this.a.t.o0());
                if (sc6.h().k(sc6.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.W != null && this.a.W.C() != null && (this.a.W.C().b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.C().b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.O1();
                    }
                    this.a.g3();
                    sc6.h().d();
                    for (nn nnVar : this.a.y.getThreadList()) {
                        if (nnVar instanceof rq4) {
                            i++;
                            continue;
                        }
                        if (i >= 6) {
                            break;
                        }
                    }
                    if (i < 6) {
                        this.a.b();
                    }
                }
                sc6.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(this.a.t.o0());
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements vm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public n0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.vm4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                d45.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.u != null) {
                    this.a.u.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(FrsFragment frsFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.za
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
                if (this.a.J0 != null) {
                    if (this.a.w == null || this.a.w.getVisibility() != 8) {
                        if (this.a.I0 >= this.a.J0.size()) {
                            this.a.J0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = this.a;
                        frsFragment.J0 = frsFragment.J0.subList(0, this.a.I0);
                        this.a.J0.addAll(arrayList);
                        return;
                    }
                    this.a.J0 = new ArrayList();
                    this.a.J0.addAll(arrayList);
                    this.a.I0 = 0;
                    this.a.M3();
                    return;
                }
                this.a.J0 = new ArrayList();
                this.a.I0 = 0;
                this.a.J0.addAll(arrayList);
                this.a.M3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends t65<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment c;

        public o(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.m65
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                bdTopToast.i(topToastEvent.isSuccess());
                bdTopToast.h(topToastEvent.getContent());
                bdTopToast.j(this.c.t.o0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public o0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
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
                this.a.l3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isResumed()) {
                this.a.b5();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public p0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09061e);
                if (this.a.t != null && view2 == this.a.t.V() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090c02 && pi.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t == null || !this.a.t.D0()) {
                        String c = this.a.y.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            sl4.n(this.a.getPageContext().getPageActivity(), c);
                        }
                    } else {
                        this.a.t.I1();
                    }
                }
                if (this.a.t != null && view2 == this.a.t.e0() && this.a.U != null && this.a.U.a()) {
                    this.a.t.L1();
                    this.a.b();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.f0()) {
                    this.a.X3();
                }
                if (ni.z()) {
                    if (this.a.y == null || this.a.y.getForum() == null) {
                        return;
                    }
                    if (this.a.t != null && (view2 == this.a.t.t0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.y == null || this.a.y.getForum() == null || StringUtils.isNull(this.a.y.getForum().getId()) || StringUtils.isNull(this.a.y.getForum().getName())) {
                            return;
                        }
                        kn6.e(this.a.y.getForum().getId(), this.a.y.getForum().getName());
                        mp6.g(this.a.getPageContext(), this.a.y, this.a.y.getForum().getId(), this.a.K, this.a.L, this.a.M1);
                    }
                    if ((this.a.t == null || view2 != this.a.t.s0()) && logicField != LogicField.SEARCH_BTN) {
                        return;
                    }
                    StatisticItem param = new StatisticItem("c12402").param("fid", this.a.y.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.y.getForum().getName());
                    kn6.a(param);
                    TiebaStatic.log(param);
                    if (StringUtils.isNull(this.a.y.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.y.getForum().getName(), this.a.y.getForum().getId())));
                    return;
                }
                pi.N(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c18);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements le6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public p1(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.le6
        public void a(int i, int i2, ve6 ve6Var, ArrayList<nn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ve6Var, arrayList}) == null) {
                this.a.S4();
                if (this.a.d0 != null) {
                    this.a.V.e0(this.a.d0.e(i));
                }
                vg8 vg8Var = new vg8();
                if (ve6Var != null) {
                    boolean z = ve6Var.e == 0;
                    vg8Var.b = z;
                    vg8Var.c = ve6Var.e;
                    vg8Var.d = ve6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.v0();
                        } else if (ve6Var.g) {
                            if (ListUtils.getCount(this.a.y.getThreadList()) > 3) {
                                this.a.t.L1();
                            } else {
                                this.a.t.H1();
                            }
                        } else if (ve6Var.i) {
                            this.a.t.O1();
                        } else {
                            this.a.t.v0();
                        }
                    }
                } else {
                    ve6Var = new ve6();
                    ve6Var.c = 1;
                    ve6Var.g = false;
                    ve6Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.G1.d(frsFragment.U.getType(), false, vg8Var);
                } else {
                    this.a.R4(vg8Var);
                    if (this.a.U.h0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y = frsFragment2.U.h0();
                    }
                    this.a.i4();
                }
                if (this.a.T1 != null) {
                    this.a.T1.a(i, i2, ve6Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.t != null) {
                    this.a.t.h1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ FrsFragment c;

        public q0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.a = 0;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.c.V != null) {
                    this.c.V.p0(i);
                    if (i == 1) {
                        this.c.V.B();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.R3()) {
                    this.c.O = new k95();
                    this.c.O.a(1000);
                }
                if (i != 0) {
                    if (this.c.X0 == null) {
                        this.c.X0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    k95 k95Var = this.c.O;
                    if (k95Var != null) {
                        k95Var.d();
                    }
                } else {
                    k95 k95Var2 = this.c.O;
                    if (k95Var2 != null) {
                        k95Var2.e();
                    }
                    cy5.b().e(true);
                    this.c.Z3(true);
                    this.c.t.M0(this.a, this.b);
                    if (this.c.X0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.X0);
                        this.c.X0 = null;
                    }
                }
                if (this.c.t0 != null) {
                    this.c.t0.i(recyclerView, i);
                }
                if (i == 0) {
                    pp6.b(this.c.t, this.c.y, this.c.d(), false, null);
                }
                if (this.c.W != null && i == 1) {
                    this.c.W.P();
                }
                if (this.c.T == null) {
                    if (this.c.t.l0() != null && !this.c.t.b0() && this.c.t.l0().j() != null && (this.c.t.l0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.T = (ThreadCardViewHolder) frsFragment2.t.l0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.l0() != null && !this.c.t.b0() && this.c.t.l0().j() != null && (this.c.t.l0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.T = (ThreadCardViewHolder) frsFragment3.t.l0().j().getTag();
                }
                if (i == 1) {
                    this.c.t.L0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.c.H0 += i2;
                if (this.c.H0 >= this.c.G0 * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.c.e0 != null) {
                    this.c.e0.j();
                }
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.c.t0 != null) {
                    this.c.t0.h(recyclerView, this.a, this.b);
                }
                if (this.c.y == null || this.c.t == null || this.c.t.X() == null) {
                    return;
                }
                this.c.t.i1(this.a, this.b);
                if (this.c.T == null || this.c.T.b() == null) {
                    return;
                }
                this.c.T.b().o(this.c.S);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class q1 implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(q1 q1Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == md6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.T1();
                }
            } else if (nnVar == null || !(nnVar instanceof rq4)) {
            } else {
                ThreadData threadData = ((rq4) nnVar).s;
                if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        if (threadData.getAppCodeData() != null) {
                            if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                                String a2 = threadData.getAppCodeData().a();
                                if (StringUtils.isNull(a2) || !pi.D()) {
                                    return;
                                }
                                sl4.n(this.a.getActivity(), a2);
                            }
                        } else if (threadData.getCartoonThreadData() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                                return;
                            }
                            jo4 cartoonThreadData = threadData.getCartoonThreadData();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                        } else {
                            rj8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                                readThreadHistory.a(threadData.getId());
                            }
                            String ad_url = threadData.getAd_url();
                            if (ad_url == null || ad_url.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, ad_url)).start();
                                z = true;
                            }
                            String tid = threadData.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (threadData.getIs_top() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{tid, "", null});
                                return;
                            }
                            if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                threadData.setId(tid.substring(3));
                            }
                            if (bdUniqueId.getId() == ThreadData.TYPE_STAR_INTERVIEW.getId()) {
                                pp6.c(threadData.getTaskInfoData());
                            } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", threadData.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                            qp6.f(this.a, threadData, i, z);
                            FrsFragment frsFragment = this.a;
                            pp6.d(frsFragment, frsFragment.y, threadData);
                        }
                    }
                }
            }
        }

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }
    }

    /* loaded from: classes3.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || oi.isEmpty(str) || !str.equals(this.a.l)) {
                    return;
                }
                mp6.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.y);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.v == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.L() == 0 || this.a.W.C() == null || !(this.a.W.C().b instanceof BaseFragment) || !((BaseFragment) this.a.W.C().b).isPrimary() || this.a.t.H0() || d45.h().k()) {
                if (this.a.W.L() != 0) {
                    this.a.v.b();
                    return;
                }
                return;
            }
            this.a.v.f();
        }
    }

    /* loaded from: classes3.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.t == null) {
                return;
            }
            this.a.t.P();
        }
    }

    /* loaded from: classes3.dex */
    public class s0 implements xc6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public s0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.xc6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i != this.a.t.X().c()) {
                    if (i != this.a.t.X().j()) {
                        if (i != this.a.t.X().i() || this.a.y == null || this.a.y.getUserData() == null || !this.a.y.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.y.getBawuCenterUrl();
                        if (oi.isEmpty(bawuCenterUrl) || this.a.y.getForum() == null) {
                            return;
                        }
                        sl4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.y.getForum().getId()).param("uid", this.a.y.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.y == null || this.a.y.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.y.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), ng.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    qp6.e(this.a.getPageContext(), this.a.y);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.O4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public t0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.U.f0() == 1 && z && !this.a.t.b0()) {
                if (this.a.y != null && !ListUtils.isEmpty(this.a.y.getThreadList())) {
                    this.a.t.J0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.Y().m());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.o0(), true);
                this.a.t.w0(false);
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements kh8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsFragment b;

        public u(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = 0L;
        }

        @Override // com.repackage.kh8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.b.t.J0();
                }
            }
        }

        @Override // com.repackage.kh8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.l4();
            }
        }

        @Override // com.repackage.kh8
        public void c(dh8 dh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dh8Var) == null) {
                if ((dh8Var == null || !("normal_page".equals(this.b.U.d0()) || "frs_page".equals(this.b.U.d0()) || "book_page".equals(this.b.U.d0()))) && !"brand_page".equals(this.b.U.d0())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, dh8Var));
                this.b.m4(dh8Var);
                FrsFragment.g2 = dh8Var;
            }
        }

        @Override // com.repackage.kh8
        public void d(int i, boolean z, vg8 vg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), vg8Var}) == null) {
                if (this.b.c0) {
                    this.b.c0 = false;
                    pp6.b(this.b.t, this.b.y, this.b.d(), false, null);
                }
                this.b.S4();
                this.b.N = true;
                if (vg8Var != null && vg8Var.b) {
                    this.b.t.X().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.h2 = 0L;
                    FrsFragment.i2 = 0L;
                    FrsFragment.j2 = 0;
                } else {
                    FrsFragment.j2 = 1;
                }
                if (!this.b.U.x0() && (i == 3 || i == 6)) {
                    this.b.g0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.U.h0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.y = frsFragment.U.h0();
                }
                this.b.Q4(1);
                this.b.I4();
                if (i == 7) {
                    this.b.k4(this.b.y.getFrsDefaultTabId());
                    return;
                }
                if (this.b.y.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.t4(frsFragment2.y.getPage().b());
                }
                if (i == 4) {
                    if (!this.b.U.x0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.U.f0() == 1 && (this.b.y.adShowSelect == 1 || this.b.y.adShowSelect == 3)) {
                        this.b.y.addRecommendAppToThreadList(this.b);
                    }
                    ArrayList<nn> c = this.b.g0.c(false, false, this.b.y.getThreadList(), this.b.o, false, this.b.y.adShowSelect, this.b.y.adMixFloor);
                    if (c != null) {
                        this.b.y.setThreadList(c);
                        this.b.y.checkLiveStageInThreadList();
                    }
                    if (this.b.U != null) {
                        fo6.m(this.b.y, this.b.U.V(), 2, this.b.getContext());
                    }
                    FrsFragment frsFragment3 = this.b;
                    bp6.a(frsFragment3, frsFragment3.y.getForum(), this.b.y.getThreadList(), false, this.b.B3());
                    this.b.t.D1(c, this.b.y);
                    this.b.U4();
                    return;
                }
                this.b.U4();
                if (i == 1) {
                    this.b.t.J0();
                } else if (i == 2) {
                    this.b.t.J0();
                } else if (i == 3 || i == 6) {
                    if (this.b.y != null) {
                        this.b.y.clearPostThreadCount();
                    }
                    vp6 vp6Var = this.b.r0;
                    if (vp6Var != null) {
                        vp6Var.d();
                    }
                }
                this.b.a5();
                if (vg8Var == null || vg8Var.c == 0) {
                    if (this.b.y == null) {
                        return;
                    }
                    if (this.b.o() != null) {
                        FrsFragment frsFragment4 = this.b;
                        if (!frsFragment4.J4(frsFragment4.y, this.b.o())) {
                            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                            upgradePopWindowMessage.setFromPage("frs");
                            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                        }
                    }
                    this.b.g4(false, i == 5);
                    if (this.b.U != null) {
                        if (this.b.y.getActivityHeadData() != null && this.b.y.getActivityHeadData().b() != null && this.b.y.getActivityHeadData().b().size() > 0) {
                            do6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.e0(), 1);
                        }
                        if (this.b.y.getThreadList() != null && this.b.y.getThreadList().size() > 0) {
                            Iterator<nn> it = this.b.y.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                nn next = it.next();
                                if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                    do6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.e0(), 2);
                                    break;
                                }
                            }
                        }
                        do6.i(this.b.getUniqueId(), this.b.y.getThreadList(), this.b.y.getForum(), this.b.U.e0());
                    }
                    this.b.t.V0(i);
                    FrsFragment.h2 = (System.nanoTime() - this.a) / 1000000;
                    if (vg8Var != null) {
                        FrsFragment.i2 = vg8Var.e;
                    }
                } else if (this.b.y == null || ListUtils.isEmpty(this.b.y.getThreadList())) {
                    this.b.R4(vg8Var);
                } else if (vg8Var.a) {
                    FrsFragment frsFragment5 = this.b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, vg8Var.d, Integer.valueOf(vg8Var.c)));
                }
                this.b.e3();
                if (this.b.y.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.b.p && this.b.W.b(49)) {
                    this.b.p = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
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
                dp6.a(customResponsedMessage, this.a.t, this.a.y);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ThreadData) {
                    pp6.b(this.a.t, this.a.y, this.a.d(), true, (ThreadData) data);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public v0(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.W == null) {
                return;
            }
            FrsTabViewController.p C = this.a.W.C();
            if (C != null && (fragment = C.b) != null && (fragment instanceof ie6)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((ie6) C.b).p1();
                ((ie6) C.b).w();
                return;
            }
            this.a.l1().T1();
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ FrsFragment b;

        public w(FrsFragment frsFragment, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = frsFragment;
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.obfuscated_res_0x7f090f1c)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.obfuscated_res_0x7f091978);
                UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{privateForumPopInfoData.E()});
                FrsFragment frsFragment = this.b;
                do6.f(privateForumPopInfoData, booleanValue, frsFragment.l, frsFragment.f, true);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements le6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w0 a;

            public a(w0 w0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.E0()) {
                    this.a.a.b();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.le6
        public void a(int i, int i2, ve6 ve6Var, ArrayList<nn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ve6Var, arrayList}) == null) {
                qg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public x(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
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
            this.a.u0 = true;
        }
    }

    /* loaded from: classes3.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FrsFragment c;

        public y(FrsFragment frsFragment, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = frsFragment;
            this.a = i;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.c.l).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.a));
                if (this.b.contains("/mo/q/forumtarget")) {
                    TiebaStatic.log(new StatisticItem("c14683").param("fid", this.c.l).param("fname", this.c.f).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{this.b});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.a.T == null && this.a.t.l0() != null && !this.a.t.b0() && this.a.t.l0().j() != null && (this.a.t.l0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.T = (ThreadCardViewHolder) frsFragment.t.l0().j().getTag();
                    }
                    if (this.a.T == null || this.a.T.b() == null) {
                        return;
                    }
                    this.a.T.b().o(new ny.a(3));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public z(FrsFragment frsFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N || !ni.z() || this.a.t.G0()) {
                return;
            }
            this.a.t.X0();
        }
    }

    /* loaded from: classes3.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.t == null) {
                return;
            }
            this.a.t.U0();
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
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.d = false;
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = false;
        this.p = false;
        this.q = false;
        this.t = null;
        this.x = null;
        this.y = new FrsViewData();
        this.B = -1L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = false;
        this.N = false;
        this.O = null;
        this.P = true;
        this.Q = true;
        this.S = new ny.a(2);
        this.b0 = new SparseArray<>();
        this.c0 = true;
        this.A0 = false;
        this.C0 = false;
        this.E0 = false;
        this.F0 = null;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.M0 = -1;
        this.R0 = -1;
        this.Z0 = false;
        this.a1 = false;
        this.b1 = false;
        this.c1 = 0;
        this.d1 = new k(this);
        this.e1 = new v(this, 2016495);
        this.f1 = new g0(this, 2921005);
        this.g1 = new r0(this, 2921401);
        this.h1 = new c1(this, 2921473);
        this.i1 = new m1(this, 2921467);
        this.j1 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.k1 = new o1(this, 2001624);
        this.l1 = new p1(this);
        this.m1 = new a(this);
        this.o1 = new b(this, 2001606);
        this.p1 = new c(this, 2001607);
        this.q1 = new d(this, 2003019);
        this.r1 = new e(this, 2921470);
        this.s1 = new f(this, 2001352);
        this.t1 = new g(this);
        this.u1 = new h(this, 2001115);
        this.v1 = new i(this, 2921346);
        this.w1 = new j(this, 2001374);
        this.x1 = new l(this, 2001378);
        this.y1 = new m(this, 2001626);
        this.z1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.A1 = new o(this);
        this.B1 = new p(this, 2921391);
        this.C1 = new q(this, 2003020);
        this.D1 = new r(this, 2921463);
        this.E1 = new s(this, 2921587);
        this.F1 = new t(this, 2921588);
        this.G1 = new u(this);
        this.H1 = new b0(this, 2016485);
        this.I1 = new c0(this, 2001194);
        this.J1 = new f0(this);
        this.K1 = new h0(this);
        this.L1 = new i0(this);
        this.M1 = new o0(this);
        this.N1 = new p0(this);
        this.O1 = new q0(this);
        this.P1 = new s0(this);
        this.Q1 = new t0(this);
        this.R1 = new u0(this, 0);
        this.S1 = new q1(this, null);
        this.T1 = new w0(this);
        this.U1 = new x0(this, 2921033);
        this.V1 = new y0(this, 2921381);
        this.W1 = new z0(this, 2921414);
        this.X1 = new a1(this, 2921437);
        this.Y1 = new g1(this, 2921462);
        this.Z1 = new h1(this, 2001223);
        this.a2 = new i1(this, 2921469);
        this.b2 = new j1(this, 2921475);
        this.c2 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.d2 = new l1(this, 2921515);
    }

    public ne6 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a0 : (ne6) invokeV.objValue;
    }

    public void A4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        eo6 eo6Var = new eo6();
        if (this.y.needLog == 1) {
            eo6Var.a = true;
        } else {
            eo6Var.a = false;
        }
        if (this.y.getForum() != null) {
            eo6Var.c = this.y.getForum().getId();
            eo6Var.d = this.y.getForum().getName();
        }
        if (L0() != null) {
            eo6Var.b = L0().V();
        }
        eo6 eo6Var2 = go6.p0;
        if (eo6Var2 != null) {
            eo6Var.e = eo6Var2.e;
            eo6Var.f = eo6Var2.f;
        }
        em6 em6Var = new em6(eo6Var, getTbPageTag(), getUniqueId());
        this.N0 = em6Var;
        em6Var.d(this.Q0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.N0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.N0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.N0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.N0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public int B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jm6 jm6Var = this.g0;
            if (jm6Var == null) {
                return 1;
            }
            return jm6Var.g();
        }
        return invokeV.intValue;
    }

    public void B4(boolean z2) {
        ne6 ne6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || (ne6Var = this.a0) == null) {
            return;
        }
        ne6Var.i(z2);
    }

    public View C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void C4(int i3) {
        jm6 jm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i3) == null) || (jm6Var = this.g0) == null) {
            return;
        }
        jm6Var.o(i3);
    }

    public FrsTabViewController D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.W : (FrsTabViewController) invokeV.objValue;
    }

    public void D4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && this.e2 == null) {
            gr6 a2 = gr6.a(z2);
            this.e2 = a2;
            jm6 jm6Var = this.g0;
            if (jm6Var != null) {
                jm6Var.m(a2);
            }
        }
    }

    public final FrsTabInfoData E3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.U == null || (frsViewData = this.y) == null || this.W == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.y.getEntelechyTabInfo().a) || (G = this.W.G()) == 502) {
                return null;
            }
            int i3 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.y.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.y.getUserData() == null || this.y.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (G == frsTabInfo.tab_id.intValue()) {
                        i3 = G;
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = i3;
            if (this.y.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.y.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public final void E4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsViewData = this.y) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.X().setFromCDN(true);
        } else {
            this.t.X().setFromCDN(false);
        }
    }

    public String F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void F4(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public OvalActionButton G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u : (OvalActionButton) invokeV.objValue;
    }

    public void G4(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public FRSRefreshButton H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v : (FRSRefreshButton) invokeV.objValue;
    }

    public void H4(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public eg<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (eg) invokeV.objValue;
    }

    public int I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            jm6 jm6Var = this.g0;
            if (jm6Var == null) {
                return -1;
            }
            return jm6Var.h();
        }
        return invokeV.intValue;
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
        achievementActivityConfig.setUrl(stringExtra);
        FrsViewData frsViewData = this.y;
        if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
            achievementActivityConfig.setShareUrl(this.y.getForumActiveInfo().forum_share_url);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        pi.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public boolean J4(dh8 dh8Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, dh8Var, tbPageContext)) == null) {
            if (v3()) {
                return false;
            }
            if (dh8Var != null && dh8Var.getEntelechyTabInfo() != null && dh8Var.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : dh8Var.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && yt4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            if (dh8Var != null && dh8Var.getBusinessPromot() != null && !StringUtils.isNull(dh8Var.getBusinessPromot().p()) && dh8Var.getForum() != null) {
                boolean j3 = hp6.j(dh8Var.getBusinessPromot(), dh8Var.getForum().getId());
                this.V0 = j3;
                v4(j3);
                return this.V0;
            }
            ag6 ag6Var = new ag6(tbPageContext);
            this.T0 = ag6Var;
            boolean j4 = ag6Var.j(dh8Var);
            this.U0 = j4;
            v4(j4);
            return this.U0;
        }
        return invokeLL.booleanValue;
    }

    public void K3() {
        aq6 aq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (aq6Var = this.V) == null) {
            return;
        }
        aq6Var.C();
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            dr4 dr4Var = new dr4(getPageContext().getPageActivity());
            dr4Var.setContentViewSize(2);
            dr4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new l0(this, dr4Var));
            dr4Var.setContentView(frsBroadcastCopyGuideDialogView);
            dr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.repackage.ti5
    public void L(ri5 ri5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ri5Var) == null) {
            this.q0.a(ri5Var);
        }
    }

    @Override // com.repackage.sm6
    public FrsModelController L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.U : (FrsModelController) invokeV.objValue;
    }

    public void L3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public final void L4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            d45.h().m(new a45(getContext()));
            d45.h().n(85, 0, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (d45.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new m0(this), true);
            }
        }
    }

    public final void M3() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || !isResumed() || (list = this.J0) == null || list.size() < 1 || this.I0 > this.J0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.J0.get(this.I0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.I0++;
            M3();
        }
        if (this.w != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f09ef), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f09ef), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f09ef), getResources().getString(R.string.obfuscated_res_0x7f0f06ff));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.K0 = ofFloat;
            ofFloat.setDuration(600L);
            this.K0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.K0.addListener(new e1(this, frsRedpackRunView));
            this.L0 = new f1(this, frsRedpackRunView);
            qg.a().postDelayed(this.L0, 5000L);
            if (this.w.getChildCount() == 0) {
                this.I0++;
                this.w.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.y;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.y.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.l).param("fname", str));
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.W.C().b).isPrimary() || this.t.H0() || this.J) {
                return;
            }
            this.w.setVisibility(0);
        }
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            d45.h().m(new b45(getContext()));
            d45.h().n(85, 0, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (d45.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    @Override // com.repackage.je6
    public NavigationBar N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            id6 id6Var = this.t;
            if (id6Var == null) {
                return null;
            }
            return id6Var.h0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void N3(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            registerListener(2001118, this.R1);
            long j3 = 0;
            if (bundle != null) {
                this.f = bundle.getString("name");
                this.g = bundle.getString("from");
                this.h = bundle.getInt("flag", 0);
                j3 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                this.f = intent.getStringExtra("name");
                this.g = intent.getStringExtra("from");
                this.h = intent.getIntExtra("flag", 0);
                j3 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            }
            if (getArguments() != null) {
                this.i = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
            }
            if (this.mIsLogin) {
                registerListener(2001120, this.R1);
            }
            this.V.I(bundle);
            i3(j3);
        }
    }

    public void N4(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.W0();
            this.t.k1(8);
            if (this.s0 == null) {
                this.s0 = new hq6(getPageContext(), getNetRefreshListener());
            }
            this.s0.c(str);
            this.s0.b(list);
            this.s0.attachView(view2, z2);
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.h == 0) {
                this.t.E1(this.f);
            } else {
                this.t.E1("");
                this.h = 1;
            }
            this.t.A1(this.S1);
            this.t.K(this.O1);
            this.t.B1(this.Q1);
            this.t.X().l(this.P1);
        }
    }

    public void O4() {
        id6 id6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (id6Var = this.t) == null) {
            return;
        }
        id6Var.G1();
    }

    public boolean P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void P4(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, str, str2, str3) == null) {
            fp6 fp6Var = new fp6(str, str2);
            this.S0 = fp6Var;
            fp6Var.f(getFragmentActivity(), str3, str2);
        }
    }

    @Override // com.repackage.gm6
    public FrsViewData Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.y : (FrsViewData) invokeV.objValue;
    }

    public final boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumPopInfo() == null;
        }
        return invokeV.booleanValue;
    }

    public final void Q4(int i3) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i3) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.y) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            WindowToast windowToast = list.get(i4);
            if (windowToast != null && windowToast.toast_type.intValue() == i3) {
                if (oi.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", se5.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    @Override // com.repackage.ti5
    public si5 R0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i3)) == null) ? this.b0.get(i3) : (si5) invokeI.objValue;
    }

    public boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void R4(vg8 vg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, vg8Var) == null) {
            if (vg8Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05a6);
                this.t.W0();
                showNetRefreshView(this.t.o0(), string, true);
            } else if (340001 == vg8Var.c) {
                W4(vg8Var, this.y.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    V4(vg8Var);
                }
                if (R3()) {
                    setNetRefreshViewEmotionMarginTop(pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070292));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public void S4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            hideLoadingView(this.t.o0());
            this.t.V1();
            if (this.t.n0() instanceof ko6) {
                ((ko6) this.t.n0()).d();
            }
        }
    }

    public boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (I3() != 1 && !this.g0.b(this.y.getThreadListIds())) {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    this.t.v0();
                } else {
                    this.t.O1();
                }
            } else if (ListUtils.getCount(this.y.getThreadList()) > 3) {
                this.t.L1();
            } else {
                this.t.H1();
            }
        }
    }

    @Override // com.repackage.p98
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final boolean U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (Q0() == null) {
                return false;
            }
            FrsViewData Q0 = Q0();
            qo4 qo4Var = null;
            if (Q0.getStar() != null && !StringUtils.isNull(Q0.getStar().a())) {
                qo4Var = new qo4();
            } else if (Q0.getActivityHeadData() != null && ListUtils.getCount(Q0.getActivityHeadData().b()) >= 1) {
                qo4Var = Q0.getActivityHeadData().b().get(0);
            }
            return qo4Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (I3() == 0 && ListUtils.isEmpty(this.y.getThreadListIds())) {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    this.t.v0();
                } else {
                    this.t.O1();
                }
            } else if (ListUtils.getCount(this.y.getThreadList()) > 3) {
                this.t.L1();
            } else {
                this.t.H1();
            }
        }
    }

    public final void V2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.U) == null || this.y == null || this.t == null || !z2) {
            return;
        }
        if (!frsModelController.x0() && this.U.f0() == 1) {
            if (!this.U.u0()) {
                this.y.addCardVideoInfoToThreadList();
                this.y.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.t.X().k(zy5.g) ? this.y.addHotTopicDataToThreadList() : false)) {
                this.y.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this);
            }
            if (!this.t.X().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                this.y.removeAlaLiveThreadData();
            }
            this.y.addSchoolRecommendToThreadList();
        }
        if (!this.t.X().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
            this.y.removeAlaInsertLiveData();
            this.y.removeAlaStageLiveDat();
        } else {
            this.y.addInsertLiveDataToThreadList();
            this.y.addStageLiveDataToThreadList();
        }
        this.y.checkLiveStageInThreadList();
        this.y.addNoticeThreadToThreadList();
        if (this.t.X().k(qr6.e)) {
            this.y.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.U.x0() || this.U.isNetFirstLoad)) {
            this.y.addUserRecommendToThreadList();
        }
        this.y.addVideoActivityToTop();
    }

    public boolean V3() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void V4(vg8 vg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, vg8Var) == null) {
            this.t.W0();
            if (vg8Var.a) {
                showNetRefreshView(this.t.o0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c16, new Object[]{vg8Var.d, Integer.valueOf(vg8Var.c)}), true);
            } else {
                showNetRefreshView(this.t.Y().m(), vg8Var.d, true);
            }
        }
    }

    @Override // com.repackage.ge6
    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && isAdded() && this.c0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.o0());
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                X2(frsModelController.d0());
            } else {
                X2("normal_page");
            }
        }
    }

    public boolean W3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (Q0() == null) {
                return false;
            }
            FrsViewData Q0 = Q0();
            return (ListUtils.isEmpty(Q0.getShowTopThreadList()) && Q0.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void W4(vg8 vg8Var, List<RecmForumInfo> list) {
        id6 id6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048631, this, vg8Var, list) == null) || (id6Var = this.t) == null) {
            return;
        }
        id6Var.W0();
        this.t.E1(this.f);
        if (this.t.Y() != null) {
            N4(this.t.o0(), vg8Var.d, true, list);
        }
        this.t.g0().f(true);
    }

    public final void X2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            y4("frs_page".equals(str));
            ci6 ci6Var = this.d0;
            if (ci6Var != null) {
                ci6Var.c(this.V, this.t, this.y);
            }
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && ViewHelper.checkUpIsLogin(getContext())) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            kn6.a(param);
            kn6.b(param, d(), c());
            TiebaStatic.log(param);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.K).param("obj_type", this.K > 0 ? 1 : 2).param("obj_source", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public boolean X4(dh8 dh8Var) {
        InterceptResult invokeL;
        boolean b2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, dh8Var)) == null) {
            this.y.receiveData(dh8Var);
            if (this.y.getForum() != null) {
                this.f = this.y.getForum().getName();
                this.l = this.y.getForum().getId();
            }
            if (c3() && Q3()) {
                return false;
            }
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.F(this.y.getPrivateForumTotalInfo().c());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            PrivateForumInfo a2 = this.y.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (oi.isEmpty(privateForumPopInfoData.D()) || privateForumPopInfoData.C() != ng.e(this.l, 0))) {
                privateForumPopInfoData.I("create_success");
                privateForumPopInfoData.J(String.format("https://tieba.baidu.com/mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1", this.l, this.f));
                privateForumPopInfoData.H(ng.e(this.l, -1));
                privateForumPopInfoData.setTitle(getString(R.string.obfuscated_res_0x7f0f141c));
                privateForumPopInfoData.G(getString(R.string.obfuscated_res_0x7f0f141d));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, false);
            } else {
                b2 = privateForumPopInfoData.C() == ng.e(this.l, 0) ? frsPrivateCommonDialogView.b(privateForumPopInfoData, false) : false;
            }
            if (b2 || (privateForumPopInfoData = this.y.getPrivateForumPopInfo()) == null || privateForumPopInfoData.C() != ng.e(this.l, 0)) {
                z2 = false;
            } else {
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, true);
                z2 = true;
            }
            if (b2) {
                dr4 dr4Var = new dr4(getActivity());
                dr4Var.setContentViewSize(10);
                dr4Var.setContentView(frsPrivateCommonDialogView);
                dr4Var.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new w(this, dr4Var));
                dr4Var.setCloseButton(new x(this));
                dr4Var.create(getPageContext()).show();
                do6.f(privateForumPopInfoData, z2, this.l, this.f, false);
                v4(true);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void Y3(Object obj) {
        im6 im6Var;
        c9 c9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, obj) == null) || (im6Var = this.Z) == null || (c9Var = im6Var.j) == null) {
            return;
        }
        c9Var.c(obj);
    }

    public void Y4() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    public boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? a3(this.n1) : invokeV.booleanValue;
    }

    public void Z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z2) == null) {
            pg8.g().h(getUniqueId(), z2);
        }
    }

    public void Z4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(str);
            bdTopToast.j(this.t.o0());
        }
    }

    public boolean a3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i3)) == null) {
            if (this.Q && !this.E0 && b3(i3)) {
                FrsModelController frsModelController = this.U;
                return (frsModelController != null && frsModelController.Y() && (tc6.f().i() || sc6.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? U3() && !W3() : invokeV.booleanValue;
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (this.y.getForum().getYuleData() != null && this.y.getForum().getYuleData().a()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                    this.t.J1(this.y.getForum().getYuleData().b());
                    return;
                }
                this.t.u0();
                return;
            }
            this.t.u0();
        }
    }

    @Override // com.repackage.sm6
    public void b() {
        jm6 jm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || (jm6Var = this.g0) == null) {
            return;
        }
        jm6Var.i(this.f, this.l, this.y);
    }

    @Override // com.repackage.ge6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.sm6
    public jm6 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.g0 : (jm6) invokeV.objValue;
    }

    public final boolean b3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i3)) == null) ? i3 != 506 : invokeI.booleanValue;
    }

    public final void b4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (frsViewData = this.y) == null || frsViewData.getForum() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.y.getForum().getId(), this.y.getForum().getName(), this.y.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.y.getForum().special_forum_type), this.y.getForum().getThemeColorInfo(), this.y.getForum().getMember_num())));
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048649, this) == null) || oi.isEmpty(this.l)) {
            return;
        }
        mi4.w().O(li4.a0, ng.g(this.l, 0L));
    }

    @Override // com.repackage.gm6, com.repackage.me6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public final boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.y.getPrivateForumTotalInfo().a() == null || this.y.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public boolean c4(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048652, this, i3, keyEvent)) == null) {
            if (i3 != 4) {
                if (i3 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (tc6.f().i()) {
                tc6.f().m();
                return true;
            } else if (sc6.h().j()) {
                id6 id6Var = this.t;
                if (id6Var != null && id6Var.F0()) {
                    this.t.c1();
                    return true;
                }
                sc6.h().n();
                return true;
            } else {
                id6 id6Var2 = this.t;
                if (id6Var2 != null) {
                    return id6Var2.Q0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public void c5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (voiceManager = this.r) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // com.repackage.me6
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Override // com.repackage.p98
    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            jm6 jm6Var = this.g0;
            if (jm6Var == null) {
                return 1;
            }
            return jm6Var.g();
        }
        return invokeV.intValue;
    }

    public void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            qp6.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.g);
        }
    }

    public void d4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, intent) == null) || intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.f = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.g = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
        this.j = booleanExtra;
        if (booleanExtra) {
            l3();
        }
    }

    public void d5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            if (!c3() && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                u4(this.y.getPrivateForumTotalInfo().a().private_forum_audit_status, this.y.getPrivateForumTotalInfo().b(), false);
            } else {
                u4(null, null, true);
            }
        }
    }

    public void e4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048660, this, str) == null) && TbadkCoreApplication.isLogin() && !oi.isEmpty(str)) {
            if (this.B0 == null) {
                this.B0 = new AddExperiencedModel(o());
            }
            this.B0.E(this.l, str);
        }
    }

    public void e5(Object obj) {
        im6 im6Var;
        c9 c9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, obj) == null) || (im6Var = this.Z) == null || (c9Var = im6Var.i) == null) {
            return;
        }
        c9Var.c(obj);
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        S4();
        this.t.J0();
        vg8 W = this.U.W();
        boolean isEmpty = ListUtils.isEmpty(this.y.getThreadList());
        if (W != null && isEmpty) {
            if (this.U.Z() != 0) {
                this.U.T0();
                this.t.J0();
            } else {
                R4(W);
            }
            this.t.m1(this.y.isStarForum(), false);
            return;
        }
        R4(W);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f3(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<nn> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.t.d0() == null || this.t.d0().getData() == null) {
            return;
        }
        Iterator<nn> it = threadList.iterator();
        List<nn> data = this.t.d0().getData();
        int i3 = 0;
        while (it.hasNext()) {
            nn next = it.next();
            if (next instanceof rq4) {
                ThreadData threadData = ((rq4) next).s;
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.g0.j(next);
                        this.t.d0().getAdapter().notifyItemRemoved(i3);
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            i3++;
        }
    }

    public final void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (this.h == 1) {
                tg.a().b(new k0(this));
            }
            this.h = 0;
        }
    }

    public void f5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i3) == null) {
            if (!this.mIsLogin) {
                FrsViewData frsViewData = this.y;
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    this.y.getAnti().setIfpost(1);
                }
                if (i3 == 0) {
                    ViewHelper.skipToLoginActivity(getActivity());
                }
            } else if (this.y != null) {
                if (i3 == 0) {
                    sp6.a(this, 0);
                } else {
                    this.t.P1();
                }
            }
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || ListUtils.isEmpty(sc6.h().i()) || this.t.d0() == null || this.t.d0().getData() == null) {
            return;
        }
        ArrayList<nn> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<nn> it = threadList.iterator();
        List<nn> data = this.t.d0().getData();
        int count = ListUtils.getCount(sc6.h().i());
        int i3 = 0;
        while (it.hasNext()) {
            nn next = it.next();
            if (next instanceof rq4) {
                ThreadData threadData = ((rq4) next).s;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    } else if (StringHelper.equals(sc6.h().i().get(i4).getId(), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.g0.j(next);
                        this.t.d0().getAdapter().notifyItemRemoved(i3);
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            i3++;
        }
    }

    public final void g4(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048668, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.y != null && this.W != null && this.U != null) {
                    if (!this.t.X().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.y.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.y.getGameTabInfo());
                    this.t.p1(isEmpty);
                    if (!isEmpty) {
                        if (this.t0 == null) {
                            this.t0 = new xp6(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.v0 == null) {
                            this.v0 = new kk6(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.t0 = null;
                        this.v0 = null;
                    }
                    if (this.y.getForum() != null) {
                        this.f = this.y.getForum().getName();
                        this.l = this.y.getForum().getId();
                    }
                    if (this.y.hasTab()) {
                        this.W.d(this.y, this.U.V());
                    }
                    if (z2) {
                        V2(true, z2);
                    } else {
                        V2(this.P, z2);
                    }
                    j4();
                    if (this.d0 != null) {
                        this.d0.a(this.V, this.y);
                    }
                    if (this.y.getPage() != null) {
                        t4(this.y.getPage().b());
                    }
                    ArrayList<nn> d2 = this.g0.d(z3, true, this.y.getThreadList(), null, z2, false, this.y.adShowSelect, this.y.adMixFloor);
                    if (d2 != null) {
                        this.y.setThreadList(d2);
                    }
                    this.y.removeRedundantUserRecommendData();
                    int topThreadSize = this.y.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        bp6.a(this, this.y.getForum(), this.y.getThreadList(), this.n, B3());
                    }
                    if (this.U.f0() == 1) {
                        i4();
                        if (!z2 && this.U.getPn() == 1) {
                            n4();
                        }
                    }
                    if (this.e0 != null) {
                        this.e0.k(this.W.H());
                    }
                    S4();
                    this.t.e1();
                    this.t.m1(true, false);
                    if (z2 && this.y.isFirstTabEqualAllThread()) {
                        qg.a().post(new z(this));
                    }
                    if (this.y.getForum() != null) {
                        this.t.O(this.y.getForum().getWarningMsg());
                    }
                    if (this.y != null && this.y.getFrsVideoActivityData() != null && yt4.k().m("frs_video_activity_guide", 0L) == 0) {
                        qg.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.F1();
                    b4();
                    this.y0.e(this.y.bottomMenuList, this.y.getForum());
                    b5();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.gm6
    public /* bridge */ /* synthetic */ d9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.p C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (D3() != null && (C = D3().C()) != null) {
                Fragment fragment = C.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.y;
                        tbPageTag.sortType = op6.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.a.equals(C.c)) {
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

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void h(ArrayList<nn> arrayList) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            t4(!isEmpty ? 1 : 0);
            T4();
            if (isEmpty) {
                return;
            }
            if (!this.U.x0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.f0() == 1 && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                do6.i(getUniqueId(), arrayList, this.y.getForum(), this.U.e0());
            }
            jm6 jm6Var = this.g0;
            fi8 fi8Var = this.o;
            FrsViewData frsViewData = this.y;
            ArrayList<nn> c2 = jm6Var.c(false, false, arrayList, fi8Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.y.setThreadList(c2);
                this.t.D1(c2, this.y);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                fo6.m(this.y, frsModelController.V(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.y.getForum()));
        }
    }

    public final void h3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i3) == null) {
            FrsViewData frsViewData = this.y;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.y.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void h4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i3) == null) {
            this.N = false;
            c5();
            id6 id6Var = this.t;
            if (id6Var != null && id6Var.l0() != null) {
                this.t.l0().x();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.K0(i3, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, view2) == null) {
            this.t.k1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).E0(view2, false);
            this.t.g0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.k1(0);
            this.t.g0().f(false);
        }
    }

    public final void i3(long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048676, this, j3) == null) || j3 <= 0) {
            return;
        }
        qg.a().postDelayed(new j0(this, j3, pi.k(TbadkCoreApplication.getInst()), pi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            c5();
            try {
                if (this.y == null) {
                    return;
                }
                this.t.K1();
                this.t.S1(Z2());
                if (this.y.getForum() != null) {
                    this.f = this.y.getForum().getName();
                    this.l = this.y.getForum().getId();
                }
                if (this.y.getPage() != null) {
                    t4(this.y.getPage().b());
                }
                this.t.E1(this.f);
                this.t.j1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.y.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.y.getUserData().getBimg_end_time());
                f4();
                E4();
                ArrayList<nn> threadList = this.y.getThreadList();
                if (threadList != null) {
                    this.t.D1(threadList, this.y);
                    dp6.b(this.t);
                    this.V.o0(d1());
                    this.y.setFrsFragmentTag(getUniqueId());
                    this.V.U(this.y);
                    this.W.d(this.y, this.U.V());
                    this.t.f1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048678, this) == null) && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(p3()) && !this.A0) {
            int l2 = yt4.k().l("key_forum_broadcast_edit_tip_number", 0);
            if (l2 < 2) {
                yt4.k().w("key_forum_broadcast_edit_tip_number", l2 + 1);
                K4();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    L4();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(getContext());
                bdTopToast.i(false);
                bdTopToast.h(getContext().getString(R.string.obfuscated_res_0x7f0f0650));
                bdTopToast.j(this.t.o0());
            } else {
                L4();
            }
        }
    }

    public boolean j4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            aq6 aq6Var = this.V;
            if (aq6Var != null && (frsModelController = this.U) != null) {
                aq6Var.t0(frsModelController.d0(), this.y);
            }
            FrsViewData frsViewData2 = this.y;
            boolean hasTab = frsViewData2 != null ? frsViewData2.hasTab() : false;
            W2();
            id6 id6Var = this.t;
            if (id6Var != null) {
                id6Var.z0();
                this.t.A0();
                FrsViewData frsViewData3 = this.y;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.V0 = hp6.j(this.y.getBusinessPromot(), this.y.getForum().getId());
                }
                if (!this.V0 && (frsViewData = this.y) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.y0(this.y.getActivityHeadData().a());
                    if (this.y.getActivityHeadData().a() != null && !this.U0 && !this.V0 && !this.W0 && !v3()) {
                        O4();
                    }
                } else {
                    this.t.y0(null);
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(p3()) && !this.A0) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    M4();
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !yt4.k().h("key_forum_rule_dialog_show_frs", false)) {
                    M4();
                    yt4.k().u("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            M4();
        }
    }

    public final void k4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i3) == null) {
            j4();
            c5();
            try {
                if (this.y == null) {
                    return;
                }
                re6 re6Var = null;
                this.t.D1(null, this.y);
                this.V.o0(1);
                this.t.f1();
                this.W.d(this.y, this.U.V());
                lo6 K = this.W.K(this.y.getFrsDefaultTabId());
                if (K != null && !TextUtils.isEmpty(K.d)) {
                    re6Var = new re6();
                    String str = K.d;
                    String str2 = K.a;
                }
                this.U.u(this.y.getFrsDefaultTabId(), 0, re6Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.sm6
    public id6 l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.t : (id6) invokeV.objValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.t.T1();
        }
    }

    public void l4() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && (frsModelController = this.U) != null && frsModelController.f0() == 1) {
            this.V.Y(this.y);
        }
    }

    public ci6 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.d0 : (ci6) invokeV.objValue;
    }

    public final void m4(dh8 dh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, dh8Var) == null) {
            try {
                if (!this.N && dh8Var != null && this.y != null) {
                    this.y.receiveData(dh8Var);
                    g4(true, false);
                    Looper.myQueue().addIdleHandler(this.d1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.p98
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            L0().W0();
        }
    }

    public final void n3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, intent) == null) || intent == null) {
            return;
        }
        if (!np6.a(this, c(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
            getActivity().finish();
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.z = uri != null ? uri.toString() : null;
        if (uri != null) {
            this.f = uri.getQueryParameter("name");
            this.g = uri.getQueryParameter("from");
            if (!StringUtils.isNull(this.f)) {
                intent.putExtra("name", this.f);
            }
            if (!StringUtils.isNull(this.g)) {
                intent.putExtra("from", this.g);
            }
            TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
        }
        if (!StringUtils.isNull(this.f) || uri == null) {
            return;
        }
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.J1);
        } else {
            ip6 b2 = qp6.b(intent);
            if (b2 != null) {
                this.f = b2.a;
            }
        }
        if (!StringUtils.isNull(this.f)) {
            intent.putExtra("name", this.f);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            if (this.j0 == null) {
                this.j0 = new dm6(this, ng.e(this.l, 0));
            }
            this.j0.w();
        }
    }

    @Override // com.repackage.p98
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public ForumWriteData o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            FrsViewData frsViewData = this.y;
            if (frsViewData == null || frsViewData.getForum() == null) {
                return null;
            }
            ForumData forum = this.y.getForum();
            ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.y.getAnti());
            forumWriteData.avatar = forum.getImage_url();
            forumWriteData.forumLevel = forum.getUser_level();
            forumWriteData.specialForumType = forum.special_forum_type;
            forumWriteData.firstDir = forum.getFirst_class();
            forumWriteData.secondDir = forum.getSecond_class();
            UserData userData = this.y.getUserData();
            forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
            forumWriteData.frsTabInfo = E3();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public void o4(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) || (frsTabViewController = this.W) == null) {
            return;
        }
        frsTabViewController.v = z2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                n3(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new fi8("frs", fi8.c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.G1);
                this.U = frsModelController;
                frsModelController.x(this.l1);
                this.U.init();
            }
            this.U.U0(this.z);
            ArrayList<nn> arrayList = null;
            if (intent != null) {
                this.U.n0(intent.getExtras());
            } else if (bundle != null) {
                this.U.n0(bundle);
            } else {
                this.U.n0(null);
            }
            if (intent != null) {
                this.V.I(intent.getExtras());
            } else if (bundle != null) {
                this.V.I(bundle);
            } else {
                this.V.I(null);
            }
            this.r = u0();
            this.q0 = new hd6(getPageContext(), this);
            O3();
            N3(bundle);
            if (!R3()) {
                ne6 ne6Var = new ne6(getActivity(), this.t, this.V);
                this.a0 = ne6Var;
                ne6Var.i(true);
            }
            VoiceManager u02 = u0();
            this.r = u02;
            if (u02 != null) {
                u02.onCreate(getPageContext());
            }
            j3();
            k3();
            if (d45.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new pm6();
            int i3 = -1;
            jm6 jm6Var = this.g0;
            if (jm6Var != null && jm6Var.f() != null) {
                i3 = this.g0.f().E();
                arrayList = this.g0.f().D();
            }
            jm6 jm6Var2 = new jm6(this, this.K1);
            this.g0 = jm6Var2;
            jm6Var2.f().setHasMore(i3);
            if (arrayList != null && arrayList.size() > 0) {
                this.g0.f().O(arrayList);
            }
            this.Y = new yn6(this);
            this.h0 = new cq6(this);
            this.e0 = new tp6(getPageContext(), this.U.s0());
            this.Z = new im6(this);
            this.f0 = new km6(this);
            this.X = new om6(this);
            this.i0 = new hm6(this);
            this.r0 = new vp6(this);
            new lm6(this, getUniqueId());
            this.w0 = new fj5(getPageContext(), "frs");
            this.x0 = new ko5(getPageContext());
            new co6(getPageContext());
            registerListener(this.u1);
            registerListener(this.I1);
            registerListener(this.s1);
            registerListener(this.H1);
            registerListener(this.o1);
            registerListener(this.p1);
            registerListener(this.q1);
            registerListener(this.r1);
            registerListener(this.e1);
            registerListener(this.f1);
            registerListener(this.g1);
            registerListener(this.h1);
            registerListener(this.U1);
            registerListener(this.w1);
            this.x1.setSelfListener(true);
            this.x1.setTag(getPageContext().getUniqueId());
            registerListener(this.x1);
            registerListener(this.k1);
            registerListener(this.y1);
            registerListener(this.v1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.D1);
            this.V1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.j1);
            registerListener(this.Z1);
            registerListener(this.z1);
            registerListener(this.i1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.c2);
            registerListener(this.d2);
            registerListener(this.E1);
            registerListener(this.F1);
            this.t.w0(false);
            if (!R3() && !this.A0) {
                showLoadingView(this.t.o0(), true);
                this.U.T(3, false);
            }
            if (TbSingleton.getInstance().getIsNeedRemindLiveRoom()) {
                LiveRemindModel liveRemindModel = new LiveRemindModel(o(), getUniqueId());
                this.Y0 = liveRemindModel;
                liveRemindModel.B();
            }
            br6.a();
            d0 d0Var = new d0(this);
            tc6.f().s(d0Var);
            sc6.h().s(d0Var);
            this.t.y1(new e0(this));
            this.G0 = UtilHelper.getScreenHeight(getActivity());
            this.A0 = true;
            h3(1);
            super.onActivityCreated(bundle);
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048694, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            hm6 hm6Var = this.i0;
            if (hm6Var != null) {
                hm6Var.n(i3, i4, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i3) == null) {
            super.onChangeSkinType(i3);
            if (this.D0) {
                this.t.O0(i3);
                this.V.M(i3);
                this.W.X(i3);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i3);
                }
                hq6 hq6Var = this.s0;
                if (hq6Var != null) {
                    hq6Var.onChangeSkinType();
                }
                mg6 mg6Var = this.y0;
                if (mg6Var != null) {
                    mg6Var.d(getPageContext(), i3);
                }
                if (this.z0 != null) {
                    ha5.a(getPageContext(), this.z0.getRealView());
                }
                xp6 xp6Var = this.t0;
                if (xp6Var != null) {
                    xp6Var.onChangeSkinType(getPageContext(), i3);
                }
                ag6 ag6Var = this.T0;
                if (ag6Var != null) {
                    ag6Var.onChangeSkinType(getPageContext(), i3);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            super.onCreate(bundle);
            pg8.g().i(getUniqueId());
            if (this.P0 == null) {
                this.P0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.P0);
            registerResponsedEventListener(TopToastEvent.class, this.A1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048697, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02e9, viewGroup, false);
                tg6 tg6Var = new tg6();
                this.b = tg6Var;
                this.d0 = tg6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0744);
                this.V = new aq6(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090cf7));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.N1);
                this.W = frsTabViewController;
                frsTabViewController.c0();
                this.V.q0(this.W);
                this.W.g0(this.m1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.d = true;
                }
                this.t = new id6(this, this.N1, this.b, this.d, this.V);
                this.y0 = new mg6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.c0();
                }
                this.t.Y0();
                this.s.setLeft(0);
                this.s.setRight(pi.k(TbadkCoreApplication.getInst().getContext()));
            }
            this.D0 = true;
            this.G = System.currentTimeMillis() - currentTimeMillis;
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            pg8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.x1);
            unRegisterResponsedEventListener();
            this.h0.Z();
            g2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            cb8.c("FRS");
            this.r = null;
            cy5.b().e(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null) {
                zd6.a().b(ng.g(this.y.getForum().getId(), 0L));
            }
            dm6 dm6Var = this.j0;
            if (dm6Var != null) {
                dm6Var.v();
            }
            id6 id6Var = this.t;
            if (id6Var != null) {
                pp6.b(id6Var, this.y, d(), false, null);
                this.t.P0();
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.w.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.K0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.L0 != null) {
                qg.a().removeCallbacks(this.L0);
            }
            this.J0 = null;
            super.onDestroy();
            try {
                if (this.O != null) {
                    this.O.c();
                }
                if (this.t != null) {
                    this.t.b1();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.V.J();
            Looper.myQueue().removeIdleHandler(this.d1);
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.k();
            }
            ne6 ne6Var = this.a0;
            if (ne6Var != null) {
                ne6Var.d();
            }
            tp6 tp6Var = this.e0;
            if (tp6Var != null) {
                tp6Var.i();
            }
            yn6 yn6Var = this.Y;
            if (yn6Var != null) {
                yn6Var.c();
            }
            xp6 xp6Var = this.t0;
            if (xp6Var != null) {
                xp6Var.g();
            }
            hm6 hm6Var = this.i0;
            if (hm6Var != null) {
                hm6Var.o();
            }
            fj5 fj5Var = this.w0;
            if (fj5Var != null) {
                fj5Var.h();
            }
            ko5 ko5Var = this.x0;
            if (ko5Var != null) {
                ko5Var.g();
            }
            ab8.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.g0(null);
                this.W.P();
            }
            AddExperiencedModel addExperiencedModel = this.B0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            tc6.f().s(null);
            sc6.h().s(null);
            fp6 fp6Var = this.S0;
            if (fp6Var != null) {
                fp6Var.d();
            }
            if (this.P0 != null) {
                getLifecycle().removeObserver(this.P0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            T4();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? z3().getPreLoadHandle() : (rn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && R3()) {
            showLoadingView(this.t.o0(), true);
            this.t.z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.K0(3, true);
            z3().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && pi.D()) {
            hideNetRefreshView(this.t.Y().m());
            showLoadingView(this.t.o0(), true);
            this.t.w0(false);
            this.U.K0(3, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            super.onPause();
            this.X.f(false);
            this.P = false;
            this.t.R0();
            aq6 aq6Var = this.V;
            if (aq6Var != null) {
                aq6Var.N();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.K0(true);
            tp6 tp6Var = this.e0;
            if (tp6Var != null) {
                tp6Var.j();
            }
            mi4.w().E();
            fp6 fp6Var = this.S0;
            if (fp6Var != null) {
                fp6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                aq6 aq6Var = this.V;
                if (aq6Var != null) {
                    aq6Var.O(isPrimary());
                }
                id6 id6Var = this.t;
                if (id6Var != null) {
                    id6Var.S0(isPrimary());
                    this.t.K0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048705, this, i3, strArr, iArr) == null) {
            qp6.i(this, i3, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.onResume();
            int i3 = this.c1;
            if (i3 <= 1) {
                this.c1 = i3 + 1;
            }
            id6 id6Var = this.t;
            if (id6Var != null) {
                id6Var.J0();
                this.t.T0();
            }
            aq6 aq6Var = this.V;
            if (aq6Var != null) {
                aq6Var.P();
            }
            if (this.c1 > 1 && w3()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                w4(false);
            }
            this.X.f(true);
            this.P = true;
            if (f2) {
                f2 = false;
                id6 id6Var2 = this.t;
                if (id6Var2 != null) {
                    id6Var2.T1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            id6 id6Var3 = this.t;
            if (id6Var3 != null) {
                id6Var3.K0(false);
            }
            if (this.u0) {
                h4(6);
                this.u0 = false;
            }
            if (this.F0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    ty4.c().h(true);
                    ty4.c().i(this.F0.getHours(), this.F0.getMinutes());
                    if (this.t != null) {
                        ty4.c().k(o().getPageActivity(), this.t.o0());
                    }
                }
                this.F0 = null;
            }
            b5();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.U.I0(bundle);
            if (this.r == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            this.r.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            this.t.d0().stopScroll();
            if (this.t.d1()) {
                return;
            }
            if (!pi.D()) {
                this.t.v0();
            } else if (this.U.f0() == 1) {
                T4();
                b();
            } else if (this.U.a()) {
                b();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            super.onStart();
            VoiceManager u02 = u0();
            this.r = u02;
            if (u02 != null) {
                u02.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onStop();
            cy5.b().e(false);
            Z3(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                a15.j().x(getPageContext().getPageActivity(), "frs", this.y.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (z3() != null) {
                z3().getRecycledViewPool().clear();
            }
            this.V.L();
            ae5.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    @Override // com.repackage.sm6
    public aq6 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.V : (aq6) invokeV.objValue;
    }

    public String p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public void p4() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.p C;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048714, this) == null) || (frsTabViewController = this.W) == null || (C = frsTabViewController.C()) == null || (fragment = C.b) == null || !(fragment instanceof ie6)) {
            return;
        }
        ((ie6) fragment).p1();
    }

    @Override // com.repackage.ti5
    public void q0(int i3, si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048715, this, i3, si5Var) == null) {
            this.b0.put(i3, si5Var);
        }
    }

    public xn q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.S1 : (xn) invokeV.objValue;
    }

    public void q4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048717, this, z2) == null) {
            this.e = z2;
        }
    }

    public int r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.R0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.R0;
        }
        return invokeV.intValue;
    }

    public void r4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i3) == null) {
            this.h = i3;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            ak5.c().f("page_frs");
            h4(3);
        }
    }

    public int s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? qp6.c(this.y, this.t) : invokeV.intValue;
    }

    public void s4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, str) == null) {
            this.f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            this.g = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController == null || frsTabViewController.C() == null || !(this.W.C().b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.W.C().b).setPrimary(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048725, this, view2, z2) == null) {
            this.t.k1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).E0(view2, true);
            this.t.g0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048726, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.obfuscated_res_0x7f0f0f84), null, getResources().getString(R.string.obfuscated_res_0x7f0f0f83), z2, getNetRefreshListener());
            this.t.k1(8);
            this.t.g0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048727, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.k1(8);
        }
    }

    @Override // com.repackage.ge6
    public void t() {
        id6 id6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (id6Var = this.t) == null) {
            return;
        }
        id6Var.d0().scrollToPosition(0);
        this.t.T1();
    }

    public km6 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.f0 : (km6) invokeV.objValue;
    }

    public void t4(int i3) {
        jm6 jm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048730, this, i3) == null) || (jm6Var = this.g0) == null) {
            return;
        }
        jm6Var.n(i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public yn6 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.Y : (yn6) invokeV.objValue;
    }

    @SuppressLint({"StringFormatInvalid"})
    public void u4(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048734, this, num, num2, z2) == null) || this.t.m0() == null) {
            return;
        }
        TextView m02 = this.t.m0();
        if (z2) {
            m02.setVisibility(8);
            return;
        }
        int i3 = 2;
        if (num.intValue() == 2) {
            m02.setText(getString(R.string.obfuscated_res_0x7f0f027b));
            m02.setVisibility(0);
            str = String.format("https://tieba.baidu.com/mo/q/priforum/editinfo?fid=%1$s&nomenu=1", this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            m02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f03b1), num2));
            m02.setVisibility(0);
            str = String.format("https://tieba.baidu.com/mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1", this.l, this.f);
            i3 = 1;
        } else {
            m02.setVisibility(8);
            str = "";
            i3 = 0;
        }
        m02.setOnClickListener(new y(this, i3, str));
    }

    public boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public void v4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.Z0 = z2;
            this.a1 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? pe5.a(2) : invokeV.booleanValue;
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public void w4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z2) == null) {
            this.b1 = z2;
        }
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.t.b0() : invokeV.booleanValue;
    }

    public void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
            this.Q = z2;
        }
    }

    @Override // com.repackage.ge6
    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && isAdded() && this.c0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.o0(), true);
        }
    }

    public boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this.a1 : invokeV.booleanValue;
    }

    public void y4(boolean z2) {
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) || (cq6Var = this.h0) == null) {
            return;
        }
        cq6Var.b0();
    }

    public BdTypeRecyclerView z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            id6 id6Var = this.t;
            if (id6Var == null) {
                return null;
            }
            return id6Var.d0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void z4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) {
            this.E0 = z2;
        }
    }
}
