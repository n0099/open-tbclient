package com.baidu.tieba.ala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import com.baidu.live.c.q;
import com.baidu.live.data.ak;
import com.baidu.live.data.at;
import com.baidu.live.data.ax;
import com.baidu.live.data.n;
import com.baidu.live.data.s;
import com.baidu.live.data.z;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.f;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.x;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.guardclub.h;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.o;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
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
import com.baidu.live.utils.m;
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
    public static boolean fxM;
    private com.baidu.tieba.ala.liveroom.data.a fwN;
    private com.baidu.tieba.ala.liveroom.attentionpop.a fwO;
    protected com.baidu.live.h.a fwP;
    protected com.baidu.tieba.ala.liveroom.share.c fwQ;
    protected com.baidu.tieba.ala.liveroom.o.b fwR;
    protected com.baidu.tieba.ala.liveroom.guide.c fwS;
    protected com.baidu.tieba.ala.liveroom.watermark.a fwT;
    protected com.baidu.tieba.ala.liveroom.b.b fwU;
    protected com.baidu.tieba.ala.liveroom.praise.a fwV;
    protected com.baidu.tieba.ala.liveroom.guide.d fwW;
    protected com.baidu.tieba.ala.liveroom.v.a fwX;
    protected com.baidu.live.x.a fwY;
    private com.baidu.tieba.ala.liveroom.g.a fwZ;
    protected RelativeLayout fxA;
    protected boolean fxC;
    protected z fxF;
    protected GuardClubInfoHttpResponseMessage fxG;
    boolean fxH;
    boolean fxI;
    boolean fxJ;
    public boolean fxK;
    public boolean fxL;
    protected com.baidu.tieba.ala.liveroom.q.b fxN;
    protected e fxO;
    private o fxa;
    k fxb;
    l fxc;
    protected v fxd;
    protected t fxe;
    protected com.baidu.tieba.ala.liveroom.tippop.a fxf;
    private com.baidu.tieba.ala.liveroom.guideim.b fxg;
    protected com.baidu.live.view.input.c fxh;
    com.baidu.tieba.ala.liveroom.k.a fxi;
    protected com.baidu.tieba.ala.liveroom.guide.a fxj;
    private com.baidu.live.guardclub.k fxk;
    protected com.baidu.tieba.ala.liveroom.f.a fxl;
    protected h fxm;
    protected j fxn;
    protected x fxo;
    protected com.baidu.tieba.ala.liveroom.turntable.e fxq;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b fxr;
    protected com.baidu.tieba.ala.liveroom.n.c fxs;
    private w fxt;
    protected com.baidu.tieba.ala.liveroom.s.a fxu;
    protected com.baidu.tieba.ala.liveroom.g.e fxv;
    protected com.baidu.live.i.a fxw;
    protected at fxx;
    protected com.baidu.live.q.a fxy;
    protected RelativeLayout fxz;
    protected String otherParams;
    private int fxp = 0;
    private int fxB = -1;
    protected int mOrientation = 0;
    protected boolean fxD = false;
    protected boolean fxE = false;
    private CustomMessageListener fxP = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            s sVar;
            if ((customResponsedMessage.getData() instanceof s) && (sVar = (s) customResponsedMessage.getData()) != null) {
                b.this.a(sVar.aqW, sVar.aqS, sVar.aqT, sVar.aqU, sVar.aqV);
            }
        }
    };
    private CustomMessageListener fxQ = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.btg().fFh.DM().aqk.userId);
            com.baidu.live.view.a.Hs().a(valueOf, new com.baidu.live.data.b(b.this.btg().fFh.DM().aqk.portrait, valueOf, true, b.this.btg().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener fxR = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof n) && b.this.fwQ != null) {
                b.this.fwQ.c((n) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener aNk = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fxb != null) {
                b.this.fxb.e(com.baidu.live.gift.s.wU().wW());
            }
        }
    };
    private CustomMessageListener fxS = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.fwN.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.AA(str);
            }
        }
    };
    private CustomMessageListener fxT = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.btg().pageContext.getPageActivity());
            } else if (b.this.fwQ != null) {
                b.this.fwQ.c(b.this.btg().fFh.DM(), false);
            }
        }
    };
    private CustomMessageListener fxU = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof z) {
                    b.this.fxE = true;
                    b.this.fxF = (z) data;
                    b.this.b(b.this.fxF);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener fxV = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.btg().fFh.DM().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.btg().fFh.DM().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.btg().fFh.DM().aqk.userId);
                    if (b.this.fwR == null) {
                        b.this.fwR = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    b.this.fwR.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.fwR.a(b.this.fxW);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.a fxW = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void DY() {
            if (b.this.btg().fFh.DM() != null && b.this.btg().fFh.DM().aqD != null) {
                b.this.btg().fFh.DM().aqD.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener fxX = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener fxY = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.qn(7);
        }
    };
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener fxZ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.fxH = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fxi != null) {
                b.this.fxi.xk();
            }
        }
    };
    HttpMessageListener fje = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aIX) != null && b.this.fxk != null && b.this.btg() != null && b.this.btg().fFh != null) {
                int[] iArr = new int[2];
                b.this.fxz.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.fxk.a(b.this.fxz, layoutParams, aVar, b.this.btg().fFh.DM());
                com.baidu.live.l.a.af(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fjb = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.btg() != null && b.this.btg().fFh != null && b.this.btg().fFh.DM() != null && guardClubInfoHttpResponseMessage.aIX != null) {
                    if (guardClubInfoHttpResponseMessage.aIX.aps == b.this.btg().fFh.DM().aqk.userId) {
                        b.this.fxG = guardClubInfoHttpResponseMessage;
                        if (b.this.fxG.aJa && com.baidu.live.guardclub.e.Aq() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Aq().ac(b.this.btg().fFh.DM().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fya = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ax) {
                b.this.a((ax) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fyb = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.o(b.this.btg().fFh.DM());
        }
    };
    private CustomMessageListener fyc = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fxw != null) {
                b.this.fxw.Ay();
            }
        }
    };
    private CustomMessageListener fyd = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.fxo != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.fxo).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fye = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bsK();
        }
    };
    private View.OnTouchListener fyf = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bsU();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(z zVar);

    protected abstract void b(z zVar);

    public abstract boolean brI();

    protected abstract void bsd();

    protected abstract View bsn();

    public abstract boolean bso();

    protected abstract boolean bsp();

    protected abstract ViewGroup bsq();

    protected abstract ViewGroup bsr();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(at atVar) {
        this.fxx = atVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fxz = (RelativeLayout) btg().fFi.findViewById(a.g.ala_live_header_view);
        this.fxA = (RelativeLayout) btg().fFi.findViewById(a.g.ala_live_footer_view);
        xQ();
        registerListener();
    }

    public void bsw() {
    }

    private void xQ() {
        if (this.fwQ == null) {
            this.fwQ = new com.baidu.tieba.ala.liveroom.share.c(btg().pageContext);
        }
        this.fwX = new com.baidu.tieba.ala.liveroom.v.a(btg().pageContext, this);
        this.fwU = new com.baidu.tieba.ala.liveroom.b.b(btg().pageContext, false);
        this.fwV = new com.baidu.tieba.ala.liveroom.praise.a(btg().pageContext);
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
                this.fwW = new com.baidu.tieba.ala.liveroom.guide.d(btg().pageContext);
            }
        }
        this.fxf = new com.baidu.tieba.ala.liveroom.tippop.a(btg().pageContext, this);
        bsx();
        bsz();
        bsA();
        bsB();
        bsE();
        bsF();
        bsG();
        bsH();
    }

    private void bsx() {
        this.fxa = new o();
    }

    public void jX(boolean z) {
        this.fxC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsy() {
        n DM = btg().fFh.DM();
        boolean z = com.baidu.live.v.a.En().aQu.atx;
        if (DM.mLiveInfo != null && DM.mLiveInfo.mAlaLiveSwitchData != null && DM.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = DM.aqO ? z : false;
        if (z2) {
            if (this.fwP == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, btg().pageContext);
                if (runTask != null) {
                    this.fwP = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.fwP != null) {
                this.fwP.ck(1);
                View view = this.fwP.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(btg().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(btg().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.fxz.addView(view, layoutParams);
                    if (z2) {
                        this.fwP.a(DM);
                    }
                }
            }
        }
    }

    private void bsz() {
        this.fxg = new com.baidu.tieba.ala.liveroom.guideim.b(btg().pageContext);
        this.fxg.c(this.fxA, brI());
        this.fxg.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Bg() {
                return b.this.zz();
            }
        });
    }

    private void bsA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, btg().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fxh = (com.baidu.live.view.input.c) runTask.getData();
            this.fxh.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                @Override // com.baidu.live.view.input.c.a
                public void HH() {
                    b.this.qn(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void HI() {
                    b.this.ct(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Bg() {
                    return b.this.zz();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Cd() {
                    return b.this.bsD();
                }
            });
        }
    }

    private void bsB() {
        this.fxi = new com.baidu.tieba.ala.liveroom.k.a(this.fwN.pageContext);
        this.fxi.a(new a.InterfaceC0517a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0517a
            public boolean bti() {
                return b.this.bsp();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0517a
            public void onClose() {
                if (b.this.aPZ != null) {
                    b.this.aPZ.bF(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jY(boolean z) {
        if (this.fxg != null) {
            this.fxg.kw(z);
        }
        if (this.fxi != null) {
            this.fxi.kw(z);
        }
        fxM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bsC() {
        return fxM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bsD() {
        n DM;
        if (btg() == null || btg().fFh == null || (DM = btg().fFh.DM()) == null || DM.aqD == null) {
            return false;
        }
        String str = DM.aqD.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bsE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, btg().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fxk = (com.baidu.live.guardclub.k) runTask.getData();
            this.fxk.setOtherParams(Cq());
        }
    }

    private void bsF() {
        this.fxl = new com.baidu.tieba.ala.liveroom.f.a(btg().pageContext);
    }

    private void bsG() {
        this.fxq = new com.baidu.tieba.ala.liveroom.turntable.e(btg().pageContext.getPageActivity());
    }

    private void bsH() {
        this.fxs = new com.baidu.tieba.ala.liveroom.n.c(btg().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fxU);
        MessageManager.getInstance().registerListener(this.fxV);
        MessageManager.getInstance().registerListener(this.fxX);
        MessageManager.getInstance().registerListener(this.fxQ);
        MessageManager.getInstance().registerListener(this.fxR);
        MessageManager.getInstance().registerListener(this.fxP);
        MessageManager.getInstance().registerListener(this.fxT);
        MessageManager.getInstance().registerListener(this.fxS);
        MessageManager.getInstance().registerListener(this.fxY);
        MessageManager.getInstance().registerListener(this.faq);
        MessageManager.getInstance().registerListener(this.fxZ);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fje);
        MessageManager.getInstance().registerListener(this.fjb);
        MessageManager.getInstance().registerListener(this.aNk);
        MessageManager.getInstance().registerListener(this.fya);
        MessageManager.getInstance().registerListener(this.fyb);
        MessageManager.getInstance().registerListener(this.fyc);
        MessageManager.getInstance().registerListener(this.fyd);
        MessageManager.getInstance().registerListener(this.fye);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zz() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(btg().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(btg().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.En().aQu.asW;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = btg().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = btg().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.btg().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(btg().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsI() {
        if (this.fxb != null) {
            this.fxb.Bf().a(this.fxh.BT(), com.baidu.live.gift.s.wU().wW());
            jY(true);
            if (this.fxt == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, w.class, btg().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.fxt = (w) runTask.getData();
                } else {
                    return;
                }
            }
            this.fxt.xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsJ() {
        if (this.fxb != null) {
            this.fxb.Bf().hide();
            jY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i, int i2, int i3) {
        if (btg().fFh.DM() != null && btg().fFh.DM().aqk != null && btg().fFh.DM().mLiveInfo != null) {
            a(btg().fFh.DM(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && zz()) {
            if (nVar == null) {
                nVar = btg().fFh.DM();
            }
            String valueOf = String.valueOf(nVar.aqk.userId);
            String str = nVar.aqk.userName;
            String valueOf2 = String.valueOf(nVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(nVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(nVar.mLiveInfo.feed_id);
            int i6 = nVar.aqD.isBlock;
            String xf = u.xf();
            String str2 = nVar.mLiveInfo.appId;
            boolean z2 = nVar.aqD.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (nVar.mLiveInfo.live_type == 1 && nVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.En().aQu.ase) {
                z3 = true;
            }
            int i7 = -1;
            if (nVar.aqD == null) {
                z = false;
            } else {
                boolean z4 = nVar.aqD.isNewUser;
                i7 = nVar.aqD.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.fxG != null && this.fxG.aIX != null && this.fxG.aIX.aps == nVar.aqk.userId) {
                z5 = this.fxG.aJa;
            }
            g gVar = new g(btg().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, xf, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.aN(nVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.aL(z);
            if (com.baidu.tieba.ala.liveroom.t.a.bzX().aQF != null) {
                gVar.aM(com.baidu.tieba.ala.liveroom.t.a.bzX().aQF.ara != 1);
            }
            ak At = com.baidu.live.guardclub.g.Ar().At();
            if (At == null || At.auW <= 0) {
                i5 = 1000;
            } else {
                i5 = At.auW;
            }
            gVar.bu(i5);
            boolean z6 = false;
            if (nVar != null && nVar.aqD != null) {
                String str3 = nVar.aqD.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.aO(z6);
            if (nVar != null && nVar.aqF != null) {
                gVar.dH(nVar.aqF.toJsonString());
            }
            if (!this.fxK) {
                this.fxL = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsK() {
        ct(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ax axVar) {
        if (axVar != null && zz()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(btg().pageContext.getPageActivity(), axVar.awi, axVar.liveId, axVar.awj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && com.baidu.live.v.a.En().aQu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(btg().pageContext.getPageActivity(), String.valueOf(nVar.mLiveInfo.live_id), String.valueOf(nVar.mLiveInfo.user_id), com.baidu.live.v.a.En().aQu.aty, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsL() {
        if (this.fxh != null) {
            this.fxh.c(this.fwN.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsM() {
        n DM = btg().fFh.DM();
        LogManager.getCommonLogger().doClickQuickImHiLog((DM == null || DM.mLiveInfo == null) ? "" : DM.mLiveInfo.feed_id, Cq());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AB(String str) {
        if (this.fxh != null) {
            this.fxh.em(str);
        }
    }

    private void bsN() {
        if ("home_rec_play".equals(btg().fromType) || "frs_play".equals(btg().fromType) || "frs_live_play".equals(btg().fromType) || "person_play".equals(btg().fromType) || "search".equals(btg().fromType) || "person_attention".equals(btg().fromType)) {
            com.baidu.live.b.tF().aJ(true);
        } else {
            com.baidu.live.b.tF().aJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jU(boolean z) {
        View wH;
        if (this.fxd == null) {
            f fVar = new f();
            fVar.ayo = false;
            fVar.context = btg().pageContext.getPageActivity();
            fVar.ayw = z;
            fVar.fromType = btg().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, v.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxd = (v) runTask.getData();
            }
        }
        if (this.fxd != null && (wH = this.fxd.wH()) != null && this.fwN.fFi.indexOfChild(wH) < 0) {
            this.fwN.fFi.addView(wH, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsO() {
        View xj;
        if (this.fxo == null) {
            aa aaVar = new aa();
            aaVar.ayo = false;
            aaVar.pageContext = btg().pageContext;
            aaVar.fromType = btg().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, x.class, aaVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxo = (x) runTask.getData();
            }
        }
        if (this.fxo != null && (xj = this.fxo.xj()) != null && btg().fFi.indexOfChild(xj) < 0) {
            if (xj.getParent() instanceof ViewGroup) {
                ((ViewGroup) xj.getParent()).removeView(xj);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            btg().fFi.addView(xj, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsP() {
        View wZ;
        if (this.fxe == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.ayo = false;
            aVar.context = btg().pageContext.getPageActivity();
            aVar.fromType = btg().fromType;
            aVar.ayp = btg().fFm;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, t.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxe = (t) runTask.getData();
            }
        }
        if (this.fxe != null && (wZ = this.fxe.wZ()) != null && btg().fFi.indexOfChild(wZ) < 0) {
            if (wZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) wZ.getParent()).removeView(wZ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            btg().fFi.addView(wZ, layoutParams);
        }
    }

    private void bsQ() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsR() {
        CustomResponsedMessage runTask;
        if (this.fxc == null && (runTask = MessageManager.getInstance().runTask(2913099, l.class, btg().pageContext)) != null) {
            this.fxc = (l) runTask.getData();
        }
        if (this.fxc != null) {
            this.fxc.setOtherParams(this.otherParams);
            this.fxc.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.l.a
                public void Bn() {
                    b.this.bsU();
                }
            });
            this.fxc.a(btg().fFh.DM(), false);
            View Bl = this.fxc.Bl();
            if (Bl != null && this.fxA.indexOfChild(Bl) < 0) {
                Resources resources = btg().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(btg().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.fxA.addView(Bl, layoutParams);
            }
        }
    }

    private void bsS() {
        if (this.fwZ == null) {
            this.fwZ = new com.baidu.tieba.ala.liveroom.g.a(btg().pageContext);
        }
        if (this.fxF != null) {
            this.fwZ.AF(this.fxF.user_id);
        }
        this.fwZ.ah(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jZ(boolean z) {
        CustomResponsedMessage runTask;
        if (btg() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, btg().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxw = (com.baidu.live.i.a) runTask.getData();
            this.fxw.a(bsr(), bsZ());
            if (btg().fFh != null) {
                this.fxw.a(btg().fFh.DM());
            }
            this.fxw.setCanVisible(!z);
            this.fxw.bs(true);
            this.fxw.a(btg().fFh.bnp());
        }
    }

    private void bsT() {
        if (this.fxm == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, btg().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxm = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (btg().fFh.DM() != null && btg().fFh.DM().aqk != null && btg().fFh.DM().mLiveInfo != null) {
            this.fxm.setHost(false);
            this.fxm.setOtherParams(Cq());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = btg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.fxm.a(this.fxz, layoutParams, btg().fFh.DM());
            this.fxm.a(new com.baidu.live.guardclub.l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void Ax() {
                    b.this.bth();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x05c3, code lost:
        Ax(r32);
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
                    if (this.aPZ != null) {
                        this.aPZ.bH(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        qp(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btg().fFh.DM().aqD.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btg().fFh.DM().aqD.isAdmin = 0;
                            btg().fFh.bzc();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        btg().fFh.DM().aqD.isAdmin = 0;
                        btg().fFh.bzc();
                    }
                } else if ("task".equals(optString2)) {
                    cO(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.fxf != null && !btg().fFl) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = btg().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = btg().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = btg().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (boF()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.fxf.a(btg().fFg.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.aPZ != null) {
                                b.this.aPZ.bG(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && btg().fFh.DM() != null && btg().fFh.DM().mLiveInfo != null) {
                        String str2 = btg().fFh.DM().mLiveInfo.feed_id;
                        long j4 = btg().fFh.DM().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!m.h(j4, optLong2)) {
                            com.baidu.live.utils.o.g(str2, j4);
                            m.i(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.q.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (btg().fFh.DM() != null && btg().fFh.DM().aqD != null && btg().fFh.DM().aqD.userId == optLong3) {
                        btg().fFh.DM().aqD.isBlock = 1;
                        bsd();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (btg().fFh.DM() != null && btg().fFh.DM().aqD != null && btg().fFh.DM().aqD.userId == optLong4) {
                        btg().fFh.DM().aqD.isBlock = 0;
                        bsd();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (btg().fFh.DM() != null && btg().fFh.DM().aqD != null && btg().fFh.DM().aqD.userId == optLong5) {
                        btg().fFh.DM().aqD.isUegBlock = 1;
                        bsd();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (btg().fFh.DM() != null && btg().fFh.DM().aqD != null && btg().fFh.DM().aqD.userId == optLong6) {
                        btg().fFh.DM().aqD.isUegBlock = 0;
                        bsd();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (btg() != null && btg().fFh != null && btg().fFh.DM() != null && btg().fFh.DM().aqD != null) {
                        if (btg().fFh.DM().aqD.userId == jSONObject2.optLong("user_id")) {
                            btg().fFh.bzc();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, btg().fFh.DM().aqD));
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
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.fwX != null) {
                this.fwX.z(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Ce = aVar.Ce();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong8 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (btg().fFh == null || btg().fFh.DM() == null || btg().fFh.DM().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = btg().fFh.DM().mLiveInfo.live_id;
                long j6 = btg().fFh.DM().mLiveInfo.group_id;
                long j7 = btg().fFh.DM().aqk.userId;
                str4 = btg().fFh.DM().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    u.b(optString9, Ce.userId, Ce.portrait, Ce.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.Eu().eQ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                u.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Ce.userId, Ce.portrait, Ce.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId());
                Ax(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.fEF = optLong8;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void Ax(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsU() {
        if (bsV()) {
            BdUtilHelper.hideSoftKeyPad(btg().pageContext.getPageActivity(), btg().fFg.getLiveContainerView());
            bso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsV() {
        if (bsn() == null || bsn().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(n nVar) {
        CustomResponsedMessage runTask;
        btg().fFi.setOnTouchListener(this.fyf);
        bta();
        btb();
        bsQ();
        bsS();
        bsT();
        if (this.fxa != null) {
            this.fxa.g(btg().fFh.DM());
        }
        if (this.fxg != null) {
            this.fxg.c(btg().fFh.DM(), Cq());
        }
        if (this.fxh != null) {
            this.fxh.a(btg().fFh.DM(), Cq());
        }
        if (this.fxi != null) {
            this.fxi.c(btg().fFh.DM(), Cq());
        }
        if (btg().fFi != null) {
            btg().fFi.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bsV() && b.this.fwV != null) {
                        b.this.fwV.kQ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.fwV != null) {
                        b.this.fwV.kQ(true);
                    }
                    return false;
                }
            });
        }
        if (this.fxt == null && (runTask = MessageManager.getInstance().runTask(2913165, w.class, btg().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxt = (w) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsW() {
        if (this.fxv == null && this.fxx != null && this.fxx.avM && btg() != null && btg().fFh != null && btg().fFh.DM() != null) {
            this.fxv = new com.baidu.tieba.ala.liveroom.g.e(btg().pageContext, this.fxx);
            this.fxv.q(btg().fFh.DM());
            if (this.fxx.avP == 1) {
                if (this.fxb != null) {
                    this.fxI = true;
                }
            } else if (this.fxx.avP == 2) {
                a(btg().fFh.DM(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsX() {
        CustomResponsedMessage runTask;
        if (btg() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, btg().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fxy = (com.baidu.live.q.a) runTask.getData();
            this.fxy.a(bsq(), bsY());
            if (btg().fFh != null) {
                this.fxJ = this.fxy.m(btg().fFh.DM());
            }
            this.fxy.setCanVisible(!this.fxD);
        }
    }

    private ViewGroup.LayoutParams bsY() {
        int dimensionPixelOffset;
        if (brI()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = btg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = btg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams bsZ() {
        int dimensionPixelOffset;
        if (brI()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = btg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = btg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ka(boolean z) {
        Rect rect = new Rect();
        btg().fFg.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(btg().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(btg().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = btg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + btg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bta() {
        if (this.fwV != null) {
            this.fwV.an(btg().fFi);
        }
    }

    private void btb() {
        if (this.fwY == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.fwY = (com.baidu.live.x.a) runTask.getData();
            }
            btc();
        }
    }

    private void cO(JSONObject jSONObject) {
        if (this.fwY != null) {
            if (this.fwS != null) {
                this.fwY.bO(this.fwS.bvO() ? false : true);
            } else {
                this.fwY.bO(true);
            }
            this.fwY.B(jSONObject);
        }
    }

    private void btc() {
        if (this.fwY != null && btg().fFh.DM() != null && btg().fFh.DM().aqN != null) {
            if (this.fwS != null) {
                this.fwY.bO(this.fwS.bvO() ? false : true);
            } else {
                this.fwY.bO(true);
            }
            this.fwY.a(btg().fFh.DM().aqN);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(n nVar) {
        if (nVar != null) {
            btc();
            if (this.fwZ != null && nVar.aqk != null) {
                this.fwZ.AF(String.valueOf(nVar.aqk.userId));
            }
            if (this.fwP != null) {
                this.fwP.a(nVar);
            }
            if (this.fxe != null && nVar.mLiveInfo != null) {
                this.fxe.a(nVar.mLiveInfo);
            }
            if (this.fxc != null) {
                this.fxc.a(nVar);
            }
            if (this.fxy != null) {
                this.fxJ = this.fxy.m(nVar);
            }
            if (this.fxw != null) {
                this.fxw.a(nVar);
            }
            qp(nVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void qp(int i) {
        if (!btg().fFl) {
            if (this.fxB < 0 && i == 0) {
                this.fxB = i;
            } else if (this.fxB != i) {
                if (i == 1) {
                    if (!this.fxf.qX(2)) {
                        String string = btg().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(btg().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.fxf.a(btg().fFg.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = btg().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.fxf.qY(2);
                    this.fxf.qY(3);
                    if (boF()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.fxf.a(btg().fFg.getLiveContainerView(), string2, 3);
                    }
                }
                this.fxB = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bJ(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bJ(z);
        if (z) {
            btd();
        }
        if (this.fwX != null) {
            this.fwX.bBd();
        }
        if (this.fwQ != null) {
            this.fwQ.uf();
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
        }
        if (this.fwY != null) {
            this.fwY.onDestroy();
            this.fwY = null;
        }
        if (this.fxd != null) {
            View wH = this.fxd.wH();
            if (wH != null && wH.getParent() != null) {
                ((ViewGroup) wH.getParent()).removeView(wH);
            }
            this.fxd.onDestroy();
            this.fxd = null;
        }
        if (this.fxc != null) {
            this.fxc.a((l.a) null);
            this.fxc.AJ();
        }
        if (this.fwO != null) {
            this.fwO.uf();
        }
        if (this.fxf != null) {
            this.fxf.uf();
        }
        this.fxB = -1;
        if (this.fwZ != null) {
            this.fwZ.uf();
            this.fwZ.onDestroy();
        }
        if (this.fwT != null) {
            this.fwT.bBa();
        }
        if (this.fwU != null) {
            this.fwU.brC();
        }
        if (this.fxa != null) {
            this.fxa.xi();
        }
        if (this.fxg != null) {
            this.fxg.bvX();
        }
        if (this.fxh != null) {
            this.fxh.xi();
        }
        if (this.fxi != null) {
            this.fxi.onDestroy();
        }
        if (this.fxk != null) {
            this.fxk.onDestory();
        }
        if (this.fxn != null) {
            this.fxn.Av();
        }
        if (this.fxm != null) {
            this.fxm.Av();
        }
        if (this.fxv != null) {
            this.fxv.onDestroy();
        }
        if (this.fxq != null) {
            this.fxq.xi();
        }
        if (this.fxr != null) {
            this.fxr.xi();
        }
        if (this.fxt != null) {
            this.fxt.xi();
        }
        if (this.fwR != null) {
            this.fwR.onDestory();
        }
        if (this.fxy != null) {
            this.fxy.xi();
        }
        if (this.fxw != null) {
            this.fxw.Av();
        }
        if (this.fxs != null) {
            this.fxs.xi();
        }
        if (this.fxo != null) {
            this.fxo.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void btd() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = btg().fFi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = btg().fFi.getChildAt(i);
            if (childAt != this.fxz && childAt != this.fxA) {
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
        if (this.fxz != null) {
            this.fxz.removeAllViews();
        }
        if (this.fxA != null) {
            this.fxA.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, n nVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(n nVar) {
        View Bl;
        View wH;
        if (this.fxd != null && (wH = this.fxd.wH()) != null && wH.getParent() != null) {
            ((ViewGroup) wH.getParent()).removeView(wH);
        }
        if (this.fxc != null && (Bl = this.fxc.Bl()) != null && Bl.getParent() != null) {
            ((ViewGroup) Bl.getParent()).removeView(Bl);
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean DH() {
        if (this.fwW == null || !this.fwW.bvT()) {
            if (this.fwS == null || !this.fwS.aj(btg().fFg.getLiveContainerView())) {
                if (this.fwV != null) {
                    this.fwV.bpp();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.fxj != null && this.fxj.bvC()) {
                    this.fxj.bvL();
                    return false;
                } else if (this.fxi == null || !this.fxi.bvW()) {
                    bsN();
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
    public void bI(boolean z) {
        super.bI(z);
        if (this.fxu != null) {
            this.fxu.destroy();
        }
        if (this.fwY != null) {
            this.fwY.onDestroy();
            this.fwY = null;
        }
        if (this.fwX != null) {
            this.fwX.bBd();
        }
        if (this.fxd != null) {
            this.fxd.onDestroy();
            this.fxd = null;
        }
        if (this.fxe != null) {
            this.fxe.onDestroy();
            this.fxe = null;
        }
        if (this.fxf != null) {
            this.fxf.onDestroy();
        }
        if (this.fwO != null) {
            this.fwO.onDestroy();
        }
        if (this.fwQ != null) {
            this.fwQ.onDestroy();
        }
        if (this.fxo != null) {
            this.fxo.onDestroy();
            this.fxo = null;
        }
        if (this.fxc != null) {
            this.fxc.a((l.a) null);
            this.fxc.release();
            this.fxc = null;
        }
        if (this.fxa != null) {
            this.fxa.release();
        }
        if (this.fxg != null) {
            this.fxg.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.fxg.release();
        }
        if (this.fxh != null) {
            this.fxh.a(null);
            this.fxh.release();
        }
        if (this.fxi != null) {
            this.fxi.a((a.InterfaceC0517a) null);
            this.fxi.onDestroy();
        }
        if (this.fxm != null) {
            this.fxm.onDestroy();
        }
        if (this.fxn != null) {
            this.fxn.onDestroy();
        }
        if (this.fxk != null) {
            this.fxk.onDestory();
        }
        if (this.fxv != null) {
            this.fxv.onDestroy();
        }
        if (this.fxl != null) {
            this.fxl.release();
        }
        if (this.fxq != null) {
            this.fxq.release();
        }
        if (this.fxs != null) {
            this.fxs.release();
        }
        if (this.fxr != null) {
            this.fxr.release();
        }
        if (this.fxt != null) {
            this.fxt.release();
        }
        if (this.fwR != null) {
            this.fwR.onDestory();
        }
        if (this.fxy != null) {
            this.fxy.release();
        }
        if (this.fxw != null) {
            this.fxw.onDestroy();
        }
        if (this.fwV != null) {
            this.fwV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fye);
        MessageManager.getInstance().unRegisterListener(this.fxU);
        MessageManager.getInstance().unRegisterListener(this.fxV);
        MessageManager.getInstance().unRegisterListener(this.fxX);
        MessageManager.getInstance().unRegisterListener(this.fxQ);
        MessageManager.getInstance().unRegisterListener(this.fxR);
        MessageManager.getInstance().unRegisterListener(this.fxP);
        MessageManager.getInstance().unRegisterListener(this.fxT);
        MessageManager.getInstance().unRegisterListener(this.fxS);
        MessageManager.getInstance().unRegisterListener(this.fxY);
        MessageManager.getInstance().unRegisterListener(this.faq);
        MessageManager.getInstance().unRegisterListener(this.fxZ);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fje);
        MessageManager.getInstance().unRegisterListener(this.fjb);
        MessageManager.getInstance().unRegisterListener(this.aNk);
        MessageManager.getInstance().unRegisterListener(this.fya);
        MessageManager.getInstance().unRegisterListener(this.fyb);
        MessageManager.getInstance().unRegisterListener(this.fyc);
        MessageManager.getInstance().unRegisterListener(this.fyd);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.fxg != null) {
            this.fxg.kv(false);
        }
        if (this.fxi != null) {
            this.fxi.kv(false);
        }
        bso();
        if (this.fxl != null) {
            this.fxl.pause();
        }
        if (this.fxq != null) {
            this.fxq.pause();
        }
        if (this.fxs != null) {
            this.fxs.pause();
        }
        if (this.fxo != null) {
            this.fxo.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.fxL = false;
        if (this.fxE && this.fxF != null) {
            a(this.fxF);
            this.fxE = false;
        }
        if (this.fxg != null) {
            this.fxg.kv(true);
        }
        if (this.fxi != null) {
            this.fxi.kv(true);
        }
        if (this.fxl != null) {
            this.fxl.resume();
        }
        if (this.fxq != null) {
            this.fxq.resume();
        }
        if (this.fxs != null) {
            this.fxs.resume();
        }
        if (this.fxo != null) {
            this.fxo.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bte() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bte();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, -1, -1);
                    return;
                }
                return;
            }
            bte();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bte();
        } else if (i == 25034) {
            bsK();
        } else if (i == 25043) {
            if (i2 == -1) {
                bth();
            }
        } else if (i == 25050 && this.fxu != null) {
            if (i2 == -1) {
                this.fxu.Q(intent);
            } else {
                this.fxu.Q(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.fxD = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean btf() {
        return (btg().fFh.DM() == null || btg().fFh.DM().mLiveInfo == null || btg().fFh.DM().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.fwS != null) {
                this.fwS.bm(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.fxi != null) {
            this.fxi.aHo();
        }
        if (this.fwR != null) {
            this.fwR.aHo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.fwN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a btg() {
        return this.fwN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bth() {
        String As = com.baidu.live.guardclub.g.Ar().As();
        if (!TextUtils.isEmpty(As)) {
            try {
                M(-1, Integer.parseInt(As), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                M(-1, -1, -1);
            }
        }
    }

    public boolean cr(int i) {
        if (7 == i) {
            if (this.fxd != null) {
                this.fxd.aW(true);
            }
            if (this.fwO != null) {
                this.fwO.brD();
            }
        } else if (1 == i) {
            if (bsn() != null) {
                bsn().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.fxD) {
                return false;
            }
            if (this.fwS == null || !this.fwS.bvO()) {
                return this.fwO == null || this.fwO.brF();
            }
            return false;
        } else if (3 == i) {
            if (btg().fFi != null) {
                btg().fFi.setEnabled(false);
                if (this.aPZ != null) {
                    this.aPZ.e(!btg().fFj, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.fwO == null || !this.fwO.isShowing();
        }
        return true;
    }

    public void qn(int i) {
        if ((i == 7 || i == 11) && this.fwO != null) {
            this.fwO.brD();
            this.fwO.jS(false);
        }
    }

    public void cs(int i) {
    }

    public void ct(int i) {
        if (7 == i) {
            if (this.fxd != null) {
                this.fxd.aW(false);
            }
            if (this.fwO != null) {
                this.fwO.jS(true);
            }
        } else if (11 == i) {
            if (this.fwO != null) {
                this.fwO.jS(true);
            }
        } else if (3 == i) {
            btg().fFi.setEnabled(true);
            if (this.aPZ != null) {
                this.aPZ.e(btg().fFj ? false : true, true);
            }
            if (this.fwY != null) {
                this.fwY.bO(true);
            }
        } else if (2 == i && this.fwX != null) {
            this.fwX.kX(true);
        }
    }

    public String Cq() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fxc != null) {
            this.fxc.setOtherParams(str);
        }
    }

    private boolean boF() {
        return btg().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
