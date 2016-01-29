package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class LowVersionLoginPassV6SwitchStatic extends a {
    static {
        e.gE().e(LowVersionLoginPassV6SwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "switch_low_version_login_passv6";
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
