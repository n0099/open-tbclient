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
    private m ale;
    private com.baidu.tieba.ala.liveroom.operation.b eRI;
    private GuardClubInfoHttpResponseMessage eSJ;
    private com.baidu.live.liveroom.a.a eTL;
    private b fdm;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aqn = false;
    private boolean aqb = false;
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fdm.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.ale.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.ale.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.ale == null || a.this.ale.XQ == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.eTL != null) {
                    a.this.eTL.cc(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.ale.XQ;
                AlaRelationData alaRelationData = a.this.ale.XS;
                AlaLocationData alaLocationData = a.this.ale.XR;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.ale.mLiveInfo.group_id), String.valueOf(a.this.ale.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.ale.XQ.userId), a.this.ale.mLiveInfo.appId, a.this.ale.XQ.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.ale != null && a.this.ale.XQ != null) {
                    String valueOf = String.valueOf(a.this.ale.XQ.userId);
                    String str = a.this.ale.XQ.portrait;
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
                        if (a.this.ale.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.ale.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.ale.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.ale.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.ale.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.ale.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.ale.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.ale.mLiveInfo.feed_id + "");
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
    CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener evM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.ale != null && a.this.ale.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.ale.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aqn) {
                            a.this.jw(false);
                        } else {
                            a.this.bna();
                        }
                        if (!com.baidu.live.view.a.Bj().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aqn = true;
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
                        a.this.aqn = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bna();
                    }
                }
            }
        }
    };
    private HttpMessageListener eEf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.ale != null && a.this.ale.XQ != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apY != null && guardClubInfoHttpResponseMessage.apY.WZ == a.this.ale.XQ.userId) {
                    a.this.eSJ = guardClubInfoHttpResponseMessage;
                    a.this.aqb = guardClubInfoHttpResponseMessage.aqb;
                    if (a.this.aqb) {
                        a.this.jw(false);
                    }
                    if (a.this.fdm != null) {
                        a.this.fdm.jx(a.this.aqb);
                    }
                }
            }
        }
    };
    CustomMessageListener eZN = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ale != null && a.this.ale.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                if (a.this.ale.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fdm.cW(dVar.eZO);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.eTL = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.evM);
        MessageManager.getInstance().registerListener(this.evY);
        MessageManager.getInstance().registerListener(this.eZN);
    }

    public void c(ViewGroup viewGroup, m mVar) {
        a(viewGroup, mVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, m mVar, int i) {
        if (viewGroup != null) {
            if (this.fdm != null && this.fdm.getView().getParent() != null) {
                ((ViewGroup) this.fdm.getView().getParent()).removeView(this.fdm.getView());
            }
            if (this.fdm == null) {
                this.fdm = new b(this.mTbPageContext.getPageActivity());
            }
            this.fdm.setId(i);
            this.fdm.m(this.drw);
            this.fdm.getView().setOnClickListener(this.drw);
            this.fdm.a(this.eRI);
            this.fdm.getView().setVisibility(0);
            aj(viewGroup);
            this.ale = mVar;
            if (this.ale != null) {
                this.fdm.a(this.ale, this.isHost, xx());
                if (this.ale.XS != null && this.ale.XS.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        jw(true);
                        return;
                    } else {
                        bna();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void aj(ViewGroup viewGroup) {
        if (this.fdm.getView() == null || this.fdm.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fdm.jw(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fdm.getView(), 0, layoutParams);
        }
    }

    public void u(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && this.fdm != null) {
            this.ale = mVar;
            this.fdm.a(mVar, this.isHost, xx());
            if (mVar.XS != null) {
                this.aqn = mVar.XS.getFollowStatus() != 0;
                if (this.aqn) {
                    this.fdm.jw(false);
                }
            }
        }
    }

    public void bmZ() {
        if (this.fdm != null && this.fdm.getView() != null) {
            this.fdm.getView().setVisibility(4);
        }
    }

    public void qb(int i) {
        if (this.fdm != null && this.fdm.getView() != null) {
            this.fdm.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bna() {
        if (this.fdm != null && !this.aqb) {
            this.fdm.bna();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if (this.fdm != null) {
            this.fdm.jw(z);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fdm != null) {
            this.fdm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.evM);
        MessageManager.getInstance().unRegisterListener(this.evY);
        MessageManager.getInstance().unRegisterListener(this.eZN);
    }

    public boolean biS() {
        return this.aqn;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRI = bVar;
        if (this.fdm != null) {
            this.fdm.a(bVar);
        }
    }
}
