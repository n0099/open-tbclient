package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_mission_system_entrance_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hz() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_mission_entrance", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hA() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hB() {
        return 10;
    }

    public static boolean iE() {
        return com.baidu.adp.lib.b.d.hI().ay("android_mission_system_entrance_switch") == 1;
    }
}
