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
    private static Runnable aEC = new e();
    private static boolean aHK = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FM() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fS().removeCallbacks(aEC);
            h.fS().postDelayed(aEC, 120000L);
            if (!aHK) {
                aHK = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FN() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aHK = false;
            h.fS().removeCallbacks(aEC);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fS().post(aEC);
            MessageManager.getInstance().registerListener(new f(2000993));
            MessageManager.getInstance().registerListener(new g(2000988));
        }
    }
}
