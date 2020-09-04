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
import com.baidu.live.data.ab;
import com.baidu.live.data.r;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.j;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private CustomMessageListener bck;
    private r bha;
    private c gAI;
    private CustomMessageListener gAJ;
    private boolean gAK;
    private boolean gAL;
    private com.baidu.tieba.ala.liveroom.guideim.a gAM;
    private Handler gAN;
    private GuideImInputView gAO;
    private GuideImInputView.a gAP;
    private boolean gAx = true;
    private boolean gAy = false;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bSq();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.gAK = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.gAM = aVar;
    }

    public void c(r rVar, String str) {
        this.bha = rVar;
        this.gAL = false;
        bSr();
        bSF();
        bSE();
        this.mVid = "";
        if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.feed_id != null) {
            this.mVid = rVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bSH();
    }

    public void mk(boolean z) {
        this.gAx = z;
        bSD();
    }

    public void ml(boolean z) {
        this.gAy = z;
        bSD();
    }

    private void bSD() {
        if (this.gAN != null) {
            if (!this.gAx || this.gAy) {
                bSK();
            }
        }
    }

    public void KP() {
        this.gAL = false;
        bSJ();
        bSG();
    }

    public void release() {
        if (this.gAN != null) {
            this.gAN.removeCallbacksAndMessages(null);
        }
        bSG();
        Mp();
    }

    private void bSq() {
        this.gAI = new c();
        String string = com.baidu.live.c.AD().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gAI.gAR = jSONObject.optBoolean("hasInput");
                    if (!this.gAI.gAR) {
                        this.gAI.date = b;
                        this.gAI.den = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bSr() {
        if (this.gAI == null) {
            this.gAI = new c();
        }
        String str = this.gAI.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gAI.gAR = false;
            this.gAI.den = 0;
        }
    }

    private void bSE() {
        if (this.bck == null) {
            this.bck = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bck);
        }
    }

    private void Mp() {
        if (this.bck != null) {
            MessageManager.getInstance().unRegisterListener(this.bck);
        }
    }

    private void bSF() {
        if (!this.gAI.gAR) {
            this.gAJ = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bSL();
                }
            };
            MessageManager.getInstance().registerListener(this.gAJ);
        }
    }

    private void bSG() {
        if (this.gAJ != null) {
            MessageManager.getInstance().unRegisterListener(this.gAJ);
        }
    }

    private void bSH() {
        int i;
        bSJ();
        if ((this.bha == null || this.bha.aEf == null || (this.bha.aEf.isUegBlock <= 0 && this.bha.aEf.isBlock <= 0)) && !this.gAL && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.gAI.gAR) {
                bSG();
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beJ;
            if (abVar != null && (i = abVar.aGP) > 0) {
                if (!j.b(new Date()).equals(this.gAI.date) || this.gAI.den < abVar.aGQ) {
                    if (this.gAN == null) {
                        this.gAN = new a(this);
                    }
                    this.gAN.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSI() {
        String[] strArr;
        int length;
        this.gAL = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.gAx && !this.gAy) {
            if (this.gAI.gAR) {
                bSG();
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beJ;
            if (abVar != null && (strArr = abVar.aGR) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.gAO == null) {
                        this.gAO = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.gAP == null) {
                        this.gAP = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Gh(String str2) {
                                if (b.this.gAM != null && b.this.gAM.Ji()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bSJ();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        };
                        this.gAO.setCallback(this.gAP);
                    }
                    Gf(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        if (this.gAN != null) {
            this.gAN.removeCallbacksAndMessages(null);
        }
        bSK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        if (this.gAO != null) {
            this.gAO.setVisibility(8);
        }
    }

    private void Gf(String str) {
        this.gAL = true;
        Gg(str);
        this.gAN.sendEmptyMessageDelayed(2, 5000L);
        aZt();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
    }

    private void Gg(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gAO) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.gAK) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.gAO, layoutParams);
            }
            this.gAO.setText(str);
            this.gAO.setVisibility(0);
        }
    }

    private void aZt() {
        String b = j.b(new Date());
        if (b.equals(this.gAI.date)) {
            this.gAI.den++;
        } else {
            this.gAI.date = b;
            this.gAI.den = 1;
        }
        if (this.gAI.den >= com.baidu.live.w.a.Nk().beJ.aGQ) {
            bSL();
            bSG();
            return;
        }
        com.baidu.live.c.AD().putString("guide_speak_show_times_date", this.gAI.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSL() {
        if (this.gAN != null) {
            this.gAN.removeMessages(1);
        }
        this.gAI.gAR = true;
        this.gAI.date = j.b(new Date());
        com.baidu.live.c.AD().putString("guide_speak_show_times_date", this.gAI.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends Handler {
        private final WeakReference<b> glU;

        a(b bVar) {
            this.glU = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.glU.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bSI();
                        return;
                    case 2:
                        bVar.bSK();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
