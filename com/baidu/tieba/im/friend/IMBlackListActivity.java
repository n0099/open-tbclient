package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity {
    private com.baidu.tieba.im.model.b a;
    private h b;
    private com.baidu.tieba.im.data.a c;
    private AlertDialog d;
    private com.baidu.adp.framework.listener.d e = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void a() {
        this.b = new h(this);
    }

    private void b() {
        this.a = new com.baidu.tieba.im.model.b(this);
        this.a.setUniqueId(getUniqueId());
    }

    private void c() {
        this.a.a();
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.e);
        registerListener(104102, this.e);
        a();
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        showLoadingDialog(null, new c(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.d == null) {
            e();
        }
        this.d.setMessage(String.format(getString(x.black_list_ensure_toremove_text), aVar.b()));
        com.baidu.adp.lib.e.d.a(this.d, this);
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(x.confirm, new d(this));
        builder.setNegativeButton(x.alert_no_button, (DialogInterface.OnClickListener) null);
        this.d = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.a() > 0) {
            this.c = aVar;
            a(aVar);
        }
    }
}
