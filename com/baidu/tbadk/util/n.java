package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class n {
    public static void bgx() {
        if (!com.baidu.adp.lib.util.l.isMainThread()) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tbadk.util.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.bgy();
                }
            });
        } else {
            bgy();
        }
    }

    public static void bgy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
