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
    private CustomMessageListener bci;
    private r bgX;
    private c gAE;
    private CustomMessageListener gAF;
    private boolean gAG;
    private boolean gAH;
    private com.baidu.tieba.ala.liveroom.guideim.a gAI;
    private Handler gAJ;
    private GuideImInputView gAK;
    private GuideImInputView.a gAL;
    private boolean gAt = true;
    private boolean gAu = false;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bSp();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.gAG = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.gAI = aVar;
    }

    public void c(r rVar, String str) {
        this.bgX = rVar;
        this.gAH = false;
        bSq();
        bSE();
        bSD();
        this.mVid = "";
        if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.feed_id != null) {
            this.mVid = rVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bSG();
    }

    public void mi(boolean z) {
        this.gAt = z;
        bSC();
    }

    public void mj(boolean z) {
        this.gAu = z;
        bSC();
    }

    private void bSC() {
        if (this.gAJ != null) {
            if (!this.gAt || this.gAu) {
                bSJ();
            }
        }
    }

    public void KP() {
        this.gAH = false;
        bSI();
        bSF();
    }

    public void release() {
        if (this.gAJ != null) {
            this.gAJ.removeCallbacksAndMessages(null);
        }
        bSF();
        Mp();
    }

    private void bSp() {
        this.gAE = new c();
        String string = com.baidu.live.c.AD().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.gAE.gAN = jSONObject.optBoolean("hasInput");
                    if (!this.gAE.gAN) {
                        this.gAE.date = b;
                        this.gAE.dej = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bSq() {
        if (this.gAE == null) {
            this.gAE = new c();
        }
        String str = this.gAE.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.gAE.gAN = false;
            this.gAE.dej = 0;
        }
    }

    private void bSD() {
        if (this.bci == null) {
            this.bci = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bci);
        }
    }

    private void Mp() {
        if (this.bci != null) {
            MessageManager.getInstance().unRegisterListener(this.bci);
        }
    }

    private void bSE() {
        if (!this.gAE.gAN) {
            this.gAF = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bSK();
                }
            };
            MessageManager.getInstance().registerListener(this.gAF);
        }
    }

    private void bSF() {
        if (this.gAF != null) {
            MessageManager.getInstance().unRegisterListener(this.gAF);
        }
    }

    private void bSG() {
        int i;
        bSI();
        if ((this.bgX == null || this.bgX.aEd == null || (this.bgX.aEd.isUegBlock <= 0 && this.bgX.aEd.isBlock <= 0)) && !this.gAH && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.gAE.gAN) {
                bSF();
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beH;
            if (abVar != null && (i = abVar.aGN) > 0) {
                if (!j.b(new Date()).equals(this.gAE.date) || this.gAE.dej < abVar.aGO) {
                    if (this.gAJ == null) {
                        this.gAJ = new a(this);
                    }
                    this.gAJ.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSH() {
        String[] strArr;
        int length;
        this.gAH = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.gAt && !this.gAu) {
            if (this.gAE.gAN) {
                bSF();
                return;
            }
            ab abVar = com.baidu.live.w.a.Nk().beH;
            if (abVar != null && (strArr = abVar.aGP) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.gAK == null) {
                        this.gAK = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.gAL == null) {
                        this.gAL = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Gg(String str2) {
                                if (b.this.gAI != null && b.this.gAI.Ji()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bSI();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        };
                        this.gAK.setCallback(this.gAL);
                    }
                    Ge(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSI() {
        if (this.gAJ != null) {
            this.gAJ.removeCallbacksAndMessages(null);
        }
        bSJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        if (this.gAK != null) {
            this.gAK.setVisibility(8);
        }
    }

    private void Ge(String str) {
        this.gAH = true;
        Gf(str);
        this.gAJ.sendEmptyMessageDelayed(2, 5000L);
        aZt();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
    }

    private void Gf(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gAK) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.gAG) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.gAK, layoutParams);
            }
            this.gAK.setText(str);
            this.gAK.setVisibility(0);
        }
    }

    private void aZt() {
        String b = j.b(new Date());
        if (b.equals(this.gAE.date)) {
            this.gAE.dej++;
        } else {
            this.gAE.date = b;
            this.gAE.dej = 1;
        }
        if (this.gAE.dej >= com.baidu.live.w.a.Nk().beH.aGO) {
            bSK();
            bSF();
            return;
        }
        com.baidu.live.c.AD().putString("guide_speak_show_times_date", this.gAE.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        if (this.gAJ != null) {
            this.gAJ.removeMessages(1);
        }
        this.gAE.gAN = true;
        this.gAE.date = j.b(new Date());
        com.baidu.live.c.AD().putString("guide_speak_show_times_date", this.gAE.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends Handler {
        private final WeakReference<b> glQ;

        a(b bVar) {
            this.glQ = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.glQ.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bSH();
                        return;
                    case 2:
                        bVar.bSJ();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
