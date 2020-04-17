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
    private BaseActivity bcd;
    private com.baidu.tieba.ala.live.b.a fpv;
    private IPayChannel fpw;
    private IPayCallback fpx;
    private int fpy;
    private InterfaceC0483a fpz;
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
                    a.this.bpO();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0482a fpA = new a.InterfaceC0482a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0482a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0482a
        public void a(PayChannelType payChannelType, int i, String str, int i2) {
            a.this.f(i, str, i2);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0483a {
        void Ao(String str);

        void a(boolean z, Intent intent);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0482a interfaceC0482a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.bcd = baseActivity;
        this.mPayChannelType = payChannelType;
        this.fpv = a(payChannelType, this.fpA);
        this.fpw = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.fpv != null) {
            this.bcd.showLoadingDialog(this.bcd.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.fpv.a(payConfig);
        }
    }

    private void bpD() {
        this.fpx = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bpO();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.jK(false);
                        break;
                    default:
                        a.this.bcd.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.jK(false);
                        break;
                }
                a.this.fpw.release();
                a.this.fpx = null;
            }
        };
    }

    public void Aq(String str) {
        if (this.fpv != null) {
            this.fpv.Ap(str);
        }
        bpQ();
    }

    public void a(InterfaceC0483a interfaceC0483a) {
        this.fpz = interfaceC0483a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.bcd.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.bcd.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.bcd.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                jK(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.fpz != null) {
                this.fpz.Ao(str2);
                return;
            } else {
                bpQ();
                return;
            }
        }
        this.bcd.showToast(str);
        this.mPayStatus = 3;
        jK(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.bcd.showToast(str);
            jL(false);
            return;
        }
        this.fpy = i2;
        if (this.fpy == 2) {
            if (this.hasResendGetMsg) {
                jL(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.fpy == 0) {
            jL(true);
        } else if (this.fpy == 1) {
            jL(false);
        } else if (this.fpy == 3) {
            jL(false);
        } else {
            jL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpO() {
        if (this.fpv != null) {
            this.bcd.showLoadingDialog(this.bcd.getString(a.i.sdk_pay_loading));
            this.fpv.bpO();
        }
    }

    private void bpQ() {
        if (this.fpw != null && this.fpv != null && this.fpv.bpM() != null && !this.fpv.bpM().isEmpty()) {
            if (this.fpx == null) {
                bpD();
            }
            this.fpw.pay(this.fpv.bpM(), this.fpx);
        }
    }

    public Intent bpR() {
        Intent intent = new Intent();
        if (this.fpv != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.fpy);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.fpv.bpP());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bpS() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(boolean z) {
        Intent bpR = bpR();
        this.bcd.setResult(-1, bpR);
        if (this.fpz != null) {
            this.fpz.a(z, bpR);
        }
    }

    private void jL(boolean z) {
        this.bcd.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        jK(z);
    }
}
