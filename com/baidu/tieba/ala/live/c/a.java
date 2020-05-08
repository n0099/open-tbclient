package com.baidu.tieba.ala.live.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.PayChannelManager;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannel;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.b.a;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a {
    private BaseActivity bci;
    private com.baidu.tieba.ala.live.b.a fpA;
    private IPayChannel fpB;
    private IPayCallback fpC;
    private int fpD;
    private InterfaceC0504a fpE;
    private PayConfig mCurPayConfig;
    private PayChannelType mPayChannelType;
    private final int SEND_GETINFO_MSG = 1;
    private int mPayStatus = 1;
    private boolean hasResendGetMsg = false;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.live.c.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    a.this.bpM();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0503a fpF = new a.InterfaceC0503a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0503a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0503a
        public void a(PayChannelType payChannelType, int i, String str, int i2) {
            a.this.f(i, str, i2);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0504a {
        void Ar(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0503a interfaceC0503a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bci = baseActivity;
        this.mPayChannelType = payChannelType;
        this.fpA = a(payChannelType, this.fpF);
        this.fpB = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fpA != null) {
            this.bci.showLoadingDialog(this.bci.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fpA.a(payConfig);
        }
    }

    private void bpB() {
        this.fpC = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bpM();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.jK(false);
                        break;
                    default:
                        a.this.bci.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.jK(false);
                        break;
                }
                a.this.fpB.release();
                a.this.fpC = null;
            }
        };
    }

    public void At(String str) {
        if (this.fpA != null) {
            this.fpA.As(str);
        }
        bpO();
    }

    public void a(InterfaceC0504a interfaceC0504a) {
        this.fpE = interfaceC0504a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bci.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bci.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.bci.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                jK(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fpE != null) {
                this.fpE.Ar(str2);
                return;
            } else {
                bpO();
                return;
            }
        }
        this.bci.showToast(str);
        this.mPayStatus = 3;
        jK(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.bci.showToast(str);
            jL(false);
            return;
        }
        this.fpD = i2;
        if (this.fpD == 2) {
            if (this.hasResendGetMsg) {
                jL(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fpD == 0) {
            jL(true);
        } else if (this.fpD == 1) {
            jL(false);
        } else if (this.fpD == 3) {
            jL(false);
        } else {
            jL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpM() {
        if (this.fpA != null) {
            this.bci.showLoadingDialog(this.bci.getString(a.i.sdk_pay_loading));
            this.fpA.bpM();
        }
    }

    private void bpO() {
        if (this.fpB != null && this.fpA != null && this.fpA.bpK() != null && !this.fpA.bpK().isEmpty()) {
            if (this.fpC == null) {
                bpB();
            }
            this.fpB.pay(this.fpA.bpK(), this.fpC);
        }
    }

    public Intent bpP() {
        Intent intent = new Intent();
        if (this.fpA != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fpD);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fpA.bpN());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bpQ() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(boolean z) {
        Intent bpP = bpP();
        this.bci.setResult(-1, bpP);
        if (this.fpE != null) {
            this.fpE.a(z, bpP);
        }
    }

    private void jL(boolean z) {
        this.bci.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        jK(z);
    }
}
