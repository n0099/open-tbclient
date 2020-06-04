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
    private AlaChallengeLiveView fSa;
    private b fSb;
    private h fSc;
    private AlaChallengeCountDown fSd;
    private j fSe;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fSf = false;
    private boolean fSg = false;
    private boolean fSh = false;
    private boolean fSi = true;
    private boolean fSj = false;
    private boolean fSk = false;
    private long challengeId = 0;
    private long aul = 0;
    private long liveId = -1;
    private long fSl = 0;
    private boolean isHost = false;
    private boolean fSm = false;
    private boolean fSn = false;
    private boolean fSo = false;
    public boolean fRr = false;
    private b.a fSp = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAH() {
            if (c.this.fSa != null && c.this.fSa.getParent() != null) {
                c.this.fSg = true;
                if (c.this.fSc != null) {
                    c.this.fSc.vt();
                }
                c.this.fSa.setCloseBtnVisible(true);
                c.this.fSa.setLiveContainerVisible(true);
                if (!com.baidu.live.c.uN().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.uN().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.fSn && !c.this.isHost) || (!c.this.fSm && c.this.isHost)) {
                        if (c.this.fSd == null) {
                            c.this.fSd = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.fSd.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.fSd.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.fSd.getParent() != null) {
                            ((ViewGroup) c.this.fSd.getParent()).removeView(c.this.fSd);
                        }
                        c.this.fSa.getLiveContainerView().addView(c.this.fSd, layoutParams);
                        c.this.fSd.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.fSj = true;
                }
                c.this.bAO();
                c.this.bAP();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAI() {
            if (c.this.fSa != null && c.this.fSa.getParent() != null) {
                c.this.fSh = false;
                if (c.this.fSc != null) {
                    c.this.fSc.aU(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.aul = c.this.aul;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.fSa.setLiveContainerVisible(false);
                c.this.fSj = true;
                c.this.fSk = true;
                c.this.bAO();
                c.this.bAP();
                c.this.fSj = false;
                c.this.fSk = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAJ() {
            if (c.this.fSa != null && c.this.fSa.getParent() != null) {
                if (!c.this.fSh) {
                    c.this.bAN();
                    c.this.bAQ();
                }
                c.this.fSj = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bAK() {
            c.this.fSk = false;
        }
    };
    private AlaChallengeLiveView.a fSq = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bAF() {
            c.this.bAR();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(al alVar) {
            if (alVar != null && alVar.azo != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(alVar.azo.userId), alVar.azo.userName, alVar.azo.portrait, alVar.azo.sex, alVar.azo.levelId, null, null, 0L, alVar.azo.fansCount, alVar.azo.followCount, alVar.azo.userStatus, String.valueOf(alVar.azA.group_id), String.valueOf(alVar.azA.live_id), false, String.valueOf(c.this.fSl), alVar.azo.appId, alVar.azo.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(al alVar) {
            if (!c.this.isHost) {
                if (c.this.fSo) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.fSa);
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
        public void bAG() {
            if (c.this.fRr && c.this.fSc != null) {
                c.this.fSc.aV(c.this.fRr);
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fSb = new b(tbPageContext.getPageActivity());
        this.fSb.a(this.fSp);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.fSb.bz(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void j(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.fSn = z;
        this.isHost = z2;
        this.fSm = z3;
    }

    private void bAL() {
        if (this.fSa == null) {
            this.fSa = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.fSa.setIsHost(this.isHost);
            this.fSa.setViewClickCallBack(this.fSq);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRr = z;
        if (this.fSa != null) {
            this.fSa.setNeedCloseRecommendFloat(this.fRr);
        }
    }

    private void bAM() {
        int i = 0;
        if (this.fSa != null && this.mParentView != null) {
            if (this.fSa.getParent() != null) {
                ((ViewGroup) this.fSa.getParent()).removeView(this.fSa);
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
            if (this.fSa.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.fSa, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.fSa, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAN() {
        if (this.fSa != null && this.fSa.getParent() != null) {
            ((ViewGroup) this.fSa.getParent()).removeView(this.fSa);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.fSe = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.fSc = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void vv() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.fSg);
        }
        this.fSk = true;
        bAP();
    }

    @Override // com.baidu.live.challenge.i
    public void bG(int i) {
        if (1 == i) {
            this.fSj = true;
            bAO();
        }
        if (2 == i) {
            this.fSk = true;
            bAP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAO() {
        if (this.fSg && this.fSj) {
            this.fSb.e(this.fSa);
            if (this.fSa != null && this.fSa.getAnchorAnimLiveBgView() != null) {
                this.fSa.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        if (this.fSg && this.fSk) {
            this.fSb.d(this.fSa);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ak akVar, al alVar, al alVar2) {
        this.fSh = true;
        this.fSi = false;
        f(akVar, alVar, alVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ak akVar, al alVar, al alVar2) {
        this.fSh = true;
        this.fSi = true;
        f(akVar, alVar, alVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ak akVar, final al alVar, al alVar2) {
        long j = -1;
        if (this.fSf) {
            this.fSh = true;
            this.fSi = true;
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
        if (!this.fSf) {
            this.fSf = true;
            if (this.fSc != null) {
                this.fSc.vs();
            }
            bAL();
            bAM();
            this.fSj = false;
            this.fSk = false;
            if (this.fSb != null && this.fSa != null) {
                this.fSa.a(akVar, alVar, alVar2, true);
                this.fSa.setRivalUserViewBg(alVar2);
                this.fSa.setAnchorUserViewBg(alVar);
                if (this.fSc != null) {
                    this.fSc.a(akVar, alVar, alVar2);
                }
                if (this.fSb != null) {
                    this.fSb.a(this.mTbPageContext.getPageActivity(), this.fSa);
                }
            }
        }
        if (this.fSg && this.fSa != null) {
            this.fSa.a(akVar, alVar, alVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(q qVar) {
        if (qVar != null && qVar.avj != null) {
            this.fSl = qVar.avj.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(al alVar) {
        if (this.fSc != null) {
            this.fSc.vu();
        }
        if (this.fSa != null) {
            this.fSa.setAnchorUserViewBg(alVar);
        }
        if (this.fSa != null) {
            this.fSa.bAD();
            this.fSa.bAC();
            this.fSb.b(this.mTbPageContext.getPageActivity(), this.fSa);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void vm() {
        if (this.fSh) {
            if (this.fSc != null) {
                this.fSc.aU(true);
            }
            if (this.fSa != null) {
                this.fSa.bAB();
            }
            this.fSj = false;
            this.fSk = false;
            bAQ();
            this.mHandler.removeCallbacksAndMessages(null);
            bAN();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        bAQ();
        this.fSb.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAQ() {
        this.fSb.yR();
        if (this.fSa != null) {
            this.fSa.releaseResource();
        }
        if (this.fSd != null) {
            this.fSd.bAz();
        }
        this.fSh = false;
        this.fSf = false;
        this.fSg = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void c(boolean z, String str) {
        if (z) {
            this.fSi = true;
            this.fSa.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAR() {
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
                c.this.fSe.vE();
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
        return this.fSh;
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
