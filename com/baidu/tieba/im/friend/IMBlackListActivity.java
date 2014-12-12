package com.baidu.tieba.im.friend;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    private BlackListModel aZV;
    private h aZW;
    private com.baidu.tieba.im.data.a aZX;
    private AlertDialog mDialog;
    private com.baidu.adp.framework.listener.e mListener = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void initView() {
        this.aZW = new h(this);
    }

    private void CG() {
        this.aZV = new BlackListModel(this);
        this.aZV.setUniqueId(getUniqueId());
    }

    private void DE() {
        this.aZV.loadBlackList();
        this.aZW.Oj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        CG();
        DE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aZV != null) {
            this.aZV.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        showLoadingDialog(null, new c(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.mDialog == null) {
            Oh();
        }
        this.mDialog.setMessage(String.format(getPageContext().getString(z.black_list_ensure_toremove_text), aVar.getUserName()));
        com.baidu.adp.lib.g.k.a(this.mDialog, getPageContext());
    }

    private void Oh() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setPositiveButton(z.confirm, new d(this));
        builder.setNegativeButton(z.alert_no_button, (DialogInterface.OnClickListener) null);
        this.mDialog = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.aZX = aVar;
            a(aVar);
        }
    }
}
