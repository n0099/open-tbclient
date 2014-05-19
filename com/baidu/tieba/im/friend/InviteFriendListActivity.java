package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity implements View.OnClickListener {
    private y a;
    private af b;
    private final com.baidu.adp.base.g c = new n(this);
    private final com.baidu.adp.framework.listener.b d = new o(this, MessageTypes.CMD_COMMIT_INVITE);

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra("gid", i);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.d);
        Intent intent = getIntent();
        b();
        if (intent != null) {
            this.b.a(intent);
        } else {
            this.b.a(bundle);
        }
        c();
        d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelLoadData();
    }

    private void b() {
        this.b = new af();
        this.b.setLoadDataCallBack(this.c);
    }

    private void c() {
        this.a = new y(this);
        this.a.a(100);
        this.a.a(new q(this));
    }

    private void d() {
        this.b.a((String) null);
        this.a.i();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.h();
            if (view.getId() == this.a.d()) {
                a();
                this.b.b(this.a.g());
            } else if (view.getId() == this.a.e()) {
                this.b.a(this.a.f());
                a();
            }
        }
    }

    public void a() {
        showLoadingDialog(null, new r(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a();
    }
}
