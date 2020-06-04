package com.baidu.tieba.ala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ar.pose.PoseAR;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.g;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.data.bc;
import com.baidu.live.data.q;
import com.baidu.live.data.v;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.f;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.w;
import com.baidu.live.gift.x;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.guardclub.h;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.o;
import com.baidu.live.n.b;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.m;
import com.baidu.live.view.input.c;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.liveroom.g.e;
import com.baidu.tieba.ala.liveroom.k.a;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean fLW;
    private com.baidu.tieba.ala.liveroom.data.a fKV;
    protected com.baidu.tieba.ala.liveroom.operation.a fKW;
    private com.baidu.tieba.ala.liveroom.attentionpop.a fKX;
    protected com.baidu.live.h.a fKY;
    protected com.baidu.tieba.ala.liveroom.share.c fKZ;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b fLA;
    protected com.baidu.tieba.ala.liveroom.n.c fLB;
    private x fLC;
    protected com.baidu.tieba.ala.liveroom.s.a fLD;
    protected e fLE;
    protected com.baidu.live.i.a fLF;
    protected com.baidu.tieba.ala.liveroom.recommend.a fLG;
    protected ay fLH;
    protected com.baidu.live.q.a fLI;
    protected RelativeLayout fLJ;
    protected RelativeLayout fLK;
    protected boolean fLM;
    protected ad fLP;
    protected GuardClubInfoHttpResponseMessage fLQ;
    boolean fLR;
    boolean fLS;
    boolean fLT;
    public boolean fLU;
    public boolean fLV;
    protected com.baidu.tieba.ala.liveroom.q.b fLX;
    protected com.baidu.tieba.ala.liveroom.h.e fLY;
    protected List<com.baidu.live.liveroom.g.d> fLZ;
    protected com.baidu.tieba.ala.liveroom.o.b fLa;
    protected com.baidu.tieba.ala.liveroom.guide.c fLb;
    protected com.baidu.tieba.ala.liveroom.watermark.a fLc;
    protected com.baidu.tieba.ala.liveroom.b.b fLd;
    protected com.baidu.tieba.ala.liveroom.praise.a fLe;
    protected com.baidu.tieba.ala.liveroom.guide.d fLf;
    protected com.baidu.tieba.ala.liveroom.v.a fLg;
    protected com.baidu.live.x.a fLh;
    private com.baidu.tieba.ala.liveroom.g.a fLi;
    private o fLj;
    k fLk;
    l fLl;
    protected w fLm;
    protected u fLn;
    protected com.baidu.tieba.ala.liveroom.tippop.a fLo;
    private com.baidu.tieba.ala.liveroom.guideim.b fLp;
    protected com.baidu.live.view.input.c fLq;
    com.baidu.tieba.ala.liveroom.k.a fLr;
    protected com.baidu.tieba.ala.liveroom.guide.a fLs;
    private com.baidu.live.guardclub.k fLt;
    protected com.baidu.tieba.ala.liveroom.f.a fLu;
    protected h fLv;
    protected j fLw;
    protected y fLx;
    protected com.baidu.tieba.ala.liveroom.turntable.e fLz;
    protected List<com.baidu.live.liveroom.g.b> fMa;
    protected String otherParams;
    private int fLy = 0;
    private int fLL = -1;
    protected int mOrientation = 0;
    protected boolean fLN = false;
    protected boolean fLO = false;
    private CustomMessageListener fMb = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if ((customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null) {
                b.this.a(vVar.avW, vVar.avS, vVar.avT, vVar.avU, vVar.avV);
            }
        }
    };
    private CustomMessageListener fMc = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bzh().fTm.Fk().avj.userId);
            com.baidu.live.view.a.Jl().a(valueOf, new com.baidu.live.data.d(b.this.bzh().fTm.Fk().avj.portrait, valueOf, true, b.this.bzh().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof q) && b.this.fKZ != null) {
                b.this.fKZ.c((q) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener aTq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fLk != null) {
                b.this.fLk.f(t.yl().yn());
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.fKV.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Ci(str);
            }
        }
    };
    private CustomMessageListener fMf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bzh().pageContext.getPageActivity());
            } else if (b.this.fKZ != null) {
                b.this.fKZ.c(b.this.bzh().fTm.Fk(), false);
            }
        }
    };
    private CustomMessageListener fMg = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ad) {
                    b.this.fLO = true;
                    b.this.fLP = (ad) data;
                    b.this.b(b.this.fLP);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener fMh = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bzh().fTm.Fk().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bzh().fTm.Fk().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bzh().fTm.Fk().avj.userId);
                    if (b.this.fLa == null) {
                        b.this.fLa = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    b.this.fLa.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.fLa.a(b.this.fMi);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.a fMi = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        @Override // com.baidu.live.n.b.a
        public void FO() {
            if (b.this.bzh().fTm.Fk() != null && b.this.bzh().fTm.Fk().avC != null) {
                b.this.bzh().fTm.Fk().avC.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener fMj = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener fMk = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.qQ(7);
        }
    };
    CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
            }
        }
    };
    CustomMessageListener fMl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.fLR = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fLr != null) {
                b.this.fLr.yy();
            }
        }
    };
    HttpMessageListener fwW = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aOG) != null && b.this.fLt != null && b.this.bzh() != null && b.this.bzh().fTm != null) {
                int[] iArr = new int[2];
                b.this.fLJ.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.fLt.a(b.this.fLJ, layoutParams, aVar, b.this.bzh().fTm.Fk());
                com.baidu.live.l.a.au(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fwT = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bzh() != null && b.this.bzh().fTm != null && b.this.bzh().fTm.Fk() != null && guardClubInfoHttpResponseMessage.aOG != null) {
                    if (guardClubInfoHttpResponseMessage.aOG.aul == b.this.bzh().fTm.Fk().avj.userId) {
                        b.this.fLQ = guardClubInfoHttpResponseMessage;
                        if (b.this.fLQ.aOJ && com.baidu.live.guardclub.e.BG() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.BG().ag(b.this.bzh().fTm.Fk().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fMm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bc) {
                b.this.a((bc) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fMn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.o(b.this.bzh().fTm.Fk());
        }
    };
    private CustomMessageListener fMo = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fLF != null) {
                b.this.fLF.BO();
            }
        }
    };
    private CustomMessageListener fMp = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.fLx != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.fLx).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fMq = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.byI();
        }
    };
    private CustomMessageListener fMr = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bzh().fTm.Fk(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener fMs = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.byS();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(ad adVar);

    protected abstract void b(ad adVar);

    public abstract boolean bxE();

    protected abstract void bya();

    protected abstract View byk();

    public abstract boolean byl();

    protected abstract boolean bym();

    protected abstract ViewGroup byn();

    protected abstract ViewGroup byo();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(ay ayVar) {
        this.fLH = ayVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fLJ = (RelativeLayout) bzh().fTn.findViewById(a.g.ala_live_header_view);
        this.fLK = (RelativeLayout) bzh().fTn.findViewById(a.g.ala_live_footer_view);
        za();
        registerListener();
    }

    public void byt() {
    }

    private void za() {
        if (this.fKZ == null) {
            this.fKZ = new com.baidu.tieba.ala.liveroom.share.c(bzh().pageContext);
        }
        this.fLg = new com.baidu.tieba.ala.liveroom.v.a(bzh().pageContext, this);
        this.fLd = new com.baidu.tieba.ala.liveroom.b.b(bzh().pageContext, false);
        this.fLe = new com.baidu.tieba.ala.liveroom.praise.a(bzh().pageContext);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            boolean z = TbadkCoreApplication.getInst().isHaokan() && subappVersionName.startsWith("4.14.");
            if (TbadkCoreApplication.getInst().isQuanmin() && subappVersionName.startsWith("1.14.")) {
                z = true;
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            }
            if (z) {
                this.fLf = new com.baidu.tieba.ala.liveroom.guide.d(bzh().pageContext);
            }
        }
        this.fLo = new com.baidu.tieba.ala.liveroom.tippop.a(bzh().pageContext, this);
        byu();
        byw();
        byx();
        byy();
        byC();
        byD();
        byE();
        byF();
    }

    private void byu() {
        this.fLj = new o();
    }

    public void kr(boolean z) {
        this.fLM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byv() {
        q Fk = bzh().fTm.Fk();
        boolean z = com.baidu.live.v.a.Ge().aWF.ayv;
        if (Fk.mLiveInfo != null && Fk.mLiveInfo.mAlaLiveSwitchData != null && Fk.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fk.avN ? z : false;
        if (z2) {
            if (this.fKY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bzh().pageContext);
                if (runTask != null) {
                    this.fKY = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.fKY != null) {
                this.fKY.ct(1);
                View view = this.fKY.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bzh().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bzh().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.fLJ.addView(view, layoutParams);
                    if (z2) {
                        this.fKY.a(Fk);
                    }
                }
            }
        }
    }

    private void byw() {
        this.fLp = new com.baidu.tieba.ala.liveroom.guideim.b(bzh().pageContext);
        this.fLp.c(this.fLK, bxE());
        this.fLp.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean CC() {
                return b.this.AP();
            }
        });
    }

    private void byx() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bzh().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fLq = (com.baidu.live.view.input.c) runTask.getData();
            this.fLq.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
                @Override // com.baidu.live.view.input.c.a
                public void JA() {
                    b.this.qQ(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void JB() {
                    b.this.cC(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean CC() {
                    return b.this.AP();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean DA() {
                    return b.this.byA();
                }

                @Override // com.baidu.live.view.input.c.a
                public int CH() {
                    return b.this.byB();
                }
            });
        }
    }

    private void byy() {
        this.fLr = new com.baidu.tieba.ala.liveroom.k.a(this.fKV.pageContext);
        this.fLr.a(new a.InterfaceC0564a() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0564a
            public boolean bzj() {
                return b.this.bym();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0564a
            public void onClose() {
                if (b.this.aWi != null) {
                    b.this.aWi.bO(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ks(boolean z) {
        if (this.fLp != null) {
            this.fLp.kR(z);
        }
        if (this.fLr != null) {
            this.fLr.kR(z);
        }
        fLW = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean byz() {
        return fLW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean byA() {
        q Fk;
        if (bzh() == null || bzh().fTm == null || (Fk = bzh().fTm.Fk()) == null || Fk.avC == null) {
            return false;
        }
        String str = Fk.avC.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int byB() {
        q Fk;
        if (bzh() != null && bzh().fTm != null && (Fk = bzh().fTm.Fk()) != null && !ListUtils.isEmpty(Fk.avH)) {
            for (AlaLiveMarkData alaLiveMarkData : Fk.avH) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void byC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bzh().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fLt = (com.baidu.live.guardclub.k) runTask.getData();
            this.fLt.setOtherParams(DN());
        }
    }

    private void byD() {
        this.fLu = new com.baidu.tieba.ala.liveroom.f.a(bzh().pageContext);
    }

    private void byE() {
        this.fLz = new com.baidu.tieba.ala.liveroom.turntable.e(bzh().pageContext.getPageActivity());
    }

    private void byF() {
        this.fLB = new com.baidu.tieba.ala.liveroom.n.c(bzh().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fMg);
        MessageManager.getInstance().registerListener(this.fMh);
        MessageManager.getInstance().registerListener(this.fMj);
        MessageManager.getInstance().registerListener(this.fMc);
        MessageManager.getInstance().registerListener(this.fMd);
        MessageManager.getInstance().registerListener(this.fMb);
        MessageManager.getInstance().registerListener(this.fMf);
        MessageManager.getInstance().registerListener(this.fMe);
        MessageManager.getInstance().registerListener(this.fMk);
        MessageManager.getInstance().registerListener(this.foe);
        MessageManager.getInstance().registerListener(this.fMl);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fwW);
        MessageManager.getInstance().registerListener(this.fwT);
        MessageManager.getInstance().registerListener(this.aTq);
        MessageManager.getInstance().registerListener(this.fMm);
        MessageManager.getInstance().registerListener(this.fMn);
        MessageManager.getInstance().registerListener(this.fMo);
        MessageManager.getInstance().registerListener(this.fMp);
        MessageManager.getInstance().registerListener(this.fMq);
        MessageManager.getInstance().registerListener(this.fMr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bzh().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bzh().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Ge().aWF.axW;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bzh().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bzh().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bzh().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bzh().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byG() {
        if (this.fLk != null) {
            this.fLk.CB().a(this.fLq.Dq(), t.yl().yn());
            ks(true);
            if (this.fLC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bzh().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.fLC = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.fLC.eT("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byH() {
        if (this.fLk != null) {
            this.fLk.CB().hide();
            ks(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(int i, int i2, int i3) {
        if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avj != null && bzh().fTm.Fk().mLiveInfo != null) {
            a(bzh().fTm.Fk(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && AP()) {
            if (qVar == null) {
                qVar = bzh().fTm.Fk();
            }
            String valueOf = String.valueOf(qVar.avj.userId);
            String str = qVar.avj.userName;
            String valueOf2 = String.valueOf(qVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(qVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(qVar.mLiveInfo.feed_id);
            int i6 = qVar.avC.isBlock;
            String yu = com.baidu.live.gift.v.yu();
            String str2 = qVar.mLiveInfo.appId;
            boolean z2 = qVar.avC.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (qVar.mLiveInfo.live_type == 1 && qVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.Ge().aWF.axf) {
                z3 = true;
            }
            int i7 = -1;
            if (qVar.avC == null) {
                z = false;
            } else {
                boolean z4 = qVar.avC.isNewUser;
                i7 = qVar.avC.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.fLQ != null && this.fLQ.aOG != null && this.fLQ.aOG.aul == qVar.avj.userId) {
                z5 = this.fLQ.aOJ;
            }
            g gVar = new g(bzh().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, yu, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.aP(qVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.aN(z);
            if (com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ != null) {
                gVar.aO(com.baidu.tieba.ala.liveroom.t.a.bGm().aWQ.awa != 1);
            }
            ao BJ = com.baidu.live.guardclub.g.BH().BJ();
            if (BJ == null || BJ.aAa <= 0) {
                i5 = 1000;
            } else {
                i5 = BJ.aAa;
            }
            gVar.bD(i5);
            boolean z6 = false;
            if (qVar != null && qVar.avC != null) {
                String str3 = qVar.avC.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.aQ(z6);
            ax axVar = com.baidu.live.v.a.Ge().aYP;
            if (TbadkCoreApplication.getInst().isMobileBaidu() || ((axVar != null && axVar.aAL != null && !axVar.aAL.aCA) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()))) {
                gVar.aR(false);
            } else {
                gVar.aR(true);
            }
            if (qVar != null && qVar.avE != null) {
                gVar.el(qVar.avE.toJsonString());
            }
            if (!this.fLU) {
                this.fLV = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byI() {
        cC(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bc bcVar) {
        if (bcVar != null && AP()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.q(bzh().pageContext.getPageActivity(), bcVar.aBr, bcVar.liveId, bcVar.aBs)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Ge().aWF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bzh().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Ge().aWF.ayw, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, NobleDetailInfo nobleDetailInfo) {
        if (AP() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (qVar != null) {
                if (qVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(qVar.mLiveInfo.live_id));
                }
                if (qVar.avj != null) {
                    hashMap.put("anchor_id", Long.valueOf(qVar.avj.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", com.baidu.live.utils.q.yu());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bzh().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byJ() {
        if (this.fLq != null) {
            this.fLq.c(this.fKV.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byK() {
        q Fk = bzh().fTm.Fk();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fk == null || Fk.mLiveInfo == null) ? "" : Fk.mLiveInfo.feed_id, DN());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(String str) {
        if (this.fLq != null) {
            this.fLq.eW(str);
        }
    }

    private void byL() {
        if ("home_rec_play".equals(bzh().fromType) || "frs_play".equals(bzh().fromType) || "frs_live_play".equals(bzh().fromType) || "person_play".equals(bzh().fromType) || "search".equals(bzh().fromType) || "person_attention".equals(bzh().fromType)) {
            com.baidu.live.b.uM().aL(true);
        } else {
            com.baidu.live.b.uM().aL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kn(boolean z) {
        View xY;
        if (this.fLm == null) {
            f fVar = new f();
            fVar.aDG = false;
            fVar.context = bzh().pageContext.getPageActivity();
            fVar.aDP = z;
            fVar.fromType = bzh().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLm = (w) runTask.getData();
            }
        }
        if (this.fLm != null && (xY = this.fLm.xY()) != null && this.fKV.fTn.indexOfChild(xY) < 0) {
            this.fKV.fTn.addView(xY, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byM() {
        View yx;
        if (this.fLx == null) {
            ab abVar = new ab();
            abVar.aDG = false;
            abVar.pageContext = bzh().pageContext;
            abVar.fromType = bzh().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLx = (y) runTask.getData();
            }
        }
        if (this.fLx != null && (yx = this.fLx.yx()) != null && bzh().fTn.indexOfChild(yx) < 0) {
            if (yx.getParent() instanceof ViewGroup) {
                ((ViewGroup) yx.getParent()).removeView(yx);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bzh().fTn.addView(yx, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byN() {
        View yq;
        if (this.fLn == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aDG = false;
            aVar.context = bzh().pageContext.getPageActivity();
            aVar.fromType = bzh().fromType;
            aVar.aDH = bzh().fTr;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLn = (u) runTask.getData();
            }
        }
        if (this.fLn != null && (yq = this.fLn.yq()) != null && bzh().fTn.indexOfChild(yq) < 0) {
            if (yq.getParent() instanceof ViewGroup) {
                ((ViewGroup) yq.getParent()).removeView(yq);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bzh().fTn.addView(yq, layoutParams);
        }
    }

    private void byO() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byP() {
        CustomResponsedMessage runTask;
        if (this.fLl == null && (runTask = MessageManager.getInstance().runTask(2913099, l.class, bzh().pageContext)) != null) {
            this.fLl = (l) runTask.getData();
        }
        if (this.fLl != null) {
            this.fLl.setOtherParams(this.otherParams);
            this.fLl.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.im.l.a
                public void CK() {
                    b.this.byS();
                }
            });
            this.fLl.a(bzh().fTm.Fk(), false);
            View CI = this.fLl.CI();
            if (CI != null && this.fLK.indexOfChild(CI) < 0) {
                Resources resources = bzh().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzh().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.fLK.addView(CI, layoutParams);
            }
        }
    }

    private void byQ() {
        if (this.fLi == null) {
            this.fLi = new com.baidu.tieba.ala.liveroom.g.a(bzh().pageContext);
        }
        if (this.fLP != null) {
            this.fLi.Cn(this.fLP.user_id);
        }
        this.fLi.ao(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kt(boolean z) {
        CustomResponsedMessage runTask;
        if (bzh() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bzh().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLF = (com.baidu.live.i.a) runTask.getData();
            this.fLF.a(byo(), bza());
            if (bzh().fTm != null) {
                this.fLF.a(bzh().fTm.Fk());
            }
            this.fLF.setCanVisible(!z);
            this.fLF.bC(true);
            this.fLF.a(bzh().fTm.btj());
        }
    }

    private void byR() {
        if (this.fLv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bzh().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLv = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avj != null && bzh().fTm.Fk().mLiveInfo != null) {
            this.fLv.setHost(false);
            this.fLv.setOtherParams(DN());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bzh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.fLv.a(this.fLJ, layoutParams, bzh().fTm.Fk());
            this.fLv.a(new com.baidu.live.guardclub.l() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                @Override // com.baidu.live.guardclub.l
                public void BN() {
                    b.this.bzi();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:195:0x0620, code lost:
        Cf(r32);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        long j2;
        long j3;
        JSONObject jSONObject4;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(aVar.getContent());
            }
            try {
                String optString = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString)) {
                    new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                }
                jSONObject3 = jSONObject4.optJSONObject("ext_data");
                jSONObject2 = jSONObject4;
            } catch (JSONException e) {
                jSONObject = jSONObject4;
                jSONObject2 = jSONObject;
                jSONObject3 = null;
                if (aVar.getMsgType() != 12) {
                }
                if (jSONObject2 == null) {
                }
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.aWi != null) {
                        this.aWi.bQ(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        qS(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzh().fTm.Fk().avC.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzh().fTm.Fk().avC.isAdmin = 0;
                            bzh().fTm.bFk();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bzh().fTm.Fk().avC.isAdmin = 0;
                        bzh().fTm.bFk();
                    }
                } else if ("task".equals(optString2)) {
                    cU(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.fLo != null && !bzh().fTq) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bzh().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bzh().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bzh().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (buz()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.fLo.a(bzh().fTl.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.aWi != null) {
                                b.this.aWi.bP(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bzh().fTm.Fk() != null && bzh().fTm.Fk().mLiveInfo != null) {
                        String str2 = bzh().fTm.Fk().mLiveInfo.feed_id;
                        long j4 = bzh().fTm.Fk().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!m.i(j4, optLong2)) {
                            com.baidu.live.utils.o.a(str2, j4, false, false);
                            m.j(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.q.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null && bzh().fTm.Fk().avC.userId == optLong3) {
                        bzh().fTm.Fk().avC.isBlock = 1;
                        bya();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null && bzh().fTm.Fk().avC.userId == optLong4) {
                        bzh().fTm.Fk().avC.isBlock = 0;
                        bya();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null && bzh().fTm.Fk().avC.userId == optLong5) {
                        bzh().fTm.Fk().avC.isUegBlock = 1;
                        bya();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null && bzh().fTm.Fk().avC.userId == optLong6) {
                        bzh().fTm.Fk().avC.isUegBlock = 0;
                        bya();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bzh() != null && bzh().fTm != null && bzh().fTm.Fk() != null && bzh().fTm.Fk().avC != null) {
                        if (bzh().fTm.Fk().avC.userId == jSONObject2.optLong("user_id")) {
                            bzh().fTm.bFk();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bzh().fTm.Fk().avC));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong7 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str3 = optLong7 + "";
                        TbadkCoreApplication.getInst();
                        if (str3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str4 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a DB = aVar.DB();
                    if (DB != null && com.baidu.live.gift.v.eR(str4)) {
                        com.baidu.live.gift.v.d(str4, 1L, "", "", DB.userId, DB.portrait, DB.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.fLg != null) {
                this.fLg.z(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a DB2 = aVar.DB();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong8 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str5 = null;
            if (bzh().fTm == null || bzh().fTm.Fk() == null || bzh().fTm.Fk().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bzh().fTm.Fk().mLiveInfo.live_id;
                long j6 = bzh().fTm.Fk().mLiveInfo.group_id;
                long j7 = bzh().fTm.Fk().avj.userId;
                str5 = bzh().fTm.Fk().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    com.baidu.live.gift.v.b(optString9, DB2.userId, DB2.portrait, DB2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str5, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.Gl().fC(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                }
                                i++;
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                com.baidu.live.gift.v.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, DB2.userId, DB2.portrait, DB2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str5, optString7, "", "", aVar.getMsgId());
                Cf(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.fSK = optLong8;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void Cf(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byS() {
        if (byT()) {
            BdUtilHelper.hideSoftKeyPad(bzh().pageContext.getPageActivity(), bzh().fTl.getLiveContainerView());
            byl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byT() {
        if (byk() == null || byk().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        CustomResponsedMessage runTask;
        bzh().fTn.setOnTouchListener(this.fMs);
        bzb();
        bzc();
        byO();
        byQ();
        byR();
        if (this.fLj != null) {
            this.fLj.g(bzh().fTm.Fk());
        }
        if (this.fLp != null) {
            this.fLp.c(bzh().fTm.Fk(), DN());
        }
        if (this.fLq != null) {
            this.fLq.a(bzh().fTm.Fk(), DN());
        }
        if (this.fLr != null) {
            this.fLr.c(bzh().fTm.Fk(), DN());
        }
        if (bzh().fTn != null) {
            bzh().fTn.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean A = b.this.A(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.byT() && b.this.fLe != null) {
                        b.this.fLe.ll(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.fLe != null) {
                        b.this.fLe.ll(true);
                    }
                    return A;
                }
            });
            bzh().fTn.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.z(motionEvent);
                }
            });
        }
        if (this.fLC == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bzh().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLC = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byU() {
        q Fk;
        ViewGroup viewGroup;
        if (bzh() != null && bzh().fTm != null && (Fk = bzh().fTm.Fk()) != null && Fk.mLiveInfo != null && !Fk.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bzh().fTl) != null) {
            if (this.fLG == null) {
                this.fLG = new com.baidu.tieba.ala.liveroom.recommend.a(bzh().pageContext);
            }
            this.fLG.r(Fk);
            this.fLG.a(bzh().fTn);
            this.fLG.ao(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.fLG);
            a((com.baidu.live.liveroom.g.b) this.fLG);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.fLZ == null) {
            this.fLZ = new ArrayList();
        }
        if (!this.fLZ.contains(dVar)) {
            this.fLZ.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.fLZ != null && this.fLZ.contains(dVar)) {
            this.fLZ.remove(dVar);
        }
    }

    protected void byV() {
        if (this.fLZ != null) {
            this.fLZ.clear();
            this.fLZ = null;
        }
    }

    protected boolean z(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fLZ == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.fLZ.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().onTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.b bVar) {
        if (this.fMa == null) {
            this.fMa = new ArrayList();
        }
        if (!this.fMa.contains(bVar)) {
            this.fMa.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.fMa != null && this.fMa.contains(bVar)) {
            this.fMa.remove(bVar);
        }
    }

    protected void byW() {
        if (this.fMa != null) {
            this.fMa.clear();
            this.fMa = null;
        }
    }

    protected boolean A(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fMa == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.fMa.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().dispatchTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byX() {
        if (this.fLE == null && this.fLH != null && this.fLH.aAV && bzh() != null && bzh().fTm != null && bzh().fTm.Fk() != null) {
            this.fLE = new e(bzh().pageContext, this.fLH);
            this.fLE.q(bzh().fTm.Fk());
            if (this.fLH.aAY == 1) {
                if (this.fLk != null) {
                    this.fLS = true;
                }
            } else if (this.fLH.aAY == 2) {
                a(bzh().fTm.Fk(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byY() {
        CustomResponsedMessage runTask;
        if (bzh() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bzh().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fLI = (com.baidu.live.q.a) runTask.getData();
            this.fLI.a(byn(), byZ());
            if (bzh().fTm != null) {
                this.fLT = this.fLI.m(bzh().fTm.Fk());
            }
            this.fLI.setCanVisible(!this.fLN);
        }
    }

    private ViewGroup.LayoutParams byZ() {
        int dimensionPixelOffset;
        if (bxE()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bzh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bzh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bza() {
        int dimensionPixelOffset;
        if (bxE()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bzh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bzh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ku(boolean z) {
        Rect rect = new Rect();
        bzh().fTl.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bzh().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bzh().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bzh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bzh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bzb() {
        if (this.fLe != null) {
            this.fLe.au(bzh().fTn);
        }
    }

    private void bzc() {
        if (this.fLh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.fLh = (com.baidu.live.x.a) runTask.getData();
            }
            bzd();
        }
    }

    private void cU(JSONObject jSONObject) {
        if (this.fLh != null) {
            if (this.fLb != null) {
                this.fLh.bY(this.fLb.bBP() ? false : true);
            } else {
                this.fLh.bY(true);
            }
            this.fLh.G(jSONObject);
        }
    }

    private void bzd() {
        if (this.fLh != null && bzh().fTm.Fk() != null && bzh().fTm.Fk().avM != null) {
            if (this.fLb != null) {
                this.fLh.bY(this.fLb.bBP() ? false : true);
            } else {
                this.fLh.bY(true);
            }
            this.fLh.a(bzh().fTm.Fk().avM);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(q qVar) {
        if (qVar != null) {
            if (this.fKW != null && this.fKW.bFF() != null && qVar.mLiveInfo != null) {
                if ((this.fKW.bFF().getVisibility() == 0) != qVar.mLiveInfo.isGoodsListVisible()) {
                    com.baidu.live.utils.o.a(qVar.mLiveInfo.feed_id, qVar.mLiveInfo.live_id, false, false);
                }
            }
            bzd();
            if (this.fLi != null && qVar.avj != null) {
                this.fLi.Cn(String.valueOf(qVar.avj.userId));
            }
            if (this.fKY != null) {
                this.fKY.a(qVar);
            }
            if (this.fLn != null && qVar.mLiveInfo != null) {
                this.fLn.a(qVar.mLiveInfo);
            }
            if (this.fLl != null) {
                this.fLl.a(qVar);
            }
            if (this.fLI != null) {
                this.fLT = this.fLI.m(qVar);
            }
            if (this.fLF != null) {
                this.fLF.a(qVar);
            }
            qS(qVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void qS(int i) {
        if (!bzh().fTq) {
            if (this.fLL < 0 && i == 0) {
                this.fLL = i;
            } else if (this.fLL != i) {
                if (i == 1) {
                    if (!this.fLo.rB(2)) {
                        String string = bzh().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bzh().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.fLo.a(bzh().fTl.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bzh().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.fLo.rC(2);
                    this.fLo.rC(3);
                    if (buz()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.fLo.a(bzh().fTl.getLiveContainerView(), string2, 3);
                    }
                }
                this.fLL = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bS(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bS(z);
        if (z) {
            bze();
        }
        if (this.fLg != null) {
            this.fLg.bHz();
        }
        if (this.fKZ != null) {
            this.fKZ.vm();
        }
        if (this.fLb != null) {
            this.fLb.onDestroy();
        }
        if (this.fLh != null) {
            this.fLh.onDestroy();
            this.fLh = null;
        }
        if (this.fLm != null) {
            View xY = this.fLm.xY();
            if (xY != null && xY.getParent() != null) {
                ((ViewGroup) xY.getParent()).removeView(xY);
            }
            this.fLm.onDestroy();
            this.fLm = null;
        }
        if (this.fLl != null) {
            this.fLl.a((l.a) null);
            this.fLl.BZ();
        }
        if (this.fKX != null) {
            this.fKX.vm();
        }
        if (this.fLo != null) {
            this.fLo.vm();
        }
        this.fLL = -1;
        if (this.fLi != null) {
            this.fLi.vm();
            this.fLi.onDestroy();
        }
        if (this.fLc != null) {
            this.fLc.bHw();
        }
        if (this.fLd != null) {
            this.fLd.bxy();
        }
        if (this.fLj != null) {
            this.fLj.yw();
        }
        if (this.fLp != null) {
            this.fLp.bBY();
        }
        if (this.fLq != null) {
            this.fLq.yw();
        }
        if (this.fLr != null) {
            this.fLr.onDestroy();
        }
        if (this.fLt != null) {
            this.fLt.onDestory();
        }
        if (this.fLw != null) {
            this.fLw.BL();
        }
        if (this.fLv != null) {
            this.fLv.BL();
        }
        if (this.fLE != null) {
            this.fLE.onDestroy();
        }
        if (this.fLz != null) {
            this.fLz.yw();
        }
        if (this.fLA != null) {
            this.fLA.yw();
        }
        if (this.fLC != null) {
            this.fLC.yw();
        }
        if (this.fLa != null) {
            this.fLa.onDestory();
        }
        if (this.fLI != null) {
            this.fLI.yw();
        }
        if (this.fLF != null) {
            this.fLF.BL();
        }
        if (this.fLB != null) {
            this.fLB.yw();
        }
        if (this.fLx != null) {
            this.fLx.onDestroy();
        }
        if (this.fLG != null) {
            this.fLG.vm();
            b((com.baidu.live.liveroom.g.d) this.fLG);
            b((com.baidu.live.liveroom.g.b) this.fLG);
        }
        ShowUtil.windowCount = 0;
        byV();
        byW();
    }

    private void bze() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bzh().fTn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bzh().fTn.getChildAt(i);
            if (childAt != this.fLJ && childAt != this.fLK) {
                linkedList.add(childAt);
            }
        }
        for (View view : linkedList) {
            if (view != null) {
                try {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                } catch (NullPointerException e) {
                }
            }
        }
        if (this.fLJ != null) {
            this.fLJ.removeAllViews();
        }
        if (this.fLK != null) {
            this.fLK.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, q qVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(q qVar) {
        View CI;
        View xY;
        if (this.fLm != null && (xY = this.fLm.xY()) != null && xY.getParent() != null) {
            ((ViewGroup) xY.getParent()).removeView(xY);
        }
        if (this.fLl != null && (CI = this.fLl.CI()) != null && CI.getParent() != null) {
            ((ViewGroup) CI.getParent()).removeView(CI);
        }
        if (this.fLb != null) {
            this.fLb.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Ff() {
        if (this.fLf == null || !this.fLf.bBU()) {
            if (this.fLb == null || !this.fLb.aq(bzh().fTl.getLiveContainerView())) {
                if (this.fLe != null) {
                    this.fLe.bvi();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.fLs != null && this.fLs.bBD()) {
                    this.fLs.bBM();
                    return false;
                } else if (this.fLr == null || !this.fLr.bBX()) {
                    byL();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bR(boolean z) {
        super.bR(z);
        if (this.fLD != null) {
            this.fLD.destroy();
        }
        if (this.fLh != null) {
            this.fLh.onDestroy();
            this.fLh = null;
        }
        if (this.fLg != null) {
            this.fLg.bHz();
        }
        if (this.fLm != null) {
            this.fLm.onDestroy();
            this.fLm = null;
        }
        if (this.fLn != null) {
            this.fLn.onDestroy();
            this.fLn = null;
        }
        if (this.fLo != null) {
            this.fLo.onDestroy();
        }
        if (this.fKX != null) {
            this.fKX.onDestroy();
        }
        if (this.fKZ != null) {
            this.fKZ.onDestroy();
        }
        if (this.fLx != null) {
            this.fLx.onDestroy();
            this.fLx = null;
        }
        if (this.fLl != null) {
            this.fLl.a((l.a) null);
            this.fLl.release();
            this.fLl = null;
        }
        if (this.fLp != null) {
            this.fLp.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.fLp.release();
        }
        if (this.fLq != null) {
            this.fLq.a(null);
            this.fLq.release();
        }
        if (this.fLr != null) {
            this.fLr.a((a.InterfaceC0564a) null);
            this.fLr.onDestroy();
        }
        if (this.fLv != null) {
            this.fLv.onDestroy();
        }
        if (this.fLw != null) {
            this.fLw.onDestroy();
        }
        if (this.fLt != null) {
            this.fLt.onDestory();
        }
        if (this.fLE != null) {
            this.fLE.onDestroy();
        }
        if (this.fLu != null) {
            this.fLu.release();
        }
        if (this.fLz != null) {
            this.fLz.release();
        }
        if (this.fLB != null) {
            this.fLB.release();
        }
        if (this.fLA != null) {
            this.fLA.release();
        }
        if (this.fLC != null) {
            this.fLC.release();
        }
        if (this.fLa != null) {
            this.fLa.onDestory();
        }
        if (this.fLI != null) {
            this.fLI.release();
        }
        if (this.fLF != null) {
            this.fLF.onDestroy();
        }
        if (this.fLe != null) {
            this.fLe.onDestroy();
        }
        if (this.fLG != null) {
            this.fLG.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.fLG);
            b((com.baidu.live.liveroom.g.b) this.fLG);
        }
        byV();
        byW();
        MessageManager.getInstance().unRegisterListener(this.fMq);
        MessageManager.getInstance().unRegisterListener(this.fMg);
        MessageManager.getInstance().unRegisterListener(this.fMh);
        MessageManager.getInstance().unRegisterListener(this.fMj);
        MessageManager.getInstance().unRegisterListener(this.fMc);
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMb);
        MessageManager.getInstance().unRegisterListener(this.fMf);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fMk);
        MessageManager.getInstance().unRegisterListener(this.foe);
        MessageManager.getInstance().unRegisterListener(this.fMl);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fwW);
        MessageManager.getInstance().unRegisterListener(this.fwT);
        MessageManager.getInstance().unRegisterListener(this.aTq);
        MessageManager.getInstance().unRegisterListener(this.fMm);
        MessageManager.getInstance().unRegisterListener(this.fMn);
        MessageManager.getInstance().unRegisterListener(this.fMo);
        MessageManager.getInstance().unRegisterListener(this.fMp);
        MessageManager.getInstance().unRegisterListener(this.fMr);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.fLp != null) {
            this.fLp.kQ(false);
        }
        if (this.fLr != null) {
            this.fLr.kQ(false);
        }
        byl();
        if (this.fLu != null) {
            this.fLu.pause();
        }
        if (this.fLz != null) {
            this.fLz.pause();
        }
        if (this.fLB != null) {
            this.fLB.pause();
        }
        if (this.fLx != null) {
            this.fLx.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.fLV = false;
        if (this.fLO && this.fLP != null) {
            a(this.fLP);
            this.fLO = false;
        }
        if (this.fLp != null) {
            this.fLp.kQ(true);
        }
        if (this.fLr != null) {
            this.fLr.kQ(true);
        }
        if (this.fLu != null) {
            this.fLu.resume();
        }
        if (this.fLz != null) {
            this.fLz.resume();
        }
        if (this.fLB != null) {
            this.fLB.resume();
        }
        if (this.fLx != null) {
            this.fLx.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzf() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fLG != null && this.fLG.isOpen()) {
            this.fLG.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bzf();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, -1, -1);
                    return;
                }
                return;
            }
            bzf();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bzf();
        } else if (i == 25034) {
            byI();
        } else if (i == 25043) {
            if (i2 == -1) {
                bzi();
            }
        } else if (i == 25050 && this.fLD != null) {
            if (i2 == -1) {
                this.fLD.N(intent);
            } else {
                this.fLD.N(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.fLN = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bzg() {
        return (bzh().fTm.Fk() == null || bzh().fTm.Fk().mLiveInfo == null || bzh().fTm.Fk().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.fLb != null) {
                this.fLb.bp(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.fLr != null) {
            this.fLr.aNc();
        }
        if (this.fLa != null) {
            this.fLa.aNc();
        }
        if (this.fLG != null) {
            this.fLG.bp(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.fKV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bzh() {
        return this.fKV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzi() {
        String BI = com.baidu.live.guardclub.g.BH().BI();
        if (!TextUtils.isEmpty(BI)) {
            try {
                L(-1, Integer.parseInt(BI), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                L(-1, -1, -1);
            }
        }
    }

    public boolean cA(int i) {
        if (7 == i) {
            if (this.fLm != null) {
                this.fLm.bb(true);
            }
            if (this.fKX != null) {
                this.fKX.bxz();
            }
        } else if (1 == i) {
            if (byk() != null) {
                byk().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.fLN) {
                return false;
            }
            if (this.fLb == null || !this.fLb.bBP()) {
                return this.fKX == null || this.fKX.bxB();
            }
            return false;
        } else if (3 == i) {
            if (bzh().fTn != null) {
                bzh().fTn.setEnabled(false);
                if (this.aWi != null) {
                    this.aWi.e(!bzh().fTo, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.fKX == null || !this.fKX.isShowing();
        }
        return true;
    }

    public void qQ(int i) {
        if ((i == 7 || i == 11) && this.fKX != null) {
            this.fKX.bxz();
            this.fKX.kl(false);
        }
    }

    public void cB(int i) {
    }

    public void cC(int i) {
        if (7 == i) {
            if (this.fLm != null) {
                this.fLm.bb(false);
            }
            if (this.fKX != null) {
                this.fKX.kl(true);
            }
        } else if (11 == i) {
            if (this.fKX != null) {
                this.fKX.kl(true);
            }
        } else if (3 == i) {
            bzh().fTn.setEnabled(true);
            if (this.aWi != null) {
                this.aWi.e(bzh().fTo ? false : true, true);
            }
            if (this.fLh != null) {
                this.fLh.bY(true);
            }
        } else if (2 == i && this.fLg != null) {
            this.fLg.lu(true);
        }
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fLl != null) {
            this.fLl.setOtherParams(str);
        }
    }

    private boolean buz() {
        return bzh().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
