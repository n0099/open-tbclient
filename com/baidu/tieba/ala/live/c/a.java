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
    private BaseActivity aGf;
    private com.baidu.tieba.ala.live.b.a eKG;
    private IPayChannel eKH;
    private IPayCallback eKI;
    private int eKJ;
    private InterfaceC0448a eKK;
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
                    a.this.bgs();
                    return;
                default:
                    return;
            }
        }
    };
    private a.InterfaceC0447a eKL = new a.InterfaceC0447a() { // from class: com.baidu.tieba.ala.live.c.a.2
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

        void yF(String str);
    }

    protected abstract com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0447a interfaceC0447a);

    public a(BaseActivity baseActivity, PayChannelType payChannelType) {
        this.aGf = baseActivity;
        this.mPayChannelType = payChannelType;
        this.eKG = a(payChannelType, this.eKL);
        this.eKH = buildPayChannel(payChannelType);
    }

    public void d(PayConfig payConfig) {
        if (this.eKG != null) {
            this.aGf.showLoadingDialog(this.aGf.getString(a.i.sdk_pay_loading));
            this.mCurPayConfig = payConfig;
            this.eKG.a(payConfig);
        }
    }

    private void bgh() {
        this.eKI = new IPayCallback() { // from class: com.baidu.tieba.ala.live.c.a.3
            @Override // com.baidu.live.tbadk.pay.channel.interfaces.IPayCallback
            public void onPayResult(int i, String str) {
                switch (i) {
                    case 0:
                        a.this.bgs();
                        break;
                    case 1:
                        break;
                    case 2:
                        a.this.mPayStatus = 1;
                        a.this.iH(false);
                        break;
                    default:
                        a.this.aGf.showToast(a.i.sdk_pay_fail);
                        a.this.mPayStatus = 5;
                        a.this.iH(false);
                        break;
                }
                a.this.eKH.release();
                a.this.eKI = null;
            }
        };
    }

    public void yH(String str) {
        if (this.eKG != null) {
            this.eKG.yG(str);
        }
        bgu();
    }

    public void a(InterfaceC0448a interfaceC0448a) {
        this.eKK = interfaceC0448a;
    }

    protected IPayChannel buildPayChannel(PayChannelType payChannelType) {
        return PayChannelManager.getInstance().buildPayChannel(payChannelType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TbPageContext getPageContext() {
        return this.aGf.getPageContext();
    }

    protected void a(int i, String str, HashMap<String, String> hashMap, String str2, boolean z) {
        this.aGf.closeLoadingDialog();
        if (i == 0) {
            if (hashMap == null || hashMap.isEmpty()) {
                this.aGf.showToast(a.i.sdk_pay_fail);
                this.mPayStatus = 3;
                iH(false);
                return;
            } else if (!TextUtils.isEmpty(str2) && !z && this.eKK != null) {
                this.eKK.yF(str2);
                return;
            } else {
                bgu();
                return;
            }
        }
        this.aGf.showToast(str);
        this.mPayStatus = 3;
        iH(false);
    }

    protected void f(int i, String str, int i2) {
        if (i != 0) {
            this.aGf.showToast(str);
            iI(false);
            return;
        }
        this.eKJ = i2;
        if (this.eKJ == 2) {
            if (this.hasResendGetMsg) {
                iI(true);
                return;
            }
            this.hasResendGetMsg = true;
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 5000L);
        } else if (this.eKJ == 0) {
            iI(true);
        } else if (this.eKJ == 1) {
            iI(false);
        } else if (this.eKJ == 3) {
            iI(false);
        } else {
            iI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgs() {
        if (this.eKG != null) {
            this.aGf.showLoadingDialog(this.aGf.getString(a.i.sdk_pay_loading));
            this.eKG.bgs();
        }
    }

    private void bgu() {
        if (this.eKH != null && this.eKG != null && this.eKG.bgq() != null && !this.eKG.bgq().isEmpty()) {
            if (this.eKI == null) {
                bgh();
            }
            this.eKH.pay(this.eKG.bgq(), this.eKI);
        }
    }

    public Intent bgv() {
        Intent intent = new Intent();
        if (this.eKG != null && this.mCurPayConfig != null) {
            intent.putExtra("result_code", this.mPayStatus);
            intent.putExtra("result_payinfo_status", this.eKJ);
            intent.putExtra("result_tbean_num", this.mCurPayConfig.getTBeanNum());
            intent.putExtra("result_order_id", this.eKG.bgt());
            intent.putExtra("pay_channel_type_name", this.mPayChannelType.name());
        }
        return intent;
    }

    public int bgw() {
        return this.mPayStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH(boolean z) {
        Intent bgv = bgv();
        this.aGf.setResult(-1, bgv);
        if (this.eKK != null) {
            this.eKK.a(z, bgv);
        }
    }

    private void iI(boolean z) {
        this.aGf.closeLoadingDialog();
        this.mPayStatus = z ? 0 : 4;
        iH(z);
    }
}
