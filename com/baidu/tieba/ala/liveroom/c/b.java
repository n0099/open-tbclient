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
    protected com.baidu.tieba.ala.liveroom.b.b dXA;
    protected com.baidu.tieba.ala.liveroom.praise.a dXB;
    protected com.baidu.tieba.ala.liveroom.guide.b dXC;
    protected com.baidu.tieba.ala.liveroom.s.a dXD;
    protected com.baidu.live.m.a dXE;
    private com.baidu.tieba.ala.liveroom.g.a dXF;
    private m dXG;
    i dXH;
    j dXI;
    protected r dXJ;
    protected p dXK;
    protected com.baidu.tieba.ala.liveroom.tippop.a dXL;
    private com.baidu.tieba.ala.liveroom.guideim.b dXM;
    protected com.baidu.tieba.ala.liveroom.o.a dXN;
    com.baidu.tieba.ala.liveroom.k.a dXO;
    private f dXP;
    protected com.baidu.tieba.ala.liveroom.f.a dXQ;
    protected com.baidu.tieba.ala.liveroom.j.a dXR;
    protected com.baidu.tieba.ala.liveroom.j.c dXS;
    protected com.baidu.tieba.ala.liveroom.turntable.e dXT;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b dXU;
    private com.baidu.live.gift.panel.a dXV;
    protected com.baidu.tieba.ala.liveroom.g.e dXW;
    protected com.baidu.tieba.ala.liveroom.data.i dXX;
    protected RelativeLayout dXY;
    protected RelativeLayout dXZ;
    private com.baidu.tieba.ala.liveroom.data.a dXt;
    protected e dXu;
    private com.baidu.tieba.ala.liveroom.attentionpop.a dXv;
    protected com.baidu.tieba.ala.liveroom.share.c dXw;
    protected com.baidu.tieba.ala.liveroom.n.b dXx;
    protected com.baidu.tieba.ala.liveroom.guide.a dXy;
    protected com.baidu.tieba.ala.liveroom.watermark.a dXz;
    protected s dYd;
    protected GuardClubInfoHttpResponseMessage dYe;
    boolean dYf;
    boolean dYg;
    public boolean dYh;
    public boolean dYi;
    protected String otherParams;
    private int dYa = -1;
    protected int mOrientation = 0;
    protected boolean dYb = false;
    protected boolean dYc = false;
    protected Handler mHandler = new Handler();
    private CustomMessageListener dYj = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.m mVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.m) && (mVar = (com.baidu.live.data.m) customResponsedMessage.getData()) != null) {
                b.this.a(mVar.Qb, mVar.PY, mVar.PZ, mVar.Qa);
            }
        }
    };
    private CustomMessageListener dYk = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.i) && b.this.dXw != null) {
                b.this.dXw.c((com.baidu.live.data.i) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener dYl = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dXH != null) {
                b.this.dXH.h(o.pI().pK());
            }
        }
    };
    private CustomMessageListener dYm = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.dXt.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.tx(str);
            }
        }
    };
    private CustomMessageListener dYn = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.aPw().pageContext.getPageActivity());
            }
            if (b.this.dXw != null) {
                b.this.dXw.c(b.this.aPw().efC.uj(), false);
            }
        }
    };
    private CustomMessageListener dYo = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof s) {
                    b.this.dYc = true;
                    b.this.dYd = (s) data;
                    b.this.b(b.this.dYd);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.e((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener dYp = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(b.this.aPw().efC.uj().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(b.this.aPw().efC.uj().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(b.this.aPw().efC.uj().Ps.userId);
            if (b.this.dXx == null) {
                b.this.dXx = new com.baidu.tieba.ala.liveroom.n.b(b.this.aPw().pageContext);
            }
            b.this.dXx.a(valueOf, valueOf2, valueOf3, false, data);
            b.this.dXx.a(b.this.dYq);
        }
    };
    private b.a dYq = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        @Override // com.baidu.live.g.b.a
        public void uu() {
            if (b.this.aPw().efC.uj() != null && b.this.aPw().efC.uj().PN != null) {
                b.this.aPw().efC.uj().PN.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener dYr = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                b.this.f((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    CustomMessageListener dYs = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ns(7);
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
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
    CustomMessageListener dYt = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.dYf = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.dXO != null) {
                b.this.dXO.aAm();
            }
        }
    };
    HttpMessageListener dLh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.guardclub.model.c cVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (cVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).dLd) != null && b.this.dXP != null && b.this.aPw() != null && b.this.aPw().efC != null) {
                b.this.dXP.a(b.this.dXY, cVar, b.this.aPw().efC.uj());
                com.baidu.live.f.a.N(cVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener dLg = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aPw() != null && b.this.aPw().efC != null && b.this.aPw().efC.uj() != null && guardClubInfoHttpResponseMessage.dLd != null) {
                    if (guardClubInfoHttpResponseMessage.dLd.OF == b.this.aPw().efC.uj().Ps.userId) {
                        b.this.dYe = guardClubInfoHttpResponseMessage;
                        if (b.this.dYe != null && b.this.dYe.dLJ) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.tieba.ala.guardclub.a.bZ(b.this.aPw().efC.uj().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private View.OnTouchListener dYu = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.aPk();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(s sVar);

    protected abstract View aOJ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean aOK();

    protected abstract boolean aOL();

    protected abstract boolean aOh();

    protected abstract void b(s sVar);

    protected abstract void e(com.baidu.live.data.a aVar);

    public void a(com.baidu.tieba.ala.liveroom.data.i iVar) {
        this.dXX = iVar;
    }

    public void init() {
        this.dXY = (RelativeLayout) aPw().efD.findViewById(a.g.ala_live_header_view);
        this.dXZ = (RelativeLayout) aPw().efD.findViewById(a.g.ala_live_footer_view);
        qg();
        registerListener();
    }

    public void aOR() {
    }

    private void qg() {
        if (this.dXw == null) {
            this.dXw = new com.baidu.tieba.ala.liveroom.share.c(aPw().pageContext);
        }
        this.dXD = new com.baidu.tieba.ala.liveroom.s.a(aPw().pageContext, this);
        this.dXA = new com.baidu.tieba.ala.liveroom.b.b(aPw().pageContext, false);
        this.dXB = new com.baidu.tieba.ala.liveroom.praise.a(aPw().pageContext);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            boolean z = TbadkCoreApplication.getInst().isHaokan() && subappVersionName.startsWith("4.14.");
            if (TbadkCoreApplication.getInst().isQuanmin() && subappVersionName.startsWith("1.14.")) {
                z = true;
            }
            if (TbadkCoreApplication.getInst().isTieba() ? false : z) {
                this.dXC = new com.baidu.tieba.ala.liveroom.guide.b(aPw().pageContext);
            }
        }
        this.dXL = new com.baidu.tieba.ala.liveroom.tippop.a(aPw().pageContext, this);
        aOS();
        aOT();
        aOU();
        aOV();
        aOW();
        aOX();
        aOY();
    }

    private void aOS() {
        this.dXG = new m();
    }

    private void aOT() {
        this.dXM = new com.baidu.tieba.ala.liveroom.guideim.b(aPw().pageContext);
        this.dXM.c(this.dXZ, aOh());
        this.dXM.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.8
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean sF() {
                return b.this.rA();
            }
        });
    }

    private void aOU() {
        this.dXN = new com.baidu.tieba.ala.liveroom.o.a();
        this.dXN.a(new a.InterfaceC0367a() { // from class: com.baidu.tieba.ala.liveroom.c.b.9
            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0367a
            public void aPz() {
                b.this.ns(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0367a
            public void aPA() {
                b.this.nc(11);
            }

            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0367a
            public boolean sF() {
                return b.this.rA();
            }
        });
    }

    private void aOV() {
        this.dXO = new com.baidu.tieba.ala.liveroom.k.a(this.dXt.pageContext);
        this.dXO.a(new a.InterfaceC0363a() { // from class: com.baidu.tieba.ala.liveroom.c.b.10
            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0363a
            public boolean aPB() {
                return b.this.aOL();
            }

            @Override // com.baidu.tieba.ala.liveroom.k.a.InterfaceC0363a
            public void onClose() {
                if (b.this.dXu != null) {
                    b.this.dXu.aPK();
                }
            }
        });
    }

    void ht(boolean z) {
        if (this.dXM != null) {
            this.dXM.hQ(z);
        }
        if (this.dXO != null) {
            this.dXO.hQ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hu(boolean z) {
        if (this.dXM != null) {
            this.dXM.hQ(z);
        }
        if (this.dXO != null) {
            this.dXO.hQ(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hv(boolean z) {
        if (this.dXM != null) {
            this.dXM.hQ(z);
        }
        if (this.dXO != null) {
            this.dXO.hQ(z);
        }
    }

    private void aOW() {
        this.dXP = new f(aPw().pageContext);
        this.dXP.setOtherParams(tm());
    }

    private void aOX() {
        this.dXQ = new com.baidu.tieba.ala.liveroom.f.a(aPw().pageContext);
    }

    private void aOY() {
        this.dXT = new com.baidu.tieba.ala.liveroom.turntable.e(aPw().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dYo);
        MessageManager.getInstance().registerListener(this.dYp);
        MessageManager.getInstance().registerListener(this.dYr);
        MessageManager.getInstance().registerListener(this.dYk);
        MessageManager.getInstance().registerListener(this.dYj);
        MessageManager.getInstance().registerListener(this.dYn);
        MessageManager.getInstance().registerListener(this.dYm);
        MessageManager.getInstance().registerListener(this.dYs);
        MessageManager.getInstance().registerListener(this.dFq);
        MessageManager.getInstance().registerListener(this.dYt);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.dLh);
        MessageManager.getInstance().registerListener(this.dLg);
        MessageManager.getInstance().registerListener(this.dYl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean rA() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(aPw().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(aPw().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.l.a.uA().ajX.Sc;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = aPw().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = aPw().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.aPw().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(aPw().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOZ() {
        if (this.dXH != null) {
            this.dXH.sE().a(this.dXN.aVG(), o.pI().pK());
            ht(true);
            if (this.dXV == null) {
                this.dXV = new com.baidu.live.gift.panel.a(aPw().pageContext.getPageActivity());
            }
            this.dXV.rr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPa() {
        if (this.dXH != null) {
            this.dXH.sE().hide();
            ht(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(int i, int i2, int i3) {
        if (aPw().efC.uj() != null && aPw().efC.uj().Ps != null && aPw().efC.uj().mLiveInfo != null) {
            a(aPw().efC.uj(), i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.i iVar, int i, int i2, int i3) {
        boolean z;
        int i4;
        if (rA()) {
            if (iVar == null) {
                iVar = aPw().efC.uj();
            }
            String valueOf = String.valueOf(iVar.Ps.userId);
            String str = iVar.Ps.userName;
            String valueOf2 = String.valueOf(iVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(iVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(iVar.mLiveInfo.feed_id);
            int i5 = iVar.PN.isBlock;
            String rf = com.baidu.live.gift.b.b.rc().rf();
            String str2 = iVar.mLiveInfo.appId;
            boolean z2 = iVar.PN.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (iVar.mLiveInfo.live_type == 1 && iVar.mLiveInfo.screen_direction == 1 && com.baidu.live.l.a.uA().ajX.Rb) {
                z3 = true;
            }
            int i6 = -1;
            if (iVar.PN == null) {
                z = false;
            } else {
                boolean z4 = iVar.PN.isNewUser;
                i6 = iVar.PN.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.dYe != null && this.dYe.dLd != null && this.dYe.dLd.OF == iVar.Ps.userId) {
                z5 = this.dYe.dLJ;
            }
            com.baidu.live.b.e eVar = new com.baidu.live.b.e(aPw().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i5, rf, str2, z3, i, i2, i3, z2, i6, valueOf4, this.otherParams, z5);
            eVar.ac(z);
            z aLz = com.baidu.tieba.ala.guardclub.m.aLx().aLz();
            if (aLz == null || aLz.TF <= 0) {
                i4 = 1000;
            } else {
                i4 = aLz.TF;
            }
            eVar.aP(i4);
            if (!this.dYh) {
                this.dYi = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
            }
        }
    }

    private void aPb() {
        nc(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPc() {
        if (this.dXN != null) {
            this.dXN.d(this.dXt.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPd() {
        com.baidu.live.data.i uj = aPw().efC.uj();
        LogManager.getCommonLogger().doClickQuickImHiLog((uj == null || uj.mLiveInfo == null) ? "" : uj.mLiveInfo.feed_id, tm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ty(String str) {
        if (this.dXN != null) {
            this.dXN.cs(str);
        }
    }

    private void aPe() {
        if ("home_rec_play".equals(aPw().fromType) || "frs_play".equals(aPw().fromType) || "frs_live_play".equals(aPw().fromType) || "person_play".equals(aPw().fromType) || "search".equals(aPw().fromType) || "person_attention".equals(aPw().fromType)) {
            com.baidu.live.b.no().aa(true);
        } else {
            com.baidu.live.b.no().aa(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ho(boolean z) {
        View pA;
        if (this.dXJ == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.Wi = false;
            fVar.context = aPw().pageContext.getPageActivity();
            fVar.Wo = z;
            fVar.fromType = aPw().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, r.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.dXJ = (r) runTask.getData();
            }
        }
        if (this.dXJ != null && (pA = this.dXJ.pA()) != null && this.dXt.efD.indexOfChild(pA) < 0) {
            this.dXt.efD.addView(pA, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPf() {
        View pN;
        if (this.dXK == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.Wi = false;
            aVar.context = aPw().pageContext.getPageActivity();
            aVar.fromType = aPw().fromType;
            aVar.Wj = aPw().efI;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, p.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.dXK = (p) runTask.getData();
            }
        }
        if (this.dXK != null && (pN = this.dXK.pN()) != null && aPw().efD.indexOfChild(pN) < 0) {
            if (pN.getParent() instanceof ViewGroup) {
                ((ViewGroup) pN.getParent()).removeView(pN);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = aPw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            aPw().efD.addView(pN, layoutParams);
        }
    }

    private void aPg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPh() {
        if (this.dXI == null) {
            this.dXI = new com.baidu.tieba.ala.liveroom.d.a(aPw().pageContext);
        }
        this.dXI.setOtherParams(this.otherParams);
        this.dXI.a(new j.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.14
            @Override // com.baidu.live.im.j.a
            public void sL() {
                b.this.aPk();
            }
        });
        this.dXI.a(aPw().efC.uj(), false);
        View sJ = this.dXI.sJ();
        if (sJ != null && this.dXZ.indexOfChild(sJ) < 0) {
            Resources resources = aPw().pageContext.getResources();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(aPw().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
            this.dXZ.addView(sJ, layoutParams);
        }
    }

    private void aPi() {
        if (this.dXF == null) {
            this.dXF = new com.baidu.tieba.ala.liveroom.g.a(aPw().pageContext);
        }
        if (this.dYd != null) {
            this.dXF.tF(this.dYd.user_id);
        }
        this.dXF.Z(null);
    }

    private void aPj() {
        if (this.dXR == null) {
            this.dXR = new com.baidu.tieba.ala.liveroom.j.a(aPw().pageContext, false, tm());
        }
        if (aPw().efC.uj() != null && aPw().efC.uj().Ps != null && aPw().efC.uj().mLiveInfo != null) {
            this.dXR.c(this.dXY, aPw().efC.uj());
            this.dXR.a(new a.InterfaceC0362a() { // from class: com.baidu.tieba.ala.liveroom.c.b.15
                @Override // com.baidu.tieba.ala.liveroom.j.a.InterfaceC0362a
                public void aPC() {
                    b.this.aPx();
                }
            });
        }
    }

    public void f(com.baidu.live.im.data.a aVar) {
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
                    if (this.dXu != null) {
                        this.dXu.hE(z);
                    }
                    int optInt = jSONObject.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        nu(optInt);
                    }
                } else if ("live_admin".equals(optString)) {
                    long optLong = jSONObject.optLong("user_id");
                    int optInt2 = jSONObject.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPw().efC.uj().PN.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPw().efC.uj().PN.isAdmin = 0;
                            aPw().efC.aVa();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        aPw().efC.uj().PN.isAdmin = 0;
                        aPw().efC.aVa();
                    }
                } else if ("task".equals(optString)) {
                    bM(jSONObject);
                } else if ("live_net_status".equals(optString)) {
                    int optInt3 = jSONObject.optInt("net_status");
                    if (this.dXL != null && !aPw().efH) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = aPw().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = aPw().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = aPw().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (aPy()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.dXL.a(aPw().efE, str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString)) {
                    final int optInt4 = jSONObject.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.dXu != null) {
                                b.this.dXu.hD(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString)) {
                    if (jSONObject.optInt("event_type") == 1001 && aPw().efC.uj() != null && aPw().efC.uj().mLiveInfo != null) {
                        String str2 = aPw().efC.uj().mLiveInfo.feed_id;
                        long j4 = aPw().efC.uj().mLiveInfo.live_id;
                        long optLong2 = jSONObject.optLong("id");
                        if (!l.g(j4, optLong2)) {
                            com.baidu.live.utils.m.i(str2, j4);
                            l.h(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject.optLong("user_id"))));
                } else if ("need_update_live_mark_info".equals(optString) && aPw() != null && aPw().efC != null && aPw().efC.uj() != null && aPw().efC.uj().PN != null && aPw().efC.uj().PN.userId == jSONObject.optLong("user_id")) {
                    aPw().efC.aVa();
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.dXD != null) {
                this.dXD.t(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject != null) {
            com.baidu.live.data.a te = aVar.te();
            String optString2 = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            String optString3 = jSONObject.optString("gift_count");
            String optString4 = jSONObject.optString("gift_name");
            String optString5 = jSONObject.optString("gift_url");
            String optString6 = jSONObject.optString("attach");
            long optLong3 = jSONObject.optLong("charm_total");
            String str3 = null;
            if (aPw().efC == null || aPw().efC.uj() == null || aPw().efC.uj().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = aPw().efC.uj().mLiveInfo.live_id;
                long j6 = aPw().efC.uj().mLiveInfo.group_id;
                long j7 = aPw().efC.uj().Ps.userId;
                str3 = aPw().efC.uj().mLiveInfo.appId;
                j = j7;
                j2 = j6;
                j3 = j5;
            }
            q.b(optString2, JavaTypesHelper.toInt(optString3, 1), optString4, optString5, te.userId, te.portrait, te.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str3, optString6);
            tv(optString2);
            com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
            dVar.eeX = optLong3;
            dVar.liveId = j3;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void tv(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aPk() {
        if (aPl()) {
            BdUtilHelper.hideSoftKeyPad(aPw().pageContext.getPageActivity(), aPw().efE);
            aOK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPl() {
        if (aOJ() == null || aOJ().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uM() {
        aPw().efD.setOnTouchListener(this.dYu);
        aPn();
        aPo();
        aPg();
        aPi();
        aPj();
        if (this.dXG != null) {
            this.dXG.f(aPw().efC.uj());
        }
        if (this.dXM != null) {
            this.dXM.a(aPw().efC.uj(), tm());
        }
        if (this.dXN != null) {
            this.dXN.a(aPw().efC.uj(), tm());
        }
        if (this.dXO != null) {
            this.dXO.a(aPw().efC.uj(), tm());
        }
        if (aPw().efD != null) {
            aPw().efD.setOnDispatchTouchEventListener(new AlaLiveView.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
                @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && b.this.aPl() && b.this.dXB != null) {
                        b.this.dXB.ig(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.dXB != null) {
                        b.this.dXB.ig(true);
                    }
                    return false;
                }
            });
        }
        if (this.dXV == null) {
            this.dXV = new com.baidu.live.gift.panel.a(aPw().pageContext.getPageActivity());
        }
        this.dXV.rr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPm() {
        if (this.dXW == null && this.dXX != null && this.dXX.egi && aPw() != null && aPw().efC != null && aPw().efC.uj() != null) {
            this.dXW = new com.baidu.tieba.ala.liveroom.g.e(aPw().pageContext, this.dXX);
            this.dXW.i(aPw().efC.uj());
            if (this.dXX.egl == 1) {
                if (this.dXH != null) {
                    this.dYg = true;
                }
            } else if (this.dXX.egl == 2) {
                a(aPw().efC.uj(), -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int hw(boolean z) {
        Rect rect = new Rect();
        aPw().efE.getWindowVisibleDisplayFrame(rect);
        return ((ViewCommonUtil.getScreenFullSize(aPw().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(aPw().pageContext.getPageActivity(), 48.0f) : 0)) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + aPw().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) + (z ? aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) : 0) + aPw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void aPn() {
        if (this.dXB != null) {
            this.dXB.ah(aPw().efD);
        }
    }

    private void aPo() {
        if (this.dXE == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.m.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.dXE = (com.baidu.live.m.a) runTask.getData();
            }
            aPp();
        }
    }

    private void bM(JSONObject jSONObject) {
        if (this.dXE != null) {
            if (this.dXy != null) {
                this.dXE.aG(this.dXy.aSc() ? false : true);
            } else {
                this.dXE.aG(true);
            }
            this.dXE.y(jSONObject);
        }
    }

    private void aPp() {
        if (this.dXE != null && aPw().efC.uj() != null && aPw().efC.uj().PU != null) {
            if (this.dXy != null) {
                this.dXE.aG(this.dXy.aSc() ? false : true);
            } else {
                this.dXE.aG(true);
            }
            this.dXE.a(aPw().efC.uj().PU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.live.data.i iVar) {
        if (iVar != null) {
            aPp();
            if (this.dXF != null && iVar.Ps != null) {
                this.dXF.tF(String.valueOf(iVar.Ps.userId));
            }
            if (this.dXK != null && iVar.mLiveInfo != null) {
                this.dXK.a(iVar.mLiveInfo);
            }
            if (this.dXI != null) {
                this.dXI.b(iVar);
            }
            nu(iVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void nu(int i) {
        if (!aPw().efH) {
            if (this.dYa < 0 && i == 0) {
                this.dYa = i;
            } else if (this.dYa != i) {
                if (i == 1) {
                    if (!this.dXL.oa(2)) {
                        String string = aPw().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(aPw().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.dXL.a(aPw().efE, string, 2, true);
                        }
                    }
                } else {
                    String string2 = aPw().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.dXL.ob(2);
                    this.dXL.ob(3);
                    if (aPy()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.dXL.a(aPw().efE, string2, 3);
                    }
                }
                this.dYa = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.data.e eVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hp(boolean z) {
        if (z) {
            aPq();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dXD != null) {
            this.dXD.aXd();
        }
        if (this.dXw != null) {
            this.dXw.nA();
        }
        if (this.dXy != null) {
            this.dXy.onDestroy();
        }
        if (this.dXE != null) {
            this.dXE.onDestroy();
            this.dXE = null;
        }
        if (this.dXJ != null) {
            View pA = this.dXJ.pA();
            if (pA != null && pA.getParent() != null) {
                ((ViewGroup) pA.getParent()).removeView(pA);
            }
            this.dXJ.onDestroy();
            this.dXJ = null;
        }
        if (this.dXI != null) {
            this.dXI.a(null);
            this.dXI.sj();
        }
        if (this.dXv != null) {
            this.dXv.nA();
        }
        if (this.dXL != null) {
            this.dXL.nA();
        }
        this.dYa = -1;
        if (this.dXF != null) {
            this.dXF.nA();
            this.dXF.onDestroy();
        }
        if (this.dXz != null) {
            this.dXz.aWY();
        }
        if (this.dXA != null) {
            this.dXA.aOb();
        }
        if (this.dXG != null) {
            this.dXG.rs();
        }
        if (this.dXM != null) {
            this.dXM.aSj();
        }
        if (this.dXN != null) {
            this.dXN.aRX();
        }
        if (this.dXO != null) {
            this.dXO.onDestroy();
        }
        if (this.dXP != null) {
            this.dXP.onDestory();
        }
        if (this.dXS != null) {
            this.dXS.onDestroy();
        }
        if (this.dXR != null) {
            this.dXR.aRX();
        }
        if (this.dXW != null) {
            this.dXW.onDestroy();
        }
        if (this.dXT != null) {
            this.dXT.rs();
        }
        if (this.dXU != null) {
            this.dXU.rs();
        }
        if (this.dXV != null) {
            this.dXV.rs();
        }
        if (this.dXx != null) {
            this.dXx.onDestory();
        }
    }

    private void aPq() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = aPw().efD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aPw().efD.getChildAt(i);
            if (childAt != this.dXY && childAt != this.dXZ) {
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
        if (this.dXY != null) {
            this.dXY.removeAllViews();
        }
        if (this.dXZ != null) {
            this.dXZ.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOH() {
        View sJ;
        View pA;
        if (this.dXJ != null && (pA = this.dXJ.pA()) != null && pA.getParent() != null) {
            ((ViewGroup) pA.getParent()).removeView(pA);
        }
        if (this.dXI != null && (sJ = this.dXI.sJ()) != null && sJ.getParent() != null) {
            ((ViewGroup) sJ.getParent()).removeView(sJ);
        }
        if (this.dXy != null) {
            this.dXy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aPr() {
        if (this.dXC == null || !this.dXC.aSh()) {
            if (this.dXy == null || !this.dXy.ad(aPw().efE)) {
                if (this.dXB != null) {
                    this.dXB.aMg();
                }
                if (this.dXO == null || !this.dXO.aSi()) {
                    aPe();
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
        if (this.dXE != null) {
            this.dXE.onDestroy();
            this.dXE = null;
        }
        if (this.dXD != null) {
            this.dXD.aXd();
        }
        if (this.dXJ != null) {
            this.dXJ.onDestroy();
            this.dXJ = null;
        }
        if (this.dXK != null) {
            this.dXK.onDestroy();
            this.dXK = null;
        }
        if (this.dXL != null) {
            this.dXL.onDestroy();
        }
        if (this.dXv != null) {
            this.dXv.onDestroy();
        }
        if (this.dXw != null) {
            this.dXw.onDestroy();
        }
        if (this.dXI != null) {
            this.dXI.a(null);
            this.dXI.release();
            this.dXI = null;
        }
        if (this.dXG != null) {
            this.dXG.release();
        }
        if (this.dXM != null) {
            this.dXM.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.dXM.release();
        }
        if (this.dXN != null) {
            this.dXN.a((a.InterfaceC0367a) null);
            this.dXN.release();
        }
        if (this.dXO != null) {
            this.dXO.a((a.InterfaceC0363a) null);
            this.dXO.onDestroy();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dXR != null) {
            this.dXR.onDestroy();
        }
        if (this.dXS != null) {
            this.dXS.onDestroy();
        }
        if (this.dXP != null) {
            this.dXP.onDestory();
        }
        if (this.dXW != null) {
            this.dXW.onDestroy();
        }
        if (this.dXQ != null) {
            this.dXQ.release();
        }
        if (this.dXT != null) {
            this.dXT.release();
        }
        if (this.dXU != null) {
            this.dXU.release();
        }
        if (this.dXV != null) {
            this.dXV.release();
        }
        if (this.dXx != null) {
            this.dXx.onDestory();
        }
        MessageManager.getInstance().unRegisterListener(this.dYo);
        MessageManager.getInstance().unRegisterListener(this.dYp);
        MessageManager.getInstance().unRegisterListener(this.dYr);
        MessageManager.getInstance().unRegisterListener(this.dYk);
        MessageManager.getInstance().unRegisterListener(this.dYj);
        MessageManager.getInstance().unRegisterListener(this.dYn);
        MessageManager.getInstance().unRegisterListener(this.dYm);
        MessageManager.getInstance().unRegisterListener(this.dYs);
        MessageManager.getInstance().unRegisterListener(this.dFq);
        MessageManager.getInstance().unRegisterListener(this.dYt);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.dLh);
        MessageManager.getInstance().unRegisterListener(this.dLg);
        MessageManager.getInstance().unRegisterListener(this.dYl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPs() {
        if (this.dXM != null) {
            this.dXM.hP(false);
        }
        if (this.dXO != null) {
            this.dXO.hP(false);
        }
        aOK();
        if (this.dXQ != null) {
            this.dXQ.pause();
        }
        if (this.dXT != null) {
            this.dXT.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPt() {
        this.dYi = false;
        if (this.dYc && this.dYd != null) {
            a(this.dYd);
            this.dYc = false;
        }
        if (this.dXM != null) {
            this.dXM.hP(true);
        }
        if (this.dXO != null) {
            this.dXO.hP(true);
        }
        if (this.dXQ != null) {
            this.dXQ.resume();
        }
        if (this.dXT != null) {
            this.dXT.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOO() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aOP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aPu() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            aPu();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    F(-1, -1, -1);
                    return;
                }
                return;
            }
            aPu();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    F(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            aPu();
        } else if (i == 25034) {
            aPb();
        } else if (i == 25043 && i2 == -1) {
            aPx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
        this.dYb = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aPv() {
        return (aPw().efC.uj() == null || aPw().efC.uj().mLiveInfo == null || aPw().efC.uj().mLiveInfo.live_type != 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.dXy != null) {
                this.dXy.aO(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.dXO != null) {
            this.dXO.afE();
        }
        if (this.dXx != null) {
            this.dXx.afE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e eVar) {
        this.dXu = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.dXt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a aPw() {
        return this.dXt;
    }

    public void aS(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPx() {
        String aLy = com.baidu.tieba.ala.guardclub.m.aLx().aLy();
        if (!TextUtils.isEmpty(aLy)) {
            try {
                F(-1, Integer.parseInt(aLy), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                F(-1, -1, -1);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public boolean na(int i) {
        if (7 == i) {
            if (this.dXJ != null) {
                this.dXJ.ai(true);
            }
            if (this.dXv != null) {
                this.dXv.aOc();
            }
        } else if (1 == i) {
            if (aOJ() != null) {
                aOJ().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.dYb) {
                return false;
            }
            if (this.dXy == null || !this.dXy.aSc()) {
                return this.dXv == null || this.dXv.aOe();
            }
            return false;
        } else if (3 == i) {
            if (aPw().efD != null) {
                aPw().efD.setEnabled(false);
                if (this.dXu != null) {
                    this.dXu.A(!aPw().efF, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.dXv == null || !this.dXv.isShowing();
        }
        return true;
    }

    public void ns(int i) {
        if ((i == 7 || i == 11) && this.dXv != null) {
            this.dXv.aOc();
            this.dXv.hm(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void nb(int i) {
    }

    @Override // com.baidu.tieba.ala.liveroom.b
    public void nc(int i) {
        if (7 == i) {
            if (this.dXJ != null) {
                this.dXJ.ai(false);
            }
            if (this.dXv != null) {
                this.dXv.hm(true);
            }
        } else if (11 == i) {
            if (this.dXv != null) {
                this.dXv.hm(true);
            }
        } else if (3 == i) {
            aPw().efD.setEnabled(true);
            if (this.dXu != null) {
                this.dXu.A(aPw().efF ? false : true, true);
            }
            if (this.dXE != null) {
                this.dXE.aG(true);
            }
        } else if (2 == i && this.dXD != null) {
            this.dXD.in(true);
        }
    }

    public String tm() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.dXI != null) {
            this.dXI.setOtherParams(str);
        }
    }

    private boolean aPy() {
        return aPw().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }
}
