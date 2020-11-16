package com.baidu.tieba.ala.liveroom.p;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.baidu.live.data.f;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a {
    private w aDh;
    private com.baidu.tieba.ala.liveroom.operation.b gVX;
    private com.baidu.live.liveroom.a.a gYv;
    private b hjW;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hjX = true;
    private boolean hjY = true;
    private int gXm = a.C0195a.anim_fade_in_and_out;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hjW.getView()) {
                a.this.ccz();
            } else {
                a.this.ccy();
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.p.a.2
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
    private CustomMessageListener guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aDh != null && a.this.aDh.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aDh.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.nu(false);
                        } else {
                            a.this.ccw();
                        }
                        if (!com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.isFollowed = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                z = true;
                            } else if (TbadkCoreApplication.getInst().isTieba()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                z = true;
                            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                            } else if (updateAttentionMessage.getData().showPop) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092, Integer.valueOf(updateAttentionMessage.getData().autoOpenStatus)));
                                z = false;
                            } else if (updateAttentionMessage.getData().autoOpenStatus == 1) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                                z = false;
                            } else {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                z = true;
                            }
                            a.this.nu(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.ccB();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.nu(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (!z) {
                        }
                    } else {
                        a.this.isFollowed = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_unfollow_success_toast));
                        }
                        a.this.ccw();
                    }
                }
            }
        }
    };
    private HttpMessageListener gEF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.p.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDh != null && a.this.aDh.aHk != null && guardClubInfoHttpResponseMessage.beL != null && guardClubInfoHttpResponseMessage.beL.anchorId == a.this.aDh.aHk.userId && guardClubInfoHttpResponseMessage.beO && a.this.hjW != null && guardClubInfoHttpResponseMessage.beR != null) {
                    a.this.hjW.nv(true);
                    a.this.hjW.setLevel(guardClubInfoHttpResponseMessage.beR.beE);
                }
            }
        }
    };
    CustomMessageListener hfQ = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aDh != null && a.this.aDh.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aDh.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hjW.eY(cVar.hfR);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gYv = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.guJ);
        MessageManager.getInstance().registerListener(this.guV);
        MessageManager.getInstance().registerListener(this.gEF);
        MessageManager.getInstance().registerListener(this.hfQ);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            if (this.hjW != null && this.hjW.getView().getParent() != null) {
                ((ViewGroup) this.hjW.getView().getParent()).removeView(this.hjW.getView());
            }
            if (this.hjW == null) {
                this.hjW = new b(this.mTbPageContext.getPageActivity());
            }
            this.hjW.setId(i);
            this.hjW.n(this.fhp);
            this.hjW.getView().setOnClickListener(this.fhp);
            this.hjW.a(this.gVX);
            this.hjW.getView().setVisibility(0);
            ccC();
            ay(viewGroup);
            this.hjX = true;
            this.hjW.nv(false);
            this.aDh = wVar;
            if (this.aDh != null) {
                this.hjW.a(this.aDh, this.isHost, LU());
                if (this.aDh.aHm != null && this.aDh.aHm.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        nu(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        ccx();
                        return;
                    } else {
                        ccw();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void nt(boolean z) {
        this.hjW.nt(z);
    }

    public void a(c cVar) {
        this.hjW.a(cVar);
    }

    private void ay(ViewGroup viewGroup) {
        if (this.hjW.getView() == null || this.hjW.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hjW.nu(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hjW.getView(), 0, layoutParams);
        }
    }

    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.hjW != null) {
            this.aDh = wVar;
            this.hjW.a(wVar, this.isHost, LU());
            if (wVar.aHm != null && this.hjX) {
                this.isFollowed = wVar.aHm.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hjW.nu(false);
                }
                this.hjX = false;
            }
        }
    }

    public void ccv() {
        if (this.hjW != null && this.hjW.getView() != null) {
            this.hjW.getView().setVisibility(4);
        }
    }

    public void wh(int i) {
        if (this.hjW != null && this.hjW.getView() != null) {
            this.hjW.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccw() {
        if (this.hjW != null) {
            this.hjW.ccw();
        }
    }

    private void ccx() {
        if (this.hjW != null) {
            this.hjW.ccx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(boolean z) {
        if (this.hjW != null) {
            this.hjW.nu(z);
        }
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aDh != null && this.aDh.aHk != null) {
            String valueOf = String.valueOf(this.aDh.aHk.userId);
            String str = this.aDh.aHk.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.VO().a(valueOf, fVar);
            nu(this.hjY);
            this.hjY = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aDh.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aDh.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aDh.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aDh.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aDh.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aDh.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aDh.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aDh.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aDh.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aDh.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aDh == null || this.aDh.aHk == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.gYv != null) {
            this.gYv.eK(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aDh.aHk;
        AlaRelationData alaRelationData = this.aDh.aHm;
        AlaLocationData alaLocationData = this.aDh.aHl;
        String str = null;
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            str = this.aDh.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aDh.mLiveInfo.group_id), String.valueOf(this.aDh.mLiveInfo.live_id), this.isHost, String.valueOf(this.aDh.aHk.userId), this.aDh.mLiveInfo.appId, this.aDh.aHk.userName, str, this.otherParams)));
    }

    public void ccA() {
        this.hjY = true;
        if (this.hjW != null) {
            this.hjW.ccA();
        }
    }

    public void onDestroy() {
        if (this.hjW != null) {
            this.hjW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.guJ);
        MessageManager.getInstance().unRegisterListener(this.guV);
        MessageManager.getInstance().unRegisterListener(this.gEF);
        MessageManager.getInstance().unRegisterListener(this.hfQ);
    }

    public boolean bXc() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gVX = bVar;
        if (this.hjW != null) {
            this.hjW.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccB() {
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            com.baidu.live.n.a.b(this.aDh.mLiveInfo.live_id, 5);
        }
    }

    public void ccC() {
        if (this.hjW != null && this.hjW.ccP() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.gXm);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hjW.ccP().setAnimation(loadAnimation);
        }
    }
}
