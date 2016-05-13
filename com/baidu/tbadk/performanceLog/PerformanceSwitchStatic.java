package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class PerformanceSwitchStatic extends com.baidu.adp.lib.c.a {
    static {
        com.baidu.adp.lib.c.e.cS().f(PerformanceSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
        aa.EN().bQ(1 == i);
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "log_stat_smallflow";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
