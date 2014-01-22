package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.message.bk;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends com.baidu.tieba.j implements View.OnClickListener, com.baidu.tieba.im.messageCenter.g {
    private t a;
    private com.baidu.tieba.im.model.h b;
    private com.baidu.adp.a.g c = new l(this);

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra(PushConstants.EXTRA_GID, i);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(205002, this);
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
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        this.b.cancelLoadData();
    }

    private void b() {
        this.b = new com.baidu.tieba.im.model.h();
        this.b.setLoadDataCallBack(this.c);
    }

    private void c() {
        this.a = new t(this);
        this.a.a(100);
        this.a.a(new k(this));
    }

    private void d() {
        this.b.a((String) null);
        this.a.l();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.k();
            if (view.getId() == this.a.g()) {
                a();
                this.b.b(this.a.j());
            } else if (view.getId() == this.a.h()) {
                this.b.a(this.a.i());
                a();
            }
        }
    }

    public void a() {
        showLoadingDialog(null, new m(this));
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        closeLoadingDialog();
        if (qVar != null && qVar.w() == 205002 && (qVar instanceof bk)) {
            try {
                bk bkVar = (bk) qVar;
                if (bkVar.k()) {
                    showToast(bkVar.m());
                } else {
                    showToast(getString(R.string.send_success), false);
                    new Handler().postDelayed(new n(this), 400L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.a.a();
    }
}
