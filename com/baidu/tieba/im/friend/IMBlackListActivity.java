package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity {
    private com.baidu.tieba.im.model.b a;
    private i b;
    private com.baidu.tieba.im.data.a c;
    private AlertDialog d;
    private com.baidu.adp.framework.listener.b e = new c(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010001, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void a() {
        this.b = new i(this);
    }

    private void b() {
        this.a = new com.baidu.tieba.im.model.b();
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
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GET_MASK_INFO, this.e);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_MASK_INFO, this.e);
        a();
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        showLoadingDialog(null, new d(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.d == null) {
            e();
        }
        this.d.setMessage(String.format(getString(com.baidu.tieba.y.black_list_ensure_toremove_text), aVar.b()));
        this.d.show();
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(com.baidu.tieba.y.confirm, new e(this));
        builder.setNegativeButton(com.baidu.tieba.y.alert_no_button, (DialogInterface.OnClickListener) null);
        this.d = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.a() > 0) {
            this.c = aVar;
            a(aVar);
        }
    }
}
