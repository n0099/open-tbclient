package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class l {
    public static void axy() {
        if (!com.baidu.adp.lib.util.l.isMainThread()) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.axz();
                }
            });
        } else {
            axz();
        }
    }

    public static void axz() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
