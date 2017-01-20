package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class ImmersiveStickySwitchStatic extends a {
    static {
        e.dL().n(ImmersiveStickySwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_immersive_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
        if (i == 1) {
            b.tQ().putBoolean("switch_immersive_sticky_status", true);
        } else {
            b.tQ().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
