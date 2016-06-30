package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable aws = new d();
    private static boolean azH;

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.dM().post(aws);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        azH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fe() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.dM().removeCallbacks(aws);
            h.dM().postDelayed(aws, 120000L);
            if (!azH) {
                azH = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(u.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ff() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            azH = false;
            h.dM().removeCallbacks(aws);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
