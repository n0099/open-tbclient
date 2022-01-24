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
import c.a.s0.a.g;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.s0.s.s.a;
import c.a.t0.k.f;
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
import com.baidu.searchbox.fluency.BdTracesManager;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes12.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, c.a.t0.e1.q2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, c.a.t0.e1.u0, c.a.t0.k3.u, c.a.t0.e1.r2.l, c.a.t0.h.e.b, c.a.t0.e1.o0, c.a.t0.e1.r0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACK_SPECIAL = "back_special";
    public static final String BOOK_FRS = "book_page";
    public static final String BRAND_FRS = "brand_page";
    public static final int CLICK_MORE_THREAD_LIMIT = 3;
    public static final String FLAG = "flag";
    public static final String FORUM_KW = "kw=";
    public static final String FROM = "from";
    public static final String FROM_FRS_TYPE = "from_frs";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final int FRS_FLAG_ADD_SEARCH_HIS = 1;
    public static final int FRS_FLAG_NORMAL = 0;
    public static final String FRS_FROM_LIKE = "tb_forumlist";
    public static final String GOOD = "good";
    public static final int HEAD_LINE_DEFAULT_NAV_TAB_ID = -1;
    public static final int INVITATION_TYPE_FORUM_OWNER = 1;
    public static final String KEY_REFRESH = "refresh_all";
    public static final int LOAD_MORE_PAGE_FRS = 1;
    public static final int LOAD_MORE_PAGE_FRS_GOOD = 2;
    public static final int LOAD_MORE_PAGE_FRS_NEW_AREA = 3;
    public static final String MTJ_FORUM_FORTUNE_CLICK = "forum_fortune_click";
    public static final String NAME = "name";
    public static final String NORMAL_FRS = "normal_page";
    public static final int ONLY_SHOW_DEFAULT_TAB = 7;
    public static final String SCHEME_FROM = "schemeFrom";
    public static final String STAR_FRS = "frs_page";
    public static final int UPDATA_TYPE_CHANGE_TAB = 5;
    public static final int UPDATA_TYPE_LOAD_MORE = 4;
    public static final int UPDATA_TYPE_NEXT = 1;
    public static final int UPDATA_TYPE_PREVIOUS = 2;
    public static final int UPDATA_TYPE_REFRESH = 3;
    public static final int UPDATA_TYPE_REFRESH_WITHOUT_CACHE = 6;
    public static final int WRITE_TEXT = 0;
    public static c.a.t0.x3.m cacheData;
    public static boolean isNeedRefreshOnBackFromBarDetail;
    public static volatile int mNetError;
    public static volatile long mPbLoadDataSize;
    public static volatile long mPbLoadTime;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int A0;
    public CustomMessageListener A1;
    public boolean B;
    public c.a.t0.e1.z2.h B0;
    public CustomMessageListener B1;
    public String C;
    public c.a.t0.e1.s1.f C0;
    public HttpMessageListener C1;
    public a.C0204a D;
    public boolean D0;
    public CustomMessageListener D1;
    public ThreadCardViewHolder E;
    public boolean E0;
    public c.a.t0.g1.a E1;
    public FrsModelController F;
    public Object F0;
    public c.a.t0.e1.a3.h G;
    public MessageQueue.IdleHandler G0;
    public FrsTabViewController H;
    public final CustomMessageListener H0;
    public c.a.t0.e1.r2.h I;
    public CustomMessageListener I0;
    public c.a.t0.e1.u2.a J;
    public CustomMessageListener J0;
    public c.a.t0.e1.r2.b K;
    public CustomMessageListener K0;
    public c.a.t0.e1.v0 L;
    public CustomMessageListener L0;
    public SparseArray<c.a.t0.h.e.a> M;
    public c.a.d.c.g.a M0;
    public boolean N;
    public CustomMessageListener N0;
    public c.a.t0.e1.z1.e.b O;
    public final c.a.t0.e1.t0 O0;
    public c.a.t0.e1.a3.a P;
    public FrsTabViewController.n P0;
    public c.a.t0.e1.r2.d Q;
    public int Q0;
    public c.a.t0.e1.r2.c R;
    public CustomMessageListener R0;
    public c.a.t0.e1.a3.j S;
    public CustomMessageListener S0;
    public c.a.t0.e1.r2.a T;
    public final CustomMessageListener T0;
    public c.a.t0.e1.p2.a U;
    public final CustomMessageListener U0;
    public c.a.t0.e1.p V;
    public final CustomMessageListener V0;
    public c.a.t0.e1.d3.a W;
    public final AntiHelper.k W0;
    public c.a.t0.e1.a3.e X;
    public CustomMessageListener X0;
    public boolean Y;
    public CustomMessageListener Y0;
    public c.a.t0.e1.j2.b Z;
    public CustomMessageListener Z0;
    public c.a.t0.k.a a0;
    public CustomMessageListener a1;
    public c.a.t0.a0.c b0;
    public CustomMessageListener b1;
    public c.a.t0.e1.v1.a.a c0;
    public HttpMessageListener c1;
    public long createTime;
    public boolean createWithGame;
    public c.a.s0.s.s.a d0;
    public c.a.s0.k0.i d1;
    public long dataParseTime;
    public long drawStartTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f43062e;
    public boolean e0;
    public final CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.e1.z1.a f43063f;
    public AddExperiencedModel f0;
    public CustomMessageListener f1;
    public String forumId;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43064g;
    public boolean g0;
    public final CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43065h;
    public boolean h0;
    public CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43066i;
    public boolean i0;
    public CustomMessageListener i1;
    public long initTime;
    public boolean isPageStayDurationClose;

    /* renamed from: j  reason: collision with root package name */
    public String f43067j;
    public final CustomMessageListener j1;
    public int k;
    public Date k0;
    public final CustomMessageListener k1;
    public boolean l;
    public final g.b l1;
    public long layoutTime;
    public c.a.t0.x3.j0.f m;
    public final c.a.t0.e1.r2.k m1;
    public final View.OnClickListener mCommenOnClickListener;
    public c.a.t0.e1.a3.c mEnterFrsDialogController;
    public int mFlag;
    public String mForum;
    public final c.a.t0.x3.t mForumModelCallback;
    public String mFrom;
    public int mHeadLineDefaultNavTabId;
    public final View.OnTouchListener mOnTouchListener;
    public boolean mSpeedUpTipShowing;
    public final e2 mThreadData;
    public boolean n;
    public final CustomMessageListener n1;
    public boolean o;
    public final RecyclerView.OnScrollListener o1;
    public VoiceManager p;
    public final c.a.t0.e1.f p1;
    public c.a.s0.s0.b perfFluencyLogData;
    public long pullBeginTime;
    public View q;
    public int q0;
    public final NoNetworkView.b q1;
    public c.a.t0.e1.q r;
    public int r0;
    public final CustomMessageListener r1;
    public OvalActionButton s;
    public int s0;
    public c.a.d.n.e.v s1;
    public long sysCreateTime;
    public FRSRefreshButton t;
    public List<LiveHorseRaceData> t0;
    public c.a.t0.e1.t0 t1;
    public LinearLayout u;
    public ValueAnimator u0;
    public CustomMessageListener u1;
    public FrsViewData v;
    public Runnable v0;
    public CustomMessageListener v1;
    public String w;
    public c.a.t0.e1.p2.b w0;
    public CustomMessageListener w1;
    public c.a.d.f.k.b<TbImageView> x;
    public c.a.t0.e1.w1.a x0;
    public CustomMessageListener x1;
    public boolean y;
    @Nullable
    public TiePlusEventController y0;
    public CustomMessageListener y1;
    public boolean z;
    public int z0;
    public CustomMessageListener z1;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                boolean z = false;
                if (i2 != 1) {
                    c.a.t0.g0.v.b().e(false);
                    this.a.logStatisticByKey(false);
                }
                if (i2 == 502) {
                    this.a.s.setIconFade(c.a.t0.e1.e1.btn_frs_professional_edit_n);
                } else {
                    this.a.s.setIconFade(0);
                }
                this.a.Q0 = i2;
                this.a.z0 = i3;
                if (this.a.w0 != null) {
                    this.a.w0.d(this.a.z0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.a.z0);
                this.a.stopVoice();
                c.a.t0.e1.w2.b bVar = c.a.t0.e1.w2.d.p0;
                bVar.f17049d = i2;
                bVar.f17052g = i3;
                bVar.f17050e = -1;
                if (!this.a.g0) {
                    this.a.r.P1(this.a.G0(i2));
                    return;
                }
                c.a.t0.e1.b.f().p(i2 == 1 && this.a.g0, true);
                c.a.t0.e1.a h2 = c.a.t0.e1.a.h();
                if (i2 == 1 && this.a.g0) {
                    z = true;
                }
                h2.p(z, true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43068e;

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
            this.f43068e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43068e.r.O1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.t != null) {
                    if (booleanValue) {
                        if (this.a.H.J() == 0 || this.a.r.E0() || c.a.s0.y.d.h().k()) {
                            return;
                        }
                        this.a.t.show();
                        return;
                    }
                    this.a.t.hide();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.H.i0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes12.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.v.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.a.r.V().notifyDataSetChanged();
        }
    }

    /* loaded from: classes12.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f43069e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43070f;

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
            this.f43070f = frsFragment;
            this.f43069e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (this.f43070f.v != null && this.f43070f.v.getForum() != null) {
                    str = this.f43070f.v.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.f43070f.forumId).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.f43069e.getLive_id() != null) {
                    alaInfoData.live_id = this.f43069e.getLive_id().longValue();
                    alaInfoData.screen_direction = this.f43069e.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f43070f.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.f43070f.forumId)));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.a.v == null) {
                return;
            }
            c.a.t0.e1.z2.t.c(this.a.v, this.a.getPageContext());
        }
    }

    /* loaded from: classes12.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.a.v == null || (userData = this.a.v.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.a.G.I(num);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.t == null || this.a.s == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                this.a.t.setVisibility(8);
                this.a.s.setVisibility(8);
                return;
            }
            this.a.s.setVisibility(0);
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.H.b(49);
        }
    }

    /* loaded from: classes12.dex */
    public class d0 implements c.a.t0.e1.x0 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.t0.e1.x0
        public void a(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.a.r == null) {
                return;
            }
            boolean z3 = false;
            if (i2 == 1) {
                this.a.r.t1(c.a.t0.e1.b.f().h());
                this.a.r.u1(z ? 0 : 8);
            } else if (i2 == 2) {
                this.a.r.q1(z ? 0 : 8);
            }
            if (!z2) {
                this.a.g0 = z;
            }
            if (this.a.r.V() != null && (i2 == 2 || (this.a.F != null && this.a.F.U()))) {
                this.a.r.V().notifyDataSetChanged();
            }
            if (this.a.getTabController() != null) {
                FrsTabViewController.o A = this.a.getTabController().A();
                if (A != null) {
                    if ((A.f43769b instanceof FrsCommonTabFragment) && (i2 == 2 || A.a == 502)) {
                        ((FrsCommonTabFragment) A.f43769b).refreshRecyclerView();
                    } else if ((A.f43769b instanceof FrsNewAreaFragment) && (i2 == 2 || A.a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) A.f43769b;
                        frsNewAreaFragment.refreshRecyclerView();
                        if (frsNewAreaFragment.getFrsView() != null) {
                            c.a.t0.e1.r2.g frsView = frsNewAreaFragment.getFrsView();
                            frsView.G(!z);
                            if (i2 == 1) {
                                frsView.D(!z);
                            } else if (i2 == 2) {
                                frsView.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = A.f43769b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).refreshRecyclerView();
                        }
                    }
                }
                if (this.a.getTabController().K() != null) {
                    this.a.getTabController().K().setmDisallowSlip(z);
                    this.a.getTabController().f0(z);
                }
            }
            if (this.a.r.X() != null) {
                c.a.t0.e1.q qVar = this.a.r;
                if (this.a.canShowWriteButton() && !z) {
                    z3 = true;
                }
                qVar.P1(z3);
            }
            if (this.a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.a.getActivity()).showTabHost(!z);
            }
            if (this.a.c0 != null) {
                this.a.c0.f(!z);
            }
            this.a.r.z1(!z);
            if (i2 == 1) {
                this.a.r.p1(!z);
            } else if (i2 == 2) {
                this.a.r.p1(true);
            }
        }

        @Override // c.a.t0.e1.x0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a.getContext() == null) {
                return;
            }
            if (i2 != 1) {
                if (i2 != 2 || this.a.r == null) {
                    return;
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getContext().getString(c.a.t0.e1.i1.frs_move_area_max_num)).show(this.a.r.k0());
                return;
            }
            c.a.d.f.p.n.M(this.a.getContext(), c.a.t0.e1.i1.frs_multi_delete_max_num);
        }

        @Override // c.a.t0.e1.x0
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.a.r == null) {
                return;
            }
            if (i3 == 1) {
                this.a.r.s1(i2);
            } else if (i3 == 2) {
                this.a.r.r1(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f43071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43072f;

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
            this.f43072f = frsFragment;
            this.f43071e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f43071e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f43071e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(c.a.t0.e1.d1.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.H.b(1);
                this.a.N0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes12.dex */
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

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes12.dex */
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

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
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
            this.a = frsFragment;
        }

        @Override // c.a.t0.k.f.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.a.r.R();
            this.a.r.Q();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.a.H == null || this.a.H.A() == null || !(this.a.H.A().f43769b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.a.H.A().f43769b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.a.getString(c.a.t0.e1.i1.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.a.d0 == null) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.d0 = new c.a.s0.s.s.a(frsFragment.getActivity());
                    }
                    this.a.d0.setMessage(text);
                    this.a.d0.setPositiveButton(c.a.t0.e1.i1.dialog_known, new a(this));
                    this.a.d0.setCanceledOnTouchOutside(false);
                    this.a.d0.create(this.a.getPageContext());
                    this.a.d0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.a.d0 == null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.d0 = new c.a.s0.s.s.a(frsFragment2.getActivity());
                    }
                    this.a.d0.setMessage(text);
                    this.a.d0.setPositiveButton(c.a.t0.e1.i1.know, new b(this));
                    this.a.d0.setCanceledOnTouchOutside(false);
                    this.a.d0.create(this.a.getPageContext());
                    this.a.d0.show();
                } else {
                    this.a.r.K1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? c.a.t0.e1.c1.nav_bar_tip_error : c.a.t0.e1.c1.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.processBatchDelete(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.a.J0(deleteThreadHttpResponseMessage.getSuccessItems());
                c.a.t0.e1.b.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (c.a.d.n.e.n nVar : this.a.v.getThreadList()) {
                    if (nVar instanceof d2) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.a.loadMore();
                    return;
                }
                return;
            }
            c.a.d.f.p.n.N(this.a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes12.dex */
    public class e1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f43073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43074f;

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
            this.f43074f = frsFragment;
            this.f43073e = frsRedpackRunView;
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
                this.f43073e.setAlpha(0.0f);
                this.f43073e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(c.a.t0.e1.d1.tbds660));
                this.f43073e.hide();
                this.f43074f.u.removeView(this.f43073e);
                if (this.f43074f.t0 == null || this.f43074f.s0 <= this.f43074f.t0.size() - 1) {
                    this.f43074f.Q0();
                    return;
                }
                this.f43074f.u.removeAllViews();
                this.f43074f.u.setVisibility(8);
                this.f43074f.s0 = 0;
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

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.t0.x3.x) || this.a.v == null) {
                return;
            }
            this.a.v.updateLikeData((c.a.t0.x3.x) customResponsedMessage.getData());
            this.a.G.L(this.a.v);
            this.a.H.d(this.a.v, this.a.F.R());
        }
    }

    /* loaded from: classes12.dex */
    public class f0 implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f43075e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f0 f43076f;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            public class RunnableC1916a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f43077e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f43078f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f43079g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f43080h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ int f43081i;

                /* renamed from: j  reason: collision with root package name */
                public final /* synthetic */ a f43082j;

                public RunnableC1916a(a aVar, long j2, int i2, int i3, float f2, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f43082j = aVar;
                    this.f43077e = j2;
                    this.f43078f = i2;
                    this.f43079g = i3;
                    this.f43080h = f2;
                    this.f43081i = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.f43077e, 0L, 0L, this.f43078f, this.f43079g, this.f43080h, this.f43081i);
                        requestGetMyPostNetMessage.setTag(this.f43082j.f43076f.a.getUniqueId());
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
                this.f43076f = f0Var;
                this.f43075e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43076f.a.H.b(301);
                    c.a.d.f.m.e.a().postDelayed(new RunnableC1916a(this, c.a.d.f.m.b.g((String) this.f43075e.get(c.a.s0.a.g.u), 0L), c.a.d.f.p.n.k(TbadkCoreApplication.getInst()), c.a.d.f.p.n.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
            this.a = frsFragment;
        }

        @Override // c.a.s0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(c.a.s0.a.g.t) instanceof String) {
                this.a.mForum = (String) hashMap.get(c.a.s0.a.g.t);
            }
            if (!(hashMap.get(c.a.s0.a.g.O) instanceof String) || TextUtils.isEmpty((String) hashMap.get(c.a.s0.a.g.O))) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes12.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f43083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43084f;

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
            this.f43084f = frsFragment;
            this.f43083e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43084f.u == null || this.f43083e == null) {
                return;
            }
            this.f43084f.u0.start();
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.v == null) {
                return;
            }
            this.a.v.removeGameRankListFromThreadList();
            if (this.a.r != null) {
                this.a.r.F0();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.a.v.getToLoadHorseData().intValue() == 1 && this.a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.a.forumId));
                this.a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f40771c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.W0) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().a && updateAttentionMessage.getData().f40772d) {
                    c.a.d.f.p.n.M(this.a.getPageContext().getPageActivity(), c.a.t0.e1.i1.attention_success);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h0 implements c.a.t0.e1.r2.k {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.t0.e1.r2.k
        public void a(int i2, boolean z, int i3, boolean z2, ArrayList<c.a.d.n.e.n> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.a.J == null || this.a.F == null || !this.a.F.t0() || !z || z2 || z3) {
                return;
            }
            this.a.J.a(i3);
        }
    }

    /* loaded from: classes12.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.a.k0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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

    /* loaded from: classes12.dex */
    public class i0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43085e;

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
            this.f43085e = frsFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f43085e.L != null && this.f43085e.L.e() != null) {
                    this.f43085e.L.e().c(motionEvent);
                }
                if (this.f43085e.Z != null) {
                    this.f43085e.Z.b(view, motionEvent);
                }
                if (this.f43085e.G != null) {
                    this.f43085e.G.H(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.s.q.a0) && this.a.isResumed()) {
                c.a.s0.s.q.a0 a0Var = (c.a.s0.s.q.a0) customResponsedMessage.getData();
                if (this.a.x0 == null) {
                    FrsFragment frsFragment = this.a;
                    frsFragment.x0 = new c.a.t0.e1.w1.a(frsFragment.getPageContext());
                }
                if (this.a.v == null || this.a.v.getForum() == null || TextUtils.isEmpty(this.a.v.getForum().getId())) {
                    return;
                }
                this.a.x0.g(a0Var.a, this.a.v.getForum().getId(), this.a.v.getForum().getName(), a0Var.f13458b);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.r.N1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
            if (k.l(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || this.a.v.getForum() == null) {
                return;
            }
            this.a.v.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes12.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e2 e2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (e2Var = (e2) customResponsedMessage.getData()) != null && this.a.isResumed()) {
                FrsFragment frsFragment = this.a;
                frsFragment.C = e2Var.w1() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", e2Var.U());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.refreshLevel();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43088g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f43089h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43090i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43091j;

        public k0(FrsFragment frsFragment, long j2, int i2, int i3, float f2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43091j = frsFragment;
            this.f43086e = j2;
            this.f43087f = i2;
            this.f43088g = i3;
            this.f43089h = f2;
            this.f43090i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.f43086e, 0L, 0L, this.f43087f, this.f43088g, this.f43089h, this.f43090i);
                requestGetMyPostNetMessage.setTag(this.f43091j.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k1 f43092e;

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
                this.f43092e = k1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f43092e.a.v.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.t0.x3.j0.n(this.f43092e.a.getContext(), "ForumGradePage", hashMap)));
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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg) && this.a.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(this.a.getContext()).setTitle(this.a.getString(c.a.t0.e1.i1.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.a.getString(c.a.t0.e1.i1.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.a.q.findViewById(c.a.t0.e1.f1.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                forumBroadcastHelper.jumpFlutterEditGenear(this.a.v.getForum().getId(), this.a.v.getForum().getName(), "6");
                forumBroadcastHelper.clipCopy(this.a.C);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), this.a.forumId)) {
                this.a.T.m(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43093e;

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
            this.f43093e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.x3.p0.a.o(this.f43093e.mForum);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.t0.k.h hVar = (c.a.t0.k.h) customResponsedMessage.getData();
            if (this.a.v == null || this.a.v.getForum() == null || this.a.v.getForum().getDeletedReasonInfo() == null) {
                c.a.t0.k.e.d(0, this.a.getPageContext(), hVar, null, this.a.v.getUserData());
                return;
            }
            c.a.t0.k.i iVar = new c.a.t0.k.i(this.a.v.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.v.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.v.forumRule != null ? this.a.v.forumRule.has_forum_rule.intValue() : 0);
            iVar.i(this.a.v.getForum().getId(), this.a.v.getForum().getName());
            iVar.h(this.a.v.getForum().getImage_url());
            iVar.j(this.a.v.getForum().getUser_level());
            c.a.t0.k.e.d(iVar.f(), this.a.getPageContext(), hVar, iVar, this.a.v.getUserData());
        }
    }

    /* loaded from: classes12.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.a.r != null) {
                    this.a.r.W0(msgCount, z);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f43094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43095f;

        public m0(FrsFragment frsFragment, c.a.s0.s.s.a aVar) {
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
            this.f43095f = frsFragment;
            this.f43094e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.s0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f43094e) == null) {
                return;
            }
            aVar.dismiss();
            this.f43095f.c1();
        }
    }

    /* loaded from: classes12.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.H.A() == null || !(this.a.H.A().f43769b instanceof BaseFragment) || !((BaseFragment) this.a.H.A().f43769b).isPrimary() || this.a.r.E0()) {
                this.a.u.setVisibility(8);
                this.a.y = true;
                return;
            }
            this.a.u.setVisibility(0);
            this.a.y = false;
        }
    }

    /* loaded from: classes12.dex */
    public class n extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.a.getContext() == null || this.a.r == null) {
                return;
            }
            int i2 = 0;
            if (httpResponsedMessage.getError() == 0) {
                new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getContext().getString(c.a.t0.e1.i1.frs_move_area_move_suc)).show(this.a.r.k0());
                if (c.a.t0.e1.a.h().k(c.a.t0.e1.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.a.H != null && this.a.H.A() != null && (this.a.H.A().f43769b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.a.H.A().f43769b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.processBatchDelete();
                    }
                    this.a.K0();
                    c.a.t0.e1.a.h().d();
                    for (c.a.d.n.e.n nVar : this.a.v.getThreadList()) {
                        if (nVar instanceof d2) {
                            i2++;
                            continue;
                        }
                        if (i2 >= 6) {
                            break;
                        }
                    }
                    if (i2 < 6) {
                        this.a.loadMore();
                    }
                }
                c.a.t0.e1.a.h().n();
                return;
            }
            new BdTopToast(this.a.getContext()).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show(this.a.r.k0());
        }
    }

    /* loaded from: classes12.dex */
    public class n0 implements c.a.s0.s.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.s0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.s0.y.d.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.a.s != null) {
                        this.a.s.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getContext().getString(c.a.t0.e1.i1.forum_broadcast_copy_no_permission_hint)).show(this.a.r.k0());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n1 extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
                if (this.a.t0 != null) {
                    if (this.a.u == null || this.a.u.getVisibility() != 8) {
                        if (this.a.s0 >= this.a.t0.size()) {
                            this.a.t0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = this.a;
                        frsFragment.t0 = frsFragment.t0.subList(0, this.a.s0);
                        this.a.t0.addAll(arrayList);
                        return;
                    }
                    this.a.t0 = new ArrayList();
                    this.a.t0.addAll(arrayList);
                    this.a.s0 = 0;
                    this.a.Q0();
                    return;
                }
                this.a.t0 = new ArrayList();
                this.a.s0 = 0;
                this.a.t0.addAll(arrayList);
                this.a.Q0();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o extends c.a.s0.k0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43096g;

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
            this.f43096g = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.k0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                new BdTopToast(this.f43096g.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.f43096g.r.k0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class o0 implements c.a.s0.s.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.s0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                c.a.s0.y.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.a.s != null) {
                    this.a.s.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
                this.a.N0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isResumed()) {
                this.a.m1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43097e;

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
            this.f43097e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f43097e.r != null && view == this.f43097e.r.T() && this.f43097e.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f43097e.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view.getId() == c.a.t0.e1.f1.game_activity_egg_layout && c.a.d.f.p.n.C()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.f43097e.r == null || !this.f43097e.r.A0()) {
                        String c2 = this.f43097e.v.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c2)) {
                            c.a.s0.m.a.l(this.f43097e.getPageContext().getPageActivity(), c2);
                        }
                    } else {
                        this.f43097e.r.F1();
                    }
                }
                if (this.f43097e.r != null && view == this.f43097e.r.b0() && this.f43097e.F != null && this.f43097e.F.hasMore()) {
                    this.f43097e.r.I1();
                    this.f43097e.loadMore();
                }
                if (view != null && this.f43097e.r != null && view == this.f43097e.r.c0()) {
                    if (!ViewHelper.checkUpIsLogin(this.f43097e.getContext())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f43097e.getContext())));
                }
                if (c.a.d.f.p.l.z()) {
                    if (this.f43097e.v == null || this.f43097e.v.getForum() == null) {
                        return;
                    }
                    if (this.f43097e.r != null && view == this.f43097e.r.p0()) {
                        if (this.f43097e.v == null || this.f43097e.v.getForum() == null || StringUtils.isNull(this.f43097e.v.getForum().getId()) || StringUtils.isNull(this.f43097e.v.getForum().getName())) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", this.f43097e.v.getForum().getId()).param("obj_locate", 11));
                        c.a.t0.e1.z2.n.g(this.f43097e.getPageContext(), this.f43097e.v, this.f43097e.v.getForum().getId());
                    }
                    if (this.f43097e.r == null || view != this.f43097e.r.o0()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12402").param("fid", this.f43097e.v.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f43097e.v.getForum().getName()));
                    if (StringUtils.isNull(this.f43097e.v.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.f43097e.getContext(), this.f43097e.v.getForum().getName(), this.f43097e.v.getForum().getId())));
                    return;
                }
                c.a.d.f.p.n.M(this.f43097e.getContext().getApplicationContext(), c.a.t0.e1.i1.network_not_available);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p1 implements c.a.t0.e1.t0 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.t0.e1.t0
        public void a(int i2, int i3, c.a.t0.e1.m1 m1Var, ArrayList<c.a.d.n.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), m1Var, arrayList}) == null) {
                this.a.showLoadFinishedUI();
                if (this.a.O != null) {
                    this.a.G.U(this.a.O.e(i2));
                }
                c.a.t0.x3.f fVar = new c.a.t0.x3.f();
                if (m1Var != null) {
                    boolean z = m1Var.f16583e == 0;
                    fVar.f25055b = z;
                    fVar.f25056c = m1Var.f16583e;
                    fVar.f25057d = m1Var.f16584f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.a.r.s0();
                        } else if (m1Var.f16585g) {
                            if (ListUtils.getCount(this.a.v.getThreadList()) > 3) {
                                this.a.r.I1();
                            } else {
                                this.a.r.E1();
                            }
                        } else if (m1Var.f16587i) {
                            this.a.r.L1();
                        } else {
                            this.a.r.s0();
                        }
                    }
                } else {
                    m1Var = new c.a.t0.e1.m1();
                    m1Var.f17231c = 1;
                    m1Var.f16585g = false;
                    m1Var.f16587i = false;
                }
                if (i2 == 1) {
                    this.a.A = true;
                    FrsFragment frsFragment = this.a;
                    frsFragment.mForumModelCallback.d(frsFragment.F.getType(), false, fVar);
                } else {
                    this.a.f1(fVar);
                    if (this.a.F.d0() != null) {
                        FrsFragment frsFragment2 = this.a;
                        frsFragment2.v = frsFragment2.F.d0();
                    }
                    this.a.V0();
                }
                if (this.a.t1 != null) {
                    this.a.t1.a(i2, i3, m1Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.r != null) {
                    this.a.r.d1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f43098b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43099c;

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
            this.f43099c = frsFragment;
            this.a = 0;
            this.f43098b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f43099c.G != null) {
                    this.f43099c.G.e0(i2);
                    if (i2 == 1) {
                        this.f43099c.G.w();
                    }
                }
                FrsFragment frsFragment = this.f43099c;
                if (frsFragment.perfFluencyLogData == null && !frsFragment.isFromMainTab()) {
                    this.f43099c.perfFluencyLogData = new c.a.s0.s0.b();
                    this.f43099c.perfFluencyLogData.a(1000);
                }
                if (i2 != 0) {
                    if (this.f43099c.F0 == null) {
                        this.f43099c.F0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    c.a.s0.s0.b bVar = this.f43099c.perfFluencyLogData;
                    if (bVar != null) {
                        bVar.d();
                    }
                } else {
                    c.a.s0.s0.b bVar2 = this.f43099c.perfFluencyLogData;
                    if (bVar2 != null) {
                        bVar2.e();
                    }
                    c.a.t0.g0.v.b().e(true);
                    this.f43099c.logStatisticByKey(true);
                    this.f43099c.r.I0(this.a, this.f43098b);
                    if (this.f43099c.F0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f43099c.F0);
                        this.f43099c.F0 = null;
                    }
                }
                if (this.f43099c.X != null) {
                    this.f43099c.X.i(recyclerView, i2);
                }
                if (i2 == 0) {
                    c.a.t0.e1.z2.q.b(this.f43099c.r, this.f43099c.v, this.f43099c.getForumId(), false, null);
                }
                if (this.f43099c.H != null && i2 == 1) {
                    this.f43099c.H.M();
                }
                if (this.f43099c.E == null) {
                    if (this.f43099c.r.h0() != null && !this.f43099c.r.Z() && this.f43099c.r.h0().j() != null && (this.f43099c.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.f43099c;
                        frsFragment2.E = (ThreadCardViewHolder) frsFragment2.r.h0().j().getTag();
                    }
                } else if (i2 == 0 && this.f43099c.r.h0() != null && !this.f43099c.r.Z() && this.f43099c.r.h0().j() != null && (this.f43099c.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.f43099c;
                    frsFragment3.E = (ThreadCardViewHolder) frsFragment3.r.h0().j().getTag();
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
                this.f43099c.r0 += i3;
                if (this.f43099c.r0 >= this.f43099c.q0 * 2 && i3 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.f43099c.P != null) {
                    this.f43099c.P.j();
                }
                this.a = 0;
                this.f43098b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.a = bdRecyclerView.getFirstVisiblePosition();
                    this.f43098b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.f43099c.X != null) {
                    this.f43099c.X.h(recyclerView, this.a, this.f43098b);
                }
                if (this.f43099c.v == null || this.f43099c.r == null || this.f43099c.r.V() == null) {
                    return;
                }
                this.f43099c.r.e1(this.a, this.f43098b);
                if (this.f43099c.E == null || this.f43099c.E.getCardView() == null) {
                    return;
                }
                this.f43099c.E.getCardView().o(this.f43099c.D);
            }
        }
    }

    /* loaded from: classes12.dex */
    public final class q1 implements c.a.d.n.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43100e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43101e;

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
                this.f43101e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f43101e);
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
            this.f43100e = frsFragment;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == c.a.t0.e1.u.f16972e) {
                if (this.f43100e.r != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f43100e.forumId).param("obj_locate", "1"));
                    this.f43100e.r.Q1();
                }
            } else if (nVar == null || !(nVar instanceof d2)) {
            } else {
                e2 e2Var = ((d2) nVar).w;
                if (e2Var.E() == null || e2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f43100e.getActivity())) {
                    if (e2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f43100e.getActivity())) {
                        if (e2Var.G() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f43100e.getActivity())) {
                                String a2 = e2Var.G().a();
                                if (StringUtils.isNull(a2) || !c.a.d.f.p.n.C()) {
                                    return;
                                }
                                c.a.s0.m.a.l(this.f43100e.getActivity(), a2);
                            }
                        } else if (e2Var.M() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f43100e.getPageContext().getPageActivity());
                                return;
                            }
                            c.a.s0.s.q.u M = e2Var.M();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f43100e.getPageContext().getPageActivity(), M.a(), M.b(), 2)));
                        } else {
                            c.a.t0.x3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.d(e2Var.h0())) {
                                readThreadHistory.a(e2Var.h0());
                            }
                            String z2 = e2Var.z();
                            if (z2 == null || z2.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, z2)).start();
                                z = true;
                            }
                            String w1 = e2Var.w1();
                            if (w1 == null) {
                                w1 = "";
                            }
                            if (e2Var.t0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.f43100e.getPageContext(), new String[]{w1, "", null});
                                return;
                            }
                            if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && w1.length() > 4) {
                                e2Var.T3(w1.substring(3));
                            }
                            if (bdUniqueId.getId() == e2.c4.getId()) {
                                c.a.t0.e1.z2.q.c(e2Var.n1());
                            } else if (bdUniqueId.getId() == e2.M3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", e2Var.w1());
                                TiebaStatic.log(statisticItem);
                            }
                            c.a.t0.e1.z2.r.e(this.f43100e, e2Var, i2, z);
                            FrsFragment frsFragment = this.f43100e;
                            c.a.t0.e1.z2.q.d(frsFragment, frsFragment.v, e2Var);
                        }
                    }
                }
            }
        }

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }
    }

    /* loaded from: classes12.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || c.a.d.f.p.m.isEmpty(str) || !str.equals(this.a.forumId)) {
                    return;
                }
                c.a.t0.e1.z2.n.h(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.a.v);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.a.H.J() == 0 || this.a.H.A() == null || !(this.a.H.A().f43769b instanceof BaseFragment) || !((BaseFragment) this.a.H.A().f43769b).isPrimary() || this.a.r.E0() || c.a.s0.y.d.h().k()) {
                if (this.a.H.J() != 0) {
                    this.a.t.hide();
                    return;
                }
                return;
            }
            this.a.t.show();
        }
    }

    /* loaded from: classes12.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.r == null) {
                return;
            }
            this.a.r.N();
        }
    }

    /* loaded from: classes12.dex */
    public class s0 implements c.a.t0.e1.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
        }

        @Override // c.a.t0.e1.f
        public void a(int i2, int i3, View view, View view2, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, view2, e2Var}) == null) {
                if (i2 != this.a.r.V().d()) {
                    if (i2 != this.a.r.V().k()) {
                        if (i2 != this.a.r.V().j() || this.a.v == null || this.a.v.getUserData() == null || !this.a.v.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.a.v.getBawuCenterUrl();
                        if (c.a.d.f.p.m.isEmpty(bawuCenterUrl) || this.a.v.getForum() == null) {
                            return;
                        }
                        c.a.s0.m.a.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.a.v.getForum().getId()).param("uid", this.a.v.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.a.v == null || this.a.v.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.a.v.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), c.a.d.f.m.b.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                    TiebaStatic.log(FrsFragment.MTJ_FORUM_FORTUNE_CLICK);
                    c.a.t0.e1.z2.r.d(this.a.getPageContext(), this.a.v);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.showFrsAdvancedAdGuide();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43102e;

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
            this.f43102e = frsFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f43102e.F.b0() == 1 && z && !this.f43102e.r.Z()) {
                if (this.f43102e.v != null && !ListUtils.isEmpty(this.f43102e.v.getThreadList())) {
                    this.f43102e.r.G0();
                    return;
                }
                FrsFragment frsFragment = this.f43102e;
                frsFragment.hideNetRefreshView(frsFragment.r.W().k());
                FrsFragment frsFragment2 = this.f43102e;
                frsFragment2.showLoadingView(frsFragment2.r.k0(), true);
                this.f43102e.r.t0(false);
                this.f43102e.refresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u implements c.a.t0.x3.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43103b;

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
            this.f43103b = frsFragment;
            this.a = 0L;
        }

        @Override // c.a.t0.x3.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a = System.nanoTime();
                if (this.f43103b.r == null) {
                    return;
                }
                if (i2 == 1 || i2 == 2) {
                    this.f43103b.r.G0();
                }
            }
        }

        @Override // c.a.t0.x3.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43103b.refreshLevel();
            }
        }

        @Override // c.a.t0.x3.t
        public void c(c.a.t0.x3.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                if ((mVar == null || !(FrsFragment.NORMAL_FRS.equals(this.f43103b.F.Z()) || FrsFragment.STAR_FRS.equals(this.f43103b.F.Z()) || FrsFragment.BOOK_FRS.equals(this.f43103b.F.Z()))) && !FrsFragment.BRAND_FRS.equals(this.f43103b.F.Z())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
                this.f43103b.X0(mVar);
                FrsFragment.cacheData = mVar;
            }
        }

        @Override // c.a.t0.x3.t
        public void d(int i2, boolean z, c.a.t0.x3.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f43103b.N) {
                    this.f43103b.N = false;
                    c.a.t0.e1.z2.q.b(this.f43103b.r, this.f43103b.v, this.f43103b.getForumId(), false, null);
                }
                this.f43103b.showLoadFinishedUI();
                this.f43103b.z = true;
                if (fVar != null && fVar.f25055b) {
                    this.f43103b.r.V().o(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.mPbLoadTime = 0L;
                    FrsFragment.mPbLoadDataSize = 0L;
                    FrsFragment.mNetError = 0;
                } else {
                    FrsFragment.mNetError = 1;
                }
                if (!this.f43103b.F.t0() && (i2 == 3 || i2 == 6)) {
                    this.f43103b.R.l();
                }
                this.f43103b.drawStartTime = System.currentTimeMillis();
                if (this.f43103b.F.d0() != null) {
                    FrsFragment frsFragment = this.f43103b;
                    frsFragment.v = frsFragment.F.d0();
                }
                this.f43103b.e1(1);
                this.f43103b.Z0();
                if (i2 == 7) {
                    this.f43103b.W0(this.f43103b.v.getFrsDefaultTabId());
                    return;
                }
                if (this.f43103b.v.getPage() != null) {
                    FrsFragment frsFragment2 = this.f43103b;
                    frsFragment2.setHasMore(frsFragment2.v.getPage().b());
                }
                if (i2 == 4) {
                    if (!this.f43103b.F.t0() && TbadkCoreApplication.getInst().isRecAppExist() && this.f43103b.F.b0() == 1 && !c.a.t0.g1.a.d()) {
                        this.f43103b.v.addRecommendAppToThreadList(this.f43103b);
                    }
                    ArrayList<c.a.d.n.e.n> c2 = this.f43103b.R.c(false, false, this.f43103b.v.getThreadList(), this.f43103b.m, false);
                    if (c2 != null) {
                        this.f43103b.v.setThreadList(c2);
                        this.f43103b.v.checkLiveStageInThreadList();
                    }
                    if (this.f43103b.F != null) {
                        c.a.t0.e1.w2.c.m(this.f43103b.v, this.f43103b.F.R(), 2, this.f43103b.getContext());
                    }
                    FrsFragment frsFragment3 = this.f43103b;
                    c.a.t0.e1.z2.d.a(frsFragment3, frsFragment3.v.getForum(), this.f43103b.v.getThreadList(), false, this.f43103b.getPn());
                    this.f43103b.r.A1(c2, this.f43103b.v);
                    this.f43103b.h1();
                    return;
                }
                this.f43103b.h1();
                if (i2 == 1) {
                    this.f43103b.r.G0();
                } else if (i2 == 2) {
                    this.f43103b.r.G0();
                } else if (i2 == 3 || i2 == 6) {
                    if (this.f43103b.v != null) {
                        this.f43103b.v.clearPostThreadCount();
                    }
                    c.a.t0.e1.a3.c cVar = this.f43103b.mEnterFrsDialogController;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
                this.f43103b.l1();
                if (fVar == null || fVar.f25056c == 0) {
                    if (this.f43103b.v == null) {
                        return;
                    }
                    FrsFragment frsFragment4 = this.f43103b;
                    if (!frsFragment4.a1(frsFragment4.v)) {
                        UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, this.f43103b.getPageContext());
                        upgradePopWindowMessage.setFromPage("frs");
                        MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
                    }
                    this.f43103b.U0(false, i2 == 5);
                    if (this.f43103b.F != null) {
                        if (this.f43103b.v.getActivityHeadData() != null && this.f43103b.v.getActivityHeadData().b() != null && this.f43103b.v.getActivityHeadData().b().size() > 0) {
                            c.a.t0.e1.w2.a.g(this.f43103b.getUniqueId(), 1, this.f43103b.v.getForum(), this.f43103b.F.a0(), 1);
                        }
                        if (this.f43103b.v.getThreadList() != null && this.f43103b.v.getThreadList().size() > 0) {
                            Iterator<c.a.d.n.e.n> it = this.f43103b.v.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                c.a.d.n.e.n next = it.next();
                                if ((next instanceof e2) && ((e2) next).getType() == e2.c4) {
                                    c.a.t0.e1.w2.a.g(this.f43103b.getUniqueId(), 1, this.f43103b.v.getForum(), this.f43103b.F.a0(), 2);
                                    break;
                                }
                            }
                        }
                        c.a.t0.e1.w2.a.h(this.f43103b.getUniqueId(), this.f43103b.v.getThreadList(), this.f43103b.v.getForum(), this.f43103b.F.a0());
                    }
                    this.f43103b.r.R0(i2);
                    FrsFragment.mPbLoadTime = (System.nanoTime() - this.a) / 1000000;
                    if (fVar != null) {
                        FrsFragment.mPbLoadDataSize = fVar.f25058e;
                    }
                } else if (this.f43103b.v == null || ListUtils.isEmpty(this.f43103b.v.getThreadList())) {
                    this.f43103b.f1(fVar);
                } else if (fVar.a) {
                    FrsFragment frsFragment5 = this.f43103b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(c.a.t0.e1.i1.net_error_text, fVar.f25057d, Integer.valueOf(fVar.f25056c)));
                }
                this.f43103b.k1();
                this.f43103b.I0();
                if (this.f43103b.v.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.f43103b.n && this.f43103b.H.b(49)) {
                    this.f43103b.n = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
                c.a.t0.e1.z2.f.a(customResponsedMessage, this.a.r, this.a.v);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof e2) {
                    c.a.t0.e1.z2.q.b(this.a.r, this.a.v, this.a.getForumId(), true, (e2) data);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43104e;

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
            this.f43104e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43104e.H == null) {
                return;
            }
            FrsTabViewController.o A = this.f43104e.H.A();
            if (A != null && (fragment = A.f43769b) != null && (fragment instanceof c.a.t0.e1.q0)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((c.a.t0.e1.q0) A.f43769b).scrollToTop();
                ((c.a.t0.e1.q0) A.f43769b).forceRefresh();
                return;
            }
            this.f43104e.getFrsView().Q1();
        }
    }

    /* loaded from: classes12.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f43105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f43106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43107g;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, c.a.s0.s.s.a aVar) {
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
            this.f43107g = frsFragment;
            this.f43105e = privateForumPopInfoData;
            this.f43106f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f43107g.getPageContext(), new String[]{this.f43105e.z()});
                this.f43106f.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w0 implements c.a.t0.e1.t0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w0 f43108e;

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
                this.f43108e = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f43108e.a.r != null && this.f43108e.a.r.B0()) {
                    this.f43108e.a.loadMore();
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
            this.a = frsFragment;
        }

        @Override // c.a.t0.e1.t0
        public void a(int i2, int i3, c.a.t0.e1.m1 m1Var, ArrayList<c.a.d.n.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), m1Var, arrayList}) == null) {
                c.a.d.f.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43109e;

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
            this.f43109e = frsFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a.Y = true;
        }
    }

    /* loaded from: classes12.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43111f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43112g;

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
            this.f43112g = frsFragment;
            this.f43110e = i2;
            this.f43111f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f43112g.forumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f43110e));
                UrlManager.getInstance().dealOneLink(this.f43112g.getPageContext(), new String[]{this.f43111f});
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.a.E == null && this.a.r.h0() != null && !this.a.r.Z() && this.a.r.h0().j() != null && (this.a.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.a;
                        frsFragment.E = (ThreadCardViewHolder) frsFragment.r.h0().j().getTag();
                    }
                    if (this.a.E == null || this.a.E.getCardView() == null) {
                        return;
                    }
                    this.a.E.getCardView().o(new a.C0204a(3));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f43113e;

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
            this.f43113e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43113e.z || !c.a.d.f.p.l.z() || this.f43113e.r.D0()) {
                return;
            }
            this.f43113e.r.T0();
        }
    }

    /* loaded from: classes12.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;

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
            this.a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.r == null) {
                return;
            }
            this.a.r.Q0();
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
        this.f43062e = "";
        this.mSpeedUpTipShowing = false;
        this.f43064g = false;
        this.f43065h = true;
        this.mForum = null;
        this.mFrom = null;
        this.mFlag = 0;
        this.createWithGame = false;
        this.f43066i = false;
        this.f43067j = null;
        this.forumId = null;
        this.k = 0;
        this.l = false;
        this.n = false;
        this.o = false;
        this.r = null;
        this.mThreadData = null;
        this.v = new FrsViewData();
        this.initTime = -1L;
        this.drawTime = 0L;
        this.sysCreateTime = 0L;
        this.createTime = 0L;
        this.layoutTime = 0L;
        this.dataParseTime = 0L;
        this.pullBeginTime = 0L;
        this.y = false;
        this.isPageStayDurationClose = false;
        this.z = false;
        this.perfFluencyLogData = null;
        this.A = true;
        this.B = true;
        this.D = new a.C0204a(2);
        this.M = new SparseArray<>();
        this.N = true;
        this.e0 = false;
        this.g0 = false;
        this.i0 = false;
        this.k0 = null;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = 0;
        this.mHeadLineDefaultNavTabId = -1;
        this.A0 = -1;
        this.G0 = new k(this);
        this.H0 = new v(this, 2016495);
        this.I0 = new g0(this, 2921005);
        this.J0 = new r0(this, 2921401);
        this.K0 = new c1(this, 2921473);
        this.L0 = new m1(this, 2921467);
        this.M0 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.N0 = new o1(this, 2001624);
        this.O0 = new p1(this);
        this.P0 = new a(this);
        this.R0 = new b(this, 2001606);
        this.S0 = new c(this, 2001607);
        this.T0 = new d(this, 2003019);
        this.U0 = new e(this, 2921470);
        this.V0 = new f(this, 2001352);
        this.W0 = new g(this);
        this.X0 = new h(this, 2001115);
        this.Y0 = new i(this, 2921346);
        this.Z0 = new j(this, 2001374);
        this.a1 = new l(this, 2001378);
        this.b1 = new m(this, 2001626);
        this.c1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.d1 = new o(this);
        this.e1 = new p(this, 2921391);
        this.f1 = new q(this, 2003020);
        this.g1 = new r(this, 2921463);
        this.h1 = new s(this, 2921587);
        this.i1 = new t(this, 2921588);
        this.mForumModelCallback = new u(this);
        this.j1 = new b0(this, 2016485);
        this.k1 = new c0(this, 2001194);
        this.l1 = new f0(this);
        this.m1 = new h0(this);
        this.mOnTouchListener = new i0(this);
        this.n1 = new j0(this, 2004507);
        this.mCommenOnClickListener = new p0(this);
        this.o1 = new q0(this);
        this.p1 = new s0(this);
        this.q1 = new t0(this);
        this.r1 = new u0(this, 0);
        this.s1 = new q1(this, null);
        this.t1 = new w0(this);
        this.u1 = new x0(this, 2921033);
        this.v1 = new y0(this, 2921381);
        this.w1 = new z0(this, 2921414);
        this.x1 = new a1(this, 2921437);
        this.y1 = new g1(this, 2921462);
        this.z1 = new h1(this, 2001223);
        this.A1 = new i1(this, 2921469);
        this.B1 = new j1(this, 2921475);
        this.C1 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.D1 = new l1(this, 2921515);
    }

    public final void D0(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.F) == null || this.v == null || this.r == null || !z2) {
            return;
        }
        if (!frsModelController.t0() && this.F.b0() == 1) {
            if (!this.F.q0()) {
                this.v.addCardVideoInfoToThreadList();
                this.v.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.r.V().l(c.a.t0.g0.f0.o.k) ? this.v.addHotTopicDataToThreadList() : false)) {
                this.v.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !c.a.t0.g1.a.d()) {
                this.v.addRecommendAppToThreadList(this);
            }
            if (!this.r.V().l(e2.I3)) {
                this.v.removeAlaLiveThreadData();
            }
            this.v.addSchoolRecommendToThreadList();
        }
        if (!this.r.V().l(e2.I3)) {
            this.v.removeAlaInsertLiveData();
            this.v.removeAlaStageLiveDat();
        } else {
            this.v.addInsertLiveDataToThreadList();
            this.v.addStageLiveDataToThreadList();
        }
        this.v.checkLiveStageInThreadList();
        this.v.addNoticeThreadToThreadList();
        if (this.r.V().l(c.a.t0.h1.b.f18277i)) {
            this.v.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.F.t0() || this.F.isNetFirstLoad)) {
            this.v.addUserRecommendToThreadList();
        }
        this.v.addVideoActivityToTop();
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                F0(frsModelController.Z());
            } else {
                F0(NORMAL_FRS);
            }
        }
    }

    public final void F0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            setListPullToRefresh(STAR_FRS.equals(str));
            c.a.t0.e1.z1.e.b bVar = this.O;
            if (bVar != null) {
                bVar.c(this.G, this.r, this.v);
            }
        }
    }

    public final boolean G0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 != 506 : invokeI.booleanValue;
    }

    public final boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsViewData frsViewData = this.v;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.v.getPrivateForumTotalInfo().a() == null || this.v.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!H0() && this.v.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                setHeaderPrivateText(this.v.getPrivateForumTotalInfo().a().private_forum_audit_status, this.v.getPrivateForumTotalInfo().b(), false);
            } else {
                setHeaderPrivateText(null, null, true);
            }
        }
    }

    public final void J0(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<c.a.d.n.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.r.a0() == null || this.r.a0().getData() == null) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = threadList.iterator();
        List<c.a.d.n.e.n> data = this.r.a0().getData();
        int i2 = 0;
        while (it.hasNext()) {
            c.a.d.n.e.n next = it.next();
            if (next instanceof d2) {
                e2 e2Var = ((d2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), e2Var.h0())) {
                        it.remove();
                        data.remove(next);
                        this.R.j(next);
                        this.r.a0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(c.a.t0.e1.a.h().i()) || this.r.a0() == null || this.r.a0().getData() == null) {
            return;
        }
        ArrayList<c.a.d.n.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<c.a.d.n.e.n> it = threadList.iterator();
        List<c.a.d.n.e.n> data = this.r.a0().getData();
        int count = ListUtils.getCount(c.a.t0.e1.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            c.a.d.n.e.n next = it.next();
            if (next instanceof d2) {
                e2 e2Var = ((d2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(c.a.t0.e1.a.h().i().get(i3).h0(), e2Var.h0())) {
                        it.remove();
                        data.remove(next);
                        this.R.j(next);
                        this.r.a0().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void L0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            FrsViewData frsViewData = this.v;
            String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.v.getForum().getId();
            if (StringUtils.isNull(id)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void M0(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || j2 <= 0) {
            return;
        }
        c.a.d.f.m.e.a().postDelayed(new k0(this, j2, c.a.d.f.p.n.k(TbadkCoreApplication.getInst()), c.a.d.f.p.n.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r.Q1();
        }
    }

    public final void O0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        if (!c.a.t0.e1.z2.o.a(this, getForumName(), "from", intent.getBooleanExtra("from_short_cut", false)) && getActivity() != null) {
            getActivity().finish();
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.w = uri != null ? uri.toString() : null;
        if (uri != null) {
            this.mForum = uri.getQueryParameter("name");
            this.mFrom = uri.getQueryParameter("from");
            if (!StringUtils.isNull(this.mForum)) {
                intent.putExtra("name", this.mForum);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
        }
        if (!StringUtils.isNull(this.mForum) || uri == null) {
            return;
        }
        if (c.a.s0.a.g.c(uri)) {
            c.a.s0.a.g.b().e(uri, this.l1);
        } else {
            c.a.t0.e1.z2.j b2 = c.a.t0.e1.z2.r.b(intent);
            if (b2 != null) {
                this.mForum = b2.a;
                String str = b2.f17358b;
                if (str != null) {
                    str.equals("aidou");
                }
            }
        }
        if (!StringUtils.isNull(this.mForum)) {
            intent.putExtra("name", this.mForum);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public final FrsTabInfoData P0() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.F == null || (frsViewData = this.v) == null || this.H == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.v.getEntelechyTabInfo().a) || (E = this.H.E()) == 502) {
                return null;
            }
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.v.getEntelechyTabInfo().a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.v.getUserData() == null || this.v.getUserData().isForumBusinessAccount())) {
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
            if (this.v.getUserData() != null) {
                frsTabInfoData.isForumBusinessAccount = this.v.getUserData().isForumBusinessAccount();
            }
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeV.objValue;
    }

    public final void Q0() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || !isResumed() || (list = this.t0) == null || list.size() < 1 || this.s0 > this.t0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.t0.get(this.s0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.s0++;
            Q0();
        }
        if (this.u != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(c.a.t0.e1.i1.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + "...");
                } else {
                    format = String.format(getResources().getString(c.a.t0.e1.i1.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(c.a.t0.e1.i1.live_horserace_red_envelope), getResources().getString(c.a.t0.e1.i1.frs_horse_none_title_verser));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.u0 = ofFloat;
            ofFloat.setDuration(600L);
            this.u0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.u0.addListener(new e1(this, frsRedpackRunView));
            this.v0 = new f1(this, frsRedpackRunView);
            c.a.d.f.m.e.a().postDelayed(this.v0, 5000L);
            if (this.u.getChildCount() == 0) {
                this.s0++;
                this.u.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.v;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.v.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.forumId).param("fname", str));
            }
            LinearLayout linearLayout = this.u;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.H.A().f43769b).isPrimary() || this.r.E0() || this.y) {
                return;
            }
            this.u.setVisibility(0);
        }
    }

    public final void R0(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            registerListener(2001118, this.r1);
            long j2 = 0;
            if (bundle != null) {
                this.mForum = bundle.getString("name");
                this.mFrom = bundle.getString("from");
                this.mFlag = bundle.getInt("flag", 0);
                j2 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                this.mForum = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra("flag", 0);
                j2 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
            }
            if (getArguments() != null) {
                this.createWithGame = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
            }
            if (!TextUtils.isEmpty(this.mFrom)) {
                FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom);
            }
            if (this.mIsLogin) {
                registerListener(2001120, this.r1);
            }
            this.G.C(bundle);
            M0(j2);
        }
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (getFrsViewData() == null) {
                return false;
            }
            FrsViewData frsViewData = getFrsViewData();
            c.a.s0.s.q.b0 b0Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                b0Var = new c.a.s0.s.q.b0();
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                b0Var = frsViewData.getActivityHeadData().b().get(0);
            }
            return b0Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.mFlag == 1) {
                c.a.d.f.m.h.a().b(new l0(this));
            }
            this.mFlag = 0;
        }
    }

    public final void U0(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.v != null && this.H != null && this.F != null) {
                    if (!this.r.V().l(e2.I3)) {
                        this.v.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.v.getGameTabInfo());
                    this.r.m1(isEmpty);
                    if (!isEmpty) {
                        if (this.X == null) {
                            this.X = new c.a.t0.e1.a3.e(this, (NoPressedRelativeLayout) this.q);
                        }
                        if (this.Z == null) {
                            this.Z = new c.a.t0.e1.j2.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                        }
                    } else {
                        this.X = null;
                        this.Z = null;
                    }
                    if (this.v.getForum() != null) {
                        this.mForum = this.v.getForum().getName();
                        this.forumId = this.v.getForum().getId();
                    }
                    if (this.v.hasTab()) {
                        this.H.d(this.v, this.F.R());
                    }
                    if (z2) {
                        D0(true, z2);
                    } else {
                        D0(this.A, z2);
                    }
                    refreshHeader();
                    if (this.O != null) {
                        this.O.a(this.G, this.v);
                    }
                    if (this.v.getPage() != null) {
                        setHasMore(this.v.getPage().b());
                    }
                    ArrayList<c.a.d.n.e.n> d2 = this.R.d(z3, true, this.v.getThreadList(), null, z2, false);
                    if (d2 != null) {
                        this.v.setThreadList(d2);
                    }
                    this.v.removeRedundantUserRecommendData();
                    int topThreadSize = this.v.getTopThreadSize();
                    this.k = topThreadSize;
                    if (this.m != null) {
                        this.l = true;
                        this.m.e(topThreadSize);
                        c.a.t0.e1.z2.d.a(this, this.v.getForum(), this.v.getThreadList(), this.l, getPn());
                    }
                    if (this.F.b0() == 1) {
                        V0();
                        if (!z2 && this.F.getPn() == 1) {
                            requestLoadLiveTip();
                        }
                    }
                    if (this.P != null) {
                        this.P.k(this.H.F());
                    }
                    showLoadFinishedUI();
                    this.r.a1();
                    this.r.i1(true, false);
                    if (z2 && this.v.isFirstTabEqualAllThread()) {
                        c.a.d.f.m.e.a().post(new z(this));
                    }
                    if (this.v.getForum() != null) {
                        this.r.M(this.v.getForum().getWarningMsg());
                    }
                    if (this.v != null && this.v.getFrsVideoActivityData() != null && c.a.s0.s.i0.b.k().m("frs_video_activity_guide", 0L) == 0) {
                        c.a.d.f.m.e.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.r.C1();
                    if (this.v != null && this.v.getForum() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.v.getForum().getId(), this.v.getForum().getName(), this.v.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.v.getForum().special_forum_type), this.v.getForum().getThemeColorInfo(), this.v.getForum().getMember_num())));
                    }
                    this.c0.e(this.v.bottomMenuList, this.v.getForum());
                    m1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            stopVoice();
            try {
                if (this.v == null) {
                    return;
                }
                this.r.H1();
                this.r.P1(canShowWriteButton());
                if (c.a.t0.e1.a3.h.B(this.v)) {
                    c.a.t0.e1.a3.h.A(this.v);
                }
                if (this.v.getForum() != null) {
                    this.mForum = this.v.getForum().getName();
                    this.forumId = this.v.getForum().getId();
                }
                if (this.v.getPage() != null) {
                    setHasMore(this.v.getPage().b());
                }
                this.r.B1(this.mForum);
                this.r.f1(this.mForum);
                TbadkCoreApplication.getInst().setDefaultBubble(this.v.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.v.getUserData().getBimg_end_time());
                T0();
                Y0();
                ArrayList<c.a.d.n.e.n> threadList = this.v.getThreadList();
                if (threadList != null) {
                    this.r.A1(threadList, this.v);
                    c.a.t0.e1.z2.f.b(this.r);
                    this.G.d0(getPageNum());
                    this.v.setFrsFragmentTag(getUniqueId());
                    this.G.L(this.v);
                    this.H.d(this.v, this.F.R());
                    this.r.b1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void W0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            refreshHeader();
            stopVoice();
            try {
                if (this.v == null) {
                    return;
                }
                c.a.t0.e1.z0 z0Var = null;
                this.r.A1(null, this.v);
                this.G.d0(1);
                this.r.b1();
                this.H.d(this.v, this.F.R());
                c.a.t0.e1.x2.e I = this.H.I(this.v.getFrsDefaultTabId());
                if (I != null && !TextUtils.isEmpty(I.f17099d)) {
                    z0Var = new c.a.t0.e1.z0();
                    String str = I.f17099d;
                    String str2 = I.a;
                }
                this.F.q(this.v.getFrsDefaultTabId(), 0, z0Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void X0(c.a.t0.x3.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mVar) == null) {
            try {
                if (!this.z && mVar != null && this.v != null) {
                    this.v.receiveData(mVar);
                    U0(true, false);
                    Looper.myQueue().addIdleHandler(this.G0);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void Y0() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (frsViewData = this.v) == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.r.V().setFromCDN(true);
        } else {
            this.r.V().setFromCDN(false);
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
        achievementActivityConfig.setUrl(stringExtra);
        FrsViewData frsViewData = this.v;
        if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
            achievementActivityConfig.setShareUrl(this.v.getForumActiveInfo().forum_share_url);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
    }

    public final boolean a1(c.a.t0.x3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, mVar)) == null) {
            if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().a != null) {
                for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && c.a.s0.s.i0.b.k().h("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            c.a.t0.e1.s1.f fVar = new c.a.t0.e1.s1.f(getTbPageContext());
            this.C0 = fVar;
            boolean j2 = fVar.j(mVar);
            this.D0 = j2;
            return j2;
        }
        return invokeL.booleanValue;
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new m0(this, aVar));
            aVar.setContentView(frsBroadcastCopyGuideDialogView);
            aVar.create(getPageContext()).show();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.s0.y.d.h().m(new c.a.s0.y.a(getContext()));
            c.a.s0.y.d.h().n(85, 0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.e1.d1.tbds144));
            if (c.a.s0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public boolean canShowSpeedTipView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f43065h : invokeV.booleanValue;
    }

    public boolean canShowWriteButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? canShowWriteButton(this.Q0) : invokeV.booleanValue;
    }

    @Override // c.a.t0.e1.o0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            c.a.t0.e1.z2.r.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
        }
    }

    public c.a.d.n.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bdUniqueId)) == null) ? c.a.t0.e1.e.e().d(getPageContext(), bdUniqueId, getUniqueId()) : (c.a.d.n.e.a) invokeL.objValue;
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.s0.y.d.h().m(new c.a.s0.y.b(getContext()));
            c.a.s0.y.d.h().n(85, 0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.e1.d1.tbds144));
            if (c.a.s0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    @Override // c.a.t0.h.e.b
    public void dispatchInjectPluginMessage(c.a.t0.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
            this.V.a(dVar);
        }
    }

    public final void e1(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.v) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (c.a.d.f.p.m.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", c.a.s0.d1.v0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public final void f1(c.a.t0.x3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            if (fVar == null) {
                String string = TbadkCoreApplication.getInst().getString(c.a.t0.e1.i1.error_unkown_try_again);
                this.r.S0();
                showNetRefreshView(this.r.k0(), string, true);
            } else if (340001 == fVar.f25056c) {
                j1(fVar, this.v.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.v.getThreadList())) {
                    i1(fVar);
                }
                if (isFromMainTab()) {
                    setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.e1.d1.ds280));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (hasMore() != 1 && !this.R.b(this.v.getThreadListIds())) {
                if (ListUtils.isEmpty(this.v.getThreadList())) {
                    this.r.s0();
                } else {
                    this.r.L1();
                }
            } else if (ListUtils.getCount(this.v.getThreadList()) > 3) {
                this.r.I1();
            } else {
                this.r.E1();
            }
        }
    }

    public c.a.t0.e1.z1.e.b getEntelechyProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.O : (c.a.t0.e1.z1.e.b) invokeV.objValue;
    }

    public c.a.t0.e1.z1.a getFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f43063f : (c.a.t0.e1.z1.a) invokeV.objValue;
    }

    @Override // c.a.t0.k3.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // c.a.t0.e1.u0
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // c.a.t0.e1.q2.a, c.a.t0.e1.u0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mForum : (String) invokeV.objValue;
    }

    public ForumWriteData getForumWriteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            FrsViewData frsViewData = this.v;
            if (frsViewData == null || frsViewData.getForum() == null) {
                return null;
            }
            ForumData forum = this.v.getForum();
            ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.v.getAnti());
            forumWriteData.avatar = forum.getImage_url();
            forumWriteData.forumLevel = forum.getUser_level();
            forumWriteData.specialForumType = forum.special_forum_type;
            forumWriteData.firstDir = forum.getFirst_class();
            forumWriteData.secondDir = forum.getSecond_class();
            UserData userData = this.v.getUserData();
            forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
            forumWriteData.frsTabInfo = P0();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    public c.a.d.n.e.v getFrsAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.s1 : (c.a.d.n.e.v) invokeV.objValue;
    }

    public int getFrsCallFromByItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.A0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.A0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.e1.r2.l
    public c.a.t0.e1.r2.c getFrsLoadMoreModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.R : (c.a.t0.e1.r2.c) invokeV.objValue;
    }

    public c.a.t0.e1.r2.d getFrsPostController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.Q : (c.a.t0.e1.r2.d) invokeV.objValue;
    }

    public c.a.t0.e1.u2.a getFrsSmartSortController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.J : (c.a.t0.e1.u2.a) invokeV.objValue;
    }

    @Override // c.a.t0.e1.r2.l
    public c.a.t0.e1.q getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.r : (c.a.t0.e1.q) invokeV.objValue;
    }

    @Override // c.a.t0.e1.q2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.v : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.t0.e1.r2.l
    public c.a.t0.e1.a3.h getHeaderVC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.G : (c.a.t0.e1.a3.h) invokeV.objValue;
    }

    @Override // c.a.t0.h.e.b
    public c.a.t0.h.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) ? this.M.get(i2) : (c.a.t0.h.e.a) invokeI.objValue;
    }

    public boolean getIsRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.r.Z() : invokeV.booleanValue;
    }

    public int getLastTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.Q0 : invokeV.intValue;
    }

    @Override // c.a.t0.e1.r2.l
    public FrsModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.F : (FrsModelController) invokeV.objValue;
    }

    public c.a.t0.e1.v0 getNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.L : (c.a.t0.e1.v0) invokeV.objValue;
    }

    @Override // c.a.t0.e1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            c.a.t0.e1.q qVar = this.r;
            if (qVar == null) {
                return null;
            }
            return qVar.d0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.t0.e1.q2.a
    public /* bridge */ /* synthetic */ c.a.d.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.t0.k3.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            c.a.t0.e1.r2.c cVar = this.R;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            c.a.t0.e1.r2.c cVar = this.R;
            if (cVar == null) {
                return 1;
            }
            return cVar.g();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    @Override // c.a.t0.k3.u
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.o A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (getTabController() != null && (A = getTabController().A()) != null) {
                Fragment fragment = A.f43769b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.v;
                        tbPageTag.sortType = c.a.t0.e1.z2.p.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.f43062e.equals(A.f43770c)) {
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

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f43067j : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.x == null) {
                this.x = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.x;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            c.a.t0.e1.q qVar = this.r;
            if (qVar == null) {
                return 0;
            }
            return qVar.q0();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.p == null) {
                this.p = VoiceManager.instance();
            }
            return this.p;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public OvalActionButton getWriteIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.s : (OvalActionButton) invokeV.objValue;
    }

    public FRSRefreshButton getmRefreshIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.t : (FRSRefreshButton) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            if (hasMore() == 0 && ListUtils.isEmpty(this.v.getThreadListIds())) {
                if (ListUtils.isEmpty(this.v.getThreadList())) {
                    this.r.s0();
                } else {
                    this.r.L1();
                }
            } else if (ListUtils.getCount(this.v.getThreadList()) > 3) {
                this.r.I1();
            } else {
                this.r.E1();
            }
        }
    }

    public int hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            c.a.t0.e1.r2.c cVar = this.R;
            if (cVar == null) {
                return -1;
            }
            return cVar.h();
        }
        return invokeV.intValue;
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.n.w(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, view) == null) {
            this.r.g1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, view) == null) {
            super.hideNetRefreshView(view);
            this.r.g1(0);
        }
    }

    public void hideRefreshIcon() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || (fRSRefreshButton = this.t) == null) {
            return;
        }
        fRSRefreshButton.hide();
    }

    public final void i1(c.a.t0.x3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, fVar) == null) {
            this.r.S0();
            if (fVar.a) {
                showNetRefreshView(this.r.k0(), TbadkCoreApplication.getInst().getString(c.a.t0.e1.i1.net_error_text, new Object[]{fVar.f25057d, Integer.valueOf(fVar.f25056c)}), true);
            } else {
                showNetRefreshView(this.r.W().k(), fVar.f25057d, true);
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (this.mFlag == 0) {
                this.r.B1(this.mForum);
            } else {
                this.r.B1("");
                this.mFlag = 1;
            }
            this.r.x1(this.s1);
            this.r.I(this.o1);
            this.r.y1(this.q1);
            this.r.V().m(this.p1);
        }
    }

    public boolean isAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isFromMainTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f43064g : invokeV.booleanValue;
    }

    public boolean isStartToLiveTab() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
                return false;
            }
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return invokeV.booleanValue;
    }

    public boolean isTopThreadListShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (getFrsViewData() == null) {
                return false;
            }
            FrsViewData frsViewData = getFrsViewData();
            return (ListUtils.isEmpty(frsViewData.getShowTopThreadList()) && frsViewData.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1(c.a.t0.x3.f fVar, List<RecmForumInfo> list) {
        c.a.t0.e1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048663, this, fVar, list) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.S0();
        this.r.B1(this.mForum);
        if (this.r.W() != null) {
            showForbidViewNoClick(this.r.k0(), fVar.f25057d, true, list);
        }
    }

    public final void k1() {
        boolean configPrivateDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048664, this) == null) || H0()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.A(this.v.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.v.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (c.a.d.f.p.m.isEmpty(privateForumPopInfoData.y()) || privateForumPopInfoData.x() != Integer.valueOf(this.forumId))) {
            privateForumPopInfoData.D(FrsPrivateCommonDialogView.DIALOG_TYPE_CREATE_SUCCESS);
            privateForumPopInfoData.B(TbadkCoreApplication.getInst().getString(c.a.t0.e1.i1.frs_private_create_hint));
            privateForumPopInfoData.E("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.mForum + "&nomenu=1");
            privateForumPopInfoData.C(Integer.valueOf(this.forumId));
            configPrivateDialog = frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData);
        } else {
            configPrivateDialog = privateForumPopInfoData.x() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData) : false;
        }
        if (configPrivateDialog) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new w(this, privateForumPopInfoData, aVar));
            aVar.setCloseButton(new x(this));
            aVar.create(getPageContext()).show();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() == null) {
                if (this.v.getForum().getYuleData() != null && this.v.getForum().getYuleData().a()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                    this.r.G1(this.v.getForum().getYuleData().b());
                    return;
                }
                this.r.r0();
                return;
            }
            this.r.r0();
        }
    }

    public void likeCallBack(Object obj) {
        c.a.t0.e1.r2.b bVar;
        c.a.d.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.f16788j) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // c.a.t0.e1.r2.l
    public void loadMore() {
        c.a.t0.e1.r2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.i(this.mForum, this.forumId, this.v);
    }

    public void logStatisticByKey(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            c.a.t0.w3.c.g().h(getUniqueId(), z2);
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || c.a.d.f.p.m.isEmpty(this.forumId)) {
            return;
        }
        c.a.s0.a.d.y().Q(c.a.s0.a.c.Y, c.a.d.f.m.b.g(this.forumId, 0L));
    }

    public boolean needAdjustHeaderBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? S0() && !isTopThreadListShow() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, bundle) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.initTime = currentTimeMillis;
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.n = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
                this.initTime = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                O0(intent);
            }
            this.sysCreateTime = currentTimeMillis - this.initTime;
            this.m = new c.a.t0.x3.j0.f("frs", c.a.t0.x3.j0.f.f25096c);
            if (this.F == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.mForumModelCallback);
                this.F = frsModelController;
                frsModelController.t(this.O0);
                this.F.init();
            }
            this.F.O0(this.w);
            ArrayList<c.a.d.n.e.n> arrayList = null;
            if (intent != null) {
                this.F.j0(intent.getExtras());
            } else if (bundle != null) {
                this.F.j0(bundle);
            } else {
                this.F.j0(null);
            }
            if (intent != null) {
                this.G.C(intent.getExtras());
            } else if (bundle != null) {
                this.G.C(bundle);
            } else {
                this.G.C(null);
            }
            this.p = getVoiceManager();
            this.V = new c.a.t0.e1.p(getPageContext(), this);
            initUI();
            R0(bundle);
            if (!isFromMainTab()) {
                c.a.t0.e1.v0 v0Var = new c.a.t0.e1.v0(getActivity(), this.r, this.G);
                this.L = v0Var;
                v0Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.p = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.e0) {
                int l2 = c.a.s0.s.i0.b.k().l("key_forum_broadcast_edit_tip_number", 0);
                if (l2 < 2) {
                    c.a.s0.s.i0.b.k().w("key_forum_broadcast_edit_tip_number", l2 + 1);
                    b1();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        c1();
                    } else {
                        new BdTopToast(getContext()).setIcon(false).setContent(getContext().getString(c.a.t0.e1.i1.forum_broadcast_copy_no_permission_hint)).show(this.r.k0());
                    }
                } else {
                    c1();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.e0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        d1();
                    } else if (Build.VERSION.SDK_INT < 23 || !c.a.s0.s.i0.b.k().h("key_forum_rule_dialog_show_frs", false)) {
                        d1();
                        c.a.s0.s.i0.b.k().u("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    d1();
                }
            }
            if (c.a.s0.y.d.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.s;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new c.a.t0.e1.r2.i();
            int i2 = -1;
            c.a.t0.e1.r2.c cVar = this.R;
            if (cVar != null && cVar.f() != null) {
                i2 = this.R.f().A();
                arrayList = this.R.f().z();
            }
            c.a.t0.e1.r2.c cVar2 = new c.a.t0.e1.r2.c(this, this.m1);
            this.R = cVar2;
            cVar2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.R.f().K(arrayList);
            }
            this.J = new c.a.t0.e1.u2.a(this);
            this.S = new c.a.t0.e1.a3.j(this);
            this.P = new c.a.t0.e1.a3.a(getPageContext(), this.F.o0());
            this.K = new c.a.t0.e1.r2.b(this);
            this.Q = new c.a.t0.e1.r2.d(this);
            this.I = new c.a.t0.e1.r2.h(this);
            this.T = new c.a.t0.e1.r2.a(this);
            this.mEnterFrsDialogController = new c.a.t0.e1.a3.c(this);
            new c.a.t0.e1.r2.e(this, getUniqueId());
            this.a0 = new c.a.t0.k.a(getPageContext(), "frs");
            this.b0 = new c.a.t0.a0.c(getPageContext());
            new c.a.t0.e1.v2.c.a(getPageContext());
            registerListener(this.X0);
            registerListener(this.k1);
            registerListener(this.V0);
            registerListener(this.n1);
            registerListener(this.j1);
            registerListener(this.R0);
            registerListener(this.S0);
            registerListener(this.T0);
            registerListener(this.U0);
            registerListener(this.H0);
            registerListener(this.I0);
            registerListener(this.J0);
            registerListener(this.K0);
            registerListener(this.u1);
            registerListener(this.Z0);
            this.a1.setSelfListener(true);
            this.a1.setTag(getPageContext().getUniqueId());
            registerListener(this.a1);
            registerListener(this.N0);
            registerListener(this.b1);
            registerListener(this.Y0);
            registerListener(this.e1);
            registerListener(this.f1);
            registerListener(this.g1);
            this.v1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.M0);
            registerListener(this.z1);
            registerListener(this.c1);
            registerListener(this.L0);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.h1);
            registerListener(this.i1);
            this.r.t0(false);
            if (!isFromMainTab() && !this.e0) {
                showLoadingView(this.r.k0(), true);
                this.F.P(3, false);
            }
            d0 d0Var = new d0(this);
            c.a.t0.e1.b.f().s(d0Var);
            c.a.t0.e1.a.h().s(d0Var);
            this.r.v1(new e0(this));
            this.q0 = UtilHelper.getScreenHeight(getActivity());
            this.e0 = true;
            L0(1);
            super.onActivityCreated(bundle);
            this.createTime = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048672, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            c.a.t0.e1.r2.a aVar = this.T;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.h0) {
                this.r.K0(i2);
                this.G.F(i2);
                this.H.U(i2);
                FRSRefreshButton fRSRefreshButton = this.t;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.t0.e1.d3.a aVar = this.W;
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
                c.a.t0.e1.v1.a.a aVar2 = this.c0;
                if (aVar2 != null) {
                    aVar2.d(getPageContext(), i2);
                }
                if (this.d0 != null) {
                    c.a.s0.x0.a.a(getPageContext(), this.d0.getRealView());
                }
                c.a.t0.e1.a3.e eVar = this.X;
                if (eVar != null) {
                    eVar.onChangeSkinType(getPageContext(), i2);
                }
                c.a.t0.e1.s1.f fVar = this.C0;
                if (fVar != null) {
                    fVar.onChangeSkinType(getPageContext(), i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, bundle) == null) {
            super.onCreate(bundle);
            c.a.t0.w3.c.g().i(getUniqueId());
            if (this.y0 == null) {
                this.y0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.y0);
            registerResponsedEventListener(TopToastEvent.class, this.d1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048675, this, layoutInflater, viewGroup, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            View view = this.q;
            if (view == null) {
                this.q = layoutInflater.inflate(c.a.t0.e1.g1.frs_activity, viewGroup, false);
                c.a.t0.e1.z1.a aVar = new c.a.t0.e1.z1.a();
                this.f43063f = aVar;
                this.O = aVar.c();
                this.f43062e = TbadkCoreApplication.getInst().getString(c.a.t0.e1.i1.frs_title_new_area);
                this.G = new c.a.t0.e1.a3.h(this, this.f43063f, (FrsHeaderViewContainer) this.q.findViewById(c.a.t0.e1.f1.header_view_container));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.q);
                this.H = frsTabViewController;
                frsTabViewController.Z();
                this.G.f0(this.H);
                this.H.d0(this.P0);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.f43064g = true;
                }
                this.r = new c.a.t0.e1.q(this, this.mCommenOnClickListener, this.f43063f, this.f43064g, this.G);
                this.c0 = new c.a.t0.e1.v1.a.a(getPageContext(), this.q);
            } else {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.q.getParent()).removeView(this.q);
                }
                FrsTabViewController frsTabViewController2 = this.H;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.Z();
                }
                this.r.U0();
                this.q.setLeft(0);
                this.q.setRight(c.a.d.f.p.n.k(TbadkCoreApplication.getInst().getContext()));
            }
            this.h0 = true;
            this.layoutTime = System.currentTimeMillis() - currentTimeMillis;
            return this.q;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            c.a.t0.w3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.u1);
            MessageManager.getInstance().unRegisterListener(this.a1);
            unRegisterResponsedEventListener();
            this.S.Z();
            cacheData = null;
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.t0.k3.l0.a.c("FRS");
            this.p = null;
            c.a.t0.g0.v.b().e(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.t0.e1.h0.a().b(c.a.d.f.m.b.g(this.v.getForum().getId(), 0L));
            }
            c.a.t0.e1.p2.a aVar = this.U;
            if (aVar != null) {
                aVar.v();
            }
            c.a.t0.e1.q qVar = this.r;
            if (qVar != null) {
                c.a.t0.e1.z2.q.b(qVar, this.v, getForumId(), false, null);
                this.r.L0();
            }
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.u.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.u0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.v0 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.v0);
            }
            this.t0 = null;
            super.onDestroy();
            try {
                if (this.perfFluencyLogData != null) {
                    this.perfFluencyLogData.c();
                }
                if (this.r != null) {
                    this.r.X0();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.G.D();
            Looper.myQueue().removeIdleHandler(this.G0);
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.g();
            }
            c.a.t0.e1.v0 v0Var = this.L;
            if (v0Var != null) {
                v0Var.d();
            }
            c.a.t0.e1.a3.a aVar2 = this.P;
            if (aVar2 != null) {
                aVar2.i();
            }
            c.a.t0.e1.u2.a aVar3 = this.J;
            if (aVar3 != null) {
                aVar3.c();
            }
            c.a.t0.e1.a3.e eVar = this.X;
            if (eVar != null) {
                eVar.g();
            }
            c.a.t0.e1.r2.a aVar4 = this.T;
            if (aVar4 != null) {
                aVar4.o();
            }
            c.a.t0.k.a aVar5 = this.a0;
            if (aVar5 != null) {
                aVar5.h();
            }
            c.a.t0.a0.c cVar = this.b0;
            if (cVar != null) {
                cVar.g();
            }
            c.a.t0.k3.j0.a.e().g();
            FrsTabViewController frsTabViewController = this.H;
            if (frsTabViewController != null) {
                frsTabViewController.d0(null);
                this.H.M();
            }
            AddExperiencedModel addExperiencedModel = this.f0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            c.a.t0.e1.b.f().s(null);
            c.a.t0.e1.a.h().s(null);
            c.a.t0.e1.z2.h hVar = this.B0;
            if (hVar != null) {
                hVar.d();
            }
            if (this.y0 != null) {
                getLifecycle().removeObserver(this.y0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            g1();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.d.n.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? getListView().getPreLoadHandle() : (c.a.d.n.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048679, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                if (i2 == 24) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                    return false;
                }
                return false;
            } else if (c.a.t0.e1.b.f().i()) {
                c.a.t0.e1.b.f().m();
                return true;
            } else if (c.a.t0.e1.a.h().j()) {
                c.a.t0.e1.q qVar = this.r;
                if (qVar != null && qVar.C0()) {
                    this.r.Y0();
                    return true;
                }
                c.a.t0.e1.a.h().n();
                return true;
            } else {
                c.a.t0.e1.q qVar2 = this.r;
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
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && isFromMainTab()) {
            showLoadingView(this.r.k0(), true);
            this.r.w1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.F.F0(3, true);
            getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && c.a.d.f.p.n.C()) {
            hideNetRefreshView(this.r.W().k());
            showLoadingView(this.r.k0(), true);
            this.r.t0(false);
            this.F.F0(3, true);
        }
    }

    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048682, this, intent) == null) || intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.mForum = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.mFrom = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra("refresh_all", false);
        this.f43066i = booleanExtra;
        if (booleanExtra) {
            N0();
        }
    }

    @Override // c.a.t0.e1.o0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && isAdded() && this.N && isLoadingViewAttached()) {
            hideLoadingView(this.r.k0());
        }
    }

    @Override // c.a.t0.e1.o0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && isAdded() && this.N && !isLoadingViewAttached()) {
            showLoadingView(this.r.k0(), true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            super.onPause();
            this.I.f(false);
            this.A = false;
            this.r.N0();
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.r.H0(true);
            c.a.t0.e1.a3.a aVar = this.P;
            if (aVar != null) {
                aVar.j();
            }
            c.a.s0.a.d.y().G();
            c.a.t0.e1.z2.h hVar = this.B0;
            if (hVar != null) {
                hVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                c.a.t0.e1.a3.h hVar = this.G;
                if (hVar != null) {
                    hVar.G(isPrimary());
                }
                c.a.t0.e1.q qVar = this.r;
                if (qVar != null) {
                    qVar.O0(isPrimary());
                    this.r.H0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048687, this, i2, strArr, iArr) == null) {
            c.a.t0.e1.z2.r.h(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onResume();
            c.a.t0.e1.q qVar = this.r;
            if (qVar != null) {
                qVar.G0();
                this.r.P0();
            }
            this.I.f(true);
            this.A = true;
            if (isNeedRefreshOnBackFromBarDetail) {
                isNeedRefreshOnBackFromBarDetail = false;
                c.a.t0.e1.q qVar2 = this.r;
                if (qVar2 != null) {
                    qVar2.Q1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            c.a.t0.e1.q qVar3 = this.r;
            if (qVar3 != null) {
                qVar3.H0(false);
            }
            if (this.Y) {
                refresh(6);
                this.Y = false;
            }
            if (this.k0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    c.a.s0.t.d.f.c().h(true);
                    c.a.s0.t.d.f.c().i(this.k0.getHours(), this.k0.getMinutes());
                    if (this.r != null) {
                        c.a.s0.t.d.f.c().k(getTbPageContext().getPageActivity(), this.r.k0());
                    }
                }
                this.k0 = null;
            }
            m1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("name", this.mForum);
            bundle.putString("from", this.mFrom);
            this.F.onSaveInstanceState(bundle);
            if (this.p == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            this.p.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.r.a0().stopScroll();
            if (this.r.Z0()) {
                return;
            }
            if (!c.a.d.f.p.n.C()) {
                this.r.s0();
            } else if (this.F.b0() == 1) {
                g1();
                loadMore();
            } else if (this.F.hasMore()) {
                loadMore();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, errorData) == null) || getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        showLoadFinishedUI();
        this.r.G0();
        c.a.t0.x3.f S = this.F.S();
        boolean isEmpty = ListUtils.isEmpty(this.v.getThreadList());
        if (S != null && isEmpty) {
            if (this.F.V() != 0) {
                this.F.N0();
                this.r.G0();
            } else {
                f1(S);
            }
            this.r.i1(this.v.isStarForum(), false);
            return;
        }
        f1(S);
    }

    public void onShareSuccess(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, str) == null) && TbadkCoreApplication.isLogin() && !c.a.d.f.p.m.isEmpty(str)) {
            if (this.f0 == null) {
                this.f0 = new AddExperiencedModel(getTbPageContext());
            }
            this.f0.A(this.forumId, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.p = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            super.onStop();
            c.a.t0.g0.v.b().e(false);
            logStatisticByKey(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                c.a.s0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.v.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (getListView() != null) {
                getListView().getRecycledViewPool().clear();
            }
            this.G.E();
            c.a.s0.d1.h0.c();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onSuccess(ArrayList<c.a.d.n.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            setHasMore(!isEmpty ? 1 : 0);
            g1();
            if (isEmpty) {
                return;
            }
            if (!this.F.t0() && TbadkCoreApplication.getInst().isRecAppExist() && this.F.b0() == 1 && !c.a.t0.g1.a.d()) {
                this.v.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.F != null) {
                c.a.t0.e1.w2.a.h(getUniqueId(), arrayList, this.v.getForum(), this.F.a0());
            }
            ArrayList<c.a.d.n.e.n> c2 = this.R.c(false, false, arrayList, this.m, false);
            if (c2 != null) {
                this.v.setThreadList(c2);
                this.r.A1(c2, this.v);
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                c.a.t0.e1.w2.c.m(this.v, frsModelController.R(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.v.getForum()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z2) == null) {
            super.onUserChanged(z2);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            c.a.t0.t.d.c().f("page_frs");
            refresh(3);
        }
    }

    public boolean refreshHeader() {
        InterceptResult invokeV;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            c.a.t0.e1.a3.h hVar = this.G;
            if (hVar != null && (frsModelController = this.F) != null) {
                hVar.i0(frsModelController.Z(), this.v);
            }
            FrsViewData frsViewData = this.v;
            boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
            E0();
            c.a.t0.e1.q qVar = this.r;
            if (qVar != null) {
                qVar.w0();
                this.r.x0();
                FrsViewData frsViewData2 = this.v;
                if (frsViewData2 != null && frsViewData2.getActivityHeadData() != null) {
                    this.r.v0(this.v.getActivityHeadData().a());
                    if (this.v.getActivityHeadData().a() != null && !this.D0 && !this.E0) {
                        showFrsAdvancedAdGuide();
                    }
                }
            }
            return hasTab;
        }
        return invokeV.booleanValue;
    }

    public void refreshLevel() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && (frsModelController = this.F) != null && frsModelController.b0() == 1) {
            this.G.P(this.v);
        }
    }

    @Override // c.a.t0.e1.o0
    public void refreshPage() {
        c.a.t0.e1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.a0().scrollToPosition(0);
        this.r.Q1();
    }

    public void requestLoadLiveTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            if (this.U == null) {
                this.U = new c.a.t0.e1.p2.a(this, c.a.d.f.m.b.e(this.forumId, 0));
            }
            this.U.w();
        }
    }

    public void resetTabViewControllerRefreshTab(boolean z2) {
        FrsTabViewController frsTabViewController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) || (frsTabViewController = this.H) == null) {
            return;
        }
        frsTabViewController.z = z2;
    }

    public void scrollCurrentTabToTop() {
        FrsTabViewController frsTabViewController;
        FrsTabViewController.o A;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (frsTabViewController = this.H) == null || (A = frsTabViewController.A()) == null || (fragment = A.f43769b) == null || !(fragment instanceof c.a.t0.e1.q0)) {
            return;
        }
        ((c.a.t0.e1.q0) fragment).scrollToTop();
    }

    public void setCanShowSpeedTipView(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            this.f43065h = z2;
        }
    }

    public void setFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            this.mFlag = i2;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.mForum = str;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.mFrom = str;
        }
    }

    public void setHasMore(int i2) {
        c.a.t0.e1.r2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048710, this, i2) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.n(i2);
    }

    public void setHeaderPrivateText(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048711, this, num, num2, z2) == null) || this.r.i0() == null) {
            return;
        }
        TextView i02 = this.r.i0();
        if (z2) {
            i02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            i02.setText("修改实名认证信息");
            i02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            i02.setText("目标已完成" + String.valueOf(num2) + "%");
            i02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.mForum + "&nomenu=1";
            i2 = 1;
        } else {
            i02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        i02.setOnClickListener(new y(this, i2, str));
    }

    @Override // c.a.t0.h.e.b
    public void setInjectPlugin(int i2, c.a.t0.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048712, this, i2, aVar) == null) {
            this.M.put(i2, aVar);
        }
    }

    public void setIsLiveTab(boolean z2) {
        c.a.t0.e1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.l1(z2);
    }

    public void setIsThreadTab(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) {
            this.B = z2;
        }
    }

    public void setListPullToRefresh(boolean z2) {
        c.a.t0.e1.a3.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || (jVar = this.S) == null) {
            return;
        }
        jVar.b0();
    }

    public void setLiteProgramListFragmentSelect(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z2) == null) {
            this.i0 = z2;
        }
    }

    public void setLiveCardStatData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048717, this) == null) || this.v == null) {
            return;
        }
        c.a.t0.e1.w2.b bVar = new c.a.t0.e1.w2.b();
        if (this.v.needLog == 1) {
            bVar.a = true;
        } else {
            bVar.a = false;
        }
        if (this.v.getForum() != null) {
            bVar.f17048c = this.v.getForum().getId();
        }
        if (getModelController() != null) {
            bVar.f17047b = getModelController().R();
        }
        c.a.t0.e1.w2.b bVar2 = c.a.t0.e1.w2.d.p0;
        if (bVar2 != null) {
            bVar.f17049d = bVar2.f17049d;
            bVar.f17050e = bVar2.f17050e;
        }
        c.a.t0.e1.p2.b bVar3 = new c.a.t0.e1.p2.b(bVar, getTbPageTag(), getUniqueId());
        this.w0 = bVar3;
        bVar3.d(this.z0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.w0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.w0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.w0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.w0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public void setNavigationBarMoveEnable(boolean z2) {
        c.a.t0.e1.v0 v0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || (v0Var = this.L) == null) {
            return;
        }
        v0Var.i(z2);
    }

    public void setPn(int i2) {
        c.a.t0.e1.r2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048719, this, i2) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.o(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.H;
            if (frsTabViewController == null || frsTabViewController.A() == null || !(this.H.A().f43769b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.H.A().f43769b).setPrimary(z2);
        }
    }

    public void setShowAdFlag(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) && this.E1 == null) {
            c.a.t0.g1.a a2 = c.a.t0.g1.a.a(z2);
            this.E1 = a2;
            c.a.t0.e1.r2.c cVar = this.R;
            if (cVar != null) {
                cVar.m(a2);
            }
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, str) == null) {
        }
    }

    public void setWriteIcon(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, ovalActionButton) == null) {
            this.s = ovalActionButton;
        }
    }

    public void setYoungsterDialogShown(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z2) == null) {
            this.E0 = z2;
        }
    }

    public void setmFrsllRedpack(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048725, this, linearLayout) == null) || linearLayout == null) {
            return;
        }
        this.u = linearLayout;
    }

    public void setmRefreshIcon(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048726, this, fRSRefreshButton) == null) || fRSRefreshButton == null) {
            return;
        }
        this.t = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new v0(this));
    }

    public void showForbidViewNoClick(View view, String str, boolean z2, List<RecmForumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048727, this, new Object[]{view, str, Boolean.valueOf(z2), list}) == null) {
            this.r.S0();
            this.r.g1(8);
            if (this.W == null) {
                this.W = new c.a.t0.e1.d3.a(getPageContext(), getNetRefreshListener());
            }
            this.W.c(str);
            this.W.b(list);
            this.W.attachView(view, z2);
        }
    }

    public void showFrsAdvancedAdGuide() {
        c.a.t0.e1.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.D1();
    }

    public void showFrsDeleteThreadTip(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048729, this, str, str2, str3) == null) {
            c.a.t0.e1.z2.h hVar = new c.a.t0.e1.z2.h(str, str2);
            this.B0 = hVar;
            hVar.f(getFragmentActivity(), str3, str2);
        }
    }

    public void showLoadFinishedUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            hideLoadingView(this.r.k0());
            this.r.S1();
            if (this.r.j0() instanceof c.a.t0.e1.x2.d) {
                ((c.a.t0.e1.x2.d) this.r.j0()).d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048731, this, view, z2) == null) {
            this.r.g1(8);
            ((FrsActivity) getActivity()).showLoadingView(view, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048732, this, view, str, z2) == null) {
            super.showNetRefreshView(view, getResources().getString(c.a.t0.e1.i1.refresh_view_title_text), null, getResources().getString(c.a.t0.e1.i1.refresh_view_button_text), z2, getNetRefreshListener());
            this.r.g1(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048733, this, view, str, z2) == null) {
            super.showNetRefreshViewNoClick(view, str, z2);
            this.r.g1(8);
        }
    }

    public void showRefreshIcon() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048734, this) == null) || (fRSRefreshButton = this.t) == null) {
            return;
        }
        fRSRefreshButton.show();
    }

    public void showTopToastRule(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            new BdTopToast(getContext(), 3000).setIcon(true).setContent(str).show(this.r.k0());
        }
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (voiceManager = this.p) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void takePhoto() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048737, this) == null) || PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? "716" : (String) invokeV.objValue;
    }

    public void unlikeCallBack(Object obj) {
        c.a.t0.e1.r2.b bVar;
        c.a.d.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048739, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.f16787i) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // c.a.t0.k3.u
    public void updateLastIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            getModelController().Q0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            FrsViewData frsViewData = this.v;
            if (frsViewData != null) {
                return c.a.s0.d1.t0.a(2) || (c.a.s0.d1.t0.e() && frsViewData.isFrsVideoAutoPlay);
            }
            return super.videoNeedPreload();
        }
        return invokeV.booleanValue;
    }

    public void writeBlog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048742, this, i2) == null) {
            if (!this.mIsLogin) {
                FrsViewData frsViewData = this.v;
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    this.v.getAnti().setIfpost(1);
                }
                if (i2 == 0) {
                    ViewHelper.skipToLoginActivity(getActivity());
                }
            } else if (this.v != null) {
                if (i2 == 0) {
                    c.a.t0.e1.z2.t.a(this, 0);
                } else {
                    this.r.M1();
                }
            }
        }
    }

    public boolean canShowWriteButton(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            if (this.B && !this.i0 && G0(i2)) {
                FrsModelController frsModelController = this.F;
                return (frsModelController != null && frsModelController.U() && (c.a.t0.e1.b.f().i() || c.a.t0.e1.a.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            c.a.t0.e1.q qVar = this.r;
            if (qVar == null) {
                return null;
            }
            return qVar.a0();
        }
        return (BdRecyclerView) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public FrsTabViewController getTabController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.H : (FrsTabViewController) invokeV.objValue;
    }

    public void refresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i2) == null) {
            this.z = false;
            stopVoice();
            c.a.t0.e1.q qVar = this.r;
            if (qVar != null && qVar.h0() != null) {
                this.r.h0().x();
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.F0(i2, true);
            }
        }
    }
}
