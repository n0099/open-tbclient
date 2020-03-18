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
import com.baidu.live.data.m;
import com.baidu.live.data.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogManager;
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
    private CustomMessageListener atE;
    private boolean fdA;
    private com.baidu.tieba.ala.liveroom.guideim.a fdB;
    private Handler fdC;
    private GuideImInputView fdD;
    private GuideImInputView.a fdE;
    private boolean fdo = true;
    private boolean fdp = false;
    private c fdx;
    private CustomMessageListener fdy;
    private boolean fdz;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bmJ();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fdz = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fdB = aVar;
    }

    public void c(m mVar, String str) {
        this.fdA = false;
        bmK();
        bmX();
        bmW();
        this.mVid = "";
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.feed_id != null) {
            this.mVid = mVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bmZ();
    }

    public void ju(boolean z) {
        this.fdo = z;
        bmV();
    }

    public void jv(boolean z) {
        this.fdp = z;
        bmV();
    }

    private void bmV() {
        if (this.fdC != null) {
            if (!this.fdo || this.fdp) {
                bnc();
            }
        }
    }

    public void bmI() {
        this.fdA = false;
        bnb();
        bmY();
    }

    public void release() {
        if (this.fdC != null) {
            this.fdC.removeCallbacksAndMessages(null);
        }
        bmY();
        xq();
    }

    private void bmJ() {
        this.fdx = new c();
        String string = com.baidu.live.c.pw().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fdx.fdG = jSONObject.optBoolean("hasInput");
                    if (!this.fdx.fdG) {
                        this.fdx.date = b;
                        this.fdx.eHr = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmK() {
        if (this.fdx == null) {
            this.fdx = new c();
        }
        String str = this.fdx.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fdx.fdG = false;
            this.fdx.eHr = 0;
        }
    }

    private void bmW() {
        if (this.atE == null) {
            this.atE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.atE);
        }
    }

    private void xq() {
        if (this.atE != null) {
            MessageManager.getInstance().unRegisterListener(this.atE);
        }
    }

    private void bmX() {
        if (!this.fdx.fdG) {
            this.fdy = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bnd();
                }
            };
            MessageManager.getInstance().registerListener(this.fdy);
        }
    }

    private void bmY() {
        if (this.fdy != null) {
            MessageManager.getInstance().unRegisterListener(this.fdy);
        }
    }

    private void bmZ() {
        int i;
        bnb();
        if (!this.fdA && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fdx.fdG) {
                bmY();
                return;
            }
            t tVar = com.baidu.live.v.a.zs().awM;
            if (tVar != null && (i = tVar.aaG) > 0) {
                if (!j.b(new Date()).equals(this.fdx.date) || this.fdx.eHr < tVar.aaH) {
                    if (this.fdC == null) {
                        this.fdC = new a(this);
                    }
                    this.fdC.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bna() {
        String[] strArr;
        int length;
        this.fdA = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fdo && !this.fdp) {
            if (this.fdx.fdG) {
                bmY();
                return;
            }
            t tVar = com.baidu.live.v.a.zs().awM;
            if (tVar != null && (strArr = tVar.aaI) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fdD == null) {
                        this.fdD = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fdE == null) {
                        this.fdE = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void ze(String str2) {
                                if (b.this.fdB != null && b.this.fdB.wx()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bnb();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.fdD.setCallback(this.fdE);
                    }
                    zc(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        if (this.fdC != null) {
            this.fdC.removeCallbacksAndMessages(null);
        }
        bnc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnc() {
        if (this.fdD != null) {
            this.fdD.setVisibility(8);
        }
    }

    private void zc(String str) {
        this.fdA = true;
        zd(str);
        this.fdC.sendEmptyMessageDelayed(2, 5000L);
        ayh();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void zd(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fdD) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fdz) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fdD, layoutParams);
            }
            this.fdD.setText(str);
            this.fdD.setVisibility(0);
        }
    }

    private void ayh() {
        String b = j.b(new Date());
        if (b.equals(this.fdx.date)) {
            this.fdx.eHr++;
        } else {
            this.fdx.date = b;
            this.fdx.eHr = 1;
        }
        if (this.fdx.eHr >= com.baidu.live.v.a.zs().awM.aaH) {
            bnd();
            bmY();
            return;
        }
        com.baidu.live.c.pw().putString("guide_speak_show_times_date", this.fdx.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnd() {
        if (this.fdC != null) {
            this.fdC.removeMessages(1);
        }
        this.fdx.fdG = true;
        this.fdx.date = j.b(new Date());
        com.baidu.live.c.pw().putString("guide_speak_show_times_date", this.fdx.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> eQM;

        a(b bVar) {
            this.eQM = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eQM.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bna();
                        return;
                    case 2:
                        bVar.bnc();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
