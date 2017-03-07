package com.baidu.tbadk.switchs;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.b.a {
    public static final String[] aIb = {"com.baidu.browser"};

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
        return aIb;
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
