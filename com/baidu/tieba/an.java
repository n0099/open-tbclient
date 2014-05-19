package com.baidu.tieba;
/* loaded from: classes.dex */
class an implements Runnable {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.tbplugin.m.a().a("BdSocialShareSdk", "com.baidu.tbadk.plugins.BdSocialShareSdkDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("batsdk", "com.baidu.tbadk.plugins.BatSdkDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("motusdk", "com.baidu.tbadk.plugins.MotuPlugin");
        com.baidu.tbadk.tbplugin.m.a().a("browser", "com.baidu.tbadk.plugins.BdBrowserDelegate");
        com.baidu.tbadk.tbplugin.m.a().a("dqsdk", "com.baidu.tbadk.plugins.DQSdkPlugin");
        com.baidu.tbadk.tbplugin.m.a().j();
    }
}
