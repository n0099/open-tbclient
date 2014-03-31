package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class IMBlackListActivity extends com.baidu.tbadk.a {
    private com.baidu.tieba.im.model.b a;
    private i b;
    private com.baidu.tieba.im.data.a c;
    private AlertDialog d;
    private com.baidu.adp.framework.c.g e = new c(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.framework.c.a().a(104103, this.e);
        com.baidu.adp.framework.c.a().a(104102, this.e);
        this.b = new i(this);
        this.a = new com.baidu.tieba.im.model.b();
        this.a.setUniqueId(getUniqueId());
        this.a.a();
        this.b.a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
    }

    public final void a(com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.a() > 0) {
            this.c = aVar;
            if (this.d == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setPositiveButton(com.baidu.tieba.im.j.confirm, new e(this));
                builder.setNegativeButton(com.baidu.tieba.im.j.alert_no_button, (DialogInterface.OnClickListener) null);
                this.d = builder.create();
            }
            this.d.setMessage(String.format(getString(com.baidu.tieba.im.j.black_list_ensure_toremove_text), aVar.b()));
            this.d.show();
        }
    }
}
