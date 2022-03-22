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
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import c.a.o0.r.t.a;
import c.a.p0.l.f;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes5.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, c.a.p0.f1.g2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, c.a.p0.f1.u0, c.a.p0.l3.v, c.a.p0.f1.h2.l, c.a.p0.h.e.b, c.a.p0.f1.o0, c.a.p0.f1.r0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a2;
    public static c.a.p0.a4.n b2;
    public static volatile long c2;
    public static volatile long d2;
    public static volatile int e2;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.f.k.b<TbImageView> A;
    public boolean A0;
    public final c.a.p0.a4.u A1;
    public long B;
    public AddExperiencedModel B0;
    public final CustomMessageListener B1;
    public long C;
    public boolean C0;
    public final CustomMessageListener C1;
    public long D;
    public boolean D0;
    public final BdUniDispatchSchemeController.b D1;
    public long E;
    public boolean E0;
    public final c.a.p0.f1.h2.k E1;
    public long F;
    public Date F0;
    public final View.OnTouchListener F1;
    public long G;
    public int G0;
    public final CustomMessageListener G1;
    public long H;
    public int H0;
    public final View.OnClickListener H1;
    public long I;
    public int I0;
    public final View.OnClickListener I1;
    public boolean J;
    public List<LiveHorseRaceData> J0;
    public final RecyclerView.OnScrollListener J1;
    public int K;
    public ValueAnimator K0;
    public final c.a.p0.f1.f K1;
    public boolean L;
    public Runnable L0;
    public final NoNetworkView.b L1;
    public boolean M;
    public int M0;
    public final CustomMessageListener M1;
    public boolean N;
    public c.a.p0.f1.f2.b N0;
    public c.a.d.o.e.w N1;
    public c.a.o0.r0.b O;
    public c.a.p0.f1.m1.a O0;
    public c.a.p0.f1.t0 O1;
    public boolean P;
    @Nullable
    public TiePlusEventController P0;
    public CustomMessageListener P1;
    public boolean Q;
    public int Q0;
    public CustomMessageListener Q1;
    public String R;
    public int R0;
    public CustomMessageListener R1;
    public a.C0196a S;
    public c.a.p0.f1.r2.h S0;
    public CustomMessageListener S1;
    public ThreadCardViewHolder T;
    public c.a.p0.f1.i1.f T0;
    public CustomMessageListener T1;
    public FrsModelController U;
    public boolean U0;
    public CustomMessageListener U1;
    public c.a.p0.f1.s2.h V;
    public boolean V0;
    public CustomMessageListener V1;
    public FrsTabViewController W;
    public Object W0;
    public CustomMessageListener W1;
    public c.a.p0.f1.h2.h X;
    public MessageQueue.IdleHandler X0;
    public HttpMessageListener X1;
    public c.a.p0.f1.m2.a Y;
    public final CustomMessageListener Y0;
    public CustomMessageListener Y1;
    public c.a.p0.f1.h2.b Z;
    public CustomMessageListener Z0;
    public c.a.p0.h1.a Z1;
    public String a;
    public CustomMessageListener a1;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f1.p1.a f32260b;
    public CustomMessageListener b1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32261c;
    public CustomMessageListener c1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32262d;
    public c.a.d.c.g.a d1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32263e;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public String f32264f;
    public final c.a.p0.f1.t0 f1;

    /* renamed from: g  reason: collision with root package name */
    public String f32265g;
    public c.a.p0.f1.v0 g0;
    public FrsTabViewController.n g1;

    /* renamed from: h  reason: collision with root package name */
    public int f32266h;
    public SparseArray<c.a.p0.h.e.a> h0;
    public int h1;
    public boolean i;
    public boolean i0;
    public CustomMessageListener i1;
    public boolean j;
    public c.a.p0.f1.p1.e.b j0;
    public CustomMessageListener j1;
    public String k;
    public c.a.p0.f1.s2.a k0;
    public final CustomMessageListener k1;
    public String l;
    public c.a.p0.f1.h2.d l0;
    public final CustomMessageListener l1;
    public int m;
    public c.a.p0.f1.h2.c m0;
    public final CustomMessageListener m1;
    public boolean n;
    public c.a.p0.f1.s2.j n0;
    public final AntiHelper.k n1;
    public c.a.p0.a4.k0.f o;
    public c.a.p0.f1.h2.a o0;
    public CustomMessageListener o1;
    public boolean p;
    public c.a.p0.f1.f2.a p0;
    public CustomMessageListener p1;
    public boolean q;
    public c.a.p0.f1.p q0;
    public CustomMessageListener q1;
    public VoiceManager r;
    public c.a.p0.f1.s2.c r0;
    public CustomMessageListener r1;
    public View s;
    public c.a.p0.f1.v2.c s0;
    public CustomMessageListener s1;
    public c.a.p0.f1.q t;
    public c.a.p0.f1.s2.e t0;
    public HttpMessageListener t1;
    public OvalActionButton u;
    public boolean u0;
    public c.a.o0.j0.i u1;
    public FRSRefreshButton v;
    public c.a.p0.f1.z1.b v0;
    public final CustomMessageListener v1;
    public LinearLayout w;
    public c.a.p0.l.a w0;
    public CustomMessageListener w1;
    public final ThreadData x;
    public c.a.p0.c0.c x0;
    public final CustomMessageListener x1;
    public FrsViewData y;
    public c.a.p0.f1.l1.a.a y0;
    public CustomMessageListener y1;
    public String z;
    public c.a.o0.r.t.a z0;
    public CustomMessageListener z1;

    /* loaded from: classes5.dex */
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
                    c.a.p0.h0.u.b().e(false);
                    this.a.b3(false);
                }
                if (i == 502) {
                    this.a.u.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.a.u.setIconFade(0);
                }
                this.a.h1 = i;
                this.a.Q0 = i2;
                if (this.a.N0 != null) {
                    this.a.N0.d(this.a.Q0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.Q0);
                this.a.d4();
                c.a.p0.f1.o2.b bVar = c.a.p0.f1.o2.d.f0;
                bVar.f14302e = i;
                bVar.f14305h = i2;
                bVar.f14303f = -1;
                if (!this.a.C0) {
                    this.a.t.S1(this.a.m2(i));
                    return;
                }
                c.a.p0.f1.b.f().p(i == 1 && this.a.C0, true);
                c.a.p0.f1.a h2 = c.a.p0.f1.a.h();
                if (i == 1 && this.a.C0) {
                    z = true;
                }
                h2.p(z, true);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            this.a.t.T0();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.W.i0(((Integer) customResponsedMessage.getData()).intValue());
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.y.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.a.t.W().notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
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
                        if (this.a.W.J() == 0 || this.a.t.H0() || c.a.o0.x.d.h().k()) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.a.y == null) {
                return;
            }
            c.a.p0.f1.r2.t.c(this.a.y, this.a.getPageContext());
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.a.y == null || (userData = this.a.y.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.a.V.N(num);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.W.b(49);
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements c.a.p0.f1.x0 {
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

        @Override // c.a.p0.f1.x0
        public void a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.a.t == null) {
                return;
            }
            boolean z3 = false;
            if (i == 1) {
                this.a.t.w1(c.a.p0.f1.b.f().h());
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
            if (this.a.I2() != null) {
                FrsTabViewController.o A = this.a.I2().A();
                if (A != null) {
                    if ((A.f32887b instanceof FrsCommonTabFragment) && (i == 2 || A.a == 502)) {
                        ((FrsCommonTabFragment) A.f32887b).Z0();
                    } else if ((A.f32887b instanceof FrsNewAreaFragment) && (i == 2 || A.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) A.f32887b;
                        frsNewAreaFragment.w1();
                        if (frsNewAreaFragment.h1() != null) {
                            c.a.p0.f1.h2.g h1 = frsNewAreaFragment.h1();
                            h1.G(!z);
                            if (i == 1) {
                                h1.D(!z);
                            } else if (i == 2) {
                                h1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = A.f32887b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).r1();
                        }
                    }
                }
                if (this.a.I2().K() != null) {
                    this.a.I2().K().setmDisallowSlip(z);
                    this.a.I2().f0(z);
                }
            }
            if (this.a.t.Y() != null) {
                c.a.p0.f1.q qVar = this.a.t;
                if (this.a.k2() && !z) {
                    z3 = true;
                }
                qVar.S1(z3);
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

        @Override // c.a.p0.f1.x0
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0703));
                bdTopToast.j(this.a.t.n0());
                return;
            }
            c.a.d.f.p.n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f070e);
        }

        @Override // c.a.p0.f1.x0
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

    /* loaded from: classes5.dex */
    public class d1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveHorseRaceData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32267b;

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
            this.f32267b = frsFragment;
            this.a = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (this.f32267b.y != null && this.f32267b.y.getForum() != null) {
                    str = this.f32267b.y.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.f32267b.l).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.a.getLive_id() != null) {
                    alaInfoData.live_id = this.a.getLive_id().longValue();
                    alaInfoData.screen_direction = this.a.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f32267b.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.f32267b.l)));
                }
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
                this.a.W.b(1);
                this.a.u2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
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

        @Override // c.a.p0.l.f.c
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
            if (this.a.W == null || this.a.W.A() == null || !(this.a.W.A().f32887b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.W.A().f32887b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(R.string.obfuscated_res_0x7f0f0493);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.z0 = new c.a.o0.r.t.a(frsFragment.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f04d4, new a(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.z0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.z0 = new c.a.o0.r.t.a(frsFragment2.getActivity());
                    }
                    this.a.z0.setMessage(text);
                    this.a.z0.setPositiveButton(R.string.obfuscated_res_0x7f0f0984, new b(this));
                    this.a.z0.setCanceledOnTouchOutside(false);
                    this.a.z0.create(this.a.getPageContext());
                    this.a.z0.show();
                } else {
                    this.a.t.N1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.s1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.q2(deleteThreadHttpResponseMessage.getSuccessItems());
                c.a.p0.f1.b.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (c.a.d.o.e.n nVar : this.a.y.getThreadList()) {
                    if (nVar instanceof a2) {
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
            c.a.d.f.p.n.N(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32268b;

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
            this.f32268b = frsFragment;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.p0.a4.y) || this.a.y == null) {
                return;
            }
            this.a.y.updateLikeData((c.a.p0.a4.y) customResponsedMessage.getData());
            this.a.V.Q(this.a.y);
            this.a.W.d(this.a.y, this.a.U.T());
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f0 f32269b;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1845a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f32270b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f32271c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ float f32272d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f32273e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f32274f;

                public RunnableC1845a(a aVar, long j, int i, int i2, float f2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32274f = aVar;
                    this.a = j;
                    this.f32270b = i;
                    this.f32271c = i2;
                    this.f32272d = f2;
                    this.f32273e = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.a, 0L, 0L, this.f32270b, this.f32271c, this.f32272d, this.f32273e);
                        requestGetMyPostNetMessage.setTag(this.f32274f.f32269b.a.getUniqueId());
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
                this.f32269b = f0Var;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f32269b.a.W.b(301);
                    c.a.d.f.m.e.a().postDelayed(new RunnableC1845a(this, c.a.d.f.m.b.g((String) this.a.get(BdUniDispatchSchemeController.PARAM_TID), 0L), c.a.d.f.p.n.k(TbadkCoreApplication.getInst()), c.a.d.f.p.n.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
                this.a.f32264f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_KW);
            }
            if (!(hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID) instanceof String) || TextUtils.isEmpty((String) hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_ID))) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32275b;

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
            this.f32275b = frsFragment;
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
                this.f32275b.w.removeView(this.a);
                if (this.f32275b.J0 == null || this.f32275b.I0 <= this.f32275b.J0.size() - 1) {
                    this.f32275b.R2();
                    return;
                }
                this.f32275b.w.removeAllViews();
                this.f32275b.w.setVisibility(8);
                this.f32275b.I0 = 0;
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
        public void onNavigationButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y == null) {
                return;
            }
            this.a.y.removeGameRankListFromThreadList();
            if (this.a.t != null) {
                this.a.t.I0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsRedpackRunView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32276b;

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
            this.f32276b = frsFragment;
            this.a = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f32276b.w == null || this.a == null) {
                return;
            }
            this.f32276b.K0.start();
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
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f30338c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.n1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().f30339d) {
                    c.a.d.f.p.n.M(this.a.getPageContext().getPageActivity(), R.string.obfuscated_res_0x7f0f02ab);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements c.a.p0.f1.h2.k {
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

        @Override // c.a.p0.f1.h2.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<c.a.d.o.e.n> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.a.Y == null || this.a.U == null || !this.a.U.v0() || !z || z2 || z3) {
                return;
            }
            this.a.Y.a(i2);
        }
    }

    /* loaded from: classes5.dex */
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
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.a.g0 != null && this.a.g0.e() != null) {
                    this.a.g0.e().c(motionEvent);
                }
                if (this.a.v0 != null) {
                    this.a.v0.b(view, motionEvent);
                }
                if (this.a.V != null) {
                    this.a.V.M(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.t.Q1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(FrsFragment frsFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
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
            c.a.o0.r.j0.b k = c.a.o0.r.j0.b.k();
            if (k.l(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || this.a.y.getForum() == null) {
                return;
            }
            this.a.y.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.o0.r.r.a0) && this.a.isResumed()) {
                c.a.o0.r.r.a0 a0Var = (c.a.o0.r.r.a0) customResponsedMessage.getData();
                if (this.a.O0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.O0 = new c.a.p0.f1.m1.a(frsFragment.getPageContext());
                }
                if (this.a.y == null || this.a.y.getForum() == null || TextUtils.isEmpty(this.a.y.getForum().getId())) {
                    return;
                }
                this.a.O0.g(a0Var.a, this.a.y.getForum().getId(), this.a.y.getForum().getName(), a0Var.f10781b);
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
                this.a.n3();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f32277b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f32278c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f32279d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f32280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32281f;

        public k0(FrsFragment frsFragment, long j, int i, int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32281f = frsFragment;
            this.a = j;
            this.f32277b = i;
            this.f32278c = i2;
            this.f32279d = f2;
            this.f32280e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.a, 0L, 0L, this.f32277b, this.f32278c, this.f32279d, this.f32280e);
                requestGetMyPostNetMessage.setTag(this.f32281f.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.o0.m(((WriteData) customResponsedMessage.getData()).getTabId());
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
                c.a.p0.a4.q0.a.o(this.a.f32264f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
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
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
                screenTopToast.m(this.a.getString(R.string.obfuscated_res_0x7f0f06bf));
                screenTopToast.k(this.a.getString(R.string.obfuscated_res_0x7f0f0720));
                screenTopToast.j(new a(this));
                screenTopToast.n((ViewGroup) this.a.s.findViewById(R.id.obfuscated_res_0x7f090abb));
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32282b;

        public m0(FrsFragment frsFragment, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32282b = frsFragment;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.o0.r.t.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.dismiss();
            this.f32282b.M3();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.p0.l.h hVar = (c.a.p0.l.h) customResponsedMessage.getData();
            if (this.a.y == null || this.a.y.getForum() == null || this.a.y.getForum().getDeletedReasonInfo() == null) {
                c.a.p0.l.e.d(0, this.a.getPageContext(), hVar, null, this.a.y.getUserData());
                return;
            }
            c.a.p0.l.i iVar = new c.a.p0.l.i(this.a.y.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.y.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.y.forumRule != null ? this.a.y.forumRule.has_forum_rule.intValue() : 0);
            iVar.i(this.a.y.getForum().getId(), this.a.y.getForum().getName());
            iVar.h(this.a.y.getForum().getImage_url());
            iVar.j(this.a.y.getForum().getUser_level());
            c.a.p0.l.e.d(iVar.f(), this.a.getPageContext(), hVar, iVar, this.a.y.getUserData());
        }
    }

    /* loaded from: classes5.dex */
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
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0708));
                bdTopToast.j(this.a.t.n0());
                if (c.a.p0.f1.a.h().k(c.a.p0.f1.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.W != null && this.a.W.A() != null && (this.a.W.A().f32887b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.W.A().f32887b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.X0();
                    }
                    this.a.r2();
                    c.a.p0.f1.a.h().d();
                    for (c.a.d.o.e.n nVar : this.a.y.getThreadList()) {
                        if (nVar instanceof a2) {
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
                c.a.p0.f1.a.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(this.a.t.n0());
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements c.a.o0.r.f {
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

        @Override // c.a.o0.r.f
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.o0.x.d.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.u != null) {
                        this.a.u.setVisibility(8);
                        return;
                    }
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0640));
                bdTopToast.j(this.a.t.n0());
            }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.v == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.A() == null || !(this.a.W.A().f32887b instanceof BaseFragment) || !((BaseFragment) this.a.W.A().f32887b).isPrimary() || this.a.t.H0()) {
                this.a.w.setVisibility(8);
                this.a.J = true;
                return;
            }
            this.a.w.setVisibility(0);
            this.a.J = false;
        }
    }

    /* loaded from: classes5.dex */
    public class o extends c.a.o0.j0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32283c;

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
            this.f32283c = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.j0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.f32283c.getContext());
                bdTopToast.i(topToastEvent.isSuccess());
                bdTopToast.h(topToastEvent.getContent());
                bdTopToast.j(this.f32283c.t.n0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements c.a.o0.r.f {
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

        @Override // c.a.o0.r.f
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                c.a.o0.x.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.u != null) {
                    this.a.u.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 extends c.a.d.c.g.a {
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

        @Override // c.a.d.c.g.a
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
                    this.a.R2();
                    return;
                }
                this.a.J0 = new ArrayList();
                this.a.I0 = 0;
                this.a.J0.addAll(arrayList);
                this.a.R2();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isResumed()) {
                this.a.c4();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Z2();
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.t != null) {
                    this.a.t.h1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LogicField logicField = (LogicField) view.getTag(R.id.obfuscated_res_0x7f090659);
                if (this.a.t != null && view == this.a.t.U() && this.a.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view.getId() == R.id.obfuscated_res_0x7f090c33 && c.a.d.f.p.n.C()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.a.t == null || !this.a.t.D0()) {
                        String c2 = this.a.y.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c2)) {
                            c.a.o0.l.a.l(this.a.getPageContext().getPageActivity(), c2);
                        }
                    } else {
                        this.a.t.I1();
                    }
                }
                if (this.a.t != null && view == this.a.t.d0() && this.a.U != null && this.a.U.hasMore()) {
                    this.a.t.L1();
                    this.a.loadMore();
                }
                if (view != null && this.a.t != null && view == this.a.t.e0()) {
                    this.a.Z2();
                }
                if (c.a.d.f.p.l.z()) {
                    if (this.a.y == null || this.a.y.getForum() == null) {
                        return;
                    }
                    if (this.a.t != null && (view == this.a.t.t0() || logicField == LogicField.MORE_BTN)) {
                        if (this.a.y == null || this.a.y.getForum() == null || StringUtils.isNull(this.a.y.getForum().getId()) || StringUtils.isNull(this.a.y.getForum().getName())) {
                            return;
                        }
                        c.a.p0.f1.l2.a.e(this.a.y.getForum().getId(), this.a.y.getForum().getName());
                        c.a.p0.f1.r2.n.g(this.a.getPageContext(), this.a.y, this.a.y.getForum().getId(), this.a.K, this.a.L, this.a.H1);
                    }
                    if ((this.a.t == null || view != this.a.t.s0()) && logicField != LogicField.SEARCH_BTN) {
                        return;
                    }
                    StatisticItem param = new StatisticItem("c12402").param("fid", this.a.y.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.a.y.getForum().getName());
                    c.a.p0.f1.l2.a.a(param);
                    TiebaStatic.log(param);
                    if (StringUtils.isNull(this.a.y.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.a.getContext(), this.a.y.getForum().getName(), this.a.y.getForum().getId())));
                    return;
                }
                c.a.d.f.p.n.M(this.a.getContext().getApplicationContext(), R.string.obfuscated_res_0x7f0f0c16);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements c.a.p0.f1.t0 {
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

        @Override // c.a.p0.f1.t0
        public void a(int i, int i2, c.a.p0.f1.c1 c1Var, ArrayList<c.a.d.o.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c1Var, arrayList}) == null) {
                this.a.T3();
                if (this.a.j0 != null) {
                    this.a.V.a0(this.a.j0.e(i));
                }
                c.a.p0.a4.f fVar = new c.a.p0.a4.f();
                if (c1Var != null) {
                    boolean z = c1Var.f13864e == 0;
                    fVar.f12188b = z;
                    fVar.f12189c = c1Var.f13864e;
                    fVar.f12190d = c1Var.f13865f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.t.v0();
                        } else if (c1Var.f13866g) {
                            if (ListUtils.getCount(this.a.y.getThreadList()) > 3) {
                                this.a.t.L1();
                            } else {
                                this.a.t.H1();
                            }
                        } else if (c1Var.i) {
                            this.a.t.O1();
                        } else {
                            this.a.t.v0();
                        }
                    }
                } else {
                    c1Var = new c.a.p0.f1.c1();
                    c1Var.f14893c = 1;
                    c1Var.f13866g = false;
                    c1Var.i = false;
                }
                if (i == 1) {
                    this.a.P = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.A1.d(frsFragment.U.getType(), false, fVar);
                } else {
                    this.a.S3(fVar);
                    if (this.a.U.f0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.y = frsFragment2.U.f0();
                    }
                    this.a.k3();
                }
                if (this.a.O1 != null) {
                    this.a.O1.a(i, i2, c1Var, arrayList);
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || c.a.d.f.p.m.isEmpty(str) || !str.equals(this.a.l)) {
                    return;
                }
                c.a.p0.f1.r2.n.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.y);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.v == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.W.J() == 0 || this.a.W.A() == null || !(this.a.W.A().f32887b instanceof BaseFragment) || !((BaseFragment) this.a.W.A().f32887b).isPrimary() || this.a.t.H0() || c.a.o0.x.d.h().k()) {
                if (this.a.W.J() != 0) {
                    this.a.v.b();
                    return;
                }
                return;
            }
            this.a.v.f();
        }
    }

    /* loaded from: classes5.dex */
    public final class r1 implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
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

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == c.a.p0.f1.u.a) {
                if (this.a.t != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.a.l).param("obj_locate", "1"));
                    this.a.t.T1();
                }
            } else if (nVar == null || !(nVar instanceof a2)) {
            } else {
                ThreadData threadData = ((a2) nVar).s;
                if (threadData.getAnchorInfoData() == null || threadData.getAnchorInfoData().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    if (threadData.getActInfoType() != 1 || ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        if (threadData.getAppCodeData() != null) {
                            if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                                String a2 = threadData.getAppCodeData().a();
                                if (StringUtils.isNull(a2) || !c.a.d.f.p.n.C()) {
                                    return;
                                }
                                c.a.o0.l.a.l(this.a.getActivity(), a2);
                            }
                        } else if (threadData.getCartoonThreadData() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                                return;
                            }
                            c.a.o0.r.r.u cartoonThreadData = threadData.getCartoonThreadData();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.a.getPageContext().getPageActivity(), cartoonThreadData.a(), cartoonThreadData.b(), 2)));
                        } else {
                            c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                                c.a.p0.f1.r2.q.c(threadData.getTaskInfoData());
                            } else if (bdUniqueId.getId() == ThreadData.TYPE_SHARE_THREAD.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", threadData.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                            c.a.p0.f1.r2.r.e(this.a, threadData, i, z);
                            FrsFragment frsFragment = this.a;
                            c.a.p0.f1.r2.q.d(frsFragment, frsFragment.y, threadData);
                        }
                    }
                }
            }
        }

        public /* synthetic */ r1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.t == null) {
                return;
            }
            this.a.t.O();
        }
    }

    /* loaded from: classes5.dex */
    public class s0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f32284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32285c;

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
            this.f32285c = frsFragment;
            this.a = 0;
            this.f32284b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (this.f32285c.V != null) {
                    this.f32285c.V.k0(i);
                    if (i == 1) {
                        this.f32285c.V.z();
                    }
                }
                FrsFragment frsFragment = this.f32285c;
                if (frsFragment.O == null && !frsFragment.V2()) {
                    this.f32285c.O = new c.a.o0.r0.b();
                    this.f32285c.O.a(1000);
                }
                if (i != 0) {
                    if (this.f32285c.W0 == null) {
                        this.f32285c.W0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    c.a.o0.r0.b bVar = this.f32285c.O;
                    if (bVar != null) {
                        bVar.d();
                    }
                } else {
                    c.a.o0.r0.b bVar2 = this.f32285c.O;
                    if (bVar2 != null) {
                        bVar2.e();
                    }
                    c.a.p0.h0.u.b().e(true);
                    this.f32285c.b3(true);
                    this.f32285c.t.L0(this.a, this.f32284b);
                    if (this.f32285c.W0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f32285c.W0);
                        this.f32285c.W0 = null;
                    }
                }
                if (this.f32285c.t0 != null) {
                    this.f32285c.t0.i(recyclerView, i);
                }
                if (i == 0) {
                    c.a.p0.f1.r2.q.b(this.f32285c.t, this.f32285c.y, this.f32285c.c(), false, null);
                }
                if (this.f32285c.W != null && i == 1) {
                    this.f32285c.W.M();
                }
                if (this.f32285c.T == null) {
                    if (this.f32285c.t.k0() != null && !this.f32285c.t.a0() && this.f32285c.t.k0().j() != null && (this.f32285c.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.f32285c;
                        frsFragment2.T = (ThreadCardViewHolder) frsFragment2.t.k0().j().getTag();
                    }
                } else if (i == 0 && this.f32285c.t.k0() != null && !this.f32285c.t.a0() && this.f32285c.t.k0().j() != null && (this.f32285c.t.k0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.f32285c;
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
                this.f32285c.H0 += i2;
                if (this.f32285c.H0 >= this.f32285c.G0 * 2 && i2 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.f32285c.k0 != null) {
                    this.f32285c.k0.j();
                }
                this.a = 0;
                this.f32284b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.f32284b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.f32285c.t0 != null) {
                    this.f32285c.t0.h(recyclerView, this.a, this.f32284b);
                }
                if (this.f32285c.y == null || this.f32285c.t == null || this.f32285c.t.W() == null) {
                    return;
                }
                this.f32285c.t.i1(this.a, this.f32284b);
                if (this.f32285c.T != null && this.f32285c.T.c() != null) {
                    this.f32285c.T.c().o(this.f32285c.S);
                }
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i2 > 0) {
                    c.a.p0.x3.b.r().A(3, 2);
                    c.a.p0.x3.b.r().G();
                }
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
                this.a.P3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements c.a.p0.f1.f {
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

        @Override // c.a.p0.f1.f
        public void a(int i, int i2, View view, View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), view, view2, threadData}) == null) {
                if (i != this.a.t.W().c()) {
                    if (i != this.a.t.W().j()) {
                        if (i != this.a.t.W().i() || this.a.y == null || this.a.y.getUserData() == null || !this.a.y.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.y.getBawuCenterUrl();
                        if (c.a.d.f.p.m.isEmpty(bawuCenterUrl) || this.a.y.getForum() == null) {
                            return;
                        }
                        c.a.o0.l.a.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.y.getForum().getId()).param("uid", this.a.y.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.y == null || this.a.y.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.y.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), c.a.d.f.m.b.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log("forum_fortune_click");
                    c.a.p0.f1.r2.r.d(this.a.getPageContext(), this.a.y);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements c.a.p0.a4.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32286b;

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
            this.f32286b = frsFragment;
            this.a = 0L;
        }

        @Override // c.a.p0.a4.u
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a = System.nanoTime();
                if (this.f32286b.t == null) {
                    return;
                }
                if (i == 1 || i == 2) {
                    this.f32286b.t.J0();
                }
            }
        }

        @Override // c.a.p0.a4.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32286b.n3();
            }
        }

        @Override // c.a.p0.a4.u
        public void c(c.a.p0.a4.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
                if ((nVar == null || !("normal_page".equals(this.f32286b.U.b0()) || "frs_page".equals(this.f32286b.U.b0()) || "book_page".equals(this.f32286b.U.b0()))) && !"brand_page".equals(this.f32286b.U.b0())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, nVar));
                this.f32286b.o3(nVar);
                FrsFragment.b2 = nVar;
            }
        }

        @Override // c.a.p0.a4.u
        public void d(int i, boolean z, c.a.p0.a4.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), fVar}) == null) {
                if (this.f32286b.i0) {
                    this.f32286b.i0 = false;
                    c.a.p0.f1.r2.q.b(this.f32286b.t, this.f32286b.y, this.f32286b.c(), false, null);
                }
                this.f32286b.T3();
                this.f32286b.N = true;
                if (fVar != null && fVar.f12188b) {
                    this.f32286b.t.W().n(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.c2 = 0L;
                    FrsFragment.d2 = 0L;
                    FrsFragment.e2 = 0;
                } else {
                    FrsFragment.e2 = 1;
                }
                if (!this.f32286b.U.v0() && (i == 3 || i == 6)) {
                    this.f32286b.m0.l();
                }
                this.f32286b.C = System.currentTimeMillis();
                if (this.f32286b.U.f0() != null) {
                    FrsFragment frsFragment = this.f32286b;
                    frsFragment.y = frsFragment.U.f0();
                }
                this.f32286b.R3(1);
                this.f32286b.J3();
                if (i == 7) {
                    this.f32286b.m3(this.f32286b.y.getFrsDefaultTabId());
                    return;
                }
                if (this.f32286b.y.getPage() != null) {
                    FrsFragment frsFragment2 = this.f32286b;
                    frsFragment2.v3(frsFragment2.y.getPage().b());
                }
                if (i == 4) {
                    if (!this.f32286b.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.f32286b.U.d0() == 1 && (this.f32286b.y.adShowSelect == 1 || this.f32286b.y.adShowSelect == 3)) {
                        this.f32286b.y.addRecommendAppToThreadList(this.f32286b);
                    }
                    ArrayList<c.a.d.o.e.n> c2 = this.f32286b.m0.c(false, false, this.f32286b.y.getThreadList(), this.f32286b.o, false, this.f32286b.y.adShowSelect, this.f32286b.y.adMixFloor);
                    if (c2 != null) {
                        this.f32286b.y.setThreadList(c2);
                        this.f32286b.y.checkLiveStageInThreadList();
                    }
                    if (this.f32286b.U != null) {
                        c.a.p0.f1.o2.c.m(this.f32286b.y, this.f32286b.U.T(), 2, this.f32286b.getContext());
                    }
                    FrsFragment frsFragment3 = this.f32286b;
                    c.a.p0.f1.r2.d.a(frsFragment3, frsFragment3.y.getForum(), this.f32286b.y.getThreadList(), false, this.f32286b.G2());
                    this.f32286b.t.D1(c2, this.f32286b.y);
                    this.f32286b.V3();
                    return;
                }
                this.f32286b.V3();
                if (i == 1) {
                    this.f32286b.t.J0();
                } else if (i == 2) {
                    this.f32286b.t.J0();
                } else if (i == 3 || i == 6) {
                    if (this.f32286b.y != null) {
                        this.f32286b.y.clearPostThreadCount();
                    }
                    c.a.p0.f1.s2.c cVar = this.f32286b.r0;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
                this.f32286b.b4();
                if (fVar == null || fVar.f12189c == 0) {
                    if (this.f32286b.y == null) {
                        return;
                    }
                    FrsFragment frsFragment4 = this.f32286b;
                    if (!frsFragment4.K3(frsFragment4.y)) {
                        UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.f32286b.getPageContext());
                        upgradePopWindowMessage.setFromPage("frs");
                        MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                    }
                    this.f32286b.h3(false, i == 5);
                    if (this.f32286b.U != null) {
                        if (this.f32286b.y.getActivityHeadData() != null && this.f32286b.y.getActivityHeadData().b() != null && this.f32286b.y.getActivityHeadData().b().size() > 0) {
                            c.a.p0.f1.o2.a.g(this.f32286b.getUniqueId(), 1, this.f32286b.y.getForum(), this.f32286b.U.c0(), 1);
                        }
                        if (this.f32286b.y.getThreadList() != null && this.f32286b.y.getThreadList().size() > 0) {
                            Iterator<c.a.d.o.e.n> it = this.f32286b.y.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                c.a.d.o.e.n next = it.next();
                                if ((next instanceof ThreadData) && ((ThreadData) next).getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                                    c.a.p0.f1.o2.a.g(this.f32286b.getUniqueId(), 1, this.f32286b.y.getForum(), this.f32286b.U.c0(), 2);
                                    break;
                                }
                            }
                        }
                        c.a.p0.f1.o2.a.h(this.f32286b.getUniqueId(), this.f32286b.y.getThreadList(), this.f32286b.y.getForum(), this.f32286b.U.c0());
                    }
                    this.f32286b.t.U0(i);
                    FrsFragment.c2 = (System.nanoTime() - this.a) / 1000000;
                    if (fVar != null) {
                        FrsFragment.d2 = fVar.f12191e;
                    }
                } else if (this.f32286b.y == null || ListUtils.isEmpty(this.f32286b.y.getThreadList())) {
                    this.f32286b.S3(fVar);
                } else if (fVar.a) {
                    FrsFragment frsFragment5 = this.f32286b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c14, fVar.f12190d, Integer.valueOf(fVar.f12189c)));
                }
                this.f32286b.Y3();
                this.f32286b.p2();
                if (this.f32286b.y.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.f32286b.p && this.f32286b.W.b(49)) {
                    this.f32286b.p = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.U.d0() == 1 && z && !this.a.t.a0()) {
                if (this.a.y != null && !ListUtils.isEmpty(this.a.y.getThreadList())) {
                    this.a.t.J0();
                    return;
                }
                FrsFragment frsFragment = this.a;
                frsFragment.hideNetRefreshView(frsFragment.t.X().k());
                FrsFragment frsFragment2 = this.a;
                frsFragment2.showLoadingView(frsFragment2.t.n0(), true);
                this.a.t.w0(false);
                this.a.refresh();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof ThreadData) {
                    c.a.p0.f1.r2.q.b(this.a.t, this.a.y, this.a.c(), true, (ThreadData) data);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                c.a.p0.f1.r2.f.a(customResponsedMessage, this.a.t, this.a.y);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivateForumPopInfoData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.r.t.a f32287b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32288c;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, privateForumPopInfoData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32288c = frsFragment;
            this.a = privateForumPopInfoData;
            this.f32287b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f32288c.getPageContext(), new String[]{this.a.B()});
                this.f32287b.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.W == null) {
                return;
            }
            FrsTabViewController.o A = this.a.W.A();
            if (A != null && (fragment = A.f32887b) != null && (fragment instanceof c.a.p0.f1.q0)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((c.a.p0.f1.q0) A.f32887b).A0();
                ((c.a.p0.f1.q0) A.f32887b).q();
                return;
            }
            this.a.x0().T1();
        }
    }

    /* loaded from: classes5.dex */
    public class x implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements c.a.p0.f1.t0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.t != null && this.a.a.t.E0()) {
                    this.a.a.loadMore();
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

        @Override // c.a.p0.f1.t0
        public void a(int i, int i2, c.a.p0.f1.c1 c1Var, ArrayList<c.a.d.o.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c1Var, arrayList}) == null) {
                c.a.d.f.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f32289b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f32290c;

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
            this.f32290c = frsFragment;
            this.a = i;
            this.f32289b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f32290c.l).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.a));
                UrlManager.getInstance().dealOneLink(this.f32290c.getPageContext(), new String[]{this.f32289b});
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N || !c.a.d.f.p.l.z() || this.a.t.G0()) {
                return;
            }
            this.a.t.W0();
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
                    this.a.T.c().o(new a.C0196a(3));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f32262d = false;
        this.f32263e = true;
        this.f32264f = null;
        this.f32265g = null;
        this.f32266h = 0;
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
        this.S = new a.C0196a(2);
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
        this.X0 = new k(this);
        this.Y0 = new v(this, 2016495);
        this.Z0 = new g0(this, 2921005);
        this.a1 = new r0(this, 2921401);
        this.b1 = new c1(this, 2921473);
        this.c1 = new n1(this, 2921467);
        this.d1 = new o1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.e1 = new p1(this, 2001624);
        this.f1 = new q1(this);
        this.g1 = new a(this);
        this.i1 = new b(this, 2001606);
        this.j1 = new c(this, 2001607);
        this.k1 = new d(this, 2003019);
        this.l1 = new e(this, 2921470);
        this.m1 = new f(this, 2001352);
        this.n1 = new g(this);
        this.o1 = new h(this, 2001115);
        this.p1 = new i(this, 2921346);
        this.q1 = new j(this, 2001374);
        this.r1 = new l(this, 2001378);
        this.s1 = new m(this, 2001626);
        this.t1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.u1 = new o(this);
        this.v1 = new p(this, 2921391);
        this.w1 = new q(this, 2003020);
        this.x1 = new r(this, 2921463);
        this.y1 = new s(this, 2921587);
        this.z1 = new t(this, 2921588);
        this.A1 = new u(this);
        this.B1 = new b0(this, 2016485);
        this.C1 = new c0(this, 2001194);
        this.D1 = new f0(this);
        this.E1 = new h0(this);
        this.F1 = new i0(this);
        this.G1 = new j0(this, 2004507);
        this.H1 = new p0(this);
        this.I1 = new q0(this);
        this.J1 = new s0(this);
        this.K1 = new t0(this);
        this.L1 = new u0(this);
        this.M1 = new v0(this, 0);
        this.N1 = new r1(this, null);
        this.O1 = new x0(this);
        this.P1 = new y0(this, 2921033);
        this.Q1 = new z0(this, 2921381);
        this.R1 = new a1(this, 2921414);
        this.S1 = new b1(this, 2921437);
        this.T1 = new h1(this, 2921462);
        this.U1 = new i1(this, 2001223);
        this.V1 = new j1(this, 2921469);
        this.W1 = new k1(this, 2921475);
        this.X1 = new l1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.Y1 = new m1(this, 2921515);
    }

    @Override // c.a.p0.f1.o0
    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isAdded() && this.i0 && isLoadingViewAttached()) {
            hideLoadingView(this.t.n0());
        }
    }

    public int A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.R0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.R0;
        }
        return invokeV.intValue;
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.y == null) {
            return;
        }
        c.a.p0.f1.o2.b bVar = new c.a.p0.f1.o2.b();
        if (this.y.needLog == 1) {
            bVar.a = true;
        } else {
            bVar.a = false;
        }
        if (this.y.getForum() != null) {
            bVar.f14300c = this.y.getForum().getId();
            bVar.f14301d = this.y.getForum().getName();
        }
        if (b0() != null) {
            bVar.f14299b = b0().T();
        }
        c.a.p0.f1.o2.b bVar2 = c.a.p0.f1.o2.d.f0;
        if (bVar2 != null) {
            bVar.f14302e = bVar2.f14302e;
            bVar.f14303f = bVar2.f14303f;
        }
        c.a.p0.f1.f2.b bVar3 = new c.a.p0.f1.f2.b(bVar, getTbPageTag(), getUniqueId());
        this.N0 = bVar3;
        bVar3.d(this.Q0);
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

    public c.a.p0.f1.h2.d B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l0 : (c.a.p0.f1.h2.d) invokeV.objValue;
    }

    public void B3(boolean z2) {
        c.a.p0.f1.v0 v0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) || (v0Var = this.g0) == null) {
            return;
        }
        v0Var.i(z2);
    }

    @Override // c.a.p0.f1.o0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public c.a.p0.f1.m2.a C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Y : (c.a.p0.f1.m2.a) invokeV.objValue;
    }

    public void C3(int i2) {
        c.a.p0.f1.h2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.o(i2);
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t.a0() : invokeV.booleanValue;
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) && this.Z1 == null) {
            c.a.p0.h1.a a3 = c.a.p0.h1.a.a(z2);
            this.Z1 = a3;
            c.a.p0.f1.h2.c cVar = this.m0;
            if (cVar != null) {
                cVar.m(a3);
            }
        }
    }

    public BdTypeRecyclerView E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.p0.f1.q qVar = this.t;
            if (qVar == null) {
                return null;
            }
            return qVar.c0();
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void E3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (frsViewData = this.y) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.t.W().setFromCDN(true);
        } else {
            this.t.W().setFromCDN(false);
        }
    }

    public c.a.p0.f1.v0 F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g0 : (c.a.p0.f1.v0) invokeV.objValue;
    }

    public void F3(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ovalActionButton) == null) {
            this.u = ovalActionButton;
        }
    }

    public int G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.p0.f1.h2.c cVar = this.m0;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    public void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.V0 = z2;
        }
    }

    public View H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void H3(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.w = linearLayout;
    }

    public FrsTabViewController I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.W : (FrsTabViewController) invokeV.objValue;
    }

    public void I3(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.v = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new w0(this));
    }

    public final FrsTabInfoData J2() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.U == null || (frsViewData = this.y) == null || this.W == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.y.getEntelechyTabInfo().a) || (E = this.W.E()) == 502) {
                return null;
            }
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.y.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.y.getUserData() == null || this.y.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (E == frsTabInfo.tab_id.intValue()) {
                        i2 = E;
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = i2;
            if (this.y.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.y.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public final void J3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
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

    public String K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public final boolean K3(c.a.p0.a4.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, nVar)) == null) {
            if (nVar != null && nVar.getEntelechyTabInfo() != null && nVar.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : nVar.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && c.a.o0.r.j0.b.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            c.a.p0.f1.i1.f fVar = new c.a.p0.f1.i1.f(j());
            this.T0 = fVar;
            boolean j2 = fVar.j(nVar);
            this.U0 = j2;
            return j2;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.l3.v
    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b0().U0();
        }
    }

    public OvalActionButton L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.u : (OvalActionButton) invokeV.objValue;
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new m0(this, aVar));
            aVar.setContentView(frsBroadcastCopyGuideDialogView);
            aVar.create(getPageContext()).show();
        }
    }

    public FRSRefreshButton M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.v : (FRSRefreshButton) invokeV.objValue;
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.o0.x.d.h().m(new c.a.o0.x.a(getContext()));
            c.a.o0.x.d.h().n(85, 0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (c.a.o0.x.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    @Override // c.a.p0.f1.h2.l
    public c.a.p0.f1.s2.h N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.V : (c.a.p0.f1.s2.h) invokeV.objValue;
    }

    public int N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            c.a.p0.f1.h2.c cVar = this.m0;
            if (cVar == null) {
                return -1;
            }
            return cVar.h();
        }
        return invokeV.intValue;
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.o0.x.d.h().m(new c.a.o0.x.b(getContext()));
            c.a.o0.x.d.h().n(85, 0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (c.a.o0.x.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.n.w(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public void O3(View view, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, str, Boolean.valueOf(z2), list}) == null) {
            this.t.V0();
            this.t.k1(8);
            if (this.s0 == null) {
                this.s0 = new c.a.p0.f1.v2.c(getPageContext(), getNetRefreshListener());
            }
            this.s0.c(str);
            this.s0.b(list);
            this.s0.attachView(view, z2);
        }
    }

    public void P2() {
        c.a.p0.f1.s2.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (hVar = this.V) == null) {
            return;
        }
        hVar.A();
    }

    public void P3() {
        c.a.p0.f1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (qVar = this.t) == null) {
            return;
        }
        qVar.G1();
    }

    public void Q2() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.b();
    }

    public void Q3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, str, str2, str3) == null) {
            c.a.p0.f1.r2.h hVar = new c.a.p0.f1.r2.h(str, str2);
            this.S0 = hVar;
            hVar.f(getFragmentActivity(), str3, str2);
        }
    }

    public final void R2() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || !isResumed() || (list = this.J0) == null || list.size() < 1 || this.I0 > this.J0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.J0.get(this.I0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.I0++;
            R2();
        }
        if (this.w != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a05), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a05), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0a05), getResources().getString(R.string.obfuscated_res_0x7f0f06ef));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new d1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.K0 = ofFloat;
            ofFloat.setDuration(600L);
            this.K0.addUpdateListener(new e1(this, frsRedpackRunView));
            this.K0.addListener(new f1(this, frsRedpackRunView));
            this.L0 = new g1(this, frsRedpackRunView);
            c.a.d.f.m.e.a().postDelayed(this.L0, 5000L);
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
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.W.A().f32887b).isPrimary() || this.t.H0() || this.J) {
                return;
            }
            this.w.setVisibility(0);
        }
    }

    public final void R3(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.y) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (c.a.d.f.p.m.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", c.a.o0.c1.v0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public final void S2(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) {
            registerListener(2001118, this.M1);
            long j2 = 0;
            if (bundle != null) {
                this.f32264f = bundle.getString("name");
                this.f32265g = bundle.getString("from");
                this.f32266h = bundle.getInt("flag", 0);
                j2 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                this.f32264f = intent.getStringExtra("name");
                this.f32265g = intent.getStringExtra("from");
                this.f32266h = intent.getIntExtra("flag", 0);
                j2 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            }
            if (getArguments() != null) {
                this.i = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
            }
            if (!TextUtils.isEmpty(this.f32265g)) {
                FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.f32265g);
            }
            if (this.mIsLogin) {
                registerListener(2001120, this.M1);
            }
            this.V.G(bundle);
            t2(j2);
        }
    }

    public final void S3(c.a.p0.a4.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            if (fVar == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0598);
                this.t.V0();
                showNetRefreshView(this.t.n0(), string, true);
            } else if (340001 == fVar.f12189c) {
                X3(fVar, this.y.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.y.getThreadList())) {
                    W3(fVar);
                }
                if (V2()) {
                    setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07028b));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.f32266h == 0) {
                this.t.E1(this.f32264f);
            } else {
                this.t.E1("");
                this.f32266h = 1;
            }
            this.t.A1(this.N1);
            this.t.J(this.J1);
            this.t.B1(this.L1);
            this.t.W().l(this.K1);
        }
    }

    public void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            hideLoadingView(this.t.n0());
            this.t.V1();
            if (this.t.m0() instanceof c.a.p0.f1.p2.d) {
                ((c.a.p0.f1.p2.d) this.t.m0()).d();
            }
        }
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (N2() != 1 && !this.m0.b(this.y.getThreadListIds())) {
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

    public boolean V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f32262d : invokeV.booleanValue;
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (N2() == 0 && ListUtils.isEmpty(this.y.getThreadListIds())) {
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

    public final boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (f0() == null) {
                return false;
            }
            FrsViewData f02 = f0();
            c.a.o0.r.r.b0 b0Var = null;
            if (f02.getStar() != null && !StringUtils.isNull(f02.getStar().a())) {
                b0Var = new c.a.o0.r.r.b0();
            } else if (f02.getActivityHeadData() != null && ListUtils.getCount(f02.getActivityHeadData().b()) >= 1) {
                b0Var = f02.getActivityHeadData().b().get(0);
            }
            return b0Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void W3(c.a.p0.a4.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, fVar) == null) {
            this.t.V0();
            if (fVar.a) {
                showNetRefreshView(this.t.n0(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c14, new Object[]{fVar.f12190d, Integer.valueOf(fVar.f12189c)}), true);
            } else {
                showNetRefreshView(this.t.X().k(), fVar.f12190d, true);
            }
        }
    }

    public boolean X2() {
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

    public final void X3(c.a.p0.a4.f fVar, List<RecmForumInfo> list) {
        c.a.p0.f1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048627, this, fVar, list) == null) || (qVar = this.t) == null) {
            return;
        }
        qVar.V0();
        this.t.E1(this.f32264f);
        if (this.t.X() != null) {
            O3(this.t.n0(), fVar.f12190d, true, list);
        }
        this.t.f0().h(true);
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (f0() == null) {
                return false;
            }
            FrsViewData f02 = f0();
            return (ListUtils.isEmpty(f02.getShowTopThreadList()) && f02.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void Y3() {
        boolean a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || n2()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.C(this.y.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (c.a.d.f.p.m.isEmpty(privateForumPopInfoData.A()) || privateForumPopInfoData.z() != Integer.valueOf(this.l))) {
            privateForumPopInfoData.F("create_success");
            privateForumPopInfoData.D(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0715));
            privateForumPopInfoData.G("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.l + "&fn=" + this.f32264f + "&nomenu=1");
            privateForumPopInfoData.E(Integer.valueOf(this.l));
            a3 = frsPrivateCommonDialogView.a(privateForumPopInfoData);
        } else {
            a3 = privateForumPopInfoData.z() == Integer.valueOf(this.l) ? frsPrivateCommonDialogView.a(privateForumPopInfoData) : false;
        }
        if (a3) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new w(this, privateForumPopInfoData, aVar));
            aVar.setCloseButton(new x(this));
            aVar.create(getPageContext()).show();
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && ViewHelper.checkUpIsLogin(getContext())) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2);
            c.a.p0.f1.l2.a.a(param);
            c.a.p0.f1.l2.a.b(param, c(), a());
            TiebaStatic.log(param);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getContext())));
        }
    }

    public void Z3() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (fRSRefreshButton = this.v) == null) {
            return;
        }
        fRSRefreshButton.f();
    }

    @Override // c.a.p0.f1.g2.a, c.a.p0.f1.u0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f32264f : (String) invokeV.objValue;
    }

    public void a3(Object obj) {
        c.a.p0.f1.h2.b bVar;
        c.a.d.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, obj) == null) || (bVar = this.Z) == null || (eVar = bVar.j) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void a4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(str);
            bdTopToast.j(this.t.n0());
        }
    }

    @Override // c.a.p0.f1.h2.l
    public FrsModelController b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.U : (FrsModelController) invokeV.objValue;
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z2) == null) {
            c.a.p0.z3.c.g().h(getUniqueId(), z2);
        }
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
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

    @Override // c.a.p0.f1.u0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? (!W2() || Y2() || UbsABTestHelper.isFrsModifyABTestA()) ? false : true : invokeV.booleanValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || c.a.d.f.p.m.isEmpty(this.l)) {
            return;
        }
        c.a.o0.a.d.y().Q(c.a.o0.a.c.Y, c.a.d.f.m.b.g(this.l, 0L));
    }

    @Override // c.a.p0.f1.r0
    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            c.a.p0.f1.q qVar = this.t;
            if (qVar == null) {
                return null;
            }
            return qVar.g0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    public boolean d3(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048642, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (c.a.p0.f1.b.f().i()) {
                c.a.p0.f1.b.f().m();
                return true;
            } else if (c.a.p0.f1.a.h().j()) {
                c.a.p0.f1.q qVar = this.t;
                if (qVar != null && qVar.F0()) {
                    this.t.c1();
                    return true;
                }
                c.a.p0.f1.a.h().n();
                return true;
            } else {
                c.a.p0.f1.q qVar2 = this.t;
                if (qVar2 != null) {
                    return qVar2.P0();
                }
                return false;
            }
        }
        return invokeIL.booleanValue;
    }

    public void d4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (voiceManager = this.r) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // c.a.p0.h.e.b
    public void dispatchInjectPluginMessage(c.a.p0.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, dVar) == null) {
            this.q0.a(dVar);
        }
    }

    public void e3(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, intent) == null) || intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.f32264f = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.f32265g = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
        this.j = booleanExtra;
        if (booleanExtra) {
            u2();
        }
    }

    public void e4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // c.a.p0.f1.g2.a
    public FrsViewData f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.y : (FrsViewData) invokeV.objValue;
    }

    public void f3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048648, this, str) == null) && TbadkCoreApplication.isLogin() && !c.a.d.f.p.m.isEmpty(str)) {
            if (this.B0 == null) {
                this.B0 = new AddExperiencedModel(j());
            }
            this.B0.C(this.l, str);
        }
    }

    public void f4(Object obj) {
        c.a.p0.f1.h2.b bVar;
        c.a.d.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, obj) == null) || (bVar = this.Z) == null || (eVar = bVar.i) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void g(ArrayList<c.a.d.o.e.n> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            v3(!isEmpty ? 1 : 0);
            U3();
            if (isEmpty) {
                return;
            }
            if (!this.U.v0() && TbadkCoreApplication.getInst().isRecAppExist() && this.U.d0() == 1 && ((i2 = this.y.adShowSelect) == 1 || i2 == 3)) {
                this.y.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.U != null) {
                c.a.p0.f1.o2.a.h(getUniqueId(), arrayList, this.y.getForum(), this.U.c0());
            }
            c.a.p0.f1.h2.c cVar = this.m0;
            c.a.p0.a4.k0.f fVar = this.o;
            FrsViewData frsViewData = this.y;
            ArrayList<c.a.d.o.e.n> c3 = cVar.c(false, false, arrayList, fVar, false, frsViewData.adShowSelect, frsViewData.adMixFloor);
            if (c3 != null) {
                this.y.setThreadList(c3);
                this.t.D1(c3, this.y);
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                c.a.p0.f1.o2.c.m(this.y, frsModelController.T(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.y.getForum()));
        }
    }

    public final void g2(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.U) == null || this.y == null || this.t == null || !z2) {
            return;
        }
        if (!frsModelController.v0() && this.U.d0() == 1) {
            if (!this.U.s0()) {
                this.y.addCardVideoInfoToThreadList();
                this.y.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.t.W().k(c.a.p0.h0.e0.o.f15339g) ? this.y.addHotTopicDataToThreadList() : false)) {
                this.y.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && ((i2 = this.y.adShowSelect) == 1 || i2 == 3)) {
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
        if (this.t.W().k(c.a.p0.i1.b.f15492e)) {
            this.y.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.U.v0() || this.U.isNetFirstLoad)) {
            this.y.addUserRecommendToThreadList();
        }
        this.y.addVideoActivityToTop();
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (this.f32266h == 1) {
                c.a.d.f.m.h.a().b(new l0(this));
            }
            this.f32266h = 0;
        }
    }

    public void g4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            if (!this.mIsLogin) {
                FrsViewData frsViewData = this.y;
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    this.y.getAnti().setIfpost(1);
                }
                if (i2 == 0) {
                    ViewHelper.skipToLoginActivity(getActivity());
                }
            } else if (this.y != null) {
                if (i2 == 0) {
                    c.a.p0.f1.r2.t.a(this, 0);
                } else {
                    this.t.P1();
                }
            }
        }
    }

    @Override // c.a.p0.h.e.b
    public c.a.p0.h.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) ? this.h0.get(i2) : (c.a.p0.h.e.a) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.p0.f1.g2.a
    public /* bridge */ /* synthetic */ c.a.d.a.f getPageContext() {
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
            if (I2() != null && (A = I2().A()) != null) {
                Fragment fragment = A.f32887b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.y;
                        tbPageTag.sortType = c.a.p0.f1.r2.p.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.a.equals(A.f32888c)) {
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
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
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

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                i2(frsModelController.b0());
            } else {
                i2("normal_page");
            }
        }
    }

    public final void h3(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.y != null && this.W != null && this.U != null) {
                    if (!this.t.W().k(ThreadData.TYPE_VIDEO_ALA_ONLIVE)) {
                        this.y.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.y.getGameTabInfo());
                    this.t.p1(isEmpty);
                    if (!isEmpty) {
                        if (this.t0 == null) {
                            this.t0 = new c.a.p0.f1.s2.e(this, (NoPressedRelativeLayout) this.s);
                        }
                        if (this.v0 == null) {
                            this.v0 = new c.a.p0.f1.z1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.t0 = null;
                        this.v0 = null;
                    }
                    if (this.y.getForum() != null) {
                        this.f32264f = this.y.getForum().getName();
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
                    l3();
                    if (this.j0 != null) {
                        this.j0.a(this.V, this.y);
                    }
                    if (this.y.getPage() != null) {
                        v3(this.y.getPage().b());
                    }
                    ArrayList<c.a.d.o.e.n> d3 = this.m0.d(z3, true, this.y.getThreadList(), null, z2, false, this.y.adShowSelect, this.y.adMixFloor);
                    if (d3 != null) {
                        this.y.setThreadList(d3);
                    }
                    this.y.removeRedundantUserRecommendData();
                    int topThreadSize = this.y.getTopThreadSize();
                    this.m = topThreadSize;
                    if (this.o != null) {
                        this.n = true;
                        this.o.e(topThreadSize);
                        c.a.p0.f1.r2.d.a(this, this.y.getForum(), this.y.getThreadList(), this.n, G2());
                    }
                    if (this.U.d0() == 1) {
                        k3();
                        if (!z2 && this.U.getPn() == 1) {
                            p3();
                        }
                    }
                    if (this.k0 != null) {
                        this.k0.k(this.W.F());
                    }
                    T3();
                    this.t.e1();
                    this.t.m1(true, false);
                    if (z2 && this.y.isFirstTabEqualAllThread()) {
                        c.a.d.f.m.e.a().post(new z(this));
                    }
                    if (this.y.getForum() != null) {
                        this.t.N(this.y.getForum().getWarningMsg());
                    }
                    if (this.y != null && this.y.getFrsVideoActivityData() != null && c.a.o0.r.j0.b.k().m("frs_video_activity_guide", 0L) == 0) {
                        c.a.d.f.m.e.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.t.F1();
                    if (this.y != null && this.y.getForum() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.y.getForum().getId(), this.y.getForum().getName(), this.y.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.y.getForum().special_forum_type), this.y.getForum().getThemeColorInfo(), this.y.getForum().getMember_num())));
                    }
                    this.y0.e(this.y.bottomMenuList, this.y.getForum());
                    c4();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, view) == null) {
            this.t.k1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
            this.t.f0().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view) == null) {
            super.hideNetRefreshView(view);
            this.t.k1(0);
            this.t.f0().h(false);
        }
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            y3("frs_page".equals(str));
            c.a.p0.f1.p1.e.b bVar = this.j0;
            if (bVar != null) {
                bVar.c(this.V, this.t, this.y);
            }
        }
    }

    public void i3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.N = false;
            d4();
            c.a.p0.f1.q qVar = this.t;
            if (qVar != null && qVar.k0() != null) {
                this.t.k0().x();
            }
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.I0(i2, true);
            }
        }
    }

    @Override // c.a.p0.l3.v
    public TbPageContext<?> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.f32263e : invokeV.booleanValue;
    }

    public void j3() {
        c.a.p0.f1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || (qVar = this.t) == null) {
            return;
        }
        qVar.Z0();
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? l2(this.h1) : invokeV.booleanValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            d4();
            try {
                if (this.y == null) {
                    return;
                }
                this.t.K1();
                this.t.S1(k2());
                if (c.a.p0.f1.s2.h.F(this.y)) {
                    c.a.p0.f1.s2.h.E(this.y);
                }
                if (this.y.getForum() != null) {
                    this.f32264f = this.y.getForum().getName();
                    this.l = this.y.getForum().getId();
                }
                if (this.y.getPage() != null) {
                    v3(this.y.getPage().b());
                }
                this.t.E1(this.f32264f);
                this.t.j1(this.f32264f);
                TbadkCoreApplication.getInst().setDefaultBubble(this.y.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.y.getUserData().getBimg_end_time());
                g3();
                E3();
                ArrayList<c.a.d.o.e.n> threadList = this.y.getThreadList();
                if (threadList != null) {
                    this.t.D1(threadList, this.y);
                    c.a.p0.f1.r2.f.b(this.t);
                    this.V.j0(r0());
                    this.y.setFrsFragmentTag(getUniqueId());
                    this.V.Q(this.y);
                    this.W.d(this.y, this.U.T());
                    this.t.f1();
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public boolean l2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048671, this, i2)) == null) {
            if (this.Q && !this.E0 && m2(i2)) {
                FrsModelController frsModelController = this.U;
                return (frsModelController != null && frsModelController.W() && (c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean l3() {
        InterceptResult invokeV;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            c.a.p0.f1.s2.h hVar = this.V;
            if (hVar != null && (frsModelController = this.U) != null) {
                hVar.o0(frsModelController.b0(), this.y);
            }
            FrsViewData frsViewData = this.y;
            boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
            h2();
            c.a.p0.f1.q qVar = this.t;
            if (qVar != null) {
                qVar.z0();
                this.t.A0();
                FrsViewData frsViewData2 = this.y;
                if (frsViewData2 != null && frsViewData2.getActivityHeadData() != null) {
                    this.t.y0(this.y.getActivityHeadData().a());
                    if (this.y.getActivityHeadData().a() != null && !this.U0 && !this.V0) {
                        P3();
                    }
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f1.h2.l
    public void loadMore() {
        c.a.p0.f1.h2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.i(this.f32264f, this.l, this.y);
    }

    public final boolean m2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i2)) == null) ? i2 != 506 : invokeI.booleanValue;
    }

    public final void m3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            l3();
            d4();
            try {
                if (this.y == null) {
                    return;
                }
                c.a.p0.f1.z0 z0Var = null;
                this.t.D1(null, this.y);
                this.V.j0(1);
                this.t.f1();
                this.W.d(this.y, this.U.T());
                c.a.p0.f1.p2.e I = this.W.I(this.y.getFrsDefaultTabId());
                if (I != null && !TextUtils.isEmpty(I.f14384d)) {
                    z0Var = new c.a.p0.f1.z0();
                    String str = I.f14384d;
                    String str2 = I.a;
                }
                this.U.s(this.y.getFrsDefaultTabId(), 0, z0Var);
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // c.a.p0.f1.o0
    public void n() {
        c.a.p0.f1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || (qVar = this.t) == null) {
            return;
        }
        qVar.c0().scrollToPosition(0);
        this.t.T1();
    }

    @Override // c.a.p0.f1.h2.l
    public c.a.p0.f1.h2.c n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.m0 : (c.a.p0.f1.h2.c) invokeV.objValue;
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            FrsViewData frsViewData = this.y;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.y.getPrivateForumTotalInfo().a() == null || this.y.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public void n3() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (frsModelController = this.U) != null && frsModelController.d0() == 1) {
            this.V.V(this.y);
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            c.a.p0.f1.r2.r.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.f32265g);
        }
    }

    public final void o3(c.a.p0.a4.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, nVar) == null) {
            try {
                if (!this.N && nVar != null && this.y != null) {
                    this.y.receiveData(nVar);
                    h3(true, false);
                    Looper.myQueue().addIdleHandler(this.X0);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.B = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.p = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.B = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                w2(intent);
            }
            this.E = currentTimeMillis - this.B;
            this.o = new c.a.p0.a4.k0.f("frs", c.a.p0.a4.k0.f.f12235c);
            if (this.U == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.A1);
                this.U = frsModelController;
                frsModelController.v(this.f1);
                this.U.init();
            }
            this.U.S0(this.z);
            ArrayList<c.a.d.o.e.n> arrayList = null;
            if (intent != null) {
                this.U.l0(intent.getExtras());
            } else if (bundle != null) {
                this.U.l0(bundle);
            } else {
                this.U.l0(null);
            }
            if (intent != null) {
                this.V.G(intent.getExtras());
            } else if (bundle != null) {
                this.V.G(bundle);
            } else {
                this.V.G(null);
            }
            this.r = getVoiceManager();
            this.q0 = new c.a.p0.f1.p(getPageContext(), this);
            T2();
            S2(bundle);
            if (!V2()) {
                c.a.p0.f1.v0 v0Var = new c.a.p0.f1.v0(getActivity(), this.t, this.V);
                this.g0 = v0Var;
                v0Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.r = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(y2()) && !this.A0) {
                int l2 = c.a.o0.r.j0.b.k().l("key_forum_broadcast_edit_tip_number", 0);
                if (l2 < 2) {
                    c.a.o0.r.j0.b.k().w("key_forum_broadcast_edit_tip_number", l2 + 1);
                    L3();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        M3();
                    } else {
                        BdTopToast bdTopToast = new BdTopToast(getContext());
                        bdTopToast.i(false);
                        bdTopToast.h(getContext().getString(R.string.obfuscated_res_0x7f0f0640));
                        bdTopToast.j(this.t.n0());
                    }
                } else {
                    M3();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(y2()) && !this.A0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        N3();
                    } else if (Build.VERSION.SDK_INT < 23 || !c.a.o0.r.j0.b.k().h("key_forum_rule_dialog_show_frs", false)) {
                        N3();
                        c.a.o0.r.j0.b.k().u("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    N3();
                }
            }
            if (c.a.o0.x.d.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.u;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new c.a.p0.f1.h2.i();
            int i2 = -1;
            c.a.p0.f1.h2.c cVar = this.m0;
            if (cVar != null && cVar.f() != null) {
                i2 = this.m0.f().C();
                arrayList = this.m0.f().B();
            }
            c.a.p0.f1.h2.c cVar2 = new c.a.p0.f1.h2.c(this, this.E1);
            this.m0 = cVar2;
            cVar2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.m0.f().M(arrayList);
            }
            this.Y = new c.a.p0.f1.m2.a(this);
            this.n0 = new c.a.p0.f1.s2.j(this);
            this.k0 = new c.a.p0.f1.s2.a(getPageContext(), this.U.q0());
            this.Z = new c.a.p0.f1.h2.b(this);
            this.l0 = new c.a.p0.f1.h2.d(this);
            this.X = new c.a.p0.f1.h2.h(this);
            this.o0 = new c.a.p0.f1.h2.a(this);
            this.r0 = new c.a.p0.f1.s2.c(this);
            new c.a.p0.f1.h2.e(this, getUniqueId());
            this.w0 = new c.a.p0.l.a(getPageContext(), "frs");
            this.x0 = new c.a.p0.c0.c(getPageContext());
            new c.a.p0.f1.n2.c.a(getPageContext());
            registerListener(this.o1);
            registerListener(this.C1);
            registerListener(this.m1);
            registerListener(this.G1);
            registerListener(this.B1);
            registerListener(this.i1);
            registerListener(this.j1);
            registerListener(this.k1);
            registerListener(this.l1);
            registerListener(this.Y0);
            registerListener(this.Z0);
            registerListener(this.a1);
            registerListener(this.b1);
            registerListener(this.P1);
            registerListener(this.q1);
            this.r1.setSelfListener(true);
            this.r1.setTag(getPageContext().getUniqueId());
            registerListener(this.r1);
            registerListener(this.e1);
            registerListener(this.s1);
            registerListener(this.p1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.x1);
            this.Q1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.Q1);
            registerListener(this.R1);
            registerListener(this.S1);
            registerListener(this.T1);
            registerListener(this.d1);
            registerListener(this.U1);
            registerListener(this.t1);
            registerListener(this.c1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.y1);
            registerListener(this.z1);
            this.t.w0(false);
            if (!V2() && !this.A0) {
                showLoadingView(this.t.n0(), true);
                this.U.R(3, false);
            }
            c.a.p0.g1.d.a();
            d0 d0Var = new d0(this);
            c.a.p0.f1.b.f().s(d0Var);
            c.a.p0.f1.a.h().s(d0Var);
            this.t.y1(new e0(this));
            this.G0 = UtilHelper.getScreenHeight(getActivity());
            this.A0 = true;
            s2(1);
            super.onActivityCreated(bundle);
            this.F = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048683, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            c.a.p0.f1.h2.a aVar = this.o0;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.D0) {
                this.t.N0(i2);
                this.V.K(i2);
                this.W.U(i2);
                FRSRefreshButton fRSRefreshButton = this.v;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.d(i2);
                }
                c.a.p0.f1.v2.c cVar = this.s0;
                if (cVar != null) {
                    cVar.onChangeSkinType();
                }
                c.a.p0.f1.l1.a.a aVar = this.y0;
                if (aVar != null) {
                    aVar.d(getPageContext(), i2);
                }
                if (this.z0 != null) {
                    c.a.o0.w0.a.a(getPageContext(), this.z0.getRealView());
                }
                c.a.p0.f1.s2.e eVar = this.t0;
                if (eVar != null) {
                    eVar.onChangeSkinType(getPageContext(), i2);
                }
                c.a.p0.f1.i1.f fVar = this.T0;
                if (fVar != null) {
                    fVar.onChangeSkinType(getPageContext(), i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.p0.z3.c.g().i(getUniqueId());
            if (this.P0 == null) {
                this.P0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.P0);
            registerResponsedEventListener(TopToastEvent.class, this.u1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048686, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view = this.s;
            if (view == null) {
                this.s = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02fb, viewGroup, false);
                c.a.p0.f1.p1.a aVar = new c.a.p0.f1.p1.a();
                this.f32260b = aVar;
                this.j0 = aVar.c();
                this.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0735);
                this.V = new c.a.p0.f1.s2.h(this, this.f32260b, (FrsHeaderViewContainer) this.s.findViewById(R.id.obfuscated_res_0x7f090d46));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.s, this.I1);
                this.W = frsTabViewController;
                frsTabViewController.Z();
                this.V.l0(this.W);
                this.W.d0(this.g1);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.f32262d = true;
                }
                this.t = new c.a.p0.f1.q(this, this.I1, this.f32260b, this.f32262d, this.V);
                this.y0 = new c.a.p0.f1.l1.a.a(getPageContext(), this.s);
            } else {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.s.getParent()).removeView(this.s);
                }
                FrsTabViewController frsTabViewController2 = this.W;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.Z();
                }
                this.t.X0();
                this.s.setLeft(0);
                this.s.setRight(c.a.d.f.p.n.k(TbadkCoreApplication.getInst().getContext()));
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
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            c.a.p0.z3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.r1);
            unRegisterResponsedEventListener();
            this.n0.Z();
            b2 = null;
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.p0.l3.m0.a.c("FRS");
            this.r = null;
            c.a.p0.h0.u.b().e(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.p0.f1.h0.a().b(c.a.d.f.m.b.g(this.y.getForum().getId(), 0L));
            }
            c.a.p0.f1.f2.a aVar = this.p0;
            if (aVar != null) {
                aVar.v();
            }
            c.a.p0.f1.q qVar = this.t;
            if (qVar != null) {
                c.a.p0.f1.r2.q.b(qVar, this.y, c(), false, null);
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
                c.a.d.f.m.e.a().removeCallbacks(this.L0);
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
            this.V.H();
            Looper.myQueue().removeIdleHandler(this.X0);
            FrsModelController frsModelController = this.U;
            if (frsModelController != null) {
                frsModelController.i();
            }
            c.a.p0.f1.v0 v0Var = this.g0;
            if (v0Var != null) {
                v0Var.d();
            }
            c.a.p0.f1.s2.a aVar2 = this.k0;
            if (aVar2 != null) {
                aVar2.i();
            }
            c.a.p0.f1.m2.a aVar3 = this.Y;
            if (aVar3 != null) {
                aVar3.c();
            }
            c.a.p0.f1.s2.e eVar = this.t0;
            if (eVar != null) {
                eVar.g();
            }
            c.a.p0.f1.h2.a aVar4 = this.o0;
            if (aVar4 != null) {
                aVar4.o();
            }
            c.a.p0.l.a aVar5 = this.w0;
            if (aVar5 != null) {
                aVar5.h();
            }
            c.a.p0.c0.c cVar = this.x0;
            if (cVar != null) {
                cVar.g();
            }
            c.a.p0.l3.k0.a.e().g();
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController != null) {
                frsTabViewController.d0(null);
                this.W.M();
            }
            AddExperiencedModel addExperiencedModel = this.B0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            c.a.p0.f1.b.f().s(null);
            c.a.p0.f1.a.h().s(null);
            c.a.p0.f1.r2.h hVar = this.S0;
            if (hVar != null) {
                hVar.d();
            }
            if (this.P0 != null) {
                getLifecycle().removeObserver(this.P0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            U3();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.d.o.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? E2().getPreLoadHandle() : (c.a.d.o.e.q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && V2()) {
            showLoadingView(this.t.n0(), true);
            this.t.z1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.U.I0(3, true);
            E2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && c.a.d.f.p.n.C()) {
            hideNetRefreshView(this.t.X().k());
            showLoadingView(this.t.n0(), true);
            this.t.w0(false);
            this.U.I0(3, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            super.onPause();
            this.X.f(false);
            this.P = false;
            this.t.Q0();
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.t.K0(true);
            c.a.p0.f1.s2.a aVar = this.k0;
            if (aVar != null) {
                aVar.j();
            }
            c.a.o0.a.d.y().G();
            c.a.p0.f1.r2.h hVar = this.S0;
            if (hVar != null) {
                hVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                c.a.p0.f1.s2.h hVar = this.V;
                if (hVar != null) {
                    hVar.L(isPrimary());
                }
                c.a.p0.f1.q qVar = this.t;
                if (qVar != null) {
                    qVar.R0(isPrimary());
                    this.t.K0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048694, this, i2, strArr, iArr) == null) {
            c.a.p0.f1.r2.r.h(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            super.onResume();
            c.a.p0.f1.q qVar = this.t;
            if (qVar != null) {
                qVar.J0();
                this.t.S0();
            }
            this.X.f(true);
            this.P = true;
            if (a2) {
                a2 = false;
                c.a.p0.f1.q qVar2 = this.t;
                if (qVar2 != null) {
                    qVar2.T1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            c.a.p0.f1.q qVar3 = this.t;
            if (qVar3 != null) {
                qVar3.K0(false);
            }
            if (this.u0) {
                i3(6);
                this.u0 = false;
            }
            if (this.F0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    c.a.o0.s.d.f.c().h(true);
                    c.a.o0.s.d.f.c().i(this.F0.getHours(), this.F0.getMinutes());
                    if (this.t != null) {
                        c.a.o0.s.d.f.c().k(j().getPageActivity(), this.t.n0());
                    }
                }
                this.F0 = null;
            }
            c4();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.f32264f);
            bundle.putString("from", this.f32265g);
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
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            this.t.c0().stopScroll();
            if (this.t.d1()) {
                return;
            }
            if (!c.a.d.f.p.n.C()) {
                this.t.v0();
            } else if (this.U.d0() == 1) {
                U3();
                loadMore();
            } else if (this.U.hasMore()) {
                loadMore();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048698, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        T3();
        this.t.J0();
        c.a.p0.a4.f U = this.U.U();
        boolean isEmpty = ListUtils.isEmpty(this.y.getThreadList());
        if (U != null && isEmpty) {
            if (this.U.X() != 0) {
                this.U.R0();
                this.t.J0();
            } else {
                S3(U);
            }
            this.t.m1(this.y.isStarForum(), false);
            return;
        }
        S3(U);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            super.onStop();
            c.a.p0.h0.u.b().e(false);
            b3(false);
            FrsViewData frsViewData = this.y;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                c.a.o0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.y.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.r;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (E2() != null) {
                E2().getRecycledViewPool().clear();
            }
            this.V.I();
            c.a.o0.c1.h0.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            if (!n2() && this.y.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                w3(this.y.getPrivateForumTotalInfo().a().private_forum_audit_status, this.y.getPrivateForumTotalInfo().b(), false);
            } else {
                w3(null, null, true);
            }
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            if (this.p0 == null) {
                this.p0 = new c.a.p0.f1.f2.a(this, c.a.d.f.m.b.e(this.l, 0));
            }
            this.p0.w();
        }
    }

    public final void q2(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048704, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<c.a.d.o.e.n> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = threadList.iterator();
        List<c.a.d.o.e.n> data = this.t.c0().getData();
        int i2 = 0;
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next instanceof a2) {
                ThreadData threadData = ((a2) next).s;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m0.j(next);
                        this.t.c0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void q3(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) || (frsTabViewController = this.W) == null) {
            return;
        }
        frsTabViewController.v = z2;
    }

    @Override // c.a.p0.f1.o0
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && isAdded() && this.i0 && !isLoadingViewAttached()) {
            showLoadingView(this.t.n0(), true);
        }
    }

    @Override // c.a.p0.l3.v
    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            c.a.p0.f1.h2.c cVar = this.m0;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || ListUtils.isEmpty(c.a.p0.f1.a.h().i()) || this.t.c0() == null || this.t.c0().getData() == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> threadList = this.y.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<c.a.d.o.e.n> it = threadList.iterator();
        List<c.a.d.o.e.n> data = this.t.c0().getData();
        int count = ListUtils.getCount(c.a.p0.f1.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            c.a.d.o.e.n next = it.next();
            if (next instanceof a2) {
                ThreadData threadData = ((a2) next).s;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(c.a.p0.f1.a.h().i().get(i3).getId(), threadData.getId())) {
                        it.remove();
                        data.remove(next);
                        this.m0.j(next);
                        this.t.c0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void r3() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.o A;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048709, this) == null) || (frsTabViewController = this.W) == null || (A = frsTabViewController.A()) == null || (fragment = A.f32887b) == null || !(fragment instanceof c.a.p0.f1.q0)) {
            return;
        }
        ((c.a.p0.f1.q0) fragment).A0();
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            c.a.p0.v.d.c().f("page_frs");
            i3(3);
        }
    }

    public final void s2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
            FrsViewData frsViewData = this.y;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.y.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z2) == null) {
            this.f32263e = z2;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.f32265g = str;
        }
    }

    @Override // c.a.p0.h.e.b
    public void setInjectPlugin(int i2, c.a.p0.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048714, this, i2, aVar) == null) {
            this.h0.put(i2, aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.W;
            if (frsTabViewController == null || frsTabViewController.A() == null || !(this.W.A().f32887b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.W.A().f32887b).setPrimary(z2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048716, this, view, z2) == null) {
            this.t.k1(8);
            ((FrsActivity) getActivity()).showLoadingView(view, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, true);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048717, this, view, str, z2) == null) {
            super.showNetRefreshView(view, getResources().getString(R.string.obfuscated_res_0x7f0f0f65), null, getResources().getString(R.string.obfuscated_res_0x7f0f0f64), z2, getNetRefreshListener());
            this.t.k1(8);
            this.t.f0().h(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048718, this, view, str, z2) == null) {
            super.showNetRefreshViewNoClick(view, str, z2);
            this.t.k1(8);
        }
    }

    public final void t2(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048719, this, j2) == null) || j2 <= 0) {
            return;
        }
        c.a.d.f.m.e.a().postDelayed(new k0(this, j2, c.a.d.f.p.n.k(TbadkCoreApplication.getInst()), c.a.d.f.p.n.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public void t3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i2) == null) {
            this.f32266h = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            this.t.T1();
        }
    }

    public void u3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            this.f32264f = str;
        }
    }

    public c.a.p0.f1.p1.e.b v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.j0 : (c.a.p0.f1.p1.e.b) invokeV.objValue;
    }

    public void v3(int i2) {
        c.a.p0.f1.h2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048725, this, i2) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.n(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            FrsViewData frsViewData = this.y;
            if (frsViewData != null) {
                return c.a.o0.c1.t0.a(2) || (c.a.o0.c1.t0.e() && frsViewData.isFrsVideoAutoPlay);
            }
            return super.videoNeedPreload();
        }
        return invokeV.booleanValue;
    }

    public final void w2(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048727, this, intent) == null) || intent == null) {
            return;
        }
        if (!c.a.p0.f1.r2.o.a(this, a(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
            getActivity().finish();
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.z = uri != null ? uri.toString() : null;
        if (uri != null) {
            this.f32264f = uri.getQueryParameter("name");
            this.f32265g = uri.getQueryParameter("from");
            if (!StringUtils.isNull(this.f32264f)) {
                intent.putExtra("name", this.f32264f);
            }
            if (!StringUtils.isNull(this.f32265g)) {
                intent.putExtra("from", this.f32265g);
            }
            TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
        }
        if (!StringUtils.isNull(this.f32264f) || uri == null) {
            return;
        }
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            BdUniDispatchSchemeController.getInstance().parseFrsScheme(uri, this.D1);
        } else {
            c.a.p0.f1.r2.j b3 = c.a.p0.f1.r2.r.b(intent);
            if (b3 != null) {
                this.f32264f = b3.a;
                String str = b3.f14486b;
                if (str != null) {
                    str.equals("aidou");
                }
            }
        }
        if (!StringUtils.isNull(this.f32264f)) {
            intent.putExtra("name", this.f32264f);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void w3(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048728, this, num, num2, z2) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                c.a.p0.f1.p1.b f2 = this.f32260b.f();
                if (f2 == null) {
                    return;
                }
                f2.S0().i(num, num2, z2);
                if (z2) {
                    return;
                }
                this.V.u();
            } else if (this.t.l0() == null) {
            } else {
                TextView l02 = this.t.l0();
                if (z2) {
                    l02.setVisibility(8);
                    return;
                }
                int i2 = 2;
                if (num.intValue() == 2) {
                    l02.setText("修改实名认证信息");
                    l02.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.l + "&nomenu=1";
                } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                    l02.setText("目标已完成" + String.valueOf(num2) + "%");
                    l02.setVisibility(0);
                    str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.l + "&fn=" + this.f32264f + "&nomenu=1";
                    i2 = 1;
                } else {
                    l02.setVisibility(8);
                    str = "";
                    i2 = 0;
                }
                l02.setOnClickListener(new y(this, i2, str));
            }
        }
    }

    @Override // c.a.p0.f1.h2.l
    public c.a.p0.f1.q x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.t : (c.a.p0.f1.q) invokeV.objValue;
    }

    public ForumWriteData x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
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
            forumWriteData.frsTabInfo = J2();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z2) == null) {
            this.Q = z2;
        }
    }

    public String y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.f32265g : (String) invokeV.objValue;
    }

    public void y3(boolean z2) {
        c.a.p0.f1.s2.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048733, this, z2) == null) || (jVar = this.n0) == null) {
            return;
        }
        jVar.b0();
    }

    @Override // c.a.p0.l3.v
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public c.a.d.o.e.w z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.N1 : (c.a.d.o.e.w) invokeV.objValue;
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            this.E0 = z2;
        }
    }
}
