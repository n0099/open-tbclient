package com.baidu.tieba.ala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
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
import com.baidu.live.c.q;
import com.baidu.live.data.ah;
import com.baidu.live.data.aq;
import com.baidu.live.data.au;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.gift.f;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.guardclub.h;
import com.baidu.live.guardclub.k;
import com.baidu.live.guardclub.l;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.live.view.input.c;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.liveroom.h.e;
import com.baidu.tieba.ala.liveroom.k.a;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean eSC;
    private com.baidu.tieba.ala.liveroom.data.a eRD;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eRE;
    protected com.baidu.live.h.a eRF;
    protected com.baidu.tieba.ala.liveroom.share.c eRG;
    protected com.baidu.tieba.ala.liveroom.o.b eRH;
    protected com.baidu.tieba.ala.liveroom.guide.c eRI;
    protected com.baidu.tieba.ala.liveroom.watermark.a eRJ;
    protected com.baidu.tieba.ala.liveroom.b.b eRK;
    protected com.baidu.tieba.ala.liveroom.praise.a eRL;
    protected com.baidu.tieba.ala.liveroom.guide.d eRM;
    protected com.baidu.tieba.ala.liveroom.u.a eRN;
    protected com.baidu.live.x.a eRO;
    private com.baidu.tieba.ala.liveroom.g.a eRP;
    private m eRQ;
    i eRR;
    j eRS;
    protected u eRT;
    protected s eRU;
    protected com.baidu.tieba.ala.liveroom.tippop.a eRV;
    private com.baidu.tieba.ala.liveroom.guideim.b eRW;
    protected com.baidu.live.view.input.c eRX;
    com.baidu.tieba.ala.liveroom.k.a eRY;
    protected com.baidu.tieba.ala.liveroom.guide.a eRZ;
    public boolean eSA;
    public boolean eSB;
    protected com.baidu.tieba.ala.liveroom.q.b eSD;
    protected e eSE;
    private k eSa;
    protected com.baidu.tieba.ala.liveroom.f.a eSb;
    protected h eSc;
    protected com.baidu.live.guardclub.j eSd;
    protected w eSe;
    protected com.baidu.tieba.ala.liveroom.turntable.e eSg;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eSh;
    protected com.baidu.tieba.ala.liveroom.n.c eSi;
    private v eSj;
    protected com.baidu.tieba.ala.liveroom.s.a eSk;
    protected com.baidu.tieba.ala.liveroom.g.e eSl;
    protected com.baidu.live.i.a eSm;
    protected aq eSn;
    protected com.baidu.live.q.a eSo;
    protected RelativeLayout eSp;
    protected RelativeLayout eSq;
    protected boolean eSs;
    protected x eSv;
    protected GuardClubInfoHttpResponseMessage eSw;
    boolean eSx;
    boolean eSy;
    boolean eSz;
    protected String otherParams;
    private int eSf = 0;
    private int eSr = -1;
    protected int mOrientation = 0;
    protected boolean eSt = false;
    protected boolean eSu = false;
    private CustomMessageListener eSF = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            if ((customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null) {
                b.this.a(rVar.Yw, rVar.Ys, rVar.Yt, rVar.Yu, rVar.Yv);
            }
        }
    };
    private CustomMessageListener eSG = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bjI().fai.yO().XQ.userId);
            com.baidu.live.view.a.Bj().a(valueOf, new com.baidu.live.data.b(b.this.bjI().fai.yO().XQ.portrait, valueOf, true, b.this.bjI().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eSH = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.m) && b.this.eRG != null) {
                b.this.eRG.c((com.baidu.live.data.m) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener atM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eRR != null) {
                b.this.eRR.h(com.baidu.live.gift.r.sx().sz());
            }
        }
    };
    private CustomMessageListener eSI = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eRD.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.yN(str);
            }
        }
    };
    private CustomMessageListener eSJ = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bjI().pageContext.getPageActivity());
            }
            if (b.this.eRG != null) {
                b.this.eRG.c(b.this.bjI().fai.yO(), false);
            }
        }
    };
    private CustomMessageListener eSK = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    b.this.eSu = true;
                    b.this.eSv = (x) data;
                    b.this.b(b.this.eSv);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eSL = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bjI().fai.yO().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bjI().fai.yO().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bjI().fai.yO().XQ.userId);
            if (b.this.eRH == null) {
                b.this.eRH = new com.baidu.tieba.ala.liveroom.o.b(b.this.bjI().pageContext);
            }
            b.this.eRH.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eRH.a(b.this.eSM);
        }
    };
    private b.a eSM = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void yZ() {
            if (b.this.bjI().fai.yO() != null && b.this.bjI().fai.yO().Ye != null) {
                b.this.bjI().fai.yO().Ye.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eSN = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eSO = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pR(7);
        }
    };
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eSP = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eSx = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eRY != null) {
                b.this.eRY.sN();
            }
        }
    };
    HttpMessageListener eDV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).apX) != null && b.this.eSa != null && b.this.bjI() != null && b.this.bjI().fai != null) {
                int[] iArr = new int[2];
                b.this.eSp.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.eSa.a(b.this.eSp, layoutParams, aVar, b.this.bjI().fai.yO());
                com.baidu.live.l.a.ac(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener eDS = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bjI() != null && b.this.bjI().fai != null && b.this.bjI().fai.yO() != null && guardClubInfoHttpResponseMessage.apX != null) {
                    if (guardClubInfoHttpResponseMessage.apX.WZ == b.this.bjI().fai.yO().XQ.userId) {
                        b.this.eSw = guardClubInfoHttpResponseMessage;
                        if (b.this.eSw.aqa && com.baidu.live.guardclub.e.vG() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.vG().E(b.this.bjI().fai.yO().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eSQ = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof au) {
                b.this.a((au) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSR = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.p(b.this.bjI().fai.yO());
        }
    };
    private CustomMessageListener eSS = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSm != null) {
                b.this.eSm.vO();
            }
        }
    };
    private CustomMessageListener eST = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.eSe != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.eSe).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener eSU = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bjm();
        }
    };
    private View.OnTouchListener eSV = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bjw();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(x xVar);

    protected abstract void b(x xVar);

    protected abstract View biP();

    public abstract boolean biQ();

    protected abstract boolean biR();

    protected abstract ViewGroup biS();

    protected abstract ViewGroup biT();

    public abstract boolean bim();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(aq aqVar) {
        this.eSn = aqVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eSp = (RelativeLayout) bjI().faj.findViewById(a.g.ala_live_header_view);
        this.eSq = (RelativeLayout) bjI().faj.findViewById(a.g.ala_live_footer_view);
        tq();
        registerListener();
    }

    public void biY() {
    }

    private void tq() {
        if (this.eRG == null) {
            this.eRG = new com.baidu.tieba.ala.liveroom.share.c(bjI().pageContext);
        }
        this.eRN = new com.baidu.tieba.ala.liveroom.u.a(bjI().pageContext, this);
        this.eRK = new com.baidu.tieba.ala.liveroom.b.b(bjI().pageContext, false);
        this.eRL = new com.baidu.tieba.ala.liveroom.praise.a(bjI().pageContext);
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
                this.eRM = new com.baidu.tieba.ala.liveroom.guide.d(bjI().pageContext);
            }
        }
        this.eRV = new com.baidu.tieba.ala.liveroom.tippop.a(bjI().pageContext, this);
        biZ();
        bjb();
        bjc();
        bjd();
        bjg();
        bjh();
        bji();
        bjj();
    }

    private void biZ() {
        this.eRQ = new m();
    }

    public void iU(boolean z) {
        this.eSs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bja() {
        com.baidu.live.data.m yO = bjI().fai.yO();
        boolean z = com.baidu.live.v.a.zl().awB.aaS;
        if (yO.mLiveInfo != null && yO.mLiveInfo.mAlaLiveSwitchData != null && yO.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = yO.Yo ? z : false;
        if (z2) {
            if (this.eRF == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bjI().pageContext);
                if (runTask != null) {
                    this.eRF = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eRF != null) {
                this.eRF.bV(1);
                View view = this.eRF.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bjI().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bjI().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eSp.addView(view, layoutParams);
                    if (z2) {
                        this.eRF.a(yO);
                    }
                }
            }
        }
    }

    private void bjb() {
        this.eRW = new com.baidu.tieba.ala.liveroom.guideim.b(bjI().pageContext);
        this.eRW.c(this.eSq, bim());
        this.eRW.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean ws() {
                return b.this.uX();
            }
        });
    }

    private void bjc() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bjI().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eRX = (com.baidu.live.view.input.c) runTask.getData();
            this.eRX.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                @Override // com.baidu.live.view.input.c.a
                public void Bx() {
                    b.this.pR(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void By() {
                    b.this.ce(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean ws() {
                    return b.this.uX();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean xn() {
                    return b.this.bjf();
                }
            });
        }
    }

    private void bjd() {
        this.eRY = new com.baidu.tieba.ala.liveroom.k.a(this.eRD.pageContext);
        this.eRY.a(new a.InterfaceC0461a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public boolean bjK() {
                return b.this.biR();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public void onClose() {
                if (b.this.awf != null) {
                    b.this.awf.bb(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iV(boolean z) {
        if (this.eRW != null) {
            this.eRW.jt(z);
        }
        if (this.eRY != null) {
            this.eRY.jt(z);
        }
        eSC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bje() {
        return eSC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjf() {
        com.baidu.live.data.m yO;
        if (bjI() == null || bjI().fai == null || (yO = bjI().fai.yO()) == null || yO.Ye == null) {
            return false;
        }
        String str = yO.Ye.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bjg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bjI().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eSa = (k) runTask.getData();
            this.eSa.setOtherParams(xx());
        }
    }

    private void bjh() {
        this.eSb = new com.baidu.tieba.ala.liveroom.f.a(bjI().pageContext);
    }

    private void bji() {
        this.eSg = new com.baidu.tieba.ala.liveroom.turntable.e(bjI().pageContext.getPageActivity());
    }

    private void bjj() {
        this.eSi = new com.baidu.tieba.ala.liveroom.n.c(bjI().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eSK);
        MessageManager.getInstance().registerListener(this.eSL);
        MessageManager.getInstance().registerListener(this.eSN);
        MessageManager.getInstance().registerListener(this.eSG);
        MessageManager.getInstance().registerListener(this.eSH);
        MessageManager.getInstance().registerListener(this.eSF);
        MessageManager.getInstance().registerListener(this.eSJ);
        MessageManager.getInstance().registerListener(this.eSI);
        MessageManager.getInstance().registerListener(this.eSO);
        MessageManager.getInstance().registerListener(this.evL);
        MessageManager.getInstance().registerListener(this.eSP);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.eDV);
        MessageManager.getInstance().registerListener(this.eDS);
        MessageManager.getInstance().registerListener(this.atM);
        MessageManager.getInstance().registerListener(this.eSQ);
        MessageManager.getInstance().registerListener(this.eSR);
        MessageManager.getInstance().registerListener(this.eSS);
        MessageManager.getInstance().registerListener(this.eST);
        MessageManager.getInstance().registerListener(this.eSU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uX() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bjI().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bjI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bjI().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zl().awB.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bjI().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bjI().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bjI().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bjI().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjk() {
        if (this.eRR != null) {
            this.eRR.wr().b(this.eRX.xe(), com.baidu.live.gift.r.sx().sz());
            iV(true);
            if (this.eSj == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, v.class, bjI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.eSj = (v) runTask.getData();
                } else {
                    return;
                }
            }
            this.eSj.sK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjl() {
        if (this.eRR != null) {
            this.eRR.wr().hide();
            iV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i, int i2, int i3) {
        if (bjI().fai.yO() != null && bjI().fai.yO().XQ != null && bjI().fai.yO().mLiveInfo != null) {
            a(bjI().fai.yO(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && uX()) {
            if (mVar == null) {
                mVar = bjI().fai.yO();
            }
            String valueOf = String.valueOf(mVar.XQ.userId);
            String str = mVar.XQ.userName;
            String valueOf2 = String.valueOf(mVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(mVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(mVar.mLiveInfo.feed_id);
            int i6 = mVar.Ye.isBlock;
            String sI = t.sI();
            String str2 = mVar.mLiveInfo.appId;
            boolean z2 = mVar.Ye.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (mVar.mLiveInfo.live_type == 1 && mVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.zl().awB.Zz) {
                z3 = true;
            }
            int i7 = -1;
            if (mVar.Ye == null) {
                z = false;
            } else {
                boolean z4 = mVar.Ye.isNewUser;
                i7 = mVar.Ye.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.eSw != null && this.eSw.apX != null && this.eSw.apX.WZ == mVar.XQ.userId) {
                z5 = this.eSw.aqa;
            }
            g gVar = new g(bjI().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, sI, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.ap(mVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.ao(z);
            ah vJ = com.baidu.live.guardclub.g.vH().vJ();
            if (vJ == null || vJ.acj <= 0) {
                i5 = 1000;
            } else {
                i5 = vJ.acj;
            }
            gVar.bh(i5);
            boolean z6 = false;
            if (mVar != null && mVar.Ye != null) {
                String str3 = mVar.Ye.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.aq(z6);
            if (!this.eSA) {
                this.eSB = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjm() {
        ce(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && uX()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(bjI().pageContext.getPageActivity(), auVar.adB, auVar.liveId, auVar.adC)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zl().awB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bjI().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zl().awB.aaT, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjn() {
        if (this.eRX != null) {
            this.eRX.c(this.eRD.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjo() {
        com.baidu.live.data.m yO = bjI().fai.yO();
        LogManager.getCommonLogger().doClickQuickImHiLog((yO == null || yO.mLiveInfo == null) ? "" : yO.mLiveInfo.feed_id, xx());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yO(String str) {
        if (this.eRX != null) {
            this.eRX.dx(str);
        }
    }

    private void bjp() {
        if ("home_rec_play".equals(bjI().fromType) || "frs_play".equals(bjI().fromType) || "frs_live_play".equals(bjI().fromType) || "person_play".equals(bjI().fromType) || "search".equals(bjI().fromType) || "person_attention".equals(bjI().fromType)) {
            com.baidu.live.b.pq().am(true);
        } else {
            com.baidu.live.b.pq().am(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iR(boolean z) {
        View sk;
        if (this.eRT == null) {
            f fVar = new f();
            fVar.afH = false;
            fVar.context = bjI().pageContext.getPageActivity();
            fVar.afP = z;
            fVar.fromType = bjI().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRT = (u) runTask.getData();
            }
        }
        if (this.eRT != null && (sk = this.eRT.sk()) != null && this.eRD.faj.indexOfChild(sk) < 0) {
            this.eRD.faj.addView(sk, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjq() {
        View sM;
        if (this.eSe == null) {
            z zVar = new z();
            zVar.afH = false;
            zVar.pageContext = bjI().pageContext;
            zVar.fromType = bjI().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSe = (w) runTask.getData();
            }
        }
        if (this.eSe != null && (sM = this.eSe.sM()) != null && bjI().faj.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bjI().faj.addView(sM, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjr() {
        View sC;
        if (this.eRU == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = false;
            aVar.context = bjI().pageContext.getPageActivity();
            aVar.fromType = bjI().fromType;
            aVar.afI = bjI().fan;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRU = (s) runTask.getData();
            }
        }
        if (this.eRU != null && (sC = this.eRU.sC()) != null && bjI().faj.indexOfChild(sC) < 0) {
            if (sC.getParent() instanceof ViewGroup) {
                ((ViewGroup) sC.getParent()).removeView(sC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bjI().faj.addView(sC, layoutParams);
        }
    }

    private void bjs() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjt() {
        CustomResponsedMessage runTask;
        if (this.eRS == null && (runTask = MessageManager.getInstance().runTask(2913099, j.class, bjI().pageContext)) != null) {
            this.eRS = (j) runTask.getData();
        }
        if (this.eRS != null) {
            this.eRS.setOtherParams(this.otherParams);
            this.eRS.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.j.a
                public void wz() {
                    b.this.bjw();
                }
            });
            this.eRS.a(bjI().fai.yO(), false);
            View wx = this.eRS.wx();
            if (wx != null && this.eSq.indexOfChild(wx) < 0) {
                Resources resources = bjI().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjI().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.eSq.addView(wx, layoutParams);
            }
        }
    }

    private void bju() {
        if (this.eRP == null) {
            this.eRP = new com.baidu.tieba.ala.liveroom.g.a(bjI().pageContext);
        }
        if (this.eSv != null) {
            this.eRP.yS(this.eSv.user_id);
        }
        this.eRP.af(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iW(boolean z) {
        CustomResponsedMessage runTask;
        if (bjI() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bjI().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSm = (com.baidu.live.i.a) runTask.getData();
            this.eSm.a(biT(), bjB());
            if (bjI().fai != null) {
                this.eSm.a(bjI().fai.yO());
            }
            this.eSm.setCanVisible(!z);
            this.eSm.aP(true);
            this.eSm.a(bjI().fai.bdY());
        }
    }

    private void bjv() {
        if (this.eSc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bjI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSc = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bjI().fai.yO() != null && bjI().fai.yO().XQ != null && bjI().fai.yO().mLiveInfo != null) {
            this.eSc.setHost(false);
            this.eSc.setOtherParams(xx());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bjI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.eSc.a(this.eSp, layoutParams, bjI().fai.yO());
            this.eSc.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void vN() {
                    b.this.bjJ();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x0468, code lost:
        yK(r27);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(com.baidu.live.im.data.a aVar) {
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
        } catch (JSONException e) {
            jSONObject = null;
        }
        try {
            String optString = jSONObject4.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
            }
            jSONObject3 = jSONObject4.optJSONObject("ext_data");
            jSONObject2 = jSONObject4;
        } catch (JSONException e2) {
            jSONObject = jSONObject4;
            jSONObject2 = jSONObject;
            jSONObject3 = null;
            if (aVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.awf != null) {
                        this.awf.bd(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        pT(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjI().fai.yO().Ye.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjI().fai.yO().Ye.isAdmin = 0;
                            bjI().fai.bpD();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bjI().fai.yO().Ye.isAdmin = 0;
                        bjI().fai.bpD();
                    }
                } else if ("task".equals(optString2)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eRV != null && !bjI().fam) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bjI().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bjI().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bjI().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bfk()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eRV.a(bjI().fah.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.awf != null) {
                                b.this.awf.bc(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bjI().fai.yO() != null && bjI().fai.yO().mLiveInfo != null) {
                        String str2 = bjI().fai.yO().mLiveInfo.feed_id;
                        long j4 = bjI().fai.yO().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                            o.g(str2, j4);
                            com.baidu.live.utils.m.h(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.q.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bjI() != null && bjI().fai != null && bjI().fai.yO() != null && bjI().fai.yO().Ye != null && bjI().fai.yO().Ye.userId == jSONObject2.optLong("user_id")) {
                        bjI().fai.bpD();
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str3 = optLong3 + "";
                        TbadkCoreApplication.getInst();
                        if (str3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.eRN != null) {
                this.eRN.v(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a xo = aVar.xo();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong4 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bjI().fai == null || bjI().fai.yO() == null || bjI().fai.yO().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bjI().fai.yO().mLiveInfo.live_id;
                long j6 = bjI().fai.yO().mLiveInfo.group_id;
                long j7 = bjI().fai.yO().XQ.userId;
                str4 = bjI().fai.yO().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    t.b(optString9, xo.userId, xo.portrait, xo.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "");
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.zs().dY(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                t.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, xo.userId, xo.portrait, xo.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "");
                yK(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.eZB = optLong4;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yK(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjw() {
        if (bjx()) {
            BdUtilHelper.hideSoftKeyPad(bjI().pageContext.getPageActivity(), bjI().fah.getLiveContainerView());
            biQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjx() {
        if (biP() == null || biP().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        bjI().faj.setOnTouchListener(this.eSV);
        bjC();
        bjD();
        bjs();
        bju();
        bjv();
        if (this.eRQ != null) {
            this.eRQ.g(bjI().fai.yO());
        }
        if (this.eRW != null) {
            this.eRW.c(bjI().fai.yO(), xx());
        }
        if (this.eRX != null) {
            this.eRX.a(bjI().fai.yO(), xx());
        }
        if (this.eRY != null) {
            this.eRY.c(bjI().fai.yO(), xx());
        }
        if (bjI().faj != null) {
            bjI().faj.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bjx() && b.this.eRL != null) {
                        b.this.eRL.jK(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eRL != null) {
                        b.this.eRL.jK(true);
                    }
                    return false;
                }
            });
        }
        if (this.eSj == null && (runTask = MessageManager.getInstance().runTask(2913165, v.class, bjI().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSj = (v) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjy() {
        if (this.eSl == null && this.eSn != null && this.eSn.adf && bjI() != null && bjI().fai != null && bjI().fai.yO() != null) {
            this.eSl = new com.baidu.tieba.ala.liveroom.g.e(bjI().pageContext, this.eSn);
            this.eSl.r(bjI().fai.yO());
            if (this.eSn.adi == 1) {
                if (this.eRR != null) {
                    this.eSy = true;
                }
            } else if (this.eSn.adi == 2) {
                a(bjI().fai.yO(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjz() {
        CustomResponsedMessage runTask;
        if (bjI() != null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bjI().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSo = (com.baidu.live.q.a) runTask.getData();
            this.eSo.a(biS(), bjA());
            if (bjI().fai != null) {
                this.eSz = this.eSo.m(bjI().fai.yO());
            }
            this.eSo.setCanVisible(!this.eSt);
        }
    }

    private ViewGroup.LayoutParams bjA() {
        int dimensionPixelOffset;
        if (bim()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bjB() {
        int dimensionPixelOffset;
        if (bim()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iX(boolean z) {
        Rect rect = new Rect();
        bjI().fah.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bjI().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bjI().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bjI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bjI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bjC() {
        if (this.eRL != null) {
            this.eRL.al(bjI().faj);
        }
    }

    private void bjD() {
        if (this.eRO == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eRO = (com.baidu.live.x.a) runTask.getData();
            }
            bjE();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eRO != null) {
            if (this.eRI != null) {
                this.eRO.bj(this.eRI.bmt() ? false : true);
            } else {
                this.eRO.bj(true);
            }
            this.eRO.v(jSONObject);
        }
    }

    private void bjE() {
        if (this.eRO != null && bjI().fai.yO() != null && bjI().fai.yO().Yn != null) {
            if (this.eRI != null) {
                this.eRO.bj(this.eRI.bmt() ? false : true);
            } else {
                this.eRO.bj(true);
            }
            this.eRO.a(bjI().fai.yO().Yn);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.m mVar) {
        if (mVar != null) {
            bjE();
            if (this.eRP != null && mVar.XQ != null) {
                this.eRP.yS(String.valueOf(mVar.XQ.userId));
            }
            if (this.eRF != null) {
                this.eRF.a(mVar);
            }
            if (this.eRU != null && mVar.mLiveInfo != null) {
                this.eRU.a(mVar.mLiveInfo);
            }
            if (this.eRS != null) {
                this.eRS.a(mVar);
            }
            if (this.eSo != null) {
                this.eSz = this.eSo.m(mVar);
            }
            if (this.eSm != null) {
                this.eSm.a(mVar);
            }
            pT(mVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pT(int i) {
        if (!bjI().fam) {
            if (this.eSr < 0 && i == 0) {
                this.eSr = i;
            } else if (this.eSr != i) {
                if (i == 1) {
                    if (!this.eRV.qC(2)) {
                        String string = bjI().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bjI().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eRV.a(bjI().fah.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bjI().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eRV.qD(2);
                    this.eRV.qD(3);
                    if (bfk()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eRV.a(bjI().fah.getLiveContainerView(), string2, 3);
                    }
                }
                this.eSr = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (z) {
            bjF();
        }
        if (this.eRN != null) {
            this.eRN.brw();
        }
        if (this.eRG != null) {
            this.eRG.pK();
        }
        if (this.eRI != null) {
            this.eRI.onDestroy();
        }
        if (this.eRO != null) {
            this.eRO.onDestroy();
            this.eRO = null;
        }
        if (this.eRT != null) {
            View sk = this.eRT.sk();
            if (sk != null && sk.getParent() != null) {
                ((ViewGroup) sk.getParent()).removeView(sk);
            }
            this.eRT.onDestroy();
            this.eRT = null;
        }
        if (this.eRS != null) {
            this.eRS.a((j.a) null);
            this.eRS.vW();
        }
        if (this.eRE != null) {
            this.eRE.pK();
        }
        if (this.eRV != null) {
            this.eRV.pK();
        }
        this.eSr = -1;
        if (this.eRP != null) {
            this.eRP.pK();
            this.eRP.onDestroy();
        }
        if (this.eRJ != null) {
            this.eRJ.brt();
        }
        if (this.eRK != null) {
            this.eRK.big();
        }
        if (this.eRQ != null) {
            this.eRQ.sL();
        }
        if (this.eRW != null) {
            this.eRW.bmC();
        }
        if (this.eRX != null) {
            this.eRX.sL();
        }
        if (this.eRY != null) {
            this.eRY.onDestroy();
        }
        if (this.eSa != null) {
            this.eSa.onDestory();
        }
        if (this.eSd != null) {
            this.eSd.vL();
        }
        if (this.eSc != null) {
            this.eSc.vL();
        }
        if (this.eSl != null) {
            this.eSl.onDestroy();
        }
        if (this.eSg != null) {
            this.eSg.sL();
        }
        if (this.eSh != null) {
            this.eSh.sL();
        }
        if (this.eSj != null) {
            this.eSj.sL();
        }
        if (this.eRH != null) {
            this.eRH.onDestory();
        }
        if (this.eSo != null) {
            this.eSo.sL();
        }
        if (this.eSm != null) {
            this.eSm.vL();
        }
        if (this.eSi != null) {
            this.eSi.sL();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void bjF() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bjI().faj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bjI().faj.getChildAt(i);
            if (childAt != this.eSp && childAt != this.eSq) {
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
        if (this.eSp != null) {
            this.eSp.removeAllViews();
        }
        if (this.eSq != null) {
            this.eSq.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.m mVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(com.baidu.live.data.m mVar) {
        View wx;
        View sk;
        if (this.eRT != null && (sk = this.eRT.sk()) != null && sk.getParent() != null) {
            ((ViewGroup) sk.getParent()).removeView(sk);
        }
        if (this.eRS != null && (wx = this.eRS.wx()) != null && wx.getParent() != null) {
            ((ViewGroup) wx.getParent()).removeView(wx);
        }
        if (this.eRI != null) {
            this.eRI.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean yJ() {
        if (this.eRM == null || !this.eRM.bmy()) {
            if (this.eRI == null || !this.eRI.ah(bjI().fah.getLiveContainerView())) {
                if (this.eRL != null) {
                    this.eRL.bfU();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eRZ != null && this.eRZ.bmh()) {
                    this.eRZ.bmq();
                    return false;
                } else if (this.eRY == null || !this.eRY.bmB()) {
                    bjp();
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
    public void be(boolean z) {
        super.be(z);
        if (this.eSk != null) {
            this.eSk.destroy();
        }
        if (this.eRO != null) {
            this.eRO.onDestroy();
            this.eRO = null;
        }
        if (this.eRN != null) {
            this.eRN.brw();
        }
        if (this.eRT != null) {
            this.eRT.onDestroy();
            this.eRT = null;
        }
        if (this.eRU != null) {
            this.eRU.onDestroy();
            this.eRU = null;
        }
        if (this.eRV != null) {
            this.eRV.onDestroy();
        }
        if (this.eRE != null) {
            this.eRE.onDestroy();
        }
        if (this.eRG != null) {
            this.eRG.onDestroy();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
            this.eSe = null;
        }
        if (this.eRS != null) {
            this.eRS.a((j.a) null);
            this.eRS.release();
            this.eRS = null;
        }
        if (this.eRQ != null) {
            this.eRQ.release();
        }
        if (this.eRW != null) {
            this.eRW.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eRW.release();
        }
        if (this.eRX != null) {
            this.eRX.a(null);
            this.eRX.release();
        }
        if (this.eRY != null) {
            this.eRY.a((a.InterfaceC0461a) null);
            this.eRY.onDestroy();
        }
        if (this.eSc != null) {
            this.eSc.onDestroy();
        }
        if (this.eSd != null) {
            this.eSd.onDestroy();
        }
        if (this.eSa != null) {
            this.eSa.onDestory();
        }
        if (this.eSl != null) {
            this.eSl.onDestroy();
        }
        if (this.eSb != null) {
            this.eSb.release();
        }
        if (this.eSg != null) {
            this.eSg.release();
        }
        if (this.eSi != null) {
            this.eSi.release();
        }
        if (this.eSh != null) {
            this.eSh.release();
        }
        if (this.eSj != null) {
            this.eSj.release();
        }
        if (this.eRH != null) {
            this.eRH.onDestory();
        }
        if (this.eSo != null) {
            this.eSo.release();
        }
        if (this.eSm != null) {
            this.eSm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eSU);
        MessageManager.getInstance().unRegisterListener(this.eSK);
        MessageManager.getInstance().unRegisterListener(this.eSL);
        MessageManager.getInstance().unRegisterListener(this.eSN);
        MessageManager.getInstance().unRegisterListener(this.eSG);
        MessageManager.getInstance().unRegisterListener(this.eSH);
        MessageManager.getInstance().unRegisterListener(this.eSF);
        MessageManager.getInstance().unRegisterListener(this.eSJ);
        MessageManager.getInstance().unRegisterListener(this.eSI);
        MessageManager.getInstance().unRegisterListener(this.eSO);
        MessageManager.getInstance().unRegisterListener(this.evL);
        MessageManager.getInstance().unRegisterListener(this.eSP);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.eDV);
        MessageManager.getInstance().unRegisterListener(this.eDS);
        MessageManager.getInstance().unRegisterListener(this.atM);
        MessageManager.getInstance().unRegisterListener(this.eSQ);
        MessageManager.getInstance().unRegisterListener(this.eSR);
        MessageManager.getInstance().unRegisterListener(this.eSS);
        MessageManager.getInstance().unRegisterListener(this.eST);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.eRW != null) {
            this.eRW.js(false);
        }
        if (this.eRY != null) {
            this.eRY.js(false);
        }
        biQ();
        if (this.eSb != null) {
            this.eSb.pause();
        }
        if (this.eSg != null) {
            this.eSg.pause();
        }
        if (this.eSi != null) {
            this.eSi.pause();
        }
        if (this.eSe != null) {
            this.eSe.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.eSB = false;
        if (this.eSu && this.eSv != null) {
            a(this.eSv);
            this.eSu = false;
        }
        if (this.eRW != null) {
            this.eRW.js(true);
        }
        if (this.eRY != null) {
            this.eRY.js(true);
        }
        if (this.eSb != null) {
            this.eSb.resume();
        }
        if (this.eSg != null) {
            this.eSg.resume();
        }
        if (this.eSi != null) {
            this.eSi.resume();
        }
        if (this.eSe != null) {
            this.eSe.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjG() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bjG();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, -1, -1);
                    return;
                }
                return;
            }
            bjG();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bjG();
        } else if (i == 25034) {
            bjm();
        } else if (i == 25043) {
            if (i2 == -1) {
                bjJ();
            }
        } else if (i == 25050 && this.eSk != null) {
            if (i2 == -1) {
                this.eSk.ae(intent);
            } else {
                this.eSk.ae(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void d(boolean z, int i) {
        this.eSt = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjH() {
        return (bjI().fai.yO() == null || bjI().fai.yO().mLiveInfo == null || bjI().fai.yO().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eRI != null) {
                this.eRI.bg(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eRY != null) {
            this.eRY.azc();
        }
        if (this.eRH != null) {
            this.eRH.azc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eRD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bjI() {
        return this.eRD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjJ() {
        String vI = com.baidu.live.guardclub.g.vH().vI();
        if (!TextUtils.isEmpty(vI)) {
            try {
                J(-1, Integer.parseInt(vI), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                J(-1, -1, -1);
            }
        }
    }

    public boolean cc(int i) {
        if (7 == i) {
            if (this.eRT != null) {
                this.eRT.ay(true);
            }
            if (this.eRE != null) {
                this.eRE.bih();
            }
        } else if (1 == i) {
            if (biP() != null) {
                biP().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eSt) {
                return false;
            }
            if (this.eRI == null || !this.eRI.bmt()) {
                return this.eRE == null || this.eRE.bij();
            }
            return false;
        } else if (3 == i) {
            if (bjI().faj != null) {
                bjI().faj.setEnabled(false);
                if (this.awf != null) {
                    this.awf.e(!bjI().fak, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eRE == null || !this.eRE.isShowing();
        }
        return true;
    }

    public void pR(int i) {
        if ((i == 7 || i == 11) && this.eRE != null) {
            this.eRE.bih();
            this.eRE.iP(false);
        }
    }

    public void cd(int i) {
    }

    public void ce(int i) {
        if (7 == i) {
            if (this.eRT != null) {
                this.eRT.ay(false);
            }
            if (this.eRE != null) {
                this.eRE.iP(true);
            }
        } else if (11 == i) {
            if (this.eRE != null) {
                this.eRE.iP(true);
            }
        } else if (3 == i) {
            bjI().faj.setEnabled(true);
            if (this.awf != null) {
                this.awf.e(bjI().fak ? false : true, true);
            }
            if (this.eRO != null) {
                this.eRO.bj(true);
            }
        } else if (2 == i && this.eRN != null) {
            this.eRN.jR(true);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eRS != null) {
            this.eRS.setOtherParams(str);
        }
    }

    private boolean bfk() {
        return bjI().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
