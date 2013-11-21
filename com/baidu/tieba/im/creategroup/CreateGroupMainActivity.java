package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class CreateGroupMainActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    b f1568a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1568a = new b(this);
        Intent intent = getIntent();
        this.f1568a.a(intent.getBooleanExtra("canCreateOfficialGroup", false), intent.getBooleanExtra("canCreateCommonGroup", false), intent.getStringExtra("createGroupOfficialTip"), intent.getStringExtra("createCommonGroupTip"), intent.getIntExtra("forumid", 0));
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "create_g_bz_pv", "pv", 1);
        }
    }

    public static void a(Activity activity, boolean z, boolean z2, String str, String str2, int i) {
        Intent intent = new Intent(activity, CreateGroupMainActivity.class);
        intent.putExtra("canCreateOfficialGroup", z);
        intent.putExtra("canCreateCommonGroup", z2);
        intent.putExtra("createGroupOfficialTip", str);
        intent.putExtra("createCommonGroupTip", str2);
        intent.putExtra("forumid", i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1568a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1568a.e()) {
            CreateGroupStepActivity.a(this, 3, this.f1568a.a());
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "create_g_common", "click", 1);
            }
        } else if (view == this.f1568a.f()) {
            CreateGroupStepActivity.a(this, 4, this.f1568a.a());
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "create_g_official", "click", 1);
            }
        }
        finish();
    }
}
