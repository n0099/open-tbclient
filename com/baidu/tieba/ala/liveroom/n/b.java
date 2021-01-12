package com.baidu.tieba.ala.liveroom.n;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.an;
import com.baidu.live.data.bj;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.n.a;
import com.baidu.tieba.ala.liveroom.n.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener bly;
    private long brk;
    private a hAh;
    private String hAi;
    private String hAj;
    private boolean hAk;
    private boolean hAl;
    private c hAm;
    private com.baidu.tieba.ala.liveroom.n.a hAp;
    private d hAq;
    private CustomMessageListener hAr;
    private an hAs;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;
    private long mUid = -1;
    private boolean hAn = true;
    private boolean hAo = false;

    /* loaded from: classes10.dex */
    public interface a {
        boolean caS();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        KL();
    }

    public void a(a aVar) {
        this.hAh = aVar;
    }

    public void c(x xVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (xVar != null && (alaLiveInfoData = xVar.mLiveInfo) != null && (alaLiveUserInfoData = xVar.aFH) != null) {
            this.brk = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hAi = alaLiveUserInfoData.portrait;
            this.hAj = alaLiveUserInfoData.userName;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hAk = false;
            this.hAl = false;
            this.hAs = com.baidu.live.af.a.OJ().bru;
            KK();
            NR();
            registerListener();
            ceT();
            ceU();
        }
    }

    private void registerListener() {
        this.hAr = new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.n.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Long l = (Long) customResponsedMessage.getData();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "网络不好，关注失败");
                } else {
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(String.valueOf(l));
                    fVar.setPageId(b.this.mPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_guide_pop");
                    com.baidu.live.view.a.VF().b(String.valueOf(l), fVar);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.hAr);
    }

    public void og(boolean z) {
        this.hAn = z;
    }

    public void oh(boolean z) {
        this.hAo = z;
    }

    public boolean PV() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.hAl && TbadkCoreApplication.isLogin() && this.hAh != null && !this.hAh.caS()) {
            ceZ();
            return true;
        }
        return false;
    }

    private void HJ() {
        this.mUid = -1L;
        this.hAk = false;
        this.hAl = false;
        Ek();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        NT();
    }

    public void onDestroy() {
        HJ();
    }

    private void KL() {
        this.hAm = new c();
        String string = com.baidu.live.d.xf().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.hAm.hAu = jSONObject.optBoolean("hasShowMax");
                    if (!this.hAm.hAu) {
                        this.hAm.date = b2;
                        this.hAm.bnO = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void KK() {
        if (this.hAm == null) {
            this.hAm = new c();
        }
        String str = this.hAm.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hAm.hAu = false;
            this.hAm.bnO = 0;
        }
    }

    private void NR() {
        if (this.bly == null) {
            this.bly = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.n.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        b.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bly);
        }
    }

    private void NT() {
        if (this.bly != null) {
            MessageManager.getInstance().unRegisterListener(this.bly);
        }
        if (this.hAr != null) {
            MessageManager.getInstance().unRegisterListener(this.hAr);
        }
    }

    private void ceT() {
        bj bjVar;
        int i;
        if (!this.hAk && TbadkCoreApplication.isLogin() && !this.hAm.hAu && this.hAs != null && (bjVar = this.hAs.aJZ) != null) {
            if ((!k.b(new Date()).equals(this.hAm.date) || this.hAm.bnO < bjVar.aMu) && (i = bjVar.aMt) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.brk, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.oi(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void ceU() {
        bj bjVar;
        int i;
        if (this.hAs != null && (bjVar = this.hAs.aJZ) != null && (i = bjVar.aMv) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.brk, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.n.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.ceY();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hAn && !this.hAo && !this.hAm.hAu && this.hAh != null && !this.hAh.caS()) {
            ceV();
        }
    }

    private void ceV() {
        this.hAk = true;
        ceW();
        ceX();
    }

    private void ceW() {
        if (this.hAp == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hAp = new e(this.mPageContext.getPageActivity());
            } else {
                this.hAp = new f(this.mPageContext.getPageActivity());
            }
            this.hAp.a(new a.InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.n.b.5
                @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0669a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.brk), b.this.hAp.ceS(), b.this.mOtherParams);
                    b.this.oj(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hAp.ey(this.hAi, this.hAj);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    private void ceX() {
        bj bjVar;
        String b2 = k.b(new Date());
        if (b2.equals(this.hAm.date)) {
            this.hAm.bnO++;
        } else {
            this.hAm.date = b2;
            this.hAm.bnO = 1;
        }
        if (com.baidu.live.af.a.OJ().bru != null && (bjVar = com.baidu.live.af.a.OJ().bru.aJZ) != null) {
            if (this.hAm.bnO >= bjVar.aMu) {
                this.hAm.hAu = true;
            }
            com.baidu.live.d.xf().putString("guide_follow_float_times_date", this.hAm.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        this.hAl = true;
    }

    private void ceZ() {
        if (this.hAq == null) {
            this.hAq = new d(this.mPageContext.getPageActivity());
            this.hAq.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.n.b.6
                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.brk), b.this.hAq.ceS(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                    b.this.oj(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.n.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hAq.Fp(this.hAi);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        Ek();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.hAl = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hAi);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.VF().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hAh != null) {
            this.hAh.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.hAl = false;
        Ek();
        if (this.hAh != null) {
            this.hAh.onClose();
        }
    }

    public void Ek() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hAp != null) {
                this.hAp.dismiss();
                this.hAp = null;
            }
            if (this.hAq != null) {
                this.hAq.dismiss();
                this.hAq = null;
            }
        }
    }

    public void bjV() {
        if (this.hAp != null && this.hAp.isShowing()) {
            this.hAp.ceR();
        }
        if (this.hAq != null && this.hAq.isShowing()) {
            this.hAq.ceR();
        }
    }
}
