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
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener bqt;
    private long bwn;
    private a hGo;
    private String hGp;
    private String hGq;
    private boolean hGr;
    private boolean hGs;
    private c hGt;
    private com.baidu.tieba.ala.liveroom.l.a hGw;
    private d hGx;
    private CustomMessageListener hGy;
    private ar hGz;
    private int mOrientation;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hGu = true;
    private boolean hGv = false;

    /* loaded from: classes10.dex */
    public interface a {
        boolean cbZ();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mm();
    }

    public void a(a aVar) {
        this.hGo = aVar;
    }

    public void c(ab abVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (abVar != null && (alaLiveInfoData = abVar.mLiveInfo) != null && (alaLiveUserInfoData = abVar.aJD) != null) {
            this.bwn = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hGp = alaLiveUserInfoData.portrait;
            this.hGq = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hGr = false;
            this.hGs = false;
            this.hGz = com.baidu.live.ae.a.Qm().bwx;
            Ml();
            Pt();
            registerListener();
            cfZ();
            cga();
        }
    }

    private void registerListener() {
        this.hGy = new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.l.b.1
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
                    com.baidu.live.view.a.Xr().b(String.valueOf(l), fVar);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hGy);
    }

    public void oq(boolean z) {
        this.hGu = z;
    }

    public void or(boolean z) {
        this.hGv = z;
    }

    public boolean RI() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hGs && TbadkCoreApplication.isLogin() && this.hGo != null && !this.hGo.cbZ()) {
            cgf();
            return true;
        }
        return false;
    }

    private void Jc() {
        this.mUid = -1L;
        this.hGr = false;
        this.hGs = false;
        FD();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Pv();
    }

    public void onDestroy() {
        Jc();
    }

    private void Mm() {
        this.hGt = new c();
        String string = com.baidu.live.d.xf().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hGt.hGB = jSONObject.optBoolean("hasShowMax");
                    if (!this.hGt.hGB) {
                        this.hGt.date = b;
                        this.hGt.bsP = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Ml() {
        if (this.hGt == null) {
            this.hGt = new c();
        }
        String str = this.hGt.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hGt.hGB = false;
            this.hGt.bsP = 0;
        }
    }

    private void Pt() {
        if (this.bqt == null) {
            this.bqt = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.b.2
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
            MessageManager.getInstance().registerListener(this.bqt);
        }
    }

    private void Pv() {
        if (this.bqt != null) {
            MessageManager.getInstance().unRegisterListener(this.bqt);
        }
        if (this.hGy != null) {
            MessageManager.getInstance().unRegisterListener(this.hGy);
        }
    }

    private void cfZ() {
        bo boVar;
        int i;
        if (!this.hGr && TbadkCoreApplication.isLogin() && !this.hGt.hGB && this.hGz != null && (boVar = this.hGz.aOm) != null) {
            if ((!k.b(new Date()).equals(this.hGt.date) || this.hGt.bsP < boVar.aQS) && (i = boVar.aQR) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bwn, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.3
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

    private void cga() {
        bo boVar;
        int i;
        if (this.hGz != null && (boVar = this.hGz.aOm) != null && (i = boVar.aQT) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bwn, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cge();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hGu && !this.hGv && !this.hGt.hGB && this.hGo != null && !this.hGo.cbZ()) {
            cgb();
        }
    }

    private void cgb() {
        this.hGr = true;
        cgc();
        cgd();
    }

    private void cgc() {
        this.mOrientation = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity());
        if (this.hGw == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hGw = new e(this.mPageContext.getPageActivity());
            } else {
                this.hGw = new f(this.mPageContext.getPageActivity());
            }
            this.hGw.a(new a.InterfaceC0674a() { // from class: com.baidu.tieba.ala.liveroom.l.b.5
                @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0674a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.bwn), b.this.hGw.cfY(), b.this.mOtherParams);
                    b.this.ot(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hGw.ex(this.hGp, this.hGq);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    private void cgd() {
        bo boVar;
        String b = k.b(new Date());
        if (b.equals(this.hGt.date)) {
            this.hGt.bsP++;
        } else {
            this.hGt.date = b;
            this.hGt.bsP = 1;
        }
        if (com.baidu.live.ae.a.Qm().bwx != null && (boVar = com.baidu.live.ae.a.Qm().bwx.aOm) != null) {
            if (this.hGt.bsP >= boVar.aQS) {
                this.hGt.hGB = true;
            }
            com.baidu.live.d.xf().putString("guide_follow_float_times_date", this.hGt.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cge() {
        this.hGs = true;
    }

    private void cgf() {
        if (this.hGx == null) {
            this.hGx = new d(this.mPageContext.getPageActivity());
            this.hGx.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.l.b.6
                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.bwn), b.this.hGx.cfY(), b.this.mOtherParams);
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
            this.hGx.FX(this.hGp);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(boolean z) {
        FD();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.hGs = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hGp);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Xr().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hGo != null) {
            this.hGo.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hGs = false;
        FD();
        if (this.hGo != null) {
            this.hGo.onClose();
        }
    }

    public void FD() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hGw != null) {
                this.hGw.dismiss();
                this.hGw = null;
            }
            if (this.hGx != null) {
                this.hGx.dismiss();
                this.hGx = null;
            }
        }
    }

    public void cL(int i) {
        if (this.hGw != null && this.hGw.isShowing()) {
            if (this.mOrientation == i) {
                this.hGw.cfX();
            } else {
                this.hGw.dismiss();
                this.hGw = null;
                cgc();
            }
        }
        if (this.hGx != null && this.hGx.isShowing()) {
            this.hGx.cfX();
        }
    }
}
