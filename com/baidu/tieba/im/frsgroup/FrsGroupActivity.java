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
    private com.baidu.tieba.im.model.c c;
    private com.baidu.tieba.im.messageCenter.g d = new a(this);

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
        a(bundle, null);
        d();
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
        a(null, intent);
        a(intent != null ? intent.getExtras() : null);
        a(TiebaApplication.h().an());
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
            this.b.b(this.c.g());
        }
        this.b.a(e());
        this.b.e();
    }

    public com.baidu.tieba.im.model.c b() {
        return this.c;
    }

    public g c() {
        return this.b;
    }

    public void a(Bundle bundle, Intent intent) {
        this.c = new com.baidu.tieba.im.model.c();
        if (bundle == null) {
            com.baidu.tieba.im.model.c cVar = this.c;
            if (intent == null) {
                intent = getIntent();
            }
            cVar.a(intent);
        } else {
            this.c.a(bundle);
        }
        this.c.a(this);
    }

    protected void d() {
        this.c.c(this.d);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.b.c(i);
    }

    private void a(boolean z) {
        Fragment a = getSupportFragmentManager().a(this.b.a()[e()]);
        if (z || a == null) {
            getSupportFragmentManager().a().a(R.id.fragment, this.b.g()[e()], this.b.a()[e()]).a();
        } else {
            getSupportFragmentManager().a().c(this.b.g()[e()]).a();
        }
    }

    private void f() {
        if (getSupportFragmentManager().a(this.b.a()[e()]) != null) {
            getSupportFragmentManager().a().b(this.b.g()[e()]).a();
        }
    }

    public int e() {
        return this.c.g() - 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.h()) {
            g();
        } else if (view == this.b.i()) {
            StatService.onEvent(this, "create_g_in_frsgroup", "click");
            i();
        }
    }

    private void g() {
        finish();
    }

    private void h() {
        this.b.d(true);
        this.c.c(this.c.m());
    }

    private void i() {
        if (TextUtils.isEmpty(TiebaApplication.B())) {
            LoginActivity.a((Activity) this, "", true, 0);
        } else {
            h();
        }
    }

    public void a(GroupPermData groupPermData) {
        if (!groupPermData.isManager()) {
            if (!groupPermData.isCreateNormal()) {
                a(groupPermData.getCreateNormalTip());
                return;
            } else {
                CreateGroupStepActivity.a(this, 3, b(this.c.m()), 1013);
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
        f();
        switch (i) {
            case R.id.radio_recommend /* 2131100400 */:
                this.c.a(1);
                break;
            case R.id.radio_hot /* 2131100402 */:
                this.c.a(2);
                break;
            case R.id.radio_official /* 2131100404 */:
                this.c.a(3);
                break;
        }
        this.b.a(e());
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            h();
        }
    }
}
