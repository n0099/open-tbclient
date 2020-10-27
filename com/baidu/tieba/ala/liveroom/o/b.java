package com.baidu.tieba.ala.liveroom.o;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.aj;
import com.baidu.live.data.be;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.o.a;
import com.baidu.tieba.ala.liveroom.o.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener bkc;
    private long bmB;
    private a hdQ;
    private String hdR;
    private String hdS;
    private boolean hdT;
    private c hdU;
    private com.baidu.tieba.ala.liveroom.o.a hdX;
    private d hdY;
    private aj hdZ;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean hdV = true;
    private boolean hdW = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean bWm();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        cah();
    }

    public void a(a aVar) {
        this.hdQ = aVar;
    }

    public void c(w wVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (wVar != null && (alaLiveInfoData = wVar.mLiveInfo) != null && (alaLiveUserInfoData = wVar.aIe) != null) {
            this.bmB = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.hdR = alaLiveUserInfoData.portrait;
            this.hdS = alaLiveInfoData.getNameShow();
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.hdT = false;
            this.mPopShow = false;
            this.hdZ = com.baidu.live.z.a.Pq().bmJ;
            cai();
            Oy();
            registerListener();
            caj();
            cak();
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913248) { // from class: com.baidu.tieba.ala.liveroom.o.b.1
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
                    com.baidu.live.view.a.TX().b(String.valueOf(l), fVar);
                }
            }
        });
    }

    public void nf(boolean z) {
        this.hdV = z;
    }

    public void ng(boolean z) {
        this.hdW = z;
    }

    public boolean cag() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.hdQ != null && !this.hdQ.bWm()) {
            cap();
            return true;
        }
        return false;
    }

    private void Kn() {
        this.mUid = -1L;
        this.hdT = false;
        this.mPopShow = false;
        GU();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        OA();
    }

    public void onDestroy() {
        Kn();
    }

    private void cah() {
        this.hdU = new c();
        String string = com.baidu.live.d.AZ().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hdU.heb = jSONObject.optBoolean("hasShowMax");
                    if (!this.hdU.heb) {
                        this.hdU.date = b;
                        this.hdU.dAU = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cai() {
        if (this.hdU == null) {
            this.hdU = new c();
        }
        String str = this.hdU.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hdU.heb = false;
            this.hdU.dAU = 0;
        }
    }

    private void Oy() {
        if (this.bkc == null) {
            this.bkc = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.b.2
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
            MessageManager.getInstance().registerListener(this.bkc);
        }
    }

    private void OA() {
        if (this.bkc != null) {
            MessageManager.getInstance().unRegisterListener(this.bkc);
        }
    }

    private void caj() {
        be beVar;
        int i;
        if (!this.hdT && TbadkCoreApplication.isLogin() && !this.hdU.heb && this.hdZ != null && (beVar = this.hdZ.aLV) != null) {
            if ((!k.b(new Date()).equals(this.hdU.date) || this.hdU.dAU < beVar.aOb) && (i = beVar.aOa) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.bmB, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.nh(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void cak() {
        be beVar;
        int i;
        if (this.hdZ != null && (beVar = this.hdZ.aLV) != null && (i = beVar.aOc) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.bmB, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.cao();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nh(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.hdV && !this.hdW && !this.hdU.heb && this.hdQ != null && !this.hdQ.bWm()) {
            cal();
        }
    }

    private void cal() {
        this.hdT = true;
        cam();
        can();
    }

    private void cam() {
        if (this.hdX == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.hdX = new e(this.mPageContext.getPageActivity());
            } else {
                this.hdX = new f(this.mPageContext.getPageActivity());
            }
            this.hdX.a(new a.InterfaceC0667a() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0667a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.bmB), b.this.hdX.caf(), b.this.mOtherParams);
                    b.this.ni(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hdX.eu(this.hdR, this.hdS);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    private void can() {
        be beVar;
        String b = k.b(new Date());
        if (b.equals(this.hdU.date)) {
            this.hdU.dAU++;
        } else {
            this.hdU.date = b;
            this.hdU.dAU = 1;
        }
        if (com.baidu.live.z.a.Pq().bmJ != null && (beVar = com.baidu.live.z.a.Pq().bmJ.aLV) != null) {
            if (this.hdU.dAU >= beVar.aOb) {
                this.hdU.heb = true;
            }
            com.baidu.live.d.AZ().putString("guide_follow_float_times_date", this.hdU.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cao() {
        this.mPopShow = true;
    }

    private void cap() {
        if (this.hdY == null) {
            this.hdY = new d(this.mPageContext.getPageActivity());
            this.hdY.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.bmB), b.this.hdY.caf(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    b.this.ni(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.hdY.FZ(this.hdR);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z) {
        GU();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
            fVar.setUserId(String.valueOf(this.mUid));
            fVar.setPortrait(this.hdR);
            fVar.setPageId(this.mPageContext.getUniqueId());
            fVar.setIsAttention(true);
            fVar.setInLive("1");
            fVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.TX().a(String.valueOf(this.mUid), fVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.hdQ != null) {
            this.hdQ.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        GU();
        if (this.hdQ != null) {
            this.hdQ.onClose();
        }
    }

    public void GU() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.hdX != null) {
                this.hdX.dismiss();
                this.hdX = null;
            }
            if (this.hdY != null) {
                this.hdY.dismiss();
                this.hdY = null;
            }
        }
    }

    public void bgm() {
        if (this.hdX != null && this.hdX.isShowing()) {
            this.hdX.cae();
        }
        if (this.hdY != null && this.hdY.isShowing()) {
            this.hdY.cae();
        }
    }
}
