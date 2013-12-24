package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.bd;
import com.baidu.tieba.im.message.bx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class IMBlackListActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private com.baidu.tieba.im.model.b a;
    private f b;
    private com.baidu.tieba.im.data.a c;
    private AlertDialog d;

    public static void a(Context context) {
        context.startActivity(new Intent(context, IMBlackListActivity.class));
    }

    private void a() {
        this.b = new f(this);
    }

    private void b() {
        this.a = new com.baidu.tieba.im.model.b();
    }

    private void c() {
        this.a.a();
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(104103, this);
        com.baidu.tieba.im.messageCenter.e.a().a(104102, this);
        a();
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        bx bxVar;
        com.baidu.tieba.im.message.n l;
        this.b.e();
        closeLoadingDialog();
        if (nVar != null) {
            if (nVar.t() == 104103 && (nVar instanceof bd)) {
                bd bdVar = (bd) nVar;
                if (bdVar.i()) {
                    showToast(bdVar.k());
                } else {
                    this.b.a(bdVar.b());
                }
            } else if (nVar.t() == 104102 && (nVar instanceof bx) && (l = (bxVar = (bx) nVar).l()) != null && (l instanceof at) && ((at) l).b() == 10) {
                if (bxVar.i()) {
                    showToast(bxVar.k());
                    return;
                }
                showToast(getString(R.string.black_list_remove_success));
                if (this.c != null) {
                    this.b.a(this.c);
                    this.c = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        showLoadingDialog(null, new a(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.d == null) {
            e();
        }
        this.d.setMessage(String.format(getString(R.string.black_list_ensure_toremove_text), aVar.b()));
        this.d.show();
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(R.string.confirm, new b(this));
        builder.setNegativeButton(R.string.alert_no_button, (DialogInterface.OnClickListener) null);
        this.d = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.a() > 0) {
            this.c = aVar;
            a(aVar);
        }
    }
}
