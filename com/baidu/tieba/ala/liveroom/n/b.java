package com.baidu.tieba.ala.liveroom.n;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.al;
import com.baidu.live.data.bh;
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
import com.baidu.tieba.ala.liveroom.n.a;
import com.baidu.tieba.ala.liveroom.n.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener boC;
    private long brr;
    private a hsS;
    private String hsT;
    private String hsU;
    private boolean hsV;
    private boolean hsW;
    private c hsX;
    private com.baidu.tieba.ala.liveroom.n.a hta;
    private d htb;
    private al htc;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hsY = true;
    private boolean hsZ = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean cca();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cfU();
    }

    public void a(a aVar) {
        this.hsS = aVar;
    }

    public void c(w wVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (wVar != null && (alaLiveInfoData = wVar.mLiveInfo) != null && (alaLiveUserInfoData = wVar.aJV) != null) {
            this.brr = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hsT = alaLiveUserInfoData.portrait;
            this.hsU = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hsV = false;
            this.hsW = false;
            this.htc = com.baidu.live.ae.a.RB().brA;
            cfV();
            QI();
            registerListener();
            cfW();
            cfX();
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.n.b.1
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
                    com.baidu.live.view.a.Yo().b(String.valueOf(l), fVar);
                }
            }
        });
    }

    public void nK(boolean z) {
        this.hsY = z;
    }

    public void nL(boolean z) {
        this.hsZ = z;
    }

    public boolean SL() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hsW && TbadkCoreApplication.isLogin() && this.hsS != null && !this.hsS.cca()) {
            cgc();
            return true;
        }
        return false;
    }

    private void Mg() {
        this.mUid = -1L;
        this.hsV = false;
        this.hsW = false;
        ID();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        QK();
    }

    public void onDestroy() {
        Mg();
    }

    private void cfU() {
        this.hsX = new c();
        String string = com.baidu.live.d.BM().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hsX.hte = jSONObject.optBoolean("hasShowMax");
                    if (!this.hsX.hte) {
                        this.hsX.date = b;
                        this.hsX.dMd = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cfV() {
        if (this.hsX == null) {
            this.hsX = new c();
        }
        String str = this.hsX.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hsX.hte = false;
            this.hsX.dMd = 0;
        }
    }

    private void QI() {
        if (this.boC == null) {
            this.boC = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.b.2
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
            MessageManager.getInstance().registerListener(this.boC);
        }
    }

    private void QK() {
        if (this.boC != null) {
            MessageManager.getInstance().unRegisterListener(this.boC);
        }
    }

    private void cfW() {
        bh bhVar;
        int i;
        if (!this.hsV && TbadkCoreApplication.isLogin() && !this.hsX.hte && this.htc != null && (bhVar = this.htc.aOf) != null) {
            if ((!k.b(new Date()).equals(this.hsX.date) || this.hsX.dMd < bhVar.aQs) && (i = bhVar.aQr) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.brr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.nM(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void cfX() {
        bh bhVar;
        int i;
        if (this.htc != null && (bhVar = this.htc.aOf) != null && (i = bhVar.aQt) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.brr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cgb();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hsY && !this.hsZ && !this.hsX.hte && this.hsS != null && !this.hsS.cca()) {
            cfY();
        }
    }

    private void cfY() {
        this.hsV = true;
        cfZ();
        cga();
    }

    private void cfZ() {
        if (this.hta == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hta = new e(this.mPageContext.getPageActivity());
            } else {
                this.hta = new f(this.mPageContext.getPageActivity());
            }
            this.hta.a(new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0694a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.brr), b.this.hta.cfT(), b.this.mOtherParams);
                    b.this.nN(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hta.eA(this.hsT, this.hsU);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void cga() {
        bh bhVar;
        String b = k.b(new Date());
        if (b.equals(this.hsX.date)) {
            this.hsX.dMd++;
        } else {
            this.hsX.date = b;
            this.hsX.dMd = 1;
        }
        if (com.baidu.live.ae.a.RB().brA != null && (bhVar = com.baidu.live.ae.a.RB().brA.aOf) != null) {
            if (this.hsX.dMd >= bhVar.aQs) {
                this.hsX.hte = true;
            }
            com.baidu.live.d.BM().putString("guide_follow_float_times_date", this.hsX.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        this.hsW = true;
    }

    private void cgc() {
        if (this.htb == null) {
            this.htb = new d(this.mPageContext.getPageActivity());
            this.htb.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.b.6
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.brr), b.this.htb.cfT(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    b.this.nN(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.htb.GD(this.hsT);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        ID();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.hsW = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hsT);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Yo().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hsS != null) {
            this.hsS.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hsW = false;
        ID();
        if (this.hsS != null) {
            this.hsS.onClose();
        }
    }

    public void ID() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hta != null) {
                this.hta.dismiss();
                this.hta = null;
            }
            if (this.htb != null) {
                this.htb.dismiss();
                this.htb = null;
            }
        }
    }

    public void blq() {
        if (this.hta != null && this.hta.isShowing()) {
            this.hta.cfS();
        }
        if (this.htb != null && this.htb.isShowing()) {
            this.htb.cfS();
        }
    }
}
