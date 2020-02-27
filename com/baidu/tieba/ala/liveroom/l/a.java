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
    private com.baidu.tieba.ala.liveroom.operation.b eRu;
    private GuardClubInfoHttpResponseMessage eSv;
    private com.baidu.live.liveroom.a.a eTx;
    private b fcY;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aqm = false;
    private boolean aqa = false;
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fcY.getView()) {
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
                if (a.this.eTx != null) {
                    a.this.eTx.cc(5);
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
                    com.baidu.live.view.a.Bh().a(valueOf, bVar);
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
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener evy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
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
                            a.this.bmX();
                        }
                        if (!com.baidu.live.view.a.Bh().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                        a.this.bmX();
                    }
                }
            }
        }
    };
    private HttpMessageListener eDR = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.ald != null && a.this.ald.XQ != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.apX != null && guardClubInfoHttpResponseMessage.apX.WZ == a.this.ald.XQ.userId) {
                    a.this.eSv = guardClubInfoHttpResponseMessage;
                    a.this.aqa = guardClubInfoHttpResponseMessage.aqa;
                    if (a.this.aqa) {
                        a.this.jw(false);
                    }
                    if (a.this.fcY != null) {
                        a.this.fcY.jx(a.this.aqa);
                    }
                }
            }
        }
    };
    CustomMessageListener eZz = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ald != null && a.this.ald.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                if (a.this.ald.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fcY.cW(dVar.eZA);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.eTx = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.evy);
        MessageManager.getInstance().registerListener(this.evK);
        MessageManager.getInstance().registerListener(this.eZz);
    }

    public void c(ViewGroup viewGroup, m mVar) {
        a(viewGroup, mVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, m mVar, int i) {
        if (viewGroup != null) {
            if (this.fcY != null && this.fcY.getView().getParent() != null) {
                ((ViewGroup) this.fcY.getView().getParent()).removeView(this.fcY.getView());
            }
            if (this.fcY == null) {
                this.fcY = new b(this.mTbPageContext.getPageActivity());
            }
            this.fcY.setId(i);
            this.fcY.m(this.drh);
            this.fcY.getView().setOnClickListener(this.drh);
            this.fcY.a(this.eRu);
            this.fcY.getView().setVisibility(0);
            aj(viewGroup);
            this.ald = mVar;
            if (this.ald != null) {
                this.fcY.a(this.ald, this.isHost, xx());
                if (this.ald.XS != null && this.ald.XS.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        jw(true);
                        return;
                    } else {
                        bmX();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void aj(ViewGroup viewGroup) {
        if (this.fcY.getView() == null || this.fcY.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fcY.jw(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fcY.getView(), 0, layoutParams);
        }
    }

    public void u(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && this.fcY != null) {
            this.ald = mVar;
            this.fcY.a(mVar, this.isHost, xx());
            if (mVar.XS != null) {
                this.aqm = mVar.XS.getFollowStatus() != 0;
                if (this.aqm) {
                    this.fcY.jw(false);
                }
            }
        }
    }

    public void bmW() {
        if (this.fcY != null && this.fcY.getView() != null) {
            this.fcY.getView().setVisibility(4);
        }
    }

    public void qb(int i) {
        if (this.fcY != null && this.fcY.getView() != null) {
            this.fcY.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmX() {
        if (this.fcY != null && !this.aqa) {
            this.fcY.bmX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if (this.fcY != null) {
            this.fcY.jw(z);
        }
    }

    public String xx() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fcY != null) {
            this.fcY.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.evy);
        MessageManager.getInstance().unRegisterListener(this.evK);
        MessageManager.getInstance().unRegisterListener(this.eZz);
    }

    public boolean biP() {
        return this.aqm;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eRu = bVar;
        if (this.fcY != null) {
            this.fcY.a(bVar);
        }
    }
}
