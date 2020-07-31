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
/* loaded from: classes4.dex */
public abstract class a {
    private BaseActivity bpg;
    private com.baidu.tieba.ala.live.b.a fUb;
    private IPayChannel fUc;
    private IPayCallback fUd;
    private int fUe;
    private InterfaceC0570a fUf;
    protected String fUh;
    private int fUi;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int fUg = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int fUj = 0;
    private long fUk = 0;
    private long fUl = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bBQ();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0568a fUm = new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0568a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0568a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0570a {
        void Di(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0568a interfaceC0568a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bpg = baseActivity;
        this.mPayChannelType = payChannelType;
        this.fUb = a(payChannelType, this.fUm);
        this.fUc = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fUb != null) {
            this.bpg.showLoadingDialog(this.bpg.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fUb.a(payConfig);
        }
    }

    private void bBE() {
        this.fUd = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.fUi = i;
                a.this.fUk = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bBQ();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.kV(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bpg.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.kV(false);
                        break;
                }
                a.this.fUc.release();
                a.this.fUd = null;
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
                if (this.fUb != null && !StringUtils.isNull(this.fUb.bBR())) {
                    jSONObject2.put("order_id", this.fUb.bBR());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Dk(String str) {
        if (this.fUb != null) {
            this.fUb.Dj(str);
        }
        bBS();
    }

    public void Dl(String str) {
        this.fUg = 2;
        this.fUh = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.fUh);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0570a interfaceC0570a) {
        this.fUf = interfaceC0570a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bpg.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bpg.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bpg.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                kV(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.fUg + " mPayway:" + this.fUh + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.fUg == 2 && !TextUtils.isEmpty(this.fUh)) {
                Dk(this.fUh);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fUf != null) {
                this.fUf.Di(str2);
                return;
            } else {
                bBS();
                return;
            }
        }
        if (this.showToast) {
            this.bpg.showToast(str);
        }
        this.mPayStatus = 3;
        kV(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.fUe = i2;
        this.fUj = i;
        this.fUl = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bpg.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            kW(false);
        } else if (this.fUe == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                kW(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fUe == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            kW(true);
        } else if (this.fUe == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            kW(false);
        } else if (this.fUe == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            kW(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            kW(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBQ() {
        if (this.fUb != null) {
            this.bpg.showLoadingDialog(this.bpg.getString(a.i.sdk_pay_loading));
            this.fUb.bBQ();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", null));
        }
    }

    private void bBS() {
        if (this.fUc != null && this.fUb != null && this.fUb.bBO() != null && !this.fUb.bBO().isEmpty()) {
            if (this.fUd == null) {
                bBE();
            }
            this.fUc.pay(this.fUb.bBO(), this.fUd);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", null));
        }
    }

    public Intent bBT() {
        Intent intent = new Intent();
        if (this.fUb != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fUe);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fUb.bBR());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bBU() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(boolean z) {
        Intent bBT = bBT();
        this.bpg.setResult(-1, bBT);
        if (this.fUf != null) {
            this.fUf.a(z, bBT);
        }
    }

    private void kW(boolean z) {
        this.bpg.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        kV(z);
    }
}
