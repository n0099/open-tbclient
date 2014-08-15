package com.baidu.tieba.im.more;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ab;
import com.baidu.tbadk.core.atomData.bs;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity implements View.OnClickListener {
    private a a;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bs.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.a.a();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.a.b().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.b()) {
            finish();
        } else if (view == this.a.c()) {
            a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                finish();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void a() {
        sendMessage(new CustomMessage(2008001, new ab(this)));
    }
}
