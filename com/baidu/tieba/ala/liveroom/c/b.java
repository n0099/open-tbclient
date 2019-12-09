package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.data.s;
import com.baidu.live.data.z;
import com.baidu.live.g.b;
import com.baidu.live.gift.o;
import com.baidu.live.gift.p;
import com.baidu.live.gift.q;
import com.baidu.live.gift.r;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.guardclub.f;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.j.a;
import com.baidu.tieba.ala.liveroom.k.a;
import com.baidu.tieba.ala.liveroom.o.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class b implements com.baidu.tieba.ala.liveroom.b {
    private com.baidu.tieba.ala.liveroom.data.a dWC;
    protected e dWD;
    private com.baidu.tieba.ala.liveroom.attentionpop.a dWE;
    protected com.baidu.tieba.ala.liveroom.share.c dWF;
    protected com.baidu.tieba.ala.liveroom.n.b dWG;
    protected com.baidu.tieba.ala.liveroom.guide.a dWH;
    protected com.baidu.tieba.ala.liveroom.watermark.a dWI;
    protected com.baidu.tieba.ala.liveroom.b.b dWJ;
    protected com.baidu.tieba.ala.liveroom.praise.a dWK;
    protected com.baidu.tieba.ala.liveroom.guide.b dWL;
    protected com.baidu.tieba.ala.liveroom.s.a dWM;
    protected com.baidu.live.m.a dWN;
    private com.baidu.tieba.ala.liveroom.g.a dWO;
    private m dWP;
    i dWQ;
    j dWR;
    protected r dWS;
    protected p dWT;
    protected com.baidu.tieba.ala.liveroom.tippop.a dWU;
    private com.baidu.tieba.ala.liveroom.guideim.b dWV;
    protected com.baidu.tieba.ala.liveroom.o.a dWW;
    com.baidu.tieba.ala.liveroom.k.a dWX;
    private f dWY;
    protected com.baidu.tieba.ala.liveroom.f.a dWZ;
    protected com.baidu.tieba.ala.liveroom.j.a dXa;
    protected com.baidu.tieba.ala.liveroom.j.c dXb;
    protected com.baidu.tieba.ala.liveroom.turntable.e dXc;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b dXd;
    private com.baidu.live.gift.panel.a dXe;
    protected com.baidu.tieba.ala.liveroom.g.e dXf;
    protected com.baidu.tieba.ala.liveroom.data.i dXg;
    protected RelativeLayout dXh;
    protected RelativeLayout dXi;
    protected s dXm;
    protected GuardClubInfoHttpResponseMessage dXn;
    boolean dXo;
    boolean dXp;
    public boolean dXq;
    public boolean dXr;
    protected String otherParams;
    private int dXj = -1;
    protected int mOrientation = 0;
    protected boolean dXk = false;
    protected boolean dXl = false;
    protected Handler mHandler = new Handler();
    private CustomMessageListener dXs = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.m mVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.m) && (mVar = (com.baidu.live.data.m) customResponsedMessage.getData()) != null) {
                b.this.a(mVar.Pv, mVar.Ps, mVar.Pt, mVar.Pu);
            }
        }
    };
    private CustomMessageListener dXt = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.i) && b.this.dWF != null) {
                b.this.dWF.c((com.baidu.live.data.i) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener dXu = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dWQ != null) {
                b.this.dWQ.h(o.pI().pK());
            }
        }
    };
    private CustomMessageListener dXv = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.dWC.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.tx(str);
            }
        }
    };
    private CustomMessageListener dXw = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.aPu().pageContext.getPageActivity());
            }
            if (b.this.dWF != null) {
                b.this.dWF.c(b.this.aPu().eeL.uk(), false);
            }
        }
    };
    private CustomMessageListener dXx = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof s) {
                    b.this.dXl = true;
                    b.this.dXm = (s) data;
                    b.this.b(b.this.dXm);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.e((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener dXy = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.aPu().eeL.uk().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.aPu().eeL.uk().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.aPu().eeL.uk().OR.userId);
            if (b.this.dWG == null) {
                b.this.dWG = new com.baidu.tieba.ala.liveroom.n.b(b.this.aPu().pageContext);
            }
            b.this.dWG.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.dWG.a(b.this.dXz);
        }
    };
    private b.a dXz = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // com.baidu.live.g.b.a
        public void uv() {
            if (b.this.aPu().eeL.uk() != null && b.this.aPu().eeL.uk().Pj != null) {
                b.this.aPu().eeL.uk().Pj.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener dXA = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener dXB = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.nr(7);
        }
    };
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
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
    CustomMessageListener dXC = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dXo = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dWX != null) {
                b.this.dWX.aAk();
            }
        }
    };
    HttpMessageListener dKq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.guardclub.model.c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (cVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).dKm) != null && b.this.dWY != null && b.this.aPu() != null && b.this.aPu().eeL != null) {
                b.this.dWY.a(b.this.dXh, cVar, b.this.aPu().eeL.uk());
                com.baidu.live.f.a.N(cVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener dKp = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aPu() != null && b.this.aPu().eeL != null && b.this.aPu().eeL.uk() != null && guardClubInfoHttpResponseMessage.dKm != null) {
                    if (guardClubInfoHttpResponseMessage.dKm.Of == b.this.aPu().eeL.uk().OR.userId) {
                        b.this.dXn = guardClubInfoHttpResponseMessage;
                        if (b.this.dXn != null && b.this.dXn.dKS) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.tieba.ala.guardclub.a.bY(b.this.aPu().eeL.uk().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private View.OnTouchListener dXD = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.aPi();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(s sVar);

    protected abstract View aOH();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean aOI();

    protected abstract boolean aOJ();

    protected abstract boolean aOf();

    protected abstract void b(s sVar);

    protected abstract void e(com.baidu.live.data.a aVar);

    public void a(com.baidu.tieba.ala.liveroom.data.i iVar) {
        this.dXg = iVar;
    }

    public void init() {
        this.dXh = (RelativeLayout) aPu().eeM.findViewById(a.g.ala_live_header_view);
        this.dXi = (RelativeLayout) aPu().eeM.findViewById(a.g.ala_live_footer_view);
        qh();
        registerListener();
    }

    public void aOP() {
    }

    private void qh() {
        if (this.dWF == null) {
            this.dWF = new com.baidu.tieba.ala.liveroom.share.c(aPu().pageContext);
        }
        this.dWM = new com.baidu.tieba.ala.liveroom.s.a(aPu().pageContext, this);
        this.dWJ = new com.baidu.tieba.ala.liveroom.b.b(aPu().pageContext, false);
        this.dWK = new com.baidu.tieba.ala.liveroom.praise.a(aPu().pageContext);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            boolean z = TbadkCoreApplication.getInst().isHaokan() && subappVersionName.startsWith("4.14.");
            if (TbadkCoreApplication.getInst().isQuanmin() && subappVersionName.startsWith("1.14.")) {
                z = true;
            }
            if (TbadkCoreApplication.getInst().isTieba() ? false : z) {
                this.dWL = new com.baidu.tieba.ala.liveroom.guide.b(aPu().pageContext);
            }
        }
        this.dWU = new com.baidu.tieba.ala.liveroom.tippop.a(aPu().pageContext, this);
        aOQ();
        aOR();
        aOS();
        aOT();
        aOU();
        aOV();
        aOW();
    }

    private void aOQ() {
        this.dWP = new m();
    }

    private void aOR() {
        this.dWV = new com.baidu.tieba.ala.liveroom.guideim.b(aPu().pageContext);
        this.dWV.c(this.dXi, aOf());
        this.dWV.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.8
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean sG() {
                return b.this.rB();
            }
        });
    }

    private void aOS() {
        this.dWW = new com.baidu.tieba.ala.liveroom.o.a();
        this.dWW.a(new a.InterfaceC0362a() { // from class: com.baidu.tieba.ala.liveroom.c.b.9
            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0362a
            public void aPx() {
                b.this.nr(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0362a
            public void aPy() {
                b.this.nb(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0362a
            public boolean sG() {
                return b.this.rB();
            }
        });
    }

    private void aOT() {
        this.dWX = new com.baidu.tieba.ala.liveroom.k.a(this.dWC.pageContext);
        this.dWX.a(new a.InterfaceC0358a() { // from class: com.baidu.tieba.ala.liveroom.c.b.10
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0358a
            public boolean aPz() {
                return b.this.aOJ();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0358a
            public void onClose() {
                if (b.this.dWD != null) {
                    b.this.dWD.aPI();
                }
            }
        });
    }

    void ht(boolean z) {
        if (this.dWV != null) {
            this.dWV.hQ(z);
        }
        if (this.dWX != null) {
            this.dWX.hQ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hu(boolean z) {
        if (this.dWV != null) {
            this.dWV.hQ(z);
        }
        if (this.dWX != null) {
            this.dWX.hQ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hv(boolean z) {
        if (this.dWV != null) {
            this.dWV.hQ(z);
        }
        if (this.dWX != null) {
            this.dWX.hQ(z);
        }
    }

    private void aOU() {
        this.dWY = new f(aPu().pageContext);
        this.dWY.setOtherParams(tn());
    }

    private void aOV() {
        this.dWZ = new com.baidu.tieba.ala.liveroom.f.a(aPu().pageContext);
    }

    private void aOW() {
        this.dXc = new com.baidu.tieba.ala.liveroom.turntable.e(aPu().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dXx);
        MessageManager.getInstance().registerListener(this.dXy);
        MessageManager.getInstance().registerListener(this.dXA);
        MessageManager.getInstance().registerListener(this.dXt);
        MessageManager.getInstance().registerListener(this.dXs);
        MessageManager.getInstance().registerListener(this.dXw);
        MessageManager.getInstance().registerListener(this.dXv);
        MessageManager.getInstance().registerListener(this.dXB);
        MessageManager.getInstance().registerListener(this.dEz);
        MessageManager.getInstance().registerListener(this.dXC);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.dKq);
        MessageManager.getInstance().registerListener(this.dKp);
        MessageManager.getInstance().registerListener(this.dXu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean rB() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(aPu().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPu().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(aPu().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.l.a.uB().ajF.Rz;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = aPu().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = aPu().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.aPu().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(aPu().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOX() {
        if (this.dWQ != null) {
            this.dWQ.sF().a(this.dWW.aVE(), o.pI().pK());
            ht(true);
            if (this.dXe == null) {
                this.dXe = new com.baidu.live.gift.panel.a(aPu().pageContext.getPageActivity());
            }
            this.dXe.rs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOY() {
        if (this.dWQ != null) {
            this.dWQ.sF().hide();
            ht(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(int i, int i2, int i3) {
        if (aPu().eeL.uk() != null && aPu().eeL.uk().OR != null && aPu().eeL.uk().mLiveInfo != null) {
            a(aPu().eeL.uk(), i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.i iVar, int i, int i2, int i3) {
        boolean z;
        int i4;
        if (rB()) {
            if (iVar == null) {
                iVar = aPu().eeL.uk();
            }
            String valueOf = String.valueOf(iVar.OR.userId);
            String str = iVar.OR.userName;
            String valueOf2 = String.valueOf(iVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(iVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(iVar.mLiveInfo.feed_id);
            int i5 = iVar.Pj.isBlock;
            String rg = com.baidu.live.gift.b.b.rd().rg();
            String str2 = iVar.mLiveInfo.appId;
            boolean z2 = iVar.Pj.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (iVar.mLiveInfo.live_type == 1 && iVar.mLiveInfo.screen_direction == 1 && com.baidu.live.l.a.uB().ajF.Qz) {
                z3 = true;
            }
            int i6 = -1;
            if (iVar.Pj == null) {
                z = false;
            } else {
                boolean z4 = iVar.Pj.isNewUser;
                i6 = iVar.Pj.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.dXn != null && this.dXn.dKm != null && this.dXn.dKm.Of == iVar.OR.userId) {
                z5 = this.dXn.dKS;
            }
            com.baidu.live.b.e eVar = new com.baidu.live.b.e(aPu().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i5, rg, str2, z3, i, i2, i3, z2, i6, valueOf4, this.otherParams, z5);
            eVar.ac(z);
            z aLx = com.baidu.tieba.ala.guardclub.m.aLv().aLx();
            if (aLx == null || aLx.Tl <= 0) {
                i4 = 1000;
            } else {
                i4 = aLx.Tl;
            }
            eVar.aP(i4);
            if (!this.dXq) {
                this.dXr = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
            }
        }
    }

    private void aOZ() {
        nb(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPa() {
        if (this.dWW != null) {
            this.dWW.d(this.dWC.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPb() {
        com.baidu.live.data.i uk = aPu().eeL.uk();
        LogManager.getCommonLogger().doClickQuickImHiLog((uk == null || uk.mLiveInfo == null) ? "" : uk.mLiveInfo.feed_id, tn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ty(String str) {
        if (this.dWW != null) {
            this.dWW.cs(str);
        }
    }

    private void aPc() {
        if ("home_rec_play".equals(aPu().fromType) || "frs_play".equals(aPu().fromType) || "frs_live_play".equals(aPu().fromType) || "person_play".equals(aPu().fromType) || "search".equals(aPu().fromType) || "person_attention".equals(aPu().fromType)) {
            com.baidu.live.b.no().aa(true);
        } else {
            com.baidu.live.b.no().aa(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ho(boolean z) {
        View pA;
        if (this.dWS == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.VP = false;
            fVar.context = aPu().pageContext.getPageActivity();
            fVar.VV = z;
            fVar.fromType = aPu().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, r.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.dWS = (r) runTask.getData();
            }
        }
        if (this.dWS != null && (pA = this.dWS.pA()) != null && this.dWC.eeM.indexOfChild(pA) < 0) {
            this.dWC.eeM.addView(pA, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPd() {
        View pN;
        if (this.dWT == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.VP = false;
            aVar.context = aPu().pageContext.getPageActivity();
            aVar.fromType = aPu().fromType;
            aVar.VQ = aPu().eeR;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, p.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.dWT = (p) runTask.getData();
            }
        }
        if (this.dWT != null && (pN = this.dWT.pN()) != null && aPu().eeM.indexOfChild(pN) < 0) {
            if (pN.getParent() instanceof ViewGroup) {
                ((ViewGroup) pN.getParent()).removeView(pN);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = aPu().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            aPu().eeM.addView(pN, layoutParams);
        }
    }

    private void aPe() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPf() {
        if (this.dWR == null) {
            this.dWR = new com.baidu.tieba.ala.liveroom.d.a(aPu().pageContext);
        }
        this.dWR.setOtherParams(this.otherParams);
        this.dWR.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.14
            @Override // com.baidu.live.im.j.a
            public void sM() {
                b.this.aPi();
            }
        });
        this.dWR.a(aPu().eeL.uk(), false);
        View sK = this.dWR.sK();
        if (sK != null && this.dXi.indexOfChild(sK) < 0) {
            Resources resources = aPu().pageContext.getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPu().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
            this.dXi.addView(sK, layoutParams);
        }
    }

    private void aPg() {
        if (this.dWO == null) {
            this.dWO = new com.baidu.tieba.ala.liveroom.g.a(aPu().pageContext);
        }
        if (this.dXm != null) {
            this.dWO.tF(this.dXm.user_id);
        }
        this.dWO.Z(null);
    }

    private void aPh() {
        if (this.dXa == null) {
            this.dXa = new com.baidu.tieba.ala.liveroom.j.a(aPu().pageContext, false, tn());
        }
        if (aPu().eeL.uk() != null && aPu().eeL.uk().OR != null && aPu().eeL.uk().mLiveInfo != null) {
            this.dXa.c(this.dXh, aPu().eeL.uk());
            this.dXa.a(new a.InterfaceC0357a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
                @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0357a
                public void aPA() {
                    b.this.aPv();
                }
            });
        }
    }

    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        long j;
        long j2;
        long j3;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (aVar.getMsgType() == 12 || aVar.getMsgType() == 13) {
            if (jSONObject != null) {
                String optString = jSONObject.optString("content_type");
                if ("live_on_private".equals(optString)) {
                    boolean z = jSONObject.optInt("on_private", 0) == 1;
                    if (this.dWD != null) {
                        this.dWD.hE(z);
                    }
                    int optInt = jSONObject.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        nt(optInt);
                    }
                } else if ("live_admin".equals(optString)) {
                    long optLong = jSONObject.optLong("user_id");
                    int optInt2 = jSONObject.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPu().eeL.uk().Pj.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPu().eeL.uk().Pj.isAdmin = 0;
                            aPu().eeL.aUY();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        aPu().eeL.uk().Pj.isAdmin = 0;
                        aPu().eeL.aUY();
                    }
                } else if ("task".equals(optString)) {
                    bN(jSONObject);
                } else if ("live_net_status".equals(optString)) {
                    int optInt3 = jSONObject.optInt("net_status");
                    if (this.dWU != null && !aPu().eeQ) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = aPu().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = aPu().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = aPu().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (aPw()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.dWU.a(aPu().eeN, str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString)) {
                    final int optInt4 = jSONObject.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.dWD != null) {
                                b.this.dWD.hD(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString)) {
                    if (jSONObject.optInt("event_type") == 1001 && aPu().eeL.uk() != null && aPu().eeL.uk().mLiveInfo != null) {
                        String str2 = aPu().eeL.uk().mLiveInfo.feed_id;
                        long j4 = aPu().eeL.uk().mLiveInfo.live_id;
                        long optLong2 = jSONObject.optLong("id");
                        if (!l.g(j4, optLong2)) {
                            com.baidu.live.utils.m.i(str2, j4);
                            l.h(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject.optLong("user_id"))));
                } else if ("need_update_live_mark_info".equals(optString) && aPu() != null && aPu().eeL != null && aPu().eeL.uk() != null && aPu().eeL.uk().Pj != null && aPu().eeL.uk().Pj.userId == jSONObject.optLong("user_id")) {
                    aPu().eeL.aUY();
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.dWM != null) {
                this.dWM.u(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject != null) {
            com.baidu.live.data.a tf = aVar.tf();
            String optString2 = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            String optString3 = jSONObject.optString("gift_count");
            String optString4 = jSONObject.optString("gift_name");
            String optString5 = jSONObject.optString("gift_url");
            String optString6 = jSONObject.optString("attach");
            long optLong3 = jSONObject.optLong("charm_total");
            String str3 = null;
            if (aPu().eeL == null || aPu().eeL.uk() == null || aPu().eeL.uk().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = aPu().eeL.uk().mLiveInfo.live_id;
                long j6 = aPu().eeL.uk().mLiveInfo.group_id;
                long j7 = aPu().eeL.uk().OR.userId;
                str3 = aPu().eeL.uk().mLiveInfo.appId;
                j = j7;
                j2 = j6;
                j3 = j5;
            }
            q.b(optString2, JavaTypesHelper.toInt(optString3, 1), optString4, optString5, tf.userId, tf.portrait, tf.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str3, optString6);
            tv(optString2);
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.eeg = optLong3;
            dVar.liveId = j3;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void tv(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPi() {
        if (aPj()) {
            BdUtilHelper.hideSoftKeyPad(aPu().pageContext.getPageActivity(), aPu().eeN);
            aOI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPj() {
        if (aOH() == null || aOH().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uN() {
        aPu().eeM.setOnTouchListener(this.dXD);
        aPl();
        aPm();
        aPe();
        aPg();
        aPh();
        if (this.dWP != null) {
            this.dWP.f(aPu().eeL.uk());
        }
        if (this.dWV != null) {
            this.dWV.a(aPu().eeL.uk(), tn());
        }
        if (this.dWW != null) {
            this.dWW.a(aPu().eeL.uk(), tn());
        }
        if (this.dWX != null) {
            this.dWX.a(aPu().eeL.uk(), tn());
        }
        if (aPu().eeM != null) {
            aPu().eeM.setOnDispatchTouchEventListener(new AlaLiveView.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.aPj() && b.this.dWK != null) {
                        b.this.dWK.ig(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.dWK != null) {
                        b.this.dWK.ig(true);
                    }
                    return false;
                }
            });
        }
        if (this.dXe == null) {
            this.dXe = new com.baidu.live.gift.panel.a(aPu().pageContext.getPageActivity());
        }
        this.dXe.rs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPk() {
        if (this.dXf == null && this.dXg != null && this.dXg.efr && aPu() != null && aPu().eeL != null && aPu().eeL.uk() != null) {
            this.dXf = new com.baidu.tieba.ala.liveroom.g.e(aPu().pageContext, this.dXg);
            this.dXf.i(aPu().eeL.uk());
            if (this.dXg.efu == 1) {
                if (this.dWQ != null) {
                    this.dXp = true;
                }
            } else if (this.dXg.efu == 2) {
                a(aPu().eeL.uk(), -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int hw(boolean z) {
        Rect rect = new Rect();
        aPu().eeN.getWindowVisibleDisplayFrame(rect);
        return ((ViewCommonUtil.getScreenFullSize(aPu().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(aPu().pageContext.getPageActivity(), 48.0f) : 0)) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + aPu().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) + (z ? aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + aPu().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void aPl() {
        if (this.dWK != null) {
            this.dWK.ah(aPu().eeM);
        }
    }

    private void aPm() {
        if (this.dWN == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.m.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.dWN = (com.baidu.live.m.a) runTask.getData();
            }
            aPn();
        }
    }

    private void bN(JSONObject jSONObject) {
        if (this.dWN != null) {
            if (this.dWH != null) {
                this.dWN.aG(this.dWH.aSa() ? false : true);
            } else {
                this.dWN.aG(true);
            }
            this.dWN.z(jSONObject);
        }
    }

    private void aPn() {
        if (this.dWN != null && aPu().eeL.uk() != null && aPu().eeL.uk().Pp != null) {
            if (this.dWH != null) {
                this.dWN.aG(this.dWH.aSa() ? false : true);
            } else {
                this.dWN.aG(true);
            }
            this.dWN.a(aPu().eeL.uk().Pp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.live.data.i iVar) {
        if (iVar != null) {
            aPn();
            if (this.dWO != null && iVar.OR != null) {
                this.dWO.tF(String.valueOf(iVar.OR.userId));
            }
            if (this.dWT != null && iVar.mLiveInfo != null) {
                this.dWT.a(iVar.mLiveInfo);
            }
            if (this.dWR != null) {
                this.dWR.b(iVar);
            }
            nt(iVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void nt(int i) {
        if (!aPu().eeQ) {
            if (this.dXj < 0 && i == 0) {
                this.dXj = i;
            } else if (this.dXj != i) {
                if (i == 1) {
                    if (!this.dWU.nZ(2)) {
                        String string = aPu().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(aPu().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.dWU.a(aPu().eeN, string, 2, true);
                        }
                    }
                } else {
                    String string2 = aPu().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.dWU.oa(2);
                    this.dWU.oa(3);
                    if (aPw()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.dWU.a(aPu().eeN, string2, 3);
                    }
                }
                this.dXj = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.data.e eVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hp(boolean z) {
        if (z) {
            aPo();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dWM != null) {
            this.dWM.aXb();
        }
        if (this.dWF != null) {
            this.dWF.nA();
        }
        if (this.dWH != null) {
            this.dWH.onDestroy();
        }
        if (this.dWN != null) {
            this.dWN.onDestroy();
            this.dWN = null;
        }
        if (this.dWS != null) {
            View pA = this.dWS.pA();
            if (pA != null && pA.getParent() != null) {
                ((ViewGroup) pA.getParent()).removeView(pA);
            }
            this.dWS.onDestroy();
            this.dWS = null;
        }
        if (this.dWR != null) {
            this.dWR.a(null);
            this.dWR.sk();
        }
        if (this.dWE != null) {
            this.dWE.nA();
        }
        if (this.dWU != null) {
            this.dWU.nA();
        }
        this.dXj = -1;
        if (this.dWO != null) {
            this.dWO.nA();
            this.dWO.onDestroy();
        }
        if (this.dWI != null) {
            this.dWI.aWW();
        }
        if (this.dWJ != null) {
            this.dWJ.aNZ();
        }
        if (this.dWP != null) {
            this.dWP.rt();
        }
        if (this.dWV != null) {
            this.dWV.aSh();
        }
        if (this.dWW != null) {
            this.dWW.aRV();
        }
        if (this.dWX != null) {
            this.dWX.onDestroy();
        }
        if (this.dWY != null) {
            this.dWY.onDestory();
        }
        if (this.dXb != null) {
            this.dXb.onDestroy();
        }
        if (this.dXa != null) {
            this.dXa.aRV();
        }
        if (this.dXf != null) {
            this.dXf.onDestroy();
        }
        if (this.dXc != null) {
            this.dXc.rt();
        }
        if (this.dXd != null) {
            this.dXd.rt();
        }
        if (this.dXe != null) {
            this.dXe.rt();
        }
        if (this.dWG != null) {
            this.dWG.onDestory();
        }
    }

    private void aPo() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = aPu().eeM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aPu().eeM.getChildAt(i);
            if (childAt != this.dXh && childAt != this.dXi) {
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
        if (this.dXh != null) {
            this.dXh.removeAllViews();
        }
        if (this.dXi != null) {
            this.dXi.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOF() {
        View sK;
        View pA;
        if (this.dWS != null && (pA = this.dWS.pA()) != null && pA.getParent() != null) {
            ((ViewGroup) pA.getParent()).removeView(pA);
        }
        if (this.dWR != null && (sK = this.dWR.sK()) != null && sK.getParent() != null) {
            ((ViewGroup) sK.getParent()).removeView(sK);
        }
        if (this.dWH != null) {
            this.dWH.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aPp() {
        if (this.dWL == null || !this.dWL.aSf()) {
            if (this.dWH == null || !this.dWH.ad(aPu().eeN)) {
                if (this.dWK != null) {
                    this.dWK.aMe();
                }
                if (this.dWX == null || !this.dWX.aSg()) {
                    aPc();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestory() {
        if (this.dWN != null) {
            this.dWN.onDestroy();
            this.dWN = null;
        }
        if (this.dWM != null) {
            this.dWM.aXb();
        }
        if (this.dWS != null) {
            this.dWS.onDestroy();
            this.dWS = null;
        }
        if (this.dWT != null) {
            this.dWT.onDestroy();
            this.dWT = null;
        }
        if (this.dWU != null) {
            this.dWU.onDestroy();
        }
        if (this.dWE != null) {
            this.dWE.onDestroy();
        }
        if (this.dWF != null) {
            this.dWF.onDestroy();
        }
        if (this.dWR != null) {
            this.dWR.a(null);
            this.dWR.release();
            this.dWR = null;
        }
        if (this.dWP != null) {
            this.dWP.release();
        }
        if (this.dWV != null) {
            this.dWV.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.dWV.release();
        }
        if (this.dWW != null) {
            this.dWW.a((a.InterfaceC0362a) null);
            this.dWW.release();
        }
        if (this.dWX != null) {
            this.dWX.a((a.InterfaceC0358a) null);
            this.dWX.onDestroy();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dXa != null) {
            this.dXa.onDestroy();
        }
        if (this.dXb != null) {
            this.dXb.onDestroy();
        }
        if (this.dWY != null) {
            this.dWY.onDestory();
        }
        if (this.dXf != null) {
            this.dXf.onDestroy();
        }
        if (this.dWZ != null) {
            this.dWZ.release();
        }
        if (this.dXc != null) {
            this.dXc.release();
        }
        if (this.dXd != null) {
            this.dXd.release();
        }
        if (this.dXe != null) {
            this.dXe.release();
        }
        if (this.dWG != null) {
            this.dWG.onDestory();
        }
        MessageManager.getInstance().unRegisterListener(this.dXx);
        MessageManager.getInstance().unRegisterListener(this.dXy);
        MessageManager.getInstance().unRegisterListener(this.dXA);
        MessageManager.getInstance().unRegisterListener(this.dXt);
        MessageManager.getInstance().unRegisterListener(this.dXs);
        MessageManager.getInstance().unRegisterListener(this.dXw);
        MessageManager.getInstance().unRegisterListener(this.dXv);
        MessageManager.getInstance().unRegisterListener(this.dXB);
        MessageManager.getInstance().unRegisterListener(this.dEz);
        MessageManager.getInstance().unRegisterListener(this.dXC);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.dKq);
        MessageManager.getInstance().unRegisterListener(this.dKp);
        MessageManager.getInstance().unRegisterListener(this.dXu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPq() {
        if (this.dWV != null) {
            this.dWV.hP(false);
        }
        if (this.dWX != null) {
            this.dWX.hP(false);
        }
        aOI();
        if (this.dWZ != null) {
            this.dWZ.pause();
        }
        if (this.dXc != null) {
            this.dXc.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPr() {
        this.dXr = false;
        if (this.dXl && this.dXm != null) {
            a(this.dXm);
            this.dXl = false;
        }
        if (this.dWV != null) {
            this.dWV.hP(true);
        }
        if (this.dWX != null) {
            this.dWX.hP(true);
        }
        if (this.dWZ != null) {
            this.dWZ.resume();
        }
        if (this.dXc != null) {
            this.dXc.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aON() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPs() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            aPs();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    F(-1, -1, -1);
                    return;
                }
                return;
            }
            aPs();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    F(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            aPs();
        } else if (i == 25034) {
            aOZ();
        } else if (i == 25043 && i2 == -1) {
            aPv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        this.dXk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aPt() {
        return (aPu().eeL.uk() == null || aPu().eeL.uk().mLiveInfo == null || aPu().eeL.uk().mLiveInfo.live_type != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.dWH != null) {
                this.dWH.aM(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.dWX != null) {
            this.dWX.afC();
        }
        if (this.dWG != null) {
            this.dWG.afC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.dWD = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.dWC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a aPu() {
        return this.dWC;
    }

    public void aS(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPv() {
        String aLw = com.baidu.tieba.ala.guardclub.m.aLv().aLw();
        if (!TextUtils.isEmpty(aLw)) {
            try {
                F(-1, Integer.parseInt(aLw), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                F(-1, -1, -1);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public boolean mZ(int i) {
        if (7 == i) {
            if (this.dWS != null) {
                this.dWS.ai(true);
            }
            if (this.dWE != null) {
                this.dWE.aOa();
            }
        } else if (1 == i) {
            if (aOH() != null) {
                aOH().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.dXk) {
                return false;
            }
            if (this.dWH == null || !this.dWH.aSa()) {
                return this.dWE == null || this.dWE.aOc();
            }
            return false;
        } else if (3 == i) {
            if (aPu().eeM != null) {
                aPu().eeM.setEnabled(false);
                if (this.dWD != null) {
                    this.dWD.A(!aPu().eeO, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.dWE == null || !this.dWE.isShowing();
        }
        return true;
    }

    public void nr(int i) {
        if ((i == 7 || i == 11) && this.dWE != null) {
            this.dWE.aOa();
            this.dWE.hm(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void na(int i) {
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void nb(int i) {
        if (7 == i) {
            if (this.dWS != null) {
                this.dWS.ai(false);
            }
            if (this.dWE != null) {
                this.dWE.hm(true);
            }
        } else if (11 == i) {
            if (this.dWE != null) {
                this.dWE.hm(true);
            }
        } else if (3 == i) {
            aPu().eeM.setEnabled(true);
            if (this.dWD != null) {
                this.dWD.A(aPu().eeO ? false : true, true);
            }
            if (this.dWN != null) {
                this.dWN.aG(true);
            }
        } else if (2 == i && this.dWM != null) {
            this.dWM.in(true);
        }
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.dWR != null) {
            this.dWR.setOtherParams(str);
        }
    }

    private boolean aPw() {
        return aPu().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
