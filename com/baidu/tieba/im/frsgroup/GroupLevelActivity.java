package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class GroupLevelActivity extends com.baidu.tbadk.a {
    private com.baidu.tieba.im.model.m a;
    private o b;
    private com.baidu.tbadk.core.dialog.a c;
    private com.baidu.tbadk.core.dialog.c d = new l(this);
    private com.baidu.tbadk.core.dialog.c e = new m(this);
    private com.baidu.adp.framework.c.g f = new n(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra("group_id", j);
        ((Activity) context).startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.core.g.b(this, "im_group_level_visit");
        this.a = new com.baidu.tieba.im.model.m();
        if (bundle == null) {
            this.a.a(getIntent());
        } else {
            this.a.a(bundle);
        }
        registerListener(103006, this.f);
        registerListener(103105, this.f);
        this.b = new o(this);
        this.c = new com.baidu.tbadk.core.dialog.a(this);
        this.c.a(com.baidu.tieba.im.j.upgrade_mem_group_if_up);
        this.c.a(com.baidu.tieba.im.j.alert_yes_btn, this.d);
        this.c.b(com.baidu.tieba.im.j.alert_no_button, this.e);
        this.c.a();
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

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            closeActivity();
        } else if (view == this.b.d()) {
            com.baidu.tbadk.core.g.a(this, "im_group_level_upgrade_mem");
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
