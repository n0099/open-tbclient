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
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
/* loaded from: classes.dex */
public class FrsGroupActivity extends BaseFragmentActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private k c;
    private com.baidu.tieba.im.model.k d;
    private final com.baidu.adp.framework.listener.b e = new a(this, MessageTypes.CMD_GET_USER_PERMISSION);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.n.class, FrsGroupActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
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
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
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
        this.c.a(h());
        this.c.b();
    }

    public com.baidu.tieba.im.model.k e() {
        return this.d;
    }

    public k f() {
        return this.c;
    }

    public void a(Bundle bundle, Intent intent) {
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

    protected void g() {
        this.d.b(this.e);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void b(int i) {
        this.c.c(i);
    }

    private void a(boolean z) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.c.a()[h()]);
        if (z || findFragmentByTag == null) {
            getSupportFragmentManager().beginTransaction().add(com.baidu.tieba.v.fragment, this.c.d()[h()], this.c.a()[h()]).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(this.c.d()[h()]).commit();
        }
    }

    private void j() {
        if (getSupportFragmentManager().findFragmentByTag(this.c.a()[h()]) != null) {
            getSupportFragmentManager().beginTransaction().hide(this.c.d()[h()]).commit();
        }
    }

    public int h() {
        return this.d.g() - 1;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.e()) {
            k();
        } else if (view == this.c.f()) {
            TiebaStatic.eventStat(this, "create_g_in_frsgroup", "click", 1, new Object[0]);
            i();
        }
    }

    private void k() {
        finish();
    }

    private void l() {
        this.c.d(true);
        this.d.c(this.d.m());
    }

    public void i() {
        if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
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
                CreateGroupStepActivity.a(this, 3, b(this.d.m()), 1013, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.d.m()), groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
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
        if (i == com.baidu.tieba.v.radio_recommend) {
            this.d.a(1);
        } else if (i == com.baidu.tieba.v.radio_hot) {
            this.d.a(2);
        } else if (i == com.baidu.tieba.v.radio_official) {
            this.d.a(3);
        }
        this.c.a(h());
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
