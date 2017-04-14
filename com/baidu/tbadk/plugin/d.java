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
public class d {
    private static Runnable aEI = new e();
    private static boolean aHR = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GO() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fR().removeCallbacks(aEI);
            h.fR().postDelayed(aEI, 120000L);
            if (!aHR) {
                aHR = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GP() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aHR = false;
            h.fR().removeCallbacks(aEI);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fR().post(aEI);
            MessageManager.getInstance().registerListener(new f(2000993));
            MessageManager.getInstance().registerListener(new g(2000988));
        }
    }
}
