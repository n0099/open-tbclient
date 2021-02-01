package com.baidu.tieba.ala.liveroom.l;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.data.bo;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.l.a;
import com.baidu.tieba.ala.liveroom.l.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener boT;
    private long buN;
    private d hEA;
    private CustomMessageListener hEB;
    private ar hEC;
    private a hEr;
    private String hEs;
    private String hEt;
    private boolean hEu;
    private boolean hEv;
    private c hEw;
    private com.baidu.tieba.ala.liveroom.l.a hEz;
    private int mOrientation;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hEx = true;
    private boolean hEy = false;

    /* loaded from: classes11.dex */
    public interface a {
        boolean cbM();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mj();
    }

    public void a(a aVar) {
        this.hEr = aVar;
    }

    public void c(ab abVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (abVar != null && (alaLiveInfoData = abVar.mLiveInfo) != null && (alaLiveUserInfoData = abVar.aId) != null) {
            this.buN = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hEs = alaLiveUserInfoData.portrait;
            this.hEt = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hEu = false;
            this.hEv = false;
            this.hEC = com.baidu.live.ae.a.Qj().buX;
            Mi();
            Pq();
            registerListener();
            cfM();
            cfN();
        }
    }

    private void registerListener() {
        this.hEB = new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.l.b.1
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
                    com.baidu.live.view.a.Xo().b(String.valueOf(l), fVar);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hEB);
    }

    public void oq(boolean z) {
        this.hEx = z;
    }

    public void or(boolean z) {
        this.hEy = z;
    }

    public boolean RF() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hEv && TbadkCoreApplication.isLogin() && this.hEr != null && !this.hEr.cbM()) {
            cfS();
            return true;
        }
        return false;
    }

    private void IZ() {
        this.mUid = -1L;
        this.hEu = false;
        this.hEv = false;
        FA();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Ps();
    }

    public void onDestroy() {
        IZ();
    }

    private void Mj() {
        this.hEw = new c();
        String string = com.baidu.live.d.xc().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.hEw.hEE = jSONObject.optBoolean("hasShowMax");
                    if (!this.hEw.hEE) {
                        this.hEw.date = b2;
                        this.hEw.brp = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Mi() {
        if (this.hEw == null) {
            this.hEw = new c();
        }
        String str = this.hEw.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hEw.hEE = false;
            this.hEw.brp = 0;
        }
    }

    private void Pq() {
        if (this.boT == null) {
            this.boT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.b.2
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
            MessageManager.getInstance().registerListener(this.boT);
        }
    }

    private void Ps() {
        if (this.boT != null) {
            MessageManager.getInstance().unRegisterListener(this.boT);
        }
        if (this.hEB != null) {
            MessageManager.getInstance().unRegisterListener(this.hEB);
        }
    }

    private void cfM() {
        bo boVar;
        int i;
        if (!this.hEu && TbadkCoreApplication.isLogin() && !this.hEw.hEE && this.hEC != null && (boVar = this.hEC.aMM) != null) {
            if ((!k.b(new Date()).equals(this.hEw.date) || this.hEw.brp < boVar.aPs) && (i = boVar.aPr) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.buN, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.os(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void cfN() {
        bo boVar;
        int i;
        if (this.hEC != null && (boVar = this.hEC.aMM) != null && (i = boVar.aPt) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.buN, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cfR();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hEx && !this.hEy && !this.hEw.hEE && this.hEr != null && !this.hEr.cbM()) {
            cfO();
        }
    }

    private void cfO() {
        this.hEu = true;
        cfP();
        cfQ();
    }

    private void cfP() {
        this.mOrientation = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity());
        if (this.hEz == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hEz = new e(this.mPageContext.getPageActivity());
            } else {
                this.hEz = new f(this.mPageContext.getPageActivity());
            }
            this.hEz.a(new a.InterfaceC0667a() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0667a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.buN), b.this.hEz.cfL(), b.this.mOtherParams);
                    b.this.ot(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hEz.ex(this.hEs, this.hEt);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    private void cfQ() {
        bo boVar;
        String b2 = k.b(new Date());
        if (b2.equals(this.hEw.date)) {
            this.hEw.brp++;
        } else {
            this.hEw.date = b2;
            this.hEw.brp = 1;
        }
        if (com.baidu.live.ae.a.Qj().buX != null && (boVar = com.baidu.live.ae.a.Qj().buX.aMM) != null) {
            if (this.hEw.brp >= boVar.aPs) {
                this.hEw.hEE = true;
            }
            com.baidu.live.d.xc().putString("guide_follow_float_times_date", this.hEw.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfR() {
        this.hEv = true;
    }

    private void cfS() {
        if (this.hEA == null) {
            this.hEA = new d(this.mPageContext.getPageActivity());
            this.hEA.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.l.b.6
                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.buN), b.this.hEA.cfL(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    b.this.ot(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hEA.FN(this.hEs);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(boolean z) {
        FA();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.hEv = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hEs);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Xo().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hEr != null) {
            this.hEr.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hEv = false;
        FA();
        if (this.hEr != null) {
            this.hEr.onClose();
        }
    }

    public void FA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hEz != null) {
                this.hEz.dismiss();
                this.hEz = null;
            }
            if (this.hEA != null) {
                this.hEA.dismiss();
                this.hEA = null;
            }
        }
    }

    public void cK(int i) {
        if (this.hEz != null && this.hEz.isShowing()) {
            if (this.mOrientation == i) {
                this.hEz.cfK();
            } else {
                this.hEz.dismiss();
                this.hEz = null;
                cfP();
            }
        }
        if (this.hEA != null && this.hEA.isShowing()) {
            this.hEA.cfK();
        }
    }
}
