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
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.b;
/* loaded from: classes2.dex */
public class c implements i {
    private AlaChallengeLiveView eUQ;
    private b eUR;
    private h eUS;
    private AlaChallengeCountDown eUT;
    private j eUU;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eUV = false;
    private boolean eUW = false;
    private boolean eUX = false;
    private boolean eUY = true;
    private boolean eUZ = false;
    private boolean eVa = false;
    private long challengeId = 0;
    private long Vt = 0;
    private long liveId = -1;
    private long eVb = 0;
    private boolean isHost = false;
    private boolean eVc = false;
    private boolean eVd = false;
    private boolean eVe = false;
    private b.a eVf = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bjq() {
            if (c.this.eUQ != null && c.this.eUQ.getParent() != null) {
                c.this.eUW = true;
                if (c.this.eUS != null) {
                    c.this.eUS.pg();
                }
                c.this.eUQ.setCloseBtnVisible(true);
                c.this.eUQ.setLiveContainerVisible(true);
                if (!com.baidu.live.c.oJ().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.oJ().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eVd && !c.this.isHost) || (!c.this.eVc && c.this.isHost)) {
                        if (c.this.eUT == null) {
                            c.this.eUT = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eUT.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eUT.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eUT.getParent() != null) {
                            ((ViewGroup) c.this.eUT.getParent()).removeView(c.this.eUT);
                        }
                        c.this.eUQ.getLiveContainerView().addView(c.this.eUT, layoutParams);
                        c.this.eUT.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eUZ = true;
                }
                c.this.bjx();
                c.this.bjy();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bjr() {
            if (c.this.eUQ != null && c.this.eUQ.getParent() != null) {
                c.this.eUX = false;
                if (c.this.eUS != null) {
                    c.this.eUS.aq(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.Vt = c.this.Vt;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eUQ.setLiveContainerVisible(false);
                c.this.eUZ = true;
                c.this.eVa = true;
                c.this.bjx();
                c.this.bjy();
                c.this.eUZ = false;
                c.this.eVa = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bjs() {
            if (c.this.eUQ != null && c.this.eUQ.getParent() != null) {
                if (!c.this.eUX) {
                    c.this.bjw();
                    c.this.bjz();
                }
                c.this.eUZ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void bjt() {
            c.this.eVa = false;
        }
    };
    private AlaChallengeLiveView.a eVg = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bjp() {
            c.this.bjA();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(ad adVar) {
            if (adVar != null && adVar.ZC != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(adVar.ZC.userId), adVar.ZC.userName, adVar.ZC.portrait, adVar.ZC.sex, adVar.ZC.levelId, null, null, 0L, adVar.ZC.fansCount, adVar.ZC.followCount, adVar.ZC.userStatus, String.valueOf(adVar.ZO.group_id), String.valueOf(adVar.ZO.live_id), false, String.valueOf(c.this.eVb), adVar.ZC.appId, adVar.ZC.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(ad adVar) {
            if (!c.this.isHost) {
                if (c.this.eVe) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eUQ);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.s.a.wR().asq.YD || !TbadkCoreApplication.getInst().isMobileBaidu()) && adVar != null && adVar.ZO != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(adVar.ZO.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eUR = new b(tbPageContext.getPageActivity());
        this.eUR.a(this.eVf);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eUR.bo(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eVd = z;
        this.isHost = z2;
        this.eVc = z3;
    }

    private void bju() {
        if (this.eUQ == null) {
            this.eUQ = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eUQ.setIsHost(this.isHost);
            this.eUQ.setViewClickCallBack(this.eVg);
        }
    }

    private void bjv() {
        int i = 0;
        if (this.eUQ != null && this.mParentView != null) {
            if (this.eUQ.getParent() != null) {
                ((ViewGroup) this.eUQ.getParent()).removeView(this.eUQ);
            }
            int i2 = this.mParentView.getChildCount() >= 2 ? 2 : 0;
            while (true) {
                if (i >= this.mParentView.getChildCount()) {
                    i = i2;
                    break;
                } else if (this.mParentView.getChildAt(i) instanceof com.baidu.live.liveroom.e.a) {
                    break;
                } else {
                    i++;
                }
            }
            if (this.eUQ.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eUQ, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eUQ, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjw() {
        if (this.eUQ != null && this.eUQ.getParent() != null) {
            ((ViewGroup) this.eUQ.getParent()).removeView(this.eUQ);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eUU = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eUS = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pi() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eUW);
        }
        this.eVa = true;
        bjy();
    }

    @Override // com.baidu.live.challenge.i
    public void bd(int i) {
        if (1 == i) {
            this.eUZ = true;
            bjx();
        }
        if (2 == i) {
            this.eVa = true;
            bjy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjx() {
        if (this.eUW && this.eUZ) {
            this.eUR.e(this.eUQ);
            if (this.eUQ != null && this.eUQ.getAnchorAnimLiveBgView() != null) {
                this.eUQ.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        if (this.eUW && this.eVa) {
            this.eUR.d(this.eUQ);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void b(ac acVar, ad adVar, ad adVar2) {
        this.eUX = true;
        this.eUY = false;
        g(acVar, adVar, adVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void c(ac acVar, ad adVar, ad adVar2) {
        this.eUX = true;
        this.eUY = true;
        g(acVar, adVar, adVar2);
    }

    @Override // com.baidu.live.challenge.j.c
    public void d(ac acVar, final ad adVar, ad adVar2) {
        if (this.eUV) {
            this.eUX = true;
            this.eUY = true;
            if (acVar.ZF == 2) {
                g(acVar, adVar, adVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.d(adVar);
                    }
                }, 5000L);
                return;
            }
            d(adVar);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void e(ac acVar, ad adVar, ad adVar2) {
    }

    private void g(ac acVar, ad adVar, ad adVar2) {
        if (acVar != null) {
            this.challengeId = acVar.challengeId;
        }
        if (adVar != null) {
            if (adVar.ZC != null) {
                this.Vt = adVar.ZC.userId;
            }
            if (adVar.ZO != null) {
                this.liveId = adVar.ZO.live_id;
            }
        }
        if (!this.eUV) {
            this.eUV = true;
            if (this.eUS != null) {
                this.eUS.pf();
            }
            bju();
            bjv();
            this.eUZ = false;
            this.eVa = false;
            if (this.eUR != null && this.eUQ != null) {
                this.eUQ.a(acVar, adVar, adVar2, true);
                this.eUQ.setRivalUserViewBg(adVar2);
                this.eUQ.setAnchorUserViewBg(adVar);
                if (this.eUS != null) {
                    this.eUS.a(acVar, adVar, adVar2);
                }
                if (this.eUR != null) {
                    this.eUR.a(this.mTbPageContext.getPageActivity(), this.eUQ);
                }
            }
        }
        if (this.eUW && this.eUQ != null) {
            this.eUQ.a(acVar, adVar, adVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(l lVar) {
        if (lVar != null && lVar.Wf != null) {
            this.eVb = lVar.Wf.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ad adVar) {
        if (this.eUS != null) {
            this.eUS.ph();
        }
        if (this.eUQ != null) {
            this.eUQ.setAnchorUserViewBg(adVar);
        }
        if (this.eUQ != null) {
            this.eUQ.bjo();
            this.eUQ.bjn();
            this.eUR.b(this.mTbPageContext.getPageActivity(), this.eUQ);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void oZ() {
        if (this.eUX) {
            if (this.eUS != null) {
                this.eUS.aq(true);
            }
            if (this.eUQ != null) {
                this.eUQ.bjm();
            }
            this.eUZ = false;
            this.eVa = false;
            bjz();
            bjw();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        bjz();
        this.eUR.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjz() {
        this.eUR.rW();
        if (this.eUQ != null) {
            this.eUQ.releaseResource();
        }
        if (this.eUT != null) {
            this.eUT.bjk();
        }
        this.eUX = false;
        this.eUV = false;
        this.eUW = false;
    }

    @Override // com.baidu.live.challenge.j.k
    public void d(boolean z, String str) {
        if (z) {
            this.eUY = true;
            this.eUQ.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjA() {
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
                c.this.eUU.pr();
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
        return this.eUX;
    }

    @Override // com.baidu.live.challenge.i
    public int ar(boolean z) {
        int aH;
        int aI = g.aI(this.mTbPageContext.getPageActivity());
        if (z) {
            aH = g.aG(this.mTbPageContext.getPageActivity());
        } else {
            aH = g.aH(this.mTbPageContext.getPageActivity());
        }
        return aH + aI + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }
}
