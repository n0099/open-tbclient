package com.baidu.tieba.ala.liveroom.n;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.an;
import com.baidu.live.data.bj;
import com.baidu.live.data.x;
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
import com.baidu.tieba.ala.liveroom.n.a;
import com.baidu.tieba.ala.liveroom.n.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener bql;
    private long bvY;
    private a hEN;
    private String hEO;
    private String hEP;
    private boolean hEQ;
    private boolean hER;
    private c hES;
    private com.baidu.tieba.ala.liveroom.n.a hEV;
    private d hEW;
    private CustomMessageListener hEX;
    private an hEY;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hET = true;
    private boolean hEU = false;

    /* loaded from: classes11.dex */
    public interface a {
        boolean ceJ();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        OG();
    }

    public void a(a aVar) {
        this.hEN = aVar;
    }

    public void c(x xVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (xVar != null && (alaLiveInfoData = xVar.mLiveInfo) != null && (alaLiveUserInfoData = xVar.aKu) != null) {
            this.bvY = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hEO = alaLiveUserInfoData.portrait;
            this.hEP = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hEQ = false;
            this.hER = false;
            this.hEY = com.baidu.live.af.a.SE().bwi;
            OF();
            RM();
            registerListener();
            ciK();
            ciL();
        }
    }

    private void registerListener() {
        this.hEX = new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.n.b.1
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
                    com.baidu.live.view.a.Zx().b(String.valueOf(l), fVar);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hEX);
    }

    public void ok(boolean z) {
        this.hET = z;
    }

    public void ol(boolean z) {
        this.hEU = z;
    }

    public boolean TQ() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hER && TbadkCoreApplication.isLogin() && this.hEN != null && !this.hEN.ceJ()) {
            ciQ();
            return true;
        }
        return false;
    }

    private void LE() {
        this.mUid = -1L;
        this.hEQ = false;
        this.hER = false;
        If();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        RO();
    }

    public void onDestroy() {
        LE();
    }

    private void OG() {
        this.hES = new c();
        String string = com.baidu.live.d.Ba().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.hES.hFa = jSONObject.optBoolean("hasShowMax");
                    if (!this.hES.hFa) {
                        this.hES.date = b2;
                        this.hES.bsA = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void OF() {
        if (this.hES == null) {
            this.hES = new c();
        }
        String str = this.hES.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hES.hFa = false;
            this.hES.bsA = 0;
        }
    }

    private void RM() {
        if (this.bql == null) {
            this.bql = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.b.2
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
            MessageManager.getInstance().registerListener(this.bql);
        }
    }

    private void RO() {
        if (this.bql != null) {
            MessageManager.getInstance().unRegisterListener(this.bql);
        }
        if (this.hEX != null) {
            MessageManager.getInstance().unRegisterListener(this.hEX);
        }
    }

    private void ciK() {
        bj bjVar;
        int i;
        if (!this.hEQ && TbadkCoreApplication.isLogin() && !this.hES.hFa && this.hEY != null && (bjVar = this.hEY.aOM) != null) {
            if ((!k.b(new Date()).equals(this.hES.date) || this.hES.bsA < bjVar.aRh) && (i = bjVar.aRg) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bvY, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.om(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void ciL() {
        bj bjVar;
        int i;
        if (this.hEY != null && (bjVar = this.hEY.aOM) != null && (i = bjVar.aRi) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bvY, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.ciP();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hET && !this.hEU && !this.hES.hFa && this.hEN != null && !this.hEN.ceJ()) {
            ciM();
        }
    }

    private void ciM() {
        this.hEQ = true;
        ciN();
        ciO();
    }

    private void ciN() {
        if (this.hEV == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hEV = new e(this.mPageContext.getPageActivity());
            } else {
                this.hEV = new f(this.mPageContext.getPageActivity());
            }
            this.hEV.a(new a.InterfaceC0686a() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0686a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.bvY), b.this.hEV.ciJ(), b.this.mOtherParams);
                    b.this.on(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hEV.ez(this.hEO, this.hEP);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void ciO() {
        bj bjVar;
        String b2 = k.b(new Date());
        if (b2.equals(this.hES.date)) {
            this.hES.bsA++;
        } else {
            this.hES.date = b2;
            this.hES.bsA = 1;
        }
        if (com.baidu.live.af.a.SE().bwi != null && (bjVar = com.baidu.live.af.a.SE().bwi.aOM) != null) {
            if (this.hES.bsA >= bjVar.aRh) {
                this.hES.hFa = true;
            }
            com.baidu.live.d.Ba().putString("guide_follow_float_times_date", this.hES.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        this.hER = true;
    }

    private void ciQ() {
        if (this.hEW == null) {
            this.hEW = new d(this.mPageContext.getPageActivity());
            this.hEW.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.b.6
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.bvY), b.this.hEW.ciJ(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    b.this.on(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hEW.GB(this.hEO);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(boolean z) {
        If();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.hER = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hEO);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Zx().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hEN != null) {
            this.hEN.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hER = false;
        If();
        if (this.hEN != null) {
            this.hEN.onClose();
        }
    }

    public void If() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hEV != null) {
                this.hEV.dismiss();
                this.hEV = null;
            }
            if (this.hEW != null) {
                this.hEW.dismiss();
                this.hEW = null;
            }
        }
    }

    public void bnO() {
        if (this.hEV != null && this.hEV.isShowing()) {
            this.hEV.ciI();
        }
        if (this.hEW != null && this.hEW.isShowing()) {
            this.hEW.ciI();
        }
    }
}
