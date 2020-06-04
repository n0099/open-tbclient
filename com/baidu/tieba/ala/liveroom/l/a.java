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
import com.baidu.live.data.d;
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class a {
    private q aJj;
    private com.baidu.tieba.ala.liveroom.operation.b fKN;
    private GuardClubInfoHttpResponseMessage fLQ;
    private com.baidu.live.liveroom.a.a fMU;
    private b fWg;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aOV = false;
    private boolean aOJ = false;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fWg.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aJj.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aJj.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aJj == null || a.this.aJj.avj == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.fMU != null) {
                    a.this.fMU.cA(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aJj.avj;
                AlaRelationData alaRelationData = a.this.aJj.avl;
                AlaLocationData alaLocationData = a.this.aJj.avk;
                String str = null;
                if (a.this.aJj != null && a.this.aJj.mLiveInfo != null) {
                    str = a.this.aJj.mLiveInfo.feed_id;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aJj.mLiveInfo.group_id), String.valueOf(a.this.aJj.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aJj.avj.userId), a.this.aJj.mLiveInfo.appId, a.this.aJj.avj.userName, str, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aJj != null && a.this.aJj.avj != null) {
                    String valueOf = String.valueOf(a.this.aJj.avj.userId);
                    String str2 = a.this.aJj.avj.portrait;
                    d dVar = new d();
                    dVar.setUserId(valueOf);
                    dVar.setPortrait(str2);
                    dVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_host_header");
                    com.baidu.live.view.a.Jl().a(valueOf, dVar);
                    a.this.kU(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aJj.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aJj.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aJj.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aJj.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aJj.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aJj.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aJj.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aJj.mLiveInfo.feed_id + "");
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
    CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener fnS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aJj != null && a.this.aJj.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aJj.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aOV) {
                            a.this.kU(false);
                        } else {
                            a.this.bCw();
                        }
                        if (!com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aOV = true;
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
                            if (com.baidu.live.liveroom.a.EI().EJ()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.kU(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aOV = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bCw();
                    }
                }
            }
        }
    };
    private HttpMessageListener fwT = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aJj != null && a.this.aJj.avj != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aOG != null && guardClubInfoHttpResponseMessage.aOG.aul == a.this.aJj.avj.userId) {
                    a.this.fLQ = guardClubInfoHttpResponseMessage;
                    a.this.aOJ = guardClubInfoHttpResponseMessage.aOJ;
                    if (a.this.aOJ) {
                        a.this.kU(false);
                    }
                    if (a.this.fWg != null) {
                        a.this.fWg.kV(a.this.aOJ);
                    }
                }
            }
        }
    };
    CustomMessageListener fSJ = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.l.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aJj != null && a.this.aJj.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.e.d)) {
                com.baidu.tieba.ala.liveroom.e.d dVar = (com.baidu.tieba.ala.liveroom.e.d) customResponsedMessage.getData();
                if (a.this.aJj.mLiveInfo.live_id == dVar.liveId) {
                    a.this.fWg.dF(dVar.fSK);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.fMU = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fnS);
        MessageManager.getInstance().registerListener(this.foe);
        MessageManager.getInstance().registerListener(this.fSJ);
    }

    public void c(ViewGroup viewGroup, q qVar) {
        a(viewGroup, qVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, q qVar, int i) {
        if (viewGroup != null) {
            if (this.fWg != null && this.fWg.getView().getParent() != null) {
                ((ViewGroup) this.fWg.getView().getParent()).removeView(this.fWg.getView());
            }
            if (this.fWg == null) {
                this.fWg = new b(this.mTbPageContext.getPageActivity());
            }
            this.fWg.setId(i);
            this.fWg.l(this.ege);
            this.fWg.getView().setOnClickListener(this.ege);
            this.fWg.a(this.fKN);
            this.fWg.getView().setVisibility(0);
            as(viewGroup);
            this.aJj = qVar;
            if (this.aJj != null) {
                this.fWg.a(this.aJj, this.isHost, DN());
                if (this.aJj.avl != null && this.aJj.avl.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        kU(true);
                        return;
                    } else {
                        bCw();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void as(ViewGroup viewGroup) {
        if (this.fWg.getView() == null || this.fWg.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.fWg.kU(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.fWg.getView(), 0, layoutParams);
        }
    }

    public void t(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && this.fWg != null) {
            this.aJj = qVar;
            this.fWg.a(qVar, this.isHost, DN());
            if (qVar.avl != null) {
                this.aOV = qVar.avl.getFollowStatus() != 0;
                if (this.aOV) {
                    this.fWg.kU(false);
                }
            }
        }
    }

    public void bCv() {
        if (this.fWg != null && this.fWg.getView() != null) {
            this.fWg.getView().setVisibility(4);
        }
    }

    public void qZ(int i) {
        if (this.fWg != null && this.fWg.getView() != null) {
            this.fWg.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCw() {
        if (this.fWg != null && !this.aOJ) {
            this.fWg.bCw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
        if (this.fWg != null) {
            this.fWg.kU(z);
        }
    }

    public String DN() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.fWg != null) {
            this.fWg.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fnS);
        MessageManager.getInstance().unRegisterListener(this.foe);
        MessageManager.getInstance().unRegisterListener(this.fSJ);
    }

    public boolean bym() {
        return this.aOV;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.fKN = bVar;
        if (this.fWg != null) {
            this.fWg.a(bVar);
        }
    }
}
