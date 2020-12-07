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
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.bx;
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
    private AlaChallengeLiveView hoK;
    private a hoL;
    private g hoM;
    private AlaChallengeCountDown hoN;
    private i hoO;
    private long hoW;
    private com.baidu.live.follow.a.b hpa;
    private CustomMessageListener hpb;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hpc;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hoP = false;
    private boolean hoQ = false;
    private boolean hoR = false;
    private boolean hoS = true;
    private boolean hoT = false;
    private boolean hoU = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hoV = 0;
    private boolean isHost = false;
    private boolean hoX = false;
    private boolean hoY = false;
    private boolean hoZ = false;
    public boolean hnR = false;
    private Set<Long> hpd = new HashSet();
    private a.InterfaceC0684a hpe = new a.InterfaceC0684a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void cec() {
            if (d.this.hoK != null && d.this.hoK.getParent() != null) {
                d.this.hoQ = true;
                if (d.this.hoM != null) {
                    d.this.hoM.Es();
                }
                d.this.hoK.setCloseBtnVisible(true);
                d.this.hoK.setLiveContainerVisible(true);
                if (!d.this.hpd.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hpd.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hoY && !d.this.isHost) || (!d.this.hoX && d.this.isHost)) {
                        if (d.this.hoN == null) {
                            d.this.hoN = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hoN.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hoN.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hoN.getParent() != null) {
                            ((ViewGroup) d.this.hoN.getParent()).removeView(d.this.hoN);
                        }
                        d.this.hoK.getLiveContainerView().addView(d.this.hoN, layoutParams);
                        d.this.hoN.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hoT = true;
                }
                d.this.cem();
                d.this.cen();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void ced() {
            if (d.this.hoK != null && d.this.hoK.getParent() != null) {
                d.this.hoR = false;
                if (d.this.hoM != null) {
                    d.this.hoM.bs(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hoK.setLiveContainerVisible(false);
                cee();
                cef();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void cee() {
            if (d.this.hoK != null && d.this.hoK.getParent() != null) {
                if (!d.this.hoR) {
                    d.this.cel();
                    d.this.ceo();
                }
                d.this.hoT = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void cef() {
            d.this.hoU = false;
        }
    };
    private AlaChallengeLiveView.a hpf = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cea() {
            d.this.ny(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bx bxVar) {
            if (bxVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (bxVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bxVar.aKm);
            } else {
                d.this.ny(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(be beVar) {
            if (beVar != null && beVar.aPJ != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(beVar.aPJ.userId), beVar.aPJ.userName, beVar.aPJ.portrait, beVar.aPJ.sex, beVar.aPJ.levelId, null, null, 0L, beVar.aPJ.fansCount, beVar.aPJ.followCount, beVar.aPJ.userStatus, String.valueOf(beVar.aPX.group_id), String.valueOf(beVar.aPX.live_id), false, String.valueOf(beVar.aPJ.userId), beVar.aPJ.appId, beVar.aPJ.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(be beVar) {
            if (beVar != null && beVar.aPJ != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(beVar.aPJ.userId));
                    fVar.setPortrait(beVar.aPJ.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Yo().a(String.valueOf(beVar.aPJ.userId), fVar);
                    if (d.this.hoK != null) {
                        d.this.hoK.nw(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(be beVar) {
            if (!d.this.isHost) {
                if (d.this.hoZ) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hoK);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.ae.a.RB().brA.aNV || !TbadkCoreApplication.getInst().isMobileBaidu()) && beVar != null && beVar.aPX != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(beVar.aPX.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void ceb() {
            if (d.this.hnR && d.this.hoM != null) {
                d.this.hoM.bt(d.this.hnR);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void nx(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.d.d dVar = new com.baidu.live.d.d(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            dVar.b(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        }
    };
    private HttpMessageListener hpg = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.hpc != null) {
                    d.this.hpc.release();
                }
                d.this.hpc = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hoO, getChallengeMvpToastInfoResponseMessage);
                d.this.hpc.RU();
            }
        }
    };
    CustomMessageListener hph = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hoO != null) {
                d.this.hoO.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hpi = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hoW > 0 && d.this.hoK != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hoW))) {
                    d.this.hoK.nw(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hoL = new a(tbPageContext.getPageActivity());
        this.hoL.a(this.hpe);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hoL.bW(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hpg);
        MessageManager.getInstance().registerListener(this.hph);
        MessageManager.getInstance().registerListener(this.hpi);
    }

    @Override // com.baidu.live.challenge.h
    public void i(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.hoY = z;
        this.isHost = z2;
        this.hoX = z3;
    }

    private void cej() {
        if (this.hoK == null) {
            this.hoK = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hoK.setIsHost(this.isHost);
            this.hoK.setViewClickCallBack(this.hpf);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnR = z;
        if (this.hoK != null) {
            this.hoK.setNeedCloseRecommendFloat(this.hnR);
        }
    }

    private void cek() {
        int i = 0;
        if (this.hoK != null && this.mParentView != null) {
            if (this.hoK.getParent() != null) {
                ((ViewGroup) this.hoK.getParent()).removeView(this.hoK);
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
            if (this.hoK.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hoK, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hoK, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cel() {
        if (this.hoK != null && this.hoK.getParent() != null) {
            ((ViewGroup) this.hoK.getParent()).removeView(this.hoK);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hoO = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hoM = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Eu() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hoQ);
        }
        this.hoU = true;
        cen();
    }

    @Override // com.baidu.live.challenge.h
    public void eb(int i) {
        if (1 == i) {
            this.hoT = true;
            cem();
        }
        if (2 == i) {
            this.hoU = true;
            cen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        if (this.hoQ && this.hoT) {
            this.hoL.k(this.hoK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hoQ && this.hoU) {
            this.hoL.j(this.hoK);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ba baVar, be beVar, be beVar2) {
        this.hoR = true;
        this.hoS = false;
        f(baVar, beVar, beVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ba baVar, be beVar, be beVar2) {
        this.hoR = true;
        this.hoS = true;
        f(baVar, beVar, beVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ba baVar, final be beVar, be beVar2) {
        long j = -1;
        if (this.hoP) {
            this.hoR = true;
            this.hoS = true;
            if (baVar.aPM == 2) {
                f(baVar, beVar, beVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(beVar);
                    }
                }, 5000L);
                return;
            }
            g(beVar);
            return;
        }
        long j2 = baVar != null ? baVar.challengeId : -1L;
        if (beVar != null && beVar.aPX != null) {
            j = beVar.aPX.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(ba baVar, be beVar, be beVar2) {
    }

    private void f(ba baVar, be beVar, be beVar2) {
        if (baVar != null) {
            this.challengeId = baVar.challengeId;
        }
        if (beVar != null) {
            if (beVar.aPJ != null) {
                this.anchorId = beVar.aPJ.userId;
            }
            if (beVar.aPX != null) {
                this.liveId = beVar.aPX.live_id;
            }
        }
        if (beVar2 != null && beVar2.aPJ != null) {
            this.hoW = beVar2.aPJ.userId;
        }
        if (!this.hoP) {
            this.hoP = true;
            if (this.hoM != null) {
                this.hoM.Er();
            }
            cej();
            cek();
            this.hoT = false;
            this.hoU = false;
            if (this.hoL != null && this.hoK != null) {
                this.hoK.a(baVar, beVar, beVar2, true);
                this.hoK.setRivalUserViewBg(beVar2);
                this.hoK.setAnchorUserViewBg(beVar);
                if (this.hoM != null) {
                    this.hoM.a(baVar, beVar, beVar2);
                }
                if (this.hoL != null) {
                    this.hoL.a(this.mTbPageContext.getPageActivity(), this.hoK);
                }
                cep();
                String str = null;
                if (beVar2 != null && beVar2.aPX != null) {
                    str = String.valueOf(beVar2.aPX.live_id);
                }
                if (TextUtils.isEmpty(str) || !ez(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hoK.nw(false);
                }
            }
        }
        if (this.hoQ && this.hoK != null) {
            this.hoK.a(baVar, beVar, beVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(w wVar) {
        if (wVar != null && wVar.aJV != null) {
            this.hoV = wVar.aJV.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(be beVar) {
        if (this.hoM != null) {
            this.hoM.Et();
        }
        if (this.hoK != null) {
            this.hoK.setAnchorUserViewBg(beVar);
        }
        if (this.hoK != null) {
            this.hoK.cdX();
            this.hoK.cdW();
            this.hoL.b(this.mTbPageContext.getPageActivity(), this.hoK);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void En() {
        if (this.hoR) {
            if (this.hoM != null) {
                this.hoM.bs(true);
            }
            if (this.hoK != null) {
                this.hoK.cdV();
            }
            this.hoT = false;
            this.hoU = false;
            ceo();
            this.mHandler.removeCallbacksAndMessages(null);
            cel();
            if (this.hpc != null) {
                this.hpc.release();
                this.hpc = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        ceo();
        this.hoL.a((a.InterfaceC0684a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hpc != null) {
            this.hpc.release();
            this.hpc = null;
        }
        if (this.hpd != null) {
            this.hpd.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hpg);
        MessageManager.getInstance().unRegisterListener(this.hph);
        MessageManager.getInstance().unRegisterListener(this.hpi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceo() {
        MessageManager.getInstance().unRegisterListener(this.hpb);
        if (this.hpa != null) {
            this.hpa.release();
        }
        this.hoL.IW();
        if (this.hoK != null) {
            this.hoK.releaseResource();
        }
        if (this.hoN != null) {
            this.hoN.cdT();
        }
        this.hoR = false;
        this.hoP = false;
        this.hoQ = false;
        this.hoW = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hoS = true;
            this.hoK.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(final boolean z) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (z) {
            bdAlertDialog.setMessageId(a.h.ala_challenge_punish_close_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.h.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setPositiveButton(a.h.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    d.this.hoO.EG();
                    return;
                }
                d.this.hoO.EE();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bdAlertDialog.setPositiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            bdAlertDialog.setNagetiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.h
    public boolean isActive() {
        return this.hoR;
    }

    @Override // com.baidu.live.challenge.h
    public int bu(boolean z) {
        int o = com.baidu.live.utils.h.o(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hoK != null && this.hoK.getCloseBtnView() != null && this.hoK.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hoK.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + o;
            }
        }
        return o;
    }

    private boolean ez(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hpa == null) {
            this.hpa = new com.baidu.live.follow.a.a();
        }
        this.hpa.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hoK != null) {
                    d.this.hoK.nw(z2);
                }
            }
        });
        this.hpa.av(str, str2);
        return true;
    }

    private void cep() {
        if (this.hpb == null) {
            this.hpb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hoW > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hoW))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hoK != null) {
                                    d.this.hoK.nw(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hoK != null) {
                                d.this.hoK.nw(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpb);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hoS = true;
            this.hoK.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void c(int i, long j) {
        if (this.hoR && i == 3 && j == this.challengeId) {
            if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aNC == 1) {
                ceq();
            }
        }
    }

    public void ceq() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
