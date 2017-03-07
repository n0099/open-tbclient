package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class UninstallFeedBackSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.e.eT().m(UninstallFeedBackSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
        this.mDefaultType = 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "uninstall_feed_back_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
