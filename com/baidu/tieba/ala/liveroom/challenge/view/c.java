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
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.b;
/* loaded from: classes6.dex */
public class c implements i {
    private AlaChallengeLiveView edt;
    private b edu;
    private h edv;
    private AlaChallengeCountDown edw;
    private j edx;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean edy = false;
    private boolean edz = false;
    private boolean edA = false;
    private boolean edB = true;
    private boolean edC = false;
    private boolean edD = false;
    private boolean edE = false;
    private boolean edF = false;
    private boolean edG = false;
    private long challengeId = 0;
    private long Of = 0;
    private long liveId = -1;
    private long edH = 0;
    private int edI = 10;
    private boolean isHost = false;
    private boolean edJ = false;
    private boolean edK = false;
    private boolean edL = false;
    private b.a edM = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRb() {
            if (c.this.edt != null && c.this.edt.getParent() != null) {
                c.this.edz = true;
                if (c.this.edv != null) {
                    c.this.edv.nH();
                }
                c.this.edt.setCloseBtnVisible(true);
                c.this.edt.setAllInBtnVisible(true);
                c.this.edt.setLiveContainerVisible(true);
                if (!com.baidu.live.c.np().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.np().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.edK && !c.this.isHost) || (!c.this.edJ && c.this.isHost)) {
                        if (c.this.edw == null) {
                            c.this.edw = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.edw.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.edw.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.edw.getParent() != null) {
                            ((ViewGroup) c.this.edw.getParent()).removeView(c.this.edw);
                        }
                        c.this.edt.getLiveContainerView().addView(c.this.edw, layoutParams);
                        c.this.edw.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.edF = true;
                }
                c.this.aRi();
                c.this.aRj();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRc() {
            if (c.this.edt != null && c.this.edt.getParent() != null) {
                c.this.edA = false;
                if (c.this.edv != null) {
                    c.this.edv.af(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.Of = c.this.Of;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.edt.setLiveContainerVisible(false);
                c.this.edF = true;
                c.this.edG = true;
                c.this.aRi();
                c.this.aRj();
                c.this.edF = false;
                c.this.edG = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRd() {
            if (c.this.edt != null && c.this.edt.getParent() != null) {
                if (!c.this.edA) {
                    c.this.aRh();
                    c.this.aRl();
                }
                c.this.edF = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRe() {
            c.this.edG = false;
        }
    };
    private AlaChallengeLiveView.a edN = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void aQW() {
            c.this.aRn();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void aQX() {
            c.this.edx.nR();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(w wVar) {
            if (wVar != null && wVar.SF != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(wVar.SF.userId), wVar.SF.userName, wVar.SF.portrait, wVar.SF.sex, wVar.SF.levelId, null, null, 0L, wVar.SF.fansCount, wVar.SF.followCount, wVar.SF.userStatus, String.valueOf(wVar.SG.group_id), String.valueOf(wVar.SG.live_id), false, String.valueOf(c.this.edH), wVar.SF.appId, wVar.SF.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(w wVar) {
            if (!c.this.isHost) {
                if (c.this.edL) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.edt);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if (wVar != null && wVar.SG != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(wVar.SG.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Runnable edO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            String string;
            c.this.mHandler.removeCallbacks(this);
            if (c.this.edI < 10) {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time1, String.valueOf(c.this.edI));
            } else {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time, String.valueOf(c.this.edI));
            }
            c.this.edt.setAllInCountDownText(string);
            if (c.this.edI <= 0) {
                c.this.edI = 10;
                c.this.mHandler.removeCallbacks(this);
                c.this.edt.setAllInBtnVisible(false);
                c.this.edt.setAllInCountDownTextVisible(false);
                return;
            }
            c.v(c.this);
            c.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int v(c cVar) {
        int i = cVar.edI;
        cVar.edI = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.edu = new b(tbPageContext.getPageActivity());
        this.edu.a(this.edM);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.edu.aV(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.edK = z;
        this.isHost = z2;
        this.edJ = z3;
    }

    private void aRf() {
        if (this.edt == null) {
            this.edt = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.edt.setIsHost(this.isHost);
            this.edt.setViewClickCallBack(this.edN);
        }
    }

    private void aRg() {
        int i = 0;
        if (this.edt != null && this.mParentView != null) {
            if (this.edt.getParent() != null) {
                ((ViewGroup) this.edt.getParent()).removeView(this.edt);
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
            if (this.edt.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.edt, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.edt, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRh() {
        if (this.edt != null && this.edt.getParent() != null) {
            ((ViewGroup) this.edt.getParent()).removeView(this.edt);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.edx = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.edv = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void nJ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.edz);
        }
        this.edG = true;
        aRj();
    }

    @Override // com.baidu.live.challenge.i
    public void aS(int i) {
        if (1 == i) {
            this.edF = true;
            aRi();
        }
        if (2 == i) {
            this.edG = true;
            aRj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        if (this.edz && this.edF) {
            this.edu.c(this.edt);
            if (this.edt != null && this.edt.getAnchorAnimLiveBgView() != null) {
                this.edt.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        if (this.edz && this.edG) {
            this.edu.b(this.edt);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(v vVar, w wVar, w wVar2) {
        this.edA = true;
        this.edB = false;
        g(vVar, wVar, wVar2);
    }

    @Override // com.baidu.live.challenge.j.e
    public void c(v vVar, w wVar, w wVar2) {
        this.edA = true;
        this.edB = true;
        g(vVar, wVar, wVar2);
        aRk();
        if (this.edE && this.edD) {
            this.edt.setAllInLabelVisible(true);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void d(v vVar, final w wVar, w wVar2) {
        if (this.edy) {
            this.edA = true;
            this.edB = true;
            if (vVar.St == 2) {
                g(vVar, wVar, wVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.d(wVar);
                    }
                }, 5000L);
            } else {
                d(wVar);
            }
        }
        this.edE = false;
        this.edD = false;
        this.edC = false;
    }

    @Override // com.baidu.live.challenge.j.e
    public void e(v vVar, w wVar, w wVar2) {
        this.edC = false;
    }

    private void g(v vVar, w wVar, w wVar2) {
        if (vVar != null) {
            this.challengeId = vVar.challengeId;
        }
        if (wVar != null) {
            if (wVar.SF != null) {
                this.Of = wVar.SF.userId;
            }
            if (wVar.SG != null) {
                this.liveId = wVar.SG.live_id;
            }
        }
        if (!this.edy) {
            this.edy = true;
            if (this.edv != null) {
                this.edv.nG();
            }
            aRf();
            aRg();
            this.edE = false;
            this.edD = false;
            this.edF = false;
            this.edG = false;
            if (this.edu != null && this.edt != null) {
                this.edt.a(vVar, wVar, wVar2, true);
                this.edt.setRivalUserViewBg(wVar2);
                this.edt.setAnchorUserViewBg(wVar);
                if (this.edv != null) {
                    this.edv.a(vVar, wVar, wVar2);
                }
                if (this.edu != null) {
                    this.edu.a(this.mTbPageContext.getPageActivity(), this.edt);
                }
            }
        }
        if (this.edz && this.edt != null) {
            this.edt.a(vVar, wVar, wVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void b(com.baidu.live.data.i iVar) {
        if (iVar != null && iVar.OR != null) {
            this.edH = iVar.OR.userId;
        }
    }

    private void aRk() {
        if (this.edt != null) {
            this.edt.getAnchorLiveAllInAnimImg().setVisibility(8);
            this.edt.getRivalLiveAllInAnimImg().setVisibility(8);
            this.edt.setAllInBtnVisible(false);
            this.edu.a(false, this.edt.getAnchorLiveAllInAnimImg(), this.edt.getRivalLiveAllInAnimImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar) {
        if (this.edv != null) {
            this.edv.nI();
        }
        aRk();
        if (this.edt != null) {
            this.edt.setAnchorUserViewBg(wVar);
        }
        if (this.edt != null) {
            this.edt.setAllInLabelVisible(false);
            this.edt.aQU();
            this.edu.a(false, this.edt.getAnchorLiveAllInAnimImg(), this.edt.getRivalLiveAllInAnimImg());
            this.edu.b(this.mTbPageContext.getPageActivity(), this.edt);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void nA() {
        if (this.edA) {
            if (this.edv != null) {
                this.edv.af(true);
            }
            if (this.edt != null) {
                this.edt.aQT();
            }
            this.edF = false;
            this.edG = false;
            aRl();
            aRh();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        aRl();
        this.edu.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        this.edu.aQY();
        if (this.edt != null) {
            this.edu.a(false, this.edt.getAnchorLiveAllInAnimImg(), this.edt.getRivalLiveAllInAnimImg());
            this.edt.releaseResource();
        }
        if (this.edw != null) {
            this.edw.aQR();
        }
        this.edA = false;
        this.edy = false;
        this.edz = false;
    }

    @Override // com.baidu.live.challenge.j.b
    public void a(int i, boolean z, String str) {
        if (this.edt != null) {
            if (z) {
                this.edt.setAllInBtnVisible(false);
                switch (i) {
                    case 1:
                        if (!this.edE) {
                            this.edE = true;
                            this.edu.a(this.mTbPageContext, this.edt.getAnchorLiveAllInAnimImg());
                            return;
                        }
                        return;
                    case 2:
                    default:
                        return;
                }
            }
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_do_request_fail), 1);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nU() {
        if (!this.edE && this.edt != null) {
            this.edE = true;
            this.edu.a(this.mTbPageContext, this.edt.getAnchorLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nV() {
        if (!this.edD && this.edt != null) {
            this.edD = true;
            aRm();
            this.edu.a(this.mTbPageContext, this.edt.getRivalLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nW() {
        if (this.edt != null) {
            if (this.isHost && !this.edC) {
                this.edC = true;
                TiebaInitialize.log(new StatisticItem("c13053"));
            }
            this.mHandler.removeCallbacks(this.edO);
            if (this.edE && !this.edD) {
                this.edD = true;
                this.edu.b(this.mTbPageContext, this.edt.getRivalLiveAllInAnimImg());
            } else if (this.edD && !this.edE) {
                this.edE = true;
                this.edu.b(this.mTbPageContext, this.edt.getAnchorLiveAllInAnimImg());
            } else if (!this.edD && !this.edE && !this.edB) {
                this.edE = true;
                this.edD = true;
                this.edu.b(this.mTbPageContext, this.edt.getRivalLiveAllInAnimImg());
                this.edu.b(this.mTbPageContext, this.edt.getAnchorLiveAllInAnimImg());
            }
            this.edt.setAllInBtnVisible(false);
            this.edt.setAllInCountDownTextVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nX() {
        if (this.edt != null) {
            if (this.edu != null) {
                this.edt.getAnchorLiveAllInAnimImg().setVisibility(8);
                this.edt.getRivalLiveAllInAnimImg().setVisibility(8);
                this.edu.a(true, this.edt.getAnchorLiveAllInAnimImg(), this.edt.getRivalLiveAllInAnimImg());
            }
            this.edt.setAllInBtnVisible(false);
            this.edt.setAllInLabelVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.l
    public void c(boolean z, String str) {
        if (z) {
            this.edB = true;
            this.edt.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    private void aRm() {
        this.edt.setAllInCountDownTextVisible(true);
        this.mHandler.post(this.edO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRn() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (this.edC) {
            bdAlertDialog.setMessageId(a.i.ala_challenge_all_in_back_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setNegativeButton(a.i.sdk_quit, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.edx.nS();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setPositiveButton(a.i.ala_challenge_back_stay, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.6
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
        return this.edA;
    }
}
