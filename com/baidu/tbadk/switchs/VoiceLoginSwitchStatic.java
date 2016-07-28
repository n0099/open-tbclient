package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class VoiceLoginSwitchStatic extends a {
    public static final String[] aBd;

    static {
        e.cS().n(VoiceLoginSwitchStatic.class);
        aBd = new String[]{"com.baidu.speech.speakerrecognition,com.baidu.sapi2"};
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "android_voice_secret";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return aBd;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }
}
