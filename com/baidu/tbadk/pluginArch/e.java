package com.baidu.tbadk.pluginArch;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements v {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.pluginArch.v
    public void a(ConfigInfos configInfos) {
        h hVar;
        if (configInfos != null && TbadkApplication.m252getInst().isMainProcess(false)) {
            ab.a().a(configInfos);
            hVar = this.a.f;
            hVar.b();
        }
    }
}
