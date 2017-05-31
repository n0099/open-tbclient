package com.baidu.tbadk.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private static long QY = 86400000;

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                m(listFiles[i]);
                            } else {
                                listFiles[i].delete();
                            }
                        }
                        return;
                    }
                    return;
                }
                file.delete();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void init() {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }
}
