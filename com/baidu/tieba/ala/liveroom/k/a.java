package com.baidu.tieba.ala.liveroom.k;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.i;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.tieba.ala.liveroom.k.c;
import com.baidu.tieba.ala.liveroom.k.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private CustomMessageListener ahD;
    private String aiq;
    private long ajM;
    private boolean dNi;
    private InterfaceC0363a ehq;
    private String ehr;
    private boolean ehs;
    private b eht;
    private c ehw;
    private d ehx;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private long mUid = -1;
    private boolean ehu = true;
    private boolean ehv = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0363a {
        boolean aPB();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aSk();
    }

    public void a(InterfaceC0363a interfaceC0363a) {
        this.ehq = interfaceC0363a;
    }

    public void a(i iVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (iVar != null && (alaLiveInfoData = iVar.mLiveInfo) != null && (alaLiveUserInfoData = iVar.Ps) != null) {
            this.ajM = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.ehr = alaLiveUserInfoData.portrait;
            this.aiq = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.ehs = false;
            this.dNi = false;
            aSl();
            aSm();
            aSo();
            aSp();
        }
    }

    public void hP(boolean z) {
        this.ehu = z;
    }

    public void hQ(boolean z) {
        this.ehv = z;
    }

    public boolean aSi() {
        if (!this.dNi || !TbadkCoreApplication.isLogin() || this.ehq == null || this.ehq.aPB()) {
            return false;
        }
        aSu();
        return true;
    }

    private void aSj() {
        this.mUid = -1L;
        this.ehs = false;
        this.dNi = false;
        aAm();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        aSn();
    }

    public void onDestroy() {
        aSj();
    }

    private void aSk() {
        this.eht = new b();
        String string = com.baidu.live.c.np().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = com.baidu.live.utils.i.b(new Date());
                if (optString.equals(b)) {
                    this.eht.ehz = jSONObject.optBoolean("hasShowMax");
                    if (!this.eht.ehz) {
                        this.eht.date = b;
                        this.eht.dNW = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void aSl() {
        if (this.eht == null) {
            this.eht = new b();
        }
        String str = this.eht.date;
        if (!TextUtils.isEmpty(str) && !str.equals(com.baidu.live.utils.i.b(new Date()))) {
            this.eht.ehz = false;
            this.eht.dNW = 0;
        }
    }

    private void aSm() {
        if (this.ahD == null) {
            this.ahD = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.ahD);
        }
    }

    private void aSn() {
        if (this.ahD != null) {
            MessageManager.getInstance().unRegisterListener(this.ahD);
        }
    }

    private void aSo() {
        o oVar;
        int i;
        if (!this.ehs && !this.eht.ehz && (oVar = com.baidu.live.l.a.uA().ajX) != null) {
            if ((!com.baidu.live.utils.i.b(new Date()).equals(this.eht.date) || this.eht.dNW < oVar.Sp) && (i = oVar.So) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.ajM, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.hR(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void aSp() {
        int i;
        o oVar = com.baidu.live.l.a.uA().ajX;
        if (oVar != null && (i = oVar.Sq) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.ajM, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.aSt();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(boolean z) {
        if (z && this.ehu && !this.ehv && !this.eht.ehz && this.ehq != null && !this.ehq.aPB()) {
            aSq();
        }
    }

    private void aSq() {
        this.ehs = true;
        aSr();
        aSs();
    }

    private void aSr() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            if (this.ehw == null) {
                this.ehw = new c(this.mPageContext.getPageActivity());
                this.ehw.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                    @Override // com.baidu.tieba.ala.liveroom.k.c.a
                    public void onConfirm() {
                        LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.aiq, String.valueOf(a.this.ajM), a.this.ehw.aSv(), a.this.mOtherParams);
                        a.this.hS(false);
                    }
                });
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.ehw.tD(this.ehr);
                LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.aiq, this.mOtherParams);
            }
        }
    }

    private void aSs() {
        String b = com.baidu.live.utils.i.b(new Date());
        if (b.equals(this.eht.date)) {
            this.eht.dNW++;
        } else {
            this.eht.date = b;
            this.eht.dNW = 1;
        }
        if (this.eht.dNW >= com.baidu.live.l.a.uA().ajX.Sp) {
            this.eht.ehz = true;
        }
        com.baidu.live.c.np().putString("guide_follow_float_times_date", this.eht.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        this.dNi = true;
    }

    private void aSu() {
        if (this.ehx == null) {
            this.ehx = new d(this.mPageContext.getPageActivity());
            this.ehx.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.aiq, String.valueOf(a.this.ajM), a.this.ehx.aSv(), a.this.mOtherParams);
                    a.this.hS(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.aiq, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.ehx.tD(this.ehr);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.aiq, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(boolean z) {
        aAm();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.dNi = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.b bVar = new com.baidu.live.data.b();
            bVar.setUserId(String.valueOf(this.mUid));
            bVar.setPortrait(this.ehr);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.wx().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if ((this.ehq != null) & z) {
            this.ehq.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.dNi = false;
        aAm();
        if (this.ehq != null) {
            this.ehq.onClose();
        }
    }

    public void aAm() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.ehw != null) {
                this.ehw.dismiss();
                this.ehw = null;
            }
            if (this.ehx != null) {
                this.ehx.dismiss();
                this.ehx = null;
            }
        }
    }

    public void afE() {
        if (this.ehw != null && this.ehw.isShowing()) {
            this.ehw.aSw();
        }
        if (this.ehx != null && this.ehx.isShowing()) {
            this.ehx.aSw();
        }
    }
}
