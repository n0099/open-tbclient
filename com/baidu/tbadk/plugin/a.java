package com.baidu.tbadk.plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static Runnable aPw = new Runnable() { // from class: com.baidu.tbadk.plugin.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.aRt();
        }
    };
    private static boolean dEY = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aRs() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.gx().removeCallbacks(aPw);
            e.gx().postDelayed(aPw, 120000L);
            if (!dEY) {
                dEY = true;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.plugin_tip_installing);
                NotificationHelper.showNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000, null, string, string, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aRt() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            dEY = false;
            e.gx().removeCallbacks(aPw);
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApplicationContext(), 1000);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_COLLECT_GROUPS, new ArrayList()));
        }
    }

    public static void init() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            e.gx().post(aPw);
            MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.PLUGIN_INSTALL_START) { // from class: com.baidu.tbadk.plugin.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.aRs();
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.PLUGIN_ALL_INSTALL) { // from class: com.baidu.tbadk.plugin.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    a.aRt();
                }
            });
        }
    }
}
