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
    private k c;
    private com.baidu.tieba.im.model.i d;
    private final com.baidu.adp.framework.listener.b e = new a(this, 103008);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.s.class, FrsGroupActivity.class);
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
        if (this.c != null) {
            this.c.destroy();
            this.c = null;
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
        this.d.b(bundle);
    }

    private void a(Bundle bundle) {
        this.c = new k(this);
        this.c.c();
        this.c.c(this.d.a());
        this.c.a(this.d.a());
        if (bundle != null) {
            this.c.b(this.d.g());
        }
        this.c.a(j());
        this.c.b();
    }

    public com.baidu.tieba.im.model.i g() {
        return this.d;
    }

    public k h() {
        return this.c;
    }

    public void a(Bundle bundle, Intent intent) {
        this.d = new com.baidu.tieba.im.model.i(this);
        if (bundle == null) {
            com.baidu.tieba.im.model.i iVar = this.d;
            if (intent == null) {
                intent = getIntent();
            }
            iVar.a(intent);
        } else {
            this.d.a(bundle);
        }
        this.d.a(this);
    }

    protected void i() {
        this.d.b(this.e);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.c.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.c.a()[j()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.v.fragment, this.c.d()[j()], this.c.a()[j()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.c.d()[j()]).commit();
        }
    }

    private void l() {
        if (getSupportFragmentManager().findFragmentByTag(this.c.a()[j()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.c.d()[j()]).commit();
        }
    }

    public int j() {
        return this.d.g() - 1;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.e()) {
            m();
        } else if (view == this.c.f()) {
            TiebaStatic.eventStat(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            k();
        }
    }

    private void m() {
        finish();
    }

    private void n() {
        this.c.d(true);
        this.d.c(this.d.l());
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
                CreateGroupStepActivity.a(this, 3, b(this.d.l()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.d.l()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
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
        if (i == com.baidu.tieba.v.radio_recommend) {
            this.d.a(1);
        } else if (i == com.baidu.tieba.v.radio_hot) {
            this.d.a(2);
        } else if (i == com.baidu.tieba.v.radio_official) {
            this.d.a(3);
        }
        this.c.a(j());
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
