package com.baidu.tieba.ala.live.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.live.b.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a {
    private BaseActivity buT;
    private com.baidu.tieba.ala.live.b.a gga;
    private IPayChannel ggb;
    private IPayCallback ggc;
    private int ggd;
    private InterfaceC0617a gge;
    protected String ggg;
    private int ggh;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int ggf = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int ggi = 0;
    private long ggj = 0;
    private long ggk = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bLk();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0615a ggl = new a.InterfaceC0615a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0615a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0615a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0617a {
        void FD(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0615a interfaceC0615a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.buT = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gga = a(payChannelType, this.ggl);
        this.ggb = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gga != null) {
            this.buT.showLoadingDialog(this.buT.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gga.a(payConfig);
        }
    }

    private void bKY() {
        this.ggc = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.ggh = i;
                a.this.ggj = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bLk();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.lv(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.buT.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.lv(false);
                        break;
                }
                a.this.ggb.release();
                a.this.ggc = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, HttpResponsedMessage httpResponsedMessage) {
        if (!StringUtils.isNull(str)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (httpResponsedMessage == null) {
                    jSONObject2.put("cpay_status", i);
                    jSONObject2.put("ctimestamp", currentTimeMillis);
                } else {
                    jSONObject2.put("spay_status", i);
                    jSONObject2.put("stimestamp", currentTimeMillis);
                    jSONObject2.put(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, this.hasResendGetMsg ? 1 : 0);
                }
                if (this.gga != null && !StringUtils.isNull(this.gga.bLl())) {
                    jSONObject2.put("order_id", this.gga.bLl());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void FF(String str) {
        if (this.gga != null) {
            this.gga.FE(str);
        }
        bLm();
    }

    public void FG(String str) {
        this.ggf = 2;
        this.ggg = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.ggg);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0617a interfaceC0617a) {
        this.gge = interfaceC0617a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.buT.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.buT.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.buT.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                lv(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.ggf + " mPayway:" + this.ggg + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.ggf == 2 && !TextUtils.isEmpty(this.ggg)) {
                FF(this.ggg);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gge != null) {
                this.gge.FD(str2);
                return;
            } else {
                bLm();
                return;
            }
        }
        if (this.showToast) {
            this.buT.showToast(str);
        }
        this.mPayStatus = 3;
        lv(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.ggd = i2;
        this.ggi = i;
        this.ggk = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.buT.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lw(false);
        } else if (this.ggd == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                lw(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.ggd == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            lw(true);
        } else if (this.ggd == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lw(false);
        } else if (this.ggd == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lw(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        if (this.gga != null) {
            this.buT.showLoadingDialog(this.buT.getString(a.i.sdk_pay_loading));
            this.gga.bLk();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bLm() {
        if (this.ggb != null && this.gga != null && this.gga.bLi() != null && !this.gga.bLi().isEmpty()) {
            if (this.ggc == null) {
                bKY();
            }
            this.ggb.pay(this.gga.bLi(), this.ggc);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bLn() {
        Intent intent = new Intent();
        if (this.gga != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.ggd);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gga.bLl());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bLo() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(boolean z) {
        Intent bLn = bLn();
        this.buT.setResult(-1, bLn);
        if (this.gge != null) {
            this.gge.a(z, bLn);
        }
    }

    private void lw(boolean z) {
        this.buT.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        lv(z);
    }
}
