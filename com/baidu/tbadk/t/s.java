package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.b.a {
    private static int cAC = 1;

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return new String[0];
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

    public static void kO(int i) {
        cAC = i;
    }

    public static int auG() {
        return cAC;
    }
}
