package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.b.a {
    private static int cNo = 1;

    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_custom_player_enabled_2";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return new String[0];
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

    public static void ki(int i) {
        cNo = i;
    }

    public static int axg() {
        return cNo;
    }
}
