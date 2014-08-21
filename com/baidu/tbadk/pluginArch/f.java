package com.baidu.tbadk.pluginArch;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements j {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void a(DownloadData downloadData) {
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void a(DownloadData downloadData, int i, String str) {
        if ("lightapp.tbplugin".equals(downloadData.getName())) {
            TbadkApplication.m252getInst().getSharedPreferences("zeus", 2).edit().putString("T5SoPath", String.valueOf(n.c("lightapp").getAbsolutePath()) + File.separator).commit();
        }
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void b(DownloadData downloadData) {
    }

    @Override // com.baidu.tbadk.pluginArch.j
    public void c(DownloadData downloadData) {
    }
}
