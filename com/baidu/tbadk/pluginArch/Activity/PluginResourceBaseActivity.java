package com.baidu.tbadk.pluginArch.Activity;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pluginArch.y;
/* loaded from: classes.dex */
public class PluginResourceBaseActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    protected void a() {
        y.a().a(this);
    }
}
