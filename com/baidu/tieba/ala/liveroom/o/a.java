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
import com.baidu.live.data.x;
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
    private x aBr;
    private b hAL;
    private com.baidu.tieba.ala.liveroom.operation.b hmE;
    private com.baidu.live.liveroom.a.a hpw;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hAM = true;
    private boolean hAN = true;
    private int hoa = a.C0194a.anim_fade_in_and_out;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hAL.getView()) {
                a.this.cfp();
            } else {
                a.this.cfo();
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
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
    private CustomMessageListener gKA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aBr != null && a.this.aBr.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aBr.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.ol(false);
                        } else {
                            a.this.cfm();
                        }
                        if (!com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                            a.this.ol(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.cfr();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.ol(true);
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
                        a.this.cfm();
                    }
                }
            }
        }
    };
    private HttpMessageListener gUM = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.o.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aBr != null && a.this.aBr.aFH != null && guardClubInfoHttpResponseMessage.bfP != null && guardClubInfoHttpResponseMessage.bfP.anchorId == a.this.aBr.aFH.userId && guardClubInfoHttpResponseMessage.bfU && a.this.hAL != null && guardClubInfoHttpResponseMessage.bfX != null) {
                    a.this.hAL.om(true);
                    a.this.hAL.setLevel(guardClubInfoHttpResponseMessage.bfX.guardLevel);
                }
            }
        }
    };
    CustomMessageListener hwQ = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.o.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aBr != null && a.this.aBr.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aBr.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hAL.fC(cVar.blS);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.hpw = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gKA);
        MessageManager.getInstance().registerListener(this.gKM);
        MessageManager.getInstance().registerListener(this.gUM);
        MessageManager.getInstance().registerListener(this.hwQ);
    }

    public void e(ViewGroup viewGroup, x xVar) {
        a(viewGroup, xVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, x xVar, int i) {
        if (viewGroup != null) {
            if (this.hAL != null && this.hAL.getView().getParent() != null) {
                ((ViewGroup) this.hAL.getView().getParent()).removeView(this.hAL.getView());
            }
            if (this.hAL == null) {
                this.hAL = new b(this.mTbPageContext.getPageActivity());
            }
            this.hAL.setId(i);
            this.hAL.o(this.onClickListener);
            this.hAL.getView().setOnClickListener(this.onClickListener);
            this.hAL.a(this.hmE);
            this.hAL.getView().setVisibility(0);
            cfs();
            aK(viewGroup);
            this.hAM = true;
            this.hAL.om(false);
            this.aBr = xVar;
            if (this.aBr != null) {
                this.hAL.a(this.aBr, this.isHost, JQ());
                if (this.aBr.aFJ != null && this.aBr.aFJ.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        ol(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cfn();
                        return;
                    } else {
                        cfm();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void ok(boolean z) {
        this.hAL.ok(z);
    }

    public void a(c cVar) {
        this.hAL.a(cVar);
    }

    private void aK(ViewGroup viewGroup) {
        if (this.hAL.getView() == null || this.hAL.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hAL.ol(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hAL.getView(), 0, layoutParams);
        }
    }

    public void M(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && this.hAL != null) {
            this.aBr = xVar;
            this.hAL.a(xVar, this.isHost, JQ());
            if (xVar.aFJ != null && this.hAM) {
                this.isFollowed = xVar.aFJ.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hAL.ol(false);
                }
                this.hAM = false;
            }
        }
    }

    public void cfl() {
        if (this.hAL != null && this.hAL.getView() != null) {
            this.hAL.getView().setVisibility(4);
        }
    }

    public void vr(int i) {
        if (this.hAL != null && this.hAL.getView() != null) {
            this.hAL.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfm() {
        if (this.hAL != null) {
            this.hAL.cfm();
        }
    }

    private void cfn() {
        if (this.hAL != null) {
            this.hAL.cfn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (this.hAL != null) {
            this.hAL.ol(z);
        }
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfo() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aBr != null && this.aBr.aFH != null) {
            String valueOf = String.valueOf(this.aBr.aFH.userId);
            String str = this.aBr.aFH.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.VF().a(valueOf, fVar);
            ol(this.hAN);
            this.hAN = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aBr.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aBr.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aBr.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aBr.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aBr.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aBr.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aBr.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aBr.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfp() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aBr.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aBr.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aBr == null || this.aBr.aFH == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.hpw != null) {
            this.hpw.dz(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aBr.aFH;
        AlaRelationData alaRelationData = this.aBr.aFJ;
        AlaLocationData alaLocationData = this.aBr.aFI;
        String str = null;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            str = this.aBr.mLiveInfo.feed_id;
        }
        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aBr.mLiveInfo.group_id), String.valueOf(this.aBr.mLiveInfo.live_id), this.isHost, String.valueOf(this.aBr.aFH.userId), this.aBr.mLiveInfo.appId, this.aBr.aFH.userName);
        alaPersonCardActivityConfig.setOtherParams(this.otherParams);
        alaPersonCardActivityConfig.setVid(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
    }

    public void cfq() {
        this.hAN = true;
        if (this.hAL != null) {
            this.hAL.cfq();
        }
    }

    public void onDestroy() {
        if (this.hAL != null) {
            this.hAL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gKA);
        MessageManager.getInstance().unRegisterListener(this.gKM);
        MessageManager.getInstance().unRegisterListener(this.gUM);
        MessageManager.getInstance().unRegisterListener(this.hwQ);
    }

    public boolean bZJ() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hmE = bVar;
        if (this.hAL != null) {
            this.hAL.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfr() {
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            com.baidu.live.q.a.c(this.aBr.mLiveInfo.live_id, 5);
        }
    }

    public void cfs() {
        if (this.hAL != null && this.hAL.cfF() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.hoa);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hAL.cfF().setAnimation(loadAnimation);
        }
    }
}
