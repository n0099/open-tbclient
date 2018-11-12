package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static Runnable atM = new Runnable() { // from class: com.baidu.tbadk.plugin.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.Oo();
        }
    };
    private static boolean bdJ = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void On() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.jG().removeCallbacks(atM);
            e.jG().postDelayed(atM, 120000L);
            if (!bdJ) {
                bdJ = true;
                String string = TbadkCoreApplication.getInst().getResources().getString(e.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oo() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            bdJ = false;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(atM);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            com.baidu.adp.lib.g.e.jG().post(atM);
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000993) { // from class: com.baidu.tbadk.plugin.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.On();
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000988) { // from class: com.baidu.tbadk.plugin.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.Oo();
                }
            });
        }
    }
}
