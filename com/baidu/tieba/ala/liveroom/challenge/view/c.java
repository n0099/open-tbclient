package com.baidu.tieba.ala.liveroom.challenge.view;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.b;
/* loaded from: classes3.dex */
public class c implements i {
    private AlaChallengeLiveView fDG;
    private b fDH;
    private h fDI;
    private AlaChallengeCountDown fDJ;
    private j fDK;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fDL = false;
    private boolean fDM = false;
    private boolean fDN = false;
    private boolean fDO = true;
    private boolean fDP = false;
    private boolean fDQ = false;
    private long challengeId = 0;
    private long apl = 0;
    private long liveId = -1;
    private long fDR = 0;
    private boolean isHost = false;
    private boolean fDS = false;
    private boolean fDT = false;
    private boolean fDU = false;
    private b.a fDV = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buG() {
            if (c.this.fDG != null && c.this.fDG.getParent() != null) {
                c.this.fDM = true;
                if (c.this.fDI != null) {
                    c.this.fDI.un();
                }
                c.this.fDG.setCloseBtnVisible(true);
                c.this.fDG.setLiveContainerVisible(true);
                if (!com.baidu.live.c.tH().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.tH().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.fDT && !c.this.isHost) || (!c.this.fDS && c.this.isHost)) {
                        if (c.this.fDJ == null) {
                            c.this.fDJ = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.fDJ.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.fDJ.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.fDJ.getParent() != null) {
                            ((ViewGroup) c.this.fDJ.getParent()).removeView(c.this.fDJ);
                        }
                        c.this.fDG.getLiveContainerView().addView(c.this.fDJ, layoutParams);
                        c.this.fDJ.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.fDP = true;
                }
                c.this.buN();
                c.this.buO();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buH() {
            if (c.this.fDG != null && c.this.fDG.getParent() != null) {
                c.this.fDN = false;
                if (c.this.fDI != null) {
                    c.this.fDI.aR(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.apl = c.this.apl;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.fDG.setLiveContainerVisible(false);
                c.this.fDP = true;
                c.this.fDQ = true;
                c.this.buN();
                c.this.buO();
                c.this.fDP = false;
                c.this.fDQ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buI() {
            if (c.this.fDG != null && c.this.fDG.getParent() != null) {
                if (!c.this.fDN) {
                    c.this.buM();
                    c.this.buP();
                }
                c.this.fDP = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buJ() {
            c.this.fDQ = false;
        }
    };
    private AlaChallengeLiveView.a fDW = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void buF() {
            c.this.buQ();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(ah ahVar) {
            if (ahVar != null && ahVar.aue != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(ahVar.aue.userId), ahVar.aue.userName, ahVar.aue.portrait, ahVar.aue.sex, ahVar.aue.levelId, null, null, 0L, ahVar.aue.fansCount, ahVar.aue.followCount, ahVar.aue.userStatus, String.valueOf(ahVar.auq.group_id), String.valueOf(ahVar.auq.live_id), false, String.valueOf(c.this.fDR), ahVar.aue.appId, ahVar.aue.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(ah ahVar) {
            if (!c.this.isHost) {
                if (c.this.fDU) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.fDG);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.Eo().aQp.asU || !TbadkCoreApplication.getInst().isMobileBaidu()) && ahVar != null && ahVar.auq != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(ahVar.auq.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fDH = new b(tbPageContext.getPageActivity());
        this.fDH.a(this.fDV);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.fDH.bv(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void f(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.fDT = z;
        this.isHost = z2;
        this.fDS = z3;
    }

    private void buK() {
        if (this.fDG == null) {
            this.fDG = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.fDG.setIsHost(this.isHost);
            this.fDG.setViewClickCallBack(this.fDW);
        }
    }

    private void buL() {
        int i = 0;
        if (this.fDG != null && this.mParentView != null) {
            if (this.fDG.getParent() != null) {
                ((ViewGroup) this.fDG.getParent()).removeView(this.fDG);
            }
            int i2 = this.mParentView.getChildCount() >= 2 ? 2 : 0;
            while (true) {
                if (i >= this.mParentView.getChildCount()) {
                    i = i2;
                    break;
                } else if (this.mParentView.getChildAt(i) instanceof com.baidu.live.liveroom.g.a) {
                    break;
                } else {
                    i++;
                }
            }
            if (this.fDG.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.fDG, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.fDG, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.fDG != null && this.fDG.getParent() != null) {
            ((ViewGroup) this.fDG.getParent()).removeView(this.fDG);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.fDK = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.fDI = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void up() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.fDM);
        }
        this.fDQ = true;
        buO();
    }

    @Override // com.baidu.live.challenge.i
    public void bx(int i) {
        if (1 == i) {
            this.fDP = true;
            buN();
        }
        if (2 == i) {
            this.fDQ = true;
            buO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (this.fDM && this.fDP) {
            this.fDH.e(this.fDG);
            if (this.fDG != null && this.fDG.getAnchorAnimLiveBgView() != null) {
                this.fDG.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.fDM && this.fDQ) {
            this.fDH.d(this.fDG);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ag agVar, ah ahVar, ah ahVar2) {
        this.fDN = true;
        this.fDO = false;
        g(agVar, ahVar, ahVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ag agVar, ah ahVar, ah ahVar2) {
        this.fDN = true;
        this.fDO = true;
        g(agVar, ahVar, ahVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ag agVar, final ah ahVar, ah ahVar2) {
        if (this.fDL) {
            this.fDN = true;
            this.fDO = true;
            if (agVar.auh == 2) {
                g(agVar, ahVar, ahVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f(ahVar);
                    }
                }, 5000L);
                return;
            }
            f(ahVar);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ag agVar, ah ahVar, ah ahVar2) {
    }

    private void g(ag agVar, ah ahVar, ah ahVar2) {
        if (agVar != null) {
            this.challengeId = agVar.challengeId;
        }
        if (ahVar != null) {
            if (ahVar.aue != null) {
                this.apl = ahVar.aue.userId;
            }
            if (ahVar.auq != null) {
                this.liveId = ahVar.auq.live_id;
            }
        }
        if (!this.fDL) {
            this.fDL = true;
            if (this.fDI != null) {
                this.fDI.um();
            }
            buK();
            buL();
            this.fDP = false;
            this.fDQ = false;
            if (this.fDH != null && this.fDG != null) {
                this.fDG.a(agVar, ahVar, ahVar2, true);
                this.fDG.setRivalUserViewBg(ahVar2);
                this.fDG.setAnchorUserViewBg(ahVar);
                if (this.fDI != null) {
                    this.fDI.a(agVar, ahVar, ahVar2);
                }
                if (this.fDH != null) {
                    this.fDH.a(this.mTbPageContext.getPageActivity(), this.fDG);
                }
            }
        }
        if (this.fDM && this.fDG != null) {
            this.fDG.a(agVar, ahVar, ahVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(n nVar) {
        if (nVar != null && nVar.aqe != null) {
            this.fDR = nVar.aqe.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ah ahVar) {
        if (this.fDI != null) {
            this.fDI.uo();
        }
        if (this.fDG != null) {
            this.fDG.setAnchorUserViewBg(ahVar);
        }
        if (this.fDG != null) {
            this.fDG.buE();
            this.fDG.buD();
            this.fDH.b(this.mTbPageContext.getPageActivity(), this.fDG);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void ug() {
        if (this.fDN) {
            if (this.fDI != null) {
                this.fDI.aR(true);
            }
            if (this.fDG != null) {
                this.fDG.buC();
            }
            this.fDP = false;
            this.fDQ = false;
            buP();
            buM();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        buP();
        this.fDH.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        this.fDH.xF();
        if (this.fDG != null) {
            this.fDG.releaseResource();
        }
        if (this.fDJ != null) {
            this.fDJ.buA();
        }
        this.fDN = false;
        this.fDL = false;
        this.fDM = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(boolean z, String str) {
        if (z) {
            this.fDO = true;
            this.fDG.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        bdAlertDialog.setNegativeButton(a.i.sdk_quit, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.fDK.uy();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setPositiveButton(a.i.ala_challenge_back_stay, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.i
    public boolean isActive() {
        return this.fDN;
    }

    @Override // com.baidu.live.challenge.i
    public int aS(boolean z) {
        int ax;
        int ay = g.ay(this.mTbPageContext.getPageActivity());
        if (z) {
            ax = g.aw(this.mTbPageContext.getPageActivity());
        } else {
            ax = g.ax(this.mTbPageContext.getPageActivity());
        }
        return ax + ay + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
