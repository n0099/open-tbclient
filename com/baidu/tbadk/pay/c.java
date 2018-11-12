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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c {
    private static c bbX = null;

    private c() {
    }

    public static synchronized c NT() {
        c cVar;
        synchronized (c.class) {
            if (bbX == null) {
                bbX = new c();
            }
            cVar = bbX;
        }
        return cVar;
    }

    public boolean NU() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001351) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && NV();
    }

    public boolean NV() {
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
            ay.Db().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(e.j.plugin_pay_error);
        } else if (!NU()) {
            showToast(e.j.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        l.showToast(TbadkCoreApplication.getInst().getContext(), i);
    }
}
