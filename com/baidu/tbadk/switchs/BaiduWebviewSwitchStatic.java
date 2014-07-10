package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class BaiduWebviewSwitchStatic extends a {
    public static final String[] a;

    static {
        f.a().a(BaiduWebviewSwitchStatic.class);
        a = new String[]{"com.baidu.browser"};
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = "baidu_webview";
        this.mKey = a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }
}
