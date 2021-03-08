package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.data.ab;
import com.baidu.live.data.f;
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
/* loaded from: classes10.dex */
public class a {
    private ab aED;
    private b hGS;
    private com.baidu.tieba.ala.liveroom.operation.b hsO;
    private com.baidu.live.liveroom.a.a hvE;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hGT = true;
    private boolean hGU = true;
    private int hui = a.C0201a.anim_fade_in_and_out;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hGS.getView()) {
                a.this.cgv();
            } else {
                a.this.cgu();
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.m.a.2
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
    private CustomMessageListener gPd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aED != null && a.this.aED.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aED.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.ov(false);
                        } else {
                            a.this.cgs();
                        }
                        if (!com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                            a.this.ov(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.cgx();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.ov(true);
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
                        a.this.cgs();
                    }
                }
            }
        }
    };
    private HttpMessageListener gZt = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.m.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aED != null && a.this.aED.aJD != null && guardClubInfoHttpResponseMessage.bky != null && guardClubInfoHttpResponseMessage.bky.anchorId == a.this.aED.aJD.userId && guardClubInfoHttpResponseMessage.bkD && a.this.hGS != null && guardClubInfoHttpResponseMessage.bkG != null) {
                    a.this.hGS.ow(true);
                    a.this.hGS.setLevel(guardClubInfoHttpResponseMessage.bkG.guardLevel);
                }
            }
        }
    };
    CustomMessageListener hCX = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.m.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aED != null && a.this.aED.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.f.c)) {
                com.baidu.tieba.ala.liveroom.f.c cVar = (com.baidu.tieba.ala.liveroom.f.c) customResponsedMessage.getData();
                if (a.this.aED.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hGS.fH(cVar.bqN);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.hvE = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gPd);
        MessageManager.getInstance().registerListener(this.gPp);
        MessageManager.getInstance().registerListener(this.gZt);
        MessageManager.getInstance().registerListener(this.hCX);
    }

    public void e(ViewGroup viewGroup, ab abVar) {
        a(viewGroup, abVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, ab abVar, int i) {
        if (viewGroup != null) {
            if (this.hGS != null && this.hGS.getView().getParent() != null) {
                ((ViewGroup) this.hGS.getView().getParent()).removeView(this.hGS.getView());
            }
            if (this.hGS == null) {
                this.hGS = new b(this.mTbPageContext.getPageActivity());
            }
            this.hGS.setId(i);
            this.hGS.o(this.onClickListener);
            this.hGS.getView().setOnClickListener(this.onClickListener);
            this.hGS.a(this.hsO);
            this.hGS.getView().setVisibility(0);
            cgy();
            aK(viewGroup);
            this.hGT = true;
            this.hGS.ow(false);
            this.aED = abVar;
            if (this.aED != null) {
                this.hGS.a(this.aED, this.isHost, Lr());
                if (this.aED.aJF != null && this.aED.aJF.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        ov(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cgt();
                        return;
                    } else {
                        cgs();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void ou(boolean z) {
        this.hGS.ou(z);
    }

    public void a(c cVar) {
        this.hGS.a(cVar);
    }

    private void aK(ViewGroup viewGroup) {
        if (this.hGS.getView() == null || this.hGS.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hGS.ov(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hGS.getView(), 0, layoutParams);
        }
    }

    public void N(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && this.hGS != null) {
            this.aED = abVar;
            this.hGS.a(abVar, this.isHost, Lr());
            if (abVar.aJF != null && this.hGT) {
                this.isFollowed = abVar.aJF.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hGS.ov(false);
                }
                this.hGT = false;
            }
        }
    }

    public void cgr() {
        if (this.hGS != null && this.hGS.getView() != null) {
            this.hGS.getView().setVisibility(4);
        }
    }

    public void vE(int i) {
        if (this.hGS != null && this.hGS.getView() != null) {
            this.hGS.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgs() {
        if (this.hGS != null) {
            this.hGS.cgs();
        }
    }

    private void cgt() {
        if (this.hGS != null) {
            this.hGS.cgt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(boolean z) {
        if (this.hGS != null) {
            this.hGS.ov(z);
        }
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgu() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aED != null && this.aED.aJD != null) {
            String valueOf = String.valueOf(this.aED.aJD.userId);
            String str = this.aED.aJD.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.Xr().a(valueOf, fVar);
            ov(this.hGU);
            this.hGU = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aED.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aED.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aED.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aED.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aED.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aED.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aED.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aED.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgv() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aED.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aED.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aED == null || this.aED.aJD == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.hvE != null) {
            this.hvE.dG(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aED.aJD;
        AlaRelationData alaRelationData = this.aED.aJF;
        AlaLocationData alaLocationData = this.aED.aJE;
        String str = null;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            str = this.aED.mLiveInfo.feed_id;
        }
        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aED.mLiveInfo.group_id), String.valueOf(this.aED.mLiveInfo.live_id), this.isHost, String.valueOf(this.aED.aJD.userId), this.aED.mLiveInfo.appId, this.aED.aJD.userName);
        alaPersonCardActivityConfig.setOtherParams(this.otherParams);
        alaPersonCardActivityConfig.setVid(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
    }

    public void cgw() {
        this.hGU = true;
        if (this.hGS != null) {
            this.hGS.cgw();
        }
    }

    public void onDestroy() {
        if (this.hGS != null) {
            this.hGS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gPd);
        MessageManager.getInstance().unRegisterListener(this.gPp);
        MessageManager.getInstance().unRegisterListener(this.gZt);
        MessageManager.getInstance().unRegisterListener(this.hCX);
    }

    public boolean caS() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hsO = bVar;
        if (this.hGS != null) {
            this.hGS.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgx() {
        if (this.aED != null && this.aED.mLiveInfo != null) {
            com.baidu.live.p.a.c(this.aED.mLiveInfo.live_id, 5);
        }
    }

    public void cgy() {
        if (this.hGS != null && this.hGS.cgL() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.hui);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hGS.cgL().setAnimation(loadAnimation);
        }
    }
}
