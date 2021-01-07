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
/* loaded from: classes11.dex */
public abstract class a {
    private BaseActivity bWu;
    private com.baidu.tieba.ala.live.b.a hjT;
    private IPayChannel hjU;
    private IPayCallback hjV;
    private int hjW;
    private InterfaceC0663a hjX;
    protected String hjZ;
    private int hka;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    protected int hjY = 0;
    protected boolean showToast = true;
    private boolean hasResendGetMsg = false;
    private int hkb = 0;
    private long hkc = 0;
    private long hkd = 0;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.caR();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0661a hke = new a.InterfaceC0661a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0661a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0661a
        public void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
            a.this.b(i, str, i2, httpResponsedMessage);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0663a {
        void HL(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0661a interfaceC0661a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bWu = baseActivity;
        this.mPayChannelType = payChannelType;
        this.hjT = a(payChannelType, this.hke);
        this.hjU = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.hjT != null) {
            this.bWu.showLoadingDialog(this.bWu.getString(a.h.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.hjT.a(payConfig);
        }
    }

    private void bZH() {
        this.hjV = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                a.this.hka = i;
                a.this.hkc = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK_SUCC, null);
                        a.this.caR();
                        break;
                    case 1:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        break;
                    case 2:
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 1;
                        a.this.nx(false);
                        break;
                    default:
                        if (a.this.showToast) {
                            a.this.bWu.showToast(a.h.sdk_pay_fail);
                        }
                        a.this.a(i, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, null);
                        a.this.mPayStatus = 5;
                        a.this.nx(false);
                        break;
                }
                a.this.hjU.release();
                a.this.hjV = null;
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
                if (this.hjT != null && !StringUtils.isNull(this.hjT.caS())) {
                    jSONObject2.put("order_id", this.hjT.caS());
                }
                jSONObject.put("pay", jSONObject2);
            } catch (JSONException e) {
            }
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_RESP, str, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
        }
    }

    public void HO(String str) {
        if (this.hjT != null) {
            this.hjT.HN(str);
        }
        caT();
    }

    public void HP(String str) {
        this.hjY = 2;
        this.hjZ = str;
        Log.d(IChannelPayController.TAG, "setPayWay mPayWay:" + this.hjZ);
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void a(InterfaceC0663a interfaceC0663a) {
        this.hjX = interfaceC0663a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bWu.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bWu.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                if (this.showToast) {
                    this.bWu.showToast(a.h.sdk_pay_fail);
                }
                this.mPayStatus = 3;
                nx(false);
                return;
            }
            Log.d(IChannelPayController.TAG, "responseOrder mPayMode:" + this.hjY + " mPayway:" + this.hjZ + ", payChannel:" + str2);
            Log.d(IChannelPayController.TAG, "responseOrder this:" + this);
            if (this.hjY == 2 && !TextUtils.isEmpty(this.hjZ)) {
                HO(this.hjZ);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.hjX != null) {
                this.hjX.HL(str2);
                return;
            } else {
                caT();
                return;
            }
        }
        if (this.showToast) {
            this.bWu.showToast(str);
        }
        this.mPayStatus = 3;
        nx(false);
    }

    protected void b(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        this.hjW = i2;
        this.hkb = i;
        this.hkd = System.currentTimeMillis();
        if (i != 0) {
            if (this.showToast) {
                this.bWu.showToast(str);
            }
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ny(false);
        } else if (this.hjW == 2) {
            if (this.hasResendGetMsg) {
                a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
                ny(true);
                return;
            }
            this.hasResendGetMsg = true;
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.hjW == 0) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS_SUCC, httpResponsedMessage);
            ny(true);
        } else if (this.hjW == 1) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ny(false);
        } else if (this.hjW == 3) {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ny(false);
        } else {
            a(i2, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, httpResponsedMessage);
            ny(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caR() {
        if (this.hjT != null) {
            this.bWu.showLoadingDialog(this.bWu.getString(a.h.sdk_pay_loading));
            this.hjT.caR();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_STATUS, "liveroom", ""));
        }
    }

    private void caT() {
        if (this.hjU != null && this.hjT != null && this.hjT.caP() != null && !this.hjT.caP().isEmpty()) {
            if (this.hjV == null) {
                bZH();
            }
            this.hjU.pay(this.hjT.caP(), this.hjV);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_RECHARGE_REQ, UbcStatConstant.ContentType.UBC_TYPE_PAY_SDK, "liveroom", ""));
        }
    }

    public Intent caU() {
        Intent intent = new Intent();
        if (this.hjT != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.hjW);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.hjT.caS());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int caV() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx(boolean z) {
        Intent caU = caU();
        this.bWu.setResult(-1, caU);
        if (this.hjX != null) {
            this.hjX.a(z, caU);
        }
    }

    private void ny(boolean z) {
        this.bWu.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        nx(z);
    }
}
