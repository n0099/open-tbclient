package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class MessageCenterHelperStatic {
    static {
        if (TbadkCoreApplication.m255getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(new c(2008004));
            MessageManager.getInstance().registerListener(new d(2008005));
            MessageManager.getInstance().registerListener(new e(2008018));
        }
    }
}
