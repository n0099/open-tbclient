package com.baidu.tbadk.pay;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private static e awB = null;

    private e() {
    }

    public static synchronized e Ep() {
        e eVar;
        synchronized (e.class) {
            if (awB == null) {
                awB = new e();
            }
            eVar = awB;
        }
        return eVar;
    }

    public boolean Eq() {
        return TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_MY_WALLET) && TbadkCoreApplication.m11getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && Er();
    }

    public boolean Er() {
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
            bg.us().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(t.j.plugin_pay_error);
        } else if (!Eq()) {
            showToast(t.j.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        k.showToast(TbadkCoreApplication.m11getInst().getContext(), i);
    }
}
