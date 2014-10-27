package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity {
    private AlertDialog Bf;
    private BlackListModel aVq;
    private h aVr;
    private com.baidu.tieba.im.data.a aVs;
    private com.baidu.adp.framework.listener.e ayJ = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void nu() {
        this.aVr = new h(this);
    }

    private void Ed() {
        this.aVq = new BlackListModel(this);
        this.aVq.setUniqueId(getUniqueId());
    }

    private void yh() {
        this.aVq.loadBlackList();
        this.aVr.Cx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.ayJ);
        registerListener(104102, this.ayJ);
        nu();
        Ed();
        yh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aVq != null) {
            this.aVq.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        showLoadingDialog(null, new c(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.Bf == null) {
            MT();
        }
        this.Bf.setMessage(String.format(getString(y.black_list_ensure_toremove_text), aVar.getUserName()));
        com.baidu.adp.lib.g.j.a(this.Bf, this);
    }

    private void MT() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(y.confirm, new d(this));
        builder.setNegativeButton(y.alert_no_button, (DialogInterface.OnClickListener) null);
        this.Bf = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.aVs = aVar;
            a(aVar);
        }
    }
}
