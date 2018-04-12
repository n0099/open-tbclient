package com.baidu.tbadk.o;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_immersive_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("switch_immersive_sticky_status", true);
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
