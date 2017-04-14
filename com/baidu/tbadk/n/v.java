package com.baidu.tbadk.n;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_immersive_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eP() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eQ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void X(int i) {
        if (i == 1) {
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("switch_immersive_sticky_status", true);
        } else {
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("switch_immersive_sticky_status", false);
        }
    }
}
