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
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.q;
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
    private AlaChallengeLiveView fRP;
    private b fRQ;
    private h fRR;
    private AlaChallengeCountDown fRS;
    private j fRT;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fRU = false;
    private boolean fRV = false;
    private boolean fRW = false;
    private boolean fRX = true;
    private boolean fRY = false;
    private boolean fRZ = false;
    private long challengeId = 0;
    private long aul = 0;
    private long liveId = -1;
    private long fSa = 0;
    private boolean isHost = false;
    private boolean fSb = false;
    private boolean fSc = false;
    private boolean fSd = false;
    public boolean fRg = false;
    private b.a fSe = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAF() {
            if (c.this.fRP != null && c.this.fRP.getParent() != null) {
                c.this.fRV = true;
                if (c.this.fRR != null) {
                    c.this.fRR.vt();
                }
                c.this.fRP.setCloseBtnVisible(true);
                c.this.fRP.setLiveContainerVisible(true);
                if (!com.baidu.live.c.uN().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.uN().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.fSc && !c.this.isHost) || (!c.this.fSb && c.this.isHost)) {
                        if (c.this.fRS == null) {
                            c.this.fRS = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.fRS.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.fRS.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.fRS.getParent() != null) {
                            ((ViewGroup) c.this.fRS.getParent()).removeView(c.this.fRS);
                        }
                        c.this.fRP.getLiveContainerView().addView(c.this.fRS, layoutParams);
                        c.this.fRS.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.fRY = true;
                }
                c.this.bAM();
                c.this.bAN();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAG() {
            if (c.this.fRP != null && c.this.fRP.getParent() != null) {
                c.this.fRW = false;
                if (c.this.fRR != null) {
                    c.this.fRR.aU(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.aul = c.this.aul;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.fRP.setLiveContainerVisible(false);
                c.this.fRY = true;
                c.this.fRZ = true;
                c.this.bAM();
                c.this.bAN();
                c.this.fRY = false;
                c.this.fRZ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAH() {
            if (c.this.fRP != null && c.this.fRP.getParent() != null) {
                if (!c.this.fRW) {
                    c.this.bAL();
                    c.this.bAO();
                }
                c.this.fRY = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAI() {
            c.this.fRZ = false;
        }
    };
    private AlaChallengeLiveView.a fSf = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bAD() {
            c.this.bAP();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(al alVar) {
            if (alVar != null && alVar.azo != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(alVar.azo.userId), alVar.azo.userName, alVar.azo.portrait, alVar.azo.sex, alVar.azo.levelId, null, null, 0L, alVar.azo.fansCount, alVar.azo.followCount, alVar.azo.userStatus, String.valueOf(alVar.azA.group_id), String.valueOf(alVar.azA.live_id), false, String.valueOf(c.this.fSa), alVar.azo.appId, alVar.azo.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(al alVar) {
            if (!c.this.isHost) {
                if (c.this.fSd) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.fRP);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.Ge().aWF.aya || !TbadkCoreApplication.getInst().isMobileBaidu()) && alVar != null && alVar.azA != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(alVar.azA.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bAE() {
            if (c.this.fRg && c.this.fRR != null) {
                c.this.fRR.aV(c.this.fRg);
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fRQ = new b(tbPageContext.getPageActivity());
        this.fRQ.a(this.fSe);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.fRQ.bz(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void j(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.fSc = z;
        this.isHost = z2;
        this.fSb = z3;
    }

    private void bAJ() {
        if (this.fRP == null) {
            this.fRP = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.fRP.setIsHost(this.isHost);
            this.fRP.setViewClickCallBack(this.fSf);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRg = z;
        if (this.fRP != null) {
            this.fRP.setNeedCloseRecommendFloat(this.fRg);
        }
    }

    private void bAK() {
        int i = 0;
        if (this.fRP != null && this.mParentView != null) {
            if (this.fRP.getParent() != null) {
                ((ViewGroup) this.fRP.getParent()).removeView(this.fRP);
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
            if (this.fRP.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.fRP, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.fRP, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAL() {
        if (this.fRP != null && this.fRP.getParent() != null) {
            ((ViewGroup) this.fRP.getParent()).removeView(this.fRP);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.fRT = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.fRR = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void vv() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.fRV);
        }
        this.fRZ = true;
        bAN();
    }

    @Override // com.baidu.live.challenge.i
    public void bE(int i) {
        if (1 == i) {
            this.fRY = true;
            bAM();
        }
        if (2 == i) {
            this.fRZ = true;
            bAN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAM() {
        if (this.fRV && this.fRY) {
            this.fRQ.e(this.fRP);
            if (this.fRP != null && this.fRP.getAnchorAnimLiveBgView() != null) {
                this.fRP.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAN() {
        if (this.fRV && this.fRZ) {
            this.fRQ.d(this.fRP);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ak akVar, al alVar, al alVar2) {
        this.fRW = true;
        this.fRX = false;
        f(akVar, alVar, alVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ak akVar, al alVar, al alVar2) {
        this.fRW = true;
        this.fRX = true;
        f(akVar, alVar, alVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ak akVar, final al alVar, al alVar2) {
        long j = -1;
        if (this.fRU) {
            this.fRW = true;
            this.fRX = true;
            if (akVar.azr == 2) {
                f(akVar, alVar, alVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f(alVar);
                    }
                }, 5000L);
                return;
            }
            f(alVar);
            return;
        }
        long j2 = akVar != null ? akVar.challengeId : -1L;
        if (alVar != null && alVar.azA != null) {
            j = alVar.azA.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ak akVar, al alVar, al alVar2) {
    }

    private void f(ak akVar, al alVar, al alVar2) {
        if (akVar != null) {
            this.challengeId = akVar.challengeId;
        }
        if (alVar != null) {
            if (alVar.azo != null) {
                this.aul = alVar.azo.userId;
            }
            if (alVar.azA != null) {
                this.liveId = alVar.azA.live_id;
            }
        }
        if (!this.fRU) {
            this.fRU = true;
            if (this.fRR != null) {
                this.fRR.vs();
            }
            bAJ();
            bAK();
            this.fRY = false;
            this.fRZ = false;
            if (this.fRQ != null && this.fRP != null) {
                this.fRP.a(akVar, alVar, alVar2, true);
                this.fRP.setRivalUserViewBg(alVar2);
                this.fRP.setAnchorUserViewBg(alVar);
                if (this.fRR != null) {
                    this.fRR.a(akVar, alVar, alVar2);
                }
                if (this.fRQ != null) {
                    this.fRQ.a(this.mTbPageContext.getPageActivity(), this.fRP);
                }
            }
        }
        if (this.fRV && this.fRP != null) {
            this.fRP.a(akVar, alVar, alVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(q qVar) {
        if (qVar != null && qVar.avj != null) {
            this.fSa = qVar.avj.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(al alVar) {
        if (this.fRR != null) {
            this.fRR.vu();
        }
        if (this.fRP != null) {
            this.fRP.setAnchorUserViewBg(alVar);
        }
        if (this.fRP != null) {
            this.fRP.bAB();
            this.fRP.bAA();
            this.fRQ.b(this.mTbPageContext.getPageActivity(), this.fRP);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vm() {
        if (this.fRW) {
            if (this.fRR != null) {
                this.fRR.aU(true);
            }
            if (this.fRP != null) {
                this.fRP.bAz();
            }
            this.fRY = false;
            this.fRZ = false;
            bAO();
            this.mHandler.removeCallbacksAndMessages(null);
            bAL();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        bAO();
        this.fRQ.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        this.fRQ.yR();
        if (this.fRP != null) {
            this.fRP.releaseResource();
        }
        if (this.fRS != null) {
            this.fRS.bAx();
        }
        this.fRW = false;
        this.fRU = false;
        this.fRV = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(boolean z, String str) {
        if (z) {
            this.fRX = true;
            this.fRP.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
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
                c.this.fRT.vE();
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
        return this.fRW;
    }

    @Override // com.baidu.live.challenge.i
    public int aW(boolean z) {
        int av;
        int aw = g.aw(this.mTbPageContext.getPageActivity());
        if (z) {
            av = g.au(this.mTbPageContext.getPageActivity());
        } else {
            av = g.av(this.mTbPageContext.getPageActivity());
        }
        return av + aw + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
