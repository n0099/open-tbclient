package com.baidu.tieba.im.chat.personaltalk;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.person.cm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c, o {
    private p a;
    private l b;
    private long c;

    public static void a(long j) {
        Intent intent = new Intent(TiebaApplication.g().b().getApplicationContext(), PersonalTalkSettingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("userId", j);
        TiebaApplication.g().b().getApplicationContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a(bundle);
        com.baidu.tieba.im.messageCenter.e.a().a(205003, this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(104102, this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(-118, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.g();
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.c);
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            this.c = getIntent().getLongExtra("userId", 0L);
        } else {
            this.c = bundle.getLong("userId");
        }
        this.b = new l(this, this, this.c);
    }

    private void b() {
        this.a = new p(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.user_info_lin) {
            if (this.b != null && this.b.b() != null) {
                cm.a(this, String.valueOf(this.c), this.b.b().getName());
            }
        } else if (id == R.id.remove_from_black_man) {
            new AlertDialog.Builder(this).setMessage(getString(R.string.add_black_alert, new Object[]{this.b.b().getName()})).setPositiveButton(R.string.alert_yes_button, new c(this)).setNegativeButton(R.string.alert_no_button, new d(this)).create().show();
        } else if (id == R.id.st_delete_talk_history) {
            new AlertDialog.Builder(this).setMessage(getString(R.string.remove_personal_history, new Object[]{this.b.b().getName()})).setPositiveButton(R.string.alert_yes_button, new e(this)).setNegativeButton(R.string.alert_no_button, new h(this)).create().show();
        } else if (id == R.id.add_to_black) {
            new AlertDialog.Builder(this).setMessage(getString(R.string.remove_black_alert, new Object[]{this.b.b().getName()})).setPositiveButton(R.string.alert_yes_button, new i(this)).setNegativeButton(R.string.alert_no_button, new j(this)).create().show();
        } else if (id == R.id.change_attention) {
            this.b.e();
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.o
    public void a() {
        closeLoadingDialog();
        if (this.a != null && this.b != null) {
            this.a.a(this.b);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        this.b.a(switchState == BdSwitchView.SwitchState.ON);
        new k(this, switchState).execute(new Void[0]);
    }
}
