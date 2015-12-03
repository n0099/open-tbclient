package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PluginInstallProgressStatic {
    private static Runnable awx = new d();
    private static boolean azy;

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hj().post(awx);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        azy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hj().removeCallbacks(awx);
            h.hj().postDelayed(awx, 120000L);
            if (!azy) {
                azy = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(n.i.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fc() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            azy = false;
            h.hj().removeCallbacks(awx);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
