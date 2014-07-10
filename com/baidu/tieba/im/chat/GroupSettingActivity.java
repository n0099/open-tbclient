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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
/* loaded from: classes.dex */
public class GroupSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.im.model.bx c;
    private com.baidu.tieba.im.a<Boolean> e;
    private bq a = null;
    private bn b = null;
    private com.baidu.tieba.im.model.bt d = null;
    private com.baidu.adp.framework.listener.b f = new bf(this, 0);
    private final DialogInterface.OnClickListener g = new bg(this);
    private com.baidu.adp.framework.listener.b h = new bh(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new bq(this);
        this.b = new bn(this);
        this.c = new com.baidu.tieba.im.model.bx();
        this.b.setUniqueId(getUniqueId());
        this.c.setUniqueId(getUniqueId());
        a();
        this.a.a(this.b.a());
        this.a.a(this.g);
        this.a.b(a(this.b.d()));
        this.a.b();
        this.e = new bi(this);
        this.b.a(this.e);
        b();
    }

    private void b() {
        registerListener(103103, this.h);
        registerListener(103102, this.f);
        registerListener(103112, this.f);
        registerListener(103104, this.f);
        registerListener(2001141, this.f);
    }

    public void a() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.a.k();
                this.a.p();
                this.a.a(true);
                this.a.n();
            } else {
                this.a.m();
                this.a.o();
                this.a.a(false);
                this.a.l();
            }
            this.b.a(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
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
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.c())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.b.b()), 1, this.b.a());
            } else if (view.equals(this.a.d())) {
                this.a.h();
            } else if (view.equals(this.a.f())) {
                this.a.j();
            } else if (view.equals(this.a.a())) {
                finish();
            } else if (view.equals(this.a.g())) {
                new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_cache_group).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bj(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new bm(this)).create().show();
            } else if (view == this.a.e()) {
                this.a.s();
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
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.f())) {
                this.a.j();
            } else if (view.equals(this.a.r())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.q())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    b(a(this.b.d(), true));
                } else {
                    b(a(this.b.d(), false));
                }
            }
        }
    }

    private int a(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean a(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void b(int i) {
        if (this.c != null) {
            this.c.a(this.b.c());
            this.c.b(i);
            this.c.c(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i < 0) {
            showToast(com.baidu.tieba.y.neterror);
        } else if (TextUtils.isEmpty(str)) {
            showToast(com.baidu.tieba.y.group_report_fail);
        } else {
            showToast(str);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            if (dialogInterface == this.a.i()) {
                showProgressBar();
                this.b.a(Long.parseLong(this.b.b()));
            }
            if (dialogInterface == this.a.t()) {
                showProgressBar();
                this.b.a(this.b.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.f);
        if (this.b != null) {
            this.b.cancelMessage();
        }
        if (this.d != null) {
            this.d.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.h);
        if (this.a != null) {
            this.a.u();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
