package com.baidu.tieba.ala.liveroom.o;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ag;
import com.baidu.live.data.bb;
import com.baidu.live.data.e;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.o.c;
import com.baidu.tieba.ala.liveroom.o.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener beU;
    private long bhr;
    private InterfaceC0633a gDI;
    private String gDJ;
    private boolean gDK;
    private b gDL;
    private c gDO;
    private d gDP;
    private ag gDQ;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean gDM = true;
    private boolean gDN = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0633a {
        boolean bPV();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bTN();
    }

    public void a(InterfaceC0633a interfaceC0633a) {
        this.gDI = interfaceC0633a;
    }

    public void c(u uVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (uVar != null && (alaLiveInfoData = uVar.mLiveInfo) != null && (alaLiveUserInfoData = uVar.aEz) != null) {
            this.bhr = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.gDJ = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.gDK = false;
            this.mPopShow = false;
            this.gDQ = com.baidu.live.x.a.NN().bhy;
            bTO();
            MV();
            bTP();
            bTQ();
        }
    }

    public void mn(boolean z) {
        this.gDM = z;
    }

    public void mo(boolean z) {
        this.gDN = z;
    }

    public boolean bTM() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.gDI != null && !this.gDI.bPV()) {
            bTV();
            return true;
        }
        return false;
    }

    private void Lv() {
        this.mUid = -1L;
        this.gDK = false;
        this.mPopShow = false;
        FD();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        MX();
    }

    public void onDestroy() {
        Lv();
    }

    private void bTN() {
        this.gDL = new b();
        String string = com.baidu.live.c.AR().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.gDL.gDS = jSONObject.optBoolean("hasShowMax");
                    if (!this.gDL.gDS) {
                        this.gDL.date = b;
                        this.gDL.dgo = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bTO() {
        if (this.gDL == null) {
            this.gDL = new b();
        }
        String str = this.gDL.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.gDL.gDS = false;
            this.gDL.dgo = 0;
        }
    }

    private void MV() {
        if (this.beU == null) {
            this.beU = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.1
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
            MessageManager.getInstance().registerListener(this.beU);
        }
    }

    private void MX() {
        if (this.beU != null) {
            MessageManager.getInstance().unRegisterListener(this.beU);
        }
    }

    private void bTP() {
        bb bbVar;
        int i;
        if (!this.gDK && !this.gDL.gDS && this.gDQ != null && (bbVar = this.gDQ.aIn) != null) {
            if ((!k.b(new Date()).equals(this.gDL.date) || this.gDL.dgo < bbVar.aKr) && (i = bbVar.aKq) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bhr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.mp(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bTQ() {
        bb bbVar;
        int i;
        if (this.gDQ != null && (bbVar = this.gDQ.aIn) != null && (i = bbVar.aKs) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bhr, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bTU();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.gDM && !this.gDN && !this.gDL.gDS && this.gDI != null && !this.gDI.bPV()) {
            bTR();
        }
    }

    private void bTR() {
        this.gDK = true;
        bTS();
        bTT();
    }

    private void bTS() {
        if (this.gDO == null) {
            this.gDO = new c(this.mPageContext.getPageActivity());
            this.gDO.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                @Override // com.baidu.tieba.ala.liveroom.o.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.bhr), a.this.gDO.bTW(), a.this.mOtherParams);
                    a.this.mq(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gDO.EO(this.gDJ);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    private void bTT() {
        bb bbVar;
        String b = k.b(new Date());
        if (b.equals(this.gDL.date)) {
            this.gDL.dgo++;
        } else {
            this.gDL.date = b;
            this.gDL.dgo = 1;
        }
        if (com.baidu.live.x.a.NN().bhy != null && (bbVar = com.baidu.live.x.a.NN().bhy.aIn) != null) {
            if (this.gDL.dgo >= bbVar.aKr) {
                this.gDL.gDS = true;
            }
            com.baidu.live.c.AR().putString("guide_follow_float_times_date", this.gDL.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTU() {
        this.mPopShow = true;
    }

    private void bTV() {
        if (this.gDP == null) {
            this.gDP = new d(this.mPageContext.getPageActivity());
            this.gDP.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.bhr), a.this.gDP.bTW(), a.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    a.this.mq(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gDP.EO(this.gDJ);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        FD();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            e eVar = new e();
            eVar.setUserId(String.valueOf(this.mUid));
            eVar.setPortrait(this.gDJ);
            eVar.setPageId(this.mPageContext.getUniqueId());
            eVar.setIsAttention(true);
            eVar.setInLive("1");
            eVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.Rg().a(String.valueOf(this.mUid), eVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.gDI != null) {
            this.gDI.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        FD();
        if (this.gDI != null) {
            this.gDI.onClose();
        }
    }

    public void FD() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.gDO != null) {
                this.gDO.dismiss();
                this.gDO = null;
            }
            if (this.gDP != null) {
                this.gDP.dismiss();
                this.gDP = null;
            }
        }
    }

    public void bbL() {
        if (this.gDO != null && this.gDO.isShowing()) {
            this.gDO.bTX();
        }
        if (this.gDP != null && this.gDP.isShowing()) {
            this.gDP.bTX();
        }
    }
}
