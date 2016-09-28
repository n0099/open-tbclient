package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static boolean aDh;
    private static Runnable azR = new d();

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().post(azR);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aDh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gw() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().removeCallbacks(azR);
            h.eG().postDelayed(azR, 120000L);
            if (!aDh) {
                aDh = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gx() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aDh = false;
            h.eG().removeCallbacks(azR);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
