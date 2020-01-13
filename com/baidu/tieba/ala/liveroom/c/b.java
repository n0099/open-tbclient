package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
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
import com.baidu.live.data.ag;
import com.baidu.live.data.as;
import com.baidu.live.data.l;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.l.b;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.o;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.l.a;
import com.baidu.tieba.ala.liveroom.m.a;
import com.baidu.tieba.ala.liveroom.t.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b implements com.baidu.tieba.ala.liveroom.b {
    public static boolean eOy;
    protected e eNA;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eNB;
    protected com.baidu.live.h.a eNC;
    protected com.baidu.tieba.ala.liveroom.share.c eND;
    protected com.baidu.tieba.ala.liveroom.q.b eNE;
    protected com.baidu.tieba.ala.liveroom.guide.c eNF;
    protected com.baidu.tieba.ala.liveroom.watermark.a eNG;
    protected com.baidu.tieba.ala.liveroom.b.b eNH;
    protected com.baidu.tieba.ala.liveroom.praise.a eNI;
    protected com.baidu.tieba.ala.liveroom.guide.d eNJ;
    protected com.baidu.tieba.ala.liveroom.x.a eNK;
    protected com.baidu.live.u.a eNL;
    private com.baidu.tieba.ala.liveroom.h.a eNM;
    private m eNN;
    i eNO;
    j eNP;
    protected t eNQ;
    protected r eNR;
    protected u eNS;
    protected com.baidu.tieba.ala.liveroom.tippop.a eNU;
    private com.baidu.tieba.ala.liveroom.guideim.b eNV;
    protected com.baidu.tieba.ala.liveroom.t.a eNW;
    com.baidu.tieba.ala.liveroom.m.a eNX;
    protected com.baidu.tieba.ala.liveroom.guide.a eNY;
    private f eNZ;
    private com.baidu.tieba.ala.liveroom.data.a eNz;
    protected com.baidu.tieba.ala.liveroom.i.e eOA;
    protected com.baidu.tieba.ala.liveroom.g.a eOa;
    protected com.baidu.tieba.ala.liveroom.l.a eOb;
    protected com.baidu.tieba.ala.liveroom.l.c eOc;
    protected com.baidu.tieba.ala.liveroom.turntable.e eOd;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eOe;
    protected com.baidu.tieba.ala.liveroom.p.c eOf;
    private com.baidu.live.gift.panel.a eOg;
    protected com.baidu.tieba.ala.liveroom.v.a eOh;
    protected com.baidu.tieba.ala.liveroom.h.e eOi;
    protected com.baidu.live.i.a eOj;
    protected com.baidu.tieba.ala.liveroom.data.j eOk;
    protected com.baidu.live.n.a eOl;
    protected RelativeLayout eOm;
    protected RelativeLayout eOn;
    protected boolean eOp;
    protected w eOs;
    protected GuardClubInfoHttpResponseMessage eOt;
    boolean eOu;
    boolean eOv;
    public boolean eOw;
    public boolean eOx;
    protected com.baidu.tieba.ala.liveroom.s.b eOz;
    protected String otherParams;
    private int eNT = 0;
    private int eOo = -1;
    protected int mOrientation = 0;
    protected boolean eOq = false;
    protected boolean eOr = false;
    protected Handler mHandler = new Handler();
    private CustomMessageListener eOB = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if ((customResponsedMessage.getData() instanceof q) && (qVar = (q) customResponsedMessage.getData()) != null) {
                b.this.a(qVar.WK, qVar.WG, qVar.WH, qVar.WI, qVar.WJ);
            }
        }
    };
    private CustomMessageListener eOC = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bhE().eWr.ww().Wf.userId);
            com.baidu.live.view.a.yR().a(valueOf, new com.baidu.live.data.b(b.this.bhE().eWr.ww().Wf.portrait, valueOf, true, b.this.bhE().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eOD = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof l) && b.this.eND != null) {
                b.this.eND.c((l) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener eOE = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eNO != null) {
                b.this.eNO.h(com.baidu.live.gift.q.rw().ry());
            }
        }
    };
    private CustomMessageListener eOF = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eNz.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.ys(str);
            }
        }
    };
    private CustomMessageListener eOG = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bhE().pageContext.getPageActivity());
            }
            if (b.this.eND != null) {
                b.this.eND.c(b.this.bhE().eWr.ww(), false);
            }
        }
    };
    private CustomMessageListener eOH = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof w) {
                    b.this.eOr = true;
                    b.this.eOs = (w) data;
                    b.this.b(b.this.eOs);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.e((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eOI = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bhE().eWr.ww().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bhE().eWr.ww().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bhE().eWr.ww().Wf.userId);
            if (b.this.eNE == null) {
                b.this.eNE = new com.baidu.tieba.ala.liveroom.q.b(b.this.bhE().pageContext);
            }
            b.this.eNE.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eNE.a(b.this.eOJ);
        }
    };
    private b.a eOJ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.l.b.a
        public void wH() {
            if (b.this.bhE().eWr.ww() != null && b.this.bhE().eWr.ww().Wt != null) {
                b.this.bhE().eWr.ww().Wt.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eOK = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eOL = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pJ(7);
        }
    };
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eOM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eOu = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eNX != null) {
                b.this.eNX.xe();
            }
        }
    };
    HttpMessageListener ezR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.guardclub.model.c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (cVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).ezN) != null && b.this.eNZ != null && b.this.bhE() != null && b.this.bhE().eWr != null) {
                b.this.eNZ.a(b.this.eOm, cVar, b.this.bhE().eWr.ww());
                com.baidu.live.k.a.U(cVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener ezQ = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bhE() != null && b.this.bhE().eWr != null && b.this.bhE().eWr.ww() != null && guardClubInfoHttpResponseMessage.ezN != null) {
                    if (guardClubInfoHttpResponseMessage.ezN.Vt == b.this.bhE().eWr.ww().Wf.userId) {
                        b.this.eOt = guardClubInfoHttpResponseMessage;
                        if (b.this.eOt != null && b.this.eOt.eAt) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.tieba.ala.guardclub.a.cJ(b.this.bhE().eWr.ww().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eON = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof as) {
                b.this.a((as) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eOO = new CustomMessageListener(2913148) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.k(b.this.bhE().eWr.ww());
        }
    };
    private CustomMessageListener eOP = new CustomMessageListener(2913149) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eOj != null) {
                b.this.eOj.uj();
            }
        }
    };
    private CustomMessageListener eOQ = new CustomMessageListener(2913155) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.eNS != null) {
                    ((com.baidu.tieba.ala.liveroom.p.b) b.this.eNS).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener eOR = new CustomMessageListener(2913159) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bhf();
        }
    };
    private View.OnTouchListener eOS = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bhp();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(w wVar);

    protected abstract void b(w wVar);

    protected abstract View bgF();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean bgG();

    protected abstract boolean bgH();

    protected abstract ViewGroup bgI();

    protected abstract ViewGroup bgJ();

    protected abstract boolean bgb();

    protected abstract void e(com.baidu.live.data.a aVar);

    public void a(com.baidu.tieba.ala.liveroom.data.j jVar) {
        this.eOk = jVar;
    }

    public void init() {
        this.eOm = (RelativeLayout) bhE().eWs.findViewById(a.g.ala_live_header_view);
        this.eOn = (RelativeLayout) bhE().eWs.findViewById(a.g.ala_live_footer_view);
        se();
        registerListener();
    }

    public void bgR() {
    }

    private void se() {
        if (this.eND == null) {
            this.eND = new com.baidu.tieba.ala.liveroom.share.c(bhE().pageContext);
        }
        this.eNK = new com.baidu.tieba.ala.liveroom.x.a(bhE().pageContext, this);
        this.eNH = new com.baidu.tieba.ala.liveroom.b.b(bhE().pageContext, false);
        this.eNI = new com.baidu.tieba.ala.liveroom.praise.a(bhE().pageContext);
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
                this.eNJ = new com.baidu.tieba.ala.liveroom.guide.d(bhE().pageContext);
            }
        }
        this.eNU = new com.baidu.tieba.ala.liveroom.tippop.a(bhE().pageContext, this);
        bgS();
        bgU();
        bgV();
        bgW();
        bgZ();
        bha();
        bhb();
        bhc();
    }

    private void bgS() {
        this.eNN = new m();
    }

    public void iO(boolean z) {
        this.eOp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgT() {
        l ww = bhE().eWr.ww();
        boolean z = com.baidu.live.s.a.wR().asq.Za;
        if (ww.mLiveInfo != null && ww.mLiveInfo.mAlaLiveSwitchData != null && ww.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = ww.WC ? z : false;
        if (z2) {
            if (this.eNC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913147, com.baidu.live.h.a.class, bhE().pageContext);
                if (runTask != null) {
                    this.eNC = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eNC != null) {
                this.eNC.bJ(1);
                View view = this.eNC.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bhE().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bhE().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eOm.addView(view, layoutParams);
                    if (z2) {
                        this.eNC.a(ww);
                    }
                }
            }
        }
    }

    private void bgU() {
        this.eNV = new com.baidu.tieba.ala.liveroom.guideim.b(bhE().pageContext);
        this.eNV.c(this.eOn, bgb());
        this.eNV.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean uO() {
                return b.this.tH();
            }
        });
    }

    private void bgV() {
        this.eNW = new com.baidu.tieba.ala.liveroom.t.a();
        this.eNW.a(new a.InterfaceC0456a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
            @Override // com.baidu.tieba.ala.liveroom.t.a.InterfaceC0456a
            public void bhG() {
                b.this.pJ(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.t.a.InterfaceC0456a
            public void bhH() {
                b.this.pt(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.t.a.InterfaceC0456a
            public boolean uO() {
                return b.this.tH();
            }

            @Override // com.baidu.tieba.ala.liveroom.t.a.InterfaceC0456a
            public boolean vX() {
                return b.this.bgY();
            }
        });
    }

    private void bgW() {
        this.eNX = new com.baidu.tieba.ala.liveroom.m.a(this.eNz.pageContext);
        this.eNX.a(new a.InterfaceC0452a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0452a
            public boolean bhI() {
                return b.this.bgH();
            }

            @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0452a
            public void onClose() {
                if (b.this.eNA != null) {
                    b.this.eNA.ja(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iP(boolean z) {
        if (this.eNV != null) {
            this.eNV.jr(z);
        }
        if (this.eNX != null) {
            this.eNX.jr(z);
        }
        eOy = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bgX() {
        return eOy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bgY() {
        l ww;
        if (bhE() == null || bhE().eWr == null || (ww = bhE().eWr.ww()) == null || ww.Wt == null) {
            return false;
        }
        String str = ww.Wt.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bgZ() {
        this.eNZ = new f(bhE().pageContext);
        this.eNZ.setOtherParams(vz());
    }

    private void bha() {
        this.eOa = new com.baidu.tieba.ala.liveroom.g.a(bhE().pageContext);
    }

    private void bhb() {
        this.eOd = new com.baidu.tieba.ala.liveroom.turntable.e(bhE().pageContext.getPageActivity());
    }

    private void bhc() {
        this.eOf = new com.baidu.tieba.ala.liveroom.p.c(bhE().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eOH);
        MessageManager.getInstance().registerListener(this.eOI);
        MessageManager.getInstance().registerListener(this.eOK);
        MessageManager.getInstance().registerListener(this.eOC);
        MessageManager.getInstance().registerListener(this.eOD);
        MessageManager.getInstance().registerListener(this.eOB);
        MessageManager.getInstance().registerListener(this.eOG);
        MessageManager.getInstance().registerListener(this.eOF);
        MessageManager.getInstance().registerListener(this.eOL);
        MessageManager.getInstance().registerListener(this.erA);
        MessageManager.getInstance().registerListener(this.eOM);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.ezR);
        MessageManager.getInstance().registerListener(this.ezQ);
        MessageManager.getInstance().registerListener(this.eOE);
        MessageManager.getInstance().registerListener(this.eON);
        MessageManager.getInstance().registerListener(this.eOO);
        MessageManager.getInstance().registerListener(this.eOP);
        MessageManager.getInstance().registerListener(this.eOQ);
        MessageManager.getInstance().registerListener(this.eOR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tH() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bhE().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bhE().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.s.a.wR().asq.Yz;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bhE().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bhE().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bhE().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bhE().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhd() {
        if (this.eNO != null) {
            this.eNO.uN().b(this.eNW.box(), com.baidu.live.gift.q.rw().ry());
            iP(true);
            if (this.eOg == null) {
                this.eOg = new com.baidu.live.gift.panel.a(bhE().pageContext.getPageActivity());
            }
            this.eOg.ty();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhe() {
        if (this.eNO != null) {
            this.eNO.uN().hide();
            iP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(int i, int i2, int i3) {
        if (bhE().eWr.ww() != null && bhE().eWr.ww().Wf != null && bhE().eWr.ww().mLiveInfo != null) {
            a(bhE().eWr.ww(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (tH()) {
            if (lVar == null) {
                lVar = bhE().eWr.ww();
            }
            String valueOf = String.valueOf(lVar.Wf.userId);
            String str = lVar.Wf.userName;
            String valueOf2 = String.valueOf(lVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(lVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(lVar.mLiveInfo.feed_id);
            int i6 = lVar.Wt.isBlock;
            String td = com.baidu.live.gift.b.b.ta().td();
            String str2 = lVar.mLiveInfo.appId;
            boolean z2 = lVar.Wt.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (lVar.mLiveInfo.live_type == 1 && lVar.mLiveInfo.screen_direction == 1 && com.baidu.live.s.a.wR().asq.XI) {
                z3 = true;
            }
            int i7 = -1;
            if (lVar.Wt == null) {
                z = false;
            } else {
                boolean z4 = lVar.Wt.isNewUser;
                i7 = lVar.Wt.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.eOt != null && this.eOt.ezN != null && this.eOt.ezN.Vt == lVar.Wf.userId) {
                z5 = this.eOt.eAt;
            }
            g gVar = new g(bhE().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, td, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (lVar != null && lVar.mLiveInfo != null && lVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.am(lVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.al(z);
            ag bdb = com.baidu.tieba.ala.guardclub.l.bcZ().bdb();
            if (bdb == null || bdb.aap <= 0) {
                i5 = 1000;
            } else {
                i5 = bdb.aap;
            }
            gVar.ba(i5);
            boolean z6 = false;
            if (lVar != null && lVar.Wt != null) {
                String str3 = lVar.Wt.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.an(z6);
            if (!this.eOw) {
                this.eOx = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhf() {
        pt(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(as asVar) {
        if (asVar != null && tH()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.q(bhE().pageContext.getPageActivity(), asVar.abw, asVar.liveId, asVar.abx)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null && com.baidu.live.s.a.wR().asq != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bhE().pageContext.getPageActivity(), String.valueOf(lVar.mLiveInfo.live_id), String.valueOf(lVar.mLiveInfo.user_id), com.baidu.live.s.a.wR().asq.Zb, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhg() {
        if (this.eNW != null) {
            this.eNW.d(this.eNz.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhh() {
        l ww = bhE().eWr.ww();
        LogManager.getCommonLogger().doClickQuickImHiLog((ww == null || ww.mLiveInfo == null) ? "" : ww.mLiveInfo.feed_id, vz());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yt(String str) {
        if (this.eNW != null) {
            this.eNW.dm(str);
        }
    }

    private void bhi() {
        if ("home_rec_play".equals(bhE().fromType) || "frs_play".equals(bhE().fromType) || "frs_live_play".equals(bhE().fromType) || "person_play".equals(bhE().fromType) || "search".equals(bhE().fromType) || "person_attention".equals(bhE().fromType)) {
            com.baidu.live.b.oI().aj(true);
        } else {
            com.baidu.live.b.oI().aj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iI(boolean z) {
        View rj;
        if (this.eNQ == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.adF = false;
            fVar.context = bhE().pageContext.getPageActivity();
            fVar.adM = z;
            fVar.fromType = bhE().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, t.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eNQ = (t) runTask.getData();
            }
        }
        if (this.eNQ != null && (rj = this.eNQ.rj()) != null && this.eNz.eWs.indexOfChild(rj) < 0) {
            this.eNz.eWs.addView(rj, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhj() {
        View rD;
        if (this.eNS == null) {
            v vVar = new v();
            vVar.adF = false;
            vVar.pageContext = bhE().pageContext;
            vVar.fromType = bhE().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913154, u.class, vVar);
            if (runTask != null && runTask.getData() != null) {
                this.eNS = (u) runTask.getData();
            }
        }
        if (this.eNS != null && (rD = this.eNS.rD()) != null && bhE().eWs.indexOfChild(rD) < 0) {
            if (rD.getParent() instanceof ViewGroup) {
                ((ViewGroup) rD.getParent()).removeView(rD);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bhE().eWs.addView(rD, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhk() {
        View rB;
        if (this.eNR == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.adF = false;
            aVar.context = bhE().pageContext.getPageActivity();
            aVar.fromType = bhE().fromType;
            aVar.adG = bhE().eWx;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, r.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eNR = (r) runTask.getData();
            }
        }
        if (this.eNR != null && (rB = this.eNR.rB()) != null && bhE().eWs.indexOfChild(rB) < 0) {
            if (rB.getParent() instanceof ViewGroup) {
                ((ViewGroup) rB.getParent()).removeView(rB);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bhE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bhE().eWs.addView(rB, layoutParams);
        }
    }

    private void bhl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhm() {
        if (this.eNP == null) {
            this.eNP = new com.baidu.tieba.ala.liveroom.e.a(bhE().pageContext);
        }
        this.eNP.setOtherParams(this.otherParams);
        this.eNP.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
            @Override // com.baidu.live.im.j.a
            public void uV() {
                b.this.bhp();
            }
        });
        this.eNP.a(bhE().eWr.ww(), false);
        View uT = this.eNP.uT();
        if (uT != null && this.eOn.indexOfChild(uT) < 0) {
            Resources resources = bhE().pageContext.getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bhE().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
            this.eOn.addView(uT, layoutParams);
        }
    }

    private void bhn() {
        if (this.eNM == null) {
            this.eNM = new com.baidu.tieba.ala.liveroom.h.a(bhE().pageContext);
        }
        if (this.eOs != null) {
            this.eNM.yy(this.eOs.user_id);
        }
        this.eNM.ad(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iQ(boolean z) {
        CustomResponsedMessage runTask;
        if (bhE() != null && (runTask = MessageManager.getInstance().runTask(2913144, com.baidu.live.i.a.class, bhE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eOj = (com.baidu.live.i.a) runTask.getData();
            this.eOj.a(bgJ(), bhu());
            if (bhE().eWr != null) {
                this.eOj.a(bhE().eWr.ww());
            }
            this.eOj.setCanVisible(!z);
            this.eOj.aM(true);
            this.eOj.a(bhE().eWr.bbH());
        }
    }

    private void bho() {
        if (this.eOb == null) {
            this.eOb = new com.baidu.tieba.ala.liveroom.l.a(bhE().pageContext, false, vz());
        }
        if (bhE().eWr.ww() != null && bhE().eWr.ww().Wf != null && bhE().eWr.ww().mLiveInfo != null) {
            this.eOb.c(this.eOm, bhE().eWr.ww());
            this.eOb.a(new a.InterfaceC0450a() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0450a
                public void bhJ() {
                    b.this.bhF();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x045e, code lost:
        yp(r25);
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
                    if (this.eNA != null) {
                        this.eNA.jc(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        pL(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bhE().eWr.ww().Wt.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bhE().eWr.ww().Wt.isAdmin = 0;
                            bhE().eWr.bnP();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bhE().eWr.ww().Wt.isAdmin = 0;
                        bhE().eWr.bnP();
                    }
                } else if ("task".equals(optString2)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eNU != null && !bhE().eWw) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bhE().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bhE().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bhE().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bcT()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eNU.a(bhE().eWt, str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.eNA != null) {
                                b.this.eNA.jb(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bhE().eWr.ww() != null && bhE().eWr.ww().mLiveInfo != null) {
                        String str2 = bhE().eWr.ww().mLiveInfo.feed_id;
                        long j4 = bhE().eWr.ww().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                            o.g(str2, j4);
                            com.baidu.live.utils.m.h(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.s.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bhE() != null && bhE().eWr != null && bhE().eWr.ww() != null && bhE().eWr.ww().Wt != null && bhE().eWr.ww().Wt.userId == jSONObject2.optLong("user_id")) {
                        bhE().eWr.bnP();
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str3 = optLong3 + "";
                        TbadkCoreApplication.getInst();
                        if (str3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155, officialNoticeData));
                        }
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.eNK != null) {
                this.eNK.u(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a vq = aVar.vq();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong4 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bhE().eWr == null || bhE().eWr.ww() == null || bhE().eWr.ww().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bhE().eWr.ww().mLiveInfo.live_id;
                long j6 = bhE().eWr.ww().mLiveInfo.group_id;
                long j7 = bhE().eWr.ww().Wf.userId;
                str4 = bhE().eWr.ww().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    s.b(optString9, vq.userId, vq.portrait, vq.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8);
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.s.d.wY().dJ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                s.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, vq.userId, vq.portrait, vq.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7);
                yp(optString3);
            }
            com.baidu.tieba.ala.liveroom.f.d dVar = new com.baidu.tieba.ala.liveroom.f.d();
            dVar.eVJ = optLong4;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yp(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bhp() {
        if (bhq()) {
            BdUtilHelper.hideSoftKeyPad(bhE().pageContext.getPageActivity(), bhE().eWt);
            bgG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhq() {
        if (bgF() == null || bgF().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xc() {
        bhE().eWs.setOnTouchListener(this.eOS);
        bhv();
        bhw();
        bhl();
        bhn();
        bho();
        if (this.eNN != null) {
            this.eNN.f(bhE().eWr.ww());
        }
        if (this.eNV != null) {
            this.eNV.a(bhE().eWr.ww(), vz());
        }
        if (this.eNW != null) {
            this.eNW.a(bhE().eWr.ww(), vz());
        }
        if (this.eNX != null) {
            this.eNX.a(bhE().eWr.ww(), vz());
        }
        if (bhE().eWs != null) {
            bhE().eWs.setOnDispatchTouchEventListener(new AlaLiveView.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bhq() && b.this.eNI != null) {
                        b.this.eNI.jI(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eNI != null) {
                        b.this.eNI.jI(true);
                    }
                    return false;
                }
            });
        }
        if (this.eOg == null) {
            this.eOg = new com.baidu.live.gift.panel.a(bhE().pageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhr() {
        if (this.eOi == null && this.eOk != null && this.eOk.eXg && bhE() != null && bhE().eWr != null && bhE().eWr.ww() != null) {
            this.eOi = new com.baidu.tieba.ala.liveroom.h.e(bhE().pageContext, this.eOk);
            this.eOi.m(bhE().eWr.ww());
            if (this.eOk.eXj == 1) {
                if (this.eNO != null) {
                    this.eOv = true;
                }
            } else if (this.eOk.eXj == 2) {
                a(bhE().eWr.ww(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhs() {
        CustomResponsedMessage runTask;
        if (bhE() != null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bhE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.n.a)) {
            this.eOl = (com.baidu.live.n.a) runTask.getData();
            this.eOl.a(bgI(), bht());
            if (bhE().eWr != null) {
                this.eOl.h(bhE().eWr.ww());
            }
            this.eOl.setCanVisible(!this.eOq);
        }
    }

    private ViewGroup.LayoutParams bht() {
        int dimensionPixelOffset;
        if (bgb()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bhE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bhE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bhu() {
        int dimensionPixelOffset;
        if (bgb()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bhE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bhE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iR(boolean z) {
        Rect rect = new Rect();
        bhE().eWt.getWindowVisibleDisplayFrame(rect);
        return ((ViewCommonUtil.getScreenFullSize(bhE().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bhE().pageContext.getPageActivity(), 48.0f) : 0)) + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + bhE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) + (z ? bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bhE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bhv() {
        if (this.eNI != null) {
            this.eNI.ak(bhE().eWs);
        }
    }

    private void bhw() {
        if (this.eNL == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.u.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eNL = (com.baidu.live.u.a) runTask.getData();
            }
            bhx();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eNL != null) {
            if (this.eNF != null) {
                this.eNL.bb(this.eNF.bkH() ? false : true);
            } else {
                this.eNL.bb(true);
            }
            this.eNL.v(jSONObject);
        }
    }

    private void bhx() {
        if (this.eNL != null && bhE().eWr.ww() != null && bhE().eWr.ww().WB != null) {
            if (this.eNF != null) {
                this.eNL.bb(this.eNF.bkH() ? false : true);
            } else {
                this.eNL.bb(true);
            }
            this.eNL.a(bhE().eWr.ww().WB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(l lVar) {
        if (lVar != null) {
            bhx();
            if (this.eNM != null && lVar.Wf != null) {
                this.eNM.yy(String.valueOf(lVar.Wf.userId));
            }
            if (this.eNC != null) {
                this.eNC.a(lVar);
            }
            if (this.eNR != null && lVar.mLiveInfo != null) {
                this.eNR.a(lVar.mLiveInfo);
            }
            if (this.eNP != null) {
                this.eNP.a(lVar);
            }
            if (this.eOl != null) {
                this.eOl.h(lVar);
            }
            if (this.eOj != null) {
                this.eOj.a(lVar);
            }
            pL(lVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pL(int i) {
        if (!bhE().eWw) {
            if (this.eOo < 0 && i == 0) {
                this.eOo = i;
            } else if (this.eOo != i) {
                if (i == 1) {
                    if (!this.eNU.qv(2)) {
                        String string = bhE().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bhE().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eNU.a(bhE().eWt, string, 2, true);
                        }
                    }
                } else {
                    String string2 = bhE().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eNU.qw(2);
                    this.eNU.qw(3);
                    if (bcT()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eNU.a(bhE().eWt, string2, 3);
                    }
                }
                this.eOo = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.live.data.g gVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iJ(boolean z) {
        if (z) {
            bhy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eNK != null) {
            this.eNK.bpQ();
        }
        if (this.eND != null) {
            this.eND.oZ();
        }
        if (this.eNF != null) {
            this.eNF.onDestroy();
        }
        if (this.eNL != null) {
            this.eNL.onDestroy();
            this.eNL = null;
        }
        if (this.eNQ != null) {
            View rj = this.eNQ.rj();
            if (rj != null && rj.getParent() != null) {
                ((ViewGroup) rj.getParent()).removeView(rj);
            }
            this.eNQ.onDestroy();
            this.eNQ = null;
        }
        if (this.eNP != null) {
            this.eNP.a((j.a) null);
            this.eNP.us();
        }
        if (this.eNB != null) {
            this.eNB.oZ();
        }
        if (this.eNU != null) {
            this.eNU.oZ();
        }
        this.eOo = -1;
        if (this.eNM != null) {
            this.eNM.oZ();
            this.eNM.onDestroy();
        }
        if (this.eNG != null) {
            this.eNG.bpK();
        }
        if (this.eNH != null) {
            this.eNH.bfV();
        }
        if (this.eNN != null) {
            this.eNN.tz();
        }
        if (this.eNV != null) {
            this.eNV.bkQ();
        }
        if (this.eNW != null) {
            this.eNW.uk();
        }
        if (this.eNX != null) {
            this.eNX.onDestroy();
        }
        if (this.eNZ != null) {
            this.eNZ.onDestory();
        }
        if (this.eOc != null) {
            this.eOc.onDestroy();
        }
        if (this.eOb != null) {
            this.eOb.uk();
        }
        if (this.eOi != null) {
            this.eOi.onDestroy();
        }
        if (this.eOd != null) {
            this.eOd.tz();
        }
        if (this.eOf != null) {
            this.eOf.tz();
        }
        if (this.eNS != null) {
            this.eNS.onDestroy();
        }
        ShowUtil.windowCount = 0;
        if (this.eOe != null) {
            this.eOe.tz();
        }
        if (this.eOg != null) {
            this.eOg.tz();
        }
        if (this.eNE != null) {
            this.eNE.onDestory();
        }
        if (this.eOl != null) {
            this.eOl.tz();
        }
        if (this.eOj != null) {
            this.eOj.uk();
        }
    }

    private void bhy() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bhE().eWs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bhE().eWs.getChildAt(i);
            if (childAt != this.eOm && childAt != this.eOn) {
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
        if (this.eOm != null) {
            this.eOm.removeAllViews();
        }
        if (this.eOn != null) {
            this.eOn.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgD() {
        View uT;
        View rj;
        if (this.eNQ != null && (rj = this.eNQ.rj()) != null && rj.getParent() != null) {
            ((ViewGroup) rj.getParent()).removeView(rj);
        }
        if (this.eNP != null && (uT = this.eNP.uT()) != null && uT.getParent() != null) {
            ((ViewGroup) uT.getParent()).removeView(uT);
        }
        if (this.eNF != null) {
            this.eNF.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhz() {
        if (this.eNJ == null || !this.eNJ.bkM()) {
            if (this.eNF == null || !this.eNF.ag(bhE().eWt)) {
                if (this.eNI != null) {
                    this.eNI.bdI();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eNY != null && this.eNY.bkv()) {
                    this.eNY.bkE();
                    return false;
                } else if (this.eNX == null || !this.eNX.bkP()) {
                    bhi();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iK(boolean z) {
        if (this.eOh != null) {
            this.eOh.destroy();
        }
        if (this.eNL != null) {
            this.eNL.onDestroy();
            this.eNL = null;
        }
        if (this.eNK != null) {
            this.eNK.bpQ();
        }
        if (this.eNQ != null) {
            this.eNQ.onDestroy();
            this.eNQ = null;
        }
        if (this.eNR != null) {
            this.eNR.onDestroy();
            this.eNR = null;
        }
        if (this.eNS != null) {
            this.eNS.onDestroy();
            this.eNS = null;
        }
        if (this.eNU != null) {
            this.eNU.onDestroy();
        }
        if (this.eNB != null) {
            this.eNB.onDestroy();
        }
        if (this.eND != null) {
            this.eND.onDestroy();
        }
        if (this.eNP != null) {
            this.eNP.a((j.a) null);
            this.eNP.release();
            this.eNP = null;
        }
        if (this.eNN != null) {
            this.eNN.release();
        }
        if (this.eNV != null) {
            this.eNV.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eNV.release();
        }
        if (this.eNW != null) {
            this.eNW.a((a.InterfaceC0456a) null);
            this.eNW.release();
        }
        if (this.eNX != null) {
            this.eNX.a((a.InterfaceC0452a) null);
            this.eNX.onDestroy();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.eOb != null) {
            this.eOb.onDestroy();
        }
        if (this.eOc != null) {
            this.eOc.onDestroy();
        }
        if (this.eNZ != null) {
            this.eNZ.onDestory();
        }
        if (this.eOi != null) {
            this.eOi.onDestroy();
        }
        if (this.eOa != null) {
            this.eOa.release();
        }
        if (this.eOd != null) {
            this.eOd.release();
        }
        if (this.eOf != null) {
            this.eOf.release();
        }
        if (this.eOe != null) {
            this.eOe.release();
        }
        if (this.eOg != null) {
            this.eOg.release();
        }
        if (this.eNE != null) {
            this.eNE.onDestory();
        }
        if (this.eOl != null) {
            this.eOl.release();
        }
        if (this.eOj != null) {
            this.eOj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eOR);
        MessageManager.getInstance().unRegisterListener(this.eOH);
        MessageManager.getInstance().unRegisterListener(this.eOI);
        MessageManager.getInstance().unRegisterListener(this.eOK);
        MessageManager.getInstance().unRegisterListener(this.eOC);
        MessageManager.getInstance().unRegisterListener(this.eOD);
        MessageManager.getInstance().unRegisterListener(this.eOB);
        MessageManager.getInstance().unRegisterListener(this.eOG);
        MessageManager.getInstance().unRegisterListener(this.eOF);
        MessageManager.getInstance().unRegisterListener(this.eOL);
        MessageManager.getInstance().unRegisterListener(this.erA);
        MessageManager.getInstance().unRegisterListener(this.eOM);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.ezR);
        MessageManager.getInstance().unRegisterListener(this.ezQ);
        MessageManager.getInstance().unRegisterListener(this.eOE);
        MessageManager.getInstance().unRegisterListener(this.eON);
        MessageManager.getInstance().unRegisterListener(this.eOO);
        MessageManager.getInstance().unRegisterListener(this.eOP);
        MessageManager.getInstance().unRegisterListener(this.eOQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhA() {
        if (this.eNV != null) {
            this.eNV.jq(false);
        }
        if (this.eNX != null) {
            this.eNX.jq(false);
        }
        bgG();
        if (this.eOa != null) {
            this.eOa.pause();
        }
        if (this.eOd != null) {
            this.eOd.pause();
        }
        if (this.eOf != null) {
            this.eOf.pause();
        }
        if (this.eNS != null) {
            this.eNS.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhB() {
        this.eOx = false;
        if (this.eOr && this.eOs != null) {
            a(this.eOs);
            this.eOr = false;
        }
        if (this.eNV != null) {
            this.eNV.jq(true);
        }
        if (this.eNX != null) {
            this.eNX.jq(true);
        }
        if (this.eOa != null) {
            this.eOa.resume();
        }
        if (this.eOd != null) {
            this.eOd.resume();
        }
        if (this.eOf != null) {
            this.eOf.resume();
        }
        if (this.eNS != null) {
            this.eNS.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bhC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bhC();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    I(-1, -1, -1);
                    return;
                }
                return;
            }
            bhC();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    I(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bhC();
        } else if (i == 25043) {
            if (i2 == -1) {
                bhF();
            }
        } else if (i == 25050) {
            if (this.eOh != null) {
                if (i2 == -1) {
                    this.eOh.ae(intent);
                } else {
                    this.eOh.ae(null);
                }
            }
        } else if (i == 25051 && i2 == -1 && this.eOA != null) {
            this.eOA.bkg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        this.eOq = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bhD() {
        return (bhE().eWr.ww() == null || bhE().eWr.ww().mLiveInfo == null || bhE().eWr.ww().mLiveInfo.live_type != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eNF != null) {
                this.eNF.bg(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eNX != null) {
            this.eNX.awN();
        }
        if (this.eNE != null) {
            this.eNE.awN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.eNA = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eNz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bhE() {
        return this.eNz;
    }

    public void bd(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhF() {
        String bda = com.baidu.tieba.ala.guardclub.l.bcZ().bda();
        if (!TextUtils.isEmpty(bda)) {
            try {
                I(-1, Integer.parseInt(bda), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                I(-1, -1, -1);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public boolean pr(int i) {
        if (7 == i) {
            if (this.eNQ != null) {
                this.eNQ.av(true);
            }
            if (this.eNB != null) {
                this.eNB.bfW();
            }
        } else if (1 == i) {
            if (bgF() != null) {
                bgF().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eOq) {
                return false;
            }
            if (this.eNF == null || !this.eNF.bkH()) {
                return this.eNB == null || this.eNB.bfY();
            }
            return false;
        } else if (3 == i) {
            if (bhE().eWs != null) {
                bhE().eWs.setEnabled(false);
                if (this.eNA != null) {
                    this.eNA.z(!bhE().eWu, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eNB == null || !this.eNB.isShowing();
        }
        return true;
    }

    public void pJ(int i) {
        if ((i == 7 || i == 11) && this.eNB != null) {
            this.eNB.bfW();
            this.eNB.iG(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void ps(int i) {
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void pt(int i) {
        if (7 == i) {
            if (this.eNQ != null) {
                this.eNQ.av(false);
            }
            if (this.eNB != null) {
                this.eNB.iG(true);
            }
        } else if (11 == i) {
            if (this.eNB != null) {
                this.eNB.iG(true);
            }
        } else if (3 == i) {
            bhE().eWs.setEnabled(true);
            if (this.eNA != null) {
                this.eNA.z(bhE().eWu ? false : true, true);
            }
            if (this.eNL != null) {
                this.eNL.bb(true);
            }
        } else if (2 == i && this.eNK != null) {
            this.eNK.jP(true);
        }
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eNP != null) {
            this.eNP.setOtherParams(str);
        }
    }

    private boolean bcT() {
        return bhE().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
