package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class AudioRecorderSwitch extends a {
    public static final String KEY_AUDIO_RECORDER_SWITCH = "android_ueg_voice";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return KEY_AUDIO_RECORDER_SWITCH;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
