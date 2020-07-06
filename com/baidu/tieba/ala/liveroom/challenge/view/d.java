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
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.bg;
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
/* loaded from: classes3.dex */
public class d implements h {
    private AlaChallengeLiveView geH;
    private a geI;
    private g geJ;
    private AlaChallengeCountDown geK;
    private i geL;
    private long geT;
    private com.baidu.live.follow.a.b geX;
    private CustomMessageListener geY;
    private com.baidu.tieba.ala.liveroom.challenge.c.a geZ;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean geM = false;
    private boolean geN = false;
    private boolean geO = false;
    private boolean geP = true;
    private boolean geQ = false;
    private boolean geR = false;
    private long challengeId = 0;
    private long awn = 0;
    private long liveId = -1;
    private long geS = 0;
    private boolean isHost = false;
    private boolean geU = false;
    private boolean geV = false;
    private boolean geW = false;
    public boolean gdw = false;
    private a.InterfaceC0569a gfa = new a.InterfaceC0569a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0569a
        public void bDH() {
            if (d.this.geH != null && d.this.geH.getParent() != null) {
                d.this.geN = true;
                if (d.this.geJ != null) {
                    d.this.geJ.vM();
                }
                d.this.geH.setCloseBtnVisible(true);
                d.this.geH.setLiveContainerVisible(true);
                if (!com.baidu.live.c.vf().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, false)) {
                    com.baidu.live.c.vf().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + d.this.challengeId, true);
                    if ((!d.this.geV && !d.this.isHost) || (!d.this.geU && d.this.isHost)) {
                        if (d.this.geK == null) {
                            d.this.geK = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.geK.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.geK.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.geK.getParent() != null) {
                            ((ViewGroup) d.this.geK.getParent()).removeView(d.this.geK);
                        }
                        d.this.geH.getLiveContainerView().addView(d.this.geK, layoutParams);
                        d.this.geK.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.geQ = true;
                }
                d.this.bDS();
                d.this.bDT();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0569a
        public void bDI() {
            if (d.this.geH != null && d.this.geH.getParent() != null) {
                d.this.geO = false;
                if (d.this.geJ != null) {
                    d.this.geJ.aU(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.awn = d.this.awn;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.geH.setLiveContainerVisible(false);
                d.this.geQ = true;
                d.this.geR = true;
                d.this.bDS();
                d.this.bDT();
                d.this.geQ = false;
                d.this.geR = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0569a
        public void bDJ() {
            if (d.this.geH != null && d.this.geH.getParent() != null) {
                if (!d.this.geO) {
                    d.this.bDR();
                    d.this.bDU();
                }
                d.this.geQ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0569a
        public void bDK() {
            d.this.geR = false;
        }
    };
    private AlaChallengeLiveView.a gfb = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bDF() {
            d.this.kS(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bg bgVar) {
            if (bgVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bgVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bgVar.ayj);
            } else {
                d.this.kS(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(aq aqVar) {
            if (aqVar != null && aqVar.aBG != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(aqVar.aBG.userId), aqVar.aBG.userName, aqVar.aBG.portrait, aqVar.aBG.sex, aqVar.aBG.levelId, null, null, 0L, aqVar.aBG.fansCount, aqVar.aBG.followCount, aqVar.aBG.userStatus, String.valueOf(aqVar.aBZ.group_id), String.valueOf(aqVar.aBZ.live_id), false, String.valueOf(d.this.geS), aqVar.aBG.appId, aqVar.aBG.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(aq aqVar) {
            if (aqVar != null && aqVar.aBG != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(String.valueOf(aqVar.aBG.userId));
                    dVar.setPortrait(aqVar.aBG.portrait);
                    dVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Ky().a(String.valueOf(aqVar.aBG.userId), dVar);
                    if (d.this.geH != null) {
                        d.this.geH.kQ(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(aq aqVar) {
            if (!d.this.isHost) {
                if (d.this.geW) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.geH);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.v.a.Hm().aZp.aAp || !TbadkCoreApplication.getInst().isMobileBaidu()) && aqVar != null && aqVar.aBZ != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(aqVar.aBZ.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bDG() {
            if (d.this.gdw && d.this.geJ != null) {
                d.this.geJ.aV(d.this.gdw);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void kR(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.awn);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gfc = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.geZ != null) {
                    d.this.geZ.release();
                }
                d.this.geZ = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.awn, d.this.challengeId, d.this.geL, getChallengeMvpToastInfoResponseMessage);
                d.this.geZ.showDialog();
            }
        }
    };
    CustomMessageListener gfd = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.geL != null) {
                d.this.geL.a(d.this.challengeId, d.this.liveId, d.this.awn, 6, "0");
            }
        }
    };
    private CustomMessageListener gfe = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.geT > 0 && d.this.geH != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.geT))) {
                    d.this.geH.kQ(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.geI = new a(tbPageContext.getPageActivity());
        this.geI.a(this.gfa);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.geI.bD(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gfc);
        MessageManager.getInstance().registerListener(this.gfd);
        MessageManager.getInstance().registerListener(this.gfe);
    }

    @Override // com.baidu.live.challenge.h
    public void j(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.geV = z;
        this.isHost = z2;
        this.geU = z3;
    }

    private void bDP() {
        if (this.geH == null) {
            this.geH = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.geH.setIsHost(this.isHost);
            this.geH.setViewClickCallBack(this.gfb);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.gdw = z;
        if (this.geH != null) {
            this.geH.setNeedCloseRecommendFloat(this.gdw);
        }
    }

    private void bDQ() {
        int i = 0;
        if (this.geH != null && this.mParentView != null) {
            if (this.geH.getParent() != null) {
                ((ViewGroup) this.geH.getParent()).removeView(this.geH);
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
            if (this.geH.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.geH, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.geH, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (this.geH != null && this.geH.getParent() != null) {
            ((ViewGroup) this.geH.getParent()).removeView(this.geH);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.geL = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.geJ = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void vO() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.geN);
        }
        this.geR = true;
        bDT();
    }

    @Override // com.baidu.live.challenge.h
    public void bL(int i) {
        if (1 == i) {
            this.geQ = true;
            bDS();
        }
        if (2 == i) {
            this.geR = true;
            bDT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        if (this.geN && this.geQ) {
            this.geI.e(this.geH);
            if (this.geH != null && this.geH.getAnchorAnimLiveBgView() != null) {
                this.geH.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        if (this.geN && this.geR) {
            this.geI.d(this.geH);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(am amVar, aq aqVar, aq aqVar2) {
        this.geO = true;
        this.geP = false;
        f(amVar, aqVar, aqVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(am amVar, aq aqVar, aq aqVar2) {
        this.geO = true;
        this.geP = true;
        f(amVar, aqVar, aqVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(am amVar, final aq aqVar, aq aqVar2) {
        long j = -1;
        if (this.geM) {
            this.geO = true;
            this.geP = true;
            if (amVar.aBJ == 2) {
                f(amVar, aqVar, aqVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(aqVar);
                    }
                }, 5000L);
                return;
            }
            g(aqVar);
            return;
        }
        long j2 = amVar != null ? amVar.challengeId : -1L;
        if (aqVar != null && aqVar.aBZ != null) {
            j = aqVar.aBZ.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(am amVar, aq aqVar, aq aqVar2) {
    }

    private void f(am amVar, aq aqVar, aq aqVar2) {
        if (amVar != null) {
            this.challengeId = amVar.challengeId;
        }
        if (aqVar != null) {
            if (aqVar.aBG != null) {
                this.awn = aqVar.aBG.userId;
            }
            if (aqVar.aBZ != null) {
                this.liveId = aqVar.aBZ.live_id;
            }
        }
        if (aqVar2 != null && aqVar2.aBG != null) {
            this.geT = aqVar2.aBG.userId;
        }
        if (!this.geM) {
            this.geM = true;
            if (this.geJ != null) {
                this.geJ.vL();
            }
            bDP();
            bDQ();
            this.geQ = false;
            this.geR = false;
            if (this.geI != null && this.geH != null) {
                this.geH.a(amVar, aqVar, aqVar2, true);
                this.geH.setRivalUserViewBg(aqVar2);
                this.geH.setAnchorUserViewBg(aqVar);
                if (this.geJ != null) {
                    this.geJ.a(amVar, aqVar, aqVar2);
                }
                if (this.geI != null) {
                    this.geI.a(this.mTbPageContext.getPageActivity(), this.geH);
                }
                bDV();
                String str = null;
                if (aqVar2 != null && aqVar2.aBZ != null) {
                    str = String.valueOf(aqVar2.aBZ.live_id);
                }
                if (TextUtils.isEmpty(str) || !dL(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.geH.kQ(false);
                }
            }
        }
        if (this.geN && this.geH != null) {
            this.geH.a(amVar, aqVar, aqVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(q qVar) {
        if (qVar != null && qVar.axp != null) {
            this.geS = qVar.axp.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(aq aqVar) {
        if (this.geJ != null) {
            this.geJ.vN();
        }
        if (this.geH != null) {
            this.geH.setAnchorUserViewBg(aqVar);
        }
        if (this.geH != null) {
            this.geH.bDD();
            this.geH.bDC();
            this.geI.b(this.mTbPageContext.getPageActivity(), this.geH);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void vH() {
        if (this.geO) {
            if (this.geJ != null) {
                this.geJ.aU(true);
            }
            if (this.geH != null) {
                this.geH.bDB();
            }
            this.geQ = false;
            this.geR = false;
            bDU();
            this.mHandler.removeCallbacksAndMessages(null);
            bDR();
            if (this.geZ != null) {
                this.geZ.release();
                this.geZ = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bDU();
        this.geI.a((a.InterfaceC0569a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.geZ != null) {
            this.geZ.release();
            this.geZ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gfc);
        MessageManager.getInstance().unRegisterListener(this.gfd);
        MessageManager.getInstance().unRegisterListener(this.gfe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        MessageManager.getInstance().unRegisterListener(this.geY);
        if (this.geX != null) {
            this.geX.release();
        }
        this.geI.zr();
        if (this.geH != null) {
            this.geH.releaseResource();
        }
        if (this.geK != null) {
            this.geK.bDz();
        }
        this.geO = false;
        this.geM = false;
        this.geN = false;
        this.geT = 0L;
    }

    @Override // com.baidu.live.challenge.i.m
    public void d(boolean z, String str) {
        if (z) {
            this.geP = true;
            this.geH.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS(final boolean z) {
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
                    d.this.geL.vZ();
                    return;
                }
                d.this.geL.vX();
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
        return this.geO;
    }

    @Override // com.baidu.live.challenge.h
    public int aW(boolean z) {
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
        if (this.geX == null) {
            this.geX = new com.baidu.live.follow.a.a();
        }
        this.geX.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.geH != null) {
                    d.this.geH.kQ(z2);
                }
            }
        });
        this.geX.ak(str, str2);
        return true;
    }

    private void bDV() {
        if (this.geY == null) {
            this.geY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.geT > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.geT))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.geH != null) {
                                    d.this.geH.kQ(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.geH != null) {
                                d.this.geH.kQ(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.geY);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.geP = true;
            this.geH.setCloseBtnVisible(false);
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
        if (this.geO && i == 3 && j == this.challengeId) {
            if (com.baidu.live.v.a.Hm().aZp == null || com.baidu.live.v.a.Hm().aZp.azY == 1) {
                bDW();
            }
        }
    }

    public void bDW() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
