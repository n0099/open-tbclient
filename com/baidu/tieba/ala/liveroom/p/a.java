package com.baidu.tieba.ala.liveroom.p;

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
import com.baidu.live.data.e;
import com.baidu.live.data.u;
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
    private u aAP;
    private b gEk;
    private com.baidu.tieba.ala.liveroom.operation.b gqe;
    private com.baidu.live.liveroom.a.a gsz;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean gEl = true;
    private boolean gEm = true;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.gEk.getView()) {
                a.this.bUn();
            } else {
                a.this.bUm();
            }
        }
    };
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.p.a.2
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
    private CustomMessageListener fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.a.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aAP != null && a.this.aAP.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aAP.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.ms(false);
                        } else {
                            a.this.bUk();
                        }
                        if (!com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.isFollowed = true;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
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
                            a.this.ms(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.bUp();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.ms(true);
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
                        a.this.bUk();
                    }
                }
            }
        }
    };
    private HttpMessageListener gcP = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.p.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAP != null && a.this.aAP.aEz != null && guardClubInfoHttpResponseMessage.bat != null && guardClubInfoHttpResponseMessage.bat.aDf == a.this.aAP.aEz.userId && guardClubInfoHttpResponseMessage.baw && a.this.gEk != null && guardClubInfoHttpResponseMessage.baz != null) {
                    a.this.gEk.mt(true);
                    a.this.gEk.setLevel(guardClubInfoHttpResponseMessage.baz.bal);
                }
            }
        }
    };
    CustomMessageListener gzY = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aAP != null && a.this.aAP.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aAP.mLiveInfo.live_id == cVar.liveId) {
                    a.this.gEk.ek(cVar.gzZ);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gsz = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.fSS);
        MessageManager.getInstance().registerListener(this.fTe);
        MessageManager.getInstance().registerListener(this.gcP);
        MessageManager.getInstance().registerListener(this.gzY);
    }

    public void d(ViewGroup viewGroup, u uVar) {
        a(viewGroup, uVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, u uVar, int i) {
        if (viewGroup != null) {
            if (this.gEk != null && this.gEk.getView().getParent() != null) {
                ((ViewGroup) this.gEk.getView().getParent()).removeView(this.gEk.getView());
            }
            if (this.gEk == null) {
                this.gEk = new b(this.mTbPageContext.getPageActivity());
            }
            this.gEk.setId(i);
            this.gEk.m(this.eHN);
            this.gEk.getView().setOnClickListener(this.eHN);
            this.gEk.a(this.gqe);
            this.gEk.getView().setVisibility(0);
            ay(viewGroup);
            this.gEl = true;
            this.gEk.mt(false);
            this.aAP = uVar;
            if (this.aAP != null) {
                this.gEk.a(this.aAP, this.isHost, KD());
                if (this.aAP.aEB != null && this.aAP.aEB.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        ms(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        bUl();
                        return;
                    } else {
                        bUk();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void mr(boolean z) {
        this.gEk.mr(z);
    }

    public void a(c cVar) {
        this.gEk.a(cVar);
    }

    private void ay(ViewGroup viewGroup) {
        if (this.gEk.getView() == null || this.gEk.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.gEk.ms(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.gEk.getView(), 0, layoutParams);
        }
    }

    public void y(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && this.gEk != null) {
            this.aAP = uVar;
            this.gEk.a(uVar, this.isHost, KD());
            if (uVar.aEB != null && this.gEl) {
                this.isFollowed = uVar.aEB.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.gEk.ms(false);
                }
                this.gEl = false;
            }
        }
    }

    public void bUj() {
        if (this.gEk != null && this.gEk.getView() != null) {
            this.gEk.getView().setVisibility(4);
        }
    }

    public void ux(int i) {
        if (this.gEk != null && this.gEk.getView() != null) {
            this.gEk.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUk() {
        if (this.gEk != null) {
            this.gEk.bUk();
        }
    }

    private void bUl() {
        if (this.gEk != null) {
            this.gEk.bUl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        if (this.gEk != null) {
            this.gEk.ms(z);
        }
    }

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUm() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
        } else if (this.aAP != null && this.aAP.aEz != null) {
            String valueOf = String.valueOf(this.aAP.aEz.userId);
            String str = this.aAP.aEz.portrait;
            e eVar = new e();
            eVar.setUserId(valueOf);
            eVar.setPortrait(str);
            eVar.setPageId(this.mTbPageContext.getUniqueId());
            eVar.setIsAttention(true);
            eVar.setInLive("1");
            eVar.setFrom("source_host_header");
            com.baidu.live.view.a.Rg().a(valueOf, eVar);
            ms(this.gEm);
            this.gEm = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aAP.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aAP.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aAP.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aAP.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aAP.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aAP.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aAP.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aAP.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aAP.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aAP.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aAP == null || this.aAP.aEz == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
            return;
        }
        if (this.gsz != null) {
            this.gsz.eC(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aAP.aEz;
        AlaRelationData alaRelationData = this.aAP.aEB;
        AlaLocationData alaLocationData = this.aAP.aEA;
        String str = null;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            str = this.aAP.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aAP.mLiveInfo.group_id), String.valueOf(this.aAP.mLiveInfo.live_id), this.isHost, String.valueOf(this.aAP.aEz.userId), this.aAP.mLiveInfo.appId, this.aAP.aEz.userName, str, this.otherParams)));
    }

    public void bUo() {
        this.gEm = true;
        if (this.gEk != null) {
            this.gEk.bUo();
        }
    }

    public void onDestroy() {
        if (this.gEk != null) {
            this.gEk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fSS);
        MessageManager.getInstance().unRegisterListener(this.fTe);
        MessageManager.getInstance().unRegisterListener(this.gcP);
        MessageManager.getInstance().unRegisterListener(this.gzY);
    }

    public boolean bOV() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gqe = bVar;
        if (this.gEk != null) {
            this.gEk.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUp() {
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            com.baidu.live.m.a.b(this.aAP.mLiveInfo.live_id, 5);
        }
    }
}
