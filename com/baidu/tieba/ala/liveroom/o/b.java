package com.baidu.tieba.ala.liveroom.o;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ak;
import com.baidu.live.data.bg;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.o.a;
import com.baidu.tieba.ala.liveroom.o.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener blw;
    private long bnV;
    private a hjM;
    private String hjN;
    private String hjO;
    private boolean hjP;
    private c hjQ;
    private com.baidu.tieba.ala.liveroom.o.a hjT;
    private d hjU;
    private ak hjV;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean hjR = true;
    private boolean hjS = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean bYN();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ccI();
    }

    public void a(a aVar) {
        this.hjM = aVar;
    }

    public void c(w wVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (wVar != null && (alaLiveInfoData = wVar.mLiveInfo) != null && (alaLiveUserInfoData = wVar.aIV) != null) {
            this.bnV = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hjN = alaLiveUserInfoData.portrait;
            this.hjO = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hjP = false;
            this.mPopShow = false;
            this.hjV = com.baidu.live.aa.a.PQ().bod;
            ccJ();
            OY();
            registerListener();
            ccK();
            ccL();
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Long l = (Long) customResponsedMessage.getData();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "网络不好，关注失败");
                } else {
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(String.valueOf(l));
                    fVar.setPageId(b.this.mPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_guide_pop");
                    com.baidu.live.view.a.Wx().b(String.valueOf(l), fVar);
                }
            }
        });
    }

    public void no(boolean z) {
        this.hjR = z;
    }

    public void np(boolean z) {
        this.hjS = z;
    }

    public boolean QW() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.hjM != null && !this.hjM.bYN()) {
            ccQ();
            return true;
        }
        return false;
    }

    private void KN() {
        this.mUid = -1L;
        this.hjP = false;
        this.mPopShow = false;
        Hv();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Pa();
    }

    public void onDestroy() {
        KN();
    }

    private void ccI() {
        this.hjQ = new c();
        String string = com.baidu.live.d.AZ().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hjQ.hjX = jSONObject.optBoolean("hasShowMax");
                    if (!this.hjQ.hjX) {
                        this.hjQ.date = b;
                        this.hjQ.dGM = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ccJ() {
        if (this.hjQ == null) {
            this.hjQ = new c();
        }
        String str = this.hjQ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hjQ.hjX = false;
            this.hjQ.dGM = 0;
        }
    }

    private void OY() {
        if (this.blw == null) {
            this.blw = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        b.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.blw);
        }
    }

    private void Pa() {
        if (this.blw != null) {
            MessageManager.getInstance().unRegisterListener(this.blw);
        }
    }

    private void ccK() {
        bg bgVar;
        int i;
        if (!this.hjP && TbadkCoreApplication.isLogin() && !this.hjQ.hjX && this.hjV != null && (bgVar = this.hjV.aMV) != null) {
            if ((!k.b(new Date()).equals(this.hjQ.date) || this.hjQ.dGM < bgVar.aPe) && (i = bgVar.aPd) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bnV, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.nq(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void ccL() {
        bg bgVar;
        int i;
        if (this.hjV != null && (bgVar = this.hjV.aMV) != null && (i = bgVar.aPf) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bnV, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.ccP();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nq(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hjR && !this.hjS && !this.hjQ.hjX && this.hjM != null && !this.hjM.bYN()) {
            ccM();
        }
    }

    private void ccM() {
        this.hjP = true;
        ccN();
        ccO();
    }

    private void ccN() {
        if (this.hjT == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hjT = new e(this.mPageContext.getPageActivity());
            } else {
                this.hjT = new f(this.mPageContext.getPageActivity());
            }
            this.hjT.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0681a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.bnV), b.this.hjT.ccH(), b.this.mOtherParams);
                    b.this.nr(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hjT.eu(this.hjN, this.hjO);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void ccO() {
        bg bgVar;
        String b = k.b(new Date());
        if (b.equals(this.hjQ.date)) {
            this.hjQ.dGM++;
        } else {
            this.hjQ.date = b;
            this.hjQ.dGM = 1;
        }
        if (com.baidu.live.aa.a.PQ().bod != null && (bgVar = com.baidu.live.aa.a.PQ().bod.aMV) != null) {
            if (this.hjQ.dGM >= bgVar.aPe) {
                this.hjQ.hjX = true;
            }
            com.baidu.live.d.AZ().putString("guide_follow_float_times_date", this.hjQ.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccP() {
        this.mPopShow = true;
    }

    private void ccQ() {
        if (this.hjU == null) {
            this.hjU = new d(this.mPageContext.getPageActivity());
            this.hjU.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.bnV), b.this.hjU.ccH(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    b.this.nr(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hjU.Gn(this.hjN);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        Hv();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hjN);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Wx().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hjM != null) {
            this.hjM.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        Hv();
        if (this.hjM != null) {
            this.hjM.onClose();
        }
    }

    public void Hv() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hjT != null) {
                this.hjT.dismiss();
                this.hjT = null;
            }
            if (this.hjU != null) {
                this.hjU.dismiss();
                this.hjU = null;
            }
        }
    }

    public void biM() {
        if (this.hjT != null && this.hjT.isShowing()) {
            this.hjT.ccG();
        }
        if (this.hjU != null && this.hjU.isShowing()) {
            this.hjU.ccG();
        }
    }
}
