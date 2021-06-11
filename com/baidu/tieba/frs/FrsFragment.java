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
import d.a.i.v0.a;
import d.a.m0.a.g;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import d.a.m0.r.s.a;
import d.a.n0.h.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements VoiceManager.j, d.a.n0.r0.d2.a, UserIconBox.c<BdRecyclerView>, BdListView.p, ActivityCompat.OnRequestPermissionsResultCallback, d.a.n0.r0.u0, d.a.n0.t2.u, d.a.n0.r0.e2.l, d.a.n0.e.e.b, d.a.n0.r0.o0, d.a.n0.r0.r0 {
    public static boolean U1 = false;
    public static d.a.n0.e3.m V1;
    public static volatile long W1;
    public static volatile long X1;
    public static volatile int Y1;
    public LinearLayout A;
    public boolean B0;
    public String D;
    public d.a.c.e.k.b<TbImageView> E;
    public long G;
    public List<LiveHorseRaceData> M0;
    public ValueAnimator N0;
    public boolean O;
    public Runnable O0;
    public d.a.n0.r0.c2.b Q0;
    public d.a.n0.r0.k1.a R0;
    public int S0;
    public String T;
    public d.a.n0.r0.n2.e T0;
    public d.a.n0.t0.a T1;
    public ThreadCardViewHolder V;
    public FrsModelController W;
    public d.a.n0.r0.o2.h X;
    public FrsTabViewController Y;
    public d.a.n0.r0.e2.h Z;
    public d.a.n0.r0.h2.a a0;
    public d.a.n0.r0.e2.b b0;
    public d.a.n0.r0.v0 c0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r0.n1.a f15081f;
    public d.a.n0.r0.n1.e.b f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15082g;
    public d.a.n0.r0.o2.a g0;
    public d.a.n0.r0.e2.d h0;
    public d.a.n0.r0.e2.c i0;
    public d.a.n0.r0.o2.j j0;
    public d.a.n0.r0.e2.a k0;
    public d.a.n0.r0.c2.a l0;
    public d.a.n0.r0.q m0;
    public d.a.n0.r0.o2.c n0;
    public d.a.m0.z0.a0 o0;
    public View.OnTouchListener p0;
    public d.a.n0.r0.r2.a q0;
    public d.a.n0.r0.o2.e r0;
    public d.a.n0.e3.h0.f s;
    public boolean s0;
    public d.a.n0.r0.x1.b t0;
    public d.a.n0.h.a u0;
    public VoiceManager v;
    public d.a.n0.v.a v0;
    public View w;
    public d.a.n0.r0.j1.a.a w0;
    public d.a.m0.r.s.a x0;
    public OvalActionButton y;
    public FRSRefreshButton z;
    public AddExperiencedModel z0;

    /* renamed from: e  reason: collision with root package name */
    public String f15080e = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f15083h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15084i = true;
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
    public d.a.n0.r0.r x = null;
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
    public d.a.m0.m0.b Q = null;
    public boolean R = true;
    public boolean S = true;
    public a.C0600a U = new a.C0600a(2);
    public SparseArray<d.a.n0.e.e.a> d0 = new SparseArray<>();
    public boolean e0 = true;
    public boolean y0 = false;
    public boolean A0 = false;
    public boolean C0 = false;
    public Date D0 = null;
    public int E0 = 0;
    public int F0 = 0;
    public int G0 = 0;
    public int P0 = -1;
    public MessageQueue.IdleHandler U0 = new k();
    public final CustomMessageListener V0 = new v(2016495);
    public CustomMessageListener W0 = new g0(2921005);
    public CustomMessageListener X0 = new r0(2921401);
    public CustomMessageListener Y0 = new c1(2921473);
    public CustomMessageListener Z0 = new k1(2921467);
    public d.a.c.c.g.a a1 = new l1(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
    public CustomMessageListener b1 = new m1(2001624);
    public final d.a.n0.r0.t0 c1 = new n1();
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
    public d.a.m0.f0.i r1 = new o();
    public final CustomMessageListener s1 = new p(2921391);
    public CustomMessageListener t1 = new q(2003020);
    public final CustomMessageListener u1 = new r(2921463);
    public final d.a.n0.e3.s v1 = new s();
    public final CustomMessageListener w1 = new z(2016485);
    public final CustomMessageListener x1 = new a0(2001194);
    public final g.b y1 = new d0();
    public final d.a.n0.r0.e2.k z1 = new e0();
    public final View.OnTouchListener A1 = new f0();
    public final CustomMessageListener B1 = new h0(2004507);
    public final View.OnClickListener C1 = new n0();
    public final RecyclerView.OnScrollListener D1 = new o0();
    public final d.a.n0.r0.f E1 = new p0();
    public final NoNetworkView.b F1 = new q0();
    public final CustomMessageListener G1 = new s0(0);
    public d.a.c.k.e.w H1 = new o1(this, null);
    public d.a.n0.r0.t0 I1 = new u0();
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
        public void a(int i2, int i3, String str) {
            boolean z = false;
            if (i2 != 1) {
                d.a.n0.z.t.b().e(false);
                FrsFragment.this.S2(false);
            }
            if (i2 == 502) {
                FrsFragment.this.y.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.y.setIconFade(0);
            }
            FrsFragment.this.e1 = i2;
            FrsFragment.this.S0 = i3;
            if (FrsFragment.this.Q0 != null) {
                FrsFragment.this.Q0.d(FrsFragment.this.S0);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.S0);
            FrsFragment.this.P3();
            d.a.n0.r0.j2.b bVar = d.a.n0.r0.j2.d.L0;
            bVar.f62468d = i2;
            bVar.f62471g = i3;
            bVar.f62469e = -1;
            d.a.n0.r0.b.e().m(i2 == 1 && FrsFragment.this.A0, true);
            d.a.n0.r0.a h2 = d.a.n0.r0.a.h();
            if (i2 == 1 && FrsFragment.this.A0) {
                z = true;
            }
            h2.p(z, true);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 extends CustomMessageListener {
        public a0(int i2) {
            super(i2);
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
                FrsFragment.this.X.O(num);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15087e;

        public a1(FrsRedpackRunView frsRedpackRunView) {
            this.f15087e = frsRedpackRunView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                this.f15087e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f15087e.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
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
    public class b0 implements d.a.n0.r0.x0 {
        public b0() {
        }

        @Override // d.a.n0.r0.x0
        public void a(boolean z, boolean z2, int i2) {
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i2 == 1) {
                FrsFragment.this.x.p1(z ? 0 : 8);
            } else if (i2 == 2) {
                FrsFragment.this.x.m1(z ? 0 : 8);
            }
            if (!z2) {
                FrsFragment.this.A0 = z;
            }
            if (FrsFragment.this.x.U() != null && (i2 == 2 || (FrsFragment.this.W != null && FrsFragment.this.W.U()))) {
                FrsFragment.this.x.U().notifyDataSetChanged();
            }
            if (FrsFragment.this.B2() != null) {
                FrsTabViewController.o y = FrsFragment.this.B2().y();
                if (y != null) {
                    if ((y.f15823b instanceof FrsCommonTabFragment) && (i2 == 2 || y.f15822a == 502)) {
                        ((FrsCommonTabFragment) y.f15823b).a1();
                    } else if ((y.f15823b instanceof FrsNewAreaFragment) && (i2 == 2 || y.f15822a == 503)) {
                        FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) y.f15823b;
                        frsNewAreaFragment.A1();
                        if (frsNewAreaFragment.l1() != null) {
                            d.a.n0.r0.e2.g l1 = frsNewAreaFragment.l1();
                            l1.G(!z);
                            if (i2 == 1) {
                                l1.D(!z);
                            } else if (i2 == 2) {
                                l1.D(true);
                            }
                        }
                    } else {
                        Fragment fragment = y.f15823b;
                        if (fragment instanceof FrsGoodFragment) {
                            ((FrsGoodFragment) fragment).v1();
                        }
                    }
                }
                if (FrsFragment.this.B2().I() != null) {
                    FrsFragment.this.B2().I().setmDisallowSlip(z);
                    FrsFragment.this.B2().b0(z);
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
            if (i2 == 1) {
                FrsFragment.this.x.l1(!z);
            } else if (i2 == 2) {
                FrsFragment.this.x.l1(true);
            }
        }

        @Override // d.a.n0.r0.x0
        public void b(int i2) {
            if (FrsFragment.this.getContext() == null) {
                return;
            }
            if (i2 != 1) {
                if (i2 != 2 || FrsFragment.this.x == null) {
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
                bdTopToast.i(false);
                bdTopToast.h(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num));
                bdTopToast.j(FrsFragment.this.x.j0());
                return;
            }
            d.a.c.e.p.l.L(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
        }

        @Override // d.a.n0.r0.x0
        public void c(int i2, int i3) {
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i3 == 1) {
                FrsFragment.this.x.o1(i2);
            } else if (i3 == 2) {
                FrsFragment.this.x.n1(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15091e;

        public b1(FrsRedpackRunView frsRedpackRunView) {
            this.f15091e = frsRedpackRunView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15091e.setAlpha(0.0f);
            this.f15091e.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
            this.f15091e.c();
            FrsFragment.this.A.removeView(this.f15091e);
            if (FrsFragment.this.M0 == null || FrsFragment.this.G0 <= FrsFragment.this.M0.size() - 1) {
                FrsFragment.this.J2();
                return;
            }
            FrsFragment.this.A.removeAllViews();
            FrsFragment.this.A.setVisibility(8);
            FrsFragment.this.G0 = 0;
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
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || ((Integer) customResponsedMessage.getData()).intValue() != 51 || FrsFragment.this.C == null) {
                return;
            }
            d.a.n0.r0.n2.n.d(FrsFragment.this.C, FrsFragment.this.getPageContext());
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements e.c {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(c0 c0Var) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(c0 c0Var) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }

        public c0() {
        }

        @Override // d.a.n0.h.e.c
        public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
            boolean z;
            if (deleteThreadHttpResponseMessage == null) {
                return;
            }
            FrsFragment.this.x.P();
            FrsFragment.this.x.O();
            FrsNewAreaFragment frsNewAreaFragment = null;
            int i2 = 0;
            if (FrsFragment.this.Y == null || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f15823b instanceof FrsNewAreaFragment)) {
                z = false;
            } else {
                frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.Y.y().f15823b;
                z = true;
            }
            if (deleteThreadHttpResponseMessage.getError() == 0) {
                String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                    if (FrsFragment.this.x0 == null) {
                        FrsFragment frsFragment = FrsFragment.this;
                        frsFragment.x0 = new d.a.m0.r.s.a(frsFragment.getActivity());
                    }
                    FrsFragment.this.x0.setMessage(text);
                    FrsFragment.this.x0.setPositiveButton(R.string.dialog_known, new a(this));
                    FrsFragment.this.x0.setCanceledOnTouchOutside(false);
                    FrsFragment.this.x0.create(FrsFragment.this.getPageContext());
                    FrsFragment.this.x0.show();
                } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                    if (FrsFragment.this.x0 == null) {
                        FrsFragment frsFragment2 = FrsFragment.this;
                        frsFragment2.x0 = new d.a.m0.r.s.a(frsFragment2.getActivity());
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
                    frsNewAreaFragment.w1(deleteThreadHttpResponseMessage.getSuccessItems());
                }
                FrsFragment.this.k2(deleteThreadHttpResponseMessage.getSuccessItems());
                d.a.n0.r0.b.e().i(deleteThreadHttpResponseMessage.getSuccessItems());
                for (d.a.c.k.e.n nVar : FrsFragment.this.C.getThreadList()) {
                    if (nVar instanceof z1) {
                        i2++;
                        continue;
                    }
                    if (i2 >= 6) {
                        break;
                    }
                }
                if (i2 < 6) {
                    FrsFragment.this.loadMore();
                    return;
                }
                return;
            }
            d.a.c.e.p.l.M(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public class c1 extends CustomMessageListener {
        public c1(int i2) {
            super(i2);
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
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            FrsFragment.this.Y.b(49);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements g.b {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HashMap f15098e;

            /* renamed from: com.baidu.tieba.frs.FrsFragment$d0$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0175a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15100e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f15101f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f15102g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f15103h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ int f15104i;

                public RunnableC0175a(long j, int i2, int i3, float f2, int i4) {
                    this.f15100e = j;
                    this.f15101f = i2;
                    this.f15102g = i3;
                    this.f15103h = f2;
                    this.f15104i = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(this.f15100e, 0L, 0L, this.f15101f, this.f15102g, this.f15103h, this.f15104i);
                    requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
                    requestGetMyPostNetMessage.setProZone(2);
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }

            public a(HashMap hashMap) {
                this.f15098e = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                FrsFragment.this.Y.b(301);
                d.a.c.e.m.e.a().postDelayed(new RunnableC0175a(d.a.c.e.m.b.f((String) this.f15098e.get(d.a.m0.a.g.o), 0L), d.a.c.e.p.l.k(TbadkCoreApplication.getInst()), d.a.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
            }
        }

        public d0() {
        }

        @Override // d.a.m0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                return;
            }
            if (hashMap.get(d.a.m0.a.g.n) instanceof String) {
                FrsFragment.this.j = (String) hashMap.get(d.a.m0.a.g.n);
            }
            if (!(hashMap.get(d.a.m0.a.g.H) instanceof String) || TextUtils.isEmpty((String) hashMap.get(d.a.m0.a.g.H))) {
                return;
            }
            d.a.c.e.m.e.a().postDelayed(new a(hashMap), IMLikeRequest.TIME_INTERVAL);
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsRedpackRunView f15105e;

        public d1(FrsRedpackRunView frsRedpackRunView) {
            this.f15105e = frsRedpackRunView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsFragment.this.A == null || this.f15105e == null) {
                return;
            }
            FrsFragment.this.N0.start();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.Y.b(1);
                FrsFragment.this.o2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements d.a.n0.r0.e2.k {
        public e0() {
        }

        @Override // d.a.n0.r0.e2.k
        public void a(int i2, boolean z, int i3, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, boolean z3) {
            if (FrsFragment.this.a0 == null || FrsFragment.this.W == null || !FrsFragment.this.W.u0() || !z || z2 || z3) {
                return;
            }
            FrsFragment.this.a0.a(i3);
        }
    }

    /* loaded from: classes4.dex */
    public class e1 extends CustomMessageListener {
        public e1(int i2) {
            super(i2);
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
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.e3.w) || FrsFragment.this.C == null) {
                return;
            }
            FrsFragment.this.C.updateLikeData((d.a.n0.e3.w) customResponsedMessage.getData());
            FrsFragment.this.X.R(FrsFragment.this.C);
            FrsFragment.this.Y.d(FrsFragment.this.C, FrsFragment.this.W.R());
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
                FrsFragment.this.X.M(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f1 extends CustomMessageListener {
        public f1(int i2) {
            super(i2);
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
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i2) {
            super(i2);
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
        public g1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.m0.r.q.z) && FrsFragment.this.isResumed()) {
                d.a.m0.r.q.z zVar = (d.a.m0.r.q.z) customResponsedMessage.getData();
                if (FrsFragment.this.R0 == null) {
                    FrsFragment frsFragment = FrsFragment.this;
                    frsFragment.R0 = new d.a.n0.r0.k1.a(frsFragment.getPageContext());
                }
                if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || TextUtils.isEmpty(FrsFragment.this.C.getForum().getId())) {
                    return;
                }
                FrsFragment.this.R0.g(zVar.f53863a, FrsFragment.this.C.getForum().getId(), FrsFragment.this.C.getForum().getName(), zVar.f53864b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12638c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(FrsFragment.this.getActivity(), updateAttentionMessage.getData().l, FrsFragment.this.k1) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f12636a && updateAttentionMessage.getData().f12639d) {
                    d.a.c.e.p.l.L(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends CustomMessageListener {
        public h0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            if (j.k(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) == -1 || FrsFragment.this.C.getForum() == null) {
                return;
            }
            FrsFragment.this.C.getForum().setCanAddPhotoLivePost(true);
        }
    }

    /* loaded from: classes4.dex */
    public class h1 extends CustomMessageListener {
        public h1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var = (a2) customResponsedMessage.getData();
            if (a2Var == null || !FrsFragment.this.isResumed()) {
                return;
            }
            FrsFragment frsFragment = FrsFragment.this;
            frsFragment.T = a2Var.z1() + "";
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", a2Var.c0());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
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
        public final /* synthetic */ long f15120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f15121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f15122g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f15123h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f15124i;

        public i0(long j, int i2, int i3, float f2, int i4) {
            this.f15120e = j;
            this.f15121f = i2;
            this.f15122g = i3;
            this.f15123h = f2;
            this.f15124i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setParams(this.f15120e, 0L, 0L, this.f15121f, this.f15122g, this.f15123h, this.f15124i);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new d.a.n0.e3.h0.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
            }
        }

        public i1(int i2) {
            super(i2);
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
        public j(int i2) {
            super(i2);
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
            d.a.n0.e3.n0.a.o(FrsFragment.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public class j1 extends CustomMessageListener {
        public j1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.n0.h.g gVar = (d.a.n0.h.g) customResponsedMessage.getData();
            if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || FrsFragment.this.C.getForum().getDeletedReasonInfo() == null) {
                d.a.n0.h.d.d(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.C.getUserData());
                return;
            }
            d.a.n0.h.h hVar = new d.a.n0.h.h(FrsFragment.this.C.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.C.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.C.forumRule != null ? FrsFragment.this.C.forumRule.has_forum_rule.intValue() : 0);
            hVar.i(FrsFragment.this.C.getForum().getId(), FrsFragment.this.C.getForum().getName());
            hVar.h(FrsFragment.this.C.getForum().getImage_url());
            hVar.j(FrsFragment.this.C.getForum().getUser_level());
            d.a.n0.h.d.d(hVar.f(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.C.getUserData());
        }
    }

    /* loaded from: classes4.dex */
    public class k implements MessageQueue.IdleHandler {
        public k() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.b3();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f15131e;

        public k0(d.a.m0.r.s.a aVar) {
            this.f15131e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.r.s.a aVar = this.f15131e;
            if (aVar != null) {
                aVar.dismiss();
                FrsFragment.this.z3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k1 extends CustomMessageListener {
        public k1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || FrsFragment.this.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f15823b instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.Y.y().f15823b).isPrimary() || FrsFragment.this.x.B0()) {
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
        public l(int i2) {
            super(i2);
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
    public class l0 implements d.a.m0.r.e {
        public l0() {
        }

        @Override // d.a.m0.r.e
        public void onPermissionResult(boolean z) {
            if (z) {
                d.a.m0.x.d.h().o(true);
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
    public class l1 extends d.a.c.c.g.a {
        public l1(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
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
                        if (FrsFragment.this.G0 >= FrsFragment.this.M0.size()) {
                            FrsFragment.this.M0.addAll(arrayList);
                            return;
                        }
                        FrsFragment frsFragment = FrsFragment.this;
                        frsFragment.M0 = frsFragment.M0.subList(0, FrsFragment.this.G0);
                        FrsFragment.this.M0.addAll(arrayList);
                        return;
                    }
                    FrsFragment.this.M0 = new ArrayList();
                    FrsFragment.this.M0.addAll(arrayList);
                    FrsFragment.this.G0 = 0;
                    FrsFragment.this.J2();
                    return;
                }
                FrsFragment.this.M0 = new ArrayList();
                FrsFragment.this.G0 = 0;
                FrsFragment.this.M0.addAll(arrayList);
                FrsFragment.this.J2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
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
    public class m0 implements d.a.m0.r.e {
        public m0() {
        }

        @Override // d.a.m0.r.e
        public void onPermissionResult(boolean z) {
            if (z) {
                d.a.m0.x.d.h().o(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                if (FrsFragment.this.y != null) {
                    FrsFragment.this.y.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m1 extends CustomMessageListener {
        public m1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                FrsFragment.this.o2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends HttpMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || FrsFragment.this.getContext() == null || FrsFragment.this.x == null) {
                return;
            }
            int i2 = 0;
            if (httpResponsedMessage.getError() == 0) {
                BdTopToast bdTopToast = new BdTopToast(FrsFragment.this.getContext());
                bdTopToast.i(true);
                bdTopToast.h(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc));
                bdTopToast.j(FrsFragment.this.x.j0());
                if (d.a.n0.r0.a.h().k(d.a.n0.r0.a.h().e())) {
                    FrsCommonTabFragment frsCommonTabFragment = null;
                    if (FrsFragment.this.Y != null && FrsFragment.this.Y.y() != null && (FrsFragment.this.Y.y().f15823b instanceof FrsCommonTabFragment)) {
                        frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.Y.y().f15823b;
                    }
                    if (frsCommonTabFragment != null) {
                        frsCommonTabFragment.Y0();
                    }
                    FrsFragment.this.l2();
                    d.a.n0.r0.a.h().d();
                    for (d.a.c.k.e.n nVar : FrsFragment.this.C.getThreadList()) {
                        if (nVar instanceof z1) {
                            i2++;
                            continue;
                        }
                        if (i2 >= 6) {
                            break;
                        }
                    }
                    if (i2 < 6) {
                        FrsFragment.this.loadMore();
                    }
                }
                d.a.n0.r0.a.h().n();
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
            if (view.getId() == R.id.game_activity_egg_layout && d.a.c.e.p.l.D()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.x == null || !FrsFragment.this.x.x0()) {
                    String c2 = FrsFragment.this.C.getForum().getYuleData().b().c();
                    if (!StringUtils.isNull(c2)) {
                        d.a.m0.l.a.k(FrsFragment.this.getPageContext().getPageActivity(), c2);
                    }
                } else {
                    FrsFragment.this.x.z1();
                }
            }
            if (FrsFragment.this.x != null && view == FrsFragment.this.x.a0() && FrsFragment.this.W != null && FrsFragment.this.W.i0()) {
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
            if (d.a.c.e.p.j.z()) {
                if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null) {
                    return;
                }
                if (FrsFragment.this.x != null && view == FrsFragment.this.x.o0()) {
                    if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null || StringUtils.isNull(FrsFragment.this.C.getForum().getId()) || StringUtils.isNull(FrsFragment.this.C.getForum().getName())) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("fid", FrsFragment.this.C.getForum().getId()).param("obj_locate", 11));
                    d.a.n0.r0.n2.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.C, FrsFragment.this.C.getForum().getId());
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
            d.a.c.e.p.l.L(FrsFragment.this.getContext().getApplicationContext(), R.string.network_not_available);
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements d.a.n0.r0.t0 {
        public n1() {
        }

        @Override // d.a.n0.r0.t0
        public void a(int i2, int i3, d.a.n0.r0.c1 c1Var, ArrayList<d.a.c.k.e.n> arrayList) {
            FrsFragment.this.F3();
            if (FrsFragment.this.f0 != null) {
                FrsFragment.this.X.c0(FrsFragment.this.f0.e(i2));
            }
            d.a.n0.e3.f fVar = new d.a.n0.e3.f();
            if (c1Var != null) {
                boolean z = c1Var.f62098e == 0;
                fVar.f57648b = z;
                fVar.f57649c = c1Var.f62098e;
                fVar.f57650d = c1Var.f62099f;
                if (z) {
                    if (ListUtils.isEmpty(arrayList)) {
                        FrsFragment.this.x.q0();
                    } else if (c1Var.f62100g) {
                        if (ListUtils.getCount(FrsFragment.this.C.getThreadList()) > 3) {
                            FrsFragment.this.x.C1();
                        } else {
                            FrsFragment.this.x.y1();
                        }
                    } else if (c1Var.f62102i) {
                        FrsFragment.this.x.F1();
                    } else {
                        FrsFragment.this.x.q0();
                    }
                }
            } else {
                c1Var = new d.a.n0.r0.c1();
                c1Var.f63562c = 1;
                c1Var.f62100g = false;
                c1Var.f62102i = false;
            }
            if (i2 == 1) {
                FrsFragment.this.R = true;
                FrsFragment frsFragment = FrsFragment.this;
                frsFragment.v1.d(frsFragment.W.getType(), false, fVar);
            } else {
                FrsFragment.this.E3(fVar);
                if (FrsFragment.this.W.d0() != null) {
                    FrsFragment frsFragment2 = FrsFragment.this;
                    frsFragment2.C = frsFragment2.W.d0();
                }
                FrsFragment.this.Y2();
            }
            if (FrsFragment.this.I1 != null) {
                FrsFragment.this.I1.a(i2, i3, c1Var, arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends d.a.m0.f0.i<TopToastEvent> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.f0.b
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
        public int f15144a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f15145b = 0;

        public o0() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (FrsFragment.this.X != null) {
                FrsFragment.this.X.p0(i2);
                if (i2 == 1) {
                    FrsFragment.this.X.y();
                }
            }
            FrsFragment frsFragment = FrsFragment.this;
            if (frsFragment.Q == null && !frsFragment.N2()) {
                FrsFragment.this.Q = new d.a.m0.m0.b();
                FrsFragment.this.Q.a(1000);
            }
            if (i2 == 0) {
                d.a.m0.m0.b bVar = FrsFragment.this.Q;
                if (bVar != null) {
                    bVar.e();
                }
                d.a.n0.z.t.b().e(true);
                FrsFragment.this.S2(true);
                FrsFragment.this.x.F0(this.f15144a, this.f15145b);
            } else {
                d.a.m0.m0.b bVar2 = FrsFragment.this.Q;
                if (bVar2 != null) {
                    bVar2.d();
                }
            }
            if (FrsFragment.this.r0 != null) {
                FrsFragment.this.r0.i(recyclerView, i2);
            }
            if (i2 == 0) {
                d.a.n0.r0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.i(), false, null);
            }
            if (FrsFragment.this.Y != null && i2 == 1) {
                FrsFragment.this.Y.J();
            }
            if (FrsFragment.this.V == null) {
                if (FrsFragment.this.x.g0() != null && !FrsFragment.this.x.Y() && FrsFragment.this.x.g0().j() != null && (FrsFragment.this.x.g0().j().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment frsFragment2 = FrsFragment.this;
                    frsFragment2.V = (ThreadCardViewHolder) frsFragment2.x.g0().j().getTag();
                }
            } else if (i2 == 0 && FrsFragment.this.x.g0() != null && !FrsFragment.this.x.Y() && FrsFragment.this.x.g0().j() != null && (FrsFragment.this.x.g0().j().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment frsFragment3 = FrsFragment.this;
                frsFragment3.V = (ThreadCardViewHolder) frsFragment3.x.g0().j().getTag();
            }
            if (i2 == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FrsFragment.this.F0 += i3;
            if (FrsFragment.this.F0 >= FrsFragment.this.E0 * 2 && i3 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
            if (FrsFragment.this.g0 != null) {
                FrsFragment.this.g0.j();
            }
            this.f15144a = 0;
            this.f15145b = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                this.f15144a = bdRecyclerView.getFirstVisiblePosition();
                this.f15145b = bdRecyclerView.getLastVisiblePosition();
            }
            if (FrsFragment.this.r0 != null) {
                FrsFragment.this.r0.h(recyclerView, this.f15144a, this.f15145b);
            }
            if (FrsFragment.this.C == null || FrsFragment.this.x == null || FrsFragment.this.x.U() == null) {
                return;
            }
            FrsFragment.this.x.b1(this.f15144a, this.f15145b);
            if (FrsFragment.this.V == null || FrsFragment.this.V.b() == null) {
                return;
            }
            FrsFragment.this.V.b().o(FrsFragment.this.U);
        }
    }

    /* loaded from: classes4.dex */
    public final class o1 implements d.a.c.k.e.w {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f15148e;

            public a(o1 o1Var, String str) {
                this.f15148e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetWork netWork = new NetWork(this.f15148e);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.getNetData();
            }
        }

        public o1() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            boolean z;
            if (bdUniqueId == null) {
                return;
            }
            if (bdUniqueId == d.a.n0.r0.v.f63391e) {
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
                                if (StringUtils.isNull(a2) || !d.a.c.e.p.l.D()) {
                                    return;
                                }
                                d.a.m0.l.a.k(FrsFragment.this.getActivity(), a2);
                            }
                        } else if (a2Var.W() != null) {
                            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                ViewHelper.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                return;
                            }
                            d.a.m0.r.q.t W = a2Var.W();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), W.a(), W.b(), 2)));
                        } else {
                            d.a.n0.e3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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
                            String z1 = a2Var.z1();
                            if (z1 == null) {
                                z1 = "";
                            }
                            if (a2Var.y0() == 2 && !z1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{z1, "", null});
                                return;
                            }
                            if (z1.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && z1.length() > 4) {
                                a2Var.I3(z1.substring(3));
                            }
                            if (bdUniqueId.getId() == a2.F3.getId()) {
                                d.a.n0.r0.n2.l.c(a2Var.q1());
                            } else if (bdUniqueId.getId() == a2.o3.getId()) {
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                statisticItem.param("obj_type", "2");
                                statisticItem.param("tid", a2Var.z1());
                                TiebaStatic.log(statisticItem);
                            }
                            d.a.n0.r0.n2.m.e(FrsFragment.this, a2Var, i2, z);
                            FrsFragment frsFragment = FrsFragment.this;
                            d.a.n0.r0.n2.l.d(frsFragment, frsFragment.C, a2Var);
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
        public p(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.O3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 implements d.a.n0.r0.f {
        public p0() {
        }

        @Override // d.a.n0.r0.f
        public void a(int i2, int i3, View view, View view2, a2 a2Var) {
            if (i2 != FrsFragment.this.x.U().c()) {
                if (i2 != FrsFragment.this.x.U().j()) {
                    if (i2 != FrsFragment.this.x.U().i() || FrsFragment.this.C == null || FrsFragment.this.C.getUserData() == null || !FrsFragment.this.C.getUserData().isBawu()) {
                        return;
                    }
                    String bawuCenterUrl = FrsFragment.this.C.getBawuCenterUrl();
                    if (d.a.c.e.p.k.isEmpty(bawuCenterUrl) || FrsFragment.this.C.getForum() == null) {
                        return;
                    }
                    d.a.m0.l.a.l(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", FrsFragment.this.C.getForum().getId()).param("uid", FrsFragment.this.C.getUserData().getUserId()));
                } else if (ViewHelper.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.C == null || FrsFragment.this.C.getForum() == null) {
                        return;
                    }
                    ForumData forum = FrsFragment.this.C.getForum();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), d.a.c.e.m.b.f(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                }
            } else if (ViewHelper.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                d.a.n0.r0.n2.m.d(FrsFragment.this.getPageContext(), FrsFragment.this.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public q(int i2) {
            super(i2);
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
            if (FrsFragment.this.W.b0() == 1 && z && !FrsFragment.this.x.Y()) {
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
        public r(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TbadkApplication.getInst().getCurrentActivity() == null || d.a.c.e.p.k.isEmpty(str) || !str.equals(FrsFragment.this.p)) {
                return;
            }
            d.a.n0.r0.n2.i.d(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.C);
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public r0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || FrsFragment.this.z == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.Y.H() == 0 || FrsFragment.this.Y.y() == null || !(FrsFragment.this.Y.y().f15823b instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.Y.y().f15823b).isPrimary() || FrsFragment.this.x.B0() || d.a.m0.x.d.h().k()) {
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
    public class s implements d.a.n0.e3.s {

        /* renamed from: a  reason: collision with root package name */
        public long f15155a = 0;

        public s() {
        }

        @Override // d.a.n0.e3.s
        public void a(int i2) {
            this.f15155a = System.nanoTime();
            if (FrsFragment.this.x == null) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                FrsFragment.this.x.D0();
            }
        }

        @Override // d.a.n0.e3.s
        public void b() {
            FrsFragment.this.b3();
        }

        @Override // d.a.n0.e3.s
        public void c(d.a.n0.e3.m mVar) {
            if ((mVar == null || !("normal_page".equals(FrsFragment.this.W.Z()) || "frs_page".equals(FrsFragment.this.W.Z()) || "book_page".equals(FrsFragment.this.W.Z()))) && !"brand_page".equals(FrsFragment.this.W.Z())) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, mVar));
            FrsFragment.this.c3(mVar);
            FrsFragment.V1 = mVar;
        }

        @Override // d.a.n0.e3.s
        public void d(int i2, boolean z, d.a.n0.e3.f fVar) {
            if (FrsFragment.this.e0) {
                FrsFragment.this.e0 = false;
                d.a.n0.r0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.i(), false, null);
            }
            FrsFragment.this.F3();
            FrsFragment.this.P = true;
            if (fVar != null && fVar.f57648b) {
                FrsFragment.this.x.U().n(TbImageHelper.getInstance().isShowBigImage());
                FrsFragment.W1 = 0L;
                FrsFragment.X1 = 0L;
                FrsFragment.Y1 = 0;
            } else {
                FrsFragment.Y1 = 1;
            }
            if (!FrsFragment.this.W.u0() && (i2 == 3 || i2 == 6)) {
                FrsFragment.this.i0.k();
            }
            FrsFragment.this.G = System.currentTimeMillis();
            if (FrsFragment.this.W.d0() != null) {
                FrsFragment frsFragment = FrsFragment.this;
                frsFragment.C = frsFragment.W.d0();
            }
            FrsFragment.this.D3(1);
            FrsFragment.this.w3();
            if (i2 == 7) {
                FrsFragment.this.a3(FrsFragment.this.C.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.C.getPage() != null) {
                FrsFragment frsFragment2 = FrsFragment.this;
                frsFragment2.j3(frsFragment2.C.getPage().b());
            }
            if (i2 == 4) {
                if (!FrsFragment.this.W.u0() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.W.b0() == 1 && !d.a.n0.t0.a.d()) {
                    FrsFragment.this.C.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<d.a.c.k.e.n> c2 = FrsFragment.this.i0.c(false, false, FrsFragment.this.C.getThreadList(), FrsFragment.this.s, false);
                if (c2 != null) {
                    FrsFragment.this.C.setThreadList(c2);
                    FrsFragment.this.C.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.W != null) {
                    d.a.n0.r0.j2.c.l(FrsFragment.this.C, FrsFragment.this.W.R(), 2, FrsFragment.this.getContext());
                }
                FrsFragment frsFragment3 = FrsFragment.this;
                d.a.n0.r0.n2.a.a(frsFragment3, frsFragment3.C.getForum(), FrsFragment.this.C.getThreadList(), false, FrsFragment.this.z2());
                FrsFragment.this.x.v1(c2, FrsFragment.this.C);
                FrsFragment.this.H3();
                return;
            }
            FrsFragment.this.H3();
            if (i2 == 1) {
                FrsFragment.this.x.D0();
            } else if (i2 == 2) {
                FrsFragment.this.x.D0();
            } else if (i2 == 3 || i2 == 6) {
                if (FrsFragment.this.C != null) {
                    FrsFragment.this.C.clearPostThreadCount();
                }
                d.a.n0.r0.o2.c cVar = FrsFragment.this.n0;
                if (cVar != null) {
                    cVar.d();
                }
            }
            FrsFragment.this.N3();
            if (fVar == null || fVar.f57649c == 0) {
                if (FrsFragment.this.C == null) {
                    return;
                }
                FrsFragment frsFragment4 = FrsFragment.this;
                frsFragment4.x3(frsFragment4.C);
                FrsFragment.this.W2(false, i2 == 5);
                if (FrsFragment.this.W != null) {
                    if (FrsFragment.this.C.getActivityHeadData() != null && FrsFragment.this.C.getActivityHeadData().a() != null && FrsFragment.this.C.getActivityHeadData().a().size() > 0) {
                        d.a.n0.r0.j2.a.e(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.C.getForum(), FrsFragment.this.W.a0(), 1);
                    }
                    if (FrsFragment.this.C.getThreadList() != null && FrsFragment.this.C.getThreadList().size() > 0) {
                        Iterator<d.a.c.k.e.n> it = FrsFragment.this.C.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d.a.c.k.e.n next = it.next();
                            if ((next instanceof a2) && ((a2) next).getType() == a2.F3) {
                                d.a.n0.r0.j2.a.e(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.C.getForum(), FrsFragment.this.W.a0(), 2);
                                break;
                            }
                        }
                    }
                    d.a.n0.r0.j2.a.f(FrsFragment.this.getUniqueId(), FrsFragment.this.C.getThreadList(), FrsFragment.this.C.getForum(), FrsFragment.this.W.a0());
                }
                FrsFragment.this.x.O0(i2);
                FrsFragment.W1 = (System.nanoTime() - this.f15155a) / 1000000;
                if (fVar != null) {
                    FrsFragment.X1 = fVar.f57651e;
                }
            } else if (FrsFragment.this.C == null || ListUtils.isEmpty(FrsFragment.this.C.getThreadList())) {
                FrsFragment.this.E3(fVar);
            } else if (fVar.f57647a) {
                FrsFragment frsFragment5 = FrsFragment.this;
                frsFragment5.showToast(frsFragment5.getPageContext().getResources().getString(R.string.net_error_text, fVar.f57650d, Integer.valueOf(fVar.f57649c)));
            }
            FrsFragment.this.K3();
            FrsFragment.this.j2();
            if (FrsFragment.this.C.getAccessFlag() == 1) {
                TiebaStatic.log(new StatisticItem("c11384"));
            }
            if (FrsFragment.this.t && FrsFragment.this.Y.b(49)) {
                FrsFragment.this.t = false;
            }
            System.gc();
        }
    }

    /* loaded from: classes4.dex */
    public class s0 extends CustomMessageListener {
        public s0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                d.a.n0.r0.n2.c.a(customResponsedMessage, FrsFragment.this.x, FrsFragment.this.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrivateForumPopInfoData f15158e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f15159f;

        public t(PrivateForumPopInfoData privateForumPopInfoData, d.a.m0.r.s.a aVar) {
            this.f15158e = privateForumPopInfoData;
            this.f15159f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{this.f15158e.z()});
            this.f15159f.dismiss();
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
                if (y != null && (fragment = y.f15823b) != null && (fragment instanceof d.a.n0.r0.q0)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                    ((d.a.n0.r0.q0) y.f15823b).E0();
                    ((d.a.n0.r0.q0) y.f15823b).u();
                    return;
                }
                FrsFragment.this.B0().K1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements a.e {
        public u() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class u0 implements d.a.n0.r0.t0 {

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

        @Override // d.a.n0.r0.t0
        public void a(int i2, int i3, d.a.n0.r0.c1 c1Var, ArrayList<d.a.c.k.e.n> arrayList) {
            d.a.c.e.m.e.a().post(new a());
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public v(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2016495) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof a2) {
                d.a.n0.r0.n2.l.b(FrsFragment.this.x, FrsFragment.this.C, FrsFragment.this.i(), true, (a2) data);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends CustomMessageListener {
        public v0(int i2) {
            super(i2);
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
        public final /* synthetic */ int f15167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15168f;

        public w(int i2, String str) {
            this.f15167e = i2;
            this.f15168f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13387").param("fid", FrsFragment.this.p).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.f15167e));
            UrlManager.getInstance().dealOneLink(FrsFragment.this.getPageContext(), new String[]{this.f15168f});
        }
    }

    /* loaded from: classes4.dex */
    public class w0 extends CustomMessageListener {
        public w0(int i2) {
            super(i2);
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
                FrsFragment.this.V.b().o(new a.C0600a(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FrsFragment.this.P || !d.a.c.e.p.j.z() || FrsFragment.this.x.A0()) {
                return;
            }
            FrsFragment.this.x.Q0();
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public x0(int i2) {
            super(i2);
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
        public y0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.z != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.Y.H() == 0 || FrsFragment.this.x.B0() || d.a.m0.x.d.h().k()) {
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
        public z(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.m0.t.n) || StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            FrsFragment.this.C.updateCurrentUserPendant((d.a.m0.t.n) customResponsedMessage.getData());
            FrsFragment.this.x.U().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class z0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveHorseRaceData f15176e;

        public z0(LiveHorseRaceData liveHorseRaceData) {
            this.f15176e = liveHorseRaceData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "";
            if (FrsFragment.this.C != null && FrsFragment.this.C.getForum() != null) {
                str = FrsFragment.this.C.getForum().getName();
            }
            TiebaStatic.log(new StatisticItem("c13744").param("obj_source", 1).param("fid", FrsFragment.this.p).param("fname", str));
            AlaInfoData alaInfoData = new AlaInfoData();
            if (this.f15176e.getLive_id() != null) {
                alaInfoData.live_id = this.f15176e.getLive_id().longValue();
                alaInfoData.screen_direction = this.f15176e.getScreen_direction().intValue();
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(FrsFragment.this.getContext(), alaLiveInfoCoreData, "live_paomadeng", FrsFragment.this.p)));
            }
        }
    }

    public View A2() {
        return this.w;
    }

    public final void A3() {
        d.a.m0.x.d.h().m(new d.a.m0.x.b(getContext()));
        d.a.m0.x.d.h().n(85, 0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (d.a.m0.x.d.h().j()) {
            getPageContext().getOrignalPage().grantWindowPermission(new m0(), true);
        }
    }

    @Override // d.a.n0.r0.e2.l
    public d.a.n0.r0.r B0() {
        return this.x;
    }

    public FrsTabViewController B2() {
        return this.Y;
    }

    public void B3(View view, String str, boolean z2, List<RecmForumInfo> list) {
        this.x.P0();
        this.x.d1(8);
        if (this.q0 == null) {
            this.q0 = new d.a.n0.r0.r2.a(getPageContext(), getNetRefreshListener());
        }
        this.q0.c(str);
        this.q0.b(list);
        this.q0.attachView(view, z2);
    }

    public final FrsTabInfoData C2() {
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

    public void C3(String str, String str2, String str3) {
        d.a.n0.r0.n2.e eVar = new d.a.n0.r0.n2.e(str, str2);
        this.T0 = eVar;
        eVar.f(getFragmentActivity(), str3, str2);
    }

    public String D2() {
        return this.o;
    }

    public final void D3(int i2) {
        FrsViewData frsViewData;
        List<WindowToast> list;
        if (!TbadkCoreApplication.isLogin() || (frsViewData = this.C) == null || (list = frsViewData.mWindowToast) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            WindowToast windowToast = list.get(i3);
            if (windowToast != null && windowToast.toast_type.intValue() == i2) {
                if (d.a.c.e.p.k.isEmpty(windowToast.toast_link)) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", d.a.m0.z0.n0.a(windowToast.toast_link), true)));
                return;
            }
        }
    }

    public OvalActionButton E2() {
        return this.y;
    }

    public final void E3(d.a.n0.e3.f fVar) {
        if (fVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.x.P0();
            showNetRefreshView(this.x.j0(), string, true);
        } else if (340001 == fVar.f57649c) {
            J3(fVar, this.C.getRecm_forum_list());
        } else {
            if (ListUtils.isEmpty(this.C.getThreadList())) {
                I3(fVar);
            }
            if (N2()) {
                setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public FRSRefreshButton F2() {
        return this.z;
    }

    public void F3() {
        hideLoadingView(this.x.j0());
        this.x.M1();
        if (this.x.i0() instanceof d.a.n0.r0.k2.c) {
            ((d.a.n0.r0.k2.c) this.x.i0()).d();
        }
    }

    @Override // d.a.n0.t2.u
    public String G() {
        return this.p;
    }

    public int G2() {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar == null) {
            return -1;
        }
        return cVar.h();
    }

    public final void G3() {
        if (G2() != 1 && !this.i0.b(this.C.getThreadListIds())) {
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

    @Override // d.a.n0.r0.o0
    public void H() {
        if (isAdded() && this.e0 && isLoadingViewAttached()) {
            hideLoadingView(this.x.j0());
        }
    }

    public void H2() {
        if (getFragmentActivity() == null || getFragmentActivity().getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
    }

    public final void H3() {
        if (G2() == 0 && ListUtils.isEmpty(this.C.getThreadListIds())) {
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

    @Override // d.a.n0.r0.o0
    public void I() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void I2() {
        FRSRefreshButton fRSRefreshButton = this.z;
        if (fRSRefreshButton != null) {
            fRSRefreshButton.b();
        }
    }

    public final void I3(d.a.n0.e3.f fVar) {
        this.x.P0();
        if (fVar.f57647a) {
            showNetRefreshView(this.x.j0(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.f57650d, Integer.valueOf(fVar.f57649c)}), true);
        } else {
            showNetRefreshView(this.x.V().n(), fVar.f57650d, true);
        }
    }

    public final void J2() {
        List<LiveHorseRaceData> list;
        String format;
        if (!isResumed() || (list = this.M0) == null || list.size() < 1 || this.G0 > this.M0.size() - 1) {
            return;
        }
        LiveHorseRaceData liveHorseRaceData = this.M0.get(this.G0);
        if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
            this.G0++;
            J2();
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
            d.a.c.e.m.e.a().postDelayed(this.O0, 5000L);
            if (this.A.getChildCount() == 0) {
                this.G0++;
                this.A.addView(frsRedpackRunView);
                FrsViewData frsViewData = this.C;
                String str = "";
                if (frsViewData != null && frsViewData.getForum() != null) {
                    str = this.C.getForum().getName();
                }
                TiebaStatic.log(new StatisticItem("c13743").param("obj_source", 1).param("fid", this.p).param("fname", str));
            }
            LinearLayout linearLayout = this.A;
            if (linearLayout == null || linearLayout.getVisibility() != 8 || !((BaseFragment) this.Y.y().f15823b).isPrimary() || this.x.B0() || this.N) {
                return;
            }
            this.A.setVisibility(0);
        }
    }

    public final void J3(d.a.n0.e3.f fVar, List<RecmForumInfo> list) {
        d.a.n0.r0.r rVar = this.x;
        if (rVar != null) {
            rVar.P0();
            this.x.w1(this.j);
            if (this.x.V() != null) {
                B3(this.x.j0(), fVar.f57650d, true, list);
            }
        }
    }

    public final void K2(Bundle bundle) {
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
        this.X.H(bundle);
        n2(j2);
    }

    public final void K3() {
        boolean a2;
        if (h2()) {
            return;
        }
        PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
        privateForumPopInfoData.A(this.C.getPrivateForumTotalInfo().c());
        FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
        if (this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1 && (d.a.c.e.p.k.isEmpty(privateForumPopInfoData.y()) || privateForumPopInfoData.x() != Integer.valueOf(this.p))) {
            privateForumPopInfoData.D("create_success");
            privateForumPopInfoData.B(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
            privateForumPopInfoData.E("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.p + "&fn=" + this.j + "&nomenu=1");
            privateForumPopInfoData.C(Integer.valueOf(this.p));
            a2 = frsPrivateCommonDialogView.a(privateForumPopInfoData);
        } else {
            a2 = privateForumPopInfoData.x() == Integer.valueOf(this.p) ? frsPrivateCommonDialogView.a(privateForumPopInfoData) : false;
        }
        if (a2) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
            aVar.setContentViewSize(2);
            aVar.setContentView(frsPrivateCommonDialogView);
            aVar.setCanceledOnTouchOutside(false);
            frsPrivateCommonDialogView.setConfirmButton(new t(privateForumPopInfoData, aVar));
            aVar.setCloseButton(new u());
            aVar.create(getPageContext()).show();
        }
    }

    public final void L2() {
        if (this.l == 0) {
            this.x.w1(this.j);
        } else {
            this.x.w1("");
            this.l = 1;
        }
        this.x.s1(this.H1);
        this.x.H(this.D1);
        this.x.t1(this.F1);
        this.x.U().l(this.E1);
    }

    public void L3() {
        FRSRefreshButton fRSRefreshButton = this.z;
        if (fRSRefreshButton != null) {
            fRSRefreshButton.f();
        }
    }

    public boolean M2() {
        return this.u;
    }

    public void M3(String str) {
        BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
        bdTopToast.i(true);
        bdTopToast.h(str);
        bdTopToast.j(this.x.j0());
    }

    public boolean N2() {
        return this.f15083h;
    }

    public final void N3() {
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

    public final boolean O2() {
        if (j0() == null) {
            return false;
        }
        FrsViewData j02 = j0();
        d.a.m0.r.q.a0 a0Var = null;
        if (j02.getStar() != null && !StringUtils.isNull(j02.getStar().a())) {
            a0Var = new d.a.m0.r.q.a0();
        } else if (j02.getActivityHeadData() != null && ListUtils.getCount(j02.getActivityHeadData().a()) >= 1) {
            a0Var = j02.getActivityHeadData().a().get(0);
        }
        return a0Var != null;
    }

    public final void O3() {
        if (d.a.c.e.p.k.isEmpty(this.p)) {
            return;
        }
        d.a.m0.a.d.y().O(d.a.m0.a.c.X, d.a.c.e.m.b.f(this.p, 0L));
    }

    @Override // d.a.n0.t2.u
    public void P() {
        e0().R0();
    }

    public boolean P2() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void P3() {
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    public boolean Q2() {
        if (j0() == null) {
            return false;
        }
        FrsViewData j02 = j0();
        return (ListUtils.isEmpty(j02.getShowTopThreadList()) && j02.getBusinessPromot() == null) ? false : true;
    }

    public void Q3() {
        if (PermissionUtil.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            return;
        }
        SelectImageHelper.takePhoto(getPageContext());
    }

    @Override // d.a.n0.r0.e2.l
    public d.a.n0.r0.o2.h R() {
        return this.X;
    }

    public void R2(Object obj) {
        d.a.c.a.e eVar;
        d.a.n0.r0.e2.b bVar = this.b0;
        if (bVar == null || (eVar = bVar.j) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void R3(Object obj) {
        d.a.c.a.e eVar;
        d.a.n0.r0.e2.b bVar = this.b0;
        if (bVar == null || (eVar = bVar.f62153i) == null) {
            return;
        }
        eVar.c(obj);
    }

    public void S2(boolean z2) {
        d.a.n0.d3.c.g().h(getUniqueId(), z2);
    }

    public void S3(int i2) {
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
                d.a.n0.r0.n2.n.b(this, 0);
            } else {
                this.x.G1();
            }
        }
    }

    public boolean T2() {
        return O2() && !Q2();
    }

    public void U2(String str) {
        if (!TbadkCoreApplication.isLogin() || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        if (this.z0 == null) {
            this.z0 = new AddExperiencedModel(p());
        }
        this.z0.A(this.p, str);
    }

    public final void V2() {
        if (this.l == 1) {
            d.a.c.e.m.h.a().b(new j0());
        }
        this.l = 0;
    }

    public final void W2(boolean z2, boolean z3) {
        try {
            if (this.C != null && this.Y != null && this.W != null) {
                if (!this.x.U().k(a2.k3)) {
                    this.C.removeAlaLiveThreadData();
                }
                boolean isEmpty = ListUtils.isEmpty(this.C.getGameTabInfo());
                this.x.i1(isEmpty);
                if (!isEmpty) {
                    if (this.r0 == null) {
                        this.r0 = new d.a.n0.r0.o2.e(this, (NoPressedRelativeLayout) this.w);
                    }
                    if (this.t0 == null) {
                        this.t0 = new d.a.n0.r0.x1.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
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
                    this.Y.d(this.C, this.W.R());
                }
                if (z2) {
                    c2(true, z2);
                } else {
                    c2(this.R, z2);
                }
                Z2();
                if (this.f0 != null) {
                    this.f0.a(this.X, this.C);
                }
                if (this.C.getPage() != null) {
                    j3(this.C.getPage().b());
                }
                ArrayList<d.a.c.k.e.n> d2 = this.i0.d(z3, true, this.C.getThreadList(), null, z2, false);
                if (d2 != null) {
                    this.C.setThreadList(d2);
                }
                this.C.removeRedundantUserRecommendData();
                int topThreadSize = this.C.getTopThreadSize();
                this.q = topThreadSize;
                if (this.s != null) {
                    this.r = true;
                    this.s.e(topThreadSize);
                    d.a.n0.r0.n2.a.a(this, this.C.getForum(), this.C.getThreadList(), this.r, z2());
                }
                if (this.W.b0() == 1) {
                    Y2();
                    if (!z2 && this.W.getPn() == 1) {
                        d3();
                    }
                }
                if (this.g0 != null) {
                    this.g0.k(this.Y.D());
                }
                F3();
                this.x.X0();
                this.x.f1(true, false);
                if (z2 && this.C.isFirstTabEqualAllThread()) {
                    d.a.c.e.m.e.a().post(new x());
                }
                if (this.C.getForum() != null) {
                    this.x.L(this.C.getForum().getWarningMsg());
                }
                if (this.C != null && this.C.getFrsVideoActivityData() != null && d.a.m0.r.d0.b.j().l("frs_video_activity_guide", 0L) == 0) {
                    d.a.c.e.m.e.a().postDelayed(new y(), 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.x.x1();
                if (this.C != null && this.C.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.C.getForum().getId(), this.C.getForum().getName(), this.C.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.C.getForum().special_forum_type), this.C.getForum().getThemeColorInfo(), this.C.getForum().getMember_num())));
                }
                this.w0.e(this.C.bottomMenuList, this.C.getForum());
                O3();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void X2(int i2) {
        this.P = false;
        P3();
        d.a.n0.r0.r rVar = this.x;
        if (rVar != null && rVar.g0() != null) {
            this.x.g0().w();
        }
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            frsModelController.G0(i2, true);
        }
    }

    public final void Y2() {
        P3();
        try {
            if (this.C == null) {
                return;
            }
            this.x.B1();
            this.x.J1(g2());
            if (d.a.n0.r0.o2.h.G(this.C)) {
                d.a.n0.r0.o2.h.F(this.C);
            }
            if (this.C.getForum() != null) {
                this.j = this.C.getForum().getName();
                this.p = this.C.getForum().getId();
            }
            if (this.C.getPage() != null) {
                j3(this.C.getPage().b());
            }
            this.x.w1(this.j);
            this.x.c1(this.j);
            TbadkCoreApplication.getInst().setDefaultBubble(this.C.getUserData().getBimg_url());
            TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.C.getUserData().getBimg_end_time());
            V2();
            s3();
            ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
            if (threadList != null) {
                this.x.v1(threadList, this.C);
                d.a.n0.r0.n2.c.b(this.x);
                this.X.m0(w0());
                this.X.R(this.C);
                this.Y.d(this.C, this.W.R());
                this.x.Y0();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean Z2() {
        FrsModelController frsModelController;
        d.a.n0.r0.o2.h hVar = this.X;
        if (hVar != null && (frsModelController = this.W) != null) {
            hVar.w0(frsModelController.Z(), this.C);
        }
        FrsViewData frsViewData = this.C;
        boolean hasTab = frsViewData != null ? frsViewData.hasTab() : false;
        d2();
        d.a.n0.r0.r rVar = this.x;
        if (rVar != null) {
            rVar.t0();
            this.x.u0();
        }
        return hasTab;
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void a(ArrayList<d.a.c.k.e.n> arrayList) {
        boolean isEmpty = ListUtils.isEmpty(arrayList);
        j3(!isEmpty ? 1 : 0);
        G3();
        if (isEmpty) {
            return;
        }
        if (!this.W.u0() && TbadkCoreApplication.getInst().isRecAppExist() && this.W.b0() == 1 && !d.a.n0.t0.a.d()) {
            this.C.addRecommendAppToThreadList(this, arrayList);
        }
        if (this.W != null) {
            d.a.n0.r0.j2.a.f(getUniqueId(), arrayList, this.C.getForum(), this.W.a0());
        }
        ArrayList<d.a.c.k.e.n> c2 = this.i0.c(false, false, arrayList, this.s, false);
        if (c2 != null) {
            this.C.setThreadList(c2);
            this.x.v1(c2, this.C);
        }
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            d.a.n0.r0.j2.c.l(this.C, frsModelController.R(), 2, getContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.C.getForum()));
    }

    public final void a3(int i2) {
        Z2();
        P3();
        try {
            if (this.C == null) {
                return;
            }
            d.a.n0.r0.z0 z0Var = null;
            this.x.v1(null, this.C);
            this.X.m0(1);
            this.x.Y0();
            this.Y.d(this.C, this.W.R());
            d.a.n0.r0.k2.d G = this.Y.G(this.C.getFrsDefaultTabId());
            if (G != null && !TextUtils.isEmpty(G.f62503d)) {
                z0Var = new d.a.n0.r0.z0();
                String str = G.f62503d;
                String str2 = G.f62500a;
            }
            this.W.q(this.C.getFrsDefaultTabId(), 0, z0Var);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b3() {
        FrsModelController frsModelController = this.W;
        if (frsModelController == null || frsModelController.b0() != 1) {
            return;
        }
        this.X.V(this.C);
    }

    public final void c2(boolean z2, boolean z3) {
        FrsModelController frsModelController = this.W;
        if (frsModelController == null || this.C == null || this.x == null || !z2) {
            return;
        }
        if (!frsModelController.u0() && this.W.b0() == 1) {
            if (!this.W.r0()) {
                this.C.addCardVideoInfoToThreadList();
                this.C.addVideoInfoToThreadListInTenAndFifteenFloor();
            }
            if (!(this.x.U().k(d.a.n0.z.e0.n.k) ? this.C.addHotTopicDataToThreadList() : false)) {
                this.C.addFeedForumDataToThreadList();
            }
            if (TbadkCoreApplication.getInst().isRecAppExist() && !d.a.n0.t0.a.d()) {
                this.C.addRecommendAppToThreadList(this);
            }
            if (!this.x.U().k(a2.k3)) {
                this.C.removeAlaLiveThreadData();
            }
            this.C.addSchoolRecommendToThreadList();
        }
        if (!this.x.U().k(a2.k3)) {
            this.C.removeAlaInsertLiveData();
            this.C.removeAlaStageLiveDat();
        } else {
            this.C.addInsertLiveDataToThreadList();
            this.C.addStageLiveDataToThreadList();
        }
        this.C.checkLiveStageInThreadList();
        this.C.addNoticeThreadToThreadList();
        if (this.x.U().k(d.a.n0.u0.b.f65023i)) {
            this.C.addGameRankListToThreadList(z3);
        }
        if (TbadkCoreApplication.isLogin() && (!this.W.u0() || this.W.isNetFirstLoad)) {
            this.C.addUserRecommendToThreadList();
        }
        this.C.addVideoActivityToTop();
    }

    public final void c3(d.a.n0.e3.m mVar) {
        try {
            if (!this.P && mVar != null && this.C != null) {
                this.C.receiveData(mVar);
                W2(true, false);
                Looper.myQueue().addIdleHandler(this.U0);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final void d2() {
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            e2(frsModelController.Z());
        } else {
            e2("normal_page");
        }
    }

    public void d3() {
        if (this.l0 == null) {
            this.l0 = new d.a.n0.r0.c2.a(this, d.a.c.e.m.b.d(this.p, 0));
        }
        this.l0.w();
    }

    @Override // d.a.n0.e.e.b
    public void dispatchInjectPluginMessage(d.a.n0.e.d dVar) {
        this.m0.a(dVar);
    }

    @Override // d.a.n0.r0.e2.l
    public FrsModelController e0() {
        return this.W;
    }

    public final void e2(String str) {
        m3("frs_page".equals(str));
        d.a.n0.r0.n1.e.b bVar = this.f0;
        if (bVar != null) {
            bVar.c(this.X, this.x, this.C);
        }
    }

    public void e3(boolean z2) {
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController != null) {
            frsTabViewController.z = z2;
        }
    }

    public boolean f2() {
        return this.f15084i;
    }

    public void f3() {
        FrsTabViewController.o y2;
        Fragment fragment;
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController == null || (y2 = frsTabViewController.y()) == null || (fragment = y2.f15823b) == null || !(fragment instanceof d.a.n0.r0.q0)) {
            return;
        }
        ((d.a.n0.r0.q0) fragment).E0();
    }

    public boolean g2() {
        if (this.S && !this.C0) {
            FrsModelController frsModelController = this.W;
            return (frsModelController != null && frsModelController.U() && (d.a.n0.r0.b.e().g() || d.a.n0.r0.a.h().j())) ? false : true;
        }
        return false;
    }

    public void g3(boolean z2) {
        this.f15084i = z2;
    }

    @Override // d.a.n0.e.e.b
    public d.a.n0.e.e.a getInjectPlugin(int i2) {
        return this.d0.get(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.n0.r0.d2.a
    public /* bridge */ /* synthetic */ d.a.c.a.f getPageContext() {
        return super.getPageContext();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.o y2;
        if (B2() != null && (y2 = B2().y()) != null) {
            Fragment fragment = y2.f15823b;
            if (fragment instanceof BaseFragment) {
                if (fragment instanceof FrsAllThreadFragment) {
                    TbPageTag tbPageTag = super.getTbPageTag();
                    FrsViewData frsViewData = this.C;
                    tbPageTag.sortType = d.a.n0.r0.n2.k.g(frsViewData != null ? frsViewData.getSortType() : -1);
                    tbPageTag.locatePage = "a070";
                    if (this.f15080e.equals(y2.f15824c)) {
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
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
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

    @Override // d.a.n0.r0.d2.a, d.a.n0.r0.u0
    public String h() {
        return this.j;
    }

    @Override // d.a.n0.r0.r0
    public NavigationBar h0() {
        d.a.n0.r0.r rVar = this.x;
        if (rVar == null) {
            return null;
        }
        return rVar.c0();
    }

    public final boolean h2() {
        FrsViewData frsViewData = this.C;
        return frsViewData == null || frsViewData.getPrivateForumTotalInfo() == null || this.C.getPrivateForumTotalInfo().a() == null || this.C.getUserData().getIs_manager() != 1;
    }

    public void h3(int i2) {
        this.l = i2;
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

    @Override // d.a.n0.r0.u0
    public String i() {
        return this.p;
    }

    public void i2() {
        d.a.n0.r0.n2.m.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.k);
    }

    public void i3(String str) {
        this.j = str;
    }

    @Override // d.a.n0.r0.d2.a
    public FrsViewData j0() {
        return this.C;
    }

    public final void j2() {
        if (!h2() && this.C.getPrivateForumTotalInfo().a().private_forum_status.intValue() == 1) {
            k3(this.C.getPrivateForumTotalInfo().a().private_forum_audit_status, this.C.getPrivateForumTotalInfo().b(), false);
        } else {
            k3(null, null, true);
        }
    }

    public void j3(int i2) {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar == null) {
            return;
        }
        cVar.m(i2);
    }

    public final void k2(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList) || this.x.Z() == null || this.x.Z().getData() == null) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = threadList.iterator();
        List<d.a.c.k.e.n> data = this.x.Z().getData();
        int i2 = 0;
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
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

    public void k3(Integer num, Integer num2, boolean z2) {
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

    public final void l2() {
        if (ListUtils.isEmpty(d.a.n0.r0.a.h().i()) || this.x.Z() == null || this.x.Z().getData() == null) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.C.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = threadList.iterator();
        List<d.a.c.k.e.n> data = this.x.Z().getData();
        int count = ListUtils.getCount(d.a.n0.r0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof z1) {
                a2 a2Var = ((z1) next).w;
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(d.a.n0.r0.a.h().i().get(i3).o0(), a2Var.o0())) {
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

    public void l3(boolean z2) {
        this.S = z2;
    }

    @Override // d.a.n0.r0.e2.l
    public void loadMore() {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar != null) {
            cVar.i(this.j, this.p, this.C);
        }
    }

    public final void m2(int i2) {
        FrsViewData frsViewData = this.C;
        String id = (frsViewData == null || frsViewData.getForum() == null) ? "" : this.C.getForum().getId();
        if (StringUtils.isNull(id)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13008").param("fid", id).param("obj_type", "4").param("obj_locate", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void m3(boolean z2) {
        d.a.n0.r0.o2.j jVar = this.j0;
        if (jVar != null) {
            jVar.d0();
        }
    }

    public final void n2(long j2) {
        if (j2 > 0) {
            d.a.c.e.m.e.a().postDelayed(new i0(j2, d.a.c.e.p.l.k(TbadkCoreApplication.getInst()), d.a.c.e.p.l.i(TbadkCoreApplication.getInst()), TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density, TbImageHelper.getInstance().isShowBigImage() ? 2 : 1), 1000L);
        }
    }

    public void n3(boolean z2) {
        this.C0 = z2;
    }

    public final void o2() {
        this.x.K1();
    }

    public void o3() {
        if (this.C == null) {
            return;
        }
        d.a.n0.r0.j2.b bVar = new d.a.n0.r0.j2.b();
        if (this.C.needLog == 1) {
            bVar.f62465a = true;
        } else {
            bVar.f62465a = false;
        }
        if (this.C.getForum() != null) {
            bVar.f62467c = this.C.getForum().getId();
        }
        if (e0() != null) {
            bVar.f62466b = e0().R();
        }
        d.a.n0.r0.j2.b bVar2 = d.a.n0.r0.j2.d.L0;
        if (bVar2 != null) {
            bVar.f62468d = bVar2.f62468d;
            bVar.f62469e = bVar2.f62469e;
        }
        d.a.n0.r0.c2.b bVar3 = new d.a.n0.r0.c2.b(bVar, getTbPageTag(), getUniqueId());
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        this.F = currentTimeMillis;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.t = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.F = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            q2(intent);
        }
        this.I = currentTimeMillis - this.F;
        this.s = new d.a.n0.e3.h0.f("frs", d.a.n0.e3.h0.f.f57687c);
        if (this.W == null) {
            FrsModelController frsModelController = new FrsModelController(this, this.v1);
            this.W = frsModelController;
            frsModelController.t(this.c1);
            this.W.init();
        }
        this.W.P0(this.D);
        ArrayList<d.a.c.k.e.n> arrayList = null;
        if (intent != null) {
            this.W.k0(intent.getExtras());
        } else if (bundle != null) {
            this.W.k0(bundle);
        } else {
            this.W.k0(null);
        }
        if (intent != null) {
            this.X.H(intent.getExtras());
        } else if (bundle != null) {
            this.X.H(bundle);
        } else {
            this.X.H(null);
        }
        this.v = getVoiceManager();
        this.m0 = new d.a.n0.r0.q(getPageContext(), this);
        L2();
        K2(bundle);
        if (!N2()) {
            d.a.n0.r0.v0 v0Var = new d.a.n0.r0.v0(getActivity(), this.x, this.X);
            this.c0 = v0Var;
            v0Var.i(true);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.v = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(s2()) && !this.y0) {
            int k2 = d.a.m0.r.d0.b.j().k("key_forum_broadcast_edit_tip_number", 0);
            if (k2 < 2) {
                d.a.m0.r.d0.b.j().v("key_forum_broadcast_edit_tip_number", k2 + 1);
                y3();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    z3();
                } else {
                    BdTopToast bdTopToast = new BdTopToast(getContext());
                    bdTopToast.i(false);
                    bdTopToast.h(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint));
                    bdTopToast.j(this.x.j0());
                }
            } else {
                z3();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(s2()) && !this.y0) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    A3();
                } else if (Build.VERSION.SDK_INT < 23 || !d.a.m0.r.d0.b.j().g("key_forum_rule_dialog_show_frs", false)) {
                    A3();
                    d.a.m0.r.d0.b.j().t("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                A3();
            }
        }
        if (d.a.m0.x.d.h().k()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            OvalActionButton ovalActionButton = this.y;
            if (ovalActionButton != null) {
                ovalActionButton.setVisibility(8);
            }
        }
        new d.a.n0.r0.e2.i();
        int i2 = -1;
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar != null && cVar.f() != null) {
            i2 = this.i0.f().A();
            arrayList = this.i0.f().z();
        }
        d.a.n0.r0.e2.c cVar2 = new d.a.n0.r0.e2.c(this, this.z1);
        this.i0 = cVar2;
        cVar2.f().L(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.i0.f().J(arrayList);
        }
        this.a0 = new d.a.n0.r0.h2.a(this);
        this.j0 = new d.a.n0.r0.o2.j(this);
        this.g0 = new d.a.n0.r0.o2.a(getPageContext(), this.W.p0());
        this.b0 = new d.a.n0.r0.e2.b(this);
        this.h0 = new d.a.n0.r0.e2.d(this);
        this.Z = new d.a.n0.r0.e2.h(this);
        this.k0 = new d.a.n0.r0.e2.a(this);
        this.n0 = new d.a.n0.r0.o2.c(this);
        new d.a.n0.r0.e2.e(this, getUniqueId());
        this.u0 = new d.a.n0.h.a(getPageContext(), "frs");
        this.v0 = new d.a.n0.v.a(getPageContext());
        new d.a.n0.r0.i2.c.a(getPageContext());
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
        if (!N2() && !this.y0) {
            showLoadingView(this.x.j0(), true);
            this.W.P(3, false);
        }
        b0 b0Var = new b0();
        d.a.n0.r0.b.e().o(b0Var);
        d.a.n0.r0.a.h().s(b0Var);
        this.x.q1(new c0());
        this.E0 = UtilHelper.getScreenHeight(getActivity());
        this.y0 = true;
        m2(1);
        super.onActivityCreated(bundle);
        this.J = System.currentTimeMillis() - currentTimeMillis;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        d.a.n0.r0.e2.a aVar = this.k0;
        if (aVar != null) {
            aVar.m(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.B0) {
            this.x.H0(i2);
            this.X.K(i2);
            this.Y.Q(i2);
            FRSRefreshButton fRSRefreshButton = this.z;
            if (fRSRefreshButton != null) {
                fRSRefreshButton.d(i2);
            }
            d.a.n0.r0.r2.a aVar = this.q0;
            if (aVar != null) {
                aVar.onChangeSkinType();
            }
            d.a.n0.r0.j1.a.a aVar2 = this.w0;
            if (aVar2 != null) {
                aVar2.d(getPageContext(), i2);
            }
            if (this.x0 != null) {
                d.a.m0.s0.a.a(getPageContext(), this.x0.getRealView());
            }
            d.a.n0.r0.o2.e eVar = this.r0;
            if (eVar != null) {
                eVar.onChangeSkinType(getPageContext(), i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.d3.c.g().i(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.r1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = this.w;
        if (view == null) {
            this.w = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            d.a.n0.r0.n1.a aVar = new d.a.n0.r0.n1.a();
            this.f15081f = aVar;
            this.f0 = aVar.c();
            this.f15080e = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.X = new d.a.n0.r0.o2.h(this, this.f15081f, (FrsHeaderViewContainer) this.w.findViewById(R.id.header_view_container));
            FrsTabViewController frsTabViewController = new FrsTabViewController(this, this.w);
            this.Y = frsTabViewController;
            frsTabViewController.V();
            this.X.q0(this.Y);
            this.Y.Z(this.d1);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.f15083h = true;
            }
            this.x = new d.a.n0.r0.r(this, this.C1, this.f15081f, this.f15083h, this.X);
            this.w0 = new d.a.n0.r0.j1.a.a(getPageContext(), this.w);
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
            this.w.setRight(d.a.c.e.p.l.k(TbadkCoreApplication.getInst().getContext()));
        }
        this.B0 = true;
        this.K = System.currentTimeMillis() - currentTimeMillis;
        return this.w;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.n0.d3.c.g().k(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.J1);
        MessageManager.getInstance().unRegisterListener(this.o1);
        unRegisterResponsedEventListener();
        this.j0.b0();
        V1 = null;
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.n0.t2.i0.a.c("FRS");
        this.v = null;
        d.a.n0.z.t.b().e(false);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForum() != null) {
            d.a.n0.r0.h0.a().b(d.a.c.e.m.b.f(this.C.getForum().getId(), 0L));
        }
        d.a.n0.r0.c2.a aVar = this.l0;
        if (aVar != null) {
            aVar.v();
        }
        d.a.n0.r0.r rVar = this.x;
        if (rVar != null) {
            d.a.n0.r0.n2.l.b(rVar, this.C, i(), false, null);
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
            d.a.c.e.m.e.a().removeCallbacks(this.O0);
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
        this.X.I();
        Looper.myQueue().removeIdleHandler(this.U0);
        FrsModelController frsModelController = this.W;
        if (frsModelController != null) {
            frsModelController.g();
        }
        d.a.n0.r0.v0 v0Var = this.c0;
        if (v0Var != null) {
            v0Var.d();
        }
        d.a.n0.r0.o2.a aVar2 = this.g0;
        if (aVar2 != null) {
            aVar2.i();
        }
        d.a.n0.r0.h2.a aVar3 = this.a0;
        if (aVar3 != null) {
            aVar3.c();
        }
        d.a.n0.r0.o2.e eVar = this.r0;
        if (eVar != null) {
            eVar.g();
        }
        d.a.n0.r0.e2.a aVar4 = this.k0;
        if (aVar4 != null) {
            aVar4.n();
        }
        d.a.n0.h.a aVar5 = this.u0;
        if (aVar5 != null) {
            aVar5.g();
        }
        d.a.n0.v.a aVar6 = this.v0;
        if (aVar6 != null) {
            aVar6.g();
        }
        d.a.n0.t2.g0.a.e().g();
        d.a.n0.r0.n2.n.a();
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController != null) {
            frsTabViewController.Z(null);
            this.Y.J();
        }
        AddExperiencedModel addExperiencedModel = this.z0;
        if (addExperiencedModel != null) {
            addExperiencedModel.onDestroy();
        }
        d.a.n0.r0.b.e().o(null);
        d.a.n0.r0.a.h().s(null);
        d.a.n0.r0.n2.e eVar2 = this.T0;
        if (eVar2 != null) {
            eVar2.d();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.b
    public void onFailed(String str) {
        G3();
        showToast(str);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.c.k.e.q onGetPreLoadListView() {
        return x2().getPreLoadHandle();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
                return false;
            }
            return false;
        } else if (d.a.n0.r0.b.e().g()) {
            d.a.n0.r0.b.e().k();
            return true;
        } else if (d.a.n0.r0.a.h().j()) {
            d.a.n0.r0.r rVar = this.x;
            if (rVar != null && rVar.z0()) {
                this.x.V0();
                return true;
            }
            d.a.n0.r0.a.h().n();
            return true;
        } else {
            d.a.n0.r0.r rVar2 = this.x;
            if (rVar2 != null) {
                return rVar2.J0();
            }
            return false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (N2()) {
            showLoadingView(this.x.j0(), true);
            this.x.r1(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.W.G0(3, true);
            x2().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.a.c.e.p.l.D()) {
            hideNetRefreshView(this.x.V().n());
            showLoadingView(this.x.j0(), true);
            this.x.r0(false);
            this.W.G0(3, true);
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
            o2();
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
        d.a.n0.r0.o2.a aVar = this.g0;
        if (aVar != null) {
            aVar.j();
        }
        d.a.m0.a.d.y().E();
        d.a.n0.r0.n2.e eVar = this.T0;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            d.a.n0.r0.o2.h hVar = this.X;
            if (hVar != null) {
                hVar.L(isPrimary());
            }
            d.a.n0.r0.r rVar = this.x;
            if (rVar != null) {
                rVar.L0(isPrimary());
                this.x.E0(!isPrimary());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        d.a.n0.r0.n2.m.h(this, i2, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.n0.r0.r rVar = this.x;
        if (rVar != null) {
            rVar.D0();
            this.x.M0();
        }
        this.Z.f(true);
        this.R = true;
        if (U1) {
            U1 = false;
            d.a.n0.r0.r rVar2 = this.x;
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
        d.a.n0.r0.r rVar3 = this.x;
        if (rVar3 != null) {
            rVar3.E0(false);
        }
        if (this.s0) {
            X2(6);
            this.s0 = false;
        }
        if (this.D0 != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                d.a.m0.s.d.f.c().h(true);
                d.a.m0.s.d.f.c().i(this.D0.getHours(), this.D0.getMinutes());
                if (this.x != null) {
                    d.a.m0.s.d.f.c().k(p().getPageActivity(), this.x.j0());
                }
            }
            this.D0 = null;
        }
        O3();
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
        if (!d.a.c.e.p.l.D()) {
            this.x.q0();
        } else if (this.W.b0() == 1) {
            G3();
            loadMore();
        } else if (this.W.i0()) {
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
        F3();
        this.x.D0();
        d.a.n0.e3.f S = this.W.S();
        boolean isEmpty = ListUtils.isEmpty(this.C.getThreadList());
        if (S != null && isEmpty) {
            if (this.W.V() != 0) {
                this.W.O0();
                this.x.D0();
            } else {
                E3(S);
            }
            this.x.f1(this.C.isStarForum(), false);
            return;
        }
        E3(S);
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
        d.a.n0.z.t.b().e(false);
        S2(false);
        FrsViewData frsViewData = this.C;
        if (frsViewData != null && frsViewData.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            d.a.m0.u.a.k().y(getPageContext().getPageActivity(), "frs", this.C.getForum().getId(), 0L);
        }
        VoiceManager voiceManager = this.v;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        if (x2() != null) {
            x2().getRecycledViewPool().clear();
        }
        this.X.J();
        d.a.m0.z0.c0.c();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
    }

    @Override // d.a.n0.t2.u
    public TbPageContext<?> p() {
        return getPageContext();
    }

    public d.a.n0.r0.n1.e.b p2() {
        return this.f0;
    }

    public void p3(boolean z2) {
        d.a.n0.r0.v0 v0Var = this.c0;
        if (v0Var != null) {
            v0Var.i(z2);
        }
    }

    @Override // d.a.n0.r0.e2.l
    public d.a.n0.r0.e2.c q0() {
        return this.i0;
    }

    public final void q2(Intent intent) {
        if (intent == null) {
            return;
        }
        if (intent != null) {
            if (!d.a.n0.r0.n2.j.a(this, h(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
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
        if (d.a.m0.a.g.c(uri)) {
            d.a.m0.a.g.b().d(uri, this.y1);
        } else {
            d.a.n0.r0.n2.g b2 = d.a.n0.r0.n2.m.b(intent);
            if (b2 != null) {
                this.j = b2.f62842a;
                String str = b2.f62843b;
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

    public void q3(int i2) {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar == null) {
            return;
        }
        cVar.n(i2);
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        if (this.x != null) {
            t();
            this.x.Z().scrollToPosition(0);
            this.x.K1();
        }
    }

    public ForumWriteData r2() {
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
        forumWriteData.frsTabInfo = C2();
        return forumWriteData;
    }

    public void r3(boolean z2) {
        if (this.T1 != null) {
            return;
        }
        d.a.n0.t0.a a2 = d.a.n0.t0.a.a(z2);
        this.T1 = a2;
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar != null) {
            cVar.l(a2);
        }
    }

    public void refresh() {
        d.a.n0.o.d.c().f("page_frs");
        X2(3);
    }

    public String s2() {
        return this.k;
    }

    public final void s3() {
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

    public void setFrom(String str) {
        this.k = str;
    }

    @Override // d.a.n0.e.e.b
    public void setInjectPlugin(int i2, d.a.n0.e.e.a aVar) {
        this.d0.put(i2, aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        super.setPrimary(z2);
        FrsTabViewController frsTabViewController = this.Y;
        if (frsTabViewController == null || frsTabViewController.y() == null || !(this.Y.y().f15823b instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) this.Y.y().f15823b).setPrimary(z2);
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

    @Override // d.a.n0.r0.o0
    public void t() {
        d.a.m0.z0.a0 a0Var = this.o0;
        if (a0Var != null) {
            a0Var.c(true);
        }
    }

    public d.a.c.k.e.w t2() {
        return this.H1;
    }

    public void t3(OvalActionButton ovalActionButton) {
        this.y = ovalActionButton;
    }

    public d.a.n0.r0.e2.d u2() {
        return this.h0;
    }

    public void u3(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        this.A = linearLayout;
    }

    @Override // d.a.n0.r0.o0
    public void v() {
        if (isAdded() && this.e0 && !isLoadingViewAttached()) {
            showLoadingView(this.x.j0(), true);
        }
    }

    public d.a.n0.r0.h2.a v2() {
        return this.a0;
    }

    public void v3(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton == null) {
            return;
        }
        this.z = fRSRefreshButton;
        fRSRefreshButton.setOnClickListener(new t0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        FrsViewData frsViewData = this.C;
        if (frsViewData != null) {
            return d.a.m0.z0.m0.a(2) || (d.a.m0.z0.m0.d() && frsViewData.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // d.a.n0.t2.u
    public int w0() {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar == null) {
            return 1;
        }
        return cVar.g();
    }

    public boolean w2() {
        return this.x.Y();
    }

    public final void w3() {
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

    public BdRecyclerView x2() {
        d.a.n0.r0.r rVar = this.x;
        if (rVar == null) {
            return null;
        }
        return rVar.Z();
    }

    public final boolean x3(d.a.n0.e3.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && d.a.m0.r.d0.b.j().g("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new d.a.n0.r0.h1.f(p()).h(mVar);
    }

    public d.a.n0.r0.v0 y2() {
        return this.c0;
    }

    public final void y3() {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new k0(aVar));
        aVar.setContentView(frsBroadcastCopyGuideDialogView);
        aVar.create(getPageContext()).show();
    }

    @Override // d.a.n0.r0.o0
    public void z(d.a.m0.z0.b0 b0Var) {
        if (b0Var != null) {
            this.o0 = b0Var.a();
            this.p0 = b0Var.b();
        }
    }

    public int z2() {
        d.a.n0.r0.e2.c cVar = this.i0;
        if (cVar == null) {
            return 1;
        }
        return cVar.g();
    }

    public final void z3() {
        d.a.m0.x.d.h().m(new d.a.m0.x.a(getContext()));
        d.a.m0.x.d.h().n(85, 0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (d.a.m0.x.d.h().j()) {
            getPageContext().getOrignalPage().grantWindowPermission(new l0(), true);
        }
    }
}
