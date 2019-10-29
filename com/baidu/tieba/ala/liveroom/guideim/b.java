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
    private CustomMessageListener ahD;
    private String aiq;
    private c ehE;
    private CustomMessageListener ehF;
    private boolean ehG;
    private boolean ehH;
    private com.baidu.tieba.ala.liveroom.guideim.a ehI;
    private Handler ehJ;
    private GuideImInputView ehK;
    private GuideImInputView.a ehL;
    private boolean ehu = true;
    private boolean ehv = false;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        aSk();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.ehG = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.ehI = aVar;
    }

    public void a(i iVar, String str) {
        this.ehH = false;
        aSl();
        aSA();
        aSz();
        this.aiq = "";
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.feed_id != null) {
            this.aiq = iVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        aSC();
    }

    public void hP(boolean z) {
        this.ehu = z;
        aSy();
    }

    public void hQ(boolean z) {
        this.ehv = z;
        aSy();
    }

    private void aSy() {
        if (this.ehJ != null) {
            if (!this.ehu || this.ehv) {
                aSF();
            }
        }
    }

    public void aSj() {
        this.ehH = false;
        aSE();
        aSB();
    }

    public void release() {
        if (this.ehJ != null) {
            this.ehJ.removeCallbacksAndMessages(null);
        }
        aSB();
        aSn();
    }

    private void aSk() {
        this.ehE = new c();
        String string = com.baidu.live.c.np().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = com.baidu.live.utils.i.b(new Date());
                if (optString.equals(b)) {
                    this.ehE.ehN = jSONObject.optBoolean("hasInput");
                    if (!this.ehE.ehN) {
                        this.ehE.date = b;
                        this.ehE.dNW = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void aSl() {
        if (this.ehE == null) {
            this.ehE = new c();
        }
        String str = this.ehE.date;
        if (!TextUtils.isEmpty(str) && !str.equals(com.baidu.live.utils.i.b(new Date()))) {
            this.ehE.ehN = false;
            this.ehE.dNW = 0;
        }
    }

    private void aSz() {
        if (this.ahD == null) {
            this.ahD = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.ahD);
        }
    }

    private void aSn() {
        if (this.ahD != null) {
            MessageManager.getInstance().unRegisterListener(this.ahD);
        }
    }

    private void aSA() {
        if (!this.ehE.ehN) {
            this.ehF = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.aSG();
                }
            };
            MessageManager.getInstance().registerListener(this.ehF);
        }
    }

    private void aSB() {
        if (this.ehF != null) {
            MessageManager.getInstance().unRegisterListener(this.ehF);
        }
    }

    private void aSC() {
        int i;
        aSE();
        if (!this.ehH) {
            if (this.ehE.ehN) {
                aSB();
                return;
            }
            o oVar = com.baidu.live.l.a.uA().ajX;
            if (oVar != null && (i = oVar.Sg) > 0) {
                if (!com.baidu.live.utils.i.b(new Date()).equals(this.ehE.date) || this.ehE.dNW < oVar.Sh) {
                    if (this.ehJ == null) {
                        this.ehJ = new a(this);
                    }
                    this.ehJ.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        String[] strArr;
        int length;
        this.ehH = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.ehu && !this.ehv) {
            if (this.ehE.ehN) {
                aSB();
                return;
            }
            o oVar = com.baidu.live.l.a.uA().ajX;
            if (oVar != null && (strArr = oVar.Si) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.ehK == null) {
                        this.ehK = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.ehL == null) {
                        this.ehL = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void tN(String str2) {
                                if (b.this.ehI != null && b.this.ehI.sF()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.aSE();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.aiq, b.this.mOtherParams, str2);
                            }
                        };
                        this.ehK.setCallback(this.ehL);
                    }
                    tL(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSE() {
        if (this.ehJ != null) {
            this.ehJ.removeCallbacksAndMessages(null);
        }
        aSF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSF() {
        if (this.ehK != null) {
            this.ehK.setVisibility(8);
        }
    }

    private void tL(String str) {
        this.ehH = true;
        tM(str);
        this.ehJ.sendEmptyMessageDelayed(2, 5000L);
        aeF();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.aiq, this.mOtherParams, str);
    }

    private void tM(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.ehK) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.ehG) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.ehK, layoutParams);
            }
            this.ehK.setText(str);
            this.ehK.setVisibility(0);
        }
    }

    private void aeF() {
        String b = com.baidu.live.utils.i.b(new Date());
        if (b.equals(this.ehE.date)) {
            this.ehE.dNW++;
        } else {
            this.ehE.date = b;
            this.ehE.dNW = 1;
        }
        if (this.ehE.dNW >= com.baidu.live.l.a.uA().ajX.Sh) {
            aSG();
            aSB();
            return;
        }
        com.baidu.live.c.np().putString("guide_speak_show_times_date", this.ehE.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSG() {
        if (this.ehJ != null) {
            this.ehJ.removeMessages(1);
        }
        this.ehE.ehN = true;
        this.ehE.date = com.baidu.live.utils.i.b(new Date());
        com.baidu.live.c.np().putString("guide_speak_show_times_date", this.ehE.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends Handler {
        private final WeakReference<b> dWa;

        a(b bVar) {
            this.dWa = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.dWa.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.aSD();
                        return;
                    case 2:
                        bVar.aSF();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
