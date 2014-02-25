package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.adp.framework.task.CustomMessageTask;
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
        g();
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
        b(TiebaApplication.g().al());
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
        this.e.d(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.e.b(bundle);
    }

    private void a(Bundle bundle) {
        this.d = new i(this);
        this.d.f();
        this.d.c(this.e.a());
        this.d.a(this.e.a());
        if (bundle != null) {
            this.d.b(this.e.g());
        }
        this.d.a(h());
        this.d.e();
    }

    public com.baidu.tieba.im.model.d e() {
        return this.e;
    }

    public i f() {
        return this.d;
    }

    public void a(Bundle bundle, Intent intent) {
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

    protected void g() {
        this.e.c(this.f);
    }

    @Override // com.baidu.tieba.k
    protected void b(int i) {
        this.d.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.d.a()[h()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, this.d.g()[h()], this.d.a()[h()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.d.g()[h()]).commit();
        }
    }

    private void j() {
        if (getSupportFragmentManager().findFragmentByTag(this.d.a()[h()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.d.g()[h()]).commit();
        }
    }

    public int h() {
        return this.e.g() - 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.h()) {
            k();
        } else if (view == this.d.i()) {
            cb.a(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            i();
        }
    }

    private void k() {
        finish();
    }

    private void l() {
        this.d.d(true);
        this.e.c(this.e.m());
    }

    public void i() {
        if (TextUtils.isEmpty(TiebaApplication.A())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupPermData groupPermData) {
        if (!groupPermData.isManager()) {
            if (!groupPermData.isCreateNormal()) {
                a(groupPermData.getCreateNormalTip());
                return;
            } else {
                CreateGroupStepActivity.a(this, 3, b(this.e.m()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.e.m()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
    }

    private int b(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        j();
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
            l();
        }
    }
}
