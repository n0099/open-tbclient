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
    private c hEJ;
    private CustomMessageListener hEK;
    private boolean hEL;
    private boolean hEM;
    private com.baidu.tieba.ala.liveroom.guideim.a hEN;
    private Handler hEO;
    private GuideImInputView hEP;
    private GuideImInputView.a hEQ;
    private boolean hEx;
    private boolean hEy;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.hEN = aVar;
    }

    public void c(ab abVar, String str) {
        this.bxN = abVar;
        this.hEM = false;
        Mi();
        cfX();
        cfW();
        this.mVid = "";
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.feed_id != null) {
            this.mVid = abVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        cfZ();
    }

    public void oq(boolean z) {
        this.hEx = z;
        cfV();
    }

    public void or(boolean z) {
        this.hEy = z;
        cfV();
    }

    private void cfV() {
        if (this.hEO != null) {
            if (!this.hEx || this.hEy) {
                cgc();
            }
        }
    }

    public void IZ() {
        this.hEM = false;
        cgb();
        cfY();
    }

    public void release() {
        if (this.hEO != null) {
            this.hEO.removeCallbacksAndMessages(null);
        }
        cfY();
        Ps();
    }

    private void Mi() {
        if (this.hEJ == null) {
            this.hEJ = new c();
        }
        String str = this.hEJ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.hEJ.bro = false;
            this.hEJ.brp = 0;
        }
    }

    private void cfW() {
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

    private void cfX() {
        if (!this.hEJ.bro) {
            this.hEK = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.cgd();
                }
            };
            MessageManager.getInstance().registerListener(this.hEK);
        }
    }

    private void cfY() {
        if (this.hEK != null) {
            MessageManager.getInstance().unRegisterListener(this.hEK);
        }
    }

    private void cfZ() {
        int i;
        cgb();
        if ((this.bxN == null || this.bxN.aIz == null || (this.bxN.aIz.isUegBlock <= 0 && this.bxN.aIz.isBlock <= 0)) && !this.hEM && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.hEJ.bro) {
                cfY();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null && (i = arVar.aMy) > 0) {
                if (!k.b(new Date()).equals(this.hEJ.date) || this.hEJ.brp < arVar.aMz) {
                    if (this.hEO == null) {
                        this.hEO = new a(this);
                    }
                    this.hEO.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cga() {
        String[] strArr;
        int length;
        this.hEM = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.hEx && !this.hEy) {
            if (this.hEJ.bro) {
                cfY();
                return;
            }
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null && (strArr = arVar.aMA) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.hEP == null) {
                        this.hEP = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.hEQ == null) {
                        this.hEQ = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void HQ(String str2) {
                                if (b.this.hEN != null && b.this.hEN.Kh()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.cgb();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                            }
                        };
                        this.hEP.setCallback(this.hEQ);
                    }
                    HO(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        if (this.hEO != null) {
            this.hEO.removeCallbacksAndMessages(null);
        }
        cgc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgc() {
        if (this.hEP != null) {
            this.hEP.setVisibility(8);
        }
    }

    private void HO(String str) {
        this.hEM = true;
        HP(str);
        this.hEO.sendEmptyMessageDelayed(2, 5000L);
        Mk();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
    }

    private void HP(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.hEP) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
                if (this.hEL) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.hEP, layoutParams);
            }
            this.hEP.setText(str);
            this.hEP.setVisibility(0);
        }
    }

    private void Mk() {
        String b2 = k.b(new Date());
        if (b2.equals(this.hEJ.date)) {
            this.hEJ.brp++;
        } else {
            this.hEJ.date = b2;
            this.hEJ.brp = 1;
        }
        if (this.hEJ.brp >= com.baidu.live.ae.a.Qj().buX.aMz) {
            cgd();
            cfY();
            return;
        }
        d.xc().putString("guide_speak_show_times_date", this.hEJ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgd() {
        if (this.hEO != null) {
            this.hEO.removeMessages(1);
        }
        this.hEJ.bro = true;
        this.hEJ.date = k.b(new Date());
        d.xc().putString("guide_speak_show_times_date", this.hEJ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<b> hml;

        a(b bVar) {
            this.hml = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.hml.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.cga();
                        return;
                    case 2:
                        bVar.cgc();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
