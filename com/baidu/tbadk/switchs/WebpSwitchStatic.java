package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class WebpSwitchStatic extends a {
    static {
        f.a().a(WebpSwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mDefaultType = 0;
        this.mOffType = 0;
        this.mName = "webp_enable";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }
}
