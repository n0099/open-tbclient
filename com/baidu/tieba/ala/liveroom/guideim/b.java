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
import com.baidu.live.data.al;
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
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener boC;
    private w bur;
    private boolean hsW;
    private boolean hsX;
    private c hth;
    private CustomMessageListener hti;
    private boolean htj;
    private boolean htk;
    private com.baidu.tieba.ala.liveroom.guideim.a htl;
    private Handler htm;
    private GuideImInputView htn;
    private GuideImInputView.a hto;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.htl = aVar;
    }

    public void c(w wVar, String str) {
        this.bur = wVar;
        this.htk = false;
        cfU();
        cgg();
        cgf();
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cgi();
    }

    public void nK(boolean z) {
        this.hsW = z;
        cge();
    }

    public void nL(boolean z) {
        this.hsX = z;
        cge();
    }

    private void cge() {
        if (this.htm != null) {
            if (!this.hsW || this.hsX) {
                cgl();
            }
        }
    }

    public void Mg() {
        this.htk = false;
        cgk();
        cgh();
    }

    public void release() {
        if (this.htm != null) {
            this.htm.removeCallbacksAndMessages(null);
        }
        cgh();
        QK();
    }

    private void cfU() {
        if (this.hth == null) {
            this.hth = new c();
        }
        String str = this.hth.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hth.htq = false;
            this.hth.dMd = 0;
        }
    }

    private void cgf() {
        if (this.boC == null) {
            this.boC = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.boC);
        }
    }

    private void QK() {
        if (this.boC != null) {
            MessageManager.getInstance().unRegisterListener(this.boC);
        }
    }

    private void cgg() {
        if (!this.hth.htq) {
            this.hti = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cgm();
                }
            };
            MessageManager.getInstance().registerListener(this.hti);
        }
    }

    private void cgh() {
        if (this.hti != null) {
            MessageManager.getInstance().unRegisterListener(this.hti);
        }
    }

    private void cgi() {
        int i;
        cgk();
        if ((this.bur == null || this.bur.aKr == null || (this.bur.aKr.isUegBlock <= 0 && this.bur.aKr.isBlock <= 0)) && !this.htk && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hth.htq) {
                cgh();
                return;
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null && (i = alVar.aNW) > 0) {
                if (!k.b(new Date()).equals(this.hth.date) || this.hth.dMd < alVar.aNX) {
                    if (this.htm == null) {
                        this.htm = new a(this);
                    }
                    this.htm.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgj() {
        String[] strArr;
        int length;
        this.htk = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hsW && !this.hsX) {
            if (this.hth.htq) {
                cgh();
                return;
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null && (strArr = alVar.aNY) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.htn == null) {
                        this.htn = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hto == null) {
                        this.hto = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Iw(String str2) {
                                if (b.this.htl != null && b.this.htl.Nh()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cgk();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.htn.setCallback(this.hto);
                    }
                    Iu(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgk() {
        if (this.htm != null) {
            this.htm.removeCallbacksAndMessages(null);
        }
        cgl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgl() {
        if (this.htn != null) {
            this.htn.setVisibility(8);
        }
    }

    private void Iu(String str) {
        this.htk = true;
        Iv(str);
        this.htm.sendEmptyMessageDelayed(2, 5000L);
        bjF();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Iv(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.htn) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.htj) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.htn, layoutParams);
            }
            this.htn.setText(str);
            this.htn.setVisibility(0);
        }
    }

    private void bjF() {
        String b = k.b(new Date());
        if (b.equals(this.hth.date)) {
            this.hth.dMd++;
        } else {
            this.hth.date = b;
            this.hth.dMd = 1;
        }
        if (this.hth.dMd >= com.baidu.live.ae.a.RB().brA.aNX) {
            cgm();
            cgh();
            return;
        }
        d.BM().putString("guide_speak_show_times_date", this.hth.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (this.htm != null) {
            this.htm.removeMessages(1);
        }
        this.hth.htq = true;
        this.hth.date = k.b(new Date());
        d.BM().putString("guide_speak_show_times_date", this.hth.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> haQ;

        a(b bVar) {
            this.haQ = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.haQ.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cgj();
                        return;
                    case 2:
                        bVar.cgl();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
