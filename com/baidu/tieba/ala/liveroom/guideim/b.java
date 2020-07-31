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
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener aWT;
    private q fYm;
    private boolean gnD = true;
    private boolean gnE = false;
    private c gnO;
    private CustomMessageListener gnP;
    private boolean gnQ;
    private boolean gnR;
    private com.baidu.tieba.ala.liveroom.guideim.a gnS;
    private Handler gnT;
    private GuideImInputView gnU;
    private GuideImInputView.a gnV;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bIo();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.gnQ = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.gnS = aVar;
    }

    public void c(q qVar, String str) {
        this.fYm = qVar;
        this.gnR = false;
        bIp();
        bID();
        bIC();
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bIF();
    }

    public void lE(boolean z) {
        this.gnD = z;
        bIB();
    }

    public void lF(boolean z) {
        this.gnE = z;
        bIB();
    }

    private void bIB() {
        if (this.gnT != null) {
            if (!this.gnD || this.gnE) {
                bII();
            }
        }
    }

    public void Fi() {
        this.gnR = false;
        bIH();
        bIE();
    }

    public void release() {
        if (this.gnT != null) {
            this.gnT.removeCallbacksAndMessages(null);
        }
        bIE();
        GD();
    }

    private void bIo() {
        this.gnO = new c();
        String string = com.baidu.live.c.vf().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gnO.gnX = jSONObject.optBoolean("hasInput");
                    if (!this.gnO.gnX) {
                        this.gnO.date = b;
                        this.gnO.cVg = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bIp() {
        if (this.gnO == null) {
            this.gnO = new c();
        }
        String str = this.gnO.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gnO.gnX = false;
            this.gnO.cVg = 0;
        }
    }

    private void bIC() {
        if (this.aWT == null) {
            this.aWT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aWT);
        }
    }

    private void GD() {
        if (this.aWT != null) {
            MessageManager.getInstance().unRegisterListener(this.aWT);
        }
    }

    private void bID() {
        if (!this.gnO.gnX) {
            this.gnP = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bIJ();
                }
            };
            MessageManager.getInstance().registerListener(this.gnP);
        }
    }

    private void bIE() {
        if (this.gnP != null) {
            MessageManager.getInstance().unRegisterListener(this.gnP);
        }
    }

    private void bIF() {
        int i;
        bIH();
        if ((this.fYm == null || this.fYm.ayV == null || (this.fYm.ayV.isUegBlock <= 0 && this.fYm.ayV.isBlock <= 0)) && !this.gnR && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.gnO.gnX) {
                bIE();
                return;
            }
            z zVar = com.baidu.live.v.a.Hs().aZn;
            if (zVar != null && (i = zVar.aBD) > 0) {
                if (!j.b(new Date()).equals(this.gnO.date) || this.gnO.cVg < zVar.aBE) {
                    if (this.gnT == null) {
                        this.gnT = new a(this);
                    }
                    this.gnT.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIG() {
        String[] strArr;
        int length;
        this.gnR = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.gnD && !this.gnE) {
            if (this.gnO.gnX) {
                bIE();
                return;
            }
            z zVar = com.baidu.live.v.a.Hs().aZn;
            if (zVar != null && (strArr = zVar.aBF) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.gnU == null) {
                        this.gnU = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.gnV == null) {
                        this.gnV = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void DI(String str2) {
                                if (b.this.gnS != null && b.this.gnS.DF()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bIH();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.gnU.setCallback(this.gnV);
                    }
                    DG(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIH() {
        if (this.gnT != null) {
            this.gnT.removeCallbacksAndMessages(null);
        }
        bII();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.gnU != null) {
            this.gnU.setVisibility(8);
        }
    }

    private void DG(String str) {
        this.gnR = true;
        DH(str);
        this.gnT.sendEmptyMessageDelayed(2, 5000L);
        aRd();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void DH(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gnU) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.gnQ) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.gnU, layoutParams);
            }
            this.gnU.setText(str);
            this.gnU.setVisibility(0);
        }
    }

    private void aRd() {
        String b = j.b(new Date());
        if (b.equals(this.gnO.date)) {
            this.gnO.cVg++;
        } else {
            this.gnO.date = b;
            this.gnO.cVg = 1;
        }
        if (this.gnO.cVg >= com.baidu.live.v.a.Hs().aZn.aBE) {
            bIJ();
            bIE();
            return;
        }
        com.baidu.live.c.vf().putString("guide_speak_show_times_date", this.gnO.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        if (this.gnT != null) {
            this.gnT.removeMessages(1);
        }
        this.gnO.gnX = true;
        this.gnO.date = j.b(new Date());
        com.baidu.live.c.vf().putString("guide_speak_show_times_date", this.gnO.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> bdF;

        a(b bVar) {
            this.bdF = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.bdF.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bIG();
                        return;
                    case 2:
                        bVar.bII();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
