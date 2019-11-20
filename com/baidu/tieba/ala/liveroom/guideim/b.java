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
import com.baidu.live.data.i;
import com.baidu.live.data.o;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private String ahX;
    private CustomMessageListener ahl;
    private boolean egD = true;
    private boolean egE = false;
    private c egN;
    private CustomMessageListener egO;
    private boolean egP;
    private boolean egQ;
    private com.baidu.tieba.ala.liveroom.guideim.a egR;
    private Handler egS;
    private GuideImInputView egT;
    private GuideImInputView.a egU;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        aSi();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.egP = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.egR = aVar;
    }

    public void a(i iVar, String str) {
        this.egQ = false;
        aSj();
        aSy();
        aSx();
        this.ahX = "";
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.feed_id != null) {
            this.ahX = iVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        aSA();
    }

    public void hP(boolean z) {
        this.egD = z;
        aSw();
    }

    public void hQ(boolean z) {
        this.egE = z;
        aSw();
    }

    private void aSw() {
        if (this.egS != null) {
            if (!this.egD || this.egE) {
                aSD();
            }
        }
    }

    public void aSh() {
        this.egQ = false;
        aSC();
        aSz();
    }

    public void release() {
        if (this.egS != null) {
            this.egS.removeCallbacksAndMessages(null);
        }
        aSz();
        aSl();
    }

    private void aSi() {
        this.egN = new c();
        String string = com.baidu.live.c.np().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = com.baidu.live.utils.i.b(new Date());
                if (optString.equals(b)) {
                    this.egN.egW = jSONObject.optBoolean("hasInput");
                    if (!this.egN.egW) {
                        this.egN.date = b;
                        this.egN.dNf = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void aSj() {
        if (this.egN == null) {
            this.egN = new c();
        }
        String str = this.egN.date;
        if (!TextUtils.isEmpty(str) && !str.equals(com.baidu.live.utils.i.b(new Date()))) {
            this.egN.egW = false;
            this.egN.dNf = 0;
        }
    }

    private void aSx() {
        if (this.ahl == null) {
            this.ahl = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.ahl);
        }
    }

    private void aSl() {
        if (this.ahl != null) {
            MessageManager.getInstance().unRegisterListener(this.ahl);
        }
    }

    private void aSy() {
        if (!this.egN.egW) {
            this.egO = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.aSE();
                }
            };
            MessageManager.getInstance().registerListener(this.egO);
        }
    }

    private void aSz() {
        if (this.egO != null) {
            MessageManager.getInstance().unRegisterListener(this.egO);
        }
    }

    private void aSA() {
        int i;
        aSC();
        if (!this.egQ) {
            if (this.egN.egW) {
                aSz();
                return;
            }
            o oVar = com.baidu.live.l.a.uB().ajF;
            if (oVar != null && (i = oVar.RD) > 0) {
                if (!com.baidu.live.utils.i.b(new Date()).equals(this.egN.date) || this.egN.dNf < oVar.RE) {
                    if (this.egS == null) {
                        this.egS = new a(this);
                    }
                    this.egS.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSB() {
        String[] strArr;
        int length;
        this.egQ = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.egD && !this.egE) {
            if (this.egN.egW) {
                aSz();
                return;
            }
            o oVar = com.baidu.live.l.a.uB().ajF;
            if (oVar != null && (strArr = oVar.RF) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.egT == null) {
                        this.egT = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.egU == null) {
                        this.egU = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void tN(String str2) {
                                if (b.this.egR != null && b.this.egR.sG()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.aSC();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.ahX, b.this.mOtherParams, str2);
                            }
                        };
                        this.egT.setCallback(this.egU);
                    }
                    tL(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSC() {
        if (this.egS != null) {
            this.egS.removeCallbacksAndMessages(null);
        }
        aSD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        if (this.egT != null) {
            this.egT.setVisibility(8);
        }
    }

    private void tL(String str) {
        this.egQ = true;
        tM(str);
        this.egS.sendEmptyMessageDelayed(2, 5000L);
        aeD();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.ahX, this.mOtherParams, str);
    }

    private void tM(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.egT) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.egP) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.egT, layoutParams);
            }
            this.egT.setText(str);
            this.egT.setVisibility(0);
        }
    }

    private void aeD() {
        String b = com.baidu.live.utils.i.b(new Date());
        if (b.equals(this.egN.date)) {
            this.egN.dNf++;
        } else {
            this.egN.date = b;
            this.egN.dNf = 1;
        }
        if (this.egN.dNf >= com.baidu.live.l.a.uB().ajF.RE) {
            aSE();
            aSz();
            return;
        }
        com.baidu.live.c.np().putString("guide_speak_show_times_date", this.egN.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSE() {
        if (this.egS != null) {
            this.egS.removeMessages(1);
        }
        this.egN.egW = true;
        this.egN.date = com.baidu.live.utils.i.b(new Date());
        com.baidu.live.c.np().putString("guide_speak_show_times_date", this.egN.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends Handler {
        private final WeakReference<b> dVj;

        a(b bVar) {
            this.dVj = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.dVj.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.aSB();
                        return;
                    case 2:
                        bVar.aSD();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
