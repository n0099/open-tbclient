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
    protected String[] hI() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hJ() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_player_reuse_switch", 0);
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hK() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hL() {
        return 10;
    }
}
