package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class AccountsDataFromPassSwitch extends a {
    public static final String ACCOUNT_DATA_FROM_PASS = "switch_account_data_from_pass";
    public static final int DEFAULT_TYPE = 0;
    public static final int OFF_TYPE = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return ACCOUNT_DATA_FROM_PASS;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 1;
    }
}
