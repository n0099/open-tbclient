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
import com.baidu.live.data.i;
import com.baidu.live.k.a;
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
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.endliveroom.b;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private String ajt;
    private b dGJ;
    private AlaLiveInfoData mLiveInfo;
    private TbPageContext mTbPageContext;
    private boolean dGK = false;
    private String mPortrait = "";
    private String mForumName = "";
    private String otherParams = "";
    private b.a dGL = new b.a() { // from class: com.baidu.tieba.ala.endliveroom.a.1
        @Override // com.baidu.tieba.ala.endliveroom.b.a
        public void aKH() {
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
        public void gT(boolean z) {
            if (a.this.mLiveInfo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mTbPageContext.getPageActivity());
                    return;
                }
                a.this.dGJ.gU(!z);
                a.this.dGK = !z;
                String valueOf = String.valueOf(a.this.mLiveInfo.user_id);
                com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                bVar.setUserId(valueOf);
                bVar.setPortrait(a.this.mPortrait);
                bVar.setPageId(a.this.mId);
                bVar.setIsAttention(z ? false : true);
                com.baidu.live.view.a.wy().a(valueOf, bVar);
                if (!z && TbadkCoreApplication.getInst().isHaokan()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                    if (a.this.mLiveInfo != null) {
                        alaStaticItem.addParams("live_id", a.this.mLiveInfo.live_id + "");
                        alaStaticItem.addParams("room_id", a.this.mLiveInfo.room_id + "");
                        alaStaticItem.addParams("feed_id", a.this.mLiveInfo.feed_id + "");
                    }
                    alaStaticItem.addParams("other_params", a.this.tn());
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
                    alaStaticItem2.addParams("other_params", a.this.tn());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    };
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.endliveroom.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid) && a.this.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(a.this.mLiveInfo.user_id))) {
                if (updateAttentionMessage.getData().isSucc) {
                    if (a.this.dGJ != null) {
                        a.this.dGJ.gU(updateAttentionMessage.getData().isAttention);
                    }
                    a.this.dGK = updateAttentionMessage.getData().isAttention;
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
                if (a.this.dGJ != null) {
                    a.this.dGJ.gU(!updateAttentionMessage.getData().isAttention);
                }
                a.this.dGK = updateAttentionMessage.getData().isAttention ? false : true;
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(a.this.mId) && !com.baidu.live.view.a.wy().a(updateAttentionMessage.getData(), a.this.mTbPageContext, false)) {
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

    public void a(i iVar, String str, ArrayList<AlaLiveInfoData> arrayList, String str2, boolean z) {
        boolean z2 = false;
        if (iVar != null) {
            if (iVar.OU != null && iVar.OU.follow_status != 0) {
                z2 = true;
            }
            String str3 = "";
            if (iVar.OR != null) {
                str3 = iVar.OR.portrait;
            }
            this.mLiveInfo = iVar.mLiveInfo;
            this.mPortrait = str3;
            this.dGK = z2;
            this.ajt = str;
            this.mForumName = str2;
            if (this.mLiveInfo == null) {
                this.mLiveInfo = new AlaLiveInfoData();
            }
            aKF();
            this.dGJ = new b(this.mTbPageContext.getPageActivity(), iVar, this.dGK, this.mPortrait, z, this.dGL, tn());
            if (arrayList != null && !arrayList.isEmpty()) {
                this.dGJ.M(arrayList);
            }
        }
    }

    public void M(ArrayList<AlaLiveInfoData> arrayList) {
        if (this.dGJ != null) {
            this.dGJ.M(arrayList);
        }
    }

    public View getView() {
        if (this.dGJ == null) {
            return null;
        }
        return this.dGJ.getRootView();
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        TiebaInitialize.log(new StatisticItem("c11888"));
        View view = getView();
        if (view != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            alaLiveRoomBlurPageLayout.b(view, new FrameLayout.LayoutParams(screenFullSize[0], screenFullSize[1]));
        }
    }

    public void aKF() {
        if (this.dGJ != null && this.dGJ.getRootView() != null && this.dGJ.getRootView().getParent() != null) {
            ((ViewGroup) this.dGJ.getRootView().getParent()).removeView(this.dGJ.getRootView());
        }
    }

    public boolean aKG() {
        return (getView() == null || getView().getParent() == null) ? false : true;
    }

    private void initListener() {
        this.dEn.setTag(this.mId);
        MessageManager.getInstance().registerListener(this.dEn);
    }

    public void aM(int i, int i2) {
        if (this.dGJ != null && this.dGJ.getRootView() != null && this.dGJ.getRootView().getParent() != null) {
            this.dGJ.getRootView().setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            int virtualBarHeight = j.getVirtualBarHeight(this.mTbPageContext.getPageActivity());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGJ.aKK().getLayoutParams();
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds90) - virtualBarHeight;
            this.dGJ.aKK().setLayoutParams(layoutParams);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021010);
        MessageManager.getInstance().unRegisterTask(1021026);
        MessageManager.getInstance().removeMessage(this.mId);
        MessageManager.getInstance().unRegisterListener(this.dEn);
        if (this.dGJ != null) {
            this.dGJ.onDestory();
        }
        this.dGJ = null;
        this.mTbPageContext = null;
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
