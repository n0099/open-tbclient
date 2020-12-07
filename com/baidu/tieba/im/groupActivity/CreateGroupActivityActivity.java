package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes23.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a kvk;
    private CreateGroupActivityModel kvl;
    private boolean kvm = false;
    private c kjf = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.kvm) {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(R.string.neterror) : responseCreateGroupActivityMessage.getErrorString());
                } else if (socketResponsedMessage.getError() != 0) {
                    CreateGroupActivityActivity.this.showToast(socketResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initListener();
        this.kvl = new CreateGroupActivityModel(this);
        this.kvk = new a(this);
        if (this.kvl.cXv() != null) {
            if (bundle != null) {
                this.kvl.cXv().setGroupId(bundle.getLong("gid", 0L));
                this.kvm = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kvm) {
                    this.kvl.cXv().setActivityId(bundle.getInt("aid", 0));
                    this.kvl.cXv().setgActivityTitle(bundle.getString("name"));
                    this.kvl.cXv().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kvl.cXv().setgActivityContent(bundle.getString("content"));
                    this.kvl.cXv().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.kvl.cXv().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.kvm = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kvm) {
                    this.kvl.cXv().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.kvl.cXv().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.kvl.cXv().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kvl.cXv().setgActivityContent(getIntent().getStringExtra("content"));
                    this.kvl.cXv().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.kvk.a(this.kvl.cXv(), this.kvm);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.kvl == null) {
            this.kvl = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.kvl.cXv() != null) {
            this.kvl.cXv().setGroupId(intent.getLongExtra("gid", 0L));
            this.kvm = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.kvm) {
                this.kvl.cXv().setActivityId(intent.getIntExtra("aid", 0));
                this.kvl.cXv().setgActivityTitle(getIntent().getStringExtra("name"));
                this.kvl.cXv().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.kvl.cXv().setgActivityContent(getIntent().getStringExtra("content"));
                this.kvl.cXv().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.kvk == null) {
            this.kvk = new a(this);
        }
        this.kvk.a(this.kvl.cXv(), this.kvm);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.kvl.cXv() != null) {
            j = this.kvl.cXv().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.kvk.getTitle());
        bundle.putString("content", this.kvk.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.kvk.cXA());
        bundle.putLong("time", this.kvk.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kvk != null) {
            this.kvk.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.kjf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kvl.cancelMessage();
        this.kvk.destroy();
        MessageManager.getInstance().unRegisterListener(this.kjf);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kvk.cXy()) {
            cXu();
        } else if (view == this.kvk.cXz() && this.kvl != null && this.kvl.cXv() != null) {
            long time = this.kvk.getTime();
            if ((!this.kvm || this.kvk.cXB()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.kvl.cXv().setgActivityArea(this.kvk.cXA());
            this.kvl.cXv().setgActivityContent(this.kvk.getContent());
            this.kvl.cXv().setgActivityTime(time);
            this.kvl.cXv().setgActivityTitle(this.kvk.getTitle());
            showProgressBar();
            this.kvl.sE(this.kvm);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cXu();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cXu() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.kvm, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                CreateGroupActivityActivity.this.finish();
            }
        }, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
    }
}
