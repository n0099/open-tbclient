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
import com.baidu.live.c;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class a {
    private i aaB;
    private com.baidu.tieba.ala.liveroom.operation.b dXm;
    private com.baidu.tieba.ala.liveroom.b dYQ;
    private GuardClubInfoHttpResponseMessage dYe;
    private b ehR;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean dHB = false;
    private boolean dLJ = false;
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ehR.getView()) {
                if (!a.this.isHost) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aaB.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aaB.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aaB == null || a.this.aaB.Ps == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.dYQ != null) {
                    a.this.dYQ.na(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aaB.Ps;
                AlaRelationData alaRelationData = a.this.aaB.Pu;
                AlaLocationData alaLocationData = a.this.aaB.Pt;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aaB.mLiveInfo.group_id), String.valueOf(a.this.aaB.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aaB.Ps.userId), a.this.aaB.mLiveInfo.appId, a.this.aaB.Ps.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aaB != null && a.this.aaB.Ps != null) {
                    String valueOf = String.valueOf(a.this.aaB.Ps.userId);
                    String str = a.this.aaB.Ps.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    com.baidu.live.view.a.wx().a(valueOf, bVar);
                    a.this.hT(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aaB.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aaB.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aaB.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aaB.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aaB.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aaB.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aaB.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aaB.mLiveInfo.feed_id + "");
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
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aaB != null && a.this.aaB.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aaB.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.dHB) {
                            a.this.hT(false);
                        } else {
                            a.this.aSI();
                        }
                        if (!com.baidu.live.view.a.wx().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.dHB = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                if (com.baidu.live.liveroom.a.tY().tZ()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                                }
                            } else if (TbadkCoreApplication.getInst().isTieba()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (!c.np().getBoolean("sp_key_live_play_attention_guide_support", false) || c.np().getBoolean("ala_attention_guide_has_displayed" + TbadkCoreApplication.getCurrentAccount(), false)) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092));
                            }
                        }
                        a.this.hT(true);
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                    } else {
                        a.this.dHB = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.aSI();
                    }
                }
            }
        }
    };
    private HttpMessageListener dLg = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aaB != null && a.this.aaB.Ps != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.dLd != null && guardClubInfoHttpResponseMessage.dLd.OF == a.this.aaB.Ps.userId) {
                    a.this.dYe = guardClubInfoHttpResponseMessage;
                    a.this.dLJ = guardClubInfoHttpResponseMessage.dLJ;
                    if (a.this.dLJ) {
                        a.this.hT(false);
                    }
                    if (a.this.ehR != null) {
                        a.this.ehR.hU(a.this.dLJ);
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.tieba.ala.liveroom.b bVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.dYQ = bVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.dFe);
        MessageManager.getInstance().registerListener(this.dFq);
    }

    public void d(ViewGroup viewGroup, i iVar) {
        a(viewGroup, iVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, i iVar, int i) {
        if (viewGroup != null) {
            if (this.ehR != null && this.ehR.getView().getParent() != null) {
                ((ViewGroup) this.ehR.getView().getParent()).removeView(this.ehR.getView());
            }
            if (this.ehR == null) {
                this.ehR = new b(this.mTbPageContext.getPageActivity());
            }
            this.ehR.setId(i);
            this.ehR.m(this.czV);
            this.ehR.getView().setOnClickListener(this.czV);
            this.ehR.a(this.dXm);
            this.ehR.getView().setVisibility(0);
            af(viewGroup);
            this.aaB = iVar;
            if (this.aaB != null) {
                this.ehR.a(this.aaB, this.isHost, tm());
                if (this.aaB.Pu != null && this.aaB.Pu.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        hT(true);
                        return;
                    } else {
                        aSI();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void af(ViewGroup viewGroup) {
        if (this.ehR.getView() == null || this.ehR.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.ehR.hT(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.ehR.getView(), 0, layoutParams);
        }
    }

    public void l(i iVar) {
        if (iVar != null && iVar.mLiveInfo != null && this.ehR != null) {
            this.aaB = iVar;
            this.ehR.a(iVar, this.isHost, tm());
            if (iVar.Pu != null) {
                this.dHB = iVar.Pu.getFollowStatus() != 0;
                if (this.dHB) {
                    this.ehR.hT(false);
                }
            }
        }
    }

    public void aSH() {
        if (this.ehR != null && this.ehR.getView() != null) {
            this.ehR.getView().setVisibility(4);
        }
    }

    public void ny(int i) {
        if (this.ehR != null && this.ehR.getView() != null) {
            this.ehR.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSI() {
        if (this.ehR != null && !this.dLJ) {
            this.ehR.aSI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(boolean z) {
        if (this.ehR != null) {
            this.ehR.hT(z);
        }
    }

    public String tm() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.ehR != null) {
            this.ehR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.dFe);
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }

    public boolean aOL() {
        return this.dHB;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.dXm = bVar;
        if (this.ehR != null) {
            this.ehR.a(bVar);
        }
    }
}
