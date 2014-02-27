package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsGroupActivity extends com.baidu.tieba.k implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private i d;
    private com.baidu.tieba.im.model.d e;
    private final com.baidu.tieba.im.messageCenter.g f = new b(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001001, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle, (Intent) null);
        com.baidu.tieba.im.model.d dVar = this.e;
        com.baidu.tieba.im.messageCenter.d.a().a(103008, this.f);
        a(bundle);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.d != null) {
            this.d.c();
            this.d = null;
        }
        a((Bundle) null, intent);
        a(intent != null ? intent.getExtras() : null);
        b(TiebaApplication.g().ae());
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.model.d dVar = this.e;
        com.baidu.tieba.im.messageCenter.d.a().a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.e.b(bundle);
    }

    private void a(Bundle bundle) {
        this.d = new i(this);
        this.d.e();
        this.d.c(this.e.a());
        this.d.a(this.e.a());
        if (bundle != null) {
            this.d.b(this.e.g());
        }
        this.d.a(h());
        this.d.d();
    }

    public final com.baidu.tieba.im.model.d e() {
        return this.e;
    }

    public final i f() {
        return this.d;
    }

    private void a(Bundle bundle, Intent intent) {
        this.e = new com.baidu.tieba.im.model.d();
        if (bundle == null) {
            com.baidu.tieba.im.model.d dVar = this.e;
            if (intent == null) {
                intent = getIntent();
            }
            dVar.a(intent);
        } else {
            this.e.a(bundle);
        }
        this.e.a(this);
    }

    @Override // com.baidu.tieba.k
    protected final void b(int i) {
        this.d.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.d.a()[h()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, this.d.f()[h()], this.d.a()[h()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.d.f()[h()]).commit();
        }
    }

    private int h() {
        return this.e.g() - 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.g()) {
            finish();
        } else if (view == this.d.h()) {
            cb.a(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            g();
        }
    }

    private void i() {
        this.d.d(true);
        this.e.c(this.e.l());
    }

    public final void g() {
        if (TextUtils.isEmpty(TiebaApplication.v())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsGroupActivity frsGroupActivity, GroupPermData groupPermData) {
        if (groupPermData.isManager()) {
            CreateGroupMainActivity.a(frsGroupActivity, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(frsGroupActivity.e.l()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
        } else if (groupPermData.isCreateNormal()) {
            CreateGroupStepActivity.a(frsGroupActivity, 3, b(frsGroupActivity.e.l()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
        } else {
            BdUtilHelper.a((Context) frsGroupActivity, groupPermData.getCreateNormalTip());
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
        if (getSupportFragmentManager().findFragmentByTag(this.d.a()[h()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.d.f()[h()]).commit();
        }
        if (i == R.id.radio_recommend) {
            this.e.a(1);
        } else if (i == R.id.radio_hot) {
            this.e.a(2);
        } else if (i == R.id.radio_official) {
            this.e.a(3);
        }
        this.d.a(h());
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            i();
        }
    }
}
