package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes4.dex */
public class a {
    private q avf;
    private com.baidu.tieba.ala.liveroom.operation.b gaQ;
    private GuardClubInfoHttpResponseMessage gbV;
    private com.baidu.live.liveroom.a.a gcZ;
    private b gob;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean aSU = false;
    private boolean aSI = false;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gob.getView()) {
                if (!a.this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.avf.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.avf.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.avf == null || a.this.avf.ayC == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.gcZ != null) {
                    a.this.gcZ.cI(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.avf.ayC;
                AlaRelationData alaRelationData = a.this.avf.ayE;
                AlaLocationData alaLocationData = a.this.avf.ayD;
                String str = null;
                if (a.this.avf != null && a.this.avf.mLiveInfo != null) {
                    str = a.this.avf.mLiveInfo.feed_id;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.avf.mLiveInfo.group_id), String.valueOf(a.this.avf.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.avf.ayC.userId), a.this.avf.mLiveInfo.appId, a.this.avf.ayC.userName, str, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.avf != null && a.this.avf.ayC != null) {
                    String valueOf = String.valueOf(a.this.avf.ayC.userId);
                    String str2 = a.this.avf.ayC.portrait;
                    d dVar = new d();
                    dVar.setUserId(valueOf);
                    dVar.setPortrait(str2);
                    dVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    dVar.setIsAttention(true);
                    dVar.setInLive("1");
                    dVar.setFrom("source_host_header");
                    com.baidu.live.view.a.KF().a(valueOf, dVar);
                    a.this.lI(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.avf.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.avf.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.avf.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.avf.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.avf.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.avf.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.avf.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.avf.mLiveInfo.feed_id + "");
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
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.a.2
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
    private CustomMessageListener fEm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.n.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.avf != null && a.this.avf.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.avf.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.aSU) {
                            a.this.lI(false);
                        } else {
                            a.this.bIL();
                        }
                        if (!com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.aSU = true;
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
                            if (com.baidu.live.liveroom.a.Fj().Fk()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.lI(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                    } else {
                        a.this.aSU = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bIL();
                    }
                }
            }
        }
    };
    private HttpMessageListener fNz = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.n.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.avf != null && a.this.avf.ayC != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aSF != null && guardClubInfoHttpResponseMessage.aSF.axs == a.this.avf.ayC.userId) {
                    a.this.gbV = guardClubInfoHttpResponseMessage;
                    a.this.aSI = guardClubInfoHttpResponseMessage.aSI;
                    if (a.this.aSI) {
                        a.this.lI(false);
                    }
                    if (a.this.gob != null) {
                        a.this.gob.lJ(a.this.aSI);
                    }
                }
            }
        }
    };
    CustomMessageListener gkE = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.n.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.avf != null && a.this.avf.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                c cVar = (c) customResponsedMessage.getData();
                if (a.this.avf.mLiveInfo.live_id == cVar.liveId) {
                    a.this.gob.dW(cVar.gkF);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gcZ = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fEm);
        MessageManager.getInstance().registerListener(this.fEy);
        MessageManager.getInstance().registerListener(this.gkE);
    }

    public void c(ViewGroup viewGroup, q qVar) {
        a(viewGroup, qVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, q qVar, int i) {
        if (viewGroup != null) {
            if (this.gob != null && this.gob.getView().getParent() != null) {
                ((ViewGroup) this.gob.getView().getParent()).removeView(this.gob.getView());
            }
            if (this.gob == null) {
                this.gob = new b(this.mTbPageContext.getPageActivity());
            }
            this.gob.setId(i);
            this.gob.m(this.eve);
            this.gob.getView().setOnClickListener(this.eve);
            this.gob.a(this.gaQ);
            this.gob.getView().setVisibility(0);
            aw(viewGroup);
            this.avf = qVar;
            if (this.avf != null) {
                this.gob.a(this.avf, this.isHost, Et());
                if (this.avf.ayE != null && this.avf.ayE.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        lI(true);
                        return;
                    } else {
                        bIL();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void aw(ViewGroup viewGroup) {
        if (this.gob.getView() == null || this.gob.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gob.lI(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gob.getView(), 0, layoutParams);
        }
    }

    public void v(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && this.gob != null) {
            this.avf = qVar;
            this.gob.a(qVar, this.isHost, Et());
            if (qVar.ayE != null) {
                this.aSU = qVar.ayE.getFollowStatus() != 0;
                if (this.aSU) {
                    this.gob.lI(false);
                }
            }
        }
    }

    public void bIK() {
        if (this.gob != null && this.gob.getView() != null) {
            this.gob.getView().setVisibility(4);
        }
    }

    public void rO(int i) {
        if (this.gob != null && this.gob.getView() != null) {
            this.gob.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIL() {
        if (this.gob != null && !this.aSI) {
            this.gob.bIL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (this.gob != null) {
            this.gob.lI(z);
        }
    }

    public String Et() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.gob != null) {
            this.gob.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fEm);
        MessageManager.getInstance().unRegisterListener(this.fEy);
        MessageManager.getInstance().unRegisterListener(this.gkE);
    }

    public boolean bEj() {
        return this.aSU;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gaQ = bVar;
        if (this.gob != null) {
            this.gob.a(bVar);
        }
    }
}
