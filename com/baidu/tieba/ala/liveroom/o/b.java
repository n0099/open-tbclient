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
import com.baidu.live.data.u;
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
    private CustomMessageListener biH;
    private long blh;
    private a gSd;
    private String gSe;
    private String gSf;
    private boolean gSg;
    private c gSh;
    private com.baidu.tieba.ala.liveroom.o.a gSk;
    private d gSl;
    private ag gSm;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean gSi = true;
    private boolean gSj = false;

    /* loaded from: classes4.dex */
    public interface a {
        boolean bTo();

        void onClose();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bXi();
    }

    public void a(a aVar) {
        this.gSd = aVar;
    }

    public void c(u uVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (uVar != null && (alaLiveInfoData = uVar.mLiveInfo) != null && (alaLiveUserInfoData = uVar.aHD) != null) {
            this.blh = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.gSe = alaLiveUserInfoData.portrait;
            this.gSf = alaLiveInfoData.getNameShow();
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.gSg = false;
            this.mPopShow = false;
            this.gSm = com.baidu.live.x.a.OS().blo;
            bXj();
            Oa();
            registerListener();
            bXk();
            bXl();
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913240) { // from class: com.baidu.tieba.ala.liveroom.o.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Long l = (Long) customResponsedMessage.getData();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(b.this.mPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "网络不好，关注失败");
                } else {
                    com.baidu.live.data.e eVar = new com.baidu.live.data.e();
                    eVar.setUserId(String.valueOf(l));
                    eVar.setPageId(b.this.mPageContext.getUniqueId());
                    eVar.setIsAttention(true);
                    eVar.setInLive("1");
                    eVar.setFrom("source_guide_pop");
                    com.baidu.live.view.a.SY().b(String.valueOf(l), eVar);
                }
            }
        });
    }

    public void mP(boolean z) {
        this.gSi = z;
    }

    public void mQ(boolean z) {
        this.gSj = z;
    }

    public boolean bXh() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.gSd != null && !this.gSd.bTo()) {
            bXq();
            return true;
        }
        return false;
    }

    private void JT() {
        this.mUid = -1L;
        this.gSg = false;
        this.mPopShow = false;
        Gz();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        Oc();
    }

    public void onDestroy() {
        JT();
    }

    private void bXi() {
        this.gSh = new c();
        String string = com.baidu.live.c.AZ().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.gSh.gSo = jSONObject.optBoolean("hasShowMax");
                    if (!this.gSh.gSo) {
                        this.gSh.date = b;
                        this.gSh.dsw = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bXj() {
        if (this.gSh == null) {
            this.gSh = new c();
        }
        String str = this.gSh.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.gSh.gSo = false;
            this.gSh.dsw = 0;
        }
    }

    private void Oa() {
        if (this.biH == null) {
            this.biH = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.b.2
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
            MessageManager.getInstance().registerListener(this.biH);
        }
    }

    private void Oc() {
        if (this.biH != null) {
            MessageManager.getInstance().unRegisterListener(this.biH);
        }
    }

    private void bXk() {
        bb bbVar;
        int i;
        if (!this.gSg && TbadkCoreApplication.isLogin() && !this.gSh.gSo && this.gSm != null && (bbVar = this.gSm.aLr) != null) {
            if ((!k.b(new Date()).equals(this.gSh.date) || this.gSh.dsw < bbVar.aNw) && (i = bbVar.aNv) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.blh, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        b.this.mR(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bXl() {
        bb bbVar;
        int i;
        if (this.gSm != null && (bbVar = this.gSm.aLr) != null && (i = bbVar.aNx) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.blh, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    b.this.bXp();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.gSi && !this.gSj && !this.gSh.gSo && this.gSd != null && !this.gSd.bTo()) {
            bXm();
        }
    }

    private void bXm() {
        this.gSg = true;
        bXn();
        bXo();
    }

    private void bXn() {
        if (this.gSk == null) {
            if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
                this.gSk = new e(this.mPageContext.getPageActivity());
            } else {
                this.gSk = new f(this.mPageContext.getPageActivity());
            }
            this.gSk.a(new a.InterfaceC0651a() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
                @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0651a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(b.this.mVid, String.valueOf(b.this.blh), b.this.gSk.bXg(), b.this.mOtherParams);
                    b.this.mS(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gSk.en(this.gSe, this.gSf);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "follow_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    private void bXo() {
        bb bbVar;
        String b = k.b(new Date());
        if (b.equals(this.gSh.date)) {
            this.gSh.dsw++;
        } else {
            this.gSh.date = b;
            this.gSh.dsw = 1;
        }
        if (com.baidu.live.x.a.OS().blo != null && (bbVar = com.baidu.live.x.a.OS().blo.aLr) != null) {
            if (this.gSh.dsw >= bbVar.aNw) {
                this.gSh.gSo = true;
            }
            com.baidu.live.c.AZ().putString("guide_follow_float_times_date", this.gSh.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXp() {
        this.mPopShow = true;
    }

    private void bXq() {
        if (this.gSl == null) {
            this.gSl = new d(this.mPageContext.getPageActivity());
            this.gSl.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(b.this.mVid, String.valueOf(b.this.blh), b.this.gSl.bXg(), b.this.mOtherParams);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "follow_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                    b.this.mS(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.o.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(b.this.mVid, b.this.mOtherParams);
                    b.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.gSl.Fz(this.gSe);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(boolean z) {
        Gz();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.e eVar = new com.baidu.live.data.e();
            eVar.setUserId(String.valueOf(this.mUid));
            eVar.setPortrait(this.gSe);
            eVar.setPageId(this.mPageContext.getUniqueId());
            eVar.setIsAttention(true);
            eVar.setInLive("1");
            eVar.setFrom(z ? "source_guide_pop_2" : "source_guide_pop");
            com.baidu.live.view.a.SY().a(String.valueOf(this.mUid), eVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.gSd != null) {
            this.gSd.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        Gz();
        if (this.gSd != null) {
            this.gSd.onClose();
        }
    }

    public void Gz() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.gSk != null) {
                this.gSk.dismiss();
                this.gSk = null;
            }
            if (this.gSl != null) {
                this.gSl.dismiss();
                this.gSl = null;
            }
        }
    }

    public void bet() {
        if (this.gSk != null && this.gSk.isShowing()) {
            this.gSk.bXf();
        }
        if (this.gSl != null && this.gSl.isShowing()) {
            this.gSl.bXf();
        }
    }
}
