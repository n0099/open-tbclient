package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.f;
/* loaded from: classes.dex */
public class VoiceLoginSwitchStatic extends a {
    public static final String[] arE;

    static {
        f.gD().l(VoiceLoginSwitchStatic.class);
        arE = new String[]{"com.baidu.speech.speakerrecognition,com.baidu.sapi2"};
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_voice_secret";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return arE;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }
}
