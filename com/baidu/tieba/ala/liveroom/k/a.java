package com.baidu.tieba.ala.liveroom.k;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ap;
import com.baidu.live.data.q;
import com.baidu.live.data.y;
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
import com.baidu.tieba.ala.liveroom.k.c;
import com.baidu.tieba.ala.liveroom.k.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private CustomMessageListener aSV;
    private long aWv;
    private InterfaceC0564a fVE;
    private String fVF;
    private boolean fVG;
    private b fVH;
    private c fVK;
    private d fVL;
    private y fVM;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fVI = true;
    private boolean fVJ = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0564a {
        boolean bzj();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bBZ();
    }

    public void a(InterfaceC0564a interfaceC0564a) {
        this.fVE = interfaceC0564a;
    }

    public void c(q qVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (qVar != null && (alaLiveInfoData = qVar.mLiveInfo) != null && (alaLiveUserInfoData = qVar.avj) != null) {
            this.aWv = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fVF = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fVG = false;
            this.mPopShow = false;
            this.fVM = com.baidu.live.v.a.Ge().aWF;
            bCa();
            Dv();
            bCb();
            bCc();
        }
    }

    public void kQ(boolean z) {
        this.fVI = z;
    }

    public void kR(boolean z) {
        this.fVJ = z;
    }

    public boolean bBX() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fVE != null && !this.fVE.bzj()) {
            bCh();
            return true;
        }
        return false;
    }

    private void bBY() {
        this.mUid = -1L;
        this.fVG = false;
        this.mPopShow = false;
        yy();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Dx();
    }

    public void onDestroy() {
        bBY();
    }

    private void bBZ() {
        this.fVH = new b();
        String string = com.baidu.live.c.uN().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fVH.fVO = jSONObject.optBoolean("hasShowMax");
                    if (!this.fVH.fVO) {
                        this.fVH.fzE = b;
                        this.fVH.fzF = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bCa() {
        if (this.fVH == null) {
            this.fVH = new b();
        }
        String str = this.fVH.fzE;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fVH.fVO = false;
            this.fVH.fzF = 0;
        }
    }

    private void Dv() {
        if (this.aSV == null) {
            this.aSV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.k.a.1
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
            MessageManager.getInstance().registerListener(this.aSV);
        }
    }

    private void Dx() {
        if (this.aSV != null) {
            MessageManager.getInstance().unRegisterListener(this.aSV);
        }
    }

    private void bCb() {
        ap apVar;
        int i;
        if (!this.fVG && !this.fVH.fVO && this.fVM != null && (apVar = this.fVM.ayj) != null) {
            if ((!j.b(new Date()).equals(this.fVH.fzE) || this.fVH.fzF < apVar.aAj) && (i = apVar.aAi) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.aWv, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.kS(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bCc() {
        ap apVar;
        int i;
        if (this.fVM != null && (apVar = this.fVM.ayj) != null && (i = apVar.aAk) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aWv, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bCg();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fVI && !this.fVJ && !this.fVH.fVO && this.fVE != null && !this.fVE.bzj()) {
            bCd();
        }
    }

    private void bCd() {
        this.fVG = true;
        bCe();
        bCf();
    }

    private void bCe() {
        if (this.fVK == null) {
            this.fVK = new c(this.mPageContext.getPageActivity());
            this.fVK.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aWv), a.this.fVK.bCi(), a.this.mOtherParams);
                    a.this.kT(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fVK.show(this.fVF);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bCf() {
        ap apVar;
        String b = j.b(new Date());
        if (b.equals(this.fVH.fzE)) {
            this.fVH.fzF++;
        } else {
            this.fVH.fzE = b;
            this.fVH.fzF = 1;
        }
        if (com.baidu.live.v.a.Ge().aWF != null && (apVar = com.baidu.live.v.a.Ge().aWF.ayj) != null) {
            if (this.fVH.fzF >= apVar.aAj) {
                this.fVH.fVO = true;
            }
            com.baidu.live.c.uN().putString("guide_follow_float_times_date", this.fVH.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCg() {
        this.mPopShow = true;
    }

    private void bCh() {
        if (this.fVL == null) {
            this.fVL = new d(this.mPageContext.getPageActivity());
            this.fVL.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aWv), a.this.fVL.bCi(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, "popup", null));
                    a.this.kT(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fVL.show(this.fVF);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT(boolean z) {
        yy();
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
            dVar.setPortrait(this.fVF);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Jl().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fVE != null) {
            this.fVE.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        yy();
        if (this.fVE != null) {
            this.fVE.onClose();
        }
    }

    public void yy() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fVK != null) {
                this.fVK.dismiss();
                this.fVK = null;
            }
            if (this.fVL != null) {
                this.fVL.dismiss();
                this.fVL = null;
            }
        }
    }

    public void aNc() {
        if (this.fVK != null && this.fVK.isShowing()) {
            this.fVK.bCj();
        }
        if (this.fVL != null && this.fVL.isShowing()) {
            this.fVL.bCj();
        }
    }
}
