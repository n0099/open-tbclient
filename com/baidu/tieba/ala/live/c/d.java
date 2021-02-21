package com.baidu.tieba.ala.live.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.WalletPayCallback;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.tieba.ala.live.b.a;
/* loaded from: classes11.dex */
public class d extends a {
    private boolean mIsPaying;

    public d(BaseActivity baseActivity) {
        super(baseActivity, PayChannelType.WALLET);
        this.mIsPaying = false;
    }

    @Override // com.baidu.tieba.ala.live.c.a
    protected com.baidu.tieba.ala.live.b.a a(PayChannelType payChannelType, a.InterfaceC0645a interfaceC0645a) {
        return new com.baidu.tieba.ala.live.b.c(getPageContext(), interfaceC0645a);
    }

    @Override // com.baidu.tieba.ala.live.c.a
    public void d(final PayConfig payConfig) {
        if (!this.mIsPaying) {
            if (TextUtils.isEmpty(ExtraParamsManager.getWalletSdkUa())) {
                if (PayManager.getInstance().getWalletSwan() != null) {
                    this.mIsPaying = true;
                    PayManager.getInstance().getWalletSwan().getWalletUA(new WalletPayCallback() { // from class: com.baidu.tieba.ala.live.c.d.1
                        @Override // com.baidu.live.tbadk.pay.WalletPayCallback
                        public void onResult(int i, String str) {
                            d.this.mIsPaying = false;
                            if (i == -1 && "wallet_plugin_not_installed".equals(str)) {
                                d.this.getPageContext().getPageActivity().finish();
                                return;
                            }
                            ExtraParamsManager.setWalletSdkUa(str);
                            d.super.d(payConfig);
                        }
                    });
                    return;
                }
                super.d(payConfig);
                return;
            }
            super.d(payConfig);
        }
    }
}
