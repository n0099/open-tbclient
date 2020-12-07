package com.baidu.tieba.ala.liveroom.o;

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
    private w aFN;
    private com.baidu.tieba.ala.liveroom.operation.b hfu;
    private com.baidu.live.liveroom.a.a hie;
    private b htu;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean htv = true;
    private boolean htw = true;
    private int hgP = a.C0205a.anim_fade_in_and_out;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.htu.getView()) {
                a.this.cgr();
            } else {
                a.this.cgq();
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
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
    private CustomMessageListener gDs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aFN != null && a.this.aFN.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aFN.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.nP(false);
                        } else {
                            a.this.cgo();
                        }
                        if (!com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                            a.this.nP(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.cgt();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.nP(true);
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
                        a.this.cgo();
                    }
                }
            }
        }
    };
    private HttpMessageListener gND = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.o.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aFN != null && a.this.aFN.aJV != null && guardClubInfoHttpResponseMessage.bja != null && guardClubInfoHttpResponseMessage.bja.anchorId == a.this.aFN.aJV.userId && guardClubInfoHttpResponseMessage.bjf && a.this.htu != null && guardClubInfoHttpResponseMessage.bji != null) {
                    a.this.htu.nQ(true);
                    a.this.htu.setLevel(guardClubInfoHttpResponseMessage.bji.guardLevel);
                }
            }
        }
    };
    CustomMessageListener hpy = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.o.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aFN != null && a.this.aFN.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aFN.mLiveInfo.live_id == cVar.liveId) {
                    a.this.htu.fC(cVar.boX);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.hie = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gDs);
        MessageManager.getInstance().registerListener(this.gDE);
        MessageManager.getInstance().registerListener(this.gND);
        MessageManager.getInstance().registerListener(this.hpy);
    }

    public void e(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            if (this.htu != null && this.htu.getView().getParent() != null) {
                ((ViewGroup) this.htu.getView().getParent()).removeView(this.htu.getView());
            }
            if (this.htu == null) {
                this.htu = new b(this.mTbPageContext.getPageActivity());
            }
            this.htu.setId(i);
            this.htu.n(this.foP);
            this.htu.getView().setOnClickListener(this.foP);
            this.htu.a(this.hfu);
            this.htu.getView().setVisibility(0);
            cgu();
            ay(viewGroup);
            this.htv = true;
            this.htu.nQ(false);
            this.aFN = wVar;
            if (this.aFN != null) {
                this.htu.a(this.aFN, this.isHost, Oj());
                if (this.aFN.aJX != null && this.aFN.aJX.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        nP(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cgp();
                        return;
                    } else {
                        cgo();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void nO(boolean z) {
        this.htu.nO(z);
    }

    public void a(c cVar) {
        this.htu.a(cVar);
    }

    private void ay(ViewGroup viewGroup) {
        if (this.htu.getView() == null || this.htu.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.htu.nP(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.htu.getView(), 0, layoutParams);
        }
    }

    public void M(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.htu != null) {
            this.aFN = wVar;
            this.htu.a(wVar, this.isHost, Oj());
            if (wVar.aJX != null && this.htv) {
                this.isFollowed = wVar.aJX.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.htu.nP(false);
                }
                this.htv = false;
            }
        }
    }

    public void cgn() {
        if (this.htu != null && this.htu.getView() != null) {
            this.htu.getView().setVisibility(4);
        }
    }

    public void wM(int i) {
        if (this.htu != null && this.htu.getView() != null) {
            this.htu.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgo() {
        if (this.htu != null) {
            this.htu.cgo();
        }
    }

    private void cgp() {
        if (this.htu != null) {
            this.htu.cgp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        if (this.htu != null) {
            this.htu.nP(z);
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aFN != null && this.aFN.aJV != null) {
            String valueOf = String.valueOf(this.aFN.aJV.userId);
            String str = this.aFN.aJV.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.Yo().a(valueOf, fVar);
            nP(this.htw);
            this.htw = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aFN.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aFN.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aFN.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aFN.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aFN.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aFN.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aFN.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aFN.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgr() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aFN.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aFN.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aFN == null || this.aFN.aJV == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.hie != null) {
            this.hie.fh(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aFN.aJV;
        AlaRelationData alaRelationData = this.aFN.aJX;
        AlaLocationData alaLocationData = this.aFN.aJW;
        String str = null;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            str = this.aFN.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aFN.mLiveInfo.group_id), String.valueOf(this.aFN.mLiveInfo.live_id), this.isHost, String.valueOf(this.aFN.aJV.userId), this.aFN.mLiveInfo.appId, this.aFN.aJV.userName, str, this.otherParams)));
    }

    public void cgs() {
        this.htw = true;
        if (this.htu != null) {
            this.htu.cgs();
        }
    }

    public void onDestroy() {
        if (this.htu != null) {
            this.htu.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gDs);
        MessageManager.getInstance().unRegisterListener(this.gDE);
        MessageManager.getInstance().unRegisterListener(this.gND);
        MessageManager.getInstance().unRegisterListener(this.hpy);
    }

    public boolean caT() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hfu = bVar;
        if (this.htu != null) {
            this.htu.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgt() {
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            com.baidu.live.p.a.b(this.aFN.mLiveInfo.live_id, 5);
        }
    }

    public void cgu() {
        if (this.htu != null && this.htu.cgH() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.hgP);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.htu.cgH().setAnimation(loadAnimation);
        }
    }
}
