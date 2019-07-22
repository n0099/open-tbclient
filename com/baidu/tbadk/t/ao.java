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
    protected String[] hI() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hJ() {
        return com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_mission_entrance", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hK() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hL() {
        return 10;
    }

    public static boolean iN() {
        return com.baidu.adp.lib.b.d.hS().az("android_mission_system_entrance_switch") == 1;
    }
}
