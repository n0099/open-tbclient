package com.baidu.tieba.ala.liveroom.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
import com.baidu.live.data.k;
import com.baidu.live.q.a;
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
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
/* loaded from: classes2.dex */
public class a {
    private k aio;
    private com.baidu.tieba.ala.liveroom.operation.b eMc;
    private com.baidu.tieba.ala.liveroom.b eNX;
    private GuardClubInfoHttpResponseMessage eNa;
    private b eXm;
    private boolean isHost;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private boolean etS = false;
    private boolean ezi = false;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eXm.getView()) {
                if (!a.this.isHost) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_AUTHORHEAD);
                    if (a.this.aio.mLiveInfo != null) {
                        alaStaticItem.addParams("feed_id", a.this.aio.mLiveInfo.feed_id);
                    } else {
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        alaStaticItem.addParams("other_params", a.this.otherParams);
                    }
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (a.this.aio == null || a.this.aio.VP == null) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_get_userinfo_failed));
                    return;
                }
                if (a.this.eNX != null) {
                    a.this.eNX.pq(5);
                }
                AlaLiveUserInfoData alaLiveUserInfoData = a.this.aio.VP;
                AlaRelationData alaRelationData = a.this.aio.VR;
                AlaLocationData alaLocationData = a.this.aio.VQ;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mTbPageContext.getPageActivity(), String.valueOf(alaLiveUserInfoData.userId), alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, alaLiveUserInfoData.sex, alaLiveUserInfoData.levelId, alaLocationData.getLocation(), alaLiveUserInfoData.description, alaLiveUserInfoData.recordCount, alaLiveUserInfoData.fansCount, alaLiveUserInfoData.followCount, alaRelationData.follow_status, String.valueOf(a.this.aio.mLiveInfo.group_id), String.valueOf(a.this.aio.mLiveInfo.live_id), a.this.isHost, String.valueOf(a.this.aio.VP.userId), a.this.aio.mLiveInfo.appId, a.this.aio.VP.userName, a.this.otherParams)));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
            } else if (BdUtilHelper.isNetOk()) {
                if (a.this.aio != null && a.this.aio.VP != null) {
                    String valueOf = String.valueOf(a.this.aio.VP.userId);
                    String str = a.this.aio.VP.portrait;
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(valueOf);
                    bVar.setPortrait(str);
                    bVar.setPageId(a.this.mTbPageContext.getUniqueId());
                    bVar.setIsAttention(true);
                    bVar.setInLive("1");
                    com.baidu.live.view.a.yy().a(valueOf, bVar);
                    a.this.jj(true);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem2 = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        if (a.this.aio.mLiveInfo != null) {
                            alaStaticItem2.addParams("live_id", a.this.aio.mLiveInfo.live_id + "");
                            alaStaticItem2.addParams("room_id", a.this.aio.mLiveInfo.room_id + "");
                            alaStaticItem2.addParams("feed_id", a.this.aio.mLiveInfo.feed_id + "");
                        }
                        alaStaticItem2.addParams("other_params", a.this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem3 = new AlaStaticItem(QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                        if (a.this.aio.mLiveInfo != null) {
                            alaStaticItem3.addParams("live_id", a.this.aio.mLiveInfo.live_id + "");
                            alaStaticItem3.addParams("room_id", a.this.aio.mLiveInfo.room_id + "");
                            alaStaticItem3.addParams("feed_id", a.this.aio.mLiveInfo.feed_id + "");
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
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.2
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
    private CustomMessageListener eqb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.l.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && a.this.aio != null && a.this.aio.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.aio.mLiveInfo.user_id))) {
                    Message<?> orginalMessage = updateAttentionMessage.getOrginalMessage();
                    if (!updateAttentionMessage.getData().isSucc) {
                        if (a.this.etS) {
                            a.this.jj(false);
                        } else {
                            a.this.bkt();
                        }
                        if (!com.baidu.live.view.a.yy().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null && orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                        }
                    } else if (updateAttentionMessage.getData().isAttention) {
                        a.this.etS = true;
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
                            if (com.baidu.live.liveroom.a.vU().vV()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                        a.this.jj(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
                        LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
                    } else {
                        a.this.etS = false;
                        if (orginalMessage != null && orginalMessage.getTag() == a.this.mTbPageContext.getUniqueId()) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                        }
                        a.this.bkt();
                    }
                }
            }
        }
    };
    private HttpMessageListener eyF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.l.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aio != null && a.this.aio.VP != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.eyC != null && guardClubInfoHttpResponseMessage.eyC.Vc == a.this.aio.VP.userId) {
                    a.this.eNa = guardClubInfoHttpResponseMessage;
                    a.this.ezi = guardClubInfoHttpResponseMessage.ezi;
                    if (a.this.ezi) {
                        a.this.jj(false);
                    }
                    if (a.this.eXm != null) {
                        a.this.eXm.jk(a.this.ezi);
                    }
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z, com.baidu.tieba.ala.liveroom.b bVar) {
        this.isHost = false;
        this.mTbPageContext = tbPageContext;
        this.eNX = bVar;
        this.isHost = z;
        MessageManager.getInstance().registerListener(this.eqb);
        MessageManager.getInstance().registerListener(this.eqn);
    }

    public void d(ViewGroup viewGroup, k kVar) {
        a(viewGroup, kVar, a.g.ala_liveroom_hostheader);
    }

    public void a(ViewGroup viewGroup, k kVar, int i) {
        if (viewGroup != null) {
            if (this.eXm != null && this.eXm.getView().getParent() != null) {
                ((ViewGroup) this.eXm.getView().getParent()).removeView(this.eXm.getView());
            }
            if (this.eXm == null) {
                this.eXm = new b(this.mTbPageContext.getPageActivity());
            }
            this.eXm.setId(i);
            this.eXm.n(this.dmK);
            this.eXm.getView().setOnClickListener(this.dmK);
            this.eXm.a(this.eMc);
            this.eXm.getView().setVisibility(0);
            ae(viewGroup);
            this.aio = kVar;
            if (this.aio != null) {
                this.eXm.a(this.aio, this.isHost, vi());
                if (this.aio.VR != null && this.aio.VR.getFollowStatus() == 0) {
                    if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) {
                        jj(true);
                        return;
                    } else {
                        bkt();
                        return;
                    }
                }
                LogManager.getMigrateFromTiebaLogger().doDisplayAttentionLog();
            }
        }
    }

    private void ae(ViewGroup viewGroup) {
        if (this.eXm.getView() == null || this.eXm.getView().getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds72));
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds20);
            if (this.isHost) {
                this.eXm.jj(false);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12);
            } else {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds24) - (UtilHelper.canUseStyleImmersiveSticky() ? BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds12) : 0);
            }
            viewGroup.addView(this.eXm.getView(), 0, layoutParams);
        }
    }

    public void n(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null && this.eXm != null) {
            this.aio = kVar;
            this.eXm.a(kVar, this.isHost, vi());
            if (kVar.VR != null) {
                this.etS = kVar.VR.getFollowStatus() != 0;
                if (this.etS) {
                    this.eXm.jj(false);
                }
            }
        }
    }

    public void bks() {
        if (this.eXm != null && this.eXm.getView() != null) {
            this.eXm.getView().setVisibility(4);
        }
    }

    public void pO(int i) {
        if (this.eXm != null && this.eXm.getView() != null) {
            this.eXm.getView().setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkt() {
        if (this.eXm != null && !this.ezi) {
            this.eXm.bkt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(boolean z) {
        if (this.eXm != null) {
            this.eXm.jj(z);
        }
    }

    public String vi() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void onDestroy() {
        if (this.eXm != null) {
            this.eXm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eqb);
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }

    public boolean bgf() {
        return this.etS;
    }

    public void a(com.baidu.tieba.ala.liveroom.operation.b bVar) {
        this.eMc = bVar;
        if (this.eXm != null) {
            this.eXm.a(bVar);
        }
    }
}
