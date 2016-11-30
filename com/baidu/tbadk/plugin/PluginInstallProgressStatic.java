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
    private static Runnable aAJ = new d();
    private static boolean aDY;

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().post(aAJ);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aDY = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GC() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().removeCallbacks(aAJ);
            h.eG().postDelayed(aAJ, 120000L);
            if (!aDY) {
                aDY = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GD() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aDY = false;
            h.eG().removeCallbacks(aAJ);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
