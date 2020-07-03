package com.baidu.tieba.ala.liveroom.l;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.at;
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
import com.baidu.tieba.ala.liveroom.l.c;
import com.baidu.tieba.ala.liveroom.l.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private CustomMessageListener aVB;
    private long aZe;
    private InterfaceC0573a giB;
    private String giC;
    private boolean giD;
    private b giE;
    private c giH;
    private d giI;
    private z giJ;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean giF = true;
    private boolean giG = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0573a {
        boolean bBU();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bFf();
    }

    public void a(InterfaceC0573a interfaceC0573a) {
        this.giB = interfaceC0573a;
    }

    public void c(q qVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (qVar != null && (alaLiveInfoData = qVar.mLiveInfo) != null && (alaLiveUserInfoData = qVar.axp) != null) {
            this.aZe = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.giC = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.giD = false;
            this.mPopShow = false;
            this.giJ = com.baidu.live.v.a.Hm().aZp;
            bFg();
            DX();
            bFh();
            bFi();
        }
    }

    public void lb(boolean z) {
        this.giF = z;
    }

    public void lc(boolean z) {
        this.giG = z;
    }

    public boolean bFe() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.giB != null && !this.giB.bBU()) {
            bFn();
            return true;
        }
        return false;
    }

    private void Fo() {
        this.mUid = -1L;
        this.giD = false;
        this.mPopShow = false;
        yY();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        DZ();
    }

    public void onDestroy() {
        Fo();
    }

    private void bFf() {
        this.giE = new b();
        String string = com.baidu.live.c.vf().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.giE.giL = jSONObject.optBoolean("hasShowMax");
                    if (!this.giE.giL) {
                        this.giE.date = b;
                        this.giE.fKO = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bFg() {
        if (this.giE == null) {
            this.giE = new b();
        }
        String str = this.giE.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.giE.giL = false;
            this.giE.fKO = 0;
        }
    }

    private void DX() {
        if (this.aVB == null) {
            this.aVB = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.a.1
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
            MessageManager.getInstance().registerListener(this.aVB);
        }
    }

    private void DZ() {
        if (this.aVB != null) {
            MessageManager.getInstance().unRegisterListener(this.aVB);
        }
    }

    private void bFh() {
        at atVar;
        int i;
        if (!this.giD && !this.giE.giL && this.giJ != null && (atVar = this.giJ.aAy) != null) {
            if ((!j.b(new Date()).equals(this.giE.date) || this.giE.fKO < atVar.aCu) && (i = atVar.aCt) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aZe, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.ld(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bFi() {
        at atVar;
        int i;
        if (this.giJ != null && (atVar = this.giJ.aAy) != null && (i = atVar.aCv) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aZe, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.l.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bFm();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.giF && !this.giG && !this.giE.giL && this.giB != null && !this.giB.bBU()) {
            bFj();
        }
    }

    private void bFj() {
        this.giD = true;
        bFk();
        bFl();
    }

    private void bFk() {
        if (this.giH == null) {
            this.giH = new c(this.mPageContext.getPageActivity());
            this.giH.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.l.a.4
                @Override // com.baidu.tieba.ala.liveroom.l.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aZe), a.this.giH.bFo(), a.this.mOtherParams);
                    a.this.le(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.giH.show(this.giC);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bFl() {
        at atVar;
        String b = j.b(new Date());
        if (b.equals(this.giE.date)) {
            this.giE.fKO++;
        } else {
            this.giE.date = b;
            this.giE.fKO = 1;
        }
        if (com.baidu.live.v.a.Hm().aZp != null && (atVar = com.baidu.live.v.a.Hm().aZp.aAy) != null) {
            if (this.giE.fKO >= atVar.aCu) {
                this.giE.giL = true;
            }
            com.baidu.live.c.vf().putString("guide_follow_float_times_date", this.giE.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFm() {
        this.mPopShow = true;
    }

    private void bFn() {
        if (this.giI == null) {
            this.giI = new d(this.mPageContext.getPageActivity());
            this.giI.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.l.a.5
                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aZe), a.this.giI.bFo(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    a.this.le(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.l.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.giI.show(this.giC);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(boolean z) {
        yY();
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
            dVar.setPortrait(this.giC);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Ky().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.giB != null) {
            this.giB.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        yY();
        if (this.giB != null) {
            this.giB.onClose();
        }
    }

    public void yY() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.giH != null) {
                this.giH.dismiss();
                this.giH = null;
            }
            if (this.giI != null) {
                this.giI.dismiss();
                this.giI = null;
            }
        }
    }

    public void aOF() {
        if (this.giH != null && this.giH.isShowing()) {
            this.giH.bFp();
        }
        if (this.giI != null && this.giI.isShowing()) {
            this.giI.bFp();
        }
    }
}
