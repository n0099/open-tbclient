package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.e;
/* loaded from: classes.dex */
public class BaiduWebviewSwitchStatic extends a {
    public static final String[] axQ;

    static {
        e.gv().e(BaiduWebviewSwitchStatic.class);
        axQ = new String[]{"com.baidu.browser"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "baidu_webview";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return axQ;
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
