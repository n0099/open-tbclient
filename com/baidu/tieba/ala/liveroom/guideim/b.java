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
import com.baidu.live.data.q;
import com.baidu.live.data.z;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private CustomMessageListener aVB;
    private q fST;
    private boolean giF = true;
    private boolean giG = false;
    private c giQ;
    private CustomMessageListener giR;
    private boolean giS;
    private boolean giT;
    private com.baidu.tieba.ala.liveroom.guideim.a giU;
    private Handler giV;
    private GuideImInputView giW;
    private GuideImInputView.a giX;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bFg();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.giS = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.giU = aVar;
    }

    public void c(q qVar, String str) {
        this.fST = qVar;
        this.giT = false;
        bFh();
        bFv();
        bFu();
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bFx();
    }

    public void lb(boolean z) {
        this.giF = z;
        bFt();
    }

    public void lc(boolean z) {
        this.giG = z;
        bFt();
    }

    private void bFt() {
        if (this.giV != null) {
            if (!this.giF || this.giG) {
                bFA();
            }
        }
    }

    public void Fo() {
        this.giT = false;
        bFz();
        bFw();
    }

    public void release() {
        if (this.giV != null) {
            this.giV.removeCallbacksAndMessages(null);
        }
        bFw();
        DZ();
    }

    private void bFg() {
        this.giQ = new c();
        String string = com.baidu.live.c.vf().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.giQ.giZ = jSONObject.optBoolean("hasInput");
                    if (!this.giQ.giZ) {
                        this.giQ.date = b;
                        this.giQ.fKO = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bFh() {
        if (this.giQ == null) {
            this.giQ = new c();
        }
        String str = this.giQ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.giQ.giZ = false;
            this.giQ.fKO = 0;
        }
    }

    private void bFu() {
        if (this.aVB == null) {
            this.aVB = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aVB);
        }
    }

    private void DZ() {
        if (this.aVB != null) {
            MessageManager.getInstance().unRegisterListener(this.aVB);
        }
    }

    private void bFv() {
        if (!this.giQ.giZ) {
            this.giR = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bFB();
                }
            };
            MessageManager.getInstance().registerListener(this.giR);
        }
    }

    private void bFw() {
        if (this.giR != null) {
            MessageManager.getInstance().unRegisterListener(this.giR);
        }
    }

    private void bFx() {
        int i;
        bFz();
        if ((this.fST == null || this.fST.axI == null || (this.fST.axI.isUegBlock <= 0 && this.fST.axI.isBlock <= 0)) && !this.giT && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.giQ.giZ) {
                bFw();
                return;
            }
            z zVar = com.baidu.live.v.a.Hm().aZp;
            if (zVar != null && (i = zVar.aAq) > 0) {
                if (!j.b(new Date()).equals(this.giQ.date) || this.giQ.fKO < zVar.aAr) {
                    if (this.giV == null) {
                        this.giV = new a(this);
                    }
                    this.giV.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFy() {
        String[] strArr;
        int length;
        this.giT = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.giF && !this.giG) {
            if (this.giQ.giZ) {
                bFw();
                return;
            }
            z zVar = com.baidu.live.v.a.Hm().aZp;
            if (zVar != null && (strArr = zVar.aAs) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.giW == null) {
                        this.giW = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.giX == null) {
                        this.giX = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void CW(String str2) {
                                if (b.this.giU != null && b.this.giU.Dd()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bFz();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.giW.setCallback(this.giX);
                    }
                    CU(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFz() {
        if (this.giV != null) {
            this.giV.removeCallbacksAndMessages(null);
        }
        bFA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFA() {
        if (this.giW != null) {
            this.giW.setVisibility(8);
        }
    }

    private void CU(String str) {
        this.giT = true;
        CV(str);
        this.giV.sendEmptyMessageDelayed(2, 5000L);
        aNp();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void CV(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.giW) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.giS) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.giW, layoutParams);
            }
            this.giW.setText(str);
            this.giW.setVisibility(0);
        }
    }

    private void aNp() {
        String b = j.b(new Date());
        if (b.equals(this.giQ.date)) {
            this.giQ.fKO++;
        } else {
            this.giQ.date = b;
            this.giQ.fKO = 1;
        }
        if (this.giQ.fKO >= com.baidu.live.v.a.Hm().aZp.aAr) {
            bFB();
            bFw();
            return;
        }
        com.baidu.live.c.vf().putString("guide_speak_show_times_date", this.giQ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (this.giV != null) {
            this.giV.removeMessages(1);
        }
        this.giQ.giZ = true;
        this.giQ.date = j.b(new Date());
        com.baidu.live.c.vf().putString("guide_speak_show_times_date", this.giQ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> bdn;

        a(b bVar) {
            this.bdn = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.bdn.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bFy();
                        return;
                    case 2:
                        bVar.bFA();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
