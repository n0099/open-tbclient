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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener bql;
    private x bzc;
    private boolean hET;
    private boolean hEU;
    private c hFf;
    private CustomMessageListener hFg;
    private boolean hFh;
    private boolean hFi;
    private com.baidu.tieba.ala.liveroom.guideim.a hFj;
    private Handler hFk;
    private GuideImInputView hFl;
    private GuideImInputView.a hFm;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hFj = aVar;
    }

    public void c(x xVar, String str) {
        this.bzc = xVar;
        this.hFi = false;
        OF();
        ciW();
        ciV();
        this.mVid = "";
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.feed_id != null) {
            this.mVid = xVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        ciY();
    }

    public void ok(boolean z) {
        this.hET = z;
        ciU();
    }

    public void ol(boolean z) {
        this.hEU = z;
        ciU();
    }

    private void ciU() {
        if (this.hFk != null) {
            if (!this.hET || this.hEU) {
                cjb();
            }
        }
    }

    public void LE() {
        this.hFi = false;
        cja();
        ciX();
    }

    public void release() {
        if (this.hFk != null) {
            this.hFk.removeCallbacksAndMessages(null);
        }
        ciX();
        RO();
    }

    private void OF() {
        if (this.hFf == null) {
            this.hFf = new c();
        }
        String str = this.hFf.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hFf.bsz = false;
            this.hFf.bsA = 0;
        }
    }

    private void ciV() {
        if (this.bql == null) {
            this.bql = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.bql);
        }
    }

    private void RO() {
        if (this.bql != null) {
            MessageManager.getInstance().unRegisterListener(this.bql);
        }
    }

    private void ciW() {
        if (!this.hFf.bsz) {
            this.hFg = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cjc();
                }
            };
            MessageManager.getInstance().registerListener(this.hFg);
        }
    }

    private void ciX() {
        if (this.hFg != null) {
            MessageManager.getInstance().unRegisterListener(this.hFg);
        }
    }

    private void ciY() {
        int i;
        cja();
        if ((this.bzc == null || this.bzc.aKQ == null || (this.bzc.aKQ.isUegBlock <= 0 && this.bzc.aKQ.isBlock <= 0)) && !this.hFi && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hFf.bsz) {
                ciX();
                return;
            }
            an anVar = com.baidu.live.af.a.SE().bwi;
            if (anVar != null && (i = anVar.aOA) > 0) {
                if (!k.b(new Date()).equals(this.hFf.date) || this.hFf.bsA < anVar.aOB) {
                    if (this.hFk == null) {
                        this.hFk = new a(this);
                    }
                    this.hFk.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciZ() {
        String[] strArr;
        int length;
        this.hFi = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hET && !this.hEU) {
            if (this.hFf.bsz) {
                ciX();
                return;
            }
            an anVar = com.baidu.live.af.a.SE().bwi;
            if (anVar != null && (strArr = anVar.aOC) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hFl == null) {
                        this.hFl = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hFm == null) {
                        this.hFm = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Ix(String str2) {
                                if (b.this.hFj != null && b.this.hFj.ME()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cja();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.hFl.setCallback(this.hFm);
                    }
                    Iv(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cja() {
        if (this.hFk != null) {
            this.hFk.removeCallbacksAndMessages(null);
        }
        cjb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (this.hFl != null) {
            this.hFl.setVisibility(8);
        }
    }

    private void Iv(String str) {
        this.hFi = true;
        Iw(str);
        this.hFk.sendEmptyMessageDelayed(2, 5000L);
        OH();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Iw(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hFl) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hFh) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hFl, layoutParams);
            }
            this.hFl.setText(str);
            this.hFl.setVisibility(0);
        }
    }

    private void OH() {
        String b2 = k.b(new Date());
        if (b2.equals(this.hFf.date)) {
            this.hFf.bsA++;
        } else {
            this.hFf.date = b2;
            this.hFf.bsA = 1;
        }
        if (this.hFf.bsA >= com.baidu.live.af.a.SE().bwi.aOB) {
            cjc();
            ciX();
            return;
        }
        d.Ba().putString("guide_speak_show_times_date", this.hFf.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjc() {
        if (this.hFk != null) {
            this.hFk.removeMessages(1);
        }
        this.hFf.bsz = true;
        this.hFf.date = k.b(new Date());
        d.Ba().putString("guide_speak_show_times_date", this.hFf.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<b> hmE;

        a(b bVar) {
            this.hmE = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.hmE.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.ciZ();
                        return;
                    case 2:
                        bVar.cjb();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
