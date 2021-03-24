package com.baidu.tbadk.switchs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class CheckShowNameDialogSwitch extends a {
    public static final String KEY = "check_user_name";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return new String[0];
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
        return KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
