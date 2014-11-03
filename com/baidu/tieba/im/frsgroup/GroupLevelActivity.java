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
    private GroupLevelModel aXw;
    private q aXx;
    private com.baidu.tbadk.core.dialog.a aXy;
    private com.baidu.tbadk.core.dialog.d aXz = new n(this);
    private com.baidu.tbadk.core.dialog.d aXA = new o(this);
    private com.baidu.adp.framework.listener.e ayS = new p(this, 0);

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
        com.baidu.tbadk.core.j.m(this, "im_group_level_visit");
        d(bundle);
        e(bundle);
        startLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.aXx.cX(true);
        this.aXw.sendMessage(this.aXw.getGroupId(), getUniqueId());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aXw.saveInstance(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aXx.NA()) {
            closeActivity();
        } else if (view == this.aXx.NB()) {
            com.baidu.tbadk.core.j.l(this, "im_group_level_upgrade_mem");
            this.aXy.kW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aXx.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void d(Bundle bundle) {
        this.aXw = new GroupLevelModel(this);
        if (bundle == null) {
            this.aXw.initWithIntent(getIntent());
        } else {
            this.aXw.initWithBundle(bundle);
        }
        registerListener(103006, this.ayS);
        registerListener(103105, this.ayS);
    }

    private void e(Bundle bundle) {
        this.aXx = new q(this, this.aXw.isMem());
        this.aXy = new com.baidu.tbadk.core.dialog.a(this);
        this.aXy.aX(com.baidu.tieba.y.upgrade_mem_group_if_up);
        this.aXy.a(com.baidu.tieba.y.alert_yes_btn, this.aXz);
        this.aXy.b(com.baidu.tieba.y.alert_no_button, this.aXA);
        this.aXy.kT();
    }
}
