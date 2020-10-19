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
    private BaseActivity bEO;
    private com.baidu.tieba.ala.live.b.a gxI;
    private IPayChannel gxJ;
    private IPayCallback gxK;
    private int gxL;
    private InterfaceC0630a gxM;
    protected String gxO;
    private int gxP;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int gxN = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int gxQ = 0;
    private long gxR = 0;
    private long gxS = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bPM();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0628a gxT = new a.InterfaceC0628a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0628a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0628a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0630a {
        void GM(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0628a interfaceC0628a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bEO = baseActivity;
        this.mPayChannelType = payChannelType;
        this.gxI = a(payChannelType, this.gxT);
        this.gxJ = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.gxI != null) {
            this.bEO.showLoadingDialog(this.bEO.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.gxI.a(payConfig);
        }
    }

    private void bOT() {
        this.gxK = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.gxP = i;
                a.this.gxR = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.bPM();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.mb(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bEO.showToast(a.i.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.mb(false);
                        break;
                }
                a.this.gxJ.release();
                a.this.gxK = null;
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
                if (this.gxI != null && !StringUtils.isNull(this.gxI.bPN())) {
                    jSONObject2.put("order_id", this.gxI.bPN());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void GP(String str) {
        if (this.gxI != null) {
            this.gxI.GO(str);
        }
        bPO();
    }

    public void GQ(String str) {
        this.gxN = 2;
        this.gxO = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.gxO);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0630a interfaceC0630a) {
        this.gxM = interfaceC0630a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bEO.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bEO.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bEO.showToast(a.i.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                mb(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.gxN + " mPayway:" + this.gxO + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.gxN == 2 && !TextUtils.isEmpty(this.gxO)) {
                GP(this.gxO);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.gxM != null) {
                this.gxM.GM(str2);
                return;
            } else {
                bPO();
                return;
            }
        }
        if (this.showToast) {
            this.bEO.showToast(str);
        }
        this.mPayStatus = 3;
        mb(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.gxL = i2;
        this.gxQ = i;
        this.gxS = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bEO.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mc(false);
        } else if (this.gxL == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                mc(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.gxL == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            mc(true);
        } else if (this.gxL == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mc(false);
        } else if (this.gxL == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mc(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            mc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPM() {
        if (this.gxI != null) {
            this.bEO.showLoadingDialog(this.bEO.getString(a.i.sdk_pay_loading));
            this.gxI.bPM();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void bPO() {
        if (this.gxJ != null && this.gxI != null && this.gxI.bPK() != null && !this.gxI.bPK().isEmpty()) {
            if (this.gxK == null) {
                bOT();
            }
            this.gxJ.pay(this.gxI.bPK(), this.gxK);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent bPP() {
        Intent intent = new Intent();
        if (this.gxI != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.gxL);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.gxI.bPN());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bPQ() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        Intent bPP = bPP();
        this.bEO.setResult(-1, bPP);
        if (this.gxM != null) {
            this.gxM.a(z, bPP);
        }
    }

    private void mc(boolean z) {
        this.bEO.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        mb(z);
    }
}
