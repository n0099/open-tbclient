package com.baidu.tbadk.e;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.plugin.packageManager.pluginServerConfig.b {
    private static final String ahF = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS_NEW;
    private com.baidu.adp.plugin.packageManager.pluginServerConfig.a ahG;
    private boolean ahH;

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.b
    public void a(com.baidu.adp.plugin.packageManager.pluginServerConfig.c cVar, com.baidu.adp.plugin.packageManager.pluginServerConfig.a aVar) {
        if (!TbadkCoreApplication.m255getInst().isMainProcess(true)) {
            if (aVar != null) {
                aVar.a(false, null);
                return;
            }
            return;
        }
        this.ahG = aVar;
        if (!this.ahH) {
            this.ahH = true;
            new f(this, cVar).execute(new Void[0]);
        }
        try {
            TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
            File filesDir = m255getInst.getFilesDir();
            if (filesDir == null) {
                filesDir = new File("/data/data/" + m255getInst.getPackageName() + "/files/");
                try {
                    if (!filesDir.exists()) {
                        com.baidu.adp.lib.util.commonsio.a.j(filesDir);
                    }
                } catch (IOException e) {
                }
            }
            File file = new File(filesDir, "pluginsEX");
            if (file != null && file.exists()) {
                new e(this, file).execute(new Void[0]);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
