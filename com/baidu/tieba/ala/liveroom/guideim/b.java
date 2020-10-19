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
import com.baidu.live.data.ag;
import com.baidu.live.data.u;
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
    private CustomMessageListener biH;
    private u bnM;
    private GuideImInputView.a gSA;
    private boolean gSi = true;
    private boolean gSj = false;
    private c gSt;
    private CustomMessageListener gSu;
    private boolean gSv;
    private boolean gSw;
    private com.baidu.tieba.ala.liveroom.guideim.a gSx;
    private Handler gSy;
    private GuideImInputView gSz;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bXi();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.gSv = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.gSx = aVar;
    }

    public void c(u uVar, String str) {
        this.bnM = uVar;
        this.gSw = false;
        bXj();
        bXv();
        bXu();
        this.mVid = "";
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.feed_id != null) {
            this.mVid = uVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bXx();
    }

    public void mP(boolean z) {
        this.gSi = z;
        bXt();
    }

    public void mQ(boolean z) {
        this.gSj = z;
        bXt();
    }

    private void bXt() {
        if (this.gSy != null) {
            if (!this.gSi || this.gSj) {
                bXA();
            }
        }
    }

    public void JT() {
        this.gSw = false;
        bXz();
        bXw();
    }

    public void release() {
        if (this.gSy != null) {
            this.gSy.removeCallbacksAndMessages(null);
        }
        bXw();
        Oc();
    }

    private void bXi() {
        this.gSt = new c();
        String string = com.baidu.live.c.AZ().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.gSt.gSC = jSONObject.optBoolean("hasInput");
                    if (!this.gSt.gSC) {
                        this.gSt.date = b;
                        this.gSt.dsw = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bXj() {
        if (this.gSt == null) {
            this.gSt = new c();
        }
        String str = this.gSt.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.gSt.gSC = false;
            this.gSt.dsw = 0;
        }
    }

    private void bXu() {
        if (this.biH == null) {
            this.biH = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.biH);
        }
    }

    private void Oc() {
        if (this.biH != null) {
            MessageManager.getInstance().unRegisterListener(this.biH);
        }
    }

    private void bXv() {
        if (!this.gSt.gSC) {
            this.gSu = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bXB();
                }
            };
            MessageManager.getInstance().registerListener(this.gSu);
        }
    }

    private void bXw() {
        if (this.gSu != null) {
            MessageManager.getInstance().unRegisterListener(this.gSu);
        }
    }

    private void bXx() {
        int i;
        bXz();
        if ((this.bnM == null || this.bnM.aIf == null || (this.bnM.aIf.isUegBlock <= 0 && this.bnM.aIf.isBlock <= 0)) && !this.gSw && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.gSt.gSC) {
                bXw();
                return;
            }
            ag agVar = com.baidu.live.x.a.OS().blo;
            if (agVar != null && (i = agVar.aLi) > 0) {
                if (!k.b(new Date()).equals(this.gSt.date) || this.gSt.dsw < agVar.aLj) {
                    if (this.gSy == null) {
                        this.gSy = new a(this);
                    }
                    this.gSy.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXy() {
        String[] strArr;
        int length;
        this.gSw = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.gSi && !this.gSj) {
            if (this.gSt.gSC) {
                bXw();
                return;
            }
            ag agVar = com.baidu.live.x.a.OS().blo;
            if (agVar != null && (strArr = agVar.aLk) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.gSz == null) {
                        this.gSz = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.gSA == null) {
                        this.gSA = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Hr(String str2) {
                                if (b.this.gSx != null && b.this.gSx.KS()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bXz();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        };
                        this.gSz.setCallback(this.gSA);
                    }
                    Hp(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXz() {
        if (this.gSy != null) {
            this.gSy.removeCallbacksAndMessages(null);
        }
        bXA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXA() {
        if (this.gSz != null) {
            this.gSz.setVisibility(8);
        }
    }

    private void Hp(String str) {
        this.gSw = true;
        Hq(str);
        this.gSy.sendEmptyMessageDelayed(2, 5000L);
        bcO();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
    }

    private void Hq(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gSz) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.gSv) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.gSz, layoutParams);
            }
            this.gSz.setText(str);
            this.gSz.setVisibility(0);
        }
    }

    private void bcO() {
        String b = k.b(new Date());
        if (b.equals(this.gSt.date)) {
            this.gSt.dsw++;
        } else {
            this.gSt.date = b;
            this.gSt.dsw = 1;
        }
        if (this.gSt.dsw >= com.baidu.live.x.a.OS().blo.aLj) {
            bXB();
            bXw();
            return;
        }
        com.baidu.live.c.AZ().putString("guide_speak_show_times_date", this.gSt.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXB() {
        if (this.gSy != null) {
            this.gSy.removeMessages(1);
        }
        this.gSt.gSC = true;
        this.gSt.date = k.b(new Date());
        com.baidu.live.c.AZ().putString("guide_speak_show_times_date", this.gSt.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> gDu;

        a(b bVar) {
            this.gDu = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.gDu.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bXy();
                        return;
                    case 2:
                        bVar.bXA();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
