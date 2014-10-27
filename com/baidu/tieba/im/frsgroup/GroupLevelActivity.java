package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.model.GroupLevelModel;
/* loaded from: classes.dex */
public class GroupLevelActivity extends BaseActivity {
    private GroupLevelModel aXi;
    private q aXj;
    private com.baidu.tbadk.core.dialog.a aXk;
    private com.baidu.tbadk.core.dialog.d aXl = new n(this);
    private com.baidu.tbadk.core.dialog.d aXm = new o(this);
    private com.baidu.adp.framework.listener.e ayJ = new p(this, 0);

    public static void a(Context context, long j, boolean z) {
        Intent intent = new Intent(context, GroupLevelActivity.class);
        intent.putExtra("group_id", j);
        intent.putExtra(GroupLevelModel.IS_MEM, z);
        ((Activity) context).startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.core.i.m(this, "im_group_level_visit");
        d(bundle);
        e(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.aXj.cX(true);
        this.aXi.sendMessage(this.aXi.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aXi.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aXj.Nw()) {
            closeActivity();
        } else if (view == this.aXj.Nx()) {
            com.baidu.tbadk.core.i.l(this, "im_group_level_upgrade_mem");
            this.aXk.kW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aXj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void d(Bundle bundle) {
        this.aXi = new GroupLevelModel(this);
        if (bundle == null) {
            this.aXi.initWithIntent(getIntent());
        } else {
            this.aXi.initWithBundle(bundle);
        }
        registerListener(103006, this.ayJ);
        registerListener(103105, this.ayJ);
    }

    private void e(Bundle bundle) {
        this.aXj = new q(this, this.aXi.isMem());
        this.aXk = new com.baidu.tbadk.core.dialog.a(this);
        this.aXk.aX(com.baidu.tieba.y.upgrade_mem_group_if_up);
        this.aXk.a(com.baidu.tieba.y.alert_yes_btn, this.aXl);
        this.aXk.b(com.baidu.tieba.y.alert_no_button, this.aXm);
        this.aXk.kT();
    }
}
