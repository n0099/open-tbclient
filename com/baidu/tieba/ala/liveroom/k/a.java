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
    private CustomMessageListener att;
    private long aws;
    private String fcA;
    private boolean fcB;
    private b fcC;
    private c fcF;
    private d fcG;
    private InterfaceC0461a fcz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fcD = true;
    private boolean fcE = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0461a {
        boolean bjK();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bmD();
    }

    public void a(InterfaceC0461a interfaceC0461a) {
        this.fcz = interfaceC0461a;
    }

    public void c(m mVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (mVar != null && (alaLiveInfoData = mVar.mLiveInfo) != null && (alaLiveUserInfoData = mVar.XQ) != null) {
            this.aws = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fcA = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fcB = false;
            this.mPopShow = false;
            bmE();
            xj();
            bmF();
            bmG();
        }
    }

    public void js(boolean z) {
        this.fcD = z;
    }

    public void jt(boolean z) {
        this.fcE = z;
    }

    public boolean bmB() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fcz != null && !this.fcz.bjK()) {
            bmL();
            return true;
        }
        return false;
    }

    private void bmC() {
        this.mUid = -1L;
        this.fcB = false;
        this.mPopShow = false;
        sN();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        xl();
    }

    public void onDestroy() {
        bmC();
    }

    private void bmD() {
        this.fcC = new b();
        String string = com.baidu.live.c.pr().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcC.fcI = jSONObject.optBoolean("hasShowMax");
                    if (!this.fcC.fcI) {
                        this.fcC.date = b;
                        this.fcC.eGI = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmE() {
        if (this.fcC == null) {
            this.fcC = new b();
        }
        String str = this.fcC.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcC.fcI = false;
            this.fcC.eGI = 0;
        }
    }

    private void xj() {
        if (this.att == null) {
            this.att = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.att);
        }
    }

    private void xl() {
        if (this.att != null) {
            MessageManager.getInstance().unRegisterListener(this.att);
        }
    }

    private void bmF() {
        t tVar;
        int i;
        if (!this.fcB && !this.fcC.fcI && (tVar = com.baidu.live.v.a.zl().awB) != null) {
            if ((!j.b(new Date()).equals(this.fcC.date) || this.fcC.eGI < tVar.aaF) && (i = tVar.aaE) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aws, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
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

    private void bmG() {
        int i;
        t tVar = com.baidu.live.v.a.zl().awB;
        if (tVar != null && (i = tVar.aaG) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aws, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bmK();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fcD && !this.fcE && !this.fcC.fcI && this.fcz != null && !this.fcz.bjK()) {
            bmH();
        }
    }

    private void bmH() {
        this.fcB = true;
        bmI();
        bmJ();
    }

    private void bmI() {
        if (this.fcF == null) {
            this.fcF = new c(this.mPageContext.getPageActivity());
            this.fcF.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aws), a.this.fcF.bmM(), a.this.mOtherParams);
                    a.this.jv(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fcF.show(this.fcA);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
        }
    }

    private void bmJ() {
        String b = j.b(new Date());
        if (b.equals(this.fcC.date)) {
            this.fcC.eGI++;
        } else {
            this.fcC.date = b;
            this.fcC.eGI = 1;
        }
        if (this.fcC.eGI >= com.baidu.live.v.a.zl().awB.aaF) {
            this.fcC.fcI = true;
        }
        com.baidu.live.c.pr().putString("guide_follow_float_times_date", this.fcC.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmK() {
        this.mPopShow = true;
    }

    private void bmL() {
        if (this.fcG == null) {
            this.fcG = new d(this.mPageContext.getPageActivity());
            this.fcG.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aws), a.this.fcG.bmM(), a.this.mOtherParams);
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
            this.fcG.show(this.fcA);
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
            bVar.setPortrait(this.fcA);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.Bj().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fcz != null) {
            this.fcz.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        sN();
        if (this.fcz != null) {
            this.fcz.onClose();
        }
    }

    public void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fcF != null) {
                this.fcF.dismiss();
                this.fcF = null;
            }
            if (this.fcG != null) {
                this.fcG.dismiss();
                this.fcG = null;
            }
        }
    }

    public void azc() {
        if (this.fcF != null && this.fcF.isShowing()) {
            this.fcF.bmN();
        }
        if (this.fcG != null && this.fcG.isShowing()) {
            this.fcG.bmN();
        }
    }
}
