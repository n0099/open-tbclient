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
    private CustomMessageListener atu;
    private boolean fcQ = true;
    private boolean fcR = false;
    private c fcZ;
    private CustomMessageListener fda;
    private boolean fdb;
    private boolean fdc;
    private com.baidu.tieba.ala.liveroom.guideim.a fdd;
    private Handler fde;
    private GuideImInputView fdf;
    private GuideImInputView.a fdg;
    private TbPageContext mContext;
    private String mOtherParams;
    private ViewGroup mParentView;
    private String mVid;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        bmE();
    }

    public void c(ViewGroup viewGroup, boolean z) {
        this.mParentView = viewGroup;
        this.fdb = z;
    }

    public void a(com.baidu.tieba.ala.liveroom.guideim.a aVar) {
        this.fdd = aVar;
    }

    public void c(m mVar, String str) {
        this.fdc = false;
        bmF();
        bmS();
        bmR();
        this.mVid = "";
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.feed_id != null) {
            this.mVid = mVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bmU();
    }

    public void js(boolean z) {
        this.fcQ = z;
        bmQ();
    }

    public void jt(boolean z) {
        this.fcR = z;
        bmQ();
    }

    private void bmQ() {
        if (this.fde != null) {
            if (!this.fcQ || this.fcR) {
                bmX();
            }
        }
    }

    public void bmD() {
        this.fdc = false;
        bmW();
        bmT();
    }

    public void release() {
        if (this.fde != null) {
            this.fde.removeCallbacksAndMessages(null);
        }
        bmT();
        xl();
    }

    private void bmE() {
        this.fcZ = new c();
        String string = com.baidu.live.c.pr().getString("guide_speak_show_times_date", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = j.b(new Date());
                if (optString.equals(b)) {
                    this.fcZ.fdi = jSONObject.optBoolean("hasInput");
                    if (!this.fcZ.fdi) {
                        this.fcZ.date = b;
                        this.fcZ.eGV = jSONObject.optInt("times");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bmF() {
        if (this.fcZ == null) {
            this.fcZ = new c();
        }
        String str = this.fcZ.date;
        if (!TextUtils.isEmpty(str) && !str.equals(j.b(new Date()))) {
            this.fcZ.fdi = false;
            this.fcZ.eGV = 0;
        }
    }

    private void bmR() {
        if (this.atu == null) {
            this.atu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.1
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
            MessageManager.getInstance().registerListener(this.atu);
        }
    }

    private void xl() {
        if (this.atu != null) {
            MessageManager.getInstance().unRegisterListener(this.atu);
        }
    }

    private void bmS() {
        if (!this.fcZ.fdi) {
            this.fda = new CustomMessageListener(2913043) { // from class: com.baidu.tieba.ala.liveroom.guideim.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    b.this.bmY();
                }
            };
            MessageManager.getInstance().registerListener(this.fda);
        }
    }

    private void bmT() {
        if (this.fda != null) {
            MessageManager.getInstance().unRegisterListener(this.fda);
        }
    }

    private void bmU() {
        int i;
        bmW();
        if (!this.fdc && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            if (this.fcZ.fdi) {
                bmT();
                return;
            }
            t tVar = com.baidu.live.v.a.zl().awC;
            if (tVar != null && (i = tVar.aaw) > 0) {
                if (!j.b(new Date()).equals(this.fcZ.date) || this.fcZ.eGV < tVar.aax) {
                    if (this.fde == null) {
                        this.fde = new a(this);
                    }
                    this.fde.sendEmptyMessageDelayed(1, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmV() {
        String[] strArr;
        int length;
        this.fdc = true;
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && this.fcQ && !this.fcR) {
            if (this.fcZ.fdi) {
                bmT();
                return;
            }
            t tVar = com.baidu.live.v.a.zl().awC;
            if (tVar != null && (strArr = tVar.aay) != null && (length = strArr.length) != 0) {
                String str = strArr[new Random().nextInt(length)];
                if (!TextUtils.isEmpty(str)) {
                    if (this.fdf == null) {
                        this.fdf = new GuideImInputView(this.mContext.getPageActivity());
                    }
                    if (this.fdg == null) {
                        this.fdg = new GuideImInputView.a() { // from class: com.baidu.tieba.ala.liveroom.guideim.b.3
                            @Override // com.baidu.tieba.ala.liveroom.guideim.GuideImInputView.a
                            public void ze(String str2) {
                                if (b.this.fdd != null && b.this.fdd.ws()) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, new ImSendMsgData(str2)));
                                }
                                b.this.bmW();
                                LogManager.getCommonLogger().doClickSpeakGuideButtonLog(b.this.mVid, b.this.mOtherParams, str2);
                            }
                        };
                        this.fdf.setCallback(this.fdg);
                    }
                    zc(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmW() {
        if (this.fde != null) {
            this.fde.removeCallbacksAndMessages(null);
        }
        bmX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmX() {
        if (this.fdf != null) {
            this.fdf.setVisibility(8);
        }
    }

    private void zc(String str) {
        this.fdc = true;
        zd(str);
        this.fde.sendEmptyMessageDelayed(2, 5000L);
        aye();
        LogManager.getCommonLogger().doDisplaySpeakGuideLog(this.mVid, this.mOtherParams, str);
    }

    private void zd(String str) {
        int dimensionPixelSize;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.fdf) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((BdUtilHelper.getEquipmentWidth(this.mContext.getPageActivity()) - this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180)) - this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_tbds26), -2);
                layoutParams.addRule(12);
                layoutParams.leftMargin = this.mContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds26);
                if (this.fdb) {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds96);
                } else {
                    dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds130);
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.mParentView.addView(this.fdf, layoutParams);
            }
            this.fdf.setText(str);
            this.fdf.setVisibility(0);
        }
    }

    private void aye() {
        String b = j.b(new Date());
        if (b.equals(this.fcZ.date)) {
            this.fcZ.eGV++;
        } else {
            this.fcZ.date = b;
            this.fcZ.eGV = 1;
        }
        if (this.fcZ.eGV >= com.baidu.live.v.a.zl().awC.aax) {
            bmY();
            bmT();
            return;
        }
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcZ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmY() {
        if (this.fde != null) {
            this.fde.removeMessages(1);
        }
        this.fcZ.fdi = true;
        this.fcZ.date = j.b(new Date());
        com.baidu.live.c.pr().putString("guide_speak_show_times_date", this.fcZ.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private final WeakReference<b> eQo;

        a(b bVar) {
            this.eQo = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = this.eQo.get();
            if (bVar != null) {
                switch (message.what) {
                    case 1:
                        bVar.bmV();
                        return;
                    case 2:
                        bVar.bmX();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
