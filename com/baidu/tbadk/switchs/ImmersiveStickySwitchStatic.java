package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class ImmersiveStickySwitchStatic extends a {
    static {
        e.cT().n(ImmersiveStickySwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_immersive_switch";
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
        if (i == 1) {
            b.sO().putBoolean("switch_immersive_sticky_status", true);
        } else {
            b.sO().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
