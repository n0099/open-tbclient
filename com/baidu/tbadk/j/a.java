package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.c;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static long dLg = 604800000;

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                K(listFiles[i]);
                            } else if (!listFiles[i].delete()) {
                            }
                        }
                        return;
                    }
                    return;
                }
                if (!file.delete()) {
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void init() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tbadk.j.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.j.a$1$1] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j = b.aZP().getLong("key_clear_resource", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j == 0) {
                    b.aZP().putLong("key_clear_resource", currentTimeMillis);
                    j = currentTimeMillis;
                }
                if (currentTimeMillis - j > a.dLg) {
                    new Thread() { // from class: com.baidu.tbadk.j.a.1.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            try {
                                c.aZW();
                                a.K(TbadkCoreApplication.getInst().getCacheDir());
                            } catch (Exception e) {
                            }
                        }
                    }.start();
                    b.aZP().putLong("key_clear_resource", currentTimeMillis);
                }
            }
        });
    }
}
