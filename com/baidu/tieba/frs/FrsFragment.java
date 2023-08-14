package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
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
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingLifecycleHelper;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.leveiconlivepolling.PollingReqMessage;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tbadk.coreExtra.messageCenter.SignManager;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.aaa;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ag;
import com.baidu.tieba.ak7;
import com.baidu.tieba.at7;
import com.baidu.tieba.au7;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bi;
import com.baidu.tieba.c36;
import com.baidu.tieba.cf7;
import com.baidu.tieba.ck7;
import com.baidu.tieba.cn;
import com.baidu.tieba.ct7;
import com.baidu.tieba.cu7;
import com.baidu.tieba.d56;
import com.baidu.tieba.d96;
import com.baidu.tieba.database.FrsVisitedInfoManager;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.dh7;
import com.baidu.tieba.do5;
import com.baidu.tieba.dt4;
import com.baidu.tieba.dw7;
import com.baidu.tieba.eo5;
import com.baidu.tieba.es7;
import com.baidu.tieba.et4;
import com.baidu.tieba.et7;
import com.baidu.tieba.f1c;
import com.baidu.tieba.fg7;
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
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsRedpackRunView;
import com.baidu.tieba.frs.view.FrsTopBarGroupEntranceGuideView;
import com.baidu.tieba.fs7;
import com.baidu.tieba.ft7;
import com.baidu.tieba.fv7;
import com.baidu.tieba.g36;
import com.baidu.tieba.go5;
import com.baidu.tieba.gs6;
import com.baidu.tieba.gw5;
import com.baidu.tieba.h36;
import com.baidu.tieba.h55;
import com.baidu.tieba.h9;
import com.baidu.tieba.hi7;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.iaa;
import com.baidu.tieba.iba;
import com.baidu.tieba.ii7;
import com.baidu.tieba.in;
import com.baidu.tieba.ix9;
import com.baidu.tieba.j36;
import com.baidu.tieba.j85;
import com.baidu.tieba.jk5;
import com.baidu.tieba.jo7;
import com.baidu.tieba.k36;
import com.baidu.tieba.k46;
import com.baidu.tieba.kg;
import com.baidu.tieba.ko7;
import com.baidu.tieba.ks5;
import com.baidu.tieba.kt7;
import com.baidu.tieba.kv7;
import com.baidu.tieba.lq7;
import com.baidu.tieba.lt7;
import com.baidu.tieba.lu7;
import com.baidu.tieba.m15;
import com.baidu.tieba.m1c;
import com.baidu.tieba.m45;
import com.baidu.tieba.mf7;
import com.baidu.tieba.mo7;
import com.baidu.tieba.mt7;
import com.baidu.tieba.nf7;
import com.baidu.tieba.ng7;
import com.baidu.tieba.no7;
import com.baidu.tieba.nt7;
import com.baidu.tieba.o26;
import com.baidu.tieba.oi7;
import com.baidu.tieba.om7;
import com.baidu.tieba.oo7;
import com.baidu.tieba.or5;
import com.baidu.tieba.ot7;
import com.baidu.tieba.p26;
import com.baidu.tieba.paa;
import com.baidu.tieba.pg7;
import com.baidu.tieba.po7;
import com.baidu.tieba.pq7;
import com.baidu.tieba.pt7;
import com.baidu.tieba.q1c;
import com.baidu.tieba.q26;
import com.baidu.tieba.qg7;
import com.baidu.tieba.qo7;
import com.baidu.tieba.qq7;
import com.baidu.tieba.r1c;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.ro7;
import com.baidu.tieba.rq7;
import com.baidu.tieba.rt7;
import com.baidu.tieba.sca;
import com.baidu.tieba.sf7;
import com.baidu.tieba.sg7;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sm7;
import com.baidu.tieba.sq7;
import com.baidu.tieba.st7;
import com.baidu.tieba.t15;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg7;
import com.baidu.tieba.to7;
import com.baidu.tieba.tq7;
import com.baidu.tieba.tt7;
import com.baidu.tieba.u15;
import com.baidu.tieba.u9a;
import com.baidu.tieba.ug7;
import com.baidu.tieba.uo7;
import com.baidu.tieba.us7;
import com.baidu.tieba.vca;
import com.baidu.tieba.vh7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.vm6;
import com.baidu.tieba.vo7;
import com.baidu.tieba.vs7;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vy;
import com.baidu.tieba.w35;
import com.baidu.tieba.wg7;
import com.baidu.tieba.wn6;
import com.baidu.tieba.xe7;
import com.baidu.tieba.xo7;
import com.baidu.tieba.xp7;
import com.baidu.tieba.xt7;
import com.baidu.tieba.y0c;
import com.baidu.tieba.ye7;
import com.baidu.tieba.yg7;
import com.baidu.tieba.ym;
import com.baidu.tieba.yo7;
import com.baidu.tieba.ys7;
import com.baidu.tieba.z36;
import com.baidu.tieba.z3a;
import com.baidu.tieba.zd5;
import com.baidu.tieba.zy9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.TopbarEntrance;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.i, mo7, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, tg7, ix9, yo7, q26, ng7, qg7 {
    public static /* synthetic */ Interceptable $ic;
    public static String A2;
    public static final String q2;
    public static final String r2;
    public static boolean s2;
    public static final ThreadData t2;
    public static iaa u2;
    public static volatile long v2;
    public static volatile long w2;
    public static volatile int x2;
    public static boolean y2;
    public static boolean z2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<TbImageView> A;
    public hi7 A0;
    public CustomMessageListener A1;
    public long B;
    public m45 B0;
    public CustomMessageListener B1;
    public long C;
    public boolean C0;
    public CustomMessageListener C1;
    public long D;
    public AddExperiencedModel D0;
    public CustomMessageListener D1;
    public long E;
    public boolean E0;
    public HttpMessageListener E1;
    public long F;
    public boolean F0;
    public ResponsedEventListener F1;
    public long G;
    public boolean G0;
    public final CustomMessageListener G1;
    public long H;
    public Date H0;
    public CustomMessageListener H1;
    public long I;
    public int I0;
    public final CustomMessageListener I1;
    public boolean J;
    public int J0;
    public CustomMessageListener J1;
    public int K;
    public int K0;
    public CustomMessageListener K1;
    public boolean L;
    public List<LiveHorseRaceData> L0;
    public CustomMessageListener L1;
    public boolean M;
    public ValueAnimator M0;
    public final paa M1;
    public boolean N;
    public Runnable N0;
    public final CustomMessageListener N1;
    public or5 O;
    public int O0;
    public final CustomMessageListener O1;
    public boolean P;
    public ko7 P0;
    public final CustomMessageListener P1;
    @Nullable
    public go5.b Q;
    public ii7 Q0;
    public CustomMessageListener Q1;
    public boolean R;
    @Nullable
    public TiePlusEventController R0;
    public final Runnable R1;
    public String S;
    public int S0;
    public final Runnable S1;

    /* renamed from: T  reason: collision with root package name */
    public vy.a f1096T;
    public int T0;
    public final BdUniDispatchSchemeController.OnSchemeParsedCallback T1;
    public ThreadCardViewHolder U;
    public ct7 U0;
    public final xo7 U1;
    public FrsModelController V;
    public vh7 V0;
    public final View.OnTouchListener V1;
    public au7 W;
    public boolean W0;
    public final View.OnClickListener W1;
    public FrsTabViewController X;
    public boolean X0;
    public final View.OnClickListener X1;
    public uo7 Y;
    public boolean Y0;
    public final RecyclerView.OnScrollListener Y1;
    public lq7 Z;
    public Object Z0;
    public final cf7 Z1;
    public String a;
    public oo7 a0;
    public PollingModel a1;
    public final NoNetworkView.b a2;
    public oi7 b;
    public ug7 b0;
    public eo5 b1;
    public Runnable b2;
    public boolean c;
    public SparseArray<p26> c0;
    public boolean c1;
    public final CustomMessageListener c2;
    public boolean d;
    public boolean d0;
    public boolean d1;
    public in d2;
    public boolean e;
    public ck7 e0;
    public boolean e1;
    public sg7 e2;
    public String f;
    public tt7 f0;
    public int f1;
    public CustomMessageListener f2;
    public String g;
    public qo7 g0;
    public int g1;
    public CustomMessageListener g2;
    public int h;
    public po7 h0;
    public long h1;
    public CustomMessageListener h2;
    public boolean i;
    public cu7 i0;
    public MessageQueue.IdleHandler i1;
    public CustomMessageListener i2;
    public boolean j;
    public no7 j0;
    public f1c j1;
    public CustomMessageListener j2;
    public String k;
    public final CustomMessageListener k1;
    public CustomMessageListener k2;
    public String l;
    public CustomMessageListener l1;
    public CustomMessageListener l2;
    public int m;
    public CustomMessageListener m1;
    public CustomMessageListener m2;
    public boolean n;
    public CustomMessageListener n1;
    public HttpMessageListener n2;
    public iba o;
    public CustomMessageListener o1;
    public CustomMessageListener o2;
    public boolean p;
    public NetMessageListener p1;
    public kv7 p2;
    public boolean q;
    public CustomMessageListener q1;
    public VoiceManager r;
    public jo7 r0;
    public final sg7 r1;
    public View s;
    public mf7 s0;
    public FrsTabViewController.h s1;
    public nf7 t;
    public vt7 t0;
    public int t1;
    public OvalActionButton u;
    public lu7 u0;
    public CustomMessageListener u1;
    public FRSRefreshButton v;
    public xt7 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public boolean w0;
    public final CustomMessageListener w1;
    public FrsViewData x;
    public om7 x0;
    public final CustomMessageListener x1;
    public String y;
    public c36 y0;
    public final CustomMessageListener y1;
    public boolean z;
    public d96 z0;
    public final AntiHelper.k z1;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    public final boolean t3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048723, this, i2)) == null) ? (i2 == 506 || i2 == 507) ? false : true : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class n0 implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ n0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$n0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0297a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0297a(a aVar, long j, int i, int i2, float f, int i3) {
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

            public a(n0 n0Var, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = n0Var;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.X.b(301);
                    long j = JavaTypesHelper.toLong((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L);
                    int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    SafeHandler.getInst().postDelayed(new RunnableC0297a(this, j, equipmentWidth, equipmentHeight, f, i), 1000L);
                }
            }
        }

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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_KW) instanceof String) {
                this.a.f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_KW);
            }
            if ((hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID))) {
                SafeHandler.getInst().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements sg7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b1 a;

            public a(b1 b1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = b1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.L0()) {
                    this.a.a.c();
                }
            }
        }

        public b1(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.sg7
        public void a(int i, int i2, dh7 dh7Var, ArrayList<ym> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), dh7Var, arrayList}) == null) {
                SafeHandler.getInst().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements h36.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements m45.e {
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

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) && m45Var != null) {
                    m45Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements m45.e {
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

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) && m45Var != null) {
                    m45Var.dismiss();
                }
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

        @Override // com.baidu.tieba.h36.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            String string;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) != null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.t.W();
            this.a.t.V();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.a.X != null && this.a.X.B() != null && (this.a.X.B().b instanceof FrsNewAreaFragment)) {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.X.B().b;
                z = true;
            } else {
                z = false;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                if (!TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText())) {
                    string = deleteThreadHttpResponseMessage.getText();
                } else {
                    string = this.a.getString(R.string.delete_fail);
                }
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.B0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.B0 = new m45(frsFragment.getActivity());
                    }
                    this.a.B0.setMessage(string);
                    this.a.B0.setPositiveButton(R.string.dialog_known, new a(this));
                    this.a.B0.setCanceledOnTouchOutside(false);
                    this.a.B0.create(this.a.getPageContext());
                    this.a.B0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.B0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.B0 = new m45(frsFragment2.getActivity());
                    }
                    this.a.B0.setMessage(string);
                    this.a.B0.setPositiveButton(R.string.obfuscated_res_0x7f0f0b3e, new b(this));
                    this.a.B0.setCanceledOnTouchOutside(false);
                    this.a.B0.create(this.a.getPageContext());
                    this.a.B0.show();
                } else {
                    Context context = this.a.getContext();
                    if (deleteThreadHttpResponseMessage.getRetType() == 1) {
                        i = R.color.nav_bar_tip_error;
                    } else {
                        i = R.color.cp_link_tip_a_alpha95;
                    }
                    this.a.t.W1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(context, i));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.z2(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.x3(deleteThreadHttpResponseMessage.getSuccessItems());
                ye7.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (ym ymVar : this.a.x.getThreadList()) {
                    if (ymVar instanceof w35) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.a.c();
                    return;
                }
                return;
            }
            BdUtilHelper.showToast(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class q1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q1 a;

            public a(q1 q1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.a.a.x.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.getContext(), "ForumGradePage", hashMap)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q1(FrsFragment frsFragment, int i) {
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
                    forumBroadcastHelper.jumpFlutterEditGenear(this.a.x.getForum().getId(), this.a.x.getForum().getName(), "6");
                    forumBroadcastHelper.clipCopy(this.a.S);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                screenTopToast.m(this.a.getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(this.a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090c47));
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class v1 implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public a(v1 v1Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v1Var, str};
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

        public v1(FrsFragment frsFragment) {
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

        public /* synthetic */ v1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == sf7.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.c2();
                }
            } else if (ymVar != null && (ymVar instanceof w35)) {
                ThreadData threadData = ((w35) ymVar).t;
                if (threadData.getAnchorInfoData() != null && threadData.getAnchorInfoData().getGroup_id() != 0 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getActInfoType() == 1 && !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    return;
                }
                if (threadData.getAppCodeData() != null) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        return;
                    }
                    String a2 = threadData.getAppCodeData().a();
                    if (!StringUtils.isNull(a2) && BdUtilHelper.isNetOk()) {
                        BrowserHelper.startInternalWebActivity(this.a.getActivity(), a2);
                    }
                } else if (threadData.getCartoonThreadData() != null) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    m15 cartoonThreadData = threadData.getCartoonThreadData();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                } else {
                    vca readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                    }
                    String ad_url = threadData.getAd_url();
                    if (ad_url != null && !ad_url.equals("")) {
                        gs6.a(new a(this, ad_url), "requestAdFrs", 3);
                        z = true;
                    } else {
                        z = false;
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
                        ot7.c(threadData.getTaskInfoData());
                    } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                    }
                    pt7.f(this.a, threadData, i, z);
                    FrsFragment frsFragment = this.a;
                    ot7.d(frsFragment, frsFragment.x, threadData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements FrsTabViewController.h {
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

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.h
        public void a(int i, int i2, String str, boolean z) {
            boolean z2;
            sm7 w1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                boolean z3 = false;
                if (i != 1) {
                    vm6.b().e(false);
                    this.a.u4(false);
                }
                this.a.u.setIconFade(0);
                if ((this.a.getActivity() instanceof FrsActivity) && (w1 = ((FrsActivity) this.a.getActivity()).w1()) != null) {
                    w1.M0(i);
                }
                this.a.t1 = i;
                this.a.S0 = i2;
                if (this.a.P0 != null) {
                    this.a.P0.d(this.a.S0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.S0);
                this.a.y5();
                rq7 rq7Var = tq7.q0;
                rq7Var.e = i;
                rq7Var.h = i2;
                rq7Var.f = -1;
                if (this.a.E0) {
                    ye7 f = ye7.f();
                    if (i == 1 && this.a.E0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    f.p(z2, true);
                    xe7 h = xe7.h();
                    if (i == 1 && this.a.E0) {
                        z3 = true;
                    }
                    h.p(z3, true);
                    return;
                }
                nf7 nf7Var = this.a.t;
                if (!z && this.a.t3(i)) {
                    z3 = true;
                }
                nf7Var.b2(z3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(FrsFragment frsFragment, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.x.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.a.t.a0().notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public a1(FrsFragment frsFragment) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.X != null) {
                FrsTabViewController.i B = this.a.X.B();
                if (B != null && (fragment = B.b) != null && (fragment instanceof pg7)) {
                    ((pg7) fragment).E1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    SafeHandler.getInst().postDelayed(this.a.b2, 500L);
                    return;
                }
                this.a.z1().c2();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.X.k0(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.o5();
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && this.a.x != null) {
                st7.b(this.a.x, this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.a.x != null && (userData = this.a.x.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    this.a.W.n0(num);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.v != null && this.a.u != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    this.a.v.setVisibility(8);
                    this.a.u.setVisibility(8);
                    return;
                }
                this.a.u.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.X.b(49);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(FrsFragment frsFragment, int i) {
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
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue != 1 && intValue != 2) {
                    return;
                }
                this.a.U3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(FrsFragment frsFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.w0 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.X.b(1);
                this.a.B3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(FrsFragment frsFragment, int i) {
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
                    if (this.a.U == null && this.a.t.o0() != null && !this.a.t.e0() && this.a.t.o0().j() != null && (this.a.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.U = (ThreadCardViewHolder) frsFragment.t.o0().j().getTag();
                    }
                    if (this.a.U != null && this.a.U.b() != null) {
                        this.a.U.b().p(new vy.a(3));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData) && this.a.x != null) {
                this.a.x.updateLikeData((LikeReturnData) customResponsedMessage.getData());
                this.a.W.q0(this.a.x);
                this.a.X.d(this.a.x, this.a.V.i0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements PollingLifecycleHelper.a {
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

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingLifecycleHelper.a
        public void onLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PollingReqMessage pollingReqMessage = new PollingReqMessage();
                pollingReqMessage.setDataType(PollingModel.ACTIVITY_BROADCAST);
                pollingReqMessage.setForumName(this.a.v());
                pollingReqMessage.setTag(this.a.getUniqueId());
                MessageManager.getInstance().sendMessage(pollingReqMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f1(FrsFragment frsFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.t != null) {
                this.a.t.c1();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onNavigationButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.x != null) {
                this.a.x.removeGameRankListFromThreadList();
                if (this.a.t != null) {
                    this.a.t.P0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !this.a.isResumed()) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.v != null && booleanValue && this.a.X.K() != 0 && !this.a.t.O0() && !jk5.h().k()) {
                this.a.v.f();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getPageContext().getUniqueId()) && updateAttentionMessage.getData().blockData != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, this.a.z1) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements m1c<NewsRemindMessage> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m1c
        public void call(NewsRemindMessage newsRemindMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, newsRemindMessage) == null) {
                this.a.K = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                FrsFragment frsFragment = this.a;
                if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                    z = false;
                } else {
                    z = true;
                }
                frsFragment.L = z;
                if (this.a.t != null) {
                    this.a.t.i1(this.a.K, this.a.L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveHorseRaceData a;
        public final /* synthetic */ FrsFragment b;

        public h1(FrsFragment frsFragment, LiveHorseRaceData liveHorseRaceData) {
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
                if (this.b.x != null && this.b.x.getForum() != null) {
                    str = this.b.x.getForum().getName();
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class i0 implements q1c<Pair<NewsRemindMessage, Boolean>, NewsRemindMessage> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public NewsRemindMessage call(Pair<NewsRemindMessage, Boolean> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) {
                return pair.first;
            }
            return (NewsRemindMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public i1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || !valueAnimator.isRunning()) {
                return;
            }
            this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.a.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                return;
            }
            this.a.t.Z1((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements q1c<NewsRemindMessage, Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public Boolean call(NewsRemindMessage newsRemindMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, newsRemindMessage)) == null) {
                if (newsRemindMessage != null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

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

        public j1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
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
                if (this.b.L0 != null && this.b.K0 > this.b.L0.size() - 1) {
                    this.b.w.removeAllViews();
                    this.b.w.setVisibility(8);
                    this.b.K0 = 0;
                    return;
                }
                this.b.g4();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.H4();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements r1c<NewsRemindMessage, Boolean, Pair<NewsRemindMessage, Boolean>> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r1c
        public Pair<NewsRemindMessage, Boolean> call(NewsRemindMessage newsRemindMessage, Boolean bool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, newsRemindMessage, bool)) == null) {
                return Pair.create(newsRemindMessage, bool);
            }
            return (Pair) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;
        public final /* synthetic */ FrsFragment b;

        public k1(FrsFragment frsFragment, FrsRedpackRunView frsRedpackRunView) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.w != null && this.a != null) {
                this.b.M0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.j0.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.x.getToLoadHorseData().intValue() == 1 && this.a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.a.l));
                this.a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends HttpMessageListener {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && this.a.getContext() != null && this.a.t != null) {
                int i = 0;
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f084a)).show(this.a.t.r0());
                    if (xe7.h().k(xe7.h().e())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (this.a.X != null && this.a.X.B() != null && (this.a.X.B().b instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) this.a.X.B().b;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.e2();
                        }
                        this.a.y3();
                        xe7.h().d();
                        for (ym ymVar : this.a.x.getThreadList()) {
                            if (ymVar instanceof w35) {
                                i++;
                                continue;
                            }
                            if (i >= 6) {
                                break;
                            }
                        }
                        if (i < 6) {
                            this.a.c();
                        }
                    }
                    xe7.h().n();
                    return;
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show(this.a.t.r0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a1 != null) {
                this.a.a1.getData(PollingModel.MEMBER_BROADCAST);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.a.H0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public n(FrsFragment frsFragment) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.uo5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.t.r0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.v != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.X.B() != null && (this.a.X.B().b instanceof BaseFragment) && ((BaseFragment) this.a.X.B().b).isPrimary() && !this.a.t.O0()) {
                    this.a.w.setVisibility(0);
                    this.a.J = false;
                    return;
                }
                this.a.w.setVisibility(8);
                this.a.J = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(FrsFragment frsFragment, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.isResumed()) {
                return;
            }
            this.a.x5();
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements xo7 {
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

        @Override // com.baidu.tieba.xo7
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<ym> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) && this.a.Z != null && this.a.V != null && this.a.V.L0() && z && !z2 && !z3) {
                this.a.Z.a(i2);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t15) && this.a.isResumed()) {
                t15 t15Var = (t15) customResponsedMessage.getData();
                if (this.a.Q0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.Q0 = new ii7(frsFragment.getPageContext());
                }
                if (this.a.x != null && this.a.x.getForum() != null && !TextUtils.isEmpty(this.a.x.getForum().getId())) {
                    this.a.Q0.j(t15Var.a, this.a.x.getForum().getId(), this.a.x.getForum().getName(), t15Var.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.t != null) {
                    this.a.t.p1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.b0 != null && this.a.b0.e() != null) {
                    this.a.b0.e().c(motionEvent);
                }
                if (this.a.x0 != null) {
                    this.a.x0.b(view2, motionEvent);
                }
                if (this.a.W != null) {
                    this.a.W.l0(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (threadData = (ThreadData) customResponsedMessage.getData()) != null && this.a.isResumed()) {
                FrsFragment frsFragment = this.a;
                frsFragment.S = threadData.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", threadData.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !bi.isEmpty(str) && str.equals(this.a.l)) {
                    kt7.e(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.x);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrsFragment f;

        public q0(FrsFragment frsFragment, long j, int i, int i2, float f, int i3) {
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.t != null) {
                this.a.t.S();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.v != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.X.K() != 0 && this.a.X.B() != null && (this.a.X.B().b instanceof BaseFragment) && ((BaseFragment) this.a.X.B().b).isPrimary() && !this.a.t.O0() && !jk5.h().k()) {
                    this.a.v.f();
                } else if (this.a.X.K() != 0) {
                    this.a.v.b();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r1(FrsFragment frsFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                j36 j36Var = (j36) customResponsedMessage.getData();
                int i = 0;
                if (this.a.x != null && this.a.x.getForum() != null && this.a.x.getForum().getDeletedReasonInfo() != null) {
                    int intValue = this.a.x.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
                    int intValue2 = this.a.x.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
                    if (this.a.x.forumRule != null) {
                        i = this.a.x.forumRule.has_forum_rule.intValue();
                    }
                    k36 k36Var = new k36(intValue, intValue2, i);
                    k36Var.i(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                    k36Var.h(this.a.x.getForum().getImage_url());
                    k36Var.j(this.a.x.getForum().getUser_level());
                    g36.d(k36Var.f(), this.a.getPageContext(), j36Var, k36Var, this.a.x.getUserData());
                    return;
                }
                g36.d(0, this.a.getPageContext(), j36Var, null, this.a.x.getUserData());
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.m5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sca.o(this.a.f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s1(FrsFragment frsFragment, int i, int i2) {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage;
            if (!z && !(responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                return;
            }
            List<LiveHorseRaceData> arrayList = new ArrayList<>();
            if (z) {
                arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().a();
            }
            if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().a();
            }
            if (this.a.L0 == null) {
                this.a.L0 = new ArrayList();
                this.a.K0 = 0;
                this.a.L0.addAll(arrayList);
                this.a.g4();
            } else if (this.a.w != null && this.a.w.getVisibility() == 8) {
                this.a.L0 = new ArrayList();
                this.a.L0.addAll(arrayList);
                this.a.K0 = 0;
                this.a.g4();
            } else if (this.a.K0 < this.a.L0.size()) {
                FrsFragment frsFragment = this.a;
                frsFragment.L0 = frsFragment.L0.subList(0, this.a.K0);
                this.a.L0.addAll(arrayList);
            } else {
                this.a.L0.addAll(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                mt7.d(this.a.getActivity(), this.a.x);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s4();
        }
    }

    /* loaded from: classes5.dex */
    public class t1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t1(FrsFragment frsFragment, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Integer) || Integer.parseInt(data.toString()) != 1) {
                return;
            }
            this.a.B3();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        }
    }

    /* loaded from: classes5.dex */
    public class u implements paa {
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

        @Override // com.baidu.tieba.paa
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.b.t.Q0();
                }
            }
        }

        @Override // com.baidu.tieba.paa
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.H4();
            }
        }

        @Override // com.baidu.tieba.paa
        public void c(iaa iaaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iaaVar) == null) {
                if ((iaaVar != null && ("normal_page".equals(this.b.V.r0()) || "frs_page".equals(this.b.V.r0()) || "book_page".equals(this.b.V.r0()))) || "brand_page".equals(this.b.V.r0())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iaaVar));
                    this.b.I4(iaaVar);
                    FrsFragment.u2 = iaaVar;
                }
            }
        }

        @Override // com.baidu.tieba.paa
        public void d(int i, boolean z, aaa aaaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), aaaVar}) == null) {
                if (this.b.d0) {
                    this.b.d0 = false;
                    ot7.b(this.b.t, this.b.x, this.b.w(), false, null);
                }
                this.b.q5();
                this.b.N = true;
                if (aaaVar != null && aaaVar.b) {
                    this.b.t.a0().m(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.v2 = 0L;
                    FrsFragment.w2 = 0L;
                    FrsFragment.x2 = 0;
                } else {
                    FrsFragment.x2 = 1;
                }
                if (!this.b.V.L0() && (i == 3 || i == 6)) {
                    this.b.h0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.V.v0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.x = frsFragment.V.v0();
                }
                mt7.h(this.b.getContext(), 1, this.b.x);
                mt7.d(this.b.getActivity(), this.b.x);
                if (i == 7) {
                    this.b.G4(this.b.x.getFrsDefaultTabId());
                    return;
                }
                if (this.b.x.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.V4(frsFragment2.x.getPage().b());
                }
                if (i != 4) {
                    this.b.s5();
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 || i == 6) {
                                if (this.b.x != null) {
                                    this.b.x.clearPostThreadCount();
                                }
                                vt7 vt7Var = this.b.t0;
                                if (vt7Var != null) {
                                    vt7Var.d();
                                }
                            }
                        } else {
                            this.b.t.Q0();
                        }
                    } else {
                        this.b.t.Q0();
                    }
                    mt7.i(this.b.x, this.b.t);
                    if (aaaVar != null && aaaVar.c != 0) {
                        if (this.b.x == null || ListUtils.isEmpty(this.b.x.getThreadList())) {
                            this.b.p5(aaaVar);
                        } else if (aaaVar.a) {
                            FrsFragment frsFragment3 = this.b;
                            frsFragment3.showToast(frsFragment3.getPageContext().getResources().getString(R.string.net_error_text, aaaVar.d, Integer.valueOf(aaaVar.c)));
                        }
                    } else if (this.b.x != null) {
                        this.b.z = true;
                        if (this.b.u() != null) {
                            FrsFragment frsFragment4 = this.b;
                            if (!frsFragment4.k5(frsFragment4.x, this.b.u())) {
                                this.b.U3();
                                if (LooperBlockSwitch.getIsOn()) {
                                    this.b.A4();
                                } else {
                                    UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                                    upgradePopWindowMessage.setFromPage("frs");
                                    MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                                }
                            }
                        }
                        FrsFragment frsFragment5 = this.b;
                        if (i == 5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        frsFragment5.C4(false, z2);
                        if (this.b.V != null) {
                            if (this.b.x.getActivityHeadData() != null && this.b.x.getActivityHeadData().b() != null && this.b.x.getActivityHeadData().b().size() > 0) {
                                qq7.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.V.s0(), 1);
                            }
                            if (this.b.x.getThreadList() != null && this.b.x.getThreadList().size() > 0) {
                                Iterator<ym> it = this.b.x.getThreadList().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ym next = it.next();
                                    if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                        qq7.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.V.s0(), 2);
                                        break;
                                    }
                                }
                            }
                            qq7.i(this.b.getUniqueId(), this.b.x.getThreadList(), this.b.x.getForum(), this.b.V.s0());
                        }
                        this.b.t.d1(i);
                        FrsFragment.v2 = (System.nanoTime() - this.a) / 1000000;
                        if (aaaVar != null) {
                            FrsFragment.w2 = aaaVar.e;
                        }
                    } else {
                        return;
                    }
                    this.b.w3();
                    if (this.b.x.getAccessFlag() == 1) {
                        TiebaStatic.log(new StatisticItem("c11384"));
                    }
                    if (this.b.p && this.b.X.b(49)) {
                        this.b.p = false;
                    }
                    System.gc();
                    return;
                }
                if (!this.b.V.L0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.V.t0() == 1 && (this.b.x.adShowSelect == 1 || this.b.x.adShowSelect == 3)) {
                    this.b.x.addRecommendAppToThreadList(this.b);
                }
                ArrayList<ym> c = this.b.h0.c(false, false, this.b.x.getThreadList(), this.b.o, false, this.b.x.adShowSelect, this.b.x.adMixFloor);
                if (c != null) {
                    this.b.x.setThreadList(c);
                    this.b.x.checkLiveStageInThreadList();
                }
                if (this.b.V != null) {
                    sq7.m(this.b.x, this.b.V.i0(), 2, this.b.getContext());
                }
                FrsFragment frsFragment6 = this.b;
                us7.a(frsFragment6, frsFragment6.x.getForum(), this.b.x.getThreadList(), false, this.b.T3());
                this.b.t.M1(c, this.b.x);
                this.b.s5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090726);
                if (this.a.t != null && view2 == this.a.t.Y() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090dd2 && BdUtilHelper.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t != null && this.a.t.J0()) {
                        this.a.t.R1();
                    } else {
                        String c = this.a.x.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            BrowserHelper.startInternalWebActivity(this.a.getPageContext().getPageActivity(), c);
                        }
                    }
                }
                if (this.a.t != null && view2 == this.a.t.h0() && this.a.V != null && this.a.V.hasMore()) {
                    this.a.t.U1();
                    this.a.c();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.i0()) {
                    this.a.s4();
                    if (ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        this.a.t.Y0();
                        this.a.w4(((zd5) ServiceManager.getService(zd5.a)).a(), 2);
                    }
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.getContext().getApplicationContext(), (int) R.string.network_not_available);
                } else if (this.a.x != null && this.a.x.getForum() != null) {
                    if (this.a.t != null && (view2 == this.a.t.z0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.x != null && this.a.x.getForum() != null && !StringUtils.isNull(this.a.x.getForum().getId()) && !StringUtils.isNull(this.a.x.getForum().getName())) {
                            xp7.e(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                            kt7.d(this.a.getPageContext(), this.a.x, this.a.x.getForum().getId(), this.a.K, this.a.L, this.a.W1);
                        } else {
                            return;
                        }
                    }
                    if ((this.a.t != null && view2 == this.a.t.y0()) || logicField == LogicField.SEARCH_BTN) {
                        StatisticItem param = new StatisticItem("c12402").param("fid", this.a.x.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.x.getForum().getName());
                        xp7.a(param);
                        TiebaStatic.log(param);
                        if (!StringUtils.isNull(this.a.x.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.x.getForum().getName(), this.a.x.getForum().getId())));
                        }
                    }
                    if (this.a.t != null && view2 == this.a.t.x0() && this.a.x != null && this.a.x.frsForumGroup != null && this.a.x.frsForumGroup.topbar_entrance != null && !TextUtils.isEmpty(this.a.x.frsForumGroup.topbar_entrance.jump_url)) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.x.frsForumGroup.topbar_entrance.jump_url});
                        at7.a(this.a.w());
                        FrsTopBarGroupEntranceGuideView w0 = this.a.t.w0();
                        ys7.c();
                        if (w0 != null) {
                            w0.a();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements sg7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public u1(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.sg7
        public void a(int i, int i2, dh7 dh7Var, ArrayList<ym> arrayList) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), dh7Var, arrayList}) == null) {
                this.a.q5();
                if (this.a.e0 != null) {
                    this.a.W.A0(this.a.e0.e(i));
                }
                aaa aaaVar = new aaa();
                if (dh7Var != null) {
                    if (dh7Var.e == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aaaVar.b = z;
                    aaaVar.c = dh7Var.e;
                    aaaVar.d = dh7Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.B0();
                        } else if (dh7Var.g) {
                            if (ListUtils.getCount(this.a.x.getThreadList()) > 3) {
                                this.a.t.U1();
                            } else {
                                this.a.t.Q1();
                            }
                        } else if (dh7Var.i) {
                            this.a.t.X1();
                        } else {
                            this.a.t.B0();
                        }
                    }
                } else {
                    dh7Var = new dh7();
                    dh7Var.c = 1;
                    dh7Var.g = false;
                    dh7Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.M1.d(frsFragment.V.getType(), false, aaaVar);
                } else {
                    this.a.p5(aaaVar);
                    if (this.a.V.v0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.x = frsFragment2.V.v0();
                    }
                    this.a.E4();
                }
                if (this.a.e2 != null) {
                    this.a.e2.a(i, i2, dh7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2016495) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof ThreadData) {
                ot7.b(this.a.t, this.a.x, this.a.w(), true, (ThreadData) data);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ FrsFragment c;

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
            this.c = frsFragment;
            this.a = 0;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.c.W != null) {
                    this.c.W.M0(i);
                    if (i == 1) {
                        this.c.W.X();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.m4()) {
                    this.c.O = new or5();
                    this.c.O.a(1000);
                }
                if (i == 0) {
                    or5 or5Var = this.c.O;
                    if (or5Var != null) {
                        or5Var.e();
                    }
                    vm6.b().e(true);
                    this.c.u4(true);
                    this.c.t.T0(this.a, this.b);
                    if (this.c.Z0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.Z0);
                        this.c.Z0 = null;
                    }
                } else {
                    if (this.c.Z0 == null) {
                        this.c.Z0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    or5 or5Var2 = this.c.O;
                    if (or5Var2 != null) {
                        or5Var2.d();
                    }
                }
                if (this.c.v0 != null) {
                    this.c.v0.i(recyclerView, i);
                }
                if (i == 0) {
                    ot7.b(this.c.t, this.c.x, this.c.w(), false, null);
                }
                if (this.c.X != null && i == 1) {
                    this.c.X.O();
                }
                if (this.c.U == null) {
                    if (this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.U = (ThreadCardViewHolder) frsFragment2.t.o0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.U = (ThreadCardViewHolder) frsFragment3.t.o0().j().getTag();
                }
                if (i == 1) {
                    this.c.t.S0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.c.J0 += i2;
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.c.J0 >= this.c.I0 * 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
                }
                if (this.c.f0 != null) {
                    this.c.f0.j();
                }
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.c.v0 != null) {
                    this.c.v0.h(recyclerView, this.a, this.b);
                }
                if (this.c.x != null && this.c.t != null && this.c.t.a0() != null) {
                    this.c.t.q1(this.a, this.b);
                    if (this.c.U != null && this.c.U.b() != null) {
                        this.c.U.b().p(this.c.f1096T);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Function1<Long, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ FrsFragment b;

        public w(FrsFragment frsFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, str};
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
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) {
                if (this.b.u() != null && this.b.u().getPageActivity() != null) {
                    this.b.h1 = l.longValue();
                    rt7.b().c(this.a, l.longValue());
                    YunDialogManager.onShow(this.b.u().getPageActivity(), h55.p);
                    if (this.b.W.T() != null) {
                        this.b.W.T().d();
                    }
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements cf7 {
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

        @Override // com.baidu.tieba.cf7
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i == this.a.t.a0().c()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        return;
                    }
                    TiebaStatic.log("forum_fortune_click");
                    pt7.e(this.a.getPageContext(), this.a.x);
                } else if (i == this.a.t.a0().j()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (this.a.x != null && this.a.x.getForum() != null) {
                        ForumData forum = this.a.x.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), JavaTypesHelper.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (i == this.a.t.a0().i() && this.a.x != null && this.a.x.getUserData() != null && this.a.x.getUserData().isBawu()) {
                    String bawuCenterUrl = this.a.x.getBawuCenterUrl();
                    if (!bi.isEmpty(bawuCenterUrl) && this.a.x.getForum() != null) {
                        BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.x.getForum().getId()).param("uid", this.a.x.getUserData().getUserId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class w1 implements wg7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FrsFragment> a;

        public w1(FrsFragment frsFragment) {
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
            this.a = new WeakReference<>(frsFragment);
        }

        @Override // com.baidu.tieba.wg7
        public void a(boolean z, boolean z2, int i) {
            FrsFragment frsFragment;
            nf7 nf7Var;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || (frsFragment = this.a.get()) == null || (nf7Var = frsFragment.t) == null) {
                return;
            }
            int i2 = 8;
            int i3 = 0;
            if (i == 1) {
                nf7Var.F1(ye7.f().h());
                if (z) {
                    i2 = 0;
                }
                nf7Var.G1(i2);
            } else if (i == 2) {
                if (z) {
                    i2 = 0;
                }
                nf7Var.C1(i2);
            }
            if (!z2) {
                frsFragment.E0 = z;
            }
            if (nf7Var.a0() != null && (i == 2 || (frsFragment.V != null && frsFragment.V.m0()))) {
                nf7Var.a0().notifyDataSetChanged();
            }
            if (frsFragment.Y3() != null) {
                FrsTabViewController.i B = frsFragment.Y3().B();
                if (B != null) {
                    Fragment fragment = B.b;
                    if ((fragment instanceof FrsCommonTabFragment) && i == 2) {
                        ((FrsCommonTabFragment) fragment).g2();
                    } else if ((B.b instanceof FrsNewAreaFragment) && (i == 2 || B.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) B.b;
                        frsNewAreaFragment.D2();
                        if (frsNewAreaFragment.o2() != null) {
                            to7 o2 = frsNewAreaFragment.o2();
                            o2.J(!z);
                            if (i == 1) {
                                o2.G(!z);
                            } else if (i == 2) {
                                o2.G(true);
                            }
                        }
                    } else {
                        Fragment fragment2 = B.b;
                        if (fragment2 instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment2).x2();
                        }
                    }
                }
                if (frsFragment.Y3().M() != null) {
                    frsFragment.Y3().M().setmDisallowSlip(z);
                    frsFragment.Y3().h0(z);
                }
            }
            if (nf7Var.c0() != null) {
                if (frsFragment.r3() && !z) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                nf7Var.b2(z3);
            }
            if (frsFragment.getActivity() instanceof FrsActivity) {
                FrsActivity frsActivity = (FrsActivity) frsFragment.getActivity();
                frsActivity.F1(!z);
                sm7 w1 = frsActivity.w1();
                if (w1 != null && w1.o0()) {
                    if (z) {
                        i3 = 4;
                    }
                    w1.I0(i3);
                }
            }
            if (frsFragment.A0 != null) {
                frsFragment.A0.f(!z);
            }
            nf7Var.L1(!z);
            if (i == 1) {
                nf7Var.B1(!z);
            } else if (i == 2) {
                nf7Var.B1(true);
            }
        }

        @Override // com.baidu.tieba.wg7
        public void b(int i) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (frsFragment = this.a.get()) == null || frsFragment.getContext() == null) {
                return;
            }
            nf7 nf7Var = frsFragment.t;
            if (i == 1) {
                BdUtilHelper.showToast(frsFragment.getContext(), (int) R.string.obfuscated_res_0x7f0f0850);
            } else if (i == 2 && nf7Var != null) {
                new BdTopToast(frsFragment.getContext()).setIcon(false).setContent(frsFragment.getContext().getString(R.string.obfuscated_res_0x7f0f0845)).show(nf7Var.r0());
            }
        }

        @Override // com.baidu.tieba.wg7
        public void c(int i, int i2) {
            FrsFragment frsFragment;
            nf7 nf7Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || (frsFragment = this.a.get()) == null || (nf7Var = frsFragment.t) == null) {
                return;
            }
            if (i2 == 1) {
                nf7Var.E1(i);
            } else if (i2 == 2) {
                nf7Var.D1(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FrsFragment c;

        public x(FrsFragment frsFragment, int i, String str) {
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

    /* loaded from: classes5.dex */
    public class x0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.V.t0() == 1 && z && !this.a.t.e0()) {
                if (this.a.x != null && !ListUtils.isEmpty(this.a.x.getThreadList())) {
                    this.a.t.Q0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.b0().m());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.r0(), true);
                this.a.t.C0(false);
                this.a.refresh();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public y(FrsFragment frsFragment) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.N && BdNetTypeUtil.isNetWorkAvailable() && !this.a.t.N0()) {
                this.a.t.f1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public y0(FrsFragment frsFragment) {
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
            FrsTabViewController.i B;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.X != null && (B = this.a.X.B()) != null && (fragment = B.b) != null && (fragment instanceof pg7)) {
                ((pg7) fragment).h();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.a2();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                vs7.a(customResponsedMessage, this.a.t, this.a.x);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1868069978, "Lcom/baidu/tieba/frs/FrsFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1868069978, "Lcom/baidu/tieba/frs/FrsFragment;");
                return;
            }
        }
        q2 = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
        r2 = TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=%1$s&nomenu=1";
        s2 = false;
        t2 = null;
        v2 = 0L;
        w2 = 0L;
        x2 = 0;
        A2 = "3";
    }

    public final void A4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (frsViewData = this.x) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.x.getForum().getId())) {
            String id = this.x.getForum().getId();
            long a2 = rt7.b().a(id);
            this.h1 = a2;
            if (a2 > 0) {
                if (u() != null) {
                    YunDialogManager.onShow(u().getPageActivity(), h55.p);
                    return;
                }
                return;
            }
            L4(id);
        }
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.a1 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.a1 = pollingModel;
                pollingModel.setDialogTime(h55.f);
            }
            this.a1.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.R1, j85.a().b());
            SafeHandler.getInst().postDelayed(this.S1, 500L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.i B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (Y3() != null && (B = Y3().B()) != null) {
                Fragment fragment = B.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        int i2 = -1;
                        FrsViewData frsViewData = this.x;
                        if (frsViewData != null) {
                            i2 = frsViewData.getSortType();
                        }
                        tbPageTag.sortType = nt7.g(i2);
                        tbPageTag.locatePage = "a070";
                        if (this.a.equals(B.c)) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            super.onPause();
            this.Y.f(false);
            this.P = false;
            this.t.Z0();
            au7 au7Var = this.W;
            if (au7Var != null) {
                au7Var.i0();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.t.R0(true);
            tt7 tt7Var = this.f0;
            if (tt7Var != null) {
                tt7Var.j();
            }
            et4.w().E();
            eo5 eo5Var = this.b1;
            if (eo5Var != null && !eo5Var.isEnable()) {
                this.b1.onPause();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            this.t.g0().stopScroll();
            if (this.t.l1()) {
                return;
            }
            if (!BdUtilHelper.isNetOk()) {
                this.t.B0();
            } else if (this.V.t0() == 1) {
                r5();
                c();
            } else if (this.V.hasMore()) {
                c();
            }
        }
    }

    public final boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            if (d1() == null) {
                return false;
            }
            FrsViewData d12 = d1();
            u15 u15Var = null;
            if (d12.getStar() != null && !StringUtils.isNull(d12.getStar().a())) {
                u15Var = new u15();
            } else if (d12.getActivityHeadData() != null && ListUtils.getCount(d12.getActivityHeadData().b()) >= 1) {
                u15Var = d12.getActivityHeadData().b().get(0);
            }
            if (u15Var == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void r5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            if (c4() != 1 && !this.h0.b(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.B0();
                } else {
                    this.t.X1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.U1();
            } else {
                this.t.Q1();
            }
        }
    }

    public final void s5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            if (c4() == 0 && ListUtils.isEmpty(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.B0();
                } else {
                    this.t.X1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.U1();
            } else {
                this.t.Q1();
            }
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if (!u3() && this.x.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                W4(this.x.getPrivateForumTotalInfo().a().private_forum_audit_status, this.x.getPrivateForumTotalInfo().b(), false);
            } else {
                W4(null, null, true);
            }
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
        this.x = new FrsViewData();
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
        this.R = true;
        this.f1096T = new vy.a(2);
        this.c0 = new SparseArray<>();
        this.d0 = true;
        this.C0 = false;
        this.E0 = false;
        this.G0 = false;
        this.H0 = null;
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = 0;
        this.O0 = -1;
        this.T0 = -1;
        this.c1 = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = 0;
        this.h1 = -1L;
        this.i1 = new k(this);
        this.j1 = null;
        this.k1 = new v(this, 2016495);
        this.l1 = new g0(this, 2921005);
        this.m1 = new r0(this, 2921401);
        this.n1 = new c1(this, 2921473);
        this.o1 = new n1(this, 2921467);
        this.p1 = new s1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.q1 = new t1(this, 2001624);
        this.r1 = new u1(this);
        this.s1 = new a(this);
        this.u1 = new b(this, 2001606);
        this.v1 = new c(this, 2001607);
        this.w1 = new d(this, 2003019);
        this.x1 = new e(this, 2921470);
        this.y1 = new f(this, 2001352);
        this.z1 = new g(this);
        this.A1 = new h(this, 2001115);
        this.B1 = new i(this, 2921346);
        this.C1 = new j(this, 2001374);
        this.D1 = new l(this, 2001378);
        this.E1 = new m(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.F1 = new n(this);
        this.G1 = new o(this, 2921391);
        this.H1 = new p(this, 2003020);
        this.I1 = new q(this, 2921463);
        this.J1 = new r(this, 2921587);
        this.K1 = new s(this, 2921588);
        this.L1 = new t(this, 2003023);
        this.M1 = new u(this);
        this.N1 = new a0(this, 2016485);
        this.O1 = new b0(this, 2003025);
        this.P1 = new c0(this, 2001194);
        this.Q1 = new d0(this, 2921682);
        this.R1 = new l0(this);
        this.S1 = new m0(this);
        this.T1 = new n0(this);
        this.U1 = new o0(this);
        this.V1 = new p0(this);
        this.W1 = new t0(this);
        this.X1 = new u0(this);
        this.Y1 = new v0(this);
        this.Z1 = new w0(this);
        this.a2 = new x0(this);
        this.b2 = new y0(this);
        this.c2 = new z0(this, 0);
        this.d2 = new v1(this, null);
        this.e2 = new b1(this);
        this.f2 = new d1(this, 2921033);
        this.g2 = new e1(this, 2921381);
        this.h2 = new f1(this, 2921414);
        this.i2 = new g1(this, 2921437);
        this.j2 = new l1(this, 2921462);
        this.k2 = new m1(this, 2001223);
        this.l2 = new o1(this, 2921469);
        this.m2 = new p1(this, 2921475);
        this.n2 = new q1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.o2 = new r1(this, 2921515);
    }

    @Override // com.baidu.tieba.q26
    public void B0(int i2, p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, p26Var) == null) {
            this.c0.put(i2, p26Var);
        }
    }

    public void w4(@NonNull NewsRemindMessage newsRemindMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048739, this, newsRemindMessage, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NEW_MSG_TAB_CLICK);
            statisticItem.addParam("obj_type", V3(newsRemindMessage));
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void A5(Object obj) {
        oo7 oo7Var;
        h9 h9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (oo7Var = this.a0) != null && (h9Var = oo7Var.i) != null) {
            h9Var.c(obj);
        }
    }

    public final void B5(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewGroup) == null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    public void D4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.N = false;
            y5();
            nf7 nf7Var = this.t;
            if (nf7Var != null && nf7Var.o0() != null) {
                this.t.o0().y();
            }
            FrsModelController frsModelController = this.V;
            if (frsModelController != null) {
                frsModelController.Y0(i2, true);
            }
        }
    }

    public void K4(boolean z3) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z3) == null) && (frsTabViewController = this.X) != null) {
            frsTabViewController.u = z3;
        }
    }

    public final void L4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            FrsVisitedInfoManager.f().g(str, new w(this, str));
        }
    }

    public void N4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z3) == null) {
            this.e = z3;
        }
    }

    public void O4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z3) == null) {
            z2 = z3;
        }
    }

    public void P4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.g1 = i2;
            if (i2 == 13) {
                this.t.r1("frs_hot_tab");
            }
            if (i2 == 14) {
                this.t.r1("frs_new_tab");
            }
        }
    }

    public void Q4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.h = i2;
        }
    }

    public void R4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.f = str;
        }
    }

    public void S4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z3) == null) {
            this.W0 = z3;
        }
    }

    @Override // com.baidu.tieba.q26
    public void T(o26 o26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, o26Var) == null) {
            this.s0.a(o26Var);
        }
    }

    public void T4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z3) == null) {
            this.X0 = z3;
        }
    }

    public void U4(vh7 vh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, vh7Var) == null) {
            this.V0 = vh7Var;
        }
    }

    public void V4(int i2) {
        po7 po7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048626, this, i2) != null) || (po7Var = this.h0) == null) {
            return;
        }
        po7Var.n(i2);
    }

    public void X4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z3) == null) {
            this.c1 = z3;
            this.d1 = z3;
        }
    }

    public void Y4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z3) == null) {
            this.e1 = z3;
        }
    }

    public void Z4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z3) == null) {
            this.R = z3;
        }
    }

    public void a5(boolean z3) {
        cu7 cu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z3) == null) && (cu7Var = this.i0) != null) {
            cu7Var.Y();
        }
    }

    public void c5(boolean z3) {
        ug7 ug7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048642, this, z3) == null) && (ug7Var = this.b0) != null) {
            ug7Var.i(z3);
        }
    }

    @NonNull
    public void d5(go5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bVar) == null) {
            this.Q = bVar;
        }
    }

    @Override // com.baidu.tieba.q26
    public p26 e1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048647, this, i2)) == null) {
            return this.c0.get(i2);
        }
        return (p26) invokeI.objValue;
    }

    public void e5(int i2) {
        po7 po7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048649, this, i2) != null) || (po7Var = this.h0) == null) {
            return;
        }
        po7Var.o(i2);
    }

    public void f5(boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048652, this, z3) != null) || this.p2 != null) {
            return;
        }
        kv7 a2 = kv7.a(z3);
        this.p2 = a2;
        po7 po7Var = this.h0;
        if (po7Var != null) {
            po7Var.m(a2);
        }
    }

    public void h5(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, view2) == null) {
            this.t.t1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).G1(view2, false);
            this.t.j0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.t1(0);
            this.t.j0().f(false);
        }
    }

    public void i5(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048665, this, linearLayout) != null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public void j5(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048667, this, fRSRefreshButton) != null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new a1(this));
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            r5();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z3) == null) {
            super.onUserChanged(z3);
        }
    }

    public final void p3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, str) == null) {
            a5("frs_page".equals(str));
            ck7 ck7Var = this.e0;
            if (ck7Var != null) {
                ck7Var.c(this.W, this.t, this.x);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.g = str;
        }
    }

    public void t4(Object obj) {
        oo7 oo7Var;
        h9 h9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048724, this, obj) == null) && (oo7Var = this.a0) != null && (h9Var = oo7Var.j) != null) {
            h9Var.c(obj);
        }
    }

    public void u4(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z3) == null) {
            u9a.g().h(getUniqueId(), z3);
        }
    }

    public void w5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, str) == null) {
            new BdTopToast(getContext(), 3000).setIcon(true).setContent(str).show(this.t.r0());
        }
    }

    public void n5(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048678, this, str, str2, str3) == null) {
            ct7 ct7Var = new ct7(str, str2);
            this.U0 = ct7Var;
            ct7Var.r(getFragmentActivity(), str3, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048685, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            no7 no7Var = this.j0;
            if (no7Var != null) {
                no7Var.n(i2, i3, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048697, this, i2, strArr, iArr) == null) {
            pt7.i(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048722, this, view2, str, z3) == null) {
            super.showNetRefreshViewNoClick(view2, str, z3);
            this.t.t1(8);
        }
    }

    public final void A3(long j2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) && j2 > 0) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            SafeHandler.getInst().postDelayed(new q0(this, j2, equipmentWidth, equipmentHeight, f2, i2), 1000L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.V.W0(bundle);
            if (this.r != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.r.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void t5(aaa aaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, aaaVar) == null) {
            this.t.e1();
            if (aaaVar.a) {
                showNetRefreshView(this.t.r0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{aaaVar.d, Integer.valueOf(aaaVar.c)}), true);
                return;
            }
            showNetRefreshView(this.t.b0().m(), aaaVar.d, true);
            B5(this.t.b0().m());
        }
    }

    public final void z3(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048750, this, i2) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                str = this.x.getForum().getId();
            } else {
                str = "";
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", str).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t.c2();
        }
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.h == 1) {
                kg.a().b(new s0(this));
            }
            this.h = 0;
        }
    }

    @Override // com.baidu.tieba.ng7
    public void C() {
        nf7 nf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (nf7Var = this.t) != null) {
            nf7Var.g0().scrollToPosition(0);
            this.t.c2();
        }
    }

    public eo5 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b1;
        }
        return (eo5) invokeV.objValue;
    }

    public ck7 D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e0;
        }
        return (ck7) invokeV.objValue;
    }

    public in G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d2;
        }
        return (in) invokeV.objValue;
    }

    public void H4() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (frsModelController = this.V) != null && frsModelController.t0() == 1) {
            this.W.v0(this.x);
        }
    }

    public int I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return pt7.c(this.x, this.t);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    public qo7 J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.g0;
        }
        return (qo7) invokeV.objValue;
    }

    public void J4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.r0 == null) {
                this.r0 = new jo7(this, JavaTypesHelper.toInt(this.l, 0));
            }
            this.r0.w();
        }
    }

    public lq7 K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.Z;
        }
        return (lq7) invokeV.objValue;
    }

    public boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.c1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ng7
    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && isAdded() && this.d0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.r0(), true);
        }
    }

    public boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.e1;
        }
        return invokeV.booleanValue;
    }

    public void M4() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.i B;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (frsTabViewController = this.X) != null && (B = frsTabViewController.B()) != null && (fragment = B.b) != null && (fragment instanceof pg7)) {
            ((pg7) fragment).E1();
        }
    }

    public boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.t.e0();
        }
        return invokeV.booleanValue;
    }

    public boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.d1;
        }
        return invokeV.booleanValue;
    }

    public long P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.h1;
        }
        return invokeV.longValue;
    }

    public BdTypeRecyclerView Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            nf7 nf7Var = this.t;
            if (nf7Var == null) {
                return null;
            }
            return nf7Var.g0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public ug7 R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.b0;
        }
        return (ug7) invokeV.objValue;
    }

    public go5.b S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.Q;
        }
        return (go5.b) invokeV.objValue;
    }

    public int T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            po7 po7Var = this.h0;
            if (po7Var == null) {
                return 1;
            }
            return po7Var.g();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yo7
    public FrsModelController W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.V;
        }
        return (FrsModelController) invokeV.objValue;
    }

    public View W3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public final AbsDataRecorder.Scene X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            int i2 = this.g1;
            if (i2 == 14) {
                return AbsDataRecorder.Scene.FRS_NEW;
            }
            if (i2 == 13) {
                return AbsDataRecorder.Scene.FRS_HOT;
            }
            return AbsDataRecorder.Scene.FRS_HOT;
        }
        return (AbsDataRecorder.Scene) invokeV.objValue;
    }

    public FrsTabViewController Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.X;
        }
        return (FrsTabViewController) invokeV.objValue;
    }

    public String a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public OvalActionButton b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.u;
        }
        return (OvalActionButton) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yo7
    public void c() {
        po7 po7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (po7Var = this.h0) != null) {
            po7Var.i(this.f, this.l, this.x);
        }
    }

    public int c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            po7 po7Var = this.h0;
            if (po7Var == null) {
                return -1;
            }
            return po7Var.h();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mo7
    public FrsViewData d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.x;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public void d4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tieba.ix9
    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void e4() {
        au7 au7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && (au7Var = this.W) != null) {
            au7Var.Y();
        }
    }

    public void f4() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.b();
        }
    }

    @Override // com.baidu.tieba.ng7
    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && isAdded() && this.d0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.r0());
        }
    }

    public final void g5() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048656, this) != null) || (frsViewData = this.x) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.a0().setFromCDN(true);
        } else {
            this.t.a0().setFromCDN(false);
        }
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo7
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    public boolean j4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ng7
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean k4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean m4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void m5() {
        nf7 nf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && (nf7Var = this.t) != null) {
            nf7Var.P1();
        }
    }

    public boolean n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qg7
    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            nf7 nf7Var = this.t;
            if (nf7Var == null) {
                return null;
            }
            return nf7Var.k0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yo7
    public po7 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.h0;
        }
        return (po7) invokeV.objValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            FrsModelController frsModelController = this.V;
            if (frsModelController != null) {
                p3(frsModelController.r0());
            } else {
                p3("normal_page");
            }
        }
    }

    public boolean o4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.X0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public cn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return Q3().getPreLoadHandle();
        }
        return (cn) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            super.onStart();
            VoiceManager z02 = z0();
            this.r = z02;
            if (z02 != null) {
                z02.onStart(getPageContext());
            }
        }
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean q4() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return s3(this.t1);
        }
        return invokeV.booleanValue;
    }

    public boolean r4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if (d1() == null) {
                return false;
            }
            FrsViewData d12 = d1();
            if (ListUtils.isEmpty(d12.getShowTopThreadList()) && d12.getBusinessPromot() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            z36.c().f("page_frs");
            D4(3);
        }
    }

    @Override // com.baidu.tieba.ix9
    public int s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            po7 po7Var = this.h0;
            if (po7Var == null) {
                return 1;
            }
            return po7Var.g();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ix9
    @Nullable
    public TbPageContext<?> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo7, com.baidu.tieba.tg7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void v3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            if (getActivity() == null) {
                intent = null;
            } else {
                intent = getActivity().getIntent();
            }
            pt7.a(getPageContext(), intent, this.g);
        }
    }

    public boolean v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (p4() && !r4()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v5() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return VideoAudioHelper.checkNeedAutoPlay(2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tg7
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix9
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            W0().k1();
        }
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && !bi.isEmpty(this.l)) {
            et4.w().P(dt4.a0, JavaTypesHelper.toLong(this.l, 0L));
        }
    }

    @Override // com.baidu.tieba.yo7
    public au7 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.W;
        }
        return (au7) invokeV.objValue;
    }

    public void y5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && (voiceManager = this.r) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yo7
    public nf7 z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.t;
        }
        return (nf7) invokeV.objValue;
    }

    public void z5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048752, this) != null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public final void C4(boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            try {
                if (this.x != null && this.X != null && this.V != null) {
                    if (!this.t.a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.x.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.x.getGameTabInfo());
                    this.t.y1(isEmpty);
                    boolean z5 = true;
                    if (!isEmpty) {
                        if (this.v0 == null) {
                            this.v0 = new xt7(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.x0 == null) {
                            this.x0 = new om7(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.v0 = null;
                        this.x0 = null;
                    }
                    if (this.x.getForum() != null) {
                        this.f = this.x.getForum().getName();
                        this.l = this.x.getForum().getId();
                    }
                    o5();
                    if (this.x.hasTab()) {
                        this.X.d(this.x, this.V.i0());
                    }
                    if (z3) {
                        n3(true, z3);
                    } else {
                        n3(this.P, z3);
                    }
                    F4();
                    if (this.e0 != null) {
                        this.e0.a(this.W, this.x);
                    }
                    if (this.x.getPage() != null) {
                        V4(this.x.getPage().b());
                    }
                    ArrayList<ym> arrayList = new ArrayList<>();
                    if (!ListUtils.isEmpty(this.x.getThreadList())) {
                        arrayList.addAll(this.x.getThreadList());
                        if (this.V != null && this.V.K0() && ys7.a(this.l) && this.x.frsForumGroup != null && this.x.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.x.frsForumGroup.feed_card.group_list) && this.x.frsForumGroup.feed_card.index.intValue() >= 0) {
                            ak7.f(this.x.frsForumGroup, arrayList, this.l);
                        }
                    }
                    ArrayList<ym> d2 = this.h0.d(z4, true, arrayList, null, z3, false, this.x.adShowSelect, this.x.adMixFloor);
                    if (d2 != null) {
                        this.x.setThreadList(d2);
                    }
                    this.x.removeRedundantUserRecommendData();
                    int topThreadSize = this.x.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        us7.a(this, this.x.getForum(), this.x.getThreadList(), this.n, T3());
                    }
                    if (this.V.t0() == 1) {
                        E4();
                        if (!z3 && this.V.getPn() == 1) {
                            J4();
                        }
                    }
                    if (this.f0 != null) {
                        this.f0.k(this.X.G());
                    }
                    q5();
                    this.t.m1();
                    this.t.v1(true, false);
                    if (this.x.frsForumGroup == null) {
                        nf7 nf7Var = this.t;
                        if (this.W0) {
                            z5 = false;
                        }
                        nf7Var.h2(null, z5);
                    } else {
                        nf7 nf7Var2 = this.t;
                        TopbarEntrance topbarEntrance = this.x.frsForumGroup.topbar_entrance;
                        if (this.W0) {
                            z5 = false;
                        }
                        nf7Var2.h2(topbarEntrance, z5);
                    }
                    if (z3 && this.x.isFirstTabEqualAllThread()) {
                        SafeHandler.getInst().post(new y(this));
                    }
                    if (this.x.getForum() != null) {
                        this.t.R(this.x.getForum().getWarningMsg());
                    }
                    if (this.x != null && this.x.getFrsVideoActivityData() != null && SharedPrefHelper.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                        SafeHandler.getInst().postDelayed(new z(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.O1();
                    x4();
                    this.A0.e(this.x.bottomMenuList, this.x.getForum());
                    x5();
                    if (this.x != null && this.x.getForum() != null && !TextUtils.isEmpty(this.x.getForum().getId())) {
                        String id = this.x.getForum().getId();
                        rt7.b().c(id, System.currentTimeMillis());
                        FrsVisitedInfoManager.f().i(id);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void E3(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, intent) != null) || intent == null) {
            return;
        }
        if (!lt7.a(this, v(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
            getActivity().finish();
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        this.y = str;
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
        if (StringUtils.isNull(this.f) && uri != null) {
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.T1);
            } else {
                ft7 b2 = pt7.b(intent);
                if (b2 != null) {
                    this.f = b2.a;
                }
            }
            if (!StringUtils.isNull(this.f)) {
                intent.putExtra("name", this.f);
            }
            intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
        }
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, errorData) != null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        q5();
        this.t.Q0();
        aaa k02 = this.V.k0();
        boolean isEmpty = ListUtils.isEmpty(this.x.getThreadList());
        if (k02 != null && isEmpty) {
            if (this.V.n0() != 0) {
                this.V.h1();
                this.t.Q0();
            } else {
                p5(k02);
            }
            this.t.v1(this.x.isStarForum(), false);
            return;
        }
        p5(k02);
    }

    public final void x3(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048741, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<ym> threadList = this.x.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.t.g0() != null && this.t.g0().getData() != null) {
            Iterator<ym> it = threadList.iterator();
            List<ym> data = this.t.g0().getData();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    ym next = it.next();
                    if (next instanceof w35) {
                        ThreadData threadData = ((w35) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list.size()) {
                                break;
                            } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.h0.j(next);
                                this.t.g0().getAdapter().notifyItemRemoved(i3);
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    i3++;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    if (this.t.g0().getAdapter() != null) {
                        i2 = this.t.g0().getAdapter().getItemCount();
                    }
                    ot7.f("frsfragment-doDeleteThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public final void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            y5();
            try {
                if (this.x == null) {
                    return;
                }
                this.t.T1();
                this.t.b2(r3());
                if (this.x.getForum() != null) {
                    this.f = this.x.getForum().getName();
                    this.l = this.x.getForum().getId();
                }
                if (this.x.getPage() != null) {
                    V4(this.x.getPage().b());
                }
                this.t.N1(this.f);
                this.t.s1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.x.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.x.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.x.getUserData().getBimg_end_time());
                B4();
                g5();
                ArrayList<ym> threadList = this.x.getThreadList();
                if (threadList != null) {
                    this.t.M1(threadList, this.x);
                    vs7.b(this.t);
                    this.W.L0(s1());
                    this.x.setFrsFragmentTag(getUniqueId());
                    this.W.q0(this.x);
                    this.X.d(this.x, this.V.i0());
                    this.t.n1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048639, this) != null) || this.x == null) {
            return;
        }
        rq7 rq7Var = new rq7();
        if (this.x.needLog == 1) {
            rq7Var.a = true;
        } else {
            rq7Var.a = false;
        }
        if (this.x.getForum() != null) {
            rq7Var.c = this.x.getForum().getId();
            rq7Var.d = this.x.getForum().getName();
        }
        if (W0() != null) {
            rq7Var.b = W0().i0();
        }
        rq7 rq7Var2 = tq7.q0;
        if (rq7Var2 != null) {
            rq7Var.e = rq7Var2.e;
            rq7Var.f = rq7Var2.f;
        }
        ko7 ko7Var = new ko7(rq7Var, getTbPageTag(), getUniqueId());
        this.P0 = ko7Var;
        ko7Var.d(this.S0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.P0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.P0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.P0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.P0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public final void o5() {
        FrsViewData frsViewData;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && getActivity() != null && getActivity().getIntent() != null && (frsViewData = this.x) != null && frsViewData.getForum() != null && !TextUtils.isEmpty(w())) {
            if (getActivity().getIntent().getBooleanExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST, false) && k4()) {
                if (this.x.getForum().isLike() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.x.getUserData() != null && this.x.getUserData().getIs_manager() != 1) {
                    this.x.getUserData().getIs_bawu();
                }
                if (this.b1 != null) {
                    getActivity().getIntent().removeExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST);
                    go5.b bVar = this.Q;
                    if (bVar != null) {
                        bVar.q1(false);
                    }
                    this.b1.a(getPageContext(), null, JavaTypesHelper.toLong(w(), 0L), v(), getActivity().getIntent().getLongExtra(FrsActivityConfig.LOCATE_ROOM_ID, -1L), z3, getActivity().getSupportFragmentManager(), A2, "dialog");
                    return;
                }
                return;
            }
            mt7.d(getActivity(), this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            super.onResume();
            int i2 = this.f1;
            if (i2 <= 1) {
                this.f1 = i2 + 1;
            }
            nf7 nf7Var = this.t;
            if (nf7Var != null) {
                nf7Var.Q0();
                this.t.b1();
            }
            au7 au7Var = this.W;
            if (au7Var != null) {
                au7Var.k0();
            }
            if (this.f1 > 1 && M3()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                Y4(false);
            }
            eo5 eo5Var = this.b1;
            if (eo5Var != null && !eo5Var.isEnable()) {
                this.b1.onResume();
            }
            this.Y.f(true);
            this.P = true;
            if (s2) {
                s2 = false;
                nf7 nf7Var2 = this.t;
                if (nf7Var2 != null) {
                    nf7Var2.c2();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            nf7 nf7Var3 = this.t;
            if (nf7Var3 != null) {
                nf7Var3.R0(false);
            }
            if (this.w0) {
                D4(6);
                this.w0 = false;
            }
            if (this.H0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    SignManager.getInstance().setSignAlert(true, this.H0.getHours(), this.H0.getMinutes());
                    if (this.t != null && u() != null) {
                        SignManager.getInstance().showSignNavBarCoverTip(u().getPageActivity(), this.t.r0());
                    }
                }
                this.H0 = null;
            }
            x5();
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048745, this) == null) && !ListUtils.isEmpty(xe7.h().i()) && this.t.g0() != null && this.t.g0().getData() != null) {
            ArrayList<ym> threadList = this.x.getThreadList();
            if (ListUtils.isEmpty(threadList)) {
                return;
            }
            Iterator<ym> it = threadList.iterator();
            List<ym> data = this.t.g0().getData();
            int count = ListUtils.getCount(xe7.h().i());
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    ym next = it.next();
                    if (next instanceof w35) {
                        ThreadData threadData = ((w35) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= count) {
                                break;
                            } else if (StringHelper.equals(xe7.h().i().get(i4).getId(), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.h0.j(next);
                                this.t.g0().getAdapter().notifyItemRemoved(i3);
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    i3++;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    if (this.t.g0().getAdapter() != null) {
                        i2 = this.t.g0().getAdapter().getItemCount();
                    }
                    ot7.f("frsfragment-doMoveThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public ForumWriteData F3() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                ForumData forum = this.x.getForum();
                ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.x.getAnti());
                forumWriteData.avatar = forum.getImage_url();
                forumWriteData.forumLevel = forum.getUser_level();
                forumWriteData.specialForumType = forum.special_forum_type;
                forumWriteData.firstDir = forum.getFirst_class();
                forumWriteData.secondDir = forum.getSecond_class();
                UserData userData = this.x.getUserData();
                if (userData != null) {
                    i2 = userData.getPrivateThread();
                } else {
                    i2 = 0;
                }
                forumWriteData.privateThread = i2;
                forumWriteData.frsTabInfo = Z3();
                FrsViewData frsViewData2 = this.x;
                forumWriteData.forumTagInfo = frsViewData2.forumTagInfo;
                forumWriteData.firstCategory = frsViewData2.firstCategory;
                return forumWriteData;
            }
            return null;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            super.onStop();
            vm6.b().e(false);
            u4(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                bh5.j().x(getPageContext().getPageActivity(), "frs", this.x.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (Q3() != null) {
                Q3().getRecycledViewPool().clear();
            }
            this.W.g0();
            gw5.c();
        }
    }

    public final void s4() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048716, this) != null) || !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
        xp7.a(param);
        xp7.b(param, w(), v());
        TiebaStatic.log(param);
        StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.K);
        if (this.K > 0) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        TiebaStatic.log(param2.param("obj_type", i2).param("obj_source", 2));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
    }

    public final void x4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (frsViewData = this.x) != null && frsViewData.getForum() != null) {
            String id = this.x.getForum().getId();
            String name = this.x.getForum().getName();
            String image_url = this.x.getForum().getImage_url();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            boolean equals = "showlive".equals(this.x.getForum().special_forum_type);
            ThemeColorInfo themeColorInfo = this.x.getForum().getThemeColorInfo();
            int member_num = this.x.getForum().getMember_num();
            FrsViewData frsViewData2 = this.x;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(id, name, image_url, valueOf, equals, themeColorInfo, member_num, frsViewData2.forumTagInfo, frsViewData2.firstCategory, frsViewData2.getForum().getPost_num())));
        }
    }

    public boolean F4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            au7 au7Var = this.W;
            if (au7Var != null && (frsModelController = this.V) != null) {
                au7Var.O0(frsModelController.r0(), this.x);
            }
            boolean z3 = false;
            FrsViewData frsViewData2 = this.x;
            if (frsViewData2 != null) {
                z3 = frsViewData2.hasTab();
            }
            o3();
            nf7 nf7Var = this.t;
            if (nf7Var != null) {
                nf7Var.F0();
                this.t.G0();
                FrsViewData frsViewData3 = this.x;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.X0 = et7.j(this.x.getBusinessPromot(), this.x.getForum().getId());
                }
                if (!this.X0 && (frsViewData = this.x) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.E0(this.x.getActivityHeadData().a());
                    if (this.x.getActivityHeadData().a() != null && !this.W0 && !this.X0 && !this.Y0 && !L3()) {
                        m5();
                    }
                } else {
                    this.t.E0(null);
                }
            }
            return z3;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabInfoData Z3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.V == null || (frsViewData = this.x) == null || this.X == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.x.getEntelechyTabInfo().a)) {
                return null;
            }
            int F = this.X.F();
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.x.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.x.getUserData() == null || this.x.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (F == frsTabInfo.tab_id.intValue()) {
                        i2 = F;
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = i2;
            if (this.x.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.x.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public final void G4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            F4();
            y5();
            try {
                if (this.x == null) {
                    return;
                }
                yg7 yg7Var = null;
                this.t.M1(null, this.x);
                this.W.L0(1);
                this.t.n1();
                this.X.d(this.x, this.V.i0());
                fs7 J = this.X.J(this.x.getFrsDefaultTabId());
                if (J != null && !TextUtils.isEmpty(J.d)) {
                    yg7Var = new yg7();
                    String str = J.d;
                    String str2 = J.a;
                }
                this.V.I(this.x.getFrsDefaultTabId(), 0, yg7Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void h4(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bundle) == null) {
            registerListener(2001118, this.c2);
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
                registerListener(2001120, this.c2);
            }
            this.W.e0(bundle);
            A3(j2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.F0) {
                this.t.V0(i2);
                this.W.h0(i2);
                this.X.W(i2);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                lu7 lu7Var = this.u0;
                if (lu7Var != null) {
                    lu7Var.onChangeSkinType();
                }
                hi7 hi7Var = this.A0;
                if (hi7Var != null) {
                    hi7Var.d(getPageContext(), i2);
                }
                if (this.B0 != null) {
                    ks5.a(getPageContext(), this.B0.getRealView());
                }
                xt7 xt7Var = this.v0;
                if (xt7Var != null) {
                    xt7Var.onChangeSkinType(getPageContext(), i2);
                }
                vh7 vh7Var = this.V0;
                if (vh7Var != null) {
                    vh7Var.onChangeSkinType(getPageContext(), i2);
                }
                eo5 eo5Var = this.b1;
                if (eo5Var != null && !eo5Var.isEnable()) {
                    this.b1.onChangeSkinType(i2);
                }
            }
        }
    }

    public final void p5(aaa aaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, aaaVar) == null) {
            if (aaaVar == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06a2);
                this.t.e1();
                showNetRefreshView(this.t.r0(), string, true);
            } else if (340001 == aaaVar.c) {
                u5(aaaVar, this.x.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    t5(aaaVar);
                }
                if (m4()) {
                    setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703b0));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public int H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.T0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.T0;
        }
        return invokeV.intValue;
    }

    public final void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            if (this.h == 0) {
                this.t.N1(this.f);
            } else {
                this.t.N1("");
                this.h = 1;
            }
            this.t.J1(this.d2);
            this.t.N(this.Y1);
            this.t.K1(this.a2);
            this.t.a0().l(this.Z1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048693, this) == null) && m4()) {
            showLoadingView(this.t.r0(), true);
            this.t.I1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.V.Y0(3, true);
            Q3().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048694, this) != null) || !BdUtilHelper.isNetOk()) {
            return;
        }
        hideNetRefreshView(this.t.b0().m());
        showLoadingView(this.t.r0(), true);
        this.t.C0(false);
        this.V.Y0(3, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                au7 au7Var = this.W;
                if (au7Var != null) {
                    au7Var.j0(isPrimary());
                }
                nf7 nf7Var = this.t;
                if (nf7Var != null) {
                    nf7Var.a1(isPrimary());
                    this.t.R0(!isPrimary());
                }
            }
        }
    }

    public void q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            hideLoadingView(this.t.r0());
            this.t.e2();
            if (this.t.q0() instanceof es7) {
                ((es7) this.t.q0()).d();
            }
        }
    }

    public final boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.x.getPrivateForumTotalInfo().a() == null || this.x.getUserData().getIs_manager() != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I4(iaa iaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iaaVar) == null) {
            try {
                if (!this.N && iaaVar != null && this.x != null) {
                    this.x.receiveData(iaaVar);
                    C4(true, false);
                    Looper.myQueue().addIdleHandler(this.i1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public String V3(@NonNull NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, newsRemindMessage)) == null) {
            int chatCount = newsRemindMessage.getChatCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (chatCount > 0) {
                return "1";
            }
            if (z3) {
                return "3";
            }
            return "2";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, bundle) == null) {
            super.onCreate(bundle);
            u9a.g().i(getUniqueId());
            if (this.R0 == null) {
                this.R0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.R0);
            this.b1 = do5.a();
            registerResponsedEventListener(TopToastEvent.class, this.F1);
        }
    }

    public boolean s3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048715, this, i2)) == null) {
            if (!this.R || this.G0 || !t3(i2)) {
                return false;
            }
            FrsModelController frsModelController = this.V;
            if (frsModelController != null && frsModelController.m0() && (ye7.f().i() || xe7.h().j())) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z3) == null) {
            super.setPrimary(z3);
            FrsTabViewController frsTabViewController = this.X;
            if (frsTabViewController != null && frsTabViewController.B() != null && (this.X.B().b instanceof BaseFragment)) {
                ((BaseFragment) this.X.B().b).setPrimary(z3);
            }
        }
    }

    public void y4(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048746, this, intent) != null) || intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.f = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.g = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra("refresh_all", false);
        this.j = booleanExtra;
        if (booleanExtra) {
            B3();
        }
    }

    public void z4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048751, this, str) == null) && TbadkCoreApplication.isLogin() && !bi.isEmpty(str)) {
            if (this.D0 == null && u() != null) {
                this.D0 = new AddExperiencedModel(u());
            }
            AddExperiencedModel addExperiencedModel = this.D0;
            if (addExperiencedModel != null) {
                addExperiencedModel.R(this.l, str);
            }
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void W4(Integer num, Integer num2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048629, this, num, num2, z3) != null) || this.t.p0() == null) {
            return;
        }
        TextView p02 = this.t.p0();
        if (z3) {
            p02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            p02.setText(getString(R.string.obfuscated_res_0x7f0f02b4));
            p02.setVisibility(0);
            str = String.format(r2, this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            p02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f0432), num2));
            p02.setVisibility(0);
            str = String.format(q2, this.l, this.f);
            i2 = 1;
        } else {
            p02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        p02.setOnClickListener(new x(this, i2, str));
    }

    public final void g4() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && isResumed() && (list = this.L0) != null && list.size() >= 1 && this.K0 <= this.L0.size() - 1) {
            LiveHorseRaceData liveHorseRaceData = this.L0.get(this.K0);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.K0++;
                g4();
            }
            if (this.w != null) {
                FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    if (liveHorseRaceData.getUser_nickname().length() > 4) {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bb4), liveHorseRaceData.getUser_nickname().substring(0, 4) + "...");
                    } else {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bb4), liveHorseRaceData.getUser_nickname());
                    }
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bb4), getResources().getString(R.string.obfuscated_res_0x7f0f0831));
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new h1(this, liveHorseRaceData));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.M0 = ofFloat;
                ofFloat.setDuration(600L);
                this.M0.addUpdateListener(new i1(this, frsRedpackRunView));
                this.M0.addListener(new j1(this, frsRedpackRunView));
                this.N0 = new k1(this, frsRedpackRunView);
                SafeHandler.getInst().postDelayed(this.N0, 5000L);
                if (this.w.getChildCount() == 0) {
                    this.K0++;
                    this.w.addView(frsRedpackRunView);
                    FrsViewData frsViewData = this.x;
                    String str = "";
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        str = this.x.getForum().getName();
                    }
                    TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.l).param("fname", str));
                }
                LinearLayout linearLayout = this.w;
                if (linearLayout != null && linearLayout.getVisibility() == 8 && ((BaseFragment) this.X.B().b).isPrimary() && !this.t.O0() && !this.J) {
                    this.w.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            u9a.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.f2);
            MessageManager.getInstance().unRegisterListener(this.D1);
            unRegisterResponsedEventListener();
            this.i0.X();
            u2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            zy9.c("FRS");
            this.r = null;
            vm6.b().e(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                fg7.a().b(JavaTypesHelper.toLong(this.x.getForum().getId(), 0L));
            }
            jo7 jo7Var = this.r0;
            if (jo7Var != null) {
                jo7Var.v();
            }
            nf7 nf7Var = this.t;
            if (nf7Var != null) {
                ot7.b(nf7Var, this.x, w(), false, null);
                this.t.W0();
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.w.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.M0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.N0 != null) {
                SafeHandler.getInst().removeCallbacks(this.N0);
            }
            if (this.R1 != null) {
                SafeHandler.getInst().removeCallbacks(this.R1);
            }
            SafeHandler.getInst().removeCallbacks(this.S1);
            this.L0 = null;
            ye7.f().s(null);
            xe7.h().s(null);
            super.onDestroy();
            try {
                if (this.O != null) {
                    this.O.c();
                }
                if (this.t != null) {
                    this.t.j1();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.W.f0();
            Looper.myQueue().removeIdleHandler(this.i1);
            if (j85.a().b() != 300000) {
                j85.a().d(300000L);
            }
            FrsModelController frsModelController = this.V;
            if (frsModelController != null) {
                frsModelController.q();
            }
            ug7 ug7Var = this.b0;
            if (ug7Var != null) {
                ug7Var.d();
            }
            tt7 tt7Var = this.f0;
            if (tt7Var != null) {
                tt7Var.i();
            }
            lq7 lq7Var = this.Z;
            if (lq7Var != null) {
                lq7Var.c();
            }
            xt7 xt7Var = this.v0;
            if (xt7Var != null) {
                xt7Var.g();
            }
            no7 no7Var = this.j0;
            if (no7Var != null) {
                no7Var.o();
            }
            c36 c36Var = this.y0;
            if (c36Var != null) {
                c36Var.h();
            }
            d96 d96Var = this.z0;
            if (d96Var != null) {
                d96Var.g();
            }
            ct7 ct7Var = this.U0;
            if (ct7Var != null) {
                ct7Var.f();
            }
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            FrsTabViewController frsTabViewController = this.X;
            if (frsTabViewController != null) {
                frsTabViewController.f0(null);
                this.X.O();
            }
            AddExperiencedModel addExperiencedModel = this.D0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            if (this.R0 != null) {
                getLifecycle().removeObserver(this.R0);
            }
            SafeHandler.getInst().removeCallbacks(this.b2);
            eo5 eo5Var = this.b1;
            if (eo5Var != null && !eo5Var.isEnable()) {
                this.b1.onDestroy();
            }
            this.b1 = null;
            f1c f1cVar = this.j1;
            if (f1cVar != null) {
                f1cVar.unsubscribe();
            }
            this.j1 = null;
            YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
        }
    }

    public boolean k5(iaa iaaVar, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048670, this, iaaVar, tbPageContext)) == null) {
            if (!L3()) {
                if (iaaVar != null && iaaVar.getBusinessPromot() != null && !StringUtils.isNull(iaaVar.getBusinessPromot().q()) && iaaVar.getForum() != null) {
                    boolean j2 = et7.j(iaaVar.getBusinessPromot(), iaaVar.getForum().getId());
                    this.X0 = j2;
                    X4(j2);
                    return this.X0;
                }
                vh7 vh7Var = new vh7(tbPageContext);
                this.V0 = vh7Var;
                boolean j3 = vh7Var.j(iaaVar);
                this.W0 = j3;
                X4(j3);
                return this.W0;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void l(ArrayList<ym> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            V4(!isEmpty ? 1 : 0);
            r5();
            if (isEmpty) {
                return;
            }
            if (k46.k().l(X3())) {
                k46.k().g(X3()).b();
            }
            if (d56.i().o(X3())) {
                d56.i().g(X3()).b();
            }
            if (!this.V.L0() && TbadkCoreApplication.getInst().isRecAppExist() && this.V.t0() == 1 && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                this.x.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.V != null) {
                qq7.i(getUniqueId(), arrayList, this.x.getForum(), this.V.s0());
            }
            po7 po7Var = this.h0;
            iba ibaVar = this.o;
            FrsViewData frsViewData = this.x;
            ArrayList<ym> c2 = po7Var.c(false, false, arrayList, ibaVar, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.x.setThreadList(c2);
                this.t.M1(c2, this.x);
            }
            FrsModelController frsModelController = this.V;
            if (frsModelController != null) {
                sq7.m(this.x, frsModelController.i0(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.x.getForum()));
        }
    }

    public void l5(View view2, String str, boolean z3, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{view2, str, Boolean.valueOf(z3), list}) == null) {
            this.t.e1();
            this.t.t1(8);
            if (this.u0 == null) {
                this.u0 = new lu7(getPageContext(), getNetRefreshListener());
            }
            this.u0.c(str);
            this.u0.b(list);
            this.u0.attachView(view2, z3);
        }
    }

    public final void n3(boolean z3, boolean z4) {
        FrsModelController frsModelController;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048676, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) && (frsModelController = this.V) != null && this.x != null && this.t != null && z3) {
            if (!frsModelController.L0() && this.V.t0() == 1) {
                if (!this.V.I0()) {
                    this.x.addCardVideoInfoToThreadList();
                    this.x.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z5 = false;
                if (this.t.a0().k(wn6.g)) {
                    z5 = this.x.addHotTopicDataToThreadList();
                }
                if (!z5) {
                    this.x.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                    if (this.g1 == 14) {
                        this.x.frsCurrentTabId = 503;
                    } else {
                        this.x.frsCurrentTabId = 1;
                    }
                    this.x.addRecommendAppToThreadList(this);
                }
                if (!this.t.a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.x.removeAlaLiveThreadData();
                }
                this.x.addSchoolRecommendToThreadList();
            }
            if (!this.t.a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                this.x.removeAlaInsertLiveData();
                this.x.removeAlaStageLiveDat();
            } else {
                this.x.addInsertLiveDataToThreadList();
                this.x.addStageLiveDataToThreadList();
            }
            this.x.checkLiveStageInThreadList();
            this.x.addNoticeThreadToThreadList();
            if (this.t.a0().k(dw7.e)) {
                this.x.addGameRankListToThreadList(z4);
            }
            if (TbadkCoreApplication.isLogin() && (!this.V.L0() || this.V.isNetFirstLoad)) {
                this.x.addUserRecommendToThreadList();
            }
            this.x.addVideoActivityToTop();
            this.x.addHeaderCardToThreadList();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                E3(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new iba("frs", iba.c);
            if (this.V == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.M1);
                this.V = frsModelController;
                frsModelController.M(this.r1);
                this.V.init();
            }
            this.V.i1(this.y);
            ArrayList<ym> arrayList = null;
            if (intent != null) {
                this.V.B0(intent.getExtras());
            } else if (bundle != null) {
                this.V.B0(bundle);
            } else {
                this.V.B0(null);
            }
            if (intent != null) {
                this.W.e0(intent.getExtras());
            } else if (bundle != null) {
                this.W.e0(bundle);
            } else {
                this.W.e0(null);
            }
            this.r = z0();
            this.s0 = new mf7(getPageContext(), this);
            i4();
            h4(bundle);
            if (!m4()) {
                ug7 ug7Var = new ug7(getActivity(), this.t, this.W);
                this.b0 = ug7Var;
                ug7Var.i(true);
            }
            VoiceManager z02 = z0();
            this.r = z02;
            if (z02 != null) {
                z02.onCreate(getPageContext());
            }
            mt7.b(this, getFrom(), this.C0, this.u, this.t);
            mt7.c(this, getFrom(), this.C0, this.u);
            if (jk5.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new vo7();
            int i2 = -1;
            po7 po7Var = this.h0;
            if (po7Var != null && po7Var.f() != null) {
                i2 = this.h0.f().R();
                arrayList = this.h0.f().Q();
            }
            po7 po7Var2 = new po7(this, this.U1);
            this.h0 = po7Var2;
            po7Var2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.h0.f().b0(arrayList);
            }
            this.Z = new lq7(this);
            this.i0 = new cu7(this);
            this.f0 = new tt7(getPageContext(), this.V.G0());
            this.a0 = new oo7(this);
            this.g0 = new qo7(this);
            this.Y = new uo7(this);
            this.j0 = new no7(this);
            this.t0 = new vt7(this);
            new ro7(this, getUniqueId());
            this.y0 = new c36(getPageContext(), "frs");
            this.z0 = new d96(getPageContext());
            new pq7(getPageContext());
            registerListener(this.A1);
            registerListener(this.P1);
            registerListener(this.y1);
            registerListener(this.N1);
            registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.k1);
            registerListener(this.l1);
            registerListener(this.m1);
            registerListener(this.n1);
            registerListener(this.f2);
            registerListener(this.C1);
            this.D1.setSelfListener(true);
            this.D1.setTag(getPageContext().getUniqueId());
            registerListener(this.D1);
            registerListener(this.q1);
            registerListener(this.B1);
            registerListener(this.G1);
            registerListener(this.H1);
            registerListener(this.I1);
            this.g2.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.g2);
            registerListener(this.h2);
            registerListener(this.i2);
            registerListener(this.j2);
            registerListener(this.p1);
            registerListener(this.k2);
            registerListener(this.E1);
            registerListener(this.o1);
            registerListener(this.l2);
            registerListener(this.m2);
            registerListener(this.n2);
            registerListener(this.o2);
            registerListener(this.J1);
            registerListener(this.K1);
            registerListener(this.L1);
            this.O1.setTag(getPageContext().getUniqueId());
            registerListener(this.O1);
            registerListener(this.Q1);
            this.t.C0(false);
            if (!m4() && !this.C0) {
                showLoadingView(this.t.r0(), true);
                this.V.g0(3, false);
            }
            fv7.a();
            w1 w1Var = new w1(this);
            ye7.f().s(w1Var);
            xe7.h().s(w1Var);
            this.t.H1(new e0(this));
            this.I0 = UtilHelper.getScreenHeight(getActivity());
            this.C0 = true;
            z3(1);
            super.onActivityCreated(bundle);
            Lifecycle lifecycle = getFragmentActivity().getLifecycle();
            PollingLifecycleHelper pollingLifecycleHelper = new PollingLifecycleHelper();
            pollingLifecycleHelper.m(1500L);
            pollingLifecycleHelper.k(new f0(this));
            lifecycle.addObserver(pollingLifecycleHelper);
            zd5 zd5Var = (zd5) ServiceManager.getService(zd5.a);
            if (zd5Var != null && this.j1 == null) {
                this.j1 = y0c.c(zd5Var.g().k(new j0(this)), zd5Var.c(), new k0(this)).p(new i0(this)).H(new h0(this));
            }
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048688, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d033e, viewGroup, false);
                oi7 oi7Var = new oi7();
                this.b = oi7Var;
                this.e0 = oi7Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0875);
                this.W = new au7(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090f26));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.X1);
                this.X = frsTabViewController;
                frsTabViewController.a0();
                this.W.N0(this.X);
                this.X.f0(this.s1);
                Intent intent = getActivity().getIntent();
                if (intent != null) {
                    if ("main_tab".equals(intent.getStringExtra("from"))) {
                        this.d = true;
                    }
                    this.X.e0(intent.getIntExtra(FrsActivityConfig.KEY_JUMP_TAB_ID, 0));
                }
                this.t = new nf7(this, this.X1, this.b, this.d, this.W);
                this.A0 = new hi7(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.X;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.a0();
                }
                this.t.g1();
                this.s.setLeft(0);
                this.s.setRight(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
            }
            this.F0 = true;
            this.G = System.currentTimeMillis() - currentTimeMillis;
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048692, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (ye7.f().i()) {
                    ye7.f().m();
                    return true;
                } else if (xe7.h().j()) {
                    nf7 nf7Var = this.t;
                    if (nf7Var != null && nf7Var.M0()) {
                        this.t.k1();
                        return true;
                    }
                    xe7.h().n();
                    return true;
                } else {
                    nf7 nf7Var2 = this.t;
                    if (nf7Var2 != null) {
                        return nf7Var2.X0();
                    }
                    return false;
                }
            } else if (i2 == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                return false;
            } else {
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048720, this, view2, z3) == null) {
            this.t.t1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z3);
            ((FrsActivity) getActivity()).G1(view2, true);
            this.t.j0().f(true);
        }
    }

    public final void u5(aaa aaaVar, List<RecmForumInfo> list) {
        nf7 nf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048730, this, aaaVar, list) == null) && (nf7Var = this.t) != null) {
            nf7Var.e1();
            this.t.N1(this.f);
            if (this.t.b0() != null) {
                l5(this.t.r0(), aaaVar.d, true, list);
            }
            this.t.j0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048721, this, view2, str, z3) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z3, getNetRefreshListener());
            this.t.t1(8);
            this.t.j0().f(true);
            z3a.a("frs", false);
        }
    }
}
