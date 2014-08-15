package com.baidu.tbadk.pluginArch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* loaded from: classes.dex */
class l implements b {
    final /* synthetic */ k a;
    private final /* synthetic */ DownloadData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, DownloadData downloadData) {
        this.a = kVar;
        this.b = downloadData;
    }

    @Override // com.baidu.tbadk.pluginArch.b
    public void a(int i, String str) {
        h hVar;
        i iVar;
        h hVar2;
        i iVar2;
        BdLog.i("startDownload_install_" + this.b.getId() + "_" + i + "_" + str);
        hVar = this.a.a;
        iVar = hVar.e;
        if (iVar != null) {
            hVar2 = this.a.a;
            iVar2 = hVar2.e;
            iVar2.a(i, str);
        }
        if (i == 0) {
            if ("lightapp.tbplugin".equals(this.b.getName())) {
                TbadkApplication.m252getInst().getSharedPreferences("zeus", 2).edit().putString("T5SoPath", String.valueOf(m.c("lightapp").getAbsolutePath()) + File.separator).commit();
            }
            ab.a().d();
        }
    }
}
