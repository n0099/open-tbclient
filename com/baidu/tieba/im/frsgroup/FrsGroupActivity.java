package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes.dex */
public class FrsGroupActivity extends com.baidu.tbadk.core.e implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private k c;
    private com.baidu.tieba.im.model.k d;
    private final com.baidu.adp.framework.c.g e = new a(this, 103008);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.m.class, FrsGroupActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle, (Intent) null);
        this.d.a(this.e);
        a(bundle);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.c != null) {
            this.c.c();
            this.c = null;
        }
        a((Bundle) null, intent);
        a(intent != null ? intent.getExtras() : null);
        c(TbadkApplication.j().l());
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c(TbadkApplication.j().l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.e, com.baidu.adp.a.c, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.d.b(bundle);
    }

    private void a(Bundle bundle) {
        this.c = new k(this);
        this.c.e();
        this.c.c(this.d.a());
        this.c.a(this.d.a());
        if (bundle != null) {
            this.c.b(this.d.g());
        }
        this.c.a(i());
        this.c.d();
    }

    public final com.baidu.tieba.im.model.k f() {
        return this.d;
    }

    public final k g() {
        return this.c;
    }

    private void a(Bundle bundle, Intent intent) {
        this.d = new com.baidu.tieba.im.model.k(this);
        if (bundle == null) {
            com.baidu.tieba.im.model.k kVar = this.d;
            if (intent == null) {
                intent = getIntent();
            }
            kVar.a(intent);
        } else {
            this.d.a(bundle);
        }
        this.d.a(this);
    }

    @Override // com.baidu.tbadk.core.e
    protected final void c(int i) {
        this.c.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.c.a()[i()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.im.h.fragment, this.c.f()[i()], this.c.a()[i()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.c.f()[i()]).commit();
        }
    }

    private int i() {
        return this.d.g() - 1;
    }

    @Override // com.baidu.adp.a.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.g()) {
            finish();
        } else if (view == this.c.h()) {
            TiebaStatic.a(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            h();
        }
    }

    private void j() {
        this.c.d(true);
        this.d.c(this.d.l());
    }

    public final void h() {
        if (TextUtils.isEmpty(TbadkApplication.E())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsGroupActivity frsGroupActivity, GroupPermData groupPermData) {
        if (groupPermData.isManager()) {
            CreateGroupMainActivity.a(frsGroupActivity, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(frsGroupActivity.d.l()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
        } else if (groupPermData.isCreateNormal()) {
            CreateGroupStepActivity.a(frsGroupActivity, 3, b(frsGroupActivity.d.l()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
        } else {
            com.baidu.adp.lib.util.i.a((Context) frsGroupActivity, groupPermData.getCreateNormalTip());
        }
    }

    private static int b(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (getSupportFragmentManager().findFragmentByTag(this.c.a()[i()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.c.f()[i()]).commit();
        }
        if (i == com.baidu.tieba.im.h.radio_recommend) {
            this.d.a(1);
        } else if (i == com.baidu.tieba.im.h.radio_hot) {
            this.d.a(2);
        } else if (i == com.baidu.tieba.im.h.radio_official) {
            this.d.a(3);
        }
        this.c.a(i());
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            j();
        }
    }
}
