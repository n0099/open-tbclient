package com.baidu.tieba.ala.liveroom.k;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.k.c;
import com.baidu.tieba.ala.liveroom.k.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener apo;
    private long arv;
    private InterfaceC0447a eWL;
    private String eWM;
    private boolean eWN;
    private boolean eWO;
    private b eWP;
    private c eWS;
    private d eWT;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean eWQ = true;
    private boolean eWR = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0447a {
        boolean bhb();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bjV();
    }

    public void a(InterfaceC0447a interfaceC0447a) {
        this.eWL = interfaceC0447a;
    }

    public void a(k kVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (kVar != null && (alaLiveInfoData = kVar.mLiveInfo) != null && (alaLiveUserInfoData = kVar.VP) != null) {
            this.arv = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.eWM = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.eWN = false;
            this.eWO = false;
            bjW();
            bjX();
            bjZ();
            bka();
        }
    }

    public void jf(boolean z) {
        this.eWQ = z;
    }

    public void jg(boolean z) {
        this.eWR = z;
    }

    public boolean bjT() {
        if (!this.eWO || !TbadkCoreApplication.isLogin() || this.eWL == null || this.eWL.bhb()) {
            return false;
        }
        bkf();
        return true;
    }

    private void bjU() {
        this.mUid = -1L;
        this.eWN = false;
        this.eWO = false;
        wN();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        bjY();
    }

    public void onDestroy() {
        bjU();
    }

    private void bjV() {
        this.eWP = new b();
        String string = com.baidu.live.c.oI().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.eWP.eWV = jSONObject.optBoolean("hasShowMax");
                    if (!this.eWP.eWV) {
                        this.eWP.date = b;
                        this.eWP.eBn = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bjW() {
        if (this.eWP == null) {
            this.eWP = new b();
        }
        String str = this.eWP.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.eWP.eWV = false;
            this.eWP.eBn = 0;
        }
    }

    private void bjX() {
        if (this.apo == null) {
            this.apo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.apo);
        }
    }

    private void bjY() {
        if (this.apo != null) {
            MessageManager.getInstance().unRegisterListener(this.apo);
        }
    }

    private void bjZ() {
        q qVar;
        int i;
        if (!this.eWN && !this.eWP.eWV && (qVar = com.baidu.live.r.a.wA().arE) != null) {
            if ((!j.b(new Date()).equals(this.eWP.date) || this.eWP.eBn < qVar.YB) && (i = qVar.YA) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.arv, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.jh(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bka() {
        int i;
        q qVar = com.baidu.live.r.a.wA().arE;
        if (qVar != null && (i = qVar.YC) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.arv, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bke();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh(boolean z) {
        if (z && this.eWQ && !this.eWR && !this.eWP.eWV && this.eWL != null && !this.eWL.bhb()) {
            bkb();
        }
    }

    private void bkb() {
        this.eWN = true;
        bkc();
        bkd();
    }

    private void bkc() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            if (this.eWS == null) {
                this.eWS = new c(this.mPageContext.getPageActivity());
                this.eWS.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                    @Override // com.baidu.tieba.ala.liveroom.k.c.a
                    public void onConfirm() {
                        LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.arv), a.this.eWS.bkg(), a.this.mOtherParams);
                        a.this.ji(false);
                    }
                });
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.eWS.show(this.eWM);
                LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            }
        }
    }

    private void bkd() {
        String b = j.b(new Date());
        if (b.equals(this.eWP.date)) {
            this.eWP.eBn++;
        } else {
            this.eWP.date = b;
            this.eWP.eBn = 1;
        }
        if (this.eWP.eBn >= com.baidu.live.r.a.wA().arE.YB) {
            this.eWP.eWV = true;
        }
        com.baidu.live.c.oI().putString("guide_follow_float_times_date", this.eWP.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bke() {
        this.eWO = true;
    }

    private void bkf() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            if (this.eWT == null) {
                this.eWT = new d(this.mPageContext.getPageActivity());
                this.eWT.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                    @Override // com.baidu.tieba.ala.liveroom.k.d.a
                    public void onConfirm() {
                        LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.arv), a.this.eWT.bkg(), a.this.mOtherParams);
                        a.this.ji(true);
                    }

                    @Override // com.baidu.tieba.ala.liveroom.k.d.a
                    public void onCancel() {
                        LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                        a.this.close();
                    }
                });
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.eWT.show(this.eWM);
                LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(boolean z) {
        wN();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.eWO = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.b bVar = new com.baidu.live.data.b();
            bVar.setUserId(String.valueOf(this.mUid));
            bVar.setPortrait(this.eWM);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.yy().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.eWL != null) {
            this.eWL.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.eWO = false;
        wN();
        if (this.eWL != null) {
            this.eWL.onClose();
        }
    }

    public void wN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.eWS != null) {
                this.eWS.dismiss();
                this.eWS = null;
            }
            if (this.eWT != null) {
                this.eWT.dismiss();
                this.eWT = null;
            }
        }
    }

    public void awu() {
        if (this.eWS != null && this.eWS.isShowing()) {
            this.eWS.bkh();
        }
        if (this.eWT != null && this.eWT.isShowing()) {
            this.eWT.bkh();
        }
    }
}
