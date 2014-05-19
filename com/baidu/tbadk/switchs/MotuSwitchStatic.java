package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class MotuSwitchStatic extends a {
    public static final String[] a;

    static {
        f.a().a(MotuSwitchStatic.class);
        a = new String[]{"cn.jingling.lib"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mName = "motu_sdk";
        this.mKey = a;
    }
}
