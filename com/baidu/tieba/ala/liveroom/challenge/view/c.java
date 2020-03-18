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
    private AlaChallengeLiveView eZt;
    private b eZu;
    private h eZv;
    private AlaChallengeCountDown eZw;
    private j eZx;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eZy = false;
    private boolean eZz = false;
    private boolean eZA = false;
    private boolean eZB = true;
    private boolean eZC = false;
    private boolean eZD = false;
    private long challengeId = 0;
    private long Xj = 0;
    private long liveId = -1;
    private long eZE = 0;
    private boolean isHost = false;
    private boolean eZF = false;
    private boolean eZG = false;
    private boolean eZH = false;
    private b.a eZI = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bln() {
            if (c.this.eZt != null && c.this.eZt.getParent() != null) {
                c.this.eZz = true;
                if (c.this.eZv != null) {
                    c.this.eZv.pW();
                }
                c.this.eZt.setCloseBtnVisible(true);
                c.this.eZt.setLiveContainerVisible(true);
                if (!com.baidu.live.c.pw().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.pw().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eZG && !c.this.isHost) || (!c.this.eZF && c.this.isHost)) {
                        if (c.this.eZw == null) {
                            c.this.eZw = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eZw.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eZw.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eZw.getParent() != null) {
                            ((ViewGroup) c.this.eZw.getParent()).removeView(c.this.eZw);
                        }
                        c.this.eZt.getLiveContainerView().addView(c.this.eZw, layoutParams);
                        c.this.eZw.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eZC = true;
                }
                c.this.blu();
                c.this.blv();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blo() {
            if (c.this.eZt != null && c.this.eZt.getParent() != null) {
                c.this.eZA = false;
                if (c.this.eZv != null) {
                    c.this.eZv.at(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.Xj = c.this.Xj;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eZt.setLiveContainerVisible(false);
                c.this.eZC = true;
                c.this.eZD = true;
                c.this.blu();
                c.this.blv();
                c.this.eZC = false;
                c.this.eZD = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blp() {
            if (c.this.eZt != null && c.this.eZt.getParent() != null) {
                if (!c.this.eZA) {
                    c.this.blt();
                    c.this.blw();
                }
                c.this.eZC = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void blq() {
            c.this.eZD = false;
        }
    };
    private AlaChallengeLiveView.a eZJ = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void blm() {
            c.this.blx();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(ae aeVar) {
            if (aeVar != null && aeVar.abH != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(aeVar.abH.userId), aeVar.abH.userName, aeVar.abH.portrait, aeVar.abH.sex, aeVar.abH.levelId, null, null, 0L, aeVar.abH.fansCount, aeVar.abH.followCount, aeVar.abH.userStatus, String.valueOf(aeVar.abT.group_id), String.valueOf(aeVar.abT.live_id), false, String.valueOf(c.this.eZE), aeVar.abH.appId, aeVar.abH.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(ae aeVar) {
            if (!c.this.isHost) {
                if (c.this.eZH) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eZt);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.zs().awM.aaF || !TbadkCoreApplication.getInst().isMobileBaidu()) && aeVar != null && aeVar.abT != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(aeVar.abT.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eZu = new b(tbPageContext.getPageActivity());
        this.eZu.a(this.eZI);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eZu.bq(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eZG = z;
        this.isHost = z2;
        this.eZF = z3;
    }

    private void blr() {
        if (this.eZt == null) {
            this.eZt = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eZt.setIsHost(this.isHost);
            this.eZt.setViewClickCallBack(this.eZJ);
        }
    }

    private void bls() {
        int i = 0;
        if (this.eZt != null && this.mParentView != null) {
            if (this.eZt.getParent() != null) {
                ((ViewGroup) this.eZt.getParent()).removeView(this.eZt);
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
            if (this.eZt.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eZt, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eZt, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.eZt != null && this.eZt.getParent() != null) {
            ((ViewGroup) this.eZt.getParent()).removeView(this.eZt);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eZx = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eZv = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pY() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eZz);
        }
        this.eZD = true;
        blv();
    }

    @Override // com.baidu.live.challenge.i
    public void bk(int i) {
        if (1 == i) {
            this.eZC = true;
            blu();
        }
        if (2 == i) {
            this.eZD = true;
            blv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blu() {
        if (this.eZz && this.eZC) {
            this.eZu.e(this.eZt);
            if (this.eZt != null && this.eZt.getAnchorAnimLiveBgView() != null) {
                this.eZt.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blv() {
        if (this.eZz && this.eZD) {
            this.eZu.d(this.eZt);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ad adVar, ae aeVar, ae aeVar2) {
        this.eZA = true;
        this.eZB = false;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ad adVar, ae aeVar, ae aeVar2) {
        this.eZA = true;
        this.eZB = true;
        g(adVar, aeVar, aeVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ad adVar, final ae aeVar, ae aeVar2) {
        if (this.eZy) {
            this.eZA = true;
            this.eZB = true;
            if (adVar.abK == 2) {
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
            if (aeVar.abH != null) {
                this.Xj = aeVar.abH.userId;
            }
            if (aeVar.abT != null) {
                this.liveId = aeVar.abT.live_id;
            }
        }
        if (!this.eZy) {
            this.eZy = true;
            if (this.eZv != null) {
                this.eZv.pV();
            }
            blr();
            bls();
            this.eZC = false;
            this.eZD = false;
            if (this.eZu != null && this.eZt != null) {
                this.eZt.a(adVar, aeVar, aeVar2, true);
                this.eZt.setRivalUserViewBg(aeVar2);
                this.eZt.setAnchorUserViewBg(aeVar);
                if (this.eZv != null) {
                    this.eZv.a(adVar, aeVar, aeVar2);
                }
                if (this.eZu != null) {
                    this.eZu.a(this.mTbPageContext.getPageActivity(), this.eZt);
                }
            }
        }
        if (this.eZz && this.eZt != null) {
            this.eZt.a(adVar, aeVar, aeVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(m mVar) {
        if (mVar != null && mVar.Ya != null) {
            this.eZE = mVar.Ya.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ae aeVar) {
        if (this.eZv != null) {
            this.eZv.pX();
        }
        if (this.eZt != null) {
            this.eZt.setAnchorUserViewBg(aeVar);
        }
        if (this.eZt != null) {
            this.eZt.bll();
            this.eZt.blk();
            this.eZu.b(this.mTbPageContext.getPageActivity(), this.eZt);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void pP() {
        if (this.eZA) {
            if (this.eZv != null) {
                this.eZv.at(true);
            }
            if (this.eZt != null) {
                this.eZt.blj();
            }
            this.eZC = false;
            this.eZD = false;
            blw();
            blt();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        blw();
        this.eZu.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blw() {
        this.eZu.tm();
        if (this.eZt != null) {
            this.eZt.releaseResource();
        }
        if (this.eZw != null) {
            this.eZw.blh();
        }
        this.eZA = false;
        this.eZy = false;
        this.eZz = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void d(boolean z, String str) {
        if (z) {
            this.eZB = true;
            this.eZt.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
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
                c.this.eZx.qh();
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
        return this.eZA;
    }

    @Override // com.baidu.live.challenge.i
    public int au(boolean z) {
        int aK;
        int aL = g.aL(this.mTbPageContext.getPageActivity());
        if (z) {
            aK = g.aJ(this.mTbPageContext.getPageActivity());
        } else {
            aK = g.aK(this.mTbPageContext.getPageActivity());
        }
        return aK + aL + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
