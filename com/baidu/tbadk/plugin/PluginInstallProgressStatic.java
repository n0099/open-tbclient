package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable avE = new d();
    private static boolean ayt;

    static {
        h.hg().post(avE);
        MessageManager.getInstance().registerListener(new e(2000993));
        MessageManager.getInstance().registerListener(new f(2000988));
        ayt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ek() {
        h.hg().removeCallbacks(avE);
        h.hg().postDelayed(avE, 120000L);
        if (!ayt) {
            ayt = true;
            String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.plugin_tip_installing);
            NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void El() {
        ayt = false;
        h.hg().removeCallbacks(avE);
        NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
    }
}
