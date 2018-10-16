package com.baidu.tbadk.p;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_bigday_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iH() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_bigday_sync_switch", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iK() {
        return 10;
    }
}
