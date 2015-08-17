package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    static {
        MessageManager.getInstance().registerListener(new d(2000993));
        MessageManager.getInstance().registerListener(new e(2000992));
        MessageManager.getInstance().registerListener(new f(2000991));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void En() {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.plugin_tip_installing);
        NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eo() {
        NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
    }
}
