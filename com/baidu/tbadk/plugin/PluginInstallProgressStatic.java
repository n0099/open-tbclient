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
    private static boolean aAx;
    private static Runnable axh = new d();

    static {
        if (TbadkCoreApplication.m10getInst().isMainProcess(true)) {
            h.dL().post(axh);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aAx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fd() {
        if (TbadkCoreApplication.m10getInst().isMainProcess(true)) {
            h.dL().removeCallbacks(axh);
            h.dL().postDelayed(axh, 120000L);
            if (!aAx) {
                aAx = true;
                String string = TbadkCoreApplication.m10getInst().getResources().getString(u.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m10getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fe() {
        if (TbadkCoreApplication.m10getInst().isMainProcess(true)) {
            aAx = false;
            h.dL().removeCallbacks(axh);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m10getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
