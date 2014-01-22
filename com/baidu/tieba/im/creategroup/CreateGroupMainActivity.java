package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
public class CreateGroupMainActivity extends com.baidu.tieba.j {
    e a = null;
    private int b;
    private int c;
    private int d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new e(this);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("canCreateOfficialGroup", false);
        boolean booleanExtra2 = intent.getBooleanExtra("canCreateCommonGroup", false);
        String stringExtra = intent.getStringExtra("createGroupOfficialTip");
        String stringExtra2 = intent.getStringExtra("createCommonGroupTip");
        int intExtra = intent.getIntExtra("forumid", 0);
        this.b = intent.getIntExtra("num_create_group_normal", 0);
        this.c = intent.getIntExtra("num_create_group_offical", 0);
        this.d = intent.getIntExtra("num_create_group_private", 0);
        this.a.a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, intExtra);
        by.a(this, "create_g_bz_pv", "pv", 1, new Object[0]);
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
        intent.putExtra("forumid", i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.e()) {
            CreateGroupStepActivity.a(this, 3, this.a.a(), 1013, this.b, this.c, this.d);
            by.a(this, "create_g_common", "click", 1, new Object[0]);
        } else if (view == this.a.f()) {
            CreateGroupStepActivity.a(this, 4, this.a.a(), 1013, this.b, this.c, this.d);
            by.a(this, "create_g_official", "click", 1, new Object[0]);
        }
        finish();
    }
}
