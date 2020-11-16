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
    private BaseActivity bLI;
    private com.baidu.tieba.ala.live.b.a gOP;
    private IPayChannel gOQ;
    private IPayCallback gOR;
    private int gOS;
    private InterfaceC0658a gOT;
    protected String gOV;
    private int gOW;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gOU = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gOX = 0;
    private long gOY = 0;
    private long gOZ = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bUB();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0656a gPa = new a.InterfaceC0656a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0656a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0656a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0658a {
        void GY(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0656a interfaceC0656a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bLI = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gOP = a(payChannelType, this.gPa);
        this.gOQ = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gOP != null) {
            this.bLI.showLoadingDialog(this.bLI.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gOP.a(payConfig);
        }
    }

    private void bTq() {
        this.gOR = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gOW = i;
                a.this.gOY = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bUB();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.mC(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bLI.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.mC(false);
                        break;
                }
                a.this.gOQ.release();
                a.this.gOR = null;
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
                if (this.gOP != null && !StringUtils.isNull(this.gOP.bUC())) {
                    jSONObject2.put("order_id", this.gOP.bUC());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Hb(String str) {
        if (this.gOP != null) {
            this.gOP.Ha(str);
        }
        bUD();
    }

    public void Hc(String str) {
        this.gOU = 2;
        this.gOV = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gOV);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        this.gOT = interfaceC0658a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bLI.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bLI.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bLI.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                mC(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gOU + " mPayway:" + this.gOV + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gOU == 2 && !TextUtils.isEmpty(this.gOV)) {
                Hb(this.gOV);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gOT != null) {
                this.gOT.GY(str2);
                return;
            } else {
                bUD();
                return;
            }
        }
        if (this.showToast) {
            this.bLI.showToast(str);
        }
        this.mPayStatus = 3;
        mC(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gOS = i2;
        this.gOX = i;
        this.gOZ = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bLI.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mD(false);
        } else if (this.gOS == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                mD(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gOS == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            mD(true);
        } else if (this.gOS == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mD(false);
        } else if (this.gOS == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mD(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        if (this.gOP != null) {
            this.bLI.showLoadingDialog(this.bLI.getString(a.h.sdk_pay_loading));
            this.gOP.bUB();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bUD() {
        if (this.gOQ != null && this.gOP != null && this.gOP.bUz() != null && !this.gOP.bUz().isEmpty()) {
            if (this.gOR == null) {
                bTq();
            }
            this.gOQ.pay(this.gOP.bUz(), this.gOR);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bUE() {
        Intent intent = new Intent();
        if (this.gOP != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gOS);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gOP.bUC());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bUF() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC(boolean z) {
        Intent bUE = bUE();
        this.bLI.setResult(-1, bUE);
        if (this.gOT != null) {
            this.gOT.a(z, bUE);
        }
    }

    private void mD(boolean z) {
        this.bLI.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        mC(z);
    }
}
