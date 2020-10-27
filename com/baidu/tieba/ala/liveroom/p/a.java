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
    private w aEc;
    private com.baidu.tieba.ala.liveroom.operation.b gQm;
    private com.baidu.live.liveroom.a.a gSJ;
    private b het;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean heu = true;
    private boolean hev = true;
    private int gRz = a.C0195a.anim_fade_in_and_out;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.het.getView()) {
                a.this.caF();
            } else {
                a.this.caE();
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.p.a.2
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
    private CustomMessageListener gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aEc != null && a.this.aEc.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aEc.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.nk(false);
                        } else {
                            a.this.caC();
                        }
                        if (!com.baidu.live.view.a.TX().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.isFollowed = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            } else if (TbadkCoreApplication.getInst().isTieba()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            } else if (updateAttentionMessage.getData().showPop) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913092, Integer.valueOf(updateAttentionMessage.getData().autoOpenStatus)));
                                z = false;
                            } else if (updateAttentionMessage.getData().autoOpenStatus == 1) {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                                z = false;
                            } else {
                                a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                z = true;
                            }
                            a.this.nk(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.caH();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.nk(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (!z) {
                        }
                    } else {
                        a.this.isFollowed = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.caC();
                    }
                }
            }
        }
    };
    private HttpMessageListener gzk = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.p.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aEc != null && a.this.aEc.aIe != null && guardClubInfoHttpResponseMessage.bfe != null && guardClubInfoHttpResponseMessage.bfe.anchorId == a.this.aEc.aIe.userId && guardClubInfoHttpResponseMessage.bfh && a.this.het != null && guardClubInfoHttpResponseMessage.bfk != null) {
                    a.this.het.nl(true);
                    a.this.het.setLevel(guardClubInfoHttpResponseMessage.bfk.beW);
                }
            }
        }
    };
    CustomMessageListener haf = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aEc != null && a.this.aEc.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aEc.mLiveInfo.live_id == cVar.liveId) {
                    a.this.het.eC(cVar.hag);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gSJ = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gpo);
        MessageManager.getInstance().registerListener(this.gpA);
        MessageManager.getInstance().registerListener(this.gzk);
        MessageManager.getInstance().registerListener(this.haf);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            if (this.het != null && this.het.getView().getParent() != null) {
                ((ViewGroup) this.het.getView().getParent()).removeView(this.het.getView());
            }
            if (this.het == null) {
                this.het = new b(this.mTbPageContext.getPageActivity());
            }
            this.het.setId(i);
            this.het.m(this.fcr);
            this.het.getView().setOnClickListener(this.fcr);
            this.het.a(this.gQm);
            this.het.getView().setVisibility(0);
            caI();
            aA(viewGroup);
            this.heu = true;
            this.het.nl(false);
            this.aEc = wVar;
            if (this.aEc != null) {
                this.het.a(this.aEc, this.isHost, Md());
                if (this.aEc.aIg != null && this.aEc.aIg.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        nk(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        caD();
                        return;
                    } else {
                        caC();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void nj(boolean z) {
        this.het.nj(z);
    }

    public void a(c cVar) {
        this.het.a(cVar);
    }

    private void aA(ViewGroup viewGroup) {
        if (this.het.getView() == null || this.het.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.het.nk(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.het.getView(), 0, layoutParams);
        }
    }

    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.het != null) {
            this.aEc = wVar;
            this.het.a(wVar, this.isHost, Md());
            if (wVar.aIg != null && this.heu) {
                this.isFollowed = wVar.aIg.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.het.nk(false);
                }
                this.heu = false;
            }
        }
    }

    public void caB() {
        if (this.het != null && this.het.getView() != null) {
            this.het.getView().setVisibility(4);
        }
    }

    public void vw(int i) {
        if (this.het != null && this.het.getView() != null) {
            this.het.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caC() {
        if (this.het != null) {
            this.het.caC();
        }
    }

    private void caD() {
        if (this.het != null) {
            this.het.caD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(boolean z) {
        if (this.het != null) {
            this.het.nk(z);
        }
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caE() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
        } else if (this.aEc != null && this.aEc.aIe != null) {
            String valueOf = String.valueOf(this.aEc.aIe.userId);
            String str = this.aEc.aIe.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.TX().a(valueOf, fVar);
            nk(this.hev);
            this.hev = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aEc.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aEc.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aEc.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aEc.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aEc.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aEc.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aEc.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aEc.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caF() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aEc.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aEc.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aEc == null || this.aEc.aIe == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
            return;
        }
        if (this.gSJ != null) {
            this.gSJ.eO(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aEc.aIe;
        AlaRelationData alaRelationData = this.aEc.aIg;
        AlaLocationData alaLocationData = this.aEc.aIf;
        String str = null;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            str = this.aEc.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aEc.mLiveInfo.group_id), String.valueOf(this.aEc.mLiveInfo.live_id), this.isHost, String.valueOf(this.aEc.aIe.userId), this.aEc.mLiveInfo.appId, this.aEc.aIe.userName, str, this.otherParams)));
    }

    public void caG() {
        this.hev = true;
        if (this.het != null) {
            this.het.caG();
        }
    }

    public void onDestroy() {
        if (this.het != null) {
            this.het.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gpo);
        MessageManager.getInstance().unRegisterListener(this.gpA);
        MessageManager.getInstance().unRegisterListener(this.gzk);
        MessageManager.getInstance().unRegisterListener(this.haf);
    }

    public boolean bVj() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gQm = bVar;
        if (this.het != null) {
            this.het.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caH() {
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            com.baidu.live.n.a.b(this.aEc.mLiveInfo.live_id, 5);
        }
    }

    public void caI() {
        if (this.het != null && this.het.caV() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.gRz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.het.caV().setAnimation(loadAnimation);
        }
    }
}
