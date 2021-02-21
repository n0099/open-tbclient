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
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener boT;
    private ab bxN;
    private boolean hEL;
    private boolean hEM;
    private c hEX;
    private CustomMessageListener hEY;
    private boolean hEZ;
    private boolean hFa;
    private com.baidu.tieba.ala.liveroom.guideim.a hFb;
    private Handler hFc;
    private GuideImInputView hFd;
    private GuideImInputView.a hFe;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hFb = aVar;
    }

    public void c(ab abVar, String str) {
        this.bxN = abVar;
        this.hFa = false;
        Mi();
        cge();
        cgd();
        this.mVid = "";
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.feed_id != null) {
            this.mVid = abVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cgg();
    }

    public void oq(boolean z) {
        this.hEL = z;
        cgc();
    }

    public void or(boolean z) {
        this.hEM = z;
        cgc();
    }

    private void cgc() {
        if (this.hFc != null) {
            if (!this.hEL || this.hEM) {
                cgj();
            }
        }
    }

    public void IZ() {
        this.hFa = false;
        cgi();
        cgf();
    }

    public void release() {
        if (this.hFc != null) {
            this.hFc.removeCallbacksAndMessages(null);
        }
        cgf();
        Ps();
    }

    private void Mi() {
        if (this.hEX == null) {
            this.hEX = new c();
        }
        String str = this.hEX.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hEX.bro = false;
            this.hEX.brp = 0;
        }
    }

    private void cgd() {
        if (this.boT == null) {
            this.boT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.boT);
        }
    }

    private void Ps() {
        if (this.boT != null) {
            MessageManager.getInstance().unRegisterListener(this.boT);
        }
    }

    private void cge() {
        if (!this.hEX.bro) {
            this.hEY = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cgk();
                }
            };
            MessageManager.getInstance().registerListener(this.hEY);
        }
    }

    private void cgf() {
        if (this.hEY != null) {
            MessageManager.getInstance().unRegisterListener(this.hEY);
        }
    }

    private void cgg() {
        int i;
        cgi();
        if ((this.bxN == null || this.bxN.aIz == null || (this.bxN.aIz.isUegBlock <= 0 && this.bxN.aIz.isBlock <= 0)) && !this.hFa && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hEX.bro) {
                cgf();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null && (i = arVar.aMy) > 0) {
                if (!k.b(new Date()).equals(this.hEX.date) || this.hEX.brp < arVar.aMz) {
                    if (this.hFc == null) {
                        this.hFc = new a(this);
                    }
                    this.hFc.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgh() {
        String[] strArr;
        int length;
        this.hFa = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hEL && !this.hEM) {
            if (this.hEX.bro) {
                cgf();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null && (strArr = arVar.aMA) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hFd == null) {
                        this.hFd = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hFe == null) {
                        this.hFe = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void HR(String str2) {
                                if (b.this.hFb != null && b.this.hFb.Kh()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cgi();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                            }
                        };
                        this.hFd.setCallback(this.hFe);
                    }
                    HP(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgi() {
        if (this.hFc != null) {
            this.hFc.removeCallbacksAndMessages(null);
        }
        cgj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgj() {
        if (this.hFd != null) {
            this.hFd.setVisibility(8);
        }
    }

    private void HP(String str) {
        this.hFa = true;
        HQ(str);
        this.hFc.sendEmptyMessageDelayed(2, 5000L);
        Mk();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    private void HQ(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hFd) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hEZ) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hFd, layoutParams);
            }
            this.hFd.setText(str);
            this.hFd.setVisibility(0);
        }
    }

    private void Mk() {
        String b2 = k.b(new Date());
        if (b2.equals(this.hEX.date)) {
            this.hEX.brp++;
        } else {
            this.hEX.date = b2;
            this.hEX.brp = 1;
        }
        if (this.hEX.brp >= com.baidu.live.ae.a.Qj().buX.aMz) {
            cgk();
            cgf();
            return;
        }
        d.xc().putString("guide_speak_show_times_date", this.hEX.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgk() {
        if (this.hFc != null) {
            this.hFc.removeMessages(1);
        }
        this.hEX.bro = true;
        this.hEX.date = k.b(new Date());
        d.xc().putString("guide_speak_show_times_date", this.hEX.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<b> hmz;

        a(b bVar) {
            this.hmz = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.hmz.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cgh();
                        return;
                    case 2:
                        bVar.cgj();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
