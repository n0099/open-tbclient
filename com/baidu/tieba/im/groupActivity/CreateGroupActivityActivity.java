package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a eqm;
    private CreateGroupActivityModel eqn;
    private boolean eqo = false;
    private c efV = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(d.k.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.eqo) {
                            CreateGroupActivityActivity.this.showToast(d.k.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(d.k.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(d.k.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.eqn = new CreateGroupActivityModel(this);
        this.eqm = new a(this);
        if (this.eqn.aJO() != null) {
            if (bundle != null) {
                this.eqn.aJO().setGroupId(bundle.getLong("gid", 0L));
                this.eqo = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eqo) {
                    this.eqn.aJO().setActivityId(bundle.getInt("aid", 0));
                    this.eqn.aJO().setgActivityTitle(bundle.getString("name"));
                    this.eqn.aJO().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eqn.aJO().setgActivityContent(bundle.getString("content"));
                    this.eqn.aJO().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eqn.aJO().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eqo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eqo) {
                    this.eqn.aJO().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eqn.aJO().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eqn.aJO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eqn.aJO().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eqn.aJO().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eqm.a(this.eqn.aJO(), this.eqo);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eqn == null) {
            this.eqn = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eqn.aJO() != null) {
            this.eqn.aJO().setGroupId(intent.getLongExtra("gid", 0L));
            this.eqo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eqo) {
                this.eqn.aJO().setActivityId(intent.getIntExtra("aid", 0));
                this.eqn.aJO().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eqn.aJO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eqn.aJO().setgActivityContent(getIntent().getStringExtra("content"));
                this.eqn.aJO().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eqm == null) {
            this.eqm = new a(this);
        }
        this.eqm.a(this.eqn.aJO(), this.eqo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eqn.aJO() != null) {
            j = this.eqn.aJO().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eqm.getTitle());
        bundle.putString("content", this.eqm.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eqm.aJT());
        bundle.putLong("time", this.eqm.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eqm != null) {
            this.eqm.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.efV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eqn.cancelMessage();
        this.eqm.destroy();
        MessageManager.getInstance().unRegisterListener(this.efV);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eqm.aJR()) {
            aJN();
        } else if (view == this.eqm.aJS() && this.eqn != null && this.eqn.aJO() != null) {
            long time = this.eqm.getTime();
            if ((!this.eqo || this.eqm.aJU()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.k.group_activity_time_val);
                return;
            }
            this.eqn.aJO().setgActivityArea(this.eqm.aJT());
            this.eqn.aJO().setgActivityContent(this.eqm.getContent());
            this.eqn.aJO().setgActivityTime(time);
            this.eqn.aJO().setgActivityTitle(this.eqm.getTitle());
            showProgressBar();
            this.eqn.hB(this.eqo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aJN();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJN() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eqo, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
