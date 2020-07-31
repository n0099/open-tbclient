package com.baidu.tieba.ala.liveroom.m;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.au;
import com.baidu.live.data.q;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.m.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener aWT;
    private long aZc;
    private String gnA;
    private boolean gnB;
    private b gnC;
    private c gnF;
    private d gnG;
    private z gnH;
    private InterfaceC0584a gnz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean gnD = true;
    private boolean gnE = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0584a {
        boolean bFg();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bIo();
    }

    public void a(InterfaceC0584a interfaceC0584a) {
        this.gnz = interfaceC0584a;
    }

    public void c(q qVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (qVar != null && (alaLiveInfoData = qVar.mLiveInfo) != null && (alaLiveUserInfoData = qVar.ayC) != null) {
            this.aZc = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.gnA = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.gnB = false;
            this.mPopShow = false;
            this.gnH = com.baidu.live.v.a.Hs().aZn;
            bIp();
            GB();
            bIq();
            bIr();
        }
    }

    public void lE(boolean z) {
        this.gnD = z;
    }

    public void lF(boolean z) {
        this.gnE = z;
    }

    public boolean bIn() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.gnz != null && !this.gnz.bFg()) {
            bIw();
            return true;
        }
        return false;
    }

    private void Fi() {
        this.mUid = -1L;
        this.gnB = false;
        this.mPopShow = false;
        zA();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        GD();
    }

    public void onDestroy() {
        Fi();
    }

    private void bIo() {
        this.gnC = new b();
        String string = com.baidu.live.c.vf().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gnC.gnJ = jSONObject.optBoolean("hasShowMax");
                    if (!this.gnC.gnJ) {
                        this.gnC.date = b;
                        this.gnC.cVg = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bIp() {
        if (this.gnC == null) {
            this.gnC = new b();
        }
        String str = this.gnC.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gnC.gnJ = false;
            this.gnC.cVg = 0;
        }
    }

    private void GB() {
        if (this.aWT == null) {
            this.aWT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.m.a.1
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
            MessageManager.getInstance().registerListener(this.aWT);
        }
    }

    private void GD() {
        if (this.aWT != null) {
            MessageManager.getInstance().unRegisterListener(this.aWT);
        }
    }

    private void bIq() {
        au auVar;
        int i;
        if (!this.gnB && !this.gnC.gnJ && this.gnH != null && (auVar = this.gnH.aBL) != null) {
            if ((!j.b(new Date()).equals(this.gnC.date) || this.gnC.cVg < auVar.aDP) && (i = auVar.aDO) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aZc, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.lG(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bIr() {
        au auVar;
        int i;
        if (this.gnH != null && (auVar = this.gnH.aBL) != null && (i = auVar.aDQ) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aZc, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bIv();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.gnD && !this.gnE && !this.gnC.gnJ && this.gnz != null && !this.gnz.bFg()) {
            bIs();
        }
    }

    private void bIs() {
        this.gnB = true;
        bIt();
        bIu();
    }

    private void bIt() {
        if (this.gnF == null) {
            this.gnF = new c(this.mPageContext.getPageActivity());
            this.gnF.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.m.a.4
                @Override // com.baidu.tieba.ala.liveroom.m.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aZc), a.this.gnF.bIx(), a.this.mOtherParams);
                    a.this.lH(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gnF.show(this.gnA);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bIu() {
        au auVar;
        String b = j.b(new Date());
        if (b.equals(this.gnC.date)) {
            this.gnC.cVg++;
        } else {
            this.gnC.date = b;
            this.gnC.cVg = 1;
        }
        if (com.baidu.live.v.a.Hs().aZn != null && (auVar = com.baidu.live.v.a.Hs().aZn.aBL) != null) {
            if (this.gnC.cVg >= auVar.aDP) {
                this.gnC.gnJ = true;
            }
            com.baidu.live.c.vf().putString("guide_follow_float_times_date", this.gnC.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIv() {
        this.mPopShow = true;
    }

    private void bIw() {
        if (this.gnG == null) {
            this.gnG = new d(this.mPageContext.getPageActivity());
            this.gnG.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.m.a.5
                @Override // com.baidu.tieba.ala.liveroom.m.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aZc), a.this.gnG.bIx(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    a.this.lH(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.m.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gnG.show(this.gnA);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        zA();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.d dVar = new com.baidu.live.data.d();
            dVar.setUserId(String.valueOf(this.mUid));
            dVar.setPortrait(this.gnA);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.KF().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.gnz != null) {
            this.gnz.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        zA();
        if (this.gnz != null) {
            this.gnz.onClose();
        }
    }

    public void zA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.gnF != null) {
                this.gnF.dismiss();
                this.gnF = null;
            }
            if (this.gnG != null) {
                this.gnG.dismiss();
                this.gnG = null;
            }
        }
    }

    public void aSA() {
        if (this.gnF != null && this.gnF.isShowing()) {
            this.gnF.bIy();
        }
        if (this.gnG != null && this.gnG.isShowing()) {
            this.gnG.bIy();
        }
    }
}
