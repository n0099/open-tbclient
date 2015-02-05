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
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements com.baidu.adp.widget.BdSwitchView.c, w {
    private x aVg;
    private r aVh;
    private com.baidu.adp.framework.listener.e aVi = new f(this, 104102);
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
        registerListener(205003, this.aVh.Lf());
        registerListener(104102, this.aVh.Lf());
        registerListener(2001118, this.aVh.Lg());
        registerListener(this.aVi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aVh.onDestory();
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
        this.aVh = new r(this, this, this.userId);
    }

    private void initView() {
        this.aVg = new x(this);
        this.aVg.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        this.aVg.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.w.user_info_lin) {
            if (this.aVh != null && this.aVh.Ld() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.aVh.Ld().name)));
            }
        } else if (id == com.baidu.tieba.w.remove_from_black_man) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.add_black_alert, this.aVh.Ld().name)).setPositiveButton(z.alert_yes_button, new h(this)).setNegativeButton(z.alert_no_button, new i(this)).create(), getPageContext());
        } else if (id == com.baidu.tieba.w.st_delete_talk_history) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.remove_personal_history, this.aVh.Ld().name)).setPositiveButton(z.alert_yes_button, new j(this)).setNegativeButton(z.alert_no_button, new m(this)).create(), getPageContext());
        } else if (id == com.baidu.tieba.w.add_to_black) {
            com.baidu.adp.lib.g.k.a(new AlertDialog.Builder(getPageContext().getContext()).setMessage(getPageContext().getContext().getString(z.remove_black_alert, this.aVh.Ld().name)).setPositiveButton(z.alert_yes_button, new n(this)).setNegativeButton(z.alert_no_button, new o(this)).create(), getPageContext());
        }
    }

    @Override // com.baidu.tieba.im.chat.personaltalk.w
    public void qB() {
        closeLoadingDialog();
        if (this.aVg != null && this.aVh != null) {
            this.aVg.e(this.aVh);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (!TbadkCoreApplication.m255getInst().isMsgRemindOn() || !TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.by(z.error_open_personal_single_alloff);
                aVar.c(getResources().getString(z.signallforum_signnow), new p(this, aVar));
                aVar.b(getPageContext());
                aVar.nQ();
                d(false, z);
                return;
            }
            showLoadingDialog(null);
            this.aVh.cD(z);
            return;
        }
        showLoadingDialog(null);
        this.aVh.cD(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, boolean z2) {
        if (z) {
            boolean Lc = this.aVh.Lc();
            this.aVh.cC(z2);
            new q(this, z2).execute(new Void[0]);
            if (Lc != this.aVh.Lc()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.i.ej().postDelayed(new g(this, z2), 500L);
    }
}
