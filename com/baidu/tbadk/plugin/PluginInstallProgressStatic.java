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
    private static boolean aCO;
    private static Runnable azz = new d();

    static {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hx().post(azz);
            MessageManager.getInstance().registerListener(new e(2000993));
            MessageManager.getInstance().registerListener(new f(2000988));
        }
        aCO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hc() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            h.hx().removeCallbacks(azz);
            h.hx().postDelayed(azz, 120000L);
            if (!aCO) {
                aCO = true;
                String string = TbadkCoreApplication.m411getInst().getResources().getString(t.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hd() {
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            aCO = false;
            h.hx().removeCallbacks(azz);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }
}
