package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class j {
    public static void ME() {
        if (!com.baidu.adp.lib.util.l.la()) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tbadk.util.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.MF();
                }
            });
        } else {
            MF();
        }
    }

    public static void MF() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
