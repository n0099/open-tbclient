package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupLevelActivity extends BaseActivity {
    private com.baidu.tieba.im.model.n a;
    private o b;
    private com.baidu.tbadk.core.dialog.a c;
    private com.baidu.tbadk.core.dialog.c d = new l(this);
    private com.baidu.tbadk.core.dialog.c e = new m(this);
    private com.baidu.adp.framework.listener.b f = new n(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        ((Activity) context).startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.core.g.b(this, "im_group_level_visit");
        a(bundle);
        b(bundle);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.a(true);
        this.a.a(this.a.a(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.a.b(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            closeActivity();
        } else if (view == this.b.b()) {
            com.baidu.tbadk.core.g.a(this, "im_group_level_upgrade_mem");
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void a(Bundle bundle) {
        this.a = new com.baidu.tieba.im.model.n();
        if (bundle == null) {
            this.a.a(getIntent());
        } else {
            this.a.a(bundle);
        }
        registerListener(MessageTypes.CMD_REQUEST_GROUPLEVEL_BY_ID, this.f);
        registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.f);
    }

    private void b(Bundle bundle) {
        this.b = new o(this);
        this.c = new com.baidu.tbadk.core.dialog.a(this);
        this.c.a(com.baidu.tieba.u.upgrade_mem_group_if_up);
        this.c.a(com.baidu.tieba.u.alert_yes_btn, this.d);
        this.c.b(com.baidu.tieba.u.alert_no_button, this.e);
        this.c.a();
    }
}
