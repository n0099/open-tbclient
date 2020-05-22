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
import com.baidu.tieba.ala.liveroom.h.e;
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
    public static boolean fLL;
    private com.baidu.tieba.ala.liveroom.data.a fKK;
    protected com.baidu.tieba.ala.liveroom.operation.a fKL;
    private com.baidu.tieba.ala.liveroom.attentionpop.a fKM;
    protected com.baidu.live.h.a fKN;
    protected com.baidu.tieba.ala.liveroom.share.c fKO;
    protected com.baidu.tieba.ala.liveroom.o.b fKP;
    protected com.baidu.tieba.ala.liveroom.guide.c fKQ;
    protected com.baidu.tieba.ala.liveroom.watermark.a fKR;
    protected com.baidu.tieba.ala.liveroom.b.b fKS;
    protected com.baidu.tieba.ala.liveroom.praise.a fKT;
    protected com.baidu.tieba.ala.liveroom.guide.d fKU;
    protected com.baidu.tieba.ala.liveroom.v.a fKV;
    protected com.baidu.live.x.a fKW;
    private com.baidu.tieba.ala.liveroom.g.a fKX;
    private o fKY;
    k fKZ;
    protected boolean fLB;
    protected ad fLE;
    protected GuardClubInfoHttpResponseMessage fLF;
    boolean fLG;
    boolean fLH;
    boolean fLI;
    public boolean fLJ;
    public boolean fLK;
    protected com.baidu.tieba.ala.liveroom.q.b fLM;
    protected e fLN;
    protected List<com.baidu.live.liveroom.g.d> fLO;
    protected List<com.baidu.live.liveroom.g.b> fLP;
    l fLa;
    protected w fLb;
    protected u fLc;
    protected com.baidu.tieba.ala.liveroom.tippop.a fLd;
    private com.baidu.tieba.ala.liveroom.guideim.b fLe;
    protected com.baidu.live.view.input.c fLf;
    com.baidu.tieba.ala.liveroom.k.a fLg;
    protected com.baidu.tieba.ala.liveroom.guide.a fLh;
    private com.baidu.live.guardclub.k fLi;
    protected com.baidu.tieba.ala.liveroom.f.a fLj;
    protected h fLk;
    protected j fLl;
    protected y fLm;
    protected com.baidu.tieba.ala.liveroom.turntable.e fLo;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b fLp;
    protected com.baidu.tieba.ala.liveroom.n.c fLq;
    private x fLr;
    protected com.baidu.tieba.ala.liveroom.s.a fLs;
    protected com.baidu.tieba.ala.liveroom.g.e fLt;
    protected com.baidu.live.i.a fLu;
    protected com.baidu.tieba.ala.liveroom.recommend.a fLv;
    protected ay fLw;
    protected com.baidu.live.q.a fLx;
    protected RelativeLayout fLy;
    protected RelativeLayout fLz;
    protected String otherParams;
    private int fLn = 0;
    private int fLA = -1;
    protected int mOrientation = 0;
    protected boolean fLC = false;
    protected boolean fLD = false;
    private CustomMessageListener fLQ = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v vVar;
            if ((customResponsedMessage.getData() instanceof v) && (vVar = (v) customResponsedMessage.getData()) != null) {
                b.this.a(vVar.avW, vVar.avS, vVar.avT, vVar.avU, vVar.avV);
            }
        }
    };
    private CustomMessageListener fLR = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bzf().fTb.Fk().avj.userId);
            com.baidu.live.view.a.Jl().a(valueOf, new com.baidu.live.data.d(b.this.bzf().fTb.Fk().avj.portrait, valueOf, true, b.this.bzf().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener fLS = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof q) && b.this.fKO != null) {
                b.this.fKO.c((q) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener aTq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fKZ != null) {
                b.this.fKZ.f(t.yl().yn());
            }
        }
    };
    private CustomMessageListener fLT = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.fKK.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Ci(str);
            }
        }
    };
    private CustomMessageListener fLU = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bzf().pageContext.getPageActivity());
            } else if (b.this.fKO != null) {
                b.this.fKO.c(b.this.bzf().fTb.Fk(), false);
            }
        }
    };
    private CustomMessageListener fLV = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ad) {
                    b.this.fLD = true;
                    b.this.fLE = (ad) data;
                    b.this.b(b.this.fLE);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener fLW = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bzf().fTb.Fk().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bzf().fTb.Fk().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bzf().fTb.Fk().avj.userId);
                    if (b.this.fKP == null) {
                        b.this.fKP = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    b.this.fKP.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.fKP.a(b.this.fLX);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.a fLX = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        @Override // com.baidu.live.n.b.a
        public void FO() {
            if (b.this.bzf().fTb.Fk() != null && b.this.bzf().fTb.Fk().avC != null) {
                b.this.bzf().fTb.Fk().avC.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener fLY = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener fLZ = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.qO(7);
        }
    };
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener fMa = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.fLG = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fLg != null) {
                b.this.fLg.yy();
            }
        }
    };
    HttpMessageListener fwL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aOG) != null && b.this.fLi != null && b.this.bzf() != null && b.this.bzf().fTb != null) {
                int[] iArr = new int[2];
                b.this.fLy.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.fLi.a(b.this.fLy, layoutParams, aVar, b.this.bzf().fTb.Fk());
                com.baidu.live.l.a.au(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fwI = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bzf() != null && b.this.bzf().fTb != null && b.this.bzf().fTb.Fk() != null && guardClubInfoHttpResponseMessage.aOG != null) {
                    if (guardClubInfoHttpResponseMessage.aOG.aul == b.this.bzf().fTb.Fk().avj.userId) {
                        b.this.fLF = guardClubInfoHttpResponseMessage;
                        if (b.this.fLF.aOJ && com.baidu.live.guardclub.e.BG() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.BG().ag(b.this.bzf().fTb.Fk().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fMb = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bc) {
                b.this.a((bc) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fMc = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.o(b.this.bzf().fTb.Fk());
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fLu != null) {
                b.this.fLu.BO();
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.fLm != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.fLm).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fMf = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.byG();
        }
    };
    private CustomMessageListener fMg = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bzf().fTb.Fk(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener fMh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.byQ();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(ad adVar);

    protected abstract void b(ad adVar);

    public abstract boolean bxC();

    protected abstract void bxY();

    protected abstract View byi();

    public abstract boolean byj();

    protected abstract boolean byk();

    protected abstract ViewGroup byl();

    protected abstract ViewGroup bym();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(ay ayVar) {
        this.fLw = ayVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fLy = (RelativeLayout) bzf().fTc.findViewById(a.g.ala_live_header_view);
        this.fLz = (RelativeLayout) bzf().fTc.findViewById(a.g.ala_live_footer_view);
        za();
        registerListener();
    }

    public void byr() {
    }

    private void za() {
        if (this.fKO == null) {
            this.fKO = new com.baidu.tieba.ala.liveroom.share.c(bzf().pageContext);
        }
        this.fKV = new com.baidu.tieba.ala.liveroom.v.a(bzf().pageContext, this);
        this.fKS = new com.baidu.tieba.ala.liveroom.b.b(bzf().pageContext, false);
        this.fKT = new com.baidu.tieba.ala.liveroom.praise.a(bzf().pageContext);
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
                this.fKU = new com.baidu.tieba.ala.liveroom.guide.d(bzf().pageContext);
            }
        }
        this.fLd = new com.baidu.tieba.ala.liveroom.tippop.a(bzf().pageContext, this);
        bys();
        byu();
        byv();
        byw();
        byA();
        byB();
        byC();
        byD();
    }

    private void bys() {
        this.fKY = new o();
    }

    public void kr(boolean z) {
        this.fLB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byt() {
        q Fk = bzf().fTb.Fk();
        boolean z = com.baidu.live.v.a.Ge().aWF.ayv;
        if (Fk.mLiveInfo != null && Fk.mLiveInfo.mAlaLiveSwitchData != null && Fk.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fk.avN ? z : false;
        if (z2) {
            if (this.fKN == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bzf().pageContext);
                if (runTask != null) {
                    this.fKN = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.fKN != null) {
                this.fKN.cr(1);
                View view = this.fKN.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bzf().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bzf().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.fLy.addView(view, layoutParams);
                    if (z2) {
                        this.fKN.a(Fk);
                    }
                }
            }
        }
    }

    private void byu() {
        this.fLe = new com.baidu.tieba.ala.liveroom.guideim.b(bzf().pageContext);
        this.fLe.c(this.fLz, bxC());
        this.fLe.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean CC() {
                return b.this.AP();
            }
        });
    }

    private void byv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bzf().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fLf = (com.baidu.live.view.input.c) runTask.getData();
            this.fLf.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
                @Override // com.baidu.live.view.input.c.a
                public void JA() {
                    b.this.qO(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void JB() {
                    b.this.cA(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean CC() {
                    return b.this.AP();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean DA() {
                    return b.this.byy();
                }

                @Override // com.baidu.live.view.input.c.a
                public int CH() {
                    return b.this.byz();
                }
            });
        }
    }

    private void byw() {
        this.fLg = new com.baidu.tieba.ala.liveroom.k.a(this.fKK.pageContext);
        this.fLg.a(new a.InterfaceC0564a() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0564a
            public boolean bzh() {
                return b.this.byk();
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
        if (this.fLe != null) {
            this.fLe.kR(z);
        }
        if (this.fLg != null) {
            this.fLg.kR(z);
        }
        fLL = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean byx() {
        return fLL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean byy() {
        q Fk;
        if (bzf() == null || bzf().fTb == null || (Fk = bzf().fTb.Fk()) == null || Fk.avC == null) {
            return false;
        }
        String str = Fk.avC.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int byz() {
        q Fk;
        if (bzf() != null && bzf().fTb != null && (Fk = bzf().fTb.Fk()) != null && !ListUtils.isEmpty(Fk.avH)) {
            for (AlaLiveMarkData alaLiveMarkData : Fk.avH) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void byA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bzf().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fLi = (com.baidu.live.guardclub.k) runTask.getData();
            this.fLi.setOtherParams(DN());
        }
    }

    private void byB() {
        this.fLj = new com.baidu.tieba.ala.liveroom.f.a(bzf().pageContext);
    }

    private void byC() {
        this.fLo = new com.baidu.tieba.ala.liveroom.turntable.e(bzf().pageContext.getPageActivity());
    }

    private void byD() {
        this.fLq = new com.baidu.tieba.ala.liveroom.n.c(bzf().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fLV);
        MessageManager.getInstance().registerListener(this.fLW);
        MessageManager.getInstance().registerListener(this.fLY);
        MessageManager.getInstance().registerListener(this.fLR);
        MessageManager.getInstance().registerListener(this.fLS);
        MessageManager.getInstance().registerListener(this.fLQ);
        MessageManager.getInstance().registerListener(this.fLU);
        MessageManager.getInstance().registerListener(this.fLT);
        MessageManager.getInstance().registerListener(this.fLZ);
        MessageManager.getInstance().registerListener(this.fnT);
        MessageManager.getInstance().registerListener(this.fMa);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fwL);
        MessageManager.getInstance().registerListener(this.fwI);
        MessageManager.getInstance().registerListener(this.aTq);
        MessageManager.getInstance().registerListener(this.fMb);
        MessageManager.getInstance().registerListener(this.fMc);
        MessageManager.getInstance().registerListener(this.fMd);
        MessageManager.getInstance().registerListener(this.fMe);
        MessageManager.getInstance().registerListener(this.fMf);
        MessageManager.getInstance().registerListener(this.fMg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean AP() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bzf().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzf().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bzf().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Ge().aWF.axW;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bzf().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bzf().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bzf().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bzf().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byE() {
        if (this.fKZ != null) {
            this.fKZ.CB().a(this.fLf.Dq(), t.yl().yn());
            ks(true);
            if (this.fLr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bzf().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.fLr = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.fLr.eT("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byF() {
        if (this.fKZ != null) {
            this.fKZ.CB().hide();
            ks(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(int i, int i2, int i3) {
        if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avj != null && bzf().fTb.Fk().mLiveInfo != null) {
            a(bzf().fTb.Fk(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && AP()) {
            if (qVar == null) {
                qVar = bzf().fTb.Fk();
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
            if (this.fLF != null && this.fLF.aOG != null && this.fLF.aOG.aul == qVar.avj.userId) {
                z5 = this.fLF.aOJ;
            }
            g gVar = new g(bzf().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, yu, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.aP(qVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.aN(z);
            if (com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ != null) {
                gVar.aO(com.baidu.tieba.ala.liveroom.t.a.bGk().aWQ.awa != 1);
            }
            ao BJ = com.baidu.live.guardclub.g.BH().BJ();
            if (BJ == null || BJ.aAa <= 0) {
                i5 = 1000;
            } else {
                i5 = BJ.aAa;
            }
            gVar.bB(i5);
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
            if (!this.fLJ) {
                this.fLK = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byG() {
        cA(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bc bcVar) {
        if (bcVar != null && AP()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.q(bzf().pageContext.getPageActivity(), bcVar.aBr, bcVar.liveId, bcVar.aBs)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Ge().aWF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bzf().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Ge().aWF.ayw, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bzf().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byH() {
        if (this.fLf != null) {
            this.fLf.c(this.fKK.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byI() {
        q Fk = bzf().fTb.Fk();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fk == null || Fk.mLiveInfo == null) ? "" : Fk.mLiveInfo.feed_id, DN());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cj(String str) {
        if (this.fLf != null) {
            this.fLf.eW(str);
        }
    }

    private void byJ() {
        if ("home_rec_play".equals(bzf().fromType) || "frs_play".equals(bzf().fromType) || "frs_live_play".equals(bzf().fromType) || "person_play".equals(bzf().fromType) || "search".equals(bzf().fromType) || "person_attention".equals(bzf().fromType)) {
            com.baidu.live.b.uM().aL(true);
        } else {
            com.baidu.live.b.uM().aL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kn(boolean z) {
        View xY;
        if (this.fLb == null) {
            f fVar = new f();
            fVar.aDG = false;
            fVar.context = bzf().pageContext.getPageActivity();
            fVar.aDP = z;
            fVar.fromType = bzf().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLb = (w) runTask.getData();
            }
        }
        if (this.fLb != null && (xY = this.fLb.xY()) != null && this.fKK.fTc.indexOfChild(xY) < 0) {
            this.fKK.fTc.addView(xY, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byK() {
        View yx;
        if (this.fLm == null) {
            ab abVar = new ab();
            abVar.aDG = false;
            abVar.pageContext = bzf().pageContext;
            abVar.fromType = bzf().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLm = (y) runTask.getData();
            }
        }
        if (this.fLm != null && (yx = this.fLm.yx()) != null && bzf().fTc.indexOfChild(yx) < 0) {
            if (yx.getParent() instanceof ViewGroup) {
                ((ViewGroup) yx.getParent()).removeView(yx);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bzf().fTc.addView(yx, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byL() {
        View yq;
        if (this.fLc == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aDG = false;
            aVar.context = bzf().pageContext.getPageActivity();
            aVar.fromType = bzf().fromType;
            aVar.aDH = bzf().fTg;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLc = (u) runTask.getData();
            }
        }
        if (this.fLc != null && (yq = this.fLc.yq()) != null && bzf().fTc.indexOfChild(yq) < 0) {
            if (yq.getParent() instanceof ViewGroup) {
                ((ViewGroup) yq.getParent()).removeView(yq);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bzf().fTc.addView(yq, layoutParams);
        }
    }

    private void byM() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byN() {
        CustomResponsedMessage runTask;
        if (this.fLa == null && (runTask = MessageManager.getInstance().runTask(2913099, l.class, bzf().pageContext)) != null) {
            this.fLa = (l) runTask.getData();
        }
        if (this.fLa != null) {
            this.fLa.setOtherParams(this.otherParams);
            this.fLa.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.im.l.a
                public void CK() {
                    b.this.byQ();
                }
            });
            this.fLa.a(bzf().fTb.Fk(), false);
            View CI = this.fLa.CI();
            if (CI != null && this.fLz.indexOfChild(CI) < 0) {
                Resources resources = bzf().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bzf().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.fLz.addView(CI, layoutParams);
            }
        }
    }

    private void byO() {
        if (this.fKX == null) {
            this.fKX = new com.baidu.tieba.ala.liveroom.g.a(bzf().pageContext);
        }
        if (this.fLE != null) {
            this.fKX.Cn(this.fLE.user_id);
        }
        this.fKX.ao(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kt(boolean z) {
        CustomResponsedMessage runTask;
        if (bzf() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bzf().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLu = (com.baidu.live.i.a) runTask.getData();
            this.fLu.a(bym(), byY());
            if (bzf().fTb != null) {
                this.fLu.a(bzf().fTb.Fk());
            }
            this.fLu.setCanVisible(!z);
            this.fLu.bC(true);
            this.fLu.a(bzf().fTb.bth());
        }
    }

    private void byP() {
        if (this.fLk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bzf().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLk = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avj != null && bzf().fTb.Fk().mLiveInfo != null) {
            this.fLk.setHost(false);
            this.fLk.setOtherParams(DN());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bzf().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.fLk.a(this.fLy, layoutParams, bzf().fTb.Fk());
            this.fLk.a(new com.baidu.live.guardclub.l() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                @Override // com.baidu.live.guardclub.l
                public void BN() {
                    b.this.bzg();
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
                        qQ(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzf().fTb.Fk().avC.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzf().fTb.Fk().avC.isAdmin = 0;
                            bzf().fTb.bFi();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bzf().fTb.Fk().avC.isAdmin = 0;
                        bzf().fTb.bFi();
                    }
                } else if ("task".equals(optString2)) {
                    cU(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.fLd != null && !bzf().fTf) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bzf().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bzf().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bzf().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bux()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.fLd.a(bzf().fTa.getLiveContainerView(), str, 1);
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
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bzf().fTb.Fk() != null && bzf().fTb.Fk().mLiveInfo != null) {
                        String str2 = bzf().fTb.Fk().mLiveInfo.feed_id;
                        long j4 = bzf().fTb.Fk().mLiveInfo.live_id;
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
                    if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null && bzf().fTb.Fk().avC.userId == optLong3) {
                        bzf().fTb.Fk().avC.isBlock = 1;
                        bxY();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null && bzf().fTb.Fk().avC.userId == optLong4) {
                        bzf().fTb.Fk().avC.isBlock = 0;
                        bxY();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null && bzf().fTb.Fk().avC.userId == optLong5) {
                        bzf().fTb.Fk().avC.isUegBlock = 1;
                        bxY();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null && bzf().fTb.Fk().avC.userId == optLong6) {
                        bzf().fTb.Fk().avC.isUegBlock = 0;
                        bxY();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bzf() != null && bzf().fTb != null && bzf().fTb.Fk() != null && bzf().fTb.Fk().avC != null) {
                        if (bzf().fTb.Fk().avC.userId == jSONObject2.optLong("user_id")) {
                            bzf().fTb.bFi();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bzf().fTb.Fk().avC));
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
            if (this.fKV != null) {
                this.fKV.z(aVar);
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
            if (bzf().fTb == null || bzf().fTb.Fk() == null || bzf().fTb.Fk().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bzf().fTb.Fk().mLiveInfo.live_id;
                long j6 = bzf().fTb.Fk().mLiveInfo.group_id;
                long j7 = bzf().fTb.Fk().avj.userId;
                str5 = bzf().fTb.Fk().mLiveInfo.appId;
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
            dVar.fSz = optLong8;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void Cf(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void byQ() {
        if (byR()) {
            BdUtilHelper.hideSoftKeyPad(bzf().pageContext.getPageActivity(), bzf().fTa.getLiveContainerView());
            byj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byR() {
        if (byi() == null || byi().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(q qVar) {
        CustomResponsedMessage runTask;
        bzf().fTc.setOnTouchListener(this.fMh);
        byZ();
        bza();
        byM();
        byO();
        byP();
        if (this.fKY != null) {
            this.fKY.g(bzf().fTb.Fk());
        }
        if (this.fLe != null) {
            this.fLe.c(bzf().fTb.Fk(), DN());
        }
        if (this.fLf != null) {
            this.fLf.a(bzf().fTb.Fk(), DN());
        }
        if (this.fLg != null) {
            this.fLg.c(bzf().fTb.Fk(), DN());
        }
        if (bzf().fTc != null) {
            bzf().fTc.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean A = b.this.A(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.byR() && b.this.fKT != null) {
                        b.this.fKT.ll(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.fKT != null) {
                        b.this.fKT.ll(true);
                    }
                    return A;
                }
            });
            bzf().fTc.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.z(motionEvent);
                }
            });
        }
        if (this.fLr == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bzf().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLr = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byS() {
        q Fk;
        ViewGroup viewGroup;
        if (bzf() != null && bzf().fTb != null && (Fk = bzf().fTb.Fk()) != null && Fk.mLiveInfo != null && !Fk.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bzf().fTa) != null) {
            if (this.fLv == null) {
                this.fLv = new com.baidu.tieba.ala.liveroom.recommend.a(bzf().pageContext);
            }
            this.fLv.r(Fk);
            this.fLv.a(bzf().fTc);
            this.fLv.ao(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.fLv);
            a((com.baidu.live.liveroom.g.b) this.fLv);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.fLO == null) {
            this.fLO = new ArrayList();
        }
        if (!this.fLO.contains(dVar)) {
            this.fLO.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.fLO != null && this.fLO.contains(dVar)) {
            this.fLO.remove(dVar);
        }
    }

    protected void byT() {
        if (this.fLO != null) {
            this.fLO.clear();
            this.fLO = null;
        }
    }

    protected boolean z(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fLO == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.fLO.iterator();
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
        if (this.fLP == null) {
            this.fLP = new ArrayList();
        }
        if (!this.fLP.contains(bVar)) {
            this.fLP.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.fLP != null && this.fLP.contains(bVar)) {
            this.fLP.remove(bVar);
        }
    }

    protected void byU() {
        if (this.fLP != null) {
            this.fLP.clear();
            this.fLP = null;
        }
    }

    protected boolean A(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fLP == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.fLP.iterator();
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
    public void byV() {
        if (this.fLt == null && this.fLw != null && this.fLw.aAV && bzf() != null && bzf().fTb != null && bzf().fTb.Fk() != null) {
            this.fLt = new com.baidu.tieba.ala.liveroom.g.e(bzf().pageContext, this.fLw);
            this.fLt.q(bzf().fTb.Fk());
            if (this.fLw.aAY == 1) {
                if (this.fKZ != null) {
                    this.fLH = true;
                }
            } else if (this.fLw.aAY == 2) {
                a(bzf().fTb.Fk(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void byW() {
        CustomResponsedMessage runTask;
        if (bzf() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bzf().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fLx = (com.baidu.live.q.a) runTask.getData();
            this.fLx.a(byl(), byX());
            if (bzf().fTb != null) {
                this.fLI = this.fLx.m(bzf().fTb.Fk());
            }
            this.fLx.setCanVisible(!this.fLC);
        }
    }

    private ViewGroup.LayoutParams byX() {
        int dimensionPixelOffset;
        if (bxC()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bzf().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bzf().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams byY() {
        int dimensionPixelOffset;
        if (bxC()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bzf().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bzf().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ku(boolean z) {
        Rect rect = new Rect();
        bzf().fTa.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bzf().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bzf().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bzf().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bzf().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void byZ() {
        if (this.fKT != null) {
            this.fKT.au(bzf().fTc);
        }
    }

    private void bza() {
        if (this.fKW == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.fKW = (com.baidu.live.x.a) runTask.getData();
            }
            bzb();
        }
    }

    private void cU(JSONObject jSONObject) {
        if (this.fKW != null) {
            if (this.fKQ != null) {
                this.fKW.bY(this.fKQ.bBN() ? false : true);
            } else {
                this.fKW.bY(true);
            }
            this.fKW.G(jSONObject);
        }
    }

    private void bzb() {
        if (this.fKW != null && bzf().fTb.Fk() != null && bzf().fTb.Fk().avM != null) {
            if (this.fKQ != null) {
                this.fKW.bY(this.fKQ.bBN() ? false : true);
            } else {
                this.fKW.bY(true);
            }
            this.fKW.a(bzf().fTb.Fk().avM);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(q qVar) {
        if (qVar != null) {
            if (this.fKL != null && this.fKL.bFD() != null && qVar.mLiveInfo != null) {
                if ((this.fKL.bFD().getVisibility() == 0) != qVar.mLiveInfo.isGoodsListVisible()) {
                    com.baidu.live.utils.o.a(qVar.mLiveInfo.feed_id, qVar.mLiveInfo.live_id, false, false);
                }
            }
            bzb();
            if (this.fKX != null && qVar.avj != null) {
                this.fKX.Cn(String.valueOf(qVar.avj.userId));
            }
            if (this.fKN != null) {
                this.fKN.a(qVar);
            }
            if (this.fLc != null && qVar.mLiveInfo != null) {
                this.fLc.a(qVar.mLiveInfo);
            }
            if (this.fLa != null) {
                this.fLa.a(qVar);
            }
            if (this.fLx != null) {
                this.fLI = this.fLx.m(qVar);
            }
            if (this.fLu != null) {
                this.fLu.a(qVar);
            }
            qQ(qVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void qQ(int i) {
        if (!bzf().fTf) {
            if (this.fLA < 0 && i == 0) {
                this.fLA = i;
            } else if (this.fLA != i) {
                if (i == 1) {
                    if (!this.fLd.rz(2)) {
                        String string = bzf().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bzf().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.fLd.a(bzf().fTa.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bzf().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.fLd.rA(2);
                    this.fLd.rA(3);
                    if (bux()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.fLd.a(bzf().fTa.getLiveContainerView(), string2, 3);
                    }
                }
                this.fLA = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bS(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bS(z);
        if (z) {
            bzc();
        }
        if (this.fKV != null) {
            this.fKV.bHx();
        }
        if (this.fKO != null) {
            this.fKO.vm();
        }
        if (this.fKQ != null) {
            this.fKQ.onDestroy();
        }
        if (this.fKW != null) {
            this.fKW.onDestroy();
            this.fKW = null;
        }
        if (this.fLb != null) {
            View xY = this.fLb.xY();
            if (xY != null && xY.getParent() != null) {
                ((ViewGroup) xY.getParent()).removeView(xY);
            }
            this.fLb.onDestroy();
            this.fLb = null;
        }
        if (this.fLa != null) {
            this.fLa.a((l.a) null);
            this.fLa.BZ();
        }
        if (this.fKM != null) {
            this.fKM.vm();
        }
        if (this.fLd != null) {
            this.fLd.vm();
        }
        this.fLA = -1;
        if (this.fKX != null) {
            this.fKX.vm();
            this.fKX.onDestroy();
        }
        if (this.fKR != null) {
            this.fKR.bHu();
        }
        if (this.fKS != null) {
            this.fKS.bxw();
        }
        if (this.fKY != null) {
            this.fKY.yw();
        }
        if (this.fLe != null) {
            this.fLe.bBW();
        }
        if (this.fLf != null) {
            this.fLf.yw();
        }
        if (this.fLg != null) {
            this.fLg.onDestroy();
        }
        if (this.fLi != null) {
            this.fLi.onDestory();
        }
        if (this.fLl != null) {
            this.fLl.BL();
        }
        if (this.fLk != null) {
            this.fLk.BL();
        }
        if (this.fLt != null) {
            this.fLt.onDestroy();
        }
        if (this.fLo != null) {
            this.fLo.yw();
        }
        if (this.fLp != null) {
            this.fLp.yw();
        }
        if (this.fLr != null) {
            this.fLr.yw();
        }
        if (this.fKP != null) {
            this.fKP.onDestory();
        }
        if (this.fLx != null) {
            this.fLx.yw();
        }
        if (this.fLu != null) {
            this.fLu.BL();
        }
        if (this.fLq != null) {
            this.fLq.yw();
        }
        if (this.fLm != null) {
            this.fLm.onDestroy();
        }
        if (this.fLv != null) {
            this.fLv.vm();
            b((com.baidu.live.liveroom.g.d) this.fLv);
            b((com.baidu.live.liveroom.g.b) this.fLv);
        }
        ShowUtil.windowCount = 0;
        byT();
        byU();
    }

    private void bzc() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bzf().fTc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bzf().fTc.getChildAt(i);
            if (childAt != this.fLy && childAt != this.fLz) {
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
        if (this.fLy != null) {
            this.fLy.removeAllViews();
        }
        if (this.fLz != null) {
            this.fLz.removeAllViews();
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
        if (this.fLb != null && (xY = this.fLb.xY()) != null && xY.getParent() != null) {
            ((ViewGroup) xY.getParent()).removeView(xY);
        }
        if (this.fLa != null && (CI = this.fLa.CI()) != null && CI.getParent() != null) {
            ((ViewGroup) CI.getParent()).removeView(CI);
        }
        if (this.fKQ != null) {
            this.fKQ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Ff() {
        if (this.fKU == null || !this.fKU.bBS()) {
            if (this.fKQ == null || !this.fKQ.aq(bzf().fTa.getLiveContainerView())) {
                if (this.fKT != null) {
                    this.fKT.bvg();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.fLh != null && this.fLh.bBB()) {
                    this.fLh.bBK();
                    return false;
                } else if (this.fLg == null || !this.fLg.bBV()) {
                    byJ();
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
        if (this.fLs != null) {
            this.fLs.destroy();
        }
        if (this.fKW != null) {
            this.fKW.onDestroy();
            this.fKW = null;
        }
        if (this.fKV != null) {
            this.fKV.bHx();
        }
        if (this.fLb != null) {
            this.fLb.onDestroy();
            this.fLb = null;
        }
        if (this.fLc != null) {
            this.fLc.onDestroy();
            this.fLc = null;
        }
        if (this.fLd != null) {
            this.fLd.onDestroy();
        }
        if (this.fKM != null) {
            this.fKM.onDestroy();
        }
        if (this.fKO != null) {
            this.fKO.onDestroy();
        }
        if (this.fLm != null) {
            this.fLm.onDestroy();
            this.fLm = null;
        }
        if (this.fLa != null) {
            this.fLa.a((l.a) null);
            this.fLa.release();
            this.fLa = null;
        }
        if (this.fLe != null) {
            this.fLe.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.fLe.release();
        }
        if (this.fLf != null) {
            this.fLf.a(null);
            this.fLf.release();
        }
        if (this.fLg != null) {
            this.fLg.a((a.InterfaceC0564a) null);
            this.fLg.onDestroy();
        }
        if (this.fLk != null) {
            this.fLk.onDestroy();
        }
        if (this.fLl != null) {
            this.fLl.onDestroy();
        }
        if (this.fLi != null) {
            this.fLi.onDestory();
        }
        if (this.fLt != null) {
            this.fLt.onDestroy();
        }
        if (this.fLj != null) {
            this.fLj.release();
        }
        if (this.fLo != null) {
            this.fLo.release();
        }
        if (this.fLq != null) {
            this.fLq.release();
        }
        if (this.fLp != null) {
            this.fLp.release();
        }
        if (this.fLr != null) {
            this.fLr.release();
        }
        if (this.fKP != null) {
            this.fKP.onDestory();
        }
        if (this.fLx != null) {
            this.fLx.release();
        }
        if (this.fLu != null) {
            this.fLu.onDestroy();
        }
        if (this.fKT != null) {
            this.fKT.onDestroy();
        }
        if (this.fLv != null) {
            this.fLv.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.fLv);
            b((com.baidu.live.liveroom.g.b) this.fLv);
        }
        byT();
        byU();
        MessageManager.getInstance().unRegisterListener(this.fMf);
        MessageManager.getInstance().unRegisterListener(this.fLV);
        MessageManager.getInstance().unRegisterListener(this.fLW);
        MessageManager.getInstance().unRegisterListener(this.fLY);
        MessageManager.getInstance().unRegisterListener(this.fLR);
        MessageManager.getInstance().unRegisterListener(this.fLS);
        MessageManager.getInstance().unRegisterListener(this.fLQ);
        MessageManager.getInstance().unRegisterListener(this.fLU);
        MessageManager.getInstance().unRegisterListener(this.fLT);
        MessageManager.getInstance().unRegisterListener(this.fLZ);
        MessageManager.getInstance().unRegisterListener(this.fnT);
        MessageManager.getInstance().unRegisterListener(this.fMa);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fwL);
        MessageManager.getInstance().unRegisterListener(this.fwI);
        MessageManager.getInstance().unRegisterListener(this.aTq);
        MessageManager.getInstance().unRegisterListener(this.fMb);
        MessageManager.getInstance().unRegisterListener(this.fMc);
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fMg);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.fLe != null) {
            this.fLe.kQ(false);
        }
        if (this.fLg != null) {
            this.fLg.kQ(false);
        }
        byj();
        if (this.fLj != null) {
            this.fLj.pause();
        }
        if (this.fLo != null) {
            this.fLo.pause();
        }
        if (this.fLq != null) {
            this.fLq.pause();
        }
        if (this.fLm != null) {
            this.fLm.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.fLK = false;
        if (this.fLD && this.fLE != null) {
            a(this.fLE);
            this.fLD = false;
        }
        if (this.fLe != null) {
            this.fLe.kQ(true);
        }
        if (this.fLg != null) {
            this.fLg.kQ(true);
        }
        if (this.fLj != null) {
            this.fLj.resume();
        }
        if (this.fLo != null) {
            this.fLo.resume();
        }
        if (this.fLq != null) {
            this.fLq.resume();
        }
        if (this.fLm != null) {
            this.fLm.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bzd() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fLv != null && this.fLv.isOpen()) {
            this.fLv.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bzd();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, -1, -1);
                    return;
                }
                return;
            }
            bzd();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bzd();
        } else if (i == 25034) {
            byG();
        } else if (i == 25043) {
            if (i2 == -1) {
                bzg();
            }
        } else if (i == 25050 && this.fLs != null) {
            if (i2 == -1) {
                this.fLs.N(intent);
            } else {
                this.fLs.N(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.fLC = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bze() {
        return (bzf().fTb.Fk() == null || bzf().fTb.Fk().mLiveInfo == null || bzf().fTb.Fk().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.fKQ != null) {
                this.fKQ.bp(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.fLg != null) {
            this.fLg.aNc();
        }
        if (this.fKP != null) {
            this.fKP.aNc();
        }
        if (this.fLv != null) {
            this.fLv.bp(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.fKK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bzf() {
        return this.fKK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzg() {
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

    public boolean cy(int i) {
        if (7 == i) {
            if (this.fLb != null) {
                this.fLb.bb(true);
            }
            if (this.fKM != null) {
                this.fKM.bxx();
            }
        } else if (1 == i) {
            if (byi() != null) {
                byi().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.fLC) {
                return false;
            }
            if (this.fKQ == null || !this.fKQ.bBN()) {
                return this.fKM == null || this.fKM.bxz();
            }
            return false;
        } else if (3 == i) {
            if (bzf().fTc != null) {
                bzf().fTc.setEnabled(false);
                if (this.aWi != null) {
                    this.aWi.e(!bzf().fTd, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.fKM == null || !this.fKM.isShowing();
        }
        return true;
    }

    public void qO(int i) {
        if ((i == 7 || i == 11) && this.fKM != null) {
            this.fKM.bxx();
            this.fKM.kl(false);
        }
    }

    public void cz(int i) {
    }

    public void cA(int i) {
        if (7 == i) {
            if (this.fLb != null) {
                this.fLb.bb(false);
            }
            if (this.fKM != null) {
                this.fKM.kl(true);
            }
        } else if (11 == i) {
            if (this.fKM != null) {
                this.fKM.kl(true);
            }
        } else if (3 == i) {
            bzf().fTc.setEnabled(true);
            if (this.aWi != null) {
                this.aWi.e(bzf().fTd ? false : true, true);
            }
            if (this.fKW != null) {
                this.fKW.bY(true);
            }
        } else if (2 == i && this.fKV != null) {
            this.fKV.lu(true);
        }
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fLa != null) {
            this.fLa.setOtherParams(str);
        }
    }

    private boolean bux() {
        return bzf().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
