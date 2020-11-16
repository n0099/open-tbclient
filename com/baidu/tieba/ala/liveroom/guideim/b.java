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
import com.baidu.live.d;
import com.baidu.live.data.ak;
import com.baidu.live.data.w;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener bjL;
    private w bph;
    private c hjJ;
    private CustomMessageListener hjK;
    private boolean hjL;
    private boolean hjM;
    private com.baidu.tieba.ala.liveroom.guideim.a hjN;
    private Handler hjO;
    private GuideImInputView hjP;
    private GuideImInputView.a hjQ;
    private boolean hjy = true;
    private boolean hjz = false;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        ccb();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.hjL = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hjN = aVar;
    }

    public void c(w wVar, String str) {
        this.bph = wVar;
        this.hjM = false;
        ccc();
        cco();
        ccn();
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        ccq();
    }

    public void np(boolean z) {
        this.hjy = z;
        ccm();
    }

    public void nq(boolean z) {
        this.hjz = z;
        ccm();
    }

    private void ccm() {
        if (this.hjO != null) {
            if (!this.hjy || this.hjz) {
                cct();
            }
        }
    }

    public void Ke() {
        this.hjM = false;
        ccs();
        ccp();
    }

    public void release() {
        if (this.hjO != null) {
            this.hjO.removeCallbacksAndMessages(null);
        }
        ccp();
        Or();
    }

    private void ccb() {
        this.hjJ = new c();
        String string = d.Aq().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hjJ.hjS = jSONObject.optBoolean("hasInput");
                    if (!this.hjJ.hjS) {
                        this.hjJ.date = b;
                        this.hjJ.dFf = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ccc() {
        if (this.hjJ == null) {
            this.hjJ = new c();
        }
        String str = this.hjJ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hjJ.hjS = false;
            this.hjJ.dFf = 0;
        }
    }

    private void ccn() {
        if (this.bjL == null) {
            this.bjL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bjL);
        }
    }

    private void Or() {
        if (this.bjL != null) {
            MessageManager.getInstance().unRegisterListener(this.bjL);
        }
    }

    private void cco() {
        if (!this.hjJ.hjS) {
            this.hjK = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.ccu();
                }
            };
            MessageManager.getInstance().registerListener(this.hjK);
        }
    }

    private void ccp() {
        if (this.hjK != null) {
            MessageManager.getInstance().unRegisterListener(this.hjK);
        }
    }

    private void ccq() {
        int i;
        ccs();
        if ((this.bph == null || this.bph.aHG == null || (this.bph.aHG.isUegBlock <= 0 && this.bph.aHG.isBlock <= 0)) && !this.hjM && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hjJ.hjS) {
                ccp();
                return;
            }
            ak akVar = com.baidu.live.aa.a.Ph().bms;
            if (akVar != null && (i = akVar.aLb) > 0) {
                if (!k.b(new Date()).equals(this.hjJ.date) || this.hjJ.dFf < akVar.aLc) {
                    if (this.hjO == null) {
                        this.hjO = new a(this);
                    }
                    this.hjO.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccr() {
        String[] strArr;
        int length;
        this.hjM = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hjy && !this.hjz) {
            if (this.hjJ.hjS) {
                ccp();
                return;
            }
            ak akVar = com.baidu.live.aa.a.Ph().bms;
            if (akVar != null && (strArr = akVar.aLd) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hjP == null) {
                        this.hjP = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hjQ == null) {
                        this.hjQ = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void HI(String str2) {
                                if (b.this.hjN != null && b.this.hjN.Ld()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.ccs();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.hjP.setCallback(this.hjQ);
                    }
                    HG(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccs() {
        if (this.hjO != null) {
            this.hjO.removeCallbacksAndMessages(null);
        }
        cct();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cct() {
        if (this.hjP != null) {
            this.hjP.setVisibility(8);
        }
    }

    private void HG(String str) {
        this.hjM = true;
        HH(str);
        this.hjO.sendEmptyMessageDelayed(2, 5000L);
        bgA();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void HH(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hjP) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hjL) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hjP, layoutParams);
            }
            this.hjP.setText(str);
            this.hjP.setVisibility(0);
        }
    }

    private void bgA() {
        String b = k.b(new Date());
        if (b.equals(this.hjJ.date)) {
            this.hjJ.dFf++;
        } else {
            this.hjJ.date = b;
            this.hjJ.dFf = 1;
        }
        if (this.hjJ.dFf >= com.baidu.live.aa.a.Ph().bms.aLc) {
            ccu();
            ccp();
            return;
        }
        d.Aq().putString("guide_speak_show_times_date", this.hjJ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccu() {
        if (this.hjO != null) {
            this.hjO.removeMessages(1);
        }
        this.hjJ.hjS = true;
        this.hjJ.date = k.b(new Date());
        d.Aq().putString("guide_speak_show_times_date", this.hjJ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> gRD;

        a(b bVar) {
            this.gRD = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.gRD.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.ccr();
                        return;
                    case 2:
                        bVar.cct();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
