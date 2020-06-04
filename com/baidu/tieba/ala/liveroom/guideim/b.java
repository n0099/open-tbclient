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
import com.baidu.live.data.y;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
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
    private CustomMessageListener aSV;
    private q fHK;
    private boolean fVI = true;
    private boolean fVJ = false;
    private c fVT;
    private CustomMessageListener fVU;
    private boolean fVV;
    private boolean fVW;
    private com.baidu.tieba.ala.liveroom.guideim.a fVX;
    private Handler fVY;
    private GuideImInputView fVZ;
    private GuideImInputView.a fWa;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bBZ();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fVV = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fVX = aVar;
    }

    public void c(q qVar, String str) {
        this.fHK = qVar;
        this.fVW = false;
        bCa();
        bCo();
        bCn();
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bCq();
    }

    public void kQ(boolean z) {
        this.fVI = z;
        bCm();
    }

    public void kR(boolean z) {
        this.fVJ = z;
        bCm();
    }

    private void bCm() {
        if (this.fVY != null) {
            if (!this.fVI || this.fVJ) {
                bCt();
            }
        }
    }

    public void bBY() {
        this.fVW = false;
        bCs();
        bCp();
    }

    public void release() {
        if (this.fVY != null) {
            this.fVY.removeCallbacksAndMessages(null);
        }
        bCp();
        Dx();
    }

    private void bBZ() {
        this.fVT = new c();
        String string = com.baidu.live.c.uN().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fVT.fWc = jSONObject.optBoolean("hasInput");
                    if (!this.fVT.fWc) {
                        this.fVT.fzE = b;
                        this.fVT.fzF = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bCa() {
        if (this.fVT == null) {
            this.fVT = new c();
        }
        String str = this.fVT.fzE;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fVT.fWc = false;
            this.fVT.fzF = 0;
        }
    }

    private void bCn() {
        if (this.aSV == null) {
            this.aSV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aSV);
        }
    }

    private void Dx() {
        if (this.aSV != null) {
            MessageManager.getInstance().unRegisterListener(this.aSV);
        }
    }

    private void bCo() {
        if (!this.fVT.fWc) {
            this.fVU = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bCu();
                }
            };
            MessageManager.getInstance().registerListener(this.fVU);
        }
    }

    private void bCp() {
        if (this.fVU != null) {
            MessageManager.getInstance().unRegisterListener(this.fVU);
        }
    }

    private void bCq() {
        int i;
        bCs();
        if ((this.fHK == null || this.fHK.avC == null || (this.fHK.avC.isUegBlock <= 0 && this.fHK.avC.isBlock <= 0)) && !this.fVW && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fVT.fWc) {
                bCp();
                return;
            }
            y yVar = com.baidu.live.v.a.Ge().aWF;
            if (yVar != null && (i = yVar.ayb) > 0) {
                if (!j.b(new Date()).equals(this.fVT.fzE) || this.fVT.fzF < yVar.ayc) {
                    if (this.fVY == null) {
                        this.fVY = new a(this);
                    }
                    this.fVY.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCr() {
        String[] strArr;
        int length;
        this.fVW = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fVI && !this.fVJ) {
            if (this.fVT.fWc) {
                bCp();
                return;
            }
            y yVar = com.baidu.live.v.a.Ge().aWF;
            if (yVar != null && (strArr = yVar.ayd) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fVZ == null) {
                        this.fVZ = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fWa == null) {
                        this.fWa = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Cx(String str2) {
                                if (b.this.fVX != null && b.this.fVX.CC()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bCs();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.fVZ.setCallback(this.fWa);
                    }
                    Cv(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCs() {
        if (this.fVY != null) {
            this.fVY.removeCallbacksAndMessages(null);
        }
        bCt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCt() {
        if (this.fVZ != null) {
            this.fVZ.setVisibility(8);
        }
    }

    private void Cv(String str) {
        this.fVW = true;
        Cw(str);
        this.fVY.sendEmptyMessageDelayed(2, 5000L);
        aLL();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Cw(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fVZ) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fVV) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fVZ, layoutParams);
            }
            this.fVZ.setText(str);
            this.fVZ.setVisibility(0);
        }
    }

    private void aLL() {
        String b = j.b(new Date());
        if (b.equals(this.fVT.fzE)) {
            this.fVT.fzF++;
        } else {
            this.fVT.fzE = b;
            this.fVT.fzF = 1;
        }
        if (this.fVT.fzF >= com.baidu.live.v.a.Ge().aWF.ayc) {
            bCu();
            bCp();
            return;
        }
        com.baidu.live.c.uN().putString("guide_speak_show_times_date", this.fVT.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCu() {
        if (this.fVY != null) {
            this.fVY.removeMessages(1);
        }
        this.fVT.fWc = true;
        this.fVT.fzE = j.b(new Date());
        com.baidu.live.c.uN().putString("guide_speak_show_times_date", this.fVT.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> fJt;

        a(b bVar) {
            this.fJt = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.fJt.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bCr();
                        return;
                    case 2:
                        bVar.bCt();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
