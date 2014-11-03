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
    private BlackListModel aVE;
    private h aVF;
    private com.baidu.tieba.im.data.a aVG;
    private com.baidu.adp.framework.listener.e ayS = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void nu() {
        this.aVF = new h(this);
    }

    private void Ef() {
        this.aVE = new BlackListModel(this);
        this.aVE.setUniqueId(getUniqueId());
    }

    private void yj() {
        this.aVE.loadBlackList();
        this.aVF.Cz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.ayS);
        registerListener(104102, this.ayS);
        nu();
        Ef();
        yj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aVE != null) {
            this.aVE.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        showLoadingDialog(null, new c(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.Bf == null) {
            MX();
        }
        this.Bf.setMessage(String.format(getString(y.black_list_ensure_toremove_text), aVar.getUserName()));
        com.baidu.adp.lib.g.j.a(this.Bf, this);
    }

    private void MX() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(y.confirm, new d(this));
        builder.setNegativeButton(y.alert_no_button, (DialogInterface.OnClickListener) null);
        this.Bf = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.aVG = aVar;
            a(aVar);
        }
    }
}
