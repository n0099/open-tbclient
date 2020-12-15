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
    private BaseActivity bQN;
    private com.baidu.tieba.ala.live.b.a gYe;
    private IPayChannel gYf;
    private IPayCallback gYg;
    private int gYh;
    private InterfaceC0671a gYi;
    protected String gYk;
    private int gYl;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gYj = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gYm = 0;
    private long gYn = 0;
    private long gYo = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bYl();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0669a gYp = new a.InterfaceC0669a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0669a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0669a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0671a {
        void HM(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0669a interfaceC0669a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bQN = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gYe = a(payChannelType, this.gYp);
        this.gYf = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gYe != null) {
            this.bQN.showLoadingDialog(this.bQN.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gYe.a(payConfig);
        }
    }

    private void bXb() {
        this.gYg = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gYl = i;
                a.this.gYn = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bYl();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.mX(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bQN.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.mX(false);
                        break;
                }
                a.this.gYf.release();
                a.this.gYg = null;
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
                if (this.gYe != null && !StringUtils.isNull(this.gYe.bYm())) {
                    jSONObject2.put("order_id", this.gYe.bYm());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void HP(String str) {
        if (this.gYe != null) {
            this.gYe.HO(str);
        }
        bYn();
    }

    public void HQ(String str) {
        this.gYj = 2;
        this.gYk = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gYk);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0671a interfaceC0671a) {
        this.gYi = interfaceC0671a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bQN.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bQN.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bQN.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                mX(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gYj + " mPayway:" + this.gYk + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gYj == 2 && !TextUtils.isEmpty(this.gYk)) {
                HP(this.gYk);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gYi != null) {
                this.gYi.HM(str2);
                return;
            } else {
                bYn();
                return;
            }
        }
        if (this.showToast) {
            this.bQN.showToast(str);
        }
        this.mPayStatus = 3;
        mX(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gYh = i2;
        this.gYm = i;
        this.gYo = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bQN.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mY(false);
        } else if (this.gYh == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                mY(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gYh == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            mY(true);
        } else if (this.gYh == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mY(false);
        } else if (this.gYh == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mY(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYl() {
        if (this.gYe != null) {
            this.bQN.showLoadingDialog(this.bQN.getString(a.h.sdk_pay_loading));
            this.gYe.bYl();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bYn() {
        if (this.gYf != null && this.gYe != null && this.gYe.bYj() != null && !this.gYe.bYj().isEmpty()) {
            if (this.gYg == null) {
                bXb();
            }
            this.gYf.pay(this.gYe.bYj(), this.gYg);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bYo() {
        Intent intent = new Intent();
        if (this.gYe != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gYh);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gYe.bYm());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bYp() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        Intent bYo = bYo();
        this.bQN.setResult(-1, bYo);
        if (this.gYi != null) {
            this.gYi.a(z, bYo);
        }
    }

    private void mY(boolean z) {
        this.bQN.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        mX(z);
    }
}
