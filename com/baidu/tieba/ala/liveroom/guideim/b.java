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
import com.baidu.live.data.m;
import com.baidu.live.data.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
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
    private CustomMessageListener att;
    private boolean fcC = true;
    private boolean fcD = false;
    private c fcL;
    private CustomMessageListener fcM;
    private boolean fcN;
    private boolean fcO;
    private com.baidu.tieba.ala.liveroom.guideim.a fcP;
    private Handler fcQ;
    private GuideImInputView fcR;
    private GuideImInputView.a fcS;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bmB();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fcN = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fcP = aVar;
    }

    public void c(m mVar, String str) {
        this.fcO = false;
        bmC();
        bmP();
        bmO();
        this.mVid = "";
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.feed_id != null) {
            this.mVid = mVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bmR();
    }

    public void js(boolean z) {
        this.fcC = z;
        bmN();
    }

    public void jt(boolean z) {
        this.fcD = z;
        bmN();
    }

    private void bmN() {
        if (this.fcQ != null) {
            if (!this.fcC || this.fcD) {
                bmU();
            }
        }
    }

    public void bmA() {
        this.fcO = false;
        bmT();
        bmQ();
    }

    public void release() {
        if (this.fcQ != null) {
            this.fcQ.removeCallbacksAndMessages(null);
        }
        bmQ();
        xl();
    }

    private void bmB() {
        this.fcL = new c();
        String string = com.baidu.live.c.pr().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcL.fcU = jSONObject.optBoolean("hasInput");
                    if (!this.fcL.fcU) {
                        this.fcL.date = b;
                        this.fcL.eGH = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmC() {
        if (this.fcL == null) {
            this.fcL = new c();
        }
        String str = this.fcL.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcL.fcU = false;
            this.fcL.eGH = 0;
        }
    }

    private void bmO() {
        if (this.att == null) {
            this.att = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.att);
        }
    }

    private void xl() {
        if (this.att != null) {
            MessageManager.getInstance().unRegisterListener(this.att);
        }
    }

    private void bmP() {
        if (!this.fcL.fcU) {
            this.fcM = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bmV();
                }
            };
            MessageManager.getInstance().registerListener(this.fcM);
        }
    }

    private void bmQ() {
        if (this.fcM != null) {
            MessageManager.getInstance().unRegisterListener(this.fcM);
        }
    }

    private void bmR() {
        int i;
        bmT();
        if (!this.fcO && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fcL.fcU) {
                bmQ();
                return;
            }
            t tVar = com.baidu.live.v.a.zj().awA;
            if (tVar != null && (i = tVar.aaw) > 0) {
                if (!j.b(new Date()).equals(this.fcL.date) || this.fcL.eGH < tVar.aax) {
                    if (this.fcQ == null) {
                        this.fcQ = new a(this);
                    }
                    this.fcQ.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmS() {
        String[] strArr;
        int length;
        this.fcO = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fcC && !this.fcD) {
            if (this.fcL.fcU) {
                bmQ();
                return;
            }
            t tVar = com.baidu.live.v.a.zj().awA;
            if (tVar != null && (strArr = tVar.aay) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fcR == null) {
                        this.fcR = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fcS == null) {
                        this.fcS = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void zd(String str2) {
                                if (b.this.fcP != null && b.this.fcP.ws()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bmT();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.fcR.setCallback(this.fcS);
                    }
                    zb(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmT() {
        if (this.fcQ != null) {
            this.fcQ.removeCallbacksAndMessages(null);
        }
        bmU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmU() {
        if (this.fcR != null) {
            this.fcR.setVisibility(8);
        }
    }

    private void zb(String str) {
        this.fcO = true;
        zc(str);
        this.fcQ.sendEmptyMessageDelayed(2, 5000L);
        ayc();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void zc(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fcR) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fcN) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fcR, layoutParams);
            }
            this.fcR.setText(str);
            this.fcR.setVisibility(0);
        }
    }

    private void ayc() {
        String b = j.b(new Date());
        if (b.equals(this.fcL.date)) {
            this.fcL.eGH++;
        } else {
            this.fcL.date = b;
            this.fcL.eGH = 1;
        }
        if (this.fcL.eGH >= com.baidu.live.v.a.zj().awA.aax) {
            bmV();
            bmQ();
            return;
        }
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcL.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmV() {
        if (this.fcQ != null) {
            this.fcQ.removeMessages(1);
        }
        this.fcL.fcU = true;
        this.fcL.date = j.b(new Date());
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcL.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> eQa;

        a(b bVar) {
            this.eQa = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eQa.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bmS();
                        return;
                    case 2:
                        bVar.bmU();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
