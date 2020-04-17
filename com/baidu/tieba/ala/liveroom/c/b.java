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
    public static boolean fxH;
    private com.baidu.tieba.ala.liveroom.data.a fwI;
    private com.baidu.tieba.ala.liveroom.attentionpop.a fwJ;
    protected com.baidu.live.h.a fwK;
    protected com.baidu.tieba.ala.liveroom.share.c fwL;
    protected com.baidu.tieba.ala.liveroom.o.b fwM;
    protected com.baidu.tieba.ala.liveroom.guide.c fwN;
    protected com.baidu.tieba.ala.liveroom.watermark.a fwO;
    protected com.baidu.tieba.ala.liveroom.b.b fwP;
    protected com.baidu.tieba.ala.liveroom.praise.a fwQ;
    protected com.baidu.tieba.ala.liveroom.guide.d fwR;
    protected com.baidu.tieba.ala.liveroom.v.a fwS;
    protected com.baidu.live.x.a fwT;
    private com.baidu.tieba.ala.liveroom.g.a fwU;
    private o fwV;
    k fwW;
    l fwX;
    protected v fwY;
    protected t fwZ;
    protected z fxA;
    protected GuardClubInfoHttpResponseMessage fxB;
    boolean fxC;
    boolean fxD;
    boolean fxE;
    public boolean fxF;
    public boolean fxG;
    protected com.baidu.tieba.ala.liveroom.q.b fxI;
    protected e fxJ;
    protected com.baidu.tieba.ala.liveroom.tippop.a fxa;
    private com.baidu.tieba.ala.liveroom.guideim.b fxb;
    protected com.baidu.live.view.input.c fxc;
    com.baidu.tieba.ala.liveroom.k.a fxd;
    protected com.baidu.tieba.ala.liveroom.guide.a fxe;
    private com.baidu.live.guardclub.k fxf;
    protected com.baidu.tieba.ala.liveroom.f.a fxg;
    protected h fxh;
    protected j fxi;
    protected x fxj;
    protected com.baidu.tieba.ala.liveroom.turntable.e fxl;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b fxm;
    protected com.baidu.tieba.ala.liveroom.n.c fxn;
    private w fxo;
    protected com.baidu.tieba.ala.liveroom.s.a fxp;
    protected com.baidu.tieba.ala.liveroom.g.e fxq;
    protected com.baidu.live.i.a fxr;
    protected at fxs;
    protected com.baidu.live.q.a fxt;
    protected RelativeLayout fxu;
    protected RelativeLayout fxv;
    protected boolean fxx;
    protected String otherParams;
    private int fxk = 0;
    private int fxw = -1;
    protected int mOrientation = 0;
    protected boolean fxy = false;
    protected boolean fxz = false;
    private CustomMessageListener fxK = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            s sVar;
            if ((customResponsedMessage.getData() instanceof s) && (sVar = (s) customResponsedMessage.getData()) != null) {
                b.this.a(sVar.aqQ, sVar.aqM, sVar.aqN, sVar.aqO, sVar.aqP);
            }
        }
    };
    private CustomMessageListener fxL = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bti().fFc.DN().aqe.userId);
            com.baidu.live.view.a.Ht().a(valueOf, new com.baidu.live.data.b(b.this.bti().fFc.DN().aqe.portrait, valueOf, true, b.this.bti().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener fxM = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof n) && b.this.fwL != null) {
                b.this.fwL.c((n) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener aNe = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fwW != null) {
                b.this.fwW.e(com.baidu.live.gift.s.wV().wX());
            }
        }
    };
    private CustomMessageListener fxN = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.fwI.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Ax(str);
            }
        }
    };
    private CustomMessageListener fxO = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bti().pageContext.getPageActivity());
            } else if (b.this.fwL != null) {
                b.this.fwL.c(b.this.bti().fFc.DN(), false);
            }
        }
    };
    private CustomMessageListener fxP = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof z) {
                    b.this.fxz = true;
                    b.this.fxA = (z) data;
                    b.this.b(b.this.fxA);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.f((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener fxQ = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bti().fFc.DN().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bti().fFc.DN().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bti().fFc.DN().aqe.userId);
                    if (b.this.fwM == null) {
                        b.this.fwM = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    b.this.fwM.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.fwM.a(b.this.fxR);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.a fxR = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        @Override // com.baidu.live.n.b.a
        public void DZ() {
            if (b.this.bti().fFc.DN() != null && b.this.bti().fFc.DN().aqx != null) {
                b.this.bti().fFc.DN().aqx.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener fxS = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener fxT = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.qn(7);
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
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
    CustomMessageListener fxU = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.fxC = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fxd != null) {
                b.this.fxd.xl();
            }
        }
    };
    HttpMessageListener fiZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aIR) != null && b.this.fxf != null && b.this.bti() != null && b.this.bti().fFc != null) {
                int[] iArr = new int[2];
                b.this.fxu.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.fxf.a(b.this.fxu, layoutParams, aVar, b.this.bti().fFc.DN());
                com.baidu.live.l.a.af(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fiW = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bti() != null && b.this.bti().fFc != null && b.this.bti().fFc.DN() != null && guardClubInfoHttpResponseMessage.aIR != null) {
                    if (guardClubInfoHttpResponseMessage.aIR.apl == b.this.bti().fFc.DN().aqe.userId) {
                        b.this.fxB = guardClubInfoHttpResponseMessage;
                        if (b.this.fxB.aIU && com.baidu.live.guardclub.e.Ar() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Ar().ac(b.this.bti().fFc.DN().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fxV = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ax) {
                b.this.a((ax) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fxW = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.o(b.this.bti().fFc.DN());
        }
    };
    private CustomMessageListener fxX = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fxr != null) {
                b.this.fxr.Az();
            }
        }
    };
    private CustomMessageListener fxY = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.fxj != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) b.this.fxj).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fxZ = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bsM();
        }
    };
    private View.OnTouchListener fya = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bsW();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(z zVar);

    protected abstract void b(z zVar);

    public abstract boolean brK();

    protected abstract void bsf();

    protected abstract View bsp();

    public abstract boolean bsq();

    protected abstract boolean bsr();

    protected abstract ViewGroup bss();

    protected abstract ViewGroup bst();

    protected abstract void f(com.baidu.live.data.a aVar);

    public void a(at atVar) {
        this.fxs = atVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fxu = (RelativeLayout) bti().fFd.findViewById(a.g.ala_live_header_view);
        this.fxv = (RelativeLayout) bti().fFd.findViewById(a.g.ala_live_footer_view);
        xR();
        registerListener();
    }

    public void bsy() {
    }

    private void xR() {
        if (this.fwL == null) {
            this.fwL = new com.baidu.tieba.ala.liveroom.share.c(bti().pageContext);
        }
        this.fwS = new com.baidu.tieba.ala.liveroom.v.a(bti().pageContext, this);
        this.fwP = new com.baidu.tieba.ala.liveroom.b.b(bti().pageContext, false);
        this.fwQ = new com.baidu.tieba.ala.liveroom.praise.a(bti().pageContext);
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
                this.fwR = new com.baidu.tieba.ala.liveroom.guide.d(bti().pageContext);
            }
        }
        this.fxa = new com.baidu.tieba.ala.liveroom.tippop.a(bti().pageContext, this);
        bsz();
        bsB();
        bsC();
        bsD();
        bsG();
        bsH();
        bsI();
        bsJ();
    }

    private void bsz() {
        this.fwV = new o();
    }

    public void jX(boolean z) {
        this.fxx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsA() {
        n DN = bti().fFc.DN();
        boolean z = com.baidu.live.v.a.Eo().aQp.atr;
        if (DN.mLiveInfo != null && DN.mLiveInfo.mAlaLiveSwitchData != null && DN.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = DN.aqI ? z : false;
        if (z2) {
            if (this.fwK == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bti().pageContext);
                if (runTask != null) {
                    this.fwK = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.fwK != null) {
                this.fwK.ck(1);
                View view = this.fwK.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bti().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bti().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.fxu.addView(view, layoutParams);
                    if (z2) {
                        this.fwK.a(DN);
                    }
                }
            }
        }
    }

    private void bsB() {
        this.fxb = new com.baidu.tieba.ala.liveroom.guideim.b(bti().pageContext);
        this.fxb.c(this.fxv, brK());
        this.fxb.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Bh() {
                return b.this.zA();
            }
        });
    }

    private void bsC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bti().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fxc = (com.baidu.live.view.input.c) runTask.getData();
            this.fxc.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                @Override // com.baidu.live.view.input.c.a
                public void HI() {
                    b.this.qn(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void HJ() {
                    b.this.ct(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Bh() {
                    return b.this.zA();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Ce() {
                    return b.this.bsF();
                }
            });
        }
    }

    private void bsD() {
        this.fxd = new com.baidu.tieba.ala.liveroom.k.a(this.fwI.pageContext);
        this.fxd.a(new a.InterfaceC0496a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0496a
            public boolean btk() {
                return b.this.bsr();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0496a
            public void onClose() {
                if (b.this.aPT != null) {
                    b.this.aPT.bF(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jY(boolean z) {
        if (this.fxb != null) {
            this.fxb.kw(z);
        }
        if (this.fxd != null) {
            this.fxd.kw(z);
        }
        fxH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bsE() {
        return fxH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bsF() {
        n DN;
        if (bti() == null || bti().fFc == null || (DN = bti().fFc.DN()) == null || DN.aqx == null) {
            return false;
        }
        String str = DN.aqx.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    private void bsG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bti().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fxf = (com.baidu.live.guardclub.k) runTask.getData();
            this.fxf.setOtherParams(Cr());
        }
    }

    private void bsH() {
        this.fxg = new com.baidu.tieba.ala.liveroom.f.a(bti().pageContext);
    }

    private void bsI() {
        this.fxl = new com.baidu.tieba.ala.liveroom.turntable.e(bti().pageContext.getPageActivity());
    }

    private void bsJ() {
        this.fxn = new com.baidu.tieba.ala.liveroom.n.c(bti().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fxP);
        MessageManager.getInstance().registerListener(this.fxQ);
        MessageManager.getInstance().registerListener(this.fxS);
        MessageManager.getInstance().registerListener(this.fxL);
        MessageManager.getInstance().registerListener(this.fxM);
        MessageManager.getInstance().registerListener(this.fxK);
        MessageManager.getInstance().registerListener(this.fxO);
        MessageManager.getInstance().registerListener(this.fxN);
        MessageManager.getInstance().registerListener(this.fxT);
        MessageManager.getInstance().registerListener(this.fal);
        MessageManager.getInstance().registerListener(this.fxU);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fiZ);
        MessageManager.getInstance().registerListener(this.fiW);
        MessageManager.getInstance().registerListener(this.aNe);
        MessageManager.getInstance().registerListener(this.fxV);
        MessageManager.getInstance().registerListener(this.fxW);
        MessageManager.getInstance().registerListener(this.fxX);
        MessageManager.getInstance().registerListener(this.fxY);
        MessageManager.getInstance().registerListener(this.fxZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bti().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ax(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bti().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bti().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Eo().aQp.asQ;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bti().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bti().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bti().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bti().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsK() {
        if (this.fwW != null) {
            this.fwW.Bg().a(this.fxc.BU(), com.baidu.live.gift.s.wV().wX());
            jY(true);
            if (this.fxo == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, w.class, bti().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.fxo = (w) runTask.getData();
                } else {
                    return;
                }
            }
            this.fxo.xi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsL() {
        if (this.fwW != null) {
            this.fwW.Bg().hide();
            jY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i, int i2, int i3) {
        if (bti().fFc.DN() != null && bti().fFc.DN().aqe != null && bti().fFc.DN().mLiveInfo != null) {
            a(bti().fFc.DN(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(g.class) != null && zA()) {
            if (nVar == null) {
                nVar = bti().fFc.DN();
            }
            String valueOf = String.valueOf(nVar.aqe.userId);
            String str = nVar.aqe.userName;
            String valueOf2 = String.valueOf(nVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(nVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(nVar.mLiveInfo.feed_id);
            int i6 = nVar.aqx.isBlock;
            String xg = u.xg();
            String str2 = nVar.mLiveInfo.appId;
            boolean z2 = nVar.aqx.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (nVar.mLiveInfo.live_type == 1 && nVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.Eo().aQp.arY) {
                z3 = true;
            }
            int i7 = -1;
            if (nVar.aqx == null) {
                z = false;
            } else {
                boolean z4 = nVar.aqx.isNewUser;
                i7 = nVar.aqx.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.fxB != null && this.fxB.aIR != null && this.fxB.aIR.apl == nVar.aqe.userId) {
                z5 = this.fxB.aIU;
            }
            g gVar = new g(bti().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, xg, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.mAlaLiveSwitchData != null) {
                gVar.aN(nVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            gVar.aL(z);
            if (com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA != null) {
                gVar.aM(com.baidu.tieba.ala.liveroom.t.a.bzZ().aQA.aqU != 1);
            }
            ak Au = com.baidu.live.guardclub.g.As().Au();
            if (Au == null || Au.auQ <= 0) {
                i5 = 1000;
            } else {
                i5 = Au.auQ;
            }
            gVar.bu(i5);
            boolean z6 = false;
            if (nVar != null && nVar.aqx != null) {
                String str3 = nVar.aqx.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            gVar.aO(z6);
            if (nVar != null && nVar.aqz != null) {
                gVar.dH(nVar.aqz.toJsonString());
            }
            if (!this.fxF) {
                this.fxG = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsM() {
        ct(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ax axVar) {
        if (axVar != null && zA()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(bti().pageContext.getPageActivity(), axVar.awc, axVar.liveId, axVar.awd)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && com.baidu.live.v.a.Eo().aQp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bti().pageContext.getPageActivity(), String.valueOf(nVar.mLiveInfo.live_id), String.valueOf(nVar.mLiveInfo.user_id), com.baidu.live.v.a.Eo().aQp.ats, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsN() {
        if (this.fxc != null) {
            this.fxc.c(this.fwI.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsO() {
        n DN = bti().fFc.DN();
        LogManager.getCommonLogger().doClickQuickImHiLog((DN == null || DN.mLiveInfo == null) ? "" : DN.mLiveInfo.feed_id, Cr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ay(String str) {
        if (this.fxc != null) {
            this.fxc.em(str);
        }
    }

    private void bsP() {
        if ("home_rec_play".equals(bti().fromType) || "frs_play".equals(bti().fromType) || "frs_live_play".equals(bti().fromType) || "person_play".equals(bti().fromType) || "search".equals(bti().fromType) || "person_attention".equals(bti().fromType)) {
            com.baidu.live.b.tG().aJ(true);
        } else {
            com.baidu.live.b.tG().aJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jU(boolean z) {
        View wI;
        if (this.fwY == null) {
            f fVar = new f();
            fVar.ayi = false;
            fVar.context = bti().pageContext.getPageActivity();
            fVar.ayq = z;
            fVar.fromType = bti().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, v.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fwY = (v) runTask.getData();
            }
        }
        if (this.fwY != null && (wI = this.fwY.wI()) != null && this.fwI.fFd.indexOfChild(wI) < 0) {
            this.fwI.fFd.addView(wI, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsQ() {
        View xk;
        if (this.fxj == null) {
            aa aaVar = new aa();
            aaVar.ayi = false;
            aaVar.pageContext = bti().pageContext;
            aaVar.fromType = bti().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, x.class, aaVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxj = (x) runTask.getData();
            }
        }
        if (this.fxj != null && (xk = this.fxj.xk()) != null && bti().fFd.indexOfChild(xk) < 0) {
            if (xk.getParent() instanceof ViewGroup) {
                ((ViewGroup) xk.getParent()).removeView(xk);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bti().fFd.addView(xk, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsR() {
        View xa;
        if (this.fwZ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.ayi = false;
            aVar.context = bti().pageContext.getPageActivity();
            aVar.fromType = bti().fromType;
            aVar.ayj = bti().fFh;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, t.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fwZ = (t) runTask.getData();
            }
        }
        if (this.fwZ != null && (xa = this.fwZ.xa()) != null && bti().fFd.indexOfChild(xa) < 0) {
            if (xa.getParent() instanceof ViewGroup) {
                ((ViewGroup) xa.getParent()).removeView(xa);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds4);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bti().fFd.addView(xa, layoutParams);
        }
    }

    private void bsS() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsT() {
        CustomResponsedMessage runTask;
        if (this.fwX == null && (runTask = MessageManager.getInstance().runTask(2913099, l.class, bti().pageContext)) != null) {
            this.fwX = (l) runTask.getData();
        }
        if (this.fwX != null) {
            this.fwX.setOtherParams(this.otherParams);
            this.fwX.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
                @Override // com.baidu.live.im.l.a
                public void Bo() {
                    b.this.bsW();
                }
            });
            this.fwX.a(bti().fFc.DN(), false);
            View Bm = this.fwX.Bm();
            if (Bm != null && this.fxv.indexOfChild(Bm) < 0) {
                Resources resources = bti().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bti().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.fxv.addView(Bm, layoutParams);
            }
        }
    }

    private void bsU() {
        if (this.fwU == null) {
            this.fwU = new com.baidu.tieba.ala.liveroom.g.a(bti().pageContext);
        }
        if (this.fxA != null) {
            this.fwU.AC(this.fxA.user_id);
        }
        this.fwU.ah(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jZ(boolean z) {
        CustomResponsedMessage runTask;
        if (bti() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bti().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxr = (com.baidu.live.i.a) runTask.getData();
            this.fxr.a(bst(), btb());
            if (bti().fFc != null) {
                this.fxr.a(bti().fFc.DN());
            }
            this.fxr.setCanVisible(!z);
            this.fxr.bs(true);
            this.fxr.a(bti().fFc.bnr());
        }
    }

    private void bsV() {
        if (this.fxh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bti().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxh = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bti().fFc.DN() != null && bti().fFc.DN().aqe != null && bti().fFc.DN().mLiveInfo != null) {
            this.fxh.setHost(false);
            this.fxh.setOtherParams(Cr());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bti().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.fxh.a(this.fxu, layoutParams, bti().fFc.DN());
            this.fxh.a(new com.baidu.live.guardclub.l() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.guardclub.l
                public void Ay() {
                    b.this.btj();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x05c3, code lost:
        Au(r32);
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
                    if (this.aPT != null) {
                        this.aPT.bH(z);
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
                            bti().fFc.DN().aqx.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bti().fFc.DN().aqx.isAdmin = 0;
                            bti().fFc.bze();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bti().fFc.DN().aqx.isAdmin = 0;
                        bti().fFc.bze();
                    }
                } else if ("task".equals(optString2)) {
                    cO(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.fxa != null && !bti().fFg) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bti().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bti().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bti().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (boH()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.fxa.a(bti().fFb.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.aPT != null) {
                                b.this.aPT.bG(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bti().fFc.DN() != null && bti().fFc.DN().mLiveInfo != null) {
                        String str2 = bti().fFc.DN().mLiveInfo.feed_id;
                        long j4 = bti().fFc.DN().mLiveInfo.live_id;
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
                    if (bti().fFc.DN() != null && bti().fFc.DN().aqx != null && bti().fFc.DN().aqx.userId == optLong3) {
                        bti().fFc.DN().aqx.isBlock = 1;
                        bsf();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bti().fFc.DN() != null && bti().fFc.DN().aqx != null && bti().fFc.DN().aqx.userId == optLong4) {
                        bti().fFc.DN().aqx.isBlock = 0;
                        bsf();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bti().fFc.DN() != null && bti().fFc.DN().aqx != null && bti().fFc.DN().aqx.userId == optLong5) {
                        bti().fFc.DN().aqx.isUegBlock = 1;
                        bsf();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bti().fFc.DN() != null && bti().fFc.DN().aqx != null && bti().fFc.DN().aqx.userId == optLong6) {
                        bti().fFc.DN().aqx.isUegBlock = 0;
                        bsf();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bti() != null && bti().fFc != null && bti().fFc.DN() != null && bti().fFc.DN().aqx != null) {
                        if (bti().fFc.DN().aqx.userId == jSONObject2.optLong("user_id")) {
                            bti().fFc.bze();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bti().fFc.DN().aqx));
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
            if (this.fwS != null) {
                this.fwS.z(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Cf = aVar.Cf();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong8 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bti().fFc == null || bti().fFc.DN() == null || bti().fFc.DN().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bti().fFc.DN().mLiveInfo.live_id;
                long j6 = bti().fFc.DN().mLiveInfo.group_id;
                long j7 = bti().fFc.DN().aqe.userId;
                str4 = bti().fFc.DN().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    u.b(optString9, Cf.userId, Cf.portrait, Cf.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.Ev().eQ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                u.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Cf.userId, Cf.portrait, Cf.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId());
                Au(optString3);
            }
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.fEA = optLong8;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void Au(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bsW() {
        if (bsX()) {
            BdUtilHelper.hideSoftKeyPad(bti().pageContext.getPageActivity(), bti().fFb.getLiveContainerView());
            bsq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsX() {
        if (bsp() == null || bsp().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void k(n nVar) {
        CustomResponsedMessage runTask;
        bti().fFd.setOnTouchListener(this.fya);
        btc();
        btd();
        bsS();
        bsU();
        bsV();
        if (this.fwV != null) {
            this.fwV.g(bti().fFc.DN());
        }
        if (this.fxb != null) {
            this.fxb.c(bti().fFc.DN(), Cr());
        }
        if (this.fxc != null) {
            this.fxc.a(bti().fFc.DN(), Cr());
        }
        if (this.fxd != null) {
            this.fxd.c(bti().fFc.DN(), Cr());
        }
        if (bti().fFd != null) {
            bti().fFd.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.bsX() && b.this.fwQ != null) {
                        b.this.fwQ.kQ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.fwQ != null) {
                        b.this.fwQ.kQ(true);
                    }
                    return false;
                }
            });
        }
        if (this.fxo == null && (runTask = MessageManager.getInstance().runTask(2913165, w.class, bti().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxo = (w) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsY() {
        if (this.fxq == null && this.fxs != null && this.fxs.avG && bti() != null && bti().fFc != null && bti().fFc.DN() != null) {
            this.fxq = new com.baidu.tieba.ala.liveroom.g.e(bti().pageContext, this.fxs);
            this.fxq.q(bti().fFc.DN());
            if (this.fxs.avJ == 1) {
                if (this.fwW != null) {
                    this.fxD = true;
                }
            } else if (this.fxs.avJ == 2) {
                a(bti().fFc.DN(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bsZ() {
        CustomResponsedMessage runTask;
        if (bti() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bti().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fxt = (com.baidu.live.q.a) runTask.getData();
            this.fxt.a(bss(), bta());
            if (bti().fFc != null) {
                this.fxE = this.fxt.m(bti().fFc.DN());
            }
            this.fxt.setCanVisible(!this.fxy);
        }
    }

    private ViewGroup.LayoutParams bta() {
        int dimensionPixelOffset;
        if (brK()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bti().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bti().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams2.topMargin = dimensionPixelOffset;
        return layoutParams2;
    }

    private ViewGroup.LayoutParams btb() {
        int dimensionPixelOffset;
        if (brK()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bti().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bti().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ka(boolean z) {
        Rect rect = new Rect();
        bti().fFb.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bti().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bti().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = bti().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88);
        return dip2px + dimensionPixelOffset + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + bti().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void btc() {
        if (this.fwQ != null) {
            this.fwQ.an(bti().fFd);
        }
    }

    private void btd() {
        if (this.fwT == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.fwT = (com.baidu.live.x.a) runTask.getData();
            }
            bte();
        }
    }

    private void cO(JSONObject jSONObject) {
        if (this.fwT != null) {
            if (this.fwN != null) {
                this.fwT.bO(this.fwN.bvQ() ? false : true);
            } else {
                this.fwT.bO(true);
            }
            this.fwT.B(jSONObject);
        }
    }

    private void bte() {
        if (this.fwT != null && bti().fFc.DN() != null && bti().fFc.DN().aqH != null) {
            if (this.fwN != null) {
                this.fwT.bO(this.fwN.bvQ() ? false : true);
            } else {
                this.fwT.bO(true);
            }
            this.fwT.a(bti().fFc.DN().aqH);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void i(n nVar) {
        if (nVar != null) {
            bte();
            if (this.fwU != null && nVar.aqe != null) {
                this.fwU.AC(String.valueOf(nVar.aqe.userId));
            }
            if (this.fwK != null) {
                this.fwK.a(nVar);
            }
            if (this.fwZ != null && nVar.mLiveInfo != null) {
                this.fwZ.a(nVar.mLiveInfo);
            }
            if (this.fwX != null) {
                this.fwX.a(nVar);
            }
            if (this.fxt != null) {
                this.fxE = this.fxt.m(nVar);
            }
            if (this.fxr != null) {
                this.fxr.a(nVar);
            }
            qp(nVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void qp(int i) {
        if (!bti().fFg) {
            if (this.fxw < 0 && i == 0) {
                this.fxw = i;
            } else if (this.fxw != i) {
                if (i == 1) {
                    if (!this.fxa.qX(2)) {
                        String string = bti().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bti().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.fxa.a(bti().fFb.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bti().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.fxa.qY(2);
                    this.fxa.qY(3);
                    if (boH()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.fxa.a(bti().fFb.getLiveContainerView(), string2, 3);
                    }
                }
                this.fxw = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bJ(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bJ(z);
        if (z) {
            btf();
        }
        if (this.fwS != null) {
            this.fwS.bBf();
        }
        if (this.fwL != null) {
            this.fwL.ug();
        }
        if (this.fwN != null) {
            this.fwN.onDestroy();
        }
        if (this.fwT != null) {
            this.fwT.onDestroy();
            this.fwT = null;
        }
        if (this.fwY != null) {
            View wI = this.fwY.wI();
            if (wI != null && wI.getParent() != null) {
                ((ViewGroup) wI.getParent()).removeView(wI);
            }
            this.fwY.onDestroy();
            this.fwY = null;
        }
        if (this.fwX != null) {
            this.fwX.a((l.a) null);
            this.fwX.AK();
        }
        if (this.fwJ != null) {
            this.fwJ.ug();
        }
        if (this.fxa != null) {
            this.fxa.ug();
        }
        this.fxw = -1;
        if (this.fwU != null) {
            this.fwU.ug();
            this.fwU.onDestroy();
        }
        if (this.fwO != null) {
            this.fwO.bBc();
        }
        if (this.fwP != null) {
            this.fwP.brE();
        }
        if (this.fwV != null) {
            this.fwV.xj();
        }
        if (this.fxb != null) {
            this.fxb.bvZ();
        }
        if (this.fxc != null) {
            this.fxc.xj();
        }
        if (this.fxd != null) {
            this.fxd.onDestroy();
        }
        if (this.fxf != null) {
            this.fxf.onDestory();
        }
        if (this.fxi != null) {
            this.fxi.Aw();
        }
        if (this.fxh != null) {
            this.fxh.Aw();
        }
        if (this.fxq != null) {
            this.fxq.onDestroy();
        }
        if (this.fxl != null) {
            this.fxl.xj();
        }
        if (this.fxm != null) {
            this.fxm.xj();
        }
        if (this.fxo != null) {
            this.fxo.xj();
        }
        if (this.fwM != null) {
            this.fwM.onDestory();
        }
        if (this.fxt != null) {
            this.fxt.xj();
        }
        if (this.fxr != null) {
            this.fxr.Aw();
        }
        if (this.fxn != null) {
            this.fxn.xj();
        }
        if (this.fxj != null) {
            this.fxj.onDestroy();
        }
        ShowUtil.windowCount = 0;
    }

    private void btf() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bti().fFd.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bti().fFd.getChildAt(i);
            if (childAt != this.fxu && childAt != this.fxv) {
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
        if (this.fxu != null) {
            this.fxu.removeAllViews();
        }
        if (this.fxv != null) {
            this.fxv.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, n nVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(n nVar) {
        View Bm;
        View wI;
        if (this.fwY != null && (wI = this.fwY.wI()) != null && wI.getParent() != null) {
            ((ViewGroup) wI.getParent()).removeView(wI);
        }
        if (this.fwX != null && (Bm = this.fwX.Bm()) != null && Bm.getParent() != null) {
            ((ViewGroup) Bm.getParent()).removeView(Bm);
        }
        if (this.fwN != null) {
            this.fwN.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean DI() {
        if (this.fwR == null || !this.fwR.bvV()) {
            if (this.fwN == null || !this.fwN.aj(bti().fFb.getLiveContainerView())) {
                if (this.fwQ != null) {
                    this.fwQ.bpr();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.fxe != null && this.fxe.bvE()) {
                    this.fxe.bvN();
                    return false;
                } else if (this.fxd == null || !this.fxd.bvY()) {
                    bsP();
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
        if (this.fxp != null) {
            this.fxp.destroy();
        }
        if (this.fwT != null) {
            this.fwT.onDestroy();
            this.fwT = null;
        }
        if (this.fwS != null) {
            this.fwS.bBf();
        }
        if (this.fwY != null) {
            this.fwY.onDestroy();
            this.fwY = null;
        }
        if (this.fwZ != null) {
            this.fwZ.onDestroy();
            this.fwZ = null;
        }
        if (this.fxa != null) {
            this.fxa.onDestroy();
        }
        if (this.fwJ != null) {
            this.fwJ.onDestroy();
        }
        if (this.fwL != null) {
            this.fwL.onDestroy();
        }
        if (this.fxj != null) {
            this.fxj.onDestroy();
            this.fxj = null;
        }
        if (this.fwX != null) {
            this.fwX.a((l.a) null);
            this.fwX.release();
            this.fwX = null;
        }
        if (this.fwV != null) {
            this.fwV.release();
        }
        if (this.fxb != null) {
            this.fxb.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.fxb.release();
        }
        if (this.fxc != null) {
            this.fxc.a(null);
            this.fxc.release();
        }
        if (this.fxd != null) {
            this.fxd.a((a.InterfaceC0496a) null);
            this.fxd.onDestroy();
        }
        if (this.fxh != null) {
            this.fxh.onDestroy();
        }
        if (this.fxi != null) {
            this.fxi.onDestroy();
        }
        if (this.fxf != null) {
            this.fxf.onDestory();
        }
        if (this.fxq != null) {
            this.fxq.onDestroy();
        }
        if (this.fxg != null) {
            this.fxg.release();
        }
        if (this.fxl != null) {
            this.fxl.release();
        }
        if (this.fxn != null) {
            this.fxn.release();
        }
        if (this.fxm != null) {
            this.fxm.release();
        }
        if (this.fxo != null) {
            this.fxo.release();
        }
        if (this.fwM != null) {
            this.fwM.onDestory();
        }
        if (this.fxt != null) {
            this.fxt.release();
        }
        if (this.fxr != null) {
            this.fxr.onDestroy();
        }
        if (this.fwQ != null) {
            this.fwQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fxZ);
        MessageManager.getInstance().unRegisterListener(this.fxP);
        MessageManager.getInstance().unRegisterListener(this.fxQ);
        MessageManager.getInstance().unRegisterListener(this.fxS);
        MessageManager.getInstance().unRegisterListener(this.fxL);
        MessageManager.getInstance().unRegisterListener(this.fxM);
        MessageManager.getInstance().unRegisterListener(this.fxK);
        MessageManager.getInstance().unRegisterListener(this.fxO);
        MessageManager.getInstance().unRegisterListener(this.fxN);
        MessageManager.getInstance().unRegisterListener(this.fxT);
        MessageManager.getInstance().unRegisterListener(this.fal);
        MessageManager.getInstance().unRegisterListener(this.fxU);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fiZ);
        MessageManager.getInstance().unRegisterListener(this.fiW);
        MessageManager.getInstance().unRegisterListener(this.aNe);
        MessageManager.getInstance().unRegisterListener(this.fxV);
        MessageManager.getInstance().unRegisterListener(this.fxW);
        MessageManager.getInstance().unRegisterListener(this.fxX);
        MessageManager.getInstance().unRegisterListener(this.fxY);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.fxb != null) {
            this.fxb.kv(false);
        }
        if (this.fxd != null) {
            this.fxd.kv(false);
        }
        bsq();
        if (this.fxg != null) {
            this.fxg.pause();
        }
        if (this.fxl != null) {
            this.fxl.pause();
        }
        if (this.fxn != null) {
            this.fxn.pause();
        }
        if (this.fxj != null) {
            this.fxj.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.fxG = false;
        if (this.fxz && this.fxA != null) {
            a(this.fxA);
            this.fxz = false;
        }
        if (this.fxb != null) {
            this.fxb.kv(true);
        }
        if (this.fxd != null) {
            this.fxd.kv(true);
        }
        if (this.fxg != null) {
            this.fxg.resume();
        }
        if (this.fxl != null) {
            this.fxl.resume();
        }
        if (this.fxn != null) {
            this.fxn.resume();
        }
        if (this.fxj != null) {
            this.fxj.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btg() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            btg();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, -1, -1);
                    return;
                }
                return;
            }
            btg();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            btg();
        } else if (i == 25034) {
            bsM();
        } else if (i == 25043) {
            if (i2 == -1) {
                btj();
            }
        } else if (i == 25050 && this.fxp != null) {
            if (i2 == -1) {
                this.fxp.ad(intent);
            } else {
                this.fxp.ad(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.fxy = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bth() {
        return (bti().fFc.DN() == null || bti().fFc.DN().mLiveInfo == null || bti().fFc.DN().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.fwN != null) {
                this.fwN.bm(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.fxd != null) {
            this.fxd.aHq();
        }
        if (this.fwM != null) {
            this.fwM.aHq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.fwI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bti() {
        return this.fwI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btj() {
        String At = com.baidu.live.guardclub.g.As().At();
        if (!TextUtils.isEmpty(At)) {
            try {
                M(-1, Integer.parseInt(At), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                M(-1, -1, -1);
            }
        }
    }

    public boolean cr(int i) {
        if (7 == i) {
            if (this.fwY != null) {
                this.fwY.aW(true);
            }
            if (this.fwJ != null) {
                this.fwJ.brF();
            }
        } else if (1 == i) {
            if (bsp() != null) {
                bsp().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.fxy) {
                return false;
            }
            if (this.fwN == null || !this.fwN.bvQ()) {
                return this.fwJ == null || this.fwJ.brH();
            }
            return false;
        } else if (3 == i) {
            if (bti().fFd != null) {
                bti().fFd.setEnabled(false);
                if (this.aPT != null) {
                    this.aPT.e(!bti().fFe, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.fwJ == null || !this.fwJ.isShowing();
        }
        return true;
    }

    public void qn(int i) {
        if ((i == 7 || i == 11) && this.fwJ != null) {
            this.fwJ.brF();
            this.fwJ.jS(false);
        }
    }

    public void cs(int i) {
    }

    public void ct(int i) {
        if (7 == i) {
            if (this.fwY != null) {
                this.fwY.aW(false);
            }
            if (this.fwJ != null) {
                this.fwJ.jS(true);
            }
        } else if (11 == i) {
            if (this.fwJ != null) {
                this.fwJ.jS(true);
            }
        } else if (3 == i) {
            bti().fFd.setEnabled(true);
            if (this.aPT != null) {
                this.aPT.e(bti().fFe ? false : true, true);
            }
            if (this.fwT != null) {
                this.fwT.bO(true);
            }
        } else if (2 == i && this.fwS != null) {
            this.fwS.kX(true);
        }
    }

    public String Cr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fwX != null) {
            this.fwX.setOtherParams(str);
        }
    }

    private boolean boH() {
        return bti().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }
}
