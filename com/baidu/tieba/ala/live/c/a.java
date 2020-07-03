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
/* loaded from: classes3.dex */
public abstract class a {
    private BaseActivity boL;
    private com.baidu.tieba.ala.live.b.a fOI;
    private IPayChannel fOJ;
    private IPayCallback fOK;
    private int fOL;
    private InterfaceC0559a fOM;
    protected String fOO;
    private int fOP;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int fON = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int fOQ = 0;
    private long fOR = 0;
    private long fOS = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.byB();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0557a fOT = new a.InterfaceC0557a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0557a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0557a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0559a {
        void Cw(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0557a interfaceC0557a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.boL = baseActivity;
        this.mPayChannelType = payChannelType;
        this.fOI = a(payChannelType, this.fOT);
        this.fOJ = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fOI != null) {
            this.boL.showLoadingDialog(this.boL.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fOI.a(payConfig);
        }
    }

    private void byp() {
        this.fOK = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.fOP = i;
                a.this.fOR = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.byB();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.kr(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.boL.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.kr(false);
                        break;
                }
                a.this.fOJ.release();
                a.this.fOK = null;
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
                if (this.fOI != null && !StringUtils.isNull(this.fOI.byC())) {
                    jSONObject2.put("order_id", this.fOI.byC());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Cy(String str) {
        if (this.fOI != null) {
            this.fOI.Cx(str);
        }
        byD();
    }

    public void Cz(String str) {
        this.fON = 2;
        this.fOO = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.fOO);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0559a interfaceC0559a) {
        this.fOM = interfaceC0559a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.boL.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.boL.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.boL.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                kr(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.fON + " mPayway:" + this.fOO + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.fON == 2 && !TextUtils.isEmpty(this.fOO)) {
                Cy(this.fOO);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fOM != null) {
                this.fOM.Cw(str2);
                return;
            } else {
                byD();
                return;
            }
        }
        if (this.showToast) {
            this.boL.showToast(str);
        }
        this.mPayStatus = 3;
        kr(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.fOL = i2;
        this.fOQ = i;
        this.fOS = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.boL.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ks(false);
        } else if (this.fOL == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                ks(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fOL == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            ks(true);
        } else if (this.fOL == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ks(false);
        } else if (this.fOL == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ks(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ks(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byB() {
        if (this.fOI != null) {
            this.boL.showLoadingDialog(this.boL.getString(a.i.sdk_pay_loading));
            this.fOI.byB();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", null));
        }
    }

    private void byD() {
        if (this.fOJ != null && this.fOI != null && this.fOI.byz() != null && !this.fOI.byz().isEmpty()) {
            if (this.fOK == null) {
                byp();
            }
            this.fOJ.pay(this.fOI.byz(), this.fOK);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", null));
        }
    }

    public Intent byE() {
        Intent intent = new Intent();
        if (this.fOI != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fOL);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fOI.byC());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int byF() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(boolean z) {
        Intent byE = byE();
        this.boL.setResult(-1, byE);
        if (this.fOM != null) {
            this.fOM.a(z, byE);
        }
    }

    private void ks(boolean z) {
        this.boL.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        kr(z);
    }
}
