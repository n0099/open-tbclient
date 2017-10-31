package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static Runnable aHO = new Runnable() { // from class: com.baidu.tbadk.plugin.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.Gr();
        }
    };
    private static boolean aKW = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gq() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.fP().removeCallbacks(aHO);
            e.fP().postDelayed(aHO, 120000L);
            if (!aKW) {
                aKW = true;
                String string = TbadkCoreApplication.getInst().getResources().getString(d.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gr() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            aKW = false;
            e.fP().removeCallbacks(aHO);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.fP().post(aHO);
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000993) { // from class: com.baidu.tbadk.plugin.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.Gq();
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000988) { // from class: com.baidu.tbadk.plugin.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.Gr();
                }
            });
        }
    }
}
