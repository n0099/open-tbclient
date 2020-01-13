package com.baidu.tieba.ala.endliveroom;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.endliveroom.b;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private String asg;
    private b ewh;
    private AlaLiveInfoData mLiveInfo;
    private TbPageContext mTbPageContext;
    private boolean evd = false;
    private String mPortrait = "";
    private String mForumName = "";
    private String otherParams = "";
    private b.a ewi = new b.a() { // from class: com.baidu.tieba.ala.endliveroom.a.1
        @Override // com.baidu.tieba.ala.endliveroom.b.a
        public void bco() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        }

        @Override // com.baidu.tieba.ala.endliveroom.b.a
        public void b(AlaLiveInfoData alaLiveInfoData) {
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
        }

        @Override // com.baidu.tieba.ala.endliveroom.b.a
        public void ik(boolean z) {
            if (a.this.mLiveInfo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
                    return;
                }
                a.this.ewh.il(!z);
                a.this.evd = !z;
                String valueOf = String.valueOf(a.this.mLiveInfo.user_id);
                com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                bVar.setUserId(valueOf);
                bVar.setPortrait(a.this.mPortrait);
                bVar.setPageId(a.this.mId);
                bVar.setIsAttention(z ? false : true);
                com.baidu.live.view.a.yR().a(valueOf, bVar);
                if (!z && TbadkCoreApplication.getInst().isHaokan()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                    if (a.this.mLiveInfo != null) {
                        alaStaticItem.addParams("live_id", a.this.mLiveInfo.live_id + "");
                        alaStaticItem.addParams("room_id", a.this.mLiveInfo.room_id + "");
                        alaStaticItem.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                    }
                    alaStaticItem.addParams("other_params", a.this.vz());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(z ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    if (a.this.mLiveInfo != null) {
                        alaStaticItem2.addParams("live_id", a.this.mLiveInfo.live_id + "");
                        alaStaticItem2.addParams("room_id", a.this.mLiveInfo.room_id + "");
                        alaStaticItem2.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                    }
                    alaStaticItem2.addParams("loc", LogConfig.TAB_LIVE_END);
                    alaStaticItem2.addParams("other_params", a.this.vz());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };
    private CustomMessageListener ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.endliveroom.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.mLiveInfo.user_id))) {
                if (updateAttentionMessage.getData().isSucc) {
                    if (a.this.ewh != null) {
                        a.this.ewh.il(updateAttentionMessage.getData().isAttention);
                    }
                    a.this.evd = updateAttentionMessage.getData().isAttention;
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
                if (a.this.ewh != null) {
                    a.this.ewh.il(!updateAttentionMessage.getData().isAttention);
                }
                a.this.evd = updateAttentionMessage.getData().isAttention ? false : true;
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(a.this.mId) && !com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false)) {
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

    public void a(l lVar, String str, ArrayList<AlaLiveInfoData> arrayList, String str2, boolean z) {
        boolean z2 = false;
        if (lVar != null) {
            if (lVar.Wh != null && lVar.Wh.follow_status != 0) {
                z2 = true;
            }
            String str3 = "";
            if (lVar.Wf != null) {
                str3 = lVar.Wf.portrait;
            }
            this.mLiveInfo = lVar.mLiveInfo;
            this.mPortrait = str3;
            this.evd = z2;
            this.asg = str;
            this.mForumName = str2;
            if (this.mLiveInfo == null) {
                this.mLiveInfo = new AlaLiveInfoData();
            }
            bcm();
            this.ewh = new b(this.mTbPageContext, lVar, this.evd, this.mPortrait, z, this.ewi, vz());
            if (arrayList != null && !arrayList.isEmpty()) {
                this.ewh.S(arrayList);
            }
        }
    }

    public void S(ArrayList<AlaLiveInfoData> arrayList) {
        if (this.ewh != null) {
            this.ewh.S(arrayList);
        }
    }

    public View getView() {
        if (this.ewh == null) {
            return null;
        }
        return this.ewh.getRootView();
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        TiebaInitialize.log(new StatisticItem("c11888"));
        View view = getView();
        if (view != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            alaLiveRoomBlurPageLayout.b(view, new FrameLayout.LayoutParams(screenFullSize[0], screenFullSize[1]));
        }
    }

    public void bcm() {
        if (this.ewh != null && this.ewh.getRootView() != null && this.ewh.getRootView().getParent() != null) {
            ((ViewGroup) this.ewh.getRootView().getParent()).removeView(this.ewh.getRootView());
        }
    }

    public boolean bcn() {
        return (getView() == null || getView().getParent() == null) ? false : true;
    }

    private void initListener() {
        this.ern.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.ern);
    }

    public void bg(int i, int i2) {
        if (this.ewh != null && this.ewh.getRootView() != null && this.ewh.getRootView().getParent() != null) {
            this.ewh.getRootView().setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            int virtualBarHeight = k.getVirtualBarHeight(this.mTbPageContext.getPageActivity());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ewh.bcr().getLayoutParams();
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds90) - virtualBarHeight;
            this.ewh.bcr().setLayoutParams(layoutParams);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021010);
        MessageManager.getInstance().unRegisterTask(1021026);
        MessageManager.getInstance().removeMessage(this.mId);
        MessageManager.getInstance().unRegisterListener(this.ern);
        if (this.ewh != null) {
            this.ewh.onDestory();
        }
        this.ewh = null;
        this.mTbPageContext = null;
    }

    public String vz() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
