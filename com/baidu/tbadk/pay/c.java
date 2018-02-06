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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static c bzK = null;

    private c() {
    }

    public static synchronized c NX() {
        c cVar;
        synchronized (c.class) {
            if (bzK == null) {
                bzK = new c();
            }
            cVar = bzK;
        }
        return cVar;
    }

    public boolean NY() {
        return TbadkCoreApplication.getInst().appResponseToCmd(2001351) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && NZ();
    }

    public boolean NZ() {
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
            aw.Du().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(d.j.plugin_pay_error);
        } else if (!NY()) {
            showToast(d.j.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        l.showToast(TbadkCoreApplication.getInst().getContext(), i);
    }
}
