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
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.ReportGroupModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
import com.baidu.tieba.im.updategroup.UpdateGroupActivity;
/* loaded from: classes.dex */
public class GroupSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private UpdateGroupModel aOj;
    private com.baidu.tieba.im.a<Boolean> aOl;
    private boolean isAcceptNotify;
    private bp aOh = null;
    private bm aOi = null;
    private ReportGroupModel aOk = null;
    private com.baidu.adp.framework.listener.e ayJ = new be(this, 0);
    private final DialogInterface.OnClickListener aOm = new bf(this);
    private com.baidu.adp.framework.listener.e aOn = new bg(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aOh = new bp(this);
        this.aOi = new bm(this);
        this.aOj = new UpdateGroupModel(this);
        this.aOi.setUniqueId(getUniqueId());
        this.aOj.setUniqueId(getUniqueId());
        initData();
        this.aOh.setGroupName(this.aOi.getGroupName());
        this.aOh.b(this.aOm);
        this.aOh.cz(fn(this.aOi.getFlag()));
        this.aOh.HJ();
        this.aOl = new bh(this);
        this.aOi.a(this.aOl);
        HJ();
    }

    private void HJ() {
        registerListener(103103, this.aOn);
        registerListener(103102, this.ayJ);
        registerListener(103112, this.ayJ);
        registerListener(103104, this.ayJ);
        registerListener(2001141, this.ayJ);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.aOh.JJ();
                this.aOh.JO();
                this.aOh.cy(true);
                this.aOh.JM();
            } else {
                this.aOh.JL();
                this.aOh.JN();
                this.aOh.cy(false);
                this.aOh.JK();
            }
            this.aOi.d(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aOh.onChangeSkinType(i);
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
            if (view.equals(this.aOh.JB())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.aOi.getGroupId()), 1, this.aOi.getGroupName());
            } else if (view.equals(this.aOh.JC())) {
                this.aOh.JG();
            } else if (view.equals(this.aOh.JE())) {
                this.aOh.JI();
            } else if (view.equals(this.aOh.JA())) {
                finish();
            } else if (view.equals(this.aOh.JF())) {
                new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_cache_group).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bi(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new bl(this)).create().show();
            } else if (view == this.aOh.JD()) {
                this.aOh.JR();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("intent_data_group_flag", this.aOi.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.aOh.JE())) {
                this.aOh.JI();
            } else if (view.equals(this.aOh.JQ())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.aOi.cx(true);
                    if (!this.isAcceptNotify) {
                        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                        this.isAcceptNotify = true;
                        return;
                    }
                    return;
                }
                this.aOi.cx(false);
                if (this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = false;
                }
            } else if (view.equals(this.aOh.JP())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    fo(p(this.aOi.getFlag(), true));
                } else {
                    fo(p(this.aOi.getFlag(), false));
                }
            }
        }
    }

    private int p(int i, boolean z) {
        return z ? i & (-3) : i | 2;
    }

    private boolean fn(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void fo(int i) {
        if (this.aOj != null) {
            this.aOj.setGroupId(this.aOi.Jz());
            this.aOj.setFlag(i);
            this.aOj.sendMessage(5);
            showProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, int i) {
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
            if (dialogInterface == this.aOh.JH()) {
                showProgressBar();
                this.aOi.D(Long.parseLong(this.aOi.getGroupId()));
            }
            if (dialogInterface == this.aOh.JS()) {
                showProgressBar();
                this.aOi.fp(this.aOi.Jz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ayJ);
        if (this.aOi != null) {
            this.aOi.cancelMessage();
        }
        if (this.aOk != null) {
            this.aOk.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.aOn);
        if (this.aOh != null) {
            this.aOh.JT();
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
