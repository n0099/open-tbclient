package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable aEs = new d();
    private static boolean aHC;

    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fM().post(aEs);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aHC = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gq() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fM().removeCallbacks(aEs);
            h.fM().postDelayed(aEs, 120000L);
            if (!aHC) {
                aHC = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gr() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aHC = false;
            h.fM().removeCallbacks(aEs);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
