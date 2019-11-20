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
    private String ahX;
    private CustomMessageListener ahl;
    private long aju;
    private boolean dMr;
    private String egA;
    private boolean egB;
    private b egC;
    private c egF;
    private d egG;
    private InterfaceC0363a egz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private long mUid = -1;
    private boolean egD = true;
    private boolean egE = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0363a {
        boolean aPz();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aSi();
    }

    public void a(InterfaceC0363a interfaceC0363a) {
        this.egz = interfaceC0363a;
    }

    public void a(i iVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (iVar != null && (alaLiveInfoData = iVar.mLiveInfo) != null && (alaLiveUserInfoData = iVar.OR) != null) {
            this.aju = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.egA = alaLiveUserInfoData.portrait;
            this.ahX = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.egB = false;
            this.dMr = false;
            aSj();
            aSk();
            aSm();
            aSn();
        }
    }

    public void hP(boolean z) {
        this.egD = z;
    }

    public void hQ(boolean z) {
        this.egE = z;
    }

    public boolean aSg() {
        if (!this.dMr || !TbadkCoreApplication.isLogin() || this.egz == null || this.egz.aPz()) {
            return false;
        }
        aSs();
        return true;
    }

    private void aSh() {
        this.mUid = -1L;
        this.egB = false;
        this.dMr = false;
        aAk();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        aSl();
    }

    public void onDestroy() {
        aSh();
    }

    private void aSi() {
        this.egC = new b();
        String string = com.baidu.live.c.np().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = com.baidu.live.utils.i.b(new Date());
                if (optString.equals(b)) {
                    this.egC.egI = jSONObject.optBoolean("hasShowMax");
                    if (!this.egC.egI) {
                        this.egC.date = b;
                        this.egC.dNf = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void aSj() {
        if (this.egC == null) {
            this.egC = new b();
        }
        String str = this.egC.date;
        if (!TextUtils.isEmpty(str) && !str.equals(com.baidu.live.utils.i.b(new Date()))) {
            this.egC.egI = false;
            this.egC.dNf = 0;
        }
    }

    private void aSk() {
        if (this.ahl == null) {
            this.ahl = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.ahl);
        }
    }

    private void aSl() {
        if (this.ahl != null) {
            MessageManager.getInstance().unRegisterListener(this.ahl);
        }
    }

    private void aSm() {
        o oVar;
        int i;
        if (!this.egB && !this.egC.egI && (oVar = com.baidu.live.l.a.uB().ajF) != null) {
            if ((!com.baidu.live.utils.i.b(new Date()).equals(this.egC.date) || this.egC.dNf < oVar.RO) && (i = oVar.RL) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aju, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
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

    private void aSn() {
        int i;
        o oVar = com.baidu.live.l.a.uB().ajF;
        if (oVar != null && (i = oVar.RP) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aju, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.aSr();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(boolean z) {
        if (z && this.egD && !this.egE && !this.egC.egI && this.egz != null && !this.egz.aPz()) {
            aSo();
        }
    }

    private void aSo() {
        this.egB = true;
        aSp();
        aSq();
    }

    private void aSp() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) {
            if (this.egF == null) {
                this.egF = new c(this.mPageContext.getPageActivity());
                this.egF.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                    @Override // com.baidu.tieba.ala.liveroom.k.c.a
                    public void onConfirm() {
                        LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.ahX, String.valueOf(a.this.aju), a.this.egF.aSt(), a.this.mOtherParams);
                        a.this.hS(false);
                    }
                });
            }
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.egF.tD(this.egA);
                LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.ahX, this.mOtherParams);
            }
        }
    }

    private void aSq() {
        String b = com.baidu.live.utils.i.b(new Date());
        if (b.equals(this.egC.date)) {
            this.egC.dNf++;
        } else {
            this.egC.date = b;
            this.egC.dNf = 1;
        }
        if (this.egC.dNf >= com.baidu.live.l.a.uB().ajF.RO) {
            this.egC.egI = true;
        }
        com.baidu.live.c.np().putString("guide_follow_float_times_date", this.egC.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSr() {
        this.dMr = true;
    }

    private void aSs() {
        if (this.egG == null) {
            this.egG = new d(this.mPageContext.getPageActivity());
            this.egG.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.ahX, String.valueOf(a.this.aju), a.this.egG.aSt(), a.this.mOtherParams);
                    a.this.hS(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.ahX, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.egG.tD(this.egA);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.ahX, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(boolean z) {
        aAk();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.dMr = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.b bVar = new com.baidu.live.data.b();
            bVar.setUserId(String.valueOf(this.mUid));
            bVar.setPortrait(this.egA);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.wy().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if ((this.egz != null) & z) {
            this.egz.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.dMr = false;
        aAk();
        if (this.egz != null) {
            this.egz.onClose();
        }
    }

    public void aAk() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.egF != null) {
                this.egF.dismiss();
                this.egF = null;
            }
            if (this.egG != null) {
                this.egG.dismiss();
                this.egG = null;
            }
        }
    }

    public void afC() {
        if (this.egF != null && this.egF.isShowing()) {
            this.egF.aSu();
        }
        if (this.egG != null && this.egG.isShowing()) {
            this.egG.aSu();
        }
    }
}
