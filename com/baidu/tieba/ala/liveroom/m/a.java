package com.baidu.tieba.ala.liveroom.m;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.l;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.m.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private CustomMessageListener aqb;
    private long ash;
    private InterfaceC0452a eZl;
    private String eZm;
    private boolean eZn;
    private b eZo;
    private c eZr;
    private d eZs;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private boolean mPopShow;
    private String mVid;
    private long mUid = -1;
    private boolean eZp = true;
    private boolean eZq = false;

    /* renamed from: com.baidu.tieba.ala.liveroom.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0452a {
        boolean bhI();

        void onClose();
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bkR();
    }

    public void a(InterfaceC0452a interfaceC0452a) {
        this.eZl = interfaceC0452a;
    }

    public void a(l lVar, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (lVar != null && (alaLiveInfoData = lVar.mLiveInfo) != null && (alaLiveUserInfoData = lVar.Wf) != null) {
            this.ash = alaLiveInfoData.live_id;
            this.mUid = alaLiveUserInfoData.userId;
            this.eZm = alaLiveUserInfoData.portrait;
            this.mVid = alaLiveInfoData.feed_id;
            this.mOtherParams = str;
            this.eZn = false;
            this.mPopShow = false;
            bkS();
            bkT();
            bkV();
            bkW();
        }
    }

    public void jq(boolean z) {
        this.eZp = z;
    }

    public void jr(boolean z) {
        this.eZq = z;
    }

    public boolean bkP() {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && this.mPopShow && TbadkCoreApplication.isLogin() && this.eZl != null && !this.eZl.bhI()) {
            blb();
            return true;
        }
        return false;
    }

    private void bkQ() {
        this.mUid = -1L;
        this.eZn = false;
        this.mPopShow = false;
        xe();
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_float", true);
        LiveTimerManager.getInstance().removeLiveTimerTask("guide_follow_pop", true);
        bkU();
    }

    public void onDestroy() {
        bkQ();
    }

    private void bkR() {
        this.eZo = new b();
        String string = com.baidu.live.c.oJ().getString("guide_follow_float_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.eZo.eZu = jSONObject.optBoolean("hasShowMax");
                    if (!this.eZo.eZu) {
                        this.eZo.date = b;
                        this.eZo.eCy = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bkS() {
        if (this.eZo == null) {
            this.eZo = new b();
        }
        String str = this.eZo.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.eZo.eZu = false;
            this.eZo.eCy = 0;
        }
    }

    private void bkT() {
        if (this.aqb == null) {
            this.aqb = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.m.a.1
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
            MessageManager.getInstance().registerListener(this.aqb);
        }
    }

    private void bkU() {
        if (this.aqb != null) {
            MessageManager.getInstance().unRegisterListener(this.aqb);
        }
    }

    private void bkV() {
        s sVar;
        int i;
        if (!this.eZn && !this.eZo.eZu && (sVar = com.baidu.live.s.a.wR().asq) != null) {
            if ((!j.b(new Date()).equals(this.eZo.date) || this.eZo.eCy < sVar.YN) && (i = sVar.YM) > 0) {
                LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_float", this.ash, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        a.this.js(z);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, i, true);
            }
        }
    }

    private void bkW() {
        int i;
        s sVar = com.baidu.live.s.a.wR().asq;
        if (sVar != null && (i = sVar.YO) > 0) {
            LiveTimerManager.getInstance().addLiveTimerTask("guide_follow_pop", this.ash, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.3
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z) {
                    a.this.bla();
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isFollowBtnUnabled()) && z && this.eZp && !this.eZq && !this.eZo.eZu && this.eZl != null && !this.eZl.bhI()) {
            bkX();
        }
    }

    private void bkX() {
        this.eZn = true;
        bkY();
        bkZ();
    }

    private void bkY() {
        if (this.eZr == null) {
            this.eZr = new c(this.mPageContext.getPageActivity());
            this.eZr.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.m.a.4
                @Override // com.baidu.tieba.ala.liveroom.m.c.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowFloatConfirmLog(a.this.mVid, String.valueOf(a.this.ash), a.this.eZr.blc(), a.this.mOtherParams);
                    a.this.jt(false);
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.eZr.show(this.eZm);
            LogManager.getCommonLogger().doDisplayGuideFollowFloatLog(this.mVid, this.mOtherParams);
        }
    }

    private void bkZ() {
        String b = j.b(new Date());
        if (b.equals(this.eZo.date)) {
            this.eZo.eCy++;
        } else {
            this.eZo.date = b;
            this.eZo.eCy = 1;
        }
        if (this.eZo.eCy >= com.baidu.live.s.a.wR().asq.YN) {
            this.eZo.eZu = true;
        }
        com.baidu.live.c.oJ().putString("guide_follow_float_times_date", this.eZo.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bla() {
        this.mPopShow = true;
    }

    private void blb() {
        if (this.eZs == null) {
            this.eZs = new d(this.mPageContext.getPageActivity());
            this.eZs.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.m.a.5
                @Override // com.baidu.tieba.ala.liveroom.m.d.a
                public void onConfirm() {
                    LogManager.getCommonLogger().doClickGuideFollowPopConfirmLog(a.this.mVid, String.valueOf(a.this.ash), a.this.eZs.blc(), a.this.mOtherParams);
                    a.this.jt(true);
                }

                @Override // com.baidu.tieba.ala.liveroom.m.d.a
                public void onCancel() {
                    LogManager.getCommonLogger().doClickGuideFollowPopCancelLog(a.this.mVid, a.this.mOtherParams);
                    a.this.close();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.eZs.show(this.eZm);
            LogManager.getCommonLogger().doDisplayGuideFollowPopLog(this.mVid, this.mOtherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(boolean z) {
        xe();
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
            return;
        }
        if (z) {
            this.mPopShow = false;
        }
        if (BdUtilHelper.isNetOk()) {
            com.baidu.live.data.b bVar = new com.baidu.live.data.b();
            bVar.setUserId(String.valueOf(this.mUid));
            bVar.setPortrait(this.eZm);
            bVar.setPageId(this.mPageContext.getUniqueId());
            bVar.setIsAttention(true);
            bVar.setInLive("1");
            com.baidu.live.view.a.yR().a(String.valueOf(this.mUid), bVar);
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，关注失败");
        }
        if (z && this.eZl != null) {
            this.eZl.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        this.mPopShow = false;
        xe();
        if (this.eZl != null) {
            this.eZl.onClose();
        }
    }

    public void xe() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            if (this.eZr != null) {
                this.eZr.dismiss();
                this.eZr = null;
            }
            if (this.eZs != null) {
                this.eZs.dismiss();
                this.eZs = null;
            }
        }
    }

    public void awN() {
        if (this.eZr != null && this.eZr.isShowing()) {
            this.eZr.bld();
        }
        if (this.eZs != null && this.eZs.isShowing()) {
            this.eZs.bld();
        }
    }
}
