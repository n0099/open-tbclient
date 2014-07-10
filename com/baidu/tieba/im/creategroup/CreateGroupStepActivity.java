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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends BaseActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener, com.baidu.tieba.im.e.h {
    com.baidu.tieba.im.model.a b;
    n a = null;
    private int c = 1014;
    private GroupAddressInfoData d = new GroupAddressInfoData();
    private int e = 0;
    private com.baidu.adp.framework.listener.b f = new j(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 3;
        super.onCreate(bundle);
        this.b = new com.baidu.tieba.im.model.a();
        this.b.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("group_type", 3);
        int intExtra2 = intent.getIntExtra("forumid", 0);
        this.c = intent.getIntExtra("Intent_Source_From", 1014);
        if (this.c == 1011 || this.c == 1012) {
            i = 1;
        } else if (intExtra == 3) {
            i = 2;
        }
        this.a = new n(this, i, intent.getIntExtra("num_create_group_private", 0), intent.getIntExtra("num_create_group_normal", 0), intent.getIntExtra("num_create_group_offical", 0));
        this.a.a(intExtra, intExtra2);
        c();
        TiebaStatic.eventStat(this, "create_g_pv", "pv", 1, new Object[0]);
    }

    private void c() {
        registerListener(103101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        }
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        Intent intent = new Intent(context, CreateGroupStepActivity.class);
        intent.putExtra("group_type", i);
        intent.putExtra("forumid", i2);
        intent.putExtra("Intent_Source_From", i3);
        intent.putExtra("num_create_group_normal", i4);
        intent.putExtra("num_create_group_private", i6);
        intent.putExtra("num_create_group_offical", i5);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.a.j();
            this.a.G();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj(), 1);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 1);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.a.f(intent.getStringExtra(EditHeadActivity.a));
                    this.a.E();
                    this.a.D();
                    return;
                case 21001:
                    this.a.d(intent.getStringExtra("Selected_Business"));
                    this.a.a(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.e = this.d.getAddressList().indexOf(this.a.l());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    bj.b(this);
                    return;
                case 12010:
                    bj.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            d();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.a.e().setEnabled(!z);
        this.a.b(z);
    }

    private void d() {
        if (this.a.d() == 1) {
            finish();
        } else {
            this.a.J();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.c()) {
            d();
        } else if (view == this.a.e()) {
            int a = com.baidu.adp.lib.util.j.a((Context) TbadkApplication.m252getInst().getApp(), 0.0f);
            if (!this.a.I()) {
                String C = this.a.C();
                if (!TextUtils.isEmpty(C)) {
                    showToast(C, a);
                }
            } else if (this.a.B()) {
                if (!this.a.i()) {
                    a(true);
                    this.b.a(this.a.s());
                    this.b.a(this.a.t());
                    this.b.b(this.a.u());
                    this.b.b(this.a.w());
                    this.b.c(this.a.v());
                    this.b.d(this.a.k());
                    this.b.e(this.a.l());
                    this.b.f(this.a.a());
                    this.b.g(this.a.b());
                    this.b.d(this.c);
                    this.b.c(this.a.m() ? 1 : 0);
                    this.b.a();
                }
            } else {
                this.a.K();
            }
        } else if (this.a.f() == view) {
            this.a.K();
        } else if (view == this.a.g() || view == this.a.h()) {
            this.a.M();
        } else if (view == this.a.p()) {
            com.baidu.tbadk.core.f.a(this, "edit_place_at_creatgroup");
            switch (this.a.q()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.d.getAddressList(), this.e, this.a.m());
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.a.j();
                    this.a.G();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.a.r()) {
            this.a.F();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.O();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.cancelMessage();
        this.a.H();
    }

    @Override // com.baidu.tieba.im.e.h
    public void a(String str, List<String> list, double d, double d2) {
        this.a.b(String.valueOf(d));
        this.a.a(String.valueOf(d2));
        this.a.c(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.d.addAddress(str2);
            }
            this.a.d(list.get(0));
            return;
        }
        this.a.e(str);
    }

    @Override // com.baidu.tieba.im.e.h
    public void a() {
        this.a.o();
    }

    @Override // com.baidu.tieba.im.e.h
    public void b() {
        this.a.n();
    }
}
