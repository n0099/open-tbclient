package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class a {
    private q aLQ;
    private com.baidu.tieba.ala.liveroom.operation.b fVL;
    private GuardClubInfoHttpResponseMessage fWQ;
    private com.baidu.live.liveroom.a.a fXS;
    private b gjd;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aRB = false;
    private boolean aRp = false;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gjd.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aLQ.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aLQ.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aLQ == null || a.this.aLQ.axp == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.fXS != null) {
                    a.this.fXS.cG(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aLQ.axp;
                AlaRelationData alaRelationData = a.this.aLQ.axr;
                AlaLocationData alaLocationData = a.this.aLQ.axq;
                String str = null;
                if (a.this.aLQ != null && a.this.aLQ.mLiveInfo != null) {
                    str = a.this.aLQ.mLiveInfo.feed_id;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aLQ.mLiveInfo.group_id), String.valueOf(a.this.aLQ.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aLQ.axp.userId), a.this.aLQ.mLiveInfo.appId, a.this.aLQ.axp.userName, str, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aLQ != null && a.this.aLQ.axp != null) {
                    String valueOf = String.valueOf(a.this.aLQ.axp.userId);
                    String str2 = a.this.aLQ.axp.portrait;
                    d dVar = new d();
                    dVar.setUserId(valueOf);
                    dVar.setPortrait(str2);
                    dVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_host_header");
                    com.baidu.live.view.a.Ky().a(valueOf, dVar);
                    a.this.lf(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aLQ.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aLQ.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aLQ.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aLQ.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aLQ.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aLQ.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aLQ.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aLQ.mLiveInfo.feed_id + "");
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
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.m.a.2
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
    private CustomMessageListener fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aLQ != null && a.this.aLQ.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aLQ.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aRB) {
                            a.this.lf(false);
                        } else {
                            a.this.bFC();
                        }
                        if (!com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aRB = true;
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
                            if (com.baidu.live.liveroom.a.Fp().Fq()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.lf(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aRB = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bFC();
                    }
                }
            }
        }
    };
    private HttpMessageListener fIe = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.m.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aLQ != null && a.this.aLQ.axp != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aRm != null && guardClubInfoHttpResponseMessage.aRm.awn == a.this.aLQ.axp.userId) {
                    a.this.fWQ = guardClubInfoHttpResponseMessage;
                    a.this.aRp = guardClubInfoHttpResponseMessage.aRp;
                    if (a.this.aRp) {
                        a.this.lf(false);
                    }
                    if (a.this.gjd != null) {
                        a.this.gjd.lg(a.this.aRp);
                    }
                }
            }
        }
    };
    CustomMessageListener gfw = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.m.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aLQ != null && a.this.aLQ.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.f.d)) {
                com.baidu.tieba.ala.liveroom.f.d dVar = (com.baidu.tieba.ala.liveroom.f.d) customResponsedMessage.getData();
                if (a.this.aLQ.mLiveInfo.live_id == dVar.liveId) {
                    a.this.gjd.dI(dVar.gfx);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.fXS = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fzf);
        MessageManager.getInstance().registerListener(this.fzr);
        MessageManager.getInstance().registerListener(this.gfw);
    }

    public void c(ViewGroup viewGroup, q qVar) {
        a(viewGroup, qVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, q qVar, int i) {
        if (viewGroup != null) {
            if (this.gjd != null && this.gjd.getView().getParent() != null) {
                ((ViewGroup) this.gjd.getView().getParent()).removeView(this.gjd.getView());
            }
            if (this.gjd == null) {
                this.gjd = new b(this.mTbPageContext.getPageActivity());
            }
            this.gjd.setId(i);
            this.gjd.m(this.eoP);
            this.gjd.getView().setOnClickListener(this.eoP);
            this.gjd.a(this.fVL);
            this.gjd.getView().setVisibility(0);
            av(viewGroup);
            this.aLQ = qVar;
            if (this.aLQ != null) {
                this.gjd.a(this.aLQ, this.isHost, Ep());
                if (this.aLQ.axr != null && this.aLQ.axr.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        lf(true);
                        return;
                    } else {
                        bFC();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void av(ViewGroup viewGroup) {
        if (this.gjd.getView() == null || this.gjd.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gjd.lf(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gjd.getView(), 0, layoutParams);
        }
    }

    public void v(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && this.gjd != null) {
            this.aLQ = qVar;
            this.gjd.a(qVar, this.isHost, Ep());
            if (qVar.axr != null) {
                this.aRB = qVar.axr.getFollowStatus() != 0;
                if (this.aRB) {
                    this.gjd.lf(false);
                }
            }
        }
    }

    public void bFB() {
        if (this.gjd != null && this.gjd.getView() != null) {
            this.gjd.getView().setVisibility(4);
        }
    }

    public void ry(int i) {
        if (this.gjd != null && this.gjd.getView() != null) {
            this.gjd.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFC() {
        if (this.gjd != null && !this.aRp) {
            this.gjd.bFC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(boolean z) {
        if (this.gjd != null) {
            this.gjd.lf(z);
        }
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.gjd != null) {
            this.gjd.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fzf);
        MessageManager.getInstance().unRegisterListener(this.fzr);
        MessageManager.getInstance().unRegisterListener(this.gfw);
    }

    public boolean bAX() {
        return this.aRB;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fVL = bVar;
        if (this.gjd != null) {
            this.gjd.a(bVar);
        }
    }
}
