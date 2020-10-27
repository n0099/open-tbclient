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
    private BaseActivity bHN;
    private InterfaceC0646a gJA;
    protected String gJC;
    private int gJD;
    private com.baidu.tieba.ala.live.b.a gJw;
    private IPayChannel gJx;
    private IPayCallback gJy;
    private int gJz;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gJB = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gJE = 0;
    private long gJF = 0;
    private long gJG = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bSJ();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0644a gJH = new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.live.c.a.2
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
    /* loaded from: classes4.dex */
    public interface InterfaceC0646a {
        void Hk(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0644a interfaceC0644a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bHN = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gJw = a(payChannelType, this.gJH);
        this.gJx = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gJw != null) {
            this.bHN.showLoadingDialog(this.bHN.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gJw.a(payConfig);
        }
    }

    private void bRy() {
        this.gJy = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gJD = i;
                a.this.gJF = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bSJ();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.ms(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bHN.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.ms(false);
                        break;
                }
                a.this.gJx.release();
                a.this.gJy = null;
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
                if (this.gJw != null && !StringUtils.isNull(this.gJw.bSK())) {
                    jSONObject2.put("order_id", this.gJw.bSK());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Hn(String str) {
        if (this.gJw != null) {
            this.gJw.Hm(str);
        }
        bSL();
    }

    public void Ho(String str) {
        this.gJB = 2;
        this.gJC = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gJC);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0646a interfaceC0646a) {
        this.gJA = interfaceC0646a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bHN.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bHN.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bHN.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                ms(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gJB + " mPayway:" + this.gJC + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gJB == 2 && !TextUtils.isEmpty(this.gJC)) {
                Hn(this.gJC);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gJA != null) {
                this.gJA.Hk(str2);
                return;
            } else {
                bSL();
                return;
            }
        }
        if (this.showToast) {
            this.bHN.showToast(str);
        }
        this.mPayStatus = 3;
        ms(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gJz = i2;
        this.gJE = i;
        this.gJG = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bHN.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mt(false);
        } else if (this.gJz == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                mt(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gJz == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            mt(true);
        } else if (this.gJz == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mt(false);
        } else if (this.gJz == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mt(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSJ() {
        if (this.gJw != null) {
            this.bHN.showLoadingDialog(this.bHN.getString(a.i.sdk_pay_loading));
            this.gJw.bSJ();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bSL() {
        if (this.gJx != null && this.gJw != null && this.gJw.bSH() != null && !this.gJw.bSH().isEmpty()) {
            if (this.gJy == null) {
                bRy();
            }
            this.gJx.pay(this.gJw.bSH(), this.gJy);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bSM() {
        Intent intent = new Intent();
        if (this.gJw != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gJz);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gJw.bSK());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bSN() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        Intent bSM = bSM();
        this.bHN.setResult(-1, bSM);
        if (this.gJA != null) {
            this.gJA.a(z, bSM);
        }
    }

    private void mt(boolean z) {
        this.bHN.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        ms(z);
    }
}
