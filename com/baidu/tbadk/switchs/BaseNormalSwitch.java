package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public abstract class BaseNormalSwitch extends a {
    private static final int TYPE_OFF = 0;
    private static final int TYPE_ON = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected abstract String getName();

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.featureSwitch.a
    public int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public boolean isOn() {
        return SwitchManager.getInstance().findType(getName()) == getDefaultType();
    }
}
