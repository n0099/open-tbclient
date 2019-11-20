package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_mission_system_entrance_switch";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_mission_entrance", 0);
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
        return com.baidu.adp.lib.b.d.ft().af("android_mission_system_entrance_switch") == 1;
    }
}
