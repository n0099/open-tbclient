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
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
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
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
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
import d.b.i.u0.a;
import d.b.i0.a.f;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.i0.r.s.a;
import d.b.j0.h.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, d.b.j0.q0.d2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, d.b.j0.q0.u0, d.b.j0.s2.t, d.b.j0.q0.e2.l, d.b.j0.e.e.b, d.b.j0.q0.o0, d.b.j0.q0.r0 {
    public static boolean U1 = false;
    public static d.b.j0.d3.m V1;
    public static volatile long W1;
    public static volatile long X1;
    public static volatile int Y1;
    public LinearLayout A;
    public boolean B0;
    public String D;
    public d.b.c.e.k.b<TbImageView> E;
    public long G;
    public List<LiveHorseRaceData> M0;
    public ValueAnimator N0;
    public boolean O;
    public Runnable O0;
    public d.b.j0.q0.c2.b Q0;
    public d.b.j0.q0.k1.a R0;
    public int S0;
    public String T;
    public d.b.j0.q0.n2.e T0;
    public d.b.j0.s0.a T1;
    public ThreadCardViewHolder V;
    public FrsModelController W;
    public d.b.j0.q0.o2.h X;
    public FrsTabViewController Y;
    public d.b.j0.q0.e2.h Z;
    public d.b.j0.q0.h2.a a0;
    public d.b.j0.q0.e2.b b0;
    public d.b.j0.q0.v0 c0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q0.n1.a f15641f;
    public d.b.j0.q0.n1.e.b f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15642g;
    public d.b.j0.q0.o2.a g0;
    public d.b.j0.q0.e2.d h0;
    public d.b.j0.q0.e2.c i0;
    public d.b.j0.q0.o2.j j0;
    public d.b.j0.q0.e2.a k0;
    public d.b.j0.q0.c2.a l0;
    public d.b.j0.q0.q m0;
    public d.b.j0.q0.o2.c n0;
    public d.b.i0.z0.a0 o0;
    public View.OnTouchListener p0;
    public d.b.j0.q0.r2.a q0;
    public d.b.j0.q0.o2.e r0;
    public d.b.j0.d3.h0.f s;
    public boolean s0;
    public d.b.j0.q0.x1.b t0;
    public d.b.j0.h.a u0;
    public VoiceManager v;
    public d.b.j0.t.a v0;
    public View w;
    public d.b.j0.q0.j1.a.a w0;
    public d.b.i0.r.s.a x0;
    public OvalActionButton y;
    public FRSRefreshButton z;
    public AddExperiencedModel z0;

    /* renamed from: e  reason: collision with root package name */
    public String f15640e = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f15643h = false;
    public boolean i = true;
    public String j = null;
    public String k = null;
    public int l = 0;
    public boolean m = false;
    public boolean n = false;
    public String o = null;
    public String p = null;
    public int q = 0;
    public boolean r = false;
    public boolean t = false;
    public boolean u = false;
    public d.b.j0.q0.r x = null;
    public final a2 B = null;
    public FrsViewData C = new FrsViewData();
    public long F = -1;
    public long H = 0;
    public long I = 0;
    public long J = 0;
    public long K = 0;
    public long L = 0;
    public long M = 0;
    public boolean N = false;
    public boolean P = false;
    public d.b.i0.m0.b Q = null;
    public boolean R = true;
    public boolean S = true;
    public a.C1072a U = new a.C1072a(2);
    public SparseArray<d.b.j0.e.e.a> d0 = new SparseArray<>();
    public boolean e0 = true;
    public boolean y0 = false;
    public boolean A0 = false;
    public boolean C0 = false;
    public Date D0 = null;
    public int E0 = 0;
    public int K0 = 0;
    public int L0 = 0;
    public int P0 = -1;
    public MessageQueue.IdleHandler U0 = new k();
    public final CustomMessageListener V0 = new v(2016495);
    public CustomMessageListener W0 = new g0(2921005);
    public CustomMessageListener X0 = new r0(2921401);
    public CustomMessageListener Y0 = new c1(2921473);
    public CustomMessageListener Z0 = new k1(2921467);
    public d.b.c.c.g.a a1 = new l1(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
    public CustomMessageListener b1 = new m1(2001624);
    public final d.b.j0.q0.t0 c1 = new n1();
    public FrsTabViewController.n d1 = new a();
    public CustomMessageListener f1 = new b(2001606);
    public CustomMessageListener g1 = new c(2001607);
    public final CustomMessageListener h1 = new d(2003019);
    public final CustomMessageListener i1 = new e(2921470);
    public final CustomMessageListener j1 = new f(2001352);
    public final AntiHelper.k k1 = new g();
    public CustomMessageListener l1 = new h(2001115);
    public CustomMessageListener m1 = new i(2921346);
    public CustomMessageListener n1 = new j(2001374);
    public CustomMessageListener o1 = new l(2001378);
    public CustomMessageListener p1 = new m(2001626);
    public HttpMessageListener q1 = new n(CmdConfigHttp.CMD_FRS_MOVE_AREA);
    public d.b.i0.f0.i r1 = new o();
    public final CustomMessageListener s1 = new p(2921391);
    public CustomMessageListener t1 = new q(2003020);
    public final CustomMessageListener u1 = new r(2921463);
    public final d.b.j0.d3.s v1 = new s();
    public final CustomMessageListener w1 = new z(2016485);
    public final CustomMessageListener x1 = new a0(2001194);
    public final f.b y1 = new d0();
    public final d.b.j0.q0.e2.k z1 = new e0();
    public final View.OnTouchListener A1 = new f0();
    public final CustomMessageListener B1 = new h0(2004507);
    public final View.OnClickListener C1 = new n0();
    public final RecyclerView.OnScrollListener D1 = new o0();
    public final d.b.j0.q0.f E1 = new p0();
    public final NoNetworkView.b F1 = new q0();
    public final CustomMessageListener G1 = new s0(0);
    public d.b.c.j.e.w H1 = new o1(this, null);
    public d.b.j0.q0.t0 I1 = new u0();
    public CustomMessageListener J1 = new v0(2921033);
    public CustomMessageListener K1 = new w0(2921381);
    public CustomMessageListener L1 = new x0(2921414);
    public CustomMessageListener M1 = new y0(2921437);
    public CustomMessageListener N1 = new e1(2921462);
    public CustomMessageListener O1 = new f1(2001223);
    public CustomMessageListener P1 = new g1(2921469);
    public CustomMessageListener Q1 = new h1(2921475);
    public HttpMessageListener R1 = new i1(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
    public CustomMessageListener S1 = new j1(2921515);

    /* loaded from: classes4.dex */
    public class a implements FrsTabViewController.n {
        public a() {
        }

        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.n
        public void a(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                d.b.j0.x.t.b().e(false);
                FrsFragment.this.Q2(false);
            }
            if (i == 502) {
                FrsFragment.this.y.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.y.setIconFade(0);
            }
            FrsFragment.this.e1 = i;
            FrsFragment.this.S0 = i2;
            if (FrsFragment.this.Q0 != null) {
                FrsFragment.this.Q0.d(FrsFragment.this.S0);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.S0);
            FrsFragment.this.N3();
            d.b.j0.q0.j2.b bVar = d.b.j0.q0.j2.d.J0;
            bVar.f59823d = i;
            bVar.f59826g = i2;
            bVar.f59824e = -1;
            d.b.j0.q0.b.e().m(i == 1 && FrsFragment.this.A0, true);
            d.b.j0.q0.a h2 = d.b.j0.q0.a.h();
            if (i == 1 && FrsFragment.this.A0) {
                z = true;
            }
            h2.p(z, true);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public a0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null || FrsFragment.this.C == null || (userData = FrsFragment.this.C.getUserData()) == null) {
                return;
            }
            userData.setIsMem(num.intValue());
            if (num.intValue() != 0) {
                FrsFragment.this.X.Q(num);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15646e;

        public a1(FrsRedpackRunView frsRedpackRunView) {
            this.f15646e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                this.f15646e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15646e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            FrsFragment.this.Y.e0(((Integer) customResponsedMessage.getData()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements d.b.j0.q0.x0 {
        public b0() {
        }

        @Override // d.b.j0.q0.x0
        public void a(int i) {
            if (FrsFragment.this.getContext() == null) {
                return;
            }
            if (i != 1) {
                if (i != 2 || FrsFragment.this.x == null) {
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
                bdTopToast.i(false);
                bdTopToast.h(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num));
                bdTopToast.j(FrsFragment.this.x.j0());
                return;
            }
            d.b.c.e.p.l.K(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
        }

        @Override // d.b.j0.q0.x0
        public void b(boolean z, boolean z2, int i) {
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i == 1) {
                FrsFragment.this.x.p1(z ? 0 : 8);
            } else if (i == 2) {
                FrsFragment.this.x.m1(z ? 0 : 8);
            }
            if (!z2) {
                FrsFragment.this.A0 = z;
            }
            if (FrsFragment.this.x.U() != null && (i == 2 || (FrsFragment.this.W != null && FrsFragment.this.W.Q()))) {
                FrsFragment.this.x.U().notifyDataSetChanged();
            }
            if (FrsFragment.this.z2() != null) {
                FrsTabViewController.o y = FrsFragment.this.z2().y();
                if (y != null) {
                    if ((y.f16323b instanceof FrsCommonTabFragment) && (i == 2 || y.f16322a == 502)) {
                        ((FrsCommonTabFragment) y.f16323b).Y0();
                    } else if ((y.f16323b instanceof FrsNewAreaFragment) && (i == 2 || y.f16322a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) y.f16323b;
                        frsNewAreaFragment.y1();
                        if (frsNewAreaFragment.j1() != null) {
                            d.b.j0.q0.e2.g j1 = frsNewAreaFragment.j1();
                            j1.G(!z);
                            if (i == 1) {
                                j1.D(!z);
                            } else if (i == 2) {
                                j1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = y.f16323b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).t1();
                        }
                    }
                }
                if (FrsFragment.this.z2().I() != null) {
                    FrsFragment.this.z2().I().setmDisallowSlip(z);
                    FrsFragment.this.z2().b0(z);
                }
            }
            if (FrsFragment.this.x.W() != null) {
                FrsFragment.this.x.J1(!z);
            }
            if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                ((FrsActivity) FrsFragment.this.getActivity()).showTabHost(!z);
            }
            if (FrsFragment.this.w0 != null) {
                FrsFragment.this.w0.f(!z);
            }
            FrsFragment.this.x.u1(!z);
            if (i == 1) {
                FrsFragment.this.x.l1(!z);
            } else if (i == 2) {
                FrsFragment.this.x.l1(true);
            }
        }

        @Override // d.b.j0.q0.x0
        public void c(int i, int i2) {
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i2 == 1) {
                FrsFragment.this.x.o1(i);
            } else if (i2 == 2) {
                FrsFragment.this.x.n1(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15650e;

        public b1(FrsRedpackRunView frsRedpackRunView) {
            this.f15650e = frsRedpackRunView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15650e.setAlpha(0.0f);
            this.f15650e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
            this.f15650e.c();
            FrsFragment.this.A.removeView(this.f15650e);
            if (FrsFragment.this.M0 == null || FrsFragment.this.L0 <= FrsFragment.this.M0.size() - 1) {
                FrsFragment.this.H2();
                return;
            }
            FrsFragment.this.A.removeAllViews();
            FrsFragment.this.A.setVisibility(8);
            FrsFragment.this.L0 = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || FrsFragment.this.C == null) {
                return;
            }
            d.b.j0.q0.n2.n.d(FrsFragment.this.C, FrsFragment.this.getPageContext());
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements e.c {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(c0 c0Var) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(c0 c0Var) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }

        public c0() {
        }

        @Override // d.b.j0.h.e.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            if (deleteThreadHttpResponseMessage == null) {
                return;
            }
            FrsFragment.this.x.P();
            FrsFragment.this.x.O();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i = 0;
            if (FrsFragment.this.Y == null || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f16323b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.Y.y().f16323b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (FrsFragment.this.x0 == null) {
                        FrsFragment frsFragment = FrsFragment.this;
                        frsFragment.x0 = new d.b.i0.r.s.a(frsFragment.getActivity());
                    }
                    FrsFragment.this.x0.setMessage(text);
                    FrsFragment.this.x0.setPositiveButton(R.string.dialog_known, new a(this));
                    FrsFragment.this.x0.setCanceledOnTouchOutside(false);
                    FrsFragment.this.x0.create(FrsFragment.this.getPageContext());
                    FrsFragment.this.x0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (FrsFragment.this.x0 == null) {
                        FrsFragment frsFragment2 = FrsFragment.this;
                        frsFragment2.x0 = new d.b.i0.r.s.a(frsFragment2.getActivity());
                    }
                    FrsFragment.this.x0.setMessage(text);
                    FrsFragment.this.x0.setPositiveButton(R.string.know, new b(this));
                    FrsFragment.this.x0.setCanceledOnTouchOutside(false);
                    FrsFragment.this.x0.create(FrsFragment.this.getPageContext());
                    FrsFragment.this.x0.show();
                } else {
                    FrsFragment.this.x.E1(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                }
                if (z && frsNewAreaFragment != null) {
                    frsNewAreaFragment.u1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                FrsFragment.this.i2(deleteThreadHttpResponseMessage.getSuccessItems());
                d.b.j0.q0.b.e().i(deleteThreadHttpResponseMessage.getSuccessItems());
                for (d.b.c.j.e.n nVar : FrsFragment.this.C.getThreadList()) {
                    if (nVar instanceof z1) {
                        i++;
                        continue;
                    }
                    if (i >= 6) {
                        break;
                    }
                }
                if (i < 6) {
                    FrsFragment.this.loadMore();
                    return;
                }
                return;
            }
            d.b.c.e.p.l.L(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public class c1 extends CustomMessageListener {
        public c1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || FrsFragment.this.z == null || FrsFragment.this.y == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                FrsFragment.this.z.setVisibility(8);
                FrsFragment.this.y.setVisibility(8);
                return;
            }
            FrsFragment.this.y.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            FrsFragment.this.Y.c(49);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements f.b {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f15657e;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$d0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0192a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15659e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f15660f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f15661g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f15662h;
                public final /* synthetic */ int i;

                public RunnableC0192a(long j, int i, int i2, float f2, int i3) {
                    this.f15659e = j;
                    this.f15660f = i;
                    this.f15661g = i2;
                    this.f15662h = f2;
                    this.i = i3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(this.f15659e, 0L, 0L, this.f15660f, this.f15661g, this.f15662h, this.i);
                    requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
                    requestGetMyPostNetMessage.setProZone(2);
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }

            public a(HashMap hashMap) {
                this.f15657e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                FrsFragment.this.Y.c(301);
                d.b.c.e.m.e.a().postDelayed(new RunnableC0192a(d.b.c.e.m.b.f((String) this.f15657e.get(d.b.i0.a.f.o), 0L), d.b.c.e.p.l.k(TbadkCoreApplication.getInst()), d.b.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
            }
        }

        public d0() {
        }

        @Override // d.b.i0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                return;
            }
            if (hashMap.get(d.b.i0.a.f.n) instanceof String) {
                FrsFragment.this.j = (String) hashMap.get(d.b.i0.a.f.n);
            }
            if (!(hashMap.get(d.b.i0.a.f.H) instanceof String) || TextUtils.isEmpty((String) hashMap.get(d.b.i0.a.f.H))) {
                return;
            }
            d.b.c.e.m.e.a().postDelayed(new a(hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15663e;

        public d1(FrsRedpackRunView frsRedpackRunView) {
            this.f15663e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsFragment.this.A == null || this.f15663e == null) {
                return;
            }
            FrsFragment.this.N0.start();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.Y.c(1);
                FrsFragment.this.m2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements d.b.j0.q0.e2.k {
        public e0() {
        }

        @Override // d.b.j0.q0.e2.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<d.b.c.j.e.n> arrayList, boolean z3) {
            if (FrsFragment.this.a0 == null || FrsFragment.this.W == null || !FrsFragment.this.W.q0() || !z || z2 || z3) {
                return;
            }
            FrsFragment.this.a0.a(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class e1 extends CustomMessageListener {
        public e1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.C.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.p));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.d3.w) || FrsFragment.this.C == null) {
                return;
            }
            FrsFragment.this.C.updateLikeData((d.b.j0.d3.w) customResponsedMessage.getData());
            FrsFragment.this.X.T(FrsFragment.this.C);
            FrsFragment.this.Y.e(FrsFragment.this.C, FrsFragment.this.W.N());
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements View.OnTouchListener {
        public f0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.p0 != null) {
                FrsFragment.this.p0.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.c0 != null && FrsFragment.this.c0.e() != null) {
                FrsFragment.this.c0.e().c(motionEvent);
            }
            if (FrsFragment.this.t0 != null) {
                FrsFragment.this.t0.b(view, motionEvent);
            }
            if (FrsFragment.this.X != null) {
                FrsFragment.this.X.P(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f1 extends CustomMessageListener {
        public f1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Date)) {
                return;
            }
            FrsFragment.this.D0 = (Date) customResponsedMessage.getData();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AntiHelper.k {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.C != null) {
                FrsFragment.this.C.removeGameRankListFromThreadList();
                if (FrsFragment.this.x != null) {
                    FrsFragment.this.x.C0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g1 extends CustomMessageListener {
        public g1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.i0.r.q.z) && FrsFragment.this.isResumed()) {
                d.b.i0.r.q.z zVar = (d.b.i0.r.q.z) customResponsedMessage.getData();
                if (FrsFragment.this.R0 == null) {
                    FrsFragment frsFragment = FrsFragment.this;
                    frsFragment.R0 = new d.b.j0.q0.k1.a(frsFragment.getPageContext());
                }
                if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || TextUtils.isEmpty(FrsFragment.this.C.getForum().getId())) {
                    return;
                }
                FrsFragment.this.R0.g(zVar.f51687a, FrsFragment.this.C.getForum().getId(), FrsFragment.this.C.getForum().getName(), zVar.f51688b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f13364c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().k != null) {
                    if (AntiHelper.t(FrsFragment.this.getActivity(), updateAttentionMessage.getData().k, FrsFragment.this.k1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f13362a && updateAttentionMessage.getData().f13365d) {
                    d.b.c.e.p.l.K(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends CustomMessageListener {
        public h0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            if (j.k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || FrsFragment.this.C.getForum() == null) {
                return;
            }
            FrsFragment.this.C.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes4.dex */
    public class h1 extends CustomMessageListener {
        public h1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var = (a2) customResponsedMessage.getData();
            if (a2Var == null || !FrsFragment.this.isResumed()) {
                return;
            }
            FrsFragment frsFragment = FrsFragment.this;
            frsFragment.T = a2Var.w1() + "";
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", a2Var.c0());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f15678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f15680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f15681h;
        public final /* synthetic */ int i;

        public i0(long j, int i, int i2, float f2, int i3) {
            this.f15678e = j;
            this.f15679f = i;
            this.f15680g = i2;
            this.f15681h = f2;
            this.i = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setParams(this.f15678e, 0L, 0L, this.f15679f, this.f15680g, this.f15681h, this.i);
            requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
            requestGetMyPostNetMessage.setHideErrorToast(true);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i1 extends HttpMessageListener {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", FrsFragment.this.C.getForum().getId());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.b.j0.d3.h0.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
            }
        }

        public i1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount > 0) {
                    ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(TbadkCoreApplication.getInst());
                    forumBroadcastHelper.jumpFlutterEditGenear(FrsFragment.this.C.getForum().getId(), FrsFragment.this.C.getForum().getName(), "6");
                    forumBroadcastHelper.clipCopy(FrsFragment.this.T);
                    forumBroadcastHelper.start();
                    return;
                }
                ScreenTopToast screenTopToast = new ScreenTopToast(FrsFragment.this.getContext());
                screenTopToast.m(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new a());
                screenTopToast.n((ViewGroup) FrsFragment.this.w.findViewById(R.id.frs));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.x.H1((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements Runnable {
        public j0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.j0.d3.n0.a.o(FrsFragment.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public class j1 extends CustomMessageListener {
        public j1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.b.j0.h.g gVar = (d.b.j0.h.g) customResponsedMessage.getData();
            if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || FrsFragment.this.C.getForum().getDeletedReasonInfo() == null) {
                d.b.j0.h.d.d(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.C.getUserData());
                return;
            }
            d.b.j0.h.h hVar = new d.b.j0.h.h(FrsFragment.this.C.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.C.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.C.forumRule != null ? FrsFragment.this.C.forumRule.has_forum_rule.intValue() : 0);
            hVar.i(FrsFragment.this.C.getForum().getId(), FrsFragment.this.C.getForum().getName());
            hVar.h(FrsFragment.this.C.getForum().getImage_url());
            hVar.j(FrsFragment.this.C.getForum().getUser_level());
            d.b.j0.h.d.d(hVar.f(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.C.getUserData());
        }
    }

    /* loaded from: classes4.dex */
    public class k implements MessageQueue.IdleHandler {
        public k() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.Z2();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f15688e;

        public k0(d.b.i0.r.s.a aVar) {
            this.f15688e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.r.s.a aVar = this.f15688e;
            if (aVar != null) {
                aVar.dismiss();
                FrsFragment.this.x3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 extends CustomMessageListener {
        public k1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || FrsFragment.this.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f16323b instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.Y.y().f16323b).isPrimary() || FrsFragment.this.x.B0()) {
                FrsFragment.this.A.setVisibility(8);
                FrsFragment.this.N = true;
                return;
            }
            FrsFragment.this.A.setVisibility(0);
            FrsFragment.this.N = false;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && StringHelper.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.p)) {
                FrsFragment.this.k0.l(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements d.b.i0.r.e {
        public l0() {
        }

        @Override // d.b.i0.r.e
        public void onPermissionResult(boolean z) {
            if (z) {
                d.b.i0.x.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (FrsFragment.this.y != null) {
                    FrsFragment.this.y.setVisibility(8);
                    return;
                }
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
            bdTopToast.i(false);
            bdTopToast.h(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint));
            bdTopToast.j(FrsFragment.this.x.j0());
        }
    }

    /* loaded from: classes4.dex */
    public class l1 extends d.b.c.c.g.a {
        public l1(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
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
                if (FrsFragment.this.M0 != null) {
                    if (FrsFragment.this.A == null || FrsFragment.this.A.getVisibility() != 8) {
                        if (FrsFragment.this.L0 >= FrsFragment.this.M0.size()) {
                            FrsFragment.this.M0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = FrsFragment.this;
                        frsFragment.M0 = frsFragment.M0.subList(0, FrsFragment.this.L0);
                        FrsFragment.this.M0.addAll(arrayList);
                        return;
                    }
                    FrsFragment.this.M0 = new ArrayList();
                    FrsFragment.this.M0.addAll(arrayList);
                    FrsFragment.this.L0 = 0;
                    FrsFragment.this.H2();
                    return;
                }
                FrsFragment.this.M0 = new ArrayList();
                FrsFragment.this.L0 = 0;
                FrsFragment.this.M0.addAll(arrayList);
                FrsFragment.this.H2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.x != null) {
                    FrsFragment.this.x.T0(msgCount, z);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements d.b.i0.r.e {
        public m0() {
        }

        @Override // d.b.i0.r.e
        public void onPermissionResult(boolean z) {
            if (z) {
                d.b.i0.x.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (FrsFragment.this.y != null) {
                    FrsFragment.this.y.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 extends CustomMessageListener {
        public m1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                FrsFragment.this.m2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends HttpMessageListener {
        public n(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || FrsFragment.this.getContext() == null || FrsFragment.this.x == null) {
                return;
            }
            int i = 0;
            if (httpResponsedMessage.getError() == 0) {
                BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
                bdTopToast.i(true);
                bdTopToast.h(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc));
                bdTopToast.j(FrsFragment.this.x.j0());
                if (d.b.j0.q0.a.h().k(d.b.j0.q0.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (FrsFragment.this.Y != null && FrsFragment.this.Y.y() != null && (FrsFragment.this.Y.y().f16323b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.Y.y().f16323b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.W0();
                    }
                    FrsFragment.this.j2();
                    d.b.j0.q0.a.h().d();
                    for (d.b.c.j.e.n nVar : FrsFragment.this.C.getThreadList()) {
                        if (nVar instanceof z1) {
                            i++;
                            continue;
                        }
                        if (i >= 6) {
                            break;
                        }
                    }
                    if (i < 6) {
                        FrsFragment.this.loadMore();
                    }
                }
                d.b.j0.q0.a.h().n();
                return;
            }
            BdTopToast bdTopToast2 = new BdTopToast(FrsFragment.this.getContext());
            bdTopToast2.i(false);
            bdTopToast2.h(httpResponsedMessage.getErrorString());
            bdTopToast2.j(FrsFragment.this.x.j0());
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements View.OnClickListener {
        public n0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.x != null && view == FrsFragment.this.x.R() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && d.b.c.e.p.l.C()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.x == null || !FrsFragment.this.x.x0()) {
                    String c2 = FrsFragment.this.C.getForum().getYuleData().b().c();
                    if (!StringUtils.isNull(c2)) {
                        d.b.i0.l.a.k(FrsFragment.this.getPageContext().getPageActivity(), c2);
                    }
                } else {
                    FrsFragment.this.x.z1();
                }
            }
            if (FrsFragment.this.x != null && view == FrsFragment.this.x.a0() && FrsFragment.this.W != null && FrsFragment.this.W.e0()) {
                FrsFragment.this.x.C1();
                FrsFragment.this.loadMore();
            }
            if (view != null && FrsFragment.this.x != null && view == FrsFragment.this.x.b0()) {
                if (!ViewHelper.checkUpIsLogin(FrsFragment.this.getContext())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
            }
            if (d.b.c.e.p.j.z()) {
                if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null) {
                    return;
                }
                if (FrsFragment.this.x != null && view == FrsFragment.this.x.o0()) {
                    if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || StringUtils.isNull(FrsFragment.this.C.getForum().getId()) || StringUtils.isNull(FrsFragment.this.C.getForum().getName())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", FrsFragment.this.C.getForum().getId()).param("obj_locate", 11));
                    d.b.j0.q0.n2.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.C, FrsFragment.this.C.getForum().getId());
                }
                if (FrsFragment.this.x == null || view != FrsFragment.this.x.n0()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12402").param("fid", FrsFragment.this.C.getForum().getId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", FrsFragment.this.C.getForum().getName()));
                if (StringUtils.isNull(FrsFragment.this.C.getForum().getName())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.C.getForum().getName(), FrsFragment.this.C.getForum().getId())));
                return;
            }
            d.b.c.e.p.l.K(FrsFragment.this.getContext().getApplicationContext(), R.string.network_not_available);
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements d.b.j0.q0.t0 {
        public n1() {
        }

        @Override // d.b.j0.q0.t0
        public void a(int i, int i2, d.b.j0.q0.c1 c1Var, ArrayList<d.b.c.j.e.n> arrayList) {
            FrsFragment.this.D3();
            if (FrsFragment.this.f0 != null) {
                FrsFragment.this.X.f0(FrsFragment.this.f0.d(i));
            }
            d.b.j0.d3.f fVar = new d.b.j0.d3.f();
            if (c1Var != null) {
                boolean z = c1Var.f59483e == 0;
                fVar.f55202b = z;
                fVar.f55203c = c1Var.f59483e;
                fVar.f55204d = c1Var.f59484f;
                if (z) {
                    if (ListUtils.isEmpty(arrayList)) {
                        FrsFragment.this.x.q0();
                    } else if (c1Var.f59485g) {
                        if (ListUtils.getCount(FrsFragment.this.C.getThreadList()) > 3) {
                            FrsFragment.this.x.C1();
                        } else {
                            FrsFragment.this.x.y1();
                        }
                    } else if (c1Var.i) {
                        FrsFragment.this.x.F1();
                    } else {
                        FrsFragment.this.x.q0();
                    }
                }
            } else {
                c1Var = new d.b.j0.q0.c1();
                c1Var.f60870c = 1;
                c1Var.f59485g = false;
                c1Var.i = false;
            }
            if (i == 1) {
                FrsFragment.this.R = true;
                FrsFragment frsFragment = FrsFragment.this;
                frsFragment.v1.a(frsFragment.W.getType(), false, fVar);
            } else {
                FrsFragment.this.C3(fVar);
                if (FrsFragment.this.W.Z() != null) {
                    FrsFragment frsFragment2 = FrsFragment.this;
                    frsFragment2.C = frsFragment2.W.Z();
                }
                FrsFragment.this.W2();
            }
            if (FrsFragment.this.I1 != null) {
                FrsFragment.this.I1.a(i, i2, c1Var, arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends d.b.i0.f0.i<TopToastEvent> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.f0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
            bdTopToast.i(topToastEvent.isSuccess());
            bdTopToast.h(topToastEvent.getContent());
            bdTopToast.j(FrsFragment.this.x.j0());
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class o0 extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f15701a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f15702b = 0;

        public o0() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.X != null) {
                FrsFragment.this.X.s0(i);
                if (i == 1) {
                    FrsFragment.this.X.A();
                }
            }
            FrsFragment frsFragment = FrsFragment.this;
            if (frsFragment.Q == null && !frsFragment.L2()) {
                FrsFragment.this.Q = new d.b.i0.m0.b();
                FrsFragment.this.Q.a(1000);
            }
            if (i == 0) {
                d.b.i0.m0.b bVar = FrsFragment.this.Q;
                if (bVar != null) {
                    bVar.e();
                }
                d.b.j0.x.t.b().e(true);
                FrsFragment.this.Q2(true);
                FrsFragment.this.x.F0(this.f15701a, this.f15702b);
            } else {
                d.b.i0.m0.b bVar2 = FrsFragment.this.Q;
                if (bVar2 != null) {
                    bVar2.d();
                }
            }
            if (FrsFragment.this.r0 != null) {
                FrsFragment.this.r0.i(recyclerView, i);
            }
            if (i == 0) {
                d.b.j0.q0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.h(), false, null);
            }
            if (FrsFragment.this.Y != null && i == 1) {
                FrsFragment.this.Y.J();
            }
            if (FrsFragment.this.V == null) {
                if (FrsFragment.this.x.g0() != null && !FrsFragment.this.x.Y() && FrsFragment.this.x.g0().j() != null && (FrsFragment.this.x.g0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment2 = FrsFragment.this;
                    frsFragment2.V = (ThreadCardViewHolder) frsFragment2.x.g0().j().getTag();
                }
            } else if (i == 0 && FrsFragment.this.x.g0() != null && !FrsFragment.this.x.Y() && FrsFragment.this.x.g0().j() != null && (FrsFragment.this.x.g0().j().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment frsFragment3 = FrsFragment.this;
                frsFragment3.V = (ThreadCardViewHolder) frsFragment3.x.g0().j().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.K0 += i2;
            if (FrsFragment.this.K0 >= FrsFragment.this.E0 * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
            if (FrsFragment.this.g0 != null) {
                FrsFragment.this.g0.j();
            }
            this.f15701a = 0;
            this.f15702b = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                this.f15701a = bdRecyclerView.getFirstVisiblePosition();
                this.f15702b = bdRecyclerView.getLastVisiblePosition();
            }
            if (FrsFragment.this.r0 != null) {
                FrsFragment.this.r0.h(recyclerView, this.f15701a, this.f15702b);
            }
            if (FrsFragment.this.C == null || FrsFragment.this.x == null || FrsFragment.this.x.U() == null) {
                return;
            }
            FrsFragment.this.x.b1(this.f15701a, this.f15702b);
            if (FrsFragment.this.V == null || FrsFragment.this.V.b() == null) {
                return;
            }
            FrsFragment.this.V.b().o(FrsFragment.this.U);
        }
    }

    /* loaded from: classes4.dex */
    public final class o1 implements d.b.c.j.e.w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15705e;

            public a(o1 o1Var, String str) {
                this.f15705e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15705e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public o1() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == d.b.j0.q0.v.f60708e) {
                if (FrsFragment.this.x != null) {
                    TiebaStatic.log(new StatisticItem("c11752").param("fid", FrsFragment.this.p).param("obj_locate", "1"));
                    FrsFragment.this.x.K1();
                }
            } else if (nVar == null || !(nVar instanceof z1)) {
            } else {
                a2 a2Var = ((z1) nVar).w;
                if (a2Var.O() == null || a2Var.O().getGroup_id() == 0 || ViewHelper.checkUpIsLogin(FrsFragment.this.getActivity())) {
                    if (a2Var.G() != 1 || ViewHelper.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (a2Var.Q() != null) {
                            if (ViewHelper.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                String a2 = a2Var.Q().a();
                                if (StringUtils.isNull(a2) || !d.b.c.e.p.l.C()) {
                                    return;
                                }
                                d.b.i0.l.a.k(FrsFragment.this.getActivity(), a2);
                            }
                        } else if (a2Var.W() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                return;
                            }
                            d.b.i0.r.q.t W = a2Var.W();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), W.a(), W.b(), 2)));
                        } else {
                            d.b.j0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.d(a2Var.o0())) {
                                readThreadHistory.a(a2Var.o0());
                            }
                            String J = a2Var.J();
                            if (J == null || J.equals("")) {
                                z = false;
                            } else {
                                new Thread(new a(this, J)).start();
                                z = true;
                            }
                            String w1 = a2Var.w1();
                            if (w1 == null) {
                                w1 = "";
                            }
                            if (a2Var.x0() == 2 && !w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{w1, "", null});
                                return;
                            }
                            if (w1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && w1.length() > 4) {
                                a2Var.E3(w1.substring(3));
                            }
                            if (bdUniqueId.getId() == a2.A3.getId()) {
                                d.b.j0.q0.n2.l.c(a2Var.o1());
                            } else if (bdUniqueId.getId() == a2.j3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", a2Var.w1());
                                TiebaStatic.log(statisticItem);
                            }
                            d.b.j0.q0.n2.m.e(FrsFragment.this, a2Var, i, z);
                            FrsFragment frsFragment = FrsFragment.this;
                            d.b.j0.q0.n2.l.d(frsFragment, frsFragment.C, a2Var);
                        }
                    }
                }
            }
        }

        public /* synthetic */ o1(FrsFragment frsFragment, k kVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public p(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.M3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements d.b.j0.q0.f {
        public p0() {
        }

        @Override // d.b.j0.q0.f
        public void a(int i, int i2, View view, View view2, a2 a2Var) {
            if (i != FrsFragment.this.x.U().e()) {
                if (i != FrsFragment.this.x.U().i()) {
                    if (i != FrsFragment.this.x.U().f() || FrsFragment.this.C == null || FrsFragment.this.C.getUserData() == null || !FrsFragment.this.C.getUserData().isBawu()) {
                        return;
                    }
                    String bawuCenterUrl = FrsFragment.this.C.getBawuCenterUrl();
                    if (d.b.c.e.p.k.isEmpty(bawuCenterUrl) || FrsFragment.this.C.getForum() == null) {
                        return;
                    }
                    d.b.i0.l.a.l(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", FrsFragment.this.C.getForum().getId()).param("uid", FrsFragment.this.C.getUserData().getUserId()));
                } else if (ViewHelper.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null) {
                        return;
                    }
                    ForumData forum = FrsFragment.this.C.getForum();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), d.b.c.e.m.b.f(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                }
            } else if (ViewHelper.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                d.b.j0.q0.n2.m.d(FrsFragment.this.getPageContext(), FrsFragment.this.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public q(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (FrsFragment.this.x != null) {
                FrsFragment.this.x.a1(booleanValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 implements NoNetworkView.b {
        public q0() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (FrsFragment.this.W.X() == 1 && z && !FrsFragment.this.x.Y()) {
                if (FrsFragment.this.C != null && !ListUtils.isEmpty(FrsFragment.this.C.getThreadList())) {
                    FrsFragment.this.x.D0();
                    return;
                }
                FrsFragment frsFragment = FrsFragment.this;
                frsFragment.hideNetRefreshView(frsFragment.x.V().n());
                FrsFragment frsFragment2 = FrsFragment.this;
                frsFragment2.showLoadingView(frsFragment2.x.j0(), true);
                FrsFragment.this.x.r0(false);
                FrsFragment.this.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public r(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TbadkApplication.getInst().getCurrentActivity() == null || d.b.c.e.p.k.isEmpty(str) || !str.equals(FrsFragment.this.p)) {
                return;
            }
            d.b.j0.q0.n2.i.d(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.C);
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public r0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || FrsFragment.this.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.Y.H() == 0 || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f16323b instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.Y.y().f16323b).isPrimary() || FrsFragment.this.x.B0() || d.b.i0.x.d.h().k()) {
                if (FrsFragment.this.Y.H() != 0) {
                    FrsFragment.this.z.b();
                    return;
                }
                return;
            }
            FrsFragment.this.z.f();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements d.b.j0.d3.s {

        /* renamed from: a  reason: collision with root package name */
        public long f15712a = 0;

        public s() {
        }

        @Override // d.b.j0.d3.s
        public void a(int i, boolean z, d.b.j0.d3.f fVar) {
            if (FrsFragment.this.e0) {
                FrsFragment.this.e0 = false;
                d.b.j0.q0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.h(), false, null);
            }
            FrsFragment.this.D3();
            FrsFragment.this.P = true;
            if (fVar != null && fVar.f55202b) {
                FrsFragment.this.x.U().n(TbImageHelper.getInstance().isShowBigImage());
                FrsFragment.W1 = 0L;
                FrsFragment.X1 = 0L;
                FrsFragment.Y1 = 0;
            } else {
                FrsFragment.Y1 = 1;
            }
            if (!FrsFragment.this.W.q0() && (i == 3 || i == 6)) {
                FrsFragment.this.i0.k();
            }
            FrsFragment.this.G = System.currentTimeMillis();
            if (FrsFragment.this.W.Z() != null) {
                FrsFragment frsFragment = FrsFragment.this;
                frsFragment.C = frsFragment.W.Z();
            }
            FrsFragment.this.B3(1);
            FrsFragment.this.u3();
            if (i == 7) {
                FrsFragment.this.Y2(FrsFragment.this.C.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.C.getPage() != null) {
                FrsFragment frsFragment2 = FrsFragment.this;
                frsFragment2.h3(frsFragment2.C.getPage().b());
            }
            if (i == 4) {
                if (!FrsFragment.this.W.q0() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.W.X() == 1 && !d.b.j0.s0.a.d()) {
                    FrsFragment.this.C.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<d.b.c.j.e.n> c2 = FrsFragment.this.i0.c(false, false, FrsFragment.this.C.getThreadList(), FrsFragment.this.s, false);
                if (c2 != null) {
                    FrsFragment.this.C.setThreadList(c2);
                    FrsFragment.this.C.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.W != null) {
                    d.b.j0.q0.j2.c.l(FrsFragment.this.C, FrsFragment.this.W.N(), 2, FrsFragment.this.getContext());
                }
                FrsFragment frsFragment3 = FrsFragment.this;
                d.b.j0.q0.n2.a.a(frsFragment3, frsFragment3.C.getForum(), FrsFragment.this.C.getThreadList(), false, FrsFragment.this.x2());
                FrsFragment.this.x.v1(c2, FrsFragment.this.C);
                FrsFragment.this.F3();
                return;
            }
            FrsFragment.this.F3();
            if (i == 1) {
                FrsFragment.this.x.D0();
            } else if (i == 2) {
                FrsFragment.this.x.D0();
            } else if (i == 3 || i == 6) {
                if (FrsFragment.this.C != null) {
                    FrsFragment.this.C.clearPostThreadCount();
                }
                d.b.j0.q0.o2.c cVar = FrsFragment.this.n0;
                if (cVar != null) {
                    cVar.d();
                }
            }
            FrsFragment.this.L3();
            if (fVar == null || fVar.f55203c == 0) {
                if (FrsFragment.this.C == null) {
                    return;
                }
                FrsFragment frsFragment4 = FrsFragment.this;
                frsFragment4.v3(frsFragment4.C);
                FrsFragment.this.U2(false, i == 5);
                if (FrsFragment.this.W != null) {
                    if (FrsFragment.this.C.getActivityHeadData() != null && FrsFragment.this.C.getActivityHeadData().a() != null && FrsFragment.this.C.getActivityHeadData().a().size() > 0) {
                        d.b.j0.q0.j2.a.d(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.C.getForum(), FrsFragment.this.W.W(), 1);
                    }
                    if (FrsFragment.this.C.getThreadList() != null && FrsFragment.this.C.getThreadList().size() > 0) {
                        Iterator<d.b.c.j.e.n> it = FrsFragment.this.C.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d.b.c.j.e.n next = it.next();
                            if ((next instanceof a2) && ((a2) next).getType() == a2.A3) {
                                d.b.j0.q0.j2.a.d(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.C.getForum(), FrsFragment.this.W.W(), 2);
                                break;
                            }
                        }
                    }
                    d.b.j0.q0.j2.a.e(FrsFragment.this.getUniqueId(), FrsFragment.this.C.getThreadList(), FrsFragment.this.C.getForum(), FrsFragment.this.W.W());
                }
                FrsFragment.this.x.O0(i);
                FrsFragment.W1 = (System.nanoTime() - this.f15712a) / 1000000;
                if (fVar != null) {
                    FrsFragment.X1 = fVar.f55205e;
                }
            } else if (FrsFragment.this.C == null || ListUtils.isEmpty(FrsFragment.this.C.getThreadList())) {
                FrsFragment.this.C3(fVar);
            } else if (fVar.f55201a) {
                FrsFragment frsFragment5 = FrsFragment.this;
                frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.net_error_text, fVar.f55204d, Integer.valueOf(fVar.f55203c)));
            }
            FrsFragment.this.I3();
            FrsFragment.this.h2();
            if (FrsFragment.this.C.getAccessFlag() == 1) {
                TiebaStatic.log(new StatisticItem("c11384"));
            }
            if (FrsFragment.this.t && FrsFragment.this.Y.c(49)) {
                FrsFragment.this.t = false;
            }
            System.gc();
        }

        @Override // d.b.j0.d3.s
        public void b(int i) {
            this.f15712a = System.nanoTime();
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i == 1 || i == 2) {
                FrsFragment.this.x.D0();
            }
        }

        @Override // d.b.j0.d3.s
        public void c() {
            FrsFragment.this.Z2();
        }

        @Override // d.b.j0.d3.s
        public void d(d.b.j0.d3.m mVar) {
            if ((mVar == null || !("normal_page".equals(FrsFragment.this.W.V()) || "frs_page".equals(FrsFragment.this.W.V()) || "book_page".equals(FrsFragment.this.W.V()))) && !"brand_page".equals(FrsFragment.this.W.V())) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
            FrsFragment.this.a3(mVar);
            FrsFragment.V1 = mVar;
        }
    }

    /* loaded from: classes4.dex */
    public class s0 extends CustomMessageListener {
        public s0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                d.b.j0.q0.n2.c.a(customResponsedMessage, FrsFragment.this.x, FrsFragment.this.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f15715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f15716f;

        public t(PrivateForumPopInfoData privateForumPopInfoData, d.b.i0.r.s.a aVar) {
            this.f15715e = privateForumPopInfoData;
            this.f15716f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{this.f15715e.v()});
            this.f15716f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnClickListener {
        public t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Fragment fragment;
            if (FrsFragment.this.Y != null) {
                FrsTabViewController.o y = FrsFragment.this.Y.y();
                if (y != null && (fragment = y.f16323b) != null && (fragment instanceof d.b.j0.q0.q0)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    ((d.b.j0.q0.q0) y.f16323b).B0();
                    ((d.b.j0.q0.q0) y.f16323b).E();
                    return;
                }
                FrsFragment.this.x0().K1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements a.e {
        public u() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements d.b.j0.q0.t0 {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FrsFragment.this.x == null || !FrsFragment.this.x.y0()) {
                    return;
                }
                FrsFragment.this.loadMore();
            }
        }

        public u0() {
        }

        @Override // d.b.j0.q0.t0
        public void a(int i, int i2, d.b.j0.q0.c1 c1Var, ArrayList<d.b.c.j.e.n> arrayList) {
            d.b.c.e.m.e.a().post(new a());
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public v(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2016495) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof a2) {
                d.b.j0.q0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.h(), true, (a2) data);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends CustomMessageListener {
        public v0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            FrsFragment.this.s0 = true;
        }
    }

    /* loaded from: classes4.dex */
    public class w implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15724e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15725f;

        public w(int i, String str) {
            this.f15724e = i;
            this.f15725f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13387").param("fid", FrsFragment.this.p).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f15724e));
            UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{this.f15725f});
        }
    }

    /* loaded from: classes4.dex */
    public class w0 extends CustomMessageListener {
        public w0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                if (FrsFragment.this.V == null && FrsFragment.this.x.g0() != null && !FrsFragment.this.x.Y() && FrsFragment.this.x.g0().j() != null && (FrsFragment.this.x.g0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment = FrsFragment.this;
                    frsFragment.V = (ThreadCardViewHolder) frsFragment.x.g0().j().getTag();
                }
                if (FrsFragment.this.V == null || FrsFragment.this.V.b() == null) {
                    return;
                }
                FrsFragment.this.V.b().o(new a.C1072a(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsFragment.this.P || !d.b.c.e.p.j.z() || FrsFragment.this.x.A0()) {
                return;
            }
            FrsFragment.this.x.Q0();
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public x0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.x != null) {
                FrsFragment.this.x.N0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrsFragment.this.x.I1();
        }
    }

    /* loaded from: classes4.dex */
    public class y0 extends CustomMessageListener {
        public y0(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.z != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.Y.H() == 0 || FrsFragment.this.x.B0() || d.b.i0.x.d.h().k()) {
                            return;
                        }
                        FrsFragment.this.z.f();
                        return;
                    }
                    FrsFragment.this.z.b();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z extends CustomMessageListener {
        public z(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.t.n) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            FrsFragment.this.C.updateCurrentUserPendant((d.b.i0.t.n) customResponsedMessage.getData());
            FrsFragment.this.x.U().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f15733e;

        public z0(LiveHorseRaceData liveHorseRaceData) {
            this.f15733e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "";
            if (FrsFragment.this.C != null && FrsFragment.this.C.getForum() != null) {
                str = FrsFragment.this.C.getForum().getName();
            }
            TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", FrsFragment.this.p).param("fname", str));
            AlaInfoData alaInfoData = new AlaInfoData();
            if (this.f15733e.getLive_id() != null) {
                alaInfoData.live_id = this.f15733e.getLive_id().longValue();
                alaInfoData.screen_direction = this.f15733e.getScreen_direction().intValue();
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(FrsFragment.this.getContext(), alaLiveInfoCoreData, "live_paomadeng", FrsFragment.this.p)));
            }
        }
    }

    @Override // d.b.j0.q0.o0
    public void A() {
        d.b.i0.z0.a0 a0Var = this.o0;
        if (a0Var != null) {
            a0Var.c(true);
        }
    }

    public final FrsTabInfoData A2() {
        FrsViewData frsViewData;
        int C;
        if (this.W == null || (frsViewData = this.C) == null || this.Y == null || frsViewData.getEntelechyTabInfo() == null || ListUtils.isEmpty(this.C.getEntelechyTabInfo().tab) || (C = this.Y.C()) == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : this.C.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && (frsTabInfo.tab_id.intValue() != 505 || this.C.getUserData() == null || this.C.getUserData().isForumBusinessAccount())) {
                arrayList.add(new FrsTabItemData(frsTabInfo));
                if (C == frsTabInfo.tab_id.intValue()) {
                    i2 = C;
                }
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i2;
        if (this.C.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.C.getUserData().isForumBusinessAccount();
        }
        return frsTabInfoData;
    }

    public void A3(String str, String str2, String str3) {
        d.b.j0.q0.n2.e eVar = new d.b.j0.q0.n2.e(str, str2);
        this.T0 = eVar;
        eVar.f(getFragmentActivity(), str3, str2);
    }

    public String B2() {
        return this.o;
    }

    public final void B3(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        if (!TbadkCoreApplication.isLogin() || (frsViewData = this.C) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (d.b.c.e.p.k.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", d.b.i0.z0.n0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public OvalActionButton C2() {
        return this.y;
    }

    public final void C3(d.b.j0.d3.f fVar) {
        if (fVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.x.P0();
            showNetRefreshView(this.x.j0(), string, true);
        } else if (340001 == fVar.f55203c) {
            H3(fVar, this.C.getRecm_forum_list());
        } else {
            if (ListUtils.isEmpty(this.C.getThreadList())) {
                G3(fVar);
            }
            if (L2()) {
                setNetRefreshViewEmotionMarginTop(d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public FRSRefreshButton D2() {
        return this.z;
    }

    public void D3() {
        hideLoadingView(this.x.j0());
        this.x.M1();
        if (this.x.i0() instanceof d.b.j0.q0.k2.c) {
            ((d.b.j0.q0.k2.c) this.x.i0()).a();
        }
    }

    public int E2() {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar == null) {
            return -1;
        }
        return cVar.h();
    }

    public final void E3() {
        if (E2() != 1 && !this.i0.b(this.C.getThreadListIds())) {
            if (ListUtils.isEmpty(this.C.getThreadList())) {
                this.x.q0();
            } else {
                this.x.F1();
            }
        } else if (ListUtils.getCount(this.C.getThreadList()) > 3) {
            this.x.C1();
        } else {
            this.x.y1();
        }
    }

    @Override // d.b.j0.q0.o0
    public void F() {
        if (isAdded() && this.e0 && !isLoadingViewAttached()) {
            showLoadingView(this.x.j0(), true);
        }
    }

    public void F2() {
        if (getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        d.b.c.e.p.l.w(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public final void F3() {
        if (E2() == 0 && ListUtils.isEmpty(this.C.getThreadListIds())) {
            if (ListUtils.isEmpty(this.C.getThreadList())) {
                this.x.q0();
            } else {
                this.x.F1();
            }
        } else if (ListUtils.getCount(this.C.getThreadList()) > 3) {
            this.x.C1();
        } else {
            this.x.y1();
        }
    }

    public void G2() {
        FRSRefreshButton fRSRefreshButton = this.z;
        if (fRSRefreshButton != null) {
            fRSRefreshButton.b();
        }
    }

    public final void G3(d.b.j0.d3.f fVar) {
        this.x.P0();
        if (fVar.f55201a) {
            showNetRefreshView(this.x.j0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.f55204d, Integer.valueOf(fVar.f55203c)}), true);
        } else {
            showNetRefreshView(this.x.V().n(), fVar.f55204d, true);
        }
    }

    public final void H2() {
        List<LiveHorseRaceData> list;
        String format;
        if (!isResumed() || (list = this.M0) == null || list.size() < 1 || this.L0 > this.M0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.M0.get(this.L0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.L0++;
            H2();
        }
        if (this.A != null) {
            FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
            if (liveHorseRaceData.getUser_nickname() != null && !TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
            } else {
                format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
            }
            frsRedpackRunView.settextTitle(format + format + format);
            frsRedpackRunView.setClickliner(new z0(liveHorseRaceData));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.N0 = ofFloat;
            ofFloat.setDuration(600L);
            this.N0.addUpdateListener(new a1(frsRedpackRunView));
            this.N0.addListener(new b1(frsRedpackRunView));
            this.O0 = new d1(frsRedpackRunView);
            d.b.c.e.m.e.a().postDelayed(this.O0, 5000L);
            if (this.A.getChildCount() == 0) {
                this.L0++;
                this.A.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.C;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.C.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.p).param("fname", str));
            }
            LinearLayout linearLayout = this.A;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.Y.y().f16323b).isPrimary() || this.x.B0() || this.N) {
                return;
            }
            this.A.setVisibility(0);
        }
    }

    public final void H3(d.b.j0.d3.f fVar, List<RecmForumInfo> list) {
        d.b.j0.q0.r rVar = this.x;
        if (rVar != null) {
            rVar.P0();
            this.x.w1(this.j);
            if (this.x.V() != null) {
                z3(this.x.j0(), fVar.f55204d, true, list);
            }
        }
    }

    public final void I2(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.G1);
        long j2 = 0;
        if (bundle != null) {
            this.j = bundle.getString("name");
            this.k = bundle.getString("from");
            this.l = bundle.getInt("flag", 0);
            j2 = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.j = intent.getStringExtra("name");
            this.k = intent.getStringExtra("from");
            this.l = intent.getIntExtra("flag", 0);
            j2 = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.m = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (!TextUtils.isEmpty(this.k)) {
            FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.k);
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.G1);
        }
        this.X.J(bundle);
        l2(j2);
    }

    public final void I3() {
        boolean a2;
        if (f2()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.w(this.C.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (d.b.c.e.p.k.isEmpty(privateForumPopInfoData.u()) || privateForumPopInfoData.t() != Integer.valueOf(this.p))) {
            privateForumPopInfoData.z("create_success");
            privateForumPopInfoData.x(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
            privateForumPopInfoData.A("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.p + "&fn=" + this.j + "&nomenu=1");
            privateForumPopInfoData.y(Integer.valueOf(this.p));
            a2 = frsPrivateCommonDialogView.a(privateForumPopInfoData);
        } else {
            a2 = privateForumPopInfoData.t() == Integer.valueOf(this.p) ? frsPrivateCommonDialogView.a(privateForumPopInfoData) : false;
        }
        if (a2) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new t(privateForumPopInfoData, aVar));
            aVar.setCloseButton(new u());
            aVar.create(getPageContext()).show();
        }
    }

    public final void J2() {
        if (this.l == 0) {
            this.x.w1(this.j);
        } else {
            this.x.w1("");
            this.l = 1;
        }
        this.x.s1(this.H1);
        this.x.H(this.D1);
        this.x.t1(this.F1);
        this.x.U().k(this.E1);
    }

    public void J3() {
        FRSRefreshButton fRSRefreshButton = this.z;
        if (fRSRefreshButton != null) {
            fRSRefreshButton.f();
        }
    }

    @Override // d.b.j0.q0.o0
    public void K(d.b.i0.z0.b0 b0Var) {
        if (b0Var != null) {
            this.o0 = b0Var.a();
            this.p0 = b0Var.b();
        }
    }

    public boolean K2() {
        return this.u;
    }

    public void K3(String str) {
        BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
        bdTopToast.i(true);
        bdTopToast.h(str);
        bdTopToast.j(this.x.j0());
    }

    public boolean L2() {
        return this.f15643h;
    }

    public final void L3() {
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForum() == null) {
            if (this.C.getForum().getYuleData() != null && this.C.getForum().getYuleData().a()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
                this.x.A1(this.C.getForum().getYuleData().b());
                return;
            }
            this.x.p0();
            return;
        }
        this.x.p0();
    }

    @Override // d.b.j0.q0.e2.l
    public FrsModelController M() {
        return this.W;
    }

    public final boolean M2() {
        if (S() == null) {
            return false;
        }
        FrsViewData S = S();
        d.b.i0.r.q.a0 a0Var = null;
        if (S.getStar() != null && !StringUtils.isNull(S.getStar().a())) {
            a0Var = new d.b.i0.r.q.a0();
        } else if (S.getActivityHeadData() != null && ListUtils.getCount(S.getActivityHeadData().a()) >= 1) {
            a0Var = S.getActivityHeadData().a().get(0);
        }
        return a0Var != null;
    }

    public final void M3() {
        if (d.b.c.e.p.k.isEmpty(this.p)) {
            return;
        }
        d.b.i0.a.c.y().O(d.b.i0.a.b.X, d.b.c.e.m.b.f(this.p, 0L));
    }

    public boolean N2() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void N3() {
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean O2() {
        if (S() == null) {
            return false;
        }
        FrsViewData S = S();
        return (ListUtils.isEmpty(S.getShowTopThreadList()) && S.getBusinessPromot() == null) ? false : true;
    }

    public void O3() {
        if (PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    public void P2(Object obj) {
        d.b.c.a.e eVar;
        d.b.j0.q0.e2.b bVar = this.b0;
        if (bVar == null || (eVar = bVar.j) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void P3(Object obj) {
        d.b.c.a.e eVar;
        d.b.j0.q0.e2.b bVar = this.b0;
        if (bVar == null || (eVar = bVar.i) == null) {
            return;
        }
        eVar.c(obj);
    }

    @Override // d.b.j0.q0.r0
    public NavigationBar Q() {
        d.b.j0.q0.r rVar = this.x;
        if (rVar == null) {
            return null;
        }
        return rVar.c0();
    }

    public void Q2(boolean z2) {
        d.b.j0.c3.c.g().h(getUniqueId(), z2);
    }

    public void Q3(int i2) {
        if (!this.mIsLogin) {
            FrsViewData frsViewData = this.C;
            if (frsViewData != null && frsViewData.getAnti() != null) {
                this.C.getAnti().setIfpost(1);
            }
            if (i2 == 0) {
                ViewHelper.skipToLoginActivity(getActivity());
            }
        } else if (this.C != null) {
            if (i2 == 0) {
                d.b.j0.q0.n2.n.b(this, 0);
            } else {
                this.x.G1();
            }
        }
    }

    public boolean R2() {
        return M2() && !O2();
    }

    @Override // d.b.j0.q0.d2.a
    public FrsViewData S() {
        return this.C;
    }

    public void S2(String str) {
        if (!TbadkCoreApplication.isLogin() || d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        if (this.z0 == null) {
            this.z0 = new AddExperiencedModel(q());
        }
        this.z0.w(this.p, str);
    }

    public final void T2() {
        if (this.l == 1) {
            d.b.c.e.m.h.a().b(new j0());
        }
        this.l = 0;
    }

    public final void U2(boolean z2, boolean z3) {
        try {
            if (this.C != null && this.Y != null && this.W != null) {
                if (!this.x.U().j(a2.f3)) {
                    this.C.removeAlaLiveThreadData();
                }
                boolean isEmpty = ListUtils.isEmpty(this.C.getGameTabInfo());
                this.x.i1(isEmpty);
                if (!isEmpty) {
                    if (this.r0 == null) {
                        this.r0 = new d.b.j0.q0.o2.e(this, (NoPressedRelativeLayout) this.w);
                    }
                    if (this.t0 == null) {
                        this.t0 = new d.b.j0.q0.x1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.r0 = null;
                    this.t0 = null;
                }
                if (this.C.getForum() != null) {
                    this.j = this.C.getForum().getName();
                    this.p = this.C.getForum().getId();
                }
                if (this.C.hasTab()) {
                    this.Y.e(this.C, this.W.N());
                }
                if (z2) {
                    a2(true, z2);
                } else {
                    a2(this.R, z2);
                }
                X2();
                if (this.f0 != null) {
                    this.f0.e(this.X, this.C);
                }
                if (this.C.getPage() != null) {
                    h3(this.C.getPage().b());
                }
                ArrayList<d.b.c.j.e.n> d2 = this.i0.d(z3, true, this.C.getThreadList(), null, z2, false);
                if (d2 != null) {
                    this.C.setThreadList(d2);
                }
                this.C.removeRedundantUserRecommendData();
                int topThreadSize = this.C.getTopThreadSize();
                this.q = topThreadSize;
                if (this.s != null) {
                    this.r = true;
                    this.s.e(topThreadSize);
                    d.b.j0.q0.n2.a.a(this, this.C.getForum(), this.C.getThreadList(), this.r, x2());
                }
                if (this.W.X() == 1) {
                    W2();
                    if (!z2 && this.W.getPn() == 1) {
                        b3();
                    }
                }
                if (this.g0 != null) {
                    this.g0.k(this.Y.D());
                }
                D3();
                this.x.X0();
                this.x.f1(true, false);
                if (z2 && this.C.isFirstTabEqualAllThread()) {
                    d.b.c.e.m.e.a().post(new x());
                }
                if (this.C.getForum() != null) {
                    this.x.L(this.C.getForum().getWarningMsg());
                }
                if (this.C != null && this.C.getFrsVideoActivityData() != null && d.b.i0.r.d0.b.j().l("frs_video_activity_guide", 0L) == 0) {
                    d.b.c.e.m.e.a().postDelayed(new y(), 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.x.x1();
                if (this.C != null && this.C.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.C.getForum().getId(), this.C.getForum().getName(), this.C.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.C.getForum().special_forum_type), this.C.getForum().getThemeColorInfo(), this.C.getForum().getMember_num())));
                }
                this.w0.e(this.C.bottomMenuList, this.C.getForum());
                M3();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.j0.s2.t
    public String V() {
        return this.p;
    }

    public void V2(int i2) {
        this.P = false;
        N3();
        d.b.j0.q0.r rVar = this.x;
        if (rVar != null && rVar.g0() != null) {
            this.x.g0().w();
        }
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            frsModelController.C0(i2, true);
        }
    }

    @Override // d.b.j0.q0.o0
    public void W() {
        if (isAdded() && this.e0 && isLoadingViewAttached()) {
            hideLoadingView(this.x.j0());
        }
    }

    public final void W2() {
        N3();
        try {
            if (this.C == null) {
                return;
            }
            this.x.B1();
            this.x.J1(e2());
            if (d.b.j0.q0.o2.h.I(this.C)) {
                d.b.j0.q0.o2.h.G(this.C);
            }
            if (this.C.getForum() != null) {
                this.j = this.C.getForum().getName();
                this.p = this.C.getForum().getId();
            }
            if (this.C.getPage() != null) {
                h3(this.C.getPage().b());
            }
            this.x.w1(this.j);
            this.x.c1(this.j);
            TbadkCoreApplication.getInst().setDefaultBubble(this.C.getUserData().getBimg_url());
            TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.C.getUserData().getBimg_end_time());
            T2();
            q3();
            ArrayList<d.b.c.j.e.n> threadList = this.C.getThreadList();
            if (threadList != null) {
                this.x.v1(threadList, this.C);
                d.b.j0.q0.n2.c.b(this.x);
                this.X.r0(n0());
                this.X.T(this.C);
                this.Y.e(this.C, this.W.N());
                this.x.Y0();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean X2() {
        FrsModelController frsModelController;
        d.b.j0.q0.o2.h hVar = this.X;
        if (hVar != null && (frsModelController = this.W) != null) {
            hVar.w0(frsModelController.V(), this.C);
        }
        FrsViewData frsViewData = this.C;
        boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
        b2();
        d.b.j0.q0.r rVar = this.x;
        if (rVar != null) {
            rVar.t0();
            this.x.u0();
        }
        return hasTab;
    }

    public final void Y2(int i2) {
        X2();
        N3();
        try {
            if (this.C == null) {
                return;
            }
            d.b.j0.q0.z0 z0Var = null;
            this.x.v1(null, this.C);
            this.X.r0(1);
            this.x.Y0();
            this.Y.e(this.C, this.W.N());
            d.b.j0.q0.k2.d G = this.Y.G(this.C.getFrsDefaultTabId());
            if (G != null && !TextUtils.isEmpty(G.f59858d)) {
                z0Var = new d.b.j0.q0.z0();
                String str = G.f59858d;
                String str2 = G.f59855a;
            }
            this.W.g(this.C.getFrsDefaultTabId(), 0, z0Var);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void Z2() {
        FrsModelController frsModelController = this.W;
        if (frsModelController == null || frsModelController.X() != 1) {
            return;
        }
        this.X.X(this.C);
    }

    public final void a2(boolean z2, boolean z3) {
        FrsModelController frsModelController = this.W;
        if (frsModelController == null || this.C == null || this.x == null || !z2) {
            return;
        }
        if (!frsModelController.q0() && this.W.X() == 1) {
            if (!this.W.n0()) {
                this.C.addCardVideoInfoToThreadList();
                this.C.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.x.U().j(d.b.j0.x.e0.n.k) ? this.C.addHotTopicDataToThreadList() : false)) {
                this.C.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !d.b.j0.s0.a.d()) {
                this.C.addRecommendAppToThreadList(this);
            }
            if (!this.x.U().j(a2.f3)) {
                this.C.removeAlaLiveThreadData();
            }
            this.C.addSchoolRecommendToThreadList();
        }
        if (!this.x.U().j(a2.f3)) {
            this.C.removeAlaInsertLiveData();
            this.C.removeAlaStageLiveDat();
        } else {
            this.C.addInsertLiveDataToThreadList();
            this.C.addStageLiveDataToThreadList();
        }
        this.C.checkLiveStageInThreadList();
        this.C.addNoticeThreadToThreadList();
        if (this.x.U().j(d.b.j0.t0.b.i)) {
            this.C.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.W.q0() || this.W.isNetFirstLoad)) {
            this.C.addUserRecommendToThreadList();
        }
        this.C.addVideoActivityToTop();
    }

    public final void a3(d.b.j0.d3.m mVar) {
        try {
            if (!this.P && mVar != null && this.C != null) {
                this.C.receiveData(mVar);
                U2(true, false);
                Looper.myQueue().addIdleHandler(this.U0);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.j0.q0.o0
    public void b0() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void b2() {
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            c2(frsModelController.V());
        } else {
            c2("normal_page");
        }
    }

    public void b3() {
        if (this.l0 == null) {
            this.l0 = new d.b.j0.q0.c2.a(this, d.b.c.e.m.b.d(this.p, 0));
        }
        this.l0.w();
    }

    public final void c2(String str) {
        k3("frs_page".equals(str));
        d.b.j0.q0.n1.e.b bVar = this.f0;
        if (bVar != null) {
            bVar.b(this.X, this.x, this.C);
        }
    }

    public void c3(boolean z2) {
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController != null) {
            frsTabViewController.z = z2;
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void d(ArrayList<d.b.c.j.e.n> arrayList) {
        boolean isEmpty = ListUtils.isEmpty(arrayList);
        h3(!isEmpty ? 1 : 0);
        E3();
        if (isEmpty) {
            return;
        }
        if (!this.W.q0() && TbadkCoreApplication.getInst().isRecAppExist() && this.W.X() == 1 && !d.b.j0.s0.a.d()) {
            this.C.addRecommendAppToThreadList(this, arrayList);
        }
        if (this.W != null) {
            d.b.j0.q0.j2.a.e(getUniqueId(), arrayList, this.C.getForum(), this.W.W());
        }
        ArrayList<d.b.c.j.e.n> c2 = this.i0.c(false, false, arrayList, this.s, false);
        if (c2 != null) {
            this.C.setThreadList(c2);
            this.x.v1(c2, this.C);
        }
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            d.b.j0.q0.j2.c.l(this.C, frsModelController.N(), 2, getContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.C.getForum()));
    }

    @Override // d.b.j0.q0.e2.l
    public d.b.j0.q0.e2.c d0() {
        return this.i0;
    }

    public boolean d2() {
        return this.i;
    }

    public void d3() {
        FrsTabViewController.o y2;
        Fragment fragment;
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController == null || (y2 = frsTabViewController.y()) == null || (fragment = y2.f16323b) == null || !(fragment instanceof d.b.j0.q0.q0)) {
            return;
        }
        ((d.b.j0.q0.q0) fragment).B0();
    }

    @Override // d.b.j0.e.e.b
    public void dispatchInjectPluginMessage(d.b.j0.e.d dVar) {
        this.m0.a(dVar);
    }

    public boolean e2() {
        if (this.S && !this.C0) {
            FrsModelController frsModelController = this.W;
            return (frsModelController != null && frsModelController.Q() && (d.b.j0.q0.b.e().g() || d.b.j0.q0.a.h().j())) ? false : true;
        }
        return false;
    }

    public void e3(boolean z2) {
        this.i = z2;
    }

    public final boolean f2() {
        FrsViewData frsViewData = this.C;
        return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.C.getPrivateForumTotalInfo().a() == null || this.C.getUserData().getIs_manager() != 1;
    }

    public void f3(int i2) {
        this.l = i2;
    }

    public void g2() {
        d.b.j0.q0.n2.m.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.k);
    }

    public void g3(String str) {
        this.j = str;
    }

    @Override // d.b.j0.e.e.b
    public d.b.j0.e.e.a getInjectPlugin(int i2) {
        return this.d0.get(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.j0.q0.d2.a
    public /* bridge */ /* synthetic */ d.b.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.o y2;
        if (z2() != null && (y2 = z2().y()) != null) {
            Fragment fragment = y2.f16323b;
            if (fragment instanceof BaseFragment) {
                if (fragment instanceof FrsAllThreadFragment) {
                    TbPageTag tbPageTag = super.getTbPageTag();
                    FrsViewData frsViewData = this.C;
                    tbPageTag.sortType = d.b.j0.q0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
                    tbPageTag.locatePage = "a070";
                    if (this.f15640e.equals(y2.f16324c)) {
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

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.b.c.e.k.b<TbImageView> getUserIconPool() {
        if (this.E == null) {
            this.E = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.E;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.v == null) {
            this.v = VoiceManager.instance();
        }
        return this.v;
    }

    @Override // d.b.j0.q0.u0
    public String h() {
        return this.p;
    }

    public final void h2() {
        if (!f2() && this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
            i3(this.C.getPrivateForumTotalInfo().a().private_forum_audit_status, this.C.getPrivateForumTotalInfo().b(), false);
        } else {
            i3(null, null, true);
        }
    }

    public void h3(int i2) {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar == null) {
            return;
        }
        cVar.m(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.x.d1(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).updateLoadingViewState(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.x.d1(0);
    }

    @Override // d.b.j0.q0.d2.a, d.b.j0.q0.u0
    public String i() {
        return this.j;
    }

    public final void i2(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<d.b.c.j.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.x.Z() == null || this.x.Z().getData() == null) {
            return;
        }
        Iterator<d.b.c.j.e.n> it = threadList.iterator();
        List<d.b.c.j.e.n> data = this.x.Z().getData();
        int i2 = 0;
        while (it.hasNext()) {
            d.b.c.j.e.n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    } else if (StringHelper.equals(list.get(i3), a2Var.o0())) {
                        it.remove();
                        data.remove(next);
                        this.i0.j(next);
                        this.x.Z().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void i3(Integer num, Integer num2, boolean z2) {
        String str;
        if (this.x.h0() == null) {
            return;
        }
        TextView h02 = this.x.h0();
        if (z2) {
            h02.setVisibility(8);
            return;
        }
        int i2 = 2;
        if (num.intValue() == 2) {
            h02.setText("修改实名认证信息");
            h02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.p + "&nomenu=1";
        } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
            h02.setText("目标已完成" + String.valueOf(num2) + "%");
            h02.setVisibility(0);
            str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.p + "&fn=" + this.j + "&nomenu=1";
            i2 = 1;
        } else {
            h02.setVisibility(8);
            str = "";
            i2 = 0;
        }
        h02.setOnClickListener(new w(i2, str));
    }

    @Override // d.b.j0.s2.t
    public void j0(AdvertAppInfo advertAppInfo, String str) {
        d.b.i0.u.a.l().u(advertAppInfo, this.p, 0L, "FRS", str, x2());
    }

    public final void j2() {
        if (ListUtils.isEmpty(d.b.j0.q0.a.h().i()) || this.x.Z() == null || this.x.Z().getData() == null) {
            return;
        }
        ArrayList<d.b.c.j.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<d.b.c.j.e.n> it = threadList.iterator();
        List<d.b.c.j.e.n> data = this.x.Z().getData();
        int count = ListUtils.getCount(d.b.j0.q0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            d.b.c.j.e.n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(d.b.j0.q0.a.h().i().get(i3).o0(), a2Var.o0())) {
                        it.remove();
                        data.remove(next);
                        this.i0.j(next);
                        this.x.Z().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public void j3(boolean z2) {
        this.S = z2;
    }

    public final void k2(int i2) {
        FrsViewData frsViewData = this.C;
        String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.C.getForum().getId();
        if (StringUtils.isNull(id)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void k3(boolean z2) {
        d.b.j0.q0.o2.j jVar = this.j0;
        if (jVar != null) {
            jVar.d0();
        }
    }

    public final void l2(long j2) {
        if (j2 > 0) {
            d.b.c.e.m.e.a().postDelayed(new i0(j2, d.b.c.e.p.l.k(TbadkCoreApplication.getInst()), d.b.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
        }
    }

    public void l3(boolean z2) {
        this.C0 = z2;
    }

    @Override // d.b.j0.q0.e2.l
    public void loadMore() {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar != null) {
            cVar.i(this.j, this.p, this.C);
        }
    }

    public final void m2() {
        this.x.K1();
    }

    public void m3() {
        if (this.C == null) {
            return;
        }
        d.b.j0.q0.j2.b bVar = new d.b.j0.q0.j2.b();
        if (this.C.needLog == 1) {
            bVar.f59820a = true;
        } else {
            bVar.f59820a = false;
        }
        if (this.C.getForum() != null) {
            bVar.f59822c = this.C.getForum().getId();
        }
        if (M() != null) {
            bVar.f59821b = M().N();
        }
        d.b.j0.q0.j2.b bVar2 = d.b.j0.q0.j2.d.J0;
        if (bVar2 != null) {
            bVar.f59823d = bVar2.f59823d;
            bVar.f59824e = bVar2.f59824e;
        }
        d.b.j0.q0.c2.b bVar3 = new d.b.j0.q0.c2.b(bVar, getTbPageTag(), getUniqueId());
        this.Q0 = bVar3;
        bVar3.d(this.S0);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, this.Q0);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, this.Q0);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, this.Q0);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, this.Q0);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // d.b.j0.s2.t
    public int n0() {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar == null) {
            return 1;
        }
        return cVar.g();
    }

    public d.b.j0.q0.n1.e.b n2() {
        return this.f0;
    }

    public void n3(boolean z2) {
        d.b.j0.q0.v0 v0Var = this.c0;
        if (v0Var != null) {
            v0Var.i(z2);
        }
    }

    public final void o2(Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent != null) {
            if (!d.b.j0.q0.n2.j.a(this, i(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.D = uri != null ? uri.toString() : null;
        if (uri != null) {
            this.j = uri.getQueryParameter("name");
            this.k = uri.getQueryParameter("from");
            if (!StringUtils.isNull(this.j)) {
                intent.putExtra("name", this.j);
            }
            if (!StringUtils.isNull(this.k)) {
                intent.putExtra("from", this.k);
            }
            TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
        }
        if (!StringUtils.isNull(this.j) || uri == null) {
            return;
        }
        if (d.b.i0.a.f.c(uri)) {
            d.b.i0.a.f.b().d(uri, this.y1);
        } else {
            d.b.j0.q0.n2.g b2 = d.b.j0.q0.n2.m.b(intent);
            if (b2 != null) {
                this.j = b2.f60187a;
                String str = b2.f60188b;
                if (str != null) {
                    str.equals("aidou");
                }
            }
        }
        if (!StringUtils.isNull(this.j)) {
            intent.putExtra("name", this.j);
        }
        intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
    }

    public void o3(int i2) {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar == null) {
            return;
        }
        cVar.n(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        this.F = currentTimeMillis;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.t = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.F = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            o2(intent);
        }
        this.I = currentTimeMillis - this.F;
        this.s = new d.b.j0.d3.h0.f("frs", d.b.j0.d3.h0.f.f55241c);
        if (this.W == null) {
            FrsModelController frsModelController = new FrsModelController(this, this.v1);
            this.W = frsModelController;
            frsModelController.o(this.c1);
            this.W.init();
        }
        this.W.L0(this.D);
        ArrayList<d.b.c.j.e.n> arrayList = null;
        if (intent != null) {
            this.W.g0(intent.getExtras());
        } else if (bundle != null) {
            this.W.g0(bundle);
        } else {
            this.W.g0(null);
        }
        if (intent != null) {
            this.X.J(intent.getExtras());
        } else if (bundle != null) {
            this.X.J(bundle);
        } else {
            this.X.J(null);
        }
        this.v = getVoiceManager();
        this.m0 = new d.b.j0.q0.q(getPageContext(), this);
        J2();
        I2(bundle);
        if (!L2()) {
            d.b.j0.q0.v0 v0Var = new d.b.j0.q0.v0(getActivity(), this.x, this.X);
            this.c0 = v0Var;
            v0Var.i(true);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.v = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(q2()) && !this.y0) {
            int k2 = d.b.i0.r.d0.b.j().k("key_forum_broadcast_edit_tip_number", 0);
            if (k2 < 2) {
                d.b.i0.r.d0.b.j().v("key_forum_broadcast_edit_tip_number", k2 + 1);
                w3();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    x3();
                } else {
                    BdTopToast bdTopToast = new BdTopToast(getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint));
                    bdTopToast.j(this.x.j0());
                }
            } else {
                x3();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(q2()) && !this.y0) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    y3();
                } else if (Build.VERSION.SDK_INT < 23 || !d.b.i0.r.d0.b.j().g("key_forum_rule_dialog_show_frs", false)) {
                    y3();
                    d.b.i0.r.d0.b.j().t("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                y3();
            }
        }
        if (d.b.i0.x.d.h().k()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            OvalActionButton ovalActionButton = this.y;
            if (ovalActionButton != null) {
                ovalActionButton.setVisibility(8);
            }
        }
        new d.b.j0.q0.e2.i();
        int i2 = -1;
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar != null && cVar.f() != null) {
            i2 = this.i0.f().w();
            arrayList = this.i0.f().v();
        }
        d.b.j0.q0.e2.c cVar2 = new d.b.j0.q0.e2.c(this, this.z1);
        this.i0 = cVar2;
        cVar2.f().H(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.i0.f().F(arrayList);
        }
        this.a0 = new d.b.j0.q0.h2.a(this);
        this.j0 = new d.b.j0.q0.o2.j(this);
        this.g0 = new d.b.j0.q0.o2.a(getPageContext(), this.W.l0());
        this.b0 = new d.b.j0.q0.e2.b(this);
        this.h0 = new d.b.j0.q0.e2.d(this);
        this.Z = new d.b.j0.q0.e2.h(this);
        this.k0 = new d.b.j0.q0.e2.a(this);
        this.n0 = new d.b.j0.q0.o2.c(this);
        new d.b.j0.q0.e2.e(this, getUniqueId());
        this.u0 = new d.b.j0.h.a(getPageContext(), "frs");
        this.v0 = new d.b.j0.t.a(getPageContext());
        new d.b.j0.q0.i2.c.a(getPageContext());
        registerListener(this.l1);
        registerListener(this.x1);
        registerListener(this.j1);
        registerListener(this.B1);
        registerListener(this.w1);
        registerListener(this.f1);
        registerListener(this.g1);
        registerListener(this.h1);
        registerListener(this.i1);
        registerListener(this.V0);
        registerListener(this.W0);
        registerListener(this.X0);
        registerListener(this.Y0);
        registerListener(this.J1);
        registerListener(this.n1);
        this.o1.setSelfListener(true);
        this.o1.setTag(getPageContext().getUniqueId());
        registerListener(this.o1);
        registerListener(this.b1);
        registerListener(this.p1);
        registerListener(this.m1);
        registerListener(this.s1);
        registerListener(this.t1);
        registerListener(this.u1);
        this.K1.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.K1);
        registerListener(this.L1);
        registerListener(this.M1);
        registerListener(this.N1);
        registerListener(this.a1);
        registerListener(this.O1);
        registerListener(this.q1);
        registerListener(this.Z0);
        registerListener(this.P1);
        registerListener(this.Q1);
        registerListener(this.R1);
        registerListener(this.S1);
        this.x.r0(false);
        if (!L2() && !this.y0) {
            showLoadingView(this.x.j0(), true);
            this.W.L(3, false);
        }
        b0 b0Var = new b0();
        d.b.j0.q0.b.e().o(b0Var);
        d.b.j0.q0.a.h().s(b0Var);
        this.x.q1(new c0());
        this.E0 = UtilHelper.getScreenHeight(getActivity());
        this.y0 = true;
        k2(1);
        super.onActivityCreated(bundle);
        this.J = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        d.b.j0.q0.e2.a aVar = this.k0;
        if (aVar != null) {
            aVar.m(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.B0) {
            this.x.H0(i2);
            this.X.M(i2);
            this.Y.Q(i2);
            FRSRefreshButton fRSRefreshButton = this.z;
            if (fRSRefreshButton != null) {
                fRSRefreshButton.d(i2);
            }
            d.b.j0.q0.r2.a aVar = this.q0;
            if (aVar != null) {
                aVar.onChangeSkinType();
            }
            d.b.j0.q0.j1.a.a aVar2 = this.w0;
            if (aVar2 != null) {
                aVar2.d(getPageContext(), i2);
            }
            if (this.x0 != null) {
                d.b.i0.s0.a.a(getPageContext(), this.x0.getRealView());
            }
            d.b.j0.q0.o2.e eVar = this.r0;
            if (eVar != null) {
                eVar.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.j0.c3.c.g().i(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.r1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = this.w;
        if (view == null) {
            this.w = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            d.b.j0.q0.n1.a aVar = new d.b.j0.q0.n1.a();
            this.f15641f = aVar;
            this.f0 = aVar.b();
            this.f15640e = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.X = new d.b.j0.q0.o2.h(this, this.f15641f, (FrsHeaderViewContainer) this.w.findViewById(R.id.header_view_container));
            FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.w);
            this.Y = frsTabViewController;
            frsTabViewController.V();
            this.X.t0(this.Y);
            this.Y.Z(this.d1);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.f15643h = true;
            }
            this.x = new d.b.j0.q0.r(this, this.C1, this.f15641f, this.f15643h, this.X);
            this.w0 = new d.b.j0.q0.j1.a.a(getPageContext(), this.w);
        } else {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.w.getParent()).removeView(this.w);
            }
            FrsTabViewController frsTabViewController2 = this.Y;
            if (frsTabViewController2 != null) {
                frsTabViewController2.V();
            }
            this.x.R0();
            this.w.setLeft(0);
            this.w.setRight(d.b.c.e.p.l.k(TbadkCoreApplication.getInst().getContext()));
        }
        this.B0 = true;
        this.K = System.currentTimeMillis() - currentTimeMillis;
        return this.w;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.b.j0.c3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.J1);
        MessageManager.getInstance().unRegisterListener(this.o1);
        unRegisterResponsedEventListener();
        this.j0.b0();
        V1 = null;
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.b.j0.s2.f0.a.c("FRS");
        this.v = null;
        d.b.j0.x.t.b().e(false);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.b.j0.q0.h0.a().b(d.b.c.e.m.b.f(this.C.getForum().getId(), 0L));
        }
        d.b.j0.q0.c2.a aVar = this.l0;
        if (aVar != null) {
            aVar.v();
        }
        d.b.j0.q0.r rVar = this.x;
        if (rVar != null) {
            d.b.j0.q0.n2.l.b(rVar, this.C, h(), false, null);
            this.x.I0();
        }
        LinearLayout linearLayout = this.A;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.N0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.O0 != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.O0);
        }
        this.M0 = null;
        super.onDestroy();
        try {
            if (this.Q != null) {
                this.Q.c();
            }
            if (this.x != null) {
                this.x.U0();
            }
            System.gc();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.X.K();
        Looper.myQueue().removeIdleHandler(this.U0);
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            frsModelController.j();
        }
        d.b.j0.q0.v0 v0Var = this.c0;
        if (v0Var != null) {
            v0Var.d();
        }
        d.b.j0.q0.o2.a aVar2 = this.g0;
        if (aVar2 != null) {
            aVar2.i();
        }
        d.b.j0.q0.h2.a aVar3 = this.a0;
        if (aVar3 != null) {
            aVar3.c();
        }
        d.b.j0.q0.o2.e eVar = this.r0;
        if (eVar != null) {
            eVar.g();
        }
        d.b.j0.q0.e2.a aVar4 = this.k0;
        if (aVar4 != null) {
            aVar4.n();
        }
        d.b.j0.h.a aVar5 = this.u0;
        if (aVar5 != null) {
            aVar5.g();
        }
        d.b.j0.t.a aVar6 = this.v0;
        if (aVar6 != null) {
            aVar6.g();
        }
        d.b.j0.s2.d0.a.e().g();
        d.b.j0.q0.n2.n.a();
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController != null) {
            frsTabViewController.Z(null);
            this.Y.J();
        }
        AddExperiencedModel addExperiencedModel = this.z0;
        if (addExperiencedModel != null) {
            addExperiencedModel.onDestroy();
        }
        d.b.j0.q0.b.e().o(null);
        d.b.j0.q0.a.h().s(null);
        d.b.j0.q0.n2.e eVar2 = this.T0;
        if (eVar2 != null) {
            eVar2.d();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        E3();
        showToast(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.b.c.j.e.q onGetPreLoadListView() {
        return v2().getPreLoadHandle();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                return false;
            }
            return false;
        } else if (d.b.j0.q0.b.e().g()) {
            d.b.j0.q0.b.e().k();
            return true;
        } else if (d.b.j0.q0.a.h().j()) {
            d.b.j0.q0.r rVar = this.x;
            if (rVar != null && rVar.z0()) {
                this.x.V0();
                return true;
            }
            d.b.j0.q0.a.h().n();
            return true;
        } else {
            d.b.j0.q0.r rVar2 = this.x;
            if (rVar2 != null) {
                return rVar2.J0();
            }
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (L2()) {
            showLoadingView(this.x.j0(), true);
            this.x.r1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.W.C0(3, true);
            v2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.b.c.e.p.l.C()) {
            hideNetRefreshView(this.x.V().n());
            showLoadingView(this.x.j0(), true);
            this.x.r0(false);
            this.W.C0(3, true);
        }
    }

    public void onNewIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
            this.j = intent.getStringExtra("name");
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
            this.k = intent.getStringExtra("from");
        }
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
        this.n = booleanExtra;
        if (booleanExtra) {
            m2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.Z.f(false);
        this.R = false;
        this.x.K0();
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        this.x.E0(true);
        d.b.j0.q0.o2.a aVar = this.g0;
        if (aVar != null) {
            aVar.j();
        }
        d.b.i0.a.c.y().E();
        d.b.j0.q0.n2.e eVar = this.T0;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            d.b.j0.q0.o2.h hVar = this.X;
            if (hVar != null) {
                hVar.O(isPrimary());
            }
            d.b.j0.q0.r rVar = this.x;
            if (rVar != null) {
                rVar.L0(isPrimary());
                this.x.E0(!isPrimary());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        d.b.j0.q0.n2.m.h(this, i2, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.b.j0.q0.r rVar = this.x;
        if (rVar != null) {
            rVar.D0();
            this.x.M0();
        }
        this.Z.f(true);
        this.R = true;
        if (U1) {
            U1 = false;
            d.b.j0.q0.r rVar2 = this.x;
            if (rVar2 != null) {
                rVar2.K1();
                return;
            }
            return;
        }
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        d.b.j0.q0.r rVar3 = this.x;
        if (rVar3 != null) {
            rVar3.E0(false);
        }
        if (this.s0) {
            V2(6);
            this.s0 = false;
        }
        if (this.D0 != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                d.b.i0.s.d.f.c().h(true);
                d.b.i0.s.d.f.c().i(this.D0.getHours(), this.D0.getMinutes());
                if (this.x != null) {
                    d.b.i0.s.d.f.c().k(q().getPageActivity(), this.x.j0());
                }
            }
            this.D0 = null;
        }
        M3();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.j);
        bundle.putString("from", this.k);
        this.W.onSaveInstanceState(bundle);
        if (this.v == null || getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        this.v.onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        this.x.Z().stopScroll();
        if (this.x.W0()) {
            return;
        }
        if (!d.b.c.e.p.l.C()) {
            this.x.q0();
        } else if (this.W.X() == 1) {
            E3();
            loadMore();
        } else if (this.W.e0()) {
            loadMore();
        }
    }

    public void onServerError(ErrorData errorData) {
        if (getActivity() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        D3();
        this.x.D0();
        d.b.j0.d3.f O = this.W.O();
        boolean isEmpty = ListUtils.isEmpty(this.C.getThreadList());
        if (O != null && isEmpty) {
            if (this.W.R() != 0) {
                this.W.K0();
                this.x.D0();
            } else {
                C3(O);
            }
            this.x.f1(this.C.isStarForum(), false);
            return;
        }
        C3(O);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.v = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d.b.j0.x.t.b().e(false);
        Q2(false);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            d.b.i0.u.a.l().A(getPageContext().getPageActivity(), "frs", this.C.getForum().getId(), 0L);
        }
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        if (v2() != null) {
            v2().getRecycledViewPool().clear();
        }
        this.X.L();
        d.b.i0.z0.c0.c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
    }

    public ForumWriteData p2() {
        FrsViewData frsViewData = this.C;
        if (frsViewData == null || frsViewData.getForum() == null) {
            return null;
        }
        ForumData forum = this.C.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.C.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.C.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = A2();
        return forumWriteData;
    }

    public void p3(boolean z2) {
        if (this.T1 != null) {
            return;
        }
        d.b.j0.s0.a a2 = d.b.j0.s0.a.a(z2);
        this.T1 = a2;
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar != null) {
            cVar.l(a2);
        }
    }

    @Override // d.b.j0.s2.t
    public TbPageContext<?> q() {
        return getPageContext();
    }

    public String q2() {
        return this.k;
    }

    public final void q3() {
        FrsViewData frsViewData = this.C;
        if (frsViewData == null) {
            return;
        }
        if (frsViewData.getIsNewUrl() == 1) {
            this.x.U().setFromCDN(true);
        } else {
            this.x.U().setFromCDN(false);
        }
    }

    public d.b.c.j.e.w r2() {
        return this.H1;
    }

    public void r3(OvalActionButton ovalActionButton) {
        this.y = ovalActionButton;
    }

    public void refresh() {
        d.b.j0.m.d.c().f("page_frs");
        V2(3);
    }

    public d.b.j0.q0.e2.d s2() {
        return this.h0;
    }

    public void s3(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        this.A = linearLayout;
    }

    public void setFrom(String str) {
        this.k = str;
    }

    @Override // d.b.j0.e.e.b
    public void setInjectPlugin(int i2, d.b.j0.e.e.a aVar) {
        this.d0.put(i2, aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        super.setPrimary(z2);
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController == null || frsTabViewController.y() == null || !(this.Y.y().f16323b instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) this.Y.y().f16323b).setPrimary(z2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z2) {
        this.x.d1(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z2);
        ((FrsActivity) getActivity()).updateLoadingViewState(view, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z2) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z2, getNetRefreshListener());
        this.x.d1(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z2) {
        super.showNetRefreshViewNoClick(view, str, z2);
        this.x.d1(8);
    }

    public d.b.j0.q0.h2.a t2() {
        return this.a0;
    }

    public void t3(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton == null) {
            return;
        }
        this.z = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new t0());
    }

    @Override // d.b.j0.s2.t
    public void u0() {
        M().N0();
    }

    public boolean u2() {
        return this.x.Y();
    }

    public final void u3() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
        AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
        achievementActivityConfig.setUrl(stringExtra);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForumActiveInfo() != null) {
            achievementActivityConfig.setShareUrl(this.C.getForumActiveInfo().forum_share_url);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, achievementActivityConfig));
    }

    public BdRecyclerView v2() {
        d.b.j0.q0.r rVar = this.x;
        if (rVar == null) {
            return null;
        }
        return rVar.Z();
    }

    public final boolean v3(d.b.j0.d3.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && d.b.i0.r.d0.b.j().g("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new d.b.j0.q0.h1.f(q()).h(mVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        FrsViewData frsViewData = this.C;
        if (frsViewData != null) {
            return d.b.i0.z0.m0.a(2) || (d.b.i0.z0.m0.d() && frsViewData.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // d.b.j0.q0.o0
    public void w() {
        if (this.x != null) {
            A();
            this.x.Z().scrollToPosition(0);
            this.x.K1();
        }
    }

    @Override // d.b.j0.q0.e2.l
    public d.b.j0.q0.o2.h w0() {
        return this.X;
    }

    public d.b.j0.q0.v0 w2() {
        return this.c0;
    }

    public final void w3() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getPageContext().getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new k0(aVar));
        aVar.setContentView(frsBroadcastCopyGuideDialogView);
        aVar.create(getPageContext()).show();
    }

    @Override // d.b.j0.q0.e2.l
    public d.b.j0.q0.r x0() {
        return this.x;
    }

    public int x2() {
        d.b.j0.q0.e2.c cVar = this.i0;
        if (cVar == null) {
            return 1;
        }
        return cVar.g();
    }

    public final void x3() {
        d.b.i0.x.d.h().m(new d.b.i0.x.a(getContext()));
        d.b.i0.x.d.h().n(85, 0, d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (d.b.i0.x.d.h().j()) {
            getPageContext().getOrignalPage().grantWindowPermission(new l0(), true);
        }
    }

    public View y2() {
        return this.w;
    }

    public final void y3() {
        d.b.i0.x.d.h().m(new d.b.i0.x.b(getContext()));
        d.b.i0.x.d.h().n(85, 0, d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (d.b.i0.x.d.h().j()) {
            getPageContext().getOrignalPage().grantWindowPermission(new m0(), true);
        }
    }

    public FrsTabViewController z2() {
        return this.Y;
    }

    public void z3(View view, String str, boolean z2, List<RecmForumInfo> list) {
        this.x.P0();
        this.x.d1(8);
        if (this.q0 == null) {
            this.q0 = new d.b.j0.q0.r2.a(getPageContext(), getNetRefreshListener());
        }
        this.q0.c(str);
        this.q0.b(list);
        this.q0.attachView(view, z2);
    }
}
