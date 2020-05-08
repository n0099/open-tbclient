package com.baidu.tieba.ala.liveroom.k;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.n;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.k.c;
import com.baidu.tieba.ala.liveroom.k.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private CustomMessageListener aMR;
    private long aQm;
    private boolean fHA;
    private b fHB;
    private c fHE;
    private d fHF;
    private InterfaceC0517a fHy;
    private String fHz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fHC = true;
    private boolean fHD = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0517a {
        boolean bti();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bvY();
    }

    public void a(InterfaceC0517a interfaceC0517a) {
        this.fHy = interfaceC0517a;
    }

    public void c(n nVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (nVar != null && (alaLiveInfoData = nVar.mLiveInfo) != null && (alaLiveUserInfoData = nVar.aqk) != null) {
            this.aQm = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fHz = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fHA = false;
            this.mPopShow = false;
            bvZ();
            BY();
            bwa();
            bwb();
        }
    }

    public void kv(boolean z) {
        this.fHC = z;
    }

    public void kw(boolean z) {
        this.fHD = z;
    }

    public boolean bvW() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fHy != null && !this.fHy.bti()) {
            bwg();
            return true;
        }
        return false;
    }

    private void bvX() {
        this.mUid = -1L;
        this.fHA = false;
        this.mPopShow = false;
        xk();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Ca();
    }

    public void onDestroy() {
        bvX();
    }

    private void bvY() {
        this.fHB = new b();
        String string = com.baidu.live.c.tG().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fHB.fHH = jSONObject.optBoolean("hasShowMax");
                    if (!this.fHB.fHH) {
                        this.fHB.date = b;
                        this.fHB.flN = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bvZ() {
        if (this.fHB == null) {
            this.fHB = new b();
        }
        String str = this.fHB.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fHB.fHH = false;
            this.fHB.flN = 0;
        }
    }

    private void BY() {
        if (this.aMR == null) {
            this.aMR = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        a.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aMR);
        }
    }

    private void Ca() {
        if (this.aMR != null) {
            MessageManager.getInstance().unRegisterListener(this.aMR);
        }
    }

    private void bwa() {
        v vVar;
        int i;
        if (!this.fHA && !this.fHB.fHH && (vVar = com.baidu.live.v.a.En().aQu) != null) {
            if ((!j.b(new Date()).equals(this.fHB.date) || this.fHB.flN < vVar.atk) && (i = vVar.atj) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aQm, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.kx(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bwb() {
        int i;
        v vVar = com.baidu.live.v.a.En().aQu;
        if (vVar != null && (i = vVar.atl) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aQm, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bwf();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fHC && !this.fHD && !this.fHB.fHH && this.fHy != null && !this.fHy.bti()) {
            bwc();
        }
    }

    private void bwc() {
        this.fHA = true;
        bwd();
        bwe();
    }

    private void bwd() {
        if (this.fHE == null) {
            this.fHE = new c(this.mPageContext.getPageActivity());
            this.fHE.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aQm), a.this.fHE.bwh(), a.this.mOtherParams);
                    a.this.ky(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fHE.show(this.fHz);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bwe() {
        String b = j.b(new Date());
        if (b.equals(this.fHB.date)) {
            this.fHB.flN++;
        } else {
            this.fHB.date = b;
            this.fHB.flN = 1;
        }
        if (this.fHB.flN >= com.baidu.live.v.a.En().aQu.atk) {
            this.fHB.fHH = true;
        }
        com.baidu.live.c.tG().putString("guide_follow_float_times_date", this.fHB.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwf() {
        this.mPopShow = true;
    }

    private void bwg() {
        if (this.fHF == null) {
            this.fHF = new d(this.mPageContext.getPageActivity());
            this.fHF.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aQm), a.this.fHF.bwh(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    a.this.ky(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fHF.show(this.fHz);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(boolean z) {
        xk();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.b bVar = new com.baidu.live.data.b();
            bVar.setUserId(String.valueOf(this.mUid));
            bVar.setPortrait(this.fHz);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            bVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Hs().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fHy != null) {
            this.fHy.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        xk();
        if (this.fHy != null) {
            this.fHy.onClose();
        }
    }

    public void xk() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fHE != null) {
                this.fHE.dismiss();
                this.fHE = null;
            }
            if (this.fHF != null) {
                this.fHF.dismiss();
                this.fHF = null;
            }
        }
    }

    public void aHo() {
        if (this.fHE != null && this.fHE.isShowing()) {
            this.fHE.bwi();
        }
        if (this.fHF != null && this.fHF.isShowing()) {
            this.fHF.bwi();
        }
    }
}
