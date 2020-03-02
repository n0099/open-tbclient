package com.baidu.tieba.ala.liveroom.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
import com.baidu.live.data.m;
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
    private m ald;
    private com.baidu.tieba.ala.liveroom.operation.b eRv;
    private GuardClubInfoHttpResponseMessage eSw;
    private com.baidu.live.liveroom.a.a eTy;
    private b fcZ;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aqm = false;
    private boolean aqa = false;
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fcZ.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.ald.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.ald.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.ald == null || a.this.ald.XQ == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.eTy != null) {
                    a.this.eTy.cc(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.ald.XQ;
                AlaRelationData alaRelationData = a.this.ald.XS;
                AlaLocationData alaLocationData = a.this.ald.XR;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.ald.mLiveInfo.group_id), String.valueOf(a.this.ald.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.ald.XQ.userId), a.this.ald.mLiveInfo.appId, a.this.ald.XQ.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.ald != null && a.this.ald.XQ != null) {
                    String valueOf = String.valueOf(a.this.ald.XQ.userId);
                    String str = a.this.ald.XQ.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    com.baidu.live.view.a.Bj().a(valueOf, bVar);
                    a.this.jw(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.ald.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.ald.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.ald.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.ald.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.ald.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.ald.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.ald.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.ald.mLiveInfo.feed_id + "");
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
    CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.ald != null && a.this.ald.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.ald.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aqm) {
                            a.this.jw(false);
                        } else {
                            a.this.bmZ();
                        }
                        if (!com.baidu.live.view.a.Bj().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aqm = true;
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
                            if (com.baidu.live.liveroom.a.ym().yn()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.jw(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aqm = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bmZ();
                    }
                }
            }
        }
    };
    private HttpMessageListener eDS = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.ald != null && a.this.ald.XQ != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apX != null && guardClubInfoHttpResponseMessage.apX.WZ == a.this.ald.XQ.userId) {
                    a.this.eSw = guardClubInfoHttpResponseMessage;
                    a.this.aqa = guardClubInfoHttpResponseMessage.aqa;
                    if (a.this.aqa) {
                        a.this.jw(false);
                    }
                    if (a.this.fcZ != null) {
                        a.this.fcZ.jx(a.this.aqa);
                    }
                }
            }
        }
    };
    CustomMessageListener eZA = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ald != null && a.this.ald.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                if (a.this.ald.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fcZ.cW(dVar.eZB);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.eTy = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.evz);
        MessageManager.getInstance().registerListener(this.evL);
        MessageManager.getInstance().registerListener(this.eZA);
    }

    public void c(ViewGroup viewGroup, m mVar) {
        a(viewGroup, mVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, m mVar, int i) {
        if (viewGroup != null) {
            if (this.fcZ != null && this.fcZ.getView().getParent() != null) {
                ((ViewGroup) this.fcZ.getView().getParent()).removeView(this.fcZ.getView());
            }
            if (this.fcZ == null) {
                this.fcZ = new b(this.mTbPageContext.getPageActivity());
            }
            this.fcZ.setId(i);
            this.fcZ.m(this.dri);
            this.fcZ.getView().setOnClickListener(this.dri);
            this.fcZ.a(this.eRv);
            this.fcZ.getView().setVisibility(0);
            aj(viewGroup);
            this.ald = mVar;
            if (this.ald != null) {
                this.fcZ.a(this.ald, this.isHost, xx());
                if (this.ald.XS != null && this.ald.XS.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        jw(true);
                        return;
                    } else {
                        bmZ();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void aj(ViewGroup viewGroup) {
        if (this.fcZ.getView() == null || this.fcZ.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fcZ.jw(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fcZ.getView(), 0, layoutParams);
        }
    }

    public void u(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && this.fcZ != null) {
            this.ald = mVar;
            this.fcZ.a(mVar, this.isHost, xx());
            if (mVar.XS != null) {
                this.aqm = mVar.XS.getFollowStatus() != 0;
                if (this.aqm) {
                    this.fcZ.jw(false);
                }
            }
        }
    }

    public void bmY() {
        if (this.fcZ != null && this.fcZ.getView() != null) {
            this.fcZ.getView().setVisibility(4);
        }
    }

    public void qb(int i) {
        if (this.fcZ != null && this.fcZ.getView() != null) {
            this.fcZ.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmZ() {
        if (this.fcZ != null && !this.aqa) {
            this.fcZ.bmZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if (this.fcZ != null) {
            this.fcZ.jw(z);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fcZ != null) {
            this.fcZ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.evz);
        MessageManager.getInstance().unRegisterListener(this.evL);
        MessageManager.getInstance().unRegisterListener(this.eZA);
    }

    public boolean biR() {
        return this.aqm;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRv = bVar;
        if (this.fcZ != null) {
            this.fcZ.a(bVar);
        }
    }
}
