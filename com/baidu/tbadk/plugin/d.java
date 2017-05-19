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
    private static Runnable aEP = new e();
    private static boolean aHX = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FS() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fS().removeCallbacks(aEP);
            h.fS().postDelayed(aEP, 120000L);
            if (!aHX) {
                aHX = true;
                String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FT() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            aHX = false;
            h.fS().removeCallbacks(aEP);
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.m9getInst().isMainProcess(true)) {
            h.fS().post(aEP);
            MessageManager.getInstance().registerListener(new f(2000993));
            MessageManager.getInstance().registerListener(new g(2000988));
        }
    }
}
