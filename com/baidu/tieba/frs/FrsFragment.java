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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
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
import com.baidu.tieba.a57;
import com.baidu.tieba.a77;
import com.baidu.tieba.a9;
import com.baidu.tieba.a97;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ad9;
import com.baidu.tieba.ah5;
import com.baidu.tieba.ay6;
import com.baidu.tieba.b57;
import com.baidu.tieba.b77;
import com.baidu.tieba.bb5;
import com.baidu.tieba.bb9;
import com.baidu.tieba.bh5;
import com.baidu.tieba.c19;
import com.baidu.tieba.c57;
import com.baidu.tieba.c77;
import com.baidu.tieba.c87;
import com.baidu.tieba.cx4;
import com.baidu.tieba.cx6;
import com.baidu.tieba.d57;
import com.baidu.tieba.d77;
import com.baidu.tieba.d97;
import com.baidu.tieba.da9;
import com.baidu.tieba.dd9;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.dh5;
import com.baidu.tieba.e57;
import com.baidu.tieba.e77;
import com.baidu.tieba.e87;
import com.baidu.tieba.ef6;
import com.baidu.tieba.eg6;
import com.baidu.tieba.ez6;
import com.baidu.tieba.f57;
import com.baidu.tieba.f97;
import com.baidu.tieba.fe5;
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
import com.baidu.tieba.fz6;
import com.baidu.tieba.g37;
import com.baidu.tieba.g87;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.gn;
import com.baidu.tieba.gt4;
import com.baidu.tieba.h57;
import com.baidu.tieba.hi;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hx5;
import com.baidu.tieba.i26;
import com.baidu.tieba.i37;
import com.baidu.tieba.i57;
import com.baidu.tieba.i67;
import com.baidu.tieba.i77;
import com.baidu.tieba.i87;
import com.baidu.tieba.ia7;
import com.baidu.tieba.ia9;
import com.baidu.tieba.j57;
import com.baidu.tieba.j77;
import com.baidu.tieba.j87;
import com.baidu.tieba.jg;
import com.baidu.tieba.jw6;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kn;
import com.baidu.tieba.kq5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.kw6;
import com.baidu.tieba.kx4;
import com.baidu.tieba.kx6;
import com.baidu.tieba.ky5;
import com.baidu.tieba.l57;
import com.baidu.tieba.lz6;
import com.baidu.tieba.m35;
import com.baidu.tieba.m57;
import com.baidu.tieba.m59;
import com.baidu.tieba.m85;
import com.baidu.tieba.mg;
import com.baidu.tieba.mx6;
import com.baidu.tieba.mz4;
import com.baidu.tieba.na7;
import com.baidu.tieba.nx6;
import com.baidu.tieba.ny;
import com.baidu.tieba.o29;
import com.baidu.tieba.o87;
import com.baidu.tieba.o97;
import com.baidu.tieba.ow5;
import com.baidu.tieba.p87;
import com.baidu.tieba.pw5;
import com.baidu.tieba.pw6;
import com.baidu.tieba.px6;
import com.baidu.tieba.q29;
import com.baidu.tieba.q87;
import com.baidu.tieba.qa9;
import com.baidu.tieba.qn;
import com.baidu.tieba.qx6;
import com.baidu.tieba.r87;
import com.baidu.tieba.rw5;
import com.baidu.tieba.rx6;
import com.baidu.tieba.s87;
import com.baidu.tieba.sb9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sp5;
import com.baidu.tieba.sw5;
import com.baidu.tieba.sx5;
import com.baidu.tieba.sy6;
import com.baidu.tieba.t87;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tl5;
import com.baidu.tieba.tx6;
import com.baidu.tieba.uv6;
import com.baidu.tieba.v05;
import com.baidu.tieba.v87;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.vv6;
import com.baidu.tieba.vx6;
import com.baidu.tieba.w05;
import com.baidu.tieba.w07;
import com.baidu.tieba.w67;
import com.baidu.tieba.w87;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wk5;
import com.baidu.tieba.wv5;
import com.baidu.tieba.x47;
import com.baidu.tieba.xa7;
import com.baidu.tieba.xa9;
import com.baidu.tieba.xf;
import com.baidu.tieba.xv5;
import com.baidu.tieba.y07;
import com.baidu.tieba.y25;
import com.baidu.tieba.y47;
import com.baidu.tieba.y77;
import com.baidu.tieba.y87;
import com.baidu.tieba.yp4;
import com.baidu.tieba.yv5;
import com.baidu.tieba.z77;
import com.baidu.tieba.z8;
import com.baidu.tieba.za;
import com.baidu.tieba.zp4;
import com.baidu.tieba.zv6;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.TopbarEntrance;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, a57, UserIconBox.e<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, qx6, c19, m57, yv5, kx6, nx6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String n2;
    public static final String o2;
    public static boolean p2;
    public static final ThreadData q2;
    public static qa9 r2;
    public static volatile long s2;
    public static volatile long t2;
    public static volatile int u2;
    public static boolean v2;
    public static boolean w2;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public zz4 A0;
    public CustomMessageListener A1;
    public long B;
    public boolean B0;
    public CustomMessageListener B1;
    public long C;
    public AddExperiencedModel C0;
    public HttpMessageListener C1;
    public long D;
    public boolean D0;
    public wh5 D1;
    public long E;
    public boolean E0;
    public final CustomMessageListener E1;
    public long F;
    public boolean F0;
    public CustomMessageListener F1;
    public long G;
    public Date G0;
    public final CustomMessageListener G1;
    public long H;
    public int H0;
    public CustomMessageListener H1;
    public boolean I;
    public int I0;
    public CustomMessageListener I1;
    public int J;
    public int J0;
    public CustomMessageListener J1;
    public boolean K;
    public List<LiveHorseRaceData> K0;
    public final xa9 K1;
    public boolean L;
    public ValueAnimator L0;
    public final CustomMessageListener L1;
    public boolean M;
    public Runnable M0;
    public final CustomMessageListener M1;
    public wk5 N;
    public int N0;
    public final CustomMessageListener N1;
    public boolean O;
    public y47 O0;
    public final Runnable O1;
    @Nullable
    public dh5.b P;
    public fz6 P0;
    public final Runnable P1;
    public boolean Q;
    @Nullable
    public TiePlusEventController Q0;
    public final BdUniDispatchSchemeController.b Q1;
    public String R;
    public int R0;
    public final l57 R1;
    public ny.a S;
    public int S0;
    public final View.OnTouchListener S1;
    public ThreadCardViewHolder T;
    public g87 T0;
    public final View.OnClickListener T1;
    public FrsModelController U;
    public sy6 U0;
    public final View.OnClickListener U1;
    public d97 V;
    public boolean V0;
    public final RecyclerView.OnScrollListener V1;
    public FrsTabViewController W;
    public boolean W0;
    public final zv6 W1;
    public i57 X;
    public boolean X0;
    public final NoNetworkView.b X1;
    public w67 Y;
    public Object Y0;
    public Runnable Y1;
    public c57 Z;
    public PollingModel Z0;
    public final CustomMessageListener Z1;
    public String a;
    public rx6 a0;
    public bh5 a1;
    public qn a2;
    public lz6 b;
    public SparseArray<xv5> b0;
    public boolean b1;
    public px6 b2;
    public boolean c;
    public boolean c0;
    public boolean c1;
    public CustomMessageListener c2;
    public boolean d;
    public y07 d0;
    public boolean d1;
    public CustomMessageListener d2;
    public boolean e;
    public w87 e0;
    public int e1;
    public CustomMessageListener e2;
    public String f;
    public e57 f0;
    public int f1;
    public CustomMessageListener f2;
    public String g;
    public d57 g0;
    public MessageQueue.IdleHandler g1;
    public CustomMessageListener g2;
    public int h;
    public f97 h0;
    public final CustomMessageListener h1;
    public CustomMessageListener h2;
    public boolean i;
    public b57 i0;
    public CustomMessageListener i1;
    public CustomMessageListener i2;
    public boolean j;
    public x47 j0;
    public CustomMessageListener j1;
    public CustomMessageListener j2;
    public String k;
    public CustomMessageListener k1;
    public HttpMessageListener k2;
    public String l;
    public CustomMessageListener l1;
    public CustomMessageListener l2;
    public int m;
    public za m1;
    public na7 m2;
    public boolean n;
    public CustomMessageListener n1;
    public sb9 o;
    public final px6 o1;
    public boolean p;
    public FrsTabViewController.h p1;
    public boolean q;
    public int q1;
    public VoiceManager r;
    public jw6 r0;
    public CustomMessageListener r1;
    public View s;
    public y87 s0;
    public CustomMessageListener s1;
    public kw6 t;
    public o97 t0;
    public final CustomMessageListener t1;
    public OvalActionButton u;
    public a97 u0;
    public final CustomMessageListener u1;
    public FRSRefreshButton v;
    public boolean v0;
    public final CustomMessageListener v1;
    public LinearLayout w;
    public g37 w0;
    public final AntiHelper.k w1;
    public FrsViewData x;
    public kw5 x0;
    public CustomMessageListener x1;
    public String y;
    public i26 y0;
    public CustomMessageListener y1;
    public xf<TbImageView> z;
    public ez6 z0;
    public CustomMessageListener z1;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final boolean l3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i2)) == null) ? (i2 == 506 || i2 == 507) ? false : true : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class i0 implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ i0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$i0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0259a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0259a(a aVar, long j, int i, int i2, float f, int i3) {
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

            public a(i0 i0Var, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i0Var, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = i0Var;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.W.b(301);
                    long g = gg.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L);
                    int l = hi.l(TbadkCoreApplication.getInst());
                    int j = hi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    jg.a().postDelayed(new RunnableC0259a(this, g, l, j, f, i), 1000L);
                }
            }
        }

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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_KW) instanceof String) {
                this.a.f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_KW);
            }
            if ((hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID))) {
                jg.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements pw5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
        public class a implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) && zz4Var != null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) && zz4Var != null) {
                    zz4Var.dismiss();
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

        @Override // com.baidu.tieba.pw5.c
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
            if (this.a.W != null && this.a.W.B() != null && (this.a.W.B().b instanceof FrsNewAreaFragment)) {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.W.B().b;
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
                    if (this.a.A0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.A0 = new zz4(frsFragment.getActivity());
                    }
                    this.a.A0.setMessage(string);
                    this.a.A0.setPositiveButton(R.string.dialog_known, new a(this));
                    this.a.A0.setCanceledOnTouchOutside(false);
                    this.a.A0.create(this.a.getPageContext());
                    this.a.A0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.A0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.A0 = new zz4(frsFragment2.getActivity());
                    }
                    this.a.A0.setMessage(string);
                    this.a.A0.setPositiveButton(R.string.obfuscated_res_0x7f0f0a66, new b(this));
                    this.a.A0.setCanceledOnTouchOutside(false);
                    this.a.A0.create(this.a.getPageContext());
                    this.a.A0.show();
                } else {
                    Context context = this.a.getContext();
                    if (deleteThreadHttpResponseMessage.getRetType() == 1) {
                        i = R.color.nav_bar_tip_error;
                    } else {
                        i = R.color.cp_link_tip_a_alpha95;
                    }
                    this.a.t.V1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(context, i));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.v2(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.p3(deleteThreadHttpResponseMessage.getSuccessItems());
                vv6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (gn gnVar : this.a.x.getThreadList()) {
                    if (gnVar instanceof mz4) {
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
            hi.Q(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
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
                    hashMap.put("_forumId", this.a.a.x.getForum().getId());
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
                    forumBroadcastHelper.jumpFlutterEditGenear(this.a.x.getForum().getId(), this.a.x.getForum().getName(), "6");
                    forumBroadcastHelper.clipCopy(this.a.R);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                screenTopToast.m(this.a.getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(this.a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090bdc));
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class q1 implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
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

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == pw6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.b2();
                }
            } else if (gnVar != null && (gnVar instanceof mz4)) {
                ThreadData threadData = ((mz4) gnVar).t;
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
                    if (!StringUtils.isNull(a2) && hi.F()) {
                        gt4.q(this.a.getActivity(), a2);
                    }
                } else if (threadData.getCartoonThreadData() != null) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    cx4 cartoonThreadData = threadData.getCartoonThreadData();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                } else {
                    dd9 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null && !readThreadHistory.d(threadData.getId())) {
                        readThreadHistory.a(threadData.getId());
                    }
                    String ad_url = threadData.getAd_url();
                    if (ad_url != null && !ad_url.equals("")) {
                        new Thread(new a(this, ad_url)).start();
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
                        s87.c(threadData.getTaskInfoData());
                    } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                    }
                    t87.f(this.a, threadData, i, z);
                    FrsFragment frsFragment = this.a;
                    s87.d(frsFragment, frsFragment.x, threadData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements px6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.L0()) {
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

        @Override // com.baidu.tieba.px6
        public void a(int i, int i2, ay6 ay6Var, ArrayList<gn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ay6Var, arrayList}) == null) {
                jg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            i37 v1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                boolean z3 = false;
                if (i != 1) {
                    ef6.b().e(false);
                    this.a.k4(false);
                }
                this.a.u.setIconFade(0);
                if ((this.a.getActivity() instanceof FrsActivity) && (v1 = ((FrsActivity) this.a.getActivity()).v1()) != null) {
                    v1.I0(i);
                }
                this.a.q1 = i;
                this.a.R0 = i2;
                if (this.a.O0 != null) {
                    this.a.O0.d(this.a.R0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.R0);
                this.a.l5();
                c77 c77Var = e77.q0;
                c77Var.e = i;
                c77Var.h = i2;
                c77Var.f = -1;
                if (this.a.D0) {
                    vv6 f = vv6.f();
                    if (i == 1 && this.a.D0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    f.p(z2, true);
                    uv6 h = uv6.h();
                    if (i == 1 && this.a.D0) {
                        z3 = true;
                    }
                    h.p(z3, true);
                    return;
                }
                kw6 kw6Var = this.a.t;
                if (!z && this.a.l3(i)) {
                    z3 = true;
                }
                kw6Var.a2(z3);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !this.a.isResumed()) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.v != null && booleanValue && this.a.W.K() != 0 && !this.a.t.O0() && !fe5.h().k()) {
                this.a.v.f();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.W.k0(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            this.a.b5();
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                v87.b(this.a.x, this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.V.Y(num);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            this.a.W.b(49);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements tx6 {
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

        @Override // com.baidu.tieba.tx6
        public void a(boolean z, boolean z2, int i) {
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || this.a.t == null) {
                return;
            }
            int i2 = 8;
            int i3 = 0;
            if (i == 1) {
                this.a.t.E1(vv6.f().h());
                kw6 kw6Var = this.a.t;
                if (z) {
                    i2 = 0;
                }
                kw6Var.F1(i2);
            } else if (i == 2) {
                kw6 kw6Var2 = this.a.t;
                if (z) {
                    i2 = 0;
                }
                kw6Var2.B1(i2);
            }
            if (!z2) {
                this.a.D0 = z;
            }
            if (this.a.t.a0() != null && (i == 2 || (this.a.U != null && this.a.U.q0()))) {
                this.a.t.a0().notifyDataSetChanged();
            }
            if (this.a.P3() != null) {
                FrsTabViewController.i B = this.a.P3().B();
                if (B != null) {
                    Fragment fragment = B.b;
                    if ((fragment instanceof FrsCommonTabFragment) && i == 2) {
                        ((FrsCommonTabFragment) fragment).c2();
                    } else if ((B.b instanceof FrsNewAreaFragment) && (i == 2 || B.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) B.b;
                        frsNewAreaFragment.z2();
                        if (frsNewAreaFragment.k2() != null) {
                            h57 k2 = frsNewAreaFragment.k2();
                            k2.J(!z);
                            if (i == 1) {
                                k2.G(!z);
                            } else if (i == 2) {
                                k2.G(true);
                            }
                        }
                    } else {
                        Fragment fragment2 = B.b;
                        if (fragment2 instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment2).t2();
                        }
                    }
                }
                if (this.a.P3().M() != null) {
                    this.a.P3().M().setmDisallowSlip(z);
                    this.a.P3().h0(z);
                }
            }
            if (this.a.t.c0() != null) {
                kw6 kw6Var3 = this.a.t;
                if (this.a.j3() && !z) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                kw6Var3.a2(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                FrsActivity frsActivity = (FrsActivity) this.a.getActivity();
                frsActivity.F1(!z);
                i37 v1 = frsActivity.v1();
                if (v1 != null) {
                    if (z) {
                        i3 = 4;
                    }
                    v1.E0(i3);
                }
            }
            if (this.a.z0 != null) {
                this.a.z0.f(!z);
            }
            this.a.t.K1(!z);
            if (i == 1) {
                this.a.t.A1(!z);
            } else if (i == 2) {
                this.a.t.A1(true);
            }
        }

        @Override // com.baidu.tieba.tx6
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.a.getContext() == null) {
                return;
            }
            if (i == 1) {
                hi.P(this.a.getContext(), R.string.obfuscated_res_0x7f0f0794);
            } else if (i == 2 && this.a.t != null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0789));
                bdTopToast.i(this.a.t.r0());
            }
        }

        @Override // com.baidu.tieba.tx6
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || this.a.t == null) {
                return;
            }
            if (i2 == 1) {
                this.a.t.D1(i);
            } else if (i2 == 2) {
                this.a.t.C1(i);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || !valueAnimator.isRunning()) {
                return;
            }
            this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.a.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.t3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e1 implements Animator.AnimatorListener {
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
                if (this.b.K0 == null || this.b.J0 <= this.b.K0.size() - 1) {
                    this.b.X3();
                    return;
                }
                this.b.w.removeAllViews();
                this.b.w.setVisibility(8);
                this.b.J0 = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb9) && this.a.x != null) {
                this.a.x.updateLikeData((bb9) customResponsedMessage.getData());
                this.a.V.b0(this.a.x);
                this.a.W.d(this.a.x, this.a.U.m0());
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.w != null && this.a != null) {
                this.b.L0.start();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.x.getToLoadHorseData().intValue() == 1 && this.a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.a.l));
                this.a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getPageContext().getUniqueId()) && updateAttentionMessage.getData().i != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, this.a.w1) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Z0 != null) {
                this.a.Z0.y0(PollingModel.MEMBER_BROADCAST);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.G0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jx4) && this.a.isResumed()) {
                jx4 jx4Var = (jx4) customResponsedMessage.getData();
                if (this.a.P0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.P0 = new fz6(frsFragment.getPageContext());
                }
                if (this.a.x != null && this.a.x.getForum() != null && !TextUtils.isEmpty(this.a.x.getForum().getId())) {
                    this.a.P0.j(jx4Var.a, this.a.x.getForum().getId(), this.a.x.getForum().getName(), jx4Var.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            this.a.t.Y1((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements l57 {
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

        @Override // com.baidu.tieba.l57
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<gn> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) && this.a.Y != null && this.a.U != null && this.a.U.P0() && z && !z2 && !z3) {
                this.a.Y.a(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                this.a.v4();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.a0 != null && this.a.a0.e() != null) {
                    this.a.a0.e().c(motionEvent);
                }
                if (this.a.w0 != null) {
                    this.a.w0.b(view2, motionEvent);
                }
                if (this.a.V != null) {
                    this.a.V.X(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrsFragment f;

        public l0(FrsFragment frsFragment, long j, int i, int i2, float f, int i3) {
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                rw5 rw5Var = (rw5) customResponsedMessage.getData();
                int i = 0;
                if (this.a.x != null && this.a.x.getForum() != null && this.a.x.getForum().getDeletedReasonInfo() != null) {
                    int intValue = this.a.x.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
                    int intValue2 = this.a.x.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
                    if (this.a.x.forumRule != null) {
                        i = this.a.x.forumRule.has_forum_rule.intValue();
                    }
                    sw5 sw5Var = new sw5(intValue, intValue2, i);
                    sw5Var.i(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                    sw5Var.h(this.a.x.getForum().getImage_url());
                    sw5Var.j(this.a.x.getForum().getUser_level());
                    ow5.d(sw5Var.f(), this.a.getPageContext(), rw5Var, sw5Var, this.a.x.getUserData());
                    return;
                }
                ow5.d(0, this.a.getPageContext(), rw5Var, null, this.a.x.getUserData());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof NewsRemindMessage) || customResponsedMessage.getCmd() != 2001626) {
                return;
            }
            NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
            this.a.J = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            FrsFragment frsFragment = this.a;
            if (!newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            frsFragment.K = z;
            if (this.a.t != null) {
                this.a.t.h1(this.a.J, this.a.K);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ad9.o(this.a.f);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.v != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.W.B() != null && (this.a.W.B().b instanceof BaseFragment) && ((BaseFragment) this.a.W.B().b).isPrimary() && !this.a.t.O0()) {
                    this.a.w.setVisibility(0);
                    this.a.I = false;
                    return;
                }
                this.a.w.setVisibility(8);
                this.a.I = true;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && this.a.getContext() != null && this.a.t != null) {
                int i = 0;
                if (httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f078e));
                    bdTopToast.i(this.a.t.r0());
                    if (uv6.h().k(uv6.h().e())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (this.a.W != null && this.a.W.B() != null && (this.a.W.B().b instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.B().b;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.a2();
                        }
                        this.a.q3();
                        uv6.h().d();
                        for (gn gnVar : this.a.x.getThreadList()) {
                            if (gnVar instanceof mz4) {
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
                    uv6.h().n();
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(httpResponsedMessage.getErrorString());
                bdTopToast2.i(this.a.t.r0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.i4();
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // com.baidu.tieba.za
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
            if (this.a.K0 == null) {
                this.a.K0 = new ArrayList();
                this.a.J0 = 0;
                this.a.K0.addAll(arrayList);
                this.a.X3();
            } else if (this.a.w != null && this.a.w.getVisibility() == 8) {
                this.a.K0 = new ArrayList();
                this.a.K0.addAll(arrayList);
                this.a.J0 = 0;
                this.a.X3();
            } else if (this.a.J0 < this.a.K0.size()) {
                FrsFragment frsFragment = this.a;
                frsFragment.K0 = frsFragment.K0.subList(0, this.a.J0);
                this.a.K0.addAll(arrayList);
            } else {
                this.a.K0.addAll(arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends wh5<TopToastEvent> {
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
        @Override // com.baidu.tieba.ph5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                bdTopToast.h(topToastEvent.isSuccess());
                bdTopToast.g(topToastEvent.getContent());
                bdTopToast.i(this.c.t.r0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f0906e8);
                if (this.a.t != null && view2 == this.a.t.Y() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090d66 && hi.F()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t != null && this.a.t.J0()) {
                        this.a.t.Q1();
                    } else {
                        String c = this.a.x.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            gt4.q(this.a.getPageContext().getPageActivity(), c);
                        }
                    }
                }
                if (this.a.t != null && view2 == this.a.t.h0() && this.a.U != null && this.a.U.hasMore()) {
                    this.a.t.T1();
                    this.a.b();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.i0()) {
                    this.a.i4();
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    hi.P(this.a.getContext().getApplicationContext(), R.string.network_not_available);
                } else if (this.a.x != null && this.a.x.getForum() != null) {
                    if (this.a.t != null && (view2 == this.a.t.z0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.x != null && this.a.x.getForum() != null && !StringUtils.isNull(this.a.x.getForum().getId()) && !StringUtils.isNull(this.a.x.getForum().getName())) {
                            i67.e(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                            o87.d(this.a.getPageContext(), this.a.x, this.a.x.getForum().getId(), this.a.J, this.a.K, this.a.T1);
                        } else {
                            return;
                        }
                    }
                    if ((this.a.t != null && view2 == this.a.t.y0()) || logicField == LogicField.SEARCH_BTN) {
                        StatisticItem param = new StatisticItem("c12402").param("fid", this.a.x.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.x.getForum().getName());
                        i67.a(param);
                        TiebaStatic.log(param);
                        if (!StringUtils.isNull(this.a.x.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.x.getForum().getName(), this.a.x.getForum().getId())));
                        }
                    }
                    if (this.a.t != null && view2 == this.a.t.x0() && this.a.x != null && this.a.x.frsForumGroup != null && this.a.x.frsForumGroup.topbar_entrance != null && !TextUtils.isEmpty(this.a.x.frsForumGroup.topbar_entrance.jump_url)) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.x.frsForumGroup.topbar_entrance.jump_url});
                        e87.a(this.a.w());
                        FrsTopBarGroupEntranceGuideView w0 = this.a.t.w0();
                        c87.c();
                        if (w0 != null) {
                            w0.a();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Integer) || Integer.parseInt(data.toString()) != 1) {
                return;
            }
            this.a.t3();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.isResumed()) {
                return;
            }
            this.a.k5();
        }
    }

    /* loaded from: classes4.dex */
    public class p0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ FrsFragment c;

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
            this.c = frsFragment;
            this.a = 0;
            this.b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.c.V != null) {
                    this.c.V.w0(i);
                    if (i == 1) {
                        this.c.V.I();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.N == null && !frsFragment.c4()) {
                    this.c.N = new wk5();
                    this.c.N.a(1000);
                }
                if (i == 0) {
                    wk5 wk5Var = this.c.N;
                    if (wk5Var != null) {
                        wk5Var.e();
                    }
                    ef6.b().e(true);
                    this.c.k4(true);
                    this.c.t.T0(this.a, this.b);
                    if (this.c.Y0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.Y0);
                        this.c.Y0 = null;
                    }
                } else {
                    if (this.c.Y0 == null) {
                        this.c.Y0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    wk5 wk5Var2 = this.c.N;
                    if (wk5Var2 != null) {
                        wk5Var2.d();
                    }
                }
                if (this.c.u0 != null) {
                    this.c.u0.i(recyclerView, i);
                }
                if (i == 0) {
                    s87.b(this.c.t, this.c.x, this.c.w(), false, null);
                }
                if (this.c.W != null && i == 1) {
                    this.c.W.O();
                }
                if (this.c.T == null) {
                    if (this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.T = (ThreadCardViewHolder) frsFragment2.t.o0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.o0() != null && !this.c.t.e0() && this.c.t.o0().j() != null && (this.c.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.T = (ThreadCardViewHolder) frsFragment3.t.o0().j().getTag();
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
                this.c.I0 += i2;
                if (i2 < 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    if (this.c.I0 >= this.c.H0 * 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.valueOf(z)));
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
                if (this.c.u0 != null) {
                    this.c.u0.h(recyclerView, this.a, this.b);
                }
                if (this.c.x != null && this.c.t != null && this.c.t.a0() != null) {
                    this.c.t.p1(this.a, this.b);
                    if (this.c.T != null && this.c.T.a() != null) {
                        this.c.T.a().p(this.c.S);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements px6 {
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

        @Override // com.baidu.tieba.px6
        public void a(int i, int i2, ay6 ay6Var, ArrayList<gn> arrayList) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ay6Var, arrayList}) == null) {
                this.a.d5();
                if (this.a.d0 != null) {
                    this.a.V.l0(this.a.d0.e(i));
                }
                ia9 ia9Var = new ia9();
                if (ay6Var != null) {
                    if (ay6Var.e == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ia9Var.b = z;
                    ia9Var.c = ay6Var.e;
                    ia9Var.d = ay6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.B0();
                        } else if (ay6Var.g) {
                            if (ListUtils.getCount(this.a.x.getThreadList()) > 3) {
                                this.a.t.T1();
                            } else {
                                this.a.t.P1();
                            }
                        } else if (ay6Var.i) {
                            this.a.t.W1();
                        } else {
                            this.a.t.B0();
                        }
                    }
                } else {
                    ay6Var = new ay6();
                    ay6Var.c = 1;
                    ay6Var.g = false;
                    ay6Var.i = false;
                }
                if (i == 1) {
                    this.a.O = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.K1.d(frsFragment.U.getType(), false, ia9Var);
                } else {
                    this.a.c5(ia9Var);
                    if (this.a.U.z0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.x = frsFragment2.U.z0();
                    }
                    this.a.s4();
                }
                if (this.a.b2 != null) {
                    this.a.b2.a(i, i2, ay6Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.t.o1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements zv6 {
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

        @Override // com.baidu.tieba.zv6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i == this.a.t.a0().c()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        return;
                    }
                    TiebaStatic.log("forum_fortune_click");
                    t87.e(this.a.getPageContext(), this.a.x);
                } else if (i == this.a.t.a0().j()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (this.a.x != null && this.a.x.getForum() != null) {
                        ForumData forum = this.a.x.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), gg.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (i == this.a.t.a0().i() && this.a.x != null && this.a.x.getUserData() != null && this.a.x.getUserData().isBawu()) {
                    String bawuCenterUrl = this.a.x.getBawuCenterUrl();
                    if (!gi.isEmpty(bawuCenterUrl) && this.a.x.getForum() != null) {
                        gt4.s(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.x.getForum().getId()).param("uid", this.a.x.getUserData().getUserId()));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (TbadkApplication.getInst().getCurrentActivity() != null && !gi.isEmpty(str) && str.equals(this.a.l)) {
                    o87.e(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.x);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.W.K() != 0 && this.a.W.B() != null && (this.a.W.B().b instanceof BaseFragment) && ((BaseFragment) this.a.W.B().b).isPrimary() && !this.a.t.O0() && !fe5.h().k()) {
                    this.a.v.f();
                } else if (this.a.W.K() != 0) {
                    this.a.v.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.t != null) {
                this.a.t.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.U.x0() == 1 && z && !this.a.t.e0()) {
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

    /* loaded from: classes4.dex */
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
                this.a.Z4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            FrsTabViewController.i B;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.W != null && (B = this.a.W.B()) != null && (fragment = B.b) != null && (fragment instanceof mx6)) {
                ((mx6) fragment).y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(FrsFragment frsFragment, int i) {
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
                q87.d(this.a.getActivity(), this.a.x);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                z77.a(customResponsedMessage, this.a.t, this.a.x);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
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
                s87.b(this.a.t, this.a.x, this.a.w(), true, (ThreadData) data);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.W != null) {
                FrsTabViewController.i B = this.a.W.B();
                if (B != null && (fragment = B.b) != null && (fragment instanceof mx6)) {
                    ((mx6) fragment).A1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    jg.a().postDelayed(this.a.Y1, 500L);
                    return;
                }
                this.a.v1().b2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements xa9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ FrsFragment b;

        public w(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.xa9
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

        @Override // com.baidu.tieba.xa9
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.v4();
            }
        }

        @Override // com.baidu.tieba.xa9
        public void c(qa9 qa9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qa9Var) == null) {
                if ((qa9Var != null && ("normal_page".equals(this.b.U.v0()) || "frs_page".equals(this.b.U.v0()) || "book_page".equals(this.b.U.v0()))) || "brand_page".equals(this.b.U.v0())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, qa9Var));
                    this.b.w4(qa9Var);
                    FrsFragment.r2 = qa9Var;
                }
            }
        }

        @Override // com.baidu.tieba.xa9
        public void d(int i, boolean z, ia9 ia9Var) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), ia9Var}) == null) {
                if (this.b.c0) {
                    this.b.c0 = false;
                    s87.b(this.b.t, this.b.x, this.b.w(), false, null);
                }
                this.b.d5();
                this.b.M = true;
                if (ia9Var != null && ia9Var.b) {
                    this.b.t.a0().m(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.s2 = 0L;
                    FrsFragment.t2 = 0L;
                    FrsFragment.u2 = 0;
                } else {
                    FrsFragment.u2 = 1;
                }
                if (!this.b.U.P0() && (i == 3 || i == 6)) {
                    this.b.g0.l();
                }
                this.b.B = System.currentTimeMillis();
                if (this.b.U.z0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.x = frsFragment.U.z0();
                }
                q87.h(this.b.getContext(), 1, this.b.x);
                q87.d(this.b.getActivity(), this.b.x);
                if (i == 7) {
                    this.b.u4(this.b.x.getFrsDefaultTabId());
                    return;
                }
                if (this.b.x.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.I4(frsFragment2.x.getPage().b());
                }
                if (i != 4) {
                    this.b.f5();
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 || i == 6) {
                                if (this.b.x != null) {
                                    this.b.x.clearPostThreadCount();
                                }
                                y87 y87Var = this.b.s0;
                                if (y87Var != null) {
                                    y87Var.d();
                                }
                            }
                        } else {
                            this.b.t.Q0();
                        }
                    } else {
                        this.b.t.Q0();
                    }
                    q87.i(this.b.x, this.b.t);
                    if (ia9Var != null && ia9Var.c != 0) {
                        if (this.b.x == null || ListUtils.isEmpty(this.b.x.getThreadList())) {
                            this.b.c5(ia9Var);
                        } else if (ia9Var.a) {
                            FrsFragment frsFragment3 = this.b;
                            frsFragment3.showToast(frsFragment3.getPageContext().getResources().getString(R.string.net_error_text, ia9Var.d, Integer.valueOf(ia9Var.c)));
                        }
                    } else if (this.b.x == null) {
                        return;
                    } else {
                        if (this.b.n() != null) {
                            FrsFragment frsFragment4 = this.b;
                            if (!frsFragment4.X4(frsFragment4.x, this.b.n())) {
                                UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.b.getPageContext());
                                upgradePopWindowMessage.setFromPage("frs");
                                MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                            }
                        }
                        FrsFragment frsFragment5 = this.b;
                        if (i == 5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        frsFragment5.q4(false, z2);
                        if (this.b.U != null) {
                            if (this.b.x.getActivityHeadData() != null && this.b.x.getActivityHeadData().b() != null && this.b.x.getActivityHeadData().b().size() > 0) {
                                b77.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.U.w0(), 1);
                            }
                            if (this.b.x.getThreadList() != null && this.b.x.getThreadList().size() > 0) {
                                Iterator<gn> it = this.b.x.getThreadList().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    gn next = it.next();
                                    if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                        b77.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.U.w0(), 2);
                                        break;
                                    }
                                }
                            }
                            b77.i(this.b.getUniqueId(), this.b.x.getThreadList(), this.b.x.getForum(), this.b.U.w0());
                        }
                        this.b.t.c1(i);
                        FrsFragment.s2 = (System.nanoTime() - this.a) / 1000000;
                        if (ia9Var != null) {
                            FrsFragment.t2 = ia9Var.e;
                        }
                    }
                    this.b.o3();
                    if (this.b.x.getAccessFlag() == 1) {
                        TiebaStatic.log(new StatisticItem("c11384"));
                    }
                    if (this.b.p && this.b.W.b(49)) {
                        this.b.p = false;
                    }
                    System.gc();
                    return;
                }
                if (!this.b.U.P0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.U.x0() == 1 && (this.b.x.adShowSelect == 1 || this.b.x.adShowSelect == 3)) {
                    this.b.x.addRecommendAppToThreadList(this.b);
                }
                ArrayList<gn> c = this.b.g0.c(false, false, this.b.x.getThreadList(), this.b.o, false, this.b.x.adShowSelect, this.b.x.adMixFloor);
                if (c != null) {
                    this.b.x.setThreadList(c);
                    this.b.x.checkLiveStageInThreadList();
                }
                if (this.b.U != null) {
                    d77.m(this.b.x, this.b.U.m0(), 2, this.b.getContext());
                }
                FrsFragment frsFragment6 = this.b;
                y77.a(frsFragment6, frsFragment6.x.getForum(), this.b.x.getThreadList(), false, this.b.L3());
                this.b.t.L1(c, this.b.x);
                this.b.f5();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.v0 = true;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.M && BdNetTypeUtil.isNetWorkAvailable() && !this.a.t.N0()) {
                this.a.t.e1();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (this.a.T == null && this.a.t.o0() != null && !this.a.t.e0() && this.a.t.o0().j() != null && (this.a.t.o0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.T = (ThreadCardViewHolder) frsFragment.t.o0().j().getTag();
                    }
                    if (this.a.T != null && this.a.T.a() != null) {
                        this.a.T.a().p(new ny.a(3));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.t.Z1();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.t != null) {
                this.a.t.b1();
            }
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
        n2 = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
        o2 = TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=%1$s&nomenu=1";
        p2 = false;
        q2 = null;
        s2 = 0L;
        t2 = 0L;
        u2 = 0;
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.Z0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.Z0 = pollingModel;
                pollingModel.I0(v05.f);
            }
            this.Z0.y0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            jg.a().postDelayed(this.O1, y25.a().b());
            jg.a().postDelayed(this.P1, 500L);
        }
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (T3() != 1 && !this.g0.b(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.B0();
                } else {
                    this.t.W1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.T1();
            } else {
                this.t.P1();
            }
        }
    }

    public final boolean f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (W0() == null) {
                return false;
            }
            FrsViewData W0 = W0();
            kx4 kx4Var = null;
            if (W0.getStar() != null && !StringUtils.isNull(W0.getStar().a())) {
                kx4Var = new kx4();
            } else if (W0.getActivityHeadData() != null && ListUtils.getCount(W0.getActivityHeadData().b()) >= 1) {
                kx4Var = W0.getActivityHeadData().b().get(0);
            }
            if (kx4Var == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (T3() == 0 && ListUtils.isEmpty(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.B0();
                } else {
                    this.t.W1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.T1();
            } else {
                this.t.P1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.i B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (P3() != null && (B = P3().B()) != null) {
                Fragment fragment = B.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        int i2 = -1;
                        FrsViewData frsViewData = this.x;
                        if (frsViewData != null) {
                            i2 = frsViewData.getSortType();
                        }
                        tbPageTag.sortType = r87.g(i2);
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

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            if (!m3() && this.x.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                J4(this.x.getPrivateForumTotalInfo().a().private_forum_audit_status, this.x.getPrivateForumTotalInfo().b(), false);
            } else {
                J4(null, null, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            super.onPause();
            this.X.f(false);
            this.O = false;
            this.t.Y0();
            d97 d97Var = this.V;
            if (d97Var != null) {
                d97Var.U();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.t.R0(true);
            w87 w87Var = this.e0;
            if (w87Var != null) {
                w87Var.j();
            }
            zp4.w().E();
            bh5 bh5Var = this.a1;
            if (bh5Var != null) {
                bh5Var.onPause();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.t.g0().stopScroll();
            if (this.t.k1()) {
                return;
            }
            if (!hi.F()) {
                this.t.B0();
            } else if (this.U.x0() == 1) {
                e5();
                b();
            } else if (this.U.hasMore()) {
                b();
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
        this.A = -1L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = false;
        this.M = false;
        this.N = null;
        this.O = true;
        this.Q = true;
        this.S = new ny.a(2);
        this.b0 = new SparseArray<>();
        this.c0 = true;
        this.B0 = false;
        this.D0 = false;
        this.F0 = false;
        this.G0 = null;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.N0 = -1;
        this.S0 = -1;
        this.b1 = false;
        this.c1 = false;
        this.d1 = false;
        this.e1 = 0;
        this.g1 = new k(this);
        this.h1 = new v(this, 2016495);
        this.i1 = new g0(this, 2921005);
        this.j1 = new r0(this, 2921401);
        this.k1 = new c1(this, 2921473);
        this.l1 = new m1(this, 2921467);
        this.m1 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.n1 = new o1(this, 2001624);
        this.o1 = new p1(this);
        this.p1 = new a(this);
        this.r1 = new b(this, 2001606);
        this.s1 = new c(this, 2001607);
        this.t1 = new d(this, 2003019);
        this.u1 = new e(this, 2921470);
        this.v1 = new f(this, 2001352);
        this.w1 = new g(this);
        this.x1 = new h(this, 2001115);
        this.y1 = new i(this, 2921346);
        this.z1 = new j(this, 2001374);
        this.A1 = new l(this, 2001378);
        this.B1 = new m(this, 2001626);
        this.C1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.D1 = new o(this);
        this.E1 = new p(this, 2921391);
        this.F1 = new q(this, 2003020);
        this.G1 = new r(this, 2921463);
        this.H1 = new s(this, 2921587);
        this.I1 = new t(this, 2921588);
        this.J1 = new u(this, 2003023);
        this.K1 = new w(this);
        this.L1 = new a0(this, 2016485);
        this.M1 = new b0(this, 2003025);
        this.N1 = new c0(this, 2001194);
        this.O1 = new f0(this);
        this.P1 = new h0(this);
        this.Q1 = new i0(this);
        this.R1 = new j0(this);
        this.S1 = new k0(this);
        this.T1 = new n0(this);
        this.U1 = new o0(this);
        this.V1 = new p0(this);
        this.W1 = new q0(this);
        this.X1 = new s0(this);
        this.Y1 = new t0(this);
        this.Z1 = new u0(this, 0);
        this.a2 = new q1(this, null);
        this.b2 = new w0(this);
        this.c2 = new x0(this, 2921033);
        this.d2 = new y0(this, 2921381);
        this.e2 = new z0(this, 2921414);
        this.f2 = new a1(this, 2921437);
        this.g2 = new g1(this, 2921462);
        this.h2 = new h1(this, 2001223);
        this.i2 = new i1(this, 2921469);
        this.j2 = new j1(this, 2921475);
        this.k2 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.l2 = new l1(this, 2921515);
    }

    public void A4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.e = z2;
        }
    }

    public void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            w2 = z2;
        }
    }

    public void C4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f1 = i2;
            if (i2 == 13) {
                this.t.q1("frs_hot_tab");
            }
            if (i2 == 14) {
                this.t.q1("frs_new_tab");
            }
        }
    }

    public void D4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.h = i2;
        }
    }

    public void E4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f = str;
        }
    }

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.V0 = z2;
        }
    }

    public void G4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.W0 = z2;
        }
    }

    public void H4(sy6 sy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sy6Var) == null) {
            this.U0 = sy6Var;
        }
    }

    public void I4(int i2) {
        d57 d57Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048595, this, i2) != null) || (d57Var = this.g0) == null) {
            return;
        }
        d57Var.n(i2);
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.b1 = z2;
            this.c1 = z2;
        }
    }

    public void L4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            this.d1 = z2;
        }
    }

    public void M4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            this.Q = z2;
        }
    }

    public void N4(boolean z2) {
        f97 f97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z2) == null) && (f97Var = this.h0) != null) {
            f97Var.Y();
        }
    }

    public void P4(boolean z2) {
        rx6 rx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) && (rx6Var = this.a0) != null) {
            rx6Var.i(z2);
        }
    }

    @NonNull
    public void Q4(dh5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bVar) == null) {
            this.P = bVar;
        }
    }

    public void R4(int i2) {
        d57 d57Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048616, this, i2) != null) || (d57Var = this.g0) == null) {
            return;
        }
        d57Var.o(i2);
    }

    @Override // com.baidu.tieba.yv5
    public void S(wv5 wv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, wv5Var) == null) {
            this.r0.a(wv5Var);
        }
    }

    public void S4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048619, this, z2) != null) || this.m2 != null) {
            return;
        }
        na7 a2 = na7.a(z2);
        this.m2 = a2;
        d57 d57Var = this.g0;
        if (d57Var != null) {
            d57Var.m(a2);
        }
    }

    public void U4(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public void V4(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, linearLayout) != null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public void W4(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, fRSRefreshButton) != null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    @Override // com.baidu.tieba.yv5
    public xv5 Z0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            return this.b0.get(i2);
        }
        return (xv5) invokeI.objValue;
    }

    public final void h3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            N4("frs_page".equals(str));
            y07 y07Var = this.d0;
            if (y07Var != null) {
                y07Var.c(this.V, this.t, this.x);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            this.t.s1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).G1(view2, false);
            this.t.j0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.s1(0);
            this.t.j0().f(false);
        }
    }

    public void j4(Object obj) {
        c57 c57Var;
        z8 z8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048670, this, obj) == null) && (c57Var = this.Z) != null && (z8Var = c57Var.j) != null) {
            z8Var.c(obj);
        }
    }

    public void j5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i(this.t.r0());
        }
    }

    public void k4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z2) == null) {
            da9.g().h(getUniqueId(), z2);
        }
    }

    public void n5(Object obj) {
        c57 c57Var;
        z8 z8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, obj) == null) && (c57Var = this.Z) != null && (z8Var = c57Var.i) != null) {
            z8Var.c(obj);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            e5();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public void r4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i2) == null) {
            this.M = false;
            l5();
            kw6 kw6Var = this.t;
            if (kw6Var != null && kw6Var.o0() != null) {
                this.t.o0().y();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.c1(i2, true);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, str) == null) {
            this.g = str;
        }
    }

    public void y4(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) && (frsTabViewController = this.W) != null) {
            frsTabViewController.u = z2;
        }
    }

    @Override // com.baidu.tieba.yv5
    public void z0(int i2, xv5 xv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048743, this, i2, xv5Var) == null) {
            this.b0.put(i2, xv5Var);
        }
    }

    public void a5(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, str, str2, str3) == null) {
            g87 g87Var = new g87(str, str2);
            this.T0 = g87Var;
            g87Var.l(getFragmentActivity(), str3, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048689, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            b57 b57Var = this.i0;
            if (b57Var != null) {
                b57Var.n(i2, i3, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048701, this, i2, strArr, iArr) == null) {
            t87.i(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048724, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.s1(8);
        }
    }

    public int A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.S0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.S0;
        }
        return invokeV.intValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.h == 0) {
                this.t.M1(this.f);
            } else {
                this.t.M1("");
                this.h = 1;
            }
            this.t.I1(this.a2);
            this.t.N(this.V1);
            this.t.J1(this.X1);
            this.t.a0().l(this.W1);
        }
    }

    public void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            hideLoadingView(this.t.r0());
            this.t.d2();
            if (this.t.q0() instanceof i77) {
                ((i77) this.t.q0()).d();
            }
        }
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.x.getPrivateForumTotalInfo().a() == null || this.x.getUserData().getIs_manager() != 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && c4()) {
            showLoadingView(this.t.r0(), true);
            this.t.H1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.c1(3, true);
            I3().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048698, this) != null) || !hi.F()) {
            return;
        }
        hideNetRefreshView(this.t.b0().m());
        showLoadingView(this.t.r0(), true);
        this.t.C0(false);
        this.U.c1(3, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                d97 d97Var = this.V;
                if (d97Var != null) {
                    d97Var.V(isPrimary());
                }
                kw6 kw6Var = this.t;
                if (kw6Var != null) {
                    kw6Var.Z0(isPrimary());
                    this.t.R0(!isPrimary());
                }
            }
        }
    }

    @Override // com.baidu.tieba.kx6
    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isAdded() && this.c0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.r0(), true);
        }
    }

    public int B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return t87.c(this.x, this.t);
        }
        return invokeV.intValue;
    }

    public e57 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f0;
        }
        return (e57) invokeV.objValue;
    }

    public w67 D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.Y;
        }
        return (w67) invokeV.objValue;
    }

    public boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b1;
        }
        return invokeV.booleanValue;
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d1;
        }
        return invokeV.booleanValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.t.e0();
        }
        return invokeV.booleanValue;
    }

    public boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.e
    public xf<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.d(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (xf) invokeV.objValue;
    }

    public BdTypeRecyclerView I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            kw6 kw6Var = this.t;
            if (kw6Var == null) {
                return null;
            }
            return kw6Var.g0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public rx6 J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a0;
        }
        return (rx6) invokeV.objValue;
    }

    public dh5.b K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.P;
        }
        return (dh5.b) invokeV.objValue;
    }

    public int L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            d57 d57Var = this.g0;
            if (d57Var == null) {
                return 1;
            }
            return d57Var.g();
        }
        return invokeV.intValue;
    }

    public View N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c19
    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final AbsDataRecorder.Scene O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int i2 = this.f1;
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

    @Override // com.baidu.tieba.kx6
    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && isAdded() && this.c0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.r0());
        }
    }

    public FrsTabViewController P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.W;
        }
        return (FrsTabViewController) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m57
    public FrsModelController Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.U;
        }
        return (FrsModelController) invokeV.objValue;
    }

    public String R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public OvalActionButton S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.u;
        }
        return (OvalActionButton) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nx6
    public NavigationBar T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            kw6 kw6Var = this.t;
            if (kw6Var == null) {
                return null;
            }
            return kw6Var.k0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public int T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            d57 d57Var = this.g0;
            if (d57Var == null) {
                return -1;
            }
            return d57Var.h();
        }
        return invokeV.intValue;
    }

    public final void T4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || (frsViewData = this.x) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.a0().setFromCDN(true);
        } else {
            this.t.a0().setFromCDN(false);
        }
    }

    public void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            hi.z(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    public void V3() {
        d97 d97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (d97Var = this.V) != null) {
            d97Var.J();
        }
    }

    @Override // com.baidu.tieba.a57
    public FrsViewData W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.x;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public void W3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.b();
        }
    }

    @Override // com.baidu.tieba.kx6
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void Z4() {
        kw6 kw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (kw6Var = this.t) != null) {
            kw6Var.O1();
        }
    }

    public boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m57
    public void b() {
        d57 d57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (d57Var = this.g0) != null) {
            d57Var.i(this.f, this.l, this.x);
        }
    }

    public boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return w2;
        }
        return invokeV.booleanValue;
    }

    public boolean c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.V0;
        }
        return invokeV.booleanValue;
    }

    public boolean e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                h3(frsModelController.v0());
            } else {
                h3("normal_page");
            }
        }
    }

    public boolean g4() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a57
    public /* bridge */ /* synthetic */ a9 getPageContext() {
        return super.getPageContext();
    }

    public boolean h4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (W0() == null) {
                return false;
            }
            FrsViewData W0 = W0();
            if (ListUtils.isEmpty(W0.getShowTopThreadList()) && W0.getBusinessPromot() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void i5() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.f();
        }
    }

    @Override // com.baidu.tieba.m57
    public d57 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.g0;
        }
        return (d57) invokeV.objValue;
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return k3(this.q1);
        }
        return invokeV.booleanValue;
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048674, this) == null) && !gi.isEmpty(this.l)) {
            zp4.w().O(yp4.a0, gg.g(this.l, 0L));
        }
    }

    public boolean l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (f4() && !h4()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && (voiceManager = this.r) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.c19
    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            d57 d57Var = this.g0;
            if (d57Var == null) {
                return 1;
            }
            return d57Var.g();
        }
        return invokeV.intValue;
    }

    public void m5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048681, this) != null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.baidu.tieba.c19
    public TbPageContext<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void n3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            if (getActivity() == null) {
                intent = null;
            } else {
                intent = getActivity().getIntent();
            }
            t87.a(getPageContext(), intent, this.g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public kn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return I3().getPreLoadHandle();
        }
        return (kn) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            super.onStart();
            VoiceManager w02 = w0();
            this.r = w02;
            if (w02 != null) {
                w02.onStart(getPageContext());
            }
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            if (this.h == 1) {
                mg.a().b(new m0(this));
            }
            this.h = 0;
        }
    }

    @Override // com.baidu.tieba.kx6
    public void q() {
        kw6 kw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && (kw6Var = this.t) != null) {
            kw6Var.g0().scrollToPosition(0);
            this.t.b2();
        }
    }

    @Override // com.baidu.tieba.c19
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            Q0().o1();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            hx5.c().f("page_frs");
            r4(3);
        }
    }

    @Override // com.baidu.tieba.m57
    public d97 s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.V;
        }
        return (d97) invokeV.objValue;
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            this.t.b2();
        }
    }

    public bh5 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.a1;
        }
        return (bh5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a57, com.baidu.tieba.qx6
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m57
    public kw6 v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.t;
        }
        return (kw6) invokeV.objValue;
    }

    public y07 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.d0;
        }
        return (y07) invokeV.objValue;
    }

    public void v4() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && (frsModelController = this.U) != null && frsModelController.x0() == 1) {
            this.V.g0(this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return kq5.a(2);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qx6
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            if (this.j0 == null) {
                this.j0 = new x47(this, gg.e(this.l, 0));
            }
            this.j0.w();
        }
    }

    public String y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public qn z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.a2;
        }
        return (qn) invokeV.objValue;
    }

    public void z4() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.i B;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048745, this) == null) && (frsTabViewController = this.W) != null && (B = frsTabViewController.B()) != null && (fragment = B.b) != null && (fragment instanceof mx6)) {
            ((mx6) fragment).A1();
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void J4(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048597, this, num, num2, z2) != null) || this.t.p0() == null) {
            return;
        }
        TextView p02 = this.t.p0();
        if (z2) {
            p02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            p02.setText(getString(R.string.obfuscated_res_0x7f0f0289));
            p02.setVisibility(0);
            str = String.format(o2, this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            p02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f03e6), num2));
            p02.setVisibility(0);
            str = String.format(n2, this.l, this.f);
            i2 = 1;
        } else {
            p02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        p02.setOnClickListener(new x(this, i2, str));
    }

    public void O4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || this.x == null) {
            return;
        }
        c77 c77Var = new c77();
        if (this.x.needLog == 1) {
            c77Var.a = true;
        } else {
            c77Var.a = false;
        }
        if (this.x.getForum() != null) {
            c77Var.c = this.x.getForum().getId();
            c77Var.d = this.x.getForum().getName();
        }
        if (Q0() != null) {
            c77Var.b = Q0().m0();
        }
        c77 c77Var2 = e77.q0;
        if (c77Var2 != null) {
            c77Var.e = c77Var2.e;
            c77Var.f = c77Var2.f;
        }
        y47 y47Var = new y47(c77Var, getTbPageTag(), getUniqueId());
        this.O0 = y47Var;
        y47Var.d(this.R0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.O0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.O0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.O0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.O0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            super.onResume();
            int i2 = this.e1;
            if (i2 <= 1) {
                this.e1 = i2 + 1;
            }
            kw6 kw6Var = this.t;
            if (kw6Var != null) {
                kw6Var.Q0();
                this.t.a1();
            }
            d97 d97Var = this.V;
            if (d97Var != null) {
                d97Var.W();
            }
            if (this.e1 > 1 && F3()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                L4(false);
            }
            bh5 bh5Var = this.a1;
            if (bh5Var != null) {
                bh5Var.onResume();
            }
            this.X.f(true);
            this.O = true;
            if (p2) {
                p2 = false;
                kw6 kw6Var2 = this.t;
                if (kw6Var2 != null) {
                    kw6Var2.b2();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            kw6 kw6Var3 = this.t;
            if (kw6Var3 != null) {
                kw6Var3.R0(false);
            }
            if (this.v0) {
                r4(6);
                this.v0 = false;
            }
            if (this.G0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    m85.c().h(true, this.G0.getHours(), this.G0.getMinutes());
                    if (this.t != null) {
                        m85.c().j(n().getPageActivity(), this.t.r0());
                    }
                }
                this.G0 = null;
            }
            k5();
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            l5();
            try {
                if (this.x == null) {
                    return;
                }
                this.t.S1();
                this.t.a2(j3());
                if (this.x.getForum() != null) {
                    this.f = this.x.getForum().getName();
                    this.l = this.x.getForum().getId();
                }
                if (this.x.getPage() != null) {
                    I4(this.x.getPage().b());
                }
                this.t.M1(this.f);
                this.t.r1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.x.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.x.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.x.getUserData().getBimg_end_time());
                p4();
                T4();
                ArrayList<gn> threadList = this.x.getThreadList();
                if (threadList != null) {
                    this.t.L1(threadList, this.x);
                    z77.b(this.t);
                    this.V.v0(m1());
                    this.x.setFrsFragmentTag(getUniqueId());
                    this.V.b0(this.x);
                    this.W.d(this.x, this.U.m0());
                    this.t.m1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final FrsTabInfoData Q3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.U == null || (frsViewData = this.x) == null || this.W == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.x.getEntelechyTabInfo().a)) {
                return null;
            }
            int F = this.W.F();
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

    public final void b5() {
        FrsViewData frsViewData;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && getActivity() != null && getActivity().getIntent() != null && (frsViewData = this.x) != null && frsViewData.getForum() != null && !TextUtils.isEmpty(w())) {
            if (getActivity().getIntent().getBooleanExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST, false) && b4()) {
                if (this.x.getForum().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.x.getUserData() != null && (this.x.getUserData().getIs_manager() == 1 || this.x.getUserData().getIs_bawu() == 1)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.a1 != null) {
                    getActivity().getIntent().removeExtra(FrsActivityConfig.IS_SHOW_IM_GROUP_LIST);
                    dh5.b bVar = this.P;
                    if (bVar != null) {
                        bVar.l1(false);
                    }
                    this.a1.a(getPageContext(), null, gg.g(w(), 0L), v(), getActivity().getIntent().getLongExtra(FrsActivityConfig.LOCATE_ROOM_ID, -1L), z2, z3);
                    return;
                }
                return;
            }
            q87.d(getActivity(), this.x);
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048712, this) == null) && !ListUtils.isEmpty(uv6.h().i()) && this.t.g0() != null && this.t.g0().getData() != null) {
            ArrayList<gn> threadList = this.x.getThreadList();
            if (ListUtils.isEmpty(threadList)) {
                return;
            }
            Iterator<gn> it = threadList.iterator();
            List<gn> data = this.t.g0().getData();
            int count = ListUtils.getCount(uv6.h().i());
            int i2 = 0;
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof mz4) {
                    ThreadData threadData = ((mz4) next).t;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= count) {
                            break;
                        } else if (StringHelper.equals(uv6.h().i().get(i3).getId(), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.g0.j(next);
                            this.t.g0().getAdapter().notifyItemRemoved(i2);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2++;
            }
        }
    }

    public boolean t4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            d97 d97Var = this.V;
            if (d97Var != null && (frsModelController = this.U) != null) {
                d97Var.y0(frsModelController.v0(), this.x);
            }
            boolean z2 = false;
            FrsViewData frsViewData2 = this.x;
            if (frsViewData2 != null) {
                z2 = frsViewData2.hasTab();
            }
            g3();
            kw6 kw6Var = this.t;
            if (kw6Var != null) {
                kw6Var.F0();
                this.t.G0();
                FrsViewData frsViewData3 = this.x;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.W0 = i87.j(this.x.getBusinessPromot(), this.x.getForum().getId());
                }
                if (!this.W0 && (frsViewData = this.x) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.E0(this.x.getActivityHeadData().a());
                    if (this.x.getActivityHeadData().a() != null && !this.V0 && !this.W0 && !this.X0 && !E3()) {
                        Z4();
                    }
                } else {
                    this.t.E0(null);
                }
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public final void X3() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && isResumed() && (list = this.K0) != null && list.size() >= 1 && this.J0 <= this.K0.size() - 1) {
            LiveHorseRaceData liveHorseRaceData = this.K0.get(this.J0);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.J0++;
                X3();
            }
            if (this.w != null) {
                FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    if (liveHorseRaceData.getUser_nickname().length() > 4) {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0ad6), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                    } else {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0ad6), liveHorseRaceData.getUser_nickname());
                    }
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0ad6), getResources().getString(R.string.obfuscated_res_0x7f0f0775));
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.L0 = ofFloat;
                ofFloat.setDuration(600L);
                this.L0.addUpdateListener(new d1(this, frsRedpackRunView));
                this.L0.addListener(new e1(this, frsRedpackRunView));
                this.M0 = new f1(this, frsRedpackRunView);
                jg.a().postDelayed(this.M0, 5000L);
                if (this.w.getChildCount() == 0) {
                    this.J0++;
                    this.w.addView(frsRedpackRunView);
                    FrsViewData frsViewData = this.x;
                    String str = "";
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        str = this.x.getForum().getName();
                    }
                    TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.l).param("fname", str));
                }
                LinearLayout linearLayout = this.w;
                if (linearLayout != null && linearLayout.getVisibility() == 8 && ((BaseFragment) this.W.B().b).isPrimary() && !this.t.O0() && !this.I) {
                    this.w.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            da9.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.A1);
            unRegisterResponsedEventListener();
            this.h0.X();
            r2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            q29.c("FRS");
            this.r = null;
            ef6.b().e(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                cx6.a().b(gg.g(this.x.getForum().getId(), 0L));
            }
            x47 x47Var = this.j0;
            if (x47Var != null) {
                x47Var.v();
            }
            kw6 kw6Var = this.t;
            if (kw6Var != null) {
                s87.b(kw6Var, this.x, w(), false, null);
                this.t.W0();
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.w.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.L0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.M0 != null) {
                jg.a().removeCallbacks(this.M0);
            }
            if (this.O1 != null) {
                jg.a().removeCallbacks(this.O1);
            }
            jg.a().removeCallbacks(this.P1);
            this.K0 = null;
            vv6.f().s(null);
            uv6.h().s(null);
            super.onDestroy();
            try {
                if (this.N != null) {
                    this.N.c();
                }
                if (this.t != null) {
                    this.t.i1();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.V.R();
            Looper.myQueue().removeIdleHandler(this.g1);
            if (y25.a().b() != 300000) {
                y25.a().d(300000L);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.m();
            }
            rx6 rx6Var = this.a0;
            if (rx6Var != null) {
                rx6Var.d();
            }
            w87 w87Var = this.e0;
            if (w87Var != null) {
                w87Var.i();
            }
            w67 w67Var = this.Y;
            if (w67Var != null) {
                w67Var.c();
            }
            a97 a97Var = this.u0;
            if (a97Var != null) {
                a97Var.g();
            }
            b57 b57Var = this.i0;
            if (b57Var != null) {
                b57Var.o();
            }
            kw5 kw5Var = this.x0;
            if (kw5Var != null) {
                kw5Var.h();
            }
            i26 i26Var = this.y0;
            if (i26Var != null) {
                i26Var.g();
            }
            g87 g87Var = this.T0;
            if (g87Var != null) {
                g87Var.d();
            }
            o29.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.f0(null);
                this.W.O();
            }
            AddExperiencedModel addExperiencedModel = this.C0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            if (this.Q0 != null) {
                getLifecycle().removeObserver(this.Q0);
            }
            jg.a().removeCallbacks(this.Y1);
            bh5 bh5Var = this.a1;
            if (bh5Var != null) {
                bh5Var.onDestroy();
            }
            this.a1 = null;
        }
    }

    public boolean X4(qa9 qa9Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, qa9Var, tbPageContext)) == null) {
            if (!E3() && !w05.i()) {
                if (qa9Var != null && qa9Var.getBusinessPromot() != null && !StringUtils.isNull(qa9Var.getBusinessPromot().q()) && qa9Var.getForum() != null) {
                    boolean j2 = i87.j(qa9Var.getBusinessPromot(), qa9Var.getForum().getId());
                    this.W0 = j2;
                    K4(j2);
                    return this.W0;
                }
                sy6 sy6Var = new sy6(tbPageContext);
                this.U0 = sy6Var;
                boolean j3 = sy6Var.j(qa9Var);
                this.V0 = j3;
                K4(j3);
                return this.V0;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048696, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (vv6.f().i()) {
                    vv6.f().m();
                    return true;
                } else if (uv6.h().j()) {
                    kw6 kw6Var = this.t;
                    if (kw6Var != null && kw6Var.M0()) {
                        this.t.j1();
                        return true;
                    }
                    uv6.h().n();
                    return true;
                } else {
                    kw6 kw6Var2 = this.t;
                    if (kw6Var2 != null) {
                        return kw6Var2.X0();
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

    public final void Y3(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            registerListener(2001118, this.Z1);
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
                registerListener(2001120, this.Z1);
            }
            this.V.Q(bundle);
            s3(j2);
        }
    }

    public final void c5(ia9 ia9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, ia9Var) == null) {
            if (ia9Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05f2);
                this.t.d1();
                showNetRefreshView(this.t.r0(), string, true);
            } else if (340001 == ia9Var.c) {
                h5(ia9Var, this.x.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    g5(ia9Var);
                }
                if (c4()) {
                    setNetRefreshViewEmotionMarginTop(hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070293));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.E0) {
                this.t.V0(i2);
                this.V.T(i2);
                this.W.W(i2);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                o97 o97Var = this.t0;
                if (o97Var != null) {
                    o97Var.onChangeSkinType();
                }
                ez6 ez6Var = this.z0;
                if (ez6Var != null) {
                    ez6Var.d(getPageContext(), i2);
                }
                if (this.A0 != null) {
                    tl5.a(getPageContext(), this.A0.getRealView());
                }
                a97 a97Var = this.u0;
                if (a97Var != null) {
                    a97Var.onChangeSkinType(getPageContext(), i2);
                }
                sy6 sy6Var = this.U0;
                if (sy6Var != null) {
                    sy6Var.onChangeSkinType(getPageContext(), i2);
                }
                bh5 bh5Var = this.a1;
                if (bh5Var != null) {
                    bh5Var.onChangeSkinType(i2);
                }
            }
        }
    }

    public final void p3(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048708, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<gn> threadList = this.x.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.t.g0() != null && this.t.g0().getData() != null) {
            Iterator<gn> it = threadList.iterator();
            List<gn> data = this.t.g0().getData();
            int i2 = 0;
            while (it.hasNext()) {
                gn next = it.next();
                if (next instanceof mz4) {
                    ThreadData threadData = ((mz4) next).t;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            break;
                        } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.g0.j(next);
                            this.t.g0().getAdapter().notifyItemRemoved(i2);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2++;
            }
        }
    }

    public final void u4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i2) == null) {
            t4();
            l5();
            try {
                if (this.x == null) {
                    return;
                }
                vx6 vx6Var = null;
                this.t.L1(null, this.x);
                this.V.v0(1);
                this.t.m1();
                this.W.d(this.x, this.U.m0());
                j77 J = this.W.J(this.x.getFrsDefaultTabId());
                if (J != null && !TextUtils.isEmpty(J.d)) {
                    vx6Var = new vx6();
                    String str = J.d;
                    String str2 = J.a;
                }
                this.U.G(this.x.getFrsDefaultTabId(), 0, vx6Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void Y4(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.d1();
            this.t.s1(8);
            if (this.t0 == null) {
                this.t0 = new o97(getPageContext(), getNetRefreshListener());
            }
            this.t0.c(str);
            this.t0.b(list);
            this.t0.attachView(view2, z2);
        }
    }

    public final void f3(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && (frsModelController = this.U) != null && this.x != null && this.t != null && z2) {
            if (!frsModelController.P0() && this.U.x0() == 1) {
                if (!this.U.M0()) {
                    this.x.addCardVideoInfoToThreadList();
                    this.x.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z4 = false;
                if (this.t.a0().k(eg6.g)) {
                    z4 = this.x.addHotTopicDataToThreadList();
                }
                if (!z4) {
                    this.x.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                    if (this.f1 == 14) {
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
            if (this.t.a0().k(xa7.e)) {
                this.x.addGameRankListToThreadList(z3);
            }
            if (TbadkCoreApplication.isLogin() && (!this.U.P0() || this.U.isNetFirstLoad)) {
                this.x.addUserRecommendToThreadList();
            }
            this.x.addVideoActivityToTop();
        }
    }

    public void g(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048653, this, errorData) != null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        d5();
        this.t.Q0();
        ia9 o02 = this.U.o0();
        boolean isEmpty = ListUtils.isEmpty(this.x.getThreadList());
        if (o02 != null && isEmpty) {
            if (this.U.r0() != 0) {
                this.U.l1();
                this.t.Q0();
            } else {
                c5(o02);
            }
            this.t.u1(this.x.isStarForum(), false);
            return;
        }
        c5(o02);
    }

    public final void w3(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048737, this, intent) != null) || intent == null) {
            return;
        }
        if (!p87.a(this, v(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
                BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.Q1);
            } else {
                j87 b2 = t87.b(intent);
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

    public final void g5(ia9 ia9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, ia9Var) == null) {
            this.t.d1();
            if (ia9Var.a) {
                showNetRefreshView(this.t.r0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{ia9Var.d, Integer.valueOf(ia9Var.c)}), true);
            } else {
                showNetRefreshView(this.t.b0().m(), ia9Var.d, true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.U.a1(bundle);
            if (this.r != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.r.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void r3(int i2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
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

    public final void s3(long j2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048718, this, j2) == null) && j2 > 0) {
            int l2 = hi.l(TbadkCoreApplication.getInst());
            int j3 = hi.j(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jg.a().postDelayed(new l0(this, j2, l2, j3, f2, i2), 1000L);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void h(ArrayList<gn> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            I4(!isEmpty ? 1 : 0);
            e5();
            if (isEmpty) {
                return;
            }
            if (sx5.k().l(O3())) {
                sx5.k().g(O3()).b();
            }
            if (ky5.i().o(O3())) {
                ky5.i().g(O3()).b();
            }
            if (!this.U.P0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.x0() == 1 && ((i2 = this.x.adShowSelect) == 1 || i2 == 3)) {
                this.x.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                b77.i(getUniqueId(), arrayList, this.x.getForum(), this.U.w0());
            }
            d57 d57Var = this.g0;
            sb9 sb9Var = this.o;
            FrsViewData frsViewData = this.x;
            ArrayList<gn> c2 = d57Var.c(false, false, arrayList, sb9Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.x.setThreadList(c2);
                this.t.L1(c2, this.x);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                d77.m(this.x, frsModelController.m0(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.x.getForum()));
        }
    }

    public final void h5(ia9 ia9Var, List<RecmForumInfo> list) {
        kw6 kw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048662, this, ia9Var, list) == null) && (kw6Var = this.t) != null) {
            kw6Var.d1();
            this.t.M1(this.f);
            if (this.t.b0() != null) {
                Y4(this.t.r0(), ia9Var.d, true, list);
            }
            this.t.j0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048722, this, view2, z2) == null) {
            this.t.s1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).G1(view2, true);
            this.t.j0().f(true);
        }
    }

    public final void i4() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048666, this) != null) || !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
        i67.a(param);
        i67.b(param, w(), v());
        TiebaStatic.log(param);
        StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.J);
        if (this.J > 0) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        TiebaStatic.log(param2.param("obj_type", i2).param("obj_source", 2));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
    }

    public final void m4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (frsViewData = this.x) != null && frsViewData.getForum() != null) {
            String id = this.x.getForum().getId();
            String name = this.x.getForum().getName();
            String image_url = this.x.getForum().getImage_url();
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            boolean equals = "showlive".equals(this.x.getForum().special_forum_type);
            ThemeColorInfo themeColorInfo = this.x.getForum().getThemeColorInfo();
            int member_num = this.x.getForum().getMember_num();
            FrsViewData frsViewData2 = this.x;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(id, name, image_url, valueOf, equals, themeColorInfo, member_num, frsViewData2.forumTagInfo, frsViewData2.firstCategory)));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.onStop();
            ef6.b().e(false);
            k4(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                bb5.j().x(getPageContext().getPageActivity(), "frs", this.x.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (I3() != null) {
                I3().getRecycledViewPool().clear();
            }
            this.V.S();
            sp5.c();
        }
    }

    public ForumWriteData x3() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
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
                forumWriteData.frsTabInfo = Q3();
                FrsViewData frsViewData2 = this.x;
                forumWriteData.forumTagInfo = frsViewData2.forumTagInfo;
                forumWriteData.firstCategory = frsViewData2.firstCategory;
                return forumWriteData;
            }
            return null;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public boolean k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i2)) == null) {
            if (!this.Q || this.F0 || !l3(i2)) {
                return false;
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null && frsModelController.q0() && (vv6.f().i() || uv6.h().j())) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void n4(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048684, this, intent) != null) || intent == null) {
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
            t3();
        }
    }

    public void o4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048687, this, str) == null) && TbadkCoreApplication.isLogin() && !gi.isEmpty(str)) {
            if (this.C0 == null) {
                this.C0 = new AddExperiencedModel(n());
            }
            this.C0.V(this.l, str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bundle) == null) {
            super.onCreate(bundle);
            da9.g().i(getUniqueId());
            if (this.Q0 == null) {
                this.Q0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.Q0);
            this.a1 = ah5.a();
            registerResponsedEventListener(TopToastEvent.class, this.D1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null && frsTabViewController.B() != null && (this.W.B().b instanceof BaseFragment)) {
                ((BaseFragment) this.W.B().b).setPrimary(z2);
            }
        }
    }

    public final void w4(qa9 qa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, qa9Var) == null) {
            try {
                if (!this.M && qa9Var != null && this.x != null) {
                    this.x.receiveData(qa9Var);
                    q4(true, false);
                    Looper.myQueue().addIdleHandler(this.g1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.A = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.A = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                w3(intent);
            }
            this.D = currentTimeMillis - this.A;
            this.o = new sb9("frs", sb9.c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.K1);
                this.U = frsModelController;
                frsModelController.O(this.o1);
                this.U.init();
            }
            this.U.m1(this.y);
            ArrayList<gn> arrayList = null;
            if (intent != null) {
                this.U.F0(intent.getExtras());
            } else if (bundle != null) {
                this.U.F0(bundle);
            } else {
                this.U.F0(null);
            }
            if (intent != null) {
                this.V.Q(intent.getExtras());
            } else if (bundle != null) {
                this.V.Q(bundle);
            } else {
                this.V.Q(null);
            }
            this.r = w0();
            this.r0 = new jw6(getPageContext(), this);
            Z3();
            Y3(bundle);
            if (!c4()) {
                rx6 rx6Var = new rx6(getActivity(), this.t, this.V);
                this.a0 = rx6Var;
                rx6Var.i(true);
            }
            VoiceManager w02 = w0();
            this.r = w02;
            if (w02 != null) {
                w02.onCreate(getPageContext());
            }
            q87.b(this, y3(), this.B0, this.u, this.t);
            q87.c(this, y3(), this.B0, this.u);
            if (fe5.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new j57();
            int i2 = -1;
            d57 d57Var = this.g0;
            if (d57Var != null && d57Var.f() != null) {
                i2 = this.g0.f().V();
                arrayList = this.g0.f().U();
            }
            d57 d57Var2 = new d57(this, this.R1);
            this.g0 = d57Var2;
            d57Var2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.g0.f().f0(arrayList);
            }
            this.Y = new w67(this);
            this.h0 = new f97(this);
            this.e0 = new w87(getPageContext(), this.U.K0());
            this.Z = new c57(this);
            this.f0 = new e57(this);
            this.X = new i57(this);
            this.i0 = new b57(this);
            this.s0 = new y87(this);
            new f57(this, getUniqueId());
            this.x0 = new kw5(getPageContext(), "frs");
            this.y0 = new i26(getPageContext());
            new a77(getPageContext());
            registerListener(this.x1);
            registerListener(this.N1);
            registerListener(this.v1);
            registerListener(this.L1);
            registerListener(this.r1);
            registerListener(this.s1);
            registerListener(this.t1);
            registerListener(this.u1);
            registerListener(this.h1);
            registerListener(this.i1);
            registerListener(this.j1);
            registerListener(this.k1);
            registerListener(this.c2);
            registerListener(this.z1);
            this.A1.setSelfListener(true);
            this.A1.setTag(getPageContext().getUniqueId());
            registerListener(this.A1);
            registerListener(this.n1);
            registerListener(this.B1);
            registerListener(this.y1);
            registerListener(this.E1);
            registerListener(this.F1);
            registerListener(this.G1);
            this.d2.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.g2);
            registerListener(this.m1);
            registerListener(this.h2);
            registerListener(this.C1);
            registerListener(this.l1);
            registerListener(this.i2);
            registerListener(this.j2);
            registerListener(this.k2);
            registerListener(this.l2);
            registerListener(this.H1);
            registerListener(this.I1);
            registerListener(this.J1);
            this.M1.setTag(getPageContext().getUniqueId());
            registerListener(this.M1);
            this.t.C0(false);
            if (!c4() && !this.B0) {
                showLoadingView(this.t.r0(), true);
                this.U.k0(3, false);
            }
            M3();
            ia7.a();
            d0 d0Var = new d0(this);
            vv6.f().s(d0Var);
            uv6.h().s(d0Var);
            this.t.G1(new e0(this));
            this.H0 = UtilHelper.getScreenHeight(getActivity());
            this.B0 = true;
            r3(1);
            super.onActivityCreated(bundle);
            this.E = System.currentTimeMillis() - currentTimeMillis;
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
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d030e, viewGroup, false);
                lz6 lz6Var = new lz6();
                this.b = lz6Var;
                this.d0 = lz6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07b7);
                this.V = new d97(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090eaa));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.U1);
                this.W = frsTabViewController;
                frsTabViewController.a0();
                this.V.x0(this.W);
                this.W.f0(this.p1);
                Intent intent = getActivity().getIntent();
                if (intent != null) {
                    if ("main_tab".equals(intent.getStringExtra("from"))) {
                        this.d = true;
                    }
                    this.W.e0(intent.getIntExtra(FrsActivityConfig.KEY_JUMP_TAB_ID, 0));
                }
                this.t = new kw6(this, this.U1, this.b, this.d, this.V);
                this.z0 = new ez6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.a0();
                }
                this.t.f1();
                this.s.setLeft(0);
                this.s.setRight(hi.l(TbadkCoreApplication.getInst().getContext()));
            }
            this.E0 = true;
            this.F = System.currentTimeMillis() - currentTimeMillis;
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    public final void q4(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048713, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.x != null && this.W != null && this.U != null) {
                    if (!this.t.a0().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.x.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.x.getGameTabInfo());
                    this.t.x1(isEmpty);
                    boolean z4 = true;
                    if (!isEmpty) {
                        if (this.u0 == null) {
                            this.u0 = new a97(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.w0 == null) {
                            this.w0 = new g37(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.u0 = null;
                        this.w0 = null;
                    }
                    if (this.x.getForum() != null) {
                        this.f = this.x.getForum().getName();
                        this.l = this.x.getForum().getId();
                    }
                    b5();
                    if (this.x.hasTab()) {
                        this.W.d(this.x, this.U.m0());
                    }
                    if (z2) {
                        f3(true, z2);
                    } else {
                        f3(this.O, z2);
                    }
                    t4();
                    if (this.d0 != null) {
                        this.d0.a(this.V, this.x);
                    }
                    if (this.x.getPage() != null) {
                        I4(this.x.getPage().b());
                    }
                    ArrayList<gn> arrayList = new ArrayList<>();
                    if (!ListUtils.isEmpty(this.x.getThreadList())) {
                        arrayList.addAll(this.x.getThreadList());
                        if (this.U != null && this.U.O0() && c87.a(this.l) && this.x.frsForumGroup != null && this.x.frsForumGroup.feed_card != null && !ListUtils.isEmpty(this.x.frsForumGroup.feed_card.group_list) && this.x.frsForumGroup.feed_card.index.intValue() >= 0) {
                            w07.h(this.x.frsForumGroup, arrayList, this.l);
                        }
                    }
                    ArrayList<gn> d2 = this.g0.d(z3, true, arrayList, null, z2, false, this.x.adShowSelect, this.x.adMixFloor);
                    if (d2 != null) {
                        this.x.setThreadList(d2);
                    }
                    this.x.removeRedundantUserRecommendData();
                    int topThreadSize = this.x.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        y77.a(this, this.x.getForum(), this.x.getThreadList(), this.n, L3());
                    }
                    if (this.U.x0() == 1) {
                        s4();
                        if (!z2 && this.U.getPn() == 1) {
                            x4();
                        }
                    }
                    if (this.e0 != null) {
                        this.e0.k(this.W.G());
                    }
                    d5();
                    this.t.l1();
                    this.t.u1(true, false);
                    if (this.x.frsForumGroup == null) {
                        kw6 kw6Var = this.t;
                        if (this.V0) {
                            z4 = false;
                        }
                        kw6Var.g2(null, z4);
                    } else {
                        kw6 kw6Var2 = this.t;
                        TopbarEntrance topbarEntrance = this.x.frsForumGroup.topbar_entrance;
                        if (this.V0) {
                            z4 = false;
                        }
                        kw6Var2.g2(topbarEntrance, z4);
                    }
                    if (z2 && this.x.isFirstTabEqualAllThread()) {
                        jg.a().post(new y(this));
                    }
                    if (this.x.getForum() != null) {
                        this.t.R(this.x.getForum().getWarningMsg());
                    }
                    if (this.x != null && this.x.getFrsVideoActivityData() != null && m35.m().o("frs_video_activity_guide", 0L) == 0) {
                        jg.a().postDelayed(new z(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.N1();
                    m4();
                    this.z0.e(this.x.bottomMenuList, this.x.getForum());
                    k5();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048723, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z2, getNetRefreshListener());
            this.t.s1(8);
            this.t.j0().f(true);
            m59.a("frs", false);
        }
    }
}
