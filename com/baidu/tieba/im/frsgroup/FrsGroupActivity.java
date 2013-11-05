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
import java.util.Timer;
/* loaded from: classes.dex */
public class FrsGroupActivity extends BaseFragmentActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private i f1545a;
    private com.baidu.tieba.im.model.b b;
    private com.baidu.tieba.im.messageCenter.h c = new a(this);

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
        if (this.f1545a != null) {
            this.f1545a.c();
            this.f1545a = null;
        }
        a(null, intent);
        a(intent != null ? intent.getExtras() : null);
        a(TiebaApplication.g().as());
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (g()) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseFragmentActivity, android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.d(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.b.b(bundle);
    }

    private void a(Bundle bundle) {
        this.f1545a = new i(this);
        this.f1545a.f();
        this.f1545a.c(this.b.a());
        this.f1545a.a(this.b.a());
        if (bundle != null) {
            this.f1545a.a(this.b.g());
        }
        this.f1545a.e();
    }

    public com.baidu.tieba.im.model.b b() {
        return this.b;
    }

    public i c() {
        return this.f1545a;
    }

    public void a(Bundle bundle, Intent intent) {
        this.b = new com.baidu.tieba.im.model.b();
        if (bundle == null) {
            com.baidu.tieba.im.model.b bVar = this.b;
            if (intent == null) {
                intent = getIntent();
            }
            bVar.a(intent);
        } else {
            this.b.a(bundle);
        }
        this.b.a(this);
    }

    protected void d() {
        this.b.c(this.c);
    }

    @Override // com.baidu.tieba.BaseFragmentActivity
    protected void a(int i) {
        this.f1545a.b(i);
    }

    private void a(boolean z) {
        Fragment a2 = getSupportFragmentManager().a(this.f1545a.a()[e()]);
        if (z || a2 == null) {
            getSupportFragmentManager().a().a(R.id.fragment, this.f1545a.g()[e()], this.f1545a.a()[e()]).a();
        } else {
            getSupportFragmentManager().a().c(this.f1545a.g()[e()]).a();
        }
    }

    private void f() {
        if (getSupportFragmentManager().a(this.f1545a.a()[e()]) != null) {
            getSupportFragmentManager().a().b(this.f1545a.g()[e()]).a();
        }
    }

    public int e() {
        return this.b.g() - 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1545a.h()) {
            h();
        } else if (view == this.f1545a.i()) {
            StatService.onEvent(this, "create_g_in_frsgroup", "click");
            j();
        }
    }

    private boolean g() {
        return com.baidu.tieba.im.l.b().c();
    }

    private void h() {
        finish();
    }

    private void i() {
        this.f1545a.d(true);
        this.f1545a.b(false);
        this.b.c(this.b.m());
    }

    private void j() {
        if (TextUtils.isEmpty(TiebaApplication.C())) {
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
                CreateGroupStepActivity.a(this, 3, b(this.b.m()));
                return;
            }
        }
        CreateGroupMainActivity.a(this, groupPermData.isCreateOfficial(), groupPermData.isCreateNormal(), groupPermData.getCreateOfficialTip(), groupPermData.getCreateNormalTip(), b(this.b.m()));
    }

    private int b(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void k() {
        new Timer().schedule(new b(this), 300L);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        f();
        switch (i) {
            case R.id.radio_recommend /* 2131100390 */:
                this.b.a(1);
                break;
            case R.id.radio_hot /* 2131100391 */:
                this.b.a(2);
                break;
            case R.id.radio_official /* 2131100392 */:
                this.b.a(3);
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
