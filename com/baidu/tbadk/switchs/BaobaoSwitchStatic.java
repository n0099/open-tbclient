package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.a.a;
import com.baidu.adp.lib.a.f;
/* loaded from: classes.dex */
public class BaobaoSwitchStatic extends a {
    public static final String[] a;

    static {
        f.a().a(BaobaoSwitchStatic.class);
        a = new String[]{"cn.myhug.baobao.sdk"};
    }

    @Override // com.baidu.adp.lib.a.a
    protected void initData() {
        this.mDefaultType = 0;
        this.mOffType = 0;
        this.mName = "switch_baobao";
        this.mKey = a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void changeSettingByType(int i) {
    }
}
