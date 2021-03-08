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
    private BaseActivity bXa;
    private IPayChannel hlA;
    private IPayCallback hlB;
    private int hlC;
    private InterfaceC0653a hlD;
    protected String hlF;
    private int hlG;
    private com.baidu.tieba.ala.live.b.a hlz;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private int mPayStatus = 1;
    protected int hlE = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int hlH = 0;
    private long hlI = 0;
    private long hlJ = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bYm();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0651a hlK = new a.InterfaceC0651a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0651a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0651a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0653a {
        void Hj(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0651a interfaceC0651a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bXa = baseActivity;
        this.mPayChannelType = payChannelType;
        this.hlz = a(payChannelType, this.hlK);
        this.hlA = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.hlz != null) {
            this.bXa.showLoadingDialog(this.bXa.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.hlz.a(payConfig);
        }
    }

    private void bWG() {
        this.hlB = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.hlG = i;
                a.this.hlI = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bYm();
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
                            a.this.bXa.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.nE(false);
                        break;
                }
                a.this.hlA.release();
                a.this.hlB = null;
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
                if (this.hlz != null && !StringUtils.isNull(this.hlz.bYn())) {
                    jSONObject2.put("order_id", this.hlz.bYn());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Hs(String str) {
        if (this.hlz != null) {
            this.hlz.Hr(str);
        }
        bYo();
    }

    public void Ht(String str) {
        this.hlE = 2;
        this.hlF = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.hlF);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0653a interfaceC0653a) {
        this.hlD = interfaceC0653a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bXa.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bXa.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bXa.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                nE(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.hlE + " mPayway:" + this.hlF + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.hlE == 2 && !TextUtils.isEmpty(this.hlF)) {
                Hs(this.hlF);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.hlD != null) {
                this.hlD.Hj(str2);
                return;
            } else {
                bYo();
                return;
            }
        }
        if (this.showToast) {
            this.bXa.showToast(str);
        }
        this.mPayStatus = 3;
        nE(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.hlC = i2;
        this.hlH = i;
        this.hlJ = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bXa.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hlC == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                nF(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.hlC == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            nF(true);
        } else if (this.hlC == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else if (this.hlC == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            nF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYm() {
        if (this.hlz != null) {
            this.bXa.showLoadingDialog(this.bXa.getString(a.h.sdk_pay_loading));
            this.hlz.bYm();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bYo() {
        if (this.hlA != null && this.hlz != null && this.hlz.bYk() != null && !this.hlz.bYk().isEmpty()) {
            if (this.hlB == null) {
                bWG();
            }
            this.hlA.pay(this.hlz.bYk(), this.hlB);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bYp() {
        Intent intent = new Intent();
        if (this.hlz != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.hlC);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.hlz.bYn());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bYq() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        Intent bYp = bYp();
        this.bXa.setResult(-1, bYp);
        if (this.hlD != null) {
            this.hlD.a(z, bYp);
        }
    }

    private void nF(boolean z) {
        this.bXa.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        nE(z);
    }
}
