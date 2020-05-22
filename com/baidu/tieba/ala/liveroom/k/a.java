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
    private d fVA;
    private y fVB;
    private InterfaceC0564a fVt;
    private String fVu;
    private boolean fVv;
    private b fVw;
    private c fVz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean fVx = true;
    private boolean fVy = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0564a {
        boolean bzh();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bBX();
    }

    public void a(InterfaceC0564a interfaceC0564a) {
        this.fVt = interfaceC0564a;
    }

    public void c(q qVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (qVar != null && (alaLiveInfoData = qVar.mLiveInfo) != null && (alaLiveUserInfoData = qVar.avj) != null) {
            this.aWv = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.fVu = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.fVv = false;
            this.mPopShow = false;
            this.fVB = com.baidu.live.v.a.Ge().aWF;
            bBY();
            Dv();
            bBZ();
            bCa();
        }
    }

    public void kQ(boolean z) {
        this.fVx = z;
    }

    public void kR(boolean z) {
        this.fVy = z;
    }

    public boolean bBV() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.fVt != null && !this.fVt.bzh()) {
            bCf();
            return true;
        }
        return false;
    }

    private void bBW() {
        this.mUid = -1L;
        this.fVv = false;
        this.mPopShow = false;
        yy();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Dx();
    }

    public void onDestroy() {
        bBW();
    }

    private void bBX() {
        this.fVw = new b();
        String string = com.baidu.live.c.uN().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fVw.fVD = jSONObject.optBoolean("hasShowMax");
                    if (!this.fVw.fVD) {
                        this.fVw.fzt = b;
                        this.fVw.fzu = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bBY() {
        if (this.fVw == null) {
            this.fVw = new b();
        }
        String str = this.fVw.fzt;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fVw.fVD = false;
            this.fVw.fzu = 0;
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

    private void bBZ() {
        ap apVar;
        int i;
        if (!this.fVv && !this.fVw.fVD && this.fVB != null && (apVar = this.fVB.ayj) != null) {
            if ((!j.b(new Date()).equals(this.fVw.fzt) || this.fVw.fzu < apVar.aAj) && (i = apVar.aAi) > 0) {
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

    private void bCa() {
        ap apVar;
        int i;
        if (this.fVB != null && (apVar = this.fVB.ayj) != null && (i = apVar.aAk) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.aWv, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bCe();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kS(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.fVx && !this.fVy && !this.fVw.fVD && this.fVt != null && !this.fVt.bzh()) {
            bCb();
        }
    }

    private void bCb() {
        this.fVv = true;
        bCc();
        bCd();
    }

    private void bCc() {
        if (this.fVz == null) {
            this.fVz = new c(this.mPageContext.getPageActivity());
            this.fVz.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // com.baidu.tieba.ala.liveroom.k.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.aWv), a.this.fVz.bCg(), a.this.mOtherParams);
                    a.this.kT(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fVz.show(this.fVu);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, "popup", null));
        }
    }

    private void bCd() {
        ap apVar;
        String b = j.b(new Date());
        if (b.equals(this.fVw.fzt)) {
            this.fVw.fzu++;
        } else {
            this.fVw.fzt = b;
            this.fVw.fzu = 1;
        }
        if (com.baidu.live.v.a.Ge().aWF != null && (apVar = com.baidu.live.v.a.Ge().aWF.ayj) != null) {
            if (this.fVw.fzu >= apVar.aAj) {
                this.fVw.fVD = true;
            }
            com.baidu.live.c.uN().putString("guide_follow_float_times_date", this.fVw.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCe() {
        this.mPopShow = true;
    }

    private void bCf() {
        if (this.fVA == null) {
            this.fVA = new d(this.mPageContext.getPageActivity());
            this.fVA.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // com.baidu.tieba.ala.liveroom.k.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.aWv), a.this.fVA.bCg(), a.this.mOtherParams);
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
            this.fVA.show(this.fVu);
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
            dVar.setPortrait(this.fVu);
            dVar.setPageId(this.mPageContext.getUniqueId());
            dVar.setIsAttention(true);
            dVar.setInLive("1");
            dVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Jl().a(String.valueOf(this.mUid), dVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.fVt != null) {
            this.fVt.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        yy();
        if (this.fVt != null) {
            this.fVt.onClose();
        }
    }

    public void yy() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.fVz != null) {
                this.fVz.dismiss();
                this.fVz = null;
            }
            if (this.fVA != null) {
                this.fVA.dismiss();
                this.fVA = null;
            }
        }
    }

    public void aNc() {
        if (this.fVz != null && this.fVz.isShowing()) {
            this.fVz.bCh();
        }
        if (this.fVA != null && this.fVA.isShowing()) {
            this.fVA.bCh();
        }
    }
}
