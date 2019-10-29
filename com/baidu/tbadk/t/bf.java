package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_share_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }

    public static boolean isOn() {
        return com.baidu.adp.lib.b.d.ft().af("android_share_switch") == 1;
    }
}
