package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class VideoPlayerReuseSwitch extends a {
    public static final String VIDEO_PLAY_REUSE_KEY = "android_video_player_reuseable";

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return VIDEO_PLAY_REUSE_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return b.aFB().getInt("key_video_player_reuse_switch", 0);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
