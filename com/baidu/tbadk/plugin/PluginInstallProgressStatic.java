package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static boolean aBb;
    private static Runnable ayb = new d();

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hj().post(ayb);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aBb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EP() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hj().removeCallbacks(ayb);
            h.hj().postDelayed(ayb, 120000L);
            if (!aBb) {
                aBb = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(n.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EQ() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            aBb = false;
            h.hj().removeCallbacks(ayb);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
