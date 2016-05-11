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
    private static Runnable avC = new d();
    private static boolean ayR;

    static {
        if (TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            h.dL().post(avC);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        ayR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EU() {
        if (TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            h.dL().removeCallbacks(avC);
            h.dL().postDelayed(avC, 120000L);
            if (!ayR) {
                ayR = true;
                String string = TbadkCoreApplication.m11getInst().getResources().getString(t.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m11getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EV() {
        if (TbadkCoreApplication.m11getInst().isMainProcess(true)) {
            ayR = false;
            h.dL().removeCallbacks(avC);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m11getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
