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
    private AlaChallengeLiveView fDL;
    private b fDM;
    private h fDN;
    private AlaChallengeCountDown fDO;
    private j fDP;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fDQ = false;
    private boolean fDR = false;
    private boolean fDS = false;
    private boolean fDT = true;
    private boolean fDU = false;
    private boolean fDV = false;
    private long challengeId = 0;
    private long aps = 0;
    private long liveId = -1;
    private long fDW = 0;
    private boolean isHost = false;
    private boolean fDX = false;
    private boolean fDY = false;
    private boolean fDZ = false;
    private b.a fEa = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buE() {
            if (c.this.fDL != null && c.this.fDL.getParent() != null) {
                c.this.fDR = true;
                if (c.this.fDN != null) {
                    c.this.fDN.um();
                }
                c.this.fDL.setCloseBtnVisible(true);
                c.this.fDL.setLiveContainerVisible(true);
                if (!com.baidu.live.c.tG().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.tG().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.fDY && !c.this.isHost) || (!c.this.fDX && c.this.isHost)) {
                        if (c.this.fDO == null) {
                            c.this.fDO = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.fDO.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.fDO.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.fDO.getParent() != null) {
                            ((ViewGroup) c.this.fDO.getParent()).removeView(c.this.fDO);
                        }
                        c.this.fDL.getLiveContainerView().addView(c.this.fDO, layoutParams);
                        c.this.fDO.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.fDU = true;
                }
                c.this.buL();
                c.this.buM();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buF() {
            if (c.this.fDL != null && c.this.fDL.getParent() != null) {
                c.this.fDS = false;
                if (c.this.fDN != null) {
                    c.this.fDN.aR(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.aps = c.this.aps;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.fDL.setLiveContainerVisible(false);
                c.this.fDU = true;
                c.this.fDV = true;
                c.this.buL();
                c.this.buM();
                c.this.fDU = false;
                c.this.fDV = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buG() {
            if (c.this.fDL != null && c.this.fDL.getParent() != null) {
                if (!c.this.fDS) {
                    c.this.buK();
                    c.this.buN();
                }
                c.this.fDU = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void buH() {
            c.this.fDV = false;
        }
    };
    private AlaChallengeLiveView.a fEb = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void buD() {
            c.this.buO();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(ah ahVar) {
            if (ahVar != null && ahVar.auk != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(ahVar.auk.userId), ahVar.auk.userName, ahVar.auk.portrait, ahVar.auk.sex, ahVar.auk.levelId, null, null, 0L, ahVar.auk.fansCount, ahVar.auk.followCount, ahVar.auk.userStatus, String.valueOf(ahVar.auw.group_id), String.valueOf(ahVar.auw.live_id), false, String.valueOf(c.this.fDW), ahVar.auk.appId, ahVar.auk.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(ah ahVar) {
            if (!c.this.isHost) {
                if (c.this.fDZ) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.fDL);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.En().aQu.ata || !TbadkCoreApplication.getInst().isMobileBaidu()) && ahVar != null && ahVar.auw != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(ahVar.auw.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fDM = new b(tbPageContext.getPageActivity());
        this.fDM.a(this.fEa);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.fDM.bv(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void f(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.fDY = z;
        this.isHost = z2;
        this.fDX = z3;
    }

    private void buI() {
        if (this.fDL == null) {
            this.fDL = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.fDL.setIsHost(this.isHost);
            this.fDL.setViewClickCallBack(this.fEb);
        }
    }

    private void buJ() {
        int i = 0;
        if (this.fDL != null && this.mParentView != null) {
            if (this.fDL.getParent() != null) {
                ((ViewGroup) this.fDL.getParent()).removeView(this.fDL);
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
            if (this.fDL.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.fDL, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.fDL, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        if (this.fDL != null && this.fDL.getParent() != null) {
            ((ViewGroup) this.fDL.getParent()).removeView(this.fDL);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.fDP = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.fDN = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void uo() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.fDR);
        }
        this.fDV = true;
        buM();
    }

    @Override // com.baidu.live.challenge.i
    public void bx(int i) {
        if (1 == i) {
            this.fDU = true;
            buL();
        }
        if (2 == i) {
            this.fDV = true;
            buM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        if (this.fDR && this.fDU) {
            this.fDM.e(this.fDL);
            if (this.fDL != null && this.fDL.getAnchorAnimLiveBgView() != null) {
                this.fDL.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.fDR && this.fDV) {
            this.fDM.d(this.fDL);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ag agVar, ah ahVar, ah ahVar2) {
        this.fDS = true;
        this.fDT = false;
        g(agVar, ahVar, ahVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ag agVar, ah ahVar, ah ahVar2) {
        this.fDS = true;
        this.fDT = true;
        g(agVar, ahVar, ahVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ag agVar, final ah ahVar, ah ahVar2) {
        if (this.fDQ) {
            this.fDS = true;
            this.fDT = true;
            if (agVar.aun == 2) {
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
            if (ahVar.auk != null) {
                this.aps = ahVar.auk.userId;
            }
            if (ahVar.auw != null) {
                this.liveId = ahVar.auw.live_id;
            }
        }
        if (!this.fDQ) {
            this.fDQ = true;
            if (this.fDN != null) {
                this.fDN.ul();
            }
            buI();
            buJ();
            this.fDU = false;
            this.fDV = false;
            if (this.fDM != null && this.fDL != null) {
                this.fDL.a(agVar, ahVar, ahVar2, true);
                this.fDL.setRivalUserViewBg(ahVar2);
                this.fDL.setAnchorUserViewBg(ahVar);
                if (this.fDN != null) {
                    this.fDN.a(agVar, ahVar, ahVar2);
                }
                if (this.fDM != null) {
                    this.fDM.a(this.mTbPageContext.getPageActivity(), this.fDL);
                }
            }
        }
        if (this.fDR && this.fDL != null) {
            this.fDL.a(agVar, ahVar, ahVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(n nVar) {
        if (nVar != null && nVar.aqk != null) {
            this.fDW = nVar.aqk.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ah ahVar) {
        if (this.fDN != null) {
            this.fDN.un();
        }
        if (this.fDL != null) {
            this.fDL.setAnchorUserViewBg(ahVar);
        }
        if (this.fDL != null) {
            this.fDL.buC();
            this.fDL.buB();
            this.fDM.b(this.mTbPageContext.getPageActivity(), this.fDL);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void uf() {
        if (this.fDS) {
            if (this.fDN != null) {
                this.fDN.aR(true);
            }
            if (this.fDL != null) {
                this.fDL.buA();
            }
            this.fDU = false;
            this.fDV = false;
            buN();
            buK();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        buN();
        this.fDM.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        this.fDM.xE();
        if (this.fDL != null) {
            this.fDL.releaseResource();
        }
        if (this.fDO != null) {
            this.fDO.buy();
        }
        this.fDS = false;
        this.fDQ = false;
        this.fDR = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(boolean z, String str) {
        if (z) {
            this.fDT = true;
            this.fDL.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
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
                c.this.fDP.ux();
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
        return this.fDS;
    }

    @Override // com.baidu.live.challenge.i
    public int aS(boolean z) {
        int al;
        int am = g.am(this.mTbPageContext.getPageActivity());
        if (z) {
            al = g.ak(this.mTbPageContext.getPageActivity());
        } else {
            al = g.al(this.mTbPageContext.getPageActivity());
        }
        return al + am + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
