package com.baidu.tieba.im.creategroup;

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
import com.baidu.tieba.ao;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.util.ae;
import com.baidu.tieba.write.bd;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends com.baidu.tieba.j implements TextWatcher, CompoundButton.OnCheckedChangeListener, ae {
    com.baidu.tieba.im.model.a b;
    l a = null;
    private int c = 1014;
    private i d = null;
    private com.baidu.tieba.s e = null;
    private GroupAddressInfoData f = new GroupAddressInfoData();
    private int g = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new l(this);
        this.b = new com.baidu.tieba.im.model.a();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.c = intent.getIntExtra("Intent_Source_From", 1014);
        this.a.a(intExtra, intExtra2);
        c();
        this.e = new com.baidu.tieba.s(this, R.style.common_alert_dialog);
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

    public static void a(Context context, int i, int i2, int i3) {
        Intent intent = new Intent(context, CreateGroupStepActivity.class);
        intent.putExtra("group_type", i);
        intent.putExtra("forumid", i2);
        intent.putExtra("Intent_Source_From", i3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b(i);
        this.e.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.a.l();
            this.a.D();
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
                    this.a.f(intent.getStringExtra(EditHeadActivity.a));
                    this.a.B();
                    this.a.A();
                    return;
                case 21001:
                    this.a.d(intent.getStringExtra("Selected_Business"));
                    this.a.a(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.g = this.f.getAddressList().indexOf(this.a.n());
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
        this.a.h().setEnabled(!z);
        this.a.b(z);
    }

    private void d() {
        if (this.a.g() == 1) {
            finish();
        } else {
            this.a.G();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.f()) {
            d();
        } else if (view == this.a.h()) {
            int a = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.h(), 0.0f);
            if (!this.a.F() || (this.a.g() == 1 && !this.a.u())) {
                if (this.a.g() == 1) {
                    showToast(R.string.group_step_name_error, a);
                } else if (this.a.g() == 2) {
                    showToast(R.string.group_step_info_error, a);
                }
            } else if (this.a.g() == 4) {
                if (!this.a.k()) {
                    a(true);
                    this.b.a(this.a.v());
                    this.b.a(this.a.w());
                    this.b.b(this.a.x());
                    this.b.b(this.a.z());
                    this.b.c(this.a.y());
                    this.b.d(this.a.m());
                    this.b.e(this.a.n());
                    this.b.f(this.a.a());
                    this.b.g(this.a.e());
                    this.b.d(this.c);
                    this.b.c(this.a.o() ? 1 : 0);
                    this.b.a();
                }
            } else {
                this.a.H();
            }
        } else if (view == this.a.i() || view == this.a.j()) {
            this.a.J();
        } else if (view == this.a.r()) {
            ao.a(this, "edit_place_at_creatgroup");
            switch (this.a.s()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.f.getAddressList(), this.g, false);
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.a.l();
                    this.a.D();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.a.t()) {
            this.a.C();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.L();
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
        this.a.E();
    }

    @Override // com.baidu.tieba.util.ae
    public void a(String str, List<String> list, double d, double d2) {
        this.a.b(String.valueOf(d));
        this.a.a(String.valueOf(d2));
        this.a.c(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.f.addAddress(str2);
            }
            this.a.d(list.get(0));
            return;
        }
        this.a.e(str);
    }

    @Override // com.baidu.tieba.util.ae
    public void a() {
        this.a.q();
    }

    @Override // com.baidu.tieba.util.ae
    public void b() {
        this.a.p();
    }
}
