package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_immersive_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hz() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hA() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hB() {
        return 10;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("switch_immersive_sticky_status", true);
        } else {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
