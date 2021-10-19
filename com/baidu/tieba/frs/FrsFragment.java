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
import c.a.l.v0.a;
import c.a.q0.a.g;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.r0.j.f;
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
/* loaded from: classes7.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, c.a.r0.x0.e2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, c.a.r0.x0.t0, c.a.r0.z2.u, c.a.r0.x0.f2.l, c.a.r0.g.e.b, c.a.r0.x0.n0, c.a.r0.x0.q0 {
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
    public static c.a.r0.k3.m cacheData;
    public static boolean isNeedRefreshOnBackFromBarDetail;
    public static volatile int mNetError;
    public static volatile long mPbLoadDataSize;
    public static volatile long mPbLoadTime;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.r0.x0.n2.e A0;
    public HttpMessageListener A1;
    public boolean B;
    public c.a.r0.x0.g1.f B0;
    public CustomMessageListener B1;
    public String C;
    public boolean C0;
    public c.a.r0.z0.a C1;
    public a.C0095a D;
    public boolean D0;
    public ThreadCardViewHolder E;
    public MessageQueue.IdleHandler E0;
    public FrsModelController F;
    public final CustomMessageListener F0;
    public c.a.r0.x0.o2.h G;
    public CustomMessageListener G0;
    public FrsTabViewController H;
    public CustomMessageListener H0;
    public c.a.r0.x0.f2.h I;
    public CustomMessageListener I0;
    public c.a.r0.x0.i2.a J;
    public CustomMessageListener J0;
    public c.a.r0.x0.f2.b K;
    public c.a.e.c.g.a K0;
    public c.a.r0.x0.u0 L;
    public CustomMessageListener L0;
    public SparseArray<c.a.r0.g.e.a> M;
    public final c.a.r0.x0.s0 M0;
    public boolean N;
    public FrsTabViewController.n N0;
    public c.a.r0.x0.n1.e.b O;
    public int O0;
    public c.a.r0.x0.o2.a P;
    public CustomMessageListener P0;
    public c.a.r0.x0.f2.d Q;
    public CustomMessageListener Q0;
    public c.a.r0.x0.f2.c R;
    public final CustomMessageListener R0;
    public c.a.r0.x0.o2.j S;
    public final CustomMessageListener S0;
    public c.a.r0.x0.f2.a T;
    public final CustomMessageListener T0;
    public c.a.r0.x0.d2.a U;
    public final AntiHelper.k U0;
    public c.a.r0.x0.p V;
    public CustomMessageListener V0;
    public c.a.r0.x0.r2.a W;
    public CustomMessageListener W0;
    public c.a.r0.x0.o2.e X;
    public CustomMessageListener X0;
    public boolean Y;
    public CustomMessageListener Y0;
    public c.a.r0.x0.x1.b Z;
    public CustomMessageListener Z0;
    public c.a.r0.j.a a0;
    public HttpMessageListener a1;
    public c.a.r0.w.c b0;
    public c.a.q0.j0.i b1;
    public c.a.r0.x0.j1.a.a c0;
    public final CustomMessageListener c1;
    public long createTime;
    public boolean createWithGame;
    public CustomMessageListener d1;
    public long dataParseTime;
    public long drawStartTime;
    public long drawTime;

    /* renamed from: e  reason: collision with root package name */
    public String f50824e;
    public final CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.x0.n1.a f50825f;
    public CustomMessageListener f1;
    public String forumId;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50826g;
    public CustomMessageListener g1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50827h;
    public final CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50828i;
    public c.a.q0.s.s.a i0;
    public final CustomMessageListener i1;
    public long initTime;
    public boolean isPageStayDurationClose;

    /* renamed from: j  reason: collision with root package name */
    public String f50829j;
    public boolean j0;
    public final g.b j1;
    public int k;
    public AddExperiencedModel k0;
    public final c.a.r0.x0.f2.k k1;
    public boolean l;
    public boolean l0;
    public final CustomMessageListener l1;
    public long layoutTime;
    public c.a.r0.k3.i0.f m;
    public boolean m0;
    public final RecyclerView.OnScrollListener m1;
    public final View.OnClickListener mCommenOnClickListener;
    public c.a.r0.x0.o2.c mEnterFrsDialogController;
    public int mFlag;
    public String mForum;
    public final c.a.r0.k3.t mForumModelCallback;
    public String mFrom;
    public int mHeadLineDefaultNavTabId;
    public final View.OnTouchListener mOnTouchListener;
    public boolean mSpeedUpTipShowing;
    public final d2 mThreadData;
    public boolean n;
    public boolean n0;
    public final c.a.r0.x0.f n1;
    public boolean o;
    public Date o0;
    public final NoNetworkView.b o1;
    public VoiceManager p;
    public int p0;
    public final CustomMessageListener p1;
    public c.a.q0.q0.b perfFluencyLogData;
    public long pullBeginTime;
    public View q;
    public int q0;
    public c.a.e.l.e.w q1;
    public c.a.r0.x0.q r;
    public int r0;
    public c.a.r0.x0.s0 r1;
    public OvalActionButton s;
    public List<LiveHorseRaceData> s0;
    public CustomMessageListener s1;
    public long sysCreateTime;
    public FRSRefreshButton t;
    public ValueAnimator t0;
    public CustomMessageListener t1;
    public LinearLayout u;
    public Runnable u0;
    public CustomMessageListener u1;
    public FrsViewData v;
    public c.a.r0.x0.d2.b v0;
    public CustomMessageListener v1;
    public String w;
    public c.a.r0.x0.k1.a w0;
    public CustomMessageListener w1;
    public c.a.e.e.k.b<TbImageView> x;
    @Nullable
    public TiePlusEventController x0;
    public CustomMessageListener x1;
    public boolean y;
    public int y0;
    public CustomMessageListener y1;
    public boolean z;
    public int z0;
    public CustomMessageListener z1;

    /* loaded from: classes7.dex */
    public class a implements FrsTabViewController.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50830a;

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
            this.f50830a = frsFragment;
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                boolean z = false;
                if (i2 != 1) {
                    c.a.r0.b0.u.b().e(false);
                    this.f50830a.logStatisticByKey(false);
                }
                if (i2 == 502) {
                    this.f50830a.s.setIconFade(R.drawable.btn_frs_professional_edit_n);
                } else {
                    this.f50830a.s.setIconFade(0);
                }
                this.f50830a.O0 = i2;
                this.f50830a.y0 = i3;
                if (this.f50830a.v0 != null) {
                    this.f50830a.v0.d(this.f50830a.y0);
                }
                TbSingleton.getInstance().setFrsCurTabType(this.f50830a.y0);
                this.f50830a.stopVoice();
                c.a.r0.x0.k2.b bVar = c.a.r0.x0.k2.d.h0;
                bVar.f27137d = i2;
                bVar.f27140g = i3;
                bVar.f27138e = -1;
                if (!this.f50830a.l0) {
                    this.f50830a.r.Q1(this.f50830a.G0(i2));
                    return;
                }
                c.a.r0.x0.b.f().p(i2 == 1 && this.f50830a.l0, true);
                c.a.r0.x0.a h2 = c.a.r0.x0.a.h();
                if (i2 == 1 && this.f50830a.l0) {
                    z = true;
                }
                h2.p(z, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50831e;

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
            this.f50831e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50831e.r.P1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50832a;

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
            this.f50832a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.f50832a.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f50832a.t != null) {
                    if (booleanValue) {
                        if (this.f50832a.H.I() == 0 || this.f50832a.r.F0() || c.a.q0.y.d.h().k()) {
                            return;
                        }
                        this.f50832a.t.show();
                        return;
                    }
                    this.f50832a.t.hide();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50833a;

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
            this.f50833a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.f50833a.H.h0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50834a;

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
            this.f50834a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f50834a.v.updateCurrentUserPendant((UserPendantData) customResponsedMessage.getData());
            this.f50834a.r.W().notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f50835e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50836f;

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
            this.f50836f = frsFragment;
            this.f50835e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (this.f50836f.v != null && this.f50836f.v.getForum() != null) {
                    str = this.f50836f.v.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", this.f50836f.forumId).param("fname", str));
                AlaInfoData alaInfoData = new AlaInfoData();
                if (this.f50835e.getLive_id() != null) {
                    alaInfoData.live_id = this.f50835e.getLive_id().longValue();
                    alaInfoData.screen_direction = this.f50835e.getScreen_direction().intValue();
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f50836f.getContext(), alaLiveInfoCoreData, "live_paomadeng", this.f50836f.forumId)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50837a;

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
            this.f50837a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || this.f50837a.v == null) {
                return;
            }
            c.a.r0.x0.n2.n.d(this.f50837a.v, this.f50837a.getPageContext());
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50838a;

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
            this.f50838a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || this.f50838a.v == null || (userData = this.f50838a.v.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                this.f50838a.G.P(num);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50839a;

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
            this.f50839a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f50839a.t == null || this.f50839a.s == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                this.f50839a.t.setVisibility(8);
                this.f50839a.s.setVisibility(8);
                return;
            }
            this.f50839a.s.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50840a;

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
            this.f50840a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f50840a.H.b(49);
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements c.a.r0.x0.w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50841a;

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
            this.f50841a = frsFragment;
        }

        @Override // c.a.r0.x0.w0
        public void a(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f50841a.r == null) {
                return;
            }
            boolean z3 = false;
            if (i2 == 1) {
                this.f50841a.r.u1(c.a.r0.x0.b.f().h());
                this.f50841a.r.v1(z ? 0 : 8);
            } else if (i2 == 2) {
                this.f50841a.r.r1(z ? 0 : 8);
            }
            if (!z2) {
                this.f50841a.l0 = z;
            }
            if (this.f50841a.r.W() != null && (i2 == 2 || (this.f50841a.F != null && this.f50841a.F.U()))) {
                this.f50841a.r.W().notifyDataSetChanged();
            }
            if (this.f50841a.getTabController() != null) {
                FrsTabViewController.o z4 = this.f50841a.getTabController().z();
                if (z4 != null) {
                    if ((z4.f51682b instanceof FrsCommonTabFragment) && (i2 == 2 || z4.f51681a == 502)) {
                        ((FrsCommonTabFragment) z4.f51682b).refreshRecyclerView();
                    } else if ((z4.f51682b instanceof FrsNewAreaFragment) && (i2 == 2 || z4.f51681a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) z4.f51682b;
                        frsNewAreaFragment.refreshRecyclerView();
                        if (frsNewAreaFragment.getFrsView() != null) {
                            c.a.r0.x0.f2.g frsView = frsNewAreaFragment.getFrsView();
                            frsView.G(!z);
                            if (i2 == 1) {
                                frsView.D(!z);
                            } else if (i2 == 2) {
                                frsView.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = z4.f51682b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).refreshRecyclerView();
                        }
                    }
                }
                if (this.f50841a.getTabController().J() != null) {
                    this.f50841a.getTabController().J().setmDisallowSlip(z);
                    this.f50841a.getTabController().e0(z);
                }
            }
            if (this.f50841a.r.Y() != null) {
                c.a.r0.x0.q qVar = this.f50841a.r;
                if (this.f50841a.canShowWriteButton() && !z) {
                    z3 = true;
                }
                qVar.Q1(z3);
            }
            if (this.f50841a.getActivity() instanceof FrsActivity) {
                ((FrsActivity) this.f50841a.getActivity()).showTabHost(!z);
            }
            if (this.f50841a.c0 != null) {
                this.f50841a.c0.f(!z);
            }
            this.f50841a.r.A1(!z);
            if (i2 == 1) {
                this.f50841a.r.q1(!z);
            } else if (i2 == 2) {
                this.f50841a.r.q1(true);
            }
        }

        @Override // c.a.r0.x0.w0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f50841a.getContext() == null) {
                return;
            }
            if (i2 != 1) {
                if (i2 != 2 || this.f50841a.r == null) {
                    return;
                }
                new BdTopToast(this.f50841a.getContext()).setIcon(false).setContent(this.f50841a.getContext().getString(R.string.frs_move_area_max_num)).show(this.f50841a.r.l0());
                return;
            }
            c.a.e.e.p.l.L(this.f50841a.getContext(), R.string.frs_multi_delete_max_num);
        }

        @Override // c.a.r0.x0.w0
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f50841a.r == null) {
                return;
            }
            if (i3 == 1) {
                this.f50841a.r.t1(i2);
            } else if (i3 == 2) {
                this.f50841a.r.s1(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f50842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50843f;

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
            this.f50843f = frsFragment;
            this.f50842e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator.isRunning()) {
                this.f50842e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f50842e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50844a;

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
            this.f50844a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.f50844a.H.b(1);
                this.f50844a.N0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50845a;

        /* loaded from: classes7.dex */
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* loaded from: classes7.dex */
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
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
            this.f50845a = frsFragment;
        }

        @Override // c.a.r0.j.f.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, deleteThreadHttpResponseMessage) == null) || deleteThreadHttpResponseMessage == null) {
                return;
            }
            this.f50845a.r.R();
            this.f50845a.r.Q();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (this.f50845a.H == null || this.f50845a.H.z() == null || !(this.f50845a.H.z().f51682b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) this.f50845a.H.z().f51682b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : this.f50845a.getString(R.string.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (this.f50845a.i0 == null) {
                        FrsFragment frsFragment = this.f50845a;
                        frsFragment.i0 = new c.a.q0.s.s.a(frsFragment.getActivity());
                    }
                    this.f50845a.i0.setMessage(text);
                    this.f50845a.i0.setPositiveButton(R.string.dialog_known, new a(this));
                    this.f50845a.i0.setCanceledOnTouchOutside(false);
                    this.f50845a.i0.create(this.f50845a.getPageContext());
                    this.f50845a.i0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (this.f50845a.i0 == null) {
                        FrsFragment frsFragment2 = this.f50845a;
                        frsFragment2.i0 = new c.a.q0.s.s.a(frsFragment2.getActivity());
                    }
                    this.f50845a.i0.setMessage(text);
                    this.f50845a.i0.setPositiveButton(R.string.know, new b(this));
                    this.f50845a.i0.setCanceledOnTouchOutside(false);
                    this.f50845a.i0.create(this.f50845a.getPageContext());
                    this.f50845a.i0.show();
                } else {
                    this.f50845a.r.L1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(this.f50845a.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.processBatchDelete(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                this.f50845a.J0(deleteThreadHttpResponseMessage.getSuccessItems());
                c.a.r0.x0.b.f().k(deleteThreadHttpResponseMessage.getSuccessItems());
                for (c.a.e.l.e.n nVar : this.f50845a.v.getThreadList()) {
                    if (nVar instanceof c2) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    this.f50845a.loadMore();
                    return;
                }
                return;
            }
            c.a.e.e.p.l.M(this.f50845a.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f50846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50847f;

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
            this.f50847f = frsFragment;
            this.f50846e = frsRedpackRunView;
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
                this.f50846e.setAlpha(0.0f);
                this.f50846e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                this.f50846e.hide();
                this.f50847f.u.removeView(this.f50846e);
                if (this.f50847f.s0 == null || this.f50847f.r0 <= this.f50847f.s0.size() - 1) {
                    this.f50847f.Q0();
                    return;
                }
                this.f50847f.u.removeAllViews();
                this.f50847f.u.setVisibility(8);
                this.f50847f.r0 = 0;
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

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50848a;

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
            this.f50848a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.r0.k3.x) || this.f50848a.v == null) {
                return;
            }
            this.f50848a.v.updateLikeData((c.a.r0.k3.x) customResponsedMessage.getData());
            this.f50848a.G.S(this.f50848a.v);
            this.f50848a.H.d(this.f50848a.v, this.f50848a.F.R());
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50849a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f50850e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f0 f50851f;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$f0$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1761a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f50852e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f50853f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f50854g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f50855h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ int f50856i;

                /* renamed from: j  reason: collision with root package name */
                public final /* synthetic */ a f50857j;

                public RunnableC1761a(a aVar, long j2, int i2, int i3, float f2, int i4) {
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
                    this.f50857j = aVar;
                    this.f50852e = j2;
                    this.f50853f = i2;
                    this.f50854g = i3;
                    this.f50855h = f2;
                    this.f50856i = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(this.f50852e, 0L, 0L, this.f50853f, this.f50854g, this.f50855h, this.f50856i);
                        requestGetMyPostNetMessage.setTag(this.f50857j.f50851f.f50849a.getUniqueId());
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
                this.f50851f = f0Var;
                this.f50850e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50851f.f50849a.H.b(301);
                    c.a.e.e.m.e.a().postDelayed(new RunnableC1761a(this, c.a.e.e.m.b.g((String) this.f50850e.get(c.a.q0.a.g.p), 0L), c.a.e.e.p.l.k(TbadkCoreApplication.getInst()), c.a.e.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
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
            this.f50849a = frsFragment;
        }

        @Override // c.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(c.a.q0.a.g.o) instanceof String) {
                this.f50849a.mForum = (String) hashMap.get(c.a.q0.a.g.o);
            }
            if (!(hashMap.get(c.a.q0.a.g.J) instanceof String) || TextUtils.isEmpty((String) hashMap.get(c.a.q0.a.g.J))) {
                return;
            }
            c.a.e.e.m.e.a().postDelayed(new a(this, hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f50858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50859f;

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
            this.f50859f = frsFragment;
            this.f50858e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50859f.u == null || this.f50858e == null) {
                return;
            }
            this.f50859f.t0.start();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50860a;

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
            this.f50860a = frsFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50861a;

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
            this.f50861a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f50861a.v == null) {
                return;
            }
            this.f50861a.v.removeGameRankListFromThreadList();
            if (this.f50861a.r != null) {
                this.f50861a.r.G0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50862a;

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
            this.f50862a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f50862a.v.getToLoadHorseData().intValue() == 1 && this.f50862a.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(this.f50862a.forumId));
                this.f50862a.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50863a;

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
            this.f50863a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f48113c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.f50863a.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.f50863a.getActivity(), updateAttentionMessage.getData().l, this.f50863a.U0) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f48111a && updateAttentionMessage.getData().f48114d) {
                    c.a.e.e.p.l.L(this.f50863a.getPageContext().getPageActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements c.a.r0.x0.f2.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50864a;

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
            this.f50864a = frsFragment;
        }

        @Override // c.a.r0.x0.f2.k
        public void a(int i2, boolean z, int i3, boolean z2, ArrayList<c.a.e.l.e.n> arrayList, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3)}) == null) || this.f50864a.J == null || this.f50864a.F == null || !this.f50864a.F.u0() || !z || z2 || z3) {
                return;
            }
            this.f50864a.J.a(i3);
        }
    }

    /* loaded from: classes7.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50865a;

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
            this.f50865a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                this.f50865a.o0 = (Date) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50866a;

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
            this.f50866a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f50866a.refresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50867e;

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
            this.f50867e = frsFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f50867e.L != null && this.f50867e.L.e() != null) {
                    this.f50867e.L.e().c(motionEvent);
                }
                if (this.f50867e.Z != null) {
                    this.f50867e.Z.b(view, motionEvent);
                }
                if (this.f50867e.G != null) {
                    this.f50867e.G.O(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50868a;

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
            this.f50868a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.s.q.a0) && this.f50868a.isResumed()) {
                c.a.q0.s.q.a0 a0Var = (c.a.q0.s.q.a0) customResponsedMessage.getData();
                if (this.f50868a.w0 == null) {
                    FrsFragment frsFragment = this.f50868a;
                    frsFragment.w0 = new c.a.r0.x0.k1.a(frsFragment.getPageContext());
                }
                if (this.f50868a.v == null || this.f50868a.v.getForum() == null || TextUtils.isEmpty(this.f50868a.v.getForum().getId())) {
                    return;
                }
                this.f50868a.w0.g(a0Var.f14080a, this.f50868a.v.getForum().getId(), this.f50868a.v.getForum().getName(), a0Var.f14081b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50869a;

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
            this.f50869a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.f50869a.r.O1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50870a;

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
            this.f50870a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            if (j2.k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || this.f50870a.v.getForum() == null) {
                return;
            }
            this.f50870a.v.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes7.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50871a;

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
            this.f50871a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (d2Var = (d2) customResponsedMessage.getData()) != null && this.f50871a.isResumed()) {
                FrsFragment frsFragment = this.f50871a;
                frsFragment.C = d2Var.s1() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", d2Var.T());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50872a;

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
            this.f50872a = frsFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f50872a.refreshLevel();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f50873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50875g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f50876h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f50877i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50878j;

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
            this.f50878j = frsFragment;
            this.f50873e = j2;
            this.f50874f = i2;
            this.f50875g = i3;
            this.f50876h = f2;
            this.f50877i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setParams(this.f50873e, 0L, 0L, this.f50874f, this.f50875g, this.f50876h, this.f50877i);
                requestGetMyPostNetMessage.setTag(this.f50878j.getUniqueId());
                requestGetMyPostNetMessage.setHideErrorToast(true);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50879a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k1 f50880e;

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
                this.f50880e = k1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f50880e.f50879a.v.getForum().getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.r0.k3.i0.n(this.f50880e.f50879a.getContext(), "ForumGradePage", hashMap)));
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
            this.f50879a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg) && this.f50879a.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(this.f50879a.getContext()).setTitle(this.f50879a.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).setBtnText(this.f50879a.getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new a(this)).show((ViewGroup) this.f50879a.q.findViewById(R.id.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                forumBroadcastHelper.jumpFlutterEditGenear(this.f50879a.v.getForum().getId(), this.f50879a.v.getForum().getName(), "6");
                forumBroadcastHelper.clipCopy(this.f50879a.C);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50881a;

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
            this.f50881a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), this.f50881a.forumId)) {
                this.f50881a.T.l(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50882e;

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
            this.f50882e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.k3.o0.a.o(this.f50882e.mForum);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50883a;

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
            this.f50883a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.r0.j.h hVar = (c.a.r0.j.h) customResponsedMessage.getData();
            if (this.f50883a.v == null || this.f50883a.v.getForum() == null || this.f50883a.v.getForum().getDeletedReasonInfo() == null) {
                c.a.r0.j.e.d(0, this.f50883a.getPageContext(), hVar, null, this.f50883a.v.getUserData());
                return;
            }
            c.a.r0.j.i iVar = new c.a.r0.j.i(this.f50883a.v.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f50883a.v.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.f50883a.v.forumRule != null ? this.f50883a.v.forumRule.has_forum_rule.intValue() : 0);
            iVar.i(this.f50883a.v.getForum().getId(), this.f50883a.v.getForum().getName());
            iVar.h(this.f50883a.v.getForum().getImage_url());
            iVar.j(this.f50883a.v.getForum().getUser_level());
            c.a.r0.j.e.d(iVar.f(), this.f50883a.getPageContext(), hVar, iVar, this.f50883a.v.getUserData());
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50884a;

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
            this.f50884a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (this.f50884a.r != null) {
                    this.f50884a.r.X0(msgCount, z);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f50885e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50886f;

        public m0(FrsFragment frsFragment, c.a.q0.s.s.a aVar) {
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
            this.f50886f = frsFragment;
            this.f50885e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f50885e) == null) {
                return;
            }
            aVar.dismiss();
            this.f50886f.c1();
        }
    }

    /* loaded from: classes7.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50887a;

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
            this.f50887a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f50887a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f50887a.H.z() == null || !(this.f50887a.H.z().f51682b instanceof BaseFragment) || !((BaseFragment) this.f50887a.H.z().f51682b).isPrimary() || this.f50887a.r.F0()) {
                this.f50887a.u.setVisibility(8);
                this.f50887a.y = true;
                return;
            }
            this.f50887a.u.setVisibility(0);
            this.f50887a.y = false;
        }
    }

    /* loaded from: classes7.dex */
    public class n extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50888a;

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
            this.f50888a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f50888a.getContext() == null || this.f50888a.r == null) {
                return;
            }
            int i2 = 0;
            if (httpResponsedMessage.getError() == 0) {
                new BdTopToast(this.f50888a.getContext()).setIcon(true).setContent(this.f50888a.getContext().getString(R.string.frs_move_area_move_suc)).show(this.f50888a.r.l0());
                if (c.a.r0.x0.a.h().k(c.a.r0.x0.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (this.f50888a.H != null && this.f50888a.H.z() != null && (this.f50888a.H.z().f51682b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) this.f50888a.H.z().f51682b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.processBatchDelete();
                    }
                    this.f50888a.K0();
                    c.a.r0.x0.a.h().d();
                    for (c.a.e.l.e.n nVar : this.f50888a.v.getThreadList()) {
                        if (nVar instanceof c2) {
                            i2++;
                            continue;
                        }
                        if (i2 >= 6) {
                            break;
                        }
                    }
                    if (i2 < 6) {
                        this.f50888a.loadMore();
                    }
                }
                c.a.r0.x0.a.h().n();
                return;
            }
            new BdTopToast(this.f50888a.getContext()).setIcon(false).setContent(httpResponsedMessage.getErrorString()).show(this.f50888a.r.l0());
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements c.a.q0.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50889a;

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
            this.f50889a = frsFragment;
        }

        @Override // c.a.q0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.q0.y.d.h().o(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (this.f50889a.s != null) {
                        this.f50889a.s.setVisibility(8);
                        return;
                    }
                    return;
                }
                new BdTopToast(this.f50889a.getContext()).setIcon(false).setContent(this.f50889a.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).show(this.f50889a.r.l0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50890a;

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
            this.f50890a = frsFragment;
        }

        @Override // c.a.e.c.g.a
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
                if (this.f50890a.s0 != null) {
                    if (this.f50890a.u == null || this.f50890a.u.getVisibility() != 8) {
                        if (this.f50890a.r0 >= this.f50890a.s0.size()) {
                            this.f50890a.s0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = this.f50890a;
                        frsFragment.s0 = frsFragment.s0.subList(0, this.f50890a.r0);
                        this.f50890a.s0.addAll(arrayList);
                        return;
                    }
                    this.f50890a.s0 = new ArrayList();
                    this.f50890a.s0.addAll(arrayList);
                    this.f50890a.r0 = 0;
                    this.f50890a.Q0();
                    return;
                }
                this.f50890a.s0 = new ArrayList();
                this.f50890a.r0 = 0;
                this.f50890a.s0.addAll(arrayList);
                this.f50890a.Q0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends c.a.q0.j0.i<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50891g;

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
            this.f50891g = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.j0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                new BdTopToast(this.f50891g.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.f50891g.r.l0());
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements c.a.q0.s.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50892a;

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
            this.f50892a = frsFragment;
        }

        @Override // c.a.q0.s.e
        public void onPermissionResult(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                c.a.q0.y.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (this.f50892a.s != null) {
                    this.f50892a.s.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50893a;

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
            this.f50893a = frsFragment;
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
                this.f50893a.N0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50894a;

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
            this.f50894a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f50894a.isResumed()) {
                this.f50894a.m1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50895e;

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
            this.f50895e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50895e.r != null && view == this.f50895e.r.T() && this.f50895e.getActivity() != null) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f50895e.getPageContext().getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && c.a.e.e.p.l.D()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (this.f50895e.r == null || !this.f50895e.r.B0()) {
                        String c2 = this.f50895e.v.getForum().getYuleData().b().c();
                        if (!StringUtils.isNull(c2)) {
                            c.a.q0.m.a.k(this.f50895e.getPageContext().getPageActivity(), c2);
                        }
                    } else {
                        this.f50895e.r.G1();
                    }
                }
                if (this.f50895e.r != null && view == this.f50895e.r.c0() && this.f50895e.F != null && this.f50895e.F.i0()) {
                    this.f50895e.r.J1();
                    this.f50895e.loadMore();
                }
                if (view != null && this.f50895e.r != null && view == this.f50895e.r.d0()) {
                    if (!ViewHelper.checkUpIsLogin(this.f50895e.getContext())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f50895e.getContext())));
                }
                if (c.a.e.e.p.j.z()) {
                    if (this.f50895e.v == null || this.f50895e.v.getForum() == null) {
                        return;
                    }
                    if (this.f50895e.r != null && view == this.f50895e.r.q0()) {
                        if (this.f50895e.v == null || this.f50895e.v.getForum() == null || StringUtils.isNull(this.f50895e.v.getForum().getId()) || StringUtils.isNull(this.f50895e.v.getForum().getName())) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", this.f50895e.v.getForum().getId()).param("obj_locate", 11));
                        c.a.r0.x0.n2.i.c(this.f50895e.getPageContext(), this.f50895e.v, this.f50895e.v.getForum().getId());
                    }
                    if (this.f50895e.r == null || view != this.f50895e.r.p0()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12402").param("fid", this.f50895e.v.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f50895e.v.getForum().getName()));
                    if (StringUtils.isNull(this.f50895e.v.getForum().getName())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.f50895e.getContext(), this.f50895e.v.getForum().getName(), this.f50895e.v.getForum().getId())));
                    return;
                }
                c.a.e.e.p.l.L(this.f50895e.getContext().getApplicationContext(), R.string.network_not_available);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements c.a.r0.x0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50896a;

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
            this.f50896a = frsFragment;
        }

        @Override // c.a.r0.x0.s0
        public void a(int i2, int i3, c.a.r0.x0.b1 b1Var, ArrayList<c.a.e.l.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                this.f50896a.showLoadFinishedUI();
                if (this.f50896a.O != null) {
                    this.f50896a.G.b0(this.f50896a.O.e(i2));
                }
                c.a.r0.k3.f fVar = new c.a.r0.k3.f();
                if (b1Var != null) {
                    boolean z = b1Var.f26657e == 0;
                    fVar.f20983b = z;
                    fVar.f20984c = b1Var.f26657e;
                    fVar.f20985d = b1Var.f26658f;
                    if (z) {
                        if (ListUtils.isEmpty(arrayList)) {
                            this.f50896a.r.t0();
                        } else if (b1Var.f26659g) {
                            if (ListUtils.getCount(this.f50896a.v.getThreadList()) > 3) {
                                this.f50896a.r.J1();
                            } else {
                                this.f50896a.r.F1();
                            }
                        } else if (b1Var.f26661i) {
                            this.f50896a.r.M1();
                        } else {
                            this.f50896a.r.t0();
                        }
                    }
                } else {
                    b1Var = new c.a.r0.x0.b1();
                    b1Var.f28223c = 1;
                    b1Var.f26659g = false;
                    b1Var.f26661i = false;
                }
                if (i2 == 1) {
                    this.f50896a.A = true;
                    FrsFragment frsFragment = this.f50896a;
                    frsFragment.mForumModelCallback.d(frsFragment.F.getType(), false, fVar);
                } else {
                    this.f50896a.f1(fVar);
                    if (this.f50896a.F.d0() != null) {
                        FrsFragment frsFragment2 = this.f50896a;
                        frsFragment2.v = frsFragment2.F.d0();
                    }
                    this.f50896a.V0();
                }
                if (this.f50896a.r1 != null) {
                    this.f50896a.r1.a(i2, i3, b1Var, arrayList);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50897a;

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
            this.f50897a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f50897a.r != null) {
                    this.f50897a.r.e1(booleanValue);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f50898a;

        /* renamed from: b  reason: collision with root package name */
        public int f50899b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50900c;

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
            this.f50900c = frsFragment;
            this.f50898a = 0;
            this.f50899b = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (this.f50900c.G != null) {
                    this.f50900c.G.l0(i2);
                    if (i2 == 1) {
                        this.f50900c.G.w();
                    }
                }
                FrsFragment frsFragment = this.f50900c;
                if (frsFragment.perfFluencyLogData == null && !frsFragment.isFromMainTab()) {
                    this.f50900c.perfFluencyLogData = new c.a.q0.q0.b();
                    this.f50900c.perfFluencyLogData.a(1000);
                }
                if (i2 == 0) {
                    c.a.q0.q0.b bVar = this.f50900c.perfFluencyLogData;
                    if (bVar != null) {
                        bVar.e();
                    }
                    c.a.r0.b0.u.b().e(true);
                    this.f50900c.logStatisticByKey(true);
                    this.f50900c.r.J0(this.f50898a, this.f50899b);
                } else {
                    c.a.q0.q0.b bVar2 = this.f50900c.perfFluencyLogData;
                    if (bVar2 != null) {
                        bVar2.d();
                    }
                }
                if (this.f50900c.X != null) {
                    this.f50900c.X.i(recyclerView, i2);
                }
                if (i2 == 0) {
                    c.a.r0.x0.n2.l.b(this.f50900c.r, this.f50900c.v, this.f50900c.getForumId(), false, null);
                }
                if (this.f50900c.H != null && i2 == 1) {
                    this.f50900c.H.L();
                }
                if (this.f50900c.E == null) {
                    if (this.f50900c.r.i0() != null && !this.f50900c.r.a0() && this.f50900c.r.i0().j() != null && (this.f50900c.r.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment2 = this.f50900c;
                        frsFragment2.E = (ThreadCardViewHolder) frsFragment2.r.i0().j().getTag();
                    }
                } else if (i2 == 0 && this.f50900c.r.i0() != null && !this.f50900c.r.a0() && this.f50900c.r.i0().j() != null && (this.f50900c.r.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment3 = this.f50900c;
                    frsFragment3.E = (ThreadCardViewHolder) frsFragment3.r.i0().j().getTag();
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
                this.f50900c.q0 += i3;
                if (this.f50900c.q0 >= this.f50900c.p0 * 2 && i3 < 0) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
                }
                if (this.f50900c.P != null) {
                    this.f50900c.P.j();
                }
                this.f50898a = 0;
                this.f50899b = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    this.f50898a = bdRecyclerView.getFirstVisiblePosition();
                    this.f50899b = bdRecyclerView.getLastVisiblePosition();
                }
                if (this.f50900c.X != null) {
                    this.f50900c.X.h(recyclerView, this.f50898a, this.f50899b);
                }
                if (this.f50900c.v == null || this.f50900c.r == null || this.f50900c.r.W() == null) {
                    return;
                }
                this.f50900c.r.f1(this.f50898a, this.f50899b);
                if (this.f50900c.E == null || this.f50900c.E.getCardView() == null) {
                    return;
                }
                this.f50900c.E.getCardView().o(this.f50900c.D);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class q1 implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50901e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f50902e;

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
                this.f50902e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    NetWork netWork = new NetWork(this.f50902e);
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
            this.f50901e = frsFragment;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == c.a.r0.x0.u.f28021e) {
                if (this.f50901e.r != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", this.f50901e.forumId).param("obj_locate", "1"));
                    this.f50901e.r.R1();
                }
            } else if (nVar == null || !(nVar instanceof c2)) {
            } else {
                d2 d2Var = ((c2) nVar).w;
                if (d2Var.E() == null || d2Var.E().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(this.f50901e.getActivity())) {
                    if (d2Var.w() != 1 || ViewHelper.checkUpIsLogin(this.f50901e.getActivity())) {
                        if (d2Var.G() != null) {
                            if (ViewHelper.checkUpIsLogin(this.f50901e.getActivity())) {
                                String a2 = d2Var.G().a();
                                if (StringUtils.isNull(a2) || !c.a.e.e.p.l.D()) {
                                    return;
                                }
                                c.a.q0.m.a.k(this.f50901e.getActivity(), a2);
                            }
                        } else if (d2Var.M() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(this.f50901e.getPageContext().getPageActivity());
                                return;
                            }
                            c.a.q0.s.q.u M = d2Var.M();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.f50901e.getPageContext().getPageActivity(), M.a(), M.b(), 2)));
                        } else {
                            c.a.r0.k3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                                UrlManager.getInstance().dealOneLink(this.f50901e.getPageContext(), new String[]{s1, "", null});
                                return;
                            }
                            if (s1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && s1.length() > 4) {
                                d2Var.N3(s1.substring(3));
                            }
                            if (bdUniqueId.getId() == d2.T3.getId()) {
                                c.a.r0.x0.n2.l.c(d2Var.j1());
                            } else if (bdUniqueId.getId() == d2.C3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", d2Var.s1());
                                TiebaStatic.log(statisticItem);
                            }
                            c.a.r0.x0.n2.m.e(this.f50901e, d2Var, i2, z);
                            FrsFragment frsFragment = this.f50901e;
                            c.a.r0.x0.n2.l.d(frsFragment, frsFragment.v, d2Var);
                        }
                    }
                }
            }
        }

        public /* synthetic */ q1(FrsFragment frsFragment, k kVar) {
            this(frsFragment);
        }
    }

    /* loaded from: classes7.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50903a;

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
            this.f50903a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() == null || c.a.e.e.p.k.isEmpty(str) || !str.equals(this.f50903a.forumId)) {
                    return;
                }
                c.a.r0.x0.n2.i.d(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), this.f50903a.v);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50904a;

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
            this.f50904a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f50904a.t == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || this.f50904a.H.I() == 0 || this.f50904a.H.z() == null || !(this.f50904a.H.z().f51682b instanceof BaseFragment) || !((BaseFragment) this.f50904a.H.z().f51682b).isPrimary() || this.f50904a.r.F0() || c.a.q0.y.d.h().k()) {
                if (this.f50904a.H.I() != 0) {
                    this.f50904a.t.hide();
                    return;
                }
                return;
            }
            this.f50904a.t.show();
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50905a;

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
            this.f50905a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f50905a.r == null) {
                return;
            }
            this.f50905a.r.N();
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements c.a.r0.x0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50906a;

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
            this.f50906a = frsFragment;
        }

        @Override // c.a.r0.x0.f
        public void a(int i2, int i3, View view, View view2, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), view, view2, d2Var}) == null) {
                if (i2 != this.f50906a.r.W().d()) {
                    if (i2 != this.f50906a.r.W().k()) {
                        if (i2 != this.f50906a.r.W().j() || this.f50906a.v == null || this.f50906a.v.getUserData() == null || !this.f50906a.v.getUserData().isBawu()) {
                            return;
                        }
                        String bawuCenterUrl = this.f50906a.v.getBawuCenterUrl();
                        if (c.a.e.e.p.k.isEmpty(bawuCenterUrl) || this.f50906a.v.getForum() == null) {
                            return;
                        }
                        c.a.q0.m.a.l(this.f50906a.getPageContext().getPageActivity(), bawuCenterUrl);
                        TiebaStatic.log(new StatisticItem("c10502").param("fid", this.f50906a.v.getForum().getId()).param("uid", this.f50906a.v.getUserData().getUserId()));
                    } else if (ViewHelper.checkUpIsLogin(this.f50906a.getPageContext().getPageActivity())) {
                        TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                        if (this.f50906a.v == null || this.f50906a.v.getForum() == null) {
                            return;
                        }
                        ForumData forum = this.f50906a.v.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f50906a.getPageContext().getPageActivity(), c.a.e.e.m.b.g(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                } else if (ViewHelper.checkUpIsLogin(this.f50906a.getActivity())) {
                    TiebaStatic.log(FrsFragment.MTJ_FORUM_FORTUNE_CLICK);
                    c.a.r0.x0.n2.m.d(this.f50906a.getPageContext(), this.f50906a.v);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50907a;

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
            this.f50907a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f50907a.showFrsAdvancedAdGuide();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50908e;

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
            this.f50908e = frsFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f50908e.F.b0() == 1 && z && !this.f50908e.r.a0()) {
                if (this.f50908e.v != null && !ListUtils.isEmpty(this.f50908e.v.getThreadList())) {
                    this.f50908e.r.H0();
                    return;
                }
                FrsFragment frsFragment = this.f50908e;
                frsFragment.hideNetRefreshView(frsFragment.r.X().k());
                FrsFragment frsFragment2 = this.f50908e;
                frsFragment2.showLoadingView(frsFragment2.r.l0(), true);
                this.f50908e.r.u0(false);
                this.f50908e.refresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements c.a.r0.k3.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f50909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50910b;

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
            this.f50910b = frsFragment;
            this.f50909a = 0L;
        }

        @Override // c.a.r0.k3.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f50909a = System.nanoTime();
                if (this.f50910b.r == null) {
                    return;
                }
                if (i2 == 1 || i2 == 2) {
                    this.f50910b.r.H0();
                }
            }
        }

        @Override // c.a.r0.k3.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50910b.refreshLevel();
            }
        }

        @Override // c.a.r0.k3.t
        public void c(c.a.r0.k3.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                if ((mVar == null || !(FrsFragment.NORMAL_FRS.equals(this.f50910b.F.Z()) || FrsFragment.STAR_FRS.equals(this.f50910b.F.Z()) || FrsFragment.BOOK_FRS.equals(this.f50910b.F.Z()))) && !FrsFragment.BRAND_FRS.equals(this.f50910b.F.Z())) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
                this.f50910b.X0(mVar);
                FrsFragment.cacheData = mVar;
            }
        }

        @Override // c.a.r0.k3.t
        public void d(int i2, boolean z, c.a.r0.k3.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), fVar}) == null) {
                if (this.f50910b.N) {
                    this.f50910b.N = false;
                    c.a.r0.x0.n2.l.b(this.f50910b.r, this.f50910b.v, this.f50910b.getForumId(), false, null);
                }
                this.f50910b.showLoadFinishedUI();
                this.f50910b.z = true;
                if (fVar != null && fVar.f20983b) {
                    this.f50910b.r.W().o(TbImageHelper.getInstance().isShowBigImage());
                    FrsFragment.mPbLoadTime = 0L;
                    FrsFragment.mPbLoadDataSize = 0L;
                    FrsFragment.mNetError = 0;
                } else {
                    FrsFragment.mNetError = 1;
                }
                if (!this.f50910b.F.u0() && (i2 == 3 || i2 == 6)) {
                    this.f50910b.R.k();
                }
                this.f50910b.drawStartTime = System.currentTimeMillis();
                if (this.f50910b.F.d0() != null) {
                    FrsFragment frsFragment = this.f50910b;
                    frsFragment.v = frsFragment.F.d0();
                }
                this.f50910b.e1(1);
                this.f50910b.Z0();
                if (i2 == 7) {
                    this.f50910b.W0(this.f50910b.v.getFrsDefaultTabId());
                    return;
                }
                if (this.f50910b.v.getPage() != null) {
                    FrsFragment frsFragment2 = this.f50910b;
                    frsFragment2.setHasMore(frsFragment2.v.getPage().b());
                }
                if (i2 == 4) {
                    if (!this.f50910b.F.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.f50910b.F.b0() == 1 && !c.a.r0.z0.a.d()) {
                        this.f50910b.v.addRecommendAppToThreadList(this.f50910b);
                    }
                    ArrayList<c.a.e.l.e.n> c2 = this.f50910b.R.c(false, false, this.f50910b.v.getThreadList(), this.f50910b.m, false);
                    if (c2 != null) {
                        this.f50910b.v.setThreadList(c2);
                        this.f50910b.v.checkLiveStageInThreadList();
                    }
                    if (this.f50910b.F != null) {
                        c.a.r0.x0.k2.c.l(this.f50910b.v, this.f50910b.F.R(), 2, this.f50910b.getContext());
                    }
                    FrsFragment frsFragment3 = this.f50910b;
                    c.a.r0.x0.n2.a.a(frsFragment3, frsFragment3.v.getForum(), this.f50910b.v.getThreadList(), false, this.f50910b.getPn());
                    this.f50910b.r.B1(c2, this.f50910b.v);
                    this.f50910b.h1();
                    return;
                }
                this.f50910b.h1();
                if (i2 == 1) {
                    this.f50910b.r.H0();
                } else if (i2 == 2) {
                    this.f50910b.r.H0();
                } else if (i2 == 3 || i2 == 6) {
                    if (this.f50910b.v != null) {
                        this.f50910b.v.clearPostThreadCount();
                    }
                    c.a.r0.x0.o2.c cVar = this.f50910b.mEnterFrsDialogController;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
                this.f50910b.l1();
                if (fVar == null || fVar.f20984c == 0) {
                    if (this.f50910b.v == null) {
                        return;
                    }
                    FrsFragment frsFragment4 = this.f50910b;
                    frsFragment4.a1(frsFragment4.v);
                    this.f50910b.U0(false, i2 == 5);
                    if (this.f50910b.F != null) {
                        if (this.f50910b.v.getActivityHeadData() != null && this.f50910b.v.getActivityHeadData().b() != null && this.f50910b.v.getActivityHeadData().b().size() > 0) {
                            c.a.r0.x0.k2.a.g(this.f50910b.getUniqueId(), 1, this.f50910b.v.getForum(), this.f50910b.F.a0(), 1);
                        }
                        if (this.f50910b.v.getThreadList() != null && this.f50910b.v.getThreadList().size() > 0) {
                            Iterator<c.a.e.l.e.n> it = this.f50910b.v.getThreadList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                c.a.e.l.e.n next = it.next();
                                if ((next instanceof d2) && ((d2) next).getType() == d2.T3) {
                                    c.a.r0.x0.k2.a.g(this.f50910b.getUniqueId(), 1, this.f50910b.v.getForum(), this.f50910b.F.a0(), 2);
                                    break;
                                }
                            }
                        }
                        c.a.r0.x0.k2.a.h(this.f50910b.getUniqueId(), this.f50910b.v.getThreadList(), this.f50910b.v.getForum(), this.f50910b.F.a0());
                    }
                    this.f50910b.r.S0(i2);
                    FrsFragment.mPbLoadTime = (System.nanoTime() - this.f50909a) / 1000000;
                    if (fVar != null) {
                        FrsFragment.mPbLoadDataSize = fVar.f20986e;
                    }
                } else if (this.f50910b.v == null || ListUtils.isEmpty(this.f50910b.v.getThreadList())) {
                    this.f50910b.f1(fVar);
                } else if (fVar.f20982a) {
                    FrsFragment frsFragment5 = this.f50910b;
                    frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.net_error_text, fVar.f20985d, Integer.valueOf(fVar.f20984c)));
                }
                this.f50910b.k1();
                this.f50910b.I0();
                if (this.f50910b.v.getAccessFlag() == 1) {
                    TiebaStatic.log(new StatisticItem("c11384"));
                }
                if (this.f50910b.n && this.f50910b.H.b(49)) {
                    this.f50910b.n = false;
                }
                System.gc();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50911a;

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
            this.f50911a = frsFragment;
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
                c.a.r0.x0.n2.c.a(customResponsedMessage, this.f50911a.r, this.f50911a.v);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50912a;

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
            this.f50912a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof d2) {
                    c.a.r0.x0.n2.l.b(this.f50912a.r, this.f50912a.v, this.f50912a.getForumId(), true, (d2) data);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50913e;

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
            this.f50913e = frsFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment fragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50913e.H == null) {
                return;
            }
            FrsTabViewController.o z = this.f50913e.H.z();
            if (z != null && (fragment = z.f51682b) != null && (fragment instanceof c.a.r0.x0.p0)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                ((c.a.r0.x0.p0) z.f51682b).scrollToTop();
                ((c.a.r0.x0.p0) z.f51682b).forceRefresh();
                return;
            }
            this.f50913e.getFrsView().R1();
        }
    }

    /* loaded from: classes7.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f50914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f50915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50916g;

        public w(FrsFragment frsFragment, PrivateForumPopInfoData privateForumPopInfoData, c.a.q0.s.s.a aVar) {
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
            this.f50916g = frsFragment;
            this.f50914e = privateForumPopInfoData;
            this.f50915f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f50916g.getPageContext(), new String[]{this.f50914e.z()});
                this.f50915f.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements c.a.r0.x0.s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50917a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w0 f50918e;

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
                this.f50918e = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50918e.f50917a.r != null && this.f50918e.f50917a.r.C0()) {
                    this.f50918e.f50917a.loadMore();
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
            this.f50917a = frsFragment;
        }

        @Override // c.a.r0.x0.s0
        public void a(int i2, int i3, c.a.r0.x0.b1 b1Var, ArrayList<c.a.e.l.e.n> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), b1Var, arrayList}) == null) {
                c.a.e.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50919e;

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
            this.f50919e = frsFragment;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50920a;

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
            this.f50920a = frsFragment;
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
            this.f50920a.Y = true;
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50923g;

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
            this.f50923g = frsFragment;
            this.f50921e = i2;
            this.f50922f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13387").param("fid", this.f50923g.forumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f50921e));
                UrlManager.getInstance().dealOneLink(this.f50923g.getPageContext(), new String[]{this.f50922f});
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50924a;

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
            this.f50924a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (this.f50924a.E == null && this.f50924a.r.i0() != null && !this.f50924a.r.a0() && this.f50924a.r.i0().j() != null && (this.f50924a.r.i0().j().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment frsFragment = this.f50924a;
                        frsFragment.E = (ThreadCardViewHolder) frsFragment.r.i0().j().getTag();
                    }
                    if (this.f50924a.E == null || this.f50924a.E.getCardView() == null) {
                        return;
                    }
                    this.f50924a.E.getCardView().o(new a.C0095a(3));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50925e;

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
            this.f50925e = frsFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50925e.z || !c.a.e.e.p.j.z() || this.f50925e.r.E0()) {
                return;
            }
            this.f50925e.r.U0();
        }
    }

    /* loaded from: classes7.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsFragment f50926a;

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
            this.f50926a = frsFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f50926a.r == null) {
                return;
            }
            this.f50926a.r.R0();
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
        this.f50824e = "";
        this.mSpeedUpTipShowing = false;
        this.f50826g = false;
        this.f50827h = true;
        this.mForum = null;
        this.mFrom = null;
        this.mFlag = 0;
        this.createWithGame = false;
        this.f50828i = false;
        this.f50829j = null;
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
        this.D = new a.C0095a(2);
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
        this.E0 = new k(this);
        this.F0 = new v(this, 2016495);
        this.G0 = new g0(this, 2921005);
        this.H0 = new r0(this, 2921401);
        this.I0 = new c1(this, 2921473);
        this.J0 = new m1(this, 2921467);
        this.K0 = new n1(this, CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        this.L0 = new o1(this, 2001624);
        this.M0 = new p1(this);
        this.N0 = new a(this);
        this.P0 = new b(this, 2001606);
        this.Q0 = new c(this, 2001607);
        this.R0 = new d(this, 2003019);
        this.S0 = new e(this, 2921470);
        this.T0 = new f(this, 2001352);
        this.U0 = new g(this);
        this.V0 = new h(this, 2001115);
        this.W0 = new i(this, 2921346);
        this.X0 = new j(this, 2001374);
        this.Y0 = new l(this, 2001378);
        this.Z0 = new m(this, 2001626);
        this.a1 = new n(this, CmdConfigHttp.CMD_FRS_MOVE_AREA);
        this.b1 = new o(this);
        this.c1 = new p(this, 2921391);
        this.d1 = new q(this, 2003020);
        this.e1 = new r(this, 2921463);
        this.f1 = new s(this, 2921587);
        this.g1 = new t(this, 2921588);
        this.mForumModelCallback = new u(this);
        this.h1 = new b0(this, 2016485);
        this.i1 = new c0(this, 2001194);
        this.j1 = new f0(this);
        this.k1 = new h0(this);
        this.mOnTouchListener = new i0(this);
        this.l1 = new j0(this, 2004507);
        this.mCommenOnClickListener = new p0(this);
        this.m1 = new q0(this);
        this.n1 = new s0(this);
        this.o1 = new t0(this);
        this.p1 = new u0(this, 0);
        this.q1 = new q1(this, null);
        this.r1 = new w0(this);
        this.s1 = new x0(this, 2921033);
        this.t1 = new y0(this, 2921381);
        this.u1 = new z0(this, 2921414);
        this.v1 = new a1(this, 2921437);
        this.w1 = new g1(this, 2921462);
        this.x1 = new h1(this, 2001223);
        this.y1 = new i1(this, 2921469);
        this.z1 = new j1(this, 2921475);
        this.A1 = new k1(this, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
        this.B1 = new l1(this, 2921515);
    }

    public final void D0(boolean z2, boolean z3) {
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
            if (!(this.r.W().l(c.a.r0.b0.e0.n.k) ? this.v.addHotTopicDataToThreadList() : false)) {
                this.v.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !c.a.r0.z0.a.d()) {
                this.v.addRecommendAppToThreadList(this);
            }
            if (!this.r.W().l(d2.y3)) {
                this.v.removeAlaLiveThreadData();
            }
            this.v.addSchoolRecommendToThreadList();
        }
        if (!this.r.W().l(d2.y3)) {
            this.v.removeAlaInsertLiveData();
            this.v.removeAlaStageLiveDat();
        } else {
            this.v.addInsertLiveDataToThreadList();
            this.v.addStageLiveDataToThreadList();
        }
        this.v.checkLiveStageInThreadList();
        this.v.addNoticeThreadToThreadList();
        if (this.r.W().l(c.a.r0.a1.b.f15592i)) {
            this.v.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.F.u0() || this.F.isNetFirstLoad)) {
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
            c.a.r0.x0.n1.e.b bVar = this.O;
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
        ArrayList<c.a.e.l.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.r.b0() == null || this.r.b0().getData() == null) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = threadList.iterator();
        List<c.a.e.l.e.n> data = this.r.b0().getData();
        int i2 = 0;
        while (it.hasNext()) {
            c.a.e.l.e.n next = it.next();
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
                        this.r.b0().getAdapter().notifyItemRemoved(i2);
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(c.a.r0.x0.a.h().i()) || this.r.b0() == null || this.r.b0().getData() == null) {
            return;
        }
        ArrayList<c.a.e.l.e.n> threadList = this.v.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<c.a.e.l.e.n> it = threadList.iterator();
        List<c.a.e.l.e.n> data = this.r.b0().getData();
        int count = ListUtils.getCount(c.a.r0.x0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            c.a.e.l.e.n next = it.next();
            if (next instanceof c2) {
                d2 d2Var = ((c2) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(c.a.r0.x0.a.h().i().get(i3).f0(), d2Var.f0())) {
                        it.remove();
                        data.remove(next);
                        this.R.j(next);
                        this.r.b0().getAdapter().notifyItemRemoved(i2);
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
        c.a.e.e.m.e.a().postDelayed(new k0(this, j2, c.a.e.e.p.l.k(TbadkCoreApplication.getInst()), c.a.e.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r.R1();
        }
    }

    public final void O0(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || intent == null) {
            return;
        }
        if (!c.a.r0.x0.n2.j.a(this, getForumName(), "from", intent.getBooleanExtra("from_short_cut", false)) && getActivity() != null) {
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
        if (c.a.q0.a.g.c(uri)) {
            c.a.q0.a.g.b().d(uri, this.j1);
        } else {
            c.a.r0.x0.n2.g b2 = c.a.r0.x0.n2.m.b(intent);
            if (b2 != null) {
                this.mForum = b2.f27507a;
                String str = b2.f27508b;
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
        int D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.F == null || (frsViewData = this.v) == null || this.H == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.v.getEntelechyTabInfo().f21174a) || (D = this.H.D()) == 502) {
                return null;
            }
            int i2 = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : this.v.getEntelechyTabInfo().f21174a) {
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

    public final void Q0() {
        List<LiveHorseRaceData> list;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || !isResumed() || (list = this.s0) == null || list.size() < 1 || this.r0 > this.s0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.s0.get(this.r0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.r0++;
            Q0();
        }
        if (this.u != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + "...");
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new b1(this, liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.t0 = ofFloat;
            ofFloat.setDuration(600L);
            this.t0.addUpdateListener(new d1(this, frsRedpackRunView));
            this.t0.addListener(new e1(this, frsRedpackRunView));
            this.u0 = new f1(this, frsRedpackRunView);
            c.a.e.e.m.e.a().postDelayed(this.u0, 5000L);
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
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.H.z().f51682b).isPrimary() || this.r.F0() || this.y) {
                return;
            }
            this.u.setVisibility(0);
        }
    }

    public final void R0(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            registerListener(2001118, this.p1);
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
                registerListener(2001120, this.p1);
            }
            this.G.D(bundle);
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
            c.a.q0.s.q.b0 b0Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                b0Var = new c.a.q0.s.q.b0();
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
                c.a.e.e.m.h.a().b(new l0(this));
            }
            this.mFlag = 0;
        }
    }

    public final void U0(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            try {
                if (this.v != null && this.H != null && this.F != null) {
                    if (!this.r.W().l(d2.y3)) {
                        this.v.removeAlaLiveThreadData();
                    }
                    boolean isEmpty = ListUtils.isEmpty(this.v.getGameTabInfo());
                    this.r.n1(isEmpty);
                    if (!isEmpty) {
                        if (this.X == null) {
                            this.X = new c.a.r0.x0.o2.e(this, (NoPressedRelativeLayout) this.q);
                        }
                        if (this.Z == null) {
                            this.Z = new c.a.r0.x0.x1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                    ArrayList<c.a.e.l.e.n> d2 = this.R.d(z3, true, this.v.getThreadList(), null, z2, false);
                    if (d2 != null) {
                        this.v.setThreadList(d2);
                    }
                    this.v.removeRedundantUserRecommendData();
                    int topThreadSize = this.v.getTopThreadSize();
                    this.k = topThreadSize;
                    if (this.m != null) {
                        this.l = true;
                        this.m.e(topThreadSize);
                        c.a.r0.x0.n2.a.a(this, this.v.getForum(), this.v.getThreadList(), this.l, getPn());
                    }
                    if (this.F.b0() == 1) {
                        V0();
                        if (!z2 && this.F.getPn() == 1) {
                            requestLoadLiveTip();
                        }
                    }
                    if (this.P != null) {
                        this.P.k(this.H.E());
                    }
                    showLoadFinishedUI();
                    this.r.b1();
                    this.r.j1(true, false);
                    if (z2 && this.v.isFirstTabEqualAllThread()) {
                        c.a.e.e.m.e.a().post(new z(this));
                    }
                    if (this.v.getForum() != null) {
                        this.r.M(this.v.getForum().getWarningMsg());
                    }
                    if (this.v != null && this.v.getFrsVideoActivityData() != null && c.a.q0.s.d0.b.j().l("frs_video_activity_guide", 0L) == 0) {
                        c.a.e.e.m.e.a().postDelayed(new a0(this), 1000L);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                    this.r.D1();
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
                this.r.I1();
                this.r.Q1(canShowWriteButton());
                if (c.a.r0.x0.o2.h.B(this.v)) {
                    c.a.r0.x0.o2.h.A(this.v);
                }
                if (this.v.getForum() != null) {
                    this.mForum = this.v.getForum().getName();
                    this.forumId = this.v.getForum().getId();
                }
                if (this.v.getPage() != null) {
                    setHasMore(this.v.getPage().b());
                }
                this.r.C1(this.mForum);
                this.r.g1(this.mForum);
                TbadkCoreApplication.getInst().setDefaultBubble(this.v.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.v.getUserData().getBimg_end_time());
                T0();
                Y0();
                ArrayList<c.a.e.l.e.n> threadList = this.v.getThreadList();
                if (threadList != null) {
                    this.r.B1(threadList, this.v);
                    c.a.r0.x0.n2.c.b(this.r);
                    this.G.k0(getPageNum());
                    this.G.S(this.v);
                    this.H.d(this.v, this.F.R());
                    this.r.c1();
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
                c.a.r0.x0.y0 y0Var = null;
                this.r.B1(null, this.v);
                this.G.k0(1);
                this.r.c1();
                this.H.d(this.v, this.F.R());
                c.a.r0.x0.l2.e H = this.H.H(this.v.getFrsDefaultTabId());
                if (H != null && !TextUtils.isEmpty(H.f27198d)) {
                    y0Var = new c.a.r0.x0.y0();
                    String str = H.f27198d;
                    String str2 = H.f27195a;
                }
                this.F.q(this.v.getFrsDefaultTabId(), 0, y0Var);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void X0(c.a.r0.k3.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mVar) == null) {
            try {
                if (!this.z && mVar != null && this.v != null) {
                    this.v.receiveData(mVar);
                    U0(true, false);
                    Looper.myQueue().addIdleHandler(this.E0);
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
            this.r.W().setFromCDN(true);
        } else {
            this.r.W().setFromCDN(false);
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

    public final boolean a1(c.a.r0.k3.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, mVar)) == null) {
            if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().f21174a != null) {
                for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().f21174a) {
                    if (frsTabInfo.tab_id.intValue() == 502 && c.a.q0.s.d0.b.j().g("first_into_tab_profession", true)) {
                        return false;
                    }
                }
            }
            c.a.r0.x0.g1.f fVar = new c.a.r0.x0.g1.f(getTbPageContext());
            this.B0 = fVar;
            boolean j2 = fVar.j(mVar);
            this.C0 = j2;
            return j2;
        }
        return invokeL.booleanValue;
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
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
            c.a.q0.y.d.h().m(new c.a.q0.y.a(getContext()));
            c.a.q0.y.d.h().n(85, 0, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (c.a.q0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new n0(this), true);
            }
        }
    }

    public boolean canShowSpeedTipView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f50827h : invokeV.booleanValue;
    }

    public boolean canShowWriteButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? canShowWriteButton(this.O0) : invokeV.booleanValue;
    }

    @Override // c.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            c.a.r0.x0.n2.m.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
        }
    }

    public c.a.e.l.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bdUniqueId)) == null) ? c.a.r0.x0.e.e().d(getPageContext(), bdUniqueId, getUniqueId()) : (c.a.e.l.e.a) invokeL.objValue;
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.q0.y.d.h().m(new c.a.q0.y.b(getContext()));
            c.a.q0.y.d.h().n(85, 0, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
            if (c.a.q0.y.d.h().j()) {
                getPageContext().getOrignalPage().grantWindowPermission(new o0(this), true);
            }
        }
    }

    @Override // c.a.r0.g.e.b
    public void dispatchInjectPluginMessage(c.a.r0.g.d dVar) {
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
                if (c.a.e.e.p.k.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", c.a.q0.d1.u0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public final void f1(c.a.r0.k3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            if (fVar == null) {
                String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
                this.r.T0();
                showNetRefreshView(this.r.l0(), string, true);
            } else if (340001 == fVar.f20984c) {
                j1(fVar, this.v.getRecm_forum_list());
            } else {
                if (ListUtils.isEmpty(this.v.getThreadList())) {
                    i1(fVar);
                }
                if (isFromMainTab()) {
                    setNetRefreshViewEmotionMarginTop(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
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
                    this.r.t0();
                } else {
                    this.r.M1();
                }
            } else if (ListUtils.getCount(this.v.getThreadList()) > 3) {
                this.r.J1();
            } else {
                this.r.F1();
            }
        }
    }

    public c.a.r0.x0.n1.e.b getEntelechyProcessor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.O : (c.a.r0.x0.n1.e.b) invokeV.objValue;
    }

    public c.a.r0.x0.n1.a getFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f50825f : (c.a.r0.x0.n1.a) invokeV.objValue;
    }

    @Override // c.a.r0.z2.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // c.a.r0.x0.t0
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    @Override // c.a.r0.x0.e2.a, c.a.r0.x0.t0
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

    public c.a.e.l.e.w getFrsAdapterItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q1 : (c.a.e.l.e.w) invokeV.objValue;
    }

    public int getFrsCallFromByItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.z0 = getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION, -1);
            }
            return this.z0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.x0.f2.l
    public c.a.r0.x0.f2.c getFrsLoadMoreModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.R : (c.a.r0.x0.f2.c) invokeV.objValue;
    }

    public c.a.r0.x0.f2.d getFrsPostController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.Q : (c.a.r0.x0.f2.d) invokeV.objValue;
    }

    public c.a.r0.x0.i2.a getFrsSmartSortController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.J : (c.a.r0.x0.i2.a) invokeV.objValue;
    }

    @Override // c.a.r0.x0.f2.l
    public c.a.r0.x0.q getFrsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.r : (c.a.r0.x0.q) invokeV.objValue;
    }

    @Override // c.a.r0.x0.e2.a
    public FrsViewData getFrsViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.v : (FrsViewData) invokeV.objValue;
    }

    @Override // c.a.r0.x0.f2.l
    public c.a.r0.x0.o2.h getHeaderVC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.G : (c.a.r0.x0.o2.h) invokeV.objValue;
    }

    @Override // c.a.r0.g.e.b
    public c.a.r0.g.e.a getInjectPlugin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) ? this.M.get(i2) : (c.a.r0.g.e.a) invokeI.objValue;
    }

    public boolean getIsRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.r.a0() : invokeV.booleanValue;
    }

    public int getLastTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.O0 : invokeV.intValue;
    }

    @Override // c.a.r0.x0.f2.l
    public FrsModelController getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.F : (FrsModelController) invokeV.objValue;
    }

    public c.a.r0.x0.u0 getNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.L : (c.a.r0.x0.u0) invokeV.objValue;
    }

    @Override // c.a.r0.x0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            c.a.r0.x0.q qVar = this.r;
            if (qVar == null) {
                return null;
            }
            return qVar.e0();
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.r0.x0.e2.a
    public /* bridge */ /* synthetic */ c.a.e.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // c.a.r0.z2.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            c.a.r0.x0.f2.c cVar = this.R;
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
            c.a.r0.x0.f2.c cVar = this.R;
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

    @Override // c.a.r0.z2.u
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        FrsTabViewController.o z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (getTabController() != null && (z2 = getTabController().z()) != null) {
                Fragment fragment = z2.f51682b;
                if (fragment instanceof BaseFragment) {
                    if (fragment instanceof FrsAllThreadFragment) {
                        TbPageTag tbPageTag = super.getTbPageTag();
                        FrsViewData frsViewData = this.v;
                        tbPageTag.sortType = c.a.r0.x0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
                        tbPageTag.locatePage = "a070";
                        if (this.f50824e.equals(z2.f51683c)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f50829j : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.x == null) {
                this.x = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.x;
        }
        return (c.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            c.a.r0.x0.q qVar = this.r;
            if (qVar == null) {
                return 0;
            }
            return qVar.r0();
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
                    this.r.t0();
                } else {
                    this.r.M1();
                }
            } else if (ListUtils.getCount(this.v.getThreadList()) > 3) {
                this.r.J1();
            } else {
                this.r.F1();
            }
        }
    }

    public int hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            c.a.r0.x0.f2.c cVar = this.R;
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
        c.a.e.e.p.l.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, view) == null) {
            this.r.h1(0);
            ((FrsActivity) getActivity()).hideLoadingView(view);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, view) == null) {
            super.hideNetRefreshView(view);
            this.r.h1(0);
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

    public final void i1(c.a.r0.k3.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, fVar) == null) {
            this.r.T0();
            if (fVar.f20982a) {
                showNetRefreshView(this.r.l0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.f20985d, Integer.valueOf(fVar.f20984c)}), true);
            } else {
                showNetRefreshView(this.r.X().k(), fVar.f20985d, true);
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (this.mFlag == 0) {
                this.r.C1(this.mForum);
            } else {
                this.r.C1("");
                this.mFlag = 1;
            }
            this.r.y1(this.q1);
            this.r.I(this.m1);
            this.r.z1(this.o1);
            this.r.W().m(this.n1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f50826g : invokeV.booleanValue;
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

    public final void j1(c.a.r0.k3.f fVar, List<RecmForumInfo> list) {
        c.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048663, this, fVar, list) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.T0();
        this.r.C1(this.mForum);
        if (this.r.X() != null) {
            showForbidViewNoClick(this.r.l0(), fVar.f20985d, true, list);
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
        if (this.v.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (c.a.e.e.p.k.isEmpty(privateForumPopInfoData.y()) || privateForumPopInfoData.x() != Integer.valueOf(this.forumId))) {
            privateForumPopInfoData.D(FrsPrivateCommonDialogView.DIALOG_TYPE_CREATE_SUCCESS);
            privateForumPopInfoData.B(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
            privateForumPopInfoData.E("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.mForum + "&nomenu=1");
            privateForumPopInfoData.C(Integer.valueOf(this.forumId));
            configPrivateDialog = frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData);
        } else {
            configPrivateDialog = privateForumPopInfoData.x() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.configPrivateDialog(privateForumPopInfoData) : false;
        }
        if (configPrivateDialog) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
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
                    this.r.H1(this.v.getForum().getYuleData().b());
                    return;
                }
                this.r.s0();
                return;
            }
            this.r.s0();
        }
    }

    public void likeCallBack(Object obj) {
        c.a.r0.x0.f2.b bVar;
        c.a.e.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.f26817j) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // c.a.r0.x0.f2.l
    public void loadMore() {
        c.a.r0.x0.f2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.i(this.mForum, this.forumId, this.v);
    }

    public void logStatisticByKey(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            c.a.r0.j3.c.g().h(getUniqueId(), z2);
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || c.a.e.e.p.k.isEmpty(this.forumId)) {
            return;
        }
        c.a.q0.a.d.y().O(c.a.q0.a.c.X, c.a.e.e.m.b.g(this.forumId, 0L));
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
            this.m = new c.a.r0.k3.i0.f("frs", c.a.r0.k3.i0.f.f21032c);
            if (this.F == null) {
                FrsModelController frsModelController = new FrsModelController(this, this.mForumModelCallback);
                this.F = frsModelController;
                frsModelController.t(this.M0);
                this.F.init();
            }
            this.F.P0(this.w);
            ArrayList<c.a.e.l.e.n> arrayList = null;
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
            this.V = new c.a.r0.x0.p(getPageContext(), this);
            initUI();
            R0(bundle);
            if (!isFromMainTab()) {
                c.a.r0.x0.u0 u0Var = new c.a.r0.x0.u0(getActivity(), this.r, this.G);
                this.L = u0Var;
                u0Var.i(true);
            }
            VoiceManager voiceManager = getVoiceManager();
            this.p = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.j0) {
                int k2 = c.a.q0.s.d0.b.j().k("key_forum_broadcast_edit_tip_number", 0);
                if (k2 < 2) {
                    c.a.q0.s.d0.b.j().v("key_forum_broadcast_edit_tip_number", k2 + 1);
                    b1();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        c1();
                    } else {
                        new BdTopToast(getContext()).setIcon(false).setContent(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).show(this.r.l0());
                    }
                } else {
                    c1();
                }
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.j0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.canDrawOverlays(getContext())) {
                        d1();
                    } else if (Build.VERSION.SDK_INT < 23 || !c.a.q0.s.d0.b.j().g("key_forum_rule_dialog_show_frs", false)) {
                        d1();
                        c.a.q0.s.d0.b.j().t("key_forum_rule_dialog_show_frs", true);
                    }
                } else {
                    d1();
                }
            }
            if (c.a.q0.y.d.h().k()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                OvalActionButton ovalActionButton = this.s;
                if (ovalActionButton != null) {
                    ovalActionButton.setVisibility(8);
                }
            }
            new c.a.r0.x0.f2.i();
            int i2 = -1;
            c.a.r0.x0.f2.c cVar = this.R;
            if (cVar != null && cVar.f() != null) {
                i2 = this.R.f().A();
                arrayList = this.R.f().z();
            }
            c.a.r0.x0.f2.c cVar2 = new c.a.r0.x0.f2.c(this, this.k1);
            this.R = cVar2;
            cVar2.f().setHasMore(i2);
            if (arrayList != null && arrayList.size() > 0) {
                this.R.f().J(arrayList);
            }
            this.J = new c.a.r0.x0.i2.a(this);
            this.S = new c.a.r0.x0.o2.j(this);
            this.P = new c.a.r0.x0.o2.a(getPageContext(), this.F.p0());
            this.K = new c.a.r0.x0.f2.b(this);
            this.Q = new c.a.r0.x0.f2.d(this);
            this.I = new c.a.r0.x0.f2.h(this);
            this.T = new c.a.r0.x0.f2.a(this);
            this.mEnterFrsDialogController = new c.a.r0.x0.o2.c(this);
            new c.a.r0.x0.f2.e(this, getUniqueId());
            this.a0 = new c.a.r0.j.a(getPageContext(), "frs");
            this.b0 = new c.a.r0.w.c(getPageContext());
            new c.a.r0.x0.j2.c.a(getPageContext());
            registerListener(this.V0);
            registerListener(this.i1);
            registerListener(this.T0);
            registerListener(this.l1);
            registerListener(this.h1);
            registerListener(this.P0);
            registerListener(this.Q0);
            registerListener(this.R0);
            registerListener(this.S0);
            registerListener(this.F0);
            registerListener(this.G0);
            registerListener(this.H0);
            registerListener(this.I0);
            registerListener(this.s1);
            registerListener(this.X0);
            this.Y0.setSelfListener(true);
            this.Y0.setTag(getPageContext().getUniqueId());
            registerListener(this.Y0);
            registerListener(this.L0);
            registerListener(this.Z0);
            registerListener(this.W0);
            registerListener(this.c1);
            registerListener(this.d1);
            registerListener(this.e1);
            this.t1.setTag(getPageContext().getUniqueId());
            MessageManager.getInstance().registerListener(this.t1);
            registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.K0);
            registerListener(this.x1);
            registerListener(this.a1);
            registerListener(this.J0);
            registerListener(this.y1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.f1);
            registerListener(this.g1);
            this.r.u0(false);
            if (!isFromMainTab() && !this.j0) {
                showLoadingView(this.r.l0(), true);
                this.F.P(3, false);
            }
            d0 d0Var = new d0(this);
            c.a.r0.x0.b.f().s(d0Var);
            c.a.r0.x0.a.h().s(d0Var);
            this.r.w1(new e0(this));
            this.p0 = UtilHelper.getScreenHeight(getActivity());
            this.j0 = true;
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
            c.a.r0.x0.f2.a aVar = this.T;
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
                this.r.L0(i2);
                this.G.L(i2);
                this.H.T(i2);
                FRSRefreshButton fRSRefreshButton = this.t;
                if (fRSRefreshButton != null) {
                    fRSRefreshButton.onChangeSkinType(i2);
                }
                c.a.r0.x0.r2.a aVar = this.W;
                if (aVar != null) {
                    aVar.onChangeSkinType();
                }
                c.a.r0.x0.j1.a.a aVar2 = this.c0;
                if (aVar2 != null) {
                    aVar2.d(getPageContext(), i2);
                }
                if (this.i0 != null) {
                    c.a.q0.w0.a.a(getPageContext(), this.i0.getRealView());
                }
                c.a.r0.x0.o2.e eVar = this.X;
                if (eVar != null) {
                    eVar.onChangeSkinType(getPageContext(), i2);
                }
                c.a.r0.x0.g1.f fVar = this.B0;
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
            c.a.r0.j3.c.g().i(getUniqueId());
            if (this.x0 == null) {
                this.x0 = new TiePlusEventController(requireContext(), TiePlusStat.Locate.FRS);
            }
            getLifecycle().addObserver(this.x0);
            registerResponsedEventListener(TopToastEvent.class, this.b1);
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
                this.q = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
                c.a.r0.x0.n1.a aVar = new c.a.r0.x0.n1.a();
                this.f50825f = aVar;
                this.O = aVar.c();
                this.f50824e = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
                this.G = new c.a.r0.x0.o2.h(this, this.f50825f, (FrsHeaderViewContainer) this.q.findViewById(R.id.header_view_container));
                FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.q);
                this.H = frsTabViewController;
                frsTabViewController.Y();
                this.G.m0(this.H);
                this.H.c0(this.N0);
                Intent intent = getActivity().getIntent();
                if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                    this.f50826g = true;
                }
                this.r = new c.a.r0.x0.q(this, this.mCommenOnClickListener, this.f50825f, this.f50826g, this.G);
                this.c0 = new c.a.r0.x0.j1.a.a(getPageContext(), this.q);
            } else {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.q.getParent()).removeView(this.q);
                }
                FrsTabViewController frsTabViewController2 = this.H;
                if (frsTabViewController2 != null) {
                    frsTabViewController2.Y();
                }
                this.r.V0();
                this.q.setLeft(0);
                this.q.setRight(c.a.e.e.p.l.k(TbadkCoreApplication.getInst().getContext()));
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
            c.a.r0.j3.c.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.s1);
            MessageManager.getInstance().unRegisterListener(this.Y0);
            unRegisterResponsedEventListener();
            this.S.Z();
            cacheData = null;
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.r0.z2.l0.a.c("FRS");
            this.p = null;
            c.a.r0.b0.u.b().e(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null) {
                c.a.r0.x0.g0.a().b(c.a.e.e.m.b.g(this.v.getForum().getId(), 0L));
            }
            c.a.r0.x0.d2.a aVar = this.U;
            if (aVar != null) {
                aVar.v();
            }
            c.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                c.a.r0.x0.n2.l.b(qVar, this.v, getForumId(), false, null);
                this.r.M0();
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
                c.a.e.e.m.e.a().removeCallbacks(this.u0);
            }
            this.s0 = null;
            super.onDestroy();
            try {
                if (this.perfFluencyLogData != null) {
                    this.perfFluencyLogData.c();
                }
                if (this.r != null) {
                    this.r.Y0();
                }
                System.gc();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            this.G.J();
            Looper.myQueue().removeIdleHandler(this.E0);
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.g();
            }
            c.a.r0.x0.u0 u0Var = this.L;
            if (u0Var != null) {
                u0Var.d();
            }
            c.a.r0.x0.o2.a aVar2 = this.P;
            if (aVar2 != null) {
                aVar2.i();
            }
            c.a.r0.x0.i2.a aVar3 = this.J;
            if (aVar3 != null) {
                aVar3.c();
            }
            c.a.r0.x0.o2.e eVar = this.X;
            if (eVar != null) {
                eVar.g();
            }
            c.a.r0.x0.f2.a aVar4 = this.T;
            if (aVar4 != null) {
                aVar4.n();
            }
            c.a.r0.j.a aVar5 = this.a0;
            if (aVar5 != null) {
                aVar5.h();
            }
            c.a.r0.w.c cVar = this.b0;
            if (cVar != null) {
                cVar.g();
            }
            c.a.r0.z2.j0.a.e().g();
            c.a.r0.x0.n2.n.a();
            FrsTabViewController frsTabViewController = this.H;
            if (frsTabViewController != null) {
                frsTabViewController.c0(null);
                this.H.L();
            }
            AddExperiencedModel addExperiencedModel = this.k0;
            if (addExperiencedModel != null) {
                addExperiencedModel.onDestroy();
            }
            c.a.r0.x0.b.f().s(null);
            c.a.r0.x0.a.h().s(null);
            c.a.r0.x0.n2.e eVar2 = this.A0;
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
            g1();
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.e.l.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? getListView().getPreLoadHandle() : (c.a.e.l.e.q) invokeV.objValue;
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
            } else if (c.a.r0.x0.b.f().i()) {
                c.a.r0.x0.b.f().m();
                return true;
            } else if (c.a.r0.x0.a.h().j()) {
                c.a.r0.x0.q qVar = this.r;
                if (qVar != null && qVar.D0()) {
                    this.r.Z0();
                    return true;
                }
                c.a.r0.x0.a.h().n();
                return true;
            } else {
                c.a.r0.x0.q qVar2 = this.r;
                if (qVar2 != null) {
                    return qVar2.N0();
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
            showLoadingView(this.r.l0(), true);
            this.r.x1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.F.G0(3, true);
            getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && c.a.e.e.p.l.D()) {
            hideNetRefreshView(this.r.X().k());
            showLoadingView(this.r.l0(), true);
            this.r.u0(false);
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
        this.f50828i = booleanExtra;
        if (booleanExtra) {
            N0();
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && isAdded() && this.N && isLoadingViewAttached()) {
            hideLoadingView(this.r.l0());
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && isAdded() && this.N && !isLoadingViewAttached()) {
            showLoadingView(this.r.l0(), true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            super.onPause();
            this.I.f(false);
            this.A = false;
            this.r.O0();
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.r.I0(true);
            c.a.r0.x0.o2.a aVar = this.P;
            if (aVar != null) {
                aVar.j();
            }
            c.a.q0.a.d.y().E();
            c.a.r0.x0.n2.e eVar = this.A0;
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
                c.a.r0.x0.o2.h hVar = this.G;
                if (hVar != null) {
                    hVar.N(isPrimary());
                }
                c.a.r0.x0.q qVar = this.r;
                if (qVar != null) {
                    qVar.P0(isPrimary());
                    this.r.I0(!isPrimary());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048687, this, i2, strArr, iArr) == null) {
            c.a.r0.x0.n2.m.h(this, i2, strArr, iArr);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            super.onResume();
            c.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                qVar.H0();
                this.r.Q0();
            }
            this.I.f(true);
            this.A = true;
            if (isNeedRefreshOnBackFromBarDetail) {
                isNeedRefreshOnBackFromBarDetail = false;
                c.a.r0.x0.q qVar2 = this.r;
                if (qVar2 != null) {
                    qVar2.R1();
                    return;
                }
                return;
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
            c.a.r0.x0.q qVar3 = this.r;
            if (qVar3 != null) {
                qVar3.I0(false);
            }
            if (this.Y) {
                refresh(6);
                this.Y = false;
            }
            if (this.o0 != null && getActivity() != null) {
                if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                    c.a.q0.t.d.f.c().h(true);
                    c.a.q0.t.d.f.c().i(this.o0.getHours(), this.o0.getMinutes());
                    if (this.r != null) {
                        c.a.q0.t.d.f.c().k(getTbPageContext().getPageActivity(), this.r.l0());
                    }
                }
                this.o0 = null;
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
            this.r.b0().stopScroll();
            if (this.r.a1()) {
                return;
            }
            if (!c.a.e.e.p.l.D()) {
                this.r.t0();
            } else if (this.F.b0() == 1) {
                g1();
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
        this.r.H0();
        c.a.r0.k3.f S = this.F.S();
        boolean isEmpty = ListUtils.isEmpty(this.v.getThreadList());
        if (S != null && isEmpty) {
            if (this.F.V() != 0) {
                this.F.O0();
                this.r.H0();
            } else {
                f1(S);
            }
            this.r.j1(this.v.isStarForum(), false);
            return;
        }
        f1(S);
    }

    public void onShareSuccess(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, str) == null) && TbadkCoreApplication.isLogin() && !c.a.e.e.p.k.isEmpty(str)) {
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
            c.a.r0.b0.u.b().e(false);
            logStatisticByKey(false);
            FrsViewData frsViewData = this.v;
            if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
                c.a.q0.v.a.k().y(getPageContext().getPageActivity(), "frs", this.v.getForum().getId(), 0L);
            }
            VoiceManager voiceManager = this.p;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            if (getListView() != null) {
                getListView().getRecycledViewPool().clear();
            }
            this.G.K();
            c.a.q0.d1.f0.c();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onSuccess(ArrayList<c.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, arrayList) == null) {
            boolean isEmpty = ListUtils.isEmpty(arrayList);
            setHasMore(!isEmpty ? 1 : 0);
            g1();
            if (isEmpty) {
                return;
            }
            if (!this.F.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.F.b0() == 1 && !c.a.r0.z0.a.d()) {
                this.v.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.F != null) {
                c.a.r0.x0.k2.a.h(getUniqueId(), arrayList, this.v.getForum(), this.F.a0());
            }
            ArrayList<c.a.e.l.e.n> c2 = this.R.c(false, false, arrayList, this.m, false);
            if (c2 != null) {
                this.v.setThreadList(c2);
                this.r.B1(c2, this.v);
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                c.a.r0.x0.k2.c.l(this.v, frsModelController.R(), 2, getContext());
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
            c.a.r0.p.d.c().f("page_frs");
            refresh(3);
        }
    }

    public boolean refreshHeader() {
        InterceptResult invokeV;
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            c.a.r0.x0.o2.h hVar = this.G;
            if (hVar != null && (frsModelController = this.F) != null) {
                hVar.p0(frsModelController.Z(), this.v);
            }
            FrsViewData frsViewData = this.v;
            boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
            E0();
            c.a.r0.x0.q qVar = this.r;
            if (qVar != null) {
                qVar.x0();
                this.r.y0();
                FrsViewData frsViewData2 = this.v;
                if (frsViewData2 != null && frsViewData2.getActivityHeadData() != null) {
                    this.r.w0(this.v.getActivityHeadData().a());
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

    @Override // c.a.r0.x0.n0
    public void refreshPage() {
        c.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.b0().scrollToPosition(0);
        this.r.R1();
    }

    public void requestLoadLiveTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            if (this.U == null) {
                this.U = new c.a.r0.x0.d2.a(this, c.a.e.e.m.b.e(this.forumId, 0));
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
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || (frsTabViewController = this.H) == null || (z2 = frsTabViewController.z()) == null || (fragment = z2.f51682b) == null || !(fragment instanceof c.a.r0.x0.p0)) {
            return;
        }
        ((c.a.r0.x0.p0) fragment).scrollToTop();
    }

    public void setCanShowSpeedTipView(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z2) == null) {
            this.f50827h = z2;
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
        c.a.r0.x0.f2.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048710, this, i2) == null) || (cVar = this.R) == null) {
            return;
        }
        cVar.m(i2);
    }

    public void setHeaderPrivateText(Integer num, Integer num2, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048711, this, num, num2, z2) == null) || this.r.j0() == null) {
            return;
        }
        TextView j02 = this.r.j0();
        if (z2) {
            j02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            j02.setText("修改实名认证信息");
            j02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            j02.setText("目标已完成" + String.valueOf(num2) + "%");
            j02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.mForum + "&nomenu=1";
            i2 = 1;
        } else {
            j02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        j02.setOnClickListener(new y(this, i2, str));
    }

    @Override // c.a.r0.g.e.b
    public void setInjectPlugin(int i2, c.a.r0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048712, this, i2, aVar) == null) {
            this.M.put(i2, aVar);
        }
    }

    public void setIsLiveTab(boolean z2) {
        c.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048713, this, z2) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.m1(z2);
    }

    public void setIsThreadTab(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) {
            this.B = z2;
        }
    }

    public void setListPullToRefresh(boolean z2) {
        c.a.r0.x0.o2.j jVar;
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
        c.a.r0.x0.k2.b bVar = new c.a.r0.x0.k2.b();
        if (this.v.needLog == 1) {
            bVar.f27134a = true;
        } else {
            bVar.f27134a = false;
        }
        if (this.v.getForum() != null) {
            bVar.f27136c = this.v.getForum().getId();
        }
        if (getModelController() != null) {
            bVar.f27135b = getModelController().R();
        }
        c.a.r0.x0.k2.b bVar2 = c.a.r0.x0.k2.d.h0;
        if (bVar2 != null) {
            bVar.f27137d = bVar2.f27137d;
            bVar.f27138e = bVar2.f27138e;
        }
        c.a.r0.x0.d2.b bVar3 = new c.a.r0.x0.d2.b(bVar, getTbPageTag(), getUniqueId());
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
        c.a.r0.x0.u0 u0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) || (u0Var = this.L) == null) {
            return;
        }
        u0Var.i(z2);
    }

    public void setPn(int i2) {
        c.a.r0.x0.f2.c cVar;
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
            if (frsTabViewController == null || frsTabViewController.z() == null || !(this.H.z().f51682b instanceof BaseFragment)) {
                return;
            }
            ((BaseFragment) this.H.z().f51682b).setPrimary(z2);
        }
    }

    public void setShowAdFlag(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) && this.C1 == null) {
            c.a.r0.z0.a a2 = c.a.r0.z0.a.a(z2);
            this.C1 = a2;
            c.a.r0.x0.f2.c cVar = this.R;
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
            this.r.T0();
            this.r.h1(8);
            if (this.W == null) {
                this.W = new c.a.r0.x0.r2.a(getPageContext(), getNetRefreshListener());
            }
            this.W.c(str);
            this.W.b(list);
            this.W.attachView(view, z2);
        }
    }

    public void showFrsAdvancedAdGuide() {
        c.a.r0.x0.q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048728, this) == null) || (qVar = this.r) == null) {
            return;
        }
        qVar.E1();
    }

    public void showFrsDeleteThreadTip(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048729, this, str, str2, str3) == null) {
            c.a.r0.x0.n2.e eVar = new c.a.r0.x0.n2.e(str, str2);
            this.A0 = eVar;
            eVar.f(getFragmentActivity(), str3, str2);
        }
    }

    public void showLoadFinishedUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            hideLoadingView(this.r.l0());
            this.r.T1();
            if (this.r.k0() instanceof c.a.r0.x0.l2.d) {
                ((c.a.r0.x0.l2.d) this.r.k0()).d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048731, this, view, z2) == null) {
            this.r.h1(8);
            ((FrsActivity) getActivity()).showLoadingView(view, z2);
            ((FrsActivity) getActivity()).updateLoadingViewState(view, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048732, this, view, str, z2) == null) {
            super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z2, getNetRefreshListener());
            this.r.h1(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048733, this, view, str, z2) == null) {
            super.showNetRefreshViewNoClick(view, str, z2);
            this.r.h1(8);
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
            new BdTopToast(getContext(), 3000).setIcon(true).setContent(str).show(this.r.l0());
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
        c.a.r0.x0.f2.b bVar;
        c.a.e.a.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, obj) == null) || (bVar = this.K) == null || (eVar = bVar.f26816i) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // c.a.r0.z2.u
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
                return c.a.q0.d1.s0.a(2) || (c.a.q0.d1.s0.e() && frsViewData.isFrsVideoAutoPlay);
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
                    c.a.r0.x0.n2.n.b(this, 0);
                } else {
                    this.r.N1();
                }
            }
        }
    }

    public boolean canShowWriteButton(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            if (this.B && !this.n0 && G0(i2)) {
                FrsModelController frsModelController = this.F;
                return (frsModelController != null && frsModelController.U() && (c.a.r0.x0.b.f().i() || c.a.r0.x0.a.h().j())) ? false : true;
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
            c.a.r0.x0.q qVar = this.r;
            if (qVar == null) {
                return null;
            }
            return qVar.b0();
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
            c.a.r0.x0.q qVar = this.r;
            if (qVar != null && qVar.i0() != null) {
                this.r.i0().w();
            }
            FrsModelController frsModelController = this.F;
            if (frsModelController != null) {
                frsModelController.G0(i2, true);
            }
        }
    }
}
