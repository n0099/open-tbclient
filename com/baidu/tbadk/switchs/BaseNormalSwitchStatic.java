package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public abstract class BaseNormalSwitchStatic extends a {
    @Override // com.baidu.adp.lib.c.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.c.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public boolean eX() {
        return e.dN().ac(getName()) == getDefaultType();
    }
}
