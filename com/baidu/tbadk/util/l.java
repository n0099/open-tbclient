package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
/* loaded from: classes.dex */
public class l {
    public static void aww() {
        if (!com.baidu.adp.lib.util.l.ks()) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tbadk.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.awx();
                }
            });
        } else {
            awx();
        }
    }

    public static void awx() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InitUserNameDialogActivityConfig(TbadkCoreApplication.getInst().getContext())));
    }
}
