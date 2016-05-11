package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
/* loaded from: classes.dex */
public class BaobaoSwitchStatic extends a {
    public static final String[] azs;

    static {
        e.cS().f(BaobaoSwitchStatic.class);
        azs = new String[]{"cn.myhug.baobao.sdk"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "switch_baobao";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return azs;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
