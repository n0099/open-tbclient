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
    private long awr;
    private boolean fcA;
    private b fcB;
    private c fcE;
    private d fcF;
    private InterfaceC0461a fcy;
    private String fcz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fcC = true;
    private boolean fcD = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0461a {
        boolean bjI();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bmB();
    }

    public void a(InterfaceC0461a interfaceC0461a) {
        this.fcy = interfaceC0461a;
    }

    public void c(m mVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (mVar != null && (alaLiveInfoData = mVar.mLiveInfo) != null && (alaLiveUserInfoData = mVar.XQ) != null) {
            this.awr = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fcz = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fcA = false;
            this.mPopShow = false;
            bmC();
            xj();
            bmD();
            bmE();
        }
    }

    public void js(boolean z) {
        this.fcC = z;
    }

    public void jt(boolean z) {
        this.fcD = z;
    }

    public boolean bmz() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fcy != null && !this.fcy.bjI()) {
            bmJ();
            return true;
        }
        return false;
    }

    private void bmA() {
        this.mUid = -1L;
        this.fcA = false;
        this.mPopShow = false;
        sN();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        xl();
    }

    public void onDestroy() {
        bmA();
    }

    private void bmB() {
        this.fcB = new b();
        String string = com.baidu.live.c.pr().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcB.fcH = jSONObject.optBoolean("hasShowMax");
                    if (!this.fcB.fcH) {
                        this.fcB.date = b;
                        this.fcB.eGH = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmC() {
        if (this.fcB == null) {
            this.fcB = new b();
        }
        String str = this.fcB.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcB.fcH = false;
            this.fcB.eGH = 0;
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

    private void bmD() {
        t tVar;
        int i;
        if (!this.fcA && !this.fcB.fcH && (tVar = com.baidu.live.v.a.zj().awA) != null) {
            if ((!j.b(new Date()).equals(this.fcB.date) || this.fcB.eGH < tVar.aaF) && (i = tVar.aaE) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.awr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
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

    private void bmE() {
        int i;
        t tVar = com.baidu.live.v.a.zj().awA;
        if (tVar != null && (i = tVar.aaG) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.awr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bmI();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fcC && !this.fcD && !this.fcB.fcH && this.fcy != null && !this.fcy.bjI()) {
            bmF();
        }
    }

    private void bmF() {
        this.fcA = true;
        bmG();
        bmH();
    }

    private void bmG() {
        if (this.fcE == null) {
            this.fcE = new c(this.mPageContext.getPageActivity());
            this.fcE.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.awr), a.this.fcE.bmK(), a.this.mOtherParams);
                    a.this.jv(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fcE.show(this.fcz);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
        }
    }

    private void bmH() {
        String b = j.b(new Date());
        if (b.equals(this.fcB.date)) {
            this.fcB.eGH++;
        } else {
            this.fcB.date = b;
            this.fcB.eGH = 1;
        }
        if (this.fcB.eGH >= com.baidu.live.v.a.zj().awA.aaF) {
            this.fcB.fcH = true;
        }
        com.baidu.live.c.pr().putString("guide_follow_float_times_date", this.fcB.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmI() {
        this.mPopShow = true;
    }

    private void bmJ() {
        if (this.fcF == null) {
            this.fcF = new d(this.mPageContext.getPageActivity());
            this.fcF.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.awr), a.this.fcF.bmK(), a.this.mOtherParams);
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
            this.fcF.show(this.fcz);
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
            bVar.setPortrait(this.fcz);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.Bh().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fcy != null) {
            this.fcy.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        sN();
        if (this.fcy != null) {
            this.fcy.onClose();
        }
    }

    public void sN() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fcE != null) {
                this.fcE.dismiss();
                this.fcE = null;
            }
            if (this.fcF != null) {
                this.fcF.dismiss();
                this.fcF = null;
            }
        }
    }

    public void aza() {
        if (this.fcE != null && this.fcE.isShowing()) {
            this.fcE.bmL();
        }
        if (this.fcF != null && this.fcF.isShowing()) {
            this.fcF.bmL();
        }
    }
}
