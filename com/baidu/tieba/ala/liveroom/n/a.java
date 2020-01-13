package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.data.l;
import com.baidu.live.r.a;
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
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
/* loaded from: classes2.dex */
public class a {
    private l aiW;
    private com.baidu.tieba.ala.liveroom.operation.b eNr;
    private GuardClubInfoHttpResponseMessage eOt;
    private com.baidu.tieba.ala.liveroom.b ePv;
    private b eZL;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean evd = false;
    private boolean eAt = false;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eZL.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aiW.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aiW.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aiW == null || a.this.aiW.Wf == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.ePv != null) {
                    a.this.ePv.pr(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aiW.Wf;
                AlaRelationData alaRelationData = a.this.aiW.Wh;
                AlaLocationData alaLocationData = a.this.aiW.Wg;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aiW.mLiveInfo.group_id), String.valueOf(a.this.aiW.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aiW.Wf.userId), a.this.aiW.mLiveInfo.appId, a.this.aiW.Wf.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aiW != null && a.this.aiW.Wf != null) {
                    String valueOf = String.valueOf(a.this.aiW.Wf.userId);
                    String str = a.this.aiW.Wf.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    com.baidu.live.view.a.yR().a(valueOf, bVar);
                    a.this.ju(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aiW.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aiW.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aiW.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aiW.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aiW.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aiW.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aiW.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aiW.mLiveInfo.feed_id + "");
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
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.a.2
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
    private CustomMessageListener ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.n.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aiW != null && a.this.aiW.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aiW.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.evd) {
                            a.this.ju(false);
                        } else {
                            a.this.blp();
                        }
                        if (!com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.evd = true;
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
                            if (com.baidu.live.liveroom.a.wl().wm()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.ju(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, "isAttentionOrGift"));
                    } else {
                        a.this.evd = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.blp();
                    }
                }
            }
        }
    };
    private HttpMessageListener ezQ = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.n.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aiW != null && a.this.aiW.Wf != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.ezN != null && guardClubInfoHttpResponseMessage.ezN.Vt == a.this.aiW.Wf.userId) {
                    a.this.eOt = guardClubInfoHttpResponseMessage;
                    a.this.eAt = guardClubInfoHttpResponseMessage.eAt;
                    if (a.this.eAt) {
                        a.this.ju(false);
                    }
                    if (a.this.eZL != null) {
                        a.this.eZL.jv(a.this.eAt);
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.tieba.ala.liveroom.b bVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.ePv = bVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.ern);
        MessageManager.getInstance().registerListener(this.erA);
    }

    public void d(ViewGroup viewGroup, l lVar) {
        a(viewGroup, lVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, l lVar, int i) {
        if (viewGroup != null) {
            if (this.eZL != null && this.eZL.getView().getParent() != null) {
                ((ViewGroup) this.eZL.getView().getParent()).removeView(this.eZL.getView());
            }
            if (this.eZL == null) {
                this.eZL = new b(this.mTbPageContext.getPageActivity());
            }
            this.eZL.setId(i);
            this.eZL.m(this.dmY);
            this.eZL.getView().setOnClickListener(this.dmY);
            this.eZL.a(this.eNr);
            this.eZL.getView().setVisibility(0);
            ai(viewGroup);
            this.aiW = lVar;
            if (this.aiW != null) {
                this.eZL.a(this.aiW, this.isHost, vz());
                if (this.aiW.Wh != null && this.aiW.Wh.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        ju(true);
                        return;
                    } else {
                        blp();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void ai(ViewGroup viewGroup) {
        if (this.eZL.getView() == null || this.eZL.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.eZL.ju(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.eZL.getView(), 0, layoutParams);
        }
    }

    public void p(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null && this.eZL != null) {
            this.aiW = lVar;
            this.eZL.a(lVar, this.isHost, vz());
            if (lVar.Wh != null) {
                this.evd = lVar.Wh.getFollowStatus() != 0;
                if (this.evd) {
                    this.eZL.ju(false);
                }
            }
        }
    }

    public void blo() {
        if (this.eZL != null && this.eZL.getView() != null) {
            this.eZL.getView().setVisibility(4);
        }
    }

    public void pT(int i) {
        if (this.eZL != null && this.eZL.getView() != null) {
            this.eZL.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blp() {
        if (this.eZL != null && !this.eAt) {
            this.eZL.blp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        if (this.eZL != null) {
            this.eZL.ju(z);
        }
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.eZL != null) {
            this.eZL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ern);
        MessageManager.getInstance().unRegisterListener(this.erA);
    }

    public boolean bgH() {
        return this.evd;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eNr = bVar;
        if (this.eZL != null) {
            this.eZL.a(bVar);
        }
    }
}
