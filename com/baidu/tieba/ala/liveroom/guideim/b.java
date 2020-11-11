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
    private CustomMessageListener blw;
    private w bqS;
    private boolean hjR = true;
    private boolean hjS = false;
    private c hkc;
    private CustomMessageListener hkd;
    private boolean hke;
    private boolean hkf;
    private com.baidu.tieba.ala.liveroom.guideim.a hkg;
    private Handler hkh;
    private GuideImInputView hki;
    private GuideImInputView.a hkj;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        ccI();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.hke = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hkg = aVar;
    }

    public void c(w wVar, String str) {
        this.bqS = wVar;
        this.hkf = false;
        ccJ();
        ccV();
        ccU();
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        ccX();
    }

    public void no(boolean z) {
        this.hjR = z;
        ccT();
    }

    public void np(boolean z) {
        this.hjS = z;
        ccT();
    }

    private void ccT() {
        if (this.hkh != null) {
            if (!this.hjR || this.hjS) {
                cda();
            }
        }
    }

    public void KN() {
        this.hkf = false;
        ccZ();
        ccW();
    }

    public void release() {
        if (this.hkh != null) {
            this.hkh.removeCallbacksAndMessages(null);
        }
        ccW();
        Pa();
    }

    private void ccI() {
        this.hkc = new c();
        String string = d.AZ().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.hkc.hkl = jSONObject.optBoolean("hasInput");
                    if (!this.hkc.hkl) {
                        this.hkc.date = b;
                        this.hkc.dGM = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ccJ() {
        if (this.hkc == null) {
            this.hkc = new c();
        }
        String str = this.hkc.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hkc.hkl = false;
            this.hkc.dGM = 0;
        }
    }

    private void ccU() {
        if (this.blw == null) {
            this.blw = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.blw);
        }
    }

    private void Pa() {
        if (this.blw != null) {
            MessageManager.getInstance().unRegisterListener(this.blw);
        }
    }

    private void ccV() {
        if (!this.hkc.hkl) {
            this.hkd = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cdb();
                }
            };
            MessageManager.getInstance().registerListener(this.hkd);
        }
    }

    private void ccW() {
        if (this.hkd != null) {
            MessageManager.getInstance().unRegisterListener(this.hkd);
        }
    }

    private void ccX() {
        int i;
        ccZ();
        if ((this.bqS == null || this.bqS.aJr == null || (this.bqS.aJr.isUegBlock <= 0 && this.bqS.aJr.isBlock <= 0)) && !this.hkf && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hkc.hkl) {
                ccW();
                return;
            }
            ak akVar = com.baidu.live.aa.a.PQ().bod;
            if (akVar != null && (i = akVar.aMM) > 0) {
                if (!k.b(new Date()).equals(this.hkc.date) || this.hkc.dGM < akVar.aMN) {
                    if (this.hkh == null) {
                        this.hkh = new a(this);
                    }
                    this.hkh.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccY() {
        String[] strArr;
        int length;
        this.hkf = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hjR && !this.hjS) {
            if (this.hkc.hkl) {
                ccW();
                return;
            }
            ak akVar = com.baidu.live.aa.a.PQ().bod;
            if (akVar != null && (strArr = akVar.aMO) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hki == null) {
                        this.hki = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hkj == null) {
                        this.hkj = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Ih(String str2) {
                                if (b.this.hkg != null && b.this.hkg.LM()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.ccZ();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.hki.setCallback(this.hkj);
                    }
                    If(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccZ() {
        if (this.hkh != null) {
            this.hkh.removeCallbacksAndMessages(null);
        }
        cda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cda() {
        if (this.hki != null) {
            this.hki.setVisibility(8);
        }
    }

    private void If(String str) {
        this.hkf = true;
        Ig(str);
        this.hkh.sendEmptyMessageDelayed(2, 5000L);
        bhh();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Ig(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hki) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hke) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hki, layoutParams);
            }
            this.hki.setText(str);
            this.hki.setVisibility(0);
        }
    }

    private void bhh() {
        String b = k.b(new Date());
        if (b.equals(this.hkc.date)) {
            this.hkc.dGM++;
        } else {
            this.hkc.date = b;
            this.hkc.dGM = 1;
        }
        if (this.hkc.dGM >= com.baidu.live.aa.a.PQ().bod.aMN) {
            cdb();
            ccW();
            return;
        }
        d.AZ().putString("guide_speak_show_times_date", this.hkc.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdb() {
        if (this.hkh != null) {
            this.hkh.removeMessages(1);
        }
        this.hkc.hkl = true;
        this.hkc.date = k.b(new Date());
        d.AZ().putString("guide_speak_show_times_date", this.hkc.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> gRW;

        a(b bVar) {
            this.gRW = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.gRW.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.ccY();
                        return;
                    case 2:
                        bVar.cda();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
