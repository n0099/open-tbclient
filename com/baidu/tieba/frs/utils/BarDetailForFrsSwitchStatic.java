package com.baidu.tieba.frs.utils;

import com.baidu.adp.lib.b.f;
/* loaded from: classes.dex */
public class BarDetailForFrsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        f.da().l(BarDetailForFrsSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "frs_to_bar_detail";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
