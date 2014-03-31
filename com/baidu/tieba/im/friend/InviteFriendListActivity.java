package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends com.baidu.tbadk.a implements View.OnClickListener {
    private y a;
    private af b;
    private final com.baidu.adp.a.h c = new n(this);
    private final com.baidu.adp.framework.c.g d = new o(this, 205002);

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra("gid", 0);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.d);
        Intent intent = getIntent();
        this.b = new af();
        this.b.setLoadDataCallBack(this.c);
        if (intent != null) {
            this.b.a(intent);
        } else {
            this.b.a(bundle);
        }
        this.a = new y(this);
        this.a.a(100);
        this.a.a(new q(this));
        this.b.a((String) null);
        this.a.j();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.i();
            if (view.getId() == this.a.e()) {
                a();
                this.b.b(this.a.h());
            } else if (view.getId() == this.a.f()) {
                this.b.a(this.a.g());
                a();
            }
        }
    }

    public final void a() {
        showLoadingDialog(null, new r(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.a.a();
    }
}
