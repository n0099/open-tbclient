package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class GroupLevelActivity extends com.baidu.tieba.j {
    private com.baidu.tieba.im.model.e a;
    private i b;
    private com.baidu.tieba.im.messageCenter.g c = new h(this);

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
        a();
    }

    private void a() {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.b(this.c);
    }

    public void a(Bundle bundle) {
        this.a = new com.baidu.tieba.im.model.e();
        if (bundle == null) {
            this.a.a(getIntent());
        } else {
            this.a.a(bundle);
        }
        this.a.a(this.c);
    }

    private void b(Bundle bundle) {
        this.b = new i(this);
    }
}
