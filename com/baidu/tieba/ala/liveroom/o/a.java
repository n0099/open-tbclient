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
    private r aAj;
    private b gAV;
    private com.baidu.tieba.ala.liveroom.operation.b gmW;
    private GuardClubInfoHttpResponseMessage goc;
    private com.baidu.live.liveroom.a.a gpl;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aYk = false;
    private boolean aXY = false;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gAV.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aAj.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aAj.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aAj == null || a.this.aAj.aDG == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.gpl != null) {
                    a.this.gpl.ey(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aAj.aDG;
                AlaRelationData alaRelationData = a.this.aAj.aDI;
                AlaLocationData alaLocationData = a.this.aAj.aDH;
                String str = null;
                if (a.this.aAj != null && a.this.aAj.mLiveInfo != null) {
                    str = a.this.aAj.mLiveInfo.feed_id;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aAj.mLiveInfo.group_id), String.valueOf(a.this.aAj.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aAj.aDG.userId), a.this.aAj.mLiveInfo.appId, a.this.aAj.aDG.userName, str, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aAj != null && a.this.aAj.aDG != null) {
                    String valueOf = String.valueOf(a.this.aAj.aDG.userId);
                    String str2 = a.this.aAj.aDG.portrait;
                    d dVar = new d();
                    dVar.setUserId(valueOf);
                    dVar.setPortrait(str2);
                    dVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_host_header");
                    com.baidu.live.view.a.Qx().a(valueOf, dVar);
                    a.this.mo(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aAj.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aAj.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aAj.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aAj.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aAj.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aAj.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aAj.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aAj.mLiveInfo.feed_id + "");
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
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
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
    private CustomMessageListener fPH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aAj != null && a.this.aAj.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aAj.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aYk) {
                            a.this.mo(false);
                        } else {
                            a.this.bSN();
                        }
                        if (!com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aYk = true;
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
                        a.this.mo(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aYk = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bSN();
                    }
                }
            }
        }
    };
    private HttpMessageListener fZB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.o.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAj != null && a.this.aAj.aDG != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXV != null && guardClubInfoHttpResponseMessage.aXV.aCw == a.this.aAj.aDG.userId) {
                    a.this.goc = guardClubInfoHttpResponseMessage;
                    a.this.aXY = guardClubInfoHttpResponseMessage.aXY;
                    if (a.this.aXY) {
                        a.this.mo(false);
                    }
                    if (a.this.gAV != null) {
                        a.this.gAV.mp(a.this.aXY);
                    }
                }
            }
        }
    };
    CustomMessageListener gwM = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.o.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aAj != null && a.this.aAj.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                if (a.this.aAj.mLiveInfo.live_id == cVar.liveId) {
                    a.this.gAV.eh(cVar.gwN);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gpl = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fPH);
        MessageManager.getInstance().registerListener(this.fPT);
        MessageManager.getInstance().registerListener(this.gwM);
    }

    public void c(ViewGroup viewGroup, r rVar) {
        a(viewGroup, rVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, r rVar, int i) {
        if (viewGroup != null) {
            if (this.gAV != null && this.gAV.getView().getParent() != null) {
                ((ViewGroup) this.gAV.getView().getParent()).removeView(this.gAV.getView());
            }
            if (this.gAV == null) {
                this.gAV = new b(this.mTbPageContext.getPageActivity());
            }
            this.gAV.setId(i);
            this.gAV.m(this.eFG);
            this.gAV.getView().setOnClickListener(this.eFG);
            this.gAV.a(this.gmW);
            this.gAV.getView().setVisibility(0);
            ax(viewGroup);
            this.aAj = rVar;
            if (this.aAj != null) {
                this.gAV.a(this.aAj, this.isHost, JY());
                if (this.aAj.aDI != null && this.aAj.aDI.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        mo(true);
                        return;
                    } else {
                        bSN();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void ax(ViewGroup viewGroup) {
        if (this.gAV.getView() == null || this.gAV.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gAV.mo(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gAV.getView(), 0, layoutParams);
        }
    }

    public void w(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && this.gAV != null) {
            this.aAj = rVar;
            this.gAV.a(rVar, this.isHost, JY());
            if (rVar.aDI != null) {
                this.aYk = rVar.aDI.getFollowStatus() != 0;
                if (this.aYk) {
                    this.gAV.mo(false);
                }
            }
        }
    }

    public void bSM() {
        if (this.gAV != null && this.gAV.getView() != null) {
            this.gAV.getView().setVisibility(4);
        }
    }

    public void ue(int i) {
        if (this.gAV != null && this.gAV.getView() != null) {
            this.gAV.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSN() {
        if (this.gAV != null && !this.aXY) {
            this.gAV.bSN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(boolean z) {
        if (this.gAV != null) {
            this.gAV.mo(z);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.gAV != null) {
            this.gAV.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fPH);
        MessageManager.getInstance().unRegisterListener(this.fPT);
        MessageManager.getInstance().unRegisterListener(this.gwM);
    }

    public boolean bNM() {
        return this.aYk;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gmW = bVar;
        if (this.gAV != null) {
            this.gAV.a(bVar);
        }
    }
}
