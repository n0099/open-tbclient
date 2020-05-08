package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class n {
    public static void ban() {
        if (!com.baidu.adp.lib.util.l.isMainThread()) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tbadk.util.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.bao();
                }
            });
        } else {
            bao();
        }
    }

    public static void bao() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
