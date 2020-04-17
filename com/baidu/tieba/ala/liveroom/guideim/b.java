package com.baidu.tieba.ala.liveroom.guideim;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.n;
import com.baidu.live.data.v;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private CustomMessageListener aML;
    private c fHH;
    private CustomMessageListener fHI;
    private boolean fHJ;
    private boolean fHK;
    private com.baidu.tieba.ala.liveroom.guideim.a fHL;
    private Handler fHM;
    private GuideImInputView fHN;
    private GuideImInputView.a fHO;
    private boolean fHx = true;
    private boolean fHy = false;
    private n fty;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bwa();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fHJ = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fHL = aVar;
    }

    public void c(n nVar, String str) {
        this.fty = nVar;
        this.fHK = false;
        bwb();
        bwo();
        bwn();
        this.mVid = "";
        if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.feed_id != null) {
            this.mVid = nVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bwq();
    }

    public void kv(boolean z) {
        this.fHx = z;
        bwm();
    }

    public void kw(boolean z) {
        this.fHy = z;
        bwm();
    }

    private void bwm() {
        if (this.fHM != null) {
            if (!this.fHx || this.fHy) {
                bwt();
            }
        }
    }

    public void bvZ() {
        this.fHK = false;
        bws();
        bwp();
    }

    public void release() {
        if (this.fHM != null) {
            this.fHM.removeCallbacksAndMessages(null);
        }
        bwp();
        Cb();
    }

    private void bwa() {
        this.fHH = new c();
        String string = com.baidu.live.c.tH().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fHH.fHQ = jSONObject.optBoolean("hasInput");
                    if (!this.fHH.fHQ) {
                        this.fHH.date = b;
                        this.fHH.flI = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bwb() {
        if (this.fHH == null) {
            this.fHH = new c();
        }
        String str = this.fHH.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fHH.fHQ = false;
            this.fHH.flI = 0;
        }
    }

    private void bwn() {
        if (this.aML == null) {
            this.aML = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aML);
        }
    }

    private void Cb() {
        if (this.aML != null) {
            MessageManager.getInstance().unRegisterListener(this.aML);
        }
    }

    private void bwo() {
        if (!this.fHH.fHQ) {
            this.fHI = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bwu();
                }
            };
            MessageManager.getInstance().registerListener(this.fHI);
        }
    }

    private void bwp() {
        if (this.fHI != null) {
            MessageManager.getInstance().unRegisterListener(this.fHI);
        }
    }

    private void bwq() {
        int i;
        bws();
        if ((this.fty == null || this.fty.aqx == null || (this.fty.aqx.isUegBlock <= 0 && this.fty.aqx.isBlock <= 0)) && !this.fHK && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fHH.fHQ) {
                bwp();
                return;
            }
            v vVar = com.baidu.live.v.a.Eo().aQp;
            if (vVar != null && (i = vVar.asV) > 0) {
                if (!j.b(new Date()).equals(this.fHH.date) || this.fHH.flI < vVar.asW) {
                    if (this.fHM == null) {
                        this.fHM = new a(this);
                    }
                    this.fHM.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        String[] strArr;
        int length;
        this.fHK = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fHx && !this.fHy) {
            if (this.fHH.fHQ) {
                bwp();
                return;
            }
            v vVar = com.baidu.live.v.a.Eo().aQp;
            if (vVar != null && (strArr = vVar.asX) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fHN == null) {
                        this.fHN = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fHO == null) {
                        this.fHO = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void AM(String str2) {
                                if (b.this.fHL != null && b.this.fHL.Bh()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bws();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.fHN.setCallback(this.fHO);
                    }
                    AK(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bws() {
        if (this.fHM != null) {
            this.fHM.removeCallbacksAndMessages(null);
        }
        bwt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwt() {
        if (this.fHN != null) {
            this.fHN.setVisibility(8);
        }
    }

    private void AK(String str) {
        this.fHK = true;
        AL(str);
        this.fHM.sendEmptyMessageDelayed(2, 5000L);
        aGs();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void AL(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fHN) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fHJ) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fHN, layoutParams);
            }
            this.fHN.setText(str);
            this.fHN.setVisibility(0);
        }
    }

    private void aGs() {
        String b = j.b(new Date());
        if (b.equals(this.fHH.date)) {
            this.fHH.flI++;
        } else {
            this.fHH.date = b;
            this.fHH.flI = 1;
        }
        if (this.fHH.flI >= com.baidu.live.v.a.Eo().aQp.asW) {
            bwu();
            bwp();
            return;
        }
        com.baidu.live.c.tH().putString("guide_speak_show_times_date", this.fHH.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwu() {
        if (this.fHM != null) {
            this.fHM.removeMessages(1);
        }
        this.fHH.fHQ = true;
        this.fHH.date = j.b(new Date());
        com.baidu.live.c.tH().putString("guide_speak_show_times_date", this.fHH.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> fvg;

        a(b bVar) {
            this.fvg = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.fvg.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bwr();
                        return;
                    case 2:
                        bVar.bwt();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
