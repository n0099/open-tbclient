package com.baidu.tieba.im.more;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.BdSwitchView.c;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ay;
import com.baidu.tbadk.core.atomData.t;
import com.baidu.tieba.im.model.ac;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity implements View.OnClickListener, c {
    private ac a;
    private b b;
    private final com.baidu.adp.framework.listener.b c = new a(this, 0);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ay.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new b(this);
        this.b.a(this);
        b();
        a();
        c();
    }

    private void a() {
        this.a.a(this.c);
    }

    private void b() {
        this.a = new ac();
    }

    private void c() {
        this.b.a();
        this.a.a(8);
    }

    private void a(boolean z) {
        this.b.c();
        this.a.a(8, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.b.b();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.b.e().performClick();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.e()) {
            finish();
        } else if (view == this.b.g()) {
            d();
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

    private void d() {
        sendMessage(new CustomMessage(2010001, new t(this)));
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            a(true);
        } else {
            a(false);
        }
    }
}
