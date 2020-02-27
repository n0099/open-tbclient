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
    public static boolean eSB;
    private com.baidu.tieba.ala.liveroom.data.a eRC;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eRD;
    protected com.baidu.live.h.a eRE;
    protected com.baidu.tieba.ala.liveroom.share.c eRF;
    protected com.baidu.tieba.ala.liveroom.o.b eRG;
    protected com.baidu.tieba.ala.liveroom.guide.c eRH;
    protected com.baidu.tieba.ala.liveroom.watermark.a eRI;
    protected com.baidu.tieba.ala.liveroom.b.b eRJ;
    protected com.baidu.tieba.ala.liveroom.praise.a eRK;
    protected com.baidu.tieba.ala.liveroom.guide.d eRL;
    protected com.baidu.tieba.ala.liveroom.u.a eRM;
    protected com.baidu.live.x.a eRN;
    private com.baidu.tieba.ala.liveroom.g.a eRO;
    private m eRP;
    i eRQ;
    j eRR;
    protected u eRS;
    protected s eRT;
    protected com.baidu.tieba.ala.liveroom.tippop.a eRU;
    private com.baidu.tieba.ala.liveroom.guideim.b eRV;
    protected com.baidu.live.view.input.c eRW;
    com.baidu.tieba.ala.liveroom.k.a eRX;
    protected com.baidu.tieba.ala.liveroom.guide.a eRY;
    private k eRZ;
    public boolean eSA;
    protected com.baidu.tieba.ala.liveroom.q.b eSC;
    protected e eSD;
    protected com.baidu.tieba.ala.liveroom.f.a eSa;
    protected h eSb;
    protected com.baidu.live.guardclub.j eSc;
    protected w eSd;
    protected com.baidu.tieba.ala.liveroom.turntable.e eSf;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eSg;
    protected com.baidu.tieba.ala.liveroom.n.c eSh;
    private v eSi;
    protected com.baidu.tieba.ala.liveroom.s.a eSj;
    protected com.baidu.tieba.ala.liveroom.g.e eSk;
    protected com.baidu.live.i.a eSl;
    protected aq eSm;
    protected com.baidu.live.q.a eSn;
    protected RelativeLayout eSo;
    protected RelativeLayout eSp;
    protected boolean eSr;
    protected x eSu;
    protected GuardClubInfoHttpResponseMessage eSv;
    boolean eSw;
    boolean eSx;
    boolean eSy;
    public boolean eSz;
    protected String otherParams;
    private int eSe = 0;
    private int eSq = -1;
    protected int mOrientation = 0;
    protected boolean eSs = false;
    protected boolean eSt = false;
    private CustomMessageListener eSE = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            if ((customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null) {
                b.this.a(rVar.Yw, rVar.Ys, rVar.Yt, rVar.Yu, rVar.Yv);
            }
        }
    };
    private CustomMessageListener eSF = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bjG().fah.yN().XQ.userId);
            com.baidu.live.view.a.Bh().a(valueOf, new com.baidu.live.data.b(b.this.bjG().fah.yN().XQ.portrait, valueOf, true, b.this.bjG().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eSG = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.m) && b.this.eRF != null) {
                b.this.eRF.c((com.baidu.live.data.m) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener atM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eRQ != null) {
                b.this.eRQ.h(com.baidu.live.gift.r.sx().sz());
            }
        }
    };
    private CustomMessageListener eSH = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eRC.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.yN(str);
            }
        }
    };
    private CustomMessageListener eSI = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bjG().pageContext.getPageActivity());
            }
            if (b.this.eRF != null) {
                b.this.eRF.c(b.this.bjG().fah.yN(), false);
            }
        }
    };
    private CustomMessageListener eSJ = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    b.this.eSt = true;
                    b.this.eSu = (x) data;
                    b.this.b(b.this.eSu);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eSK = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bjG().fah.yN().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bjG().fah.yN().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bjG().fah.yN().XQ.userId);
            if (b.this.eRG == null) {
                b.this.eRG = new com.baidu.tieba.ala.liveroom.o.b(b.this.bjG().pageContext);
            }
            b.this.eRG.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eRG.a(b.this.eSL);
        }
    };
    private b.a eSL = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void yY() {
            if (b.this.bjG().fah.yN() != null && b.this.bjG().fah.yN().Ye != null) {
                b.this.bjG().fah.yN().Ye.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eSM = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eSN = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pR(7);
        }
    };
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eSO = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eSw = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eRX != null) {
                b.this.eRX.sN();
            }
        }
    };
    HttpMessageListener eDU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).apX) != null && b.this.eRZ != null && b.this.bjG() != null && b.this.bjG().fah != null) {
                int[] iArr = new int[2];
                b.this.eSo.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.eRZ.a(b.this.eSo, layoutParams, aVar, b.this.bjG().fah.yN());
                com.baidu.live.l.a.ac(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener eDR = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bjG() != null && b.this.bjG().fah != null && b.this.bjG().fah.yN() != null && guardClubInfoHttpResponseMessage.apX != null) {
                    if (guardClubInfoHttpResponseMessage.apX.WZ == b.this.bjG().fah.yN().XQ.userId) {
                        b.this.eSv = guardClubInfoHttpResponseMessage;
                        if (b.this.eSv.aqa && com.baidu.live.guardclub.e.vG() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.vG().E(b.this.bjG().fah.yN().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eSP = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof au) {
                b.this.a((au) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSQ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.p(b.this.bjG().fah.yN());
        }
    };
    private CustomMessageListener eSR = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSl != null) {
                b.this.eSl.vO();
            }
        }
    };
    private CustomMessageListener eSS = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.eSd != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.eSd).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener eST = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bjk();
        }
    };
    private View.OnTouchListener eSU = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bju();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(x xVar);

    protected abstract void b(x xVar);

    protected abstract View biN();

    public abstract boolean biO();

    protected abstract boolean biP();

    protected abstract ViewGroup biQ();

    protected abstract ViewGroup biR();

    public abstract boolean bik();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(aq aqVar) {
        this.eSm = aqVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eSo = (RelativeLayout) bjG().fai.findViewById(a.g.ala_live_header_view);
        this.eSp = (RelativeLayout) bjG().fai.findViewById(a.g.ala_live_footer_view);
        tq();
        registerListener();
    }

    public void biW() {
    }

    private void tq() {
        if (this.eRF == null) {
            this.eRF = new com.baidu.tieba.ala.liveroom.share.c(bjG().pageContext);
        }
        this.eRM = new com.baidu.tieba.ala.liveroom.u.a(bjG().pageContext, this);
        this.eRJ = new com.baidu.tieba.ala.liveroom.b.b(bjG().pageContext, false);
        this.eRK = new com.baidu.tieba.ala.liveroom.praise.a(bjG().pageContext);
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
                this.eRL = new com.baidu.tieba.ala.liveroom.guide.d(bjG().pageContext);
            }
        }
        this.eRU = new com.baidu.tieba.ala.liveroom.tippop.a(bjG().pageContext, this);
        biX();
        biZ();
        bja();
        bjb();
        bje();
        bjf();
        bjg();
        bjh();
    }

    private void biX() {
        this.eRP = new m();
    }

    public void iU(boolean z) {
        this.eSr = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void biY() {
        com.baidu.live.data.m yN = bjG().fah.yN();
        boolean z = com.baidu.live.v.a.zj().awA.aaS;
        if (yN.mLiveInfo != null && yN.mLiveInfo.mAlaLiveSwitchData != null && yN.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = yN.Yo ? z : false;
        if (z2) {
            if (this.eRE == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bjG().pageContext);
                if (runTask != null) {
                    this.eRE = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eRE != null) {
                this.eRE.bV(1);
                View view = this.eRE.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bjG().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bjG().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eSo.addView(view, layoutParams);
                    if (z2) {
                        this.eRE.a(yN);
                    }
                }
            }
        }
    }

    private void biZ() {
        this.eRV = new com.baidu.tieba.ala.liveroom.guideim.b(bjG().pageContext);
        this.eRV.c(this.eSp, bik());
        this.eRV.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean ws() {
                return b.this.uX();
            }
        });
    }

    private void bja() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bjG().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eRW = (com.baidu.live.view.input.c) runTask.getData();
            this.eRW.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                @Override // com.baidu.live.view.input.c.a
                public void Bv() {
                    b.this.pR(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void Bw() {
                    b.this.ce(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean ws() {
                    return b.this.uX();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean xn() {
                    return b.this.bjd();
                }
            });
        }
    }

    private void bjb() {
        this.eRX = new com.baidu.tieba.ala.liveroom.k.a(this.eRC.pageContext);
        this.eRX.a(new a.InterfaceC0461a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public boolean bjI() {
                return b.this.biP();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public void onClose() {
                if (b.this.awe != null) {
                    b.this.awe.bb(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iV(boolean z) {
        if (this.eRV != null) {
            this.eRV.jt(z);
        }
        if (this.eRX != null) {
            this.eRX.jt(z);
        }
        eSB = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjc() {
        return eSB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjd() {
        com.baidu.live.data.m yN;
        if (bjG() == null || bjG().fah == null || (yN = bjG().fah.yN()) == null || yN.Ye == null) {
            return false;
        }
        String str = yN.Ye.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bje() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bjG().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eRZ = (k) runTask.getData();
            this.eRZ.setOtherParams(xx());
        }
    }

    private void bjf() {
        this.eSa = new com.baidu.tieba.ala.liveroom.f.a(bjG().pageContext);
    }

    private void bjg() {
        this.eSf = new com.baidu.tieba.ala.liveroom.turntable.e(bjG().pageContext.getPageActivity());
    }

    private void bjh() {
        this.eSh = new com.baidu.tieba.ala.liveroom.n.c(bjG().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eSJ);
        MessageManager.getInstance().registerListener(this.eSK);
        MessageManager.getInstance().registerListener(this.eSM);
        MessageManager.getInstance().registerListener(this.eSF);
        MessageManager.getInstance().registerListener(this.eSG);
        MessageManager.getInstance().registerListener(this.eSE);
        MessageManager.getInstance().registerListener(this.eSI);
        MessageManager.getInstance().registerListener(this.eSH);
        MessageManager.getInstance().registerListener(this.eSN);
        MessageManager.getInstance().registerListener(this.evK);
        MessageManager.getInstance().registerListener(this.eSO);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.eDU);
        MessageManager.getInstance().registerListener(this.eDR);
        MessageManager.getInstance().registerListener(this.atM);
        MessageManager.getInstance().registerListener(this.eSP);
        MessageManager.getInstance().registerListener(this.eSQ);
        MessageManager.getInstance().registerListener(this.eSR);
        MessageManager.getInstance().registerListener(this.eSS);
        MessageManager.getInstance().registerListener(this.eST);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uX() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bjG().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bjG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bjG().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zj().awA.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bjG().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bjG().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bjG().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bjG().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bji() {
        if (this.eRQ != null) {
            this.eRQ.wr().b(this.eRW.xe(), com.baidu.live.gift.r.sx().sz());
            iV(true);
            if (this.eSi == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, v.class, bjG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.eSi = (v) runTask.getData();
                } else {
                    return;
                }
            }
            this.eSi.sK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjj() {
        if (this.eRQ != null) {
            this.eRQ.wr().hide();
            iV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i, int i2, int i3) {
        if (bjG().fah.yN() != null && bjG().fah.yN().XQ != null && bjG().fah.yN().mLiveInfo != null) {
            a(bjG().fah.yN(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && uX()) {
            if (mVar == null) {
                mVar = bjG().fah.yN();
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
            if (mVar.mLiveInfo.live_type == 1 && mVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.zj().awA.Zz) {
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
            if (this.eSv != null && this.eSv.apX != null && this.eSv.apX.WZ == mVar.XQ.userId) {
                z5 = this.eSv.aqa;
            }
            g gVar = new g(bjG().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, sI, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
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
            if (!this.eSz) {
                this.eSA = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjk() {
        ce(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && uX()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(bjG().pageContext.getPageActivity(), auVar.adB, auVar.liveId, auVar.adC)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zj().awA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bjG().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zj().awA.aaT, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjl() {
        if (this.eRW != null) {
            this.eRW.c(this.eRC.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjm() {
        com.baidu.live.data.m yN = bjG().fah.yN();
        LogManager.getCommonLogger().doClickQuickImHiLog((yN == null || yN.mLiveInfo == null) ? "" : yN.mLiveInfo.feed_id, xx());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yO(String str) {
        if (this.eRW != null) {
            this.eRW.dx(str);
        }
    }

    private void bjn() {
        if ("home_rec_play".equals(bjG().fromType) || "frs_play".equals(bjG().fromType) || "frs_live_play".equals(bjG().fromType) || "person_play".equals(bjG().fromType) || "search".equals(bjG().fromType) || "person_attention".equals(bjG().fromType)) {
            com.baidu.live.b.pq().am(true);
        } else {
            com.baidu.live.b.pq().am(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iR(boolean z) {
        View sk;
        if (this.eRS == null) {
            f fVar = new f();
            fVar.afH = false;
            fVar.context = bjG().pageContext.getPageActivity();
            fVar.afP = z;
            fVar.fromType = bjG().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRS = (u) runTask.getData();
            }
        }
        if (this.eRS != null && (sk = this.eRS.sk()) != null && this.eRC.fai.indexOfChild(sk) < 0) {
            this.eRC.fai.addView(sk, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjo() {
        View sM;
        if (this.eSd == null) {
            z zVar = new z();
            zVar.afH = false;
            zVar.pageContext = bjG().pageContext;
            zVar.fromType = bjG().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSd = (w) runTask.getData();
            }
        }
        if (this.eSd != null && (sM = this.eSd.sM()) != null && bjG().fai.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bjG().fai.addView(sM, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjp() {
        View sC;
        if (this.eRT == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = false;
            aVar.context = bjG().pageContext.getPageActivity();
            aVar.fromType = bjG().fromType;
            aVar.afI = bjG().fam;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRT = (s) runTask.getData();
            }
        }
        if (this.eRT != null && (sC = this.eRT.sC()) != null && bjG().fai.indexOfChild(sC) < 0) {
            if (sC.getParent() instanceof ViewGroup) {
                ((ViewGroup) sC.getParent()).removeView(sC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bjG().fai.addView(sC, layoutParams);
        }
    }

    private void bjq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjr() {
        CustomResponsedMessage runTask;
        if (this.eRR == null && (runTask = MessageManager.getInstance().runTask(2913099, j.class, bjG().pageContext)) != null) {
            this.eRR = (j) runTask.getData();
        }
        if (this.eRR != null) {
            this.eRR.setOtherParams(this.otherParams);
            this.eRR.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.j.a
                public void wz() {
                    b.this.bju();
                }
            });
            this.eRR.a(bjG().fah.yN(), false);
            View wx = this.eRR.wx();
            if (wx != null && this.eSp.indexOfChild(wx) < 0) {
                Resources resources = bjG().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjG().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.eSp.addView(wx, layoutParams);
            }
        }
    }

    private void bjs() {
        if (this.eRO == null) {
            this.eRO = new com.baidu.tieba.ala.liveroom.g.a(bjG().pageContext);
        }
        if (this.eSu != null) {
            this.eRO.yS(this.eSu.user_id);
        }
        this.eRO.af(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iW(boolean z) {
        CustomResponsedMessage runTask;
        if (bjG() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bjG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSl = (com.baidu.live.i.a) runTask.getData();
            this.eSl.a(biR(), bjz());
            if (bjG().fah != null) {
                this.eSl.a(bjG().fah.yN());
            }
            this.eSl.setCanVisible(!z);
            this.eSl.aP(true);
            this.eSl.a(bjG().fah.bdW());
        }
    }

    private void bjt() {
        if (this.eSb == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bjG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSb = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bjG().fah.yN() != null && bjG().fah.yN().XQ != null && bjG().fah.yN().mLiveInfo != null) {
            this.eSb.setHost(false);
            this.eSb.setOtherParams(xx());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bjG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.eSb.a(this.eSo, layoutParams, bjG().fah.yN());
            this.eSb.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void vN() {
                    b.this.bjH();
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
                    if (this.awe != null) {
                        this.awe.bd(z);
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
                            bjG().fah.yN().Ye.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjG().fah.yN().Ye.isAdmin = 0;
                            bjG().fah.bpB();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bjG().fah.yN().Ye.isAdmin = 0;
                        bjG().fah.bpB();
                    }
                } else if ("task".equals(optString2)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eRU != null && !bjG().fal) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bjG().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bjG().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bjG().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bfi()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eRU.a(bjG().fag.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.awe != null) {
                                b.this.awe.bc(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bjG().fah.yN() != null && bjG().fah.yN().mLiveInfo != null) {
                        String str2 = bjG().fah.yN().mLiveInfo.feed_id;
                        long j4 = bjG().fah.yN().mLiveInfo.live_id;
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
                    if (bjG() != null && bjG().fah != null && bjG().fah.yN() != null && bjG().fah.yN().Ye != null && bjG().fah.yN().Ye.userId == jSONObject2.optLong("user_id")) {
                        bjG().fah.bpB();
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
            if (this.eRM != null) {
                this.eRM.v(aVar);
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
            if (bjG().fah == null || bjG().fah.yN() == null || bjG().fah.yN().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bjG().fah.yN().mLiveInfo.live_id;
                long j6 = bjG().fah.yN().mLiveInfo.group_id;
                long j7 = bjG().fah.yN().XQ.userId;
                str4 = bjG().fah.yN().mLiveInfo.appId;
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
                                if (com.baidu.live.v.d.zq().dY(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
            dVar.eZA = optLong4;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yK(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bju() {
        if (bjv()) {
            BdUtilHelper.hideSoftKeyPad(bjG().pageContext.getPageActivity(), bjG().fag.getLiveContainerView());
            biO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjv() {
        if (biN() == null || biN().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        bjG().fai.setOnTouchListener(this.eSU);
        bjA();
        bjB();
        bjq();
        bjs();
        bjt();
        if (this.eRP != null) {
            this.eRP.g(bjG().fah.yN());
        }
        if (this.eRV != null) {
            this.eRV.c(bjG().fah.yN(), xx());
        }
        if (this.eRW != null) {
            this.eRW.a(bjG().fah.yN(), xx());
        }
        if (this.eRX != null) {
            this.eRX.c(bjG().fah.yN(), xx());
        }
        if (bjG().fai != null) {
            bjG().fai.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bjv() && b.this.eRK != null) {
                        b.this.eRK.jK(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eRK != null) {
                        b.this.eRK.jK(true);
                    }
                    return false;
                }
            });
        }
        if (this.eSi == null && (runTask = MessageManager.getInstance().runTask(2913165, v.class, bjG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSi = (v) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjw() {
        if (this.eSk == null && this.eSm != null && this.eSm.adf && bjG() != null && bjG().fah != null && bjG().fah.yN() != null) {
            this.eSk = new com.baidu.tieba.ala.liveroom.g.e(bjG().pageContext, this.eSm);
            this.eSk.r(bjG().fah.yN());
            if (this.eSm.adi == 1) {
                if (this.eRQ != null) {
                    this.eSx = true;
                }
            } else if (this.eSm.adi == 2) {
                a(bjG().fah.yN(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjx() {
        CustomResponsedMessage runTask;
        if (bjG() != null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bjG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSn = (com.baidu.live.q.a) runTask.getData();
            this.eSn.a(biQ(), bjy());
            if (bjG().fah != null) {
                this.eSy = this.eSn.m(bjG().fah.yN());
            }
            this.eSn.setCanVisible(!this.eSs);
        }
    }

    private ViewGroup.LayoutParams bjy() {
        int dimensionPixelOffset;
        if (bik()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjG().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bjz() {
        int dimensionPixelOffset;
        if (bik()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjG().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iX(boolean z) {
        Rect rect = new Rect();
        bjG().fag.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bjG().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bjG().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bjG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bjG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bjA() {
        if (this.eRK != null) {
            this.eRK.al(bjG().fai);
        }
    }

    private void bjB() {
        if (this.eRN == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eRN = (com.baidu.live.x.a) runTask.getData();
            }
            bjC();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eRN != null) {
            if (this.eRH != null) {
                this.eRN.bj(this.eRH.bmr() ? false : true);
            } else {
                this.eRN.bj(true);
            }
            this.eRN.v(jSONObject);
        }
    }

    private void bjC() {
        if (this.eRN != null && bjG().fah.yN() != null && bjG().fah.yN().Yn != null) {
            if (this.eRH != null) {
                this.eRN.bj(this.eRH.bmr() ? false : true);
            } else {
                this.eRN.bj(true);
            }
            this.eRN.a(bjG().fah.yN().Yn);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.m mVar) {
        if (mVar != null) {
            bjC();
            if (this.eRO != null && mVar.XQ != null) {
                this.eRO.yS(String.valueOf(mVar.XQ.userId));
            }
            if (this.eRE != null) {
                this.eRE.a(mVar);
            }
            if (this.eRT != null && mVar.mLiveInfo != null) {
                this.eRT.a(mVar.mLiveInfo);
            }
            if (this.eRR != null) {
                this.eRR.a(mVar);
            }
            if (this.eSn != null) {
                this.eSy = this.eSn.m(mVar);
            }
            if (this.eSl != null) {
                this.eSl.a(mVar);
            }
            pT(mVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pT(int i) {
        if (!bjG().fal) {
            if (this.eSq < 0 && i == 0) {
                this.eSq = i;
            } else if (this.eSq != i) {
                if (i == 1) {
                    if (!this.eRU.qC(2)) {
                        String string = bjG().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bjG().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eRU.a(bjG().fag.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bjG().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eRU.qD(2);
                    this.eRU.qD(3);
                    if (bfi()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eRU.a(bjG().fag.getLiveContainerView(), string2, 3);
                    }
                }
                this.eSq = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (z) {
            bjD();
        }
        if (this.eRM != null) {
            this.eRM.bru();
        }
        if (this.eRF != null) {
            this.eRF.pK();
        }
        if (this.eRH != null) {
            this.eRH.onDestroy();
        }
        if (this.eRN != null) {
            this.eRN.onDestroy();
            this.eRN = null;
        }
        if (this.eRS != null) {
            View sk = this.eRS.sk();
            if (sk != null && sk.getParent() != null) {
                ((ViewGroup) sk.getParent()).removeView(sk);
            }
            this.eRS.onDestroy();
            this.eRS = null;
        }
        if (this.eRR != null) {
            this.eRR.a((j.a) null);
            this.eRR.vW();
        }
        if (this.eRD != null) {
            this.eRD.pK();
        }
        if (this.eRU != null) {
            this.eRU.pK();
        }
        this.eSq = -1;
        if (this.eRO != null) {
            this.eRO.pK();
            this.eRO.onDestroy();
        }
        if (this.eRI != null) {
            this.eRI.brr();
        }
        if (this.eRJ != null) {
            this.eRJ.bie();
        }
        if (this.eRP != null) {
            this.eRP.sL();
        }
        if (this.eRV != null) {
            this.eRV.bmA();
        }
        if (this.eRW != null) {
            this.eRW.sL();
        }
        if (this.eRX != null) {
            this.eRX.onDestroy();
        }
        if (this.eRZ != null) {
            this.eRZ.onDestory();
        }
        if (this.eSc != null) {
            this.eSc.vL();
        }
        if (this.eSb != null) {
            this.eSb.vL();
        }
        if (this.eSk != null) {
            this.eSk.onDestroy();
        }
        if (this.eSf != null) {
            this.eSf.sL();
        }
        if (this.eSg != null) {
            this.eSg.sL();
        }
        if (this.eSi != null) {
            this.eSi.sL();
        }
        if (this.eRG != null) {
            this.eRG.onDestory();
        }
        if (this.eSn != null) {
            this.eSn.sL();
        }
        if (this.eSl != null) {
            this.eSl.vL();
        }
        if (this.eSh != null) {
            this.eSh.sL();
        }
        if (this.eSd != null) {
            this.eSd.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void bjD() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bjG().fai.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bjG().fai.getChildAt(i);
            if (childAt != this.eSo && childAt != this.eSp) {
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
        if (this.eSo != null) {
            this.eSo.removeAllViews();
        }
        if (this.eSp != null) {
            this.eSp.removeAllViews();
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
        if (this.eRS != null && (sk = this.eRS.sk()) != null && sk.getParent() != null) {
            ((ViewGroup) sk.getParent()).removeView(sk);
        }
        if (this.eRR != null && (wx = this.eRR.wx()) != null && wx.getParent() != null) {
            ((ViewGroup) wx.getParent()).removeView(wx);
        }
        if (this.eRH != null) {
            this.eRH.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean yI() {
        if (this.eRL == null || !this.eRL.bmw()) {
            if (this.eRH == null || !this.eRH.ah(bjG().fag.getLiveContainerView())) {
                if (this.eRK != null) {
                    this.eRK.bfS();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eRY != null && this.eRY.bmf()) {
                    this.eRY.bmo();
                    return false;
                } else if (this.eRX == null || !this.eRX.bmz()) {
                    bjn();
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
        if (this.eSj != null) {
            this.eSj.destroy();
        }
        if (this.eRN != null) {
            this.eRN.onDestroy();
            this.eRN = null;
        }
        if (this.eRM != null) {
            this.eRM.bru();
        }
        if (this.eRS != null) {
            this.eRS.onDestroy();
            this.eRS = null;
        }
        if (this.eRT != null) {
            this.eRT.onDestroy();
            this.eRT = null;
        }
        if (this.eRU != null) {
            this.eRU.onDestroy();
        }
        if (this.eRD != null) {
            this.eRD.onDestroy();
        }
        if (this.eRF != null) {
            this.eRF.onDestroy();
        }
        if (this.eSd != null) {
            this.eSd.onDestroy();
            this.eSd = null;
        }
        if (this.eRR != null) {
            this.eRR.a((j.a) null);
            this.eRR.release();
            this.eRR = null;
        }
        if (this.eRP != null) {
            this.eRP.release();
        }
        if (this.eRV != null) {
            this.eRV.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eRV.release();
        }
        if (this.eRW != null) {
            this.eRW.a(null);
            this.eRW.release();
        }
        if (this.eRX != null) {
            this.eRX.a((a.InterfaceC0461a) null);
            this.eRX.onDestroy();
        }
        if (this.eSb != null) {
            this.eSb.onDestroy();
        }
        if (this.eSc != null) {
            this.eSc.onDestroy();
        }
        if (this.eRZ != null) {
            this.eRZ.onDestory();
        }
        if (this.eSk != null) {
            this.eSk.onDestroy();
        }
        if (this.eSa != null) {
            this.eSa.release();
        }
        if (this.eSf != null) {
            this.eSf.release();
        }
        if (this.eSh != null) {
            this.eSh.release();
        }
        if (this.eSg != null) {
            this.eSg.release();
        }
        if (this.eSi != null) {
            this.eSi.release();
        }
        if (this.eRG != null) {
            this.eRG.onDestory();
        }
        if (this.eSn != null) {
            this.eSn.release();
        }
        if (this.eSl != null) {
            this.eSl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eST);
        MessageManager.getInstance().unRegisterListener(this.eSJ);
        MessageManager.getInstance().unRegisterListener(this.eSK);
        MessageManager.getInstance().unRegisterListener(this.eSM);
        MessageManager.getInstance().unRegisterListener(this.eSF);
        MessageManager.getInstance().unRegisterListener(this.eSG);
        MessageManager.getInstance().unRegisterListener(this.eSE);
        MessageManager.getInstance().unRegisterListener(this.eSI);
        MessageManager.getInstance().unRegisterListener(this.eSH);
        MessageManager.getInstance().unRegisterListener(this.eSN);
        MessageManager.getInstance().unRegisterListener(this.evK);
        MessageManager.getInstance().unRegisterListener(this.eSO);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.eDU);
        MessageManager.getInstance().unRegisterListener(this.eDR);
        MessageManager.getInstance().unRegisterListener(this.atM);
        MessageManager.getInstance().unRegisterListener(this.eSP);
        MessageManager.getInstance().unRegisterListener(this.eSQ);
        MessageManager.getInstance().unRegisterListener(this.eSR);
        MessageManager.getInstance().unRegisterListener(this.eSS);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.eRV != null) {
            this.eRV.js(false);
        }
        if (this.eRX != null) {
            this.eRX.js(false);
        }
        biO();
        if (this.eSa != null) {
            this.eSa.pause();
        }
        if (this.eSf != null) {
            this.eSf.pause();
        }
        if (this.eSh != null) {
            this.eSh.pause();
        }
        if (this.eSd != null) {
            this.eSd.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.eSA = false;
        if (this.eSt && this.eSu != null) {
            a(this.eSu);
            this.eSt = false;
        }
        if (this.eRV != null) {
            this.eRV.js(true);
        }
        if (this.eRX != null) {
            this.eRX.js(true);
        }
        if (this.eSa != null) {
            this.eSa.resume();
        }
        if (this.eSf != null) {
            this.eSf.resume();
        }
        if (this.eSh != null) {
            this.eSh.resume();
        }
        if (this.eSd != null) {
            this.eSd.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjE() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bjE();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, -1, -1);
                    return;
                }
                return;
            }
            bjE();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bjE();
        } else if (i == 25034) {
            bjk();
        } else if (i == 25043) {
            if (i2 == -1) {
                bjH();
            }
        } else if (i == 25050 && this.eSj != null) {
            if (i2 == -1) {
                this.eSj.ae(intent);
            } else {
                this.eSj.ae(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void d(boolean z, int i) {
        this.eSs = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjF() {
        return (bjG().fah.yN() == null || bjG().fah.yN().mLiveInfo == null || bjG().fah.yN().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eRH != null) {
                this.eRH.bg(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eRX != null) {
            this.eRX.aza();
        }
        if (this.eRG != null) {
            this.eRG.aza();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eRC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bjG() {
        return this.eRC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
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
            if (this.eRS != null) {
                this.eRS.ay(true);
            }
            if (this.eRD != null) {
                this.eRD.bif();
            }
        } else if (1 == i) {
            if (biN() != null) {
                biN().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eSs) {
                return false;
            }
            if (this.eRH == null || !this.eRH.bmr()) {
                return this.eRD == null || this.eRD.bih();
            }
            return false;
        } else if (3 == i) {
            if (bjG().fai != null) {
                bjG().fai.setEnabled(false);
                if (this.awe != null) {
                    this.awe.e(!bjG().faj, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eRD == null || !this.eRD.isShowing();
        }
        return true;
    }

    public void pR(int i) {
        if ((i == 7 || i == 11) && this.eRD != null) {
            this.eRD.bif();
            this.eRD.iP(false);
        }
    }

    public void cd(int i) {
    }

    public void ce(int i) {
        if (7 == i) {
            if (this.eRS != null) {
                this.eRS.ay(false);
            }
            if (this.eRD != null) {
                this.eRD.iP(true);
            }
        } else if (11 == i) {
            if (this.eRD != null) {
                this.eRD.iP(true);
            }
        } else if (3 == i) {
            bjG().fai.setEnabled(true);
            if (this.awe != null) {
                this.awe.e(bjG().faj ? false : true, true);
            }
            if (this.eRN != null) {
                this.eRN.bj(true);
            }
        } else if (2 == i && this.eRM != null) {
            this.eRM.jR(true);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eRR != null) {
            this.eRR.setOtherParams(str);
        }
    }

    private boolean bfi() {
        return bjG().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
