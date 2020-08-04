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
/* loaded from: classes17.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a jcc;
    private CreateGroupActivityModel jcd;
    private boolean jce = false;
    private c iPO = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jce) {
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
        this.jcd = new CreateGroupActivityModel(this);
        this.jcc = new a(this);
        if (this.jcd.cuO() != null) {
            if (bundle != null) {
                this.jcd.cuO().setGroupId(bundle.getLong("gid", 0L));
                this.jce = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jce) {
                    this.jcd.cuO().setActivityId(bundle.getInt("aid", 0));
                    this.jcd.cuO().setgActivityTitle(bundle.getString("name"));
                    this.jcd.cuO().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jcd.cuO().setgActivityContent(bundle.getString("content"));
                    this.jcd.cuO().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jcd.cuO().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jce = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jce) {
                    this.jcd.cuO().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jcd.cuO().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jcd.cuO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jcd.cuO().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jcd.cuO().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jcc.a(this.jcd.cuO(), this.jce);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jcd == null) {
            this.jcd = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jcd.cuO() != null) {
            this.jcd.cuO().setGroupId(intent.getLongExtra("gid", 0L));
            this.jce = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jce) {
                this.jcd.cuO().setActivityId(intent.getIntExtra("aid", 0));
                this.jcd.cuO().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jcd.cuO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jcd.cuO().setgActivityContent(getIntent().getStringExtra("content"));
                this.jcd.cuO().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jcc == null) {
            this.jcc = new a(this);
        }
        this.jcc.a(this.jcd.cuO(), this.jce);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jcd.cuO() != null) {
            j = this.jcd.cuO().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jcc.getTitle());
        bundle.putString("content", this.jcc.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jcc.cuT());
        bundle.putLong("time", this.jcc.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jcc != null) {
            this.jcc.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.iPO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jcd.cancelMessage();
        this.jcc.destroy();
        MessageManager.getInstance().unRegisterListener(this.iPO);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jcc.cuR()) {
            cuN();
        } else if (view == this.jcc.cuS() && this.jcd != null && this.jcd.cuO() != null) {
            long time = this.jcc.getTime();
            if ((!this.jce || this.jcc.cuU()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jcd.cuO().setgActivityArea(this.jcc.cuT());
            this.jcd.cuO().setgActivityContent(this.jcc.getContent());
            this.jcd.cuO().setgActivityTime(time);
            this.jcd.cuO().setgActivityTitle(this.jcc.getTitle());
            showProgressBar();
            this.jcd.qc(this.jce);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cuN();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cuN() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jce, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
