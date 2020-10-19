package com.baidu.tieba.ala.liveroom.p;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.e;
import com.baidu.live.data.u;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.searchbox.websocket.WebSocketRequest;
/* loaded from: classes4.dex */
public class a {
    private u aDU;
    private com.baidu.tieba.ala.liveroom.operation.b gEx;
    private com.baidu.live.liveroom.a.a gGU;
    private b gSG;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean gSH = true;
    private boolean gSI = true;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gSG.getView()) {
                a.this.bXG();
            } else {
                a.this.bXF();
            }
        }
    };
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };
    private CustomMessageListener gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aDU != null && a.this.aDU.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aDU.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.mU(false);
                        } else {
                            a.this.bXD();
                        }
                        if (!com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.isFollowed = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            } else if (TbadkCoreApplication.getInst().isTieba()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (updateAttentionMessage.getData().showPop) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092, Integer.valueOf(updateAttentionMessage.getData().autoOpenStatus)));
                                z = false;
                            } else if (updateAttentionMessage.getData().autoOpenStatus == 1) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                                z = false;
                            } else {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            }
                            a.this.mU(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.bXI();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.mU(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (!z) {
                        }
                    } else {
                        a.this.isFollowed = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bXD();
                    }
                }
            }
        }
    };
    private HttpMessageListener gpf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.p.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDU != null && a.this.aDU.aHD != null && guardClubInfoHttpResponseMessage.bdN != null && guardClubInfoHttpResponseMessage.bdN.anchorId == a.this.aDU.aHD.userId && guardClubInfoHttpResponseMessage.bdQ && a.this.gSG != null && guardClubInfoHttpResponseMessage.bdT != null) {
                    a.this.gSG.mV(true);
                    a.this.gSG.setLevel(guardClubInfoHttpResponseMessage.bdT.bdG);
                }
            }
        }
    };
    CustomMessageListener gOr = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aDU != null && a.this.aDU.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aDU.mLiveInfo.live_id == cVar.liveId) {
                    a.this.gSG.eA(cVar.gOs);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gGU = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gfl);
        MessageManager.getInstance().registerListener(this.gfx);
        MessageManager.getInstance().registerListener(this.gpf);
        MessageManager.getInstance().registerListener(this.gOr);
    }

    public void d(ViewGroup viewGroup, u uVar) {
        a(viewGroup, uVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, u uVar, int i) {
        if (viewGroup != null) {
            if (this.gSG != null && this.gSG.getView().getParent() != null) {
                ((ViewGroup) this.gSG.getView().getParent()).removeView(this.gSG.getView());
            }
            if (this.gSG == null) {
                this.gSG = new b(this.mTbPageContext.getPageActivity());
            }
            this.gSG.setId(i);
            this.gSG.m(this.eTU);
            this.gSG.getView().setOnClickListener(this.eTU);
            this.gSG.a(this.gEx);
            this.gSG.getView().setVisibility(0);
            aA(viewGroup);
            this.gSH = true;
            this.gSG.mV(false);
            this.aDU = uVar;
            if (this.aDU != null) {
                this.gSG.a(this.aDU, this.isHost, LI());
                if (this.aDU.aHF != null && this.aDU.aHF.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        mU(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        bXE();
                        return;
                    } else {
                        bXD();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void mT(boolean z) {
        this.gSG.mT(z);
    }

    public void a(c cVar) {
        this.gSG.a(cVar);
    }

    private void aA(ViewGroup viewGroup) {
        if (this.gSG.getView() == null || this.gSG.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gSG.mU(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gSG.getView(), 0, layoutParams);
        }
    }

    public void z(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && this.gSG != null) {
            this.aDU = uVar;
            this.gSG.a(uVar, this.isHost, LI());
            if (uVar.aHF != null && this.gSH) {
                this.isFollowed = uVar.aHF.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.gSG.mU(false);
                }
                this.gSH = false;
            }
        }
    }

    public void bXC() {
        if (this.gSG != null && this.gSG.getView() != null) {
            this.gSG.getView().setVisibility(4);
        }
    }

    public void vc(int i) {
        if (this.gSG != null && this.gSG.getView() != null) {
            this.gSG.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXD() {
        if (this.gSG != null) {
            this.gSG.bXD();
        }
    }

    private void bXE() {
        if (this.gSG != null) {
            this.gSG.bXE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        if (this.gSG != null) {
            this.gSG.mU(z);
        }
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXF() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
        } else if (this.aDU != null && this.aDU.aHD != null) {
            String valueOf = String.valueOf(this.aDU.aHD.userId);
            String str = this.aDU.aHD.portrait;
            e eVar = new e();
            eVar.setUserId(valueOf);
            eVar.setPortrait(str);
            eVar.setPageId(this.mTbPageContext.getUniqueId());
            eVar.setIsAttention(true);
            eVar.setInLive("1");
            eVar.setFrom("source_host_header");
            com.baidu.live.view.a.SY().a(valueOf, eVar);
            mU(this.gSI);
            this.gSI = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aDU.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aDU.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aDU.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aDU.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aDU.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aDU.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aDU.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aDU.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXG() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aDU.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aDU.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aDU == null || this.aDU.aHD == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
            return;
        }
        if (this.gGU != null) {
            this.gGU.eL(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aDU.aHD;
        AlaRelationData alaRelationData = this.aDU.aHF;
        AlaLocationData alaLocationData = this.aDU.aHE;
        String str = null;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            str = this.aDU.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aDU.mLiveInfo.group_id), String.valueOf(this.aDU.mLiveInfo.live_id), this.isHost, String.valueOf(this.aDU.aHD.userId), this.aDU.mLiveInfo.appId, this.aDU.aHD.userName, str, this.otherParams)));
    }

    public void bXH() {
        this.gSI = true;
        if (this.gSG != null) {
            this.gSG.bXH();
        }
    }

    public void onDestroy() {
        if (this.gSG != null) {
            this.gSG.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gfl);
        MessageManager.getInstance().unRegisterListener(this.gfx);
        MessageManager.getInstance().unRegisterListener(this.gpf);
        MessageManager.getInstance().unRegisterListener(this.gOr);
    }

    public boolean bSm() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gEx = bVar;
        if (this.gSG != null) {
            this.gSG.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXI() {
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            com.baidu.live.m.a.b(this.aDU.mLiveInfo.live_id, 5);
        }
    }
}
