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
    private AlaChallengeLiveView eYV;
    private b eYW;
    private h eYX;
    private AlaChallengeCountDown eYY;
    private j eYZ;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eZa = false;
    private boolean eZb = false;
    private boolean eZc = false;
    private boolean eZd = true;
    private boolean eZe = false;
    private boolean eZf = false;
    private long challengeId = 0;
    private long WZ = 0;
    private long liveId = -1;
    private long eZg = 0;
    private boolean isHost = false;
    private boolean eZh = false;
    private boolean eZi = false;
    private boolean eZj = false;
    private b.a eZk = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bli() {
            if (c.this.eYV != null && c.this.eYV.getParent() != null) {
                c.this.eZb = true;
                if (c.this.eYX != null) {
                    c.this.eYX.pR();
                }
                c.this.eYV.setCloseBtnVisible(true);
                c.this.eYV.setLiveContainerVisible(true);
                if (!com.baidu.live.c.pr().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.pr().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eZi && !c.this.isHost) || (!c.this.eZh && c.this.isHost)) {
                        if (c.this.eYY == null) {
                            c.this.eYY = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eYY.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eYY.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eYY.getParent() != null) {
                            ((ViewGroup) c.this.eYY.getParent()).removeView(c.this.eYY);
                        }
                        c.this.eYV.getLiveContainerView().addView(c.this.eYY, layoutParams);
                        c.this.eYY.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eZe = true;
                }
                c.this.blp();
                c.this.blq();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blj() {
            if (c.this.eYV != null && c.this.eYV.getParent() != null) {
                c.this.eZc = false;
                if (c.this.eYX != null) {
                    c.this.eYX.at(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.WZ = c.this.WZ;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eYV.setLiveContainerVisible(false);
                c.this.eZe = true;
                c.this.eZf = true;
                c.this.blp();
                c.this.blq();
                c.this.eZe = false;
                c.this.eZf = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blk() {
            if (c.this.eYV != null && c.this.eYV.getParent() != null) {
                if (!c.this.eZc) {
                    c.this.blo();
                    c.this.blr();
                }
                c.this.eZe = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bll() {
            c.this.eZf = false;
        }
    };
    private AlaChallengeLiveView.a eZl = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void blh() {
            c.this.bls();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(ae aeVar) {
            if (aeVar != null && aeVar.abx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(aeVar.abx.userId), aeVar.abx.userName, aeVar.abx.portrait, aeVar.abx.sex, aeVar.abx.levelId, null, null, 0L, aeVar.abx.fansCount, aeVar.abx.followCount, aeVar.abx.userStatus, String.valueOf(aeVar.abJ.group_id), String.valueOf(aeVar.abJ.live_id), false, String.valueOf(c.this.eZg), aeVar.abx.appId, aeVar.abx.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(ae aeVar) {
            if (!c.this.isHost) {
                if (c.this.eZj) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eYV);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.zl().awC.aav || !TbadkCoreApplication.getInst().isMobileBaidu()) && aeVar != null && aeVar.abJ != null) {
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
        this.eYW = new b(tbPageContext.getPageActivity());
        this.eYW.a(this.eZk);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eYW.bp(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eZi = z;
        this.isHost = z2;
        this.eZh = z3;
    }

    private void blm() {
        if (this.eYV == null) {
            this.eYV = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eYV.setIsHost(this.isHost);
            this.eYV.setViewClickCallBack(this.eZl);
        }
    }

    private void bln() {
        int i = 0;
        if (this.eYV != null && this.mParentView != null) {
            if (this.eYV.getParent() != null) {
                ((ViewGroup) this.eYV.getParent()).removeView(this.eYV);
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
            if (this.eYV.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eYV, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eYV, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blo() {
        if (this.eYV != null && this.eYV.getParent() != null) {
            ((ViewGroup) this.eYV.getParent()).removeView(this.eYV);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eYZ = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eYX = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eZb);
        }
        this.eZf = true;
        blq();
    }

    @Override // com.baidu.live.challenge.i
    public void bk(int i) {
        if (1 == i) {
            this.eZe = true;
            blp();
        }
        if (2 == i) {
            this.eZf = true;
            blq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blp() {
        if (this.eZb && this.eZe) {
            this.eYW.e(this.eYV);
            if (this.eYV != null && this.eYV.getAnchorAnimLiveBgView() != null) {
                this.eYV.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        if (this.eZb && this.eZf) {
            this.eYW.d(this.eYV);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        this.eZc = true;
        this.eZd = false;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ad adVar, ae aeVar, ae aeVar2) {
        this.eZc = true;
        this.eZd = true;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ad adVar, final ae aeVar, ae aeVar2) {
        if (this.eZa) {
            this.eZc = true;
            this.eZd = true;
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
        if (!this.eZa) {
            this.eZa = true;
            if (this.eYX != null) {
                this.eYX.pQ();
            }
            blm();
            bln();
            this.eZe = false;
            this.eZf = false;
            if (this.eYW != null && this.eYV != null) {
                this.eYV.a(adVar, aeVar, aeVar2, true);
                this.eYV.setRivalUserViewBg(aeVar2);
                this.eYV.setAnchorUserViewBg(aeVar);
                if (this.eYX != null) {
                    this.eYX.a(adVar, aeVar, aeVar2);
                }
                if (this.eYW != null) {
                    this.eYW.a(this.mTbPageContext.getPageActivity(), this.eYV);
                }
            }
        }
        if (this.eZb && this.eYV != null) {
            this.eYV.a(adVar, aeVar, aeVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(m mVar) {
        if (mVar != null && mVar.XQ != null) {
            this.eZg = mVar.XQ.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ae aeVar) {
        if (this.eYX != null) {
            this.eYX.pS();
        }
        if (this.eYV != null) {
            this.eYV.setAnchorUserViewBg(aeVar);
        }
        if (this.eYV != null) {
            this.eYV.blg();
            this.eYV.blf();
            this.eYW.b(this.mTbPageContext.getPageActivity(), this.eYV);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void pK() {
        if (this.eZc) {
            if (this.eYX != null) {
                this.eYX.at(true);
            }
            if (this.eYV != null) {
                this.eYV.ble();
            }
            this.eZe = false;
            this.eZf = false;
            blr();
            blo();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        blr();
        this.eYW.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        this.eYW.th();
        if (this.eYV != null) {
            this.eYV.releaseResource();
        }
        if (this.eYY != null) {
            this.eYY.blc();
        }
        this.eZc = false;
        this.eZa = false;
        this.eZb = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void d(boolean z, String str) {
        if (z) {
            this.eZd = true;
            this.eYV.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
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
                c.this.eYZ.qc();
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
        return this.eZc;
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
