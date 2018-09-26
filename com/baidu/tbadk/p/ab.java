package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_immersive_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ir() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int is() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int it() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iu() {
        return 10;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("switch_immersive_sticky_status", true);
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
