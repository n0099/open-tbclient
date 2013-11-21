package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.creategroup.CreateGroupMainActivity;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsGroupActivity extends BaseFragmentActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private g b;
    private com.baidu.tieba.im.model.b c;
    private com.baidu.tieba.im.messageCenter.h d = new a(this);

    public static void a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, FrsGroupActivity.class);
        intent.putExtra("forum_id", str);
        intent.putExtra("show_recommend", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle, (Intent) null);
        e();
        a(bundle);
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.b != null) {
            this.b.c();
            this.b = null;
        }
        a((Bundle) null, intent);
        a(intent != null ? intent.getExtras() : null);
        a(TiebaApplication.g().ap());
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.d(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.c.b(bundle);
    }

    private void a(Bundle bundle) {
        this.b = new g(this);
        this.b.f();
        this.b.c(this.c.a());
        this.b.a(this.c.a());
        if (bundle != null) {
            this.b.a(this.c.g());
        }
        this.b.e();
    }

    public com.baidu.tieba.im.model.b c() {
        return this.c;
    }

    public g d() {
        return this.b;
    }

    public void a(Bundle bundle, Intent intent) {
        this.c = new com.baidu.tieba.im.model.b();
        if (bundle == null) {
            com.baidu.tieba.im.model.b bVar = this.c;
            if (intent == null) {
                intent = getIntent();
            }
            bVar.a(intent);
        } else {
            this.c.a(bundle);
        }
        this.c.a(this);
    }

    protected void e() {
        this.c.c(this.d);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.b.b(i);
    }

    private void a(boolean z) {
        Fragment a2 = getSupportFragmentManager().a(this.b.a()[f()]);
        if (z || a2 == null) {
            getSupportFragmentManager().a().a(R.id.fragment, this.b.g()[f()], this.b.a()[f()]).a();
        } else {
            getSupportFragmentManager().a().c(this.b.g()[f()]).a();
        }
    }

    private void g() {
        if (getSupportFragmentManager().a(this.b.a()[f()]) != null) {
            getSupportFragmentManager().a().b(this.b.g()[f()]).a();
        }
    }

    public int f() {
        return this.c.g() - 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.h()) {
            h();
        } else if (view == this.b.i()) {
            StatService.onEvent(this, "create_g_in_frsgroup", "click");
            j();
        }
    }

    private void h() {
        finish();
    }

    private void i() {
        this.b.d(true);
        this.c.c(this.c.m());
    }

    private void j() {
        if (TextUtils.isEmpty(TiebaApplication.A())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            i();
        }
    }

    public void a(GroupPermData groupPermData) {
        if (!groupPermData.isManager()) {
            if (!groupPermData.isCreateNormal()) {
                a(groupPermData.getCreateNormalTip());
                return;
            } else {
                CreateGroupStepActivity.a(this, 3, b(this.c.m()));
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.c.m()));
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
        g();
        switch (i) {
            case R.id.radio_recommend /* 2131100349 */:
                this.c.a(1);
                break;
            case R.id.radio_hot /* 2131100350 */:
                this.c.a(2);
                break;
            case R.id.radio_official /* 2131100351 */:
                this.c.a(3);
                break;
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            i();
        }
    }
}
