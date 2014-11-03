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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, s {
    private t aSC;
    private n aSD;
    private long userId;

    public static void L(long j) {
        Intent intent = new Intent(TbadkApplication.m251getInst().getApp().getApplicationContext(), PersonalTalkSettingActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("userId", j);
        TbadkApplication.m251getInst().getApp().getApplicationContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nu();
        d(bundle);
        registerListener(205003, this.aSD.KN());
        registerListener(104102, this.aSD.KN());
        registerListener(2001118, this.aSD.KO());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aSD.onDestory();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.userId);
    }

    private void d(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra("userId", 0L);
        } else {
            this.userId = bundle.getLong("userId");
        }
        this.aSD = new n(this, this, this.userId);
    }

    private void nu() {
        this.aSC = new t(this);
        this.aSC.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        this.aSC.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == v.user_info_lin) {
            if (this.aSD != null && this.aSD.KL() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(this.userId), this.aSD.KL().name)));
            }
        } else if (id == v.remove_from_black_man) {
            com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this).setMessage(getString(y.add_black_alert, new Object[]{this.aSD.KL().name})).setPositiveButton(y.alert_yes_button, new e(this)).setNegativeButton(y.alert_no_button, new f(this)).create(), this);
        } else if (id == v.st_delete_talk_history) {
            com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this).setMessage(getString(y.remove_personal_history, new Object[]{this.aSD.KL().name})).setPositiveButton(y.alert_yes_button, new g(this)).setNegativeButton(y.alert_no_button, new j(this)).create(), this);
        } else if (id == v.add_to_black) {
            com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this).setMessage(getString(y.remove_black_alert, new Object[]{this.aSD.KL().name})).setPositiveButton(y.alert_yes_button, new k(this)).setNegativeButton(y.alert_no_button, new l(this)).create(), this);
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.s
    public void nx() {
        closeLoadingDialog();
        if (this.aSC != null && this.aSD != null) {
            this.aSC.e(this.aSD);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean KK = this.aSD.KK();
        this.aSD.cL(switchState == BdSwitchView.SwitchState.ON);
        new m(this, switchState).execute(new Void[0]);
        if (KK != this.aSD.KK()) {
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
        }
    }
}
