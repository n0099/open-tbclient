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
    private static Runnable aAg = new d();
    private static boolean aDs;

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().post(aAg);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aDs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gc() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().removeCallbacks(aAg);
            h.eG().postDelayed(aAg, 120000L);
            if (!aDs) {
                aDs = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gd() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aDs = false;
            h.eG().removeCallbacks(aAg);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
