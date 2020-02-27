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
    private BaseActivity aGd;
    private com.baidu.tieba.ala.live.b.a eKs;
    private IPayChannel eKt;
    private IPayCallback eKu;
    private int eKv;
    private InterfaceC0448a eKw;
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
                    a.this.bgp();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0447a eKx = new a.InterfaceC0447a() { // from class: com.baidu.tieba.ala.live.c.a.2
        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0447a
        public void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
            a.this.a(i, str, hashMap, str2, z);
        }

        @Override // com.baidu.tieba.ala.live.b.a.InterfaceC0447a
        public void a(PayChannelType payChannelType, int i, String str, int i2) {
            a.this.f(i, str, i2);
        }
    };

    /* renamed from: com.baidu.tieba.ala.live.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0448a {
        void a(boolean z, Intent intent);

        void yE(String str);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0447a interfaceC0447a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.aGd = baseActivity;
        this.mPayChannelType = payChannelType;
        this.eKs = a(payChannelType, this.eKx);
        this.eKt = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.eKs != null) {
            this.aGd.showLoadingDialog(this.aGd.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.eKs.a(payConfig);
        }
    }

    private void bge() {
        this.eKu = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bgp();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.iH(false);
                        break;
                    default:
                        a.this.aGd.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.iH(false);
                        break;
                }
                a.this.eKt.release();
                a.this.eKu = null;
            }
        };
    }

    public void yG(String str) {
        if (this.eKs != null) {
            this.eKs.yF(str);
        }
        bgr();
    }

    public void a(InterfaceC0448a interfaceC0448a) {
        this.eKw = interfaceC0448a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.aGd.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.aGd.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.aGd.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                iH(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.eKw != null) {
                this.eKw.yE(str2);
                return;
            } else {
                bgr();
                return;
            }
        }
        this.aGd.showToast(str);
        this.mPayStatus = 3;
        iH(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.aGd.showToast(str);
            iI(false);
            return;
        }
        this.eKv = i2;
        if (this.eKv == 2) {
            if (this.hasResendGetMsg) {
                iI(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.eKv == 0) {
            iI(true);
        } else if (this.eKv == 1) {
            iI(false);
        } else if (this.eKv == 3) {
            iI(false);
        } else {
            iI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        if (this.eKs != null) {
            this.aGd.showLoadingDialog(this.aGd.getString(a.i.sdk_pay_loading));
            this.eKs.bgp();
        }
    }

    private void bgr() {
        if (this.eKt != null && this.eKs != null && this.eKs.bgn() != null && !this.eKs.bgn().isEmpty()) {
            if (this.eKu == null) {
                bge();
            }
            this.eKt.pay(this.eKs.bgn(), this.eKu);
        }
    }

    public Intent bgs() {
        Intent intent = new Intent();
        if (this.eKs != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.eKv);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.eKs.bgq());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bgt() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(boolean z) {
        Intent bgs = bgs();
        this.aGd.setResult(-1, bgs);
        if (this.eKw != null) {
            this.eKw.a(z, bgs);
        }
    }

    private void iI(boolean z) {
        this.aGd.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        iH(z);
    }
}
