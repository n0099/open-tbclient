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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private static c aIP = null;

    private c() {
    }

    public static synchronized c FU() {
        c cVar;
        synchronized (c.class) {
            if (aIP == null) {
                aIP = new c();
            }
            cVar = aIP;
        }
        return cVar;
    }

    public boolean FV() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_MY_WALLET) && TbadkCoreApplication.getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && FW();
    }

    public boolean FW() {
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
            av.vI().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(d.j.plugin_pay_error);
        } else if (!FV()) {
            showToast(d.j.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        l.showToast(TbadkCoreApplication.getInst().getContext(), i);
    }
}
