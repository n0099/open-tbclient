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
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private CustomMessageListener apo;
    private boolean eWQ = true;
    private boolean eWR = false;
    private c eWZ;
    private CustomMessageListener eXa;
    private boolean eXb;
    private boolean eXc;
    private com.baidu.tieba.ala.liveroom.guideim.a eXd;
    private Handler eXe;
    private GuideImInputView eXf;
    private GuideImInputView.a eXg;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bjV();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.eXb = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.eXd = aVar;
    }

    public void a(k kVar, String str) {
        this.eXc = false;
        bjW();
        bkl();
        bkk();
        this.mVid = "";
        if (kVar != null && kVar.mLiveInfo != null && kVar.mLiveInfo.feed_id != null) {
            this.mVid = kVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bkn();
    }

    public void jf(boolean z) {
        this.eWQ = z;
        bkj();
    }

    public void jg(boolean z) {
        this.eWR = z;
        bkj();
    }

    private void bkj() {
        if (this.eXe != null) {
            if (!this.eWQ || this.eWR) {
                bkq();
            }
        }
    }

    public void bjU() {
        this.eXc = false;
        bkp();
        bkm();
    }

    public void release() {
        if (this.eXe != null) {
            this.eXe.removeCallbacksAndMessages(null);
        }
        bkm();
        bjY();
    }

    private void bjV() {
        this.eWZ = new c();
        String string = com.baidu.live.c.oI().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.eWZ.eXi = jSONObject.optBoolean("hasInput");
                    if (!this.eWZ.eXi) {
                        this.eWZ.date = b;
                        this.eWZ.eBn = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bjW() {
        if (this.eWZ == null) {
            this.eWZ = new c();
        }
        String str = this.eWZ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.eWZ.eXi = false;
            this.eWZ.eBn = 0;
        }
    }

    private void bkk() {
        if (this.apo == null) {
            this.apo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.apo);
        }
    }

    private void bjY() {
        if (this.apo != null) {
            MessageManager.getInstance().unRegisterListener(this.apo);
        }
    }

    private void bkl() {
        if (!this.eWZ.eXi) {
            this.eXa = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bkr();
                }
            };
            MessageManager.getInstance().registerListener(this.eXa);
        }
    }

    private void bkm() {
        if (this.eXa != null) {
            MessageManager.getInstance().unRegisterListener(this.eXa);
        }
    }

    private void bkn() {
        int i;
        bkp();
        if (!this.eXc && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.eWZ.eXi) {
                bkm();
                return;
            }
            q qVar = com.baidu.live.r.a.wA().arE;
            if (qVar != null && (i = qVar.Ys) > 0) {
                if (!j.b(new Date()).equals(this.eWZ.date) || this.eWZ.eBn < qVar.Yt) {
                    if (this.eXe == null) {
                        this.eXe = new a(this);
                    }
                    this.eXe.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        String[] strArr;
        int length;
        this.eXc = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.eWQ && !this.eWR) {
            if (this.eWZ.eXi) {
                bkm();
                return;
            }
            q qVar = com.baidu.live.r.a.wA().arE;
            if (qVar != null && (strArr = qVar.Yu) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.eXf == null) {
                        this.eXf = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.eXg == null) {
                        this.eXg = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void yC(String str2) {
                                if (b.this.eXd != null && b.this.eXd.ux()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bkp();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.eXf.setCallback(this.eXg);
                    }
                    yA(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        if (this.eXe != null) {
            this.eXe.removeCallbacksAndMessages(null);
        }
        bkq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkq() {
        if (this.eXf != null) {
            this.eXf.setVisibility(8);
        }
    }

    private void yA(String str) {
        this.eXc = true;
        yB(str);
        this.eXe.sendEmptyMessageDelayed(2, 5000L);
        avw();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void yB(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.eXf) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.eXb) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.eXf, layoutParams);
            }
            this.eXf.setText(str);
            this.eXf.setVisibility(0);
        }
    }

    private void avw() {
        String b = j.b(new Date());
        if (b.equals(this.eWZ.date)) {
            this.eWZ.eBn++;
        } else {
            this.eWZ.date = b;
            this.eWZ.eBn = 1;
        }
        if (this.eWZ.eBn >= com.baidu.live.r.a.wA().arE.Yt) {
            bkr();
            bkm();
            return;
        }
        com.baidu.live.c.oI().putString("guide_speak_show_times_date", this.eWZ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkr() {
        if (this.eXe != null) {
            this.eXe.removeMessages(1);
        }
        this.eWZ.eXi = true;
        this.eWZ.date = j.b(new Date());
        com.baidu.live.c.oI().putString("guide_speak_show_times_date", this.eWZ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private final WeakReference<b> eKK;

        a(b bVar) {
            this.eKK = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eKK.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bko();
                        return;
                    case 2:
                        bVar.bkq();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
