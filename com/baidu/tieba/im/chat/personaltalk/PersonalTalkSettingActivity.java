package com.baidu.tieba.im.chat.personaltalk;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ag;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c, p {
    private q a;
    private k b;
    private long c;

    public static void a(long j) {
        Intent intent = new Intent(TbadkApplication.j().b().getApplicationContext(), PersonalTalkSettingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("userId", j);
        TbadkApplication.j().b().getApplicationContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new q(this);
        q qVar = this.a;
        if (qVar.b != null) {
            qVar.b.setSwitchStateChangeListener(this);
        }
        if (bundle == null) {
            this.c = getIntent().getLongExtra("userId", 0L);
        } else {
            this.c = bundle.getLong("userId");
        }
        this.b = new k(this, this, this.c);
        registerListener(205003, this.b.h());
        registerListener(104102, this.b.h());
        registerListener(2001118, this.b.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.g();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.im.h.user_info_lin) {
            if (this.b != null && this.b.b() != null) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new ag(this, String.valueOf(this.c), this.b.b().getName())));
            }
        } else if (id == com.baidu.tieba.im.h.remove_from_black_man) {
            new AlertDialog.Builder(this).setMessage(getString(com.baidu.tieba.im.j.add_black_alert, new Object[]{this.b.b().getName()})).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, new b(this)).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new c(this)).create().show();
        } else if (id == com.baidu.tieba.im.h.st_delete_talk_history) {
            new AlertDialog.Builder(this).setMessage(getString(com.baidu.tieba.im.j.remove_personal_history, new Object[]{this.b.b().getName()})).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, new d(this)).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new g(this)).create().show();
        } else if (id == com.baidu.tieba.im.h.add_to_black) {
            new AlertDialog.Builder(this).setMessage(getString(com.baidu.tieba.im.j.remove_black_alert, new Object[]{this.b.b().getName()})).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, new h(this)).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new i(this)).create().show();
        } else if (id == com.baidu.tieba.im.h.change_attention) {
            this.b.e();
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.p
    public final void a() {
        String portrait;
        closeLoadingDialog();
        if (this.a != null && this.b != null) {
            q qVar = this.a;
            k kVar = this.b;
            if (kVar != null) {
                boolean d = kVar.d();
                int sex = kVar.b().getSex();
                if (d) {
                    qVar.a.setSex(sex);
                    qVar.a.setVisibility(0);
                    qVar.b.setVisibility(8);
                } else {
                    qVar.b.setVisibility(0);
                    qVar.a.setVisibility(8);
                }
                qVar.b.b(kVar.c());
                qVar.b.a(kVar.a());
                qVar.a(kVar.b());
                if (kVar == null || kVar.b() == null || (portrait = kVar.b().getPortrait()) == null || portrait.length() <= 0) {
                    return;
                }
                kVar.f().c(portrait, new r(qVar));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        this.b.a(switchState == BdSwitchView.SwitchState.ON);
        new j(this, switchState).execute(new Void[0]);
    }
}
