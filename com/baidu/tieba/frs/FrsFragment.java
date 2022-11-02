package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
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
import com.baidu.tieba.aj6;
import com.baidu.tieba.am6;
import com.baidu.tieba.ao;
import com.baidu.tieba.ao8;
import com.baidu.tieba.ap5;
import com.baidu.tieba.av6;
import com.baidu.tieba.bk6;
import com.baidu.tieba.bq8;
import com.baidu.tieba.bv6;
import com.baidu.tieba.ch;
import com.baidu.tieba.cj5;
import com.baidu.tieba.ck6;
import com.baidu.tieba.cn8;
import com.baidu.tieba.cv6;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.dv6;
import com.baidu.tieba.dx6;
import com.baidu.tieba.eh8;
import com.baidu.tieba.ek6;
import com.baidu.tieba.ep5;
import com.baidu.tieba.fj6;
import com.baidu.tieba.fk6;
import com.baidu.tieba.fp5;
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
import com.baidu.tieba.fv6;
import com.baidu.tieba.gh8;
import com.baidu.tieba.gk6;
import com.baidu.tieba.go;
import com.baidu.tieba.gv6;
import com.baidu.tieba.hl6;
import com.baidu.tieba.hn8;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hp5;
import com.baidu.tieba.hq5;
import com.baidu.tieba.if5;
import com.baidu.tieba.ik6;
import com.baidu.tieba.ip5;
import com.baidu.tieba.iv4;
import com.baidu.tieba.iv6;
import com.baidu.tieba.jm4;
import com.baidu.tieba.k35;
import com.baidu.tieba.ki6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.km4;
import com.baidu.tieba.kr6;
import com.baidu.tieba.kt6;
import com.baidu.tieba.kv6;
import com.baidu.tieba.ky4;
import com.baidu.tieba.le5;
import com.baidu.tieba.li6;
import com.baidu.tieba.ln6;
import com.baidu.tieba.lr6;
import com.baidu.tieba.mo5;
import com.baidu.tieba.ms4;
import com.baidu.tieba.mu6;
import com.baidu.tieba.nb5;
import com.baidu.tieba.ng;
import com.baidu.tieba.no5;
import com.baidu.tieba.nr6;
import com.baidu.tieba.nv6;
import com.baidu.tieba.oo5;
import com.baidu.tieba.or6;
import com.baidu.tieba.ot6;
import com.baidu.tieba.ou6;
import com.baidu.tieba.ow6;
import com.baidu.tieba.pb;
import com.baidu.tieba.pi6;
import com.baidu.tieba.pk6;
import com.baidu.tieba.pn8;
import com.baidu.tieba.pr6;
import com.baidu.tieba.pt6;
import com.baidu.tieba.pv6;
import com.baidu.tieba.q9;
import com.baidu.tieba.qr6;
import com.baidu.tieba.qt6;
import com.baidu.tieba.r9;
import com.baidu.tieba.ro8;
import com.baidu.tieba.rp4;
import com.baidu.tieba.rr6;
import com.baidu.tieba.rt6;
import com.baidu.tieba.ru6;
import com.baidu.tieba.s36;
import com.baidu.tieba.s46;
import com.baidu.tieba.s85;
import com.baidu.tieba.sf8;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sj6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.ss4;
import com.baidu.tieba.st6;
import com.baidu.tieba.t85;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tj5;
import com.baidu.tieba.tl6;
import com.baidu.tieba.tp6;
import com.baidu.tieba.tq4;
import com.baidu.tieba.ts4;
import com.baidu.tieba.tu6;
import com.baidu.tieba.tw6;
import com.baidu.tieba.u55;
import com.baidu.tieba.ul6;
import com.baidu.tieba.ur6;
import com.baidu.tieba.uu6;
import com.baidu.tieba.uv6;
import com.baidu.tieba.v85;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.vr6;
import com.baidu.tieba.vu4;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wn;
import com.baidu.tieba.wn8;
import com.baidu.tieba.wr6;
import com.baidu.tieba.ws6;
import com.baidu.tieba.wt6;
import com.baidu.tieba.xi;
import com.baidu.tieba.xj5;
import com.baidu.tieba.xp5;
import com.baidu.tieba.xt6;
import com.baidu.tieba.xu5;
import com.baidu.tieba.yp8;
import com.baidu.tieba.yr6;
import com.baidu.tieba.yy;
import com.baidu.tieba.zg;
import com.baidu.tieba.zi6;
import com.baidu.tieba.zj6;
import com.baidu.tieba.zq5;
import com.baidu.tieba.zr6;
import com.baidu.tieba.zu6;
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
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, nr6, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, fk6, sf8, zr6, oo5, zj6, ck6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String h2;
    public static final String i2;
    public static boolean j2;
    public static final ThreadData k2;
    public static pn8 l2;
    public static volatile long m2;
    public static volatile long n2;
    public static volatile int o2;
    public static boolean p2;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public AddExperiencedModel A0;
    public nb5 A1;
    public long B;
    public boolean B0;
    public final CustomMessageListener B1;
    public long C;
    public boolean C0;
    public CustomMessageListener C1;
    public long D;
    public boolean D0;
    public final CustomMessageListener D1;
    public long E;
    public Date E0;
    public CustomMessageListener E1;
    public long F;
    public int F0;
    public CustomMessageListener F1;
    public long G;
    public int G0;
    public final wn8 G1;
    public long H;
    public int H0;
    public final CustomMessageListener H1;
    public boolean I;
    public List<LiveHorseRaceData> I0;
    public final CustomMessageListener I1;
    public int J;
    public ValueAnimator J0;
    public final Runnable J1;
    public boolean K;
    public Runnable K0;
    public final BdUniDispatchSchemeController.b K1;
    public boolean L;
    public int L0;
    public final yr6 L1;
    public boolean M;
    public lr6 M0;
    public final View.OnTouchListener M1;
    public le5 N;
    public ul6 N0;
    public final View.OnClickListener N1;
    public boolean O;
    @Nullable
    public TiePlusEventController O0;
    public final View.OnClickListener O1;
    public boolean P;
    public int P0;
    public final RecyclerView.OnScrollListener P1;
    public String Q;
    public int Q0;
    public final pi6 Q1;
    public yy.a R;
    public ru6 R0;
    public final NoNetworkView.b R1;
    public ThreadCardViewHolder S;
    public hl6 S0;
    public Runnable S1;
    public FrsModelController T;
    public boolean T0;
    public final CustomMessageListener T1;
    public nv6 U;
    public boolean U0;
    public go U1;
    public FrsTabViewController V;
    public boolean V0;
    public ek6 V1;
    public vr6 W;
    public Object W0;
    public CustomMessageListener W1;
    public kt6 X;
    public PollingModel X0;
    public CustomMessageListener X1;
    public pr6 Y;
    public boolean Y0;
    public CustomMessageListener Y1;
    public gk6 Z;
    public boolean Z0;
    public CustomMessageListener Z1;
    public String a;
    public SparseArray<no5> a0;
    public boolean a1;
    public CustomMessageListener a2;
    public am6 b;
    public boolean b0;
    public int b1;
    public CustomMessageListener b2;
    public boolean c;
    public ln6 c0;
    public int c1;
    public CustomMessageListener c2;
    public boolean d;
    public gv6 d0;
    public MessageQueue.IdleHandler d1;
    public CustomMessageListener d2;
    public boolean e;
    public rr6 e0;
    public final CustomMessageListener e1;
    public HttpMessageListener e2;
    public String f;
    public qr6 f0;
    public CustomMessageListener f1;
    public CustomMessageListener f2;
    public String g;
    public pv6 g0;
    public CustomMessageListener g1;
    public tw6 g2;
    public int h;
    public or6 h0;
    public CustomMessageListener h1;
    public boolean i;
    public kr6 i0;
    public CustomMessageListener i1;
    public boolean j;
    public zi6 j0;
    public pb j1;
    public String k;
    public CustomMessageListener k1;
    public String l;
    public final ek6 l1;
    public int m;
    public FrsTabViewController.o m1;
    public boolean n;
    public int n1;
    public ro8 o;
    public CustomMessageListener o1;
    public boolean p;
    public CustomMessageListener p1;
    public boolean q;
    public iv6 q0;
    public final CustomMessageListener q1;
    public VoiceManager r;
    public uv6 r0;
    public final CustomMessageListener r1;
    public View s;
    public kv6 s0;
    public final CustomMessageListener s1;
    public aj6 t;
    public boolean t0;
    public final AntiHelper.k t1;
    public OvalActionButton u;
    public tp6 u0;
    public CustomMessageListener u1;
    public FRSRefreshButton v;
    public ap5 v0;
    public CustomMessageListener v1;
    public LinearLayout w;
    public xu5 w0;
    public CustomMessageListener w1;
    public FrsViewData x;
    public tl6 x0;
    public CustomMessageListener x1;
    public String y;
    public iv4 y0;
    public CustomMessageListener y1;
    public ng<TbImageView> z;
    public boolean z0;
    public HttpMessageListener z1;

    public final boolean a3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i3)) == null) ? i3 != 506 : invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class f0 implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ f0 b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0262a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ float d;
                public final /* synthetic */ int e;
                public final /* synthetic */ a f;

                public RunnableC0262a(a aVar, long j, int i, int i2, float f, int i3) {
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
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.V.b(301);
                    long g = wg.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L);
                    int l = xi.l(TbadkCoreApplication.getInst());
                    int j = xi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    zg.a().postDelayed(new RunnableC0262a(this, g, l, j, f, i), 1000L);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_KW) instanceof String) {
                this.a.f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_KW);
            }
            if ((hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID))) {
                zg.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements fp5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes4.dex */
        public class a implements iv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) && iv4Var != null) {
                    iv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements iv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) && iv4Var != null) {
                    iv4Var.dismiss();
                }
            }
        }

        public c0(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.fp5.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            String string;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) != null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.t.U();
            this.a.t.T();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.a.V != null && this.a.V.C() != null && (this.a.V.C().b instanceof FrsNewAreaFragment)) {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.V.C().b;
                z = true;
            } else {
                z = false;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                if (!TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText())) {
                    string = deleteThreadHttpResponseMessage.getText();
                } else {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f04bf);
                }
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.y0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.y0 = new iv4(frsFragment.getActivity());
                    }
                    this.a.y0.setMessage(string);
                    this.a.y0.setPositiveButton(R.string.obfuscated_res_0x7f0f04fd, new a(this));
                    this.a.y0.setCanceledOnTouchOutside(false);
                    this.a.y0.create(this.a.getPageContext());
                    this.a.y0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.y0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y0 = new iv4(frsFragment2.getActivity());
                    }
                    this.a.y0.setMessage(string);
                    this.a.y0.setPositiveButton(R.string.obfuscated_res_0x7f0f09d2, new b(this));
                    this.a.y0.setCanceledOnTouchOutside(false);
                    this.a.y0.create(this.a.getPageContext());
                    this.a.y0.show();
                } else {
                    Context context = this.a.getContext();
                    if (deleteThreadHttpResponseMessage.getRetType() == 1) {
                        i = R.color.nav_bar_tip_error;
                    } else {
                        i = R.color.cp_link_tip_a_alpha95;
                    }
                    this.a.t.R1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(context, i));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.h2(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.e3(deleteThreadHttpResponseMessage.getSuccessItems());
                li6.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (wn wnVar : this.a.x.getThreadList()) {
                    if (wnVar instanceof vu4) {
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
            xi.P(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
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
                    forumBroadcastHelper.clipCopy(this.a.Q);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f0701));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f0761));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090afb));
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class q1 implements go {
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

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == fj6.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.X1();
                }
            } else if (wnVar != null && (wnVar instanceof vu4)) {
                ThreadData threadData = ((vu4) wnVar).t;
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
                    if (!StringUtils.isNull(a2) && xi.F()) {
                        rp4.n(this.a.getActivity(), a2);
                    }
                } else if (threadData.getCartoonThreadData() != null) {
                    if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    ms4 cartoonThreadData = threadData.getCartoonThreadData();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                } else {
                    bq8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                        cv6.c(threadData.getTaskInfoData());
                    } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "2");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                    }
                    dv6.f(this.a, threadData, i, z);
                    FrsFragment frsFragment = this.a;
                    cv6.d(frsFragment, frsFragment.x, threadData);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements ek6 {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.H0()) {
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

        @Override // com.baidu.tieba.ek6
        public void a(int i, int i2, pk6 pk6Var, ArrayList<wn> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), pk6Var, arrayList}) == null) {
                zg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                boolean z2 = false;
                if (i != 1) {
                    s36.b().e(false);
                    this.a.Y3(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.n1 = i;
                this.a.P0 = i2;
                if (this.a.M0 != null) {
                    this.a.M0.d(this.a.P0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.P0);
                this.a.d5();
                qt6 qt6Var = st6.p0;
                qt6Var.e = i;
                qt6Var.h = i2;
                qt6Var.f = -1;
                if (this.a.B0) {
                    li6 f = li6.f();
                    if (i == 1 && this.a.B0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    f.p(z, true);
                    ki6 h = ki6.h();
                    if (i == 1 && this.a.B0) {
                        z2 = true;
                    }
                    h.p(z2, true);
                    return;
                }
                this.a.t.W1(this.a.a3(i));
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
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && this.a.x != null && (userData = this.a.x.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    this.a.U.T(num);
                }
            }
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
                this.a.V.l0(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements ik6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public b0(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.ik6
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || this.a.t == null) {
                return;
            }
            int i2 = 8;
            boolean z3 = false;
            if (i == 1) {
                this.a.t.A1(li6.f().h());
                aj6 aj6Var = this.a.t;
                if (z) {
                    i2 = 0;
                }
                aj6Var.B1(i2);
            } else if (i == 2) {
                aj6 aj6Var2 = this.a.t;
                if (z) {
                    i2 = 0;
                }
                aj6Var2.x1(i2);
            }
            if (!z2) {
                this.a.B0 = z;
            }
            if (this.a.t.Y() != null && (i == 2 || (this.a.T != null && this.a.T.X()))) {
                this.a.t.Y().notifyDataSetChanged();
            }
            if (this.a.E3() != null) {
                FrsTabViewController.p C = this.a.E3().C();
                if (C != null) {
                    if ((C.b instanceof FrsCommonTabFragment) && (i == 2 || C.a == 502)) {
                        ((FrsCommonTabFragment) C.b).Q1();
                    } else if ((C.b instanceof FrsNewAreaFragment) && (i == 2 || C.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) C.b;
                        frsNewAreaFragment.l2();
                        if (frsNewAreaFragment.W1() != null) {
                            ur6 W1 = frsNewAreaFragment.W1();
                            W1.L(!z);
                            if (i == 1) {
                                W1.I(!z);
                            } else if (i == 2) {
                                W1.I(true);
                            }
                        }
                    } else {
                        Fragment fragment = C.b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).g2();
                        }
                    }
                }
                if (this.a.E3().N() != null) {
                    this.a.E3().N().setmDisallowSlip(z);
                    this.a.E3().i0(z);
                }
            }
            if (this.a.t.a0() != null) {
                aj6 aj6Var3 = this.a.t;
                if (this.a.Y2() && !z) {
                    z3 = true;
                }
                aj6Var3.W1(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.a.getActivity()).d1(!z);
            }
            if (this.a.x0 != null) {
                this.a.x0.f(!z);
            }
            this.a.t.G1(!z);
            if (i == 1) {
                this.a.t.w1(!z);
            } else if (i == 2) {
                this.a.t.w1(true);
            }
        }

        @Override // com.baidu.tieba.ik6
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.a.getContext() == null) {
                return;
            }
            if (i == 1) {
                xi.O(this.a.getContext(), R.string.obfuscated_res_0x7f0f0750);
            } else if (i == 2 && this.a.t != null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0745));
                bdTopToast.i(this.a.t.p0());
            }
        }

        @Override // com.baidu.tieba.ik6
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || this.a.t == null) {
                return;
            }
            if (i2 == 1) {
                this.a.t.z1(i);
            } else if (i2 == 2) {
                this.a.t.y1(i);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !this.a.isResumed()) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.v != null) {
                if (booleanValue) {
                    if (this.a.V.L() != 0 && !this.a.t.K0() && !v85.h().k()) {
                        this.a.v.f();
                        return;
                    }
                    return;
                }
                this.a.v.b();
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
                fv6.b(this.a.x, this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveHorseRaceData a;
        public final /* synthetic */ FrsFragment b;

        public c1(FrsFragment frsFragment, LiveHorseRaceData liveHorseRaceData) {
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
            this.a.V.b(49);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
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
                this.a.V.b(1);
                this.a.k3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(FrsFragment frsFragment, int i) {
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
                    this.a.t.L0();
                }
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
                if (this.b.I0 == null || this.b.H0 <= this.b.I0.size() - 1) {
                    this.b.M3();
                    return;
                }
                this.b.w.removeAllViews();
                this.b.w.setVisibility(8);
                this.b.H0 = 0;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao8) && this.a.x != null) {
                this.a.x.updateLikeData((ao8) customResponsedMessage.getData());
                this.a.U.W(this.a.x);
                this.a.V.d(this.a.x, this.a.T.U());
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
                this.b.J0.start();
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
        public void onNavigationButtonClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements yr6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public g0(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.yr6
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<wn> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) && this.a.X != null && this.a.T != null && this.a.T.w0() && z && !z2 && !z3) {
                this.a.X.a(i2);
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getPageContext().getUniqueId()) && updateAttentionMessage.getData().i != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, this.a.t1) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.Z != null && this.a.Z.e() != null) {
                    this.a.Z.e().c(motionEvent);
                }
                if (this.a.u0 != null) {
                    this.a.u0.b(view2, motionEvent);
                }
                if (this.a.U != null) {
                    this.a.U.S(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
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
                this.a.E0 = (Date) customResponsedMessage.getData();
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
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FrsFragment f;

        public i0(FrsFragment frsFragment, long j, int i, int i2, float f, int i3) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ss4) && this.a.isResumed()) {
                ss4 ss4Var = (ss4) customResponsedMessage.getData();
                if (this.a.N0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.N0 = new ul6(frsFragment.getPageContext());
                }
                if (this.a.x != null && this.a.x.getForum() != null && !TextUtils.isEmpty(this.a.x.getForum().getId())) {
                    this.a.N0.j(ss4Var.a, this.a.x.getForum().getId(), this.a.x.getForum().getName(), ss4Var.b);
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
            this.a.t.U1((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yp8.o(this.a.f);
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
                frsFragment.Q = threadData.getTid() + "";
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
                this.a.k4();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;
        public final /* synthetic */ FrsFragment b;

        public k0(FrsFragment frsFragment, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, iv4Var};
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
            this.a = iv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            iv4 iv4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (iv4Var = this.a) != null) {
                iv4Var.dismiss();
                this.b.N4();
            }
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
                this.a.h0.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements tq4 {
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

        @Override // com.baidu.tieba.tq4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    v85.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f067e));
                bdTopToast.i(this.a.t.p0());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && this.a.v != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.V.C() != null && (this.a.V.C().b instanceof BaseFragment) && ((BaseFragment) this.a.V.C().b).isPrimary() && !this.a.t.K0()) {
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
                this.a.t.d1(this.a.J, this.a.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements tq4 {
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

        @Override // com.baidu.tieba.tq4
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                v85.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.u != null) {
                    this.a.u.setVisibility(8);
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                hp5 hp5Var = (hp5) customResponsedMessage.getData();
                int i = 0;
                if (this.a.x != null && this.a.x.getForum() != null && this.a.x.getForum().getDeletedReasonInfo() != null) {
                    int intValue = this.a.x.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
                    int intValue2 = this.a.x.getForum().getDeletedReasonInfo().is_boomgrow.intValue();
                    if (this.a.x.forumRule != null) {
                        i = this.a.x.forumRule.has_forum_rule.intValue();
                    }
                    ip5 ip5Var = new ip5(intValue, intValue2, i);
                    ip5Var.i(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                    ip5Var.h(this.a.x.getForum().getImage_url());
                    ip5Var.j(this.a.x.getForum().getUser_level());
                    ep5.d(ip5Var.f(), this.a.getPageContext(), hp5Var, ip5Var, this.a.x.getUserData());
                    return;
                }
                ep5.d(0, this.a.getPageContext(), hp5Var, null, this.a.x.getUserData());
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
                    bdTopToast.g(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f074a));
                    bdTopToast.i(this.a.t.p0());
                    if (ki6.h().k(ki6.h().e())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (this.a.V != null && this.a.V.C() != null && (this.a.V.C().b instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) this.a.V.C().b;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.O1();
                        }
                        this.a.f3();
                        ki6.h().d();
                        for (wn wnVar : this.a.x.getThreadList()) {
                            if (wnVar instanceof vu4) {
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
                    ki6.h().n();
                    return;
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(httpResponsedMessage.getErrorString());
                bdTopToast2.i(this.a.t.p0());
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
            this.a.W3();
        }
    }

    /* loaded from: classes4.dex */
    public class n1 extends pb {
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

        @Override // com.baidu.tieba.pb
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
            if (this.a.I0 == null) {
                this.a.I0 = new ArrayList();
                this.a.H0 = 0;
                this.a.I0.addAll(arrayList);
                this.a.M3();
            } else if (this.a.w != null && this.a.w.getVisibility() == 8) {
                this.a.I0 = new ArrayList();
                this.a.I0.addAll(arrayList);
                this.a.H0 = 0;
                this.a.M3();
            } else if (this.a.H0 < this.a.I0.size()) {
                FrsFragment frsFragment = this.a;
                frsFragment.I0 = frsFragment.I0.subList(0, this.a.H0);
                this.a.I0.addAll(arrayList);
            } else {
                this.a.I0.addAll(arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends nb5<TopToastEvent> {
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
        @Override // com.baidu.tieba.gb5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                bdTopToast.h(topToastEvent.isSuccess());
                bdTopToast.g(topToastEvent.getContent());
                bdTopToast.i(this.c.t.p0());
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
                LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090663);
                if (this.a.t != null && view2 == this.a.t.W() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090c7b && xi.F()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t != null && this.a.t.F0()) {
                        this.a.t.M1();
                    } else {
                        String c = this.a.x.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c)) {
                            rp4.n(this.a.getPageContext().getPageActivity(), c);
                        }
                    }
                }
                if (this.a.t != null && view2 == this.a.t.f0() && this.a.T != null && this.a.T.hasMore()) {
                    this.a.t.P1();
                    this.a.b();
                }
                if (view2 != null && this.a.t != null && view2 == this.a.t.g0()) {
                    this.a.W3();
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    xi.O(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c80);
                } else if (this.a.x != null && this.a.x.getForum() != null) {
                    if (this.a.t != null && (view2 == this.a.t.v0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.x != null && this.a.x.getForum() != null && !StringUtils.isNull(this.a.x.getForum().getId()) && !StringUtils.isNull(this.a.x.getForum().getName())) {
                            ws6.e(this.a.x.getForum().getId(), this.a.x.getForum().getName());
                            zu6.f(this.a.getPageContext(), this.a.x, this.a.x.getForum().getId(), this.a.J, this.a.K, this.a.N1);
                        } else {
                            return;
                        }
                    }
                    if ((this.a.t != null && view2 == this.a.t.u0()) || logicField == LogicField.SEARCH_BTN) {
                        StatisticItem param = new StatisticItem("c12402").param("fid", this.a.x.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.x.getForum().getName());
                        ws6.a(param);
                        TiebaStatic.log(param);
                        if (!StringUtils.isNull(this.a.x.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.x.getForum().getName(), this.a.x.getForum().getId())));
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
            this.a.k3();
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
            this.a.c5();
        }
    }

    /* loaded from: classes4.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(FrsFragment frsFragment, int i) {
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
                if (((Integer) customResponsedMessage.getData()).intValue() > 0 && this.a.V.L() != 0 && this.a.V.C() != null && (this.a.V.C().b instanceof BaseFragment) && ((BaseFragment) this.a.V.C().b).isPrimary() && !this.a.t.K0() && !v85.h().k()) {
                    this.a.v.f();
                } else if (this.a.V.L() != 0) {
                    this.a.v.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p1 implements ek6 {
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

        @Override // com.baidu.tieba.ek6
        public void a(int i, int i2, pk6 pk6Var, ArrayList<wn> arrayList) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), pk6Var, arrayList}) == null) {
                this.a.U4();
                if (this.a.c0 != null) {
                    this.a.U.g0(this.a.c0.e(i));
                }
                hn8 hn8Var = new hn8();
                if (pk6Var != null) {
                    if (pk6Var.e == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    hn8Var.b = z;
                    hn8Var.c = pk6Var.e;
                    hn8Var.d = pk6Var.f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.x0();
                        } else if (pk6Var.g) {
                            if (ListUtils.getCount(this.a.x.getThreadList()) > 3) {
                                this.a.t.P1();
                            } else {
                                this.a.t.L1();
                            }
                        } else if (pk6Var.i) {
                            this.a.t.S1();
                        } else {
                            this.a.t.x0();
                        }
                    }
                } else {
                    pk6Var = new pk6();
                    pk6Var.c = 1;
                    pk6Var.g = false;
                    pk6Var.i = false;
                }
                if (i == 1) {
                    this.a.O = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.G1.d(frsFragment.T.getType(), false, hn8Var);
                } else {
                    this.a.T4(hn8Var);
                    if (this.a.T.g0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.x = frsFragment2.T.g0();
                    }
                    this.a.h4();
                }
                if (this.a.V1 != null) {
                    this.a.V1.a(i, i2, pk6Var, arrayList);
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
                    this.a.t.k1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.c.U != null) {
                    this.c.U.r0(i);
                    if (i == 1) {
                        this.c.U.D();
                    }
                }
                FrsFragment frsFragment = this.c;
                if (frsFragment.N == null && !frsFragment.Q3()) {
                    this.c.N = new le5();
                    this.c.N.a(1000);
                }
                if (i == 0) {
                    le5 le5Var = this.c.N;
                    if (le5Var != null) {
                        le5Var.e();
                    }
                    s36.b().e(true);
                    this.c.Y3(true);
                    this.c.t.P0(this.a, this.b);
                    if (this.c.W0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.c.W0);
                        this.c.W0 = null;
                    }
                } else {
                    if (this.c.W0 == null) {
                        this.c.W0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    le5 le5Var2 = this.c.N;
                    if (le5Var2 != null) {
                        le5Var2.d();
                    }
                }
                if (this.c.s0 != null) {
                    this.c.s0.i(recyclerView, i);
                }
                if (i == 0) {
                    cv6.b(this.c.t, this.c.x, this.c.k(), false, null);
                }
                if (this.c.V != null && i == 1) {
                    this.c.V.P();
                }
                if (this.c.S == null) {
                    if (this.c.t.m0() != null && !this.c.t.c0() && this.c.t.m0().j() != null && (this.c.t.m0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.c;
                        frsFragment2.S = (ThreadCardViewHolder) frsFragment2.t.m0().j().getTag();
                    }
                } else if (i == 0 && this.c.t.m0() != null && !this.c.t.c0() && this.c.t.m0().j() != null && (this.c.t.m0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.c;
                    frsFragment3.S = (ThreadCardViewHolder) frsFragment3.t.m0().j().getTag();
                }
                if (i == 1) {
                    this.c.t.O0();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.c.G0 += i2;
                if (this.c.G0 >= this.c.F0 * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.c.d0 != null) {
                    this.c.d0.j();
                }
                this.a = 0;
                this.b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.c.s0 != null) {
                    this.c.s0.h(recyclerView, this.a, this.b);
                }
                if (this.c.x != null && this.c.t != null && this.c.t.Y() != null) {
                    this.c.t.l1(this.a, this.b);
                    if (this.c.S != null && this.c.S.a() != null) {
                        this.c.S.a().o(this.c.R);
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
                if (TbadkApplication.getInst().getCurrentActivity() != null && !wi.isEmpty(str) && str.equals(this.a.l)) {
                    zu6.g(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.x);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements pi6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        public r0(FrsFragment frsFragment) {
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

        @Override // com.baidu.tieba.pi6
        public void a(int i, int i2, View view2, View view3, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view2, view3, threadData}) == null) {
                if (i == this.a.t.Y().c()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        return;
                    }
                    TiebaStatic.log("forum_fortune_click");
                    dv6.e(this.a.getPageContext(), this.a.x);
                } else if (i == this.a.t.Y().j()) {
                    if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (this.a.x != null && this.a.x.getForum() != null) {
                        ForumData forum = this.a.x.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), wg.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (i == this.a.t.Y().i() && this.a.x != null && this.a.x.getUserData() != null && this.a.x.getUserData().isBawu()) {
                    String bawuCenterUrl = this.a.x.getBawuCenterUrl();
                    if (!wi.isEmpty(bawuCenterUrl) && this.a.x.getForum() != null) {
                        rp4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.x.getForum().getId()).param("uid", this.a.x.getUserData().getUserId()));
                    }
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
                this.a.t.Q();
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
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.T.e0() == 1 && z && !this.a.t.c0()) {
                if (this.a.x != null && !ListUtils.isEmpty(this.a.x.getThreadList())) {
                    this.a.t.M0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.Z().m());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.p0(), true);
                this.a.t.y0(false);
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
                this.a.Q4();
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
            FrsTabViewController.p C;
            Fragment fragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.V != null && (C = this.a.V.C()) != null && (fragment = C.b) != null && (fragment instanceof bk6)) {
                ((bk6) fragment).x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements wn8 {
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

        @Override // com.baidu.tieba.wn8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.b.t.M0();
                }
            }
        }

        @Override // com.baidu.tieba.wn8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.k4();
            }
        }

        @Override // com.baidu.tieba.wn8
        public void c(pn8 pn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pn8Var) == null) {
                if ((pn8Var != null && ("normal_page".equals(this.b.T.c0()) || "frs_page".equals(this.b.T.c0()) || "book_page".equals(this.b.T.c0()))) || "brand_page".equals(this.b.T.c0())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, pn8Var));
                    this.b.l4(pn8Var);
                    FrsFragment.l2 = pn8Var;
                }
            }
        }

        @Override // com.baidu.tieba.wn8
        public void d(int i, boolean z, hn8 hn8Var) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), hn8Var}) == null) {
                if (this.b.b0) {
                    this.b.b0 = false;
                    cv6.b(this.b.t, this.b.x, this.b.k(), false, null);
                }
                this.b.U4();
                this.b.M = true;
                if (hn8Var != null && hn8Var.b) {
                    this.b.t.Y().m(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.m2 = 0L;
                    FrsFragment.n2 = 0L;
                    FrsFragment.o2 = 0;
                } else {
                    FrsFragment.o2 = 1;
                }
                if (!this.b.T.w0() && (i == 3 || i == 6)) {
                    this.b.f0.l();
                }
                this.b.B = System.currentTimeMillis();
                if (this.b.T.g0() != null) {
                    FrsFragment frsFragment = this.b;
                    frsFragment.x = frsFragment.T.g0();
                }
                this.b.S4(1);
                this.b.K4();
                if (i == 7) {
                    this.b.j4(this.b.x.getFrsDefaultTabId());
                    return;
                }
                if (this.b.x.getPage() != null) {
                    FrsFragment frsFragment2 = this.b;
                    frsFragment2.w4(frsFragment2.x.getPage().b());
                }
                if (i != 4) {
                    this.b.W4();
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 || i == 6) {
                                if (this.b.x != null) {
                                    this.b.x.clearPostThreadCount();
                                }
                                iv6 iv6Var = this.b.q0;
                                if (iv6Var != null) {
                                    iv6Var.d();
                                }
                            }
                        } else {
                            this.b.t.M0();
                        }
                    } else {
                        this.b.t.M0();
                    }
                    this.b.b5();
                    if (hn8Var != null && hn8Var.c != 0) {
                        if (this.b.x == null || ListUtils.isEmpty(this.b.x.getThreadList())) {
                            this.b.T4(hn8Var);
                        } else if (hn8Var.a) {
                            FrsFragment frsFragment3 = this.b;
                            frsFragment3.showToast(frsFragment3.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c7e, hn8Var.d, Integer.valueOf(hn8Var.c)));
                        }
                    } else if (this.b.x == null) {
                        return;
                    } else {
                        if (this.b.o() != null) {
                            FrsFragment frsFragment4 = this.b;
                            if (!frsFragment4.L4(frsFragment4.x, this.b.o())) {
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
                        frsFragment5.f4(false, z2);
                        if (this.b.T != null) {
                            if (this.b.x.getActivityHeadData() != null && this.b.x.getActivityHeadData().b() != null && this.b.x.getActivityHeadData().b().size() > 0) {
                                pt6.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.T.d0(), 1);
                            }
                            if (this.b.x.getThreadList() != null && this.b.x.getThreadList().size() > 0) {
                                Iterator<wn> it = this.b.x.getThreadList().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    wn next = it.next();
                                    if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                        pt6.h(this.b.getUniqueId(), 1, this.b.x.getForum(), this.b.T.d0(), 2);
                                        break;
                                    }
                                }
                            }
                            pt6.i(this.b.getUniqueId(), this.b.x.getThreadList(), this.b.x.getForum(), this.b.T.d0());
                        }
                        this.b.t.Y0(i);
                        FrsFragment.m2 = (System.nanoTime() - this.a) / 1000000;
                        if (hn8Var != null) {
                            FrsFragment.n2 = hn8Var.e;
                        }
                    }
                    this.b.d3();
                    if (this.b.x.getAccessFlag() == 1) {
                        TiebaStatic.log(new StatisticItem("c11384"));
                    }
                    if (this.b.p && this.b.V.b(49)) {
                        this.b.p = false;
                    }
                    System.gc();
                    return;
                }
                if (!this.b.T.w0() && TbadkCoreApplication.getInst().isRecAppExist() && this.b.T.e0() == 1 && (this.b.x.adShowSelect == 1 || this.b.x.adShowSelect == 3)) {
                    this.b.x.addRecommendAppToThreadList(this.b);
                }
                ArrayList<wn> c = this.b.f0.c(false, false, this.b.x.getThreadList(), this.b.o, false, this.b.x.adShowSelect, this.b.x.adMixFloor);
                if (c != null) {
                    this.b.x.setThreadList(c);
                    this.b.x.checkLiveStageInThreadList();
                }
                if (this.b.T != null) {
                    rt6.m(this.b.x, this.b.T.U(), 2, this.b.getContext());
                }
                FrsFragment frsFragment6 = this.b;
                mu6.a(frsFragment6, frsFragment6.x.getForum(), this.b.x.getThreadList(), false, this.b.A3());
                this.b.t.H1(c, this.b.x);
                this.b.W4();
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
                ou6.a(customResponsedMessage, this.a.t, this.a.x);
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
                cv6.b(this.a.t, this.a.x, this.a.k(), true, (ThreadData) data);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.V != null) {
                FrsTabViewController.p C = this.a.V.C();
                if (C != null && (fragment = C.b) != null && (fragment instanceof bk6)) {
                    ((bk6) fragment).n1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    zg.a().postDelayed(this.a.S1, 500L);
                    return;
                }
                this.a.j1().X1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FrsFragment c;

        public w(FrsFragment frsFragment, int i, String str) {
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
    public class x implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.M && BdNetTypeUtil.isNetWorkAvailable() && !this.a.t.J0()) {
                this.a.t.a1();
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
                this.a.t0 = true;
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.V1();
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
                    if (this.a.S == null && this.a.t.m0() != null && !this.a.t.c0() && this.a.t.m0().j() != null && (this.a.t.m0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.S = (ThreadCardViewHolder) frsFragment.t.m0().j().getTag();
                    }
                    if (this.a.S != null && this.a.S.a() != null) {
                        this.a.S.a().o(new yy.a(3));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(FrsFragment frsFragment, int i) {
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
            this.a.t.Y().notifyDataSetChanged();
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
                this.a.t.X0();
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
        h2 = TbConfig.TIEBA_ADDRESS + "mo/q/forumtarget?fid=%1$s&fn=%2$s&nomenu=1";
        i2 = TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=%1$s&nomenu=1";
        j2 = false;
        k2 = null;
        m2 = 0L;
        n2 = 0L;
        o2 = 0;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.X0 == null) {
                this.X0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.X0.T(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            zg.a().postDelayed(this.J1, 300000L);
        }
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            iv4 iv4Var = new iv4(getPageContext().getPageActivity());
            iv4Var.setContentViewSize(2);
            iv4Var.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new k0(this, iv4Var));
            iv4Var.setContentView(frsBroadcastCopyGuideDialogView);
            iv4Var.create(getPageContext()).show();
        }
    }

    public final void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            v85.h().m(new s85(getContext()));
            v85.h().n(85, 0, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (v85.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new l0(this), true);
            }
        }
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            v85.h().m(new t85(getContext()));
            v85.h().n(85, 0, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (v85.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new m0(this), true);
            }
        }
    }

    public final boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (O0() == null) {
                return false;
            }
            FrsViewData O0 = O0();
            ts4 ts4Var = null;
            if (O0.getStar() != null && !StringUtils.isNull(O0.getStar().a())) {
                ts4Var = new ts4();
            } else if (O0.getActivityHeadData() != null && ListUtils.getCount(O0.getActivityHeadData().b()) >= 1) {
                ts4Var = O0.getActivityHeadData().b().get(0);
            }
            if (ts4Var == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (I3() != 1 && !this.f0.b(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.x0();
                } else {
                    this.t.S1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.P1();
            } else {
                this.t.L1();
            }
        }
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (I3() == 0 && ListUtils.isEmpty(this.x.getThreadListIds())) {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    this.t.x0();
                } else {
                    this.t.S1();
                }
            } else if (ListUtils.getCount(this.x.getThreadList()) > 3) {
                this.t.P1();
            } else {
                this.t.L1();
            }
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (this.x.getForum().getYuleData() != null && this.x.getForum().getYuleData().a()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                    this.t.N1(this.x.getForum().getYuleData().b());
                    return;
                }
                this.t.w0();
                return;
            }
            this.t.w0();
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (!b3() && this.x.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                x4(this.x.getPrivateForumTotalInfo().a().private_forum_audit_status, this.x.getPrivateForumTotalInfo().b(), false);
            } else {
                x4(null, null, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.p C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (E3() != null && (C = E3().C()) != null) {
                Fragment fragment = C.b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        int i3 = -1;
                        FrsViewData frsViewData = this.x;
                        if (frsViewData != null) {
                            i3 = frsViewData.getSortType();
                        }
                        tbPageTag.sortType = bv6.g(i3);
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

    public final void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(o3()) && !this.z0) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    O4();
                    return;
                } else if (Build.VERSION.SDK_INT < 23 || !ky4.k().h("key_forum_rule_dialog_show_frs", false)) {
                    O4();
                    ky4.k().u("key_forum_rule_dialog_show_frs", true);
                    return;
                } else {
                    return;
                }
            }
            O4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            super.onPause();
            this.W.f(false);
            this.O = false;
            this.t.U0();
            nv6 nv6Var = this.U;
            if (nv6Var != null) {
                nv6Var.P();
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.N0(true);
            gv6 gv6Var = this.d0;
            if (gv6Var != null) {
                gv6Var.j();
            }
            km4.w().E();
            ru6 ru6Var = this.R0;
            if (ru6Var != null) {
                ru6Var.g();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            this.t.e0().stopScroll();
            if (this.t.g1()) {
                return;
            }
            if (!xi.F()) {
                this.t.x0();
            } else if (this.T.e0() == 1) {
                V4();
                b();
            } else if (this.T.hasMore()) {
                b();
            }
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
        this.P = true;
        this.R = new yy.a(2);
        this.a0 = new SparseArray<>();
        this.b0 = true;
        this.z0 = false;
        this.B0 = false;
        this.D0 = false;
        this.E0 = null;
        this.F0 = 0;
        this.G0 = 0;
        this.H0 = 0;
        this.L0 = -1;
        this.Q0 = -1;
        this.Y0 = false;
        this.Z0 = false;
        this.a1 = false;
        this.b1 = 0;
        this.d1 = new k(this);
        this.e1 = new v(this, 2016495);
        this.f1 = new e0(this, 2921005);
        this.g1 = new p0(this, 2921401);
        this.h1 = new a1(this, 2921473);
        this.i1 = new l1(this, 2921467);
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
        this.H1 = new z(this, 2016485);
        this.I1 = new a0(this, 2001194);
        this.J1 = new d0(this);
        this.K1 = new f0(this);
        this.L1 = new g0(this);
        this.M1 = new h0(this);
        this.N1 = new n0(this);
        this.O1 = new o0(this);
        this.P1 = new q0(this);
        this.Q1 = new r0(this);
        this.R1 = new s0(this);
        this.S1 = new t0(this);
        this.T1 = new u0(this, 0);
        this.U1 = new q1(this, null);
        this.V1 = new w0(this);
        this.W1 = new x0(this, 2921033);
        this.X1 = new y0(this, 2921381);
        this.Y1 = new z0(this, 2921414);
        this.Z1 = new b1(this, 2921437);
        this.a2 = new g1(this, 2921462);
        this.b2 = new h1(this, 2001223);
        this.c2 = new i1(this, 2921469);
        this.d2 = new j1(this, 2921475);
        this.e2 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.f2 = new m1(this, 2921515);
    }

    public void A4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.P = z2;
        }
    }

    public void B4(boolean z2) {
        pv6 pv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) && (pv6Var = this.g0) != null) {
            pv6Var.b0();
        }
    }

    public void D4(boolean z2) {
        gk6 gk6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && (gk6Var = this.Z) != null) {
            gk6Var.i(z2);
        }
    }

    public void E4(int i3) {
        qr6 qr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i3) != null) || (qr6Var = this.f0) == null) {
            return;
        }
        qr6Var.o(i3);
    }

    public void F4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z2) != null) || this.g2 != null) {
            return;
        }
        tw6 a2 = tw6.a(z2);
        this.g2 = a2;
        qr6 qr6Var = this.f0;
        if (qr6Var != null) {
            qr6Var.m(a2);
        }
    }

    public void H4(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public void I4(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, linearLayout) != null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public void J4(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, fRSRefreshButton) != null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    @Override // com.baidu.tieba.oo5
    public void M(mo5 mo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, mo5Var) == null) {
            this.j0.a(mo5Var);
        }
    }

    @Override // com.baidu.tieba.oo5
    public no5 P0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i3)) == null) {
            return this.a0.get(i3);
        }
        return (no5) invokeI.objValue;
    }

    public final void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            B4("frs_page".equals(str));
            ln6 ln6Var = this.c0;
            if (ln6Var != null) {
                ln6Var.c(this.U, this.t, this.x);
            }
        }
    }

    public void X3(Object obj) {
        pr6 pr6Var;
        q9 q9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, obj) == null) && (pr6Var = this.Y) != null && (q9Var = pr6Var.j) != null) {
            q9Var.c(obj);
        }
    }

    public void Y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) {
            cn8.g().h(getUniqueId(), z2);
        }
    }

    public void a5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i(this.t.p0());
        }
    }

    public void f5(Object obj) {
        pr6 pr6Var;
        q9 q9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, obj) == null) && (pr6Var = this.Y) != null && (q9Var = pr6Var.i) != null) {
            q9Var.c(obj);
        }
    }

    public void g4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i3) == null) {
            this.M = false;
            d5();
            aj6 aj6Var = this.t;
            if (aj6Var != null && aj6Var.m0() != null) {
                this.t.m0().y();
            }
            FrsModelController frsModelController = this.T;
            if (frsModelController != null) {
                frsModelController.J0(i3, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, view2) == null) {
            this.t.o1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view2);
            ((FrsActivity) getActivity()).f1(view2, false);
            this.t.h0().f(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.t.o1(0);
            this.t.h0().f(false);
        }
    }

    public void n4(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) && (frsTabViewController = this.V) != null) {
            frsTabViewController.v = z2;
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            V4();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public void p4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z2) == null) {
            this.e = z2;
        }
    }

    public void q4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i3) == null) {
            this.c1 = i3;
            if (i3 == 13) {
                this.t.m1("frs_hot_tab");
            }
            if (i3 == 14) {
                this.t.m1("frs_new_tab");
            }
        }
    }

    public void r4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i3) == null) {
            this.h = i3;
        }
    }

    public void s4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, str) == null) {
            this.f = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, str) == null) {
            this.g = str;
        }
    }

    public void t4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            this.T0 = z2;
        }
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            this.U0 = z2;
        }
    }

    public void v4(hl6 hl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, hl6Var) == null) {
            this.S0 = hl6Var;
        }
    }

    public void w4(int i3) {
        qr6 qr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048740, this, i3) != null) || (qr6Var = this.f0) == null) {
            return;
        }
        qr6Var.n(i3);
    }

    public void y4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) {
            this.Y0 = z2;
            this.Z0 = z2;
        }
    }

    public void z4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z2) == null) {
            this.a1 = z2;
        }
    }

    @Override // com.baidu.tieba.oo5
    public void o0(int i3, no5 no5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048693, this, i3, no5Var) == null) {
            this.a0.put(i3, no5Var);
        }
    }

    public void R4(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, str, str2, str3) == null) {
            ru6 ru6Var = new ru6(str, str2);
            this.R0 = ru6Var;
            ru6Var.o(getFragmentActivity(), str3, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048697, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            or6 or6Var = this.h0;
            if (or6Var != null) {
                or6Var.n(i3, i4, intent);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048708, this, i3, strArr, iArr) == null) {
            dv6.i(this, i3, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048729, this, view2, str, z2) == null) {
            super.showNetRefreshViewNoClick(view2, str, z2);
            this.t.o1(8);
        }
    }

    public int A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qr6 qr6Var = this.f0;
            if (qr6Var == null) {
                return 1;
            }
            return qr6Var.g();
        }
        return invokeV.intValue;
    }

    public View C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public final AbsDataRecorder.Scene D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i3 = this.c1;
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

    public FrsTabViewController E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.V;
        }
        return (FrsTabViewController) invokeV.objValue;
    }

    public String G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final void G4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (frsViewData = this.x) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.Y().setFromCDN(true);
        } else {
            this.t.Y().setFromCDN(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ng) invokeV.objValue;
    }

    public OvalActionButton H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.u;
        }
        return (OvalActionButton) invokeV.objValue;
    }

    public int I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            qr6 qr6Var = this.f0;
            if (qr6Var == null) {
                return -1;
            }
            return qr6Var.h();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zr6
    public FrsModelController J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.T;
        }
        return (FrsModelController) invokeV.objValue;
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            xi.z(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    public void K3() {
        nv6 nv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (nv6Var = this.U) != null) {
            nv6Var.E();
        }
    }

    @Override // com.baidu.tieba.ck6
    public NavigationBar L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            aj6 aj6Var = this.t;
            if (aj6Var == null) {
                return null;
            }
            return aj6Var.i0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void L3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.b();
        }
    }

    @Override // com.baidu.tieba.nr6
    public FrsViewData O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.x;
        }
        return (FrsViewData) invokeV.objValue;
    }

    public boolean P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public void Q4() {
        aj6 aj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (aj6Var = this.t) != null) {
            aj6Var.K1();
        }
    }

    public boolean R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.T0;
        }
        return invokeV.booleanValue;
    }

    public boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.U0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sf8
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public boolean U3() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            FrsModelController frsModelController = this.T;
            if (frsModelController != null) {
                W2(frsModelController.c0());
            } else {
                W2("normal_page");
            }
        }
    }

    public boolean V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (O0() == null) {
                return false;
            }
            FrsViewData O0 = O0();
            if (ListUtils.isEmpty(O0.getShowTopThreadList()) && O0.getBusinessPromot() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zj6
    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && isAdded() && this.b0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.p0());
        }
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return Z2(this.n1);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zr6
    public qr6 Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.f0;
        }
        return (qr6) invokeV.objValue;
    }

    public boolean Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (T3() && !V3()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z4() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (fRSRefreshButton = this.v) != null) {
            fRSRefreshButton.f();
        }
    }

    @Override // com.baidu.tieba.zr6
    public void b() {
        qr6 qr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (qr6Var = this.f0) != null) {
            qr6Var.i(this.f, this.l, this.x);
        }
    }

    @Override // com.baidu.tieba.zj6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.sf8
    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            qr6 qr6Var = this.f0;
            if (qr6Var == null) {
                return 1;
            }
            return qr6Var.g();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nr6, com.baidu.tieba.fk6
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void c3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (getActivity() == null) {
                intent = null;
            } else {
                intent = getActivity().getIntent();
            }
            dv6.a(getPageContext(), intent, this.g);
        }
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && !wi.isEmpty(this.l)) {
            km4.w().O(jm4.a0, wg.g(this.l, 0L));
        }
    }

    public void d5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && (voiceManager = this.r) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            if (this.h == 1) {
                ch.a().b(new j0(this));
            }
            this.h = 0;
        }
    }

    public void e5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048662, this) != null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.nr6
    public /* bridge */ /* synthetic */ r9 getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tieba.zr6
    public aj6 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.t;
        }
        return (aj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fk6
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            this.t.X1();
        }
    }

    public void k4() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && (frsModelController = this.T) != null && frsModelController.e0() == 1) {
            this.U.a0(this.x);
        }
    }

    @Override // com.baidu.tieba.sf8
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            J0().V0();
        }
    }

    public ln6 l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.c0;
        }
        return (ln6) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            if (this.i0 == null) {
                this.i0 = new kr6(this, wg.e(this.l, 0));
            }
            this.i0.w();
        }
    }

    @Override // com.baidu.tieba.zr6
    public nv6 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.U;
        }
        return (nv6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf8
    public TbPageContext<?> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public String o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public void o4() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.p C;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (frsTabViewController = this.V) != null && (C = frsTabViewController.C()) != null && (fragment = C.b) != null && (fragment instanceof bk6)) {
            ((bk6) fragment).n1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ao onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return y3().getPreLoadHandle();
        }
        return (ao) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            super.onStart();
            VoiceManager s02 = s0();
            this.r = s02;
            if (s02 != null) {
                s02.onStart(getPageContext());
            }
        }
    }

    public go p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.U1;
        }
        return (go) invokeV.objValue;
    }

    public int r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return dv6.c(this.x, this.t);
        }
        return invokeV.intValue;
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            xp5.c().f("page_frs");
            g4(3);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            if (this.r == null) {
                this.r = VoiceManager.instance();
            }
            return this.r;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public rr6 s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.e0;
        }
        return (rr6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zj6
    public void t() {
        aj6 aj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048730, this) == null) && (aj6Var = this.t) != null) {
            aj6Var.e0().scrollToPosition(0);
            this.t.X1();
        }
    }

    public kt6 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.X;
        }
        return (kt6) invokeV.objValue;
    }

    public boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return this.Y0;
        }
        return invokeV.booleanValue;
    }

    public boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.a1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return tj5.a(2);
        }
        return invokeV.booleanValue;
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return this.t.c0();
        }
        return invokeV.booleanValue;
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            return this.Z0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zj6
    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && isAdded() && this.b0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.p0(), true);
        }
    }

    public BdTypeRecyclerView y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            aj6 aj6Var = this.t;
            if (aj6Var == null) {
                return null;
            }
            return aj6Var.e0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public gk6 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.Z;
        }
        return (gk6) invokeV.objValue;
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.x == null) {
            return;
        }
        qt6 qt6Var = new qt6();
        if (this.x.needLog == 1) {
            qt6Var.a = true;
        } else {
            qt6Var.a = false;
        }
        if (this.x.getForum() != null) {
            qt6Var.c = this.x.getForum().getId();
            qt6Var.d = this.x.getForum().getName();
        }
        if (J0() != null) {
            qt6Var.b = J0().U();
        }
        qt6 qt6Var2 = st6.p0;
        if (qt6Var2 != null) {
            qt6Var.e = qt6Var2.e;
            qt6Var.f = qt6Var2.f;
        }
        lr6 lr6Var = new lr6(qt6Var, getTbPageTag(), getUniqueId());
        this.M0 = lr6Var;
        lr6Var.d(this.P0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.M0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.M0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.M0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.M0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public final FrsTabInfoData F3() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.T == null || (frsViewData = this.x) == null || this.V == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.x.getEntelechyTabInfo().a) || (G = this.V.G()) == 502) {
                return null;
            }
            int i3 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.x.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.x.getUserData() == null || this.x.getUserData().isForumBusinessAccount())) {
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
            if (this.x.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.x.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public final void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            d5();
            try {
                if (this.x == null) {
                    return;
                }
                this.t.O1();
                this.t.W1(Y2());
                if (this.x.getForum() != null) {
                    this.f = this.x.getForum().getName();
                    this.l = this.x.getForum().getId();
                }
                if (this.x.getPage() != null) {
                    w4(this.x.getPage().b());
                }
                this.t.I1(this.f);
                this.t.n1(this.f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.x.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.x.getUserData().getDynamicUrl());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.x.getUserData().getBimg_end_time());
                e4();
                G4();
                ArrayList<wn> threadList = this.x.getThreadList();
                if (threadList != null) {
                    this.t.H1(threadList, this.x);
                    ou6.b(this.t);
                    this.U.q0(b1());
                    this.x.setFrsFragmentTag(getUniqueId());
                    this.U.W(this.x);
                    this.V.d(this.x, this.T.U());
                    this.t.i1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            super.onResume();
            int i3 = this.b1;
            if (i3 <= 1) {
                this.b1 = i3 + 1;
            }
            aj6 aj6Var = this.t;
            if (aj6Var != null) {
                aj6Var.M0();
                this.t.W0();
            }
            nv6 nv6Var = this.U;
            if (nv6Var != null) {
                nv6Var.R();
            }
            if (this.b1 > 1 && v3()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                z4(false);
            }
            this.W.f(true);
            this.O = true;
            if (j2) {
                j2 = false;
                aj6 aj6Var2 = this.t;
                if (aj6Var2 != null) {
                    aj6Var2.X1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            aj6 aj6Var3 = this.t;
            if (aj6Var3 != null) {
                aj6Var3.N0(false);
            }
            if (this.t0) {
                g4(6);
                this.t0 = false;
            }
            if (this.E0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    k35.c().h(true, this.E0.getHours(), this.E0.getMinutes());
                    if (this.t != null) {
                        k35.c().j(o().getPageActivity(), this.t.p0());
                    }
                }
                this.E0 = null;
            }
            c5();
        }
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                FrsViewData frsViewData = this.x;
                if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.x.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
            }
        }
    }

    public final void W3() {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048631, this) != null) || !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
        ws6.a(param);
        ws6.b(param, k(), c());
        TiebaStatic.log(param);
        StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", this.J);
        if (this.J > 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        TiebaStatic.log(param2.param("obj_type", i3).param("obj_source", 2));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
    }

    public final void a4() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (frsViewData = this.x) != null && frsViewData.getForum() != null) {
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

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(o3()) && !this.z0) {
            int l3 = ky4.k().l("key_forum_broadcast_edit_tip_number", 0);
            if (l3 < 2) {
                ky4.k().w("key_forum_broadcast_edit_tip_number", l3 + 1);
                M4();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    N4();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(getContext());
                bdTopToast.h(false);
                bdTopToast.g(getContext().getString(R.string.obfuscated_res_0x7f0f067e));
                bdTopToast.i(this.t.p0());
            } else {
                N4();
            }
        }
    }

    public ForumWriteData n3() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
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
                    i3 = userData.getPrivateThread();
                } else {
                    i3 = 0;
                }
                forumWriteData.privateThread = i3;
                forumWriteData.frsTabInfo = F3();
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
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onStop();
            s36.b().e(false);
            Y3(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                u55.j().x(getPageContext().getPageActivity(), "frs", this.x.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (y3() != null) {
                y3().getRecycledViewPool().clear();
            }
            this.U.N();
            cj5.c();
        }
    }

    public boolean L4(pn8 pn8Var, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, pn8Var, tbPageContext)) == null) {
            if (u3()) {
                return false;
            }
            if (pn8Var != null && pn8Var.getEntelechyTabInfo() != null && pn8Var.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : pn8Var.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && ky4.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            if (pn8Var != null && pn8Var.getBusinessPromot() != null && !StringUtils.isNull(pn8Var.getBusinessPromot().q()) && pn8Var.getForum() != null) {
                boolean j3 = tu6.j(pn8Var.getBusinessPromot(), pn8Var.getForum().getId());
                this.U0 = j3;
                y4(j3);
                return this.U0;
            }
            hl6 hl6Var = new hl6(tbPageContext);
            this.S0 = hl6Var;
            boolean j4 = hl6Var.j(pn8Var);
            this.T0 = j4;
            y4(j4);
            return this.T0;
        }
        return invokeLL.booleanValue;
    }

    public final void M3() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && isResumed() && (list = this.I0) != null && list.size() >= 1 && this.H0 <= this.I0.size() - 1) {
            LiveHorseRaceData liveHorseRaceData = this.I0.get(this.H0);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.H0++;
                M3();
            }
            if (this.w != null) {
                FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    if (liveHorseRaceData.getUser_nickname().length() > 4) {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a3f), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                    } else {
                        format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a3f), liveHorseRaceData.getUser_nickname());
                    }
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a3f), getResources().getString(R.string.obfuscated_res_0x7f0f0731));
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new c1(this, liveHorseRaceData));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.J0 = ofFloat;
                ofFloat.setDuration(600L);
                this.J0.addUpdateListener(new d1(this, frsRedpackRunView));
                this.J0.addListener(new e1(this, frsRedpackRunView));
                this.K0 = new f1(this, frsRedpackRunView);
                zg.a().postDelayed(this.K0, 5000L);
                if (this.w.getChildCount() == 0) {
                    this.H0++;
                    this.w.addView(frsRedpackRunView);
                    FrsViewData frsViewData = this.x;
                    String str = "";
                    if (frsViewData != null && frsViewData.getForum() != null) {
                        str = this.x.getForum().getName();
                    }
                    TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.l).param("fname", str));
                }
                LinearLayout linearLayout = this.w;
                if (linearLayout != null && linearLayout.getVisibility() == 8 && ((BaseFragment) this.V.C().b).isPrimary() && !this.t.K0() && !this.I) {
                    this.w.setVisibility(0);
                }
            }
        }
    }

    public final void N3(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
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
            this.U.L(bundle);
            h3(j3);
        }
    }

    public final void S4(int i3) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i3) == null) && TbadkCoreApplication.isLogin() && (frsViewData = this.x) != null && (list = frsViewData.mWindowToast) != null && list.size() > 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                WindowToast windowToast = list.get(i4);
                if (windowToast != null && windowToast.toast_type.intValue() == i3) {
                    if (!wi.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", xj5.a(windowToast.toast_link), true)));
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void T4(hn8 hn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, hn8Var) == null) {
            if (hn8Var == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
                this.t.Z0();
                showNetRefreshView(this.t.p0(), string, true);
            } else if (340001 == hn8Var.c) {
                Y4(hn8Var, this.x.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.x.getThreadList())) {
                    X4(hn8Var);
                }
                if (Q3()) {
                    setNetRefreshViewEmotionMarginTop(xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070292));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public final void e3(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048660, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<wn> threadList = this.x.getThreadList();
        if (!ListUtils.isEmpty(threadList) && this.t.e0() != null && this.t.e0().getData() != null) {
            Iterator<wn> it = threadList.iterator();
            List<wn> data = this.t.e0().getData();
            int i3 = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof vu4) {
                    ThreadData threadData = ((vu4) next).t;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list.size()) {
                            break;
                        } else if (StringHelper.equals(list.get(i4), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.f0.j(next);
                            this.t.e0().getAdapter().notifyItemRemoved(i3);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                i3++;
            }
        }
    }

    public final void j4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i3) == null) {
            i4();
            d5();
            try {
                if (this.x == null) {
                    return;
                }
                kk6 kk6Var = null;
                this.t.H1(null, this.x);
                this.U.q0(1);
                this.t.i1();
                this.V.d(this.x, this.T.U());
                xt6 K = this.V.K(this.x.getFrsDefaultTabId());
                if (K != null && !TextUtils.isEmpty(K.d)) {
                    kk6Var = new kk6();
                    String str = K.d;
                    String str2 = K.a;
                }
                this.T.t(this.x.getFrsDefaultTabId(), 0, kk6Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i3) == null) {
            super.onChangeSkinType(i3);
            if (this.C0) {
                this.t.R0(i3);
                this.U.O(i3);
                this.V.X(i3);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i3);
                }
                uv6 uv6Var = this.r0;
                if (uv6Var != null) {
                    uv6Var.onChangeSkinType();
                }
                tl6 tl6Var = this.x0;
                if (tl6Var != null) {
                    tl6Var.d(getPageContext(), i3);
                }
                if (this.y0 != null) {
                    if5.a(getPageContext(), this.y0.getRealView());
                }
                kv6 kv6Var = this.s0;
                if (kv6Var != null) {
                    kv6Var.onChangeSkinType(getPageContext(), i3);
                }
                hl6 hl6Var = this.S0;
                if (hl6Var != null) {
                    hl6Var.onChangeSkinType(getPageContext(), i3);
                }
            }
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.h == 0) {
                this.t.I1(this.f);
            } else {
                this.t.I1("");
                this.h = 1;
            }
            this.t.E1(this.U1);
            this.t.L(this.P1);
            this.t.F1(this.R1);
            this.t.Y().l(this.Q1);
        }
    }

    public void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            hideLoadingView(this.t.p0());
            this.t.Z1();
            if (this.t.o0() instanceof wt6) {
                ((wt6) this.t.o0()).d();
            }
        }
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048704, this) == null) && Q3()) {
            showLoadingView(this.t.p0(), true);
            this.t.D1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.T.J0(3, true);
            y3().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048705, this) != null) || !xi.F()) {
            return;
        }
        hideNetRefreshView(this.t.Z().m());
        showLoadingView(this.t.p0(), true);
        this.t.y0(false);
        this.T.J0(3, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                nv6 nv6Var = this.U;
                if (nv6Var != null) {
                    nv6Var.Q(isPrimary());
                }
                aj6 aj6Var = this.t;
                if (aj6Var != null) {
                    aj6Var.V0(isPrimary());
                    this.t.N0(!isPrimary());
                }
            }
        }
    }

    public int q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.Q0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.Q0;
        }
        return invokeV.intValue;
    }

    public void P4(View view2, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{view2, str, Boolean.valueOf(z2), list}) == null) {
            this.t.Z0();
            this.t.o1(8);
            if (this.r0 == null) {
                this.r0 = new uv6(getPageContext(), getNetRefreshListener());
            }
            this.r0.c(str);
            this.r0.b(list);
            this.r0.attachView(view2, z2);
        }
    }

    public final void U2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && (frsModelController = this.T) != null && this.x != null && this.t != null && z2) {
            if (!frsModelController.w0() && this.T.e0() == 1) {
                if (!this.T.t0()) {
                    this.x.addCardVideoInfoToThreadList();
                    this.x.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z4 = false;
                if (this.t.Y().k(s46.g)) {
                    z4 = this.x.addHotTopicDataToThreadList();
                }
                if (!z4) {
                    this.x.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && ((i3 = this.x.adShowSelect) == 1 || i3 == 3)) {
                    if (this.c1 == 14) {
                        this.x.frsCurrentTabId = 503;
                    } else {
                        this.x.frsCurrentTabId = 1;
                    }
                    this.x.addRecommendAppToThreadList(this);
                }
                if (!this.t.Y().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                    this.x.removeAlaLiveThreadData();
                }
                this.x.addSchoolRecommendToThreadList();
            }
            if (!this.t.Y().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                this.x.removeAlaInsertLiveData();
                this.x.removeAlaStageLiveDat();
            } else {
                this.x.addInsertLiveDataToThreadList();
                this.x.addStageLiveDataToThreadList();
            }
            this.x.checkLiveStageInThreadList();
            this.x.addNoticeThreadToThreadList();
            if (this.t.Y().k(dx6.e)) {
                this.x.addGameRankListToThreadList(z3);
            }
            if (TbadkCoreApplication.isLogin() && (!this.T.w0() || this.T.isNetFirstLoad)) {
                this.x.addUserRecommendToThreadList();
            }
            this.x.addVideoActivityToTop();
        }
    }

    public final void X4(hn8 hn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, hn8Var) == null) {
            this.t.Z0();
            if (hn8Var.a) {
                showNetRefreshView(this.t.p0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c7e, new Object[]{hn8Var.d, Integer.valueOf(hn8Var.c)}), true);
            } else {
                showNetRefreshView(this.t.Z().m(), hn8Var.d, true);
            }
        }
    }

    public final void g3(int i3) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i3) == null) {
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                str = this.x.getForum().getId();
            } else {
                str = "";
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", str).param("obj_type", "4").param("obj_locate", i3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void h3(long j3) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048672, this, j3) == null) && j3 > 0) {
            int l3 = xi.l(TbadkCoreApplication.getInst());
            int j4 = xi.j(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            zg.a().postDelayed(new i0(this, j3, l3, j4, f2, i3), 1000L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f);
            bundle.putString("from", this.g);
            this.T.H0(bundle);
            if (this.r != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                this.r.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void Y4(hn8 hn8Var, List<RecmForumInfo> list) {
        aj6 aj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048638, this, hn8Var, list) == null) && (aj6Var = this.t) != null) {
            aj6Var.Z0();
            this.t.I1(this.f);
            if (this.t.Z() != null) {
                P4(this.t.p0(), hn8Var.d, true, list);
            }
            this.t.h0().f(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048727, this, view2, z2) == null) {
            this.t.o1(8);
            ((FrsActivity) getActivity()).showLoadingView(view2, z2);
            ((FrsActivity) getActivity()).f1(view2, true);
            this.t.h0().f(true);
        }
    }

    public boolean Z2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i3)) == null) {
            if (!this.P || this.D0 || !a3(i3)) {
                return false;
            }
            FrsModelController frsModelController = this.T;
            if (frsModelController != null && frsModelController.X() && (li6.f().i() || ki6.h().j())) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void c4(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048655, this, intent) != null) || intent == null) {
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

    public void d4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048658, this, str) == null) && TbadkCoreApplication.isLogin() && !wi.isEmpty(str)) {
            if (this.A0 == null) {
                this.A0 = new AddExperiencedModel(o());
            }
            this.A0.D(this.l, str);
        }
    }

    public final void l4(pn8 pn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, pn8Var) == null) {
            try {
                if (!this.M && pn8Var != null && this.x != null) {
                    this.x.receiveData(pn8Var);
                    f4(true, false);
                    Looper.myQueue().addIdleHandler(this.d1);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, bundle) == null) {
            super.onCreate(bundle);
            cn8.g().i(getUniqueId());
            if (this.O0 == null) {
                this.O0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.O0);
            registerResponsedEventListener(TopToastEvent.class, this.A1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.V;
            if (frsTabViewController != null && frsTabViewController.C() != null && (this.V.C().b instanceof BaseFragment)) {
                ((BaseFragment) this.V.C().b).setPrimary(z2);
            }
        }
    }

    public boolean b4(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048650, this, i3, keyEvent)) == null) {
            if (i3 == 4) {
                if (li6.f().i()) {
                    li6.f().m();
                    return true;
                } else if (ki6.h().j()) {
                    aj6 aj6Var = this.t;
                    if (aj6Var != null && aj6Var.I0()) {
                        this.t.f1();
                        return true;
                    }
                    ki6.h().n();
                    return true;
                } else {
                    aj6 aj6Var2 = this.t;
                    if (aj6Var2 != null) {
                        return aj6Var2.T0();
                    }
                    return false;
                }
            } else if (i3 == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                return false;
            } else {
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048663, this, errorData) != null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        U4();
        this.t.M0();
        hn8 V = this.T.V();
        boolean isEmpty = ListUtils.isEmpty(this.x.getThreadList());
        if (V != null && isEmpty) {
            if (this.T.Y() != 0) {
                this.T.S0();
                this.t.M0();
            } else {
                T4(V);
            }
            this.t.q1(this.x.isStarForum(), false);
            return;
        }
        T4(V);
    }

    public final void m3(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048687, this, intent) != null) || intent == null) {
            return;
        }
        if (!av6.a(this, c(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
                BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.K1);
            } else {
                uu6 b2 = dv6.b(intent);
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

    public final void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && !ListUtils.isEmpty(ki6.h().i()) && this.t.e0() != null && this.t.e0().getData() != null) {
            ArrayList<wn> threadList = this.x.getThreadList();
            if (ListUtils.isEmpty(threadList)) {
                return;
            }
            Iterator<wn> it = threadList.iterator();
            List<wn> data = this.t.e0().getData();
            int count = ListUtils.getCount(ki6.h().i());
            int i3 = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if (next instanceof vu4) {
                    ThreadData threadData = ((vu4) next).t;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= count) {
                            break;
                        } else if (StringHelper.equals(ki6.h().i().get(i4).getId(), threadData.getId())) {
                            it.remove();
                            data.remove(next);
                            this.f0.j(next);
                            this.t.e0().getAdapter().notifyItemRemoved(i3);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                i3++;
            }
        }
    }

    public boolean i4() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            nv6 nv6Var = this.U;
            if (nv6Var != null && (frsModelController = this.T) != null) {
                nv6Var.v0(frsModelController.c0(), this.x);
            }
            boolean z2 = false;
            FrsViewData frsViewData2 = this.x;
            if (frsViewData2 != null) {
                z2 = frsViewData2.hasTab();
            }
            V2();
            aj6 aj6Var = this.t;
            if (aj6Var != null) {
                aj6Var.B0();
                this.t.C0();
                FrsViewData frsViewData3 = this.x;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    this.U0 = tu6.j(this.x.getBusinessPromot(), this.x.getForum().getId());
                }
                if (!this.U0 && (frsViewData = this.x) != null && frsViewData.getActivityHeadData() != null) {
                    this.t.A0(this.x.getActivityHeadData().a());
                    if (this.x.getActivityHeadData().a() != null && !this.T0 && !this.U0 && !this.V0 && !u3()) {
                        Q4();
                    }
                } else {
                    this.t.A0(null);
                }
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public final void f4(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.x != null && this.V != null && this.T != null) {
                    if (!this.t.Y().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.x.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.x.getGameTabInfo());
                    this.t.t1(isEmpty);
                    if (!isEmpty) {
                        if (this.s0 == null) {
                            this.s0 = new kv6(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.u0 == null) {
                            this.u0 = new tp6(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.s0 = null;
                        this.u0 = null;
                    }
                    if (this.x.getForum() != null) {
                        this.f = this.x.getForum().getName();
                        this.l = this.x.getForum().getId();
                    }
                    if (this.x.hasTab()) {
                        this.V.d(this.x, this.T.U());
                    }
                    if (z2) {
                        U2(true, z2);
                    } else {
                        U2(this.O, z2);
                    }
                    i4();
                    if (this.c0 != null) {
                        this.c0.a(this.U, this.x);
                    }
                    if (this.x.getPage() != null) {
                        w4(this.x.getPage().b());
                    }
                    ArrayList<wn> d2 = this.f0.d(z3, true, this.x.getThreadList(), null, z2, false, this.x.adShowSelect, this.x.adMixFloor);
                    if (d2 != null) {
                        this.x.setThreadList(d2);
                    }
                    this.x.removeRedundantUserRecommendData();
                    int topThreadSize = this.x.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        mu6.a(this, this.x.getForum(), this.x.getThreadList(), this.n, A3());
                    }
                    if (this.T.e0() == 1) {
                        h4();
                        if (!z2 && this.T.getPn() == 1) {
                            m4();
                        }
                    }
                    if (this.d0 != null) {
                        this.d0.k(this.V.H());
                    }
                    U4();
                    this.t.h1();
                    this.t.q1(true, false);
                    if (z2 && this.x.isFirstTabEqualAllThread()) {
                        zg.a().post(new x(this));
                    }
                    if (this.x.getForum() != null) {
                        this.t.P(this.x.getForum().getWarningMsg());
                    }
                    if (this.x != null && this.x.getFrsVideoActivityData() != null && ky4.k().m("frs_video_activity_guide", 0L) == 0) {
                        zg.a().postDelayed(new y(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.J1();
                    a4();
                    this.x0.e(this.x.bottomMenuList, this.x.getForum());
                    c5();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void g(ArrayList<wn> arrayList) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            w4(!isEmpty ? 1 : 0);
            V4();
            if (isEmpty) {
                return;
            }
            if (hq5.k().l(D3())) {
                hq5.k().g(D3()).b();
            }
            if (zq5.i().o(D3())) {
                zq5.i().g(D3()).b();
            }
            if (!this.T.w0() && TbadkCoreApplication.getInst().isRecAppExist() && this.T.e0() == 1 && ((i3 = this.x.adShowSelect) == 1 || i3 == 3)) {
                this.x.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.T != null) {
                pt6.i(getUniqueId(), arrayList, this.x.getForum(), this.T.d0());
            }
            qr6 qr6Var = this.f0;
            ro8 ro8Var = this.o;
            FrsViewData frsViewData = this.x;
            ArrayList<wn> c2 = qr6Var.c(false, false, arrayList, ro8Var, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c2 != null) {
                this.x.setThreadList(c2);
                this.t.H1(c2, this.x);
            }
            FrsModelController frsModelController = this.T;
            if (frsModelController != null) {
                rt6.m(this.x, frsModelController.U(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.x.getForum()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.A = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.A = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                m3(intent);
            }
            this.D = currentTimeMillis - this.A;
            this.o = new ro8("frs", ro8.c);
            if (this.T == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.G1);
                this.T = frsModelController;
                frsModelController.w(this.l1);
                this.T.init();
            }
            this.T.T0(this.y);
            ArrayList<wn> arrayList = null;
            if (intent != null) {
                this.T.m0(intent.getExtras());
            } else if (bundle != null) {
                this.T.m0(bundle);
            } else {
                this.T.m0(null);
            }
            if (intent != null) {
                this.U.L(intent.getExtras());
            } else if (bundle != null) {
                this.U.L(bundle);
            } else {
                this.U.L(null);
            }
            this.r = s0();
            this.j0 = new zi6(getPageContext(), this);
            O3();
            N3(bundle);
            if (!Q3()) {
                gk6 gk6Var = new gk6(getActivity(), this.t, this.U);
                this.Z = gk6Var;
                gk6Var.i(true);
            }
            VoiceManager s02 = s0();
            this.r = s02;
            if (s02 != null) {
                s02.onCreate(getPageContext());
            }
            i3();
            j3();
            if (v85.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new wr6();
            int i3 = -1;
            qr6 qr6Var = this.f0;
            if (qr6Var != null && qr6Var.f() != null) {
                i3 = this.f0.f().D();
                arrayList = this.f0.f().C();
            }
            qr6 qr6Var2 = new qr6(this, this.L1);
            this.f0 = qr6Var2;
            qr6Var2.f().setHasMore(i3);
            if (arrayList != null && arrayList.size() > 0) {
                this.f0.f().N(arrayList);
            }
            this.X = new kt6(this);
            this.g0 = new pv6(this);
            this.d0 = new gv6(getPageContext(), this.T.r0());
            this.Y = new pr6(this);
            this.e0 = new rr6(this);
            this.W = new vr6(this);
            this.h0 = new or6(this);
            this.q0 = new iv6(this);
            new sr6(this, getUniqueId());
            this.v0 = new ap5(getPageContext(), "frs");
            this.w0 = new xu5(getPageContext());
            new ot6(getPageContext());
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
            registerListener(this.W1);
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
            this.X1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.j1);
            registerListener(this.b2);
            registerListener(this.z1);
            registerListener(this.i1);
            registerListener(this.c2);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.E1);
            registerListener(this.F1);
            this.t.y0(false);
            if (!Q3() && !this.z0) {
                showLoadingView(this.t.p0(), true);
                this.T.S(3, false);
            }
            B3();
            ow6.a();
            b0 b0Var = new b0(this);
            li6.f().s(b0Var);
            ki6.h().s(b0Var);
            this.t.C1(new c0(this));
            this.F0 = UtilHelper.getScreenHeight(getActivity());
            this.z0 = true;
            g3(1);
            super.onActivityCreated(bundle);
            this.E = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048700, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view2 = this.s;
            if (view2 == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f2, viewGroup, false);
                am6 am6Var = new am6();
                this.b = am6Var;
                this.c0 = am6Var.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0776);
                this.U = new nv6(this, this.b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090d84));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.O1);
                this.V = frsTabViewController;
                frsTabViewController.c0();
                this.U.s0(this.V);
                this.V.g0(this.m1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.d = true;
                }
                this.t = new aj6(this, this.O1, this.b, this.d, this.U);
                this.x0 = new tl6(getPageContext(), this.s);
            } else {
                if (view2.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.V;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.c0();
                }
                this.t.b1();
                this.s.setLeft(0);
                this.s.setRight(xi.l(TbadkCoreApplication.getInst().getContext()));
            }
            this.C0 = true;
            this.F = System.currentTimeMillis() - currentTimeMillis;
            return this.s;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            cn8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.x1);
            unRegisterResponsedEventListener();
            this.g0.Z();
            l2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            gh8.c("FRS");
            this.r = null;
            s36.b().e(false);
            FrsViewData frsViewData = this.x;
            if (frsViewData != null && frsViewData.getForum() != null) {
                sj6.a().b(wg.g(this.x.getForum().getId(), 0L));
            }
            kr6 kr6Var = this.i0;
            if (kr6Var != null) {
                kr6Var.v();
            }
            aj6 aj6Var = this.t;
            if (aj6Var != null) {
                cv6.b(aj6Var, this.x, k(), false, null);
                this.t.S0();
            }
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.w.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.J0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.K0 != null) {
                zg.a().removeCallbacks(this.K0);
            }
            if (this.J1 != null) {
                zg.a().removeCallbacks(this.J1);
            }
            this.I0 = null;
            li6.f().s(null);
            ki6.h().s(null);
            super.onDestroy();
            try {
                if (this.N != null) {
                    this.N.c();
                }
                if (this.t != null) {
                    this.t.e1();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.U.M();
            Looper.myQueue().removeIdleHandler(this.d1);
            FrsModelController frsModelController = this.T;
            if (frsModelController != null) {
                frsModelController.j();
            }
            gk6 gk6Var = this.Z;
            if (gk6Var != null) {
                gk6Var.d();
            }
            gv6 gv6Var = this.d0;
            if (gv6Var != null) {
                gv6Var.i();
            }
            kt6 kt6Var = this.X;
            if (kt6Var != null) {
                kt6Var.c();
            }
            kv6 kv6Var = this.s0;
            if (kv6Var != null) {
                kv6Var.g();
            }
            or6 or6Var = this.h0;
            if (or6Var != null) {
                or6Var.o();
            }
            ap5 ap5Var = this.v0;
            if (ap5Var != null) {
                ap5Var.h();
            }
            xu5 xu5Var = this.w0;
            if (xu5Var != null) {
                xu5Var.g();
            }
            eh8.e().g();
            FrsTabViewController frsTabViewController = this.V;
            if (frsTabViewController != null) {
                frsTabViewController.g0(null);
                this.V.P();
            }
            AddExperiencedModel addExperiencedModel = this.A0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            ru6 ru6Var = this.R0;
            if (ru6Var != null) {
                ru6Var.g();
            }
            if (this.O0 != null) {
                getLifecycle().removeObserver(this.O0);
            }
            zg.a().removeCallbacks(this.S1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048728, this, view2, str, z2) == null) {
            super.showNetRefreshView(view2, getResources().getString(R.string.obfuscated_res_0x7f0f1007), null, getResources().getString(R.string.obfuscated_res_0x7f0f1006), z2, getNetRefreshListener());
            this.t.o1(8);
            this.t.h0().f(true);
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public void x4(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048742, this, num, num2, z2) != null) || this.t.n0() == null) {
            return;
        }
        TextView n02 = this.t.n0();
        if (z2) {
            n02.setVisibility(8);
            return;
        }
        int i3 = 2;
        if (num.intValue() == 2) {
            n02.setText(getString(R.string.obfuscated_res_0x7f0f0285));
            n02.setVisibility(0);
            str = String.format(i2, this.l);
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            n02.setText(String.format(getString(R.string.obfuscated_res_0x7f0f03c5), num2));
            n02.setVisibility(0);
            str = String.format(h2, this.l, this.f);
            i3 = 1;
        } else {
            n02.setVisibility(8);
            str = "";
            i3 = 0;
        }
        n02.setOnClickListener(new w(this, i3, str));
    }
}
