package com.baidu.tbadk.pluginArch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
class m implements b {
    final /* synthetic */ l a;
    private final /* synthetic */ DownloadData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, DownloadData downloadData) {
        this.a = lVar;
        this.b = downloadData;
    }

    @Override // com.baidu.tbadk.pluginArch.b
    public void a(int i, String str) {
        i iVar;
        j jVar;
        i iVar2;
        j jVar2;
        BdLog.i("startDownload_install_" + this.b.getId() + "_" + i + "_" + str);
        iVar = this.a.a;
        jVar = iVar.e;
        if (jVar != null) {
            iVar2 = this.a.a;
            jVar2 = iVar2.e;
            jVar2.a(this.b, i, str);
        }
        if (i == 0) {
            ac.a().d();
        }
    }
}
