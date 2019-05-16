package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class m {
    public static void auZ() {
        if (!com.baidu.adp.lib.util.l.kh()) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tbadk.util.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.ava();
                }
            });
        } else {
            ava();
        }
    }

    public static void ava() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
