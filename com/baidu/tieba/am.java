package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.tbplugin.h {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ad adVar) {
        this.a = adVar;
    }

    @Override // com.baidu.tbadk.tbplugin.h
    public void a() {
        if (TbadkApplication.m252getInst().isMainProcess()) {
            this.a.b.post(new an(this));
            return;
        }
        com.baidu.tbadk.tbplugin.m.a().a("BdSocialShareSdk", "com.baidu.tbadk.plugins.BdSocialShareSdkDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("batsdk", "com.baidu.tbadk.plugins.BatSdkDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("motusdk", "com.baidu.tbadk.plugins.MotuPlugin");
        com.baidu.tbadk.tbplugin.m.a().a("browser", "com.baidu.tbadk.plugins.BdBrowserDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("dqsdk", "com.baidu.tbadk.plugins.DQSdkPlugin");
        com.baidu.tbadk.tbplugin.m.a().j();
    }
}
