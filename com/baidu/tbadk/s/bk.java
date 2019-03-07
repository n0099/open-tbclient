package com.baidu.tbadk.s;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_video_player_reuseable";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_player_reuse_switch", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }
}
