package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
/* loaded from: classes.dex */
public class GroupSettingActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.im.model.br c;
    private com.baidu.tieba.im.a<Boolean> e;
    private bv a = null;
    private bs b = null;
    private com.baidu.tieba.im.model.bn d = null;
    private com.baidu.adp.framework.c.g f = new bk(this, 0);
    private final DialogInterface.OnClickListener g = new bl(this);
    private com.baidu.adp.framework.c.g h = new bm(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new bv(this);
        this.b = new bs(this);
        this.c = new com.baidu.tieba.im.model.br();
        this.b.setUniqueId(getUniqueId());
        this.c.setUniqueId(getUniqueId());
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.a.m();
                this.a.r();
                this.a.a(true);
                this.a.p();
            } else {
                this.a.o();
                this.a.q();
                this.a.a(false);
                this.a.n();
            }
            bs bsVar = this.b;
            bsVar.b(stringExtra2);
            bsVar.a(stringExtra);
            bsVar.b(intExtra);
        }
        this.a.a(this.b.a());
        this.a.a(this.g);
        this.a.b(((this.b.d() & 2) >> 1) != 1);
        this.a.d();
        this.e = new bn(this);
        com.baidu.tieba.im.s.a(new bu(this.b), this.e);
        registerListener(103103, this.h);
        registerListener(103102, this.f);
        registerListener(103112, this.f);
        registerListener(103104, this.f);
        registerListener(2001141, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    public static void a(Activity activity, int i, String str, String str2, boolean z, int i2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(activity, GroupSettingActivity.class);
            intent.putExtra("intent_data_group_name", str);
            intent.putExtra("intent_data_group_id", str2);
            intent.putExtra("intent_data_is_group_master", z);
            intent.putExtra("intent_data_group_flag", i2);
            activity.startActivityForResult(intent, 4);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.e())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.b.b()), 1, this.b.a());
            } else if (view.equals(this.a.f())) {
                this.a.j();
            } else if (view.equals(this.a.h())) {
                this.a.l();
            } else if (view.equals(this.a.a())) {
                finish();
            } else if (view.equals(this.a.i())) {
                new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.im.j.alert_clear_cache_group).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, new bo(this)).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new br(this)).create().show();
            } else if (view == this.a.g()) {
                this.a.u();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("intent_data_group_flag", this.b.d());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.h())) {
                this.a.l();
            } else if (view.equals(this.a.t())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.s())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    a(a(this.b.d(), true));
                } else {
                    a(a(this.b.d(), false));
                }
            }
        }
    }

    private static int a(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private void a(int i) {
        if (this.c != null) {
            this.c.a(this.b.c());
            this.c.b(i);
            this.c.c(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupSettingActivity groupSettingActivity, String str, int i) {
        if (i < 0) {
            groupSettingActivity.showToast(com.baidu.tieba.im.j.neterror);
        } else if (TextUtils.isEmpty(str)) {
            groupSettingActivity.showToast(com.baidu.tieba.im.j.group_report_fail);
        } else {
            groupSettingActivity.showToast(str);
        }
    }

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            if (dialogInterface == this.a.k()) {
                showProgressBar();
                this.b.a(Long.parseLong(this.b.b()));
            }
            if (dialogInterface == this.a.v()) {
                showProgressBar();
                this.b.a(this.b.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.f);
        if (this.b != null) {
            this.b.cancelMessage();
        }
        if (this.d != null) {
            this.d.cancelMessage();
        }
        com.baidu.adp.framework.c.a().b(this.h);
        if (this.a != null) {
            this.a.w();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
