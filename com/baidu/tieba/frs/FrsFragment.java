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
import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
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
import com.baidu.tieba.ad.AbsDataRecorder;
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
import com.repackage.ab;
import com.repackage.af6;
import com.repackage.ag6;
import com.repackage.al5;
import com.repackage.am8;
import com.repackage.ao6;
import com.repackage.ap4;
import com.repackage.ar6;
import com.repackage.as6;
import com.repackage.bg6;
import com.repackage.bo6;
import com.repackage.br6;
import com.repackage.c9;
import com.repackage.cj4;
import com.repackage.ck8;
import com.repackage.co6;
import com.repackage.cq5;
import com.repackage.d9;
import com.repackage.dg6;
import com.repackage.dj4;
import com.repackage.dj8;
import com.repackage.dm6;
import com.repackage.dm8;
import com.repackage.do6;
import com.repackage.dp6;
import com.repackage.dq6;
import com.repackage.ef6;
import com.repackage.eg6;
import com.repackage.ei6;
import com.repackage.ek5;
import com.repackage.eo6;
import com.repackage.eq6;
import com.repackage.fb5;
import com.repackage.fg;
import com.repackage.fg6;
import com.repackage.fi6;
import com.repackage.fk5;
import com.repackage.fr6;
import com.repackage.gk5;
import com.repackage.go6;
import com.repackage.gp4;
import com.repackage.gr6;
import com.repackage.hg6;
import com.repackage.ho6;
import com.repackage.hp4;
import com.repackage.hr6;
import com.repackage.ia5;
import com.repackage.id8;
import com.repackage.io6;
import com.repackage.ir4;
import com.repackage.ir6;
import com.repackage.jg6;
import com.repackage.jj8;
import com.repackage.jm4;
import com.repackage.jr6;
import com.repackage.jt6;
import com.repackage.kd8;
import com.repackage.ke6;
import com.repackage.ko6;
import com.repackage.le6;
import com.repackage.li6;
import com.repackage.lo6;
import com.repackage.lr6;
import com.repackage.mn4;
import com.repackage.mr6;
import com.repackage.ng6;
import com.repackage.nl5;
import com.repackage.of5;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.or6;
import com.repackage.oy;
import com.repackage.oz4;
import com.repackage.p75;
import com.repackage.pe6;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.qr6;
import com.repackage.r06;
import com.repackage.rf5;
import com.repackage.rf6;
import com.repackage.rg;
import com.repackage.rj8;
import com.repackage.rp6;
import com.repackage.ru4;
import com.repackage.sh6;
import com.repackage.sk5;
import com.repackage.sn;
import com.repackage.tk8;
import com.repackage.tr6;
import com.repackage.ug;
import com.repackage.uq6;
import com.repackage.ur4;
import com.repackage.us6;
import com.repackage.uz5;
import com.repackage.vj6;
import com.repackage.vp6;
import com.repackage.vr6;
import com.repackage.w45;
import com.repackage.wb8;
import com.repackage.wk5;
import com.repackage.wn6;
import com.repackage.wp6;
import com.repackage.wq6;
import com.repackage.x15;
import com.repackage.x45;
import com.repackage.xk5;
import com.repackage.xl5;
import com.repackage.xn6;
import com.repackage.xp6;
import com.repackage.yf6;
import com.repackage.yj8;
import com.repackage.yn;
import com.repackage.yp6;
import com.repackage.yq6;
import com.repackage.z45;
import com.repackage.ze5;
import com.repackage.ze6;
import com.repackage.zk5;
import com.repackage.zn6;
import com.repackage.zp6;
import com.repackage.zs6;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
import tbclient.WindowToast;
/* loaded from: classes3.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, zn6, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, eg6, wb8, lo6, gk5, yf6, bg6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean h2;
    public static rj8 i2;
    public static volatile long j2;
    public static volatile long k2;
    public static volatile int l2;
    public static boolean m2;
    public transient /* synthetic */ FieldHolder $fh;
    public fg<TbImageView> A;
    public boolean A0;
    public HttpMessageListener A1;
    public long B;
    public AddExperiencedModel B0;
    public p75 B1;
    public long C;
    public boolean C0;
    public final CustomMessageListener C1;
    public long D;
    public boolean D0;
    public CustomMessageListener D1;
    public long E;
    public boolean E0;
    public final CustomMessageListener E1;
    public long F;
    public Date F0;
    public CustomMessageListener F1;
    public long G;
    public int G0;
    public CustomMessageListener G1;
    public long H;
    public int H0;
    public final yj8 H1;
    public long I;
    public int I0;
    public final CustomMessageListener I1;
    public boolean J;
    public List<LiveHorseRaceData> J0;
    public final CustomMessageListener J1;
    public int K;
    public ValueAnimator K0;
    public final Runnable K1;
    public boolean L;
    public Runnable L0;
    public final BdUniDispatchSchemeController.b L1;
    public boolean M;
    public int M0;
    public final ko6 M1;
    public boolean N;
    public xn6 N0;
    public final View.OnTouchListener N1;
    public ia5 O;
    public fi6 O0;
    public final View.OnClickListener O1;
    public boolean P;
    @Nullable
    public TiePlusEventController P0;
    public final View.OnClickListener P1;
    public boolean Q;
    public int Q0;
    public final RecyclerView.OnScrollListener Q1;
    public String R;
    public int R0;
    public final pe6 R1;
    public oy.a S;
    public yq6 S0;
    public final NoNetworkView.b S1;
    public ThreadCardViewHolder T;
    public sh6 T0;
    public final CustomMessageListener T1;
    public FrsModelController U;
    public boolean U0;
    public yn U1;
    public tr6 V;
    public boolean V0;
    public dg6 V1;
    public FrsTabViewController W;
    public boolean W0;
    public CustomMessageListener W1;
    public ho6 X;
    public Object X0;
    public CustomMessageListener X1;
    public rp6 Y;
    public PollingModel Y0;
    public CustomMessageListener Y1;
    public bo6 Z;
    public boolean Z0;
    public CustomMessageListener Z1;
    public String a;
    public fg6 a0;
    public boolean a1;
    public CustomMessageListener a2;
    public li6 b;
    public SparseArray<fk5> b0;
    public boolean b1;
    public CustomMessageListener b2;
    public boolean c;
    public boolean c0;
    public int c1;
    public CustomMessageListener c2;
    public boolean d;
    public vj6 d0;
    public int d1;
    public CustomMessageListener d2;
    public boolean e;
    public mr6 e0;
    public MessageQueue.IdleHandler e1;
    public HttpMessageListener e2;
    public String f;
    public do6 f0;
    public final CustomMessageListener f1;
    public CustomMessageListener f2;
    public String g;
    public co6 g0;
    public CustomMessageListener g1;
    public zs6 g2;
    public int h;
    public vr6 h0;
    public CustomMessageListener h1;
    public boolean i;
    public ao6 i0;
    public CustomMessageListener i1;
    public boolean j;
    public wn6 j0;
    public CustomMessageListener j1;
    public String k;
    public ab k1;
    public String l;
    public CustomMessageListener l1;
    public int m;
    public final dg6 m1;
    public boolean n;
    public FrsTabViewController.o n1;
    public tk8 o;
    public int o1;
    public boolean p;
    public CustomMessageListener p1;
    public boolean q;
    public ze6 q0;
    public CustomMessageListener q1;
    public VoiceManager r;
    public or6 r0;
    public final CustomMessageListener r1;
    public View s;
    public as6 s0;
    public final CustomMessageListener s1;
    public af6 t;
    public qr6 t0;
    public final CustomMessageListener t1;
    public OvalActionButton u;
    public boolean u0;
    public final AntiHelper.k u1;
    public FRSRefreshButton v;
    public dm6 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public sk5 w0;
    public CustomMessageListener w1;
    public final ThreadData x;
    public cq5 x0;
    public CustomMessageListener x1;
    public FrsViewData y;
    public ei6 y0;
    public CustomMessageListener y1;
    public String z;
    public ur4 z0;
    public CustomMessageListener z1;

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
                    uz5.b().e(false);
                    this.a.a4(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.o1 = i;
                this.a.Q0 = i2;
                if (this.a.N0 != null) {
                    this.a.N0.d(this.a.Q0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.Q0);
                this.a.e5();
                xp6 xp6Var = zp6.p0;
                xp6Var.e = i;
                xp6Var.h = i2;
                xp6Var.f = -1;
                if (!this.a.C0) {
                    this.a.t.U1(this.a.a3(i));
                    return;
                }
                le6.f().p(i == 1 && this.a.C0, true);
                ke6 h = ke6.h();
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
                this.a.t.T1();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.t == null) {
                return;
            }
            this.a.t.V0();
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
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(FrsFragment frsFragment, int i) {
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
                        if (this.a.W.L() == 0 || this.a.t.I0() || z45.h().k()) {
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
            lr6.c(this.a.y, this.a.getPageContext());
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
                this.a.V.T(num);
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
    public class d0 implements hg6 {
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

        @Override // com.repackage.hg6
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.a.t == null) {
                return;
            }
            boolean z3 = false;
            if (i == 1) {
                this.a.t.y1(le6.f().h());
                this.a.t.z1(z ? 0 : 8);
            } else if (i == 2) {
                this.a.t.v1(z ? 0 : 8);
            }
            if (!z2) {
                this.a.C0 = z;
            }
            if (this.a.t.X() != null && (i == 2 || (this.a.U != null && this.a.U.X()))) {
                this.a.t.X().notifyDataSetChanged();
            }
            if (this.a.E3() != null) {
                FrsTabViewController.p C = this.a.E3().C();
                if (C != null) {
                    if ((C.b instanceof FrsCommonTabFragment) && (i == 2 || C.a == 502)) {
                        ((FrsCommonTabFragment) C.b).P1();
                    } else if ((C.b instanceof FrsNewAreaFragment) && (i == 2 || C.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) C.b;
                        frsNewAreaFragment.m2();
                        if (frsNewAreaFragment.X1() != null) {
                            go6 X1 = frsNewAreaFragment.X1();
                            X1.J(!z);
                            if (i == 1) {
                                X1.G(!z);
                            } else if (i == 2) {
                                X1.G(true);
                            }
                        }
                    } else {
                        Fragment fragment = C.b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).h2();
                        }
                    }
                }
                if (this.a.E3().N() != null) {
                    this.a.E3().N().setmDisallowSlip(z);
                    this.a.E3().i0(z);
                }
            }
            if (this.a.t.Z() != null) {
                af6 af6Var = this.a.t;
                if (this.a.Y2() && !z) {
                    z3 = true;
                }
                af6Var.U1(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.a.getActivity()).T0(!z);
            }
            if (this.a.y0 != null) {
                this.a.y0.f(!z);
            }
            this.a.t.E1(!z);
            if (i == 1) {
                this.a.t.u1(!z);
            } else if (i == 2) {
                this.a.t.u1(true);
            }
        }

        @Override // com.repackage.hg6
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
                bdTopToast.h(false);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0722));
                bdTopToast.i(this.a.t.o0());
                return;
            }
            qi.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f072d);
        }

        @Override // com.repackage.hg6
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.a.t == null) {
                return;
            }
            if (i2 == 1) {
                this.a.t.x1(i);
            } else if (i2 == 2) {
                this.a.t.w1(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveHorseRaceData a;
        public final /* synthetic */ FrsFragment b;

        public d1(FrsFragment frsFragment, LiveHorseRaceData liveHorseRaceData) {
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
                this.a.k3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements xk5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                    return;
                }
                ur4Var.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                    return;
                }
                ur4Var.dismiss();
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

        @Override // com.repackage.xk5.c
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
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(R.string.obfuscated_res_0x7f0f04b0);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.z0 = new ur4(frsFragment.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f04ec, new a(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.z0 = new ur4(frsFragment2.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f09a0, new b(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else {
                    this.a.t.P1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.i2(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.e3(deleteThreadHttpResponseMessage.getSuccessItems());
                le6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (on onVar : this.a.y.getThreadList()) {
                    if (onVar instanceof ir4) {
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
            qi.O(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements ValueAnimator.AnimatorUpdateListener {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ck8) || this.a.y == null) {
                return;
            }
            this.a.y.updateLikeData((ck8) customResponsedMessage.getData());
            this.a.V.W(this.a.y);
            this.a.W.d(this.a.y, this.a.U.U());
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements Animator.AnimatorListener {
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
                    this.b.N3();
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
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
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
                this.a.t.J0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public g1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
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
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.u1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().d) {
                    qi.N(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f02ba);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ h0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$h0$a$a  reason: collision with other inner class name */
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

            public a(h0 h0Var, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = h0Var;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.W.b(301);
                    rg.a().postDelayed(new RunnableC0206a(this, og.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L), qi.k(TbadkCoreApplication.getInst()), qi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
                }
            }
        }

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
            rg.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.y.getToLoadHorseData().intValue() == 1 && this.a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.a.l));
                this.a.sendMessage(liveHorseRaceRequestMessage);
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
    public class i0 implements ko6 {
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

        @Override // com.repackage.ko6
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<on> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.a.Y == null || this.a.U == null || !this.a.U.w0() || !z || z2 || z3) {
                return;
            }
            this.a.Y.a(i2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.a.F0 = (Date) customResponsedMessage.getData();
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
                this.a.t.S1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public j0(FrsFragment frsFragment) {
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
                    this.a.V.S(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gp4) && this.a.isResumed()) {
                gp4 gp4Var = (gp4) customResponsedMessage.getData();
                if (this.a.O0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.O0 = new fi6(frsFragment.getPageContext());
                }
                if (this.a.y == null || this.a.y.getForum() == null || TextUtils.isEmpty(this.a.y.getForum().getId())) {
                    return;
                }
                this.a.O0.g(gp4Var.a, this.a.y.getForum().getId(), this.a.y.getForum().getName(), gp4Var.b);
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
                this.a.m4();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrsFragment f;

        public k0(FrsFragment frsFragment, long j, int i, int i2, float f, int i3) {
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
    public class k1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public l0(FrsFragment frsFragment) {
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
                am8.o(this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l1 a;

            public a(l1 l1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l1Var;
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
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f06de));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f073e));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090ac4));
            }
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
                    this.a.t.b1(this.a.K, this.a.L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ FrsFragment b;

        public m0(FrsFragment frsFragment, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, ur4Var};
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
            this.a = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ur4 ur4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (ur4Var = this.a) == null) {
                return;
            }
            ur4Var.dismiss();
            this.b.N4();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            zk5 zk5Var = (zk5) customResponsedMessage.getData();
            if (this.a.y == null || this.a.y.getForum() == null || this.a.y.getForum().getDeletedReasonInfo() == null) {
                wk5.d(0, this.a.getPageContext(), zk5Var, null, this.a.y.getUserData());
                return;
            }
            al5 al5Var = new al5(this.a.y.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.y.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.y.forumRule != null ? this.a.y.forumRule.has_forum_rule.intValue() : 0);
            al5Var.i(this.a.y.getForum().getId(), this.a.y.getForum().getName());
            al5Var.h(this.a.y.getForum().getImage_url());
            al5Var.j(this.a.y.getForum().getUser_level());
            wk5.d(al5Var.f(), this.a.getPageContext(), zk5Var, al5Var, this.a.y.getUserData());
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
                bdTopToast.h(true);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0727));
                bdTopToast.i(this.a.t.o0());
                if (ke6.h().k(ke6.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.W != null && this.a.W.C() != null && (this.a.W.C().b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.C().b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.N1();
                    }
                    this.a.f3();
                    ke6.h().d();
                    for (on onVar : this.a.y.getThreadList()) {
                        if (onVar instanceof ir4) {
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
                ke6.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
            bdTopToast2.h(false);
            bdTopToast2.g(httpResponsedMessage.getErrorString());
            bdTopToast2.i(this.a.t.o0());
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements mn4 {
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

        @Override // com.repackage.mn4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    z45.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f065e));
                bdTopToast.i(this.a.t.o0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(FrsFragment frsFragment, int i) {
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
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.C() == null || !(this.a.W.C().b instanceof BaseFragment) || !((BaseFragment) this.a.W.C().b).isPrimary() || this.a.t.I0()) {
                this.a.w.setVisibility(8);
                this.a.J = true;
                return;
            }
            this.a.w.setVisibility(0);
            this.a.J = false;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends p75<TopToastEvent> {
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
        @Override // com.repackage.i75
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                bdTopToast.h(topToastEvent.isSuccess());
                bdTopToast.g(topToastEvent.getContent());
                bdTopToast.i(this.c.t.o0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements mn4 {
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

        @Override // com.repackage.mn4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                z45.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.u != null) {
                    this.a.u.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o1 extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(FrsFragment frsFragment, int i, int i2) {
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

        @Override // com.repackage.ab
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
                    this.a.N3();
                    return;
                }
                this.a.J0 = new ArrayList();
                this.a.I0 = 0;
                this.a.J0.addAll(arrayList);
                this.a.N3();
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
                this.a.d5();
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
                this.a.Y3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p1(FrsFragment frsFragment, int i) {
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
                this.a.k3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
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
                    this.a.t.i1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09063a);
                if (this.a.t != null && view2 == this.a.t.V() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090c43 && qi.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t == null || !this.a.t.E0()) {
                        String c = this.a.y.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            jm4.n(this.a.getPageContext().getPageActivity(), c);
                        }
                    } else {
                        this.a.t.K1();
                    }
                }
                if (this.a.t != null && view2 == this.a.t.e0() && this.a.U != null && this.a.U.hasMore()) {
                    this.a.t.N1();
                    this.a.b();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.f0()) {
                    this.a.Y3();
                }
                if (oi.z()) {
                    if (this.a.y == null || this.a.y.getForum() == null) {
                        return;
                    }
                    if (this.a.t != null && (view2 == this.a.t.u0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.y == null || this.a.y.getForum() == null || StringUtils.isNull(this.a.y.getForum().getId()) || StringUtils.isNull(this.a.y.getForum().getName())) {
                            return;
                        }
                        dp6.e(this.a.y.getForum().getId(), this.a.y.getForum().getName());
                        fr6.g(this.a.getPageContext(), this.a.y, this.a.y.getForum().getId(), this.a.K, this.a.L, this.a.O1);
                    }
                    if ((this.a.t == null || view2 != this.a.t.t0()) && logicField != LogicField.SEARCH_BTN) {
                        return;
                    }
                    StatisticItem param = new StatisticItem("c12402").param("fid", this.a.y.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.y.getForum().getName());
                    dp6.a(param);
                    TiebaStatic.log(param);
                    if (StringUtils.isNull(this.a.y.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.y.getForum().getName(), this.a.y.getForum().getId())));
                    return;
                }
                qi.N(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c3d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q1 implements dg6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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

        @Override // com.repackage.dg6
        public void a(int i, int i2, ng6 ng6Var, ArrayList<on> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ng6Var, arrayList}) == null) {
                this.a.U4();
                if (this.a.d0 != null) {
                    this.a.V.g0(this.a.d0.e(i));
                }
                jj8 jj8Var = new jj8();
                if (ng6Var != null) {
                    boolean z = ng6Var.e == 0;
                    jj8Var.b = z;
                    jj8Var.c = ng6Var.e;
                    jj8Var.d = ng6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.w0();
                        } else if (ng6Var.g) {
                            if (ListUtils.getCount(this.a.y.getThreadList()) > 3) {
                                this.a.t.N1();
                            } else {
                                this.a.t.J1();
                            }
                        } else if (ng6Var.i) {
                            this.a.t.Q1();
                        } else {
                            this.a.t.w0();
                        }
                    }
                } else {
                    ng6Var = new ng6();
                    ng6Var.c = 1;
                    ng6Var.g = false;
                    ng6Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.H1.d(frsFragment.U.getType(), false, jj8Var);
                } else {
                    this.a.T4(jj8Var);
                    if (this.a.U.g0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y = frsFragment2.U.g0();
                    }
                    this.a.j4();
                }
                if (this.a.V1 != null) {
                    this.a.V1.a(i, i2, ng6Var, arrayList);
                }
            }
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
                if (TbadkApplication.getInst().getCurrentActivity() == null || pi.isEmpty(str) || !str.equals(this.a.l)) {
                    return;
                }
                fr6.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.y);
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
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.L() == 0 || this.a.W.C() == null || !(this.a.W.C().b instanceof BaseFragment) || !((BaseFragment) this.a.W.C().b).isPrimary() || this.a.t.I0() || z45.h().k()) {
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
    public final class r1 implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(r1 r1Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r1Var, str};
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

        public r1(FrsFragment frsFragment) {
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

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == ef6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.V1();
                }
            } else if (onVar == null || !(onVar instanceof ir4)) {
            } else {
                ThreadData threadData = ((ir4) onVar).t;
                if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        if (threadData.getAppCodeData() != null) {
                            if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                                String a2 = threadData.getAppCodeData().a();
                                if (StringUtils.isNull(a2) || !qi.D()) {
                                    return;
                                }
                                jm4.n(this.a.getActivity(), a2);
                            }
                        } else if (threadData.getCartoonThreadData() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                                return;
                            }
                            ap4 cartoonThreadData = threadData.getCartoonThreadData();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                        } else {
                            dm8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                                ir6.c(threadData.getTaskInfoData());
                            } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", threadData.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                            jr6.f(this.a, threadData, i, z);
                            FrsFragment frsFragment = this.a;
                            ir6.d(frsFragment, frsFragment.y, threadData);
                        }
                    }
                }
            }
        }

        public /* synthetic */ r1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
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
    public class s0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ FrsFragment c;

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
            this.c = frsFragment;
            this.a = 0;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.c.V != null) {
                    this.c.V.r0(i);
                    if (i == 1) {
                        this.c.V.D();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.S3()) {
                    this.c.O = new ia5();
                    this.c.O.a(1000);
                }
                if (i != 0) {
                    if (this.c.X0 == null) {
                        this.c.X0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    ia5 ia5Var = this.c.O;
                    if (ia5Var != null) {
                        ia5Var.d();
                    }
                } else {
                    ia5 ia5Var2 = this.c.O;
                    if (ia5Var2 != null) {
                        ia5Var2.e();
                    }
                    uz5.b().e(true);
                    this.c.a4(true);
                    this.c.t.N0(this.a, this.b);
                    if (this.c.X0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.X0);
                        this.c.X0 = null;
                    }
                }
                if (this.c.t0 != null) {
                    this.c.t0.i(recyclerView, i);
                }
                if (i == 0) {
                    ir6.b(this.c.t, this.c.y, this.c.d(), false, null);
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
                    this.c.t.M0();
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
                this.c.t.j1(this.a, this.b);
                if (this.c.T == null || this.c.T.a() == null) {
                    return;
                }
                this.c.T.a().o(this.c.S);
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
                this.a.Q4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t0 implements pe6 {
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

        @Override // com.repackage.pe6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i != this.a.t.X().c()) {
                    if (i != this.a.t.X().j()) {
                        if (i != this.a.t.X().i() || this.a.y == null || this.a.y.getUserData() == null || !this.a.y.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.y.getBawuCenterUrl();
                        if (pi.isEmpty(bawuCenterUrl) || this.a.y.getForum() == null) {
                            return;
                        }
                        jm4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.y.getForum().getId()).param("uid", this.a.y.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.y == null || this.a.y.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.y.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), og.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    jr6.e(this.a.getPageContext(), this.a.y);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements yj8 {
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

        @Override // com.repackage.yj8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.b.t.K0();
                }
            }
        }

        @Override // com.repackage.yj8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.m4();
            }
        }

        @Override // com.repackage.yj8
        public void c(rj8 rj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj8Var) == null) {
                if ((rj8Var == null || !("normal_page".equals(this.b.U.c0()) || "frs_page".equals(this.b.U.c0()) || "book_page".equals(this.b.U.c0()))) && !"brand_page".equals(this.b.U.c0())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, rj8Var));
                this.b.n4(rj8Var);
                FrsFragment.i2 = rj8Var;
            }
        }

        @Override // com.repackage.yj8
        public void d(int i, boolean z, jj8 jj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), jj8Var}) == null) {
                if (this.b.c0) {
                    this.b.c0 = false;
                    ir6.b(this.b.t, this.b.y, this.b.d(), false, null);
                }
                this.b.U4();
                this.b.N = true;
                if (jj8Var != null && jj8Var.b) {
                    this.b.t.X().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.j2 = 0L;
                    FrsFragment.k2 = 0L;
                    FrsFragment.l2 = 0;
                } else {
                    FrsFragment.l2 = 1;
                }
                if (!this.b.U.w0() && (i == 3 || i == 6)) {
                    this.b.g0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.U.g0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.y = frsFragment.U.g0();
                }
                this.b.S4(1);
                this.b.K4();
                if (i == 7) {
                    this.b.l4(this.b.y.getFrsDefaultTabId());
                    return;
                }
                if (this.b.y.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.v4(frsFragment2.y.getPage().b());
                }
                if (i == 4) {
                    if (!this.b.U.w0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.U.e0() == 1 && (this.b.y.adShowSelect == 1 || this.b.y.adShowSelect == 3)) {
                        this.b.y.addRecommendAppToThreadList(this.b);
                    }
                    ArrayList<on> c = this.b.g0.c(false, false, this.b.y.getThreadList(), this.b.o, false, this.b.y.adShowSelect, this.b.y.adMixFloor);
                    if (c != null) {
                        this.b.y.setThreadList(c);
                        this.b.y.checkLiveStageInThreadList();
                    }
                    if (this.b.U != null) {
                        yp6.m(this.b.y, this.b.U.U(), 2, this.b.getContext());
                    }
                    FrsFragment frsFragment3 = this.b;
                    uq6.a(frsFragment3, frsFragment3.y.getForum(), this.b.y.getThreadList(), false, this.b.A3());
                    this.b.t.F1(c, this.b.y);
                    this.b.W4();
                    return;
                }
                this.b.W4();
                if (i == 1) {
                    this.b.t.K0();
                } else if (i == 2) {
                    this.b.t.K0();
                } else if (i == 3 || i == 6) {
                    if (this.b.y != null) {
                        this.b.y.clearPostThreadCount();
                    }
                    or6 or6Var = this.b.r0;
                    if (or6Var != null) {
                        or6Var.d();
                    }
                }
                this.b.c5();
                if (jj8Var == null || jj8Var.c == 0) {
                    if (this.b.y == null) {
                        return;
                    }
                    if (this.b.o() != null) {
                        FrsFragment frsFragment4 = this.b;
                        if (!frsFragment4.L4(frsFragment4.y, this.b.o())) {
                            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                            upgradePopWindowMessage.setFromPage("frs");
                            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                        }
                    }
                    this.b.h4(false, i == 5);
                    if (this.b.U != null) {
                        if (this.b.y.getActivityHeadData() != null && this.b.y.getActivityHeadData().b() != null && this.b.y.getActivityHeadData().b().size() > 0) {
                            wp6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.d0(), 1);
                        }
                        if (this.b.y.getThreadList() != null && this.b.y.getThreadList().size() > 0) {
                            Iterator<on> it = this.b.y.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                on next = it.next();
                                if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                    wp6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.d0(), 2);
                                    break;
                                }
                            }
                        }
                        wp6.i(this.b.getUniqueId(), this.b.y.getThreadList(), this.b.y.getForum(), this.b.U.d0());
                    }
                    this.b.t.W0(i);
                    FrsFragment.j2 = (System.nanoTime() - this.a) / 1000000;
                    if (jj8Var != null) {
                        FrsFragment.k2 = jj8Var.e;
                    }
                } else if (this.b.y == null || ListUtils.isEmpty(this.b.y.getThreadList())) {
                    this.b.T4(jj8Var);
                } else if (jj8Var.a) {
                    FrsFragment frsFragment5 = this.b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3b, jj8Var.d, Integer.valueOf(jj8Var.c)));
                }
                this.b.d3();
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
    public class u0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public u0(FrsFragment frsFragment) {
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
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.U.e0() == 1 && z && !this.a.t.b0()) {
                if (this.a.y != null && !ListUtils.isEmpty(this.a.y.getThreadList())) {
                    this.a.t.K0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.Y().m());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.o0(), true);
                this.a.t.x0(false);
                this.a.refresh();
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
                    ir6.b(this.a.t, this.a.y, this.a.d(), true, (ThreadData) data);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(FrsFragment frsFragment, int i) {
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
                wq6.a(customResponsedMessage, this.a.t, this.a.y);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ FrsFragment b;

        public w(FrsFragment frsFragment, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, ur4Var};
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
            this.a = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.obfuscated_res_0x7f090f6d)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.obfuscated_res_0x7f091a4d);
                UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{privateForumPopInfoData.D()});
                FrsFragment frsFragment = this.b;
                wp6.f(privateForumPopInfoData, booleanValue, frsFragment.l, frsFragment.f, true);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.W == null) {
                return;
            }
            FrsTabViewController.p C = this.a.W.C();
            if (C != null && (fragment = C.b) != null && (fragment instanceof ag6)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((ag6) C.b).o1();
                ((ag6) C.b).x();
                return;
            }
            this.a.k1().V1();
        }
    }

    /* loaded from: classes3.dex */
    public class x implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x0 implements dg6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x0 a;

            public a(x0 x0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = x0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.F0()) {
                    this.a.a.b();
                }
            }
        }

        public x0(FrsFragment frsFragment) {
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

        @Override // com.repackage.dg6
        public void a(int i, int i2, ng6 ng6Var, ArrayList<on> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ng6Var, arrayList}) == null) {
                rg.a().post(new a(this));
            }
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N || !oi.z() || this.a.t.H0()) {
                return;
            }
            this.a.t.Y0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.a.T == null && this.a.t.l0() != null && !this.a.t.b0() && this.a.t.l0().j() != null && (this.a.t.l0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.T = (ThreadCardViewHolder) frsFragment.t.l0().j().getTag();
                    }
                    if (this.a.T == null || this.a.T.a() == null) {
                        return;
                    }
                    this.a.T.a().o(new oy.a(3));
                }
            }
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
        this.S = new oy.a(2);
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
        this.e1 = new k(this);
        this.f1 = new v(this, 2016495);
        this.g1 = new g0(this, 2921005);
        this.h1 = new r0(this, 2921401);
        this.i1 = new c1(this, 2921473);
        this.j1 = new n1(this, 2921467);
        this.k1 = new o1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.l1 = new p1(this, 2001624);
        this.m1 = new q1(this);
        this.n1 = new a(this);
        this.p1 = new b(this, 2001606);
        this.q1 = new c(this, 2001607);
        this.r1 = new d(this, 2003019);
        this.s1 = new e(this, 2921470);
        this.t1 = new f(this, 2001352);
        this.u1 = new g(this);
        this.v1 = new h(this, 2001115);
        this.w1 = new i(this, 2921346);
        this.x1 = new j(this, 2001374);
        this.y1 = new l(this, 2001378);
        this.z1 = new m(this, 2001626);
        this.A1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.B1 = new o(this);
        this.C1 = new p(this, 2921391);
        this.D1 = new q(this, 2003020);
        this.E1 = new r(this, 2921463);
        this.F1 = new s(this, 2921587);
        this.G1 = new t(this, 2921588);
        this.H1 = new u(this);
        this.I1 = new b0(this, 2016485);
        this.J1 = new c0(this, 2001194);
        this.K1 = new f0(this);
        this.L1 = new h0(this);
        this.M1 = new i0(this);
        this.N1 = new j0(this);
        this.O1 = new p0(this);
        this.P1 = new q0(this);
        this.Q1 = new s0(this);
        this.R1 = new t0(this);
        this.S1 = new u0(this);
        this.T1 = new v0(this, 0);
        this.U1 = new r1(this, null);
        this.V1 = new x0(this);
        this.W1 = new y0(this, 2921033);
        this.X1 = new z0(this, 2921381);
        this.Y1 = new a1(this, 2921414);
        this.Z1 = new b1(this, 2921437);
        this.a2 = new h1(this, 2921462);
        this.b2 = new i1(this, 2001223);
        this.c2 = new j1(this, 2921469);
        this.d2 = new k1(this, 2921475);
        this.e2 = new l1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.f2 = new m1(this, 2921515);
    }

    public int A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            co6 co6Var = this.g0;
            if (co6Var == null) {
                return 1;
            }
            return co6Var.g();
        }
        return invokeV.intValue;
    }

    public void A4(boolean z2) {
        vr6 vr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) || (vr6Var = this.h0) == null) {
            return;
        }
        vr6Var.b0();
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.Y0 == null) {
                this.Y0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.Y0.L(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            rg.a().postDelayed(this.K1, 300000L);
        }
    }

    public void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) {
            this.E0 = z2;
        }
    }

    public View C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y == null) {
            return;
        }
        xp6 xp6Var = new xp6();
        if (this.y.needLog == 1) {
            xp6Var.a = true;
        } else {
            xp6Var.a = false;
        }
        if (this.y.getForum() != null) {
            xp6Var.c = this.y.getForum().getId();
            xp6Var.d = this.y.getForum().getName();
        }
        if (K0() != null) {
            xp6Var.b = K0().U();
        }
        xp6 xp6Var2 = zp6.p0;
        if (xp6Var2 != null) {
            xp6Var.e = xp6Var2.e;
            xp6Var.f = xp6Var2.f;
        }
        xn6 xn6Var = new xn6(xp6Var, getTbPageTag(), getUniqueId());
        this.N0 = xn6Var;
        xn6Var.d(this.Q0);
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

    @NonNull
    public final AbsDataRecorder.Scene D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i3 = this.d1;
            if (i3 == 14) {
                return AbsDataRecorder.Scene.FRS_NEW;
            }
            if (i3 == 13) {
                return AbsDataRecorder.Scene.FRS_HOT;
            }
            return AbsDataRecorder.Scene.FRS_HOT;
        }
        return (AbsDataRecorder.Scene) invokeV.objValue;
    }

    public void D4(boolean z2) {
        fg6 fg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) || (fg6Var = this.a0) == null) {
            return;
        }
        fg6Var.i(z2);
    }

    public FrsTabViewController E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.W : (FrsTabViewController) invokeV.objValue;
    }

    public void E4(int i3) {
        co6 co6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i3) == null) || (co6Var = this.g0) == null) {
            return;
        }
        co6Var.o(i3);
    }

    public final FrsTabInfoData F3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) && this.g2 == null) {
            zs6 a2 = zs6.a(z2);
            this.g2 = a2;
            co6 co6Var = this.g0;
            if (co6Var != null) {
                co6Var.m(a2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public fg<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (fg) invokeV.objValue;
    }

    public String G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final void G4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (frsViewData = this.y) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.X().setFromCDN(true);
        } else {
            this.t.X().setFromCDN(false);
        }
    }

    public OvalActionButton H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.u : (OvalActionButton) invokeV.objValue;
    }

    public void H4(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public FRSRefreshButton I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.v : (FRSRefreshButton) invokeV.objValue;
    }

    public void I4(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public int J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            co6 co6Var = this.g0;
            if (co6Var == null) {
                return -1;
            }
            return co6Var.h();
        }
        return invokeV.intValue;
    }

    public void J4(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new w0(this));
    }

    @Override // com.repackage.lo6
    public FrsModelController K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.U : (FrsModelController) invokeV.objValue;
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        qi.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
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

    public void L3() {
        tr6 tr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (tr6Var = this.V) == null) {
            return;
        }
        tr6Var.E();
    }

    public boolean L4(rj8 rj8Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, rj8Var, tbPageContext)) == null) {
            if (u3()) {
                return false;
            }
            if (rj8Var != null && rj8Var.getEntelechyTabInfo() != null && rj8Var.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : rj8Var.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && ru4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            if (rj8Var != null && rj8Var.getBusinessPromot() != null && !StringUtils.isNull(rj8Var.getBusinessPromot().p()) && rj8Var.getForum() != null) {
                boolean j3 = ar6.j(rj8Var.getBusinessPromot(), rj8Var.getForum().getId());
                this.V0 = j3;
                x4(j3);
                return this.V0;
            }
            sh6 sh6Var = new sh6(tbPageContext);
            this.T0 = sh6Var;
            boolean j4 = sh6Var.j(rj8Var);
            this.U0 = j4;
            x4(j4);
            return this.U0;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.gk5
    public void M(ek5 ek5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ek5Var) == null) {
            this.q0.a(ek5Var);
        }
    }

    @Override // com.repackage.bg6
    public NavigationBar M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            af6 af6Var = this.t;
            if (af6Var == null) {
                return null;
            }
            return af6Var.h0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void M3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setContentViewSize(2);
            ur4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new m0(this, ur4Var));
            ur4Var.setContentView(frsBroadcastCopyGuideDialogView);
            ur4Var.create(getPageContext()).show();
        }
    }

    public final void N3() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || !isResumed() || (list = this.J0) == null || list.size() < 1 || this.I0 > this.J0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.J0.get(this.I0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.I0++;
            N3();
        }
        if (this.w != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0f), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0f), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a0f), getResources().getString(R.string.obfuscated_res_0x7f0f070e));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new d1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.K0 = ofFloat;
            ofFloat.setDuration(600L);
            this.K0.addUpdateListener(new e1(this, frsRedpackRunView));
            this.K0.addListener(new f1(this, frsRedpackRunView));
            this.L0 = new g1(this, frsRedpackRunView);
            rg.a().postDelayed(this.L0, 5000L);
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
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.W.C().b).isPrimary() || this.t.I0() || this.J) {
                return;
            }
            this.w.setVisibility(0);
        }
    }

    public final void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            z45.h().m(new w45(getContext()));
            z45.h().n(85, 0, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (z45.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public final void O3(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            registerListener(2001118, this.T1);
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
                registerListener(2001120, this.T1);
            }
            this.V.L(bundle);
            h3(j3);
        }
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            z45.h().m(new x45(getContext()));
            z45.h().n(85, 0, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (z45.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    @Override // com.repackage.zn6
    public FrsViewData P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.y : (FrsViewData) invokeV.objValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.h == 0) {
                this.t.G1(this.f);
            } else {
                this.t.G1("");
                this.h = 1;
            }
            this.t.C1(this.U1);
            this.t.K(this.Q1);
            this.t.D1(this.S1);
            this.t.X().l(this.R1);
        }
    }

    public void P4(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.X0();
            this.t.m1(8);
            if (this.s0 == null) {
                this.s0 = new as6(getPageContext(), getNetRefreshListener());
            }
            this.s0.c(str);
            this.s0.b(list);
            this.s0.attachView(view2, z2);
        }
    }

    @Override // com.repackage.gk5
    public fk5 Q0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i3)) == null) ? this.b0.get(i3) : (fk5) invokeI.objValue;
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void Q4() {
        af6 af6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (af6Var = this.t) == null) {
            return;
        }
        af6Var.I1();
    }

    public final boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumPopInfo() == null;
        }
        return invokeV.booleanValue;
    }

    public void R4(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, str, str2, str3) == null) {
            yq6 yq6Var = new yq6(str, str2);
            this.S0 = yq6Var;
            yq6Var.f(getFragmentActivity(), str3, str2);
        }
    }

    public boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void S4(int i3) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i3) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.y) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            WindowToast windowToast = list.get(i4);
            if (windowToast != null && windowToast.toast_type.intValue() == i3) {
                if (pi.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", rf5.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public final void T4(jj8 jj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, jj8Var) == null) {
            if (jj8Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05b4);
                this.t.X0();
                showNetRefreshView(this.t.o0(), string, true);
            } else if (340001 == jj8Var.c) {
                Y4(jj8Var, this.y.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    X4(jj8Var);
                }
                if (S3()) {
                    setNetRefreshViewEmotionMarginTop(qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070292));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    @Override // com.repackage.wb8
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final void U2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.U) == null || this.y == null || this.t == null || !z2) {
            return;
        }
        if (!frsModelController.w0() && this.U.e0() == 1) {
            if (!this.U.t0()) {
                this.y.addCardVideoInfoToThreadList();
                this.y.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.t.X().k(r06.g) ? this.y.addHotTopicDataToThreadList() : false)) {
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
        if (this.t.X().k(jt6.e)) {
            this.y.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.U.w0() || this.U.isNetFirstLoad)) {
            this.y.addUserRecommendToThreadList();
        }
        this.y.addVideoActivityToTop();
    }

    public boolean U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            hideLoadingView(this.t.o0());
            this.t.X1();
            if (this.t.n0() instanceof dq6) {
                ((dq6) this.t.n0()).d();
            }
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                W2(frsModelController.c0());
            } else {
                W2("normal_page");
            }
        }
    }

    public final boolean V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (P0() == null) {
                return false;
            }
            FrsViewData P0 = P0();
            hp4 hp4Var = null;
            if (P0.getStar() != null && !StringUtils.isNull(P0.getStar().a())) {
                hp4Var = new hp4();
            } else if (P0.getActivityHeadData() != null && ListUtils.getCount(P0.getActivityHeadData().b()) >= 1) {
                hp4Var = P0.getActivityHeadData().b().get(0);
            }
            return hp4Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (J3() != 1 && !this.g0.b(this.y.getThreadListIds())) {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    this.t.w0();
                } else {
                    this.t.Q1();
                }
            } else if (ListUtils.getCount(this.y.getThreadList()) > 3) {
                this.t.N1();
            } else {
                this.t.J1();
            }
        }
    }

    @Override // com.repackage.yf6
    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && isAdded() && this.c0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.o0());
        }
    }

    public final void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            A4("frs_page".equals(str));
            vj6 vj6Var = this.d0;
            if (vj6Var != null) {
                vj6Var.c(this.V, this.t, this.y);
            }
        }
    }

    public boolean W3() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (J3() == 0 && ListUtils.isEmpty(this.y.getThreadListIds())) {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    this.t.w0();
                } else {
                    this.t.Q1();
                }
            } else if (ListUtils.getCount(this.y.getThreadList()) > 3) {
                this.t.N1();
            } else {
                this.t.J1();
            }
        }
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (P0() == null) {
                return false;
            }
            FrsViewData P0 = P0();
            return (ListUtils.isEmpty(P0.getShowTopThreadList()) && P0.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void X4(jj8 jj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, jj8Var) == null) {
            this.t.X0();
            if (jj8Var.a) {
                showNetRefreshView(this.t.o0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3b, new Object[]{jj8Var.d, Integer.valueOf(jj8Var.c)}), true);
            } else {
                showNetRefreshView(this.t.Y().m(), jj8Var.d, true);
            }
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? Z2(this.o1) : invokeV.booleanValue;
    }

    public final void Y3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && ViewHelper.checkUpIsLogin(getContext())) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            dp6.a(param);
            dp6.b(param, d(), c());
            TiebaStatic.log(param);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.K).param("obj_type", this.K > 0 ? 1 : 2).param("obj_source", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public final void Y4(jj8 jj8Var, List<RecmForumInfo> list) {
        af6 af6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048638, this, jj8Var, list) == null) || (af6Var = this.t) == null) {
            return;
        }
        af6Var.X0();
        this.t.G1(this.f);
        if (this.t.Y() != null) {
            P4(this.t.o0(), jj8Var.d, true, list);
        }
        this.t.g0().f(true);
    }

    public boolean Z2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i3)) == null) {
            if (this.Q && !this.E0 && a3(i3)) {
                FrsModelController frsModelController = this.U;
                return (frsModelController != null && frsModelController.X() && (le6.f().i() || ke6.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void Z3(Object obj) {
        bo6 bo6Var;
        c9 c9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, obj) == null) || (bo6Var = this.Z) == null || (c9Var = bo6Var.j) == null) {
            return;
        }
        c9Var.c(obj);
    }

    public boolean Z4(rj8 rj8Var) {
        InterceptResult invokeL;
        boolean b2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, rj8Var)) == null) {
            this.y.receiveData(rj8Var);
            if (this.y.getForum() != null) {
                this.f = this.y.getForum().getName();
                this.l = this.y.getForum().getId();
            }
            if (b3() && R3()) {
                return false;
            }
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.E(this.y.getPrivateForumTotalInfo().c());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            PrivateForumInfo a2 = this.y.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (pi.isEmpty(privateForumPopInfoData.C()) || privateForumPopInfoData.B() != og.e(this.l, 0))) {
                privateForumPopInfoData.H("create_success");
                privateForumPopInfoData.I(String.format("https://tieba.baidu.com/mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1", this.l, this.f));
                privateForumPopInfoData.G(og.e(this.l, -1));
                privateForumPopInfoData.setTitle(getString(R.string.obfuscated_res_0x7f0f145a));
                privateForumPopInfoData.F(getString(R.string.obfuscated_res_0x7f0f145b));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, false);
            } else {
                b2 = privateForumPopInfoData.B() == og.e(this.l, 0) ? frsPrivateCommonDialogView.b(privateForumPopInfoData, false) : false;
            }
            if (b2 || (privateForumPopInfoData = this.y.getPrivateForumPopInfo()) == null || privateForumPopInfoData.B() != og.e(this.l, 0)) {
                z2 = false;
            } else {
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, true);
                z2 = true;
            }
            if (b2) {
                ur4 ur4Var = new ur4(getActivity());
                ur4Var.setContentViewSize(10);
                ur4Var.setContentView(frsPrivateCommonDialogView);
                ur4Var.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new w(this, ur4Var));
                ur4Var.setCloseButton(new x(this));
                ur4Var.create(getPageContext()).show();
                wp6.f(privateForumPopInfoData, z2, this.l, this.f, false);
                x4(true);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.lo6
    public co6 a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.g0 : (co6) invokeV.objValue;
    }

    public final boolean a3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i3)) == null) ? i3 != 506 : invokeI.booleanValue;
    }

    public void a4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            dj8.g().h(getUniqueId(), z2);
        }
    }

    public void a5() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    @Override // com.repackage.lo6
    public void b() {
        co6 co6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (co6Var = this.g0) == null) {
            return;
        }
        co6Var.i(this.f, this.l, this.y);
    }

    @Override // com.repackage.yf6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.y.getPrivateForumTotalInfo().a() == null || this.y.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? V3() && !X3() : invokeV.booleanValue;
    }

    public void b5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i(this.t.o0());
        }
    }

    @Override // com.repackage.zn6, com.repackage.eg6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    @Override // com.repackage.wb8
    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            co6 co6Var = this.g0;
            if (co6Var == null) {
                return 1;
            }
            return co6Var.g();
        }
        return invokeV.intValue;
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            jr6.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.g);
        }
    }

    public final void c4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (frsViewData = this.y) == null || frsViewData.getForum() == null) {
            return;
        }
        String id = this.y.getForum().getId();
        String name = this.y.getForum().getName();
        String image_url = this.y.getForum().getImage_url();
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        boolean equals = "showlive".equals(this.y.getForum().special_forum_type);
        ThemeColorInfo themeColorInfo = this.y.getForum().getThemeColorInfo();
        int member_num = this.y.getForum().getMember_num();
        FrsViewData frsViewData2 = this.y;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(id, name, image_url, valueOf, equals, themeColorInfo, member_num, frsViewData2.forumTagInfo, frsViewData2.firstCategory)));
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (this.y.getForum().getYuleData() != null && this.y.getForum().getYuleData().a()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                    this.t.L1(this.y.getForum().getYuleData().b());
                    return;
                }
                this.t.v0();
                return;
            }
            this.t.v0();
        }
    }

    @Override // com.repackage.eg6
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (!b3() && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                w4(this.y.getPrivateForumTotalInfo().a().private_forum_audit_status, this.y.getPrivateForumTotalInfo().b(), false);
            } else {
                w4(null, null, true);
            }
        }
    }

    public boolean d4(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048658, this, i3, keyEvent)) == null) {
            if (i3 != 4) {
                if (i3 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (le6.f().i()) {
                le6.f().m();
                return true;
            } else if (ke6.h().j()) {
                af6 af6Var = this.t;
                if (af6Var != null && af6Var.G0()) {
                    this.t.d1();
                    return true;
                }
                ke6.h().n();
                return true;
            } else {
                af6 af6Var2 = this.t;
                if (af6Var2 != null) {
                    return af6Var2.R0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public final void d5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || pi.isEmpty(this.l)) {
            return;
        }
        dj4.w().O(cj4.a0, og.g(this.l, 0L));
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void e3(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<on> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.t.d0() == null || this.t.d0().getData() == null) {
            return;
        }
        Iterator<on> it = threadList.iterator();
        List<on> data = this.t.d0().getData();
        int i3 = 0;
        while (it.hasNext()) {
            on next = it.next();
            if (next instanceof ir4) {
                ThreadData threadData = ((ir4) next).t;
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

    public void e4(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, intent) == null) || intent == null) {
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
            k3();
        }
    }

    public void e5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || (voiceManager = this.r) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        U4();
        this.t.K0();
        jj8 V = this.U.V();
        boolean isEmpty = ListUtils.isEmpty(this.y.getThreadList());
        if (V != null && isEmpty) {
            if (this.U.Y() != 0) {
                this.U.S0();
                this.t.K0();
            } else {
                T4(V);
            }
            this.t.o1(this.y.isStarForum(), false);
            return;
        }
        T4(V);
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || ListUtils.isEmpty(ke6.h().i()) || this.t.d0() == null || this.t.d0().getData() == null) {
            return;
        }
        ArrayList<on> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<on> it = threadList.iterator();
        List<on> data = this.t.d0().getData();
        int count = ListUtils.getCount(ke6.h().i());
        int i3 = 0;
        while (it.hasNext()) {
            on next = it.next();
            if (next instanceof ir4) {
                ThreadData threadData = ((ir4) next).t;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    } else if (StringHelper.equals(ke6.h().i().get(i4).getId(), threadData.getId())) {
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

    public void f4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, str) == null) && TbadkCoreApplication.isLogin() && !pi.isEmpty(str)) {
            if (this.B0 == null) {
                this.B0 = new AddExperiencedModel(o());
            }
            this.B0.D(this.l, str);
        }
    }

    public void f5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public final void g3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i3) == null) {
            FrsViewData frsViewData = this.y;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.y.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            if (this.h == 1) {
                ug.a().b(new l0(this));
            }
            this.h = 0;
        }
    }

    public void g5(Object obj) {
        bo6 bo6Var;
        c9 c9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, obj) == null) || (bo6Var = this.Z) == null || (c9Var = bo6Var.i) == null) {
            return;
        }
        c9Var.c(obj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.zn6
    public /* bridge */ /* synthetic */ d9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.p C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (E3() != null && (C = E3().C()) != null) {
                Fragment fragment = C.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.y;
                        tbPageTag.sortType = hr6.g(frsViewData != null ? frsViewData.getSortType() : -1);
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
    public void h(ArrayList<on> arrayList) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            v4(!isEmpty ? 1 : 0);
            V4();
            if (isEmpty) {
                return;
            }
            if (xl5.k().l(D3())) {
                xl5.k().g(D3()).b();
            }
            if (!this.U.w0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.e0() == 1 && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                wp6.i(getUniqueId(), arrayList, this.y.getForum(), this.U.d0());
            }
            co6 co6Var = this.g0;
            tk8 tk8Var = this.o;
            FrsViewData frsViewData = this.y;
            ArrayList<on> c2 = co6Var.c(false, false, arrayList, tk8Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.y.setThreadList(c2);
                this.t.F1(c2, this.y);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                yp6.m(this.y, frsModelController.U(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.y.getForum()));
        }
    }

    public final void h3(long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048674, this, j3) == null) || j3 <= 0) {
            return;
        }
        rg.a().postDelayed(new k0(this, j3, qi.k(TbadkCoreApplication.getInst()), qi.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public final void h4(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048675, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.y != null && this.W != null && this.U != null) {
                    if (!this.t.X().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.y.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.y.getGameTabInfo());
                    this.t.r1(isEmpty);
                    if (!isEmpty) {
                        if (this.t0 == null) {
                            this.t0 = new qr6(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.v0 == null) {
                            this.v0 = new dm6(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                        this.W.d(this.y, this.U.U());
                    }
                    if (z2) {
                        U2(true, z2);
                    } else {
                        U2(this.P, z2);
                    }
                    k4();
                    if (this.d0 != null) {
                        this.d0.a(this.V, this.y);
                    }
                    if (this.y.getPage() != null) {
                        v4(this.y.getPage().b());
                    }
                    ArrayList<on> d2 = this.g0.d(z3, true, this.y.getThreadList(), null, z2, false, this.y.adShowSelect, this.y.adMixFloor);
                    if (d2 != null) {
                        this.y.setThreadList(d2);
                    }
                    this.y.removeRedundantUserRecommendData();
                    int topThreadSize = this.y.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        uq6.a(this, this.y.getForum(), this.y.getThreadList(), this.n, A3());
                    }
                    if (this.U.e0() == 1) {
                        j4();
                        if (!z2 && this.U.getPn() == 1) {
                            o4();
                        }
                    }
                    if (this.e0 != null) {
                        this.e0.k(this.W.H());
                    }
                    U4();
                    this.t.f1();
                    this.t.o1(true, false);
                    if (z2 && this.y.isFirstTabEqualAllThread()) {
                        rg.a().post(new z(this));
                    }
                    if (this.y.getForum() != null) {
                        this.t.O(this.y.getForum().getWarningMsg());
                    }
                    if (this.y != null && this.y.getFrsVideoActivityData() != null && ru4.k().m("frs_video_activity_guide", 0L) == 0) {
                        rg.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.H1();
                    c4();
                    this.y0.e(this.y.bottomMenuList, this.y.getForum());
                    d5();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void h5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i3) == null) {
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
                    lr6.a(this, 0);
                } else {
                    this.t.R1();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, view2) == null) {
            this.t.m1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).U0(view2, false);
            this.t.g0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.m1(0);
            this.t.g0().f(false);
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(o3()) && !this.A0) {
            int l3 = ru4.k().l("key_forum_broadcast_edit_tip_number", 0);
            if (l3 < 2) {
                ru4.k().w("key_forum_broadcast_edit_tip_number", l3 + 1);
                M4();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    N4();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(getContext());
                bdTopToast.h(false);
                bdTopToast.g(getContext().getString(R.string.obfuscated_res_0x7f0f065e));
                bdTopToast.i(this.t.o0());
            } else {
                N4();
            }
        }
    }

    public void i4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i3) == null) {
            this.N = false;
            e5();
            af6 af6Var = this.t;
            if (af6Var != null && af6Var.l0() != null) {
                this.t.l0().x();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.J0(i3, true);
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(o3()) && !this.A0) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    O4();
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !ru4.k().h("key_forum_rule_dialog_show_frs", false)) {
                    O4();
                    ru4.k().u("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            O4();
        }
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            e5();
            try {
                if (this.y == null) {
                    return;
                }
                this.t.M1();
                this.t.U1(Y2());
                if (this.y.getForum() != null) {
                    this.f = this.y.getForum().getName();
                    this.l = this.y.getForum().getId();
                }
                if (this.y.getPage() != null) {
                    v4(this.y.getPage().b());
                }
                this.t.G1(this.f);
                this.t.l1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.y.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.y.getUserData().getBimg_end_time());
                g4();
                G4();
                ArrayList<on> threadList = this.y.getThreadList();
                if (threadList != null) {
                    this.t.F1(threadList, this.y);
                    wq6.b(this.t);
                    this.V.q0(c1());
                    this.y.setFrsFragmentTag(getUniqueId());
                    this.V.W(this.y);
                    this.W.d(this.y, this.U.U());
                    this.t.g1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.lo6
    public af6 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.t : (af6) invokeV.objValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.t.V1();
        }
    }

    public boolean k4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            tr6 tr6Var = this.V;
            if (tr6Var != null && (frsModelController = this.U) != null) {
                tr6Var.v0(frsModelController.c0(), this.y);
            }
            FrsViewData frsViewData2 = this.y;
            boolean hasTab = frsViewData2 != null ? frsViewData2.hasTab() : false;
            V2();
            af6 af6Var = this.t;
            if (af6Var != null) {
                af6Var.A0();
                this.t.B0();
                FrsViewData frsViewData3 = this.y;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.V0 = ar6.j(this.y.getBusinessPromot(), this.y.getForum().getId());
                }
                if (!this.V0 && (frsViewData = this.y) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.z0(this.y.getActivityHeadData().a());
                    if (this.y.getActivityHeadData().a() != null && !this.U0 && !this.V0 && !this.W0 && !u3()) {
                        Q4();
                    }
                } else {
                    this.t.z0(null);
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    public vj6 l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.d0 : (vj6) invokeV.objValue;
    }

    public final void l4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i3) == null) {
            k4();
            e5();
            try {
                if (this.y == null) {
                    return;
                }
                jg6 jg6Var = null;
                this.t.F1(null, this.y);
                this.V.q0(1);
                this.t.g1();
                this.W.d(this.y, this.U.U());
                eq6 K = this.W.K(this.y.getFrsDefaultTabId());
                if (K != null && !TextUtils.isEmpty(K.d)) {
                    jg6Var = new jg6();
                    String str = K.d;
                    String str2 = K.a;
                }
                this.U.t(this.y.getFrsDefaultTabId(), 0, jg6Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.wb8
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            K0().V0();
        }
    }

    public final void m3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048689, this, intent) == null) || intent == null) {
            return;
        }
        if (!gr6.a(this, c(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
            BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.L1);
        } else {
            br6 b2 = jr6.b(intent);
            if (b2 != null) {
                this.f = b2.a;
            }
        }
        if (!StringUtils.isNull(this.f)) {
            intent.putExtra("name", this.f);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void m4() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (frsModelController = this.U) != null && frsModelController.e0() == 1) {
            this.V.a0(this.y);
        }
    }

    public ForumWriteData n3() {
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
            forumWriteData.frsTabInfo = F3();
            FrsViewData frsViewData2 = this.y;
            forumWriteData.forumTagInfo = frsViewData2.forumTagInfo;
            forumWriteData.firstCategory = frsViewData2.firstCategory;
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public final void n4(rj8 rj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, rj8Var) == null) {
            try {
                if (!this.N && rj8Var != null && this.y != null) {
                    this.y.receiveData(rj8Var);
                    h4(true, false);
                    Looper.myQueue().addIdleHandler(this.e1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.repackage.wb8
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.repackage.lo6
    public tr6 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.V : (tr6) invokeV.objValue;
    }

    public String o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            if (this.j0 == null) {
                this.j0 = new wn6(this, og.e(this.l, 0));
            }
            this.j0.w();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                m3(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new tk8("frs", tk8.c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.H1);
                this.U = frsModelController;
                frsModelController.w(this.m1);
                this.U.init();
            }
            this.U.T0(this.z);
            ArrayList<on> arrayList = null;
            if (intent != null) {
                this.U.m0(intent.getExtras());
            } else if (bundle != null) {
                this.U.m0(bundle);
            } else {
                this.U.m0(null);
            }
            if (intent != null) {
                this.V.L(intent.getExtras());
            } else if (bundle != null) {
                this.V.L(bundle);
            } else {
                this.V.L(null);
            }
            this.r = t0();
            this.q0 = new ze6(getPageContext(), this);
            P3();
            O3(bundle);
            if (!S3()) {
                fg6 fg6Var = new fg6(getActivity(), this.t, this.V);
                this.a0 = fg6Var;
                fg6Var.i(true);
            }
            VoiceManager t02 = t0();
            this.r = t02;
            if (t02 != null) {
                t02.onCreate(getPageContext());
            }
            i3();
            j3();
            if (z45.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new io6();
            int i3 = -1;
            co6 co6Var = this.g0;
            if (co6Var != null && co6Var.f() != null) {
                i3 = this.g0.f().D();
                arrayList = this.g0.f().C();
            }
            co6 co6Var2 = new co6(this, this.M1);
            this.g0 = co6Var2;
            co6Var2.f().setHasMore(i3);
            if (arrayList != null && arrayList.size() > 0) {
                this.g0.f().N(arrayList);
            }
            this.Y = new rp6(this);
            this.h0 = new vr6(this);
            this.e0 = new mr6(getPageContext(), this.U.r0());
            this.Z = new bo6(this);
            this.f0 = new do6(this);
            this.X = new ho6(this);
            this.i0 = new ao6(this);
            this.r0 = new or6(this);
            new eo6(this, getUniqueId());
            this.w0 = new sk5(getPageContext(), "frs");
            this.x0 = new cq5(getPageContext());
            new vp6(getPageContext());
            registerListener(this.v1);
            registerListener(this.J1);
            registerListener(this.t1);
            registerListener(this.I1);
            registerListener(this.p1);
            registerListener(this.q1);
            registerListener(this.r1);
            registerListener(this.s1);
            registerListener(this.f1);
            registerListener(this.g1);
            registerListener(this.h1);
            registerListener(this.i1);
            registerListener(this.W1);
            registerListener(this.x1);
            this.y1.setSelfListener(true);
            this.y1.setTag(getPageContext().getUniqueId());
            registerListener(this.y1);
            registerListener(this.l1);
            registerListener(this.z1);
            registerListener(this.w1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.E1);
            this.X1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.k1);
            registerListener(this.b2);
            registerListener(this.A1);
            registerListener(this.j1);
            registerListener(this.c2);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.F1);
            registerListener(this.G1);
            this.t.x0(false);
            if (!S3() && !this.A0) {
                showLoadingView(this.t.o0(), true);
                this.U.S(3, false);
            }
            B3();
            us6.a();
            d0 d0Var = new d0(this);
            le6.f().s(d0Var);
            ke6.h().s(d0Var);
            this.t.A1(new e0(this));
            this.G0 = UtilHelper.getScreenHeight(getActivity());
            this.A0 = true;
            g3(1);
            super.onActivityCreated(bundle);
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048698, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            ao6 ao6Var = this.i0;
            if (ao6Var != null) {
                ao6Var.n(i3, i4, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i3) == null) {
            super.onChangeSkinType(i3);
            if (this.D0) {
                this.t.P0(i3);
                this.V.O(i3);
                this.W.X(i3);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i3);
                }
                as6 as6Var = this.s0;
                if (as6Var != null) {
                    as6Var.onChangeSkinType();
                }
                ei6 ei6Var = this.y0;
                if (ei6Var != null) {
                    ei6Var.d(getPageContext(), i3);
                }
                if (this.z0 != null) {
                    fb5.a(getPageContext(), this.z0.getRealView());
                }
                qr6 qr6Var = this.t0;
                if (qr6Var != null) {
                    qr6Var.onChangeSkinType(getPageContext(), i3);
                }
                sh6 sh6Var = this.T0;
                if (sh6Var != null) {
                    sh6Var.onChangeSkinType(getPageContext(), i3);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, bundle) == null) {
            super.onCreate(bundle);
            dj8.g().i(getUniqueId());
            if (this.P0 == null) {
                this.P0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.P0);
            registerResponsedEventListener(TopToastEvent.class, this.B1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048701, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02eb, viewGroup, false);
                li6 li6Var = new li6();
                this.b = li6Var;
                this.d0 = li6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0753);
                this.V = new tr6(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090d3c));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.P1);
                this.W = frsTabViewController;
                frsTabViewController.c0();
                this.V.s0(this.W);
                this.W.g0(this.n1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.d = true;
                }
                this.t = new af6(this, this.P1, this.b, this.d, this.V);
                this.y0 = new ei6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.c0();
                }
                this.t.Z0();
                this.s.setLeft(0);
                this.s.setRight(qi.k(TbadkCoreApplication.getInst().getContext()));
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
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            dj8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.y1);
            unRegisterResponsedEventListener();
            this.h0.Z();
            i2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            kd8.c("FRS");
            this.r = null;
            uz5.b().e(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null) {
                rf6.a().b(og.g(this.y.getForum().getId(), 0L));
            }
            wn6 wn6Var = this.j0;
            if (wn6Var != null) {
                wn6Var.v();
            }
            af6 af6Var = this.t;
            if (af6Var != null) {
                ir6.b(af6Var, this.y, d(), false, null);
                this.t.Q0();
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
                rg.a().removeCallbacks(this.L0);
            }
            if (this.K1 != null) {
                rg.a().removeCallbacks(this.K1);
            }
            this.J0 = null;
            le6.f().s(null);
            ke6.h().s(null);
            super.onDestroy();
            try {
                if (this.O != null) {
                    this.O.c();
                }
                if (this.t != null) {
                    this.t.c1();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.V.M();
            Looper.myQueue().removeIdleHandler(this.e1);
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.j();
            }
            fg6 fg6Var = this.a0;
            if (fg6Var != null) {
                fg6Var.d();
            }
            mr6 mr6Var = this.e0;
            if (mr6Var != null) {
                mr6Var.i();
            }
            rp6 rp6Var = this.Y;
            if (rp6Var != null) {
                rp6Var.c();
            }
            qr6 qr6Var = this.t0;
            if (qr6Var != null) {
                qr6Var.g();
            }
            ao6 ao6Var = this.i0;
            if (ao6Var != null) {
                ao6Var.o();
            }
            sk5 sk5Var = this.w0;
            if (sk5Var != null) {
                sk5Var.h();
            }
            cq5 cq5Var = this.x0;
            if (cq5Var != null) {
                cq5Var.g();
            }
            id8.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.g0(null);
                this.W.P();
            }
            AddExperiencedModel addExperiencedModel = this.B0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            yq6 yq6Var = this.S0;
            if (yq6Var != null) {
                yq6Var.d();
            }
            if (this.P0 != null) {
                getLifecycle().removeObserver(this.P0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, str) == null) {
            V4();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public sn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? y3().getPreLoadHandle() : (sn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && S3()) {
            showLoadingView(this.t.o0(), true);
            this.t.B1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.J0(3, true);
            y3().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && qi.D()) {
            hideNetRefreshView(this.t.Y().m());
            showLoadingView(this.t.o0(), true);
            this.t.x0(false);
            this.U.J0(3, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            super.onPause();
            this.X.f(false);
            this.P = false;
            this.t.S0();
            tr6 tr6Var = this.V;
            if (tr6Var != null) {
                tr6Var.P();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.L0(true);
            mr6 mr6Var = this.e0;
            if (mr6Var != null) {
                mr6Var.j();
            }
            dj4.w().E();
            yq6 yq6Var = this.S0;
            if (yq6Var != null) {
                yq6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                tr6 tr6Var = this.V;
                if (tr6Var != null) {
                    tr6Var.Q(isPrimary());
                }
                af6 af6Var = this.t;
                if (af6Var != null) {
                    af6Var.T0(isPrimary());
                    this.t.L0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048709, this, i3, strArr, iArr) == null) {
            jr6.i(this, i3, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onResume();
            int i3 = this.c1;
            if (i3 <= 1) {
                this.c1 = i3 + 1;
            }
            af6 af6Var = this.t;
            if (af6Var != null) {
                af6Var.K0();
                this.t.U0();
            }
            tr6 tr6Var = this.V;
            if (tr6Var != null) {
                tr6Var.R();
            }
            if (this.c1 > 1 && v3()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                y4(false);
            }
            this.X.f(true);
            this.P = true;
            if (h2) {
                h2 = false;
                af6 af6Var2 = this.t;
                if (af6Var2 != null) {
                    af6Var2.V1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            af6 af6Var3 = this.t;
            if (af6Var3 != null) {
                af6Var3.L0(false);
            }
            if (this.u0) {
                i4(6);
                this.u0 = false;
            }
            if (this.F0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    oz4.c().h(true, this.F0.getHours(), this.F0.getMinutes());
                    if (this.t != null) {
                        oz4.c().j(o().getPageActivity(), this.t.o0());
                    }
                }
                this.F0 = null;
            }
            d5();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.U.H0(bundle);
            if (this.r == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            this.r.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            this.t.d0().stopScroll();
            if (this.t.e1()) {
                return;
            }
            if (!qi.D()) {
                this.t.w0();
            } else if (this.U.e0() == 1) {
                V4();
                b();
            } else if (this.U.hasMore()) {
                b();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onStart();
            VoiceManager t02 = t0();
            this.r = t02;
            if (t02 != null) {
                t02.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            super.onStop();
            uz5.b().e(false);
            a4(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                x15.j().x(getPageContext().getPageActivity(), "frs", this.y.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (y3() != null) {
                y3().getRecycledViewPool().clear();
            }
            this.V.N();
            ze5.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    @Override // com.repackage.gk5
    public void p0(int i3, fk5 fk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048716, this, i3, fk5Var) == null) {
            this.b0.put(i3, fk5Var);
        }
    }

    public yn p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.U1 : (yn) invokeV.objValue;
    }

    public void p4(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || (frsTabViewController = this.W) == null) {
            return;
        }
        frsTabViewController.v = z2;
    }

    public int q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.R0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.R0;
        }
        return invokeV.intValue;
    }

    public void q4() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.p C;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048720, this) == null) || (frsTabViewController = this.W) == null || (C = frsTabViewController.C()) == null || (fragment = C.b) == null || !(fragment instanceof ag6)) {
            return;
        }
        ((ag6) fragment).o1();
    }

    public int r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? jr6.c(this.y, this.t) : invokeV.intValue;
    }

    public void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z2) == null) {
            this.e = z2;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            nl5.c().f("page_frs");
            i4(3);
        }
    }

    public do6 s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.f0 : (do6) invokeV.objValue;
    }

    public void s4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i3) == null) {
            this.d1 = i3;
            if (i3 == 13) {
                this.t.k1("frs_hot_tab");
            }
            if (i3 == 14) {
                this.t.k1("frs_new_tab");
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.g = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeLZ(1048728, this, view2, z2) == null) {
            this.t.m1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).U0(view2, true);
            this.t.g0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048729, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.obfuscated_res_0x7f0f0fb9), null, getResources().getString(R.string.obfuscated_res_0x7f0f0fb8), z2, getNetRefreshListener());
            this.t.m1(8);
            this.t.g0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048730, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.m1(8);
        }
    }

    @Override // com.repackage.yf6
    public void t() {
        af6 af6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048731, this) == null) || (af6Var = this.t) == null) {
            return;
        }
        af6Var.d0().scrollToPosition(0);
        this.t.V1();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
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

    public rp6 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.Y : (rp6) invokeV.objValue;
    }

    public void t4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048734, this, i3) == null) {
            this.h = i3;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public void u4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, str) == null) {
            this.f = str;
        }
    }

    public boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public void v4(int i3) {
        co6 co6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048739, this, i3) == null) || (co6Var = this.g0) == null) {
            return;
        }
        co6Var.n(i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? of5.a(2) : invokeV.booleanValue;
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.t.b0() : invokeV.booleanValue;
    }

    @SuppressLint({"StringFormatInvalid"})
    public void w4(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048742, this, num, num2, z2) == null) || this.t.m0() == null) {
            return;
        }
        TextView m02 = this.t.m0();
        if (z2) {
            m02.setVisibility(8);
            return;
        }
        int i3 = 2;
        if (num.intValue() == 2) {
            m02.setText(getString(R.string.obfuscated_res_0x7f0f027f));
            m02.setVisibility(0);
            str = String.format("https://tieba.baidu.com/mo/q/priforum/editinfo?fid=%1$s&nomenu=1", this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            m02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f03b7), num2));
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

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this.a1 : invokeV.booleanValue;
    }

    public void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.Z0 = z2;
            this.a1 = z2;
        }
    }

    public BdTypeRecyclerView y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            af6 af6Var = this.t;
            if (af6Var == null) {
                return null;
            }
            return af6Var.d0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void y4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) {
            this.b1 = z2;
        }
    }

    @Override // com.repackage.yf6
    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && isAdded() && this.c0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.o0(), true);
        }
    }

    public fg6 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.a0 : (fg6) invokeV.objValue;
    }

    public void z4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            this.Q = z2;
        }
    }
}
