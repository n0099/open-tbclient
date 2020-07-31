package com.baidu.tieba.ala.liveroom.challenge.view;

import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.bh;
import com.baidu.live.data.q;
import com.baidu.live.follow.a.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.a;
/* loaded from: classes4.dex */
public class d implements h {
    private AlaChallengeLiveView gjP;
    private a gjQ;
    private g gjR;
    private AlaChallengeCountDown gjS;
    private i gjT;
    private long gkb;
    private com.baidu.live.follow.a.b gkf;
    private CustomMessageListener gkg;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gkh;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gjU = false;
    private boolean gjV = false;
    private boolean gjW = false;
    private boolean gjX = true;
    private boolean gjY = false;
    private boolean gjZ = false;
    private long challengeId = 0;
    private long axs = 0;
    private long liveId = -1;
    private long gka = 0;
    private boolean isHost = false;
    private boolean gkc = false;
    private boolean gkd = false;
    private boolean gke = false;
    public boolean giF = false;
    private a.InterfaceC0579a gki = new a.InterfaceC0579a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0579a
        public void bGS() {
            if (d.this.gjP != null && d.this.gjP.getParent() != null) {
                d.this.gjV = true;
                if (d.this.gjR != null) {
                    d.this.gjR.wi();
                }
                d.this.gjP.setCloseBtnVisible(true);
                d.this.gjP.setLiveContainerVisible(true);
                if (!com.baidu.live.c.vf().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, false)) {
                    com.baidu.live.c.vf().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, true);
                    if ((!d.this.gkd && !d.this.isHost) || (!d.this.gkc && d.this.isHost)) {
                        if (d.this.gjS == null) {
                            d.this.gjS = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gjS.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gjS.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gjS.getParent() != null) {
                            ((ViewGroup) d.this.gjS.getParent()).removeView(d.this.gjS);
                        }
                        d.this.gjP.getLiveContainerView().addView(d.this.gjS, layoutParams);
                        d.this.gjS.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gjY = true;
                }
                d.this.bHd();
                d.this.bHe();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0579a
        public void bGT() {
            if (d.this.gjP != null && d.this.gjP.getParent() != null) {
                d.this.gjW = false;
                if (d.this.gjR != null) {
                    d.this.gjR.aX(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.axs = d.this.axs;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gjP.setLiveContainerVisible(false);
                d.this.gjY = true;
                d.this.gjZ = true;
                d.this.bHd();
                d.this.bHe();
                d.this.gjY = false;
                d.this.gjZ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0579a
        public void bGU() {
            if (d.this.gjP != null && d.this.gjP.getParent() != null) {
                if (!d.this.gjW) {
                    d.this.bHc();
                    d.this.bHf();
                }
                d.this.gjY = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0579a
        public void bGV() {
            d.this.gjZ = false;
        }
    };
    private AlaChallengeLiveView.a gkj = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bGQ() {
            d.this.lv(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bh bhVar) {
            if (bhVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bhVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bhVar.azw);
            } else {
                d.this.lv(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(ar arVar) {
            if (arVar != null && arVar.aDb != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(arVar.aDb.userId), arVar.aDb.userName, arVar.aDb.portrait, arVar.aDb.sex, arVar.aDb.levelId, null, null, 0L, arVar.aDb.fansCount, arVar.aDb.followCount, arVar.aDb.userStatus, String.valueOf(arVar.aDu.group_id), String.valueOf(arVar.aDu.live_id), false, String.valueOf(d.this.gka), arVar.aDb.appId, arVar.aDb.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(ar arVar) {
            if (arVar != null && arVar.aDb != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(String.valueOf(arVar.aDb.userId));
                    dVar.setPortrait(arVar.aDb.portrait);
                    dVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.KF().a(String.valueOf(arVar.aDb.userId), dVar);
                    if (d.this.gjP != null) {
                        d.this.gjP.lt(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(ar arVar) {
            if (!d.this.isHost) {
                if (d.this.gke) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gjP);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.Hs().aZn.aBC || !TbadkCoreApplication.getInst().isMobileBaidu()) && arVar != null && arVar.aDu != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(arVar.aDu.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bGR() {
            if (d.this.giF && d.this.gjR != null) {
                d.this.gjR.aY(d.this.giF);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void lu(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.axs);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gkk = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gkh != null) {
                    d.this.gkh.release();
                }
                d.this.gkh = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.axs, d.this.challengeId, d.this.gjT, getChallengeMvpToastInfoResponseMessage);
                d.this.gkh.showDialog();
            }
        }
    };
    CustomMessageListener gkl = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gjT != null) {
                d.this.gjT.a(d.this.challengeId, d.this.liveId, d.this.axs, 6, "0");
            }
        }
    };
    private CustomMessageListener gkm = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gkb > 0 && d.this.gjP != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gkb))) {
                    d.this.gjP.lt(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gjQ = new a(tbPageContext.getPageActivity());
        this.gjQ.a(this.gki);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gjQ.bG(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gkk);
        MessageManager.getInstance().registerListener(this.gkl);
        MessageManager.getInstance().registerListener(this.gkm);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gkd = z;
        this.isHost = z2;
        this.gkc = z3;
    }

    private void bHa() {
        if (this.gjP == null) {
            this.gjP = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gjP.setIsHost(this.isHost);
            this.gjP.setViewClickCallBack(this.gkj);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.giF = z;
        if (this.gjP != null) {
            this.gjP.setNeedCloseRecommendFloat(this.giF);
        }
    }

    private void bHb() {
        int i = 0;
        if (this.gjP != null && this.mParentView != null) {
            if (this.gjP.getParent() != null) {
                ((ViewGroup) this.gjP.getParent()).removeView(this.gjP);
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
            if (this.gjP.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gjP, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gjP, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHc() {
        if (this.gjP != null && this.gjP.getParent() != null) {
            ((ViewGroup) this.gjP.getParent()).removeView(this.gjP);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gjT = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gjR = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void wk() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gjV);
        }
        this.gjZ = true;
        bHe();
    }

    @Override // com.baidu.live.challenge.h
    public void bR(int i) {
        if (1 == i) {
            this.gjY = true;
            bHd();
        }
        if (2 == i) {
            this.gjZ = true;
            bHe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHd() {
        if (this.gjV && this.gjY) {
            this.gjQ.e(this.gjP);
            if (this.gjP != null && this.gjP.getAnchorAnimLiveBgView() != null) {
                this.gjP.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHe() {
        if (this.gjV && this.gjZ) {
            this.gjQ.d(this.gjP);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(an anVar, ar arVar, ar arVar2) {
        this.gjW = true;
        this.gjX = false;
        f(anVar, arVar, arVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(an anVar, ar arVar, ar arVar2) {
        this.gjW = true;
        this.gjX = true;
        f(anVar, arVar, arVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(an anVar, final ar arVar, ar arVar2) {
        long j = -1;
        if (this.gjU) {
            this.gjW = true;
            this.gjX = true;
            if (anVar.aDe == 2) {
                f(anVar, arVar, arVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(arVar);
                    }
                }, 5000L);
                return;
            }
            g(arVar);
            return;
        }
        long j2 = anVar != null ? anVar.challengeId : -1L;
        if (arVar != null && arVar.aDu != null) {
            j = arVar.aDu.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(an anVar, ar arVar, ar arVar2) {
    }

    private void f(an anVar, ar arVar, ar arVar2) {
        if (anVar != null) {
            this.challengeId = anVar.challengeId;
        }
        if (arVar != null) {
            if (arVar.aDb != null) {
                this.axs = arVar.aDb.userId;
            }
            if (arVar.aDu != null) {
                this.liveId = arVar.aDu.live_id;
            }
        }
        if (arVar2 != null && arVar2.aDb != null) {
            this.gkb = arVar2.aDb.userId;
        }
        if (!this.gjU) {
            this.gjU = true;
            if (this.gjR != null) {
                this.gjR.wh();
            }
            bHa();
            bHb();
            this.gjY = false;
            this.gjZ = false;
            if (this.gjQ != null && this.gjP != null) {
                this.gjP.a(anVar, arVar, arVar2, true);
                this.gjP.setRivalUserViewBg(arVar2);
                this.gjP.setAnchorUserViewBg(arVar);
                if (this.gjR != null) {
                    this.gjR.a(anVar, arVar, arVar2);
                }
                if (this.gjQ != null) {
                    this.gjQ.a(this.mTbPageContext.getPageActivity(), this.gjP);
                }
                bHg();
                String str = null;
                if (arVar2 != null && arVar2.aDu != null) {
                    str = String.valueOf(arVar2.aDu.live_id);
                }
                if (TextUtils.isEmpty(str) || !dL(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gjP.lt(false);
                }
            }
        }
        if (this.gjV && this.gjP != null) {
            this.gjP.a(anVar, arVar, arVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(q qVar) {
        if (qVar != null && qVar.ayC != null) {
            this.gka = qVar.ayC.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ar arVar) {
        if (this.gjR != null) {
            this.gjR.wj();
        }
        if (this.gjP != null) {
            this.gjP.setAnchorUserViewBg(arVar);
        }
        if (this.gjP != null) {
            this.gjP.bGO();
            this.gjP.bGN();
            this.gjQ.b(this.mTbPageContext.getPageActivity(), this.gjP);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void wd() {
        if (this.gjW) {
            if (this.gjR != null) {
                this.gjR.aX(true);
            }
            if (this.gjP != null) {
                this.gjP.bGM();
            }
            this.gjY = false;
            this.gjZ = false;
            bHf();
            this.mHandler.removeCallbacksAndMessages(null);
            bHc();
            if (this.gkh != null) {
                this.gkh.release();
                this.gkh = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bHf();
        this.gjQ.a((a.InterfaceC0579a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gkh != null) {
            this.gkh.release();
            this.gkh = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gkk);
        MessageManager.getInstance().unRegisterListener(this.gkl);
        MessageManager.getInstance().unRegisterListener(this.gkm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        MessageManager.getInstance().unRegisterListener(this.gkg);
        if (this.gkf != null) {
            this.gkf.release();
        }
        this.gjQ.zT();
        if (this.gjP != null) {
            this.gjP.releaseResource();
        }
        if (this.gjS != null) {
            this.gjS.bGK();
        }
        this.gjW = false;
        this.gjU = false;
        this.gjV = false;
        this.gkb = 0L;
    }

    @Override // com.baidu.live.challenge.i.m
    public void d(boolean z, String str) {
        if (z) {
            this.gjX = true;
            this.gjP.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(final boolean z) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (z) {
            bdAlertDialog.setMessageId(a.i.ala_challenge_punish_close_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setPositiveButton(a.i.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    d.this.gjT.wv();
                    return;
                }
                d.this.gjT.wt();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bdAlertDialog.setPositiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            bdAlertDialog.setNagetiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.h
    public boolean isActive() {
        return this.gjW;
    }

    @Override // com.baidu.live.challenge.h
    public int aZ(boolean z) {
        int aw;
        int ax = com.baidu.live.utils.g.ax(this.mTbPageContext.getPageActivity());
        if (z) {
            aw = com.baidu.live.utils.g.av(this.mTbPageContext.getPageActivity());
        } else {
            aw = com.baidu.live.utils.g.aw(this.mTbPageContext.getPageActivity());
        }
        return aw + ax + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) + this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds68);
    }

    private boolean dL(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gkf == null) {
            this.gkf = new com.baidu.live.follow.a.a();
        }
        this.gkf.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gjP != null) {
                    d.this.gjP.lt(z2);
                }
            }
        });
        this.gkf.aj(str, str2);
        return true;
    }

    private void bHg() {
        if (this.gkg == null) {
            this.gkg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gkb > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gkb))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gjP != null) {
                                    d.this.gjP.lt(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gjP != null) {
                                d.this.gjP.lt(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gkg);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gjX = true;
            this.gjP.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void c(int i, long j) {
        if (this.gjW && i == 3 && j == this.challengeId) {
            if (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aBl == 1) {
                bHh();
            }
        }
    }

    public void bHh() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
