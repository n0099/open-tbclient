package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class AccountsDataFromPassSwitch extends a {
    public static final String ACCOUNT_DATA_FROM_PASS = "switch_account_data_from_pass";
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return ACCOUNT_DATA_FROM_PASS;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
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
