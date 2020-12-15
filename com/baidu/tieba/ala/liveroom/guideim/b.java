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
    private boolean hsY;
    private boolean hsZ;
    private c htj;
    private CustomMessageListener htk;
    private boolean htl;
    private boolean htm;
    private com.baidu.tieba.ala.liveroom.guideim.a htn;
    private Handler hto;
    private GuideImInputView htp;
    private GuideImInputView.a htq;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.htn = aVar;
    }

    public void c(w wVar, String str) {
        this.bur = wVar;
        this.htm = false;
        cfV();
        cgh();
        cgg();
        this.mVid = "";
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.feed_id != null) {
            this.mVid = wVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cgj();
    }

    public void nK(boolean z) {
        this.hsY = z;
        cgf();
    }

    public void nL(boolean z) {
        this.hsZ = z;
        cgf();
    }

    private void cgf() {
        if (this.hto != null) {
            if (!this.hsY || this.hsZ) {
                cgm();
            }
        }
    }

    public void Mg() {
        this.htm = false;
        cgl();
        cgi();
    }

    public void release() {
        if (this.hto != null) {
            this.hto.removeCallbacksAndMessages(null);
        }
        cgi();
        QK();
    }

    private void cfV() {
        if (this.htj == null) {
            this.htj = new c();
        }
        String str = this.htj.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.htj.hts = false;
            this.htj.dMd = 0;
        }
    }

    private void cgg() {
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

    private void cgh() {
        if (!this.htj.hts) {
            this.htk = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cgn();
                }
            };
            MessageManager.getInstance().registerListener(this.htk);
        }
    }

    private void cgi() {
        if (this.htk != null) {
            MessageManager.getInstance().unRegisterListener(this.htk);
        }
    }

    private void cgj() {
        int i;
        cgl();
        if ((this.bur == null || this.bur.aKr == null || (this.bur.aKr.isUegBlock <= 0 && this.bur.aKr.isBlock <= 0)) && !this.htm && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.htj.hts) {
                cgi();
                return;
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null && (i = alVar.aNW) > 0) {
                if (!k.b(new Date()).equals(this.htj.date) || this.htj.dMd < alVar.aNX) {
                    if (this.hto == null) {
                        this.hto = new a(this);
                    }
                    this.hto.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgk() {
        String[] strArr;
        int length;
        this.htm = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hsY && !this.hsZ) {
            if (this.htj.hts) {
                cgi();
                return;
            }
            al alVar = com.baidu.live.ae.a.RB().brA;
            if (alVar != null && (strArr = alVar.aNY) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.htp == null) {
                        this.htp = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.htq == null) {
                        this.htq = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Iw(String str2) {
                                if (b.this.htn != null && b.this.htn.Nh()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cgl();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.htp.setCallback(this.htq);
                    }
                    Iu(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgl() {
        if (this.hto != null) {
            this.hto.removeCallbacksAndMessages(null);
        }
        cgm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (this.htp != null) {
            this.htp.setVisibility(8);
        }
    }

    private void Iu(String str) {
        this.htm = true;
        Iv(str);
        this.hto.sendEmptyMessageDelayed(2, 5000L);
        bjF();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Iv(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.htp) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.htl) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.htp, layoutParams);
            }
            this.htp.setText(str);
            this.htp.setVisibility(0);
        }
    }

    private void bjF() {
        String b = k.b(new Date());
        if (b.equals(this.htj.date)) {
            this.htj.dMd++;
        } else {
            this.htj.date = b;
            this.htj.dMd = 1;
        }
        if (this.htj.dMd >= com.baidu.live.ae.a.RB().brA.aNX) {
            cgn();
            cgi();
            return;
        }
        d.BM().putString("guide_speak_show_times_date", this.htj.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgn() {
        if (this.hto != null) {
            this.hto.removeMessages(1);
        }
        this.htj.hts = true;
        this.htj.date = k.b(new Date());
        d.BM().putString("guide_speak_show_times_date", this.htj.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<b> haS;

        a(b bVar) {
            this.haS = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.haS.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cgk();
                        return;
                    case 2:
                        bVar.cgm();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
