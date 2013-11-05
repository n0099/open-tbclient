package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.bg;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends com.baidu.tieba.j implements TextWatcher, CompoundButton.OnCheckedChangeListener {
    com.baidu.tieba.im.model.a b;

    /* renamed from: a  reason: collision with root package name */
    j f1487a = null;
    private g c = null;
    private com.baidu.tieba.q d = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1487a = new j(this);
        this.b = new com.baidu.tieba.im.model.a();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        this.f1487a.a(intExtra, intent.getIntExtra("forumid", 0));
        b();
        this.d = new com.baidu.tieba.q(this, R.style.common_alert_dialog);
        if (intExtra == 2 && com.baidu.tieba.sharedPref.b.a().a("first_create_private", true)) {
            com.baidu.tieba.sharedPref.b.a().b("first_create_private", false);
            this.d.show();
        }
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "create_g_pv", "pv", 1);
        }
    }

    private void b() {
        this.c = new g(this);
        com.baidu.tieba.im.messageCenter.f.a().a(103101, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
    }

    public static void a(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, CreateGroupStepActivity.class);
        intent.putExtra("group_type", i);
        intent.putExtra("forumid", i2);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.f1487a.b(i);
        this.d.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.G(), 1);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.G(), 1);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.f1487a.a(intent.getStringExtra(EditHeadActivity.f2157a));
                    this.f1487a.r();
                    this.f1487a.q();
                    return;
                case 21001:
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    bg.b(this);
                    return;
                case 12010:
                    bg.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            c();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f1487a.f().setEnabled(!z);
        this.f1487a.a(z);
    }

    private void c() {
        if (this.f1487a.e() == 1) {
            finish();
        } else {
            this.f1487a.t();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1487a.a()) {
            c();
        } else if (view == this.f1487a.f()) {
            int a2 = UtilHelper.a((Context) TiebaApplication.g(), 0.0f);
            if (!this.f1487a.s() || (this.f1487a.e() == 1 && !this.f1487a.j())) {
                if (this.f1487a.e() == 1) {
                    a(R.string.group_step_name_error, a2);
                } else if (this.f1487a.e() == 2) {
                    a(R.string.group_step_info_error, a2);
                }
            } else if (this.f1487a.e() == 3) {
                if (!this.f1487a.i()) {
                    a(true);
                    this.b.a(this.f1487a.k());
                    this.b.a(this.f1487a.l());
                    this.b.b(this.f1487a.m());
                    this.b.b(this.f1487a.p());
                    this.b.c(this.f1487a.n());
                    this.b.d(this.f1487a.o().getLng());
                    this.b.e(this.f1487a.o().getLat());
                    this.b.a();
                }
            } else {
                this.f1487a.u();
            }
        } else if (view == this.f1487a.g() || view == this.f1487a.h()) {
            this.f1487a.w();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1487a.y();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int length;
        if (this.f1487a.e() == 1) {
            try {
                if (com.baidu.tieba.im.d.f.a(editable) > 20 && editable.length() - 1 > 0) {
                    editable.delete(length, length + 1);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.d(e.getMessage());
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.b();
        com.baidu.tieba.im.messageCenter.f.a().a(this.c);
    }
}
