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
    private CustomMessageListener aML;
    private long aQg;
    private d fHA;
    private InterfaceC0496a fHt;
    private String fHu;
    private boolean fHv;
    private b fHw;
    private c fHz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fHx = true;
    private boolean fHy = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0496a {
        boolean btk();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bwa();
    }

    public void a(InterfaceC0496a interfaceC0496a) {
        this.fHt = interfaceC0496a;
    }

    public void c(n nVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (nVar != null && (alaLiveInfoData = nVar.mLiveInfo) != null && (alaLiveUserInfoData = nVar.aqe) != null) {
            this.aQg = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fHu = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fHv = false;
            this.mPopShow = false;
            bwb();
            BZ();
            bwc();
            bwd();
        }
    }

    public void kv(boolean z) {
        this.fHx = z;
    }

    public void kw(boolean z) {
        this.fHy = z;
    }

    public boolean bvY() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fHt != null && !this.fHt.btk()) {
            bwi();
            return true;
        }
        return false;
    }

    private void bvZ() {
        this.mUid = -1L;
        this.fHv = false;
        this.mPopShow = false;
        xl();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Cb();
    }

    public void onDestroy() {
        bvZ();
    }

    private void bwa() {
        this.fHw = new b();
        String string = com.baidu.live.c.tH().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fHw.fHC = jSONObject.optBoolean("hasShowMax");
                    if (!this.fHw.fHC) {
                        this.fHw.date = b;
                        this.fHw.flI = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bwb() {
        if (this.fHw == null) {
            this.fHw = new b();
        }
        String str = this.fHw.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fHw.fHC = false;
            this.fHw.flI = 0;
        }
    }

    private void BZ() {
        if (this.aML == null) {
            this.aML = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.aML);
        }
    }

    private void Cb() {
        if (this.aML != null) {
            MessageManager.getInstance().unRegisterListener(this.aML);
        }
    }

    private void bwc() {
        v vVar;
        int i;
        if (!this.fHv && !this.fHw.fHC && (vVar = com.baidu.live.v.a.Eo().aQp) != null) {
            if ((!j.b(new Date()).equals(this.fHw.date) || this.fHw.flI < vVar.ate) && (i = vVar.atd) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aQg, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
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

    private void bwd() {
        int i;
        v vVar = com.baidu.live.v.a.Eo().aQp;
        if (vVar != null && (i = vVar.atf) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aQg, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bwh();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fHx && !this.fHy && !this.fHw.fHC && this.fHt != null && !this.fHt.btk()) {
            bwe();
        }
    }

    private void bwe() {
        this.fHv = true;
        bwf();
        bwg();
    }

    private void bwf() {
        if (this.fHz == null) {
            this.fHz = new c(this.mPageContext.getPageActivity());
            this.fHz.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aQg), a.this.fHz.bwj(), a.this.mOtherParams);
                    a.this.ky(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fHz.show(this.fHu);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bwg() {
        String b = j.b(new Date());
        if (b.equals(this.fHw.date)) {
            this.fHw.flI++;
        } else {
            this.fHw.date = b;
            this.fHw.flI = 1;
        }
        if (this.fHw.flI >= com.baidu.live.v.a.Eo().aQp.ate) {
            this.fHw.fHC = true;
        }
        com.baidu.live.c.tH().putString("guide_follow_float_times_date", this.fHw.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwh() {
        this.mPopShow = true;
    }

    private void bwi() {
        if (this.fHA == null) {
            this.fHA = new d(this.mPageContext.getPageActivity());
            this.fHA.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aQg), a.this.fHA.bwj(), a.this.mOtherParams);
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
            this.fHA.show(this.fHu);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(boolean z) {
        xl();
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
            bVar.setPortrait(this.fHu);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            bVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Ht().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fHt != null) {
            this.fHt.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        xl();
        if (this.fHt != null) {
            this.fHt.onClose();
        }
    }

    public void xl() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fHz != null) {
                this.fHz.dismiss();
                this.fHz = null;
            }
            if (this.fHA != null) {
                this.fHA.dismiss();
                this.fHA = null;
            }
        }
    }

    public void aHq() {
        if (this.fHz != null && this.fHz.isShowing()) {
            this.fHz.bwk();
        }
        if (this.fHA != null && this.fHA.isShowing()) {
            this.fHA.bwk();
        }
    }
}
