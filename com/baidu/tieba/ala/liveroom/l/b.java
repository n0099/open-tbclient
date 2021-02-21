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
    private a hEF;
    private String hEG;
    private String hEH;
    private boolean hEI;
    private boolean hEJ;
    private c hEK;
    private com.baidu.tieba.ala.liveroom.l.a hEN;
    private d hEO;
    private CustomMessageListener hEP;
    private ar hEQ;
    private int mOrientation;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hEL = true;
    private boolean hEM = false;

    /* loaded from: classes11.dex */
    public interface a {
        boolean cbT();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mj();
    }

    public void a(a aVar) {
        this.hEF = aVar;
    }

    public void c(ab abVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (abVar != null && (alaLiveInfoData = abVar.mLiveInfo) != null && (alaLiveUserInfoData = abVar.aId) != null) {
            this.buN = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hEG = alaLiveUserInfoData.portrait;
            this.hEH = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hEI = false;
            this.hEJ = false;
            this.hEQ = com.baidu.live.ae.a.Qj().buX;
            Mi();
            Pq();
            registerListener();
            cfT();
            cfU();
        }
    }

    private void registerListener() {
        this.hEP = new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.l.b.1
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
        MessageManager.getInstance().registerListener(this.hEP);
    }

    public void oq(boolean z) {
        this.hEL = z;
    }

    public void or(boolean z) {
        this.hEM = z;
    }

    public boolean RF() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hEJ && TbadkCoreApplication.isLogin() && this.hEF != null && !this.hEF.cbT()) {
            cfZ();
            return true;
        }
        return false;
    }

    private void IZ() {
        this.mUid = -1L;
        this.hEI = false;
        this.hEJ = false;
        FA();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Ps();
    }

    public void onDestroy() {
        IZ();
    }

    private void Mj() {
        this.hEK = new c();
        String string = com.baidu.live.d.xc().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.hEK.hES = jSONObject.optBoolean("hasShowMax");
                    if (!this.hEK.hES) {
                        this.hEK.date = b2;
                        this.hEK.brp = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Mi() {
        if (this.hEK == null) {
            this.hEK = new c();
        }
        String str = this.hEK.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hEK.hES = false;
            this.hEK.brp = 0;
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
        if (this.hEP != null) {
            MessageManager.getInstance().unRegisterListener(this.hEP);
        }
    }

    private void cfT() {
        bo boVar;
        int i;
        if (!this.hEI && TbadkCoreApplication.isLogin() && !this.hEK.hES && this.hEQ != null && (boVar = this.hEQ.aMM) != null) {
            if ((!k.b(new Date()).equals(this.hEK.date) || this.hEK.brp < boVar.aPs) && (i = boVar.aPr) > 0) {
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

    private void cfU() {
        bo boVar;
        int i;
        if (this.hEQ != null && (boVar = this.hEQ.aMM) != null && (i = boVar.aPt) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.buN, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cfY();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hEL && !this.hEM && !this.hEK.hES && this.hEF != null && !this.hEF.cbT()) {
            cfV();
        }
    }

    private void cfV() {
        this.hEI = true;
        cfW();
        cfX();
    }

    private void cfW() {
        this.mOrientation = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity());
        if (this.hEN == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hEN = new e(this.mPageContext.getPageActivity());
            } else {
                this.hEN = new f(this.mPageContext.getPageActivity());
            }
            this.hEN.a(new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0668a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.buN), b.this.hEN.cfS(), b.this.mOtherParams);
                    b.this.ot(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hEN.ex(this.hEG, this.hEH);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    private void cfX() {
        bo boVar;
        String b2 = k.b(new Date());
        if (b2.equals(this.hEK.date)) {
            this.hEK.brp++;
        } else {
            this.hEK.date = b2;
            this.hEK.brp = 1;
        }
        if (com.baidu.live.ae.a.Qj().buX != null && (boVar = com.baidu.live.ae.a.Qj().buX.aMM) != null) {
            if (this.hEK.brp >= boVar.aPs) {
                this.hEK.hES = true;
            }
            com.baidu.live.d.xc().putString("guide_follow_float_times_date", this.hEK.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfY() {
        this.hEJ = true;
    }

    private void cfZ() {
        if (this.hEO == null) {
            this.hEO = new d(this.mPageContext.getPageActivity());
            this.hEO.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.l.b.6
                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.buN), b.this.hEO.cfS(), b.this.mOtherParams);
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
            this.hEO.FO(this.hEG);
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
            this.hEJ = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hEG);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Xo().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hEF != null) {
            this.hEF.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hEJ = false;
        FA();
        if (this.hEF != null) {
            this.hEF.onClose();
        }
    }

    public void FA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hEN != null) {
                this.hEN.dismiss();
                this.hEN = null;
            }
            if (this.hEO != null) {
                this.hEO.dismiss();
                this.hEO = null;
            }
        }
    }

    public void cK(int i) {
        if (this.hEN != null && this.hEN.isShowing()) {
            if (this.mOrientation == i) {
                this.hEN.cfR();
            } else {
                this.hEN.dismiss();
                this.hEN = null;
                cfW();
            }
        }
        if (this.hEO != null && this.hEO.isShowing()) {
            this.hEO.cfR();
        }
    }
}
