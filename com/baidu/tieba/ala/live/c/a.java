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
    private BaseActivity byl;
    private com.baidu.tieba.ala.live.b.a gjp;
    private IPayChannel gjq;
    private IPayCallback gjr;
    private int gjs;
    private InterfaceC0613a gjt;
    protected String gjv;
    private int gjw;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gju = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gjx = 0;
    private long gjy = 0;
    private long gjz = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bMv();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0611a gjA = new a.InterfaceC0611a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0611a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0611a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0613a {
        void Gb(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0611a interfaceC0611a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.byl = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gjp = a(payChannelType, this.gjA);
        this.gjq = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gjp != null) {
            this.byl.showLoadingDialog(this.byl.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gjp.a(payConfig);
        }
    }

    private void bMj() {
        this.gjr = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gjw = i;
                a.this.gjy = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bMv();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.lz(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.byl.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.lz(false);
                        break;
                }
                a.this.gjq.release();
                a.this.gjr = null;
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
                if (this.gjp != null && !StringUtils.isNull(this.gjp.bMw())) {
                    jSONObject2.put("order_id", this.gjp.bMw());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Gd(String str) {
        if (this.gjp != null) {
            this.gjp.Gc(str);
        }
        bMx();
    }

    public void Ge(String str) {
        this.gju = 2;
        this.gjv = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gjv);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0613a interfaceC0613a) {
        this.gjt = interfaceC0613a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.byl.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.byl.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.byl.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                lz(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gju + " mPayway:" + this.gjv + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gju == 2 && !TextUtils.isEmpty(this.gjv)) {
                Gd(this.gjv);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gjt != null) {
                this.gjt.Gb(str2);
                return;
            } else {
                bMx();
                return;
            }
        }
        if (this.showToast) {
            this.byl.showToast(str);
        }
        this.mPayStatus = 3;
        lz(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gjs = i2;
        this.gjx = i;
        this.gjz = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.byl.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lA(false);
        } else if (this.gjs == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                lA(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gjs == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            lA(true);
        } else if (this.gjs == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lA(false);
        } else if (this.gjs == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lA(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            lA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMv() {
        if (this.gjp != null) {
            this.byl.showLoadingDialog(this.byl.getString(a.i.sdk_pay_loading));
            this.gjp.bMv();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bMx() {
        if (this.gjq != null && this.gjp != null && this.gjp.bMt() != null && !this.gjp.bMt().isEmpty()) {
            if (this.gjr == null) {
                bMj();
            }
            this.gjq.pay(this.gjp.bMt(), this.gjr);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bMy() {
        Intent intent = new Intent();
        if (this.gjp != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gjs);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gjp.bMw());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bMz() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        Intent bMy = bMy();
        this.byl.setResult(-1, bMy);
        if (this.gjt != null) {
            this.gjt.a(z, bMy);
        }
    }

    private void lA(boolean z) {
        this.byl.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        lz(z);
    }
}
