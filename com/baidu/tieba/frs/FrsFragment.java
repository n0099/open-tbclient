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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.repackage.a9;
import com.repackage.a95;
import com.repackage.ae6;
import com.repackage.ai8;
import com.repackage.am6;
import com.repackage.ap4;
import com.repackage.aq6;
import com.repackage.b9;
import com.repackage.bg;
import com.repackage.bm6;
import com.repackage.bo6;
import com.repackage.bp;
import com.repackage.bp4;
import com.repackage.br4;
import com.repackage.ce6;
import com.repackage.cl8;
import com.repackage.cm6;
import com.repackage.de5;
import com.repackage.dm6;
import com.repackage.dq6;
import com.repackage.ee6;
import com.repackage.em6;
import com.repackage.ep6;
import com.repackage.f65;
import com.repackage.fc6;
import com.repackage.fg6;
import com.repackage.fm4;
import com.repackage.fm6;
import com.repackage.fn6;
import com.repackage.fo6;
import com.repackage.fq6;
import com.repackage.ga8;
import com.repackage.gc6;
import com.repackage.ge5;
import com.repackage.gg6;
import com.repackage.gi8;
import com.repackage.gj5;
import com.repackage.gn4;
import com.repackage.go6;
import com.repackage.gp6;
import com.repackage.gr6;
import com.repackage.he6;
import com.repackage.hk6;
import com.repackage.hm6;
import com.repackage.ho6;
import com.repackage.im6;
import com.repackage.io6;
import com.repackage.ip6;
import com.repackage.iu4;
import com.repackage.jm6;
import com.repackage.jo6;
import com.repackage.kc6;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.kp6;
import com.repackage.ky5;
import com.repackage.lh8;
import com.repackage.li;
import com.repackage.li5;
import com.repackage.lm6;
import com.repackage.lp6;
import com.repackage.lr6;
import com.repackage.m05;
import com.repackage.m35;
import com.repackage.md6;
import com.repackage.mf6;
import com.repackage.mi;
import com.repackage.mm6;
import com.repackage.mq6;
import com.repackage.n35;
import com.repackage.ng;
import com.repackage.no6;
import com.repackage.nr4;
import com.repackage.nx5;
import com.repackage.oh6;
import com.repackage.oi8;
import com.repackage.oo6;
import com.repackage.oy4;
import com.repackage.p35;
import com.repackage.pd5;
import com.repackage.pi5;
import com.repackage.pp6;
import com.repackage.qg;
import com.repackage.qi5;
import com.repackage.qj8;
import com.repackage.qp6;
import com.repackage.rb8;
import com.repackage.rn5;
import com.repackage.ro;
import com.repackage.rp6;
import com.repackage.si5;
import com.repackage.sp6;
import com.repackage.tb8;
import com.repackage.td6;
import com.repackage.ti5;
import com.repackage.tp6;
import com.repackage.tr6;
import com.repackage.uc6;
import com.repackage.uo4;
import com.repackage.vc6;
import com.repackage.vd6;
import com.repackage.vi8;
import com.repackage.vo;
import com.repackage.vp6;
import com.repackage.vz;
import com.repackage.w95;
import com.repackage.wa;
import com.repackage.wd6;
import com.repackage.wp6;
import com.repackage.xh5;
import com.repackage.xl6;
import com.repackage.yd6;
import com.repackage.yf6;
import com.repackage.yh5;
import com.repackage.yi4;
import com.repackage.yl6;
import com.repackage.yp6;
import com.repackage.zc6;
import com.repackage.zd6;
import com.repackage.zf6;
import com.repackage.zh5;
import com.repackage.zi4;
import com.repackage.zi8;
import com.repackage.zk8;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes3.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, am6, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, zd6, ga8, mm6, zh5, td6, wd6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d2;
    public static oi8 e2;
    public static volatile long f2;
    public static volatile long g2;
    public static volatile int h2;
    public static boolean i2;
    public transient /* synthetic */ FieldHolder $fh;
    public bg<TbImageView> A;
    public boolean A0;
    public CustomMessageListener A1;
    public long B;
    public AddExperiencedModel B0;
    public final CustomMessageListener B1;
    public long C;
    public boolean C0;
    public CustomMessageListener C1;
    public long D;
    public boolean D0;
    public CustomMessageListener D1;
    public long E;
    public boolean E0;
    public final vi8 E1;
    public long F;
    public Date F0;
    public final CustomMessageListener F1;
    public long G;
    public int G0;
    public final CustomMessageListener G1;
    public long H;
    public int H0;
    public final BdUniDispatchSchemeController.b H1;
    public long I;
    public int I0;
    public final lm6 I1;
    public boolean J;
    public List<LiveHorseRaceData> J0;
    public final View.OnTouchListener J1;
    public int K;
    public ValueAnimator K0;
    public final View.OnClickListener K1;
    public boolean L;
    public Runnable L0;
    public final View.OnClickListener L1;
    public boolean M;
    public int M0;
    public final RecyclerView.OnScrollListener M1;
    public boolean N;
    public yl6 N0;
    public final kc6 N1;
    public a95 O;
    public zf6 O0;
    public final NoNetworkView.b O1;
    public boolean P;
    @Nullable
    public TiePlusEventController P0;
    public final CustomMessageListener P1;
    public boolean Q;
    public int Q0;
    public bp Q1;
    public String R;
    public int R0;
    public yd6 R1;
    public vz.a S;
    public ip6 S0;
    public CustomMessageListener S1;
    public ThreadCardViewHolder T;
    public mf6 T0;
    public CustomMessageListener T1;
    public FrsModelController U;
    public boolean U0;
    public CustomMessageListener U1;
    public dq6 V;
    public boolean V0;
    public CustomMessageListener V1;
    public FrsTabViewController W;
    public boolean W0;
    public CustomMessageListener W1;
    public im6 X;
    public Object X0;
    public CustomMessageListener X1;
    public bo6 Y;
    public boolean Y0;
    public CustomMessageListener Y1;
    public cm6 Z;
    public boolean Z0;
    public CustomMessageListener Z1;
    public String a;
    public boolean a1;
    public HttpMessageListener a2;
    public fg6 b;
    public MessageQueue.IdleHandler b1;
    public CustomMessageListener b2;
    public boolean c;
    public final CustomMessageListener c1;
    public lr6 c2;
    public boolean d;
    public CustomMessageListener d1;
    public boolean e;
    public CustomMessageListener e1;
    public String f;
    public CustomMessageListener f1;
    public String g;
    public ae6 g0;
    public CustomMessageListener g1;
    public int h;
    public SparseArray<yh5> h0;
    public wa h1;
    public boolean i;
    public boolean i0;
    public CustomMessageListener i1;
    public boolean j;
    public oh6 j0;
    public final yd6 j1;
    public String k;
    public wp6 k0;
    public FrsTabViewController.n k1;
    public String l;
    public em6 l0;
    public int l1;
    public int m;
    public dm6 m0;
    public CustomMessageListener m1;
    public boolean n;
    public fq6 n0;
    public CustomMessageListener n1;
    public qj8 o;
    public bm6 o0;
    public final CustomMessageListener o1;
    public boolean p;
    public xl6 p0;
    public final CustomMessageListener p1;
    public boolean q;
    public uc6 q0;
    public final CustomMessageListener q1;
    public VoiceManager r;
    public yp6 r0;
    public final AntiHelper.k r1;
    public View s;
    public mq6 s0;
    public CustomMessageListener s1;
    public vc6 t;
    public aq6 t0;
    public CustomMessageListener t1;
    public OvalActionButton u;
    public boolean u0;
    public CustomMessageListener u1;
    public FRSRefreshButton v;
    public hk6 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public li5 w0;
    public CustomMessageListener w1;
    public final ThreadData x;
    public rn5 x0;
    public HttpMessageListener x1;
    public FrsViewData y;
    public yf6 y0;
    public f65 y1;
    public String z;
    public nr4 z0;
    public final CustomMessageListener z1;

    /* loaded from: classes3.dex */
    public class a implements FrsTabViewController.n {
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

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                boolean z = false;
                if (i != 1) {
                    nx5.b().e(false);
                    this.a.g3(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.l1 = i;
                this.a.Q0 = i2;
                if (this.a.N0 != null) {
                    this.a.N0.d(this.a.Q0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.Q0);
                this.a.j4();
                ho6 ho6Var = jo6.f0;
                ho6Var.e = i;
                ho6Var.h = i2;
                ho6Var.f = -1;
                if (!this.a.C0) {
                    this.a.t.S1(this.a.l2(i));
                    return;
                }
                gc6.f().p(i == 1 && this.a.C0, true);
                fc6 h = fc6.h();
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
                        if (this.a.W.J() == 0 || this.a.t.H0() || p35.h().k()) {
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
            this.a.W.i0(((Integer) customResponsedMessage.getData()).intValue());
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
            this.a.t.W().notifyDataSetChanged();
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
            vp6.c(this.a.y, this.a.getPageContext());
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
                this.a.V.S(num);
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
    public class d0 implements ce6 {
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

        @Override // com.repackage.ce6
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.a.t == null) {
                return;
            }
            boolean z3 = false;
            if (i == 1) {
                this.a.t.w1(gc6.f().h());
                this.a.t.x1(z ? 0 : 8);
            } else if (i == 2) {
                this.a.t.t1(z ? 0 : 8);
            }
            if (!z2) {
                this.a.C0 = z;
            }
            if (this.a.t.W() != null && (i == 2 || (this.a.U != null && this.a.U.W()))) {
                this.a.t.W().notifyDataSetChanged();
            }
            if (this.a.L2() != null) {
                FrsTabViewController.o A = this.a.L2().A();
                if (A != null) {
                    if ((A.b instanceof FrsCommonTabFragment) && (i == 2 || A.a == 502)) {
                        ((FrsCommonTabFragment) A.b).Z0();
                    } else if ((A.b instanceof FrsNewAreaFragment) && (i == 2 || A.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) A.b;
                        frsNewAreaFragment.w1();
                        if (frsNewAreaFragment.h1() != null) {
                            hm6 h1 = frsNewAreaFragment.h1();
                            h1.G(!z);
                            if (i == 1) {
                                h1.D(!z);
                            } else if (i == 2) {
                                h1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = A.b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).r1();
                        }
                    }
                }
                if (this.a.L2().K() != null) {
                    this.a.L2().K().setmDisallowSlip(z);
                    this.a.L2().f0(z);
                }
            }
            if (this.a.t.Y() != null) {
                vc6 vc6Var = this.a.t;
                if (this.a.j2() && !z) {
                    z3 = true;
                }
                vc6Var.S1(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.a.getActivity()).showTabHost(!z);
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

        @Override // com.repackage.ce6
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0711));
                bdTopToast.j(this.a.t.n0());
                return;
            }
            mi.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f071c);
        }

        @Override // com.repackage.ce6
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
                this.a.t2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements qi5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || nr4Var == null) {
                    return;
                }
                nr4Var.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || nr4Var == null) {
                    return;
                }
                nr4Var.dismiss();
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

        @Override // com.repackage.qi5.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.t.S();
            this.a.t.R();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i = 0;
            if (this.a.W == null || this.a.W.A() == null || !(this.a.W.A().b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.W.A().b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(R.string.obfuscated_res_0x7f0f04a2);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.z0 = new nr4(frsFragment.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new a(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.z0 = new nr4(frsFragment2.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f0988, new b(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else {
                    this.a.t.N1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.s1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.p2(deleteThreadHttpResponseMessage.getSuccessItems());
                gc6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (ro roVar : this.a.y.getThreadList()) {
                    if (roVar instanceof br4) {
                        i++;
                        continue;
                    }
                    if (i >= 6) {
                        break;
                    }
                }
                if (i < 6) {
                    this.a.loadMore();
                    return;
                }
                return;
            }
            mi.N(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
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
                    this.b.U2();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zi8) || this.a.y == null) {
                return;
            }
            this.a.y.updateLikeData((zi8) customResponsedMessage.getData());
            this.a.V.V(this.a.y);
            this.a.W.d(this.a.y, this.a.U.T());
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
            public class RunnableC0186a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0186a(a aVar, long j, int i, int i2, float f, int i3) {
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
                    ng.a().postDelayed(new RunnableC0186a(this, kg.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L), mi.k(TbadkCoreApplication.getInst()), mi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
            ng.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
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
        public void onNavigationButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nr4Var) == null) {
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
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.r1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().d) {
                    mi.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f02b1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements lm6 {
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

        @Override // com.repackage.lm6
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<ro> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.a.Y == null || this.a.U == null || !this.a.U.v0() || !z || z2 || z3) {
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
                if (this.a.g0 != null && this.a.g0.e() != null) {
                    this.a.g0.e().c(motionEvent);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ap4) && this.a.isResumed()) {
                ap4 ap4Var = (ap4) customResponsedMessage.getData();
                if (this.a.O0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.O0 = new zf6(frsFragment.getPageContext());
                }
                if (this.a.y == null || this.a.y.getForum() == null || TextUtils.isEmpty(this.a.y.getForum().getId())) {
                    return;
                }
                this.a.O0.g(ap4Var.a, this.a.y.getForum().getId(), this.a.y.getForum().getName(), ap4Var.b);
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
                this.a.s3();
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
                zk8.o(this.a.f);
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
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f06cd));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f072e));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090aac));
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
                this.a.o0.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ FrsFragment b;

        public l0(FrsFragment frsFragment, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, nr4Var};
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
            this.a = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nr4 nr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (nr4Var = this.a) == null) {
                return;
            }
            nr4Var.dismiss();
            this.b.S3();
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
            si5 si5Var = (si5) customResponsedMessage.getData();
            if (this.a.y == null || this.a.y.getForum() == null || this.a.y.getForum().getDeletedReasonInfo() == null) {
                pi5.d(0, this.a.getPageContext(), si5Var, null, this.a.y.getUserData());
                return;
            }
            ti5 ti5Var = new ti5(this.a.y.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.y.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.y.forumRule != null ? this.a.y.forumRule.has_forum_rule.intValue() : 0);
            ti5Var.i(this.a.y.getForum().getId(), this.a.y.getForum().getName());
            ti5Var.h(this.a.y.getForum().getImage_url());
            ti5Var.j(this.a.y.getForum().getUser_level());
            pi5.d(ti5Var.f(), this.a.getPageContext(), si5Var, ti5Var, this.a.y.getUserData());
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
    public class m0 implements gn4 {
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

        @Override // com.repackage.gn4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    p35.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f064f));
                bdTopToast.j(this.a.t.n0());
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
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.A() == null || !(this.a.W.A().b instanceof BaseFragment) || !((BaseFragment) this.a.W.A().b).isPrimary() || this.a.t.H0()) {
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0716));
                bdTopToast.j(this.a.t.n0());
                if (fc6.h().k(fc6.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.W != null && this.a.W.A() != null && (this.a.W.A().b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.A().b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.X0();
                    }
                    this.a.q2();
                    fc6.h().d();
                    for (ro roVar : this.a.y.getThreadList()) {
                        if (roVar instanceof br4) {
                            i++;
                            continue;
                        }
                        if (i >= 6) {
                            break;
                        }
                    }
                    if (i < 6) {
                        this.a.loadMore();
                    }
                }
                fc6.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(this.a.t.n0());
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements gn4 {
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

        @Override // com.repackage.gn4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                p35.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.u != null) {
                    this.a.u.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 extends wa {
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

        @Override // com.repackage.wa
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
                    this.a.U2();
                    return;
                }
                this.a.J0 = new ArrayList();
                this.a.I0 = 0;
                this.a.J0.addAll(arrayList);
                this.a.U2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends f65<TopToastEvent> {
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
        @Override // com.repackage.y55
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                bdTopToast.i(topToastEvent.isSuccess());
                bdTopToast.h(topToastEvent.getContent());
                bdTopToast.j(this.c.t.n0());
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
                this.a.e3();
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
                this.a.t2();
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
                this.a.i4();
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
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09065b);
                if (this.a.t != null && view2 == this.a.t.U() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090c2d && mi.C()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t == null || !this.a.t.D0()) {
                        String c = this.a.y.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            fm4.l(this.a.getPageContext().getPageActivity(), c);
                        }
                    } else {
                        this.a.t.I1();
                    }
                }
                if (this.a.t != null && view2 == this.a.t.d0() && this.a.U != null && this.a.U.hasMore()) {
                    this.a.t.L1();
                    this.a.loadMore();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.e0()) {
                    this.a.e3();
                }
                if (ki.z()) {
                    if (this.a.y == null || this.a.y.getForum() == null) {
                        return;
                    }
                    if (this.a.t != null && (view2 == this.a.t.t0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.y == null || this.a.y.getForum() == null || StringUtils.isNull(this.a.y.getForum().getId()) || StringUtils.isNull(this.a.y.getForum().getName())) {
                            return;
                        }
                        fn6.e(this.a.y.getForum().getId(), this.a.y.getForum().getName());
                        pp6.g(this.a.getPageContext(), this.a.y, this.a.y.getForum().getId(), this.a.K, this.a.L, this.a.K1);
                    }
                    if ((this.a.t == null || view2 != this.a.t.s0()) && logicField != LogicField.SEARCH_BTN) {
                        return;
                    }
                    StatisticItem param = new StatisticItem("c12402").param("fid", this.a.y.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.y.getForum().getName());
                    fn6.a(param);
                    TiebaStatic.log(param);
                    if (StringUtils.isNull(this.a.y.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.y.getForum().getName(), this.a.y.getForum().getId())));
                    return;
                }
                mi.M(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c2e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements yd6 {
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

        @Override // com.repackage.yd6
        public void a(int i, int i2, he6 he6Var, ArrayList<ro> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), he6Var, arrayList}) == null) {
                this.a.Z3();
                if (this.a.j0 != null) {
                    this.a.V.e0(this.a.j0.e(i));
                }
                gi8 gi8Var = new gi8();
                if (he6Var != null) {
                    boolean z = he6Var.e == 0;
                    gi8Var.b = z;
                    gi8Var.c = he6Var.e;
                    gi8Var.d = he6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.v0();
                        } else if (he6Var.g) {
                            if (ListUtils.getCount(this.a.y.getThreadList()) > 3) {
                                this.a.t.L1();
                            } else {
                                this.a.t.H1();
                            }
                        } else if (he6Var.i) {
                            this.a.t.O1();
                        } else {
                            this.a.t.v0();
                        }
                    }
                } else {
                    he6Var = new he6();
                    he6Var.c = 1;
                    he6Var.g = false;
                    he6Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.E1.d(frsFragment.U.getType(), false, gi8Var);
                } else {
                    this.a.Y3(gi8Var);
                    if (this.a.U.f0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y = frsFragment2.U.f0();
                    }
                    this.a.p3();
                }
                if (this.a.R1 != null) {
                    this.a.R1.a(i, i2, he6Var, arrayList);
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
                    this.c.V.o0(i);
                    if (i == 1) {
                        this.c.V.B();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.Y2()) {
                    this.c.O = new a95();
                    this.c.O.a(1000);
                }
                if (i != 0) {
                    if (this.c.X0 == null) {
                        this.c.X0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    a95 a95Var = this.c.O;
                    if (a95Var != null) {
                        a95Var.d();
                    }
                } else {
                    a95 a95Var2 = this.c.O;
                    if (a95Var2 != null) {
                        a95Var2.e();
                    }
                    nx5.b().e(true);
                    this.c.g3(true);
                    this.c.t.L0(this.a, this.b);
                    if (this.c.X0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.X0);
                        this.c.X0 = null;
                    }
                }
                if (this.c.t0 != null) {
                    this.c.t0.i(recyclerView, i);
                }
                if (i == 0) {
                    sp6.b(this.c.t, this.c.y, this.c.b(), false, null);
                }
                if (this.c.W != null && i == 1) {
                    this.c.W.M();
                }
                if (this.c.T == null) {
                    if (this.c.t.k0() != null && !this.c.t.a0() && this.c.t.k0().j() != null && (this.c.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.T = (ThreadCardViewHolder) frsFragment2.t.k0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.k0() != null && !this.c.t.a0() && this.c.t.k0().j() != null && (this.c.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.T = (ThreadCardViewHolder) frsFragment3.t.k0().j().getTag();
                }
                if (i == 1) {
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
                if (this.c.k0 != null) {
                    this.c.k0.j();
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
                if (this.c.y == null || this.c.t == null || this.c.t.W() == null) {
                    return;
                }
                this.c.t.i1(this.a, this.b);
                if (this.c.T != null && this.c.T.c() != null) {
                    this.c.T.c().o(this.c.S);
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i2 > 0) {
                    lh8.r().A(3, 2);
                    lh8.r().G();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class q1 implements bp {
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

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == zc6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.T1();
                }
            } else if (roVar == null || !(roVar instanceof br4)) {
            } else {
                ThreadData threadData = ((br4) roVar).s;
                if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        if (threadData.getAppCodeData() != null) {
                            if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                                String a2 = threadData.getAppCodeData().a();
                                if (StringUtils.isNull(a2) || !mi.C()) {
                                    return;
                                }
                                fm4.l(this.a.getActivity(), a2);
                            }
                        } else if (threadData.getCartoonThreadData() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                                return;
                            }
                            uo4 cartoonThreadData = threadData.getCartoonThreadData();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                        } else {
                            cl8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                                sp6.c(threadData.getTaskInfoData());
                            } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", threadData.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                            tp6.f(this.a, threadData, i, z);
                            FrsFragment frsFragment = this.a;
                            sp6.d(frsFragment, frsFragment.y, threadData);
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
                if (TbadkApplication.getInst().getCurrentActivity() == null || li.isEmpty(str) || !str.equals(this.a.l)) {
                    return;
                }
                pp6.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.y);
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
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.J() == 0 || this.a.W.A() == null || !(this.a.W.A().b instanceof BaseFragment) || !((BaseFragment) this.a.W.A().b).isPrimary() || this.a.t.H0() || p35.h().k()) {
                if (this.a.W.J() != 0) {
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
            this.a.t.O();
        }
    }

    /* loaded from: classes3.dex */
    public class s0 implements kc6 {
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

        @Override // com.repackage.kc6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i != this.a.t.W().c()) {
                    if (i != this.a.t.W().j()) {
                        if (i != this.a.t.W().i() || this.a.y == null || this.a.y.getUserData() == null || !this.a.y.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.y.getBawuCenterUrl();
                        if (li.isEmpty(bawuCenterUrl) || this.a.y.getForum() == null) {
                            return;
                        }
                        fm4.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.y.getForum().getId()).param("uid", this.a.y.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.y == null || this.a.y.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.y.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), kg.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    tp6.e(this.a.getPageContext(), this.a.y);
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
                this.a.V3();
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
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.U.d0() == 1 && z && !this.a.t.a0()) {
                if (this.a.y != null && !ListUtils.isEmpty(this.a.y.getThreadList())) {
                    this.a.t.J0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.X().m());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.n0(), true);
                this.a.t.w0(false);
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements vi8 {
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

        @Override // com.repackage.vi8
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

        @Override // com.repackage.vi8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.s3();
            }
        }

        @Override // com.repackage.vi8
        public void c(oi8 oi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oi8Var) == null) {
                if ((oi8Var == null || !("normal_page".equals(this.b.U.b0()) || "frs_page".equals(this.b.U.b0()) || "book_page".equals(this.b.U.b0()))) && !"brand_page".equals(this.b.U.b0())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, oi8Var));
                this.b.t3(oi8Var);
                FrsFragment.e2 = oi8Var;
            }
        }

        @Override // com.repackage.vi8
        public void d(int i, boolean z, gi8 gi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), gi8Var}) == null) {
                if (this.b.i0) {
                    this.b.i0 = false;
                    sp6.b(this.b.t, this.b.y, this.b.b(), false, null);
                }
                this.b.Z3();
                this.b.N = true;
                if (gi8Var != null && gi8Var.b) {
                    this.b.t.W().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.f2 = 0L;
                    FrsFragment.g2 = 0L;
                    FrsFragment.h2 = 0;
                } else {
                    FrsFragment.h2 = 1;
                }
                if (!this.b.U.v0() && (i == 3 || i == 6)) {
                    this.b.m0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.U.f0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.y = frsFragment.U.f0();
                }
                this.b.X3(1);
                this.b.P3();
                if (i == 7) {
                    this.b.r3(this.b.y.getFrsDefaultTabId());
                    return;
                }
                if (this.b.y.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.A3(frsFragment2.y.getPage().b());
                }
                if (i == 4) {
                    if (!this.b.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.U.d0() == 1 && (this.b.y.adShowSelect == 1 || this.b.y.adShowSelect == 3)) {
                        this.b.y.addRecommendAppToThreadList(this.b);
                    }
                    ArrayList<ro> c = this.b.m0.c(false, false, this.b.y.getThreadList(), this.b.o, false, this.b.y.adShowSelect, this.b.y.adMixFloor);
                    if (c != null) {
                        this.b.y.setThreadList(c);
                        this.b.y.checkLiveStageInThreadList();
                    }
                    if (this.b.U != null) {
                        io6.m(this.b.y, this.b.U.T(), 2, this.b.getContext());
                    }
                    FrsFragment frsFragment3 = this.b;
                    ep6.a(frsFragment3, frsFragment3.y.getForum(), this.b.y.getThreadList(), false, this.b.J2());
                    this.b.t.D1(c, this.b.y);
                    this.b.b4();
                    return;
                }
                this.b.b4();
                if (i == 1) {
                    this.b.t.J0();
                } else if (i == 2) {
                    this.b.t.J0();
                } else if (i == 3 || i == 6) {
                    if (this.b.y != null) {
                        this.b.y.clearPostThreadCount();
                    }
                    yp6 yp6Var = this.b.r0;
                    if (yp6Var != null) {
                        yp6Var.d();
                    }
                }
                this.b.h4();
                if (gi8Var == null || gi8Var.c == 0) {
                    if (this.b.y == null) {
                        return;
                    }
                    if (this.b.i() != null) {
                        FrsFragment frsFragment4 = this.b;
                        if (!frsFragment4.Q3(frsFragment4.y, this.b.i())) {
                            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                            upgradePopWindowMessage.setFromPage("frs");
                            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                        }
                    }
                    this.b.m3(false, i == 5);
                    if (this.b.U != null) {
                        if (this.b.y.getActivityHeadData() != null && this.b.y.getActivityHeadData().b() != null && this.b.y.getActivityHeadData().b().size() > 0) {
                            go6.g(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.c0(), 1);
                        }
                        if (this.b.y.getThreadList() != null && this.b.y.getThreadList().size() > 0) {
                            Iterator<ro> it = this.b.y.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ro next = it.next();
                                if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                    go6.g(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.c0(), 2);
                                    break;
                                }
                            }
                        }
                        go6.h(this.b.getUniqueId(), this.b.y.getThreadList(), this.b.y.getForum(), this.b.U.c0());
                    }
                    this.b.t.U0(i);
                    FrsFragment.f2 = (System.nanoTime() - this.a) / 1000000;
                    if (gi8Var != null) {
                        FrsFragment.g2 = gi8Var.e;
                    }
                } else if (this.b.y == null || ListUtils.isEmpty(this.b.y.getThreadList())) {
                    this.b.Y3(gi8Var);
                } else if (gi8Var.a) {
                    FrsFragment frsFragment5 = this.b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2c, gi8Var.d, Integer.valueOf(gi8Var.c)));
                }
                if (!this.b.D2()) {
                    this.b.e4();
                }
                this.b.o2();
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
                gp6.a(customResponsedMessage, this.a.t, this.a.y);
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
                    sp6.b(this.a.t, this.a.y, this.a.b(), true, (ThreadData) data);
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
            FrsTabViewController.o A = this.a.W.A();
            if (A != null && (fragment = A.b) != null && (fragment instanceof vd6)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((vd6) A.b).z0();
                ((vd6) A.b).o();
                return;
            }
            this.a.w0().T1();
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivateForumPopInfoData a;
        public final /* synthetic */ nr4 b;
        public final /* synthetic */ FrsFragment c;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, privateForumPopInfoData, nr4Var};
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
            this.a = privateForumPopInfoData;
            this.b = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.c.getPageContext(), new String[]{this.a.B()});
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements yd6 {
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
                    this.a.a.loadMore();
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

        @Override // com.repackage.yd6
        public void a(int i, int i2, he6 he6Var, ArrayList<ro> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), he6Var, arrayList}) == null) {
                ng.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements nr4.e {
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
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
                    if (this.a.T == null && this.a.t.k0() != null && !this.a.t.a0() && this.a.t.k0().j() != null && (this.a.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.T = (ThreadCardViewHolder) frsFragment.t.k0().j().getTag();
                    }
                    if (this.a.T == null || this.a.T.c() == null) {
                        return;
                    }
                    this.a.T.c().o(new vz.a(3));
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N || !ki.z() || this.a.t.G0()) {
                return;
            }
            this.a.t.W0();
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
            this.a.t.T0();
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
        this.S = new vz.a(2);
        this.h0 = new SparseArray<>();
        this.i0 = true;
        this.A0 = false;
        this.C0 = false;
        this.E0 = false;
        this.F0 = null;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.M0 = -1;
        this.R0 = -1;
        this.Y0 = false;
        this.Z0 = false;
        this.a1 = false;
        this.b1 = new k(this);
        this.c1 = new v(this, 2016495);
        this.d1 = new g0(this, 2921005);
        this.e1 = new r0(this, 2921401);
        this.f1 = new c1(this, 2921473);
        this.g1 = new m1(this, 2921467);
        this.h1 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.i1 = new o1(this, 2001624);
        this.j1 = new p1(this);
        this.k1 = new a(this);
        this.m1 = new b(this, 2001606);
        this.n1 = new c(this, 2001607);
        this.o1 = new d(this, 2003019);
        this.p1 = new e(this, 2921470);
        this.q1 = new f(this, 2001352);
        this.r1 = new g(this);
        this.s1 = new h(this, 2001115);
        this.t1 = new i(this, 2921346);
        this.u1 = new j(this, 2001374);
        this.v1 = new l(this, 2001378);
        this.w1 = new m(this, 2001626);
        this.x1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.y1 = new o(this);
        this.z1 = new p(this, 2921391);
        this.A1 = new q(this, 2003020);
        this.B1 = new r(this, 2921463);
        this.C1 = new s(this, 2921587);
        this.D1 = new t(this, 2921588);
        this.E1 = new u(this);
        this.F1 = new b0(this, 2016485);
        this.G1 = new c0(this, 2001194);
        this.H1 = new f0(this);
        this.I1 = new h0(this);
        this.J1 = new i0(this);
        this.K1 = new o0(this);
        this.L1 = new p0(this);
        this.M1 = new q0(this);
        this.N1 = new s0(this);
        this.O1 = new t0(this);
        this.P1 = new u0(this, 0);
        this.Q1 = new q1(this, null);
        this.R1 = new w0(this);
        this.S1 = new x0(this, 2921033);
        this.T1 = new y0(this, 2921381);
        this.U1 = new z0(this, 2921414);
        this.V1 = new a1(this, 2921437);
        this.W1 = new g1(this, 2921462);
        this.X1 = new h1(this, 2001223);
        this.Y1 = new i1(this, 2921469);
        this.Z1 = new j1(this, 2921475);
        this.a2 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.b2 = new l1(this, 2921515);
    }

    public int A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? tp6.c(this.y, this.t) : invokeV.intValue;
    }

    public void A3(int i3) {
        dm6 dm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) || (dm6Var = this.m0) == null) {
            return;
        }
        dm6Var.n(i3);
    }

    public em6 B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l0 : (em6) invokeV.objValue;
    }

    public void B3(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, num, num2, z2) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                gg6 f3 = this.b.f();
                if (f3 == null) {
                    return;
                }
                f3.z1().i(num, num2, z2);
                if (z2) {
                    return;
                }
                this.V.w();
            } else if (this.t.l0() == null) {
            } else {
                TextView l02 = this.t.l0();
                if (z2) {
                    l02.setVisibility(8);
                    return;
                }
                int i3 = 2;
                if (num.intValue() == 2) {
                    l02.setText("修改实名认证信息");
                    l02.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.l + "&nomenu=1";
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    l02.setText("目标已完成" + String.valueOf(num2) + "%");
                    l02.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.l + "&fn=" + this.f + "&nomenu=1";
                    i3 = 1;
                } else {
                    l02.setVisibility(8);
                    str = "";
                    i3 = 0;
                }
                l02.setOnClickListener(new y(this, i3, str));
            }
        }
    }

    @Override // com.repackage.td6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public bo6 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.Y : (bo6) invokeV.objValue;
    }

    public void C3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.Y0 = z2;
            this.Z0 = z2;
        }
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.a1 = z2;
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a1 : invokeV.booleanValue;
    }

    public void E3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.Q = z2;
        }
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t.a0() : invokeV.booleanValue;
    }

    public void F3(boolean z2) {
        fq6 fq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) || (fq6Var = this.n0) == null) {
            return;
        }
        fq6Var.b0();
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.E0 = z2;
        }
    }

    public BdTypeRecyclerView H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            vc6 vc6Var = this.t;
            if (vc6Var == null) {
                return null;
            }
            return vc6Var.c0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.y == null) {
            return;
        }
        ho6 ho6Var = new ho6();
        if (this.y.needLog == 1) {
            ho6Var.a = true;
        } else {
            ho6Var.a = false;
        }
        if (this.y.getForum() != null) {
            ho6Var.c = this.y.getForum().getId();
            ho6Var.d = this.y.getForum().getName();
        }
        if (b0() != null) {
            ho6Var.b = b0().T();
        }
        ho6 ho6Var2 = jo6.f0;
        if (ho6Var2 != null) {
            ho6Var.e = ho6Var2.e;
            ho6Var.f = ho6Var2.f;
        }
        yl6 yl6Var = new yl6(ho6Var, getTbPageTag(), getUniqueId());
        this.N0 = yl6Var;
        yl6Var.d(this.Q0);
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

    public ae6 I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g0 : (ae6) invokeV.objValue;
    }

    public void I3(boolean z2) {
        ae6 ae6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || (ae6Var = this.g0) == null) {
            return;
        }
        ae6Var.i(z2);
    }

    public int J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            dm6 dm6Var = this.m0;
            if (dm6Var == null) {
                return 1;
            }
            return dm6Var.g();
        }
        return invokeV.intValue;
    }

    public void J3(int i3) {
        dm6 dm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i3) == null) || (dm6Var = this.m0) == null) {
            return;
        }
        dm6Var.o(i3);
    }

    public View K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void K3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) && this.c2 == null) {
            lr6 a2 = lr6.a(z2);
            this.c2 = a2;
            dm6 dm6Var = this.m0;
            if (dm6Var != null) {
                dm6Var.m(a2);
            }
        }
    }

    @Override // com.repackage.ga8
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b0().U0();
        }
    }

    public FrsTabViewController L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.W : (FrsTabViewController) invokeV.objValue;
    }

    public final void L3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (frsViewData = this.y) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.W().setFromCDN(true);
        } else {
            this.t.W().setFromCDN(false);
        }
    }

    public final FrsTabInfoData M2() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.U == null || (frsViewData = this.y) == null || this.W == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.y.getEntelechyTabInfo().a) || (E = this.W.E()) == 502) {
                return null;
            }
            int i3 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.y.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.y.getUserData() == null || this.y.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (E == frsTabInfo.tab_id.intValue()) {
                        i3 = E;
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

    public void M3(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    @Override // com.repackage.mm6
    public dq6 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.V : (dq6) invokeV.objValue;
    }

    public String N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void N3(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public OvalActionButton O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.u : (OvalActionButton) invokeV.objValue;
    }

    public void O3(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    public FRSRefreshButton P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.v : (FRSRefreshButton) invokeV.objValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
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

    public int Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            dm6 dm6Var = this.m0;
            if (dm6Var == null) {
                return -1;
            }
            return dm6Var.h();
        }
        return invokeV.intValue;
    }

    public boolean Q3(oi8 oi8Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, oi8Var, tbPageContext)) == null) {
            if (D2()) {
                return false;
            }
            if (oi8Var != null && oi8Var.getEntelechyTabInfo() != null && oi8Var.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : oi8Var.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && iu4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            if (oi8Var != null && oi8Var.getBusinessPromot() != null && !StringUtils.isNull(oi8Var.getBusinessPromot().p()) && oi8Var.getForum() != null) {
                boolean j2 = kp6.j(oi8Var.getBusinessPromot(), oi8Var.getForum().getId());
                this.V0 = j2;
                C3(j2);
                return this.V0;
            }
            mf6 mf6Var = new mf6(tbPageContext);
            this.T0 = mf6Var;
            boolean j3 = mf6Var.j(oi8Var);
            this.U0 = j3;
            C3(j3);
            return this.U0;
        }
        return invokeLL.booleanValue;
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        mi.w(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setContentViewSize(2);
            nr4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new l0(this, nr4Var));
            nr4Var.setContentView(frsBroadcastCopyGuideDialogView);
            nr4Var.create(getPageContext()).show();
        }
    }

    public void S2() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (dq6Var = this.V) == null) {
            return;
        }
        dq6Var.C();
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            p35.h().m(new m35(getContext()));
            p35.h().n(85, 0, mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (p35.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new m0(this), true);
            }
        }
    }

    public void T2() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            p35.h().m(new n35(getContext()));
            p35.h().n(85, 0, mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (p35.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public final void U2() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || !isResumed() || (list = this.J0) == null || list.size() < 1 || this.I0 > this.J0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.J0.get(this.I0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.I0++;
            U2();
        }
        if (this.w != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0b), getResources().getString(R.string.obfuscated_res_0x7f0f06fd));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.K0 = ofFloat;
            ofFloat.setDuration(600L);
            this.K0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.K0.addListener(new e1(this, frsRedpackRunView));
            this.L0 = new f1(this, frsRedpackRunView);
            ng.a().postDelayed(this.L0, 5000L);
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
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.W.A().b).isPrimary() || this.t.H0() || this.J) {
                return;
            }
            this.w.setVisibility(0);
        }
    }

    public void U3(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.V0();
            this.t.k1(8);
            if (this.s0 == null) {
                this.s0 = new mq6(getPageContext(), getNetRefreshListener());
            }
            this.s0.c(str);
            this.s0.b(list);
            this.s0.attachView(view2, z2);
        }
    }

    public final void V2(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            registerListener(2001118, this.P1);
            long j2 = 0;
            if (bundle != null) {
                this.f = bundle.getString("name");
                this.g = bundle.getString("from");
                this.h = bundle.getInt("flag", 0);
                j2 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                this.f = intent.getStringExtra("name");
                this.g = intent.getStringExtra("from");
                this.h = intent.getIntExtra("flag", 0);
                j2 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            }
            if (getArguments() != null) {
                this.i = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
            }
            if (this.mIsLogin) {
                registerListener(2001120, this.P1);
            }
            this.V.I(bundle);
            s2(j2);
        }
    }

    public void V3() {
        vc6 vc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (vc6Var = this.t) == null) {
            return;
        }
        vc6Var.G1();
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.h == 0) {
                this.t.E1(this.f);
            } else {
                this.t.E1("");
                this.h = 1;
            }
            this.t.A1(this.Q1);
            this.t.J(this.M1);
            this.t.B1(this.O1);
            this.t.W().l(this.N1);
        }
    }

    public void W3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048624, this, str, str2, str3) == null) {
            ip6 ip6Var = new ip6(str, str2);
            this.S0 = ip6Var;
            ip6Var.f(getFragmentActivity(), str3, str2);
        }
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void X3(int i3) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i3) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.y) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            WindowToast windowToast = list.get(i4);
            if (windowToast != null && windowToast.toast_type.intValue() == i3) {
                if (li.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", ge5.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void Y3(gi8 gi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, gi8Var) == null) {
            if (gi8Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05a5);
                this.t.V0();
                showNetRefreshView(this.t.n0(), string, true);
            } else if (340001 == gi8Var.c) {
                d4(gi8Var, this.y.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    c4(gi8Var);
                }
                if (Y2()) {
                    setNetRefreshViewEmotionMarginTop(mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070295));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            hideLoadingView(this.t.n0());
            this.t.V1();
            if (this.t.m0() instanceof no6) {
                ((no6) this.t.m0()).d();
            }
        }
    }

    @Override // com.repackage.am6, com.repackage.zd6
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (Q2() != 1 && !this.m0.b(this.y.getThreadListIds())) {
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

    @Override // com.repackage.zd6
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Override // com.repackage.mm6
    public FrsModelController b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.U : (FrsModelController) invokeV.objValue;
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (g0() == null) {
                return false;
            }
            FrsViewData g02 = g0();
            bp4 bp4Var = null;
            if (g02.getStar() != null && !StringUtils.isNull(g02.getStar().a())) {
                bp4Var = new bp4();
            } else if (g02.getActivityHeadData() != null && ListUtils.getCount(g02.getActivityHeadData().b()) >= 1) {
                bp4Var = g02.getActivityHeadData().b().get(0);
            }
            return bp4Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (Q2() == 0 && ListUtils.isEmpty(this.y.getThreadListIds())) {
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

    public boolean c3() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void c4(gi8 gi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, gi8Var) == null) {
            this.t.V0();
            if (gi8Var.a) {
                showNetRefreshView(this.t.n0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2c, new Object[]{gi8Var.d, Integer.valueOf(gi8Var.c)}), true);
            } else {
                showNetRefreshView(this.t.X().m(), gi8Var.d, true);
            }
        }
    }

    @Override // com.repackage.wd6
    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            vc6 vc6Var = this.t;
            if (vc6Var == null) {
                return null;
            }
            return vc6Var.g0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (g0() == null) {
                return false;
            }
            FrsViewData g02 = g0();
            return (ListUtils.isEmpty(g02.getShowTopThreadList()) && g02.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void d4(gi8 gi8Var, List<RecmForumInfo> list) {
        vc6 vc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048642, this, gi8Var, list) == null) || (vc6Var = this.t) == null) {
            return;
        }
        vc6Var.V0();
        this.t.E1(this.f);
        if (this.t.X() != null) {
            U3(this.t.n0(), gi8Var.d, true, list);
        }
        this.t.f0().h(true);
    }

    @Override // com.repackage.zh5
    public void dispatchInjectPluginMessage(xh5 xh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, xh5Var) == null) {
            this.q0.a(xh5Var);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void e(ArrayList<ro> arrayList) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            A3(!isEmpty ? 1 : 0);
            a4();
            if (isEmpty) {
                return;
            }
            if (!this.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.d0() == 1 && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                go6.h(getUniqueId(), arrayList, this.y.getForum(), this.U.c0());
            }
            dm6 dm6Var = this.m0;
            qj8 qj8Var = this.o;
            FrsViewData frsViewData = this.y;
            ArrayList<ro> c2 = dm6Var.c(false, false, arrayList, qj8Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.y.setThreadList(c2);
                this.t.D1(c2, this.y);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                io6.m(this.y, frsModelController.T(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.y.getForum()));
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && ViewHelper.checkUpIsLogin(getContext())) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            fn6.a(param);
            fn6.b(param, b(), a());
            TiebaStatic.log(param);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.K).param("obj_type", this.K > 0 ? 1 : 2).param("obj_source", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public final void e4() {
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || m2()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.C(this.y.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.y.getPrivateForumTotalInfo().a() != null && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (li.isEmpty(privateForumPopInfoData.A()) || privateForumPopInfoData.z() != Integer.valueOf(this.l))) {
            privateForumPopInfoData.F("create_success");
            privateForumPopInfoData.D(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0723));
            privateForumPopInfoData.G("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.l + "&fn=" + this.f + "&nomenu=1");
            privateForumPopInfoData.E(Integer.valueOf(this.l));
            a2 = frsPrivateCommonDialogView.a(privateForumPopInfoData);
        } else {
            a2 = privateForumPopInfoData.z() == Integer.valueOf(this.l) ? frsPrivateCommonDialogView.a(privateForumPopInfoData) : false;
        }
        if (a2) {
            nr4 nr4Var = new nr4(getActivity());
            nr4Var.setContentViewSize(2);
            nr4Var.setContentView(frsPrivateCommonDialogView);
            nr4Var.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new w(this, privateForumPopInfoData, nr4Var));
            nr4Var.setCloseButton(new x(this));
            nr4Var.create(getPageContext()).show();
            C3(true);
        }
    }

    public final void f2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.U) == null || this.y == null || this.t == null || !z2) {
            return;
        }
        if (!frsModelController.v0() && this.U.d0() == 1) {
            if (!this.U.s0()) {
                this.y.addCardVideoInfoToThreadList();
                this.y.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.t.W().k(ky5.g) ? this.y.addHotTopicDataToThreadList() : false)) {
                this.y.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this);
            }
            if (!this.t.W().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                this.y.removeAlaLiveThreadData();
            }
            this.y.addSchoolRecommendToThreadList();
        }
        if (!this.t.W().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
            this.y.removeAlaInsertLiveData();
            this.y.removeAlaStageLiveDat();
        } else {
            this.y.addInsertLiveDataToThreadList();
            this.y.addStageLiveDataToThreadList();
        }
        this.y.checkLiveStageInThreadList();
        this.y.addNoticeThreadToThreadList();
        if (this.t.W().k(tr6.e)) {
            this.y.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.U.v0() || this.U.isNetFirstLoad)) {
            this.y.addUserRecommendToThreadList();
        }
        this.y.addVideoActivityToTop();
    }

    public void f3(Object obj) {
        cm6 cm6Var;
        a9 a9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, obj) == null) || (cm6Var = this.Z) == null || (a9Var = cm6Var.j) == null) {
            return;
        }
        a9Var.c(obj);
    }

    public void f4() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048649, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    @Override // com.repackage.am6
    public FrsViewData g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.y : (FrsViewData) invokeV.objValue;
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                h2(frsModelController.b0());
            } else {
                h2("normal_page");
            }
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z2) == null) {
            ai8.g().h(getUniqueId(), z2);
        }
    }

    public void g4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(str);
            bdTopToast.j(this.t.n0());
        }
    }

    @Override // com.repackage.zh5
    public yh5 getInjectPlugin(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i3)) == null) ? this.h0.get(i3) : (yh5) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.am6
    public /* bridge */ /* synthetic */ b9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.o A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (L2() != null && (A = L2().A()) != null) {
                Fragment fragment = A.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.y;
                        tbPageTag.sortType = rp6.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.a.equals(A.c)) {
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
    public bg<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void h2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            F3("frs_page".equals(str));
            oh6 oh6Var = this.j0;
            if (oh6Var != null) {
                oh6Var.c(this.V, this.t, this.y);
            }
        }
    }

    public boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? (!b3() || d3() || UbsABTestHelper.isFrsModifyABTestA()) ? false : true : invokeV.booleanValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            this.t.k1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view2, false);
            this.t.f0().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.k1(0);
            this.t.f0().h(false);
        }
    }

    @Override // com.repackage.ga8
    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean i3(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048667, this, i3, keyEvent)) == null) {
            if (i3 != 4) {
                if (i3 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (gc6.f().i()) {
                gc6.f().m();
                return true;
            } else if (fc6.h().j()) {
                vc6 vc6Var = this.t;
                if (vc6Var != null && vc6Var.F0()) {
                    this.t.c1();
                    return true;
                }
                fc6.h().n();
                return true;
            } else {
                vc6 vc6Var2 = this.t;
                if (vc6Var2 != null) {
                    return vc6Var2.P0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || li.isEmpty(this.l)) {
            return;
        }
        zi4.y().Q(yi4.Y, kg.g(this.l, 0L));
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? k2(this.l1) : invokeV.booleanValue;
    }

    public void j3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, intent) == null) || intent == null) {
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
            t2();
        }
    }

    public void j4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || (voiceManager = this.r) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public boolean k2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i3)) == null) {
            if (this.Q && !this.E0 && l2(i3)) {
                FrsModelController frsModelController = this.U;
                return (frsModelController != null && frsModelController.W() && (gc6.f().i() || fc6.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void k3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048673, this, str) == null) && TbadkCoreApplication.isLogin() && !li.isEmpty(str)) {
            if (this.B0 == null) {
                this.B0 = new AddExperiencedModel(i());
            }
            this.B0.C(this.l, str);
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.repackage.td6
    public void l() {
        vc6 vc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (vc6Var = this.t) == null) {
            return;
        }
        vc6Var.c0().scrollToPosition(0);
        this.t.T1();
    }

    public final boolean l2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048676, this, i3)) == null) ? i3 != 506 : invokeI.booleanValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            if (this.h == 1) {
                qg.a().b(new k0(this));
            }
            this.h = 0;
        }
    }

    public void l4(Object obj) {
        cm6 cm6Var;
        a9 a9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, obj) == null) || (cm6Var = this.Z) == null || (a9Var = cm6Var.i) == null) {
            return;
        }
        a9Var.c(obj);
    }

    @Override // com.repackage.mm6
    public void loadMore() {
        dm6 dm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || (dm6Var = this.m0) == null) {
            return;
        }
        dm6Var.i(this.f, this.l, this.y);
    }

    public final boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.y.getPrivateForumTotalInfo().a() == null || this.y.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public final void m3(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.y != null && this.W != null && this.U != null) {
                    if (!this.t.W().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.y.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.y.getGameTabInfo());
                    this.t.p1(isEmpty);
                    if (!isEmpty) {
                        if (this.t0 == null) {
                            this.t0 = new aq6(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.v0 == null) {
                            this.v0 = new hk6(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                        this.W.d(this.y, this.U.T());
                    }
                    if (z2) {
                        f2(true, z2);
                    } else {
                        f2(this.P, z2);
                    }
                    q3();
                    if (this.j0 != null) {
                        this.j0.a(this.V, this.y);
                    }
                    if (this.y.getPage() != null) {
                        A3(this.y.getPage().b());
                    }
                    ArrayList<ro> d3 = this.m0.d(z3, true, this.y.getThreadList(), null, z2, false, this.y.adShowSelect, this.y.adMixFloor);
                    if (d3 != null) {
                        this.y.setThreadList(d3);
                    }
                    this.y.removeRedundantUserRecommendData();
                    int topThreadSize = this.y.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        ep6.a(this, this.y.getForum(), this.y.getThreadList(), this.n, J2());
                    }
                    if (this.U.d0() == 1) {
                        p3();
                        if (!z2 && this.U.getPn() == 1) {
                            u3();
                        }
                    }
                    if (this.k0 != null) {
                        this.k0.k(this.W.F());
                    }
                    Z3();
                    this.t.e1();
                    this.t.m1(true, false);
                    if (z2 && this.y.isFirstTabEqualAllThread()) {
                        ng.a().post(new z(this));
                    }
                    if (this.y.getForum() != null) {
                        this.t.N(this.y.getForum().getWarningMsg());
                    }
                    if (this.y != null && this.y.getFrsVideoActivityData() != null && iu4.k().m("frs_video_activity_guide", 0L) == 0) {
                        ng.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.F1();
                    if (this.y != null && this.y.getForum() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.y.getForum().getId(), this.y.getForum().getName(), this.y.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.y.getForum().special_forum_type), this.y.getForum().getThemeColorInfo(), this.y.getForum().getMember_num())));
                    }
                    this.y0.e(this.y.bottomMenuList, this.y.getForum());
                    i4();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void m4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i3) == null) {
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
                    vp6.a(this, 0);
                } else {
                    this.t.P1();
                }
            }
        }
    }

    @Override // com.repackage.mm6
    public dm6 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.m0 : (dm6) invokeV.objValue;
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            tp6.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.g);
        }
    }

    public void n3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i3) == null) {
            this.N = false;
            j4();
            vc6 vc6Var = this.t;
            if (vc6Var != null && vc6Var.k0() != null) {
                this.t.k0().x();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.I0(i3, true);
            }
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            if (!m2() && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                B3(this.y.getPrivateForumTotalInfo().a().private_forum_audit_status, this.y.getPrivateForumTotalInfo().b(), false);
            } else {
                B3(null, null, true);
            }
        }
    }

    public void o3() {
        vc6 vc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (vc6Var = this.t) == null) {
            return;
        }
        vc6Var.Z0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                v2(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new qj8("frs", qj8.c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.E1);
                this.U = frsModelController;
                frsModelController.v(this.j1);
                this.U.init();
            }
            this.U.S0(this.z);
            ArrayList<ro> arrayList = null;
            if (intent != null) {
                this.U.l0(intent.getExtras());
            } else if (bundle != null) {
                this.U.l0(bundle);
            } else {
                this.U.l0(null);
            }
            if (intent != null) {
                this.V.I(intent.getExtras());
            } else if (bundle != null) {
                this.V.I(bundle);
            } else {
                this.V.I(null);
            }
            this.r = getVoiceManager();
            this.q0 = new uc6(getPageContext(), this);
            W2();
            V2(bundle);
            if (!Y2()) {
                ae6 ae6Var = new ae6(getActivity(), this.t, this.V);
                this.g0 = ae6Var;
                ae6Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.r = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(x2()) && !this.A0) {
                int l2 = iu4.k().l("key_forum_broadcast_edit_tip_number", 0);
                if (l2 < 2) {
                    iu4.k().w("key_forum_broadcast_edit_tip_number", l2 + 1);
                    R3();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        S3();
                    } else {
                        BdTopToast bdTopToast = new BdTopToast(getContext());
                        bdTopToast.i(false);
                        bdTopToast.h(getContext().getString(R.string.obfuscated_res_0x7f0f064f));
                        bdTopToast.j(this.t.n0());
                    }
                } else {
                    S3();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(x2()) && !this.A0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        T3();
                    } else if (Build.VERSION.SDK_INT < 23 || !iu4.k().h("key_forum_rule_dialog_show_frs", false)) {
                        T3();
                        iu4.k().u("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    T3();
                }
            }
            if (p35.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new jm6();
            int i3 = -1;
            dm6 dm6Var = this.m0;
            if (dm6Var != null && dm6Var.f() != null) {
                i3 = this.m0.f().C();
                arrayList = this.m0.f().B();
            }
            dm6 dm6Var2 = new dm6(this, this.I1);
            this.m0 = dm6Var2;
            dm6Var2.f().setHasMore(i3);
            if (arrayList != null && arrayList.size() > 0) {
                this.m0.f().M(arrayList);
            }
            this.Y = new bo6(this);
            this.n0 = new fq6(this);
            this.k0 = new wp6(getPageContext(), this.U.q0());
            this.Z = new cm6(this);
            this.l0 = new em6(this);
            this.X = new im6(this);
            this.o0 = new bm6(this);
            this.r0 = new yp6(this);
            new fm6(this, getUniqueId());
            this.w0 = new li5(getPageContext(), "frs");
            this.x0 = new rn5(getPageContext());
            new fo6(getPageContext());
            registerListener(this.s1);
            registerListener(this.G1);
            registerListener(this.q1);
            registerListener(this.F1);
            registerListener(this.m1);
            registerListener(this.n1);
            registerListener(this.o1);
            registerListener(this.p1);
            registerListener(this.c1);
            registerListener(this.d1);
            registerListener(this.e1);
            registerListener(this.f1);
            registerListener(this.S1);
            registerListener(this.u1);
            this.v1.setSelfListener(true);
            this.v1.setTag(getPageContext().getUniqueId());
            registerListener(this.v1);
            registerListener(this.i1);
            registerListener(this.w1);
            registerListener(this.t1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.B1);
            this.T1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.T1);
            registerListener(this.U1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.h1);
            registerListener(this.X1);
            registerListener(this.x1);
            registerListener(this.g1);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.C1);
            registerListener(this.D1);
            this.t.w0(false);
            if (!Y2() && !this.A0) {
                showLoadingView(this.t.n0(), true);
                this.U.R(3, false);
            }
            gr6.a();
            d0 d0Var = new d0(this);
            gc6.f().s(d0Var);
            fc6.h().s(d0Var);
            this.t.y1(new e0(this));
            this.G0 = UtilHelper.getScreenHeight(getActivity());
            this.A0 = true;
            r2(1);
            super.onActivityCreated(bundle);
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048689, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            bm6 bm6Var = this.o0;
            if (bm6Var != null) {
                bm6Var.n(i3, i4, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i3) == null) {
            super.onChangeSkinType(i3);
            if (this.D0) {
                this.t.N0(i3);
                this.V.M(i3);
                this.W.U(i3);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i3);
                }
                mq6 mq6Var = this.s0;
                if (mq6Var != null) {
                    mq6Var.onChangeSkinType();
                }
                yf6 yf6Var = this.y0;
                if (yf6Var != null) {
                    yf6Var.d(getPageContext(), i3);
                }
                if (this.z0 != null) {
                    w95.a(getPageContext(), this.z0.getRealView());
                }
                aq6 aq6Var = this.t0;
                if (aq6Var != null) {
                    aq6Var.onChangeSkinType(getPageContext(), i3);
                }
                mf6 mf6Var = this.T0;
                if (mf6Var != null) {
                    mf6Var.onChangeSkinType(getPageContext(), i3);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bundle) == null) {
            super.onCreate(bundle);
            ai8.g().i(getUniqueId());
            if (this.P0 == null) {
                this.P0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.P0);
            registerResponsedEventListener(TopToastEvent.class, this.y1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048692, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f2, viewGroup, false);
                fg6 fg6Var = new fg6();
                this.b = fg6Var;
                this.j0 = fg6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0743);
                this.V = new dq6(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090d3c));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.L1);
                this.W = frsTabViewController;
                frsTabViewController.Z();
                this.V.q0(this.W);
                this.W.d0(this.k1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.d = true;
                }
                this.t = new vc6(this, this.L1, this.b, this.d, this.V);
                this.y0 = new yf6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.Z();
                }
                this.t.X0();
                this.s.setLeft(0);
                this.s.setRight(mi.k(TbadkCoreApplication.getInst().getContext()));
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
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            ai8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.v1);
            unRegisterResponsedEventListener();
            this.n0.Z();
            e2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            tb8.c("FRS");
            this.r = null;
            nx5.b().e(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null) {
                md6.a().b(kg.g(this.y.getForum().getId(), 0L));
            }
            xl6 xl6Var = this.p0;
            if (xl6Var != null) {
                xl6Var.v();
            }
            vc6 vc6Var = this.t;
            if (vc6Var != null) {
                sp6.b(vc6Var, this.y, b(), false, null);
                this.t.O0();
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
                ng.a().removeCallbacks(this.L0);
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
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            this.V.K();
            Looper.myQueue().removeIdleHandler(this.b1);
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.i();
            }
            ae6 ae6Var = this.g0;
            if (ae6Var != null) {
                ae6Var.d();
            }
            wp6 wp6Var = this.k0;
            if (wp6Var != null) {
                wp6Var.i();
            }
            bo6 bo6Var = this.Y;
            if (bo6Var != null) {
                bo6Var.c();
            }
            aq6 aq6Var = this.t0;
            if (aq6Var != null) {
                aq6Var.g();
            }
            bm6 bm6Var = this.o0;
            if (bm6Var != null) {
                bm6Var.o();
            }
            li5 li5Var = this.w0;
            if (li5Var != null) {
                li5Var.h();
            }
            rn5 rn5Var = this.x0;
            if (rn5Var != null) {
                rn5Var.g();
            }
            rb8.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.d0(null);
                this.W.M();
            }
            AddExperiencedModel addExperiencedModel = this.B0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            gc6.f().s(null);
            fc6.h().s(null);
            ip6 ip6Var = this.S0;
            if (ip6Var != null) {
                ip6Var.d();
            }
            if (this.P0 != null) {
                getLifecycle().removeObserver(this.P0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            a4();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public vo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? H2().getPreLoadHandle() : (vo) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && Y2()) {
            showLoadingView(this.t.n0(), true);
            this.t.z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.I0(3, true);
            H2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && mi.C()) {
            hideNetRefreshView(this.t.X().m());
            showLoadingView(this.t.n0(), true);
            this.t.w0(false);
            this.U.I0(3, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            super.onPause();
            this.X.f(false);
            this.P = false;
            this.t.Q0();
            dq6 dq6Var = this.V;
            if (dq6Var != null) {
                dq6Var.N();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.K0(true);
            wp6 wp6Var = this.k0;
            if (wp6Var != null) {
                wp6Var.j();
            }
            zi4.y().G();
            ip6 ip6Var = this.S0;
            if (ip6Var != null) {
                ip6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                dq6 dq6Var = this.V;
                if (dq6Var != null) {
                    dq6Var.O(isPrimary());
                }
                vc6 vc6Var = this.t;
                if (vc6Var != null) {
                    vc6Var.R0(isPrimary());
                    this.t.K0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048700, this, i3, strArr, iArr) == null) {
            tp6.i(this, i3, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            super.onResume();
            vc6 vc6Var = this.t;
            if (vc6Var != null) {
                vc6Var.J0();
                this.t.S0();
            }
            dq6 dq6Var = this.V;
            if (dq6Var != null) {
                dq6Var.P();
            }
            if (E2()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                D3(false);
            }
            this.X.f(true);
            this.P = true;
            if (d2) {
                d2 = false;
                vc6 vc6Var2 = this.t;
                if (vc6Var2 != null) {
                    vc6Var2.T1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            vc6 vc6Var3 = this.t;
            if (vc6Var3 != null) {
                vc6Var3.K0(false);
            }
            if (this.u0) {
                n3(6);
                this.u0 = false;
            }
            if (this.F0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    oy4.c().h(true);
                    oy4.c().i(this.F0.getHours(), this.F0.getMinutes());
                    if (this.t != null) {
                        oy4.c().k(i().getPageActivity(), this.t.n0());
                    }
                }
                this.F0 = null;
            }
            i4();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.U.G0(bundle);
            if (this.r == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            this.r.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            this.t.c0().stopScroll();
            if (this.t.d1()) {
                return;
            }
            if (!mi.C()) {
                this.t.v0();
            } else if (this.U.d0() == 1) {
                a4();
                loadMore();
            } else if (this.U.hasMore()) {
                loadMore();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048704, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        Z3();
        this.t.J0();
        gi8 U = this.U.U();
        boolean isEmpty = ListUtils.isEmpty(this.y.getThreadList());
        if (U != null && isEmpty) {
            if (this.U.X() != 0) {
                this.U.R0();
                this.t.J0();
            } else {
                Y3(U);
            }
            this.t.m1(this.y.isStarForum(), false);
            return;
        }
        Y3(U);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.r = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.onStop();
            nx5.b().e(false);
            g3(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                m05.j().x(getPageContext().getPageActivity(), "frs", this.y.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (H2() != null) {
                H2().getRecycledViewPool().clear();
            }
            this.V.L();
            pd5.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public final void p2(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<ro> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        Iterator<ro> it = threadList.iterator();
        List<ro> data = this.t.c0().getData();
        int i3 = 0;
        while (it.hasNext()) {
            ro next = it.next();
            if (next instanceof br4) {
                ThreadData threadData = ((br4) next).s;
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m0.j(next);
                        this.t.c0().getAdapter().notifyItemRemoved(i3);
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            i3++;
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            j4();
            try {
                if (this.y == null) {
                    return;
                }
                this.t.K1();
                this.t.S1(j2());
                if (this.y.getForum() != null) {
                    this.f = this.y.getForum().getName();
                    this.l = this.y.getForum().getId();
                }
                if (this.y.getPage() != null) {
                    A3(this.y.getPage().b());
                }
                this.t.E1(this.f);
                this.t.j1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.y.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.y.getUserData().getBimg_end_time());
                l3();
                L3();
                ArrayList<ro> threadList = this.y.getThreadList();
                if (threadList != null) {
                    this.t.D1(threadList, this.y);
                    gp6.b(this.t);
                    this.V.n0(q0());
                    this.y.setFrsFragmentTag(getUniqueId());
                    this.V.V(this.y);
                    this.W.d(this.y, this.U.T());
                    this.t.f1();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // com.repackage.td6
    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && isAdded() && this.i0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.n0(), true);
        }
    }

    @Override // com.repackage.ga8
    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            dm6 dm6Var = this.m0;
            if (dm6Var == null) {
                return 1;
            }
            return dm6Var.g();
        }
        return invokeV.intValue;
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048712, this) == null) || ListUtils.isEmpty(fc6.h().i()) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        ArrayList<ro> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<ro> it = threadList.iterator();
        List<ro> data = this.t.c0().getData();
        int count = ListUtils.getCount(fc6.h().i());
        int i3 = 0;
        while (it.hasNext()) {
            ro next = it.next();
            if (next instanceof br4) {
                ThreadData threadData = ((br4) next).s;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    } else if (StringHelper.equals(fc6.h().i().get(i4).getId(), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m0.j(next);
                        this.t.c0().getAdapter().notifyItemRemoved(i3);
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            i3++;
        }
    }

    public boolean q3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            dq6 dq6Var = this.V;
            if (dq6Var != null && (frsModelController = this.U) != null) {
                dq6Var.t0(frsModelController.b0(), this.y);
            }
            FrsViewData frsViewData2 = this.y;
            boolean hasTab = frsViewData2 != null ? frsViewData2.hasTab() : false;
            g2();
            vc6 vc6Var = this.t;
            if (vc6Var != null) {
                vc6Var.z0();
                this.t.A0();
                FrsViewData frsViewData3 = this.y;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.V0 = kp6.j(this.y.getBusinessPromot(), this.y.getForum().getId());
                }
                if (!this.V0 && (frsViewData = this.y) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.y0(this.y.getActivityHeadData().a());
                    if (this.y.getActivityHeadData().a() != null && !this.U0 && !this.V0 && !this.W0) {
                        V3();
                    }
                } else {
                    this.t.y0(null);
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    public final void r2(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i3) == null) {
            FrsViewData frsViewData = this.y;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.y.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void r3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i3) == null) {
            q3();
            j4();
            try {
                if (this.y == null) {
                    return;
                }
                ee6 ee6Var = null;
                this.t.D1(null, this.y);
                this.V.n0(1);
                this.t.f1();
                this.W.d(this.y, this.U.T());
                oo6 I = this.W.I(this.y.getFrsDefaultTabId());
                if (I != null && !TextUtils.isEmpty(I.d)) {
                    ee6Var = new ee6();
                    String str = I.d;
                    String str2 = I.a;
                }
                this.U.s(this.y.getFrsDefaultTabId(), 0, ee6Var);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            gj5.c().f("page_frs");
            n3(3);
        }
    }

    public final void s2(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048717, this, j2) == null) || j2 <= 0) {
            return;
        }
        ng.a().postDelayed(new j0(this, j2, mi.k(TbadkCoreApplication.getInst()), mi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public void s3() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048718, this) == null) && (frsModelController = this.U) != null && frsModelController.d0() == 1) {
            this.V.Z(this.y);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, str) == null) {
            this.g = str;
        }
    }

    @Override // com.repackage.zh5
    public void setInjectPlugin(int i3, yh5 yh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048720, this, i3, yh5Var) == null) {
            this.h0.put(i3, yh5Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController == null || frsTabViewController.A() == null || !(this.W.A().b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.W.A().b).setPrimary(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048722, this, view2, z2) == null) {
            this.t.k1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view2, true);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048723, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.obfuscated_res_0x7f0f0f84), null, getResources().getString(R.string.obfuscated_res_0x7f0f0f83), z2, getNetRefreshListener());
            this.t.k1(8);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048724, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.k1(8);
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            this.t.T1();
        }
    }

    public final void t3(oi8 oi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, oi8Var) == null) {
            try {
                if (!this.N && oi8Var != null && this.y != null) {
                    this.y.receiveData(oi8Var);
                    m3(true, false);
                    Looper.myQueue().addIdleHandler(this.b1);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public oh6 u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.j0 : (oh6) invokeV.objValue;
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            if (this.p0 == null) {
                this.p0 = new xl6(this, kg.e(this.l, 0));
            }
            this.p0.w();
        }
    }

    public final void v2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048730, this, intent) == null) || intent == null) {
            return;
        }
        if (!qp6.a(this, a(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
            BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.H1);
        } else {
            lp6 b2 = tp6.b(intent);
            if (b2 != null) {
                this.f = b2.a;
            }
        }
        if (!StringUtils.isNull(this.f)) {
            intent.putExtra("name", this.f);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void v3(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) || (frsTabViewController = this.W) == null) {
            return;
        }
        frsTabViewController.v = z2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? de5.a(2) : invokeV.booleanValue;
    }

    @Override // com.repackage.mm6
    public vc6 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.t : (vc6) invokeV.objValue;
    }

    public ForumWriteData w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
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
            forumWriteData.frsTabInfo = M2();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public void w3() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.o A;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || (frsTabViewController = this.W) == null || (A = frsTabViewController.A()) == null || (fragment = A.b) == null || !(fragment instanceof vd6)) {
            return;
        }
        ((vd6) fragment).z0();
    }

    public String x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.e = z2;
        }
    }

    @Override // com.repackage.ga8
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public bp y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.Q1 : (bp) invokeV.objValue;
    }

    public void y3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i3) == null) {
            this.h = i3;
        }
    }

    @Override // com.repackage.td6
    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && isAdded() && this.i0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.n0());
        }
    }

    public int z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.R0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.R0;
        }
        return invokeV.intValue;
    }

    public void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.f = str;
        }
    }
}
