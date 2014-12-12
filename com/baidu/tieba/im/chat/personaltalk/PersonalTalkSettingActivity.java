package com.baidu.tieba.im.chat.personaltalk;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements com.baidu.adp.widget.BdSwitchView.c, t {
    private u aTO;
    private o aTP;
    private long userId;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.aTP.KP());
        registerListener(104102, this.aTP.KP());
        registerListener(2001118, this.aTP.KQ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aTP.onDestory();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.userId);
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra("userId", 0L);
        } else {
            this.userId = bundle.getLong("userId");
        }
        this.aTP = new o(this, this, this.userId);
    }

    private void initView() {
        this.aTO = new u(this);
        this.aTO.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        this.aTO.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == w.user_info_lin) {
            if (this.aTP != null && this.aTP.KN() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.aTP.KN().name)));
            }
        } else if (id == w.remove_from_black_man) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.add_black_alert, this.aTP.KN().name)).setPositiveButton(z.alert_yes_button, new f(this)).setNegativeButton(z.alert_no_button, new g(this)).create(), getPageContext());
        } else if (id == w.st_delete_talk_history) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.remove_personal_history, this.aTP.KN().name)).setPositiveButton(z.alert_yes_button, new h(this)).setNegativeButton(z.alert_no_button, new k(this)).create(), getPageContext());
        } else if (id == w.add_to_black) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.remove_black_alert, this.aTP.KN().name)).setPositiveButton(z.alert_yes_button, new l(this)).setNegativeButton(z.alert_no_button, new m(this)).create(), getPageContext());
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.t
    public void qw() {
        closeLoadingDialog();
        if (this.aTO != null && this.aTP != null) {
            this.aTO.e(this.aTP);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean KM = this.aTP.KM();
        this.aTP.cy(switchState == BdSwitchView.SwitchState.ON);
        new n(this, switchState).execute(new Void[0]);
        if (KM != this.aTP.KM()) {
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
        }
    }
}
