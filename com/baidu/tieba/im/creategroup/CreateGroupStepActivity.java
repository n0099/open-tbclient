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
import com.baidu.tieba.ap;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.write.bd;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends com.baidu.tieba.j implements TextWatcher, CompoundButton.OnCheckedChangeListener, ad {
    com.baidu.tieba.im.model.a b;

    /* renamed from: a  reason: collision with root package name */
    l f1614a = null;
    private int c = 1014;
    private i d = null;
    private com.baidu.tieba.t e = null;
    private GroupAddressInfoData f = new GroupAddressInfoData();
    private int g = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1614a = new l(this);
        this.b = new com.baidu.tieba.im.model.a();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.c = intent.getIntExtra("Intent_Source_From", 1014);
        this.f1614a.a(intExtra, intExtra2);
        c();
        this.e = new com.baidu.tieba.t(this, R.style.common_alert_dialog);
        if (intExtra == 2 && com.baidu.tieba.sharedPref.b.a().a("first_create_private", true)) {
            com.baidu.tieba.sharedPref.b.a().b("first_create_private", false);
            this.e.show();
        }
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this, "create_g_pv", "pv", 1);
        }
    }

    private void c() {
        this.d = new i(this);
        com.baidu.tieba.im.messageCenter.e.a().a(103101, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    public static void a(Activity activity, int i, int i2, int i3) {
        Intent intent = new Intent(activity, CreateGroupStepActivity.class);
        intent.putExtra("group_type", i);
        intent.putExtra("forumid", i2);
        intent.putExtra("Intent_Source_From", i3);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f1614a.b(i);
        this.e.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.f1614a.l();
            this.f1614a.D();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.F(), 1);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.F(), 1);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.f1614a.f(intent.getStringExtra(EditHeadActivity.f2291a));
                    this.f1614a.B();
                    this.f1614a.A();
                    return;
                case 21001:
                    this.f1614a.d(intent.getStringExtra("Selected_Business"));
                    this.f1614a.a(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.g = this.f.getAddressList().indexOf(this.f1614a.n());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    bd.b(this);
                    return;
                case 12010:
                    bd.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            d();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f1614a.h().setEnabled(!z);
        this.f1614a.b(z);
    }

    private void d() {
        if (this.f1614a.g() == 1) {
            finish();
        } else {
            this.f1614a.G();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.f1614a.f()) {
            d();
        } else if (view == this.f1614a.h()) {
            int a2 = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.h(), 0.0f);
            if (!this.f1614a.F() || (this.f1614a.g() == 1 && !this.f1614a.u())) {
                if (this.f1614a.g() == 1) {
                    showToast(R.string.group_step_name_error, a2);
                } else if (this.f1614a.g() == 2) {
                    showToast(R.string.group_step_info_error, a2);
                }
            } else if (this.f1614a.g() == 4) {
                if (!this.f1614a.k()) {
                    a(true);
                    this.b.a(this.f1614a.v());
                    this.b.a(this.f1614a.w());
                    this.b.b(this.f1614a.x());
                    this.b.b(this.f1614a.z());
                    this.b.c(this.f1614a.y());
                    this.b.d(this.f1614a.m());
                    this.b.e(this.f1614a.n());
                    this.b.f(this.f1614a.a());
                    this.b.g(this.f1614a.e());
                    this.b.d(this.c);
                    this.b.c(this.f1614a.o() ? 1 : 0);
                    this.b.a();
                }
            } else {
                this.f1614a.H();
            }
        } else if (view == this.f1614a.i() || view == this.f1614a.j()) {
            this.f1614a.J();
        } else if (view == this.f1614a.r()) {
            ap.a(this, "edit_place_at_creatgroup");
            switch (this.f1614a.s()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.f.getAddressList(), this.g, false);
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.f1614a.l();
                    this.f1614a.D();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.f1614a.t()) {
            this.f1614a.C();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1614a.L();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.b();
        com.baidu.tieba.im.messageCenter.e.a().a(this.d);
        this.f1614a.E();
    }

    @Override // com.baidu.tieba.util.ad
    public void a(String str, List<String> list, double d, double d2) {
        this.f1614a.b(String.valueOf(d));
        this.f1614a.a(String.valueOf(d2));
        this.f1614a.c(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.f.addAddress(str2);
            }
            this.f1614a.d(list.get(0));
            return;
        }
        this.f1614a.e(str);
    }

    @Override // com.baidu.tieba.util.ad
    public void a() {
        this.f1614a.q();
    }

    @Override // com.baidu.tieba.util.ad
    public void b() {
        this.f1614a.p();
    }
}
