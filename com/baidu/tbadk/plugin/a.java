package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static Runnable alC = new Runnable() { // from class: com.baidu.tbadk.plugin.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.KR();
        }
    };
    private static boolean aVh = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void KQ() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.in().removeCallbacks(alC);
            e.in().postDelayed(alC, 120000L);
            if (!aVh) {
                aVh = true;
                String string = TbadkCoreApplication.getInst().getResources().getString(f.j.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void KR() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            aVh = false;
            e.in().removeCallbacks(alC);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.in().post(alC);
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000993) { // from class: com.baidu.tbadk.plugin.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.KQ();
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000988) { // from class: com.baidu.tbadk.plugin.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.KR();
                }
            });
        }
    }
}
