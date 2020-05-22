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
    private com.baidu.tieba.ala.live.b.a fDo;
    private IPayChannel fDp;
    private IPayCallback fDq;
    private int fDr;
    private InterfaceC0551a fDs;
    protected String fDu;
    private int fDv;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int fDt = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int fDw = 0;
    private long fDx = 0;
    private long fDy = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bvE();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0549a fDz = new a.InterfaceC0549a() { // from class: com.baidu.tieba.ala.live.c.a.2
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
        this.fDo = a(payChannelType, this.fDz);
        this.fDp = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fDo != null) {
            this.bjI.showLoadingDialog(this.bjI.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fDo.a(payConfig);
        }
    }

    private void bvs() {
        this.fDq = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.fDv = i;
                a.this.fDx = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bvE();
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
                a.this.fDp.release();
                a.this.fDq = null;
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
                if (this.fDo != null && !StringUtils.isNull(this.fDo.bvF())) {
                    jSONObject2.put("order_id", this.fDo.bvF());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void Ca(String str) {
        if (this.fDo != null) {
            this.fDo.BZ(str);
        }
        bvG();
    }

    public void Cb(String str) {
        this.fDt = 2;
        this.fDu = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.fDu);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0551a interfaceC0551a) {
        this.fDs = interfaceC0551a;
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
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.fDt + " mPayway:" + this.fDu + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.fDt == 2 && !TextUtils.isEmpty(this.fDu)) {
                Ca(this.fDu);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fDs != null) {
                this.fDs.BY(str2);
                return;
            } else {
                bvG();
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
        this.fDr = i2;
        this.fDw = i;
        this.fDy = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bjI.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else if (this.fDr == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                ke(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fDr == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            ke(true);
        } else if (this.fDr == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else if (this.fDr == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ke(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvE() {
        if (this.fDo != null) {
            this.bjI.showLoadingDialog(this.bjI.getString(a.i.sdk_pay_loading));
            this.fDo.bvE();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", null));
        }
    }

    private void bvG() {
        if (this.fDp != null && this.fDo != null && this.fDo.bvC() != null && !this.fDo.bvC().isEmpty()) {
            if (this.fDq == null) {
                bvs();
            }
            this.fDp.pay(this.fDo.bvC(), this.fDq);
        }
    }

    public Intent bvH() {
        Intent intent = new Intent();
        if (this.fDo != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fDr);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fDo.bvF());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bvI() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        Intent bvH = bvH();
        this.bjI.setResult(-1, bvH);
        if (this.fDs != null) {
            this.fDs.a(z, bvH);
        }
    }

    private void ke(boolean z) {
        this.bjI.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        kd(z);
    }
}
