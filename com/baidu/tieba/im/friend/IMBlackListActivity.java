package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.im.message.bj;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.cx;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class IMBlackListActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        cx cxVar;
        com.baidu.tieba.im.message.s o;
        this.b.e();
        closeLoadingDialog();
        if (sVar != null) {
            if (sVar.w() == 104103 && (sVar instanceof bz)) {
                bz bzVar = (bz) sVar;
                if (bzVar.l()) {
                    showToast(bzVar.n());
                } else {
                    this.b.a(bzVar.b());
                }
            } else if (sVar.w() == 104102 && (sVar instanceof cx) && (o = (cxVar = (cx) sVar).o()) != null && (o instanceof bj) && ((bj) o).b() == 10) {
                if (cxVar.l()) {
                    showToast(cxVar.n());
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
