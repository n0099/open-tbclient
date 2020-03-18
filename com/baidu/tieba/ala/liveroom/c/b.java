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
import com.baidu.tieba.ala.liveroom.k.a;
import com.baidu.tieba.ala.liveroom.turntable.e;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean eTn;
    private com.baidu.tieba.ala.liveroom.g.a eSA;
    private m eSB;
    i eSC;
    j eSD;
    protected u eSE;
    protected s eSF;
    protected com.baidu.tieba.ala.liveroom.tippop.a eSG;
    private com.baidu.tieba.ala.liveroom.guideim.b eSH;
    protected com.baidu.live.view.input.c eSI;
    com.baidu.tieba.ala.liveroom.k.a eSJ;
    protected com.baidu.tieba.ala.liveroom.guide.a eSK;
    private k eSL;
    protected com.baidu.tieba.ala.liveroom.f.a eSM;
    protected h eSN;
    protected com.baidu.live.guardclub.j eSO;
    protected w eSP;
    protected e eSR;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b eSS;
    protected com.baidu.tieba.ala.liveroom.n.c eST;
    private v eSU;
    protected com.baidu.tieba.ala.liveroom.s.a eSV;
    protected com.baidu.tieba.ala.liveroom.g.e eSW;
    protected com.baidu.live.i.a eSX;
    protected aq eSY;
    protected com.baidu.live.q.a eSZ;
    private com.baidu.tieba.ala.liveroom.data.a eSo;
    private com.baidu.tieba.ala.liveroom.attentionpop.a eSp;
    protected com.baidu.live.h.a eSq;
    protected com.baidu.tieba.ala.liveroom.share.c eSr;
    protected com.baidu.tieba.ala.liveroom.o.b eSs;
    protected com.baidu.tieba.ala.liveroom.guide.c eSt;
    protected com.baidu.tieba.ala.liveroom.watermark.a eSu;
    protected com.baidu.tieba.ala.liveroom.b.b eSv;
    protected com.baidu.tieba.ala.liveroom.praise.a eSw;
    protected com.baidu.tieba.ala.liveroom.guide.d eSx;
    protected com.baidu.tieba.ala.liveroom.u.a eSy;
    protected com.baidu.live.x.a eSz;
    protected RelativeLayout eTa;
    protected RelativeLayout eTb;
    protected boolean eTd;
    protected x eTg;
    protected GuardClubInfoHttpResponseMessage eTh;
    boolean eTi;
    boolean eTj;
    boolean eTk;
    public boolean eTl;
    public boolean eTm;
    protected com.baidu.tieba.ala.liveroom.q.b eTo;
    protected com.baidu.tieba.ala.liveroom.h.e eTp;
    protected String otherParams;
    private int eSQ = 0;
    private int eTc = -1;
    protected int mOrientation = 0;
    protected boolean eTe = false;
    protected boolean eTf = false;
    private CustomMessageListener eTq = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            if ((customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null) {
                b.this.a(rVar.YG, rVar.YC, rVar.YD, rVar.YE, rVar.YF);
            }
        }
    };
    private CustomMessageListener eTr = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bjO().faT.yT().Ya.userId);
            com.baidu.live.view.a.Bq().a(valueOf, new com.baidu.live.data.b(b.this.bjO().faT.yT().Ya.portrait, valueOf, true, b.this.bjO().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener eTs = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.m) && b.this.eSr != null) {
                b.this.eSr.c((com.baidu.live.data.m) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener atX = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSC != null) {
                b.this.eSC.h(com.baidu.live.gift.r.sC().sE());
            }
        }
    };
    private CustomMessageListener eTt = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.eSo.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.yO(str);
            }
        }
    };
    private CustomMessageListener eTu = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bjO().pageContext.getPageActivity());
            }
            if (b.this.eSr != null) {
                b.this.eSr.c(b.this.bjO().faT.yT(), false);
            }
        }
    };
    private CustomMessageListener eTv = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    b.this.eTf = true;
                    b.this.eTg = (x) data;
                    b.this.b(b.this.eTg);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener eTw = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.bjO().faT.yT().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.bjO().faT.yT().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.bjO().faT.yT().Ya.userId);
            if (b.this.eSs == null) {
                b.this.eSs = new com.baidu.tieba.ala.liveroom.o.b(b.this.bjO().pageContext);
            }
            b.this.eSs.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.eSs.a(b.this.eTx);
        }
    };
    private b.a eTx = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void ze() {
            if (b.this.bjO().faT.yT() != null && b.this.bjO().faT.yT().Yo != null) {
                b.this.bjO().faT.yT().Yo.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener eTy = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener eTz = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.pT(7);
        }
    };
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener eTA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.eTi = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSJ != null) {
                b.this.eSJ.sS();
            }
        }
    };
    HttpMessageListener eEE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aqi) != null && b.this.eSL != null && b.this.bjO() != null && b.this.bjO().faT != null) {
                int[] iArr = new int[2];
                b.this.eTa.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.eSL.a(b.this.eTa, layoutParams, aVar, b.this.bjO().faT.yT());
                com.baidu.live.l.a.ab(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener eEB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bjO() != null && b.this.bjO().faT != null && b.this.bjO().faT.yT() != null && guardClubInfoHttpResponseMessage.aqi != null) {
                    if (guardClubInfoHttpResponseMessage.aqi.Xj == b.this.bjO().faT.yT().Ya.userId) {
                        b.this.eTh = guardClubInfoHttpResponseMessage;
                        if (b.this.eTh.aql && com.baidu.live.guardclub.e.vL() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.vL().E(b.this.bjO().faT.yT().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eTB = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof au) {
                b.this.a((au) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eTC = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.p(b.this.bjO().faT.yT());
        }
    };
    private CustomMessageListener eTD = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.eSX != null) {
                b.this.eSX.vT();
            }
        }
    };
    private CustomMessageListener eTE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.eSP != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.eSP).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener eTF = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bjs();
        }
    };
    private View.OnTouchListener eTG = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bjC();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(x xVar);

    protected abstract void b(x xVar);

    protected abstract View biV();

    public abstract boolean biW();

    protected abstract boolean biX();

    protected abstract ViewGroup biY();

    protected abstract ViewGroup biZ();

    public abstract boolean bis();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(aq aqVar) {
        this.eSY = aqVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.eTa = (RelativeLayout) bjO().faU.findViewById(a.g.ala_live_header_view);
        this.eTb = (RelativeLayout) bjO().faU.findViewById(a.g.ala_live_footer_view);
        tv();
        registerListener();
    }

    public void bje() {
    }

    private void tv() {
        if (this.eSr == null) {
            this.eSr = new com.baidu.tieba.ala.liveroom.share.c(bjO().pageContext);
        }
        this.eSy = new com.baidu.tieba.ala.liveroom.u.a(bjO().pageContext, this);
        this.eSv = new com.baidu.tieba.ala.liveroom.b.b(bjO().pageContext, false);
        this.eSw = new com.baidu.tieba.ala.liveroom.praise.a(bjO().pageContext);
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
                this.eSx = new com.baidu.tieba.ala.liveroom.guide.d(bjO().pageContext);
            }
        }
        this.eSG = new com.baidu.tieba.ala.liveroom.tippop.a(bjO().pageContext, this);
        bjf();
        bjh();
        bji();
        bjj();
        bjm();
        bjn();
        bjo();
        bjp();
    }

    private void bjf() {
        this.eSB = new m();
    }

    public void iW(boolean z) {
        this.eTd = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjg() {
        com.baidu.live.data.m yT = bjO().faT.yT();
        boolean z = com.baidu.live.v.a.zs().awM.abd;
        if (yT.mLiveInfo != null && yT.mLiveInfo.mAlaLiveSwitchData != null && yT.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = yT.Yy ? z : false;
        if (z2) {
            if (this.eSq == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bjO().pageContext);
                if (runTask != null) {
                    this.eSq = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.eSq != null) {
                this.eSq.bV(1);
                View view = this.eSq.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bjO().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bjO().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.eTa.addView(view, layoutParams);
                    if (z2) {
                        this.eSq.a(yT);
                    }
                }
            }
        }
    }

    private void bjh() {
        this.eSH = new com.baidu.tieba.ala.liveroom.guideim.b(bjO().pageContext);
        this.eSH.c(this.eTb, bis());
        this.eSH.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean wx() {
                return b.this.vc();
            }
        });
    }

    private void bji() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bjO().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eSI = (com.baidu.live.view.input.c) runTask.getData();
            this.eSI.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                @Override // com.baidu.live.view.input.c.a
                public void BE() {
                    b.this.pT(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void BF() {
                    b.this.ce(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean wx() {
                    return b.this.vc();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean xs() {
                    return b.this.bjl();
                }
            });
        }
    }

    private void bjj() {
        this.eSJ = new com.baidu.tieba.ala.liveroom.k.a(this.eSo.pageContext);
        this.eSJ.a(new a.InterfaceC0461a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public boolean bjQ() {
                return b.this.biX();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0461a
            public void onClose() {
                if (b.this.awq != null) {
                    b.this.awq.bb(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iX(boolean z) {
        if (this.eSH != null) {
            this.eSH.jv(z);
        }
        if (this.eSJ != null) {
            this.eSJ.jv(z);
        }
        eTn = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjk() {
        return eTn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bjl() {
        com.baidu.live.data.m yT;
        if (bjO() == null || bjO().faT == null || (yT = bjO().faT.yT()) == null || yT.Yo == null) {
            return false;
        }
        String str = yT.Yo.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bjm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bjO().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eSL = (k) runTask.getData();
            this.eSL.setOtherParams(xC());
        }
    }

    private void bjn() {
        this.eSM = new com.baidu.tieba.ala.liveroom.f.a(bjO().pageContext);
    }

    private void bjo() {
        this.eSR = new e(bjO().pageContext.getPageActivity());
    }

    private void bjp() {
        this.eST = new com.baidu.tieba.ala.liveroom.n.c(bjO().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.eTv);
        MessageManager.getInstance().registerListener(this.eTw);
        MessageManager.getInstance().registerListener(this.eTy);
        MessageManager.getInstance().registerListener(this.eTr);
        MessageManager.getInstance().registerListener(this.eTs);
        MessageManager.getInstance().registerListener(this.eTq);
        MessageManager.getInstance().registerListener(this.eTu);
        MessageManager.getInstance().registerListener(this.eTt);
        MessageManager.getInstance().registerListener(this.eTz);
        MessageManager.getInstance().registerListener(this.ewu);
        MessageManager.getInstance().registerListener(this.eTA);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.eEE);
        MessageManager.getInstance().registerListener(this.eEB);
        MessageManager.getInstance().registerListener(this.atX);
        MessageManager.getInstance().registerListener(this.eTB);
        MessageManager.getInstance().registerListener(this.eTC);
        MessageManager.getInstance().registerListener(this.eTD);
        MessageManager.getInstance().registerListener(this.eTE);
        MessageManager.getInstance().registerListener(this.eTF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vc() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bjO().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bjO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bjO().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zs().awM.aaB;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bjO().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bjO().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bjO().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bjO().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjq() {
        if (this.eSC != null) {
            this.eSC.ww().b(this.eSI.xj(), com.baidu.live.gift.r.sC().sE());
            iX(true);
            if (this.eSU == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, v.class, bjO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.eSU = (v) runTask.getData();
                } else {
                    return;
                }
            }
            this.eSU.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjr() {
        if (this.eSC != null) {
            this.eSC.ww().hide();
            iX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i, int i2, int i3) {
        if (bjO().faT.yT() != null && bjO().faT.yT().Ya != null && bjO().faT.yT().mLiveInfo != null) {
            a(bjO().faT.yT(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && vc()) {
            if (mVar == null) {
                mVar = bjO().faT.yT();
            }
            String valueOf = String.valueOf(mVar.Ya.userId);
            String str = mVar.Ya.userName;
            String valueOf2 = String.valueOf(mVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(mVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(mVar.mLiveInfo.feed_id);
            int i6 = mVar.Yo.isBlock;
            String sN = t.sN();
            String str2 = mVar.mLiveInfo.appId;
            boolean z2 = mVar.Yo.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (mVar.mLiveInfo.live_type == 1 && mVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.zs().awM.ZJ) {
                z3 = true;
            }
            int i7 = -1;
            if (mVar.Yo == null) {
                z = false;
            } else {
                boolean z4 = mVar.Yo.isNewUser;
                i7 = mVar.Yo.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.eTh != null && this.eTh.aqi != null && this.eTh.aqi.Xj == mVar.Ya.userId) {
                z5 = this.eTh.aql;
            }
            g gVar = new g(bjO().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, sN, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.ap(mVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.ao(z);
            ah vO = com.baidu.live.guardclub.g.vM().vO();
            if (vO == null || vO.acx <= 0) {
                i5 = 1000;
            } else {
                i5 = vO.acx;
            }
            gVar.bh(i5);
            boolean z6 = false;
            if (mVar != null && mVar.Yo != null) {
                String str3 = mVar.Yo.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.aq(z6);
            if (!this.eTl) {
                this.eTm = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjs() {
        ce(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && vc()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(bjO().pageContext.getPageActivity(), auVar.adL, auVar.liveId, auVar.adM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zs().awM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bjO().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zs().awM.abe, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjt() {
        if (this.eSI != null) {
            this.eSI.c(this.eSo.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bju() {
        com.baidu.live.data.m yT = bjO().faT.yT();
        LogManager.getCommonLogger().doClickQuickImHiLog((yT == null || yT.mLiveInfo == null) ? "" : yT.mLiveInfo.feed_id, xC());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yP(String str) {
        if (this.eSI != null) {
            this.eSI.dw(str);
        }
    }

    private void bjv() {
        if ("home_rec_play".equals(bjO().fromType) || "frs_play".equals(bjO().fromType) || "frs_live_play".equals(bjO().fromType) || "person_play".equals(bjO().fromType) || "search".equals(bjO().fromType) || "person_attention".equals(bjO().fromType)) {
            com.baidu.live.b.pv().am(true);
        } else {
            com.baidu.live.b.pv().am(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iT(boolean z) {
        View sp;
        if (this.eSE == null) {
            f fVar = new f();
            fVar.afR = false;
            fVar.context = bjO().pageContext.getPageActivity();
            fVar.afZ = z;
            fVar.fromType = bjO().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSE = (u) runTask.getData();
            }
        }
        if (this.eSE != null && (sp = this.eSE.sp()) != null && this.eSo.faU.indexOfChild(sp) < 0) {
            this.eSo.faU.addView(sp, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjw() {
        View sR;
        if (this.eSP == null) {
            z zVar = new z();
            zVar.afR = false;
            zVar.pageContext = bjO().pageContext;
            zVar.fromType = bjO().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSP = (w) runTask.getData();
            }
        }
        if (this.eSP != null && (sR = this.eSP.sR()) != null && bjO().faU.indexOfChild(sR) < 0) {
            if (sR.getParent() instanceof ViewGroup) {
                ((ViewGroup) sR.getParent()).removeView(sR);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bjO().faU.addView(sR, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjx() {
        View sH;
        if (this.eSF == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afR = false;
            aVar.context = bjO().pageContext.getPageActivity();
            aVar.fromType = bjO().fromType;
            aVar.afS = bjO().faY;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSF = (s) runTask.getData();
            }
        }
        if (this.eSF != null && (sH = this.eSF.sH()) != null && bjO().faU.indexOfChild(sH) < 0) {
            if (sH.getParent() instanceof ViewGroup) {
                ((ViewGroup) sH.getParent()).removeView(sH);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bjO().faU.addView(sH, layoutParams);
        }
    }

    private void bjy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjz() {
        CustomResponsedMessage runTask;
        if (this.eSD == null && (runTask = MessageManager.getInstance().runTask(2913099, j.class, bjO().pageContext)) != null) {
            this.eSD = (j) runTask.getData();
        }
        if (this.eSD != null) {
            this.eSD.setOtherParams(this.otherParams);
            this.eSD.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.j.a
                public void wE() {
                    b.this.bjC();
                }
            });
            this.eSD.a(bjO().faT.yT(), false);
            View wC = this.eSD.wC();
            if (wC != null && this.eTb.indexOfChild(wC) < 0) {
                Resources resources = bjO().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bjO().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.eTb.addView(wC, layoutParams);
            }
        }
    }

    private void bjA() {
        if (this.eSA == null) {
            this.eSA = new com.baidu.tieba.ala.liveroom.g.a(bjO().pageContext);
        }
        if (this.eTg != null) {
            this.eSA.yT(this.eTg.user_id);
        }
        this.eSA.ag(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iY(boolean z) {
        CustomResponsedMessage runTask;
        if (bjO() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bjO().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSX = (com.baidu.live.i.a) runTask.getData();
            this.eSX.a(biZ(), bjH());
            if (bjO().faT != null) {
                this.eSX.a(bjO().faT.yT());
            }
            this.eSX.setCanVisible(!z);
            this.eSX.aP(true);
            this.eSX.a(bjO().faT.bee());
        }
    }

    private void bjB() {
        if (this.eSN == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bjO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSN = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bjO().faT.yT() != null && bjO().faT.yT().Ya != null && bjO().faT.yT().mLiveInfo != null) {
            this.eSN.setHost(false);
            this.eSN.setOtherParams(xC());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bjO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.eSN.a(this.eTa, layoutParams, bjO().faT.yT());
            this.eSN.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void vS() {
                    b.this.bjP();
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
                    if (this.awq != null) {
                        this.awq.bd(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        pV(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjO().faT.yT().Yo.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bjO().faT.yT().Yo.isAdmin = 0;
                            bjO().faT.bpJ();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bjO().faT.yT().Yo.isAdmin = 0;
                        bjO().faT.bpJ();
                    }
                } else if ("task".equals(optString2)) {
                    cD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.eSG != null && !bjO().faX) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bjO().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bjO().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bjO().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bfq()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.eSG.a(bjO().faS.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.awq != null) {
                                b.this.awq.bc(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt("event_type") == 1001 && bjO().faT.yT() != null && bjO().faT.yT().mLiveInfo != null) {
                        String str2 = bjO().faT.yT().mLiveInfo.feed_id;
                        long j4 = bjO().faT.yT().mLiveInfo.live_id;
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
                    if (bjO() != null && bjO().faT != null && bjO().faT.yT() != null && bjO().faT.yT().Yo != null && bjO().faT.yT().Yo.userId == jSONObject2.optLong("user_id")) {
                        bjO().faT.bpJ();
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
            if (this.eSy != null) {
                this.eSy.v(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a xt = aVar.xt();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong4 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bjO().faT == null || bjO().faT.yT() == null || bjO().faT.yT().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bjO().faT.yT().mLiveInfo.live_id;
                long j6 = bjO().faT.yT().mLiveInfo.group_id;
                long j7 = bjO().faT.yT().Ya.userId;
                str4 = bjO().faT.yT().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    t.b(optString9, xt.userId, xt.portrait, xt.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "");
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.zz().dX(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                t.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, xt.userId, xt.portrait, xt.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "");
                yL(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.fam = optLong4;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void yL(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bjC() {
        if (bjD()) {
            BdUtilHelper.hideSoftKeyPad(bjO().pageContext.getPageActivity(), bjO().faS.getLiveContainerView());
            biW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjD() {
        if (biV() == null || biV().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        bjO().faU.setOnTouchListener(this.eTG);
        bjI();
        bjJ();
        bjy();
        bjA();
        bjB();
        if (this.eSB != null) {
            this.eSB.g(bjO().faT.yT());
        }
        if (this.eSH != null) {
            this.eSH.c(bjO().faT.yT(), xC());
        }
        if (this.eSI != null) {
            this.eSI.a(bjO().faT.yT(), xC());
        }
        if (this.eSJ != null) {
            this.eSJ.c(bjO().faT.yT(), xC());
        }
        if (bjO().faU != null) {
            bjO().faU.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bjD() && b.this.eSw != null) {
                        b.this.eSw.jM(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.eSw != null) {
                        b.this.eSw.jM(true);
                    }
                    return false;
                }
            });
        }
        if (this.eSU == null && (runTask = MessageManager.getInstance().runTask(2913165, v.class, bjO().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSU = (v) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjE() {
        if (this.eSW == null && this.eSY != null && this.eSY.adp && bjO() != null && bjO().faT != null && bjO().faT.yT() != null) {
            this.eSW = new com.baidu.tieba.ala.liveroom.g.e(bjO().pageContext, this.eSY);
            this.eSW.r(bjO().faT.yT());
            if (this.eSY.ads == 1) {
                if (this.eSC != null) {
                    this.eTj = true;
                }
            } else if (this.eSY.ads == 2) {
                a(bjO().faT.yT(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjF() {
        CustomResponsedMessage runTask;
        if (bjO() != null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bjO().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSZ = (com.baidu.live.q.a) runTask.getData();
            this.eSZ.a(biY(), bjG());
            if (bjO().faT != null) {
                this.eTk = this.eSZ.m(bjO().faT.yT());
            }
            this.eSZ.setCanVisible(!this.eTe);
        }
    }

    private ViewGroup.LayoutParams bjG() {
        int dimensionPixelOffset;
        if (bis()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjO().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjO().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bjH() {
        int dimensionPixelOffset;
        if (bis()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bjO().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bjO().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int iZ(boolean z) {
        Rect rect = new Rect();
        bjO().faS.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bjO().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bjO().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bjO().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bjO().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bjI() {
        if (this.eSw != null) {
            this.eSw.am(bjO().faU);
        }
    }

    private void bjJ() {
        if (this.eSz == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.eSz = (com.baidu.live.x.a) runTask.getData();
            }
            bjK();
        }
    }

    private void cD(JSONObject jSONObject) {
        if (this.eSz != null) {
            if (this.eSt != null) {
                this.eSz.bk(this.eSt.bmz() ? false : true);
            } else {
                this.eSz.bk(true);
            }
            this.eSz.v(jSONObject);
        }
    }

    private void bjK() {
        if (this.eSz != null && bjO().faT.yT() != null && bjO().faT.yT().Yx != null) {
            if (this.eSt != null) {
                this.eSz.bk(this.eSt.bmz() ? false : true);
            } else {
                this.eSz.bk(true);
            }
            this.eSz.a(bjO().faT.yT().Yx);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(com.baidu.live.data.m mVar) {
        if (mVar != null) {
            bjK();
            if (this.eSA != null && mVar.Ya != null) {
                this.eSA.yT(String.valueOf(mVar.Ya.userId));
            }
            if (this.eSq != null) {
                this.eSq.a(mVar);
            }
            if (this.eSF != null && mVar.mLiveInfo != null) {
                this.eSF.a(mVar.mLiveInfo);
            }
            if (this.eSD != null) {
                this.eSD.a(mVar);
            }
            if (this.eSZ != null) {
                this.eTk = this.eSZ.m(mVar);
            }
            if (this.eSX != null) {
                this.eSX.a(mVar);
            }
            pV(mVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void pV(int i) {
        if (!bjO().faX) {
            if (this.eTc < 0 && i == 0) {
                this.eTc = i;
            } else if (this.eTc != i) {
                if (i == 1) {
                    if (!this.eSG.qE(2)) {
                        String string = bjO().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bjO().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.eSG.a(bjO().faS.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bjO().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.eSG.qF(2);
                    this.eSG.qF(3);
                    if (bfq()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.eSG.a(bjO().faS.getLiveContainerView(), string2, 3);
                    }
                }
                this.eTc = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bf(boolean z) {
        super.bf(z);
        if (z) {
            bjL();
        }
        if (this.eSy != null) {
            this.eSy.brC();
        }
        if (this.eSr != null) {
            this.eSr.pP();
        }
        if (this.eSt != null) {
            this.eSt.onDestroy();
        }
        if (this.eSz != null) {
            this.eSz.onDestroy();
            this.eSz = null;
        }
        if (this.eSE != null) {
            View sp = this.eSE.sp();
            if (sp != null && sp.getParent() != null) {
                ((ViewGroup) sp.getParent()).removeView(sp);
            }
            this.eSE.onDestroy();
            this.eSE = null;
        }
        if (this.eSD != null) {
            this.eSD.a((j.a) null);
            this.eSD.wb();
        }
        if (this.eSp != null) {
            this.eSp.pP();
        }
        if (this.eSG != null) {
            this.eSG.pP();
        }
        this.eTc = -1;
        if (this.eSA != null) {
            this.eSA.pP();
            this.eSA.onDestroy();
        }
        if (this.eSu != null) {
            this.eSu.brz();
        }
        if (this.eSv != null) {
            this.eSv.bim();
        }
        if (this.eSB != null) {
            this.eSB.sQ();
        }
        if (this.eSH != null) {
            this.eSH.bmI();
        }
        if (this.eSI != null) {
            this.eSI.sQ();
        }
        if (this.eSJ != null) {
            this.eSJ.onDestroy();
        }
        if (this.eSL != null) {
            this.eSL.onDestory();
        }
        if (this.eSO != null) {
            this.eSO.vQ();
        }
        if (this.eSN != null) {
            this.eSN.vQ();
        }
        if (this.eSW != null) {
            this.eSW.onDestroy();
        }
        if (this.eSR != null) {
            this.eSR.sQ();
        }
        if (this.eSS != null) {
            this.eSS.sQ();
        }
        if (this.eSU != null) {
            this.eSU.sQ();
        }
        if (this.eSs != null) {
            this.eSs.onDestory();
        }
        if (this.eSZ != null) {
            this.eSZ.sQ();
        }
        if (this.eSX != null) {
            this.eSX.vQ();
        }
        if (this.eST != null) {
            this.eST.sQ();
        }
        if (this.eSP != null) {
            this.eSP.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void bjL() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bjO().faU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bjO().faU.getChildAt(i);
            if (childAt != this.eTa && childAt != this.eTb) {
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
        if (this.eTa != null) {
            this.eTa.removeAllViews();
        }
        if (this.eTb != null) {
            this.eTb.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.m mVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(com.baidu.live.data.m mVar) {
        View wC;
        View sp;
        if (this.eSE != null && (sp = this.eSE.sp()) != null && sp.getParent() != null) {
            ((ViewGroup) sp.getParent()).removeView(sp);
        }
        if (this.eSD != null && (wC = this.eSD.wC()) != null && wC.getParent() != null) {
            ((ViewGroup) wC.getParent()).removeView(wC);
        }
        if (this.eSt != null) {
            this.eSt.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean yO() {
        if (this.eSx == null || !this.eSx.bmE()) {
            if (this.eSt == null || !this.eSt.ai(bjO().faS.getLiveContainerView())) {
                if (this.eSw != null) {
                    this.eSw.bga();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.eSK != null && this.eSK.bmn()) {
                    this.eSK.bmw();
                    return false;
                } else if (this.eSJ == null || !this.eSJ.bmH()) {
                    bjv();
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
        if (this.eSV != null) {
            this.eSV.destroy();
        }
        if (this.eSz != null) {
            this.eSz.onDestroy();
            this.eSz = null;
        }
        if (this.eSy != null) {
            this.eSy.brC();
        }
        if (this.eSE != null) {
            this.eSE.onDestroy();
            this.eSE = null;
        }
        if (this.eSF != null) {
            this.eSF.onDestroy();
            this.eSF = null;
        }
        if (this.eSG != null) {
            this.eSG.onDestroy();
        }
        if (this.eSp != null) {
            this.eSp.onDestroy();
        }
        if (this.eSr != null) {
            this.eSr.onDestroy();
        }
        if (this.eSP != null) {
            this.eSP.onDestroy();
            this.eSP = null;
        }
        if (this.eSD != null) {
            this.eSD.a((j.a) null);
            this.eSD.release();
            this.eSD = null;
        }
        if (this.eSB != null) {
            this.eSB.release();
        }
        if (this.eSH != null) {
            this.eSH.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.eSH.release();
        }
        if (this.eSI != null) {
            this.eSI.a(null);
            this.eSI.release();
        }
        if (this.eSJ != null) {
            this.eSJ.a((a.InterfaceC0461a) null);
            this.eSJ.onDestroy();
        }
        if (this.eSN != null) {
            this.eSN.onDestroy();
        }
        if (this.eSO != null) {
            this.eSO.onDestroy();
        }
        if (this.eSL != null) {
            this.eSL.onDestory();
        }
        if (this.eSW != null) {
            this.eSW.onDestroy();
        }
        if (this.eSM != null) {
            this.eSM.release();
        }
        if (this.eSR != null) {
            this.eSR.release();
        }
        if (this.eST != null) {
            this.eST.release();
        }
        if (this.eSS != null) {
            this.eSS.release();
        }
        if (this.eSU != null) {
            this.eSU.release();
        }
        if (this.eSs != null) {
            this.eSs.onDestory();
        }
        if (this.eSZ != null) {
            this.eSZ.release();
        }
        if (this.eSX != null) {
            this.eSX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eTF);
        MessageManager.getInstance().unRegisterListener(this.eTv);
        MessageManager.getInstance().unRegisterListener(this.eTw);
        MessageManager.getInstance().unRegisterListener(this.eTy);
        MessageManager.getInstance().unRegisterListener(this.eTr);
        MessageManager.getInstance().unRegisterListener(this.eTs);
        MessageManager.getInstance().unRegisterListener(this.eTq);
        MessageManager.getInstance().unRegisterListener(this.eTu);
        MessageManager.getInstance().unRegisterListener(this.eTt);
        MessageManager.getInstance().unRegisterListener(this.eTz);
        MessageManager.getInstance().unRegisterListener(this.ewu);
        MessageManager.getInstance().unRegisterListener(this.eTA);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.eEE);
        MessageManager.getInstance().unRegisterListener(this.eEB);
        MessageManager.getInstance().unRegisterListener(this.atX);
        MessageManager.getInstance().unRegisterListener(this.eTB);
        MessageManager.getInstance().unRegisterListener(this.eTC);
        MessageManager.getInstance().unRegisterListener(this.eTD);
        MessageManager.getInstance().unRegisterListener(this.eTE);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.eSH != null) {
            this.eSH.ju(false);
        }
        if (this.eSJ != null) {
            this.eSJ.ju(false);
        }
        biW();
        if (this.eSM != null) {
            this.eSM.pause();
        }
        if (this.eSR != null) {
            this.eSR.pause();
        }
        if (this.eST != null) {
            this.eST.pause();
        }
        if (this.eSP != null) {
            this.eSP.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.eTm = false;
        if (this.eTf && this.eTg != null) {
            a(this.eTg);
            this.eTf = false;
        }
        if (this.eSH != null) {
            this.eSH.ju(true);
        }
        if (this.eSJ != null) {
            this.eSJ.ju(true);
        }
        if (this.eSM != null) {
            this.eSM.resume();
        }
        if (this.eSR != null) {
            this.eSR.resume();
        }
        if (this.eST != null) {
            this.eST.resume();
        }
        if (this.eSP != null) {
            this.eSP.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bjM() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bjM();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, -1, -1);
                    return;
                }
                return;
            }
            bjM();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    J(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bjM();
        } else if (i == 25034) {
            bjs();
        } else if (i == 25043) {
            if (i2 == -1) {
                bjP();
            }
        } else if (i == 25050 && this.eSV != null) {
            if (i2 == -1) {
                this.eSV.ae(intent);
            } else {
                this.eSV.ae(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void d(boolean z, int i) {
        this.eTe = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bjN() {
        return (bjO().faT.yT() == null || bjO().faT.yT().mLiveInfo == null || bjO().faT.yT().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void j(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.eSt != null) {
                this.eSt.bh(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.eSJ != null) {
            this.eSJ.azf();
        }
        if (this.eSs != null) {
            this.eSs.azf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.eSo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bjO() {
        return this.eSo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjP() {
        String vN = com.baidu.live.guardclub.g.vM().vN();
        if (!TextUtils.isEmpty(vN)) {
            try {
                J(-1, Integer.parseInt(vN), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                J(-1, -1, -1);
            }
        }
    }

    public boolean cc(int i) {
        if (7 == i) {
            if (this.eSE != null) {
                this.eSE.ay(true);
            }
            if (this.eSp != null) {
                this.eSp.bin();
            }
        } else if (1 == i) {
            if (biV() != null) {
                biV().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.eTe) {
                return false;
            }
            if (this.eSt == null || !this.eSt.bmz()) {
                return this.eSp == null || this.eSp.bip();
            }
            return false;
        } else if (3 == i) {
            if (bjO().faU != null) {
                bjO().faU.setEnabled(false);
                if (this.awq != null) {
                    this.awq.f(!bjO().faV, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.eSp == null || !this.eSp.isShowing();
        }
        return true;
    }

    public void pT(int i) {
        if ((i == 7 || i == 11) && this.eSp != null) {
            this.eSp.bin();
            this.eSp.iR(false);
        }
    }

    public void cd(int i) {
    }

    public void ce(int i) {
        if (7 == i) {
            if (this.eSE != null) {
                this.eSE.ay(false);
            }
            if (this.eSp != null) {
                this.eSp.iR(true);
            }
        } else if (11 == i) {
            if (this.eSp != null) {
                this.eSp.iR(true);
            }
        } else if (3 == i) {
            bjO().faU.setEnabled(true);
            if (this.awq != null) {
                this.awq.f(bjO().faV ? false : true, true);
            }
            if (this.eSz != null) {
                this.eSz.bk(true);
            }
        } else if (2 == i && this.eSy != null) {
            this.eSy.jT(true);
        }
    }

    public String xC() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eSD != null) {
            this.eSD.setOtherParams(str);
        }
    }

    private boolean bfq() {
        return bjO().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
