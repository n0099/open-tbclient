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
    private w aES;
    private com.baidu.tieba.ala.liveroom.operation.b gWq;
    private com.baidu.live.liveroom.a.a gYO;
    private b hkp;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean isFollowed = false;
    private boolean hkq = true;
    private boolean hkr = true;
    private int gXF = a.C0197a.anim_fade_in_and_out;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.hkp.getView()) {
                a.this.cdg();
            } else {
                a.this.cdf();
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.p.a.2
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
    private CustomMessageListener gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.a.3
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
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aES != null && a.this.aES.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aES.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.isFollowed) {
                            a.this.nt(false);
                        } else {
                            a.this.cdd();
                        }
                        if (!com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
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
                            a.this.nt(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                            LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                            if (!z) {
                                a.this.cdi();
                                return;
                            }
                            return;
                        }
                        z = true;
                        a.this.nt(true);
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
                        a.this.cdd();
                    }
                }
            }
        }
    };
    private HttpMessageListener gEY = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.p.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aES != null && a.this.aES.aIV != null && guardClubInfoHttpResponseMessage.bgz != null && guardClubInfoHttpResponseMessage.bgz.anchorId == a.this.aES.aIV.userId && guardClubInfoHttpResponseMessage.bgC && a.this.hkp != null && guardClubInfoHttpResponseMessage.bgF != null) {
                    a.this.hkp.nu(true);
                    a.this.hkp.setLevel(guardClubInfoHttpResponseMessage.bgF.bgr);
                }
            }
        }
    };
    CustomMessageListener hgj = new CustomMessageListener(2913094) { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.aES != null && a.this.aES.mLiveInfo != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.g.c)) {
                com.baidu.tieba.ala.liveroom.g.c cVar = (com.baidu.tieba.ala.liveroom.g.c) customResponsedMessage.getData();
                if (a.this.aES.mLiveInfo.live_id == cVar.liveId) {
                    a.this.hkp.eY(cVar.hgk);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.live.liveroom.a.a aVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.gYO = aVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.gvc);
        MessageManager.getInstance().registerListener(this.gvo);
        MessageManager.getInstance().registerListener(this.gEY);
        MessageManager.getInstance().registerListener(this.hgj);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        a(viewGroup, wVar, a.f.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, w wVar, int i) {
        if (viewGroup != null) {
            if (this.hkp != null && this.hkp.getView().getParent() != null) {
                ((ViewGroup) this.hkp.getView().getParent()).removeView(this.hkp.getView());
            }
            if (this.hkp == null) {
                this.hkp = new b(this.mTbPageContext.getPageActivity());
            }
            this.hkp.setId(i);
            this.hkp.n(this.fii);
            this.hkp.getView().setOnClickListener(this.fii);
            this.hkp.a(this.gWq);
            this.hkp.getView().setVisibility(0);
            cdj();
            aC(viewGroup);
            this.hkq = true;
            this.hkp.nu(false);
            this.aES = wVar;
            if (this.aES != null) {
                this.hkp.a(this.aES, this.isHost, MD());
                if (this.aES.aIX != null && this.aES.aIX.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled() && !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) {
                        nt(false);
                        return;
                    } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled() && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        cde();
                        return;
                    } else {
                        cdd();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    public void ns(boolean z) {
        this.hkp.ns(z);
    }

    public void a(c cVar) {
        this.hkp.a(cVar);
    }

    private void aC(ViewGroup viewGroup) {
        if (this.hkp.getView() == null || this.hkp.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds20);
            if (this.isHost) {
                this.hkp.nt(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds12) : 0);
            }
            viewGroup.addView(this.hkp.getView(), 0, layoutParams);
        }
    }

    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && this.hkp != null) {
            this.aES = wVar;
            this.hkp.a(wVar, this.isHost, MD());
            if (wVar.aIX != null && this.hkq) {
                this.isFollowed = wVar.aIX.getFollowStatus() != 0;
                if (this.isFollowed) {
                    this.hkp.nt(false);
                }
                this.hkq = false;
            }
        }
    }

    public void cdc() {
        if (this.hkp != null && this.hkp.getView() != null) {
            this.hkp.getView().setVisibility(4);
        }
    }

    public void vJ(int i) {
        if (this.hkp != null && this.hkp.getView() != null) {
            this.hkp.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdd() {
        if (this.hkp != null) {
            this.hkp.cdd();
        }
    }

    private void cde() {
        if (this.hkp != null) {
            this.hkp.cde();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(boolean z) {
        if (this.hkp != null) {
            this.hkp.nt(z);
        }
    }

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdf() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mTbPageContext.getPageActivity());
        } else if (!BdUtilHelper.isNetOk()) {
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
        } else if (this.aES != null && this.aES.aIV != null) {
            String valueOf = String.valueOf(this.aES.aIV.userId);
            String str = this.aES.aIV.portrait;
            f fVar = new f();
            fVar.setUserId(valueOf);
            fVar.setPortrait(str);
            fVar.setPageId(this.mTbPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom("source_host_header");
            com.baidu.live.view.a.Wx().a(valueOf, fVar);
            nt(this.hkr);
            this.hkr = false;
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                if (this.aES.mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", this.aES.mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", this.aES.mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", this.aES.mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                if (this.aES.mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", this.aES.mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", this.aES.mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", this.aES.mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("loc", WebSocketRequest.PARAM_KEY_HEADER);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdg() {
        if (!this.isHost && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
            if (this.aES.mLiveInfo != null) {
                alaStaticItem.addParams("feed_id", this.aES.mLiveInfo.feed_id);
            } else {
                alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                alaStaticItem.addParams("other_params", this.otherParams);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.aES == null || this.aES.aIV == null) {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_get_userinfo_failed));
            return;
        }
        if (this.gYO != null) {
            this.gYO.eO(5);
        }
        AlaLiveUserInfoData alaLiveUserInfoData = this.aES.aIV;
        AlaRelationData alaRelationData = this.aES.aIX;
        AlaLocationData alaLocationData = this.aES.aIW;
        String str = null;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            str = this.aES.mLiveInfo.feed_id;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(this.aES.mLiveInfo.group_id), String.valueOf(this.aES.mLiveInfo.live_id), this.isHost, String.valueOf(this.aES.aIV.userId), this.aES.mLiveInfo.appId, this.aES.aIV.userName, str, this.otherParams)));
    }

    public void cdh() {
        this.hkr = true;
        if (this.hkp != null) {
            this.hkp.cdh();
        }
    }

    public void onDestroy() {
        if (this.hkp != null) {
            this.hkp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gvc);
        MessageManager.getInstance().unRegisterListener(this.gvo);
        MessageManager.getInstance().unRegisterListener(this.gEY);
        MessageManager.getInstance().unRegisterListener(this.hgj);
    }

    public boolean bXJ() {
        return this.isFollowed;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.gWq = bVar;
        if (this.hkp != null) {
            this.hkp.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdi() {
        if (this.aES != null && this.aES.mLiveInfo != null) {
            com.baidu.live.n.a.b(this.aES.mLiveInfo.live_id, 5);
        }
    }

    public void cdj() {
        if (this.hkp != null && this.hkp.cdw() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mTbPageContext.getPageActivity(), this.gXF);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hkp.cdw().setAnimation(loadAnimation);
        }
    }
}
