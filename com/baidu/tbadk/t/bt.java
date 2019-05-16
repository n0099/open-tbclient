package com.baidu.tbadk.t;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_video_player_reuseable";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hz() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_player_reuse_switch", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hA() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hB() {
        return 10;
    }
}
