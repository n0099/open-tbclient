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
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.bj;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class d implements h {
    private AlaChallengeLiveView gvV;
    private a gvW;
    private g gvX;
    private AlaChallengeCountDown gvY;
    private i gvZ;
    private long gwh;
    private com.baidu.live.follow.a.b gwl;
    private CustomMessageListener gwm;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gwn;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gwa = false;
    private boolean gwb = false;
    private boolean gwc = false;
    private boolean gwd = true;
    private boolean gwe = false;
    private boolean gwf = false;
    private long challengeId = 0;
    private long aCu = 0;
    private long liveId = -1;
    private long gwg = 0;
    private boolean isHost = false;
    private boolean gwi = false;
    private boolean gwj = false;
    private boolean gwk = false;
    public boolean guJ = false;
    private a.InterfaceC0627a gwo = new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQw() {
            if (d.this.gvV != null && d.this.gvV.getParent() != null) {
                d.this.gwb = true;
                if (d.this.gvX != null) {
                    d.this.gvX.BG();
                }
                d.this.gvV.setCloseBtnVisible(true);
                d.this.gvV.setLiveContainerVisible(true);
                if (!com.baidu.live.c.AD().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, false)) {
                    com.baidu.live.c.AD().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, true);
                    if ((!d.this.gwj && !d.this.isHost) || (!d.this.gwi && d.this.isHost)) {
                        if (d.this.gvY == null) {
                            d.this.gvY = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gvY.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gvY.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gvY.getParent() != null) {
                            ((ViewGroup) d.this.gvY.getParent()).removeView(d.this.gvY);
                        }
                        d.this.gvV.getLiveContainerView().addView(d.this.gvY, layoutParams);
                        d.this.gvY.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gwe = true;
                }
                d.this.bQH();
                d.this.bQI();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQx() {
            if (d.this.gvV != null && d.this.gvV.getParent() != null) {
                d.this.gwc = false;
                if (d.this.gvX != null) {
                    d.this.gvX.bc(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.aCu = d.this.aCu;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gvV.setLiveContainerVisible(false);
                d.this.gwe = true;
                d.this.gwf = true;
                d.this.bQH();
                d.this.bQI();
                d.this.gwe = false;
                d.this.gwf = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQy() {
            if (d.this.gvV != null && d.this.gvV.getParent() != null) {
                if (!d.this.gwc) {
                    d.this.bQG();
                    d.this.bQJ();
                }
                d.this.gwe = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQz() {
            d.this.gwf = false;
        }
    };
    private AlaChallengeLiveView.a gwp = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bQu() {
            d.this.lW(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bj bjVar) {
            if (bjVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bjVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bjVar.aDS);
            } else {
                d.this.lW(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(at atVar) {
            if (atVar != null && atVar.aIl != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(atVar.aIl.userId), atVar.aIl.userName, atVar.aIl.portrait, atVar.aIl.sex, atVar.aIl.levelId, null, null, 0L, atVar.aIl.fansCount, atVar.aIl.followCount, atVar.aIl.userStatus, String.valueOf(atVar.aIE.group_id), String.valueOf(atVar.aIE.live_id), false, String.valueOf(d.this.gwg), atVar.aIl.appId, atVar.aIl.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(at atVar) {
            if (atVar != null && atVar.aIl != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(String.valueOf(atVar.aIl.userId));
                    dVar.setPortrait(atVar.aIl.portrait);
                    dVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Qx().a(String.valueOf(atVar.aIl.userId), dVar);
                    if (d.this.gvV != null) {
                        d.this.gvV.lU(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(at atVar) {
            if (!d.this.isHost) {
                if (d.this.gwk) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gvV);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.w.a.Nk().beH.aGM || !TbadkCoreApplication.getInst().isMobileBaidu()) && atVar != null && atVar.aIE != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(atVar.aIE.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bQv() {
            if (d.this.guJ && d.this.gvX != null) {
                d.this.gvX.bd(d.this.guJ);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void lV(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.aCu);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gwq = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gwn != null) {
                    d.this.gwn.release();
                }
                d.this.gwn = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.aCu, d.this.challengeId, d.this.gvZ, getChallengeMvpToastInfoResponseMessage);
                d.this.gwn.Nv();
            }
        }
    };
    CustomMessageListener gwr = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gvZ != null) {
                d.this.gvZ.a(d.this.challengeId, d.this.liveId, d.this.aCu, 6, "0");
            }
        }
    };
    private CustomMessageListener gws = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gwh > 0 && d.this.gvV != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gwh))) {
                    d.this.gvV.lU(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gvW = new a(tbPageContext.getPageActivity());
        this.gvW.a(this.gwo);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gvW.bO(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gwq);
        MessageManager.getInstance().registerListener(this.gwr);
        MessageManager.getInstance().registerListener(this.gws);
    }

    @Override // com.baidu.live.challenge.h
    public void l(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gwj = z;
        this.isHost = z2;
        this.gwi = z3;
    }

    private void bQE() {
        if (this.gvV == null) {
            this.gvV = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gvV.setIsHost(this.isHost);
            this.gvV.setViewClickCallBack(this.gwp);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.guJ = z;
        if (this.gvV != null) {
            this.gvV.setNeedCloseRecommendFloat(this.guJ);
        }
    }

    private void bQF() {
        int i = 0;
        if (this.gvV != null && this.mParentView != null) {
            if (this.gvV.getParent() != null) {
                ((ViewGroup) this.gvV.getParent()).removeView(this.gvV);
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
            if (this.gvV.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gvV, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gvV, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        if (this.gvV != null && this.gvV.getParent() != null) {
            ((ViewGroup) this.gvV.getParent()).removeView(this.gvV);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gvZ = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gvX = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void BI() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gwb);
        }
        this.gwf = true;
        bQI();
    }

    @Override // com.baidu.live.challenge.h
    public void dD(int i) {
        if (1 == i) {
            this.gwe = true;
            bQH();
        }
        if (2 == i) {
            this.gwf = true;
            bQI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQH() {
        if (this.gwb && this.gwe) {
            this.gvW.e(this.gvV);
            if (this.gvV != null && this.gvV.getAnchorAnimLiveBgView() != null) {
                this.gvV.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQI() {
        if (this.gwb && this.gwf) {
            this.gvW.d(this.gvV);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ap apVar, at atVar, at atVar2) {
        this.gwc = true;
        this.gwd = false;
        f(apVar, atVar, atVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ap apVar, at atVar, at atVar2) {
        this.gwc = true;
        this.gwd = true;
        f(apVar, atVar, atVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ap apVar, final at atVar, at atVar2) {
        long j = -1;
        if (this.gwa) {
            this.gwc = true;
            this.gwd = true;
            if (apVar.aIo == 2) {
                f(apVar, atVar, atVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(atVar);
                    }
                }, 5000L);
                return;
            }
            g(atVar);
            return;
        }
        long j2 = apVar != null ? apVar.challengeId : -1L;
        if (atVar != null && atVar.aIE != null) {
            j = atVar.aIE.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ap apVar, at atVar, at atVar2) {
    }

    private void f(ap apVar, at atVar, at atVar2) {
        if (apVar != null) {
            this.challengeId = apVar.challengeId;
        }
        if (atVar != null) {
            if (atVar.aIl != null) {
                this.aCu = atVar.aIl.userId;
            }
            if (atVar.aIE != null) {
                this.liveId = atVar.aIE.live_id;
            }
        }
        if (atVar2 != null && atVar2.aIl != null) {
            this.gwh = atVar2.aIl.userId;
        }
        if (!this.gwa) {
            this.gwa = true;
            if (this.gvX != null) {
                this.gvX.BF();
            }
            bQE();
            bQF();
            this.gwe = false;
            this.gwf = false;
            if (this.gvW != null && this.gvV != null) {
                this.gvV.a(apVar, atVar, atVar2, true);
                this.gvV.setRivalUserViewBg(atVar2);
                this.gvV.setAnchorUserViewBg(atVar);
                if (this.gvX != null) {
                    this.gvX.a(apVar, atVar, atVar2);
                }
                if (this.gvW != null) {
                    this.gvW.a(this.mTbPageContext.getPageActivity(), this.gvV);
                }
                bQK();
                String str = null;
                if (atVar2 != null && atVar2.aIE != null) {
                    str = String.valueOf(atVar2.aIE.live_id);
                }
                if (TextUtils.isEmpty(str) || !ec(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gvV.lU(false);
                }
            }
        }
        if (this.gwb && this.gvV != null) {
            this.gvV.a(apVar, atVar, atVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(r rVar) {
        if (rVar != null && rVar.aDE != null) {
            this.gwg = rVar.aDE.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(at atVar) {
        if (this.gvX != null) {
            this.gvX.BH();
        }
        if (this.gvV != null) {
            this.gvV.setAnchorUserViewBg(atVar);
        }
        if (this.gvV != null) {
            this.gvV.bQt();
            this.gvV.bQs();
            this.gvW.b(this.mTbPageContext.getPageActivity(), this.gvV);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void BB() {
        if (this.gwc) {
            if (this.gvX != null) {
                this.gvX.bc(true);
            }
            if (this.gvV != null) {
                this.gvV.bQr();
            }
            this.gwe = false;
            this.gwf = false;
            bQJ();
            this.mHandler.removeCallbacksAndMessages(null);
            bQG();
            if (this.gwn != null) {
                this.gwn.release();
                this.gwn = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bQJ();
        this.gvW.a((a.InterfaceC0627a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gwn != null) {
            this.gwn.release();
            this.gwn = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gwq);
        MessageManager.getInstance().unRegisterListener(this.gwr);
        MessageManager.getInstance().unRegisterListener(this.gws);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQJ() {
        MessageManager.getInstance().unRegisterListener(this.gwm);
        if (this.gwl != null) {
            this.gwl.release();
        }
        this.gvW.Fw();
        if (this.gvV != null) {
            this.gvV.releaseResource();
        }
        if (this.gvY != null) {
            this.gvY.bQp();
        }
        this.gwc = false;
        this.gwa = false;
        this.gwb = false;
        this.gwh = 0L;
    }

    @Override // com.baidu.live.challenge.i.m
    public void d(boolean z, String str) {
        if (z) {
            this.gwd = true;
            this.gvV.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(final boolean z) {
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
                    d.this.gvZ.BT();
                    return;
                }
                d.this.gvZ.BR();
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
        return this.gwc;
    }

    @Override // com.baidu.live.challenge.h
    public int be(boolean z) {
        int j = com.baidu.live.utils.g.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.gvV != null && this.gvV.getCloseBtnView() != null && this.gvV.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.gvV.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean ec(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gwl == null) {
            this.gwl = new com.baidu.live.follow.a.a();
        }
        this.gwl.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gvV != null) {
                    d.this.gvV.lU(z2);
                }
            }
        });
        this.gwl.an(str, str2);
        return true;
    }

    private void bQK() {
        if (this.gwm == null) {
            this.gwm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gwh > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gwh))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gvV != null) {
                                    d.this.gvV.lU(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gvV != null) {
                                d.this.gvV.lU(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gwm);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gwd = true;
            this.gvV.setCloseBtnVisible(false);
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
        if (this.gwc && i == 3 && j == this.challengeId) {
            if (com.baidu.live.w.a.Nk().beH == null || com.baidu.live.w.a.Nk().beH.aGv == 1) {
                bQL();
            }
        }
    }

    public void bQL() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
