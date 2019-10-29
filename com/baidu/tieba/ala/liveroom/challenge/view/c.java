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
    private AlaChallengeLiveView eek;
    private b eel;
    private h eem;
    private AlaChallengeCountDown een;
    private j eeo;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eep = false;
    private boolean eeq = false;
    private boolean eer = false;
    private boolean ees = true;
    private boolean eet = false;
    private boolean eeu = false;
    private boolean eev = false;
    private boolean eew = false;
    private boolean eex = false;
    private long challengeId = 0;
    private long OF = 0;
    private long liveId = -1;
    private long eey = 0;
    private int eez = 10;
    private boolean isHost = false;
    private boolean eeA = false;
    private boolean eeB = false;
    private boolean eeC = false;
    private b.a eeD = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRd() {
            if (c.this.eek != null && c.this.eek.getParent() != null) {
                c.this.eeq = true;
                if (c.this.eem != null) {
                    c.this.eem.nH();
                }
                c.this.eek.setCloseBtnVisible(true);
                c.this.eek.setAllInBtnVisible(true);
                c.this.eek.setLiveContainerVisible(true);
                if (!com.baidu.live.c.np().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.np().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eeB && !c.this.isHost) || (!c.this.eeA && c.this.isHost)) {
                        if (c.this.een == null) {
                            c.this.een = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.een.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.een.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.een.getParent() != null) {
                            ((ViewGroup) c.this.een.getParent()).removeView(c.this.een);
                        }
                        c.this.eek.getLiveContainerView().addView(c.this.een, layoutParams);
                        c.this.een.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eew = true;
                }
                c.this.aRk();
                c.this.aRl();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRe() {
            if (c.this.eek != null && c.this.eek.getParent() != null) {
                c.this.eer = false;
                if (c.this.eem != null) {
                    c.this.eem.af(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.OF = c.this.OF;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eek.setLiveContainerVisible(false);
                c.this.eew = true;
                c.this.eex = true;
                c.this.aRk();
                c.this.aRl();
                c.this.eew = false;
                c.this.eex = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRf() {
            if (c.this.eek != null && c.this.eek.getParent() != null) {
                if (!c.this.eer) {
                    c.this.aRj();
                    c.this.aRn();
                }
                c.this.eew = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void aRg() {
            c.this.eex = false;
        }
    };
    private AlaChallengeLiveView.a eeE = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void aQY() {
            c.this.aRp();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void aQZ() {
            c.this.eeo.nR();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(w wVar) {
            if (wVar != null && wVar.Tb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(wVar.Tb.userId), wVar.Tb.userName, wVar.Tb.portrait, wVar.Tb.sex, wVar.Tb.levelId, null, null, 0L, wVar.Tb.fansCount, wVar.Tb.followCount, wVar.Tb.userStatus, String.valueOf(wVar.Tc.group_id), String.valueOf(wVar.Tc.live_id), false, String.valueOf(c.this.eey), wVar.Tb.appId, wVar.Tb.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(w wVar) {
            if (!c.this.isHost) {
                if (c.this.eeC) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eek);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if (wVar != null && wVar.Tc != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(wVar.Tc.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Runnable eeF = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            String string;
            c.this.mHandler.removeCallbacks(this);
            if (c.this.eez < 10) {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time1, String.valueOf(c.this.eez));
            } else {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time, String.valueOf(c.this.eez));
            }
            c.this.eek.setAllInCountDownText(string);
            if (c.this.eez <= 0) {
                c.this.eez = 10;
                c.this.mHandler.removeCallbacks(this);
                c.this.eek.setAllInBtnVisible(false);
                c.this.eek.setAllInCountDownTextVisible(false);
                return;
            }
            c.v(c.this);
            c.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int v(c cVar) {
        int i = cVar.eez;
        cVar.eez = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eel = new b(tbPageContext.getPageActivity());
        this.eel.a(this.eeD);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eel.aX(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eeB = z;
        this.isHost = z2;
        this.eeA = z3;
    }

    private void aRh() {
        if (this.eek == null) {
            this.eek = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eek.setIsHost(this.isHost);
            this.eek.setViewClickCallBack(this.eeE);
        }
    }

    private void aRi() {
        int i = 0;
        if (this.eek != null && this.mParentView != null) {
            if (this.eek.getParent() != null) {
                ((ViewGroup) this.eek.getParent()).removeView(this.eek);
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
            if (this.eek.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eek, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eek, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        if (this.eek != null && this.eek.getParent() != null) {
            ((ViewGroup) this.eek.getParent()).removeView(this.eek);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eeo = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eem = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void nJ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eeq);
        }
        this.eex = true;
        aRl();
    }

    @Override // com.baidu.live.challenge.i
    public void aS(int i) {
        if (1 == i) {
            this.eew = true;
            aRk();
        }
        if (2 == i) {
            this.eex = true;
            aRl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        if (this.eeq && this.eew) {
            this.eel.c(this.eek);
            if (this.eek != null && this.eek.getAnchorAnimLiveBgView() != null) {
                this.eek.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        if (this.eeq && this.eex) {
            this.eel.b(this.eek);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(v vVar, w wVar, w wVar2) {
        this.eer = true;
        this.ees = false;
        g(vVar, wVar, wVar2);
    }

    @Override // com.baidu.live.challenge.j.e
    public void c(v vVar, w wVar, w wVar2) {
        this.eer = true;
        this.ees = true;
        g(vVar, wVar, wVar2);
        aRm();
        if (this.eev && this.eeu) {
            this.eek.setAllInLabelVisible(true);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void d(v vVar, final w wVar, w wVar2) {
        if (this.eep) {
            this.eer = true;
            this.ees = true;
            if (vVar.SQ == 2) {
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
        this.eev = false;
        this.eeu = false;
        this.eet = false;
    }

    @Override // com.baidu.live.challenge.j.e
    public void e(v vVar, w wVar, w wVar2) {
        this.eet = false;
    }

    private void g(v vVar, w wVar, w wVar2) {
        if (vVar != null) {
            this.challengeId = vVar.challengeId;
        }
        if (wVar != null) {
            if (wVar.Tb != null) {
                this.OF = wVar.Tb.userId;
            }
            if (wVar.Tc != null) {
                this.liveId = wVar.Tc.live_id;
            }
        }
        if (!this.eep) {
            this.eep = true;
            if (this.eem != null) {
                this.eem.nG();
            }
            aRh();
            aRi();
            this.eev = false;
            this.eeu = false;
            this.eew = false;
            this.eex = false;
            if (this.eel != null && this.eek != null) {
                this.eek.a(vVar, wVar, wVar2, true);
                this.eek.setRivalUserViewBg(wVar2);
                this.eek.setAnchorUserViewBg(wVar);
                if (this.eem != null) {
                    this.eem.a(vVar, wVar, wVar2);
                }
                if (this.eel != null) {
                    this.eel.a(this.mTbPageContext.getPageActivity(), this.eek);
                }
            }
        }
        if (this.eeq && this.eek != null) {
            this.eek.a(vVar, wVar, wVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void b(com.baidu.live.data.i iVar) {
        if (iVar != null && iVar.Ps != null) {
            this.eey = iVar.Ps.userId;
        }
    }

    private void aRm() {
        if (this.eek != null) {
            this.eek.getAnchorLiveAllInAnimImg().setVisibility(8);
            this.eek.getRivalLiveAllInAnimImg().setVisibility(8);
            this.eek.setAllInBtnVisible(false);
            this.eel.a(false, this.eek.getAnchorLiveAllInAnimImg(), this.eek.getRivalLiveAllInAnimImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar) {
        if (this.eem != null) {
            this.eem.nI();
        }
        aRm();
        if (this.eek != null) {
            this.eek.setAnchorUserViewBg(wVar);
        }
        if (this.eek != null) {
            this.eek.setAllInLabelVisible(false);
            this.eek.aQW();
            this.eel.a(false, this.eek.getAnchorLiveAllInAnimImg(), this.eek.getRivalLiveAllInAnimImg());
            this.eel.b(this.mTbPageContext.getPageActivity(), this.eek);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void nA() {
        if (this.eer) {
            if (this.eem != null) {
                this.eem.af(true);
            }
            if (this.eek != null) {
                this.eek.aQV();
            }
            this.eew = false;
            this.eex = false;
            aRn();
            aRj();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        aRn();
        this.eel.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRn() {
        this.eel.aRa();
        if (this.eek != null) {
            this.eel.a(false, this.eek.getAnchorLiveAllInAnimImg(), this.eek.getRivalLiveAllInAnimImg());
            this.eek.releaseResource();
        }
        if (this.een != null) {
            this.een.aQT();
        }
        this.eer = false;
        this.eep = false;
        this.eeq = false;
    }

    @Override // com.baidu.live.challenge.j.b
    public void a(int i, boolean z, String str) {
        if (this.eek != null) {
            if (z) {
                this.eek.setAllInBtnVisible(false);
                switch (i) {
                    case 1:
                        if (!this.eev) {
                            this.eev = true;
                            this.eel.a(this.mTbPageContext, this.eek.getAnchorLiveAllInAnimImg());
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
        if (!this.eev && this.eek != null) {
            this.eev = true;
            this.eel.a(this.mTbPageContext, this.eek.getAnchorLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nV() {
        if (!this.eeu && this.eek != null) {
            this.eeu = true;
            aRo();
            this.eel.a(this.mTbPageContext, this.eek.getRivalLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nW() {
        if (this.eek != null) {
            if (this.isHost && !this.eet) {
                this.eet = true;
                TiebaInitialize.log(new StatisticItem("c13053"));
            }
            this.mHandler.removeCallbacks(this.eeF);
            if (this.eev && !this.eeu) {
                this.eeu = true;
                this.eel.b(this.mTbPageContext, this.eek.getRivalLiveAllInAnimImg());
            } else if (this.eeu && !this.eev) {
                this.eev = true;
                this.eel.b(this.mTbPageContext, this.eek.getAnchorLiveAllInAnimImg());
            } else if (!this.eeu && !this.eev && !this.ees) {
                this.eev = true;
                this.eeu = true;
                this.eel.b(this.mTbPageContext, this.eek.getRivalLiveAllInAnimImg());
                this.eel.b(this.mTbPageContext, this.eek.getAnchorLiveAllInAnimImg());
            }
            this.eek.setAllInBtnVisible(false);
            this.eek.setAllInCountDownTextVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void nX() {
        if (this.eek != null) {
            if (this.eel != null) {
                this.eek.getAnchorLiveAllInAnimImg().setVisibility(8);
                this.eek.getRivalLiveAllInAnimImg().setVisibility(8);
                this.eel.a(true, this.eek.getAnchorLiveAllInAnimImg(), this.eek.getRivalLiveAllInAnimImg());
            }
            this.eek.setAllInBtnVisible(false);
            this.eek.setAllInLabelVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.l
    public void c(boolean z, String str) {
        if (z) {
            this.ees = true;
            this.eek.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    private void aRo() {
        this.eek.setAllInCountDownTextVisible(true);
        this.mHandler.post(this.eeF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRp() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (this.eet) {
            bdAlertDialog.setMessageId(a.i.ala_challenge_all_in_back_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setNegativeButton(a.i.sdk_quit, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.eeo.nS();
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
        return this.eer;
    }
}
