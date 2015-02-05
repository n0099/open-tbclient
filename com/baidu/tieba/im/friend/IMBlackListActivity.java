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
    private BlackListModel bbr;
    private h bbs;
    private com.baidu.tieba.im.data.a bbt;
    private AlertDialog mDialog;
    private com.baidu.adp.framework.listener.e mListener = new b(this, 0);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void initView() {
        this.bbs = new h(this);
    }

    private void CZ() {
        this.bbr = new BlackListModel(this);
        this.bbr.setUniqueId(getUniqueId());
    }

    private void DX() {
        this.bbr.loadBlackList();
        this.bbs.OA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(104103, this.mListener);
        registerListener(104102, this.mListener);
        initView();
        CZ();
        DX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bbr != null) {
            this.bbr.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox() {
        showLoadingDialog(null, new c(this));
    }

    private void a(com.baidu.tieba.im.data.a aVar) {
        if (this.mDialog == null) {
            Oy();
        }
        this.mDialog.setMessage(String.format(getPageContext().getString(z.black_list_ensure_toremove_text), aVar.getUserName()));
        com.baidu.adp.lib.g.k.a(this.mDialog, getPageContext());
    }

    private void Oy() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setPositiveButton(z.confirm, new d(this));
        builder.setNegativeButton(z.alert_no_button, (DialogInterface.OnClickListener) null);
        this.mDialog = builder.create();
    }

    public void a(View view, com.baidu.tieba.im.data.a aVar) {
        if (aVar != null && aVar.getUserId() > 0) {
            this.bbt = aVar;
            a(aVar);
        }
    }
}
