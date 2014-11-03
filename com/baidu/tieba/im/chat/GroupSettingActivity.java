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
    private UpdateGroupModel aOx;
    private com.baidu.tieba.im.a<Boolean> aOz;
    private boolean isAcceptNotify;
    private bp aOv = null;
    private bm aOw = null;
    private ReportGroupModel aOy = null;
    private com.baidu.adp.framework.listener.e ayS = new be(this, 0);
    private final DialogInterface.OnClickListener aOA = new bf(this);
    private com.baidu.adp.framework.listener.e aOB = new bg(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aOv = new bp(this);
        this.aOw = new bm(this);
        this.aOx = new UpdateGroupModel(this);
        this.aOw.setUniqueId(getUniqueId());
        this.aOx.setUniqueId(getUniqueId());
        initData();
        this.aOv.setGroupName(this.aOw.getGroupName());
        this.aOv.b(this.aOA);
        this.aOv.cz(fn(this.aOw.getFlag()));
        this.aOv.HN();
        this.aOz = new bh(this);
        this.aOw.a(this.aOz);
        HN();
    }

    private void HN() {
        registerListener(103103, this.aOB);
        registerListener(103102, this.ayS);
        registerListener(103112, this.ayS);
        registerListener(103104, this.ayS);
        registerListener(2001141, this.ayS);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_data_group_name");
            String stringExtra2 = intent.getStringExtra("intent_data_group_id");
            int intExtra = intent.getIntExtra("intent_data_group_flag", 0);
            if (intent.getBooleanExtra("intent_data_is_group_master", false)) {
                this.aOv.JN();
                this.aOv.JS();
                this.aOv.cy(true);
                this.aOv.JQ();
            } else {
                this.aOv.JP();
                this.aOv.JR();
                this.aOv.cy(false);
                this.aOv.JO();
            }
            this.aOw.d(stringExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aOv.onChangeSkinType(i);
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
            if (view.equals(this.aOv.JF())) {
                UpdateGroupActivity.a(this, 1, Integer.parseInt(this.aOw.getGroupId()), 1, this.aOw.getGroupName());
            } else if (view.equals(this.aOv.JG())) {
                this.aOv.JK();
            } else if (view.equals(this.aOv.JI())) {
                this.aOv.JM();
            } else if (view.equals(this.aOv.JE())) {
                finish();
            } else if (view.equals(this.aOv.JJ())) {
                new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_cache_group).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new bi(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new bl(this)).create().show();
            } else if (view == this.aOv.JH()) {
                this.aOv.JV();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("intent_data_group_flag", this.aOw.getFlag());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.aOv.JI())) {
                this.aOv.JM();
            } else if (view.equals(this.aOv.JU())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.aOw.cx(true);
                    if (!this.isAcceptNotify) {
                        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                        this.isAcceptNotify = true;
                        return;
                    }
                    return;
                }
                this.aOw.cx(false);
                if (this.isAcceptNotify) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(1));
                    this.isAcceptNotify = false;
                }
            } else if (view.equals(this.aOv.JT())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    fo(p(this.aOw.getFlag(), true));
                } else {
                    fo(p(this.aOw.getFlag(), false));
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
        if (this.aOx != null) {
            this.aOx.setGroupId(this.aOw.JD());
            this.aOx.setFlag(i);
            this.aOx.sendMessage(5);
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
            if (dialogInterface == this.aOv.JL()) {
                showProgressBar();
                this.aOw.D(Long.parseLong(this.aOw.getGroupId()));
            }
            if (dialogInterface == this.aOv.JW()) {
                showProgressBar();
                this.aOw.fp(this.aOw.JD());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ayS);
        if (this.aOw != null) {
            this.aOw.cancelMessage();
        }
        if (this.aOy != null) {
            this.aOy.cancelMessage();
        }
        MessageManager.getInstance().unRegisterListener(this.aOB);
        if (this.aOv != null) {
            this.aOv.JX();
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
