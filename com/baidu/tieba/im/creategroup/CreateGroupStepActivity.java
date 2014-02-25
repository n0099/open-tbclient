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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ai;
import com.baidu.tieba.im.data.GroupAddressInfoData;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.util.al;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.write.bz;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class CreateGroupStepActivity extends com.baidu.tieba.f implements TextWatcher, CompoundButton.OnCheckedChangeListener, al {
    com.baidu.tieba.im.model.a b;
    n a = null;
    private int c = 1014;
    private j d = null;
    private GroupAddressInfoData e = new GroupAddressInfoData();
    private int f = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i = 3;
        super.onCreate(bundle);
        this.b = new com.baidu.tieba.im.model.a();
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
        cb.a(this, "create_g_pv", "pv", 1, new Object[0]);
    }

    private void c() {
        this.d = new j(this);
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
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22001) {
            this.a.m();
            this.a.J();
        } else if (i2 == -1) {
            switch (i) {
                case 12001:
                    EditHeadActivity.a(this, 12001, 12010, null, TiebaApplication.E(), 1);
                    return;
                case 12002:
                    if (intent != null) {
                        EditHeadActivity.a(this, 12002, 12009, intent.getData(), TiebaApplication.E(), 1);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.a.f(intent.getStringExtra(EditHeadActivity.a));
                    this.a.H();
                    this.a.G();
                    return;
                case 21001:
                    this.a.d(intent.getStringExtra("Selected_Business"));
                    this.a.a(intent.getBooleanExtra("Hidden_Address_Flag", false));
                    this.f = this.e.getAddressList().indexOf(this.a.o());
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    bz.b(this);
                    return;
                case 12010:
                    bz.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
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
            this.a.M();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.a.f()) {
            d();
        } else if (view == this.a.h()) {
            int a = BdUtilHelper.a((Context) TiebaApplication.g().b(), 0.0f);
            if (!this.a.L()) {
                String F = this.a.F();
                if (!TextUtils.isEmpty(F)) {
                    showToast(F, a);
                }
            } else if (this.a.E()) {
                if (!this.a.l()) {
                    a(true);
                    this.b.a(this.a.v());
                    this.b.a(this.a.w());
                    this.b.b(this.a.x());
                    this.b.b(this.a.z());
                    this.b.c(this.a.y());
                    this.b.d(this.a.n());
                    this.b.e(this.a.o());
                    this.b.f(this.a.a());
                    this.b.g(this.a.e());
                    this.b.d(this.c);
                    this.b.c(this.a.p() ? 1 : 0);
                    this.b.a();
                }
            } else {
                this.a.N();
            }
        } else if (this.a.i() == view) {
            this.a.N();
        } else if (view == this.a.j() || view == this.a.k()) {
            this.a.P();
        } else if (view == this.a.s()) {
            ai.a(this, "edit_place_at_creatgroup");
            switch (this.a.t()) {
                case 0:
                    GroupAddressEditActivity.a(this, 21001, this.e.getAddressList(), this.f, false);
                    return;
                case 1:
                    startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 22001);
                    return;
                case 2:
                    this.a.m();
                    this.a.J();
                    return;
                case 3:
                case 4:
                default:
                    return;
            }
        } else if (view == this.a.u()) {
            this.a.I();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.R();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.b();
        com.baidu.tieba.im.messageCenter.e.a().a(this.d);
        this.a.K();
    }

    @Override // com.baidu.tieba.util.al
    public void a(String str, List<String> list, double d, double d2) {
        this.a.b(String.valueOf(d));
        this.a.a(String.valueOf(d2));
        this.a.c(str);
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                this.e.addAddress(str2);
            }
            this.a.d(list.get(0));
            return;
        }
        this.a.e(str);
    }

    @Override // com.baidu.tieba.util.al
    public void a() {
        this.a.r();
    }

    @Override // com.baidu.tieba.util.al
    public void b() {
        this.a.q();
    }
}
