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
    private BaseActivity buW;
    private com.baidu.tieba.ala.live.b.a gge;
    private IPayChannel ggf;
    private IPayCallback ggg;
    private int ggh;
    private InterfaceC0617a ggi;
    protected String ggk;
    private int ggl;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int ggj = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int ggm = 0;
    private long ggn = 0;
    private long ggo = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bLl();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0615a ggp = new a.InterfaceC0615a() { // from class: com.baidu.tieba.ala.live.c.a.2
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
        void FE(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0615a interfaceC0615a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.buW = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gge = a(payChannelType, this.ggp);
        this.ggf = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gge != null) {
            this.buW.showLoadingDialog(this.buW.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gge.a(payConfig);
        }
    }

    private void bKZ() {
        this.ggg = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.ggl = i;
                a.this.ggn = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bLl();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.lx(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.buW.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.lx(false);
                        break;
                }
                a.this.ggf.release();
                a.this.ggg = null;
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
                if (this.gge != null && !StringUtils.isNull(this.gge.bLm())) {
                    jSONObject2.put("order_id", this.gge.bLm());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void FG(String str) {
        if (this.gge != null) {
            this.gge.FF(str);
        }
        bLn();
    }

    public void FH(String str) {
        this.ggj = 2;
        this.ggk = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.ggk);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0617a interfaceC0617a) {
        this.ggi = interfaceC0617a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.buW.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.buW.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.buW.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                lx(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.ggj + " mPayway:" + this.ggk + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.ggj == 2 && !TextUtils.isEmpty(this.ggk)) {
                FG(this.ggk);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.ggi != null) {
                this.ggi.FE(str2);
                return;
            } else {
                bLn();
                return;
            }
        }
        if (this.showToast) {
            this.buW.showToast(str);
        }
        this.mPayStatus = 3;
        lx(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.ggh = i2;
        this.ggm = i;
        this.ggo = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.buW.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ly(false);
        } else if (this.ggh == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                ly(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.ggh == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            ly(true);
        } else if (this.ggh == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ly(false);
        } else if (this.ggh == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ly(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ly(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (this.gge != null) {
            this.buW.showLoadingDialog(this.buW.getString(a.i.sdk_pay_loading));
            this.gge.bLl();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bLn() {
        if (this.ggf != null && this.gge != null && this.gge.bLj() != null && !this.gge.bLj().isEmpty()) {
            if (this.ggg == null) {
                bKZ();
            }
            this.ggf.pay(this.gge.bLj(), this.ggg);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bLo() {
        Intent intent = new Intent();
        if (this.gge != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.ggh);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gge.bLm());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bLp() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lx(boolean z) {
        Intent bLo = bLo();
        this.buW.setResult(-1, bLo);
        if (this.ggi != null) {
            this.ggi.a(z, bLo);
        }
    }

    private void ly(boolean z) {
        this.buW.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        lx(z);
    }
}
