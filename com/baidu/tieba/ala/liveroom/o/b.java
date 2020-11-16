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
    private CustomMessageListener bjL;
    private long bmk;
    private com.baidu.tieba.ala.liveroom.o.a hjA;
    private d hjB;
    private ak hjC;
    private a hjt;
    private String hju;
    private String hjv;
    private boolean hjw;
    private c hjx;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean hjy = true;
    private boolean hjz = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean bYg();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ccb();
    }

    public void a(a aVar) {
        this.hjt = aVar;
    }

    public void c(w wVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (wVar != null && (alaLiveInfoData = wVar.mLiveInfo) != null && (alaLiveUserInfoData = wVar.aHk) != null) {
            this.bmk = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hju = alaLiveUserInfoData.portrait;
            this.hjv = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hjw = false;
            this.mPopShow = false;
            this.hjC = com.baidu.live.aa.a.Ph().bms;
            ccc();
            Op();
            registerListener();
            ccd();
            cce();
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
                    com.baidu.live.view.a.VO().b(String.valueOf(l), fVar);
                }
            }
        });
    }

    public void np(boolean z) {
        this.hjy = z;
    }

    public void nq(boolean z) {
        this.hjz = z;
    }

    public boolean Qn() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.hjt != null && !this.hjt.bYg()) {
            ccj();
            return true;
        }
        return false;
    }

    private void Ke() {
        this.mUid = -1L;
        this.hjw = false;
        this.mPopShow = false;
        GM();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Or();
    }

    public void onDestroy() {
        Ke();
    }

    private void ccb() {
        this.hjx = new c();
        String string = com.baidu.live.d.Aq().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hjx.hjE = jSONObject.optBoolean("hasShowMax");
                    if (!this.hjx.hjE) {
                        this.hjx.date = b;
                        this.hjx.dFf = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ccc() {
        if (this.hjx == null) {
            this.hjx = new c();
        }
        String str = this.hjx.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hjx.hjE = false;
            this.hjx.dFf = 0;
        }
    }

    private void Op() {
        if (this.bjL == null) {
            this.bjL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.b.2
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
            MessageManager.getInstance().registerListener(this.bjL);
        }
    }

    private void Or() {
        if (this.bjL != null) {
            MessageManager.getInstance().unRegisterListener(this.bjL);
        }
    }

    private void ccd() {
        bg bgVar;
        int i;
        if (!this.hjw && TbadkCoreApplication.isLogin() && !this.hjx.hjE && this.hjC != null && (bgVar = this.hjC.aLk) != null) {
            if ((!k.b(new Date()).equals(this.hjx.date) || this.hjx.dFf < bgVar.aNt) && (i = bgVar.aNs) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bmk, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.nr(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void cce() {
        bg bgVar;
        int i;
        if (this.hjC != null && (bgVar = this.hjC.aLk) != null && (i = bgVar.aNu) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bmk, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cci();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hjy && !this.hjz && !this.hjx.hjE && this.hjt != null && !this.hjt.bYg()) {
            ccf();
        }
    }

    private void ccf() {
        this.hjw = true;
        ccg();
        cch();
    }

    private void ccg() {
        if (this.hjA == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hjA = new e(this.mPageContext.getPageActivity());
            } else {
                this.hjA = new f(this.mPageContext.getPageActivity());
            }
            this.hjA.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0681a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.bmk), b.this.hjA.cca(), b.this.mOtherParams);
                    b.this.ns(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hjA.eu(this.hju, this.hjv);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void cch() {
        bg bgVar;
        String b = k.b(new Date());
        if (b.equals(this.hjx.date)) {
            this.hjx.dFf++;
        } else {
            this.hjx.date = b;
            this.hjx.dFf = 1;
        }
        if (com.baidu.live.aa.a.Ph().bms != null && (bgVar = com.baidu.live.aa.a.Ph().bms.aLk) != null) {
            if (this.hjx.dFf >= bgVar.aNt) {
                this.hjx.hjE = true;
            }
            com.baidu.live.d.Aq().putString("guide_follow_float_times_date", this.hjx.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        this.mPopShow = true;
    }

    private void ccj() {
        if (this.hjB == null) {
            this.hjB = new d(this.mPageContext.getPageActivity());
            this.hjB.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.bmk), b.this.hjB.cca(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    b.this.ns(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hjB.FO(this.hju);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(boolean z) {
        GM();
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
            fVar.setPortrait(this.hju);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.VO().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hjt != null) {
            this.hjt.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        GM();
        if (this.hjt != null) {
            this.hjt.onClose();
        }
    }

    public void GM() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hjA != null) {
                this.hjA.dismiss();
                this.hjA = null;
            }
            if (this.hjB != null) {
                this.hjB.dismiss();
                this.hjB = null;
            }
        }
    }

    public void big() {
        if (this.hjA != null && this.hjA.isShowing()) {
            this.hjA.cbZ();
        }
        if (this.hjB != null && this.hjB.isShowing()) {
            this.hjB.cbZ();
        }
    }
}
