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
    private AlaChallengeLiveView gvZ;
    private a gwa;
    private g gwb;
    private AlaChallengeCountDown gwc;
    private i gwd;
    private long gwl;
    private com.baidu.live.follow.a.b gwp;
    private CustomMessageListener gwq;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gwr;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gwe = false;
    private boolean gwf = false;
    private boolean gwg = false;
    private boolean gwh = true;
    private boolean gwi = false;
    private boolean gwj = false;
    private long challengeId = 0;
    private long aCw = 0;
    private long liveId = -1;
    private long gwk = 0;
    private boolean isHost = false;
    private boolean gwm = false;
    private boolean gwn = false;
    private boolean gwo = false;
    public boolean guN = false;
    private a.InterfaceC0627a gws = new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQx() {
            if (d.this.gvZ != null && d.this.gvZ.getParent() != null) {
                d.this.gwf = true;
                if (d.this.gwb != null) {
                    d.this.gwb.BG();
                }
                d.this.gvZ.setCloseBtnVisible(true);
                d.this.gvZ.setLiveContainerVisible(true);
                if (!com.baidu.live.c.AD().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, false)) {
                    com.baidu.live.c.AD().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, true);
                    if ((!d.this.gwn && !d.this.isHost) || (!d.this.gwm && d.this.isHost)) {
                        if (d.this.gwc == null) {
                            d.this.gwc = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gwc.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gwc.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gwc.getParent() != null) {
                            ((ViewGroup) d.this.gwc.getParent()).removeView(d.this.gwc);
                        }
                        d.this.gvZ.getLiveContainerView().addView(d.this.gwc, layoutParams);
                        d.this.gwc.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gwi = true;
                }
                d.this.bQI();
                d.this.bQJ();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQy() {
            if (d.this.gvZ != null && d.this.gvZ.getParent() != null) {
                d.this.gwg = false;
                if (d.this.gwb != null) {
                    d.this.gwb.bc(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.aCw = d.this.aCw;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gvZ.setLiveContainerVisible(false);
                d.this.gwi = true;
                d.this.gwj = true;
                d.this.bQI();
                d.this.bQJ();
                d.this.gwi = false;
                d.this.gwj = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQz() {
            if (d.this.gvZ != null && d.this.gvZ.getParent() != null) {
                if (!d.this.gwg) {
                    d.this.bQH();
                    d.this.bQK();
                }
                d.this.gwi = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0627a
        public void bQA() {
            d.this.gwj = false;
        }
    };
    private AlaChallengeLiveView.a gwt = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bQv() {
            d.this.lY(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bj bjVar) {
            if (bjVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bjVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bjVar.aDU);
            } else {
                d.this.lY(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(at atVar) {
            if (atVar != null && atVar.aIn != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(atVar.aIn.userId), atVar.aIn.userName, atVar.aIn.portrait, atVar.aIn.sex, atVar.aIn.levelId, null, null, 0L, atVar.aIn.fansCount, atVar.aIn.followCount, atVar.aIn.userStatus, String.valueOf(atVar.aIG.group_id), String.valueOf(atVar.aIG.live_id), false, String.valueOf(d.this.gwk), atVar.aIn.appId, atVar.aIn.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(at atVar) {
            if (atVar != null && atVar.aIn != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(String.valueOf(atVar.aIn.userId));
                    dVar.setPortrait(atVar.aIn.portrait);
                    dVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Qx().a(String.valueOf(atVar.aIn.userId), dVar);
                    if (d.this.gvZ != null) {
                        d.this.gvZ.lW(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(at atVar) {
            if (!d.this.isHost) {
                if (d.this.gwo) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gvZ);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.w.a.Nk().beJ.aGO || !TbadkCoreApplication.getInst().isMobileBaidu()) && atVar != null && atVar.aIG != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(atVar.aIG.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bQw() {
            if (d.this.guN && d.this.gwb != null) {
                d.this.gwb.bd(d.this.guN);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void lX(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.aCw);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gwu = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gwr != null) {
                    d.this.gwr.release();
                }
                d.this.gwr = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.aCw, d.this.challengeId, d.this.gwd, getChallengeMvpToastInfoResponseMessage);
                d.this.gwr.Nv();
            }
        }
    };
    CustomMessageListener gwv = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gwd != null) {
                d.this.gwd.a(d.this.challengeId, d.this.liveId, d.this.aCw, 6, "0");
            }
        }
    };
    private CustomMessageListener gww = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gwl > 0 && d.this.gvZ != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gwl))) {
                    d.this.gvZ.lW(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gwa = new a(tbPageContext.getPageActivity());
        this.gwa.a(this.gws);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gwa.bO(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gwu);
        MessageManager.getInstance().registerListener(this.gwv);
        MessageManager.getInstance().registerListener(this.gww);
    }

    @Override // com.baidu.live.challenge.h
    public void l(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gwn = z;
        this.isHost = z2;
        this.gwm = z3;
    }

    private void bQF() {
        if (this.gvZ == null) {
            this.gvZ = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gvZ.setIsHost(this.isHost);
            this.gvZ.setViewClickCallBack(this.gwt);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.guN = z;
        if (this.gvZ != null) {
            this.gvZ.setNeedCloseRecommendFloat(this.guN);
        }
    }

    private void bQG() {
        int i = 0;
        if (this.gvZ != null && this.mParentView != null) {
            if (this.gvZ.getParent() != null) {
                ((ViewGroup) this.gvZ.getParent()).removeView(this.gvZ);
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
            if (this.gvZ.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gvZ, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gvZ, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQH() {
        if (this.gvZ != null && this.gvZ.getParent() != null) {
            ((ViewGroup) this.gvZ.getParent()).removeView(this.gvZ);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gwd = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gwb = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void BI() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gwf);
        }
        this.gwj = true;
        bQJ();
    }

    @Override // com.baidu.live.challenge.h
    public void dD(int i) {
        if (1 == i) {
            this.gwi = true;
            bQI();
        }
        if (2 == i) {
            this.gwj = true;
            bQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQI() {
        if (this.gwf && this.gwi) {
            this.gwa.e(this.gvZ);
            if (this.gvZ != null && this.gvZ.getAnchorAnimLiveBgView() != null) {
                this.gvZ.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQJ() {
        if (this.gwf && this.gwj) {
            this.gwa.d(this.gvZ);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ap apVar, at atVar, at atVar2) {
        this.gwg = true;
        this.gwh = false;
        f(apVar, atVar, atVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ap apVar, at atVar, at atVar2) {
        this.gwg = true;
        this.gwh = true;
        f(apVar, atVar, atVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ap apVar, final at atVar, at atVar2) {
        long j = -1;
        if (this.gwe) {
            this.gwg = true;
            this.gwh = true;
            if (apVar.aIq == 2) {
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
        if (atVar != null && atVar.aIG != null) {
            j = atVar.aIG.live_id;
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
            if (atVar.aIn != null) {
                this.aCw = atVar.aIn.userId;
            }
            if (atVar.aIG != null) {
                this.liveId = atVar.aIG.live_id;
            }
        }
        if (atVar2 != null && atVar2.aIn != null) {
            this.gwl = atVar2.aIn.userId;
        }
        if (!this.gwe) {
            this.gwe = true;
            if (this.gwb != null) {
                this.gwb.BF();
            }
            bQF();
            bQG();
            this.gwi = false;
            this.gwj = false;
            if (this.gwa != null && this.gvZ != null) {
                this.gvZ.a(apVar, atVar, atVar2, true);
                this.gvZ.setRivalUserViewBg(atVar2);
                this.gvZ.setAnchorUserViewBg(atVar);
                if (this.gwb != null) {
                    this.gwb.a(apVar, atVar, atVar2);
                }
                if (this.gwa != null) {
                    this.gwa.a(this.mTbPageContext.getPageActivity(), this.gvZ);
                }
                bQL();
                String str = null;
                if (atVar2 != null && atVar2.aIG != null) {
                    str = String.valueOf(atVar2.aIG.live_id);
                }
                if (TextUtils.isEmpty(str) || !ed(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gvZ.lW(false);
                }
            }
        }
        if (this.gwf && this.gvZ != null) {
            this.gvZ.a(apVar, atVar, atVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(r rVar) {
        if (rVar != null && rVar.aDG != null) {
            this.gwk = rVar.aDG.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(at atVar) {
        if (this.gwb != null) {
            this.gwb.BH();
        }
        if (this.gvZ != null) {
            this.gvZ.setAnchorUserViewBg(atVar);
        }
        if (this.gvZ != null) {
            this.gvZ.bQu();
            this.gvZ.bQt();
            this.gwa.b(this.mTbPageContext.getPageActivity(), this.gvZ);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void BB() {
        if (this.gwg) {
            if (this.gwb != null) {
                this.gwb.bc(true);
            }
            if (this.gvZ != null) {
                this.gvZ.bQs();
            }
            this.gwi = false;
            this.gwj = false;
            bQK();
            this.mHandler.removeCallbacksAndMessages(null);
            bQH();
            if (this.gwr != null) {
                this.gwr.release();
                this.gwr = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bQK();
        this.gwa.a((a.InterfaceC0627a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gwr != null) {
            this.gwr.release();
            this.gwr = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gwu);
        MessageManager.getInstance().unRegisterListener(this.gwv);
        MessageManager.getInstance().unRegisterListener(this.gww);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQK() {
        MessageManager.getInstance().unRegisterListener(this.gwq);
        if (this.gwp != null) {
            this.gwp.release();
        }
        this.gwa.Fw();
        if (this.gvZ != null) {
            this.gvZ.releaseResource();
        }
        if (this.gwc != null) {
            this.gwc.bQq();
        }
        this.gwg = false;
        this.gwe = false;
        this.gwf = false;
        this.gwl = 0L;
    }

    @Override // com.baidu.live.challenge.i.m
    public void d(boolean z, String str) {
        if (z) {
            this.gwh = true;
            this.gvZ.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(final boolean z) {
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
                    d.this.gwd.BT();
                    return;
                }
                d.this.gwd.BR();
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
        return this.gwg;
    }

    @Override // com.baidu.live.challenge.h
    public int be(boolean z) {
        int j = com.baidu.live.utils.g.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.gvZ != null && this.gvZ.getCloseBtnView() != null && this.gvZ.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.gvZ.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean ed(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gwp == null) {
            this.gwp = new com.baidu.live.follow.a.a();
        }
        this.gwp.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gvZ != null) {
                    d.this.gvZ.lW(z2);
                }
            }
        });
        this.gwp.an(str, str2);
        return true;
    }

    private void bQL() {
        if (this.gwq == null) {
            this.gwq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gwl > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gwl))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gvZ != null) {
                                    d.this.gvZ.lW(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gvZ != null) {
                                d.this.gvZ.lW(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gwq);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gwh = true;
            this.gvZ.setCloseBtnVisible(false);
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
        if (this.gwg && i == 3 && j == this.challengeId) {
            if (com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aGx == 1) {
                bQM();
            }
        }
    }

    public void bQM() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
