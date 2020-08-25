package com.baidu.tieba.ala.endliveroom;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.d;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private AlaLiveInfoData mLiveInfo;
    private TbPageContext mTbPageContext;
    private View mView;
    private boolean aYi = false;
    private String mPortrait = "";
    private String otherParams = "";
    private AlaLiveAudienceEndView.a fVn = new AlaLiveAudienceEndView.a() { // from class: com.baidu.tieba.ala.endliveroom.a.1
        @Override // com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.a
        public void Ll() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        }

        @Override // com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.a
        public void f(AlaLiveInfoData alaLiveInfoData) {
            Log.i("EndDebug", "@@ onPlayRecommendViewClick mTbPageContext = " + a.this.mTbPageContext);
            if (a.this.mTbPageContext == null) {
                TiebaInitialize.log(new StatisticItem("c11890"));
                return;
            }
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(a.this.mTbPageContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(alaLiveInfoData.live_id, String.valueOf(alaLiveInfoData.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_END_LIVE_RECOMMEND);
            if (TextUtils.isEmpty(a.this.otherParams)) {
                a.this.otherParams = "";
            }
            try {
                String flvUrl = alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                String str = alaLiveInfoData.cover;
                String valueOf = String.valueOf(alaLiveInfoData.room_id);
                String valueOf2 = String.valueOf(alaLiveInfoData.live_id);
                JSONObject jSONObject = new JSONObject(a.this.otherParams);
                jSONObject.put("live_url", flvUrl);
                jSONObject.put("cover", str);
                jSONObject.put("enterRoomId", valueOf);
                jSONObject.put("enterLiveId", valueOf2);
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, alaLiveInfoData.screen_direction);
                a.this.otherParams = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            alaLiveRoomActivityConfig.addExtraByParams(a.this.otherParams);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            StatisticItem param = new StatisticItem("c11890").param("live_id", alaLiveInfoData.live_id).param("description", alaLiveInfoData.description);
            if (a.this.mLiveInfo != null) {
                param.param("uid", a.this.mLiveInfo.user_id);
            }
            TiebaInitialize.log(param);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("model", "youlike");
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, "live_end", "").setContentExt(jSONObject2));
        }

        @Override // com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.a
        public void ld(boolean z) {
            if (a.this.mLiveInfo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
                    return;
                }
                if (a.this.mView instanceof AlaLiveAudienceEndView) {
                    ((AlaLiveAudienceEndView) a.this.mView).le(!z);
                }
                a.this.aYi = !z;
                String valueOf = String.valueOf(a.this.mLiveInfo.user_id);
                d dVar = new d();
                dVar.setUserId(valueOf);
                dVar.setPortrait(a.this.mPortrait);
                dVar.setPageId(a.this.mId);
                dVar.setIsAttention(z ? false : true);
                dVar.setFrom("source_audience_end_page");
                com.baidu.live.view.a.Qx().a(valueOf, dVar);
                if (!z && TbadkCoreApplication.getInst().isHaokan()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                    if (a.this.mLiveInfo != null) {
                        alaStaticItem.addParams("live_id", a.this.mLiveInfo.live_id + "");
                        alaStaticItem.addParams("room_id", a.this.mLiveInfo.room_id + "");
                        alaStaticItem.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                    }
                    alaStaticItem.addParams("other_params", a.this.JY());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    if (a.this.mLiveInfo != null) {
                        alaStaticItem2.addParams("live_id", a.this.mLiveInfo.live_id + "");
                        alaStaticItem2.addParams("room_id", a.this.mLiveInfo.room_id + "");
                        alaStaticItem2.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                    }
                    alaStaticItem2.addParams("loc", "live_end");
                    alaStaticItem2.addParams("other_params", a.this.JY());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };
    private CustomMessageListener fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.endliveroom.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.mLiveInfo.user_id))) {
                if (updateAttentionMessage.getData().isSucc) {
                    if (a.this.mView instanceof AlaLiveAudienceEndView) {
                        ((AlaLiveAudienceEndView) a.this.mView).le(updateAttentionMessage.getData().isAttention);
                    }
                    a.this.aYi = updateAttentionMessage.getData().isAttention;
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mId)) {
                        if (updateAttentionMessage.getData().isAttention) {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                            return;
                        } else {
                            a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                            return;
                        }
                    }
                    return;
                }
                if (a.this.mView instanceof AlaLiveAudienceEndView) {
                    ((AlaLiveAudienceEndView) a.this.mView).le(!updateAttentionMessage.getData().isAttention);
                }
                a.this.aYi = updateAttentionMessage.getData().isAttention ? false : true;
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(a.this.mId) && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mTbPageContext, false)) {
                    a.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    };
    private BdUniqueId mId = BdUniqueId.gen();

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        initListener();
    }

    public View getView() {
        return this.mView;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, View view, r rVar, boolean z, ArrayList<AlaLiveInfoData> arrayList) {
        boolean z2;
        if (rVar != null) {
            if (rVar.aDG != null) {
                z2 = rVar.aDG.follow_status != 0;
            } else {
                z2 = false;
            }
            String str = "";
            if (rVar.aDE != null) {
                str = rVar.aDE.portrait;
            }
            this.mLiveInfo = rVar.mLiveInfo;
            this.mPortrait = str;
            this.aYi = z2;
            if (this.mLiveInfo == null) {
                this.mLiveInfo = new AlaLiveInfoData();
            }
            bJh();
            TiebaInitialize.log(new StatisticItem("c11888"));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", "youlike");
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1392, "show", "live_end", "").setContentExt(jSONObject));
            this.mView = view;
            if (this.mView == null) {
                this.mView = new AlaLiveAudienceEndView(alaLiveRoomBlurPageLayout.getContext());
            }
            this.mView.setId(a.g.ala_liveroom_audience_end_view);
            if (this.mView instanceof AlaLiveAudienceEndView) {
                ((AlaLiveAudienceEndView) this.mView).setCallback(this.fVn);
                ((AlaLiveAudienceEndView) this.mView).setData(this.mTbPageContext, rVar, z, this.aYi, this.mPortrait, JY());
                bJg();
            }
            if (this.mView != null) {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenFullSize[0], screenFullSize[1]);
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                layoutParams.height = visibilityRegion.height();
                layoutParams.width = visibilityRegion.width();
                alaLiveRoomBlurPageLayout.c(this.mView, layoutParams);
            }
        }
    }

    public void bJg() {
        if (this.mView instanceof AlaLiveAudienceEndView) {
            ((AlaLiveAudienceEndView) this.mView).bJk();
        }
    }

    public void bJh() {
        if (this.mView != null && this.mView.getParent() != null) {
            ((ViewGroup) this.mView).removeView(this.mView);
        }
    }

    public boolean bJi() {
        return (getView() == null || getView().getParent() == null) ? false : true;
    }

    private void initListener() {
        this.fPD.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.fPD);
    }

    public void D(int i, int i2) {
        if ((this.mView instanceof AlaLiveAudienceEndView) && this.mView.getParent() != null) {
            this.mView.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            int virtualBarHeight = k.getVirtualBarHeight(this.mTbPageContext.getPageActivity());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((AlaLiveAudienceEndView) this.mView).getRecParentView().getLayoutParams();
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds90) - virtualBarHeight;
            ((AlaLiveAudienceEndView) this.mView).getRecParentView().setLayoutParams(layoutParams);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021010);
        MessageManager.getInstance().unRegisterTask(1021026);
        MessageManager.getInstance().removeMessage(this.mId);
        MessageManager.getInstance().unRegisterListener(this.fPD);
        if (this.mView instanceof AlaLiveAudienceEndView) {
            ((AlaLiveAudienceEndView) this.mView).onDestory();
        }
        this.mView = null;
        this.mTbPageContext = null;
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
