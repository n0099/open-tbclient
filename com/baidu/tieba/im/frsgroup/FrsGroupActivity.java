package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes.dex */
public class FrsGroupActivity extends BaseFragmentActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private j d;
    private com.baidu.tieba.im.model.i e;
    private final com.baidu.adp.framework.listener.d f = new a(this, 103008);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.t.class, FrsGroupActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle, (Intent) null);
        i();
        a(bundle);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.d != null) {
            this.d.destroy();
            this.d = null;
        }
        a((Bundle) null, intent);
        a(intent != null ? intent.getExtras() : null);
        b(TbadkApplication.m252getInst().getSkinType());
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b(TbadkApplication.m252getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.e.b(bundle);
    }

    private void a(Bundle bundle) {
        this.d = new j(this);
        this.d.c();
        this.d.c(this.e.a());
        this.d.a(this.e.a());
        if (bundle != null) {
            this.d.b(this.e.g());
        }
        this.d.a(j());
        this.d.b();
    }

    public com.baidu.tieba.im.model.i g() {
        return this.e;
    }

    public j h() {
        return this.d;
    }

    public void a(Bundle bundle, Intent intent) {
        this.e = new com.baidu.tieba.im.model.i(this);
        if (bundle == null) {
            com.baidu.tieba.im.model.i iVar = this.e;
            if (intent == null) {
                intent = getIntent();
            }
            iVar.a(intent);
        } else {
            this.e.a(bundle);
        }
        this.e.a(this);
    }

    protected void i() {
        this.e.b(this.f);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.d.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.d.a()[j()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.u.fragment, this.d.d()[j()], this.d.a()[j()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.d.d()[j()]).commit();
        }
    }

    private void l() {
        if (getSupportFragmentManager().findFragmentByTag(this.d.a()[j()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.d.d()[j()]).commit();
        }
    }

    public int j() {
        return this.e.g() - 1;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.d.e()) {
            m();
        } else if (view == this.d.f()) {
            TiebaStatic.eventStat(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            k();
        }
    }

    private void m() {
        finish();
    }

    private void n() {
        this.d.d(true);
        this.e.c(this.e.l());
    }

    public void k() {
        if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupPermData groupPermData) {
        if (!groupPermData.isManager()) {
            if (!groupPermData.isCreateNormal()) {
                a(groupPermData.getCreateNormalTip());
                return;
            } else {
                CreateGroupStepActivity.a(this, 3, b(this.e.l()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.e.l()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
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
        l();
        if (i == com.baidu.tieba.u.radio_recommend) {
            this.e.a(1);
        } else if (i == com.baidu.tieba.u.radio_hot) {
            this.e.a(2);
        } else if (i == com.baidu.tieba.u.radio_official) {
            this.e.a(3);
        }
        this.d.a(j());
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            n();
        }
    }
}
