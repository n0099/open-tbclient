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
    private BaseActivity bNs;
    private com.baidu.tieba.ala.live.b.a gPi;
    private IPayChannel gPj;
    private IPayCallback gPk;
    private int gPl;
    private InterfaceC0658a gPm;
    protected String gPo;
    private int gPp;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gPn = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gPq = 0;
    private long gPr = 0;
    private long gPs = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bVi();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0656a gPt = new a.InterfaceC0656a() { // from class: com.baidu.tieba.ala.live.c.a.2
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
        void Hx(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0656a interfaceC0656a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bNs = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gPi = a(payChannelType, this.gPt);
        this.gPj = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gPi != null) {
            this.bNs.showLoadingDialog(this.bNs.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gPi.a(payConfig);
        }
    }

    private void bTX() {
        this.gPk = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gPp = i;
                a.this.gPr = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bVi();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.mB(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bNs.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.mB(false);
                        break;
                }
                a.this.gPj.release();
                a.this.gPk = null;
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
                if (this.gPi != null && !StringUtils.isNull(this.gPi.bVj())) {
                    jSONObject2.put("order_id", this.gPi.bVj());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void HA(String str) {
        if (this.gPi != null) {
            this.gPi.Hz(str);
        }
        bVk();
    }

    public void HB(String str) {
        this.gPn = 2;
        this.gPo = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gPo);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        this.gPm = interfaceC0658a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bNs.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bNs.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bNs.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                mB(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gPn + " mPayway:" + this.gPo + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gPn == 2 && !TextUtils.isEmpty(this.gPo)) {
                HA(this.gPo);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gPm != null) {
                this.gPm.Hx(str2);
                return;
            } else {
                bVk();
                return;
            }
        }
        if (this.showToast) {
            this.bNs.showToast(str);
        }
        this.mPayStatus = 3;
        mB(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gPl = i2;
        this.gPq = i;
        this.gPs = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bNs.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mC(false);
        } else if (this.gPl == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                mC(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gPl == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            mC(true);
        } else if (this.gPl == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mC(false);
        } else if (this.gPl == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mC(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mC(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        if (this.gPi != null) {
            this.bNs.showLoadingDialog(this.bNs.getString(a.h.sdk_pay_loading));
            this.gPi.bVi();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bVk() {
        if (this.gPj != null && this.gPi != null && this.gPi.bVg() != null && !this.gPi.bVg().isEmpty()) {
            if (this.gPk == null) {
                bTX();
            }
            this.gPj.pay(this.gPi.bVg(), this.gPk);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bVl() {
        Intent intent = new Intent();
        if (this.gPi != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gPl);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gPi.bVj());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bVm() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(boolean z) {
        Intent bVl = bVl();
        this.bNs.setResult(-1, bVl);
        if (this.gPm != null) {
            this.gPm.a(z, bVl);
        }
    }

    private void mC(boolean z) {
        this.bNs.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        mB(z);
    }
}
