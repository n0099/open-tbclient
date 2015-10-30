package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable avF = new d();
    private static boolean ayE;

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hg().post(avF);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        ayE = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hg().removeCallbacks(avF);
            h.hg().postDelayed(avF, 120000L);
            if (!ayE) {
                ayE = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            ayE = false;
            h.hg().removeCallbacks(avF);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
        }
    }
}
