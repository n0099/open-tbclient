package com.baidu.tbadk.pluginArch;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements w {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.pluginArch.w
    public void a(ConfigInfos configInfos) {
        if (configInfos != null && TbadkApplication.m252getInst().isMainProcess(false)) {
            ac.a().a(configInfos);
            this.a.e();
        }
    }
}
