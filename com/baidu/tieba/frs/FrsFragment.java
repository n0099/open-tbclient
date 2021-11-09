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
import b.a.l.v0.a;
import b.a.q0.a.g;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.r0.j.f;
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
/* loaded from: classes9.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, b.a.r0.x0.o2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, b.a.r0.x0.t0, b.a.r0.z2.u, b.a.r0.x0.p2.l, b.a.r0.g.e.b, b.a.r0.x0.n0, b.a.r0.x0.q0 {
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
    public static b.a.r0.l3.m cacheData;
    public static boolean isNeedRefreshOnBackFromBarDetail;
    public static volatile int mNetError;
    public static volatile long mPbLoadDataSize;
    public static volatile long mPbLoadTime;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public b.a.r0.x0.x2.e A0;
    public CustomMessageListener A1;
    public boolean B;
    public b.a.r0.x0.q1.f B0;
    public HttpMessageListener B1;
    public String C;
    public boolean C0;
    public CustomMessageListener C1;
    public a.C0090a D;
    public boolean D0;
    public b.a.r0.z0.a D1;
    public ThreadCardViewHolder E;
    public Object E0;
    public FrsModelController F;
    public MessageQueue.IdleHandler F0;
    public b.a.r0.x0.y2.h G;
    public final CustomMessageListener G0;
    public FrsTabViewController H;
    public CustomMessageListener H0;
    public b.a.r0.x0.p2.h I;
    public CustomMessageListener I0;
    public b.a.r0.x0.s2.a J;
    public CustomMessageListener J0;
    public b.a.r0.x0.p2.b K;
    public CustomMessageListener K0;
    public b.a.r0.x0.u0 L;
    public b.a.e.c.g.a L0;
    public SparseArray<b.a.r0.g.e.a> M;
    public CustomMessageListener M0;
    public boolean N;
    public final b.a.r0.x0.s0 N0;
    public b.a.r0.x0.x1.e.b O;
    public FrsTabViewController.n O0;
    public b.a.r0.x0.y2.a P;
    public int P0;
    public b.a.r0.x0.p2.d Q;
    public CustomMessageListener Q0;
    public b.a.r0.x0.p2.c R;
    public CustomMessageListener R0;
    public b.a.r0.x0.y2.j S;
    public final CustomMessageListener S0;
    public b.a.r0.x0.p2.a T;
    public final CustomMessageListener T0;
    public b.a.r0.x0.n2.a U;
    public final CustomMessageListener U0;
    public b.a.r0.x0.p V;
    public final AntiHelper.k V0;
    public b.a.r0.x0.b3.a W;
    public CustomMessageListener W0;
    public b.a.r0.x0.y2.e X;
    public CustomMessageListener X0;
    public boolean Y;
    public CustomMessageListener Y0;
    public b.a.r0.x0.h2.b Z;
    public CustomMessageListener Z0;
    public b.a.r0.j.a a0;
    public CustomMessageListener a1;
    public b.a.r0.w.c b0;
    public HttpMessageListener b1;
    public b.a.r0.x0.t1.a.a c0;
    public b.a.q0.j0.i c1;
    public long createTime;
    public boolean createWithGame;
    public final CustomMessageListener d1;
    public long dataParseTime;
    public long drawStartTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f48190e;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.x0.x1.a f48191f;
    public final CustomMessageListener f1;
    public String forumId;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48192g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48193h;
    public CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48194i;
    public b.a.q0.s.s.a i0;
    public final CustomMessageListener i1;
    public long initTime;
    public boolean isPageStayDurationClose;
    public String j;
    public boolean j0;
    public final CustomMessageListener j1;
    public int k;
    public AddExperiencedModel k0;
    public final g.b k1;
    public boolean l;
    public boolean l0;
    public final b.a.r0.x0.p2.k l1;
    public long layoutTime;
    public b.a.r0.l3.j0.f m;
    public boolean m0;
    public final CustomMessageListener m1;
    public final View.OnClickListener mCommenOnClickListener;
    public b.a.r0.x0.y2.c mEnterFrsDialogController;
    public int mFlag;
    public String mForum;
    public final b.a.r0.l3.t mForumModelCallback;
    public String mFrom;
    public int mHeadLineDefaultNavTabId;
    public final View.OnTouchListener mOnTouchListener;
    public boolean mSpeedUpTipShowing;
    public final d2 mThreadData;
    public boolean n;
    public boolean n0;
    public final RecyclerView.OnScrollListener n1;
    public boolean o;
    public Date o0;
    public final b.a.r0.x0.f o1;
    public VoiceManager p;
    public int p0;
    public final NoNetworkView.b p1;
    public b.a.q0.q0.b perfFluencyLogData;
    public long pullBeginTime;
    public View q;
    public int q0;
    public final CustomMessageListener q1;
    public b.a.r0.x0.q r;
    public int r0;
    public b.a.e.l.e.w r1;
    public OvalActionButton s;
    public List<LiveHorseRaceData> s0;
    public b.a.r0.x0.s0 s1;
    public long sysCreateTime;
    public FRSRefreshButton t;
    public ValueAnimator t0;
    public CustomMessageListener t1;
    public LinearLayout u;
    public Runnable u0;
    public CustomMessageListener u1;
    public FrsViewData v;
    public b.a.r0.x0.n2.b v0;
    public CustomMessageListener v1;
    public String w;
    public b.a.r0.x0.u1.a w0;
    public CustomMessageListener w1;
    public b.a.e.e.k.b<TbImageView> x;
    @Nullable
    public TiePlusEventController x0;
    public CustomMessageListener x1;
    public boolean y;
    public int y0;
    public CustomMessageListener y1;
    public boolean z;
    public int z0;
    public CustomMessageListener z1;

    /* loaded from: classes9.dex */
    public class a implements FrsTabViewController.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48195a;

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
            this.f48195a = frsFragment;
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                boolean z = false;
                if (i2 != 1) {
                    b.a.r0.b0.u.b().e(false);
                    this.f48195a.logStatisticByKey(false);
                }
                if (i2 == 502) {
                    this.f48195a.s.setIconFade(b.a.r0.x0.d1.btn_frs_professional_edit_n);
                } else {
                    this.f48195a.s.setIconFade(0);
                }
                this.f48195a.P0 = i2;
                this.f48195a.y0 = i3;
                if (this.f48195a.v0 != null) {
                    this.f48195a.v0.d(this.f48195a.y0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.f48195a.y0);
                this.f48195a.stopVoice();
                b.a.r0.x0.u2.b bVar = b.a.r0.x0.u2.d.h0;
                bVar.f26388d = i2;
                bVar.f26391g = i3;
                bVar.f26389e = -1;
                if (!this.f48195a.l0) {
                    this.f48195a.r.P1(this.f48195a.I0(i2));
                    return;
                }
                b.a.r0.x0.b.f().p(i2 == 1 && this.f48195a.l0, true);
                b.a.r0.x0.a h2 = b.a.r0.x0.a.h();
                if (i2 == 1 && this.f48195a.l0) {
                    z = true;
                }
                h2.p(z, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48196e;

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
            this.f48196e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48196e.r.O1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48197a;

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
            this.f48197a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.f48197a.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f48197a.t != null) {
                    if (booleanValue) {
                        if (this.f48197a.H.I() == 0 || this.f48197a.r.E0() || b.a.q0.y.d.h().k()) {
                            return;
                        }
                        this.f48197a.t.show();
                        return;
                    }
                    this.f48197a.t.hide();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48198a;

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
            this.f48198a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.f48198a.H.h0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48199a;

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
            this.f48199a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f48199a.v.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.f48199a.r.V().notifyDataSetChanged();
        }
    }

    /* loaded from: classes9.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f48200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48201f;

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
            this.f48201f = frsFragment;
            this.f48200e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (this.f48201f.v != null && this.f48201f.v.getForum() != null) {
                    str = this.f48201f.v.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.f48201f.forumId).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.f48200e.getLive_id() != null) {
                    alaInfoData.live_id = this.f48200e.getLive_id().longValue();
                    alaInfoData.screen_direction = this.f48200e.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f48201f.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.f48201f.forumId)));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48202a;

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
            this.f48202a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.f48202a.v == null) {
                return;
            }
            b.a.r0.x0.x2.n.d(this.f48202a.v, this.f48202a.getPageContext());
        }
    }

    /* loaded from: classes9.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48203a;

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
            this.f48203a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.f48203a.v == null || (userData = this.f48203a.v.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.f48203a.G.P(num);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48204a;

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
            this.f48204a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f48204a.t == null || this.f48204a.s == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                this.f48204a.t.setVisibility(8);
                this.f48204a.s.setVisibility(8);
                return;
            }
            this.f48204a.s.setVisibility(0);
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48205a;

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
            this.f48205a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f48205a.H.b(49);
        }
    }

    /* loaded from: classes9.dex */
    public class d0 implements b.a.r0.x0.w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48206a;

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
            this.f48206a = frsFragment;
        }

        @Override // b.a.r0.x0.w0
        public void a(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f48206a.r == null) {
                return;
            }
            boolean z3 = false;
            if (i2 == 1) {
                this.f48206a.r.t1(b.a.r0.x0.b.f().h());
                this.f48206a.r.u1(z ? 0 : 8);
            } else if (i2 == 2) {
                this.f48206a.r.q1(z ? 0 : 8);
            }
            if (!z2) {
                this.f48206a.l0 = z;
            }
            if (this.f48206a.r.V() != null && (i2 == 2 || (this.f48206a.F != null && this.f48206a.F.U()))) {
                this.f48206a.r.V().notifyDataSetChanged();
            }
            if (this.f48206a.getTabController() != null) {
                FrsTabViewController.o z4 = this.f48206a.getTabController().z();
                if (z4 != null) {
                    if ((z4.f49026b instanceof FrsCommonTabFragment) && (i2 == 2 || z4.f49025a == 502)) {
                        ((FrsCommonTabFragment) z4.f49026b).refreshRecyclerView();
                    } else if ((z4.f49026b instanceof FrsNewAreaFragment) && (i2 == 2 || z4.f49025a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) z4.f49026b;
                        frsNewAreaFragment.refreshRecyclerView();
                        if (frsNewAreaFragment.getFrsView() != null) {
                            b.a.r0.x0.p2.g frsView = frsNewAreaFragment.getFrsView();
                            frsView.G(!z);
                            if (i2 == 1) {
                                frsView.D(!z);
                            } else if (i2 == 2) {
                                frsView.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = z4.f49026b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).refreshRecyclerView();
                        }
                    }
                }
                if (this.f48206a.getTabController().J() != null) {
                    this.f48206a.getTabController().J().setmDisallowSlip(z);
                    this.f48206a.getTabController().e0(z);
                }
            }
            if (this.f48206a.r.X() != null) {
                b.a.r0.x0.q qVar = this.f48206a.r;
                if (this.f48206a.canShowWriteButton() && !z) {
                    z3 = true;
                }
                qVar.P1(z3);
            }
            if (this.f48206a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.f48206a.getActivity()).showTabHost(!z);
            }
            if (this.f48206a.c0 != null) {
                this.f48206a.c0.f(!z);
            }
            this.f48206a.r.z1(!z);
            if (i2 == 1) {
                this.f48206a.r.p1(!z);
            } else if (i2 == 2) {
                this.f48206a.r.p1(true);
            }
        }

        @Override // b.a.r0.x0.w0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f48206a.getContext() == null) {
                return;
            }
            if (i2 != 1) {
                if (i2 != 2 || this.f48206a.r == null) {
                    return;
                }
                new BdTopToast(this.f48206a.getContext()).setIcon(false).setContent(this.f48206a.getContext().getString(b.a.r0.x0.h1.frs_move_area_max_num)).show(this.f48206a.r.k0());
                return;
            }
            b.a.e.e.p.l.L(this.f48206a.getContext(), b.a.r0.x0.h1.frs_multi_delete_max_num);
        }

        @Override // b.a.r0.x0.w0
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f48206a.r == null) {
                return;
            }
            if (i3 == 1) {
                this.f48206a.r.s1(i2);
            } else if (i3 == 2) {
                this.f48206a.r.r1(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f48207e;

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
            this.f48207e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f48207e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f48207e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(b.a.r0.x0.c1.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48208a;

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
            this.f48208a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.f48208a.H.b(1);
                this.f48208a.P0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48209a;

        /* loaded from: classes9.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes9.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
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
            this.f48209a = frsFragment;
        }

        @Override // b.a.r0.j.f.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.f48209a.r.R();
            this.f48209a.r.Q();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.f48209a.H == null || this.f48209a.H.z() == null || !(this.f48209a.H.z().f49026b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.f48209a.H.z().f49026b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.f48209a.getString(b.a.r0.x0.h1.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.f48209a.i0 == null) {
                        FrsFragment frsFragment = this.f48209a;
                        frsFragment.i0 = new b.a.q0.s.s.a(frsFragment.getActivity());
                    }
                    this.f48209a.i0.setMessage(text);
                    this.f48209a.i0.setPositiveButton(b.a.r0.x0.h1.dialog_known, new a(this));
                    this.f48209a.i0.setCanceledOnTouchOutside(false);
                    this.f48209a.i0.create(this.f48209a.getPageContext());
                    this.f48209a.i0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.f48209a.i0 == null) {
                        FrsFragment frsFragment2 = this.f48209a;
                        frsFragment2.i0 = new b.a.q0.s.s.a(frsFragment2.getActivity());
                    }
                    this.f48209a.i0.setMessage(text);
                    this.f48209a.i0.setPositiveButton(b.a.r0.x0.h1.know, new b(this));
                    this.f48209a.i0.setCanceledOnTouchOutside(false);
                    this.f48209a.i0.create(this.f48209a.getPageContext());
                    this.f48209a.i0.show();
                } else {
                    this.f48209a.r.K1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.f48209a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? b.a.r0.x0.b1.nav_bar_tip_error : b.a.r0.x0.b1.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.processBatchDelete(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.f48209a.L0(deleteThreadHttpResponseMessage.getSuccessItems());
                b.a.r0.x0.b.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (b.a.e.l.e.n nVar : this.f48209a.v.getThreadList()) {
                    if (nVar instanceof c2) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.f48209a.loadMore();
                    return;
                }
                return;
            }
            b.a.e.e.p.l.M(this.f48209a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes9.dex */
    public class e1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f48210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48211f;

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
            this.f48211f = frsFragment;
            this.f48210e = frsRedpackRunView;
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
                this.f48210e.setAlpha(0.0f);
                this.f48210e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(b.a.r0.x0.c1.tbds660));
                this.f48210e.hide();
                this.f48211f.u.removeView(this.f48210e);
                if (this.f48211f.s0 == null || this.f48211f.r0 <= this.f48211f.s0.size() - 1) {
                    this.f48211f.S0();
                    return;
                }
                this.f48211f.u.removeAllViews();
                this.f48211f.u.setVisibility(8);
                this.f48211f.r0 = 0;
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

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48212a;

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
            this.f48212a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.r0.l3.x) || this.f48212a.v == null) {
                return;
            }
            this.f48212a.v.updateLikeData((b.a.r0.l3.x) customResponsedMessage.getData());
            this.f48212a.G.S(this.f48212a.v);
            this.f48212a.H.d(this.f48212a.v, this.f48212a.F.R());
        }
    }

    /* loaded from: classes9.dex */
    public class f0 implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48213a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f48214e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f0 f48215f;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class RunnableC1719a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f48216e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f48217f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f48218g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f48219h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ int f48220i;
                public final /* synthetic */ a j;

                public RunnableC1719a(a aVar, long j, int i2, int i3, float f2, int i4) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.j = aVar;
                    this.f48216e = j;
                    this.f48217f = i2;
                    this.f48218g = i3;
                    this.f48219h = f2;
                    this.f48220i = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.f48216e, 0L, 0L, this.f48217f, this.f48218g, this.f48219h, this.f48220i);
                        requestGetMyPostNetMessage.setTag(this.j.f48215f.f48213a.getUniqueId());
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
                this.f48215f = f0Var;
                this.f48214e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f48215f.f48213a.H.b(301);
                    b.a.e.e.m.e.a().postDelayed(new RunnableC1719a(this, b.a.e.e.m.b.g((String) this.f48214e.get(b.a.q0.a.g.s), 0L), b.a.e.e.p.l.k(TbadkCoreApplication.getInst()), b.a.e.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
            this.f48213a = frsFragment;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(b.a.q0.a.g.r) instanceof String) {
                this.f48213a.mForum = (String) hashMap.get(b.a.q0.a.g.r);
            }
            if (!(hashMap.get(b.a.q0.a.g.M) instanceof String) || TextUtils.isEmpty((String) hashMap.get(b.a.q0.a.g.M))) {
                return;
            }
            b.a.e.e.m.e.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes9.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f48221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48222f;

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
            this.f48222f = frsFragment;
            this.f48221e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48222f.u == null || this.f48221e == null) {
                return;
            }
            this.f48222f.t0.start();
        }
    }

    /* loaded from: classes9.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48223a;

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
            this.f48223a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f48223a.v == null) {
                return;
            }
            this.f48223a.v.removeGameRankListFromThreadList();
            if (this.f48223a.r != null) {
                this.f48223a.r.F0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48224a;

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
            this.f48224a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f48224a.v.getToLoadHorseData().intValue() == 1 && this.f48224a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.f48224a.forumId));
                this.f48224a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48225a;

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
            this.f48225a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f45669c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.f48225a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.f48225a.getActivity(), updateAttentionMessage.getData().l, this.f48225a.V0) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f45667a && updateAttentionMessage.getData().f45670d) {
                    b.a.e.e.p.l.L(this.f48225a.getPageContext().getPageActivity(), b.a.r0.x0.h1.attention_success);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements b.a.r0.x0.p2.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48226a;

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
            this.f48226a = frsFragment;
        }

        @Override // b.a.r0.x0.p2.k
        public void a(int i2, boolean z, int i3, boolean z2, ArrayList<b.a.e.l.e.n> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.f48226a.J == null || this.f48226a.F == null || !this.f48226a.F.u0() || !z || z2 || z3) {
                return;
            }
            this.f48226a.J.a(i3);
        }
    }

    /* loaded from: classes9.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48227a;

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
            this.f48227a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.f48227a.o0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48228a;

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
            this.f48228a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f48228a.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48229e;

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
            this.f48229e = frsFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f48229e.L != null && this.f48229e.L.e() != null) {
                    this.f48229e.L.e().c(motionEvent);
                }
                if (this.f48229e.Z != null) {
                    this.f48229e.Z.b(view, motionEvent);
                }
                if (this.f48229e.G != null) {
                    this.f48229e.G.O(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48230a;

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
            this.f48230a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.q0.s.q.a0) && this.f48230a.isResumed()) {
                b.a.q0.s.q.a0 a0Var = (b.a.q0.s.q.a0) customResponsedMessage.getData();
                if (this.f48230a.w0 == null) {
                    FrsFragment frsFragment = this.f48230a;
                    frsFragment.w0 = new b.a.r0.x0.u1.a(frsFragment.getPageContext());
                }
                if (this.f48230a.v == null || this.f48230a.v.getForum() == null || TextUtils.isEmpty(this.f48230a.v.getForum().getId())) {
                    return;
                }
                this.f48230a.w0.g(a0Var.f13198a, this.f48230a.v.getForum().getId(), this.f48230a.v.getForum().getName(), a0Var.f13199b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48231a;

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
            this.f48231a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.f48231a.r.N1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48232a;

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
            this.f48232a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
            if (j.k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || this.f48232a.v.getForum() == null) {
                return;
            }
            this.f48232a.v.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes9.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48233a;

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
            this.f48233a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (d2Var = (d2) customResponsedMessage.getData()) != null && this.f48233a.isResumed()) {
                FrsFragment frsFragment = this.f48233a;
                frsFragment.C = d2Var.s1() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", d2Var.T());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48234a;

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
            this.f48234a = frsFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f48234a.refreshLevel();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f48235e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48236f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48237g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f48238h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f48239i;
        public final /* synthetic */ FrsFragment j;

        public k0(FrsFragment frsFragment, long j, int i2, int i3, float f2, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = frsFragment;
            this.f48235e = j;
            this.f48236f = i2;
            this.f48237g = i3;
            this.f48238h = f2;
            this.f48239i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.f48235e, 0L, 0L, this.f48236f, this.f48237g, this.f48238h, this.f48239i);
                requestGetMyPostNetMessage.setTag(this.j.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48240a;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k1 f48241e;

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
                this.f48241e = k1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f48241e.f48240a.v.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(this.f48241e.f48240a.getContext(), "ForumGradePage", hashMap)));
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
            this.f48240a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg) && this.f48240a.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(this.f48240a.getContext()).setTitle(this.f48240a.getString(b.a.r0.x0.h1.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.f48240a.getString(b.a.r0.x0.h1.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.f48240a.q.findViewById(b.a.r0.x0.e1.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                forumBroadcastHelper.jumpFlutterEditGenear(this.f48240a.v.getForum().getId(), this.f48240a.v.getForum().getName(), "6");
                forumBroadcastHelper.clipCopy(this.f48240a.C);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48242a;

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
            this.f48242a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), this.f48242a.forumId)) {
                this.f48242a.T.l(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48243e;

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
            this.f48243e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.r0.l3.p0.a.o(this.f48243e.mForum);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48244a;

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
            this.f48244a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            b.a.r0.j.h hVar = (b.a.r0.j.h) customResponsedMessage.getData();
            if (this.f48244a.v == null || this.f48244a.v.getForum() == null || this.f48244a.v.getForum().getDeletedReasonInfo() == null) {
                b.a.r0.j.e.d(0, this.f48244a.getPageContext(), hVar, null, this.f48244a.v.getUserData());
                return;
            }
            b.a.r0.j.i iVar = new b.a.r0.j.i(this.f48244a.v.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f48244a.v.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.f48244a.v.forumRule != null ? this.f48244a.v.forumRule.has_forum_rule.intValue() : 0);
            iVar.i(this.f48244a.v.getForum().getId(), this.f48244a.v.getForum().getName());
            iVar.h(this.f48244a.v.getForum().getImage_url());
            iVar.j(this.f48244a.v.getForum().getUser_level());
            b.a.r0.j.e.d(iVar.f(), this.f48244a.getPageContext(), hVar, iVar, this.f48244a.v.getUserData());
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48245a;

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
            this.f48245a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.f48245a.r != null) {
                    this.f48245a.r.W0(msgCount, z);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48247f;

        public m0(FrsFragment frsFragment, b.a.q0.s.s.a aVar) {
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
            this.f48247f = frsFragment;
            this.f48246e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f48246e) == null) {
                return;
            }
            aVar.dismiss();
            this.f48247f.e1();
        }
    }

    /* loaded from: classes9.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48248a;

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
            this.f48248a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f48248a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f48248a.H.z() == null || !(this.f48248a.H.z().f49026b instanceof BaseFragment) || !((BaseFragment) this.f48248a.H.z().f49026b).isPrimary() || this.f48248a.r.E0()) {
                this.f48248a.u.setVisibility(8);
                this.f48248a.y = true;
                return;
            }
            this.f48248a.u.setVisibility(0);
            this.f48248a.y = false;
        }
    }

    /* loaded from: classes9.dex */
    public class n extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48249a;

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
            this.f48249a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f48249a.getContext() == null || this.f48249a.r == null) {
                return;
            }
            int i2 = 0;
            if (httpResponsedMessage.getError() == 0) {
                new BdTopToast(this.f48249a.getContext()).setIcon(true).setContent(this.f48249a.getContext().getString(b.a.r0.x0.h1.frs_move_area_move_suc)).show(this.f48249a.r.k0());
                if (b.a.r0.x0.a.h().k(b.a.r0.x0.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.f48249a.H != null && this.f48249a.H.z() != null && (this.f48249a.H.z().f49026b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.f48249a.H.z().f49026b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.processBatchDelete();
                    }
                    this.f48249a.M0();
                    b.a.r0.x0.a.h().d();
                    for (b.a.e.l.e.n nVar : this.f48249a.v.getThreadList()) {
                        if (nVar instanceof c2) {
                            i2++;
                            continue;
                        }
                        if (i2 >= 6) {
                            break;
                        }
                    }
                    if (i2 < 6) {
                        this.f48249a.loadMore();
                    }
                }
                b.a.r0.x0.a.h().n();
                return;
            }
            new BdTopToast(this.f48249a.getContext()).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show(this.f48249a.r.k0());
        }
    }

    /* loaded from: classes9.dex */
    public class n0 implements b.a.q0.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48250a;

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
            this.f48250a = frsFragment;
        }

        @Override // b.a.q0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    b.a.q0.y.d.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.f48250a.s != null) {
                        this.f48250a.s.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.f48250a.getContext()).setIcon(false).setContent(this.f48250a.getContext().getString(b.a.r0.x0.h1.forum_broadcast_copy_no_permission_hint)).show(this.f48250a.r.k0());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n1 extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48251a;

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
            this.f48251a = frsFragment;
        }

        @Override // b.a.e.c.g.a
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
                if (this.f48251a.s0 != null) {
                    if (this.f48251a.u == null || this.f48251a.u.getVisibility() != 8) {
                        if (this.f48251a.r0 >= this.f48251a.s0.size()) {
                            this.f48251a.s0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = this.f48251a;
                        frsFragment.s0 = frsFragment.s0.subList(0, this.f48251a.r0);
                        this.f48251a.s0.addAll(arrayList);
                        return;
                    }
                    this.f48251a.s0 = new ArrayList();
                    this.f48251a.s0.addAll(arrayList);
                    this.f48251a.r0 = 0;
                    this.f48251a.S0();
                    return;
                }
                this.f48251a.s0 = new ArrayList();
                this.f48251a.r0 = 0;
                this.f48251a.s0.addAll(arrayList);
                this.f48251a.S0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o extends b.a.q0.j0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48252g;

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
            this.f48252g = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                new BdTopToast(this.f48252g.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.f48252g.r.k0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class o0 implements b.a.q0.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48253a;

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
            this.f48253a = frsFragment;
        }

        @Override // b.a.q0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                b.a.q0.y.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.f48253a.s != null) {
                    this.f48253a.s.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48254a;

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
            this.f48254a = frsFragment;
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
                this.f48254a.P0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48255a;

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
            this.f48255a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f48255a.isResumed()) {
                this.f48255a.o1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48256e;

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
            this.f48256e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48256e.r != null && view == this.f48256e.r.T() && this.f48256e.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f48256e.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view.getId() == b.a.r0.x0.e1.game_activity_egg_layout && b.a.e.e.p.l.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.f48256e.r == null || !this.f48256e.r.A0()) {
                        String c2 = this.f48256e.v.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c2)) {
                            b.a.q0.m.a.k(this.f48256e.getPageContext().getPageActivity(), c2);
                        }
                    } else {
                        this.f48256e.r.F1();
                    }
                }
                if (this.f48256e.r != null && view == this.f48256e.r.b0() && this.f48256e.F != null && this.f48256e.F.i0()) {
                    this.f48256e.r.I1();
                    this.f48256e.loadMore();
                }
                if (view != null && this.f48256e.r != null && view == this.f48256e.r.c0()) {
                    if (!ViewHelper.checkUpIsLogin(this.f48256e.getContext())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f48256e.getContext())));
                }
                if (b.a.e.e.p.j.z()) {
                    if (this.f48256e.v == null || this.f48256e.v.getForum() == null) {
                        return;
                    }
                    if (this.f48256e.r != null && view == this.f48256e.r.p0()) {
                        if (this.f48256e.v == null || this.f48256e.v.getForum() == null || StringUtils.isNull(this.f48256e.v.getForum().getId()) || StringUtils.isNull(this.f48256e.v.getForum().getName())) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", this.f48256e.v.getForum().getId()).param("obj_locate", 11));
                        b.a.r0.x0.x2.i.c(this.f48256e.getPageContext(), this.f48256e.v, this.f48256e.v.getForum().getId());
                    }
                    if (this.f48256e.r == null || view != this.f48256e.r.o0()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12402").param("fid", this.f48256e.v.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f48256e.v.getForum().getName()));
                    if (StringUtils.isNull(this.f48256e.v.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.f48256e.getContext(), this.f48256e.v.getForum().getName(), this.f48256e.v.getForum().getId())));
                    return;
                }
                b.a.e.e.p.l.L(this.f48256e.getContext().getApplicationContext(), b.a.r0.x0.h1.network_not_available);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p1 implements b.a.r0.x0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48257a;

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
            this.f48257a = frsFragment;
        }

        @Override // b.a.r0.x0.s0
        public void a(int i2, int i3, b.a.r0.x0.l1 l1Var, ArrayList<b.a.e.l.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), l1Var, arrayList}) == null) {
                this.f48257a.showLoadFinishedUI();
                if (this.f48257a.O != null) {
                    this.f48257a.G.b0(this.f48257a.O.e(i2));
                }
                b.a.r0.l3.f fVar = new b.a.r0.l3.f();
                if (l1Var != null) {
                    boolean z = l1Var.f25911e == 0;
                    fVar.f20551b = z;
                    fVar.f20552c = l1Var.f25911e;
                    fVar.f20553d = l1Var.f25912f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.f48257a.r.s0();
                        } else if (l1Var.f25913g) {
                            if (ListUtils.getCount(this.f48257a.v.getThreadList()) > 3) {
                                this.f48257a.r.I1();
                            } else {
                                this.f48257a.r.E1();
                            }
                        } else if (l1Var.f25915i) {
                            this.f48257a.r.L1();
                        } else {
                            this.f48257a.r.s0();
                        }
                    }
                } else {
                    l1Var = new b.a.r0.x0.l1();
                    l1Var.f26789c = 1;
                    l1Var.f25913g = false;
                    l1Var.f25915i = false;
                }
                if (i2 == 1) {
                    this.f48257a.A = true;
                    FrsFragment frsFragment = this.f48257a;
                    frsFragment.mForumModelCallback.d(frsFragment.F.getType(), false, fVar);
                } else {
                    this.f48257a.h1(fVar);
                    if (this.f48257a.F.d0() != null) {
                        FrsFragment frsFragment2 = this.f48257a;
                        frsFragment2.v = frsFragment2.F.d0();
                    }
                    this.f48257a.X0();
                }
                if (this.f48257a.s1 != null) {
                    this.f48257a.s1.a(i2, i3, l1Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48258a;

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
            this.f48258a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f48258a.r != null) {
                    this.f48258a.r.d1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f48259a;

        /* renamed from: b  reason: collision with root package name */
        public int f48260b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48261c;

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
            this.f48261c = frsFragment;
            this.f48259a = 0;
            this.f48260b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f48261c.G != null) {
                    this.f48261c.G.l0(i2);
                    if (i2 == 1) {
                        this.f48261c.G.w();
                    }
                }
                FrsFragment frsFragment = this.f48261c;
                if (frsFragment.perfFluencyLogData == null && !frsFragment.isFromMainTab()) {
                    this.f48261c.perfFluencyLogData = new b.a.q0.q0.b();
                    this.f48261c.perfFluencyLogData.a(1000);
                }
                if (i2 != 0) {
                    if (this.f48261c.E0 == null) {
                        this.f48261c.E0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("frs", "1", "scroll");
                    }
                    b.a.q0.q0.b bVar = this.f48261c.perfFluencyLogData;
                    if (bVar != null) {
                        bVar.d();
                    }
                } else {
                    b.a.q0.q0.b bVar2 = this.f48261c.perfFluencyLogData;
                    if (bVar2 != null) {
                        bVar2.e();
                    }
                    b.a.r0.b0.u.b().e(true);
                    this.f48261c.logStatisticByKey(true);
                    this.f48261c.r.I0(this.f48259a, this.f48260b);
                    if (this.f48261c.E0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f48261c.E0);
                        this.f48261c.E0 = null;
                    }
                }
                if (this.f48261c.X != null) {
                    this.f48261c.X.i(recyclerView, i2);
                }
                if (i2 == 0) {
                    b.a.r0.x0.x2.l.b(this.f48261c.r, this.f48261c.v, this.f48261c.getForumId(), false, null);
                }
                if (this.f48261c.H != null && i2 == 1) {
                    this.f48261c.H.L();
                }
                if (this.f48261c.E == null) {
                    if (this.f48261c.r.h0() != null && !this.f48261c.r.Z() && this.f48261c.r.h0().j() != null && (this.f48261c.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.f48261c;
                        frsFragment2.E = (ThreadCardViewHolder) frsFragment2.r.h0().j().getTag();
                    }
                } else if (i2 == 0 && this.f48261c.r.h0() != null && !this.f48261c.r.Z() && this.f48261c.r.h0().j() != null && (this.f48261c.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.f48261c;
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
                this.f48261c.q0 += i3;
                if (this.f48261c.q0 >= this.f48261c.p0 * 2 && i3 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.f48261c.P != null) {
                    this.f48261c.P.j();
                }
                this.f48259a = 0;
                this.f48260b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.f48259a = bdRecyclerView.getFirstVisiblePosition();
                    this.f48260b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.f48261c.X != null) {
                    this.f48261c.X.h(recyclerView, this.f48259a, this.f48260b);
                }
                if (this.f48261c.v == null || this.f48261c.r == null || this.f48261c.r.V() == null) {
                    return;
                }
                this.f48261c.r.e1(this.f48259a, this.f48260b);
                if (this.f48261c.E == null || this.f48261c.E.getCardView() == null) {
                    return;
                }
                this.f48261c.E.getCardView().n(this.f48261c.D);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class q1 implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48262e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48263e;

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
                this.f48263e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f48263e);
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
            this.f48262e = frsFragment;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == b.a.r0.x0.u.f26361e) {
                if (this.f48262e.r != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f48262e.forumId).param("obj_locate", "1"));
                    this.f48262e.r.Q1();
                }
            } else if (nVar == null || !(nVar instanceof c2)) {
            } else {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.E() == null || d2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f48262e.getActivity())) {
                    if (d2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f48262e.getActivity())) {
                        if (d2Var.G() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f48262e.getActivity())) {
                                String a2 = d2Var.G().a();
                                if (StringUtils.isNull(a2) || !b.a.e.e.p.l.D()) {
                                    return;
                                }
                                b.a.q0.m.a.k(this.f48262e.getActivity(), a2);
                            }
                        } else if (d2Var.M() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f48262e.getPageContext().getPageActivity());
                                return;
                            }
                            b.a.q0.s.q.u M = d2Var.M();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f48262e.getPageContext().getPageActivity(), M.a(), M.b(), 2)));
                        } else {
                            b.a.r0.l3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.d(d2Var.f0())) {
                                readThreadHistory.a(d2Var.f0());
                            }
                            String z2 = d2Var.z();
                            if (z2 == null || z2.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, z2)).start();
                                z = true;
                            }
                            String s1 = d2Var.s1();
                            if (s1 == null) {
                                s1 = "";
                            }
                            if (d2Var.r0() == 2 && !s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(this.f48262e.getPageContext(), new String[]{s1, "", null});
                                return;
                            }
                            if (s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && s1.length() > 4) {
                                d2Var.O3(s1.substring(3));
                            }
                            if (bdUniqueId.getId() == d2.T3.getId()) {
                                b.a.r0.x0.x2.l.c(d2Var.j1());
                            } else if (bdUniqueId.getId() == d2.C3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", d2Var.s1());
                                TiebaStatic.log(statisticItem);
                            }
                            b.a.r0.x0.x2.m.e(this.f48262e, d2Var, i2, z);
                            FrsFragment frsFragment = this.f48262e;
                            b.a.r0.x0.x2.l.d(frsFragment, frsFragment.v, d2Var);
                        }
                    }
                }
            }
        }

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }
    }

    /* loaded from: classes9.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48264a;

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
            this.f48264a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || b.a.e.e.p.k.isEmpty(str) || !str.equals(this.f48264a.forumId)) {
                    return;
                }
                b.a.r0.x0.x2.i.d(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.f48264a.v);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48265a;

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
            this.f48265a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f48265a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f48265a.H.I() == 0 || this.f48265a.H.z() == null || !(this.f48265a.H.z().f49026b instanceof BaseFragment) || !((BaseFragment) this.f48265a.H.z().f49026b).isPrimary() || this.f48265a.r.E0() || b.a.q0.y.d.h().k()) {
                if (this.f48265a.H.I() != 0) {
                    this.f48265a.t.hide();
                    return;
                }
                return;
            }
            this.f48265a.t.show();
        }
    }

    /* loaded from: classes9.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48266a;

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
            this.f48266a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f48266a.r == null) {
                return;
            }
            this.f48266a.r.N();
        }
    }

    /* loaded from: classes9.dex */
    public class s0 implements b.a.r0.x0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48267a;

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
            this.f48267a = frsFragment;
        }

        @Override // b.a.r0.x0.f
        public void a(int i2, int i3, View view, View view2, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, view2, d2Var}) == null) {
                if (i2 != this.f48267a.r.V().d()) {
                    if (i2 != this.f48267a.r.V().k()) {
                        if (i2 != this.f48267a.r.V().j() || this.f48267a.v == null || this.f48267a.v.getUserData() == null || !this.f48267a.v.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.f48267a.v.getBawuCenterUrl();
                        if (b.a.e.e.p.k.isEmpty(bawuCenterUrl) || this.f48267a.v.getForum() == null) {
                            return;
                        }
                        b.a.q0.m.a.l(this.f48267a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.f48267a.v.getForum().getId()).param("uid", this.f48267a.v.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.f48267a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.f48267a.v == null || this.f48267a.v.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.f48267a.v.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f48267a.getPageContext().getPageActivity(), b.a.e.e.m.b.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f48267a.getActivity())) {
                    TiebaStatic.log(FrsFragment.MTJ_FORUM_FORTUNE_CLICK);
                    b.a.r0.x0.x2.m.d(this.f48267a.getPageContext(), this.f48267a.v);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48268a;

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
            this.f48268a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f48268a.showFrsAdvancedAdGuide();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48269e;

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
            this.f48269e = frsFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f48269e.F.b0() == 1 && z && !this.f48269e.r.Z()) {
                if (this.f48269e.v != null && !ListUtils.isEmpty(this.f48269e.v.getThreadList())) {
                    this.f48269e.r.G0();
                    return;
                }
                FrsFragment frsFragment = this.f48269e;
                frsFragment.hideNetRefreshView(frsFragment.r.W().k());
                FrsFragment frsFragment2 = this.f48269e;
                frsFragment2.showLoadingView(frsFragment2.r.k0(), true);
                this.f48269e.r.t0(false);
                this.f48269e.refresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u implements b.a.r0.l3.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f48270a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48271b;

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
            this.f48271b = frsFragment;
            this.f48270a = 0L;
        }

        @Override // b.a.r0.l3.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f48270a = System.nanoTime();
                if (this.f48271b.r == null) {
                    return;
                }
                if (i2 == 1 || i2 == 2) {
                    this.f48271b.r.G0();
                }
            }
        }

        @Override // b.a.r0.l3.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f48271b.refreshLevel();
            }
        }

        @Override // b.a.r0.l3.t
        public void c(b.a.r0.l3.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                if ((mVar == null || !(FrsFragment.NORMAL_FRS.equals(this.f48271b.F.Z()) || FrsFragment.STAR_FRS.equals(this.f48271b.F.Z()) || FrsFragment.BOOK_FRS.equals(this.f48271b.F.Z()))) && !FrsFragment.BRAND_FRS.equals(this.f48271b.F.Z())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
                this.f48271b.Z0(mVar);
                FrsFragment.cacheData = mVar;
            }
        }

        @Override // b.a.r0.l3.t
        public void d(int i2, boolean z, b.a.r0.l3.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f48271b.N) {
                    this.f48271b.N = false;
                    b.a.r0.x0.x2.l.b(this.f48271b.r, this.f48271b.v, this.f48271b.getForumId(), false, null);
                }
                this.f48271b.showLoadFinishedUI();
                this.f48271b.z = true;
                if (fVar != null && fVar.f20551b) {
                    this.f48271b.r.V().o(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.mPbLoadTime = 0L;
                    FrsFragment.mPbLoadDataSize = 0L;
                    FrsFragment.mNetError = 0;
                } else {
                    FrsFragment.mNetError = 1;
                }
                if (!this.f48271b.F.u0() && (i2 == 3 || i2 == 6)) {
                    this.f48271b.R.k();
                }
                this.f48271b.drawStartTime = System.currentTimeMillis();
                if (this.f48271b.F.d0() != null) {
                    FrsFragment frsFragment = this.f48271b;
                    frsFragment.v = frsFragment.F.d0();
                }
                this.f48271b.g1(1);
                this.f48271b.b1();
                if (i2 == 7) {
                    this.f48271b.Y0(this.f48271b.v.getFrsDefaultTabId());
                    return;
                }
                if (this.f48271b.v.getPage() != null) {
                    FrsFragment frsFragment2 = this.f48271b;
                    frsFragment2.setHasMore(frsFragment2.v.getPage().b());
                }
                if (i2 == 4) {
                    if (!this.f48271b.F.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.f48271b.F.b0() == 1 && !b.a.r0.z0.a.d()) {
                        this.f48271b.v.addRecommendAppToThreadList(this.f48271b);
                    }
                    ArrayList<b.a.e.l.e.n> c2 = this.f48271b.R.c(false, false, this.f48271b.v.getThreadList(), this.f48271b.m, false);
                    if (c2 != null) {
                        this.f48271b.v.setThreadList(c2);
                        this.f48271b.v.checkLiveStageInThreadList();
                    }
                    if (this.f48271b.F != null) {
                        b.a.r0.x0.u2.c.l(this.f48271b.v, this.f48271b.F.R(), 2, this.f48271b.getContext());
                    }
                    FrsFragment frsFragment3 = this.f48271b;
                    b.a.r0.x0.x2.a.a(frsFragment3, frsFragment3.v.getForum(), this.f48271b.v.getThreadList(), false, this.f48271b.getPn());
                    this.f48271b.r.A1(c2, this.f48271b.v);
                    this.f48271b.j1();
                    return;
                }
                this.f48271b.j1();
                if (i2 == 1) {
                    this.f48271b.r.G0();
                } else if (i2 == 2) {
                    this.f48271b.r.G0();
                } else if (i2 == 3 || i2 == 6) {
                    if (this.f48271b.v != null) {
                        this.f48271b.v.clearPostThreadCount();
                    }
                    b.a.r0.x0.y2.c cVar = this.f48271b.mEnterFrsDialogController;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
                this.f48271b.n1();
                if (fVar == null || fVar.f20552c == 0) {
                    if (this.f48271b.v == null) {
                        return;
                    }
                    FrsFragment frsFragment4 = this.f48271b;
                    frsFragment4.c1(frsFragment4.v);
                    this.f48271b.W0(false, i2 == 5);
                    if (this.f48271b.F != null) {
                        if (this.f48271b.v.getActivityHeadData() != null && this.f48271b.v.getActivityHeadData().b() != null && this.f48271b.v.getActivityHeadData().b().size() > 0) {
                            b.a.r0.x0.u2.a.g(this.f48271b.getUniqueId(), 1, this.f48271b.v.getForum(), this.f48271b.F.a0(), 1);
                        }
                        if (this.f48271b.v.getThreadList() != null && this.f48271b.v.getThreadList().size() > 0) {
                            Iterator<b.a.e.l.e.n> it = this.f48271b.v.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                b.a.e.l.e.n next = it.next();
                                if ((next instanceof d2) && ((d2) next).getType() == d2.T3) {
                                    b.a.r0.x0.u2.a.g(this.f48271b.getUniqueId(), 1, this.f48271b.v.getForum(), this.f48271b.F.a0(), 2);
                                    break;
                                }
                            }
                        }
                        b.a.r0.x0.u2.a.h(this.f48271b.getUniqueId(), this.f48271b.v.getThreadList(), this.f48271b.v.getForum(), this.f48271b.F.a0());
                    }
                    this.f48271b.r.R0(i2);
                    FrsFragment.mPbLoadTime = (System.nanoTime() - this.f48270a) / 1000000;
                    if (fVar != null) {
                        FrsFragment.mPbLoadDataSize = fVar.f20554e;
                    }
                } else if (this.f48271b.v == null || ListUtils.isEmpty(this.f48271b.v.getThreadList())) {
                    this.f48271b.h1(fVar);
                } else if (fVar.f20550a) {
                    FrsFragment frsFragment5 = this.f48271b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(b.a.r0.x0.h1.net_error_text, fVar.f20553d, Integer.valueOf(fVar.f20552c)));
                }
                this.f48271b.m1();
                this.f48271b.K0();
                if (this.f48271b.v.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.f48271b.n && this.f48271b.H.b(49)) {
                    this.f48271b.n = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48272a;

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
            this.f48272a = frsFragment;
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
                b.a.r0.x0.x2.c.a(customResponsedMessage, this.f48272a.r, this.f48272a.v);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48273a;

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
            this.f48273a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof d2) {
                    b.a.r0.x0.x2.l.b(this.f48273a.r, this.f48273a.v, this.f48273a.getForumId(), true, (d2) data);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48274e;

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
            this.f48274e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48274e.H == null) {
                return;
            }
            FrsTabViewController.o z = this.f48274e.H.z();
            if (z != null && (fragment = z.f49026b) != null && (fragment instanceof b.a.r0.x0.p0)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((b.a.r0.x0.p0) z.f49026b).scrollToTop();
                ((b.a.r0.x0.p0) z.f49026b).forceRefresh();
                return;
            }
            this.f48274e.getFrsView().Q1();
        }
    }

    /* loaded from: classes9.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f48275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48277g;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, b.a.q0.s.s.a aVar) {
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
            this.f48277g = frsFragment;
            this.f48275e = privateForumPopInfoData;
            this.f48276f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f48277g.getPageContext(), new String[]{this.f48275e.z()});
                this.f48276f.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w0 implements b.a.r0.x0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48278a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w0 f48279e;

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
                this.f48279e = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f48279e.f48278a.r != null && this.f48279e.f48278a.r.B0()) {
                    this.f48279e.f48278a.loadMore();
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
            this.f48278a = frsFragment;
        }

        @Override // b.a.r0.x0.s0
        public void a(int i2, int i3, b.a.r0.x0.l1 l1Var, ArrayList<b.a.e.l.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), l1Var, arrayList}) == null) {
                b.a.e.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48280a;

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
            this.f48280a = frsFragment;
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
            this.f48280a.Y = true;
        }
    }

    /* loaded from: classes9.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48282f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48283g;

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
            this.f48283g = frsFragment;
            this.f48281e = i2;
            this.f48282f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f48283g.forumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f48281e));
                UrlManager.getInstance().dealOneLink(this.f48283g.getPageContext(), new String[]{this.f48282f});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48284a;

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
            this.f48284a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.f48284a.E == null && this.f48284a.r.h0() != null && !this.f48284a.r.Z() && this.f48284a.r.h0().j() != null && (this.f48284a.r.h0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.f48284a;
                        frsFragment.E = (ThreadCardViewHolder) frsFragment.r.h0().j().getTag();
                    }
                    if (this.f48284a.E == null || this.f48284a.E.getCardView() == null) {
                        return;
                    }
                    this.f48284a.E.getCardView().n(new a.C0090a(3));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48285e;

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
            this.f48285e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48285e.z || !b.a.e.e.p.j.z() || this.f48285e.r.D0()) {
                return;
            }
            this.f48285e.r.T0();
        }
    }

    /* loaded from: classes9.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f48286a;

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
            this.f48286a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f48286a.r == null) {
                return;
            }
            this.f48286a.r.Q0();
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
        this.f48190e = "";
        this.mSpeedUpTipShowing = false;
        this.f48192g = false;
        this.f48193h = true;
        this.mForum = null;
        this.mFrom = null;
        this.mFlag = 0;
        this.createWithGame = false;
        this.f48194i = false;
        this.j = null;
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
        this.D = new a.C0090a(2);
        this.M = new SparseArray<>();
        this.N = true;
        this.j0 = false;
        this.l0 = false;
        this.n0 = false;
        this.o0 = null;
        this.p0 = 0;
        this.q0 = 0;
        this.r0 = 0;
        this.mHeadLineDefaultNavTabId = -1;
        this.z0 = -1;
        this.F0 = new k(this);
        this.G0 = new v(this, 2016495);
        this.H0 = new g0(this, 2921005);
        this.I0 = new r0(this, 2921401);
        this.J0 = new c1(this, 2921473);
        this.K0 = new m1(this, 2921467);
        this.L0 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.M0 = new o1(this, 2001624);
        this.N0 = new p1(this);
        this.O0 = new a(this);
        this.Q0 = new b(this, 2001606);
        this.R0 = new c(this, 2001607);
        this.S0 = new d(this, 2003019);
        this.T0 = new e(this, 2921470);
        this.U0 = new f(this, 2001352);
        this.V0 = new g(this);
        this.W0 = new h(this, 2001115);
        this.X0 = new i(this, 2921346);
        this.Y0 = new j(this, 2001374);
        this.Z0 = new l(this, 2001378);
        this.a1 = new m(this, 2001626);
        this.b1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.c1 = new o(this);
        this.d1 = new p(this, 2921391);
        this.e1 = new q(this, 2003020);
        this.f1 = new r(this, 2921463);
        this.g1 = new s(this, 2921587);
        this.h1 = new t(this, 2921588);
        this.mForumModelCallback = new u(this);
        this.i1 = new b0(this, 2016485);
        this.j1 = new c0(this, 2001194);
        this.k1 = new f0(this);
        this.l1 = new h0(this);
        this.mOnTouchListener = new i0(this);
        this.m1 = new j0(this, 2004507);
        this.mCommenOnClickListener = new p0(this);
        this.n1 = new q0(this);
        this.o1 = new s0(this);
        this.p1 = new t0(this);
        this.q1 = new u0(this, 0);
        this.r1 = new q1(this, null);
        this.s1 = new w0(this);
        this.t1 = new x0(this, 2921033);
        this.u1 = new y0(this, 2921381);
        this.v1 = new z0(this, 2921414);
        this.w1 = new a1(this, 2921437);
        this.x1 = new g1(this, 2921462);
        this.y1 = new h1(this, 2001223);
        this.z1 = new i1(this, 2921469);
        this.A1 = new j1(this, 2921475);
        this.B1 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.C1 = new l1(this, 2921515);
    }

    public final void F0(boolean z2, boolean z3) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (frsModelController = this.F) == null || this.v == null || this.r == null || !z2) {
            return;
        }
        if (!frsModelController.u0() && this.F.b0() == 1) {
            if (!this.F.r0()) {
                this.v.addCardVideoInfoToThreadList();
                this.v.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.r.V().l(b.a.r0.b0.e0.n.k) ? this.v.addHotTopicDataToThreadList() : false)) {
                this.v.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !b.a.r0.z0.a.d()) {
                this.v.addRecommendAppToThreadList(this);
            }
            if (!this.r.V().l(d2.y3)) {
                this.v.removeAlaLiveThreadData();
            }
            this.v.addSchoolRecommendToThreadList();
        }
        if (!this.r.V().l(d2.y3)) {
            this.v.removeAlaInsertLiveData();
            this.v.removeAlaStageLiveDat();
        } else {
            this.v.addInsertLiveDataToThreadList();
            this.v.addStageLiveDataToThreadList();
        }
        this.v.checkLiveStageInThreadList();
        this.v.addNoticeThreadToThreadList();
        if (this.r.V().l(b.a.r0.a1.b.f14668i)) {
            this.v.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.F.u0() || this.F.isNetFirstLoad)) {
            this.v.addUserRecommendToThreadList();
        }
        this.v.addVideoActivityToTop();
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                H0(frsModelController.Z());
            } else {
                H0(NORMAL_FRS);
            }
        }
    }

    public final void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            setListPullToRefresh(STAR_FRS.equals(str));
            b.a.r0.x0.x1.e.b bVar = this.O;
            if (bVar != null) {
                bVar.c(this.G, this.r, this.v);
            }
        }
    }

    public final boolean I0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 != 506 : invokeI.booleanValue;
    }

    public final boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsViewData frsViewData = this.v;
            return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.v.getPrivateForumTotalInfo().a() == null || this.v.getUserData().getIs_manager() != 1;
        }
        return invokeV.booleanValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!J0() && this.v.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
                setHeaderPrivateText(this.v.getPrivateForumTotalInfo().a().private_forum_audit_status, this.v.getPrivateForumTotalInfo().b(), false);
            } else {
                setHeaderPrivateText(null, null, true);
            }
        }
    }

    public final void L0(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<b.a.e.l.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.r.a0() == null || this.r.a0().getData() == null) {
            return;
        }
        Iterator<b.a.e.l.e.n> it = threadList.iterator();
        List<b.a.e.l.e.n> data = this.r.a0().getData();
        int i2 = 0;
        while (it.hasNext()) {
            b.a.e.l.e.n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), d2Var.f0())) {
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

    public final void M0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(b.a.r0.x0.a.h().i()) || this.r.a0() == null || this.r.a0().getData() == null) {
            return;
        }
        ArrayList<b.a.e.l.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<b.a.e.l.e.n> it = threadList.iterator();
        List<b.a.e.l.e.n> data = this.r.a0().getData();
        int count = ListUtils.getCount(b.a.r0.x0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            b.a.e.l.e.n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(b.a.r0.x0.a.h().i().get(i3).f0(), d2Var.f0())) {
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

    public final void N0(int i2) {
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

    public final void O0(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || j2 <= 0) {
            return;
        }
        b.a.e.e.m.e.a().postDelayed(new k0(this, j2, b.a.e.e.p.l.k(TbadkCoreApplication.getInst()), b.a.e.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r.Q1();
        }
    }

    public final void Q0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        if (!b.a.r0.x0.x2.j.a(this, getForumName(), "from", intent.getBooleanExtra("from_short_cut", false)) && getActivity() != null) {
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
        if (b.a.q0.a.g.c(uri)) {
            b.a.q0.a.g.b().d(uri, this.k1);
        } else {
            b.a.r0.x0.x2.g b2 = b.a.r0.x0.x2.m.b(intent);
            if (b2 != null) {
                this.mForum = b2.f26756a;
                String str = b2.f26757b;
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

    public final FrsTabInfoData R0() {
        InterceptResult invokeV;
        FrsViewData frsViewData;
        int D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.F == null || (frsViewData = this.v) == null || this.H == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.v.getEntelechyTabInfo().f20737a) || (D = this.H.D()) == 502) {
                return null;
            }
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.v.getEntelechyTabInfo().f20737a) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_type.intValue() != 100 && (frsTabInfo.tab_id.intValue() != 505 || this.v.getUserData() == null || this.v.getUserData().isForumBusinessAccount())) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (D == frsTabInfo.tab_id.intValue()) {
                        i2 = D;
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

    public final void S0() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || !isResumed() || (list = this.s0) == null || list.size() < 1 || this.r0 > this.s0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.s0.get(this.r0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.r0++;
            S0();
        }
        if (this.u != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(b.a.r0.x0.h1.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + "...");
                } else {
                    format = String.format(getResources().getString(b.a.r0.x0.h1.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(b.a.r0.x0.h1.live_horserace_red_envelope), getResources().getString(b.a.r0.x0.h1.frs_horse_none_title_verser));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.t0 = ofFloat;
            ofFloat.setDuration(600L);
            this.t0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.t0.addListener(new e1(this, frsRedpackRunView));
            this.u0 = new f1(this, frsRedpackRunView);
            b.a.e.e.m.e.a().postDelayed(this.u0, 5000L);
            if (this.u.getChildCount() == 0) {
                this.r0++;
                this.u.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.v;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.v.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.forumId).param("fname", str));
            }
            LinearLayout linearLayout = this.u;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.H.z().f49026b).isPrimary() || this.r.E0() || this.y) {
                return;
            }
            this.u.setVisibility(0);
        }
    }

    public final void T0(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            registerListener(2001118, this.q1);
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
                registerListener(2001120, this.q1);
            }
            this.G.D(bundle);
            O0(j2);
        }
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (getFrsViewData() == null) {
                return false;
            }
            FrsViewData frsViewData = getFrsViewData();
            b.a.q0.s.q.b0 b0Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                b0Var = new b.a.q0.s.q.b0();
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                b0Var = frsViewData.getActivityHeadData().b().get(0);
            }
            return b0Var != null;
        }
        return invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.mFlag == 1) {
                b.a.e.e.m.h.a().b(new l0(this));
            }
            this.mFlag = 0;
        }
    }

    public final void W0(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.v != null && this.H != null && this.F != null) {
                    if (!this.r.V().l(d2.y3)) {
                        this.v.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.v.getGameTabInfo());
                    this.r.m1(isEmpty);
                    if (!isEmpty) {
                        if (this.X == null) {
                            this.X = new b.a.r0.x0.y2.e(this, (NoPressedRelativeLayout) this.q);
                        }
                        if (this.Z == null) {
                            this.Z = new b.a.r0.x0.h2.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                        F0(true, z2);
                    } else {
                        F0(this.A, z2);
                    }
                    refreshHeader();
                    if (this.O != null) {
                        this.O.a(this.G, this.v);
                    }
                    if (this.v.getPage() != null) {
                        setHasMore(this.v.getPage().b());
                    }
                    ArrayList<b.a.e.l.e.n> d2 = this.R.d(z3, true, this.v.getThreadList(), null, z2, false);
                    if (d2 != null) {
                        this.v.setThreadList(d2);
                    }
                    this.v.removeRedundantUserRecommendData();
                    int topThreadSize = this.v.getTopThreadSize();
                    this.k = topThreadSize;
                    if (this.m != null) {
                        this.l = true;
                        this.m.e(topThreadSize);
                        b.a.r0.x0.x2.a.a(this, this.v.getForum(), this.v.getThreadList(), this.l, getPn());
                    }
                    if (this.F.b0() == 1) {
                        X0();
                        if (!z2 && this.F.getPn() == 1) {
                            requestLoadLiveTip();
                        }
                    }
                    if (this.P != null) {
                        this.P.k(this.H.E());
                    }
                    showLoadFinishedUI();
                    this.r.a1();
                    this.r.i1(true, false);
                    if (z2 && this.v.isFirstTabEqualAllThread()) {
                        b.a.e.e.m.e.a().post(new z(this));
                    }
                    if (this.v.getForum() != null) {
                        this.r.M(this.v.getForum().getWarningMsg());
                    }
                    if (this.v != null && this.v.getFrsVideoActivityData() != null && b.a.q0.s.e0.b.j().l("frs_video_activity_guide", 0L) == 0) {
                        b.a.e.e.m.e.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.r.C1();
                    if (this.v != null && this.v.getForum() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.v.getForum().getId(), this.v.getForum().getName(), this.v.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.v.getForum().special_forum_type), this.v.getForum().getThemeColorInfo(), this.v.getForum().getMember_num())));
                    }
                    this.c0.e(this.v.bottomMenuList, this.v.getForum());
                    o1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            stopVoice();
            try {
                if (this.v == null) {
                    return;
                }
                this.r.H1();
                this.r.P1(canShowWriteButton());
                if (b.a.r0.x0.y2.h.B(this.v)) {
                    b.a.r0.x0.y2.h.A(this.v);
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
                V0();
                a1();
                ArrayList<b.a.e.l.e.n> threadList = this.v.getThreadList();
                if (threadList != null) {
                    this.r.A1(threadList, this.v);
                    b.a.r0.x0.x2.c.b(this.r);
                    this.G.k0(getPageNum());
                    this.G.S(this.v);
                    this.H.d(this.v, this.F.R());
                    this.r.b1();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void Y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            refreshHeader();
            stopVoice();
            try {
                if (this.v == null) {
                    return;
                }
                b.a.r0.x0.y0 y0Var = null;
                this.r.A1(null, this.v);
                this.G.k0(1);
                this.r.b1();
                this.H.d(this.v, this.F.R());
                b.a.r0.x0.v2.e H = this.H.H(this.v.getFrsDefaultTabId());
                if (H != null && !TextUtils.isEmpty(H.f26454d)) {
                    y0Var = new b.a.r0.x0.y0();
                    String str = H.f26454d;
                    String str2 = H.f26451a;
                }
                this.F.q(this.v.getFrsDefaultTabId(), 0, y0Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void Z0(b.a.r0.l3.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mVar) == null) {
            try {
                if (!this.z && mVar != null && this.v != null) {
                    this.v.receiveData(mVar);
                    W0(true, false);
                    Looper.myQueue().addIdleHandler(this.F0);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void a1() {
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

    public final void b1() {
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

    public final boolean c1(b.a.r0.l3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, mVar)) == null) {
            if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().f20737a != null) {
                for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().f20737a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && b.a.q0.s.e0.b.j().g("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            b.a.r0.x0.q1.f fVar = new b.a.r0.x0.q1.f(getTbPageContext());
            this.B0 = fVar;
            boolean j2 = fVar.j(mVar);
            this.C0 = j2;
            return j2;
        }
        return invokeL.booleanValue;
    }

    public boolean canShowSpeedTipView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f48193h : invokeV.booleanValue;
    }

    public boolean canShowWriteButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? canShowWriteButton(this.P0) : invokeV.booleanValue;
    }

    @Override // b.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            b.a.r0.x0.x2.m.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
        }
    }

    public b.a.e.l.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bdUniqueId)) == null) ? b.a.r0.x0.e.e().d(getPageContext(), bdUniqueId, getUniqueId()) : (b.a.e.l.e.a) invokeL.objValue;
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
            frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new m0(this, aVar));
            aVar.setContentView(frsBroadcastCopyGuideDialogView);
            aVar.create(getPageContext()).show();
        }
    }

    @Override // b.a.r0.g.e.b
    public void dispatchInjectPluginMessage(b.a.r0.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, dVar) == null) {
            this.V.a(dVar);
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            b.a.q0.y.d.h().m(new b.a.q0.y.a(getContext()));
            b.a.q0.y.d.h().n(85, 0, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.x0.c1.tbds144));
            if (b.a.q0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            b.a.q0.y.d.h().m(new b.a.q0.y.b(getContext()));
            b.a.q0.y.d.h().n(85, 0, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.x0.c1.tbds144));
            if (b.a.q0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    public final void g1(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || !TbadkCoreApplication.isLogin() || (frsViewData = this.v) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (b.a.e.e.p.k.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", b.a.q0.d1.u0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public b.a.r0.x0.x1.e.b getEntelechyProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.O : (b.a.r0.x0.x1.e.b) invokeV.objValue;
    }

    public b.a.r0.x0.x1.a getFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f48191f : (b.a.r0.x0.x1.a) invokeV.objValue;
    }

    @Override // b.a.r0.z2.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // b.a.r0.x0.t0
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // b.a.r0.x0.o2.a, b.a.r0.x0.t0
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mForum : (String) invokeV.objValue;
    }

    public ForumWriteData getForumWriteData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
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
            forumWriteData.frsTabInfo = R0();
            return forumWriteData;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    public b.a.e.l.e.w getFrsAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.r1 : (b.a.e.l.e.w) invokeV.objValue;
    }

    public int getFrsCallFromByItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.z0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.z0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.p2.l
    public b.a.r0.x0.p2.c getFrsLoadMoreModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.R : (b.a.r0.x0.p2.c) invokeV.objValue;
    }

    public b.a.r0.x0.p2.d getFrsPostController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.Q : (b.a.r0.x0.p2.d) invokeV.objValue;
    }

    public b.a.r0.x0.s2.a getFrsSmartSortController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.J : (b.a.r0.x0.s2.a) invokeV.objValue;
    }

    @Override // b.a.r0.x0.p2.l
    public b.a.r0.x0.q getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.r : (b.a.r0.x0.q) invokeV.objValue;
    }

    @Override // b.a.r0.x0.o2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.v : (FrsViewData) invokeV.objValue;
    }

    @Override // b.a.r0.x0.p2.l
    public b.a.r0.x0.y2.h getHeaderVC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.G : (b.a.r0.x0.y2.h) invokeV.objValue;
    }

    @Override // b.a.r0.g.e.b
    public b.a.r0.g.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) ? this.M.get(i2) : (b.a.r0.g.e.a) invokeI.objValue;
    }

    public boolean getIsRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.r.Z() : invokeV.booleanValue;
    }

    public int getLastTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.P0 : invokeV.intValue;
    }

    @Override // b.a.r0.x0.p2.l
    public FrsModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.F : (FrsModelController) invokeV.objValue;
    }

    public b.a.r0.x0.u0 getNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.L : (b.a.r0.x0.u0) invokeV.objValue;
    }

    @Override // b.a.r0.x0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            b.a.r0.x0.q qVar = this.r;
            if (qVar == null) {
                return null;
            }
            return qVar.d0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, b.a.r0.x0.o2.a
    public /* bridge */ /* synthetic */ b.a.e.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // b.a.r0.z2.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            b.a.r0.x0.p2.c cVar = this.R;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            b.a.r0.x0.p2.c cVar = this.R;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    @Override // b.a.r0.z2.u
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.o z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (getTabController() != null && (z2 = getTabController().z()) != null) {
                Fragment fragment = z2.f49026b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.v;
                        tbPageTag.sortType = b.a.r0.x0.x2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.f48190e.equals(z2.f49027c)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public b.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.x == null) {
                this.x = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.x;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            b.a.r0.x0.q qVar = this.r;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.s : (OvalActionButton) invokeV.objValue;
    }

    public FRSRefreshButton getmRefreshIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.t : (FRSRefreshButton) invokeV.objValue;
    }

    public final void h1(b.a.r0.l3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, fVar) == null) {
            if (fVar == null) {
                String string = TbadkCoreApplication.getInst().getString(b.a.r0.x0.h1.error_unkown_try_again);
                this.r.S0();
                showNetRefreshView(this.r.k0(), string, true);
            } else if (340001 == fVar.f20552c) {
                l1(fVar, this.v.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.v.getThreadList())) {
                    k1(fVar);
                }
                if (isFromMainTab()) {
                    setNetRefreshViewEmotionMarginTop(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.x0.c1.ds280));
                } else {
                    setNetRefreshViewEmotionDefMarginTop();
                }
            }
        }
    }

    public int hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            b.a.r0.x0.p2.c cVar = this.R;
            if (cVar == null) {
                return -1;
            }
            return cVar.h();
        }
        return invokeV.intValue;
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        b.a.e.e.p.l.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, view) == null) {
            this.r.g1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, view) == null) {
            super.hideNetRefreshView(view);
            this.r.g1(0);
        }
    }

    public void hideRefreshIcon() {
        FRSRefreshButton fRSRefreshButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (fRSRefreshButton = this.t) == null) {
            return;
        }
        fRSRefreshButton.hide();
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
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

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            if (this.mFlag == 0) {
                this.r.B1(this.mForum);
            } else {
                this.r.B1("");
                this.mFlag = 1;
            }
            this.r.x1(this.r1);
            this.r.I(this.n1);
            this.r.y1(this.p1);
            this.r.V().m(this.o1);
        }
    }

    public boolean isAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean isFromMainTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.f48192g : invokeV.booleanValue;
    }

    public boolean isStartToLiveTab() {
        InterceptResult invokeV;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (getFrsViewData() == null) {
                return false;
            }
            FrsViewData frsViewData = getFrsViewData();
            return (ListUtils.isEmpty(frsViewData.getShowTopThreadList()) && frsViewData.getBusinessPromot() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
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

    public final void k1(b.a.r0.l3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, fVar) == null) {
            this.r.S0();
            if (fVar.f20550a) {
                showNetRefreshView(this.r.k0(), TbadkCoreApplication.getInst().getString(b.a.r0.x0.h1.net_error_text, new Object[]{fVar.f20553d, Integer.valueOf(fVar.f20552c)}), true);
            } else {
                showNetRefreshView(this.r.W().k(), fVar.f20553d, true);
            }
        }
    }

    public final void l1(b.a.r0.l3.f fVar, List<RecmForumInfo> list) {
        b.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048663, this, fVar, list) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.S0();
        this.r.B1(this.mForum);
        if (this.r.W() != null) {
            showForbidViewNoClick(this.r.k0(), fVar.f20553d, true, list);
        }
    }

    public void likeCallBack(Object obj) {
        b.a.r0.x0.p2.b bVar;
        b.a.e.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.j) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // b.a.r0.x0.p2.l
    public void loadMore() {
        b.a.r0.x0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.i(this.mForum, this.forumId, this.v);
    }

    public void logStatisticByKey(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            b.a.r0.k3.c.g().h(getUniqueId(), z2);
        }
    }

    public final void m1() {
        boolean configPrivateDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || J0()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.A(this.v.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.v.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (b.a.e.e.p.k.isEmpty(privateForumPopInfoData.y()) || privateForumPopInfoData.x() != Integer.valueOf(this.forumId))) {
            privateForumPopInfoData.D(FrsPrivateCommonDialogView.DIALOG_TYPE_CREATE_SUCCESS);
            privateForumPopInfoData.B(TbadkCoreApplication.getInst().getString(b.a.r0.x0.h1.frs_private_create_hint));
            privateForumPopInfoData.E("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.mForum + "&nomenu=1");
            privateForumPopInfoData.C(Integer.valueOf(this.forumId));
            configPrivateDialog = frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData);
        } else {
            configPrivateDialog = privateForumPopInfoData.x() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData) : false;
        }
        if (configPrivateDialog) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new w(this, privateForumPopInfoData, aVar));
            aVar.setCloseButton(new x(this));
            aVar.create(getPageContext()).show();
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
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

    public boolean needAdjustHeaderBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? U0() && !isTopThreadListShow() : invokeV.booleanValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || b.a.e.e.p.k.isEmpty(this.forumId)) {
            return;
        }
        b.a.q0.a.d.y().O(b.a.q0.a.c.X, b.a.e.e.m.b.g(this.forumId, 0L));
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
                Q0(intent);
            }
            this.sysCreateTime = currentTimeMillis - this.initTime;
            this.m = new b.a.r0.l3.j0.f("frs", b.a.r0.l3.j0.f.f20603c);
            if (this.F == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.mForumModelCallback);
                this.F = frsModelController;
                frsModelController.t(this.N0);
                this.F.init();
            }
            this.F.P0(this.w);
            ArrayList<b.a.e.l.e.n> arrayList = null;
            if (intent != null) {
                this.F.k0(intent.getExtras());
            } else if (bundle != null) {
                this.F.k0(bundle);
            } else {
                this.F.k0(null);
            }
            if (intent != null) {
                this.G.D(intent.getExtras());
            } else if (bundle != null) {
                this.G.D(bundle);
            } else {
                this.G.D(null);
            }
            this.p = getVoiceManager();
            this.V = new b.a.r0.x0.p(getPageContext(), this);
            initUI();
            T0(bundle);
            if (!isFromMainTab()) {
                b.a.r0.x0.u0 u0Var = new b.a.r0.x0.u0(getActivity(), this.r, this.G);
                this.L = u0Var;
                u0Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.p = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.j0) {
                int k2 = b.a.q0.s.e0.b.j().k("key_forum_broadcast_edit_tip_number", 0);
                if (k2 < 2) {
                    b.a.q0.s.e0.b.j().v("key_forum_broadcast_edit_tip_number", k2 + 1);
                    d1();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        e1();
                    } else {
                        new BdTopToast(getContext()).setIcon(false).setContent(getContext().getString(b.a.r0.x0.h1.forum_broadcast_copy_no_permission_hint)).show(this.r.k0());
                    }
                } else {
                    e1();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.j0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        f1();
                    } else if (Build.VERSION.SDK_INT < 23 || !b.a.q0.s.e0.b.j().g("key_forum_rule_dialog_show_frs", false)) {
                        f1();
                        b.a.q0.s.e0.b.j().t("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    f1();
                }
            }
            if (b.a.q0.y.d.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.s;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new b.a.r0.x0.p2.i();
            int i2 = -1;
            b.a.r0.x0.p2.c cVar = this.R;
            if (cVar != null && cVar.f() != null) {
                i2 = this.R.f().A();
                arrayList = this.R.f().z();
            }
            b.a.r0.x0.p2.c cVar2 = new b.a.r0.x0.p2.c(this, this.l1);
            this.R = cVar2;
            cVar2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.R.f().J(arrayList);
            }
            this.J = new b.a.r0.x0.s2.a(this);
            this.S = new b.a.r0.x0.y2.j(this);
            this.P = new b.a.r0.x0.y2.a(getPageContext(), this.F.p0());
            this.K = new b.a.r0.x0.p2.b(this);
            this.Q = new b.a.r0.x0.p2.d(this);
            this.I = new b.a.r0.x0.p2.h(this);
            this.T = new b.a.r0.x0.p2.a(this);
            this.mEnterFrsDialogController = new b.a.r0.x0.y2.c(this);
            new b.a.r0.x0.p2.e(this, getUniqueId());
            this.a0 = new b.a.r0.j.a(getPageContext(), "frs");
            this.b0 = new b.a.r0.w.c(getPageContext());
            new b.a.r0.x0.t2.c.a(getPageContext());
            registerListener(this.W0);
            registerListener(this.j1);
            registerListener(this.U0);
            registerListener(this.m1);
            registerListener(this.i1);
            registerListener(this.Q0);
            registerListener(this.R0);
            registerListener(this.S0);
            registerListener(this.T0);
            registerListener(this.G0);
            registerListener(this.H0);
            registerListener(this.I0);
            registerListener(this.J0);
            registerListener(this.t1);
            registerListener(this.Y0);
            this.Z0.setSelfListener(true);
            this.Z0.setTag(getPageContext().getUniqueId());
            registerListener(this.Z0);
            registerListener(this.M0);
            registerListener(this.a1);
            registerListener(this.X0);
            registerListener(this.d1);
            registerListener(this.e1);
            registerListener(this.f1);
            this.u1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.L0);
            registerListener(this.y1);
            registerListener(this.b1);
            registerListener(this.K0);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.g1);
            registerListener(this.h1);
            this.r.t0(false);
            if (!isFromMainTab() && !this.j0) {
                showLoadingView(this.r.k0(), true);
                this.F.P(3, false);
            }
            d0 d0Var = new d0(this);
            b.a.r0.x0.b.f().s(d0Var);
            b.a.r0.x0.a.h().s(d0Var);
            this.r.v1(new e0(this));
            this.p0 = UtilHelper.getScreenHeight(getActivity());
            this.j0 = true;
            N0(1);
            super.onActivityCreated(bundle);
            this.createTime = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048672, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            b.a.r0.x0.p2.a aVar = this.T;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.m0) {
                this.r.K0(i2);
                this.G.K(i2);
                this.H.T(i2);
                FRSRefreshButton fRSRefreshButton = this.t;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                b.a.r0.x0.b3.a aVar = this.W;
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
                b.a.r0.x0.t1.a.a aVar2 = this.c0;
                if (aVar2 != null) {
                    aVar2.d(getPageContext(), i2);
                }
                if (this.i0 != null) {
                    b.a.q0.w0.a.a(getPageContext(), this.i0.getRealView());
                }
                b.a.r0.x0.y2.e eVar = this.X;
                if (eVar != null) {
                    eVar.onChangeSkinType(getPageContext(), i2);
                }
                b.a.r0.x0.q1.f fVar = this.B0;
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
            b.a.r0.k3.c.g().i(getUniqueId());
            if (this.x0 == null) {
                this.x0 = new TiePlusEventController(requireContext(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.x0);
            registerResponsedEventListener(TopToastEvent.class, this.c1);
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
                this.q = layoutInflater.inflate(b.a.r0.x0.f1.frs_activity, viewGroup, false);
                b.a.r0.x0.x1.a aVar = new b.a.r0.x0.x1.a();
                this.f48191f = aVar;
                this.O = aVar.c();
                this.f48190e = TbadkCoreApplication.getInst().getString(b.a.r0.x0.h1.frs_title_new_area);
                this.G = new b.a.r0.x0.y2.h(this, this.f48191f, (FrsHeaderViewContainer) this.q.findViewById(b.a.r0.x0.e1.header_view_container));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.q);
                this.H = frsTabViewController;
                frsTabViewController.Y();
                this.G.m0(this.H);
                this.H.c0(this.O0);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.f48192g = true;
                }
                this.r = new b.a.r0.x0.q(this, this.mCommenOnClickListener, this.f48191f, this.f48192g, this.G);
                this.c0 = new b.a.r0.x0.t1.a.a(getPageContext(), this.q);
            } else {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.q.getParent()).removeView(this.q);
                }
                FrsTabViewController frsTabViewController2 = this.H;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.Y();
                }
                this.r.U0();
                this.q.setLeft(0);
                this.q.setRight(b.a.e.e.p.l.k(TbadkCoreApplication.getInst().getContext()));
            }
            this.m0 = true;
            this.layoutTime = System.currentTimeMillis() - currentTimeMillis;
            return this.q;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            b.a.r0.k3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.t1);
            MessageManager.getInstance().unRegisterListener(this.Z0);
            unRegisterResponsedEventListener();
            this.S.Z();
            cacheData = null;
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            b.a.r0.z2.l0.a.c("FRS");
            this.p = null;
            b.a.r0.b0.u.b().e(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null) {
                b.a.r0.x0.g0.a().b(b.a.e.e.m.b.g(this.v.getForum().getId(), 0L));
            }
            b.a.r0.x0.n2.a aVar = this.U;
            if (aVar != null) {
                aVar.v();
            }
            b.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                b.a.r0.x0.x2.l.b(qVar, this.v, getForumId(), false, null);
                this.r.L0();
            }
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                this.u.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.t0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.u0 != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.u0);
            }
            this.s0 = null;
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
            this.G.I();
            Looper.myQueue().removeIdleHandler(this.F0);
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.g();
            }
            b.a.r0.x0.u0 u0Var = this.L;
            if (u0Var != null) {
                u0Var.d();
            }
            b.a.r0.x0.y2.a aVar2 = this.P;
            if (aVar2 != null) {
                aVar2.i();
            }
            b.a.r0.x0.s2.a aVar3 = this.J;
            if (aVar3 != null) {
                aVar3.c();
            }
            b.a.r0.x0.y2.e eVar = this.X;
            if (eVar != null) {
                eVar.g();
            }
            b.a.r0.x0.p2.a aVar4 = this.T;
            if (aVar4 != null) {
                aVar4.n();
            }
            b.a.r0.j.a aVar5 = this.a0;
            if (aVar5 != null) {
                aVar5.h();
            }
            b.a.r0.w.c cVar = this.b0;
            if (cVar != null) {
                cVar.g();
            }
            b.a.r0.z2.j0.a.e().g();
            b.a.r0.x0.x2.n.a();
            FrsTabViewController frsTabViewController = this.H;
            if (frsTabViewController != null) {
                frsTabViewController.c0(null);
                this.H.L();
            }
            AddExperiencedModel addExperiencedModel = this.k0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            b.a.r0.x0.b.f().s(null);
            b.a.r0.x0.a.h().s(null);
            b.a.r0.x0.x2.e eVar2 = this.A0;
            if (eVar2 != null) {
                eVar2.d();
            }
            if (this.x0 != null) {
                getLifecycle().removeObserver(this.x0);
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            i1();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public b.a.e.l.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? getListView().getPreLoadHandle() : (b.a.e.l.e.q) invokeV.objValue;
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
            } else if (b.a.r0.x0.b.f().i()) {
                b.a.r0.x0.b.f().m();
                return true;
            } else if (b.a.r0.x0.a.h().j()) {
                b.a.r0.x0.q qVar = this.r;
                if (qVar != null && qVar.C0()) {
                    this.r.Y0();
                    return true;
                }
                b.a.r0.x0.a.h().n();
                return true;
            } else {
                b.a.r0.x0.q qVar2 = this.r;
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
            this.F.G0(3, true);
            getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && b.a.e.e.p.l.D()) {
            hideNetRefreshView(this.r.W().k());
            showLoadingView(this.r.k0(), true);
            this.r.t0(false);
            this.F.G0(3, true);
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
        this.f48194i = booleanExtra;
        if (booleanExtra) {
            P0();
        }
    }

    @Override // b.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && isAdded() && this.N && isLoadingViewAttached()) {
            hideLoadingView(this.r.k0());
        }
    }

    @Override // b.a.r0.x0.n0
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
            b.a.r0.x0.y2.a aVar = this.P;
            if (aVar != null) {
                aVar.j();
            }
            b.a.q0.a.d.y().E();
            b.a.r0.x0.x2.e eVar = this.A0;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                b.a.r0.x0.y2.h hVar = this.G;
                if (hVar != null) {
                    hVar.M(isPrimary());
                }
                b.a.r0.x0.q qVar = this.r;
                if (qVar != null) {
                    qVar.O0(isPrimary());
                    this.r.H0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048687, this, i2, strArr, iArr) == null) {
            b.a.r0.x0.x2.m.h(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onResume();
            b.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                qVar.G0();
                this.r.P0();
            }
            this.I.f(true);
            this.A = true;
            if (isNeedRefreshOnBackFromBarDetail) {
                isNeedRefreshOnBackFromBarDetail = false;
                b.a.r0.x0.q qVar2 = this.r;
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
            b.a.r0.x0.q qVar3 = this.r;
            if (qVar3 != null) {
                qVar3.H0(false);
            }
            if (this.Y) {
                refresh(6);
                this.Y = false;
            }
            if (this.o0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    b.a.q0.t.d.f.c().h(true);
                    b.a.q0.t.d.f.c().i(this.o0.getHours(), this.o0.getMinutes());
                    if (this.r != null) {
                        b.a.q0.t.d.f.c().k(getTbPageContext().getPageActivity(), this.r.k0());
                    }
                }
                this.o0 = null;
            }
            o1();
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
            if (!b.a.e.e.p.l.D()) {
                this.r.s0();
            } else if (this.F.b0() == 1) {
                i1();
                loadMore();
            } else if (this.F.i0()) {
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
        b.a.r0.l3.f S = this.F.S();
        boolean isEmpty = ListUtils.isEmpty(this.v.getThreadList());
        if (S != null && isEmpty) {
            if (this.F.V() != 0) {
                this.F.O0();
                this.r.G0();
            } else {
                h1(S);
            }
            this.r.i1(this.v.isStarForum(), false);
            return;
        }
        h1(S);
    }

    public void onShareSuccess(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, str) == null) && TbadkCoreApplication.isLogin() && !b.a.e.e.p.k.isEmpty(str)) {
            if (this.k0 == null) {
                this.k0 = new AddExperiencedModel(getTbPageContext());
            }
            this.k0.A(this.forumId, str);
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
            b.a.r0.b0.u.b().e(false);
            logStatisticByKey(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                b.a.q0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.v.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (getListView() != null) {
                getListView().getRecycledViewPool().clear();
            }
            this.G.J();
            b.a.q0.d1.f0.c();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onSuccess(ArrayList<b.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            setHasMore(!isEmpty ? 1 : 0);
            i1();
            if (isEmpty) {
                return;
            }
            if (!this.F.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.F.b0() == 1 && !b.a.r0.z0.a.d()) {
                this.v.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.F != null) {
                b.a.r0.x0.u2.a.h(getUniqueId(), arrayList, this.v.getForum(), this.F.a0());
            }
            ArrayList<b.a.e.l.e.n> c2 = this.R.c(false, false, arrayList, this.m, false);
            if (c2 != null) {
                this.v.setThreadList(c2);
                this.r.A1(c2, this.v);
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                b.a.r0.x0.u2.c.l(this.v, frsModelController.R(), 2, getContext());
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
            b.a.r0.p.d.c().f("page_frs");
            refresh(3);
        }
    }

    public boolean refreshHeader() {
        InterceptResult invokeV;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            b.a.r0.x0.y2.h hVar = this.G;
            if (hVar != null && (frsModelController = this.F) != null) {
                hVar.p0(frsModelController.Z(), this.v);
            }
            FrsViewData frsViewData = this.v;
            boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
            G0();
            b.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                qVar.w0();
                this.r.x0();
                FrsViewData frsViewData2 = this.v;
                if (frsViewData2 != null && frsViewData2.getActivityHeadData() != null) {
                    this.r.v0(this.v.getActivityHeadData().a());
                    if (this.v.getActivityHeadData().a() != null && !this.C0 && !this.D0) {
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
            this.G.W(this.v);
        }
    }

    @Override // b.a.r0.x0.n0
    public void refreshPage() {
        b.a.r0.x0.q qVar;
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
                this.U = new b.a.r0.x0.n2.a(this, b.a.e.e.m.b.e(this.forumId, 0));
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
        FrsTabViewController.o z2;
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (frsTabViewController = this.H) == null || (z2 = frsTabViewController.z()) == null || (fragment = z2.f49026b) == null || !(fragment instanceof b.a.r0.x0.p0)) {
            return;
        }
        ((b.a.r0.x0.p0) fragment).scrollToTop();
    }

    public void setCanShowSpeedTipView(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            this.f48193h = z2;
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
        b.a.r0.x0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048710, this, i2) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.m(i2);
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

    @Override // b.a.r0.g.e.b
    public void setInjectPlugin(int i2, b.a.r0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048712, this, i2, aVar) == null) {
            this.M.put(i2, aVar);
        }
    }

    public void setIsLiveTab(boolean z2) {
        b.a.r0.x0.q qVar;
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
        b.a.r0.x0.y2.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || (jVar = this.S) == null) {
            return;
        }
        jVar.b0();
    }

    public void setLiteProgramListFragmentSelect(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public void setLiveCardStatData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048717, this) == null) || this.v == null) {
            return;
        }
        b.a.r0.x0.u2.b bVar = new b.a.r0.x0.u2.b();
        if (this.v.needLog == 1) {
            bVar.f26385a = true;
        } else {
            bVar.f26385a = false;
        }
        if (this.v.getForum() != null) {
            bVar.f26387c = this.v.getForum().getId();
        }
        if (getModelController() != null) {
            bVar.f26386b = getModelController().R();
        }
        b.a.r0.x0.u2.b bVar2 = b.a.r0.x0.u2.d.h0;
        if (bVar2 != null) {
            bVar.f26388d = bVar2.f26388d;
            bVar.f26389e = bVar2.f26389e;
        }
        b.a.r0.x0.n2.b bVar3 = new b.a.r0.x0.n2.b(bVar, getTbPageTag(), getUniqueId());
        this.v0 = bVar3;
        bVar3.d(this.y0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.v0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.v0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.v0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.v0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    public void setNavigationBarMoveEnable(boolean z2) {
        b.a.r0.x0.u0 u0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || (u0Var = this.L) == null) {
            return;
        }
        u0Var.i(z2);
    }

    public void setPn(int i2) {
        b.a.r0.x0.p2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048719, this, i2) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.n(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) {
            super.setPrimary(z2);
            FrsTabViewController frsTabViewController = this.H;
            if (frsTabViewController == null || frsTabViewController.z() == null || !(this.H.z().f49026b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.H.z().f49026b).setPrimary(z2);
        }
    }

    public void setShowAdFlag(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) && this.D1 == null) {
            b.a.r0.z0.a a2 = b.a.r0.z0.a.a(z2);
            this.D1 = a2;
            b.a.r0.x0.p2.c cVar = this.R;
            if (cVar != null) {
                cVar.l(a2);
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
            this.D0 = z2;
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
                this.W = new b.a.r0.x0.b3.a(getPageContext(), getNetRefreshListener());
            }
            this.W.c(str);
            this.W.b(list);
            this.W.attachView(view, z2);
        }
    }

    public void showFrsAdvancedAdGuide() {
        b.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.D1();
    }

    public void showFrsDeleteThreadTip(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048729, this, str, str2, str3) == null) {
            b.a.r0.x0.x2.e eVar = new b.a.r0.x0.x2.e(str, str2);
            this.A0 = eVar;
            eVar.f(getFragmentActivity(), str3, str2);
        }
    }

    public void showLoadFinishedUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            hideLoadingView(this.r.k0());
            this.r.S1();
            if (this.r.j0() instanceof b.a.r0.x0.v2.d) {
                ((b.a.r0.x0.v2.d) this.r.j0()).d();
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
            super.showNetRefreshView(view, getResources().getString(b.a.r0.x0.h1.refresh_view_title_text), null, getResources().getString(b.a.r0.x0.h1.refresh_view_button_text), z2, getNetRefreshListener());
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

    public void unlikeCallBack(Object obj) {
        b.a.r0.x0.p2.b bVar;
        b.a.e.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.f26068i) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // b.a.r0.z2.u
    public void updateLastIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            getModelController().R0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            FrsViewData frsViewData = this.v;
            if (frsViewData != null) {
                return b.a.q0.d1.s0.a(2) || (b.a.q0.d1.s0.e() && frsViewData.isFrsVideoAutoPlay);
            }
            return super.videoNeedPreload();
        }
        return invokeV.booleanValue;
    }

    public void writeBlog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048741, this, i2) == null) {
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
                    b.a.r0.x0.x2.n.b(this, 0);
                } else {
                    this.r.M1();
                }
            }
        }
    }

    public boolean canShowWriteButton(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            if (this.B && !this.n0 && I0(i2)) {
                FrsModelController frsModelController = this.F;
                return (frsModelController != null && frsModelController.U() && (b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j())) ? false : true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public BdRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            b.a.r0.x0.q qVar = this.r;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.H : (FrsTabViewController) invokeV.objValue;
    }

    public void refresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i2) == null) {
            this.z = false;
            stopVoice();
            b.a.r0.x0.q qVar = this.r;
            if (qVar != null && qVar.h0() != null) {
                this.r.h0().w();
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.G0(i2, true);
            }
        }
    }
}
