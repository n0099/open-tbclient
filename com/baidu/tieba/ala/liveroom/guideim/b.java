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
    private CustomMessageListener beU;
    private u bjZ;
    private boolean gDM = true;
    private boolean gDN = false;
    private c gDX;
    private CustomMessageListener gDY;
    private boolean gDZ;
    private boolean gEa;
    private com.baidu.tieba.ala.liveroom.guideim.a gEb;
    private Handler gEc;
    private GuideImInputView gEd;
    private GuideImInputView.a gEe;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bTN();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.gDZ = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.gEb = aVar;
    }

    public void c(u uVar, String str) {
        this.bjZ = uVar;
        this.gEa = false;
        bTO();
        bUc();
        bUb();
        this.mVid = "";
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.feed_id != null) {
            this.mVid = uVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bUe();
    }

    public void mn(boolean z) {
        this.gDM = z;
        bUa();
    }

    public void mo(boolean z) {
        this.gDN = z;
        bUa();
    }

    private void bUa() {
        if (this.gEc != null) {
            if (!this.gDM || this.gDN) {
                bUh();
            }
        }
    }

    public void Lv() {
        this.gEa = false;
        bUg();
        bUd();
    }

    public void release() {
        if (this.gEc != null) {
            this.gEc.removeCallbacksAndMessages(null);
        }
        bUd();
        MX();
    }

    private void bTN() {
        this.gDX = new c();
        String string = com.baidu.live.c.AR().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.gDX.gEg = jSONObject.optBoolean("hasInput");
                    if (!this.gDX.gEg) {
                        this.gDX.date = b;
                        this.gDX.dgo = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bTO() {
        if (this.gDX == null) {
            this.gDX = new c();
        }
        String str = this.gDX.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.gDX.gEg = false;
            this.gDX.dgo = 0;
        }
    }

    private void bUb() {
        if (this.beU == null) {
            this.beU = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.beU);
        }
    }

    private void MX() {
        if (this.beU != null) {
            MessageManager.getInstance().unRegisterListener(this.beU);
        }
    }

    private void bUc() {
        if (!this.gDX.gEg) {
            this.gDY = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bUi();
                }
            };
            MessageManager.getInstance().registerListener(this.gDY);
        }
    }

    private void bUd() {
        if (this.gDY != null) {
            MessageManager.getInstance().unRegisterListener(this.gDY);
        }
    }

    private void bUe() {
        int i;
        bUg();
        if ((this.bjZ == null || this.bjZ.aFb == null || (this.bjZ.aFb.isUegBlock <= 0 && this.bjZ.aFb.isBlock <= 0)) && !this.gEa && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.gDX.gEg) {
                bUd();
                return;
            }
            ag agVar = com.baidu.live.x.a.NN().bhy;
            if (agVar != null && (i = agVar.aIe) > 0) {
                if (!k.b(new Date()).equals(this.gDX.date) || this.gDX.dgo < agVar.aIf) {
                    if (this.gEc == null) {
                        this.gEc = new a(this);
                    }
                    this.gEc.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        String[] strArr;
        int length;
        this.gEa = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.gDM && !this.gDN) {
            if (this.gDX.gEg) {
                bUd();
                return;
            }
            ag agVar = com.baidu.live.x.a.NN().bhy;
            if (agVar != null && (strArr = agVar.aIg) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.gEd == null) {
                        this.gEd = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.gEe == null) {
                        this.gEe = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void GF(String str2) {
                                if (b.this.gEb != null && b.this.gEb.JM()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bUg();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        };
                        this.gEd.setCallback(this.gEe);
                    }
                    GD(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
        if (this.gEc != null) {
            this.gEc.removeCallbacksAndMessages(null);
        }
        bUh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUh() {
        if (this.gEd != null) {
            this.gEd.setVisibility(8);
        }
    }

    private void GD(String str) {
        this.gEa = true;
        GE(str);
        this.gEc.sendEmptyMessageDelayed(2, 5000L);
        bag();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
    }

    private void GE(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gEd) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.gDZ) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.gEd, layoutParams);
            }
            this.gEd.setText(str);
            this.gEd.setVisibility(0);
        }
    }

    private void bag() {
        String b = k.b(new Date());
        if (b.equals(this.gDX.date)) {
            this.gDX.dgo++;
        } else {
            this.gDX.date = b;
            this.gDX.dgo = 1;
        }
        if (this.gDX.dgo >= com.baidu.live.x.a.NN().bhy.aIf) {
            bUi();
            bUd();
            return;
        }
        com.baidu.live.c.AR().putString("guide_speak_show_times_date", this.gDX.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUi() {
        if (this.gEc != null) {
            this.gEc.removeMessages(1);
        }
        this.gDX.gEg = true;
        this.gDX.date = k.b(new Date());
        com.baidu.live.c.AR().putString("guide_speak_show_times_date", this.gDX.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> gpb;

        a(b bVar) {
            this.gpb = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.gpb.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bUf();
                        return;
                    case 2:
                        bVar.bUh();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
