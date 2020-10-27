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
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.bu;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
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
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class d implements h {
    private long gZD;
    private com.baidu.live.follow.a.b gZH;
    private CustomMessageListener gZI;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gZJ;
    private AlaChallengeLiveView gZr;
    private a gZs;
    private g gZt;
    private AlaChallengeCountDown gZu;
    private i gZv;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gZw = false;
    private boolean gZx = false;
    private boolean gZy = false;
    private boolean gZz = true;
    private boolean gZA = false;
    private boolean gZB = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long gZC = 0;
    private boolean isHost = false;
    private boolean gZE = false;
    private boolean gZF = false;
    private boolean gZG = false;
    public boolean gYy = false;
    private Set<Long> gZK = new HashSet();
    private a.InterfaceC0657a gZL = new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0657a
        public void bYm() {
            if (d.this.gZr != null && d.this.gZr.getParent() != null) {
                d.this.gZx = true;
                if (d.this.gZt != null) {
                    d.this.gZt.CY();
                }
                d.this.gZr.setCloseBtnVisible(true);
                d.this.gZr.setLiveContainerVisible(true);
                if (!d.this.gZK.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.gZK.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.gZF && !d.this.isHost) || (!d.this.gZE && d.this.isHost)) {
                        if (d.this.gZu == null) {
                            d.this.gZu = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gZu.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gZu.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gZu.getParent() != null) {
                            ((ViewGroup) d.this.gZu.getParent()).removeView(d.this.gZu);
                        }
                        d.this.gZr.getLiveContainerView().addView(d.this.gZu, layoutParams);
                        d.this.gZu.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gZA = true;
                }
                d.this.bYw();
                d.this.bYx();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0657a
        public void bYn() {
            if (d.this.gZr != null && d.this.gZr.getParent() != null) {
                d.this.gZy = false;
                if (d.this.gZt != null) {
                    d.this.gZt.bh(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gZr.setLiveContainerVisible(false);
                bYo();
                bYp();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0657a
        public void bYo() {
            if (d.this.gZr != null && d.this.gZr.getParent() != null) {
                if (!d.this.gZy) {
                    d.this.bYv();
                    d.this.bYy();
                }
                d.this.gZA = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0657a
        public void bYp() {
            d.this.gZB = false;
        }
    };
    private AlaChallengeLiveView.a gZM = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bYk() {
            d.this.mT(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bu buVar) {
            if (buVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (buVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), buVar.aIv);
            } else {
                d.this.mT(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bb bbVar) {
            if (bbVar != null && bbVar.aNs != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bbVar.aNs.userId), bbVar.aNs.userName, bbVar.aNs.portrait, bbVar.aNs.sex, bbVar.aNs.levelId, null, null, 0L, bbVar.aNs.fansCount, bbVar.aNs.followCount, bbVar.aNs.userStatus, String.valueOf(bbVar.aNG.group_id), String.valueOf(bbVar.aNG.live_id), false, String.valueOf(bbVar.aNs.userId), bbVar.aNs.appId, bbVar.aNs.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bb bbVar) {
            if (bbVar != null && bbVar.aNs != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bbVar.aNs.userId));
                    fVar.setPortrait(bbVar.aNs.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.TX().a(String.valueOf(bbVar.aNs.userId), fVar);
                    if (d.this.gZr != null) {
                        d.this.gZr.mR(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bb bbVar) {
            if (!d.this.isHost) {
                if (d.this.gZG) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gZr);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.z.a.Pq().bmJ.aLL || !TbadkCoreApplication.getInst().isMobileBaidu()) && bbVar != null && bbVar.aNG != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bbVar.aNG.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bYl() {
            if (d.this.gYy && d.this.gZt != null) {
                d.this.gZt.bi(d.this.gYy);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void mS(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.b.d dVar = new com.baidu.live.b.d(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            dVar.b(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        }
    };
    private HttpMessageListener gZN = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gZJ != null) {
                    d.this.gZJ.release();
                }
                d.this.gZJ = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.gZv, getChallengeMvpToastInfoResponseMessage);
                d.this.gZJ.PJ();
            }
        }
    };
    CustomMessageListener gZO = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gZv != null) {
                d.this.gZv.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener gZP = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gZD > 0 && d.this.gZr != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gZD))) {
                    d.this.gZr.mR(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gZs = new a(tbPageContext.getPageActivity());
        this.gZs.a(this.gZL);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gZs.bQ(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gZN);
        MessageManager.getInstance().registerListener(this.gZO);
        MessageManager.getInstance().registerListener(this.gZP);
    }

    @Override // com.baidu.live.challenge.h
    public void m(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gZF = z;
        this.isHost = z2;
        this.gZE = z3;
    }

    private void bYt() {
        if (this.gZr == null) {
            this.gZr = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gZr.setIsHost(this.isHost);
            this.gZr.setViewClickCallBack(this.gZM);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.gYy = z;
        if (this.gZr != null) {
            this.gZr.setNeedCloseRecommendFloat(this.gYy);
        }
    }

    private void bYu() {
        int i = 0;
        if (this.gZr != null && this.mParentView != null) {
            if (this.gZr.getParent() != null) {
                ((ViewGroup) this.gZr.getParent()).removeView(this.gZr);
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
            if (this.gZr.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gZr, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gZr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
        if (this.gZr != null && this.gZr.getParent() != null) {
            ((ViewGroup) this.gZr.getParent()).removeView(this.gZr);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gZv = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gZt = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Da() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gZx);
        }
        this.gZB = true;
        bYx();
    }

    @Override // com.baidu.live.challenge.h
    public void dM(int i) {
        if (1 == i) {
            this.gZA = true;
            bYw();
        }
        if (2 == i) {
            this.gZB = true;
            bYx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        if (this.gZx && this.gZA) {
            this.gZs.k(this.gZr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
        if (this.gZx && this.gZB) {
            this.gZs.j(this.gZr);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ax axVar, bb bbVar, bb bbVar2) {
        this.gZy = true;
        this.gZz = false;
        f(axVar, bbVar, bbVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ax axVar, bb bbVar, bb bbVar2) {
        this.gZy = true;
        this.gZz = true;
        f(axVar, bbVar, bbVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ax axVar, final bb bbVar, bb bbVar2) {
        long j = -1;
        if (this.gZw) {
            this.gZy = true;
            this.gZz = true;
            if (axVar.aNv == 2) {
                f(axVar, bbVar, bbVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(bbVar);
                    }
                }, 5000L);
                return;
            }
            g(bbVar);
            return;
        }
        long j2 = axVar != null ? axVar.challengeId : -1L;
        if (bbVar != null && bbVar.aNG != null) {
            j = bbVar.aNG.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ax axVar, bb bbVar, bb bbVar2) {
    }

    private void f(ax axVar, bb bbVar, bb bbVar2) {
        if (axVar != null) {
            this.challengeId = axVar.challengeId;
        }
        if (bbVar != null) {
            if (bbVar.aNs != null) {
                this.anchorId = bbVar.aNs.userId;
            }
            if (bbVar.aNG != null) {
                this.liveId = bbVar.aNG.live_id;
            }
        }
        if (bbVar2 != null && bbVar2.aNs != null) {
            this.gZD = bbVar2.aNs.userId;
        }
        if (!this.gZw) {
            this.gZw = true;
            if (this.gZt != null) {
                this.gZt.CX();
            }
            bYt();
            bYu();
            this.gZA = false;
            this.gZB = false;
            if (this.gZs != null && this.gZr != null) {
                this.gZr.a(axVar, bbVar, bbVar2, true);
                this.gZr.setRivalUserViewBg(bbVar2);
                this.gZr.setAnchorUserViewBg(bbVar);
                if (this.gZt != null) {
                    this.gZt.a(axVar, bbVar, bbVar2);
                }
                if (this.gZs != null) {
                    this.gZs.a(this.mTbPageContext.getPageActivity(), this.gZr);
                }
                bYz();
                String str = null;
                if (bbVar2 != null && bbVar2.aNG != null) {
                    str = String.valueOf(bbVar2.aNG.live_id);
                }
                if (TextUtils.isEmpty(str) || !et(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gZr.mR(false);
                }
            }
        }
        if (this.gZx && this.gZr != null) {
            this.gZr.a(axVar, bbVar, bbVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(w wVar) {
        if (wVar != null && wVar.aIe != null) {
            this.gZC = wVar.aIe.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bb bbVar) {
        if (this.gZt != null) {
            this.gZt.CZ();
        }
        if (this.gZr != null) {
            this.gZr.setAnchorUserViewBg(bbVar);
        }
        if (this.gZr != null) {
            this.gZr.bYh();
            this.gZr.bYg();
            this.gZs.b(this.mTbPageContext.getPageActivity(), this.gZr);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void CT() {
        if (this.gZy) {
            if (this.gZt != null) {
                this.gZt.bh(true);
            }
            if (this.gZr != null) {
                this.gZr.bYf();
            }
            this.gZA = false;
            this.gZB = false;
            bYy();
            this.mHandler.removeCallbacksAndMessages(null);
            bYv();
            if (this.gZJ != null) {
                this.gZJ.release();
                this.gZJ = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bYy();
        this.gZs.a((a.InterfaceC0657a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gZJ != null) {
            this.gZJ.release();
            this.gZJ = null;
        }
        if (this.gZK != null) {
            this.gZK.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.gZN);
        MessageManager.getInstance().unRegisterListener(this.gZO);
        MessageManager.getInstance().unRegisterListener(this.gZP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        MessageManager.getInstance().unRegisterListener(this.gZI);
        if (this.gZH != null) {
            this.gZH.release();
        }
        this.gZs.Ho();
        if (this.gZr != null) {
            this.gZr.releaseResource();
        }
        if (this.gZu != null) {
            this.gZu.bYd();
        }
        this.gZy = false;
        this.gZw = false;
        this.gZx = false;
        this.gZD = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.gZz = true;
            this.gZr.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(final boolean z) {
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
                    d.this.gZv.Dm();
                    return;
                }
                d.this.gZv.Dk();
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
        return this.gZy;
    }

    @Override // com.baidu.live.challenge.h
    public int bj(boolean z) {
        int j = com.baidu.live.utils.h.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.gZr != null && this.gZr.getCloseBtnView() != null && this.gZr.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.gZr.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean et(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gZH == null) {
            this.gZH = new com.baidu.live.follow.a.a();
        }
        this.gZH.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gZr != null) {
                    d.this.gZr.mR(z2);
                }
            }
        });
        this.gZH.aq(str, str2);
        return true;
    }

    private void bYz() {
        if (this.gZI == null) {
            this.gZI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gZD > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gZD))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gZr != null) {
                                    d.this.gZr.mR(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gZr != null) {
                                d.this.gZr.mR(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.TX().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gZI);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gZz = true;
            this.gZr.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void d(int i, long j) {
        if (this.gZy && i == 3 && j == this.challengeId) {
            if (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aLs == 1) {
                bYA();
            }
        }
    }

    public void bYA() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
