package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class BaobaoSwitchStatic extends a {
    public static final String[] ayJ;

    static {
        e.gy().e(BaobaoSwitchStatic.class);
        ayJ = new String[]{"cn.myhug.baobao.sdk"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_baobao";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return ayJ;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
