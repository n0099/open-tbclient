package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class CheckShowNameDialogSwitch extends a {
    public static final String KEY = "check_user_name";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
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
}
