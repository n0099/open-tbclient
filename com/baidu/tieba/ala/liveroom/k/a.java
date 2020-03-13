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
    private CustomMessageListener atu;
    private long awt;
    private InterfaceC0461a fcM;
    private String fcN;
    private boolean fcO;
    private b fcP;
    private c fcS;
    private d fcT;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fcQ = true;
    private boolean fcR = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0461a {
        boolean bjL();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bmE();
    }

    public void a(InterfaceC0461a interfaceC0461a) {
        this.fcM = interfaceC0461a;
    }

    public void c(m mVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (mVar != null && (alaLiveInfoData = mVar.mLiveInfo) != null && (alaLiveUserInfoData = mVar.XQ) != null) {
            this.awt = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fcN = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fcO = false;
            this.mPopShow = false;
            bmF();
            xj();
            bmG();
            bmH();
        }
    }

    public void js(boolean z) {
        this.fcQ = z;
    }

    public void jt(boolean z) {
        this.fcR = z;
    }

    public boolean bmC() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fcM != null && !this.fcM.bjL()) {
            bmM();
            return true;
        }
        return false;
    }

    private void bmD() {
        this.mUid = -1L;
        this.fcO = false;
        this.mPopShow = false;
        sN();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        xl();
    }

    public void onDestroy() {
        bmD();
    }

    private void bmE() {
        this.fcP = new b();
        String string = com.baidu.live.c.pr().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcP.fcV = jSONObject.optBoolean("hasShowMax");
                    if (!this.fcP.fcV) {
                        this.fcP.date = b;
                        this.fcP.eGV = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmF() {
        if (this.fcP == null) {
            this.fcP = new b();
        }
        String str = this.fcP.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcP.fcV = false;
            this.fcP.eGV = 0;
        }
    }

    private void xj() {
        if (this.atu == null) {
            this.atu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.atu);
        }
    }

    private void xl() {
        if (this.atu != null) {
            MessageManager.getInstance().unRegisterListener(this.atu);
        }
    }

    private void bmG() {
        t tVar;
        int i;
        if (!this.fcO && !this.fcP.fcV && (tVar = com.baidu.live.v.a.zl().awC) != null) {
            if ((!j.b(new Date()).equals(this.fcP.date) || this.fcP.eGV < tVar.aaF) && (i = tVar.aaE) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.awt, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.ju(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bmH() {
        int i;
        t tVar = com.baidu.live.v.a.zl().awC;
        if (tVar != null && (i = tVar.aaG) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.awt, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bmL();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fcQ && !this.fcR && !this.fcP.fcV && this.fcM != null && !this.fcM.bjL()) {
            bmI();
        }
    }

    private void bmI() {
        this.fcO = true;
        bmJ();
        bmK();
    }

    private void bmJ() {
        if (this.fcS == null) {
            this.fcS = new c(this.mPageContext.getPageActivity());
            this.fcS.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.awt), a.this.fcS.bmN(), a.this.mOtherParams);
                    a.this.jv(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fcS.show(this.fcN);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
        }
    }

    private void bmK() {
        String b = j.b(new Date());
        if (b.equals(this.fcP.date)) {
            this.fcP.eGV++;
        } else {
            this.fcP.date = b;
            this.fcP.eGV = 1;
        }
        if (this.fcP.eGV >= com.baidu.live.v.a.zl().awC.aaF) {
            this.fcP.fcV = true;
        }
        com.baidu.live.c.pr().putString("guide_follow_float_times_date", this.fcP.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmL() {
        this.mPopShow = true;
    }

    private void bmM() {
        if (this.fcT == null) {
            this.fcT = new d(this.mPageContext.getPageActivity());
            this.fcT.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.awt), a.this.fcT.bmN(), a.this.mOtherParams);
                    a.this.jv(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fcT.show(this.fcN);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv(boolean z) {
        sN();
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
            bVar.setPortrait(this.fcN);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.Bj().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fcM != null) {
            this.fcM.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        sN();
        if (this.fcM != null) {
            this.fcM.onClose();
        }
    }

    public void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fcS != null) {
                this.fcS.dismiss();
                this.fcS = null;
            }
            if (this.fcT != null) {
                this.fcT.dismiss();
                this.fcT = null;
            }
        }
    }

    public void azc() {
        if (this.fcS != null && this.fcS.isShowing()) {
            this.fcS.bmO();
        }
        if (this.fcT != null && this.fcT.isShowing()) {
            this.fcT.bmO();
        }
    }
}
