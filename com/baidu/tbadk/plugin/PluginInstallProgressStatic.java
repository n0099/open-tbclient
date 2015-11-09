package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable aut = new d();
    private static boolean axt;

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hh().post(aut);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        axt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hh().removeCallbacks(aut);
            h.hh().postDelayed(aut, 120000L);
            if (!axt) {
                axt = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            axt = false;
            h.hh().removeCallbacks(aut);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
