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
/* loaded from: classes11.dex */
public class a {
    private ab aDd;
    private b hFj;
    private com.baidu.tieba.ala.liveroom.operation.b hrf;
    private com.baidu.live.liveroom.a.a htV;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hFk = true;
    private boolean hFl = true;
    private int hsz = a.C0195a.anim_fade_in_and_out;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hFj.getView()) {
                a.this.cgp();
            } else {
                a.this.cgo();
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.m.a.2
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
    private CustomMessageListener gNu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aDd != null && a.this.aDd.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aDd.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.ov(false);
                        } else {
                            a.this.cgm();
                        }
                        if (!com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                                a.this.cgr();
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
                        a.this.cgm();
                    }
                }
            }
        }
    };
    private HttpMessageListener gXK = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.m.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDd != null && a.this.aDd.aId != null && guardClubInfoHttpResponseMessage.biY != null && guardClubInfoHttpResponseMessage.biY.anchorId == a.this.aDd.aId.userId && guardClubInfoHttpResponseMessage.bjd && a.this.hFj != null && guardClubInfoHttpResponseMessage.bjg != null) {
                    a.this.hFj.ow(true);
                    a.this.hFj.setLevel(guardClubInfoHttpResponseMessage.bjg.guardLevel);
                }
            }
        }
    };
    CustomMessageListener hBo = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.m.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aDd != null && a.this.aDd.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.f.c)) {
                com.baidu.tieba.ala.liveroom.f.c cVar = (com.baidu.tieba.ala.liveroom.f.c) customResponsedMessage.getData();
                if (a.this.aDd.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hFj.fH(cVar.bpn);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.htV = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gNu);
        MessageManager.getInstance().registerListener(this.gNG);
        MessageManager.getInstance().registerListener(this.gXK);
        MessageManager.getInstance().registerListener(this.hBo);
    }

    public void e(ViewGroup viewGroup, ab abVar) {
        a(viewGroup, abVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, ab abVar, int i) {
        if (viewGroup != null) {
            if (this.hFj != null && this.hFj.getView().getParent() != null) {
                ((ViewGroup) this.hFj.getView().getParent()).removeView(this.hFj.getView());
            }
            if (this.hFj == null) {
                this.hFj = new b(this.mTbPageContext.getPageActivity());
            }
            this.hFj.setId(i);
            this.hFj.o(this.onClickListener);
            this.hFj.getView().setOnClickListener(this.onClickListener);
            this.hFj.a(this.hrf);
            this.hFj.getView().setVisibility(0);
            cgs();
            aK(viewGroup);
            this.hFk = true;
            this.hFj.ow(false);
            this.aDd = abVar;
            if (this.aDd != null) {
                this.hFj.a(this.aDd, this.isHost, Lo());
                if (this.aDd.aIf != null && this.aDd.aIf.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        ov(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cgn();
                        return;
                    } else {
                        cgm();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void ou(boolean z) {
        this.hFj.ou(z);
    }

    public void a(c cVar) {
        this.hFj.a(cVar);
    }

    private void aK(ViewGroup viewGroup) {
        if (this.hFj.getView() == null || this.hFj.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hFj.ov(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hFj.getView(), 0, layoutParams);
        }
    }

    public void N(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && this.hFj != null) {
            this.aDd = abVar;
            this.hFj.a(abVar, this.isHost, Lo());
            if (abVar.aIf != null && this.hFk) {
                this.isFollowed = abVar.aIf.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hFj.ov(false);
                }
                this.hFk = false;
            }
        }
    }

    public void cgl() {
        if (this.hFj != null && this.hFj.getView() != null) {
            this.hFj.getView().setVisibility(4);
        }
    }

    public void vC(int i) {
        if (this.hFj != null && this.hFj.getView() != null) {
            this.hFj.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (this.hFj != null) {
            this.hFj.cgm();
        }
    }

    private void cgn() {
        if (this.hFj != null) {
            this.hFj.cgn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(boolean z) {
        if (this.hFj != null) {
            this.hFj.ov(z);
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgo() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aDd != null && this.aDd.aId != null) {
            String valueOf = String.valueOf(this.aDd.aId.userId);
            String str = this.aDd.aId.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.Xo().a(valueOf, fVar);
            ov(this.hFl);
            this.hFl = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aDd.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aDd.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aDd.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aDd.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aDd.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aDd.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aDd.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aDd.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgp() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aDd.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aDd.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aDd == null || this.aDd.aId == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.htV != null) {
            this.htV.dF(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aDd.aId;
        AlaRelationData alaRelationData = this.aDd.aIf;
        AlaLocationData alaLocationData = this.aDd.aIe;
        String str = null;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            str = this.aDd.mLiveInfo.feed_id;
        }
        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aDd.mLiveInfo.group_id), String.valueOf(this.aDd.mLiveInfo.live_id), this.isHost, String.valueOf(this.aDd.aId.userId), this.aDd.mLiveInfo.appId, this.aDd.aId.userName);
        alaPersonCardActivityConfig.setOtherParams(this.otherParams);
        alaPersonCardActivityConfig.setVid(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
    }

    public void cgq() {
        this.hFl = true;
        if (this.hFj != null) {
            this.hFj.cgq();
        }
    }

    public void onDestroy() {
        if (this.hFj != null) {
            this.hFj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gNu);
        MessageManager.getInstance().unRegisterListener(this.gNG);
        MessageManager.getInstance().unRegisterListener(this.gXK);
        MessageManager.getInstance().unRegisterListener(this.hBo);
    }

    public boolean caM() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hrf = bVar;
        if (this.hFj != null) {
            this.hFj.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgr() {
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            com.baidu.live.p.a.c(this.aDd.mLiveInfo.live_id, 5);
        }
    }

    public void cgs() {
        if (this.hFj != null && this.hFj.cgF() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.hsz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hFj.cgF().setAnimation(loadAnimation);
        }
    }
}
