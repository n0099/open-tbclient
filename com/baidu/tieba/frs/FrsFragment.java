package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingLifecycleHelper;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.leveiconlivepolling.PollingReqMessage;
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
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mvc.data.IResponseData;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.a28;
import com.baidu.tieba.a38;
import com.baidu.tieba.a78;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.am5;
import com.baidu.tieba.b28;
import com.baidu.tieba.bm5;
import com.baidu.tieba.bs7;
import com.baidu.tieba.c26;
import com.baidu.tieba.c28;
import com.baidu.tieba.c68;
import com.baidu.tieba.c78;
import com.baidu.tieba.cx4;
import com.baidu.tieba.d78;
import com.baidu.tieba.database.FrsVisitedInfoManager;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.dm5;
import com.baidu.tieba.doc;
import com.baidu.tieba.du7;
import com.baidu.tieba.dva;
import com.baidu.tieba.dwa;
import com.baidu.tieba.e28;
import com.baidu.tieba.e68;
import com.baidu.tieba.e78;
import com.baidu.tieba.ea5;
import com.baidu.tieba.em6;
import com.baidu.tieba.et7;
import com.baidu.tieba.f05;
import com.baidu.tieba.f16;
import com.baidu.tieba.f28;
import com.baidu.tieba.fp5;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
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
import com.baidu.tieba.g36;
import com.baidu.tieba.g78;
import com.baidu.tieba.h25;
import com.baidu.tieba.h68;
import com.baidu.tieba.hn6;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hx7;
import com.baidu.tieba.i78;
import com.baidu.tieba.ija;
import com.baidu.tieba.j16;
import com.baidu.tieba.j68;
import com.baidu.tieba.jq5;
import com.baidu.tieba.ju5;
import com.baidu.tieba.jx4;
import com.baidu.tieba.jx7;
import com.baidu.tieba.k16;
import com.baidu.tieba.k58;
import com.baidu.tieba.koc;
import com.baidu.tieba.kva;
import com.baidu.tieba.kx4;
import com.baidu.tieba.l4b;
import com.baidu.tieba.l58;
import com.baidu.tieba.l78;
import com.baidu.tieba.ls7;
import com.baidu.tieba.m16;
import com.baidu.tieba.m45;
import com.baidu.tieba.ms7;
import com.baidu.tieba.mt7;
import com.baidu.tieba.mv7;
import com.baidu.tieba.mz4;
import com.baidu.tieba.n16;
import com.baidu.tieba.n26;
import com.baidu.tieba.n68;
import com.baidu.tieba.n78;
import com.baidu.tieba.np5;
import com.baidu.tieba.nu;
import com.baidu.tieba.nv7;
import com.baidu.tieba.o38;
import com.baidu.tieba.oo4;
import com.baidu.tieba.ot7;
import com.baidu.tieba.oxa;
import com.baidu.tieba.p68;
import com.baidu.tieba.p98;
import com.baidu.tieba.pb;
import com.baidu.tieba.pi;
import com.baidu.tieba.po4;
import com.baidu.tieba.pr6;
import com.baidu.tieba.pt7;
import com.baidu.tieba.pua;
import com.baidu.tieba.q18;
import com.baidu.tieba.q68;
import com.baidu.tieba.qd5;
import com.baidu.tieba.r06;
import com.baidu.tieba.r18;
import com.baidu.tieba.r88;
import com.baidu.tieba.rd;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rha;
import com.baidu.tieba.roc;
import com.baidu.tieba.rs7;
import com.baidu.tieba.rt7;
import com.baidu.tieba.rxa;
import com.baidu.tieba.s06;
import com.baidu.tieba.s38;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.st7;
import com.baidu.tieba.sy4;
import com.baidu.tieba.t06;
import com.baidu.tieba.t18;
import com.baidu.tieba.t38;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ti;
import com.baidu.tieba.tv7;
import com.baidu.tieba.u18;
import com.baidu.tieba.u38;
import com.baidu.tieba.v18;
import com.baidu.tieba.v38;
import com.baidu.tieba.v68;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.vt7;
import com.baidu.tieba.vua;
import com.baidu.tieba.vz7;
import com.baidu.tieba.w18;
import com.baidu.tieba.w38;
import com.baidu.tieba.w4;
import com.baidu.tieba.w68;
import com.baidu.tieba.w88;
import com.baidu.tieba.woa;
import com.baidu.tieba.woc;
import com.baidu.tieba.wr7;
import com.baidu.tieba.wu7;
import com.baidu.tieba.x18;
import com.baidu.tieba.x68;
import com.baidu.tieba.x76;
import com.baidu.tieba.x78;
import com.baidu.tieba.xoc;
import com.baidu.tieba.xr7;
import com.baidu.tieba.xt7;
import com.baidu.tieba.y05;
import com.baidu.tieba.y18;
import com.baidu.tieba.y68;
import com.baidu.tieba.z68;
import com.baidu.tieba.zb;
import com.baidu.tieba.zh5;
import com.baidu.tieba.zi;
import com.baidu.tieba.zt7;
import com.baidu.tieba.zx6;
import com.baidu.tieba.zz7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tbclient.AddBawuPopInfo;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.TopbarEntrance;
import tbclient.FrsTabInfo;
import tbclient.PopInfo;
/* loaded from: classes6.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, t18, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, st7, rha, f28, t06, mt7, pt7, l4b, h25 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile int A2;
    public static boolean B2;
    public static boolean C2;
    public static String D2;
    public static final String t2;
    public static final String u2;
    public static boolean v2;
    public static final ThreadData w2;
    public static dva x2;
    public static volatile long y2;
    public static volatile long z2;
    public transient /* synthetic */ FieldHolder $fh;
    public pb<TbImageView> A;
    public f16 A0;
    public final CustomMessageListener A1;
    public long B;
    public x76 B0;
    public final CustomMessageListener B1;
    public long C;
    public mv7 C0;
    public final AntiHelper.k C1;
    public long D;
    public f05 D0;
    public CustomMessageListener D1;
    public long E;
    public boolean E0;
    public CustomMessageListener E1;
    public long F;
    public AddExperiencedModel F0;
    public CustomMessageListener F1;
    public long G;
    public boolean G0;
    public CustomMessageListener G1;
    public long H;
    public boolean H0;
    public HttpMessageListener H1;
    public long I;
    public boolean I0;
    public ResponsedEventListener I1;
    public boolean J;
    public Date J0;
    public final CustomMessageListener J1;
    public int K;
    public int K0;
    public CustomMessageListener K1;
    public boolean L;
    public int L0;
    public final CustomMessageListener L1;
    public boolean M;
    public int M0;
    public CustomMessageListener M1;
    public boolean N;
    public List<LiveHorseRaceData> N0;
    public CustomMessageListener N1;
    public np5 O;
    public ValueAnimator O0;
    public CustomMessageListener O1;
    public boolean P;
    public Runnable P0;
    public final kva P1;
    @Nullable
    public dm5.b Q;
    public int Q0;
    public final CustomMessageListener Q1;
    public boolean R;
    public r18 R0;
    public final CustomMessageListener R1;
    public String S;
    public nv7 S0;
    public final CustomMessageListener S1;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1094T;
    @Nullable
    public TiePlusEventController T0;
    public CustomMessageListener T1;
    public boolean U;
    public int U0;
    public final Runnable U1;
    public nu.a V;
    public int V0;
    public final Runnable V1;
    public ThreadCardViewHolder W;
    public n68 W0;
    public final BdUniDispatchSchemeController.OnSchemeParsedCallback W1;
    public FrsModelController X;
    public wu7 X0;
    public final e28 X1;
    public l78 Y;
    public boolean Y0;
    public final View.OnTouchListener Y1;
    public FrsTabViewController Z;
    public boolean Z0;
    public final View.OnClickListener Z1;
    public String a;
    public b28 a0;
    public boolean a1;
    public final View.OnClickListener a2;
    public tv7 b;
    public o38 b0;
    public Object b1;
    public final RecyclerView.OnScrollListener b2;
    public boolean c;
    public v18 c0;
    public PollingModel c1;
    public final bs7 c2;
    public boolean d;
    public vt7 d0;
    public bm5 d1;
    public final NoNetworkView.b d2;
    public boolean e;
    public SparseArray<s06> e0;
    public boolean e1;
    public Runnable e2;
    public String f;
    public boolean f0;
    public boolean f1;
    public final CustomMessageListener f2;
    public String g;
    public jx7 g0;
    public boolean g1;
    public zi g2;
    public int h;
    public e78 h0;
    public int h1;
    public rt7 h2;
    public boolean i;
    public x18 i0;
    public int i1;
    public CustomMessageListener i2;
    public boolean j;
    public w18 j0;
    public long j1;
    public CustomMessageListener j2;
    public String k;
    public boolean k1;
    public CustomMessageListener k2;
    public String l;
    public MessageQueue.IdleHandler l1;
    public CustomMessageListener l2;
    public int m;
    public koc m1;
    public CustomMessageListener m2;
    public boolean n;
    public final CustomMessageListener n1;
    public CustomMessageListener n2;
    public dwa o;
    public CustomMessageListener o1;
    public CustomMessageListener o2;
    public boolean p;
    public CustomMessageListener p1;
    public CustomMessageListener p2;
    public boolean q;
    public CustomMessageListener q1;
    public HttpMessageListener q2;
    public VoiceManager r;
    public n78 r0;
    public CustomMessageListener r1;
    public CustomMessageListener r2;
    public View s;
    public u18 s0;
    public NetMessageListener s1;
    public w88 s2;
    public ms7 t;
    public q18 t0;
    public CustomMessageListener t1;
    public OvalActionButton u;
    public ls7 u0;
    public final rt7 u1;
    public FRSRefreshButton v;
    public g78 v0;
    public FrsTabViewController.h v1;
    public LinearLayout w;
    public x78 w0;
    public int w1;
    public FrsViewData x;
    public i78 x0;
    public CustomMessageListener x1;
    public String y;
    public boolean y0;
    public CustomMessageListener y1;
    public boolean z;
    public vz7 z0;
    public final CustomMessageListener z1;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? "frs_landing_page" : (String) invokeV.objValue;
    }

    public final boolean r4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048734, this, i2)) == null) ? (i2 == 506 || i2 == 507) ? false : true : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? "frs" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class n0 implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ n0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$n0$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0279a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0279a(a aVar, long j, int i, int i2, float f, int i3) {
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
                    this.b.a.Z.b(301);
                    long j = JavaTypesHelper.toLong((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L);
                    int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    SafeHandler.getInst().postDelayed(new RunnableC0279a(this, j, equipmentWidth, equipmentHeight, f, i), 1000L);
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

    /* loaded from: classes6.dex */
    public class b1 implements rt7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.K0()) {
                    this.a.a.b();
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

        @Override // com.baidu.tieba.rt7
        public void a(int i, int i2, du7 du7Var, ArrayList<pi> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), du7Var, arrayList}) == null) {
                SafeHandler.getInst().post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements k16.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes6.dex */
        public class a implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) && f05Var != null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) && f05Var != null) {
                    f05Var.dismiss();
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

        @Override // com.baidu.tieba.k16.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            String string;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) != null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.t.V();
            this.a.t.U();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.a.Z != null && this.a.Z.B() != null && (this.a.Z.B().b instanceof FrsNewAreaFragment)) {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.Z.B().b;
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
                    if (this.a.D0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.D0 = new f05(frsFragment.getActivity());
                    }
                    this.a.D0.setMessage(string);
                    this.a.D0.setPositiveButton(R.string.dialog_known, new a(this));
                    this.a.D0.setCanceledOnTouchOutside(false);
                    this.a.D0.create(this.a.getPageContext());
                    this.a.D0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.D0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.D0 = new f05(frsFragment2.getActivity());
                    }
                    this.a.D0.setMessage(string);
                    this.a.D0.setPositiveButton(R.string.obfuscated_res_0x7f0f0b86, new b(this));
                    this.a.D0.setCanceledOnTouchOutside(false);
                    this.a.D0.create(this.a.getPageContext());
                    this.a.D0.show();
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
                    frsNewAreaFragment.x3(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.v4(deleteThreadHttpResponseMessage.getSuccessItems());
                xr7.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (pi piVar : this.a.x.getThreadList()) {
                    if (piVar instanceof mz4) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.a.b();
                    return;
                }
                return;
            }
            BdUtilHelper.showToast(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes6.dex */
    public class q1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes6.dex */
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
                screenTopToast.n(this.a.getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(this.a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.p((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090caf));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class v1 implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes6.dex */
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

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == rs7.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.c2();
                }
            } else if (piVar != null && (piVar instanceof mz4)) {
                ThreadData threadData = ((mz4) piVar).t;
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
                    cx4 cartoonThreadData = threadData.getCartoonThreadData();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                } else {
                    rxa readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                    }
                    String ad_url = threadData.getAd_url();
                    if (ad_url != null && !ad_url.equals("")) {
                        pr6.a(new a(this, ad_url), "requestAdFrs", 3);
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
                        z68.c(threadData.getTaskInfoData());
                    } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                    }
                    a78.f(this.a, threadData, i, z);
                    FrsFragment frsFragment = this.a;
                    z68.d(frsFragment, frsFragment.x, threadData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            zz7 q1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                boolean z3 = false;
                if (i != 1) {
                    em6.b().e(false);
                    this.a.q5(false);
                }
                this.a.u.setIconFade(0);
                if ((this.a.getActivity() instanceof FrsActivity) && (q1 = ((FrsActivity) this.a.getActivity()).q1()) != null) {
                    q1.M0(i);
                }
                this.a.w1 = i;
                this.a.U0 = i2;
                if (this.a.R0 != null) {
                    this.a.R0.e(this.a.U0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.U0);
                this.a.s6();
                u38 u38Var = w38.q0;
                u38Var.e = i;
                u38Var.h = i2;
                u38Var.f = -1;
                if (this.a.G0) {
                    xr7 f = xr7.f();
                    if (i == 1 && this.a.G0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    f.p(z2, true);
                    wr7 h = wr7.h();
                    if (i == 1 && this.a.G0) {
                        z3 = true;
                    }
                    h.p(z3, true);
                    return;
                }
                ms7 ms7Var = this.a.t;
                if (!z && this.a.r4(i)) {
                    z3 = true;
                }
                ms7Var.b2(z3);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.Z != null) {
                FrsTabViewController.i B = this.a.Z.B();
                if (B != null && (fragment = B.b) != null && (fragment instanceof ot7)) {
                    ((ot7) fragment).F();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    SafeHandler.getInst().postDelayed(this.a.e2, 500L);
                    return;
                }
                this.a.u2().c2();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.Z.k0(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
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
            this.a.i6();
        }
    }

    /* loaded from: classes6.dex */
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
                d78.b(this.a.x, this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.Y.n0(num);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            this.a.Z.b(49);
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.R4();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.y0 = true;
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.Z.b(1);
                this.a.z4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    if (this.a.W == null && this.a.t.o0() != null && !this.a.t.e0() && this.a.t.o0().j() != null && (this.a.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.W = (ThreadCardViewHolder) frsFragment.t.o0().j().getTag();
                    }
                    if (this.a.W != null && this.a.W.a() != null) {
                        this.a.W.a().q(new nu.a(3));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.Y.q0(this.a.x);
                this.a.Z.d(this.a.x, this.a.X.j0());
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                this.a.t.b1();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.t.O0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (this.a.v != null && booleanValue && this.a.Z.K() != 0 && !this.a.t.N0() && !zh5.h().k()) {
                this.a.v.f();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getPageContext().getUniqueId()) && updateAttentionMessage.getData().blockData != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, this.a.C1) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements roc<NewsRemindMessage> {
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
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class i0 implements woc<Pair<NewsRemindMessage, Boolean>, NewsRemindMessage> {
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
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public NewsRemindMessage call(Pair<NewsRemindMessage, Boolean> pair) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pair)) == null) {
                return pair.first;
            }
            return (NewsRemindMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class j0 implements xoc<NewsRemindMessage, Boolean, Pair<NewsRemindMessage, Boolean>> {
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
        @Override // com.baidu.tieba.xoc
        /* renamed from: b */
        public Pair<NewsRemindMessage, Boolean> a(NewsRemindMessage newsRemindMessage, Boolean bool) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, newsRemindMessage, bool)) == null) {
                return Pair.create(newsRemindMessage, bool);
            }
            return (Pair) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.b.N0 != null && this.b.M0 > this.b.N0.size() - 1) {
                    this.b.w.removeAllViews();
                    this.b.w.setVisibility(8);
                    this.b.M0 = 0;
                    return;
                }
                this.b.d5();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.E5();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements woc<NewsRemindMessage, Boolean> {
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
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
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

    /* loaded from: classes6.dex */
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
                this.b.O0.start();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.s0.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                    new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f086a)).show(this.a.t.r0());
                    if (wr7.h().k(wr7.h().e())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (this.a.Z != null && this.a.Z.B() != null && (this.a.Z.B().b instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) this.a.Z.B().b;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.c3();
                        }
                        this.a.w4();
                        wr7.h().d();
                        for (pi piVar : this.a.x.getThreadList()) {
                            if (piVar instanceof mz4) {
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
                    wr7.h().n();
                    return;
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show(this.a.t.r0());
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c1 != null) {
                this.a.c1.getData(PollingModel.MEMBER_BROADCAST);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.J0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
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

    /* loaded from: classes6.dex */
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
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.Z.B() != null && (this.a.Z.B().b instanceof BaseFragment) && ((BaseFragment) this.a.Z.B().b).isPrimary() && !this.a.t.N0()) {
                    this.a.w.setVisibility(0);
                    this.a.J = false;
                    return;
                }
                this.a.w.setVisibility(8);
                this.a.J = true;
            }
        }
    }

    /* loaded from: classes6.dex */
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
            this.a.r6();
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements e28 {
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

        @Override // com.baidu.tieba.e28
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<pi> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) && this.a.b0 != null && this.a.X != null && this.a.X.M0() && z && !z2 && !z3) {
                this.a.b0.a(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jx4) && this.a.isResumed()) {
                jx4 jx4Var = (jx4) customResponsedMessage.getData();
                if (this.a.S0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.S0 = new nv7(frsFragment.getPageContext());
                }
                if (this.a.x != null && this.a.x.getForum() != null && !TextUtils.isEmpty(this.a.x.getForum().getId())) {
                    this.a.S0.j(jx4Var.a, this.a.x.getForum().getId(), this.a.x.getForum().getName(), jx4Var.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                if (this.a.d0 != null && this.a.d0.e() != null) {
                    this.a.d0.e().c(motionEvent);
                }
                if (this.a.z0 != null) {
                    this.a.z0.b(view2, motionEvent);
                }
                if (this.a.Y != null) {
                    this.a.Y.m0(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                if (TbadkApplication.getInst().getCurrentActivity() != null && !rd.isEmpty(str) && str.equals(this.a.l)) {
                    v68.f(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.x);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                this.a.t.R();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.Z.K() != 0 && this.a.Z.B() != null && (this.a.Z.B().b instanceof BaseFragment) && ((BaseFragment) this.a.Z.B().b).isPrimary() && !this.a.t.N0() && !zh5.h().k()) {
                    this.a.v.f();
                } else if (this.a.Z.K() != 0) {
                    this.a.v.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                m16 m16Var = (m16) customResponsedMessage.getData();
                int i = 0;
                if (this.a.x != null && this.a.x.getForum() != null && this.a.x.getForum().getDeletedReasonInfo() != null) {
                    int intValue = this.a.x.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
                    int intValue2 = this.a.x.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
                    if (this.a.x.forumRule != null) {
                        i = this.a.x.forumRule.has_forum_rule.intValue();
                    }
                    n16 n16Var = new n16(intValue, intValue2, i);
                    n16Var.i(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                    n16Var.h(this.a.x.getForum().getImage_url());
                    n16Var.j(this.a.x.getForum().getUser_level());
                    j16.d(n16Var.f(), this.a.getPageContext(), m16Var, n16Var, this.a.x.getUserData());
                    return;
                }
                j16.d(0, this.a.getPageContext(), m16Var, null, this.a.x.getUserData());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.g6();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                oxa.o(this.a.f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || !((z = responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage))) {
                return;
            }
            List<LiveHorseRaceData> arrayList = new ArrayList<>();
            if (z) {
                arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().a();
            }
            if (this.a.N0 != null) {
                if (this.a.w == null || this.a.w.getVisibility() != 8) {
                    if (this.a.M0 < this.a.N0.size()) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.N0 = frsFragment.N0.subList(0, this.a.M0);
                        this.a.N0.addAll(arrayList);
                        return;
                    }
                    this.a.N0.addAll(arrayList);
                    return;
                }
                this.a.N0 = new ArrayList();
                this.a.N0.addAll(arrayList);
                this.a.M0 = 0;
                this.a.d5();
                return;
            }
            this.a.N0 = new ArrayList();
            this.a.M0 = 0;
            this.a.N0.addAll(arrayList);
            this.a.d5();
        }
    }

    /* loaded from: classes6.dex */
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
                x68.c(this.a.getActivity(), this.a.x);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            this.a.o5();
        }
    }

    /* loaded from: classes6.dex */
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
            this.a.z4();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        }
    }

    /* loaded from: classes6.dex */
    public class u implements kva {
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

        @Override // com.baidu.tieba.kva
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.b.t.P0();
                }
            }
        }

        @Override // com.baidu.tieba.kva
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.E5();
            }
        }

        @Override // com.baidu.tieba.kva
        public void c(dva dvaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dvaVar) == null) {
                if ((dvaVar != null && ("normal_page".equals(this.b.X.s0()) || "frs_page".equals(this.b.X.s0()) || "book_page".equals(this.b.X.s0()))) || "brand_page".equals(this.b.X.s0())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, dvaVar));
                    this.b.F5(dvaVar);
                    FrsFragment.x2 = dvaVar;
                }
            }
        }

        @Override // com.baidu.tieba.kva
        public void d(int i, boolean z, vua vuaVar) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), vuaVar}) == null) {
                if (this.b.f0) {
                    this.b.f0 = false;
                    z68.b(this.b.t, this.b.x, this.b.w(), false, null);
                }
                this.b.k6();
                this.b.N = true;
                if (vuaVar != null && vuaVar.b) {
                    this.b.t.a0().m(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.y2 = 0L;
                    FrsFragment.z2 = 0L;
                    FrsFragment.A2 = 0;
                } else {
                    FrsFragment.A2 = 1;
                }
                if (!this.b.X.M0() && (i == 3 || i == 6)) {
                    this.b.j0.l();
                }
                this.b.C = System.currentTimeMillis();
                if (this.b.X.w0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.x = frsFragment.X.w0();
                }
                x68.f(this.b.getContext(), 1, this.b.x);
                x68.c(this.b.getActivity(), this.b.x);
                if (i == 7) {
                    this.b.D5(this.b.x.getFrsDefaultTabId());
                    return;
                }
                if (this.b.x.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.P5(frsFragment2.x.getPage().b());
                }
                if (i != 4) {
                    this.b.m6();
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 || i == 6) {
                                if (this.b.x != null) {
                                    this.b.x.clearPostThreadCount();
                                }
                                g78 g78Var = this.b.v0;
                                if (g78Var != null) {
                                    g78Var.d();
                                }
                            }
                        } else {
                            this.b.t.P0();
                        }
                    } else {
                        this.b.t.P0();
                    }
                    x68.g(this.b.x, this.b.t);
                    if (vuaVar != null && vuaVar.c != 0) {
                        if (this.b.x == null || ListUtils.isEmpty(this.b.x.getThreadList())) {
                            this.b.j6(vuaVar);
                        } else if (vuaVar.a) {
                            FrsFragment frsFragment3 = this.b;
                            frsFragment3.showToast(frsFragment3.getPageContext().getResources().getString(R.string.net_error_text, vuaVar.d, Integer.valueOf(vuaVar.c)));
                        }
                    } else if (this.b.x != null) {
                        this.b.z = true;
                        if (this.b.I() != null) {
                            FrsFragment frsFragment4 = this.b;
                            if (!frsFragment4.e6(frsFragment4.x, this.b.I())) {
                                this.b.R4();
                                this.b.w5();
                            }
                        }
                        FrsFragment frsFragment5 = this.b;
                        if (i == 5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        frsFragment5.y5(false, z2);
                        if (this.b.X != null) {
                            if (this.b.x.getActivityHeadData() != null && this.b.x.getActivityHeadData().b() != null && this.b.x.getActivityHeadData().b().size() > 0) {
                                t38.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.X.t0(), 1);
                            }
                            if (this.b.x.getThreadList() != null && this.b.x.getThreadList().size() > 0) {
                                Iterator<pi> it = this.b.x.getThreadList().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    pi next = it.next();
                                    if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                        t38.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.X.t0(), 2);
                                        break;
                                    }
                                }
                            }
                            t38.i(this.b.getUniqueId(), this.b.x.getThreadList(), this.b.x.getForum(), this.b.X.t0());
                        }
                        this.b.t.c1(i);
                        FrsFragment.y2 = (System.nanoTime() - this.a) / 1000000;
                        if (vuaVar != null) {
                            FrsFragment.z2 = vuaVar.e;
                        }
                    } else {
                        return;
                    }
                    this.b.u4();
                    if (this.b.x.getAccessFlag() == 1) {
                        TiebaStatic.log(new StatisticItem("c11384"));
                    }
                    if (this.b.p && this.b.Z.b(49)) {
                        this.b.p = false;
                    }
                    System.gc();
                    return;
                }
                if (!this.b.X.M0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.X.u0() == 1 && (this.b.x.adShowSelect == 1 || this.b.x.adShowSelect == 3)) {
                    this.b.x.addRecommendAppToThreadList(this.b);
                }
                ArrayList<pi> c = this.b.j0.c(false, false, this.b.x.getThreadList(), this.b.o, false, this.b.x.adShowSelect, this.b.x.adMixFloor);
                if (c != null) {
                    this.b.x.setThreadList(c);
                    this.b.x.checkLiveStageInThreadList();
                }
                if (this.b.X != null) {
                    v38.m(this.b.x, this.b.X.j0(), 2, this.b.getContext());
                }
                FrsFragment frsFragment6 = this.b;
                c68.a(frsFragment6, frsFragment6.x.getForum(), this.b.x.getThreadList(), false, this.b.Q4());
                this.b.t.M1(c, this.b.x);
                this.b.m6();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09076d);
                if (this.a.t != null && view2 == this.a.t.X() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090e4a && BdUtilHelper.isNetOk()) {
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
                if (this.a.t != null && view2 == this.a.t.h0() && this.a.X != null && this.a.X.hasMore()) {
                    this.a.t.U1();
                    this.a.b();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.i0()) {
                    this.a.o5();
                    if (ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        this.a.t.X0();
                        this.a.s5(((ea5) ServiceManager.getService(ea5.a)).a(), 2);
                    }
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(this.a.getContext().getApplicationContext(), (int) R.string.network_not_available);
                } else if (this.a.x != null && this.a.x.getForum() != null) {
                    if (this.a.t != null && (view2 == this.a.t.z0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.x != null && this.a.x.getForum() != null && !StringUtils.isNull(this.a.x.getForum().getId()) && !StringUtils.isNull(this.a.x.getForum().getName())) {
                            a38.e(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                            v68.e(this.a.getPageContext(), this.a.x, this.a.x.getForum().getId(), this.a.K, this.a.L, this.a.Z1);
                        } else {
                            return;
                        }
                    }
                    if ((this.a.t != null && view2 == this.a.t.y0()) || logicField == LogicField.SEARCH_BTN) {
                        StatisticItem param = new StatisticItem("c12402").param("fid", this.a.x.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.x.getForum().getName());
                        a38.a(param);
                        TiebaStatic.log(param);
                        if (!StringUtils.isNull(this.a.x.getForum().getName())) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{fs7.i("frs", this.a.x.getForum().getName(), this.a.x.getForum().getId())});
                        }
                    }
                    if (this.a.t != null && view2 == this.a.t.x0() && this.a.x != null && this.a.x.frsForumGroup != null && this.a.x.frsForumGroup.topbar_entrance != null && !TextUtils.isEmpty(this.a.x.frsForumGroup.topbar_entrance.jump_url)) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.x.frsForumGroup.topbar_entrance.jump_url});
                        j68.a(this.a.w());
                        FrsTopBarGroupEntranceGuideView w0 = this.a.t.w0();
                        h68.c();
                        if (w0 != null) {
                            w0.a();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u1 implements rt7 {
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

        @Override // com.baidu.tieba.rt7
        public void a(int i, int i2, du7 du7Var, ArrayList<pi> arrayList) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), du7Var, arrayList}) == null) {
                this.a.k6();
                if (this.a.g0 != null) {
                    this.a.Y.z0(this.a.g0.e(i));
                }
                vua vuaVar = new vua();
                if (du7Var != null) {
                    if (du7Var.e == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    vuaVar.b = z;
                    vuaVar.c = du7Var.e;
                    vuaVar.d = du7Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.B0();
                        } else if (du7Var.g) {
                            if (ListUtils.getCount(this.a.x.getThreadList()) > 3) {
                                this.a.t.U1();
                            } else {
                                this.a.t.Q1();
                            }
                        } else if (du7Var.i) {
                            this.a.t.X1();
                        } else {
                            this.a.t.B0();
                        }
                    }
                } else {
                    du7Var = new du7();
                    du7Var.c = 1;
                    du7Var.g = false;
                    du7Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.P1.d(frsFragment.X.getType(), false, vuaVar);
                } else {
                    this.a.j6(vuaVar);
                    if (this.a.X.w0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.x = frsFragment2.X.w0();
                    }
                    this.a.B5();
                }
                if (this.a.h2 != null) {
                    this.a.h2.a(i, i2, du7Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                z68.b(this.a.t, this.a.x, this.a.w(), true, (ThreadData) data);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.c.Y != null) {
                    this.c.Y.J0(i);
                    if (i == 1) {
                        this.c.Y.Y();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.O == null && !frsFragment.j5()) {
                    this.c.O = new np5();
                    this.c.O.a(1000);
                }
                if (i == 0) {
                    np5 np5Var = this.c.O;
                    if (np5Var != null) {
                        np5Var.e();
                    }
                    em6.b().e(true);
                    this.c.q5(true);
                    this.c.t.S0(this.a, this.b);
                    if (this.c.b1 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.b1);
                        this.c.b1 = null;
                    }
                } else {
                    if (this.c.b1 == null) {
                        this.c.b1 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    np5 np5Var2 = this.c.O;
                    if (np5Var2 != null) {
                        np5Var2.d();
                    }
                }
                if (this.c.x0 != null) {
                    this.c.x0.i(recyclerView, i);
                }
                if (i == 0) {
                    z68.b(this.c.t, this.c.x, this.c.w(), false, null);
                }
                if (this.c.Z != null && i == 1) {
                    this.c.Z.O();
                }
                if (this.c.W == null) {
                    if (this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.W = (ThreadCardViewHolder) frsFragment2.t.o0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.W = (ThreadCardViewHolder) frsFragment3.t.o0().j().getTag();
                }
                if (i == 1) {
                    this.c.t.R0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                FrsFragment.L3(this.c, i2);
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.c.L0 >= this.c.K0 * 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
                }
                if (this.c.h0 != null) {
                    this.c.h0.j();
                }
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.c.x0 != null) {
                    this.c.x0.h(recyclerView, this.a, this.b);
                }
                if (this.c.x != null && this.c.t != null && this.c.t.a0() != null) {
                    this.c.t.q1(this.a, this.b);
                    if (this.c.W != null && this.c.W.a() != null) {
                        this.c.W.a().q(this.c.V);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (this.b.I() != null && this.b.I().getPageActivity() != null) {
                    this.b.j1 = l.longValue();
                    c78.b().c(this.a, l.longValue());
                    YunDialogManager.onShow(this.b.I().getPageActivity(), y05.q);
                    if (this.b.Y.U() != null) {
                        this.b.Y.U().e();
                    }
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements bs7 {
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

        @Override // com.baidu.tieba.bs7
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i == this.a.t.a0().c()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        return;
                    }
                    TiebaStatic.log("forum_fortune_click");
                    a78.e(this.a.getPageContext(), this.a.x);
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
                    if (!rd.isEmpty(bawuCenterUrl) && this.a.x.getForum() != null) {
                        BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.x.getForum().getId()).param("uid", this.a.x.getUserData().getUserId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class w1 implements xt7 {
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

        @Override // com.baidu.tieba.xt7
        public void a(boolean z, boolean z2, int i) {
            FrsFragment frsFragment;
            ms7 ms7Var;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || (frsFragment = this.a.get()) == null || (ms7Var = frsFragment.t) == null) {
                return;
            }
            int i2 = 8;
            int i3 = 0;
            if (i == 1) {
                ms7Var.F1(xr7.f().h());
                if (z) {
                    i2 = 0;
                }
                ms7Var.G1(i2);
            } else if (i == 2) {
                if (z) {
                    i2 = 0;
                }
                ms7Var.C1(i2);
            }
            if (!z2) {
                frsFragment.G0 = z;
            }
            if (ms7Var.a0() != null && (i == 2 || (frsFragment.X != null && frsFragment.X.n0()))) {
                ms7Var.a0().notifyDataSetChanged();
            }
            if (frsFragment.V4() != null) {
                FrsTabViewController.i B = frsFragment.V4().B();
                if (B != null) {
                    Fragment fragment = B.b;
                    if ((fragment instanceof FrsCommonTabFragment) && i == 2) {
                        ((FrsCommonTabFragment) fragment).e3();
                    } else if ((B.b instanceof FrsNewAreaFragment) && (i == 2 || B.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) B.b;
                        frsNewAreaFragment.B3();
                        if (frsNewAreaFragment.m3() != null) {
                            a28 m3 = frsNewAreaFragment.m3();
                            m3.J(!z);
                            if (i == 1) {
                                m3.G(!z);
                            } else if (i == 2) {
                                m3.G(true);
                            }
                        }
                    } else {
                        Fragment fragment2 = B.b;
                        if (fragment2 instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment2).v3();
                        }
                    }
                }
                if (frsFragment.V4().M() != null) {
                    frsFragment.V4().M().setmDisallowSlip(z);
                    frsFragment.V4().h0(z);
                }
            }
            if (ms7Var.c0() != null) {
                if (frsFragment.p4() && !z) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ms7Var.b2(z3);
            }
            if (frsFragment.getActivity() instanceof FrsActivity) {
                FrsActivity frsActivity = (FrsActivity) frsFragment.getActivity();
                frsActivity.y1(!z);
                zz7 q1 = frsActivity.q1();
                if (q1 != null && q1.n0()) {
                    if (z) {
                        i3 = 4;
                    }
                    q1.I0(i3);
                }
            }
            if (frsFragment.C0 != null) {
                frsFragment.C0.f(!z);
            }
            ms7Var.L1(!z);
            if (i == 1) {
                ms7Var.B1(!z);
            } else if (i == 2) {
                ms7Var.B1(true);
            }
        }

        @Override // com.baidu.tieba.xt7
        public void b(int i) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (frsFragment = this.a.get()) == null || frsFragment.getContext() == null) {
                return;
            }
            ms7 ms7Var = frsFragment.t;
            if (i == 1) {
                BdUtilHelper.showToast(frsFragment.getContext(), (int) R.string.obfuscated_res_0x7f0f0871);
            } else if (i == 2 && ms7Var != null) {
                new BdTopToast(frsFragment.getContext()).setIcon(false).setContent(frsFragment.getContext().getString(R.string.obfuscated_res_0x7f0f0864)).show(ms7Var.r0());
            }
        }

        @Override // com.baidu.tieba.xt7
        public void c(int i, int i2) {
            FrsFragment frsFragment;
            ms7 ms7Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || (frsFragment = this.a.get()) == null || (ms7Var = frsFragment.t) == null) {
                return;
            }
            if (i2 == 1) {
                ms7Var.E1(i);
            } else if (i2 == 2) {
                ms7Var.D1(i);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.X.u0() == 1 && z && !this.a.t.e0()) {
                if (this.a.x != null && !ListUtils.isEmpty(this.a.x.getThreadList())) {
                    this.a.t.P0();
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

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.N && BdNetTypeUtil.isNetWorkAvailable() && !this.a.t.M0()) {
                this.a.t.e1();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Z != null && (B = this.a.Z.B()) != null && (fragment = B.b) != null && (fragment instanceof ot7)) {
                ((ot7) fragment).l();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                e68.a(customResponsedMessage, this.a.t, this.a.x);
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
        t2 = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
        u2 = TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=%1$s&nomenu=1";
        v2 = false;
        w2 = null;
        y2 = 0L;
        z2 = 0L;
        A2 = 0;
        D2 = "3";
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.c1 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.c1 = pollingModel;
                pollingModel.setDialogTime(y05.f);
            }
            this.c1.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.U1, m45.a().b());
            SafeHandler.getInst().postDelayed(this.V1, 500L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.i B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (V4() != null && (B = V4().B()) != null) {
                Fragment fragment = B.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        int i2 = -1;
                        FrsViewData frsViewData = this.x;
                        if (frsViewData != null) {
                            i2 = frsViewData.getSortType();
                        }
                        tbPageTag.sortType = y68.g(i2);
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

    public final boolean l5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            if (Q1() == null) {
                return false;
            }
            FrsViewData Q1 = Q1();
            kx4 kx4Var = null;
            if (Q1.getStar() != null && !StringUtils.isNull(Q1.getStar().a())) {
                kx4Var = new kx4();
            } else if (Q1.getActivityHeadData() != null && ListUtils.getCount(Q1.getActivityHeadData().b()) >= 1) {
                kx4Var = Q1.getActivityHeadData().b().get(0);
            }
            if (kx4Var == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            if (Z4() != 1 && !this.j0.b(this.x.getThreadListIds())) {
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

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            if (Z4() == 0 && ListUtils.isEmpty(this.x.getThreadListIds())) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onPause();
            this.a0.f(false);
            this.P = false;
            this.t.Y0();
            l78 l78Var = this.Y;
            if (l78Var != null) {
                l78Var.j0();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.t.Q0(true);
            e78 e78Var = this.h0;
            if (e78Var != null) {
                e78Var.j();
            }
            po4.w().E();
            bm5 bm5Var = this.d1;
            if (bm5Var != null && !bm5Var.isEnable()) {
                this.d1.onPause();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921825, Boolean.TRUE));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.t.g0().stopScroll();
            if (this.t.l1()) {
                return;
            }
            if (!BdUtilHelper.isNetOk()) {
                this.t.B0();
            } else if (this.X.u0() == 1) {
                l6();
                b();
            } else if (this.X.hasMore()) {
                b();
            }
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            if (!s4() && this.x.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                Q5(this.x.getPrivateForumTotalInfo().a().private_forum_audit_status, this.x.getPrivateForumTotalInfo().b(), false);
            } else {
                Q5(null, null, true);
            }
        }
    }

    public final void w5() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (frsViewData = this.x) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.x.getForum().getId())) {
            String id = this.x.getForum().getId();
            long a2 = c78.b().a(id);
            this.j1 = a2;
            if (a2 > 0) {
                if (I() != null) {
                    YunDialogManager.onShow(I().getPageActivity(), y05.q);
                    return;
                }
                return;
            }
            I5(id);
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
        this.f1094T = true;
        this.U = true;
        this.V = new nu.a(2);
        this.e0 = new SparseArray<>();
        this.f0 = true;
        this.E0 = false;
        this.G0 = false;
        this.I0 = false;
        this.J0 = null;
        this.K0 = 0;
        this.L0 = 0;
        this.M0 = 0;
        this.Q0 = -1;
        this.V0 = -1;
        this.e1 = false;
        this.f1 = false;
        this.g1 = false;
        this.h1 = 0;
        this.j1 = -1L;
        this.k1 = false;
        this.l1 = new k(this);
        this.m1 = null;
        this.n1 = new v(this, 2016495);
        this.o1 = new g0(this, 2921005);
        this.p1 = new r0(this, 2921401);
        this.q1 = new c1(this, 2921473);
        this.r1 = new n1(this, 2921467);
        this.s1 = new s1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.t1 = new t1(this, 2001624);
        this.u1 = new u1(this);
        this.v1 = new a(this);
        this.x1 = new b(this, 2001606);
        this.y1 = new c(this, 2001607);
        this.z1 = new d(this, 2003019);
        this.A1 = new e(this, 2921470);
        this.B1 = new f(this, 2001352);
        this.C1 = new g(this);
        this.D1 = new h(this, 2001115);
        this.E1 = new i(this, 2921346);
        this.F1 = new j(this, 2001374);
        this.G1 = new l(this, 2001378);
        this.H1 = new m(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.I1 = new n(this);
        this.J1 = new o(this, 2921391);
        this.K1 = new p(this, 2003020);
        this.L1 = new q(this, 2921463);
        this.M1 = new r(this, 2921587);
        this.N1 = new s(this, 2921588);
        this.O1 = new t(this, 2003023);
        this.P1 = new u(this);
        this.Q1 = new a0(this, 2016485);
        this.R1 = new b0(this, 2003025);
        this.S1 = new c0(this, 2001194);
        this.T1 = new d0(this, 2921682);
        this.U1 = new l0(this);
        this.V1 = new m0(this);
        this.W1 = new n0(this);
        this.X1 = new o0(this);
        this.Y1 = new p0(this);
        this.Z1 = new t0(this);
        this.a2 = new u0(this);
        this.b2 = new v0(this);
        this.c2 = new w0(this);
        this.d2 = new x0(this);
        this.e2 = new y0(this);
        this.f2 = new z0(this, 0);
        this.g2 = new v1(this, null);
        this.h2 = new b1(this);
        this.i2 = new d1(this, 2921033);
        this.j2 = new e1(this, 2921381);
        this.k2 = new f1(this, 2921414);
        this.l2 = new g1(this, 2921437);
        this.m2 = new l1(this, 2921462);
        this.n2 = new m1(this, 2001223);
        this.o2 = new o1(this, 2921469);
        this.p2 = new p1(this, 2921475);
        this.q2 = new q1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.r2 = new r1(this, 2921515);
    }

    public static /* synthetic */ int L3(FrsFragment frsFragment, int i2) {
        int i3 = frsFragment.L0 + i2;
        frsFragment.L0 = i3;
        return i3;
    }

    @Override // com.baidu.tieba.t06
    public void f1(int i2, s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048663, this, i2, s06Var) == null) {
            this.e0.put(i2, s06Var);
        }
    }

    public void s5(@NonNull NewsRemindMessage newsRemindMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048740, this, newsRemindMessage, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NEW_MSG_TAB_CLICK);
            statisticItem.addParam("obj_type", S4(newsRemindMessage));
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void H5(boolean z3) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z3) == null) && (frsTabViewController = this.Z) != null) {
            frsTabViewController.u = z3;
        }
    }

    @Override // com.baidu.tieba.h25
    public void I1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z3) == null) {
            this.f1094T = z3;
        }
    }

    public final void I5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            FrsVisitedInfoManager.f().g(str, new w(this, str));
        }
    }

    public void K5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z3) == null) {
            this.e = z3;
        }
    }

    public void L5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z3) == null) {
            C2 = z3;
        }
    }

    public void M5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.i1 = i2;
            if (i2 == 13) {
                this.t.r1("frs_hot_tab");
            }
            if (i2 == 14) {
                this.t.r1("frs_new_tab");
            }
        }
    }

    public void N5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.h = i2;
        }
    }

    public void O5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.f = str;
        }
    }

    public void P5(int i2) {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048617, this, i2) != null) || (w18Var = this.j0) == null) {
            return;
        }
        w18Var.n(i2);
    }

    public void R5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z3) == null) {
            this.e1 = z3;
            this.f1 = z3;
        }
    }

    @Override // com.baidu.tieba.h25
    public void S1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z3) == null) {
            R5(z3);
        }
    }

    public void S5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z3) == null) {
            this.g1 = z3;
        }
    }

    @Override // com.baidu.tieba.t06
    public s06 T1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            return this.e0.get(i2);
        }
        return (s06) invokeI.objValue;
    }

    public void T5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z3) == null) {
            this.R = z3;
        }
    }

    public void U5(boolean z3) {
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z3) == null) && (n78Var = this.r0) != null) {
            n78Var.Y();
        }
    }

    public void W5(boolean z3) {
        vt7 vt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048639, this, z3) == null) && (vt7Var = this.d0) != null) {
            vt7Var.i(z3);
        }
    }

    @NonNull
    public void X5(dm5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, bVar) == null) {
            this.Q = bVar;
        }
    }

    public void Y5(int i2) {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048643, this, i2) != null) || (w18Var = this.j0) == null) {
            return;
        }
        w18Var.o(i2);
    }

    public void Z5(boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048646, this, z3) != null) || this.s2 != null) {
            return;
        }
        w88 a2 = w88.a(z3);
        this.s2 = a2;
        w18 w18Var = this.j0;
        if (w18Var != null) {
            w18Var.m(a2);
        }
    }

    public void b6(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public void c6(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, linearLayout) != null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public void d6(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048659, this, fRSRefreshButton) != null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new a1(this));
    }

    @Override // com.baidu.tieba.h25
    public boolean g0(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, activity)) == null) {
            if (!FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) || SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0) >= 2 || this.k1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, view2) == null) {
            this.t.t1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).z1(view2, false);
            this.t.j0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.t1(0);
            this.t.j0().f(false);
        }
    }

    public final void n4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            U5("frs_page".equals(str));
            jx7 jx7Var = this.g0;
            if (jx7Var != null) {
                jx7Var.c(this.Y, this.t, this.x);
            }
        }
    }

    @Override // com.baidu.tieba.t06
    public void o0(r06 r06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, r06Var) == null) {
            this.u0.a(r06Var);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, str) == null) {
            l6();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z3) == null) {
            super.onUserChanged(z3);
        }
    }

    public void p5(Object obj) {
        v18 v18Var;
        w4 w4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048725, this, obj) == null) && (v18Var = this.c0) != null && (w4Var = v18Var.j) != null) {
            w4Var.c(obj);
        }
    }

    @Override // com.baidu.tieba.h25
    public void q1(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, activity) == null) {
            this.k1 = true;
            SharedPrefHelper.getInstance().putInt("key_forum_broadcast_edit_tip_number", SharedPrefHelper.getInstance().getInt("key_forum_broadcast_edit_tip_number", 0) + 1);
        }
    }

    public void q5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z3) == null) {
            pua.g().h(getUniqueId(), z3);
        }
    }

    public void q6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            new BdTopToast(getContext(), 3000).setIcon(true).setContent(str).show(this.t.r0());
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, str) == null) {
            this.g = str;
        }
    }

    @Override // com.baidu.tieba.h25
    public void u1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z3) == null) {
            this.U = z3;
        }
    }

    public void u6(Object obj) {
        v18 v18Var;
        w4 w4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048755, this, obj) == null) && (v18Var = this.c0) != null && (w4Var = v18Var.i) != null) {
            w4Var.c(obj);
        }
    }

    public final void v6(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, viewGroup) == null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    public void z5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048772, this, i2) == null) {
            this.N = false;
            s6();
            ms7 ms7Var = this.t;
            if (ms7Var != null && ms7Var.o0() != null) {
                this.t.o0().y();
            }
            FrsModelController frsModelController = this.X;
            if (frsModelController != null) {
                frsModelController.Z0(i2, true);
            }
        }
    }

    public void h6(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048676, this, str, str2, str3) == null) {
            n68 n68Var = new n68(str, str2);
            this.W0 = n68Var;
            n68Var.o(getFragmentActivity(), str3, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048705, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            u18 u18Var = this.s0;
            if (u18Var != null) {
                u18Var.n(i2, i3, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048717, this, i2, strArr, iArr) == null) {
            a78.i(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048746, this, view2, str, z3) == null) {
            super.showNetRefreshViewNoClick(view2, str, z3);
            this.t.t1(8);
        }
    }

    public bm5 A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d1;
        }
        return (bm5) invokeV.objValue;
    }

    public void A5() {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ms7Var = this.t) != null) {
            ms7Var.h1();
        }
    }

    @Override // com.baidu.tieba.h25
    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (P4() != null) {
                return P4().M1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public jx7 B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g0;
        }
        return (jx7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rha
    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mt7
    public void E0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && isAdded() && this.f0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.r0());
        }
    }

    public zi E4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g2;
        }
        return (zi) invokeV.objValue;
    }

    public void E5() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (frsModelController = this.X) != null && frsModelController.u0() == 1) {
            this.Y.u0(this.x);
        }
    }

    @Override // com.baidu.tieba.h25
    public FrsSpriteNewUserGuide F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (Q1() != null) {
                return Q1().frsSpriteNewUserGuide;
            }
            return null;
        }
        return (FrsSpriteNewUserGuide) invokeV.objValue;
    }

    public int G4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return a78.c(this.x, this.t);
        }
        return invokeV.intValue;
    }

    public void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.t0 == null) {
                this.t0 = new q18(this, JavaTypesHelper.toInt(this.l, 0));
            }
            this.t0.w();
        }
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public PopInfo H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            dva frsResponseData = TbSingleton.getInstance().getFrsResponseData();
            if (frsResponseData != null) {
                return frsResponseData.frsMaskPopInfo;
            }
            return null;
        }
        return (PopInfo) invokeV.objValue;
    }

    public x18 H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.i0;
        }
        return (x18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rha
    @Nullable
    public TbPageContext<?> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean I0() {
        InterceptResult invokeV;
        zz7 q12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if ((getActivity() instanceof FrsActivity) && (q12 = ((FrsActivity) getActivity()).q1()) != null) {
                return q12.W();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public o38 I4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b0;
        }
        return (o38) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f28
    public FrsModelController J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.X;
        }
        return (FrsModelController) invokeV.objValue;
    }

    public boolean J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e1;
        }
        return invokeV.booleanValue;
    }

    public void J5() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.i B;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (frsTabViewController = this.Z) != null && (B = frsTabViewController.B()) != null && (fragment = B.b) != null && (fragment instanceof ot7)) {
            ((ot7) fragment).F();
        }
    }

    public boolean K4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.g1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mt7
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.t.e0();
        }
        return invokeV.booleanValue;
    }

    public boolean M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.f1;
        }
        return invokeV.booleanValue;
    }

    public BdTypeRecyclerView N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ms7 ms7Var = this.t;
            if (ms7Var == null) {
                return null;
            }
            return ms7Var.g0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public vt7 O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.d0;
        }
        return (vt7) invokeV.objValue;
    }

    public dm5.b P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.Q;
        }
        return (dm5.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t18
    public FrsViewData Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.x;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public int Q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            w18 w18Var = this.j0;
            if (w18Var == null) {
                return 1;
            }
            return w18Var.g();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.Y0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mt7
    public void T() {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (ms7Var = this.t) != null) {
            ms7Var.g0().scrollToPosition(0);
            this.t.c2();
        }
    }

    public View T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public final AbsDataRecorder.Scene U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            int i2 = this.i1;
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

    public FrsTabViewController V4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.Z;
        }
        return (FrsTabViewController) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public IResponseData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return TbSingleton.getInstance().getFrsResponseData();
        }
        return (IResponseData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public UserData W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (Q1() != null) {
                return Q1().getUserData();
            }
            return null;
        }
        return (UserData) invokeV.objValue;
    }

    public String X4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public OvalActionButton Y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.u;
        }
        return (OvalActionButton) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rha
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            J1().l1();
        }
    }

    public int Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            w18 w18Var = this.j0;
            if (w18Var == null) {
                return -1;
            }
            return w18Var.h();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public ForumData a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (Q1() != null) {
                return Q1().getForum();
            }
            return null;
        }
        return (ForumData) invokeV.objValue;
    }

    public void a5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    public final void a6() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048649, this) != null) || (frsViewData = this.x) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.a0().setFromCDN(true);
        } else {
            this.t.a0().setFromCDN(false);
        }
    }

    @Override // com.baidu.tieba.f28
    public void b() {
        w18 w18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (w18Var = this.j0) != null) {
            w18Var.i(this.f, this.l, this.x);
        }
    }

    public void b5() {
        l78 l78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (l78Var = this.Y) != null) {
            l78Var.Z();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f28
    public l78 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.Y;
        }
        return (l78) invokeV.objValue;
    }

    public void c5() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
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

    @Override // com.baidu.tieba.mt7
    public void e0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && isAdded() && this.f0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.r0(), true);
        }
    }

    @Override // com.baidu.tieba.f28
    public w18 f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.j0;
        }
        return (w18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h25
    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.U;
        }
        return invokeV.booleanValue;
    }

    public boolean g5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public void g6() {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048670, this) == null) && (ms7Var = this.t) != null) {
            ms7Var.P1();
        }
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t18
    public /* bridge */ /* synthetic */ BdPageContext getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tieba.l4b
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return String.valueOf(getUniqueId().getId());
        }
        return (String) invokeV.objValue;
    }

    public boolean h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return C2;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    public long i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.j1;
        }
        return invokeV.longValue;
    }

    public boolean i5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean j5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean k5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.Z0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public AddBawuPopInfo m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            dva frsResponseData = TbSingleton.getInstance().getFrsResponseData();
            if (frsResponseData != null) {
                return frsResponseData.bawuPopInfo;
            }
            return null;
        }
        return (AddBawuPopInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rha
    public int m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            w18 w18Var = this.j0;
            if (w18Var == null) {
                return 1;
            }
            return w18Var.g();
        }
        return invokeV.intValue;
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            FrsModelController frsModelController = this.X;
            if (frsModelController != null) {
                n4(frsModelController.s0());
            } else {
                n4("normal_page");
            }
        }
    }

    public boolean m5() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public sy4 n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            if (Q1() != null) {
                return Q1().getPrivateForumTotalInfo();
            }
            return null;
        }
        return (sy4) invokeV.objValue;
    }

    public boolean n5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            if (Q1() == null) {
                return false;
            }
            FrsViewData Q1 = Q1();
            if (ListUtils.isEmpty(Q1.getShowTopThreadList()) && Q1.getBusinessPromot() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return N4().getPreLoadHandle();
        }
        return (ti) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            super.onStart();
            VoiceManager d12 = d1();
            this.r = d12;
            if (d12 != null) {
                d12.onStart(getPageContext());
            }
        }
    }

    public boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return q4(this.w1);
        }
        return invokeV.booleanValue;
    }

    public void p6() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048726, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.f();
        }
    }

    @Override // com.baidu.tieba.h25
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (P4() != null) {
                return P4().r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h25
    @Nullable
    public PrivateForumPopInfoData r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (Q1() != null) {
                return Q1().getPrivateForumPopInfo();
            }
            return null;
        }
        return (PrivateForumPopInfoData) invokeV.objValue;
    }

    public boolean r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            if (l5() && !n5()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && !rd.isEmpty(this.l)) {
            po4.w().P(oo4.a0, JavaTypesHelper.toLong(this.l, 0L));
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            c26.c().f("page_frs");
            z5(3);
        }
    }

    @Override // com.baidu.tieba.h25
    public void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom())) {
            x68.d(this, this.u, this.t);
        }
    }

    public void s6() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && (voiceManager = this.r) != null) {
            voiceManager.stopPlay();
        }
    }

    public void t4() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            if (getActivity() == null) {
                intent = null;
            } else {
                intent = getActivity().getIntent();
            }
            a78.a(getPageContext(), intent, this.g);
        }
    }

    public final void t5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && this.x != null) {
            zx6 o2 = zx6.o();
            ForumData forum = this.x.getForum();
            FrsViewData frsViewData = this.x;
            o2.t(forum, frsViewData.forumTagInfo, frsViewData.firstCategory);
        }
    }

    public void t6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048749, this) != null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.baidu.tieba.f28
    public ms7 u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.t;
        }
        return (ms7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t18, com.baidu.tieba.st7
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return VideoAudioHelper.checkNeedAutoPlay(2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.st7
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pt7
    public NavigationBar x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            ms7 ms7Var = this.t;
            if (ms7Var == null) {
                return null;
            }
            return ms7Var.k0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            if (this.h == 1) {
                zb.a().b(new s0(this));
            }
            this.h = 0;
        }
    }

    @Override // com.baidu.tieba.h25
    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            return this.f1094T;
        }
        return invokeV.booleanValue;
    }

    public final void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            this.t.c2();
        }
    }

    public final void B5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s6();
            try {
                if (this.x == null) {
                    return;
                }
                this.t.T1();
                this.t.b2(p4());
                if (this.x.getForum() != null) {
                    this.f = this.x.getForum().getName();
                    this.l = this.x.getForum().getId();
                }
                if (this.x.getPage() != null) {
                    P5(this.x.getPage().b());
                }
                this.t.N1(this.f);
                this.t.s1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.x.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.x.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.x.getUserData().getBimg_end_time());
                x5();
                a6();
                ArrayList<pi> threadList = this.x.getThreadList();
                if (threadList != null) {
                    this.t.M1(threadList, this.x);
                    e68.b(this.t);
                    this.Y.I0(m2());
                    this.x.setFrsFragmentTag(getUniqueId());
                    this.Y.q0(this.x);
                    this.Z.d(this.x, this.X.j0());
                    this.t.n1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void V5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || this.x == null) {
            return;
        }
        u38 u38Var = new u38();
        if (this.x.needLog == 1) {
            u38Var.a = true;
        } else {
            u38Var.a = false;
        }
        if (this.x.getForum() != null) {
            u38Var.c = this.x.getForum().getId();
            u38Var.d = this.x.getForum().getName();
        }
        if (J1() != null) {
            u38Var.b = J1().j0();
        }
        u38 u38Var2 = w38.q0;
        if (u38Var2 != null) {
            u38Var.e = u38Var2.e;
            u38Var.f = u38Var2.f;
        }
        r18 r18Var = new r18(u38Var, getTbPageTag(), getUniqueId());
        this.R0 = r18Var;
        r18Var.e(this.U0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.R0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.R0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.R0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.R0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public final void i6() {
        FrsViewData frsViewData;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && getActivity() != null && getActivity().getIntent() != null && (frsViewData = this.x) != null && frsViewData.getForum() != null && !TextUtils.isEmpty(w())) {
            if (getActivity().getIntent().getBooleanExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST, false) && h5()) {
                if (this.x.getForum().isLike() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.x.getUserData() != null && this.x.getUserData().getIs_manager() != 1) {
                    this.x.getUserData().getIs_bawu();
                }
                if (this.d1 != null) {
                    getActivity().getIntent().removeExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST);
                    dm5.b bVar = this.Q;
                    if (bVar != null) {
                        bVar.h2(false);
                    }
                    this.d1.a(getPageContext(), null, JavaTypesHelper.toLong(w(), 0L), v(), getActivity().getIntent().getLongExtra(FrsActivityConfig.LOCATE_ROOM_ID, -1L), z3, getActivity().getSupportFragmentManager(), D2, "dialog");
                    return;
                }
                return;
            }
            x68.c(getActivity(), this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onResume();
            int i2 = this.h1;
            if (i2 <= 1) {
                this.h1 = i2 + 1;
            }
            ms7 ms7Var = this.t;
            if (ms7Var != null) {
                ms7Var.P0();
                this.t.a1();
            }
            l78 l78Var = this.Y;
            if (l78Var != null) {
                l78Var.l0();
            }
            if (this.h1 > 1 && K4()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                S5(false);
            }
            bm5 bm5Var = this.d1;
            if (bm5Var != null && !bm5Var.isEnable()) {
                this.d1.onResume();
            }
            this.a0.f(true);
            this.P = true;
            if (v2) {
                v2 = false;
                ms7 ms7Var2 = this.t;
                if (ms7Var2 != null) {
                    ms7Var2.c2();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            ms7 ms7Var3 = this.t;
            if (ms7Var3 != null) {
                ms7Var3.Q0(false);
            }
            if (this.y0) {
                z5(6);
                this.y0 = false;
            }
            if (this.J0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    SignManager.getInstance().setSignAlert(true, this.J0.getHours(), this.J0.getMinutes());
                    if (this.t != null && I() != null) {
                        SignManager.getInstance().showSignNavBarCoverTip(I().getPageActivity(), this.t.r0());
                    }
                }
                this.J0 = null;
            }
            r6();
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048762, this) == null) && !ListUtils.isEmpty(wr7.h().i()) && this.t.g0() != null && this.t.g0().getData() != null) {
            ArrayList<pi> threadList = this.x.getThreadList();
            if (ListUtils.isEmpty(threadList)) {
                return;
            }
            Iterator<pi> it = threadList.iterator();
            List<pi> data = this.t.g0().getData();
            int count = ListUtils.getCount(wr7.h().i());
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    pi next = it.next();
                    if (next instanceof mz4) {
                        ThreadData threadData = ((mz4) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= count) {
                                break;
                            } else if (StringHelper.equals(wr7.h().i().get(i4).getId(), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.j0.j(next);
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
                    z68.f("frsfragment-doMoveThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public final void C4(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, intent) != null) || intent == null) {
            return;
        }
        if (!w68.a(this, v(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
                BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.W1);
            } else {
                q68 b2 = a78.b(intent);
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

    public void i(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048679, this, errorData) != null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        k6();
        this.t.P0();
        vua l02 = this.X.l0();
        boolean isEmpty = ListUtils.isEmpty(this.x.getThreadList());
        if (l02 != null && isEmpty) {
            if (this.X.o0() != 0) {
                this.X.i1();
                this.t.P0();
            } else {
                j6(l02);
            }
            this.t.v1(this.x.isStarForum(), false);
            return;
        }
        j6(l02);
    }

    public final void v4(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048757, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<pi> threadList = this.x.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.t.g0() != null && this.t.g0().getData() != null) {
            Iterator<pi> it = threadList.iterator();
            List<pi> data = this.t.g0().getData();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                try {
                    pi next = it.next();
                    if (next instanceof mz4) {
                        ThreadData threadData = ((mz4) next).t;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= list.size()) {
                                break;
                            } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                                it.remove();
                                data.remove(next);
                                this.j0.j(next);
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
                    z68.f("frsfragment-doDeleteThread()", i3, i2, e2);
                    throw null;
                }
            }
        }
    }

    public boolean C5() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            l78 l78Var = this.Y;
            if (l78Var != null && (frsModelController = this.X) != null) {
                l78Var.L0(frsModelController.s0(), this.x);
            }
            boolean z3 = false;
            FrsViewData frsViewData2 = this.x;
            if (frsViewData2 != null) {
                z3 = frsViewData2.hasTab();
            }
            m4();
            ms7 ms7Var = this.t;
            if (ms7Var != null) {
                ms7Var.F0();
                this.t.G0();
                FrsViewData frsViewData3 = this.x;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.Z0 = p68.j(this.x.getBusinessPromot(), this.x.getForum().getId());
                }
                if (!this.Z0 && (frsViewData = this.x) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.E0(this.x.getActivityHeadData().a());
                    if (this.x.getActivityHeadData().a() != null && !this.Y0 && !this.Z0 && !this.a1 && !J4()) {
                        g6();
                    }
                } else {
                    this.t.E0(null);
                }
            }
            return z3;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabInfoData W4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.X == null || (frsViewData = this.x) == null || this.Z == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.x.getEntelechyTabInfo().a)) {
                return null;
            }
            int F = this.Z.F();
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

    public ForumWriteData D4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
                forumWriteData.frsTabInfo = W4();
                FrsViewData frsViewData2 = this.x;
                forumWriteData.forumTagInfo = frsViewData2.forumTagInfo;
                forumWriteData.firstCategory = frsViewData2.firstCategory;
                return forumWriteData;
            }
            return null;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public final void o5() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048702, this) != null) || !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
        a38.a(param);
        a38.b(param, w(), v());
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onStop();
            em6.b().e(false);
            q5(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                qd5.j().x(getPageContext().getPageActivity(), "frs", this.x.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (N4() != null) {
                N4().getRecycledViewPool().clear();
            }
            this.Y.h0();
            ju5.c();
        }
    }

    public final void D5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            C5();
            s6();
            try {
                if (this.x == null) {
                    return;
                }
                zt7 zt7Var = null;
                this.t.M1(null, this.x);
                this.Y.I0(1);
                this.t.n1();
                this.Z.d(this.x, this.X.j0());
                l58 J = this.Z.J(this.x.getFrsDefaultTabId());
                if (J != null && !TextUtils.isEmpty(J.d)) {
                    zt7Var = new zt7();
                    String str = J.d;
                    String str2 = J.a;
                }
                this.X.J(this.x.getFrsDefaultTabId(), 0, zt7Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void e5(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, bundle) == null) {
            registerListener(2001118, this.f2);
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
                registerListener(2001120, this.f2);
            }
            this.Y.f0(bundle);
            y4(j2);
        }
    }

    public final void j6(vua vuaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, vuaVar) == null) {
            if (vuaVar == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bc);
                this.t.d1();
                showNetRefreshView(this.t.r0(), string, true);
            } else if (340001 == vuaVar.c) {
                o6(vuaVar, this.x.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    n6(vuaVar);
                }
                if (j5()) {
                    setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703b1));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.H0) {
                this.t.U0(i2);
                this.Y.i0(i2);
                this.Z.W(i2);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                x78 x78Var = this.w0;
                if (x78Var != null) {
                    x78Var.onChangeSkinType();
                }
                mv7 mv7Var = this.C0;
                if (mv7Var != null) {
                    mv7Var.d(getPageContext(), i2);
                }
                if (this.D0 != null) {
                    jq5.a(getPageContext(), this.D0.getRealView());
                }
                i78 i78Var = this.x0;
                if (i78Var != null) {
                    i78Var.onChangeSkinType(getPageContext(), i2);
                }
                wu7 wu7Var = this.X0;
                if (wu7Var != null) {
                    wu7Var.onChangeSkinType(getPageContext(), i2);
                }
                bm5 bm5Var = this.d1;
                if (bm5Var != null && !bm5Var.isEnable()) {
                    this.d1.onChangeSkinType(i2);
                }
            }
        }
    }

    public int F4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.V0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.V0;
        }
        return invokeV.intValue;
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (this.h == 0) {
                this.t.N1(this.f);
            } else {
                this.t.N1("");
                this.h = 1;
            }
            this.t.J1(this.g2);
            this.t.M(this.b2);
            this.t.K1(this.d2);
            this.t.a0().l(this.c2);
        }
    }

    public void k6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            hideLoadingView(this.t.r0());
            this.t.e2();
            if (this.t.q0() instanceof k58) {
                ((k58) this.t.q0()).d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && j5()) {
            showLoadingView(this.t.r0(), true);
            this.t.I1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.X.Z0(3, true);
            N4().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048714, this) != null) || !BdUtilHelper.isNetOk()) {
            return;
        }
        hideNetRefreshView(this.t.b0().m());
        showLoadingView(this.t.r0(), true);
        this.t.C0(false);
        this.X.Z0(3, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                l78 l78Var = this.Y;
                if (l78Var != null) {
                    l78Var.k0(isPrimary());
                }
                ms7 ms7Var = this.t;
                if (ms7Var != null) {
                    ms7Var.Z0(isPrimary());
                    this.t.Q0(!isPrimary());
                }
            }
        }
    }

    public final boolean s4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.x.getPrivateForumTotalInfo().a() == null || this.x.getUserData().getIs_manager() != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F5(dva dvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dvaVar) == null) {
            try {
                if (!this.N && dvaVar != null && this.x != null) {
                    this.x.receiveData(dvaVar);
                    y5(true, false);
                    Looper.myQueue().addIdleHandler(this.l1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public String S4(@NonNull NewsRemindMessage newsRemindMessage) {
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

    public boolean q4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048729, this, i2)) == null) {
            if (!this.R || this.I0 || !r4(i2)) {
                return false;
            }
            FrsModelController frsModelController = this.X;
            if (frsModelController != null && frsModelController.n0() && (xr7.f().i() || wr7.h().j())) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z3) == null) {
            super.setPrimary(z3);
            FrsTabViewController frsTabViewController = this.Z;
            if (frsTabViewController != null && frsTabViewController.B() != null && (this.Z.B().b instanceof BaseFragment)) {
                ((BaseFragment) this.Z.B().b).setPrimary(z3);
            }
        }
    }

    public void u5(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048754, this, intent) != null) || intent == null) {
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
            z4();
        }
    }

    public void v5(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, str) == null) && TbadkCoreApplication.isLogin() && !rd.isEmpty(str)) {
            if (this.F0 == null && I() != null) {
                this.F0 = new AddExperiencedModel(I());
            }
            AddExperiencedModel addExperiencedModel = this.F0;
            if (addExperiencedModel != null) {
                addExperiencedModel.S(this.l, str);
            }
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void Q5(Integer num, Integer num2, boolean z3) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048620, this, num, num2, z3) != null) || this.t.p0() == null) {
            return;
        }
        TextView p02 = this.t.p0();
        if (z3) {
            p02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            p02.setText(getString(R.string.obfuscated_res_0x7f0f02bf));
            p02.setVisibility(0);
            str = String.format(u2, this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            p02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f0440), num2));
            p02.setVisibility(0);
            str = String.format(t2, this.l, this.f);
            i2 = 1;
        } else {
            p02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        p02.setOnClickListener(new x(this, i2, str));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048745, this, view2, str, z3) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z3, getNetRefreshListener());
            this.t.t1(8);
            this.t.j0().f(true);
            woa.a("frs", false);
            fp5.a.a(getUniqueId(), new kotlin.Pair<>(PushMessageHelper.ERROR_TYPE, "frs_page"), new kotlin.Pair<>("error_info", "frs page net error"));
        }
    }

    public final void d5() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && isResumed() && (list = this.N0) != null && list.size() >= 1 && this.M0 <= this.N0.size() - 1) {
            LiveHorseRaceData liveHorseRaceData = this.N0.get(this.M0);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.M0++;
                d5();
            }
            if (this.w != null) {
                FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    if (liveHorseRaceData.getUser_nickname().length() > 4) {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bfe), liveHorseRaceData.getUser_nickname().substring(0, 4) + "...");
                    } else {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bfe), liveHorseRaceData.getUser_nickname());
                    }
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0bfe), getResources().getString(R.string.obfuscated_res_0x7f0f0850));
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new h1(this, liveHorseRaceData));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.O0 = ofFloat;
                ofFloat.setDuration(600L);
                this.O0.addUpdateListener(new i1(this, frsRedpackRunView));
                this.O0.addListener(new j1(this, frsRedpackRunView));
                this.P0 = new k1(this, frsRedpackRunView);
                SafeHandler.getInst().postDelayed(this.P0, 5000L);
                if (this.w.getChildCount() == 0) {
                    this.M0++;
                    this.w.addView(frsRedpackRunView);
                    FrsViewData frsViewData = this.x;
                    String str = "";
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        str = this.x.getForum().getName();
                    }
                    TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.l).param("fname", str));
                }
                LinearLayout linearLayout = this.w;
                if (linearLayout != null && linearLayout.getVisibility() == 8 && ((BaseFragment) this.Z.B().b).isPrimary() && !this.t.N0() && !this.J) {
                    this.w.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            pua.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.i2);
            MessageManager.getInstance().unRegisterListener(this.G1);
            unRegisterResponsedEventListener();
            this.r0.X();
            x2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ija.c("FRS");
            this.r = null;
            em6.b().e(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                et7.a().b(JavaTypesHelper.toLong(this.x.getForum().getId(), 0L));
            }
            q18 q18Var = this.t0;
            if (q18Var != null) {
                q18Var.v();
            }
            ms7 ms7Var = this.t;
            if (ms7Var != null) {
                z68.b(ms7Var, this.x, w(), false, null);
                this.t.V0();
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.w.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.O0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.P0 != null) {
                SafeHandler.getInst().removeCallbacks(this.P0);
            }
            if (this.U1 != null) {
                SafeHandler.getInst().removeCallbacks(this.U1);
            }
            SafeHandler.getInst().removeCallbacks(this.V1);
            this.N0 = null;
            xr7.f().s(null);
            wr7.h().s(null);
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
            this.Y.g0();
            Looper.myQueue().removeIdleHandler(this.l1);
            if (m45.a().b() != 300000) {
                m45.a().d(300000L);
            }
            FrsModelController frsModelController = this.X;
            if (frsModelController != null) {
                frsModelController.n();
            }
            vt7 vt7Var = this.d0;
            if (vt7Var != null) {
                vt7Var.d();
            }
            e78 e78Var = this.h0;
            if (e78Var != null) {
                e78Var.i();
            }
            o38 o38Var = this.b0;
            if (o38Var != null) {
                o38Var.c();
            }
            i78 i78Var = this.x0;
            if (i78Var != null) {
                i78Var.g();
            }
            u18 u18Var = this.s0;
            if (u18Var != null) {
                u18Var.o();
            }
            f16 f16Var = this.A0;
            if (f16Var != null) {
                f16Var.h();
            }
            x76 x76Var = this.B0;
            if (x76Var != null) {
                x76Var.g();
            }
            n68 n68Var = this.W0;
            if (n68Var != null) {
                n68Var.f();
            }
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            FrsTabViewController frsTabViewController = this.Z;
            if (frsTabViewController != null) {
                frsTabViewController.f0(null);
                this.Z.O();
            }
            AddExperiencedModel addExperiencedModel = this.F0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            if (this.T0 != null) {
                getLifecycle().removeObserver(this.T0);
            }
            SafeHandler.getInst().removeCallbacks(this.e2);
            bm5 bm5Var = this.d1;
            if (bm5Var != null && !bm5Var.isEnable()) {
                this.d1.onDestroy();
            }
            this.d1 = null;
            koc kocVar = this.m1;
            if (kocVar != null) {
                kocVar.unsubscribe();
            }
            this.m1 = null;
            YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
            fp5.a.a(getUniqueId(), new kotlin.Pair<>(PushMessageHelper.ERROR_TYPE, "frs_page"), new kotlin.Pair<>("error_info", "frs page unfinished destroy"));
        }
    }

    public boolean e6(dva dvaVar, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048662, this, dvaVar, tbPageContext)) == null) {
            if (!J4()) {
                if (dvaVar != null && dvaVar.getBusinessPromot() != null && !StringUtils.isNull(dvaVar.getBusinessPromot().r()) && dvaVar.getForum() != null) {
                    boolean j2 = p68.j(dvaVar.getBusinessPromot(), dvaVar.getForum().getId());
                    this.Z0 = j2;
                    R5(j2);
                    return this.Z0;
                }
                wu7 wu7Var = new wu7(tbPageContext);
                this.X0 = wu7Var;
                boolean j3 = wu7Var.j(dvaVar);
                this.Y0 = j3;
                R5(j3);
                return this.Y0;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void f6(View view2, String str, boolean z3, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{view2, str, Boolean.valueOf(z3), list}) == null) {
            this.t.d1();
            this.t.t1(8);
            if (this.w0 == null) {
                this.w0 = new x78(getPageContext(), getNetRefreshListener());
            }
            this.w0.c(str);
            this.w0.b(list);
            this.w0.attachView(view2, z3);
        }
    }

    public final void l4(boolean z3, boolean z4) {
        FrsModelController frsModelController;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) && (frsModelController = this.X) != null && this.x != null && this.t != null && z3) {
            if (!frsModelController.M0() && this.X.u0() == 1) {
                if (!this.X.J0()) {
                    this.x.addCardVideoInfoToThreadList();
                    this.x.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z5 = false;
                if (this.t.a0().k(hn6.g)) {
                    z5 = this.x.addHotTopicDataToThreadList();
                }
                if (!z5) {
                    this.x.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                    if (this.i1 == 14) {
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
            if (this.t.a0().k(p98.e)) {
                this.x.addGameRankListToThreadList(z4);
            }
            if (TbadkCoreApplication.isLogin() && (!this.X.M0() || this.X.isNetFirstLoad)) {
                this.x.addUserRecommendToThreadList();
            }
            this.x.addVideoActivityToTop();
            this.x.addHeaderCardToThreadList();
        }
    }

    public final void n6(vua vuaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, vuaVar) == null) {
            this.t.d1();
            if (vuaVar.a) {
                showNetRefreshView(this.t.r0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{vuaVar.d, Integer.valueOf(vuaVar.c)}), true);
                return;
            }
            showNetRefreshView(this.t.b0().m(), vuaVar.d, true);
            v6(this.t.b0().m());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            super.onCreate(bundle);
            pua.g().i(getUniqueId());
            if (this.T0 == null) {
                this.T0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.T0);
            this.d1 = am5.a();
            registerResponsedEventListener(TopToastEvent.class, this.I1);
            fp5.a.e(getUniqueId(), this);
            fp5.a.g(getUniqueId());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.X.X0(bundle);
            if (this.r != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.r.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void x4(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048765, this, i2) == null) {
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

    public final void y4(long j2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048768, this, j2) == null) && j2 > 0) {
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

    public final void o6(vua vuaVar, List<RecmForumInfo> list) {
        ms7 ms7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048703, this, vuaVar, list) == null) && (ms7Var = this.t) != null) {
            ms7Var.d1();
            this.t.N1(this.f);
            if (this.t.b0() != null) {
                f6(this.t.r0(), vuaVar.d, true, list);
            }
            this.t.j0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048744, this, view2, z3) == null) {
            this.t.t1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z3);
            ((FrsActivity) getActivity()).z1(view2, true);
            this.t.j0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                C4(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new dwa("frs", dwa.c);
            if (this.X == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.P1);
                this.X = frsModelController;
                frsModelController.N(this.u1);
                this.X.init();
            }
            this.X.j1(this.y);
            ArrayList<pi> arrayList = null;
            if (intent != null) {
                this.X.C0(intent.getExtras());
            } else if (bundle != null) {
                this.X.C0(bundle);
            } else {
                this.X.C0(null);
            }
            if (intent != null) {
                this.Y.f0(intent.getExtras());
            } else if (bundle != null) {
                this.Y.f0(bundle);
            } else {
                this.Y.f0(null);
            }
            this.r = d1();
            this.u0 = new ls7(getPageContext(), this);
            f5();
            e5(bundle);
            if (!j5()) {
                vt7 vt7Var = new vt7(getActivity(), this.t, this.Y);
                this.d0 = vt7Var;
                vt7Var.i(true);
            }
            VoiceManager d12 = d1();
            this.r = d12;
            if (d12 != null) {
                d12.onCreate(getPageContext());
            }
            if (!g0(getActivity())) {
                x68.a(this, getFrom(), this.E0, this.u, this.t);
            }
            x68.b(this, getFrom(), this.E0, this.u);
            if (zh5.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new c28();
            int i2 = -1;
            w18 w18Var = this.j0;
            if (w18Var != null && w18Var.f() != null) {
                i2 = this.j0.f().S();
                arrayList = this.j0.f().R();
            }
            w18 w18Var2 = new w18(this, this.X1);
            this.j0 = w18Var2;
            w18Var2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.j0.f().c0(arrayList);
            }
            this.b0 = new o38(this);
            this.r0 = new n78(this);
            this.h0 = new e78(getPageContext(), this.X.H0());
            this.c0 = new v18(this);
            this.i0 = new x18(this);
            this.a0 = new b28(this);
            this.s0 = new u18(this);
            this.v0 = new g78(this);
            new y18(this, getUniqueId());
            this.A0 = new f16(getPageContext(), "frs");
            this.B0 = new x76(getPageContext());
            new s38(getPageContext());
            registerListener(this.D1);
            registerListener(this.S1);
            registerListener(this.B1);
            registerListener(this.Q1);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.n1);
            registerListener(this.o1);
            registerListener(this.p1);
            registerListener(this.q1);
            registerListener(this.i2);
            registerListener(this.F1);
            this.G1.setSelfListener(true);
            this.G1.setTag(getPageContext().getUniqueId());
            registerListener(this.G1);
            registerListener(this.t1);
            registerListener(this.E1);
            registerListener(this.J1);
            registerListener(this.K1);
            registerListener(this.L1);
            this.j2.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.j2);
            registerListener(this.k2);
            registerListener(this.l2);
            registerListener(this.m2);
            registerListener(this.s1);
            registerListener(this.n2);
            registerListener(this.H1);
            registerListener(this.r1);
            registerListener(this.o2);
            registerListener(this.p2);
            registerListener(this.q2);
            registerListener(this.r2);
            registerListener(this.M1);
            registerListener(this.N1);
            registerListener(this.O1);
            this.R1.setTag(getPageContext().getUniqueId());
            registerListener(this.R1);
            registerListener(this.T1);
            this.t.C0(false);
            if (!j5() && !this.E0) {
                showLoadingView(this.t.r0(), true);
                this.X.h0(3, false);
            }
            r88.a();
            w1 w1Var = new w1(this);
            xr7.f().s(w1Var);
            wr7.h().s(w1Var);
            this.t.H1(new e0(this));
            this.K0 = UtilHelper.getScreenHeight(getActivity());
            this.E0 = true;
            x4(1);
            super.onActivityCreated(bundle);
            Lifecycle lifecycle = getFragmentActivity().getLifecycle();
            PollingLifecycleHelper pollingLifecycleHelper = new PollingLifecycleHelper();
            pollingLifecycleHelper.k(1500L);
            pollingLifecycleHelper.j(new f0(this));
            lifecycle.addObserver(pollingLifecycleHelper);
            ea5 ea5Var = (ea5) ServiceManager.getService(ea5.a);
            if (ea5Var != null && this.m1 == null) {
                this.m1 = doc.c(ea5Var.g().k(new k0(this)), ea5Var.c(), new j0(this)).p(new i0(this)).H(new h0(this));
            }
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048708, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0360, viewGroup, false);
                tv7 tv7Var = new tv7();
                this.b = tv7Var;
                this.g0 = tv7Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0898);
                this.Y = new l78(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090fa1));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.a2);
                this.Z = frsTabViewController;
                frsTabViewController.a0();
                this.Y.K0(this.Z);
                this.Z.f0(this.v1);
                Intent intent = getActivity().getIntent();
                if (intent != null) {
                    if ("main_tab".equals(intent.getStringExtra("from"))) {
                        this.d = true;
                    }
                    this.Z.e0(intent.getIntExtra(FrsActivityConfig.KEY_JUMP_TAB_ID, 0));
                }
                this.t = new ms7(this, this.a2, this.b, this.d, this.Y);
                this.C0 = new mv7(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.Z;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.a0();
                }
                this.t.f1();
                this.s.setLeft(0);
                this.s.setRight(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
            }
            this.H0 = true;
            this.G = System.currentTimeMillis() - currentTimeMillis;
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048712, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (xr7.f().i()) {
                    xr7.f().m();
                    return true;
                } else if (wr7.h().j()) {
                    ms7 ms7Var = this.t;
                    if (ms7Var != null && ms7Var.L0()) {
                        this.t.k1();
                        return true;
                    }
                    wr7.h().n();
                    return true;
                } else {
                    ms7 ms7Var2 = this.t;
                    if (ms7Var2 != null) {
                        return ms7Var2.W0();
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

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void q(ArrayList<pi> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            P5(!isEmpty ? 1 : 0);
            l6();
            if (isEmpty) {
                return;
            }
            if (n26.k().l(U4())) {
                n26.k().g(U4()).b();
            }
            if (g36.i().o(U4())) {
                g36.i().g(U4()).b();
            }
            if (!this.X.M0() && TbadkCoreApplication.getInst().isRecAppExist() && this.X.u0() == 1 && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                this.x.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.X != null) {
                t38.i(getUniqueId(), arrayList, this.x.getForum(), this.X.t0());
            }
            w18 w18Var = this.j0;
            dwa dwaVar = this.o;
            FrsViewData frsViewData = this.x;
            ArrayList<pi> c2 = w18Var.c(false, false, arrayList, dwaVar, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.x.setThreadList(c2);
                this.t.M1(c2, this.x);
            }
            FrsModelController frsModelController = this.X;
            if (frsModelController != null) {
                v38.m(this.x, frsModelController.j0(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.x.getForum()));
        }
    }

    public final void y5(boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048769, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            try {
                if (this.x != null && this.Z != null && this.X != null) {
                    if (!this.t.a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.x.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.x.getGameTabInfo());
                    this.t.y1(isEmpty);
                    boolean z5 = true;
                    if (!isEmpty) {
                        if (this.x0 == null) {
                            this.x0 = new i78(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.z0 == null) {
                            this.z0 = new vz7(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.x0 = null;
                        this.z0 = null;
                    }
                    if (this.x.getForum() != null) {
                        this.f = this.x.getForum().getName();
                        this.l = this.x.getForum().getId();
                    }
                    i6();
                    if (this.x.hasTab()) {
                        this.Z.d(this.x, this.X.j0());
                    }
                    if (z3) {
                        l4(true, z3);
                    } else {
                        l4(this.P, z3);
                    }
                    C5();
                    if (this.g0 != null) {
                        this.g0.a(this.Y, this.x);
                    }
                    if (this.x.getPage() != null) {
                        P5(this.x.getPage().b());
                    }
                    ArrayList<pi> arrayList = new ArrayList<>();
                    if (!ListUtils.isEmpty(this.x.getThreadList())) {
                        arrayList.addAll(this.x.getThreadList());
                        if (this.X != null && this.X.L0() && h68.a(this.l) && this.x.frsForumGroup != null && this.x.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.x.frsForumGroup.feed_card.group_list) && this.x.frsForumGroup.feed_card.index.intValue() >= 0) {
                            hx7.f(this.x.frsForumGroup, arrayList, this.l);
                        }
                    }
                    ArrayList<pi> d2 = this.j0.d(z4, true, arrayList, null, z3, false, this.x.adShowSelect, this.x.adMixFloor);
                    if (d2 != null) {
                        this.x.setThreadList(d2);
                    }
                    this.x.removeRedundantUserRecommendData();
                    int topThreadSize = this.x.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        c68.a(this, this.x.getForum(), this.x.getThreadList(), this.n, Q4());
                    }
                    if (this.X.u0() == 1) {
                        B5();
                        if (!z3 && this.X.getPn() == 1) {
                            G5();
                        }
                    }
                    if (this.h0 != null) {
                        this.h0.k(this.Z.G());
                    }
                    k6();
                    this.t.m1();
                    this.t.v1(true, false);
                    if (this.x.frsForumGroup == null) {
                        ms7 ms7Var = this.t;
                        if (this.Y0) {
                            z5 = false;
                        }
                        ms7Var.h2(null, z5);
                    } else {
                        ms7 ms7Var2 = this.t;
                        TopbarEntrance topbarEntrance = this.x.frsForumGroup.topbar_entrance;
                        if (this.Y0) {
                            z5 = false;
                        }
                        ms7Var2.h2(topbarEntrance, z5);
                    }
                    if (z3 && this.x.isFirstTabEqualAllThread()) {
                        SafeHandler.getInst().post(new y(this));
                    }
                    if (this.x.getForum() != null) {
                        this.t.Q(this.x.getForum().getWarningMsg());
                    }
                    if (this.x != null && this.x.getFrsVideoActivityData() != null && SharedPrefHelper.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                        SafeHandler.getInst().postDelayed(new z(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.O1();
                    t5();
                    this.C0.e(this.x.bottomMenuList, this.x.getForum());
                    r6();
                    if (this.x != null && this.x.getForum() != null && !TextUtils.isEmpty(this.x.getForum().getId())) {
                        String id = this.x.getForum().getId();
                        c78.b().c(id, System.currentTimeMillis());
                        FrsVisitedInfoManager.f().i(id);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
