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
import com.baidu.live.data.an;
import com.baidu.live.data.x;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener bly;
    private x buq;
    private CustomMessageListener hAA;
    private boolean hAB;
    private boolean hAC;
    private com.baidu.tieba.ala.liveroom.guideim.a hAD;
    private Handler hAE;
    private GuideImInputView hAF;
    private GuideImInputView.a hAG;
    private boolean hAn;
    private boolean hAo;
    private c hAz;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hAD = aVar;
    }

    public void c(x xVar, String str) {
        this.buq = xVar;
        this.hAC = false;
        KK();
        cfe();
        cfd();
        this.mVid = "";
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.feed_id != null) {
            this.mVid = xVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cfg();
    }

    public void og(boolean z) {
        this.hAn = z;
        cfc();
    }

    public void oh(boolean z) {
        this.hAo = z;
        cfc();
    }

    private void cfc() {
        if (this.hAE != null) {
            if (!this.hAn || this.hAo) {
                cfj();
            }
        }
    }

    public void HJ() {
        this.hAC = false;
        cfi();
        cff();
    }

    public void release() {
        if (this.hAE != null) {
            this.hAE.removeCallbacksAndMessages(null);
        }
        cff();
        NT();
    }

    private void KK() {
        if (this.hAz == null) {
            this.hAz = new c();
        }
        String str = this.hAz.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hAz.bnN = false;
            this.hAz.bnO = 0;
        }
    }

    private void cfd() {
        if (this.bly == null) {
            this.bly = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bly);
        }
    }

    private void NT() {
        if (this.bly != null) {
            MessageManager.getInstance().unRegisterListener(this.bly);
        }
    }

    private void cfe() {
        if (!this.hAz.bnN) {
            this.hAA = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cfk();
                }
            };
            MessageManager.getInstance().registerListener(this.hAA);
        }
    }

    private void cff() {
        if (this.hAA != null) {
            MessageManager.getInstance().unRegisterListener(this.hAA);
        }
    }

    private void cfg() {
        int i;
        cfi();
        if ((this.buq == null || this.buq.aGd == null || (this.buq.aGd.isUegBlock <= 0 && this.buq.aGd.isBlock <= 0)) && !this.hAC && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hAz.bnN) {
                cff();
                return;
            }
            an anVar = com.baidu.live.af.a.OJ().bru;
            if (anVar != null && (i = anVar.aJN) > 0) {
                if (!k.b(new Date()).equals(this.hAz.date) || this.hAz.bnO < anVar.aJO) {
                    if (this.hAE == null) {
                        this.hAE = new a(this);
                    }
                    this.hAE.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        String[] strArr;
        int length;
        this.hAC = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hAn && !this.hAo) {
            if (this.hAz.bnN) {
                cff();
                return;
            }
            an anVar = com.baidu.live.af.a.OJ().bru;
            if (anVar != null && (strArr = anVar.aJP) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hAF == null) {
                        this.hAF = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hAG == null) {
                        this.hAG = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Hm(String str2) {
                                if (b.this.hAD != null && b.this.hAD.IJ()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cfi();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                            }
                        };
                        this.hAF.setCallback(this.hAG);
                    }
                    Hk(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfi() {
        if (this.hAE != null) {
            this.hAE.removeCallbacksAndMessages(null);
        }
        cfj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfj() {
        if (this.hAF != null) {
            this.hAF.setVisibility(8);
        }
    }

    private void Hk(String str) {
        this.hAC = true;
        Hl(str);
        this.hAE.sendEmptyMessageDelayed(2, 5000L);
        KM();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    private void Hl(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hAF) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hAB) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hAF, layoutParams);
            }
            this.hAF.setText(str);
            this.hAF.setVisibility(0);
        }
    }

    private void KM() {
        String b2 = k.b(new Date());
        if (b2.equals(this.hAz.date)) {
            this.hAz.bnO++;
        } else {
            this.hAz.date = b2;
            this.hAz.bnO = 1;
        }
        if (this.hAz.bnO >= com.baidu.live.af.a.OJ().bru.aJO) {
            cfk();
            cff();
            return;
        }
        d.xf().putString("guide_speak_show_times_date", this.hAz.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfk() {
        if (this.hAE != null) {
            this.hAE.removeMessages(1);
        }
        this.hAz.bnN = true;
        this.hAz.date = k.b(new Date());
        d.xf().putString("guide_speak_show_times_date", this.hAz.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends Handler {
        private final WeakReference<b> hhX;

        a(b bVar) {
            this.hhX = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.hhX.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cfh();
                        return;
                    case 2:
                        bVar.cfj();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
