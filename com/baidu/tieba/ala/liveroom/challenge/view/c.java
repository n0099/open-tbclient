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
    private AlaChallengeLiveView eYH;
    private b eYI;
    private h eYJ;
    private AlaChallengeCountDown eYK;
    private j eYL;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eYM = false;
    private boolean eYN = false;
    private boolean eYO = false;
    private boolean eYP = true;
    private boolean eYQ = false;
    private boolean eYR = false;
    private long challengeId = 0;
    private long WZ = 0;
    private long liveId = -1;
    private long eYS = 0;
    private boolean isHost = false;
    private boolean eYT = false;
    private boolean eYU = false;
    private boolean eYV = false;
    private b.a eYW = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blf() {
            if (c.this.eYH != null && c.this.eYH.getParent() != null) {
                c.this.eYN = true;
                if (c.this.eYJ != null) {
                    c.this.eYJ.pR();
                }
                c.this.eYH.setCloseBtnVisible(true);
                c.this.eYH.setLiveContainerVisible(true);
                if (!com.baidu.live.c.pr().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.pr().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eYU && !c.this.isHost) || (!c.this.eYT && c.this.isHost)) {
                        if (c.this.eYK == null) {
                            c.this.eYK = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eYK.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eYK.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eYK.getParent() != null) {
                            ((ViewGroup) c.this.eYK.getParent()).removeView(c.this.eYK);
                        }
                        c.this.eYH.getLiveContainerView().addView(c.this.eYK, layoutParams);
                        c.this.eYK.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eYQ = true;
                }
                c.this.blm();
                c.this.bln();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blg() {
            if (c.this.eYH != null && c.this.eYH.getParent() != null) {
                c.this.eYO = false;
                if (c.this.eYJ != null) {
                    c.this.eYJ.at(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.WZ = c.this.WZ;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eYH.setLiveContainerVisible(false);
                c.this.eYQ = true;
                c.this.eYR = true;
                c.this.blm();
                c.this.bln();
                c.this.eYQ = false;
                c.this.eYR = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blh() {
            if (c.this.eYH != null && c.this.eYH.getParent() != null) {
                if (!c.this.eYO) {
                    c.this.bll();
                    c.this.blo();
                }
                c.this.eYQ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bli() {
            c.this.eYR = false;
        }
    };
    private AlaChallengeLiveView.a eYX = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void ble() {
            c.this.blp();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(ae aeVar) {
            if (aeVar != null && aeVar.abx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(aeVar.abx.userId), aeVar.abx.userName, aeVar.abx.portrait, aeVar.abx.sex, aeVar.abx.levelId, null, null, 0L, aeVar.abx.fansCount, aeVar.abx.followCount, aeVar.abx.userStatus, String.valueOf(aeVar.abJ.group_id), String.valueOf(aeVar.abJ.live_id), false, String.valueOf(c.this.eYS), aeVar.abx.appId, aeVar.abx.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(ae aeVar) {
            if (!c.this.isHost) {
                if (c.this.eYV) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eYH);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.zj().awA.aav || !TbadkCoreApplication.getInst().isMobileBaidu()) && aeVar != null && aeVar.abJ != null) {
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
        this.eYI = new b(tbPageContext.getPageActivity());
        this.eYI.a(this.eYW);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eYI.bp(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eYU = z;
        this.isHost = z2;
        this.eYT = z3;
    }

    private void blj() {
        if (this.eYH == null) {
            this.eYH = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eYH.setIsHost(this.isHost);
            this.eYH.setViewClickCallBack(this.eYX);
        }
    }

    private void blk() {
        int i = 0;
        if (this.eYH != null && this.mParentView != null) {
            if (this.eYH.getParent() != null) {
                ((ViewGroup) this.eYH.getParent()).removeView(this.eYH);
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
            if (this.eYH.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eYH, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eYH, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        if (this.eYH != null && this.eYH.getParent() != null) {
            ((ViewGroup) this.eYH.getParent()).removeView(this.eYH);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eYL = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eYJ = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eYN);
        }
        this.eYR = true;
        bln();
    }

    @Override // com.baidu.live.challenge.i
    public void bk(int i) {
        if (1 == i) {
            this.eYQ = true;
            blm();
        }
        if (2 == i) {
            this.eYR = true;
            bln();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blm() {
        if (this.eYN && this.eYQ) {
            this.eYI.e(this.eYH);
            if (this.eYH != null && this.eYH.getAnchorAnimLiveBgView() != null) {
                this.eYH.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        if (this.eYN && this.eYR) {
            this.eYI.d(this.eYH);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        this.eYO = true;
        this.eYP = false;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ad adVar, ae aeVar, ae aeVar2) {
        this.eYO = true;
        this.eYP = true;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ad adVar, final ae aeVar, ae aeVar2) {
        if (this.eYM) {
            this.eYO = true;
            this.eYP = true;
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
        if (!this.eYM) {
            this.eYM = true;
            if (this.eYJ != null) {
                this.eYJ.pQ();
            }
            blj();
            blk();
            this.eYQ = false;
            this.eYR = false;
            if (this.eYI != null && this.eYH != null) {
                this.eYH.a(adVar, aeVar, aeVar2, true);
                this.eYH.setRivalUserViewBg(aeVar2);
                this.eYH.setAnchorUserViewBg(aeVar);
                if (this.eYJ != null) {
                    this.eYJ.a(adVar, aeVar, aeVar2);
                }
                if (this.eYI != null) {
                    this.eYI.a(this.mTbPageContext.getPageActivity(), this.eYH);
                }
            }
        }
        if (this.eYN && this.eYH != null) {
            this.eYH.a(adVar, aeVar, aeVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(m mVar) {
        if (mVar != null && mVar.XQ != null) {
            this.eYS = mVar.XQ.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ae aeVar) {
        if (this.eYJ != null) {
            this.eYJ.pS();
        }
        if (this.eYH != null) {
            this.eYH.setAnchorUserViewBg(aeVar);
        }
        if (this.eYH != null) {
            this.eYH.bld();
            this.eYH.blc();
            this.eYI.b(this.mTbPageContext.getPageActivity(), this.eYH);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void pK() {
        if (this.eYO) {
            if (this.eYJ != null) {
                this.eYJ.at(true);
            }
            if (this.eYH != null) {
                this.eYH.blb();
            }
            this.eYQ = false;
            this.eYR = false;
            blo();
            bll();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        blo();
        this.eYI.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blo() {
        this.eYI.th();
        if (this.eYH != null) {
            this.eYH.releaseResource();
        }
        if (this.eYK != null) {
            this.eYK.bkZ();
        }
        this.eYO = false;
        this.eYM = false;
        this.eYN = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void d(boolean z, String str) {
        if (z) {
            this.eYP = true;
            this.eYH.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blp() {
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
                c.this.eYL.qc();
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
        return this.eYO;
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
