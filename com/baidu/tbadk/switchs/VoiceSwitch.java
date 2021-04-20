package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class VoiceSwitch extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;
    public static final String VOICE = "voice";
    public static final String[] VOICE_KEY = {"com.baidu.tieba.voice"};

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return VOICE_KEY;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return "voice";
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 1;
    }

    @Override // d.b.c.e.f.a
    public void initData() {
        this.mName = "voice";
        this.mKey = VOICE_KEY;
    }
}
