package com.baidu.tbadk.pay;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static c aTv = null;

    private c() {
    }

    public static synchronized c Kx() {
        c cVar;
        synchronized (c.class) {
            if (aTv == null) {
                aTv = new c();
            }
            cVar = aTv;
        }
        return cVar;
    }

    public boolean Ky() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001351) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && Kz();
    }

    public boolean Kz() {
        try {
            Class.forName("com.baidu.wallet.api.BaiduWallet");
            return true;
        } catch (ClassNotFoundException e) {
            BdLog.e(e);
            return false;
        }
    }

    public void a(String str, TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            az.zV().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(d.k.plugin_pay_error);
        } else if (!Ky()) {
            showToast(d.k.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        l.showToast(TbadkCoreApplication.getInst().getContext(), i);
    }
}
