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
    public static boolean eSP;
    private com.baidu.tieba.ala.liveroom.data.a eRQ;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eRR;
    protected com.baidu.live.h.a eRS;
    protected com.baidu.tieba.ala.liveroom.share.c eRT;
    protected com.baidu.tieba.ala.liveroom.o.b eRU;
    protected com.baidu.tieba.ala.liveroom.guide.c eRV;
    protected com.baidu.tieba.ala.liveroom.watermark.a eRW;
    protected com.baidu.tieba.ala.liveroom.b.b eRX;
    protected com.baidu.tieba.ala.liveroom.praise.a eRY;
    protected com.baidu.tieba.ala.liveroom.guide.d eRZ;
    protected aq eSA;
    protected com.baidu.live.q.a eSB;
    protected RelativeLayout eSC;
    protected RelativeLayout eSD;
    protected boolean eSF;
    protected x eSI;
    protected GuardClubInfoHttpResponseMessage eSJ;
    boolean eSK;
    boolean eSL;
    boolean eSM;
    public boolean eSN;
    public boolean eSO;
    protected com.baidu.tieba.ala.liveroom.q.b eSQ;
    protected e eSR;
    protected com.baidu.tieba.ala.liveroom.u.a eSa;
    protected com.baidu.live.x.a eSb;
    private com.baidu.tieba.ala.liveroom.g.a eSc;
    private m eSd;
    i eSe;
    j eSf;
    protected u eSg;
    protected s eSh;
    protected com.baidu.tieba.ala.liveroom.tippop.a eSi;
    private com.baidu.tieba.ala.liveroom.guideim.b eSj;
    protected com.baidu.live.view.input.c eSk;
    com.baidu.tieba.ala.liveroom.k.a eSl;
    protected com.baidu.tieba.ala.liveroom.guide.a eSm;
    private k eSn;
    protected com.baidu.tieba.ala.liveroom.f.a eSo;
    protected h eSp;
    protected com.baidu.live.guardclub.j eSq;
    protected w eSr;
    protected com.baidu.tieba.ala.liveroom.turntable.e eSt;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eSu;
    protected com.baidu.tieba.ala.liveroom.n.c eSv;
    private v eSw;
    protected com.baidu.tieba.ala.liveroom.s.a eSx;
    protected com.baidu.tieba.ala.liveroom.g.e eSy;
    protected com.baidu.live.i.a eSz;
    protected String otherParams;
    private int eSs = 0;
    private int eSE = -1;
    protected int mOrientation = 0;
    protected boolean eSG = false;
    protected boolean eSH = false;
    private CustomMessageListener eSS = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            if ((customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null) {
                b.this.a(rVar.Yw, rVar.Ys, rVar.Yt, rVar.Yu, rVar.Yv);
            }
        }
    };
    private CustomMessageListener eST = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bjJ().fav.yO().XQ.userId);
            com.baidu.live.view.a.Bj().a(valueOf, new com.baidu.live.data.b(b.this.bjJ().fav.yO().XQ.portrait, valueOf, true, b.this.bjJ().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eSU = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.m) && b.this.eRT != null) {
                b.this.eRT.c((com.baidu.live.data.m) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener atN = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSe != null) {
                b.this.eSe.h(com.baidu.live.gift.r.sx().sz());
            }
        }
    };
    private CustomMessageListener eSV = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eRQ.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.yO(str);
            }
        }
    };
    private CustomMessageListener eSW = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bjJ().pageContext.getPageActivity());
            }
            if (b.this.eRT != null) {
                b.this.eRT.c(b.this.bjJ().fav.yO(), false);
            }
        }
    };
    private CustomMessageListener eSX = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    b.this.eSH = true;
                    b.this.eSI = (x) data;
                    b.this.b(b.this.eSI);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eSY = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bjJ().fav.yO().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bjJ().fav.yO().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bjJ().fav.yO().XQ.userId);
            if (b.this.eRU == null) {
                b.this.eRU = new com.baidu.tieba.ala.liveroom.o.b(b.this.bjJ().pageContext);
            }
            b.this.eRU.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eRU.a(b.this.eSZ);
        }
    };
    private b.a eSZ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void yZ() {
            if (b.this.bjJ().fav.yO() != null && b.this.bjJ().fav.yO().Ye != null) {
                b.this.bjJ().fav.yO().Ye.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eTa = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eTb = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pR(7);
        }
    };
    CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eTc = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eSK = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSl != null) {
                b.this.eSl.sN();
            }
        }
    };
    HttpMessageListener eEi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).apY) != null && b.this.eSn != null && b.this.bjJ() != null && b.this.bjJ().fav != null) {
                int[] iArr = new int[2];
                b.this.eSC.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.eSn.a(b.this.eSC, layoutParams, aVar, b.this.bjJ().fav.yO());
                com.baidu.live.l.a.ac(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener eEf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bjJ() != null && b.this.bjJ().fav != null && b.this.bjJ().fav.yO() != null && guardClubInfoHttpResponseMessage.apY != null) {
                    if (guardClubInfoHttpResponseMessage.apY.WZ == b.this.bjJ().fav.yO().XQ.userId) {
                        b.this.eSJ = guardClubInfoHttpResponseMessage;
                        if (b.this.eSJ.aqb && com.baidu.live.guardclub.e.vG() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.vG().E(b.this.bjJ().fav.yO().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eTd = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof au) {
                b.this.a((au) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eTe = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.p(b.this.bjJ().fav.yO());
        }
    };
    private CustomMessageListener eTf = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSz != null) {
                b.this.eSz.vO();
            }
        }
    };
    private CustomMessageListener eTg = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.eSr != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.eSr).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener eTh = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bjn();
        }
    };
    private View.OnTouchListener eTi = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bjx();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(x xVar);

    protected abstract void b(x xVar);

    protected abstract View biQ();

    public abstract boolean biR();

    protected abstract boolean biS();

    protected abstract ViewGroup biT();

    protected abstract ViewGroup biU();

    public abstract boolean bin();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(aq aqVar) {
        this.eSA = aqVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eSC = (RelativeLayout) bjJ().faw.findViewById(a.g.ala_live_header_view);
        this.eSD = (RelativeLayout) bjJ().faw.findViewById(a.g.ala_live_footer_view);
        tq();
        registerListener();
    }

    public void biZ() {
    }

    private void tq() {
        if (this.eRT == null) {
            this.eRT = new com.baidu.tieba.ala.liveroom.share.c(bjJ().pageContext);
        }
        this.eSa = new com.baidu.tieba.ala.liveroom.u.a(bjJ().pageContext, this);
        this.eRX = new com.baidu.tieba.ala.liveroom.b.b(bjJ().pageContext, false);
        this.eRY = new com.baidu.tieba.ala.liveroom.praise.a(bjJ().pageContext);
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
                this.eRZ = new com.baidu.tieba.ala.liveroom.guide.d(bjJ().pageContext);
            }
        }
        this.eSi = new com.baidu.tieba.ala.liveroom.tippop.a(bjJ().pageContext, this);
        bja();
        bjc();
        bjd();
        bje();
        bjh();
        bji();
        bjj();
        bjk();
    }

    private void bja() {
        this.eSd = new m();
    }

    public void iU(boolean z) {
        this.eSF = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjb() {
        com.baidu.live.data.m yO = bjJ().fav.yO();
        boolean z = com.baidu.live.v.a.zl().awC.aaS;
        if (yO.mLiveInfo != null && yO.mLiveInfo.mAlaLiveSwitchData != null && yO.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = yO.Yo ? z : false;
        if (z2) {
            if (this.eRS == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bjJ().pageContext);
                if (runTask != null) {
                    this.eRS = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eRS != null) {
                this.eRS.bV(1);
                View view = this.eRS.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bjJ().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bjJ().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eSC.addView(view, layoutParams);
                    if (z2) {
                        this.eRS.a(yO);
                    }
                }
            }
        }
    }

    private void bjc() {
        this.eSj = new com.baidu.tieba.ala.liveroom.guideim.b(bjJ().pageContext);
        this.eSj.c(this.eSD, bin());
        this.eSj.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean ws() {
                return b.this.uX();
            }
        });
    }

    private void bjd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bjJ().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eSk = (com.baidu.live.view.input.c) runTask.getData();
            this.eSk.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
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
                    return b.this.bjg();
                }
            });
        }
    }

    private void bje() {
        this.eSl = new com.baidu.tieba.ala.liveroom.k.a(this.eRQ.pageContext);
        this.eSl.a(new a.InterfaceC0461a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public boolean bjL() {
                return b.this.biS();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public void onClose() {
                if (b.this.awg != null) {
                    b.this.awg.bb(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iV(boolean z) {
        if (this.eSj != null) {
            this.eSj.jt(z);
        }
        if (this.eSl != null) {
            this.eSl.jt(z);
        }
        eSP = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjf() {
        return eSP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjg() {
        com.baidu.live.data.m yO;
        if (bjJ() == null || bjJ().fav == null || (yO = bjJ().fav.yO()) == null || yO.Ye == null) {
            return false;
        }
        String str = yO.Ye.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bjh() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bjJ().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eSn = (k) runTask.getData();
            this.eSn.setOtherParams(xx());
        }
    }

    private void bji() {
        this.eSo = new com.baidu.tieba.ala.liveroom.f.a(bjJ().pageContext);
    }

    private void bjj() {
        this.eSt = new com.baidu.tieba.ala.liveroom.turntable.e(bjJ().pageContext.getPageActivity());
    }

    private void bjk() {
        this.eSv = new com.baidu.tieba.ala.liveroom.n.c(bjJ().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eSX);
        MessageManager.getInstance().registerListener(this.eSY);
        MessageManager.getInstance().registerListener(this.eTa);
        MessageManager.getInstance().registerListener(this.eST);
        MessageManager.getInstance().registerListener(this.eSU);
        MessageManager.getInstance().registerListener(this.eSS);
        MessageManager.getInstance().registerListener(this.eSW);
        MessageManager.getInstance().registerListener(this.eSV);
        MessageManager.getInstance().registerListener(this.eTb);
        MessageManager.getInstance().registerListener(this.evY);
        MessageManager.getInstance().registerListener(this.eTc);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.eEi);
        MessageManager.getInstance().registerListener(this.eEf);
        MessageManager.getInstance().registerListener(this.atN);
        MessageManager.getInstance().registerListener(this.eTd);
        MessageManager.getInstance().registerListener(this.eTe);
        MessageManager.getInstance().registerListener(this.eTf);
        MessageManager.getInstance().registerListener(this.eTg);
        MessageManager.getInstance().registerListener(this.eTh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uX() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bjJ().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bjJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bjJ().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zl().awC.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bjJ().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bjJ().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bjJ().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bjJ().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjl() {
        if (this.eSe != null) {
            this.eSe.wr().b(this.eSk.xe(), com.baidu.live.gift.r.sx().sz());
            iV(true);
            if (this.eSw == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, v.class, bjJ().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.eSw = (v) runTask.getData();
                } else {
                    return;
                }
            }
            this.eSw.sK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjm() {
        if (this.eSe != null) {
            this.eSe.wr().hide();
            iV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i, int i2, int i3) {
        if (bjJ().fav.yO() != null && bjJ().fav.yO().XQ != null && bjJ().fav.yO().mLiveInfo != null) {
            a(bjJ().fav.yO(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && uX()) {
            if (mVar == null) {
                mVar = bjJ().fav.yO();
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
            if (mVar.mLiveInfo.live_type == 1 && mVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.zl().awC.Zz) {
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
            if (this.eSJ != null && this.eSJ.apY != null && this.eSJ.apY.WZ == mVar.XQ.userId) {
                z5 = this.eSJ.aqb;
            }
            g gVar = new g(bjJ().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, sI, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
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
            if (!this.eSN) {
                this.eSO = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjn() {
        ce(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && uX()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(bjJ().pageContext.getPageActivity(), auVar.adB, auVar.liveId, auVar.adC)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zl().awC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bjJ().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zl().awC.aaT, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjo() {
        if (this.eSk != null) {
            this.eSk.c(this.eRQ.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjp() {
        com.baidu.live.data.m yO = bjJ().fav.yO();
        LogManager.getCommonLogger().doClickQuickImHiLog((yO == null || yO.mLiveInfo == null) ? "" : yO.mLiveInfo.feed_id, xx());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yP(String str) {
        if (this.eSk != null) {
            this.eSk.dx(str);
        }
    }

    private void bjq() {
        if ("home_rec_play".equals(bjJ().fromType) || "frs_play".equals(bjJ().fromType) || "frs_live_play".equals(bjJ().fromType) || "person_play".equals(bjJ().fromType) || "search".equals(bjJ().fromType) || "person_attention".equals(bjJ().fromType)) {
            com.baidu.live.b.pq().am(true);
        } else {
            com.baidu.live.b.pq().am(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iR(boolean z) {
        View sk;
        if (this.eSg == null) {
            f fVar = new f();
            fVar.afH = false;
            fVar.context = bjJ().pageContext.getPageActivity();
            fVar.afP = z;
            fVar.fromType = bjJ().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSg = (u) runTask.getData();
            }
        }
        if (this.eSg != null && (sk = this.eSg.sk()) != null && this.eRQ.faw.indexOfChild(sk) < 0) {
            this.eRQ.faw.addView(sk, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjr() {
        View sM;
        if (this.eSr == null) {
            z zVar = new z();
            zVar.afH = false;
            zVar.pageContext = bjJ().pageContext;
            zVar.fromType = bjJ().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSr = (w) runTask.getData();
            }
        }
        if (this.eSr != null && (sM = this.eSr.sM()) != null && bjJ().faw.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bjJ().faw.addView(sM, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjs() {
        View sC;
        if (this.eSh == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = false;
            aVar.context = bjJ().pageContext.getPageActivity();
            aVar.fromType = bjJ().fromType;
            aVar.afI = bjJ().faA;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSh = (s) runTask.getData();
            }
        }
        if (this.eSh != null && (sC = this.eSh.sC()) != null && bjJ().faw.indexOfChild(sC) < 0) {
            if (sC.getParent() instanceof ViewGroup) {
                ((ViewGroup) sC.getParent()).removeView(sC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bjJ().faw.addView(sC, layoutParams);
        }
    }

    private void bjt() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bju() {
        CustomResponsedMessage runTask;
        if (this.eSf == null && (runTask = MessageManager.getInstance().runTask(2913099, j.class, bjJ().pageContext)) != null) {
            this.eSf = (j) runTask.getData();
        }
        if (this.eSf != null) {
            this.eSf.setOtherParams(this.otherParams);
            this.eSf.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.j.a
                public void wz() {
                    b.this.bjx();
                }
            });
            this.eSf.a(bjJ().fav.yO(), false);
            View wx = this.eSf.wx();
            if (wx != null && this.eSD.indexOfChild(wx) < 0) {
                Resources resources = bjJ().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjJ().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.eSD.addView(wx, layoutParams);
            }
        }
    }

    private void bjv() {
        if (this.eSc == null) {
            this.eSc = new com.baidu.tieba.ala.liveroom.g.a(bjJ().pageContext);
        }
        if (this.eSI != null) {
            this.eSc.yT(this.eSI.user_id);
        }
        this.eSc.af(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iW(boolean z) {
        CustomResponsedMessage runTask;
        if (bjJ() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bjJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSz = (com.baidu.live.i.a) runTask.getData();
            this.eSz.a(biU(), bjC());
            if (bjJ().fav != null) {
                this.eSz.a(bjJ().fav.yO());
            }
            this.eSz.setCanVisible(!z);
            this.eSz.aP(true);
            this.eSz.a(bjJ().fav.bdZ());
        }
    }

    private void bjw() {
        if (this.eSp == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bjJ().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSp = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bjJ().fav.yO() != null && bjJ().fav.yO().XQ != null && bjJ().fav.yO().mLiveInfo != null) {
            this.eSp.setHost(false);
            this.eSp.setOtherParams(xx());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bjJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.eSp.a(this.eSC, layoutParams, bjJ().fav.yO());
            this.eSp.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void vN() {
                    b.this.bjK();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x0468, code lost:
        yL(r27);
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
                    if (this.awg != null) {
                        this.awg.bd(z);
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
                            bjJ().fav.yO().Ye.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjJ().fav.yO().Ye.isAdmin = 0;
                            bjJ().fav.bpE();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bjJ().fav.yO().Ye.isAdmin = 0;
                        bjJ().fav.bpE();
                    }
                } else if ("task".equals(optString2)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eSi != null && !bjJ().faz) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bjJ().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bjJ().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bjJ().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bfl()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eSi.a(bjJ().fau.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.awg != null) {
                                b.this.awg.bc(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bjJ().fav.yO() != null && bjJ().fav.yO().mLiveInfo != null) {
                        String str2 = bjJ().fav.yO().mLiveInfo.feed_id;
                        long j4 = bjJ().fav.yO().mLiveInfo.live_id;
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
                    if (bjJ() != null && bjJ().fav != null && bjJ().fav.yO() != null && bjJ().fav.yO().Ye != null && bjJ().fav.yO().Ye.userId == jSONObject2.optLong("user_id")) {
                        bjJ().fav.bpE();
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
            if (this.eSa != null) {
                this.eSa.v(aVar);
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
            if (bjJ().fav == null || bjJ().fav.yO() == null || bjJ().fav.yO().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bjJ().fav.yO().mLiveInfo.live_id;
                long j6 = bjJ().fav.yO().mLiveInfo.group_id;
                long j7 = bjJ().fav.yO().XQ.userId;
                str4 = bjJ().fav.yO().mLiveInfo.appId;
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
                yL(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.eZO = optLong4;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yL(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjx() {
        if (bjy()) {
            BdUtilHelper.hideSoftKeyPad(bjJ().pageContext.getPageActivity(), bjJ().fau.getLiveContainerView());
            biR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjy() {
        if (biQ() == null || biQ().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        bjJ().faw.setOnTouchListener(this.eTi);
        bjD();
        bjE();
        bjt();
        bjv();
        bjw();
        if (this.eSd != null) {
            this.eSd.g(bjJ().fav.yO());
        }
        if (this.eSj != null) {
            this.eSj.c(bjJ().fav.yO(), xx());
        }
        if (this.eSk != null) {
            this.eSk.a(bjJ().fav.yO(), xx());
        }
        if (this.eSl != null) {
            this.eSl.c(bjJ().fav.yO(), xx());
        }
        if (bjJ().faw != null) {
            bjJ().faw.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bjy() && b.this.eRY != null) {
                        b.this.eRY.jK(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eRY != null) {
                        b.this.eRY.jK(true);
                    }
                    return false;
                }
            });
        }
        if (this.eSw == null && (runTask = MessageManager.getInstance().runTask(2913165, v.class, bjJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSw = (v) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjz() {
        if (this.eSy == null && this.eSA != null && this.eSA.adf && bjJ() != null && bjJ().fav != null && bjJ().fav.yO() != null) {
            this.eSy = new com.baidu.tieba.ala.liveroom.g.e(bjJ().pageContext, this.eSA);
            this.eSy.r(bjJ().fav.yO());
            if (this.eSA.adi == 1) {
                if (this.eSe != null) {
                    this.eSL = true;
                }
            } else if (this.eSA.adi == 2) {
                a(bjJ().fav.yO(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjA() {
        CustomResponsedMessage runTask;
        if (bjJ() != null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bjJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSB = (com.baidu.live.q.a) runTask.getData();
            this.eSB.a(biT(), bjB());
            if (bjJ().fav != null) {
                this.eSM = this.eSB.m(bjJ().fav.yO());
            }
            this.eSB.setCanVisible(!this.eSG);
        }
    }

    private ViewGroup.LayoutParams bjB() {
        int dimensionPixelOffset;
        if (bin()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjJ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjJ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bjC() {
        int dimensionPixelOffset;
        if (bin()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjJ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjJ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iX(boolean z) {
        Rect rect = new Rect();
        bjJ().fau.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bjJ().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bjJ().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bjJ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bjJ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bjD() {
        if (this.eRY != null) {
            this.eRY.al(bjJ().faw);
        }
    }

    private void bjE() {
        if (this.eSb == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eSb = (com.baidu.live.x.a) runTask.getData();
            }
            bjF();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eSb != null) {
            if (this.eRV != null) {
                this.eSb.bj(this.eRV.bmu() ? false : true);
            } else {
                this.eSb.bj(true);
            }
            this.eSb.v(jSONObject);
        }
    }

    private void bjF() {
        if (this.eSb != null && bjJ().fav.yO() != null && bjJ().fav.yO().Yn != null) {
            if (this.eRV != null) {
                this.eSb.bj(this.eRV.bmu() ? false : true);
            } else {
                this.eSb.bj(true);
            }
            this.eSb.a(bjJ().fav.yO().Yn);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.m mVar) {
        if (mVar != null) {
            bjF();
            if (this.eSc != null && mVar.XQ != null) {
                this.eSc.yT(String.valueOf(mVar.XQ.userId));
            }
            if (this.eRS != null) {
                this.eRS.a(mVar);
            }
            if (this.eSh != null && mVar.mLiveInfo != null) {
                this.eSh.a(mVar.mLiveInfo);
            }
            if (this.eSf != null) {
                this.eSf.a(mVar);
            }
            if (this.eSB != null) {
                this.eSM = this.eSB.m(mVar);
            }
            if (this.eSz != null) {
                this.eSz.a(mVar);
            }
            pT(mVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pT(int i) {
        if (!bjJ().faz) {
            if (this.eSE < 0 && i == 0) {
                this.eSE = i;
            } else if (this.eSE != i) {
                if (i == 1) {
                    if (!this.eSi.qC(2)) {
                        String string = bjJ().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bjJ().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eSi.a(bjJ().fau.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bjJ().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eSi.qD(2);
                    this.eSi.qD(3);
                    if (bfl()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eSi.a(bjJ().fau.getLiveContainerView(), string2, 3);
                    }
                }
                this.eSE = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (z) {
            bjG();
        }
        if (this.eSa != null) {
            this.eSa.brx();
        }
        if (this.eRT != null) {
            this.eRT.pK();
        }
        if (this.eRV != null) {
            this.eRV.onDestroy();
        }
        if (this.eSb != null) {
            this.eSb.onDestroy();
            this.eSb = null;
        }
        if (this.eSg != null) {
            View sk = this.eSg.sk();
            if (sk != null && sk.getParent() != null) {
                ((ViewGroup) sk.getParent()).removeView(sk);
            }
            this.eSg.onDestroy();
            this.eSg = null;
        }
        if (this.eSf != null) {
            this.eSf.a((j.a) null);
            this.eSf.vW();
        }
        if (this.eRR != null) {
            this.eRR.pK();
        }
        if (this.eSi != null) {
            this.eSi.pK();
        }
        this.eSE = -1;
        if (this.eSc != null) {
            this.eSc.pK();
            this.eSc.onDestroy();
        }
        if (this.eRW != null) {
            this.eRW.bru();
        }
        if (this.eRX != null) {
            this.eRX.bih();
        }
        if (this.eSd != null) {
            this.eSd.sL();
        }
        if (this.eSj != null) {
            this.eSj.bmD();
        }
        if (this.eSk != null) {
            this.eSk.sL();
        }
        if (this.eSl != null) {
            this.eSl.onDestroy();
        }
        if (this.eSn != null) {
            this.eSn.onDestory();
        }
        if (this.eSq != null) {
            this.eSq.vL();
        }
        if (this.eSp != null) {
            this.eSp.vL();
        }
        if (this.eSy != null) {
            this.eSy.onDestroy();
        }
        if (this.eSt != null) {
            this.eSt.sL();
        }
        if (this.eSu != null) {
            this.eSu.sL();
        }
        if (this.eSw != null) {
            this.eSw.sL();
        }
        if (this.eRU != null) {
            this.eRU.onDestory();
        }
        if (this.eSB != null) {
            this.eSB.sL();
        }
        if (this.eSz != null) {
            this.eSz.vL();
        }
        if (this.eSv != null) {
            this.eSv.sL();
        }
        if (this.eSr != null) {
            this.eSr.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void bjG() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bjJ().faw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bjJ().faw.getChildAt(i);
            if (childAt != this.eSC && childAt != this.eSD) {
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
        if (this.eSC != null) {
            this.eSC.removeAllViews();
        }
        if (this.eSD != null) {
            this.eSD.removeAllViews();
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
        if (this.eSg != null && (sk = this.eSg.sk()) != null && sk.getParent() != null) {
            ((ViewGroup) sk.getParent()).removeView(sk);
        }
        if (this.eSf != null && (wx = this.eSf.wx()) != null && wx.getParent() != null) {
            ((ViewGroup) wx.getParent()).removeView(wx);
        }
        if (this.eRV != null) {
            this.eRV.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean yJ() {
        if (this.eRZ == null || !this.eRZ.bmz()) {
            if (this.eRV == null || !this.eRV.ah(bjJ().fau.getLiveContainerView())) {
                if (this.eRY != null) {
                    this.eRY.bfV();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eSm != null && this.eSm.bmi()) {
                    this.eSm.bmr();
                    return false;
                } else if (this.eSl == null || !this.eSl.bmC()) {
                    bjq();
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
        if (this.eSx != null) {
            this.eSx.destroy();
        }
        if (this.eSb != null) {
            this.eSb.onDestroy();
            this.eSb = null;
        }
        if (this.eSa != null) {
            this.eSa.brx();
        }
        if (this.eSg != null) {
            this.eSg.onDestroy();
            this.eSg = null;
        }
        if (this.eSh != null) {
            this.eSh.onDestroy();
            this.eSh = null;
        }
        if (this.eSi != null) {
            this.eSi.onDestroy();
        }
        if (this.eRR != null) {
            this.eRR.onDestroy();
        }
        if (this.eRT != null) {
            this.eRT.onDestroy();
        }
        if (this.eSr != null) {
            this.eSr.onDestroy();
            this.eSr = null;
        }
        if (this.eSf != null) {
            this.eSf.a((j.a) null);
            this.eSf.release();
            this.eSf = null;
        }
        if (this.eSd != null) {
            this.eSd.release();
        }
        if (this.eSj != null) {
            this.eSj.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eSj.release();
        }
        if (this.eSk != null) {
            this.eSk.a(null);
            this.eSk.release();
        }
        if (this.eSl != null) {
            this.eSl.a((a.InterfaceC0461a) null);
            this.eSl.onDestroy();
        }
        if (this.eSp != null) {
            this.eSp.onDestroy();
        }
        if (this.eSq != null) {
            this.eSq.onDestroy();
        }
        if (this.eSn != null) {
            this.eSn.onDestory();
        }
        if (this.eSy != null) {
            this.eSy.onDestroy();
        }
        if (this.eSo != null) {
            this.eSo.release();
        }
        if (this.eSt != null) {
            this.eSt.release();
        }
        if (this.eSv != null) {
            this.eSv.release();
        }
        if (this.eSu != null) {
            this.eSu.release();
        }
        if (this.eSw != null) {
            this.eSw.release();
        }
        if (this.eRU != null) {
            this.eRU.onDestory();
        }
        if (this.eSB != null) {
            this.eSB.release();
        }
        if (this.eSz != null) {
            this.eSz.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eTh);
        MessageManager.getInstance().unRegisterListener(this.eSX);
        MessageManager.getInstance().unRegisterListener(this.eSY);
        MessageManager.getInstance().unRegisterListener(this.eTa);
        MessageManager.getInstance().unRegisterListener(this.eST);
        MessageManager.getInstance().unRegisterListener(this.eSU);
        MessageManager.getInstance().unRegisterListener(this.eSS);
        MessageManager.getInstance().unRegisterListener(this.eSW);
        MessageManager.getInstance().unRegisterListener(this.eSV);
        MessageManager.getInstance().unRegisterListener(this.eTb);
        MessageManager.getInstance().unRegisterListener(this.evY);
        MessageManager.getInstance().unRegisterListener(this.eTc);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.eEi);
        MessageManager.getInstance().unRegisterListener(this.eEf);
        MessageManager.getInstance().unRegisterListener(this.atN);
        MessageManager.getInstance().unRegisterListener(this.eTd);
        MessageManager.getInstance().unRegisterListener(this.eTe);
        MessageManager.getInstance().unRegisterListener(this.eTf);
        MessageManager.getInstance().unRegisterListener(this.eTg);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.eSj != null) {
            this.eSj.js(false);
        }
        if (this.eSl != null) {
            this.eSl.js(false);
        }
        biR();
        if (this.eSo != null) {
            this.eSo.pause();
        }
        if (this.eSt != null) {
            this.eSt.pause();
        }
        if (this.eSv != null) {
            this.eSv.pause();
        }
        if (this.eSr != null) {
            this.eSr.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.eSO = false;
        if (this.eSH && this.eSI != null) {
            a(this.eSI);
            this.eSH = false;
        }
        if (this.eSj != null) {
            this.eSj.js(true);
        }
        if (this.eSl != null) {
            this.eSl.js(true);
        }
        if (this.eSo != null) {
            this.eSo.resume();
        }
        if (this.eSt != null) {
            this.eSt.resume();
        }
        if (this.eSv != null) {
            this.eSv.resume();
        }
        if (this.eSr != null) {
            this.eSr.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjH() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bjH();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, -1, -1);
                    return;
                }
                return;
            }
            bjH();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bjH();
        } else if (i == 25034) {
            bjn();
        } else if (i == 25043) {
            if (i2 == -1) {
                bjK();
            }
        } else if (i == 25050 && this.eSx != null) {
            if (i2 == -1) {
                this.eSx.ae(intent);
            } else {
                this.eSx.ae(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void d(boolean z, int i) {
        this.eSG = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjI() {
        return (bjJ().fav.yO() == null || bjJ().fav.yO().mLiveInfo == null || bjJ().fav.yO().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eRV != null) {
                this.eRV.bg(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eSl != null) {
            this.eSl.azc();
        }
        if (this.eRU != null) {
            this.eRU.azc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eRQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bjJ() {
        return this.eRQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjK() {
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
            if (this.eSg != null) {
                this.eSg.ay(true);
            }
            if (this.eRR != null) {
                this.eRR.bii();
            }
        } else if (1 == i) {
            if (biQ() != null) {
                biQ().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eSG) {
                return false;
            }
            if (this.eRV == null || !this.eRV.bmu()) {
                return this.eRR == null || this.eRR.bik();
            }
            return false;
        } else if (3 == i) {
            if (bjJ().faw != null) {
                bjJ().faw.setEnabled(false);
                if (this.awg != null) {
                    this.awg.f(!bjJ().fax, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eRR == null || !this.eRR.isShowing();
        }
        return true;
    }

    public void pR(int i) {
        if ((i == 7 || i == 11) && this.eRR != null) {
            this.eRR.bii();
            this.eRR.iP(false);
        }
    }

    public void cd(int i) {
    }

    public void ce(int i) {
        if (7 == i) {
            if (this.eSg != null) {
                this.eSg.ay(false);
            }
            if (this.eRR != null) {
                this.eRR.iP(true);
            }
        } else if (11 == i) {
            if (this.eRR != null) {
                this.eRR.iP(true);
            }
        } else if (3 == i) {
            bjJ().faw.setEnabled(true);
            if (this.awg != null) {
                this.awg.f(bjJ().fax ? false : true, true);
            }
            if (this.eSb != null) {
                this.eSb.bj(true);
            }
        } else if (2 == i && this.eSa != null) {
            this.eSa.jR(true);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eSf != null) {
            this.eSf.setOtherParams(str);
        }
    }

    private boolean bfl() {
        return bjJ().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
