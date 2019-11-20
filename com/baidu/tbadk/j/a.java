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
    private static long bUK = 604800000;

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                o(listFiles[i]);
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
                long j = b.alP().getLong("key_clear_resource", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j == 0) {
                    b.alP().putLong("key_clear_resource", currentTimeMillis);
                    j = currentTimeMillis;
                }
                if (currentTimeMillis - j > a.bUK) {
                    new Thread() { // from class: com.baidu.tbadk.j.a.1.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            try {
                                c.alT();
                                a.o(TbadkCoreApplication.getInst().getCacheDir());
                            } catch (Exception e) {
                            }
                        }
                    }.start();
                    b.alP().putLong("key_clear_resource", currentTimeMillis);
                }
            }
        });
    }
}
