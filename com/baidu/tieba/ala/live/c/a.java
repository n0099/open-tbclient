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
/* loaded from: classes10.dex */
public abstract class a {
    private BaseActivity bRI;
    private com.baidu.tieba.ala.live.b.a hfm;
    private IPayChannel hfn;
    private IPayCallback hfo;
    private int hfp;
    private InterfaceC0646a hfq;
    protected String hfs;
    private int hft;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int hfr = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int hfu = 0;
    private long hfv = 0;
    private long hfw = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bWZ();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0644a hfx = new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.live.c.a.2
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
    /* loaded from: classes10.dex */
    public interface InterfaceC0646a {
        void GA(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0644a interfaceC0644a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bRI = baseActivity;
        this.mPayChannelType = payChannelType;
        this.hfm = a(payChannelType, this.hfx);
        this.hfn = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.hfm != null) {
            this.bRI.showLoadingDialog(this.bRI.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.hfm.a(payConfig);
        }
    }

    private void bVP() {
        this.hfo = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.hft = i;
                a.this.hfv = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bWZ();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.nt(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bRI.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.nt(false);
                        break;
                }
                a.this.hfn.release();
                a.this.hfo = null;
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
                if (this.hfm != null && !StringUtils.isNull(this.hfm.bXa())) {
                    jSONObject2.put("order_id", this.hfm.bXa());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void GD(String str) {
        if (this.hfm != null) {
            this.hfm.GC(str);
        }
        bXb();
    }

    public void GE(String str) {
        this.hfr = 2;
        this.hfs = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.hfs);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0646a interfaceC0646a) {
        this.hfq = interfaceC0646a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bRI.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bRI.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bRI.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                nt(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.hfr + " mPayway:" + this.hfs + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.hfr == 2 && !TextUtils.isEmpty(this.hfs)) {
                GD(this.hfs);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.hfq != null) {
                this.hfq.GA(str2);
                return;
            } else {
                bXb();
                return;
            }
        }
        if (this.showToast) {
            this.bRI.showToast(str);
        }
        this.mPayStatus = 3;
        nt(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.hfp = i2;
        this.hfu = i;
        this.hfw = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bRI.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nu(false);
        } else if (this.hfp == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                nu(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.hfp == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            nu(true);
        } else if (this.hfp == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nu(false);
        } else if (this.hfp == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nu(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nu(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWZ() {
        if (this.hfm != null) {
            this.bRI.showLoadingDialog(this.bRI.getString(a.h.sdk_pay_loading));
            this.hfm.bWZ();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bXb() {
        if (this.hfn != null && this.hfm != null && this.hfm.bWX() != null && !this.hfm.bWX().isEmpty()) {
            if (this.hfo == null) {
                bVP();
            }
            this.hfn.pay(this.hfm.bWX(), this.hfo);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bXc() {
        Intent intent = new Intent();
        if (this.hfm != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.hfp);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.hfm.bXa());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bXd() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(boolean z) {
        Intent bXc = bXc();
        this.bRI.setResult(-1, bXc);
        if (this.hfq != null) {
            this.hfq.a(z, bXc);
        }
    }

    private void nu(boolean z) {
        this.bRI.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        nt(z);
    }
}
