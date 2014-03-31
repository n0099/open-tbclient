package com.baidu.tieba.im.more;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.c.g;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.BdSwitchView.c;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.am;
import com.baidu.tbadk.core.b.q;
import com.baidu.tieba.im.model.x;
/* loaded from: classes.dex */
public class SecretSettingActivity extends com.baidu.tbadk.a implements View.OnClickListener, c {
    private x a;
    private b b;
    private final g c = new a(this, 0);

    static {
        TbadkApplication.j().a(am.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new b(this);
        this.b.a(this);
        this.a = new x();
        x xVar = this.a;
        g gVar = this.c;
        com.baidu.adp.framework.c.a().a(104103, gVar);
        com.baidu.adp.framework.c.a().a(104102, gVar);
        this.b.a();
        this.a.a(8);
    }

    private void a(boolean z) {
        this.b.e();
        this.a.a(8, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        x xVar = this.a;
        com.baidu.adp.framework.c.a().b(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.b.d();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.b.g().performClick();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.g()) {
            finish();
        } else if (view == this.b.i()) {
            sendMessage(new com.baidu.adp.framework.message.a(2008001, new q(this)));
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                finish();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            a(true);
        } else {
            a(false);
        }
    }
}
