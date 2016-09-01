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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private static e aBo = null;

    private e() {
    }

    public static synchronized e FS() {
        e eVar;
        synchronized (e.class) {
            if (aBo == null) {
                aBo = new e();
            }
            eVar = aBo;
        }
        return eVar;
    }

    public boolean FT() {
        return TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_MY_WALLET) && TbadkCoreApplication.m9getInst().isWalletShouldOpen() && Build.VERSION.SDK_INT >= 8 && FU();
    }

    public boolean FU() {
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
            bi.vx().c(tbPageContext, new String[]{str});
        }
    }

    public void a(PayConfig payConfig, Context context) {
        if (payConfig == null || context == null) {
            showToast(t.j.plugin_pay_error);
        } else if (!FT()) {
            showToast(t.j.plugin_pay_wallet_not_found);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayWalletActivityConfig(context, payConfig)));
        }
    }

    private void showToast(int i) {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), i);
    }
}
