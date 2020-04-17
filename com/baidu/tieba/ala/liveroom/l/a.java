package com.baidu.tieba.ala.liveroom.l;

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
import com.baidu.live.data.n;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
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
import com.baidu.live.u.a;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tieba.ala.liveroom.e.d;
/* loaded from: classes3.dex */
public class a {
    private n aDE;
    private b fHU;
    private com.baidu.tieba.ala.liveroom.operation.b fwA;
    private GuardClubInfoHttpResponseMessage fxB;
    private com.baidu.live.liveroom.a.a fyD;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aJg = false;
    private boolean aIU = false;
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fHU.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aDE.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aDE.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aDE == null || a.this.aDE.aqe == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.fyD != null) {
                    a.this.fyD.cr(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aDE.aqe;
                AlaRelationData alaRelationData = a.this.aDE.aqg;
                AlaLocationData alaLocationData = a.this.aDE.aqf;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aDE.mLiveInfo.group_id), String.valueOf(a.this.aDE.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aDE.aqe.userId), a.this.aDE.mLiveInfo.appId, a.this.aDE.aqe.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aDE != null && a.this.aDE.aqe != null) {
                    String valueOf = String.valueOf(a.this.aDE.aqe.userId);
                    String str = a.this.aDE.aqe.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    bVar.setFrom("source_host_header");
                    com.baidu.live.view.a.Ht().a(valueOf, bVar);
                    a.this.kz(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aDE.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aDE.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aDE.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aDE.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aDE.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aDE.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aDE.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aDE.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem3.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                        alaStaticItem3.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem3);
                    }
                }
            } else {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aDE != null && a.this.aDE.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aDE.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aJg) {
                            a.this.kz(false);
                        } else {
                            a.this.bww();
                        }
                        if (!com.baidu.live.view.a.Ht().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aJg = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (TbadkCoreApplication.getInst().isTieba()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (updateAttentionMessage.getData().showPop) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092, Integer.valueOf(updateAttentionMessage.getData().autoOpenStatus)));
                            } else if (updateAttentionMessage.getData().autoOpenStatus == 1) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                            } else {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            }
                            if (com.baidu.live.liveroom.a.Dl().Dm()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.kz(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aJg = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bww();
                    }
                }
            }
        }
    };
    private HttpMessageListener fiW = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDE != null && a.this.aDE.aqe != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aIR != null && guardClubInfoHttpResponseMessage.aIR.apl == a.this.aDE.aqe.userId) {
                    a.this.fxB = guardClubInfoHttpResponseMessage;
                    a.this.aIU = guardClubInfoHttpResponseMessage.aIU;
                    if (a.this.aIU) {
                        a.this.kz(false);
                    }
                    if (a.this.fHU != null) {
                        a.this.fHU.kA(a.this.aIU);
                    }
                }
            }
        }
    };
    CustomMessageListener fEz = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aDE != null && a.this.aDE.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                if (a.this.aDE.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fHU.dE(dVar.fEA);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.fyD = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.eZZ);
        MessageManager.getInstance().registerListener(this.fal);
        MessageManager.getInstance().registerListener(this.fEz);
    }

    public void c(ViewGroup viewGroup, n nVar) {
        a(viewGroup, nVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, n nVar, int i) {
        if (viewGroup != null) {
            if (this.fHU != null && this.fHU.getView().getParent() != null) {
                ((ViewGroup) this.fHU.getView().getParent()).removeView(this.fHU.getView());
            }
            if (this.fHU == null) {
                this.fHU = new b(this.mTbPageContext.getPageActivity());
            }
            this.fHU.setId(i);
            this.fHU.m(this.dRF);
            this.fHU.getView().setOnClickListener(this.dRF);
            this.fHU.a(this.fwA);
            this.fHU.getView().setVisibility(0);
            al(viewGroup);
            this.aDE = nVar;
            if (this.aDE != null) {
                this.fHU.a(this.aDE, this.isHost, Cr());
                if (this.aDE.aqg != null && this.aDE.aqg.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        kz(true);
                        return;
                    } else {
                        bww();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void al(ViewGroup viewGroup) {
        if (this.fHU.getView() == null || this.fHU.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fHU.kz(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fHU.getView(), 0, layoutParams);
        }
    }

    public void t(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && this.fHU != null) {
            this.aDE = nVar;
            this.fHU.a(nVar, this.isHost, Cr());
            if (nVar.aqg != null) {
                this.aJg = nVar.aqg.getFollowStatus() != 0;
                if (this.aJg) {
                    this.fHU.kz(false);
                }
            }
        }
    }

    public void bwv() {
        if (this.fHU != null && this.fHU.getView() != null) {
            this.fHU.getView().setVisibility(4);
        }
    }

    public void qw(int i) {
        if (this.fHU != null && this.fHU.getView() != null) {
            this.fHU.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        if (this.fHU != null && !this.aIU) {
            this.fHU.bww();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(boolean z) {
        if (this.fHU != null) {
            this.fHU.kz(z);
        }
    }

    public String Cr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fHU != null) {
            this.fHU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eZZ);
        MessageManager.getInstance().unRegisterListener(this.fal);
        MessageManager.getInstance().unRegisterListener(this.fEz);
    }

    public boolean bsr() {
        return this.aJg;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fwA = bVar;
        if (this.fHU != null) {
            this.fHU.a(bVar);
        }
    }
}
