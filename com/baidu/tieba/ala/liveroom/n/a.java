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
    private CustomMessageListener bci;
    private long bew;
    private InterfaceC0636a gAp;
    private String gAq;
    private boolean gAr;
    private b gAs;
    private c gAv;
    private d gAw;
    private ab gAx;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean gAt = true;
    private boolean gAu = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0636a {
        boolean bOI();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bSp();
    }

    public void a(InterfaceC0636a interfaceC0636a) {
        this.gAp = interfaceC0636a;
    }

    public void c(r rVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (rVar != null && (alaLiveInfoData = rVar.mLiveInfo) != null && (alaLiveUserInfoData = rVar.aDE) != null) {
            this.bew = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.gAq = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.gAr = false;
            this.mPopShow = false;
            this.gAx = com.baidu.live.w.a.Nk().beH;
            bSq();
            Mn();
            bSr();
            bSs();
        }
    }

    public void mi(boolean z) {
        this.gAt = z;
    }

    public void mj(boolean z) {
        this.gAu = z;
    }

    public boolean bSo() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.gAp != null && !this.gAp.bOI()) {
            bSx();
            return true;
        }
        return false;
    }

    private void KP() {
        this.mUid = -1L;
        this.gAr = false;
        this.mPopShow = false;
        Fd();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Mp();
    }

    public void onDestroy() {
        KP();
    }

    private void bSp() {
        this.gAs = new b();
        String string = com.baidu.live.c.AD().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gAs.gAz = jSONObject.optBoolean("hasShowMax");
                    if (!this.gAs.gAz) {
                        this.gAs.date = b;
                        this.gAs.dej = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bSq() {
        if (this.gAs == null) {
            this.gAs = new b();
        }
        String str = this.gAs.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gAs.gAz = false;
            this.gAs.dej = 0;
        }
    }

    private void Mn() {
        if (this.bci == null) {
            this.bci = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.a.1
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
            MessageManager.getInstance().registerListener(this.bci);
        }
    }

    private void Mp() {
        if (this.bci != null) {
            MessageManager.getInstance().unRegisterListener(this.bci);
        }
    }

    private void bSr() {
        aw awVar;
        int i;
        if (!this.gAr && !this.gAs.gAz && this.gAx != null && (awVar = this.gAx.aGV) != null) {
            if ((!j.b(new Date()).equals(this.gAs.date) || this.gAs.dej < awVar.aIZ) && (i = awVar.aIY) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bew, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.mk(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bSs() {
        aw awVar;
        int i;
        if (this.gAx != null && (awVar = this.gAx.aGV) != null && (i = awVar.aJa) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bew, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bSw();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.gAt && !this.gAu && !this.gAs.gAz && this.gAp != null && !this.gAp.bOI()) {
            bSt();
        }
    }

    private void bSt() {
        this.gAr = true;
        bSu();
        bSv();
    }

    private void bSu() {
        if (this.gAv == null) {
            this.gAv = new c(this.mPageContext.getPageActivity());
            this.gAv.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.n.a.4
                @Override // com.baidu.tieba.ala.liveroom.n.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.bew), a.this.gAv.bSy(), a.this.mOtherParams);
                    a.this.ml(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gAv.show(this.gAq);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    private void bSv() {
        aw awVar;
        String b = j.b(new Date());
        if (b.equals(this.gAs.date)) {
            this.gAs.dej++;
        } else {
            this.gAs.date = b;
            this.gAs.dej = 1;
        }
        if (com.baidu.live.w.a.Nk().beH != null && (awVar = com.baidu.live.w.a.Nk().beH.aGV) != null) {
            if (this.gAs.dej >= awVar.aIZ) {
                this.gAs.gAz = true;
            }
            com.baidu.live.c.AD().putString("guide_follow_float_times_date", this.gAs.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSw() {
        this.mPopShow = true;
    }

    private void bSx() {
        if (this.gAw == null) {
            this.gAw = new d(this.mPageContext.getPageActivity());
            this.gAw.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.a.5
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.bew), a.this.gAw.bSy(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    a.this.ml(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gAw.show(this.gAq);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(boolean z) {
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
            dVar.setPortrait(this.gAq);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Qx().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.gAp != null) {
            this.gAp.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        Fd();
        if (this.gAp != null) {
            this.gAp.onClose();
        }
    }

    public void Fd() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.gAv != null) {
                this.gAv.dismiss();
                this.gAv = null;
            }
            if (this.gAw != null) {
                this.gAw.dismiss();
                this.gAw = null;
            }
        }
    }

    public void baR() {
        if (this.gAv != null && this.gAv.isShowing()) {
            this.gAv.bSz();
        }
        if (this.gAw != null && this.gAw.isShowing()) {
            this.gAw.bSz();
        }
    }
}
