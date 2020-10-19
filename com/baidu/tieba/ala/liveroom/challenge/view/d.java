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
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.bq;
import com.baidu.live.data.e;
import com.baidu.live.data.u;
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
    private AlaChallengeLiveView gND;
    private a gNE;
    private g gNF;
    private AlaChallengeCountDown gNG;
    private i gNH;
    private long gNP;
    private com.baidu.live.follow.a.b gNT;
    private CustomMessageListener gNU;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gNV;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gNI = false;
    private boolean gNJ = false;
    private boolean gNK = false;
    private boolean gNL = true;
    private boolean gNM = false;
    private boolean gNN = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long gNO = 0;
    private boolean isHost = false;
    private boolean gNQ = false;
    private boolean gNR = false;
    private boolean gNS = false;
    public boolean gMK = false;
    private Set<Long> gNW = new HashSet();
    private a.InterfaceC0641a gNX = new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0641a
        public void bVn() {
            if (d.this.gND != null && d.this.gND.getParent() != null) {
                d.this.gNJ = true;
                if (d.this.gNF != null) {
                    d.this.gNF.CS();
                }
                d.this.gND.setCloseBtnVisible(true);
                d.this.gND.setLiveContainerVisible(true);
                if (!d.this.gNW.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.gNW.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.gNR && !d.this.isHost) || (!d.this.gNQ && d.this.isHost)) {
                        if (d.this.gNG == null) {
                            d.this.gNG = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gNG.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gNG.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gNG.getParent() != null) {
                            ((ViewGroup) d.this.gNG.getParent()).removeView(d.this.gNG);
                        }
                        d.this.gND.getLiveContainerView().addView(d.this.gNG, layoutParams);
                        d.this.gNG.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gNM = true;
                }
                d.this.bVx();
                d.this.bVy();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0641a
        public void bVo() {
            if (d.this.gND != null && d.this.gND.getParent() != null) {
                d.this.gNK = false;
                if (d.this.gNF != null) {
                    d.this.gNF.bg(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gND.setLiveContainerVisible(false);
                bVp();
                bVq();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0641a
        public void bVp() {
            if (d.this.gND != null && d.this.gND.getParent() != null) {
                if (!d.this.gNK) {
                    d.this.bVw();
                    d.this.bVz();
                }
                d.this.gNM = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0641a
        public void bVq() {
            d.this.gNN = false;
        }
    };
    private AlaChallengeLiveView.a gNY = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bVl() {
            d.this.mD(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bq bqVar) {
            if (bqVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bqVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bqVar.aHU);
            } else {
                d.this.mD(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(ay ayVar) {
            if (ayVar != null && ayVar.aMN != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(ayVar.aMN.userId), ayVar.aMN.userName, ayVar.aMN.portrait, ayVar.aMN.sex, ayVar.aMN.levelId, null, null, 0L, ayVar.aMN.fansCount, ayVar.aMN.followCount, ayVar.aMN.userStatus, String.valueOf(ayVar.aNb.group_id), String.valueOf(ayVar.aNb.live_id), false, String.valueOf(ayVar.aMN.userId), ayVar.aMN.appId, ayVar.aMN.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(ay ayVar) {
            if (ayVar != null && ayVar.aMN != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    e eVar = new e();
                    eVar.setUserId(String.valueOf(ayVar.aMN.userId));
                    eVar.setPortrait(ayVar.aMN.portrait);
                    eVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    eVar.setIsAttention(true);
                    eVar.setInLive("1");
                    eVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.SY().a(String.valueOf(ayVar.aMN.userId), eVar);
                    if (d.this.gND != null) {
                        d.this.gND.mB(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(ay ayVar) {
            if (!d.this.isHost) {
                if (d.this.gNS) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gND);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.x.a.OS().blo.aLh || !TbadkCoreApplication.getInst().isMobileBaidu()) && ayVar != null && ayVar.aNb != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(ayVar.aNb.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bVm() {
            if (d.this.gMK && d.this.gNF != null) {
                d.this.gNF.bh(d.this.gMK);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void mC(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.b.c cVar = new com.baidu.live.b.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gNZ = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gNV != null) {
                    d.this.gNV.release();
                }
                d.this.gNV = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.gNH, getChallengeMvpToastInfoResponseMessage);
                d.this.gNV.Pd();
            }
        }
    };
    CustomMessageListener gOa = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gNH != null) {
                d.this.gNH.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener gOb = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gNP > 0 && d.this.gND != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gNP))) {
                    d.this.gND.mB(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gNE = new a(tbPageContext.getPageActivity());
        this.gNE.a(this.gNX);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gNE.bO(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gNZ);
        MessageManager.getInstance().registerListener(this.gOa);
        MessageManager.getInstance().registerListener(this.gOb);
    }

    @Override // com.baidu.live.challenge.h
    public void m(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gNR = z;
        this.isHost = z2;
        this.gNQ = z3;
    }

    private void bVu() {
        if (this.gND == null) {
            this.gND = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gND.setIsHost(this.isHost);
            this.gND.setViewClickCallBack(this.gNY);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.gMK = z;
        if (this.gND != null) {
            this.gND.setNeedCloseRecommendFloat(this.gMK);
        }
    }

    private void bVv() {
        int i = 0;
        if (this.gND != null && this.mParentView != null) {
            if (this.gND.getParent() != null) {
                ((ViewGroup) this.gND.getParent()).removeView(this.gND);
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
            if (this.gND.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gND, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gND, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVw() {
        if (this.gND != null && this.gND.getParent() != null) {
            ((ViewGroup) this.gND.getParent()).removeView(this.gND);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gNH = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gNF = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void CU() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gNJ);
        }
        this.gNN = true;
        bVy();
    }

    @Override // com.baidu.live.challenge.h
    public void dM(int i) {
        if (1 == i) {
            this.gNM = true;
            bVx();
        }
        if (2 == i) {
            this.gNN = true;
            bVy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVx() {
        if (this.gNJ && this.gNM) {
            this.gNE.k(this.gND);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVy() {
        if (this.gNJ && this.gNN) {
            this.gNE.j(this.gND);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(au auVar, ay ayVar, ay ayVar2) {
        this.gNK = true;
        this.gNL = false;
        f(auVar, ayVar, ayVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(au auVar, ay ayVar, ay ayVar2) {
        this.gNK = true;
        this.gNL = true;
        f(auVar, ayVar, ayVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(au auVar, final ay ayVar, ay ayVar2) {
        long j = -1;
        if (this.gNI) {
            this.gNK = true;
            this.gNL = true;
            if (auVar.aMQ == 2) {
                f(auVar, ayVar, ayVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(ayVar);
                    }
                }, 5000L);
                return;
            }
            g(ayVar);
            return;
        }
        long j2 = auVar != null ? auVar.challengeId : -1L;
        if (ayVar != null && ayVar.aNb != null) {
            j = ayVar.aNb.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(au auVar, ay ayVar, ay ayVar2) {
    }

    private void f(au auVar, ay ayVar, ay ayVar2) {
        if (auVar != null) {
            this.challengeId = auVar.challengeId;
        }
        if (ayVar != null) {
            if (ayVar.aMN != null) {
                this.anchorId = ayVar.aMN.userId;
            }
            if (ayVar.aNb != null) {
                this.liveId = ayVar.aNb.live_id;
            }
        }
        if (ayVar2 != null && ayVar2.aMN != null) {
            this.gNP = ayVar2.aMN.userId;
        }
        if (!this.gNI) {
            this.gNI = true;
            if (this.gNF != null) {
                this.gNF.CR();
            }
            bVu();
            bVv();
            this.gNM = false;
            this.gNN = false;
            if (this.gNE != null && this.gND != null) {
                this.gND.a(auVar, ayVar, ayVar2, true);
                this.gND.setRivalUserViewBg(ayVar2);
                this.gND.setAnchorUserViewBg(ayVar);
                if (this.gNF != null) {
                    this.gNF.a(auVar, ayVar, ayVar2);
                }
                if (this.gNE != null) {
                    this.gNE.a(this.mTbPageContext.getPageActivity(), this.gND);
                }
                bVA();
                String str = null;
                if (ayVar2 != null && ayVar2.aNb != null) {
                    str = String.valueOf(ayVar2.aNb.live_id);
                }
                if (TextUtils.isEmpty(str) || !em(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gND.mB(false);
                }
            }
        }
        if (this.gNJ && this.gND != null) {
            this.gND.a(auVar, ayVar, ayVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(u uVar) {
        if (uVar != null && uVar.aHD != null) {
            this.gNO = uVar.aHD.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ay ayVar) {
        if (this.gNF != null) {
            this.gNF.CT();
        }
        if (this.gND != null) {
            this.gND.setAnchorUserViewBg(ayVar);
        }
        if (this.gND != null) {
            this.gND.bVi();
            this.gND.bVh();
            this.gNE.b(this.mTbPageContext.getPageActivity(), this.gND);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void CN() {
        if (this.gNK) {
            if (this.gNF != null) {
                this.gNF.bg(true);
            }
            if (this.gND != null) {
                this.gND.bVg();
            }
            this.gNM = false;
            this.gNN = false;
            bVz();
            this.mHandler.removeCallbacksAndMessages(null);
            bVw();
            if (this.gNV != null) {
                this.gNV.release();
                this.gNV = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bVz();
        this.gNE.a((a.InterfaceC0641a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gNV != null) {
            this.gNV.release();
            this.gNV = null;
        }
        if (this.gNW != null) {
            this.gNW.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.gNZ);
        MessageManager.getInstance().unRegisterListener(this.gOa);
        MessageManager.getInstance().unRegisterListener(this.gOb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVz() {
        MessageManager.getInstance().unRegisterListener(this.gNU);
        if (this.gNT != null) {
            this.gNT.release();
        }
        this.gNE.GS();
        if (this.gND != null) {
            this.gND.releaseResource();
        }
        if (this.gNG != null) {
            this.gNG.bVe();
        }
        this.gNK = false;
        this.gNI = false;
        this.gNJ = false;
        this.gNP = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.gNL = true;
            this.gND.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(final boolean z) {
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
                    d.this.gNH.Df();
                    return;
                }
                d.this.gNH.Dd();
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
        return this.gNK;
    }

    @Override // com.baidu.live.challenge.h
    public int bi(boolean z) {
        int j = com.baidu.live.utils.h.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.gND != null && this.gND.getCloseBtnView() != null && this.gND.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.gND.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean em(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gNT == null) {
            this.gNT = new com.baidu.live.follow.a.a();
        }
        this.gNT.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gND != null) {
                    d.this.gND.mB(z2);
                }
            }
        });
        this.gNT.ap(str, str2);
        return true;
    }

    private void bVA() {
        if (this.gNU == null) {
            this.gNU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gNP > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gNP))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gND != null) {
                                    d.this.gND.mB(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gND != null) {
                                d.this.gND.mB(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gNU);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gNL = true;
            this.gND.setCloseBtnVisible(false);
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
        if (this.gNK && i == 3 && j == this.challengeId) {
            if (com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aKQ == 1) {
                bVB();
            }
        }
    }

    public void bVB() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
