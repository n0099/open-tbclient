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
    private boolean fcD = true;
    private boolean fcE = false;
    private c fcM;
    private CustomMessageListener fcN;
    private boolean fcO;
    private boolean fcP;
    private com.baidu.tieba.ala.liveroom.guideim.a fcQ;
    private Handler fcR;
    private GuideImInputView fcS;
    private GuideImInputView.a fcT;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bmD();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fcO = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fcQ = aVar;
    }

    public void c(m mVar, String str) {
        this.fcP = false;
        bmE();
        bmR();
        bmQ();
        this.mVid = "";
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.feed_id != null) {
            this.mVid = mVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bmT();
    }

    public void js(boolean z) {
        this.fcD = z;
        bmP();
    }

    public void jt(boolean z) {
        this.fcE = z;
        bmP();
    }

    private void bmP() {
        if (this.fcR != null) {
            if (!this.fcD || this.fcE) {
                bmW();
            }
        }
    }

    public void bmC() {
        this.fcP = false;
        bmV();
        bmS();
    }

    public void release() {
        if (this.fcR != null) {
            this.fcR.removeCallbacksAndMessages(null);
        }
        bmS();
        xl();
    }

    private void bmD() {
        this.fcM = new c();
        String string = com.baidu.live.c.pr().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcM.fcV = jSONObject.optBoolean("hasInput");
                    if (!this.fcM.fcV) {
                        this.fcM.date = b;
                        this.fcM.eGI = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmE() {
        if (this.fcM == null) {
            this.fcM = new c();
        }
        String str = this.fcM.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcM.fcV = false;
            this.fcM.eGI = 0;
        }
    }

    private void bmQ() {
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

    private void bmR() {
        if (!this.fcM.fcV) {
            this.fcN = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bmX();
                }
            };
            MessageManager.getInstance().registerListener(this.fcN);
        }
    }

    private void bmS() {
        if (this.fcN != null) {
            MessageManager.getInstance().unRegisterListener(this.fcN);
        }
    }

    private void bmT() {
        int i;
        bmV();
        if (!this.fcP && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fcM.fcV) {
                bmS();
                return;
            }
            t tVar = com.baidu.live.v.a.zl().awB;
            if (tVar != null && (i = tVar.aaw) > 0) {
                if (!j.b(new Date()).equals(this.fcM.date) || this.fcM.eGI < tVar.aax) {
                    if (this.fcR == null) {
                        this.fcR = new a(this);
                    }
                    this.fcR.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmU() {
        String[] strArr;
        int length;
        this.fcP = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fcD && !this.fcE) {
            if (this.fcM.fcV) {
                bmS();
                return;
            }
            t tVar = com.baidu.live.v.a.zl().awB;
            if (tVar != null && (strArr = tVar.aay) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fcS == null) {
                        this.fcS = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fcT == null) {
                        this.fcT = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void zd(String str2) {
                                if (b.this.fcQ != null && b.this.fcQ.ws()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bmV();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.fcS.setCallback(this.fcT);
                    }
                    zb(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmV() {
        if (this.fcR != null) {
            this.fcR.removeCallbacksAndMessages(null);
        }
        bmW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmW() {
        if (this.fcS != null) {
            this.fcS.setVisibility(8);
        }
    }

    private void zb(String str) {
        this.fcP = true;
        zc(str);
        this.fcR.sendEmptyMessageDelayed(2, 5000L);
        aye();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void zc(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fcS) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fcO) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fcS, layoutParams);
            }
            this.fcS.setText(str);
            this.fcS.setVisibility(0);
        }
    }

    private void aye() {
        String b = j.b(new Date());
        if (b.equals(this.fcM.date)) {
            this.fcM.eGI++;
        } else {
            this.fcM.date = b;
            this.fcM.eGI = 1;
        }
        if (this.fcM.eGI >= com.baidu.live.v.a.zl().awB.aax) {
            bmX();
            bmS();
            return;
        }
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcM.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmX() {
        if (this.fcR != null) {
            this.fcR.removeMessages(1);
        }
        this.fcM.fcV = true;
        this.fcM.date = j.b(new Date());
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcM.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> eQb;

        a(b bVar) {
            this.eQb = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eQb.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bmU();
                        return;
                    case 2:
                        bVar.bmW();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
