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
    private m alp;
    private com.baidu.tieba.ala.liveroom.operation.b eSg;
    private GuardClubInfoHttpResponseMessage eTh;
    private com.baidu.live.liveroom.a.a eUj;
    private b fdK;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aqx = false;
    private boolean aql = false;
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fdK.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.alp.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.alp.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.alp == null || a.this.alp.Ya == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.eUj != null) {
                    a.this.eUj.cc(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.alp.Ya;
                AlaRelationData alaRelationData = a.this.alp.Yc;
                AlaLocationData alaLocationData = a.this.alp.Yb;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.alp.mLiveInfo.group_id), String.valueOf(a.this.alp.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.alp.Ya.userId), a.this.alp.mLiveInfo.appId, a.this.alp.Ya.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.alp != null && a.this.alp.Ya != null) {
                    String valueOf = String.valueOf(a.this.alp.Ya.userId);
                    String str = a.this.alp.Ya.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    com.baidu.live.view.a.Bq().a(valueOf, bVar);
                    a.this.jy(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.alp.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.alp.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.alp.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.alp.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.alp.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.alp.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.alp.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.alp.mLiveInfo.feed_id + "");
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
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener ewi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.alp != null && a.this.alp.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.alp.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aqx) {
                            a.this.jy(false);
                        } else {
                            a.this.bnf();
                        }
                        if (!com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aqx = true;
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
                            if (com.baidu.live.liveroom.a.yr().ys()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.jy(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aqx = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bnf();
                    }
                }
            }
        }
    };
    private HttpMessageListener eEB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.alp != null && a.this.alp.Ya != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aqi != null && guardClubInfoHttpResponseMessage.aqi.Xj == a.this.alp.Ya.userId) {
                    a.this.eTh = guardClubInfoHttpResponseMessage;
                    a.this.aql = guardClubInfoHttpResponseMessage.aql;
                    if (a.this.aql) {
                        a.this.jy(false);
                    }
                    if (a.this.fdK != null) {
                        a.this.fdK.jz(a.this.aql);
                    }
                }
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.alp != null && a.this.alp.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d)) {
                d dVar = (d) customResponsedMessage.getData();
                if (a.this.alp.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fdK.cW(dVar.fam);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.eUj = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.ewi);
        MessageManager.getInstance().registerListener(this.ewu);
        MessageManager.getInstance().registerListener(this.fal);
    }

    public void c(ViewGroup viewGroup, m mVar) {
        a(viewGroup, mVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, m mVar, int i) {
        if (viewGroup != null) {
            if (this.fdK != null && this.fdK.getView().getParent() != null) {
                ((ViewGroup) this.fdK.getView().getParent()).removeView(this.fdK.getView());
            }
            if (this.fdK == null) {
                this.fdK = new b(this.mTbPageContext.getPageActivity());
            }
            this.fdK.setId(i);
            this.fdK.m(this.drJ);
            this.fdK.getView().setOnClickListener(this.drJ);
            this.fdK.a(this.eSg);
            this.fdK.getView().setVisibility(0);
            ak(viewGroup);
            this.alp = mVar;
            if (this.alp != null) {
                this.fdK.a(this.alp, this.isHost, xC());
                if (this.alp.Yc != null && this.alp.Yc.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        jy(true);
                        return;
                    } else {
                        bnf();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void ak(ViewGroup viewGroup) {
        if (this.fdK.getView() == null || this.fdK.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fdK.jy(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fdK.getView(), 0, layoutParams);
        }
    }

    public void u(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && this.fdK != null) {
            this.alp = mVar;
            this.fdK.a(mVar, this.isHost, xC());
            if (mVar.Yc != null) {
                this.aqx = mVar.Yc.getFollowStatus() != 0;
                if (this.aqx) {
                    this.fdK.jy(false);
                }
            }
        }
    }

    public void bne() {
        if (this.fdK != null && this.fdK.getView() != null) {
            this.fdK.getView().setVisibility(4);
        }
    }

    public void qd(int i) {
        if (this.fdK != null && this.fdK.getView() != null) {
            this.fdK.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnf() {
        if (this.fdK != null && !this.aql) {
            this.fdK.bnf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(boolean z) {
        if (this.fdK != null) {
            this.fdK.jy(z);
        }
    }

    public String xC() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fdK != null) {
            this.fdK.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ewi);
        MessageManager.getInstance().unRegisterListener(this.ewu);
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    public boolean biX() {
        return this.aqx;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eSg = bVar;
        if (this.fdK != null) {
            this.fdK.a(bVar);
        }
    }
}
