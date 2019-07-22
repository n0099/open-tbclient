package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.b.a {
    private static int cBT = 1;

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hI() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hJ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hK() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hL() {
        return 10;
    }

    public static void kU(int i) {
        cBT = i;
    }

    public static int avP() {
        return cBT;
    }
}
