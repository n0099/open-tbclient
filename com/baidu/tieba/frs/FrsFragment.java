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
import com.repackage.a98;
import com.repackage.ab6;
import com.repackage.ad5;
import com.repackage.ag;
import com.repackage.ag8;
import com.repackage.ai5;
import com.repackage.ai8;
import com.repackage.b55;
import com.repackage.b9;
import com.repackage.bf8;
import com.repackage.bo6;
import com.repackage.cc6;
import com.repackage.co6;
import com.repackage.de6;
import com.repackage.di8;
import com.repackage.dk6;
import com.repackage.dq4;
import com.repackage.dx5;
import com.repackage.ek6;
import com.repackage.eo6;
import com.repackage.fg6;
import com.repackage.fh5;
import com.repackage.gk6;
import com.repackage.go6;
import com.repackage.gw5;
import com.repackage.hf8;
import com.repackage.hk6;
import com.repackage.hm6;
import com.repackage.hx4;
import com.repackage.i25;
import com.repackage.ik6;
import com.repackage.iy;
import com.repackage.iz4;
import com.repackage.j25;
import com.repackage.jc5;
import com.repackage.jc6;
import com.repackage.jg;
import com.repackage.jh5;
import com.repackage.ji;
import com.repackage.jk6;
import com.repackage.jn;
import com.repackage.jn4;
import com.repackage.jo6;
import com.repackage.kb6;
import com.repackage.kh5;
import com.repackage.ki;
import com.repackage.kk6;
import com.repackage.km5;
import com.repackage.kn6;
import com.repackage.l25;
import com.repackage.lb6;
import com.repackage.lc6;
import com.repackage.lh4;
import com.repackage.li;
import com.repackage.lk6;
import com.repackage.ll6;
import com.repackage.lm6;
import com.repackage.lo6;
import com.repackage.mc6;
import com.repackage.me8;
import com.repackage.mg;
import com.repackage.mh4;
import com.repackage.mh5;
import com.repackage.mm6;
import com.repackage.mn6;
import com.repackage.mp6;
import com.repackage.n78;
import com.repackage.nh5;
import com.repackage.ni6;
import com.repackage.nk6;
import com.repackage.nm6;
import com.repackage.nn;
import com.repackage.oc6;
import com.repackage.ok6;
import com.repackage.om6;
import com.repackage.on6;
import com.repackage.pb6;
import com.repackage.pc6;
import com.repackage.pe6;
import com.repackage.pf8;
import com.repackage.pg;
import com.repackage.pk6;
import com.repackage.pm6;
import com.repackage.pn4;
import com.repackage.q85;
import com.repackage.qc6;
import com.repackage.qe6;
import com.repackage.qn4;
import com.repackage.qn6;
import com.repackage.rg5;
import com.repackage.rg8;
import com.repackage.rk6;
import com.repackage.rn6;
import com.repackage.rp4;
import com.repackage.rp6;
import com.repackage.sc6;
import com.repackage.sg5;
import com.repackage.sk4;
import com.repackage.sk6;
import com.repackage.so6;
import com.repackage.tg5;
import com.repackage.tm6;
import com.repackage.tn;
import com.repackage.u75;
import com.repackage.uc6;
import com.repackage.um6;
import com.repackage.va6;
import com.repackage.vl4;
import com.repackage.vn6;
import com.repackage.wa;
import com.repackage.wa6;
import com.repackage.we6;
import com.repackage.wf8;
import com.repackage.wn6;
import com.repackage.xc5;
import com.repackage.xe6;
import com.repackage.xn6;
import com.repackage.y88;
import com.repackage.yc6;
import com.repackage.yn6;
import com.repackage.ys4;
import com.repackage.zn6;
import com.repackage.zp6;
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
public class FrsFragment extends BaseFragment implements VoiceManager.j, gk6, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, pc6, n78, sk6, tg5, jc6, mc6 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean e2;
    public static pf8 f2;
    public static volatile long g2;
    public static volatile long h2;
    public static volatile int i2;
    public static boolean j2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<TbImageView> A;
    public boolean A0;
    public final CustomMessageListener A1;
    public long B;
    public AddExperiencedModel B0;
    public CustomMessageListener B1;
    public long C;
    public boolean C0;
    public final CustomMessageListener C1;
    public long D;
    public boolean D0;
    public CustomMessageListener D1;
    public long E;
    public boolean E0;
    public CustomMessageListener E1;
    public long F;
    public Date F0;
    public final wf8 F1;
    public long G;
    public int G0;
    public final CustomMessageListener G1;
    public long H;
    public int H0;
    public final CustomMessageListener H1;
    public long I;
    public int I0;
    public final BdUniDispatchSchemeController.b I1;
    public boolean J;
    public List<LiveHorseRaceData> J0;
    public final rk6 J1;
    public int K;
    public ValueAnimator K0;
    public final View.OnTouchListener K1;
    public boolean L;
    public Runnable L0;
    public final View.OnClickListener L1;
    public boolean M;
    public int M0;
    public final View.OnClickListener M1;
    public boolean N;
    public ek6 N0;
    public final RecyclerView.OnScrollListener N1;
    public u75 O;
    public qe6 O0;
    public final ab6 O1;
    public boolean P;
    @Nullable
    public TiePlusEventController P0;
    public final NoNetworkView.b P1;
    public boolean Q;
    public int Q0;
    public final CustomMessageListener Q1;
    public String R;
    public int R0;
    public tn R1;
    public iy.a S;
    public on6 S0;
    public oc6 S1;
    public ThreadCardViewHolder T;
    public de6 T0;
    public CustomMessageListener T1;
    public FrsModelController U;
    public boolean U0;
    public CustomMessageListener U1;
    public jo6 V;
    public boolean V0;
    public CustomMessageListener V1;
    public FrsTabViewController W;
    public boolean W0;
    public CustomMessageListener W1;
    public ok6 X;
    public Object X0;
    public CustomMessageListener X1;
    public hm6 Y;
    public boolean Y0;
    public CustomMessageListener Y1;
    public ik6 Z;
    public boolean Z0;
    public CustomMessageListener Z1;
    public String a;
    public boolean a1;
    public CustomMessageListener a2;
    public we6 b;
    public int b1;
    public HttpMessageListener b2;
    public boolean c;
    public MessageQueue.IdleHandler c1;
    public CustomMessageListener c2;
    public boolean d;
    public final CustomMessageListener d1;
    public rp6 d2;
    public boolean e;
    public CustomMessageListener e1;
    public String f;
    public CustomMessageListener f1;
    public String g;
    public qc6 g0;
    public CustomMessageListener g1;
    public int h;
    public SparseArray<sg5> h0;
    public CustomMessageListener h1;
    public boolean i;
    public boolean i0;
    public wa i1;
    public boolean j;
    public fg6 j0;
    public CustomMessageListener j1;
    public String k;
    public co6 k0;
    public final oc6 k1;
    public String l;
    public kk6 l0;
    public FrsTabViewController.o l1;
    public int m;
    public jk6 m0;
    public int m1;
    public boolean n;
    public lo6 n0;
    public CustomMessageListener n1;
    public rg8 o;
    public hk6 o0;
    public CustomMessageListener o1;
    public boolean p;
    public dk6 p0;
    public final CustomMessageListener p1;
    public boolean q;
    public kb6 q0;
    public final CustomMessageListener q1;
    public VoiceManager r;
    public eo6 r0;
    public final CustomMessageListener r1;
    public View s;
    public so6 s0;
    public final AntiHelper.k s1;
    public lb6 t;
    public go6 t0;
    public CustomMessageListener t1;
    public OvalActionButton u;
    public boolean u0;
    public CustomMessageListener u1;
    public FRSRefreshButton v;
    public ni6 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public fh5 w0;
    public CustomMessageListener w1;
    public final ThreadData x;
    public km5 x0;
    public CustomMessageListener x1;
    public FrsViewData y;
    public pe6 y0;
    public HttpMessageListener y1;
    public String z;
    public dq4 z0;
    public b55 z1;

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
                    gw5.b().e(false);
                    this.a.i3(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.m1 = i;
                this.a.Q0 = i2;
                if (this.a.N0 != null) {
                    this.a.N0.d(this.a.Q0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.Q0);
                this.a.m4();
                nm6 nm6Var = pm6.f0;
                nm6Var.e = i;
                nm6Var.h = i2;
                nm6Var.f = -1;
                if (!this.a.C0) {
                    this.a.t.S1(this.a.m2(i));
                    return;
                }
                wa6.f().p(i == 1 && this.a.C0, true);
                va6 h = va6.h();
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
                        if (this.a.W.L() == 0 || this.a.t.H0() || l25.h().k()) {
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
            bo6.c(this.a.y, this.a.getPageContext());
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
                this.a.V.Q(num);
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
    public class d0 implements sc6 {
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

        @Override // com.repackage.sc6
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.a.t == null) {
                return;
            }
            boolean z3 = false;
            if (i == 1) {
                this.a.t.w1(wa6.f().h());
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
            if (this.a.M2() != null) {
                FrsTabViewController.p C = this.a.M2().C();
                if (C != null) {
                    if ((C.b instanceof FrsCommonTabFragment) && (i == 2 || C.a == 502)) {
                        ((FrsCommonTabFragment) C.b).b1();
                    } else if ((C.b instanceof FrsNewAreaFragment) && (i == 2 || C.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) C.b;
                        frsNewAreaFragment.y1();
                        if (frsNewAreaFragment.j1() != null) {
                            nk6 j1 = frsNewAreaFragment.j1();
                            j1.G(!z);
                            if (i == 1) {
                                j1.D(!z);
                            } else if (i == 2) {
                                j1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = C.b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).t1();
                        }
                    }
                }
                if (this.a.M2().N() != null) {
                    this.a.M2().N().setmDisallowSlip(z);
                    this.a.M2().i0(z);
                }
            }
            if (this.a.t.Y() != null) {
                lb6 lb6Var = this.a.t;
                if (this.a.k2() && !z) {
                    z3 = true;
                }
                lb6Var.S1(z3);
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

        @Override // com.repackage.sc6
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0718));
                bdTopToast.j(this.a.t.n0());
                return;
            }
            li.N(this.a.getContext(), R.string.obfuscated_res_0x7f0f0723);
        }

        @Override // com.repackage.sc6
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
                this.a.u2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements kh5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                    return;
                }
                dq4Var.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                    return;
                }
                dq4Var.dismiss();
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

        @Override // com.repackage.kh5.c
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
            if (this.a.W == null || this.a.W.C() == null || !(this.a.W.C().b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.W.C().b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(R.string.obfuscated_res_0x7f0f04a9);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.z0 = new dq4(frsFragment.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f04e8, new a(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.z0 = new dq4(frsFragment2.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f098e, new b(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else {
                    this.a.t.N1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.u1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.q2(deleteThreadHttpResponseMessage.getSuccessItems());
                wa6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (jn jnVar : this.a.y.getThreadList()) {
                    if (jnVar instanceof rp4) {
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
            li.O(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
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
                    this.b.V2();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ag8) || this.a.y == null) {
                return;
            }
            this.a.y.updateLikeData((ag8) customResponsedMessage.getData());
            this.a.V.U(this.a.y);
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
                    mg.a().postDelayed(new RunnableC0186a(this, jg.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L), li.k(TbadkCoreApplication.getInst()), li.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
            mg.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
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
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
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
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.s1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().d) {
                    li.N(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f02b3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements rk6 {
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

        @Override // com.repackage.rk6
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<jn> arrayList, boolean z3) {
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
                    this.a.V.P(motionEvent);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pn4) && this.a.isResumed()) {
                pn4 pn4Var = (pn4) customResponsedMessage.getData();
                if (this.a.O0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.O0 = new qe6(frsFragment.getPageContext());
                }
                if (this.a.y == null || this.a.y.getForum() == null || TextUtils.isEmpty(this.a.y.getForum().getId())) {
                    return;
                }
                this.a.O0.g(pn4Var.a, this.a.y.getForum().getId(), this.a.y.getForum().getName(), pn4Var.b);
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
                this.a.v3();
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
                ai8.o(this.a.f);
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
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f06d4));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f0734));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090a99));
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
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ FrsFragment b;

        public l0(FrsFragment frsFragment, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, dq4Var};
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
            this.a = dq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            dq4 dq4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (dq4Var = this.a) == null) {
                return;
            }
            dq4Var.dismiss();
            this.b.V3();
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
            mh5 mh5Var = (mh5) customResponsedMessage.getData();
            if (this.a.y == null || this.a.y.getForum() == null || this.a.y.getForum().getDeletedReasonInfo() == null) {
                jh5.d(0, this.a.getPageContext(), mh5Var, null, this.a.y.getUserData());
                return;
            }
            nh5 nh5Var = new nh5(this.a.y.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.y.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.y.forumRule != null ? this.a.y.forumRule.has_forum_rule.intValue() : 0);
            nh5Var.i(this.a.y.getForum().getId(), this.a.y.getForum().getName());
            nh5Var.h(this.a.y.getForum().getImage_url());
            nh5Var.j(this.a.y.getForum().getUser_level());
            jh5.d(nh5Var.f(), this.a.getPageContext(), mh5Var, nh5Var, this.a.y.getUserData());
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
    public class m0 implements vl4 {
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

        @Override // com.repackage.vl4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l25.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0656));
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f071d));
                bdTopToast.j(this.a.t.n0());
                if (va6.h().k(va6.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.W != null && this.a.W.C() != null && (this.a.W.C().b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.C().b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.Z0();
                    }
                    this.a.r2();
                    va6.h().d();
                    for (jn jnVar : this.a.y.getThreadList()) {
                        if (jnVar instanceof rp4) {
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
                va6.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(this.a.t.n0());
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements vl4 {
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

        @Override // com.repackage.vl4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                l25.h().o(true);
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
                    this.a.V2();
                    return;
                }
                this.a.J0 = new ArrayList();
                this.a.I0 = 0;
                this.a.J0.addAll(arrayList);
                this.a.V2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends b55<TopToastEvent> {
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
        @Override // com.repackage.u45
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
                this.a.g3();
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
                this.a.u2();
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
                this.a.l4();
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
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09063c);
                if (this.a.t != null && view2 == this.a.t.U() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090c11 && li.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t == null || !this.a.t.D0()) {
                        String c = this.a.y.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            sk4.n(this.a.getPageContext().getPageActivity(), c);
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
                    this.a.g3();
                }
                if (ji.z()) {
                    if (this.a.y == null || this.a.y.getForum() == null) {
                        return;
                    }
                    if (this.a.t != null && (view2 == this.a.t.t0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.y == null || this.a.y.getForum() == null || StringUtils.isNull(this.a.y.getForum().getId()) || StringUtils.isNull(this.a.y.getForum().getName())) {
                            return;
                        }
                        ll6.e(this.a.y.getForum().getId(), this.a.y.getForum().getName());
                        vn6.g(this.a.getPageContext(), this.a.y, this.a.y.getForum().getId(), this.a.K, this.a.L, this.a.L1);
                    }
                    if ((this.a.t == null || view2 != this.a.t.s0()) && logicField != LogicField.SEARCH_BTN) {
                        return;
                    }
                    StatisticItem param = new StatisticItem("c12402").param("fid", this.a.y.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.y.getForum().getName());
                    ll6.a(param);
                    TiebaStatic.log(param);
                    if (StringUtils.isNull(this.a.y.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.y.getForum().getName(), this.a.y.getForum().getId())));
                    return;
                }
                li.N(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c34);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements oc6 {
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

        @Override // com.repackage.oc6
        public void a(int i, int i2, yc6 yc6Var, ArrayList<jn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), yc6Var, arrayList}) == null) {
                this.a.c4();
                if (this.a.j0 != null) {
                    this.a.V.d0(this.a.j0.e(i));
                }
                hf8 hf8Var = new hf8();
                if (yc6Var != null) {
                    boolean z = yc6Var.e == 0;
                    hf8Var.b = z;
                    hf8Var.c = yc6Var.e;
                    hf8Var.d = yc6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.v0();
                        } else if (yc6Var.g) {
                            if (ListUtils.getCount(this.a.y.getThreadList()) > 3) {
                                this.a.t.L1();
                            } else {
                                this.a.t.H1();
                            }
                        } else if (yc6Var.i) {
                            this.a.t.O1();
                        } else {
                            this.a.t.v0();
                        }
                    }
                } else {
                    yc6Var = new yc6();
                    yc6Var.c = 1;
                    yc6Var.g = false;
                    yc6Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.F1.d(frsFragment.U.getType(), false, hf8Var);
                } else {
                    this.a.b4(hf8Var);
                    if (this.a.U.f0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y = frsFragment2.U.f0();
                    }
                    this.a.s3();
                }
                if (this.a.S1 != null) {
                    this.a.S1.a(i, i2, yc6Var, arrayList);
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
                    this.c.V.n0(i);
                    if (i == 1) {
                        this.c.V.A();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.a3()) {
                    this.c.O = new u75();
                    this.c.O.a(1000);
                }
                if (i != 0) {
                    if (this.c.X0 == null) {
                        this.c.X0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    u75 u75Var = this.c.O;
                    if (u75Var != null) {
                        u75Var.d();
                    }
                } else {
                    u75 u75Var2 = this.c.O;
                    if (u75Var2 != null) {
                        u75Var2.e();
                    }
                    gw5.b().e(true);
                    this.c.i3(true);
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
                    yn6.b(this.c.t, this.c.y, this.c.b(), false, null);
                }
                if (this.c.W != null && i == 1) {
                    this.c.W.P();
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
                    me8.r().A(3, 2);
                    me8.r().G();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class q1 implements tn {
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

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == pb6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.T1();
                }
            } else if (jnVar == null || !(jnVar instanceof rp4)) {
            } else {
                ThreadData threadData = ((rp4) jnVar).s;
                if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        if (threadData.getAppCodeData() != null) {
                            if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                                String a2 = threadData.getAppCodeData().a();
                                if (StringUtils.isNull(a2) || !li.D()) {
                                    return;
                                }
                                sk4.n(this.a.getActivity(), a2);
                            }
                        } else if (threadData.getCartoonThreadData() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                                return;
                            }
                            jn4 cartoonThreadData = threadData.getCartoonThreadData();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                        } else {
                            di8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                                yn6.c(threadData.getTaskInfoData());
                            } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", threadData.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                            zn6.f(this.a, threadData, i, z);
                            FrsFragment frsFragment = this.a;
                            yn6.d(frsFragment, frsFragment.y, threadData);
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
                if (TbadkApplication.getInst().getCurrentActivity() == null || ki.isEmpty(str) || !str.equals(this.a.l)) {
                    return;
                }
                vn6.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.y);
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
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.L() == 0 || this.a.W.C() == null || !(this.a.W.C().b instanceof BaseFragment) || !((BaseFragment) this.a.W.C().b).isPrimary() || this.a.t.H0() || l25.h().k()) {
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
            this.a.t.O();
        }
    }

    /* loaded from: classes3.dex */
    public class s0 implements ab6 {
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

        @Override // com.repackage.ab6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i != this.a.t.W().c()) {
                    if (i != this.a.t.W().j()) {
                        if (i != this.a.t.W().i() || this.a.y == null || this.a.y.getUserData() == null || !this.a.y.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.y.getBawuCenterUrl();
                        if (ki.isEmpty(bawuCenterUrl) || this.a.y.getForum() == null) {
                            return;
                        }
                        sk4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.y.getForum().getId()).param("uid", this.a.y.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.y == null || this.a.y.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.y.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), jg.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    zn6.e(this.a.getPageContext(), this.a.y);
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
                this.a.Y3();
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
    public class u implements wf8 {
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

        @Override // com.repackage.wf8
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

        @Override // com.repackage.wf8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.v3();
            }
        }

        @Override // com.repackage.wf8
        public void c(pf8 pf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pf8Var) == null) {
                if ((pf8Var == null || !("normal_page".equals(this.b.U.b0()) || "frs_page".equals(this.b.U.b0()) || "book_page".equals(this.b.U.b0()))) && !"brand_page".equals(this.b.U.b0())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, pf8Var));
                this.b.w3(pf8Var);
                FrsFragment.f2 = pf8Var;
            }
        }

        @Override // com.repackage.wf8
        public void d(int i, boolean z, hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), hf8Var}) == null) {
                if (this.b.i0) {
                    this.b.i0 = false;
                    yn6.b(this.b.t, this.b.y, this.b.b(), false, null);
                }
                this.b.c4();
                this.b.N = true;
                if (hf8Var != null && hf8Var.b) {
                    this.b.t.W().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.g2 = 0L;
                    FrsFragment.h2 = 0L;
                    FrsFragment.i2 = 0;
                } else {
                    FrsFragment.i2 = 1;
                }
                if (!this.b.U.v0() && (i == 3 || i == 6)) {
                    this.b.m0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.U.f0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.y = frsFragment.U.f0();
                }
                this.b.a4(1);
                this.b.S3();
                if (i == 7) {
                    this.b.u3(this.b.y.getFrsDefaultTabId());
                    return;
                }
                if (this.b.y.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.D3(frsFragment2.y.getPage().b());
                }
                if (i == 4) {
                    if (!this.b.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.U.d0() == 1 && (this.b.y.adShowSelect == 1 || this.b.y.adShowSelect == 3)) {
                        this.b.y.addRecommendAppToThreadList(this.b);
                    }
                    ArrayList<jn> c = this.b.m0.c(false, false, this.b.y.getThreadList(), this.b.o, false, this.b.y.adShowSelect, this.b.y.adMixFloor);
                    if (c != null) {
                        this.b.y.setThreadList(c);
                        this.b.y.checkLiveStageInThreadList();
                    }
                    if (this.b.U != null) {
                        om6.m(this.b.y, this.b.U.T(), 2, this.b.getContext());
                    }
                    FrsFragment frsFragment3 = this.b;
                    kn6.a(frsFragment3, frsFragment3.y.getForum(), this.b.y.getThreadList(), false, this.b.K2());
                    this.b.t.D1(c, this.b.y);
                    this.b.e4();
                    return;
                }
                this.b.e4();
                if (i == 1) {
                    this.b.t.J0();
                } else if (i == 2) {
                    this.b.t.J0();
                } else if (i == 3 || i == 6) {
                    if (this.b.y != null) {
                        this.b.y.clearPostThreadCount();
                    }
                    eo6 eo6Var = this.b.r0;
                    if (eo6Var != null) {
                        eo6Var.d();
                    }
                }
                this.b.k4();
                if (hf8Var == null || hf8Var.c == 0) {
                    if (this.b.y == null) {
                        return;
                    }
                    if (this.b.i() != null) {
                        FrsFragment frsFragment4 = this.b;
                        if (!frsFragment4.T3(frsFragment4.y, this.b.i())) {
                            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                            upgradePopWindowMessage.setFromPage("frs");
                            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                        }
                    }
                    this.b.p3(false, i == 5);
                    if (this.b.U != null) {
                        if (this.b.y.getActivityHeadData() != null && this.b.y.getActivityHeadData().b() != null && this.b.y.getActivityHeadData().b().size() > 0) {
                            mm6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.c0(), 1);
                        }
                        if (this.b.y.getThreadList() != null && this.b.y.getThreadList().size() > 0) {
                            Iterator<jn> it = this.b.y.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                jn next = it.next();
                                if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                    mm6.h(this.b.getUniqueId(), 1, this.b.y.getForum(), this.b.U.c0(), 2);
                                    break;
                                }
                            }
                        }
                        mm6.i(this.b.getUniqueId(), this.b.y.getThreadList(), this.b.y.getForum(), this.b.U.c0());
                    }
                    this.b.t.U0(i);
                    FrsFragment.g2 = (System.nanoTime() - this.a) / 1000000;
                    if (hf8Var != null) {
                        FrsFragment.h2 = hf8Var.e;
                    }
                } else if (this.b.y == null || ListUtils.isEmpty(this.b.y.getThreadList())) {
                    this.b.b4(hf8Var);
                } else if (hf8Var.a) {
                    FrsFragment frsFragment5 = this.b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c32, hf8Var.d, Integer.valueOf(hf8Var.c)));
                }
                this.b.p2();
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
                mn6.a(customResponsedMessage, this.a.t, this.a.y);
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
                    yn6.b(this.a.t, this.a.y, this.a.b(), true, (ThreadData) data);
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
            if (C != null && (fragment = C.b) != null && (fragment instanceof lc6)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((lc6) C.b).B0();
                ((lc6) C.b).o();
                return;
            }
            this.a.y0().T1();
        }
    }

    /* loaded from: classes3.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ FrsFragment b;

        public w(FrsFragment frsFragment, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, dq4Var};
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
            this.a = dq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean booleanValue = ((Boolean) view2.getTag(R.id.obfuscated_res_0x7f090f23)).booleanValue();
                PrivateForumPopInfoData privateForumPopInfoData = (PrivateForumPopInfoData) view2.getTag(R.id.obfuscated_res_0x7f0918fd);
                UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{privateForumPopInfoData.C()});
                FrsFragment frsFragment = this.b;
                mm6.f(privateForumPopInfoData, booleanValue, frsFragment.l, frsFragment.f, true);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements oc6 {
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

        @Override // com.repackage.oc6
        public void a(int i, int i2, yc6 yc6Var, ArrayList<jn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), yc6Var, arrayList}) == null) {
                mg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
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
                    if (this.a.T == null && this.a.t.k0() != null && !this.a.t.a0() && this.a.t.k0().j() != null && (this.a.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.T = (ThreadCardViewHolder) frsFragment.t.k0().j().getTag();
                    }
                    if (this.a.T == null || this.a.T.c() == null) {
                        return;
                    }
                    this.a.T.c().o(new iy.a(3));
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N || !ji.z() || this.a.t.G0()) {
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
        this.S = new iy.a(2);
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
        this.b1 = 0;
        this.c1 = new k(this);
        this.d1 = new v(this, 2016495);
        this.e1 = new g0(this, 2921005);
        this.f1 = new r0(this, 2921401);
        this.g1 = new c1(this, 2921473);
        this.h1 = new m1(this, 2921467);
        this.i1 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.j1 = new o1(this, 2001624);
        this.k1 = new p1(this);
        this.l1 = new a(this);
        this.n1 = new b(this, 2001606);
        this.o1 = new c(this, 2001607);
        this.p1 = new d(this, 2003019);
        this.q1 = new e(this, 2921470);
        this.r1 = new f(this, 2001352);
        this.s1 = new g(this);
        this.t1 = new h(this, 2001115);
        this.u1 = new i(this, 2921346);
        this.v1 = new j(this, 2001374);
        this.w1 = new l(this, 2001378);
        this.x1 = new m(this, 2001626);
        this.y1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.z1 = new o(this);
        this.A1 = new p(this, 2921391);
        this.B1 = new q(this, 2003020);
        this.C1 = new r(this, 2921463);
        this.D1 = new s(this, 2921587);
        this.E1 = new t(this, 2921588);
        this.F1 = new u(this);
        this.G1 = new b0(this, 2016485);
        this.H1 = new c0(this, 2001194);
        this.I1 = new f0(this);
        this.J1 = new h0(this);
        this.K1 = new i0(this);
        this.L1 = new o0(this);
        this.M1 = new p0(this);
        this.N1 = new q0(this);
        this.O1 = new s0(this);
        this.P1 = new t0(this);
        this.Q1 = new u0(this, 0);
        this.R1 = new q1(this, null);
        this.S1 = new w0(this);
        this.T1 = new x0(this, 2921033);
        this.U1 = new y0(this, 2921381);
        this.V1 = new z0(this, 2921414);
        this.W1 = new a1(this, 2921437);
        this.X1 = new g1(this, 2921462);
        this.Y1 = new h1(this, 2001223);
        this.Z1 = new i1(this, 2921469);
        this.a2 = new j1(this, 2921475);
        this.b2 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.c2 = new l1(this, 2921515);
    }

    public int A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.R0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.R0;
        }
        return invokeV.intValue;
    }

    public void A3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.e = z2;
        }
    }

    public int B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? zn6.c(this.y, this.t) : invokeV.intValue;
    }

    public void B3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i3) == null) {
            this.h = i3;
        }
    }

    @Override // com.repackage.jc6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public kk6 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l0 : (kk6) invokeV.objValue;
    }

    public void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f = str;
        }
    }

    public hm6 D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Y : (hm6) invokeV.objValue;
    }

    public void D3(int i3) {
        jk6 jk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i3) == null) || (jk6Var = this.m0) == null) {
            return;
        }
        jk6Var.n(i3);
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    @SuppressLint({"StringFormatInvalid"})
    public void E3(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, num, num2, z2) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                xe6 f3 = this.b.f();
                if (f3 == null) {
                    return;
                }
                f3.z1().i(num, num2, z2);
                if (z2) {
                    return;
                }
                this.V.v();
            } else if (this.t.l0() == null) {
            } else {
                TextView l02 = this.t.l0();
                if (z2) {
                    l02.setVisibility(8);
                    return;
                }
                int i3 = 2;
                if (num.intValue() == 2) {
                    l02.setText(getString(R.string.obfuscated_res_0x7f0f0278));
                    l02.setVisibility(0);
                    str = String.format("https://tieba.baidu.com/mo/q/priforum/editinfo?fid=%1$s&nomenu=1", this.l);
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    l02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f03b9), num2));
                    l02.setVisibility(0);
                    str = String.format("https://tieba.baidu.com/mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1", this.l, this.f);
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

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a1 : invokeV.booleanValue;
    }

    public void F3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.Y0 = z2;
            this.Z0 = z2;
        }
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.t.a0() : invokeV.booleanValue;
    }

    public void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.a1 = z2;
        }
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z2) == null) {
            this.Q = z2;
        }
    }

    public BdTypeRecyclerView I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            lb6 lb6Var = this.t;
            if (lb6Var == null) {
                return null;
            }
            return lb6Var.c0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void I3(boolean z2) {
        lo6 lo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || (lo6Var = this.n0) == null) {
            return;
        }
        lo6Var.b0();
    }

    public qc6 J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.g0 : (qc6) invokeV.objValue;
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            this.E0 = z2;
        }
    }

    public int K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            jk6 jk6Var = this.m0;
            if (jk6Var == null) {
                return 1;
            }
            return jk6Var.g();
        }
        return invokeV.intValue;
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.y == null) {
            return;
        }
        nm6 nm6Var = new nm6();
        if (this.y.needLog == 1) {
            nm6Var.a = true;
        } else {
            nm6Var.a = false;
        }
        if (this.y.getForum() != null) {
            nm6Var.c = this.y.getForum().getId();
            nm6Var.d = this.y.getForum().getName();
        }
        if (c0() != null) {
            nm6Var.b = c0().T();
        }
        nm6 nm6Var2 = pm6.f0;
        if (nm6Var2 != null) {
            nm6Var.e = nm6Var2.e;
            nm6Var.f = nm6Var2.f;
        }
        ek6 ek6Var = new ek6(nm6Var, getTbPageTag(), getUniqueId());
        this.N0 = ek6Var;
        ek6Var.d(this.Q0);
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

    @Override // com.repackage.n78
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c0().U0();
        }
    }

    public View L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void L3(boolean z2) {
        qc6 qc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) || (qc6Var = this.g0) == null) {
            return;
        }
        qc6Var.i(z2);
    }

    public FrsTabViewController M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.W : (FrsTabViewController) invokeV.objValue;
    }

    public void M3(int i3) {
        jk6 jk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i3) == null) || (jk6Var = this.m0) == null) {
            return;
        }
        jk6Var.o(i3);
    }

    @Override // com.repackage.sk6
    public jo6 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.V : (jo6) invokeV.objValue;
    }

    public final FrsTabInfoData N2() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
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

    public void N3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) && this.d2 == null) {
            rp6 a2 = rp6.a(z2);
            this.d2 = a2;
            jk6 jk6Var = this.m0;
            if (jk6Var != null) {
                jk6Var.m(a2);
            }
        }
    }

    public String O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final void O3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (frsViewData = this.y) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.W().setFromCDN(true);
        } else {
            this.t.W().setFromCDN(false);
        }
    }

    public OvalActionButton P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.u : (OvalActionButton) invokeV.objValue;
    }

    public void P3(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public FRSRefreshButton Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.v : (FRSRefreshButton) invokeV.objValue;
    }

    public void Q3(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public int R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            jk6 jk6Var = this.m0;
            if (jk6Var == null) {
                return -1;
            }
            return jk6Var.h();
        }
        return invokeV.intValue;
    }

    public void R3(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        li.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
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

    public void T2() {
        jo6 jo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (jo6Var = this.V) == null) {
            return;
        }
        jo6Var.B();
    }

    public boolean T3(pf8 pf8Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, pf8Var, tbPageContext)) == null) {
            if (E2()) {
                return false;
            }
            if (pf8Var != null && pf8Var.getEntelechyTabInfo() != null && pf8Var.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : pf8Var.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && ys4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            if (pf8Var != null && pf8Var.getBusinessPromot() != null && !StringUtils.isNull(pf8Var.getBusinessPromot().p()) && pf8Var.getForum() != null) {
                boolean j3 = qn6.j(pf8Var.getBusinessPromot(), pf8Var.getForum().getId());
                this.V0 = j3;
                F3(j3);
                return this.V0;
            }
            de6 de6Var = new de6(tbPageContext);
            this.T0 = de6Var;
            boolean j4 = de6Var.j(pf8Var);
            this.U0 = j4;
            F3(j4);
            return this.U0;
        }
        return invokeLL.booleanValue;
    }

    public void U2() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            dq4 dq4Var = new dq4(getPageContext().getPageActivity());
            dq4Var.setContentViewSize(2);
            dq4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new l0(this, dq4Var));
            dq4Var.setContentView(frsBroadcastCopyGuideDialogView);
            dq4Var.create(getPageContext()).show();
        }
    }

    public final void V2() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || !isResumed() || (list = this.J0) == null || list.size() < 1 || this.I0 > this.J0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.J0.get(this.I0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.I0++;
            V2();
        }
        if (this.w != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a12), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a12), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a12), getResources().getString(R.string.obfuscated_res_0x7f0f0704));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.K0 = ofFloat;
            ofFloat.setDuration(600L);
            this.K0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.K0.addListener(new e1(this, frsRedpackRunView));
            this.L0 = new f1(this, frsRedpackRunView);
            mg.a().postDelayed(this.L0, 5000L);
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

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            l25.h().m(new i25(getContext()));
            l25.h().n(85, 0, li.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (l25.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new m0(this), true);
            }
        }
    }

    public final void W2(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            registerListener(2001118, this.Q1);
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
                registerListener(2001120, this.Q1);
            }
            this.V.H(bundle);
            t2(j3);
        }
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            l25.h().m(new j25(getContext()));
            l25.h().n(85, 0, li.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (l25.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.h == 0) {
                this.t.E1(this.f);
            } else {
                this.t.E1("");
                this.h = 1;
            }
            this.t.A1(this.R1);
            this.t.J(this.N1);
            this.t.B1(this.P1);
            this.t.W().l(this.O1);
        }
    }

    public void X3(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.V0();
            this.t.k1(8);
            if (this.s0 == null) {
                this.s0 = new so6(getPageContext(), getNetRefreshListener());
            }
            this.s0.c(str);
            this.s0.b(list);
            this.s0.attachView(view2, z2);
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void Y3() {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (lb6Var = this.t) == null) {
            return;
        }
        lb6Var.G1();
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumPopInfo() == null;
        }
        return invokeV.booleanValue;
    }

    public void Z3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048630, this, str, str2, str3) == null) {
            on6 on6Var = new on6(str, str2);
            this.S0 = on6Var;
            on6Var.f(getFragmentActivity(), str3, str2);
        }
    }

    @Override // com.repackage.gk6, com.repackage.pc6
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void a4(int i3) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i3) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.y) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            WindowToast windowToast = list.get(i4);
            if (windowToast != null && windowToast.toast_type.intValue() == i3) {
                if (ki.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", ad5.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    @Override // com.repackage.pc6
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.U0 : invokeV.booleanValue;
    }

    public final void b4(hf8 hf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, hf8Var) == null) {
            if (hf8Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05ac);
                this.t.V0();
                showNetRefreshView(this.t.n0(), string, true);
            } else if (340001 == hf8Var.c) {
                g4(hf8Var, this.y.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    f4(hf8Var);
                }
                if (a3()) {
                    setNetRefreshViewEmotionMarginTop(li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070295));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    @Override // com.repackage.sk6
    public FrsModelController c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.U : (FrsModelController) invokeV.objValue;
    }

    public boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.V0 : invokeV.booleanValue;
    }

    public void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            hideLoadingView(this.t.n0());
            this.t.V1();
            if (this.t.m0() instanceof tm6) {
                ((tm6) this.t.m0()).d();
            }
        }
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (h0() == null) {
                return false;
            }
            FrsViewData h02 = h0();
            qn4 qn4Var = null;
            if (h02.getStar() != null && !StringUtils.isNull(h02.getStar().a())) {
                qn4Var = new qn4();
            } else if (h02.getActivityHeadData() != null && ListUtils.getCount(h02.getActivityHeadData().b()) >= 1) {
                qn4Var = h02.getActivityHeadData().b().get(0);
            }
            return qn4Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (R2() != 1 && !this.m0.b(this.y.getThreadListIds())) {
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

    @Override // com.repackage.tg5
    public void dispatchInjectPluginMessage(rg5 rg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, rg5Var) == null) {
            this.q0.a(rg5Var);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void e(ArrayList<jn> arrayList) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            D3(!isEmpty ? 1 : 0);
            d4();
            if (isEmpty) {
                return;
            }
            if (!this.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.d0() == 1 && ((i3 = this.y.adShowSelect) == 1 || i3 == 3)) {
                this.y.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                mm6.i(getUniqueId(), arrayList, this.y.getForum(), this.U.c0());
            }
            jk6 jk6Var = this.m0;
            rg8 rg8Var = this.o;
            FrsViewData frsViewData = this.y;
            ArrayList<jn> c2 = jk6Var.c(false, false, arrayList, rg8Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.y.setThreadList(c2);
                this.t.D1(c2, this.y);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                om6.m(this.y, frsModelController.T(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.y.getForum()));
        }
    }

    @Override // com.repackage.mc6
    public NavigationBar e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            lb6 lb6Var = this.t;
            if (lb6Var == null) {
                return null;
            }
            return lb6Var.g0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public boolean e3() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (R2() == 0 && ListUtils.isEmpty(this.y.getThreadListIds())) {
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

    public boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (h0() == null) {
                return false;
            }
            FrsViewData h02 = h0();
            return (ListUtils.isEmpty(h02.getShowTopThreadList()) && h02.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void f4(hf8 hf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, hf8Var) == null) {
            this.t.V0();
            if (hf8Var.a) {
                showNetRefreshView(this.t.n0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c32, new Object[]{hf8Var.d, Integer.valueOf(hf8Var.c)}), true);
            } else {
                showNetRefreshView(this.t.X().m(), hf8Var.d, true);
            }
        }
    }

    public final void g2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.U) == null || this.y == null || this.t == null || !z2) {
            return;
        }
        if (!frsModelController.v0() && this.U.d0() == 1) {
            if (!this.U.s0()) {
                this.y.addCardVideoInfoToThreadList();
                this.y.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.t.W().k(dx5.g) ? this.y.addHotTopicDataToThreadList() : false)) {
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
        if (this.t.W().k(zp6.e)) {
            this.y.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.U.v0() || this.U.isNetFirstLoad)) {
            this.y.addUserRecommendToThreadList();
        }
        this.y.addVideoActivityToTop();
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && ViewHelper.checkUpIsLogin(getContext())) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            ll6.a(param);
            ll6.b(param, b(), a());
            TiebaStatic.log(param);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.K).param("obj_type", this.K > 0 ? 1 : 2).param("obj_source", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public final void g4(hf8 hf8Var, List<RecmForumInfo> list) {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048651, this, hf8Var, list) == null) || (lb6Var = this.t) == null) {
            return;
        }
        lb6Var.V0();
        this.t.E1(this.f);
        if (this.t.X() != null) {
            X3(this.t.n0(), hf8Var.d, true, list);
        }
        this.t.f0().h(true);
    }

    @Override // com.repackage.tg5
    public sg5 getInjectPlugin(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i3)) == null) ? this.h0.get(i3) : (sg5) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.gk6
    public /* bridge */ /* synthetic */ b9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.p C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (M2() != null && (C = M2().C()) != null) {
                Fragment fragment = C.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.y;
                        tbPageTag.sortType = xn6.g(frsViewData != null ? frsViewData.getSortType() : -1);
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

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.gk6
    public FrsViewData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.y : (FrsViewData) invokeV.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                i2(frsModelController.b0());
            } else {
                i2("normal_page");
            }
        }
    }

    public void h3(Object obj) {
        ik6 ik6Var;
        a9 a9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, obj) == null) || (ik6Var = this.Z) == null || (a9Var = ik6Var.j) == null) {
            return;
        }
        a9Var.c(obj);
    }

    public boolean h4(pf8 pf8Var) {
        InterceptResult invokeL;
        boolean b2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, pf8Var)) == null) {
            this.y.receiveData(pf8Var);
            if (this.y.getForum() != null) {
                this.f = this.y.getForum().getName();
                this.l = this.y.getForum().getId();
            }
            if (n2() && Z2()) {
                return false;
            }
            PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.D(this.y.getPrivateForumTotalInfo().c());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            PrivateForumInfo a2 = this.y.getPrivateForumTotalInfo().a();
            if (a2 != null && a2.private_forum_status.intValue() == 1 && (ki.isEmpty(privateForumPopInfoData.B()) || privateForumPopInfoData.A() != jg.e(this.l, 0))) {
                privateForumPopInfoData.G("create_success");
                privateForumPopInfoData.H(String.format("https://tieba.baidu.com/mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1", this.l, this.f));
                privateForumPopInfoData.F(jg.e(this.l, -1));
                privateForumPopInfoData.setTitle(getString(R.string.obfuscated_res_0x7f0f1466));
                privateForumPopInfoData.E(getString(R.string.obfuscated_res_0x7f0f1467));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, false);
            } else {
                b2 = privateForumPopInfoData.A() == jg.e(this.l, 0) ? frsPrivateCommonDialogView.b(privateForumPopInfoData, false) : false;
            }
            if (b2 || (privateForumPopInfoData = this.y.getPrivateForumPopInfo()) == null || privateForumPopInfoData.A() != jg.e(this.l, 0)) {
                z2 = false;
            } else {
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData, true);
                z2 = true;
            }
            if (b2) {
                dq4 dq4Var = new dq4(getActivity());
                dq4Var.setContentViewSize(10);
                dq4Var.setContentView(frsPrivateCommonDialogView);
                dq4Var.setCanceledOnTouchOutside(false);
                frsPrivateCommonDialogView.setConfirmButton(new w(this, dq4Var));
                dq4Var.setCloseButton(new x(this));
                dq4Var.create(getPageContext()).show();
                mm6.f(privateForumPopInfoData, z2, this.l, this.f, false);
                F3(true);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, view2) == null) {
            this.t.k1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view2, false);
            this.t.f0().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.k1(0);
            this.t.f0().h(false);
        }
    }

    @Override // com.repackage.n78
    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            I3("frs_page".equals(str));
            fg6 fg6Var = this.j0;
            if (fg6Var != null) {
                fg6Var.c(this.V, this.t, this.y);
            }
        }
    }

    public void i3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            bf8.g().h(getUniqueId(), z2);
        }
    }

    public void i4() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? (!d3() || f3() || UbsABTestHelper.isFrsModifyABTestA()) ? false : true : invokeV.booleanValue;
    }

    public void j4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(str);
            bdTopToast.j(this.t.n0());
        }
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? l2(this.m1) : invokeV.booleanValue;
    }

    public final void k3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || (frsViewData = this.y) == null || frsViewData.getForum() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.y.getForum().getId(), this.y.getForum().getName(), this.y.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.y.getForum().special_forum_type), this.y.getForum().getThemeColorInfo(), this.y.getForum().getMember_num())));
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
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

    @Override // com.repackage.jc6
    public void l() {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || (lb6Var = this.t) == null) {
            return;
        }
        lb6Var.c0().scrollToPosition(0);
        this.t.T1();
    }

    public boolean l2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i3)) == null) {
            if (this.Q && !this.E0 && m2(i3)) {
                FrsModelController frsModelController = this.U;
                return (frsModelController != null && frsModelController.W() && (wa6.f().i() || va6.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean l3(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048676, this, i3, keyEvent)) == null) {
            if (i3 != 4) {
                if (i3 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (wa6.f().i()) {
                wa6.f().m();
                return true;
            } else if (va6.h().j()) {
                lb6 lb6Var = this.t;
                if (lb6Var != null && lb6Var.F0()) {
                    this.t.c1();
                    return true;
                }
                va6.h().n();
                return true;
            } else {
                lb6 lb6Var2 = this.t;
                if (lb6Var2 != null) {
                    return lb6Var2.P0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || ki.isEmpty(this.l)) {
            return;
        }
        mh4.x().P(lh4.Y, jg.g(this.l, 0L));
    }

    @Override // com.repackage.sk6
    public void loadMore() {
        jk6 jk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || (jk6Var = this.m0) == null) {
            return;
        }
        jk6Var.i(this.f, this.l, this.y);
    }

    public final boolean m2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048679, this, i3)) == null) ? i3 != 506 : invokeI.booleanValue;
    }

    public void m3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048680, this, intent) == null) || intent == null) {
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
            u2();
        }
    }

    public void m4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048681, this) == null) || (voiceManager = this.r) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.y.getPrivateForumTotalInfo().a() == null || this.y.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public void n3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, str) == null) && TbadkCoreApplication.isLogin() && !ki.isEmpty(str)) {
            if (this.B0 == null) {
                this.B0 = new AddExperiencedModel(i());
            }
            this.B0.C(this.l, str);
        }
    }

    public void n4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048684, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            zn6.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.g);
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            if (this.h == 1) {
                pg.a().b(new k0(this));
            }
            this.h = 0;
        }
    }

    public void o4(Object obj) {
        ik6 ik6Var;
        a9 a9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, obj) == null) || (ik6Var = this.Z) == null || (a9Var = ik6Var.i) == null) {
            return;
        }
        a9Var.c(obj);
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
                w2(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new rg8("frs", rg8.c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.F1);
                this.U = frsModelController;
                frsModelController.v(this.k1);
                this.U.init();
            }
            this.U.S0(this.z);
            ArrayList<jn> arrayList = null;
            if (intent != null) {
                this.U.l0(intent.getExtras());
            } else if (bundle != null) {
                this.U.l0(bundle);
            } else {
                this.U.l0(null);
            }
            if (intent != null) {
                this.V.H(intent.getExtras());
            } else if (bundle != null) {
                this.V.H(bundle);
            } else {
                this.V.H(null);
            }
            this.r = getVoiceManager();
            this.q0 = new kb6(getPageContext(), this);
            X2();
            W2(bundle);
            if (!a3()) {
                qc6 qc6Var = new qc6(getActivity(), this.t, this.V);
                this.g0 = qc6Var;
                qc6Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.r = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(y2()) && !this.A0) {
                int l2 = ys4.k().l("key_forum_broadcast_edit_tip_number", 0);
                if (l2 < 2) {
                    ys4.k().w("key_forum_broadcast_edit_tip_number", l2 + 1);
                    U3();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        V3();
                    } else {
                        BdTopToast bdTopToast = new BdTopToast(getContext());
                        bdTopToast.i(false);
                        bdTopToast.h(getContext().getString(R.string.obfuscated_res_0x7f0f0656));
                        bdTopToast.j(this.t.n0());
                    }
                } else {
                    V3();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(y2()) && !this.A0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        W3();
                    } else if (Build.VERSION.SDK_INT < 23 || !ys4.k().h("key_forum_rule_dialog_show_frs", false)) {
                        W3();
                        ys4.k().u("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    W3();
                }
            }
            if (l25.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new pk6();
            int i3 = -1;
            jk6 jk6Var = this.m0;
            if (jk6Var != null && jk6Var.f() != null) {
                i3 = this.m0.f().C();
                arrayList = this.m0.f().B();
            }
            jk6 jk6Var2 = new jk6(this, this.J1);
            this.m0 = jk6Var2;
            jk6Var2.f().setHasMore(i3);
            if (arrayList != null && arrayList.size() > 0) {
                this.m0.f().M(arrayList);
            }
            this.Y = new hm6(this);
            this.n0 = new lo6(this);
            this.k0 = new co6(getPageContext(), this.U.q0());
            this.Z = new ik6(this);
            this.l0 = new kk6(this);
            this.X = new ok6(this);
            this.o0 = new hk6(this);
            this.r0 = new eo6(this);
            new lk6(this, getUniqueId());
            this.w0 = new fh5(getPageContext(), "frs");
            this.x0 = new km5(getPageContext());
            new lm6(getPageContext());
            registerListener(this.t1);
            registerListener(this.H1);
            registerListener(this.r1);
            registerListener(this.G1);
            registerListener(this.n1);
            registerListener(this.o1);
            registerListener(this.p1);
            registerListener(this.q1);
            registerListener(this.d1);
            registerListener(this.e1);
            registerListener(this.f1);
            registerListener(this.g1);
            registerListener(this.T1);
            registerListener(this.v1);
            this.w1.setSelfListener(true);
            this.w1.setTag(getPageContext().getUniqueId());
            registerListener(this.w1);
            registerListener(this.j1);
            registerListener(this.x1);
            registerListener(this.u1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            this.U1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.U1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.i1);
            registerListener(this.Y1);
            registerListener(this.y1);
            registerListener(this.h1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.c2);
            registerListener(this.D1);
            registerListener(this.E1);
            this.t.w0(false);
            if (!a3() && !this.A0) {
                showLoadingView(this.t.n0(), true);
                this.U.R(3, false);
            }
            mp6.a();
            d0 d0Var = new d0(this);
            wa6.f().s(d0Var);
            va6.h().s(d0Var);
            this.t.y1(new e0(this));
            this.G0 = UtilHelper.getScreenHeight(getActivity());
            this.A0 = true;
            s2(1);
            super.onActivityCreated(bundle);
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048689, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            hk6 hk6Var = this.o0;
            if (hk6Var != null) {
                hk6Var.n(i3, i4, intent);
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
                this.V.L(i3);
                this.W.X(i3);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i3);
                }
                so6 so6Var = this.s0;
                if (so6Var != null) {
                    so6Var.onChangeSkinType();
                }
                pe6 pe6Var = this.y0;
                if (pe6Var != null) {
                    pe6Var.d(getPageContext(), i3);
                }
                if (this.z0 != null) {
                    q85.a(getPageContext(), this.z0.getRealView());
                }
                go6 go6Var = this.t0;
                if (go6Var != null) {
                    go6Var.onChangeSkinType(getPageContext(), i3);
                }
                de6 de6Var = this.T0;
                if (de6Var != null) {
                    de6Var.onChangeSkinType(getPageContext(), i3);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bundle) == null) {
            super.onCreate(bundle);
            bf8.g().i(getUniqueId());
            if (this.P0 == null) {
                this.P0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.P0);
            registerResponsedEventListener(TopToastEvent.class, this.z1);
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
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ed, viewGroup, false);
                we6 we6Var = new we6();
                this.b = we6Var;
                this.j0 = we6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0749);
                this.V = new jo6(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090d00));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.M1);
                this.W = frsTabViewController;
                frsTabViewController.c0();
                this.V.o0(this.W);
                this.W.g0(this.l1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.d = true;
                }
                this.t = new lb6(this, this.M1, this.b, this.d, this.V);
                this.y0 = new pe6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.c0();
                }
                this.t.X0();
                this.s.setLeft(0);
                this.s.setRight(li.k(TbadkCoreApplication.getInst().getContext()));
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
            bf8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.w1);
            unRegisterResponsedEventListener();
            this.n0.Z();
            f2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            a98.c("FRS");
            this.r = null;
            gw5.b().e(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null) {
                cc6.a().b(jg.g(this.y.getForum().getId(), 0L));
            }
            dk6 dk6Var = this.p0;
            if (dk6Var != null) {
                dk6Var.v();
            }
            lb6 lb6Var = this.t;
            if (lb6Var != null) {
                yn6.b(lb6Var, this.y, b(), false, null);
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
                mg.a().removeCallbacks(this.L0);
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
            this.V.I();
            Looper.myQueue().removeIdleHandler(this.c1);
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.i();
            }
            qc6 qc6Var = this.g0;
            if (qc6Var != null) {
                qc6Var.d();
            }
            co6 co6Var = this.k0;
            if (co6Var != null) {
                co6Var.i();
            }
            hm6 hm6Var = this.Y;
            if (hm6Var != null) {
                hm6Var.c();
            }
            go6 go6Var = this.t0;
            if (go6Var != null) {
                go6Var.g();
            }
            hk6 hk6Var = this.o0;
            if (hk6Var != null) {
                hk6Var.o();
            }
            fh5 fh5Var = this.w0;
            if (fh5Var != null) {
                fh5Var.h();
            }
            km5 km5Var = this.x0;
            if (km5Var != null) {
                km5Var.g();
            }
            y88.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.g0(null);
                this.W.P();
            }
            AddExperiencedModel addExperiencedModel = this.B0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            wa6.f().s(null);
            va6.h().s(null);
            on6 on6Var = this.S0;
            if (on6Var != null) {
                on6Var.d();
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
            d4();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public nn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? I2().getPreLoadHandle() : (nn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && a3()) {
            showLoadingView(this.t.n0(), true);
            this.t.z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.I0(3, true);
            I2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && li.D()) {
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
            jo6 jo6Var = this.V;
            if (jo6Var != null) {
                jo6Var.M();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.K0(true);
            co6 co6Var = this.k0;
            if (co6Var != null) {
                co6Var.j();
            }
            mh4.x().F();
            on6 on6Var = this.S0;
            if (on6Var != null) {
                on6Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                jo6 jo6Var = this.V;
                if (jo6Var != null) {
                    jo6Var.N(isPrimary());
                }
                lb6 lb6Var = this.t;
                if (lb6Var != null) {
                    lb6Var.R0(isPrimary());
                    this.t.K0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048700, this, i3, strArr, iArr) == null) {
            zn6.i(this, i3, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            super.onResume();
            int i3 = this.b1;
            if (i3 <= 1) {
                this.b1 = i3 + 1;
            }
            lb6 lb6Var = this.t;
            if (lb6Var != null) {
                lb6Var.J0();
                this.t.S0();
            }
            jo6 jo6Var = this.V;
            if (jo6Var != null) {
                jo6Var.O();
            }
            if (this.b1 > 1 && F2()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                G3(false);
            }
            this.X.f(true);
            this.P = true;
            if (e2) {
                e2 = false;
                lb6 lb6Var2 = this.t;
                if (lb6Var2 != null) {
                    lb6Var2.T1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            lb6 lb6Var3 = this.t;
            if (lb6Var3 != null) {
                lb6Var3.K0(false);
            }
            if (this.u0) {
                q3(6);
                this.u0 = false;
            }
            if (this.F0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    hx4.c().h(true);
                    hx4.c().i(this.F0.getHours(), this.F0.getMinutes());
                    if (this.t != null) {
                        hx4.c().k(i().getPageActivity(), this.t.n0());
                    }
                }
                this.F0 = null;
            }
            l4();
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
            if (!li.D()) {
                this.t.v0();
            } else if (this.U.d0() == 1) {
                d4();
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
        c4();
        this.t.J0();
        hf8 U = this.U.U();
        boolean isEmpty = ListUtils.isEmpty(this.y.getThreadList());
        if (U != null && isEmpty) {
            if (this.U.X() != 0) {
                this.U.R0();
                this.t.J0();
            } else {
                b4(U);
            }
            this.t.m1(this.y.isStarForum(), false);
            return;
        }
        b4(U);
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
            gw5.b().e(false);
            i3(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                iz4.j().x(getPageContext().getPageActivity(), "frs", this.y.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (I2() != null) {
                I2().getRecycledViewPool().clear();
            }
            this.V.K();
            jc5.c();
            k3();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    @Override // com.repackage.sk6
    public jk6 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.m0 : (jk6) invokeV.objValue;
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            if (!n2() && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                E3(this.y.getPrivateForumTotalInfo().a().private_forum_audit_status, this.y.getPrivateForumTotalInfo().b(), false);
            } else {
                E3(null, null, true);
            }
        }
    }

    public final void p3(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048710, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.y != null && this.W != null && this.U != null) {
                    if (!this.t.W().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.y.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.y.getGameTabInfo());
                    this.t.p1(isEmpty);
                    if (!isEmpty) {
                        if (this.t0 == null) {
                            this.t0 = new go6(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.v0 == null) {
                            this.v0 = new ni6(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                        g2(true, z2);
                    } else {
                        g2(this.P, z2);
                    }
                    t3();
                    if (this.j0 != null) {
                        this.j0.a(this.V, this.y);
                    }
                    if (this.y.getPage() != null) {
                        D3(this.y.getPage().b());
                    }
                    ArrayList<jn> d2 = this.m0.d(z3, true, this.y.getThreadList(), null, z2, false, this.y.adShowSelect, this.y.adMixFloor);
                    if (d2 != null) {
                        this.y.setThreadList(d2);
                    }
                    this.y.removeRedundantUserRecommendData();
                    int topThreadSize = this.y.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        kn6.a(this, this.y.getForum(), this.y.getThreadList(), this.n, K2());
                    }
                    if (this.U.d0() == 1) {
                        s3();
                        if (!z2 && this.U.getPn() == 1) {
                            x3();
                        }
                    }
                    if (this.k0 != null) {
                        this.k0.k(this.W.H());
                    }
                    c4();
                    this.t.e1();
                    this.t.m1(true, false);
                    if (z2 && this.y.isFirstTabEqualAllThread()) {
                        mg.a().post(new z(this));
                    }
                    if (this.y.getForum() != null) {
                        this.t.N(this.y.getForum().getWarningMsg());
                    }
                    if (this.y != null && this.y.getFrsVideoActivityData() != null && ys4.k().m("frs_video_activity_guide", 0L) == 0) {
                        mg.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.F1();
                    this.y0.e(this.y.bottomMenuList, this.y.getForum());
                    l4();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void p4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i3) == null) {
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
                    bo6.a(this, 0);
                } else {
                    this.t.P1();
                }
            }
        }
    }

    @Override // com.repackage.jc6
    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048712, this) == null) && isAdded() && this.i0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.n0(), true);
        }
    }

    public final void q2(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<jn> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        Iterator<jn> it = threadList.iterator();
        List<jn> data = this.t.c0().getData();
        int i3 = 0;
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof rp4) {
                ThreadData threadData = ((rp4) next).s;
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

    public void q3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i3) == null) {
            this.N = false;
            m4();
            lb6 lb6Var = this.t;
            if (lb6Var != null && lb6Var.k0() != null) {
                this.t.k0().x();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.I0(i3, true);
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048715, this) == null) || ListUtils.isEmpty(va6.h().i()) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        ArrayList<jn> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<jn> it = threadList.iterator();
        List<jn> data = this.t.c0().getData();
        int count = ListUtils.getCount(va6.h().i());
        int i3 = 0;
        while (it.hasNext()) {
            jn next = it.next();
            if (next instanceof rp4) {
                ThreadData threadData = ((rp4) next).s;
                int i4 = 0;
                while (true) {
                    if (i4 >= count) {
                        break;
                    } else if (StringHelper.equals(va6.h().i().get(i4).getId(), threadData.getId())) {
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

    public void r3() {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048716, this) == null) || (lb6Var = this.t) == null) {
            return;
        }
        lb6Var.Z0();
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            ai5.c().f("page_frs");
            q3(3);
        }
    }

    @Override // com.repackage.n78
    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            jk6 jk6Var = this.m0;
            if (jk6Var == null) {
                return 1;
            }
            return jk6Var.g();
        }
        return invokeV.intValue;
    }

    public final void s2(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i3) == null) {
            FrsViewData frsViewData = this.y;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.y.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            m4();
            try {
                if (this.y == null) {
                    return;
                }
                this.t.K1();
                this.t.S1(k2());
                if (this.y.getForum() != null) {
                    this.f = this.y.getForum().getName();
                    this.l = this.y.getForum().getId();
                }
                if (this.y.getPage() != null) {
                    D3(this.y.getPage().b());
                }
                this.t.E1(this.f);
                this.t.j1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.y.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.y.getUserData().getBimg_end_time());
                o3();
                O3();
                ArrayList<jn> threadList = this.y.getThreadList();
                if (threadList != null) {
                    this.t.D1(threadList, this.y);
                    mn6.b(this.t);
                    this.V.m0(s0());
                    this.y.setFrsFragmentTag(getUniqueId());
                    this.V.U(this.y);
                    this.W.d(this.y, this.U.T());
                    this.t.f1();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.g = str;
        }
    }

    @Override // com.repackage.tg5
    public void setInjectPlugin(int i3, sg5 sg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048722, this, i3, sg5Var) == null) {
            this.h0.put(i3, sg5Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeLZ(1048724, this, view2, z2) == null) {
            this.t.k1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view2, true);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048725, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.obfuscated_res_0x7f0f0f95), null, getResources().getString(R.string.obfuscated_res_0x7f0f0f94), z2, getNetRefreshListener());
            this.t.k1(8);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048726, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.k1(8);
        }
    }

    public final void t2(long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048727, this, j3) == null) || j3 <= 0) {
            return;
        }
        mg.a().postDelayed(new j0(this, j3, li.k(TbadkCoreApplication.getInst()), li.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public boolean t3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            jo6 jo6Var = this.V;
            if (jo6Var != null && (frsModelController = this.U) != null) {
                jo6Var.s0(frsModelController.b0(), this.y);
            }
            FrsViewData frsViewData2 = this.y;
            boolean hasTab = frsViewData2 != null ? frsViewData2.hasTab() : false;
            h2();
            lb6 lb6Var = this.t;
            if (lb6Var != null) {
                lb6Var.z0();
                this.t.A0();
                FrsViewData frsViewData3 = this.y;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.V0 = qn6.j(this.y.getBusinessPromot(), this.y.getForum().getId());
                }
                if (!this.V0 && (frsViewData = this.y) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.y0(this.y.getActivityHeadData().a());
                    if (this.y.getActivityHeadData().a() != null && !this.U0 && !this.V0 && !this.W0 && !E2()) {
                        Y3();
                    }
                } else {
                    this.t.y0(null);
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            this.t.T1();
        }
    }

    public final void u3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i3) == null) {
            t3();
            m4();
            try {
                if (this.y == null) {
                    return;
                }
                uc6 uc6Var = null;
                this.t.D1(null, this.y);
                this.V.m0(1);
                this.t.f1();
                this.W.d(this.y, this.U.T());
                um6 K = this.W.K(this.y.getFrsDefaultTabId());
                if (K != null && !TextUtils.isEmpty(K.d)) {
                    uc6Var = new uc6();
                    String str = K.d;
                    String str2 = K.a;
                }
                this.U.s(this.y.getFrsDefaultTabId(), 0, uc6Var);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public fg6 v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.j0 : (fg6) invokeV.objValue;
    }

    public void v3() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && (frsModelController = this.U) != null && frsModelController.d0() == 1) {
            this.V.Y(this.y);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? xc5.a(2) : invokeV.booleanValue;
    }

    public final void w2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048735, this, intent) == null) || intent == null) {
            return;
        }
        if (!wn6.a(this, a(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
            BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.I1);
        } else {
            rn6 b2 = zn6.b(intent);
            if (b2 != null) {
                this.f = b2.a;
            }
        }
        if (!StringUtils.isNull(this.f)) {
            intent.putExtra("name", this.f);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public final void w3(pf8 pf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, pf8Var) == null) {
            try {
                if (!this.N && pf8Var != null && this.y != null) {
                    this.y.receiveData(pf8Var);
                    p3(true, false);
                    Looper.myQueue().addIdleHandler(this.c1);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public ForumWriteData x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
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
            forumWriteData.frsTabInfo = N2();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if (this.p0 == null) {
                this.p0 = new dk6(this, jg.e(this.l, 0));
            }
            this.p0.w();
        }
    }

    @Override // com.repackage.n78
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    @Override // com.repackage.sk6
    public lb6 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.t : (lb6) invokeV.objValue;
    }

    public String y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public void y3(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) || (frsTabViewController = this.W) == null) {
            return;
        }
        frsTabViewController.v = z2;
    }

    @Override // com.repackage.jc6
    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && isAdded() && this.i0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.n0());
        }
    }

    public tn z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.R1 : (tn) invokeV.objValue;
    }

    public void z3() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.p C;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (frsTabViewController = this.W) == null || (C = frsTabViewController.C()) == null || (fragment = C.b) == null || !(fragment instanceof lc6)) {
            return;
        }
        ((lc6) fragment).B0();
    }
}
