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
    private AlaChallengeLiveView hoM;
    private a hoN;
    private g hoO;
    private AlaChallengeCountDown hoP;
    private i hoQ;
    private long hoY;
    private com.baidu.live.follow.a.b hpc;
    private CustomMessageListener hpd;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hpe;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hoR = false;
    private boolean hoS = false;
    private boolean hoT = false;
    private boolean hoU = true;
    private boolean hoV = false;
    private boolean hoW = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hoX = 0;
    private boolean isHost = false;
    private boolean hoZ = false;
    private boolean hpa = false;
    private boolean hpb = false;
    public boolean hnT = false;
    private Set<Long> hpf = new HashSet();
    private a.InterfaceC0684a hpg = new a.InterfaceC0684a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void ced() {
            if (d.this.hoM != null && d.this.hoM.getParent() != null) {
                d.this.hoS = true;
                if (d.this.hoO != null) {
                    d.this.hoO.Es();
                }
                d.this.hoM.setCloseBtnVisible(true);
                d.this.hoM.setLiveContainerVisible(true);
                if (!d.this.hpf.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hpf.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hpa && !d.this.isHost) || (!d.this.hoZ && d.this.isHost)) {
                        if (d.this.hoP == null) {
                            d.this.hoP = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hoP.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hoP.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hoP.getParent() != null) {
                            ((ViewGroup) d.this.hoP.getParent()).removeView(d.this.hoP);
                        }
                        d.this.hoM.getLiveContainerView().addView(d.this.hoP, layoutParams);
                        d.this.hoP.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hoV = true;
                }
                d.this.cen();
                d.this.ceo();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void cee() {
            if (d.this.hoM != null && d.this.hoM.getParent() != null) {
                d.this.hoT = false;
                if (d.this.hoO != null) {
                    d.this.hoO.bs(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hoM.setLiveContainerVisible(false);
                cef();
                ceg();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void cef() {
            if (d.this.hoM != null && d.this.hoM.getParent() != null) {
                if (!d.this.hoT) {
                    d.this.cem();
                    d.this.cep();
                }
                d.this.hoV = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0684a
        public void ceg() {
            d.this.hoW = false;
        }
    };
    private AlaChallengeLiveView.a hph = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void ceb() {
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
                    if (d.this.hoM != null) {
                        d.this.hoM.nw(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(be beVar) {
            if (!d.this.isHost) {
                if (d.this.hpb) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hoM);
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
        public void cec() {
            if (d.this.hnT && d.this.hoO != null) {
                d.this.hoO.bt(d.this.hnT);
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
    private HttpMessageListener hpi = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.hpe != null) {
                    d.this.hpe.release();
                }
                d.this.hpe = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hoQ, getChallengeMvpToastInfoResponseMessage);
                d.this.hpe.RU();
            }
        }
    };
    CustomMessageListener hpj = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hoQ != null) {
                d.this.hoQ.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hpk = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hoY > 0 && d.this.hoM != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hoY))) {
                    d.this.hoM.nw(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hoN = new a(tbPageContext.getPageActivity());
        this.hoN.a(this.hpg);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hoN.bW(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hpi);
        MessageManager.getInstance().registerListener(this.hpj);
        MessageManager.getInstance().registerListener(this.hpk);
    }

    @Override // com.baidu.live.challenge.h
    public void i(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.hpa = z;
        this.isHost = z2;
        this.hoZ = z3;
    }

    private void cek() {
        if (this.hoM == null) {
            this.hoM = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hoM.setIsHost(this.isHost);
            this.hoM.setViewClickCallBack(this.hph);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnT = z;
        if (this.hoM != null) {
            this.hoM.setNeedCloseRecommendFloat(this.hnT);
        }
    }

    private void cel() {
        int i = 0;
        if (this.hoM != null && this.mParentView != null) {
            if (this.hoM.getParent() != null) {
                ((ViewGroup) this.hoM.getParent()).removeView(this.hoM);
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
            if (this.hoM.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hoM, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hoM, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cem() {
        if (this.hoM != null && this.hoM.getParent() != null) {
            ((ViewGroup) this.hoM.getParent()).removeView(this.hoM);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hoQ = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hoO = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Eu() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hoS);
        }
        this.hoW = true;
        ceo();
    }

    @Override // com.baidu.live.challenge.h
    public void eb(int i) {
        if (1 == i) {
            this.hoV = true;
            cen();
        }
        if (2 == i) {
            this.hoW = true;
            ceo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hoS && this.hoV) {
            this.hoN.k(this.hoM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceo() {
        if (this.hoS && this.hoW) {
            this.hoN.j(this.hoM);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(ba baVar, be beVar, be beVar2) {
        this.hoT = true;
        this.hoU = false;
        f(baVar, beVar, beVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(ba baVar, be beVar, be beVar2) {
        this.hoT = true;
        this.hoU = true;
        f(baVar, beVar, beVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(ba baVar, final be beVar, be beVar2) {
        long j = -1;
        if (this.hoR) {
            this.hoT = true;
            this.hoU = true;
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
            this.hoY = beVar2.aPJ.userId;
        }
        if (!this.hoR) {
            this.hoR = true;
            if (this.hoO != null) {
                this.hoO.Er();
            }
            cek();
            cel();
            this.hoV = false;
            this.hoW = false;
            if (this.hoN != null && this.hoM != null) {
                this.hoM.a(baVar, beVar, beVar2, true);
                this.hoM.setRivalUserViewBg(beVar2);
                this.hoM.setAnchorUserViewBg(beVar);
                if (this.hoO != null) {
                    this.hoO.a(baVar, beVar, beVar2);
                }
                if (this.hoN != null) {
                    this.hoN.a(this.mTbPageContext.getPageActivity(), this.hoM);
                }
                ceq();
                String str = null;
                if (beVar2 != null && beVar2.aPX != null) {
                    str = String.valueOf(beVar2.aPX.live_id);
                }
                if (TextUtils.isEmpty(str) || !ez(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hoM.nw(false);
                }
            }
        }
        if (this.hoS && this.hoM != null) {
            this.hoM.a(baVar, beVar, beVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(w wVar) {
        if (wVar != null && wVar.aJV != null) {
            this.hoX = wVar.aJV.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(be beVar) {
        if (this.hoO != null) {
            this.hoO.Et();
        }
        if (this.hoM != null) {
            this.hoM.setAnchorUserViewBg(beVar);
        }
        if (this.hoM != null) {
            this.hoM.cdY();
            this.hoM.cdX();
            this.hoN.b(this.mTbPageContext.getPageActivity(), this.hoM);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void En() {
        if (this.hoT) {
            if (this.hoO != null) {
                this.hoO.bs(true);
            }
            if (this.hoM != null) {
                this.hoM.cdW();
            }
            this.hoV = false;
            this.hoW = false;
            cep();
            this.mHandler.removeCallbacksAndMessages(null);
            cem();
            if (this.hpe != null) {
                this.hpe.release();
                this.hpe = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cep();
        this.hoN.a((a.InterfaceC0684a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hpe != null) {
            this.hpe.release();
            this.hpe = null;
        }
        if (this.hpf != null) {
            this.hpf.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hpi);
        MessageManager.getInstance().unRegisterListener(this.hpj);
        MessageManager.getInstance().unRegisterListener(this.hpk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cep() {
        MessageManager.getInstance().unRegisterListener(this.hpd);
        if (this.hpc != null) {
            this.hpc.release();
        }
        this.hoN.IW();
        if (this.hoM != null) {
            this.hoM.releaseResource();
        }
        if (this.hoP != null) {
            this.hoP.cdU();
        }
        this.hoT = false;
        this.hoR = false;
        this.hoS = false;
        this.hoY = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hoU = true;
            this.hoM.setCloseBtnVisible(false);
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
                    d.this.hoQ.EG();
                    return;
                }
                d.this.hoQ.EE();
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
        return this.hoT;
    }

    @Override // com.baidu.live.challenge.h
    public int bu(boolean z) {
        int o = com.baidu.live.utils.h.o(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hoM != null && this.hoM.getCloseBtnView() != null && this.hoM.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hoM.getCloseBtnView().getLayoutParams();
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
        if (this.hpc == null) {
            this.hpc = new com.baidu.live.follow.a.a();
        }
        this.hpc.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hoM != null) {
                    d.this.hoM.nw(z2);
                }
            }
        });
        this.hpc.av(str, str2);
        return true;
    }

    private void ceq() {
        if (this.hpd == null) {
            this.hpd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hoY > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hoY))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hoM != null) {
                                    d.this.hoM.nw(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hoM != null) {
                                d.this.hoM.nw(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpd);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hoU = true;
            this.hoM.setCloseBtnVisible(false);
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
        if (this.hoT && i == 3 && j == this.challengeId) {
            if (com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aNC == 1) {
                cer();
            }
        }
    }

    public void cer() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
