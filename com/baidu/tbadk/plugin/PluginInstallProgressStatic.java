package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable aAo = new d();
    private static boolean aDE;

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().post(aAo);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aDE = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gx() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eG().removeCallbacks(aAo);
            h.eG().postDelayed(aAo, 120000L);
            if (!aDE) {
                aDE = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(t.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gy() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aDE = false;
            h.eG().removeCallbacks(aAo);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
