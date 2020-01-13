package com.baidu.tieba.ala.live.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.tieba.ala.live.b.a;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class a {
    private BaseActivity aBW;
    private IPayCallback eGA;
    private int eGB;
    private InterfaceC0437a eGC;
    private com.baidu.tieba.ala.live.b.a eGy;
    private IPayChannel eGz;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private final int RESEND_INTERVAL = 5000;
    private int mPayStatus = 1;
    private boolean hasResendGetMsg = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bef();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0436a eGD = new a.InterfaceC0436a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0436a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0436a
        public void a(PayChannelType payChannelType, int i, String str, int i2) {
            a.this.f(i, str, i2);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0437a {
        void a(boolean z, Intent intent);

        void yi(String str);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0436a interfaceC0436a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.aBW = baseActivity;
        this.mPayChannelType = payChannelType;
        this.eGy = a(payChannelType, this.eGD);
        this.eGz = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.eGy != null) {
            this.aBW.showLoadingDialog(this.aBW.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.eGy.a(payConfig);
        }
    }

    private void bdU() {
        this.eGA = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bef();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.iA(false);
                        break;
                    default:
                        a.this.aBW.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.iA(false);
                        break;
                }
                a.this.eGz.release();
                a.this.eGA = null;
            }
        };
    }

    public void yk(String str) {
        if (this.eGy != null) {
            this.eGy.yj(str);
        }
        beh();
    }

    public void a(InterfaceC0437a interfaceC0437a) {
        this.eGC = interfaceC0437a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.aBW.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.aBW.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.aBW.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                iA(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.eGC != null) {
                this.eGC.yi(str2);
                return;
            } else {
                beh();
                return;
            }
        }
        this.aBW.showToast(str);
        this.mPayStatus = 3;
        iA(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.aBW.showToast(str);
            iB(false);
            return;
        }
        this.eGB = i2;
        if (this.eGB == 2) {
            if (this.hasResendGetMsg) {
                iB(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.eGB == 0) {
            iB(true);
        } else if (this.eGB == 1) {
            iB(false);
        } else if (this.eGB == 3) {
            iB(false);
        } else {
            iB(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bef() {
        if (this.eGy != null) {
            this.aBW.showLoadingDialog(this.aBW.getString(a.i.sdk_pay_loading));
            this.eGy.bef();
        }
    }

    private void beh() {
        if (this.eGz != null && this.eGy != null && this.eGy.bed() != null && !this.eGy.bed().isEmpty()) {
            if (this.eGA == null) {
                bdU();
            }
            this.eGz.pay(this.eGy.bed(), this.eGA);
        }
    }

    public Intent bei() {
        Intent intent = new Intent();
        if (this.eGy != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.eGB);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.eGy.beg());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bej() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(boolean z) {
        Intent bei = bei();
        this.aBW.setResult(-1, bei);
        if (this.eGC != null) {
            this.eGC.a(z, bei);
        }
    }

    private void iB(boolean z) {
        this.aBW.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        iA(z);
    }
}
