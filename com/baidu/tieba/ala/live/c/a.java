package com.baidu.tieba.ala.live.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
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
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.b.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a {
    private BaseActivity bjI;
    private IPayChannel fDA;
    private IPayCallback fDB;
    private int fDC;
    private InterfaceC0551a fDD;
    protected String fDF;
    private int fDG;
    private com.baidu.tieba.ala.live.b.a fDz;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int fDE = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int fDH = 0;
    private long fDI = 0;
    private long fDJ = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bvG();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0549a fDK = new a.InterfaceC0549a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0549a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0549a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0551a {
        void BY(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0549a interfaceC0549a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bjI = baseActivity;
        this.mPayChannelType = payChannelType;
        this.fDz = a(payChannelType, this.fDK);
        this.fDA = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fDz != null) {
            this.bjI.showLoadingDialog(this.bjI.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fDz.a(payConfig);
        }
    }

    private void bvu() {
        this.fDB = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.fDG = i;
                a.this.fDI = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bvG();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.mPayStatus = 1;
                        a.this.kd(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bjI.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.kd(false);
                        break;
                }
                a.this.fDA.release();
                a.this.fDB = null;
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
                if (this.fDz != null && !StringUtils.isNull(this.fDz.bvH())) {
                    jSONObject2.put("order_id", this.fDz.bvH());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Ca(String str) {
        if (this.fDz != null) {
            this.fDz.BZ(str);
        }
        bvI();
    }

    public void Cb(String str) {
        this.fDE = 2;
        this.fDF = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.fDF);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0551a interfaceC0551a) {
        this.fDD = interfaceC0551a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bjI.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bjI.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bjI.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                kd(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.fDE + " mPayway:" + this.fDF + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.fDE == 2 && !TextUtils.isEmpty(this.fDF)) {
                Ca(this.fDF);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fDD != null) {
                this.fDD.BY(str2);
                return;
            } else {
                bvI();
                return;
            }
        }
        if (this.showToast) {
            this.bjI.showToast(str);
        }
        this.mPayStatus = 3;
        kd(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.fDC = i2;
        this.fDH = i;
        this.fDJ = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bjI.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else if (this.fDC == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                ke(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fDC == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            ke(true);
        } else if (this.fDC == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else if (this.fDC == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        if (this.fDz != null) {
            this.bjI.showLoadingDialog(this.bjI.getString(a.i.sdk_pay_loading));
            this.fDz.bvG();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", null));
        }
    }

    private void bvI() {
        if (this.fDA != null && this.fDz != null && this.fDz.bvE() != null && !this.fDz.bvE().isEmpty()) {
            if (this.fDB == null) {
                bvu();
            }
            this.fDA.pay(this.fDz.bvE(), this.fDB);
        }
    }

    public Intent bvJ() {
        Intent intent = new Intent();
        if (this.fDz != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fDC);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fDz.bvH());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bvK() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        Intent bvJ = bvJ();
        this.bjI.setResult(-1, bvJ);
        if (this.fDD != null) {
            this.fDD.a(z, bvJ);
        }
    }

    private void ke(boolean z) {
        this.bjI.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        kd(z);
    }
}
