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
import com.baidu.live.d;
import com.baidu.live.data.aj;
import com.baidu.live.data.w;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener bkc;
    private w bpz;
    private boolean hdV = true;
    private boolean hdW = false;
    private c heg;
    private CustomMessageListener heh;
    private boolean hei;
    private boolean hej;
    private com.baidu.tieba.ala.liveroom.guideim.a hek;
    private Handler hel;
    private GuideImInputView hem;
    private GuideImInputView.a hen;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        cah();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.hei = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hek = aVar;
    }

    public void c(w wVar, String str) {
        this.bpz = wVar;
        this.hej = false;
        cai();
        cau();
        cat();
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        caw();
    }

    public void nf(boolean z) {
        this.hdV = z;
        cas();
    }

    public void ng(boolean z) {
        this.hdW = z;
        cas();
    }

    private void cas() {
        if (this.hel != null) {
            if (!this.hdV || this.hdW) {
                caz();
            }
        }
    }

    public void Kn() {
        this.hej = false;
        cay();
        cav();
    }

    public void release() {
        if (this.hel != null) {
            this.hel.removeCallbacksAndMessages(null);
        }
        cav();
        OA();
    }

    private void cah() {
        this.heg = new c();
        String string = d.AZ().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.heg.hep = jSONObject.optBoolean("hasInput");
                    if (!this.heg.hep) {
                        this.heg.date = b;
                        this.heg.dAU = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cai() {
        if (this.heg == null) {
            this.heg = new c();
        }
        String str = this.heg.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.heg.hep = false;
            this.heg.dAU = 0;
        }
    }

    private void cat() {
        if (this.bkc == null) {
            this.bkc = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bkc);
        }
    }

    private void OA() {
        if (this.bkc != null) {
            MessageManager.getInstance().unRegisterListener(this.bkc);
        }
    }

    private void cau() {
        if (!this.heg.hep) {
            this.heh = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.caA();
                }
            };
            MessageManager.getInstance().registerListener(this.heh);
        }
    }

    private void cav() {
        if (this.heh != null) {
            MessageManager.getInstance().unRegisterListener(this.heh);
        }
    }

    private void caw() {
        int i;
        cay();
        if ((this.bpz == null || this.bpz.aIA == null || (this.bpz.aIA.isUegBlock <= 0 && this.bpz.aIA.isBlock <= 0)) && !this.hej && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.heg.hep) {
                cav();
                return;
            }
            aj ajVar = com.baidu.live.z.a.Pq().bmJ;
            if (ajVar != null && (i = ajVar.aLM) > 0) {
                if (!k.b(new Date()).equals(this.heg.date) || this.heg.dAU < ajVar.aLN) {
                    if (this.hel == null) {
                        this.hel = new a(this);
                    }
                    this.hel.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cax() {
        String[] strArr;
        int length;
        this.hej = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hdV && !this.hdW) {
            if (this.heg.hep) {
                cav();
                return;
            }
            aj ajVar = com.baidu.live.z.a.Pq().bmJ;
            if (ajVar != null && (strArr = ajVar.aLO) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hem == null) {
                        this.hem = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hen == null) {
                        this.hen = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void HQ(String str2) {
                                if (b.this.hek != null && b.this.hek.Lm()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cay();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        };
                        this.hem.setCallback(this.hen);
                    }
                    HO(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cay() {
        if (this.hel != null) {
            this.hel.removeCallbacksAndMessages(null);
        }
        caz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caz() {
        if (this.hem != null) {
            this.hem.setVisibility(8);
        }
    }

    private void HO(String str) {
        this.hej = true;
        HP(str);
        this.hel.sendEmptyMessageDelayed(2, 5000L);
        beH();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
    }

    private void HP(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hem) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.hei) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hem, layoutParams);
            }
            this.hem.setText(str);
            this.hem.setVisibility(0);
        }
    }

    private void beH() {
        String b = k.b(new Date());
        if (b.equals(this.heg.date)) {
            this.heg.dAU++;
        } else {
            this.heg.date = b;
            this.heg.dAU = 1;
        }
        if (this.heg.dAU >= com.baidu.live.z.a.Pq().bmJ.aLN) {
            caA();
            cav();
            return;
        }
        d.AZ().putString("guide_speak_show_times_date", this.heg.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        if (this.hel != null) {
            this.hel.removeMessages(1);
        }
        this.heg.hep = true;
        this.heg.date = k.b(new Date());
        d.AZ().putString("guide_speak_show_times_date", this.heg.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> gPi;

        a(b bVar) {
            this.gPi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.gPi.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cax();
                        return;
                    case 2:
                        bVar.caz();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
