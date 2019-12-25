package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.g;
import com.baidu.live.c.p;
import com.baidu.live.data.ac;
import com.baidu.live.data.ao;
import com.baidu.live.data.k;
import com.baidu.live.data.o;
import com.baidu.live.data.u;
import com.baidu.live.gift.q;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.k.b;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
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
import com.baidu.live.utils.n;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.l;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.data.i;
import com.baidu.tieba.ala.liveroom.j.a;
import com.baidu.tieba.ala.liveroom.k.a;
import com.baidu.tieba.ala.liveroom.q.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b implements com.baidu.tieba.ala.liveroom.b {
    public static boolean eNf;
    public static boolean eNg;
    public static boolean eNh;
    protected t eMA;
    protected r eMB;
    protected com.baidu.tieba.ala.liveroom.tippop.a eMC;
    private com.baidu.tieba.ala.liveroom.guideim.b eMD;
    protected com.baidu.tieba.ala.liveroom.q.a eME;
    com.baidu.tieba.ala.liveroom.k.a eMF;
    protected com.baidu.tieba.ala.liveroom.guide.a eMG;
    private f eMH;
    protected com.baidu.tieba.ala.liveroom.f.a eMI;
    protected com.baidu.tieba.ala.liveroom.j.a eMJ;
    protected com.baidu.tieba.ala.liveroom.j.c eMK;
    protected com.baidu.tieba.ala.liveroom.turntable.e eML;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eMM;
    private com.baidu.live.gift.panel.a eMN;
    protected com.baidu.tieba.ala.liveroom.s.a eMO;
    protected com.baidu.tieba.ala.liveroom.g.e eMP;
    protected com.baidu.live.h.a eMQ;
    protected i eMR;
    protected com.baidu.live.m.a eMS;
    protected RelativeLayout eMT;
    protected RelativeLayout eMU;
    protected boolean eMW;
    protected u eMZ;
    private com.baidu.tieba.ala.liveroom.data.a eMj;
    protected e eMk;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eMl;
    protected com.baidu.live.g.a eMm;
    protected com.baidu.tieba.ala.liveroom.share.c eMn;
    protected com.baidu.tieba.ala.liveroom.n.b eMo;
    protected com.baidu.tieba.ala.liveroom.guide.c eMp;
    protected com.baidu.tieba.ala.liveroom.watermark.a eMq;
    protected com.baidu.tieba.ala.liveroom.b.b eMr;
    protected com.baidu.tieba.ala.liveroom.praise.a eMs;
    protected com.baidu.tieba.ala.liveroom.guide.d eMt;
    protected com.baidu.tieba.ala.liveroom.u.a eMu;
    protected com.baidu.live.s.a eMv;
    private com.baidu.tieba.ala.liveroom.g.a eMw;
    private m eMx;
    com.baidu.live.im.i eMy;
    j eMz;
    protected GuardClubInfoHttpResponseMessage eNa;
    boolean eNb;
    boolean eNc;
    public boolean eNd;
    public boolean eNe;
    protected com.baidu.tieba.ala.liveroom.p.b eNi;
    protected String otherParams;
    private int eMV = -1;
    protected int mOrientation = 0;
    protected boolean eMX = false;
    protected boolean eMY = false;
    protected Handler mHandler = new Handler();
    private CustomMessageListener eNj = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if ((customResponsedMessage.getData() instanceof o) && (oVar = (o) customResponsedMessage.getData()) != null) {
                b.this.a(oVar.Wr, oVar.Wn, oVar.Wo, oVar.Wp, oVar.Wq);
            }
        }
    };
    private CustomMessageListener eNk = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bgX().eUF.wf().VP.userId);
            com.baidu.live.view.a.yy().a(valueOf, new com.baidu.live.data.b(b.this.bgX().eUF.wf().VP.portrait, valueOf, true, b.this.bgX().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eNl = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof k) && b.this.eMn != null) {
                b.this.eMn.c((k) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener eNm = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eMy != null) {
                b.this.eMy.h(q.rk().rm());
            }
        }
    };
    private CustomMessageListener eNn = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eMj.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.yn(str);
            }
        }
    };
    private CustomMessageListener eNo = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bgX().pageContext.getPageActivity());
            }
            if (b.this.eMn != null) {
                b.this.eMn.c(b.this.bgX().eUF.wf(), false);
            }
        }
    };
    private CustomMessageListener eNp = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof u) {
                    b.this.eMY = true;
                    b.this.eMZ = (u) data;
                    b.this.b(b.this.eMZ);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.e((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eNq = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bgX().eUF.wf().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bgX().eUF.wf().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bgX().eUF.wf().VP.userId);
            if (b.this.eMo == null) {
                b.this.eMo = new com.baidu.tieba.ala.liveroom.n.b(b.this.bgX().pageContext);
            }
            b.this.eMo.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eMo.a(b.this.eNr);
        }
    };
    private b.a eNr = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        @Override // com.baidu.live.k.b.a
        public void wq() {
            if (b.this.bgX().eUF.wf() != null && b.this.bgX().eUF.wf().Wc != null) {
                b.this.bgX().eUF.wf().Wc.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eNs = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eNt = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pI(7);
        }
    };
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eNu = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eNb = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eMF != null) {
                b.this.eMF.wN();
            }
        }
    };
    HttpMessageListener eyG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.guardclub.model.c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (cVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).eyC) != null && b.this.eMH != null && b.this.bgX() != null && b.this.bgX().eUF != null) {
                b.this.eMH.a(b.this.eMT, cVar, b.this.bgX().eUF.wf());
                com.baidu.live.j.a.V(cVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener eyF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bgX() != null && b.this.bgX().eUF != null && b.this.bgX().eUF.wf() != null && guardClubInfoHttpResponseMessage.eyC != null) {
                    if (guardClubInfoHttpResponseMessage.eyC.Vc == b.this.bgX().eUF.wf().VP.userId) {
                        b.this.eNa = guardClubInfoHttpResponseMessage;
                        if (b.this.eNa != null && b.this.eNa.ezi) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.tieba.ala.guardclub.a.cE(b.this.bgX().eUF.wf().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ao) {
                b.this.a((ao) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eNw = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.i(b.this.bgX().eUF.wf());
        }
    };
    private CustomMessageListener eNx = new CustomMessageListener(2913148) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eMQ != null) {
                b.this.eMQ.tS();
            }
        }
    };
    private View.OnTouchListener eNy = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bgI();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(u uVar);

    protected abstract void b(u uVar);

    protected abstract boolean bfB();

    protected abstract View bgd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean bge();

    protected abstract boolean bgf();

    protected abstract ViewGroup bgg();

    protected abstract ViewGroup bgh();

    protected abstract void e(com.baidu.live.data.a aVar);

    public void a(i iVar) {
        this.eMR = iVar;
    }

    public void init() {
        this.eMT = (RelativeLayout) bgX().eUG.findViewById(a.g.ala_live_header_view);
        this.eMU = (RelativeLayout) bgX().eUG.findViewById(a.g.ala_live_footer_view);
        rO();
        registerListener();
    }

    public void bgn() {
    }

    private void rO() {
        if (this.eMn == null) {
            this.eMn = new com.baidu.tieba.ala.liveroom.share.c(bgX().pageContext);
        }
        this.eMu = new com.baidu.tieba.ala.liveroom.u.a(bgX().pageContext, this);
        this.eMr = new com.baidu.tieba.ala.liveroom.b.b(bgX().pageContext, false);
        this.eMs = new com.baidu.tieba.ala.liveroom.praise.a(bgX().pageContext);
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
                this.eMt = new com.baidu.tieba.ala.liveroom.guide.d(bgX().pageContext);
            }
        }
        this.eMC = new com.baidu.tieba.ala.liveroom.tippop.a(bgX().pageContext, this);
        bgo();
        bgq();
        bgr();
        bgs();
        bgu();
        bgv();
        bgw();
    }

    private void bgo() {
        this.eMx = new m();
    }

    public void iE(boolean z) {
        this.eMW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgp() {
        k wf = bgX().eUF.wf();
        boolean z = com.baidu.live.r.a.wA().arE.YO;
        if (wf.mLiveInfo != null && wf.mLiveInfo.mAlaLiveSwitchData != null && wf.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = wf.Wl ? z : false;
        if (z2) {
            if (this.eMm == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913146, com.baidu.live.g.a.class, bgX().pageContext);
                if (runTask != null) {
                    this.eMm = (com.baidu.live.g.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eMm != null) {
                this.eMm.bJ(1);
                View view = this.eMm.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bgX().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bgX().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eMT.addView(view, layoutParams);
                    if (z2) {
                        this.eMm.a(wf);
                    }
                }
            }
        }
    }

    private void bgq() {
        this.eMD = new com.baidu.tieba.ala.liveroom.guideim.b(bgX().pageContext);
        this.eMD.c(this.eMU, bfB());
        this.eMD.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.13
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean ux() {
                return b.this.tq();
            }
        });
    }

    private void bgr() {
        this.eME = new com.baidu.tieba.ala.liveroom.q.a();
        this.eME.a(new a.InterfaceC0452a() { // from class: com.baidu.tieba.ala.liveroom.c.b.14
            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0452a
            public void bgZ() {
                b.this.pI(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0452a
            public void bha() {
                b.this.ps(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0452a
            public boolean ux() {
                return b.this.tq();
            }

            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0452a
            public boolean vG() {
                return b.this.bgt();
            }
        });
    }

    private void bgs() {
        this.eMF = new com.baidu.tieba.ala.liveroom.k.a(this.eMj.pageContext);
        this.eMF.a(new a.InterfaceC0447a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0447a
            public boolean bhb() {
                return b.this.bgf();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0447a
            public void onClose() {
                if (b.this.eMk != null) {
                    b.this.eMk.iR(false);
                }
            }
        });
    }

    void iF(boolean z) {
        if (this.eMD != null) {
            this.eMD.jg(z);
        }
        if (this.eMF != null) {
            this.eMF.jg(z);
        }
        eNf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iG(boolean z) {
        if (this.eMD != null) {
            this.eMD.jg(z);
        }
        if (this.eMF != null) {
            this.eMF.jg(z);
        }
        eNg = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iH(boolean z) {
        if (this.eMD != null) {
            this.eMD.jg(z);
        }
        if (this.eMF != null) {
            this.eMF.jg(z);
        }
        eNh = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iI(boolean z) {
        if (this.eMD != null) {
            this.eMD.jg(z);
        }
        if (this.eMF != null) {
            this.eMF.jg(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bgt() {
        k wf;
        if (bgX() == null || bgX().eUF == null || (wf = bgX().eUF.wf()) == null || wf.Wc == null) {
            return false;
        }
        String str = wf.Wc.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bgu() {
        this.eMH = new f(bgX().pageContext);
        this.eMH.setOtherParams(vi());
    }

    private void bgv() {
        this.eMI = new com.baidu.tieba.ala.liveroom.f.a(bgX().pageContext);
    }

    private void bgw() {
        this.eML = new com.baidu.tieba.ala.liveroom.turntable.e(bgX().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eNp);
        MessageManager.getInstance().registerListener(this.eNq);
        MessageManager.getInstance().registerListener(this.eNs);
        MessageManager.getInstance().registerListener(this.eNk);
        MessageManager.getInstance().registerListener(this.eNl);
        MessageManager.getInstance().registerListener(this.eNj);
        MessageManager.getInstance().registerListener(this.eNo);
        MessageManager.getInstance().registerListener(this.eNn);
        MessageManager.getInstance().registerListener(this.eNt);
        MessageManager.getInstance().registerListener(this.eqn);
        MessageManager.getInstance().registerListener(this.eNu);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.eyG);
        MessageManager.getInstance().registerListener(this.eyF);
        MessageManager.getInstance().registerListener(this.eNm);
        MessageManager.getInstance().registerListener(this.eNv);
        MessageManager.getInstance().registerListener(this.eNw);
        MessageManager.getInstance().registerListener(this.eNx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tq() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bgX().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bgX().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bgX().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.r.a.wA().arE.Yn;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bgX().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bgX().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bgX().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bgX().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgx() {
        if (this.eMy != null) {
            this.eMy.uw().b(this.eME.bnx(), q.rk().rm());
            iF(true);
            if (this.eMN == null) {
                this.eMN = new com.baidu.live.gift.panel.a(bgX().pageContext.getPageActivity());
            }
            this.eMN.tg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgy() {
        if (this.eMy != null) {
            this.eMy.uw().hide();
            iF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(int i, int i2, int i3) {
        if (bgX().eUF.wf() != null && bgX().eUF.wf().VP != null && bgX().eUF.wf().mLiveInfo != null) {
            a(bgX().eUF.wf(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (tq()) {
            if (kVar == null) {
                kVar = bgX().eUF.wf();
            }
            String valueOf = String.valueOf(kVar.VP.userId);
            String str = kVar.VP.userName;
            String valueOf2 = String.valueOf(kVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(kVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(kVar.mLiveInfo.feed_id);
            int i6 = kVar.Wc.isBlock;
            String sN = com.baidu.live.gift.b.b.sK().sN();
            String str2 = kVar.mLiveInfo.appId;
            boolean z2 = kVar.Wc.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (kVar.mLiveInfo.live_type == 1 && kVar.mLiveInfo.screen_direction == 1 && com.baidu.live.r.a.wA().arE.Xp) {
                z3 = true;
            }
            int i7 = -1;
            if (kVar.Wc == null) {
                z = false;
            } else {
                boolean z4 = kVar.Wc.isNewUser;
                i7 = kVar.Wc.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.eNa != null && this.eNa.eyC != null && this.eNa.eyC.Vc == kVar.VP.userId) {
                z5 = this.eNa.ezi;
            }
            g gVar = new g(bgX().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, sN, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (kVar != null && kVar.mLiveInfo != null && kVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.am(kVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.al(z);
            ac bcG = l.bcE().bcG();
            if (bcG == null || bcG.aab <= 0) {
                i5 = 1000;
            } else {
                i5 = bcG.aab;
            }
            gVar.ba(i5);
            boolean z6 = false;
            if (kVar != null && kVar.Wc != null) {
                String str3 = kVar.Wc.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.an(z6);
            if (!this.eNd) {
                this.eNe = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    private void bgz() {
        ps(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ao aoVar) {
        if (aoVar != null && tq()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(bgX().pageContext.getPageActivity(), aoVar.abk, aoVar.liveId, aoVar.abl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null && com.baidu.live.r.a.wA().arE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bgX().pageContext.getPageActivity(), String.valueOf(kVar.mLiveInfo.live_id), String.valueOf(kVar.mLiveInfo.user_id), com.baidu.live.r.a.wA().arE.YP, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bgA() {
        if (this.eME != null) {
            this.eME.d(this.eMj.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bgB() {
        k wf = bgX().eUF.wf();
        LogManager.getCommonLogger().doClickQuickImHiLog((wf == null || wf.mLiveInfo == null) ? "" : wf.mLiveInfo.feed_id, vi());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yo(String str) {
        if (this.eME != null) {
            this.eME.dk(str);
        }
    }

    private void bgC() {
        if ("home_rec_play".equals(bgX().fromType) || "frs_play".equals(bgX().fromType) || "frs_live_play".equals(bgX().fromType) || "person_play".equals(bgX().fromType) || "search".equals(bgX().fromType) || "person_attention".equals(bgX().fromType)) {
            com.baidu.live.b.oH().aj(true);
        } else {
            com.baidu.live.b.oH().aj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iy(boolean z) {
        View qX;
        if (this.eMA == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.adq = false;
            fVar.context = bgX().pageContext.getPageActivity();
            fVar.adx = z;
            fVar.fromType = bgX().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, t.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eMA = (t) runTask.getData();
            }
        }
        if (this.eMA != null && (qX = this.eMA.qX()) != null && this.eMj.eUG.indexOfChild(qX) < 0) {
            this.eMj.eUG.addView(qX, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgD() {
        View rp;
        if (this.eMB == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.adq = false;
            aVar.context = bgX().pageContext.getPageActivity();
            aVar.fromType = bgX().fromType;
            aVar.adr = bgX().eUL;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, r.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eMB = (r) runTask.getData();
            }
        }
        if (this.eMB != null && (rp = this.eMB.rp()) != null && bgX().eUG.indexOfChild(rp) < 0) {
            if (rp.getParent() instanceof ViewGroup) {
                ((ViewGroup) rp.getParent()).removeView(rp);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bgX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bgX().eUG.addView(rp, layoutParams);
        }
    }

    private void bgE() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bgF() {
        if (this.eMz == null) {
            this.eMz = new com.baidu.tieba.ala.liveroom.d.a(bgX().pageContext);
        }
        this.eMz.setOtherParams(this.otherParams);
        this.eMz.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.im.j.a
            public void uE() {
                b.this.bgI();
            }
        });
        this.eMz.a(bgX().eUF.wf(), false);
        View uC = this.eMz.uC();
        if (uC != null && this.eMU.indexOfChild(uC) < 0) {
            Resources resources = bgX().pageContext.getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bgX().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
            this.eMU.addView(uC, layoutParams);
        }
    }

    private void bgG() {
        if (this.eMw == null) {
            this.eMw = new com.baidu.tieba.ala.liveroom.g.a(bgX().pageContext);
        }
        if (this.eMZ != null) {
            this.eMw.yu(this.eMZ.user_id);
        }
        this.eMw.Z(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iJ(boolean z) {
        CustomResponsedMessage runTask;
        if (bgX() != null && (runTask = MessageManager.getInstance().runTask(2913144, com.baidu.live.h.a.class, bgX().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eMQ = (com.baidu.live.h.a) runTask.getData();
            this.eMQ.a(bgh(), bgN());
            if (bgX().eUF != null) {
                this.eMQ.a(bgX().eUF.wf());
            }
            this.eMQ.setCanVisible(!z);
            this.eMQ.aK(true);
            this.eMQ.a(bgX().eUF.bbm());
        }
    }

    private void bgH() {
        if (this.eMJ == null) {
            this.eMJ = new com.baidu.tieba.ala.liveroom.j.a(bgX().pageContext, false, vi());
        }
        if (bgX().eUF.wf() != null && bgX().eUF.wf().VP != null && bgX().eUF.wf().mLiveInfo != null) {
            this.eMJ.c(this.eMT, bgX().eUF.wf());
            this.eMJ.a(new a.InterfaceC0446a() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
                @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0446a
                public void bhc() {
                    b.this.bgY();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x03e1, code lost:
        yk(r25);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(com.baidu.live.im.data.a aVar) {
        long j;
        long j2;
        long j3;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            jSONObject2 = jSONObject;
        } catch (JSONException e) {
        }
        if (aVar.getMsgType() == 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 != null) {
                String optString = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.eMk != null) {
                        this.eMk.iT(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        pK(optInt);
                    }
                } else if ("live_admin".equals(optString)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bgX().eUF.wf().Wc.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bgX().eUF.wf().Wc.isAdmin = 0;
                            bgX().eUF.bmQ();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bgX().eUF.wf().Wc.isAdmin = 0;
                        bgX().eUF.bmQ();
                    }
                } else if ("task".equals(optString)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eMC != null && !bgX().eUK) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bgX().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bgX().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bgX().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bcy()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eMC.a(bgX().eUH, str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.eMk != null) {
                                b.this.eMk.iS(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bgX().eUF.wf() != null && bgX().eUF.wf().mLiveInfo != null) {
                        String str2 = bgX().eUF.wf().mLiveInfo.feed_id;
                        long j4 = bgX().eUF.wf().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                            n.g(str2, j4);
                            com.baidu.live.utils.m.h(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.p.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("need_update_live_mark_info".equals(optString)) {
                    if (bgX() != null && bgX().eUF != null && bgX().eUF.wf() != null && bgX().eUF.wf().Wc != null && bgX().eUF.wf().Wc.userId == jSONObject2.optLong("user_id")) {
                        bgX().eUF.bmQ();
                    }
                } else if ("guard_seat".equals(optString) && jSONObject2.optInt("seat_status") == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913150));
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.eMu != null) {
                this.eMu.u(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a uZ = aVar.uZ();
            String optString2 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString3 = jSONObject2.optString("gift_count");
            String optString4 = jSONObject2.optString("gift_name");
            String optString5 = jSONObject2.optString("gift_url");
            String optString6 = jSONObject2.optString("attach");
            long optLong3 = jSONObject2.optLong("charm_total");
            String optString7 = jSONObject2.optString("attach_new");
            String optString8 = jSONObject2.optString("gift_mul");
            String str3 = null;
            if (bgX().eUF == null || bgX().eUF.wf() == null || bgX().eUF.wf().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bgX().eUF.wf().mLiveInfo.live_id;
                long j6 = bgX().eUF.wf().mLiveInfo.group_id;
                long j7 = bgX().eUF.wf().VP.userId;
                str3 = bgX().eUF.wf().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    s.b(optString8, uZ.userId, uZ.portrait, uZ.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str3, optString7);
                    try {
                        JSONArray jSONArray = new JSONArray(optString8);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.r.d.wH().dH(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                }
                                i++;
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                s.b(optString2, JavaTypesHelper.toInt(optString3, 1), optString4, optString5, uZ.userId, uZ.portrait, uZ.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str3, optString6);
                yk(optString2);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.eUa = optLong3;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yk(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bgI() {
        if (bgJ()) {
            BdUtilHelper.hideSoftKeyPad(bgX().pageContext.getPageActivity(), bgX().eUH);
            bge();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgJ() {
        if (bgd() == null || bgd().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wL() {
        bgX().eUG.setOnTouchListener(this.eNy);
        bgO();
        bgP();
        bgE();
        bgG();
        bgH();
        if (this.eMx != null) {
            this.eMx.f(bgX().eUF.wf());
        }
        if (this.eMD != null) {
            this.eMD.a(bgX().eUF.wf(), vi());
        }
        if (this.eME != null) {
            this.eME.a(bgX().eUF.wf(), vi());
        }
        if (this.eMF != null) {
            this.eMF.a(bgX().eUF.wf(), vi());
        }
        if (bgX().eUG != null) {
            bgX().eUG.setOnDispatchTouchEventListener(new AlaLiveView.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bgJ() && b.this.eMs != null) {
                        b.this.eMs.jx(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eMs != null) {
                        b.this.eMs.jx(true);
                    }
                    return false;
                }
            });
        }
        if (this.eMN == null) {
            this.eMN = new com.baidu.live.gift.panel.a(bgX().pageContext.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgK() {
        if (this.eMP == null && this.eMR != null && this.eMR.eVl && bgX() != null && bgX().eUF != null && bgX().eUF.wf() != null) {
            this.eMP = new com.baidu.tieba.ala.liveroom.g.e(bgX().pageContext, this.eMR);
            this.eMP.k(bgX().eUF.wf());
            if (this.eMR.eVo == 1) {
                if (this.eMy != null) {
                    this.eNc = true;
                }
            } else if (this.eMR.eVo == 2) {
                a(bgX().eUF.wf(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgL() {
        CustomResponsedMessage runTask;
        if (bgX() != null && (runTask = MessageManager.getInstance().runTask(2913130, com.baidu.live.im.i.class, bgX().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.m.a)) {
            this.eMS = (com.baidu.live.m.a) runTask.getData();
            this.eMS.a(bgg(), bgM());
            if (bgX().eUF != null) {
                this.eMS.a(bgX().eUF.wf());
            }
            this.eMS.setCanVisible(!this.eMX);
        }
    }

    private ViewGroup.LayoutParams bgM() {
        int dimensionPixelOffset;
        if (bfB()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bgX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bgX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bgN() {
        int dimensionPixelOffset;
        if (bfB()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bgX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bgX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iK(boolean z) {
        Rect rect = new Rect();
        bgX().eUH.getWindowVisibleDisplayFrame(rect);
        return ((ViewCommonUtil.getScreenFullSize(bgX().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bgX().pageContext.getPageActivity(), 48.0f) : 0)) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + bgX().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) + (z ? bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bgX().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bgO() {
        if (this.eMs != null) {
            this.eMs.ag(bgX().eUG);
        }
    }

    private void bgP() {
        if (this.eMv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.s.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eMv = (com.baidu.live.s.a) runTask.getData();
            }
            bgQ();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eMv != null) {
            if (this.eMp != null) {
                this.eMv.aX(this.eMp.bjL() ? false : true);
            } else {
                this.eMv.aX(true);
            }
            this.eMv.v(jSONObject);
        }
    }

    private void bgQ() {
        if (this.eMv != null && bgX().eUF.wf() != null && bgX().eUF.wf().Wk != null) {
            if (this.eMp != null) {
                this.eMv.aX(this.eMp.bjL() ? false : true);
            } else {
                this.eMv.aX(true);
            }
            this.eMv.a(bgX().eUF.wf().Wk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(k kVar) {
        if (kVar != null) {
            bgQ();
            if (this.eMw != null && kVar.VP != null) {
                this.eMw.yu(String.valueOf(kVar.VP.userId));
            }
            if (this.eMm != null) {
                this.eMm.a(kVar);
            }
            if (this.eMB != null && kVar.mLiveInfo != null) {
                this.eMB.a(kVar.mLiveInfo);
            }
            if (this.eMz != null) {
                this.eMz.a(kVar);
            }
            if (this.eMS != null) {
                this.eMS.a(kVar);
            }
            if (this.eMQ != null) {
                this.eMQ.a(kVar);
            }
            pK(kVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pK(int i) {
        if (!bgX().eUK) {
            if (this.eMV < 0 && i == 0) {
                this.eMV = i;
            } else if (this.eMV != i) {
                if (i == 1) {
                    if (!this.eMC.qq(2)) {
                        String string = bgX().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bgX().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eMC.a(bgX().eUH, string, 2, true);
                        }
                    }
                } else {
                    String string2 = bgX().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eMC.qr(2);
                    this.eMC.qr(3);
                    if (bcy()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eMC.a(bgX().eUH, string2, 3);
                    }
                }
                this.eMV = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.live.data.g gVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iz(boolean z) {
        if (z) {
            bgR();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eMu != null) {
            this.eMu.boP();
        }
        if (this.eMn != null) {
            this.eMn.oS();
        }
        if (this.eMp != null) {
            this.eMp.onDestroy();
        }
        if (this.eMv != null) {
            this.eMv.onDestroy();
            this.eMv = null;
        }
        if (this.eMA != null) {
            View qX = this.eMA.qX();
            if (qX != null && qX.getParent() != null) {
                ((ViewGroup) qX.getParent()).removeView(qX);
            }
            this.eMA.onDestroy();
            this.eMA = null;
        }
        if (this.eMz != null) {
            this.eMz.a((j.a) null);
            this.eMz.ub();
        }
        if (this.eMl != null) {
            this.eMl.oS();
        }
        if (this.eMC != null) {
            this.eMC.oS();
        }
        this.eMV = -1;
        if (this.eMw != null) {
            this.eMw.oS();
            this.eMw.onDestroy();
        }
        if (this.eMq != null) {
            this.eMq.boK();
        }
        if (this.eMr != null) {
            this.eMr.bfv();
        }
        if (this.eMx != null) {
            this.eMx.th();
        }
        if (this.eMD != null) {
            this.eMD.bjU();
        }
        if (this.eME != null) {
            this.eME.tT();
        }
        if (this.eMF != null) {
            this.eMF.onDestroy();
        }
        if (this.eMH != null) {
            this.eMH.onDestory();
        }
        if (this.eMK != null) {
            this.eMK.onDestroy();
        }
        if (this.eMJ != null) {
            this.eMJ.tT();
        }
        if (this.eMP != null) {
            this.eMP.onDestroy();
        }
        if (this.eML != null) {
            this.eML.th();
        }
        if (this.eMM != null) {
            this.eMM.th();
        }
        if (this.eMN != null) {
            this.eMN.th();
        }
        if (this.eMo != null) {
            this.eMo.onDestory();
        }
        if (this.eMS != null) {
            this.eMS.th();
        }
        if (this.eMQ != null) {
            this.eMQ.tT();
        }
    }

    private void bgR() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bgX().eUG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bgX().eUG.getChildAt(i);
            if (childAt != this.eMT && childAt != this.eMU) {
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
        if (this.eMT != null) {
            this.eMT.removeAllViews();
        }
        if (this.eMU != null) {
            this.eMU.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgb() {
        View uC;
        View qX;
        if (this.eMA != null && (qX = this.eMA.qX()) != null && qX.getParent() != null) {
            ((ViewGroup) qX.getParent()).removeView(qX);
        }
        if (this.eMz != null && (uC = this.eMz.uC()) != null && uC.getParent() != null) {
            ((ViewGroup) uC.getParent()).removeView(uC);
        }
        if (this.eMp != null) {
            this.eMp.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bgS() {
        if (this.eMt == null || !this.eMt.bjQ()) {
            if (this.eMp == null || !this.eMp.ac(bgX().eUH)) {
                if (this.eMs != null) {
                    this.eMs.bdn();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eMG != null && this.eMG.bjz()) {
                    this.eMG.bjI();
                    return false;
                } else if (this.eMF == null || !this.eMF.bjT()) {
                    bgC();
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
    public void onDestory() {
        if (this.eMO != null) {
            this.eMO.destroy();
        }
        if (this.eMv != null) {
            this.eMv.onDestroy();
            this.eMv = null;
        }
        if (this.eMu != null) {
            this.eMu.boP();
        }
        if (this.eMA != null) {
            this.eMA.onDestroy();
            this.eMA = null;
        }
        if (this.eMB != null) {
            this.eMB.onDestroy();
            this.eMB = null;
        }
        if (this.eMC != null) {
            this.eMC.onDestroy();
        }
        if (this.eMl != null) {
            this.eMl.onDestroy();
        }
        if (this.eMn != null) {
            this.eMn.onDestroy();
        }
        if (this.eMz != null) {
            this.eMz.a((j.a) null);
            this.eMz.release();
            this.eMz = null;
        }
        if (this.eMx != null) {
            this.eMx.release();
        }
        if (this.eMD != null) {
            this.eMD.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eMD.release();
        }
        if (this.eME != null) {
            this.eME.a((a.InterfaceC0452a) null);
            this.eME.release();
        }
        if (this.eMF != null) {
            this.eMF.a((a.InterfaceC0447a) null);
            this.eMF.onDestroy();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.eMJ != null) {
            this.eMJ.onDestroy();
        }
        if (this.eMK != null) {
            this.eMK.onDestroy();
        }
        if (this.eMH != null) {
            this.eMH.onDestory();
        }
        if (this.eMP != null) {
            this.eMP.onDestroy();
        }
        if (this.eMI != null) {
            this.eMI.release();
        }
        if (this.eML != null) {
            this.eML.release();
        }
        if (this.eMM != null) {
            this.eMM.release();
        }
        if (this.eMN != null) {
            this.eMN.release();
        }
        if (this.eMo != null) {
            this.eMo.onDestory();
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.eMQ != null) {
            this.eMQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eNp);
        MessageManager.getInstance().unRegisterListener(this.eNq);
        MessageManager.getInstance().unRegisterListener(this.eNs);
        MessageManager.getInstance().unRegisterListener(this.eNk);
        MessageManager.getInstance().unRegisterListener(this.eNl);
        MessageManager.getInstance().unRegisterListener(this.eNj);
        MessageManager.getInstance().unRegisterListener(this.eNo);
        MessageManager.getInstance().unRegisterListener(this.eNn);
        MessageManager.getInstance().unRegisterListener(this.eNt);
        MessageManager.getInstance().unRegisterListener(this.eqn);
        MessageManager.getInstance().unRegisterListener(this.eNu);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.eyG);
        MessageManager.getInstance().unRegisterListener(this.eyF);
        MessageManager.getInstance().unRegisterListener(this.eNm);
        MessageManager.getInstance().unRegisterListener(this.eNv);
        MessageManager.getInstance().unRegisterListener(this.eNw);
        MessageManager.getInstance().unRegisterListener(this.eNx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgT() {
        if (this.eMD != null) {
            this.eMD.jf(false);
        }
        if (this.eMF != null) {
            this.eMF.jf(false);
        }
        bge();
        if (this.eMI != null) {
            this.eMI.pause();
        }
        if (this.eML != null) {
            this.eML.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgU() {
        this.eNe = false;
        if (this.eMY && this.eMZ != null) {
            a(this.eMZ);
            this.eMY = false;
        }
        if (this.eMD != null) {
            this.eMD.jf(true);
        }
        if (this.eMF != null) {
            this.eMF.jf(true);
        }
        if (this.eMI != null) {
            this.eMI.resume();
        }
        if (this.eML != null) {
            this.eML.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bgV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bgV();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    I(-1, -1, -1);
                    return;
                }
                return;
            }
            bgV();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    I(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bgV();
        } else if (i == 25034) {
            bgz();
        } else if (i == 25043) {
            if (i2 == -1) {
                bgY();
            }
        } else if (i == 25050 && this.eMO != null) {
            if (i2 == -1) {
                this.eMO.ae(intent);
            } else {
                this.eMO.ae(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        this.eMX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bgW() {
        return (bgX().eUF.wf() == null || bgX().eUF.wf().mLiveInfo == null || bgX().eUF.wf().mLiveInfo.live_type != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eMp != null) {
                this.eMp.bc(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eMF != null) {
            this.eMF.awu();
        }
        if (this.eMo != null) {
            this.eMo.awu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.eMk = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eMj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bgX() {
        return this.eMj;
    }

    public void bd(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgY() {
        String bcF = l.bcE().bcF();
        if (!TextUtils.isEmpty(bcF)) {
            try {
                I(-1, Integer.parseInt(bcF), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                I(-1, -1, -1);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public boolean pq(int i) {
        if (7 == i) {
            if (this.eMA != null) {
                this.eMA.av(true);
            }
            if (this.eMl != null) {
                this.eMl.bfw();
            }
        } else if (1 == i) {
            if (bgd() != null) {
                bgd().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eMX) {
                return false;
            }
            if (this.eMp == null || !this.eMp.bjL()) {
                return this.eMl == null || this.eMl.bfy();
            }
            return false;
        } else if (3 == i) {
            if (bgX().eUG != null) {
                bgX().eUG.setEnabled(false);
                if (this.eMk != null) {
                    this.eMk.A(!bgX().eUI, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eMl == null || !this.eMl.isShowing();
        }
        return true;
    }

    public void pI(int i) {
        if ((i == 7 || i == 11) && this.eMl != null) {
            this.eMl.bfw();
            this.eMl.iw(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void pr(int i) {
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void ps(int i) {
        if (7 == i) {
            if (this.eMA != null) {
                this.eMA.av(false);
            }
            if (this.eMl != null) {
                this.eMl.iw(true);
            }
        } else if (11 == i) {
            if (this.eMl != null) {
                this.eMl.iw(true);
            }
        } else if (3 == i) {
            bgX().eUG.setEnabled(true);
            if (this.eMk != null) {
                this.eMk.A(bgX().eUI ? false : true, true);
            }
            if (this.eMv != null) {
                this.eMv.aX(true);
            }
        } else if (2 == i && this.eMu != null) {
            this.eMu.jE(true);
        }
    }

    public String vi() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eMz != null) {
            this.eMz.setOtherParams(str);
        }
    }

    private boolean bcy() {
        return bgX().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
