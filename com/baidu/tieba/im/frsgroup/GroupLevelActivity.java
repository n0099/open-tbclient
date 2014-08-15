package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class GroupLevelActivity extends BaseActivity {
    private com.baidu.tieba.im.model.l a;
    private n b;
    private com.baidu.tbadk.core.dialog.a c;
    private com.baidu.tbadk.core.dialog.d d = new k(this);
    private com.baidu.tbadk.core.dialog.d e = new l(this);
    private com.baidu.adp.framework.listener.d f = new m(this, 0);

    public static void a(Context context, long j, boolean z) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        intent.putExtra("is_mem", z);
        ((Activity) context).startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.core.f.b(this, "im_group_level_visit");
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
            com.baidu.tbadk.core.f.a(this, "im_group_level_upgrade_mem");
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
        this.a = new com.baidu.tieba.im.model.l(this);
        if (bundle == null) {
            this.a.a(getIntent());
        } else {
            this.a.a(bundle);
        }
        registerListener(103006, this.f);
        registerListener(103105, this.f);
    }

    private void b(Bundle bundle) {
        this.b = new n(this, this.a.b());
        this.c = new com.baidu.tbadk.core.dialog.a(this);
        this.c.b(com.baidu.tieba.x.upgrade_mem_group_if_up);
        this.c.a(com.baidu.tieba.x.alert_yes_btn, this.d);
        this.c.b(com.baidu.tieba.x.alert_no_button, this.e);
        this.c.a();
    }
}
