package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity implements View.OnClickListener {
    private x b;
    private ae c;
    public List<com.baidu.tbadk.coreExtra.relationship.b> a = null;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private CustomMessageListener e = new m(this, 2001188);
    private final com.baidu.adp.framework.listener.b f = new n(this, 205002);

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
        registerListener(this.f);
        registerListener(this.e);
        Intent intent = getIntent();
        b();
        if (intent != null) {
            this.c.a(intent);
        } else {
            this.c.a(bundle);
        }
        c();
        d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.cancelLoadData();
    }

    private void b() {
        this.c = new ae();
    }

    private void c() {
        this.b = new x(this);
        this.b.a(100);
        this.b.a(new p(this));
    }

    private void d() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String trim;
        if (!isFinishing()) {
            if (this.a == null) {
                if (!this.d.get()) {
                    this.d.set(true);
                    a();
                    this.b.h();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String e = this.b.e();
            if (e == null) {
                trim = "";
            } else {
                trim = e.trim();
            }
            if (this.a.isEmpty() && trim.length() > 0) {
                showToast(getString(com.baidu.tieba.y.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.b.a(this.a, false);
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.a) {
                String a = bVar.a();
                if (a != null && a.contains(trim)) {
                    linkedList.add(bVar);
                }
            }
            this.b.a((List<com.baidu.tbadk.coreExtra.relationship.b>) linkedList, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.g();
            if (view.getId() == this.b.d()) {
                a();
                this.c.a(this.b.f());
            }
        }
    }

    public void a() {
        showLoadingDialog(null, new q(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a();
    }
}
