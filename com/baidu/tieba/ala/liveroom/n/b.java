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
    private a hsQ;
    private String hsR;
    private String hsS;
    private boolean hsT;
    private boolean hsU;
    private c hsV;
    private com.baidu.tieba.ala.liveroom.n.a hsY;
    private d hsZ;
    private al hta;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hsW = true;
    private boolean hsX = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean cbZ();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cfT();
    }

    public void a(a aVar) {
        this.hsQ = aVar;
    }

    public void c(w wVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (wVar != null && (alaLiveInfoData = wVar.mLiveInfo) != null && (alaLiveUserInfoData = wVar.aJV) != null) {
            this.brr = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hsR = alaLiveUserInfoData.portrait;
            this.hsS = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hsT = false;
            this.hsU = false;
            this.hta = com.baidu.live.ae.a.RB().brA;
            cfU();
            QI();
            registerListener();
            cfV();
            cfW();
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
        this.hsW = z;
    }

    public void nL(boolean z) {
        this.hsX = z;
    }

    public boolean SL() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hsU && TbadkCoreApplication.isLogin() && this.hsQ != null && !this.hsQ.cbZ()) {
            cgb();
            return true;
        }
        return false;
    }

    private void Mg() {
        this.mUid = -1L;
        this.hsT = false;
        this.hsU = false;
        ID();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        QK();
    }

    public void onDestroy() {
        Mg();
    }

    private void cfT() {
        this.hsV = new c();
        String string = com.baidu.live.d.BM().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hsV.htc = jSONObject.optBoolean("hasShowMax");
                    if (!this.hsV.htc) {
                        this.hsV.date = b;
                        this.hsV.dMd = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cfU() {
        if (this.hsV == null) {
            this.hsV = new c();
        }
        String str = this.hsV.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hsV.htc = false;
            this.hsV.dMd = 0;
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

    private void cfV() {
        bh bhVar;
        int i;
        if (!this.hsT && TbadkCoreApplication.isLogin() && !this.hsV.htc && this.hta != null && (bhVar = this.hta.aOf) != null) {
            if ((!k.b(new Date()).equals(this.hsV.date) || this.hsV.dMd < bhVar.aQs) && (i = bhVar.aQr) > 0) {
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

    private void cfW() {
        bh bhVar;
        int i;
        if (this.hta != null && (bhVar = this.hta.aOf) != null && (i = bhVar.aQt) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.brr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cga();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hsW && !this.hsX && !this.hsV.htc && this.hsQ != null && !this.hsQ.cbZ()) {
            cfX();
        }
    }

    private void cfX() {
        this.hsT = true;
        cfY();
        cfZ();
    }

    private void cfY() {
        if (this.hsY == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hsY = new e(this.mPageContext.getPageActivity());
            } else {
                this.hsY = new f(this.mPageContext.getPageActivity());
            }
            this.hsY.a(new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0694a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.brr), b.this.hsY.cfS(), b.this.mOtherParams);
                    b.this.nN(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hsY.eA(this.hsR, this.hsS);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void cfZ() {
        bh bhVar;
        String b = k.b(new Date());
        if (b.equals(this.hsV.date)) {
            this.hsV.dMd++;
        } else {
            this.hsV.date = b;
            this.hsV.dMd = 1;
        }
        if (com.baidu.live.ae.a.RB().brA != null && (bhVar = com.baidu.live.ae.a.RB().brA.aOf) != null) {
            if (this.hsV.dMd >= bhVar.aQs) {
                this.hsV.htc = true;
            }
            com.baidu.live.d.BM().putString("guide_follow_float_times_date", this.hsV.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cga() {
        this.hsU = true;
    }

    private void cgb() {
        if (this.hsZ == null) {
            this.hsZ = new d(this.mPageContext.getPageActivity());
            this.hsZ.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.b.6
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.brr), b.this.hsZ.cfS(), b.this.mOtherParams);
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
            this.hsZ.GD(this.hsR);
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
            this.hsU = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hsR);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Yo().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hsQ != null) {
            this.hsQ.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hsU = false;
        ID();
        if (this.hsQ != null) {
            this.hsQ.onClose();
        }
    }

    public void ID() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hsY != null) {
                this.hsY.dismiss();
                this.hsY = null;
            }
            if (this.hsZ != null) {
                this.hsZ.dismiss();
                this.hsZ = null;
            }
        }
    }

    public void blq() {
        if (this.hsY != null && this.hsY.isShowing()) {
            this.hsY.cfR();
        }
        if (this.hsZ != null && this.hsZ.isShowing()) {
            this.hsZ.cfR();
        }
    }
}
