package com.baidu.tieba.ala.liveroom.o;

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
import com.baidu.live.data.d;
import com.baidu.live.data.r;
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
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes7.dex */
public class a {
    private r aAh;
    private b gAR;
    private com.baidu.tieba.ala.liveroom.operation.b gmS;
    private GuardClubInfoHttpResponseMessage gnY;
    private com.baidu.live.liveroom.a.a gph;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aYi = false;
    private boolean aXW = false;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gAR.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aAh.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aAh.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aAh == null || a.this.aAh.aDE == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.gph != null) {
                    a.this.gph.ey(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aAh.aDE;
                AlaRelationData alaRelationData = a.this.aAh.aDG;
                AlaLocationData alaLocationData = a.this.aAh.aDF;
                String str = null;
                if (a.this.aAh != null && a.this.aAh.mLiveInfo != null) {
                    str = a.this.aAh.mLiveInfo.feed_id;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aAh.mLiveInfo.group_id), String.valueOf(a.this.aAh.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aAh.aDE.userId), a.this.aAh.mLiveInfo.appId, a.this.aAh.aDE.userName, str, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aAh != null && a.this.aAh.aDE != null) {
                    String valueOf = String.valueOf(a.this.aAh.aDE.userId);
                    String str2 = a.this.aAh.aDE.portrait;
                    d dVar = new d();
                    dVar.setUserId(valueOf);
                    dVar.setPortrait(str2);
                    dVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_host_header");
                    com.baidu.live.view.a.Qx().a(valueOf, dVar);
                    a.this.mm(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aAh.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aAh.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aAh.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aAh.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aAh.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aAh.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aAh.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aAh.mLiveInfo.feed_id + "");
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
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
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
    private CustomMessageListener fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aAh != null && a.this.aAh.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aAh.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aYi) {
                            a.this.mm(false);
                        } else {
                            a.this.bSM();
                        }
                        if (!com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aYi = true;
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
                            if (com.baidu.live.liveroom.a.KQ().KR()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.mm(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aYi = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bSM();
                    }
                }
            }
        }
    };
    private HttpMessageListener fZx = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.o.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAh != null && a.this.aAh.aDE != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXT != null && guardClubInfoHttpResponseMessage.aXT.aCu == a.this.aAh.aDE.userId) {
                    a.this.gnY = guardClubInfoHttpResponseMessage;
                    a.this.aXW = guardClubInfoHttpResponseMessage.aXW;
                    if (a.this.aXW) {
                        a.this.mm(false);
                    }
                    if (a.this.gAR != null) {
                        a.this.gAR.mn(a.this.aXW);
                    }
                }
            }
        }
    };
    CustomMessageListener gwI = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.o.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aAh != null && a.this.aAh.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                if (a.this.aAh.mLiveInfo.live_id == cVar.liveId) {
                    a.this.gAR.eh(cVar.gwJ);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gph = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fPD);
        MessageManager.getInstance().registerListener(this.fPP);
        MessageManager.getInstance().registerListener(this.gwI);
    }

    public void c(ViewGroup viewGroup, r rVar) {
        a(viewGroup, rVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, r rVar, int i) {
        if (viewGroup != null) {
            if (this.gAR != null && this.gAR.getView().getParent() != null) {
                ((ViewGroup) this.gAR.getView().getParent()).removeView(this.gAR.getView());
            }
            if (this.gAR == null) {
                this.gAR = new b(this.mTbPageContext.getPageActivity());
            }
            this.gAR.setId(i);
            this.gAR.m(this.eFC);
            this.gAR.getView().setOnClickListener(this.eFC);
            this.gAR.a(this.gmS);
            this.gAR.getView().setVisibility(0);
            ax(viewGroup);
            this.aAh = rVar;
            if (this.aAh != null) {
                this.gAR.a(this.aAh, this.isHost, JY());
                if (this.aAh.aDG != null && this.aAh.aDG.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        mm(true);
                        return;
                    } else {
                        bSM();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void ax(ViewGroup viewGroup) {
        if (this.gAR.getView() == null || this.gAR.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gAR.mm(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gAR.getView(), 0, layoutParams);
        }
    }

    public void w(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && this.gAR != null) {
            this.aAh = rVar;
            this.gAR.a(rVar, this.isHost, JY());
            if (rVar.aDG != null) {
                this.aYi = rVar.aDG.getFollowStatus() != 0;
                if (this.aYi) {
                    this.gAR.mm(false);
                }
            }
        }
    }

    public void bSL() {
        if (this.gAR != null && this.gAR.getView() != null) {
            this.gAR.getView().setVisibility(4);
        }
    }

    public void ue(int i) {
        if (this.gAR != null && this.gAR.getView() != null) {
            this.gAR.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSM() {
        if (this.gAR != null && !this.aXW) {
            this.gAR.bSM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if (this.gAR != null) {
            this.gAR.mm(z);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.gAR != null) {
            this.gAR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fPD);
        MessageManager.getInstance().unRegisterListener(this.fPP);
        MessageManager.getInstance().unRegisterListener(this.gwI);
    }

    public boolean bNL() {
        return this.aYi;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gmS = bVar;
        if (this.gAR != null) {
            this.gAR.a(bVar);
        }
    }
}
