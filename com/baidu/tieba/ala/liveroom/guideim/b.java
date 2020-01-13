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
import com.baidu.live.data.l;
import com.baidu.live.data.s;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.r.a;
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
    private CustomMessageListener aqb;
    private boolean eZA;
    private boolean eZB;
    private com.baidu.tieba.ala.liveroom.guideim.a eZC;
    private Handler eZD;
    private GuideImInputView eZE;
    private GuideImInputView.a eZF;
    private boolean eZp = true;
    private boolean eZq = false;
    private c eZy;
    private CustomMessageListener eZz;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bkR();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.eZA = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.eZC = aVar;
    }

    public void a(l lVar, String str) {
        this.eZB = false;
        bkS();
        blh();
        blg();
        this.mVid = "";
        if (lVar != null && lVar.mLiveInfo != null && lVar.mLiveInfo.feed_id != null) {
            this.mVid = lVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        blj();
    }

    public void jq(boolean z) {
        this.eZp = z;
        blf();
    }

    public void jr(boolean z) {
        this.eZq = z;
        blf();
    }

    private void blf() {
        if (this.eZD != null) {
            if (!this.eZp || this.eZq) {
                blm();
            }
        }
    }

    public void bkQ() {
        this.eZB = false;
        bll();
        bli();
    }

    public void release() {
        if (this.eZD != null) {
            this.eZD.removeCallbacksAndMessages(null);
        }
        bli();
        bkU();
    }

    private void bkR() {
        this.eZy = new c();
        String string = com.baidu.live.c.oJ().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.eZy.eZH = jSONObject.optBoolean("hasInput");
                    if (!this.eZy.eZH) {
                        this.eZy.date = b;
                        this.eZy.eCy = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bkS() {
        if (this.eZy == null) {
            this.eZy = new c();
        }
        String str = this.eZy.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.eZy.eZH = false;
            this.eZy.eCy = 0;
        }
    }

    private void blg() {
        if (this.aqb == null) {
            this.aqb = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aqb);
        }
    }

    private void bkU() {
        if (this.aqb != null) {
            MessageManager.getInstance().unRegisterListener(this.aqb);
        }
    }

    private void blh() {
        if (!this.eZy.eZH) {
            this.eZz = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bln();
                }
            };
            MessageManager.getInstance().registerListener(this.eZz);
        }
    }

    private void bli() {
        if (this.eZz != null) {
            MessageManager.getInstance().unRegisterListener(this.eZz);
        }
    }

    private void blj() {
        int i;
        bll();
        if (!this.eZB && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.eZy.eZH) {
                bli();
                return;
            }
            s sVar = com.baidu.live.s.a.wR().asq;
            if (sVar != null && (i = sVar.YE) > 0) {
                if (!j.b(new Date()).equals(this.eZy.date) || this.eZy.eCy < sVar.YF) {
                    if (this.eZD == null) {
                        this.eZD = new a(this);
                    }
                    this.eZD.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blk() {
        String[] strArr;
        int length;
        this.eZB = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.eZp && !this.eZq) {
            if (this.eZy.eZH) {
                bli();
                return;
            }
            s sVar = com.baidu.live.s.a.wR().asq;
            if (sVar != null && (strArr = sVar.YG) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.eZE == null) {
                        this.eZE = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.eZF == null) {
                        this.eZF = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void yL(String str2) {
                                if (b.this.eZC != null && b.this.eZC.uO()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bll();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.eZE.setCallback(this.eZF);
                    }
                    yJ(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        if (this.eZD != null) {
            this.eZD.removeCallbacksAndMessages(null);
        }
        blm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blm() {
        if (this.eZE != null) {
            this.eZE.setVisibility(8);
        }
    }

    private void yJ(String str) {
        this.eZB = true;
        yK(str);
        this.eZD.sendEmptyMessageDelayed(2, 5000L);
        avP();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void yK(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.eZE) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.eZA) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.eZE, layoutParams);
            }
            this.eZE.setText(str);
            this.eZE.setVisibility(0);
        }
    }

    private void avP() {
        String b = j.b(new Date());
        if (b.equals(this.eZy.date)) {
            this.eZy.eCy++;
        } else {
            this.eZy.date = b;
            this.eZy.eCy = 1;
        }
        if (this.eZy.eCy >= com.baidu.live.s.a.wR().asq.YF) {
            bln();
            bli();
            return;
        }
        com.baidu.live.c.oJ().putString("guide_speak_show_times_date", this.eZy.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        if (this.eZD != null) {
            this.eZD.removeMessages(1);
        }
        this.eZy.eZH = true;
        this.eZy.date = j.b(new Date());
        com.baidu.live.c.oJ().putString("guide_speak_show_times_date", this.eZy.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        private final WeakReference<b> eLX;

        a(b bVar) {
            this.eLX = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eLX.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.blk();
                        return;
                    case 2:
                        bVar.blm();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
