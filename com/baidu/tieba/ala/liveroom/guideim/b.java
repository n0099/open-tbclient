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
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
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
    private CustomMessageListener bqt;
    private ab bzn;
    private c hGG;
    private CustomMessageListener hGH;
    private boolean hGI;
    private boolean hGJ;
    private com.baidu.tieba.ala.liveroom.guideim.a hGK;
    private Handler hGL;
    private GuideImInputView hGM;
    private GuideImInputView.a hGN;
    private boolean hGu;
    private boolean hGv;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hGK = aVar;
    }

    public void c(ab abVar, String str) {
        this.bzn = abVar;
        this.hGJ = false;
        Ml();
        cgk();
        cgj();
        this.mVid = "";
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.feed_id != null) {
            this.mVid = abVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cgm();
    }

    public void oq(boolean z) {
        this.hGu = z;
        cgi();
    }

    public void or(boolean z) {
        this.hGv = z;
        cgi();
    }

    private void cgi() {
        if (this.hGL != null) {
            if (!this.hGu || this.hGv) {
                cgp();
            }
        }
    }

    public void Jc() {
        this.hGJ = false;
        cgo();
        cgl();
    }

    public void release() {
        if (this.hGL != null) {
            this.hGL.removeCallbacksAndMessages(null);
        }
        cgl();
        Pv();
    }

    private void Ml() {
        if (this.hGG == null) {
            this.hGG = new c();
        }
        String str = this.hGG.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hGG.bsO = false;
            this.hGG.bsP = 0;
        }
    }

    private void cgj() {
        if (this.bqt == null) {
            this.bqt = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bqt);
        }
    }

    private void Pv() {
        if (this.bqt != null) {
            MessageManager.getInstance().unRegisterListener(this.bqt);
        }
    }

    private void cgk() {
        if (!this.hGG.bsO) {
            this.hGH = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cgq();
                }
            };
            MessageManager.getInstance().registerListener(this.hGH);
        }
    }

    private void cgl() {
        if (this.hGH != null) {
            MessageManager.getInstance().unRegisterListener(this.hGH);
        }
    }

    private void cgm() {
        int i;
        cgo();
        if ((this.bzn == null || this.bzn.aJZ == null || (this.bzn.aJZ.isUegBlock <= 0 && this.bzn.aJZ.isBlock <= 0)) && !this.hGJ && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hGG.bsO) {
                cgl();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null && (i = arVar.aNY) > 0) {
                if (!k.b(new Date()).equals(this.hGG.date) || this.hGG.bsP < arVar.aNZ) {
                    if (this.hGL == null) {
                        this.hGL = new a(this);
                    }
                    this.hGL.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgn() {
        String[] strArr;
        int length;
        this.hGJ = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hGu && !this.hGv) {
            if (this.hGG.bsO) {
                cgl();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null && (strArr = arVar.aOa) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hGM == null) {
                        this.hGM = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hGN == null) {
                        this.hGN = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Ia(String str2) {
                                if (b.this.hGK != null && b.this.hGK.Kk()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cgo();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                            }
                        };
                        this.hGM.setCallback(this.hGN);
                    }
                    HY(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgo() {
        if (this.hGL != null) {
            this.hGL.removeCallbacksAndMessages(null);
        }
        cgp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgp() {
        if (this.hGM != null) {
            this.hGM.setVisibility(8);
        }
    }

    private void HY(String str) {
        this.hGJ = true;
        HZ(str);
        this.hGL.sendEmptyMessageDelayed(2, 5000L);
        Mn();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    private void HZ(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hGM) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hGI) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hGM, layoutParams);
            }
            this.hGM.setText(str);
            this.hGM.setVisibility(0);
        }
    }

    private void Mn() {
        String b = k.b(new Date());
        if (b.equals(this.hGG.date)) {
            this.hGG.bsP++;
        } else {
            this.hGG.date = b;
            this.hGG.bsP = 1;
        }
        if (this.hGG.bsP >= com.baidu.live.ae.a.Qm().bwx.aNZ) {
            cgq();
            cgl();
            return;
        }
        d.xf().putString("guide_speak_show_times_date", this.hGG.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        if (this.hGL != null) {
            this.hGL.removeMessages(1);
        }
        this.hGG.bsO = true;
        this.hGG.date = k.b(new Date());
        d.xf().putString("guide_speak_show_times_date", this.hGG.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends Handler {
        private final WeakReference<b> hoi;

        a(b bVar) {
            this.hoi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.hoi.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cgn();
                        return;
                    case 2:
                        bVar.cgp();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
