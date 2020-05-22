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
import com.baidu.live.data.q;
import com.baidu.live.data.y;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.liveroom.guideim.GuideImInputView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private CustomMessageListener aSV;
    private q fHz;
    private c fVI;
    private CustomMessageListener fVJ;
    private boolean fVK;
    private boolean fVL;
    private com.baidu.tieba.ala.liveroom.guideim.a fVM;
    private Handler fVN;
    private GuideImInputView fVO;
    private GuideImInputView.a fVP;
    private boolean fVx = true;
    private boolean fVy = false;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bBX();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fVK = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fVM = aVar;
    }

    public void c(q qVar, String str) {
        this.fHz = qVar;
        this.fVL = false;
        bBY();
        bCm();
        bCl();
        this.mVid = "";
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.feed_id != null) {
            this.mVid = qVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bCo();
    }

    public void kQ(boolean z) {
        this.fVx = z;
        bCk();
    }

    public void kR(boolean z) {
        this.fVy = z;
        bCk();
    }

    private void bCk() {
        if (this.fVN != null) {
            if (!this.fVx || this.fVy) {
                bCr();
            }
        }
    }

    public void bBW() {
        this.fVL = false;
        bCq();
        bCn();
    }

    public void release() {
        if (this.fVN != null) {
            this.fVN.removeCallbacksAndMessages(null);
        }
        bCn();
        Dx();
    }

    private void bBX() {
        this.fVI = new c();
        String string = com.baidu.live.c.uN().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fVI.fVR = jSONObject.optBoolean("hasInput");
                    if (!this.fVI.fVR) {
                        this.fVI.fzt = b;
                        this.fVI.fzu = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bBY() {
        if (this.fVI == null) {
            this.fVI = new c();
        }
        String str = this.fVI.fzt;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fVI.fVR = false;
            this.fVI.fzu = 0;
        }
    }

    private void bCl() {
        if (this.aSV == null) {
            this.aSV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.aSV);
        }
    }

    private void Dx() {
        if (this.aSV != null) {
            MessageManager.getInstance().unRegisterListener(this.aSV);
        }
    }

    private void bCm() {
        if (!this.fVI.fVR) {
            this.fVJ = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bCs();
                }
            };
            MessageManager.getInstance().registerListener(this.fVJ);
        }
    }

    private void bCn() {
        if (this.fVJ != null) {
            MessageManager.getInstance().unRegisterListener(this.fVJ);
        }
    }

    private void bCo() {
        int i;
        bCq();
        if ((this.fHz == null || this.fHz.avC == null || (this.fHz.avC.isUegBlock <= 0 && this.fHz.avC.isBlock <= 0)) && !this.fVL && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fVI.fVR) {
                bCn();
                return;
            }
            y yVar = com.baidu.live.v.a.Ge().aWF;
            if (yVar != null && (i = yVar.ayb) > 0) {
                if (!j.b(new Date()).equals(this.fVI.fzt) || this.fVI.fzu < yVar.ayc) {
                    if (this.fVN == null) {
                        this.fVN = new a(this);
                    }
                    this.fVN.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        String[] strArr;
        int length;
        this.fVL = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fVx && !this.fVy) {
            if (this.fVI.fVR) {
                bCn();
                return;
            }
            y yVar = com.baidu.live.v.a.Ge().aWF;
            if (yVar != null && (strArr = yVar.ayd) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fVO == null) {
                        this.fVO = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fVP == null) {
                        this.fVP = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void Cx(String str2) {
                                if (b.this.fVM != null && b.this.fVM.CC()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bCq();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "msg_clk").setContentExt(null, "popup", null));
                            }
                        };
                        this.fVO.setCallback(this.fVP);
                    }
                    Cv(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        if (this.fVN != null) {
            this.fVN.removeCallbacksAndMessages(null);
        }
        bCr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCr() {
        if (this.fVO != null) {
            this.fVO.setVisibility(8);
        }
    }

    private void Cv(String str) {
        this.fVL = true;
        Cw(str);
        this.fVN.sendEmptyMessageDelayed(2, 5000L);
        aLL();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "msg_show").setContentExt(null, "popup", null));
    }

    private void Cw(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fVO) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fVK) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fVO, layoutParams);
            }
            this.fVO.setText(str);
            this.fVO.setVisibility(0);
        }
    }

    private void aLL() {
        String b = j.b(new Date());
        if (b.equals(this.fVI.fzt)) {
            this.fVI.fzu++;
        } else {
            this.fVI.fzt = b;
            this.fVI.fzu = 1;
        }
        if (this.fVI.fzu >= com.baidu.live.v.a.Ge().aWF.ayc) {
            bCs();
            bCn();
            return;
        }
        com.baidu.live.c.uN().putString("guide_speak_show_times_date", this.fVI.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCs() {
        if (this.fVN != null) {
            this.fVN.removeMessages(1);
        }
        this.fVI.fVR = true;
        this.fVI.fzt = j.b(new Date());
        com.baidu.live.c.uN().putString("guide_speak_show_times_date", this.fVI.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> fJi;

        a(b bVar) {
            this.fJi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.fJi.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bCp();
                        return;
                    case 2:
                        bVar.bCr();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
