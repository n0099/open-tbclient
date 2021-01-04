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
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    private b hFr;
    private com.baidu.tieba.ala.liveroom.operation.b hrl;
    private com.baidu.live.liveroom.a.a huc;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hFs = true;
    private boolean hFt = true;
    private int hsH = a.C0203a.anim_fade_in_and_out;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hFr.getView()) {
                a.this.cjg();
            } else {
                a.this.cjf();
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
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
    private CustomMessageListener gPg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aGe != null && a.this.aGe.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aGe.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.op(false);
                        } else {
                            a.this.cjd();
                        }
                        if (!com.baidu.live.view.a.Zx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                            a.this.op(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.cji();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.op(true);
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
                        a.this.cjd();
                    }
                }
            }
        }
    };
    private HttpMessageListener gZs = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.o.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aGe != null && a.this.aGe.aKu != null && guardClubInfoHttpResponseMessage.bkF != null && guardClubInfoHttpResponseMessage.bkF.anchorId == a.this.aGe.aKu.userId && guardClubInfoHttpResponseMessage.bkK && a.this.hFr != null && guardClubInfoHttpResponseMessage.bkN != null) {
                    a.this.hFr.oq(true);
                    a.this.hFr.setLevel(guardClubInfoHttpResponseMessage.bkN.guardLevel);
                }
            }
        }
    };
    CustomMessageListener hBw = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.o.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aGe != null && a.this.aGe.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aGe.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hFr.fC(cVar.bqF);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.huc = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gPg);
        MessageManager.getInstance().registerListener(this.gPs);
        MessageManager.getInstance().registerListener(this.gZs);
        MessageManager.getInstance().registerListener(this.hBw);
    }

    public void e(ViewGroup viewGroup, x xVar) {
        a(viewGroup, xVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, x xVar, int i) {
        if (viewGroup != null) {
            if (this.hFr != null && this.hFr.getView().getParent() != null) {
                ((ViewGroup) this.hFr.getView().getParent()).removeView(this.hFr.getView());
            }
            if (this.hFr == null) {
                this.hFr = new b(this.mTbPageContext.getPageActivity());
            }
            this.hFr.setId(i);
            this.hFr.o(this.onClickListener);
            this.hFr.getView().setOnClickListener(this.onClickListener);
            this.hFr.a(this.hrl);
            this.hFr.getView().setVisibility(0);
            cjj();
            aK(viewGroup);
            this.hFs = true;
            this.hFr.oq(false);
            this.aGe = xVar;
            if (this.aGe != null) {
                this.hFr.a(this.aGe, this.isHost, NL());
                if (this.aGe.aKw != null && this.aGe.aKw.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        op(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cje();
                        return;
                    } else {
                        cjd();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void oo(boolean z) {
        this.hFr.oo(z);
    }

    public void a(c cVar) {
        this.hFr.a(cVar);
    }

    private void aK(ViewGroup viewGroup) {
        if (this.hFr.getView() == null || this.hFr.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hFr.op(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hFr.getView(), 0, layoutParams);
        }
    }

    public void M(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && this.hFr != null) {
            this.aGe = xVar;
            this.hFr.a(xVar, this.isHost, NL());
            if (xVar.aKw != null && this.hFs) {
                this.isFollowed = xVar.aKw.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hFr.op(false);
                }
                this.hFs = false;
            }
        }
    }

    public void cjc() {
        if (this.hFr != null && this.hFr.getView() != null) {
            this.hFr.getView().setVisibility(4);
        }
    }

    public void wX(int i) {
        if (this.hFr != null && this.hFr.getView() != null) {
            this.hFr.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjd() {
        if (this.hFr != null) {
            this.hFr.cjd();
        }
    }

    private void cje() {
        if (this.hFr != null) {
            this.hFr.cje();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hFr != null) {
            this.hFr.op(z);
        }
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aGe != null && this.aGe.aKu != null) {
            String valueOf = String.valueOf(this.aGe.aKu.userId);
            String str = this.aGe.aKu.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.Zx().a(valueOf, fVar);
            op(this.hFt);
            this.hFt = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aGe.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aGe.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aGe.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aGe.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aGe.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aGe.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aGe.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aGe.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aGe.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aGe.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aGe == null || this.aGe.aKu == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.huc != null) {
            this.huc.ff(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aGe.aKu;
        AlaRelationData alaRelationData = this.aGe.aKw;
        AlaLocationData alaLocationData = this.aGe.aKv;
        String str = null;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            str = this.aGe.mLiveInfo.feed_id;
        }
        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aGe.mLiveInfo.group_id), String.valueOf(this.aGe.mLiveInfo.live_id), this.isHost, String.valueOf(this.aGe.aKu.userId), this.aGe.mLiveInfo.appId, this.aGe.aKu.userName);
        alaPersonCardActivityConfig.setOtherParams(this.otherParams);
        alaPersonCardActivityConfig.setVid(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
    }

    public void cjh() {
        this.hFt = true;
        if (this.hFr != null) {
            this.hFr.cjh();
        }
    }

    public void onDestroy() {
        if (this.hFr != null) {
            this.hFr.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gPg);
        MessageManager.getInstance().unRegisterListener(this.gPs);
        MessageManager.getInstance().unRegisterListener(this.gZs);
        MessageManager.getInstance().unRegisterListener(this.hBw);
    }

    public boolean cdA() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.hrl = bVar;
        if (this.hFr != null) {
            this.hFr.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cji() {
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            com.baidu.live.q.a.c(this.aGe.mLiveInfo.live_id, 5);
        }
    }

    public void cjj() {
        if (this.hFr != null && this.hFr.cjw() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.hsH);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hFr.cjw().setAnimation(loadAnimation);
        }
    }
}
