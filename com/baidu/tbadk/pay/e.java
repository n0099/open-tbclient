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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private static e awv = null;

    private e() {
    }

    public static synchronized e Dx() {
        e eVar;
        synchronized (e.class) {
            if (awv == null) {
                awv = new e();
            }
            eVar = awv;
        }
        return eVar;
    }

    public boolean Dy() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_MY_WALLET) && TbadkCoreApplication.m411getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && Dz();
    }

    public boolean Dz() {
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
            az.uT().b(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(i.h.plugin_pay_error);
        } else if (!Dy()) {
            showToast(i.h.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i);
    }
}
