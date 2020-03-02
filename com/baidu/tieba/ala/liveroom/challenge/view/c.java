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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.m;
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
    private AlaChallengeLiveView eYI;
    private b eYJ;
    private h eYK;
    private AlaChallengeCountDown eYL;
    private j eYM;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eYN = false;
    private boolean eYO = false;
    private boolean eYP = false;
    private boolean eYQ = true;
    private boolean eYR = false;
    private boolean eYS = false;
    private long challengeId = 0;
    private long WZ = 0;
    private long liveId = -1;
    private long eYT = 0;
    private boolean isHost = false;
    private boolean eYU = false;
    private boolean eYV = false;
    private boolean eYW = false;
    private b.a eYX = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blh() {
            if (c.this.eYI != null && c.this.eYI.getParent() != null) {
                c.this.eYO = true;
                if (c.this.eYK != null) {
                    c.this.eYK.pR();
                }
                c.this.eYI.setCloseBtnVisible(true);
                c.this.eYI.setLiveContainerVisible(true);
                if (!com.baidu.live.c.pr().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.pr().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eYV && !c.this.isHost) || (!c.this.eYU && c.this.isHost)) {
                        if (c.this.eYL == null) {
                            c.this.eYL = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eYL.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eYL.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eYL.getParent() != null) {
                            ((ViewGroup) c.this.eYL.getParent()).removeView(c.this.eYL);
                        }
                        c.this.eYI.getLiveContainerView().addView(c.this.eYL, layoutParams);
                        c.this.eYL.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eYR = true;
                }
                c.this.blo();
                c.this.blp();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bli() {
            if (c.this.eYI != null && c.this.eYI.getParent() != null) {
                c.this.eYP = false;
                if (c.this.eYK != null) {
                    c.this.eYK.at(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.WZ = c.this.WZ;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eYI.setLiveContainerVisible(false);
                c.this.eYR = true;
                c.this.eYS = true;
                c.this.blo();
                c.this.blp();
                c.this.eYR = false;
                c.this.eYS = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blj() {
            if (c.this.eYI != null && c.this.eYI.getParent() != null) {
                if (!c.this.eYP) {
                    c.this.bln();
                    c.this.blq();
                }
                c.this.eYR = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blk() {
            c.this.eYS = false;
        }
    };
    private AlaChallengeLiveView.a eYY = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void blg() {
            c.this.blr();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(ae aeVar) {
            if (aeVar != null && aeVar.abx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(aeVar.abx.userId), aeVar.abx.userName, aeVar.abx.portrait, aeVar.abx.sex, aeVar.abx.levelId, null, null, 0L, aeVar.abx.fansCount, aeVar.abx.followCount, aeVar.abx.userStatus, String.valueOf(aeVar.abJ.group_id), String.valueOf(aeVar.abJ.live_id), false, String.valueOf(c.this.eYT), aeVar.abx.appId, aeVar.abx.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(ae aeVar) {
            if (!c.this.isHost) {
                if (c.this.eYW) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eYI);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.zl().awB.aav || !TbadkCoreApplication.getInst().isMobileBaidu()) && aeVar != null && aeVar.abJ != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(aeVar.abJ.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eYJ = new b(tbPageContext.getPageActivity());
        this.eYJ.a(this.eYX);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eYJ.bp(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eYV = z;
        this.isHost = z2;
        this.eYU = z3;
    }

    private void bll() {
        if (this.eYI == null) {
            this.eYI = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eYI.setIsHost(this.isHost);
            this.eYI.setViewClickCallBack(this.eYY);
        }
    }

    private void blm() {
        int i = 0;
        if (this.eYI != null && this.mParentView != null) {
            if (this.eYI.getParent() != null) {
                ((ViewGroup) this.eYI.getParent()).removeView(this.eYI);
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
            if (this.eYI.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eYI, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eYI, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        if (this.eYI != null && this.eYI.getParent() != null) {
            ((ViewGroup) this.eYI.getParent()).removeView(this.eYI);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eYM = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eYK = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eYO);
        }
        this.eYS = true;
        blp();
    }

    @Override // com.baidu.live.challenge.i
    public void bk(int i) {
        if (1 == i) {
            this.eYR = true;
            blo();
        }
        if (2 == i) {
            this.eYS = true;
            blp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blo() {
        if (this.eYO && this.eYR) {
            this.eYJ.e(this.eYI);
            if (this.eYI != null && this.eYI.getAnchorAnimLiveBgView() != null) {
                this.eYI.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blp() {
        if (this.eYO && this.eYS) {
            this.eYJ.d(this.eYI);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        this.eYP = true;
        this.eYQ = false;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ad adVar, ae aeVar, ae aeVar2) {
        this.eYP = true;
        this.eYQ = true;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ad adVar, final ae aeVar, ae aeVar2) {
        if (this.eYN) {
            this.eYP = true;
            this.eYQ = true;
            if (adVar.abA == 2) {
                g(adVar, aeVar, aeVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.d(aeVar);
                    }
                }, 5000L);
                return;
            }
            d(aeVar);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ad adVar, ae aeVar, ae aeVar2) {
    }

    private void g(ad adVar, ae aeVar, ae aeVar2) {
        if (adVar != null) {
            this.challengeId = adVar.challengeId;
        }
        if (aeVar != null) {
            if (aeVar.abx != null) {
                this.WZ = aeVar.abx.userId;
            }
            if (aeVar.abJ != null) {
                this.liveId = aeVar.abJ.live_id;
            }
        }
        if (!this.eYN) {
            this.eYN = true;
            if (this.eYK != null) {
                this.eYK.pQ();
            }
            bll();
            blm();
            this.eYR = false;
            this.eYS = false;
            if (this.eYJ != null && this.eYI != null) {
                this.eYI.a(adVar, aeVar, aeVar2, true);
                this.eYI.setRivalUserViewBg(aeVar2);
                this.eYI.setAnchorUserViewBg(aeVar);
                if (this.eYK != null) {
                    this.eYK.a(adVar, aeVar, aeVar2);
                }
                if (this.eYJ != null) {
                    this.eYJ.a(this.mTbPageContext.getPageActivity(), this.eYI);
                }
            }
        }
        if (this.eYO && this.eYI != null) {
            this.eYI.a(adVar, aeVar, aeVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(m mVar) {
        if (mVar != null && mVar.XQ != null) {
            this.eYT = mVar.XQ.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ae aeVar) {
        if (this.eYK != null) {
            this.eYK.pS();
        }
        if (this.eYI != null) {
            this.eYI.setAnchorUserViewBg(aeVar);
        }
        if (this.eYI != null) {
            this.eYI.blf();
            this.eYI.ble();
            this.eYJ.b(this.mTbPageContext.getPageActivity(), this.eYI);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void pK() {
        if (this.eYP) {
            if (this.eYK != null) {
                this.eYK.at(true);
            }
            if (this.eYI != null) {
                this.eYI.bld();
            }
            this.eYR = false;
            this.eYS = false;
            blq();
            bln();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        blq();
        this.eYJ.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        this.eYJ.th();
        if (this.eYI != null) {
            this.eYI.releaseResource();
        }
        if (this.eYL != null) {
            this.eYL.blb();
        }
        this.eYP = false;
        this.eYN = false;
        this.eYO = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void d(boolean z, String str) {
        if (z) {
            this.eYQ = true;
            this.eYI.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
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
                c.this.eYM.qc();
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
        return this.eYP;
    }

    @Override // com.baidu.live.challenge.i
    public int au(boolean z) {
        int aL;
        int aM = g.aM(this.mTbPageContext.getPageActivity());
        if (z) {
            aL = g.aK(this.mTbPageContext.getPageActivity());
        } else {
            aL = g.aL(this.mTbPageContext.getPageActivity());
        }
        return aL + aM + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
