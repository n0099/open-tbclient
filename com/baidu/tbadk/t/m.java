package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_bigday_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_bigday_sync_switch", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }
}
