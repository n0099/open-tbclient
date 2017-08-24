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
    private static Runnable aIp = new Runnable() { // from class: com.baidu.tbadk.plugin.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.GI();
        }
    };
    private static boolean aLx = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GH() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.ga().removeCallbacks(aIp);
            e.ga().postDelayed(aIp, 120000L);
            if (!aLx) {
                aLx = true;
                String string = TbadkCoreApplication.getInst().getResources().getString(d.l.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GI() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            aLx = false;
            e.ga().removeCallbacks(aIp);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.ga().post(aIp);
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000993) { // from class: com.baidu.tbadk.plugin.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.GH();
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(2000988) { // from class: com.baidu.tbadk.plugin.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.GI();
                }
            });
        }
    }
}
