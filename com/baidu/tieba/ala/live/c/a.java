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
/* loaded from: classes11.dex */
public abstract class a {
    private BaseActivity bVA;
    private com.baidu.tieba.ala.live.b.a hjQ;
    private IPayChannel hjR;
    private IPayCallback hjS;
    private int hjT;
    private InterfaceC0647a hjU;
    protected String hjW;
    private int hjX;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private int mPayStatus = 1;
    protected int hjV = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int hjY = 0;
    private long hjZ = 0;
    private long hka = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bYg();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0645a hkb = new a.InterfaceC0645a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0645a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0645a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0647a {
        void Ha(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0645a interfaceC0645a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bVA = baseActivity;
        this.mPayChannelType = payChannelType;
        this.hjQ = a(payChannelType, this.hkb);
        this.hjR = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.hjQ != null) {
            this.bVA.showLoadingDialog(this.bVA.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.hjQ.a(payConfig);
        }
    }

    private void bWA() {
        this.hjS = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.hjX = i;
                a.this.hjZ = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bYg();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.nE(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bVA.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.nE(false);
                        break;
                }
                a.this.hjR.release();
                a.this.hjS = null;
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
                if (this.hjQ != null && !StringUtils.isNull(this.hjQ.bYh())) {
                    jSONObject2.put("order_id", this.hjQ.bYh());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Hj(String str) {
        if (this.hjQ != null) {
            this.hjQ.Hi(str);
        }
        bYi();
    }

    public void Hk(String str) {
        this.hjV = 2;
        this.hjW = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.hjW);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0647a interfaceC0647a) {
        this.hjU = interfaceC0647a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bVA.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bVA.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bVA.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                nE(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.hjV + " mPayway:" + this.hjW + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.hjV == 2 && !TextUtils.isEmpty(this.hjW)) {
                Hj(this.hjW);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.hjU != null) {
                this.hjU.Ha(str2);
                return;
            } else {
                bYi();
                return;
            }
        }
        if (this.showToast) {
            this.bVA.showToast(str);
        }
        this.mPayStatus = 3;
        nE(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.hjT = i2;
        this.hjY = i;
        this.hka = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bVA.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hjT == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                nF(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.hjT == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            nF(true);
        } else if (this.hjT == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hjT == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYg() {
        if (this.hjQ != null) {
            this.bVA.showLoadingDialog(this.bVA.getString(a.h.sdk_pay_loading));
            this.hjQ.bYg();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bYi() {
        if (this.hjR != null && this.hjQ != null && this.hjQ.bYe() != null && !this.hjQ.bYe().isEmpty()) {
            if (this.hjS == null) {
                bWA();
            }
            this.hjR.pay(this.hjQ.bYe(), this.hjS);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bYj() {
        Intent intent = new Intent();
        if (this.hjQ != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.hjT);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.hjQ.bYh());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bYk() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        Intent bYj = bYj();
        this.bVA.setResult(-1, bYj);
        if (this.hjU != null) {
            this.hjU.a(z, bYj);
        }
    }

    private void nF(boolean z) {
        this.bVA.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        nE(z);
    }
}
