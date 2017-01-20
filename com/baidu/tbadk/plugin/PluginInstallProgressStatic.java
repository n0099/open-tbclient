package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static boolean aCk;
    private static Runnable ayZ = new d();

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eE().post(ayZ);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aCk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FW() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.eE().removeCallbacks(ayZ);
            h.eE().postDelayed(ayZ, 120000L);
            if (!aCk) {
                aCk = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(r.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FX() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aCk = false;
            h.eE().removeCallbacks(ayZ);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
