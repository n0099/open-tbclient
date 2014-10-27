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
    f aTe = null;
    private int aTf;
    private int aTg;
    private int aTh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aTe = new f(this);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("canCreateOfficialGroup", false);
        boolean booleanExtra2 = intent.getBooleanExtra("canCreateCommonGroup", false);
        String stringExtra = intent.getStringExtra("createGroupOfficialTip");
        String stringExtra2 = intent.getStringExtra("createCommonGroupTip");
        int intExtra = intent.getIntExtra(WriteImageActivityConfig.FORUMID, 0);
        this.aTf = intent.getIntExtra("num_create_group_normal", 0);
        this.aTg = intent.getIntExtra("num_create_group_offical", 0);
        this.aTh = intent.getIntExtra("num_create_group_private", 0);
        this.aTe.a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, intExtra);
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
        this.aTe.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aTe.Lf()) {
            CreateGroupStepActivity.a(this, 3, this.aTe.getForumId(), 1013, this.aTf, this.aTg, this.aTh);
            TiebaStatic.eventStat(this, "create_g_common", "click", 1, new Object[0]);
        } else if (view == this.aTe.Lg()) {
            CreateGroupStepActivity.a(this, 4, this.aTe.getForumId(), 1013, this.aTf, this.aTg, this.aTh);
            TiebaStatic.eventStat(this, "create_g_official", "click", 1, new Object[0]);
        }
        finish();
    }
}
