package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class i {
    public static void Ln() {
        if (!com.baidu.adp.lib.util.l.jU()) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tbadk.util.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.Lo();
                }
            });
        } else {
            Lo();
        }
    }

    public static void Lo() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
