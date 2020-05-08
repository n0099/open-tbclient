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
    private CustomMessageListener aMR;
    private boolean fHC = true;
    private boolean fHD = false;
    private c fHM;
    private CustomMessageListener fHN;
    private boolean fHO;
    private boolean fHP;
    private com.baidu.tieba.ala.liveroom.guideim.a fHQ;
    private Handler fHR;
    private GuideImInputView fHS;
    private GuideImInputView.a fHT;
    private n ftD;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bvY();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fHO = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fHQ = aVar;
    }

    public void c(n nVar, String str) {
        this.ftD = nVar;
        this.fHP = false;
        bvZ();
        bwm();
        bwl();
        this.mVid = "";
        if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.feed_id != null) {
            this.mVid = nVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bwo();
    }

    public void kv(boolean z) {
        this.fHC = z;
        bwk();
    }

    public void kw(boolean z) {
        this.fHD = z;
        bwk();
    }

    private void bwk() {
        if (this.fHR != null) {
            if (!this.fHC || this.fHD) {
                bwr();
            }
        }
    }

    public void bvX() {
        this.fHP = false;
        bwq();
        bwn();
    }

    public void release() {
        if (this.fHR != null) {
            this.fHR.removeCallbacksAndMessages(null);
        }
        bwn();
        Ca();
    }

    private void bvY() {
        this.fHM = new c();
        String string = com.baidu.live.c.tG().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fHM.fHV = jSONObject.optBoolean("hasInput");
                    if (!this.fHM.fHV) {
                        this.fHM.date = b;
                        this.fHM.flN = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bvZ() {
        if (this.fHM == null) {
            this.fHM = new c();
        }
        String str = this.fHM.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fHM.fHV = false;
            this.fHM.flN = 0;
        }
    }

    private void bwl() {
        if (this.aMR == null) {
            this.aMR = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aMR);
        }
    }

    private void Ca() {
        if (this.aMR != null) {
            MessageManager.getInstance().unRegisterListener(this.aMR);
        }
    }

    private void bwm() {
        if (!this.fHM.fHV) {
            this.fHN = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bws();
                }
            };
            MessageManager.getInstance().registerListener(this.fHN);
        }
    }

    private void bwn() {
        if (this.fHN != null) {
            MessageManager.getInstance().unRegisterListener(this.fHN);
        }
    }

    private void bwo() {
        int i;
        bwq();
        if ((this.ftD == null || this.ftD.aqD == null || (this.ftD.aqD.isUegBlock <= 0 && this.ftD.aqD.isBlock <= 0)) && !this.fHP && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fHM.fHV) {
                bwn();
                return;
            }
            v vVar = com.baidu.live.v.a.En().aQu;
            if (vVar != null && (i = vVar.atb) > 0) {
                if (!j.b(new Date()).equals(this.fHM.date) || this.fHM.flN < vVar.atc) {
                    if (this.fHR == null) {
                        this.fHR = new a(this);
                    }
                    this.fHR.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwp() {
        String[] strArr;
        int length;
        this.fHP = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fHC && !this.fHD) {
            if (this.fHM.fHV) {
                bwn();
                return;
            }
            v vVar = com.baidu.live.v.a.En().aQu;
            if (vVar != null && (strArr = vVar.atd) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fHS == null) {
                        this.fHS = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fHT == null) {
                        this.fHT = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void AP(String str2) {
                                if (b.this.fHQ != null && b.this.fHQ.Bg()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bwq();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.fHS.setCallback(this.fHT);
                    }
                    AN(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwq() {
        if (this.fHR != null) {
            this.fHR.removeCallbacksAndMessages(null);
        }
        bwr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        if (this.fHS != null) {
            this.fHS.setVisibility(8);
        }
    }

    private void AN(String str) {
        this.fHP = true;
        AO(str);
        this.fHR.sendEmptyMessageDelayed(2, 5000L);
        aGq();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void AO(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fHS) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fHO) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fHS, layoutParams);
            }
            this.fHS.setText(str);
            this.fHS.setVisibility(0);
        }
    }

    private void aGq() {
        String b = j.b(new Date());
        if (b.equals(this.fHM.date)) {
            this.fHM.flN++;
        } else {
            this.fHM.date = b;
            this.fHM.flN = 1;
        }
        if (this.fHM.flN >= com.baidu.live.v.a.En().aQu.atc) {
            bws();
            bwn();
            return;
        }
        com.baidu.live.c.tG().putString("guide_speak_show_times_date", this.fHM.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bws() {
        if (this.fHR != null) {
            this.fHR.removeMessages(1);
        }
        this.fHM.fHV = true;
        this.fHM.date = j.b(new Date());
        com.baidu.live.c.tG().putString("guide_speak_show_times_date", this.fHM.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> fvl;

        a(b bVar) {
            this.fvl = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.fvl.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bwp();
                        return;
                    case 2:
                        bVar.bwr();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
