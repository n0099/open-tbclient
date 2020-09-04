package com.baidu.tieba.ala.liveroom.n;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.aw;
import com.baidu.live.data.r;
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
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.n.c;
import com.baidu.tieba.ala.liveroom.n.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private CustomMessageListener bck;
    private long bey;
    private d gAA;
    private ab gAB;
    private InterfaceC0636a gAt;
    private String gAu;
    private boolean gAv;
    private b gAw;
    private c gAz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean gAx = true;
    private boolean gAy = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0636a {
        boolean bOJ();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bSq();
    }

    public void a(InterfaceC0636a interfaceC0636a) {
        this.gAt = interfaceC0636a;
    }

    public void c(r rVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (rVar != null && (alaLiveInfoData = rVar.mLiveInfo) != null && (alaLiveUserInfoData = rVar.aDG) != null) {
            this.bey = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.gAu = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.gAv = false;
            this.mPopShow = false;
            this.gAB = com.baidu.live.w.a.Nk().beJ;
            bSr();
            Mn();
            bSs();
            bSt();
        }
    }

    public void mk(boolean z) {
        this.gAx = z;
    }

    public void ml(boolean z) {
        this.gAy = z;
    }

    public boolean bSp() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.gAt != null && !this.gAt.bOJ()) {
            bSy();
            return true;
        }
        return false;
    }

    private void KP() {
        this.mUid = -1L;
        this.gAv = false;
        this.mPopShow = false;
        Fd();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Mp();
    }

    public void onDestroy() {
        KP();
    }

    private void bSq() {
        this.gAw = new b();
        String string = com.baidu.live.c.AD().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gAw.gAD = jSONObject.optBoolean("hasShowMax");
                    if (!this.gAw.gAD) {
                        this.gAw.date = b;
                        this.gAw.den = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bSr() {
        if (this.gAw == null) {
            this.gAw = new b();
        }
        String str = this.gAw.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gAw.gAD = false;
            this.gAw.den = 0;
        }
    }

    private void Mn() {
        if (this.bck == null) {
            this.bck = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.a.1
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
            MessageManager.getInstance().registerListener(this.bck);
        }
    }

    private void Mp() {
        if (this.bck != null) {
            MessageManager.getInstance().unRegisterListener(this.bck);
        }
    }

    private void bSs() {
        aw awVar;
        int i;
        if (!this.gAv && !this.gAw.gAD && this.gAB != null && (awVar = this.gAB.aGX) != null) {
            if ((!j.b(new Date()).equals(this.gAw.date) || this.gAw.den < awVar.aJb) && (i = awVar.aJa) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bey, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.mm(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bSt() {
        aw awVar;
        int i;
        if (this.gAB != null && (awVar = this.gAB.aGX) != null && (i = awVar.aJc) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bey, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bSx();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.gAx && !this.gAy && !this.gAw.gAD && this.gAt != null && !this.gAt.bOJ()) {
            bSu();
        }
    }

    private void bSu() {
        this.gAv = true;
        bSv();
        bSw();
    }

    private void bSv() {
        if (this.gAz == null) {
            this.gAz = new c(this.mPageContext.getPageActivity());
            this.gAz.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.n.a.4
                @Override // com.baidu.tieba.ala.liveroom.n.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.bey), a.this.gAz.bSz(), a.this.mOtherParams);
                    a.this.mn(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gAz.show(this.gAu);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    private void bSw() {
        aw awVar;
        String b = j.b(new Date());
        if (b.equals(this.gAw.date)) {
            this.gAw.den++;
        } else {
            this.gAw.date = b;
            this.gAw.den = 1;
        }
        if (com.baidu.live.w.a.Nk().beJ != null && (awVar = com.baidu.live.w.a.Nk().beJ.aGX) != null) {
            if (this.gAw.den >= awVar.aJb) {
                this.gAw.gAD = true;
            }
            com.baidu.live.c.AD().putString("guide_follow_float_times_date", this.gAw.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSx() {
        this.mPopShow = true;
    }

    private void bSy() {
        if (this.gAA == null) {
            this.gAA = new d(this.mPageContext.getPageActivity());
            this.gAA.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.a.5
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.bey), a.this.gAA.bSz(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    a.this.mn(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gAA.show(this.gAu);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        Fd();
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
            dVar.setPortrait(this.gAu);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Qx().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.gAt != null) {
            this.gAt.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        Fd();
        if (this.gAt != null) {
            this.gAt.onClose();
        }
    }

    public void Fd() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.gAz != null) {
                this.gAz.dismiss();
                this.gAz = null;
            }
            if (this.gAA != null) {
                this.gAA.dismiss();
                this.gAA = null;
            }
        }
    }

    public void baR() {
        if (this.gAz != null && this.gAz.isShowing()) {
            this.gAz.bSA();
        }
        if (this.gAA != null && this.gAA.isShowing()) {
            this.gAA.bSA();
        }
    }
}
