package com.baidu.tieba.im.chat.personaltalk;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, p {
    private q a;
    private k b;
    private long c;

    public static void a(long j) {
        Intent intent = new Intent(TbadkApplication.m252getInst().getApp().getApplicationContext(), PersonalTalkSettingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("userId", j);
        TbadkApplication.m252getInst().getApp().getApplicationContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a(bundle);
        registerListener(MessageTypes.CMD_QUERY_USER_INFO, this.b.h());
        registerListener(MessageTypes.CMD_UPDATE_MASK_INFO, this.b.h());
        registerListener(MessageTypes.CMD_UPDATE_ATTENTION, this.b.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.g();
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
        this.b = new k(this, this, this.c);
    }

    private void b() {
        this.a = new q(this);
        this.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.r.user_info_lin) {
            if (this.b != null && this.b.b() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(this, String.valueOf(this.c), this.b.b().name)));
            }
        } else if (id == com.baidu.tieba.r.remove_from_black_man) {
            new AlertDialog.Builder(this).setMessage(getString(u.add_black_alert, new Object[]{this.b.b().name})).setPositiveButton(u.alert_yes_button, new b(this)).setNegativeButton(u.alert_no_button, new c(this)).create().show();
        } else if (id == com.baidu.tieba.r.st_delete_talk_history) {
            new AlertDialog.Builder(this).setMessage(getString(u.remove_personal_history, new Object[]{this.b.b().name})).setPositiveButton(u.alert_yes_button, new d(this)).setNegativeButton(u.alert_no_button, new g(this)).create().show();
        } else if (id == com.baidu.tieba.r.add_to_black) {
            new AlertDialog.Builder(this).setMessage(getString(u.remove_black_alert, new Object[]{this.b.b().name})).setPositiveButton(u.alert_yes_button, new h(this)).setNegativeButton(u.alert_no_button, new i(this)).create().show();
        } else if (id == com.baidu.tieba.r.change_attention) {
            this.b.e();
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.p
    public void a() {
        closeLoadingDialog();
        if (this.a != null && this.b != null) {
            this.a.a(this.b);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        this.b.a(switchState == BdSwitchView.SwitchState.ON);
        new j(this, switchState).execute(new Void[0]);
    }
}
