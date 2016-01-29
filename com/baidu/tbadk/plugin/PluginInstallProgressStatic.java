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
    private static boolean aBQ;
    private static Runnable ayS = new d();

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hr().post(ayS);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aBQ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gg() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hr().removeCallbacks(ayS);
            h.hr().postDelayed(ayS, 120000L);
            if (!aBQ) {
                aBQ = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(t.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            aBQ = false;
            h.hr().removeCallbacks(ayS);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
