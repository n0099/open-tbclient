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
    private com.baidu.tieba.ala.live.b.a hjC;
    private IPayChannel hjD;
    private IPayCallback hjE;
    private int hjF;
    private InterfaceC0646a hjG;
    protected String hjI;
    private int hjJ;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private int mPayStatus = 1;
    protected int hjH = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int hjK = 0;
    private long hjL = 0;
    private long hjM = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bXZ();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0644a hjN = new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0644a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0644a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0646a {
        void GZ(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0644a interfaceC0644a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bVA = baseActivity;
        this.mPayChannelType = payChannelType;
        this.hjC = a(payChannelType, this.hjN);
        this.hjD = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.hjC != null) {
            this.bVA.showLoadingDialog(this.bVA.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.hjC.a(payConfig);
        }
    }

    private void bWt() {
        this.hjE = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.hjJ = i;
                a.this.hjL = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bXZ();
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
                a.this.hjD.release();
                a.this.hjE = null;
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
                if (this.hjC != null && !StringUtils.isNull(this.hjC.bYa())) {
                    jSONObject2.put("order_id", this.hjC.bYa());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Hi(String str) {
        if (this.hjC != null) {
            this.hjC.Hh(str);
        }
        bYb();
    }

    public void Hj(String str) {
        this.hjH = 2;
        this.hjI = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.hjI);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0646a interfaceC0646a) {
        this.hjG = interfaceC0646a;
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
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.hjH + " mPayway:" + this.hjI + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.hjH == 2 && !TextUtils.isEmpty(this.hjI)) {
                Hi(this.hjI);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.hjG != null) {
                this.hjG.GZ(str2);
                return;
            } else {
                bYb();
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
        this.hjF = i2;
        this.hjK = i;
        this.hjM = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bVA.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hjF == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                nF(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.hjF == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            nF(true);
        } else if (this.hjF == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hjF == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXZ() {
        if (this.hjC != null) {
            this.bVA.showLoadingDialog(this.bVA.getString(a.h.sdk_pay_loading));
            this.hjC.bXZ();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bYb() {
        if (this.hjD != null && this.hjC != null && this.hjC.bXX() != null && !this.hjC.bXX().isEmpty()) {
            if (this.hjE == null) {
                bWt();
            }
            this.hjD.pay(this.hjC.bXX(), this.hjE);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bYc() {
        Intent intent = new Intent();
        if (this.hjC != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.hjF);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.hjC.bYa());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bYd() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        Intent bYc = bYc();
        this.bVA.setResult(-1, bYc);
        if (this.hjG != null) {
            this.hjG.a(z, bYc);
        }
    }

    private void nF(boolean z) {
        this.bVA.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        nE(z);
    }
}
