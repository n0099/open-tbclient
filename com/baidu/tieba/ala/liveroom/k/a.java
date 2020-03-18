package com.baidu.tieba.ala.liveroom.k;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.m;
import com.baidu.live.data.t;
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
/* loaded from: classes3.dex */
public class a {
    private CustomMessageListener atE;
    private long awD;
    private InterfaceC0461a fdk;
    private String fdl;
    private boolean fdm;
    private b fdn;
    private c fdq;
    private d fdr;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fdo = true;
    private boolean fdp = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0461a {
        boolean bjQ();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bmJ();
    }

    public void a(InterfaceC0461a interfaceC0461a) {
        this.fdk = interfaceC0461a;
    }

    public void c(m mVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (mVar != null && (alaLiveInfoData = mVar.mLiveInfo) != null && (alaLiveUserInfoData = mVar.Ya) != null) {
            this.awD = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fdl = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fdm = false;
            this.mPopShow = false;
            bmK();
            xo();
            bmL();
            bmM();
        }
    }

    public void ju(boolean z) {
        this.fdo = z;
    }

    public void jv(boolean z) {
        this.fdp = z;
    }

    public boolean bmH() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fdk != null && !this.fdk.bjQ()) {
            bmR();
            return true;
        }
        return false;
    }

    private void bmI() {
        this.mUid = -1L;
        this.fdm = false;
        this.mPopShow = false;
        sS();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        xq();
    }

    public void onDestroy() {
        bmI();
    }

    private void bmJ() {
        this.fdn = new b();
        String string = com.baidu.live.c.pw().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fdn.fdt = jSONObject.optBoolean("hasShowMax");
                    if (!this.fdn.fdt) {
                        this.fdn.date = b;
                        this.fdn.eHr = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmK() {
        if (this.fdn == null) {
            this.fdn = new b();
        }
        String str = this.fdn.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fdn.fdt = false;
            this.fdn.eHr = 0;
        }
    }

    private void xo() {
        if (this.atE == null) {
            this.atE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.atE);
        }
    }

    private void xq() {
        if (this.atE != null) {
            MessageManager.getInstance().unRegisterListener(this.atE);
        }
    }

    private void bmL() {
        t tVar;
        int i;
        if (!this.fdm && !this.fdn.fdt && (tVar = com.baidu.live.v.a.zs().awM) != null) {
            if ((!j.b(new Date()).equals(this.fdn.date) || this.fdn.eHr < tVar.aaP) && (i = tVar.aaO) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.awD, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.jw(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bmM() {
        int i;
        t tVar = com.baidu.live.v.a.zs().awM;
        if (tVar != null && (i = tVar.aaQ) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.awD, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bmQ();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jw(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fdo && !this.fdp && !this.fdn.fdt && this.fdk != null && !this.fdk.bjQ()) {
            bmN();
        }
    }

    private void bmN() {
        this.fdm = true;
        bmO();
        bmP();
    }

    private void bmO() {
        if (this.fdq == null) {
            this.fdq = new c(this.mPageContext.getPageActivity());
            this.fdq.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.awD), a.this.fdq.bmS(), a.this.mOtherParams);
                    a.this.jx(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fdq.show(this.fdl);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
        }
    }

    private void bmP() {
        String b = j.b(new Date());
        if (b.equals(this.fdn.date)) {
            this.fdn.eHr++;
        } else {
            this.fdn.date = b;
            this.fdn.eHr = 1;
        }
        if (this.fdn.eHr >= com.baidu.live.v.a.zs().awM.aaP) {
            this.fdn.fdt = true;
        }
        com.baidu.live.c.pw().putString("guide_follow_float_times_date", this.fdn.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmQ() {
        this.mPopShow = true;
    }

    private void bmR() {
        if (this.fdr == null) {
            this.fdr = new d(this.mPageContext.getPageActivity());
            this.fdr.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.awD), a.this.fdr.bmS(), a.this.mOtherParams);
                    a.this.jx(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fdr.show(this.fdl);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx(boolean z) {
        sS();
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
            bVar.setPortrait(this.fdl);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.Bq().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fdk != null) {
            this.fdk.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        sS();
        if (this.fdk != null) {
            this.fdk.onClose();
        }
    }

    public void sS() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fdq != null) {
                this.fdq.dismiss();
                this.fdq = null;
            }
            if (this.fdr != null) {
                this.fdr.dismiss();
                this.fdr = null;
            }
        }
    }

    public void azf() {
        if (this.fdq != null && this.fdq.isShowing()) {
            this.fdq.bmT();
        }
        if (this.fdr != null && this.fdr.isShowing()) {
            this.fdr.bmT();
        }
    }
}
