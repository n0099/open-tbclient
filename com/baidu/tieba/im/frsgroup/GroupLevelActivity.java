package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.ai;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupLevelActivity extends com.baidu.tieba.f {
    private com.baidu.tieba.im.model.f a;
    private m b;
    private com.baidu.tieba.view.dialog.a c;
    private com.baidu.tieba.view.dialog.c d = new j(this);
    private com.baidu.tieba.view.dialog.c e = new k(this);
    private com.baidu.tieba.im.messageCenter.g f = new l(this);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra("group_id", j);
        ((Activity) context).startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai.b(this, "im_group_level_visit");
        this.a = new com.baidu.tieba.im.model.f();
        if (bundle == null) {
            this.a.a(getIntent());
        } else {
            this.a.a(bundle);
        }
        com.baidu.tieba.im.model.f fVar = this.a;
        com.baidu.tieba.im.messageCenter.g gVar = this.f;
        com.baidu.tieba.im.messageCenter.d.a().a(103006, gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(103105, gVar);
        this.b = new m(this);
        this.c = new com.baidu.tieba.view.dialog.a(this);
        this.c.a(R.string.upgrade_mem_group_if_up);
        this.c.a(R.string.alert_yes_btn, this.d);
        this.c.b(R.string.alert_no_button, this.e);
        this.c.a();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.a(true);
        this.a.a(this.a.a());
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
            ai.a(this, "im_group_level_upgrade_mem");
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.model.f fVar = this.a;
        com.baidu.tieba.im.messageCenter.d.a().a(this.f);
    }
}
