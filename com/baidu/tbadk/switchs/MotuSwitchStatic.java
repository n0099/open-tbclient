package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class MotuSwitchStatic extends a {
    public static final String[] axS;

    static {
        e.gv().e(MotuSwitchStatic.class);
        axS = new String[]{"cn.jingling.lib"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "motu_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return axS;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 0;
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
