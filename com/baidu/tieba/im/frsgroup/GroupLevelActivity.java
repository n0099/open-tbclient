package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class GroupLevelActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.im.model.d f1547a;
    private m b;
    private com.baidu.tieba.im.messageCenter.h c = new l(this);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b(bundle);
        b();
    }

    private void b() {
        this.b.a(true);
        this.f1547a.a(this.f1547a.a());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f1547a.b(bundle);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.a()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1547a.b(this.c);
    }

    public void a(Bundle bundle) {
        this.f1547a = new com.baidu.tieba.im.model.d();
        if (bundle == null) {
            this.f1547a.a(getIntent());
        } else {
            this.f1547a.a(bundle);
        }
        this.f1547a.a(this.c);
    }

    private void b(Bundle bundle) {
        this.b = new m(this);
    }
}
