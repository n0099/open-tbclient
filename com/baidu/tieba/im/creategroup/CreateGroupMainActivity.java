package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class CreateGroupMainActivity extends BaseActivity {
    f aTs = null;
    private int aTt;
    private int aTu;
    private int aTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aTs = new f(this);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("canCreateOfficialGroup", false);
        boolean booleanExtra2 = intent.getBooleanExtra("canCreateCommonGroup", false);
        String stringExtra = intent.getStringExtra("createGroupOfficialTip");
        String stringExtra2 = intent.getStringExtra("createCommonGroupTip");
        int intExtra = intent.getIntExtra(WriteImageActivityConfig.FORUMID, 0);
        this.aTt = intent.getIntExtra("num_create_group_normal", 0);
        this.aTu = intent.getIntExtra("num_create_group_offical", 0);
        this.aTv = intent.getIntExtra("num_create_group_private", 0);
        this.aTs.a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, intExtra);
        TiebaStatic.eventStat(this, "create_g_bz_pv", "pv", 1, new Object[0]);
    }

    public static void a(Activity activity, boolean z, boolean z2, String str, String str2, int i, int i2, int i3, int i4) {
        Intent intent = new Intent(activity, CreateGroupMainActivity.class);
        intent.putExtra("canCreateOfficialGroup", z);
        intent.putExtra("canCreateCommonGroup", z2);
        intent.putExtra("createGroupOfficialTip", str);
        intent.putExtra("createCommonGroupTip", str2);
        intent.putExtra("num_create_group_normal", i2);
        intent.putExtra("num_create_group_offical", i3);
        intent.putExtra("num_create_group_private", i4);
        intent.putExtra(WriteImageActivityConfig.FORUMID, i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aTs.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aTs.Lj()) {
            CreateGroupStepActivity.a(this, 3, this.aTs.getForumId(), 1013, this.aTt, this.aTu, this.aTv);
            TiebaStatic.eventStat(this, "create_g_common", "click", 1, new Object[0]);
        } else if (view == this.aTs.Lk()) {
            CreateGroupStepActivity.a(this, 4, this.aTs.getForumId(), 1013, this.aTt, this.aTu, this.aTv);
            TiebaStatic.eventStat(this, "create_g_official", "click", 1, new Object[0]);
        }
        finish();
    }
}
