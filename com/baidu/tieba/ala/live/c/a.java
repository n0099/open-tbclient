package com.baidu.tieba.ala.live.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.live.q.a;
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
    private BaseActivity aBe;
    private com.baidu.tieba.ala.live.b.a eFo;
    private IPayChannel eFp;
    private IPayCallback eFq;
    private int eFr;
    private InterfaceC0434a eFs;
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
                    a.this.bdK();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0433a eFt = new a.InterfaceC0433a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0433a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0433a
        public void a(PayChannelType payChannelType, int i, String str, int i2) {
            a.this.f(i, str, i2);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0434a {
        void a(boolean z, Intent intent);

        void yd(String str);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0433a interfaceC0433a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.aBe = baseActivity;
        this.mPayChannelType = payChannelType;
        this.eFo = a(payChannelType, this.eFt);
        this.eFp = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.eFo != null) {
            this.aBe.showLoadingDialog(this.aBe.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.eFo.a(payConfig);
        }
    }

    private void bdz() {
        this.eFq = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bdK();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.iq(false);
                        break;
                    default:
                        a.this.aBe.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.iq(false);
                        break;
                }
                a.this.eFp.release();
                a.this.eFq = null;
            }
        };
    }

    public void yf(String str) {
        if (this.eFo != null) {
            this.eFo.ye(str);
        }
        bdM();
    }

    public void a(InterfaceC0434a interfaceC0434a) {
        this.eFs = interfaceC0434a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.aBe.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.aBe.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.aBe.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                iq(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.eFs != null) {
                this.eFs.yd(str2);
                return;
            } else {
                bdM();
                return;
            }
        }
        this.aBe.showToast(str);
        this.mPayStatus = 3;
        iq(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.aBe.showToast(str);
            ir(false);
            return;
        }
        this.eFr = i2;
        if (this.eFr == 2) {
            if (this.hasResendGetMsg) {
                ir(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.eFr == 0) {
            ir(true);
        } else if (this.eFr == 1) {
            ir(false);
        } else if (this.eFr == 3) {
            ir(false);
        } else {
            ir(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdK() {
        if (this.eFo != null) {
            this.aBe.showLoadingDialog(this.aBe.getString(a.i.sdk_pay_loading));
            this.eFo.bdK();
        }
    }

    private void bdM() {
        if (this.eFp != null && this.eFo != null && this.eFo.bdI() != null && !this.eFo.bdI().isEmpty()) {
            if (this.eFq == null) {
                bdz();
            }
            this.eFp.pay(this.eFo.bdI(), this.eFq);
        }
    }

    public Intent bdN() {
        Intent intent = new Intent();
        if (this.eFo != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.eFr);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.eFo.bdL());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bdO() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq(boolean z) {
        Intent bdN = bdN();
        this.aBe.setResult(-1, bdN);
        if (this.eFs != null) {
            this.eFs.a(z, bdN);
        }
    }

    private void ir(boolean z) {
        this.aBe.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        iq(z);
    }
}
