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
/* loaded from: classes22.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a jzK;
    private CreateGroupActivityModel jzL;
    private boolean jzM = false;
    private c jnx = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jzM) {
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
        this.jzL = new CreateGroupActivityModel(this);
        this.jzK = new a(this);
        if (this.jzL.cJm() != null) {
            if (bundle != null) {
                this.jzL.cJm().setGroupId(bundle.getLong("gid", 0L));
                this.jzM = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jzM) {
                    this.jzL.cJm().setActivityId(bundle.getInt("aid", 0));
                    this.jzL.cJm().setgActivityTitle(bundle.getString("name"));
                    this.jzL.cJm().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jzL.cJm().setgActivityContent(bundle.getString("content"));
                    this.jzL.cJm().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jzL.cJm().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jzM = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jzM) {
                    this.jzL.cJm().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jzL.cJm().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jzL.cJm().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jzL.cJm().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jzL.cJm().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jzK.a(this.jzL.cJm(), this.jzM);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jzL == null) {
            this.jzL = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jzL.cJm() != null) {
            this.jzL.cJm().setGroupId(intent.getLongExtra("gid", 0L));
            this.jzM = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jzM) {
                this.jzL.cJm().setActivityId(intent.getIntExtra("aid", 0));
                this.jzL.cJm().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jzL.cJm().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jzL.cJm().setgActivityContent(getIntent().getStringExtra("content"));
                this.jzL.cJm().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jzK == null) {
            this.jzK = new a(this);
        }
        this.jzK.a(this.jzL.cJm(), this.jzM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jzL.cJm() != null) {
            j = this.jzL.cJm().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jzK.getTitle());
        bundle.putString("content", this.jzK.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jzK.cJr());
        bundle.putLong("time", this.jzK.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jzK != null) {
            this.jzK.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jnx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jzL.cancelMessage();
        this.jzK.destroy();
        MessageManager.getInstance().unRegisterListener(this.jnx);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jzK.cJp()) {
            cJl();
        } else if (view == this.jzK.cJq() && this.jzL != null && this.jzL.cJm() != null) {
            long time = this.jzK.getTime();
            if ((!this.jzM || this.jzK.cJs()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jzL.cJm().setgActivityArea(this.jzK.cJr());
            this.jzL.cJm().setgActivityContent(this.jzK.getContent());
            this.jzL.cJm().setgActivityTime(time);
            this.jzL.cJm().setgActivityTitle(this.jzK.getTitle());
            showProgressBar();
            this.jzL.qS(this.jzM);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cJl();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cJl() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jzM, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
