package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class VoiceSwitch extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;
    public static final String VOICE = "voice";
    public static final String[] VOICE_KEY = {"com.baidu.tieba.voice"};

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void initData() {
        this.mName = "voice";
        this.mKey = VOICE_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "voice";
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return VOICE_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
