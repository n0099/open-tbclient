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
    private a jca;
    private CreateGroupActivityModel jcb;
    private boolean jcc = false;
    private c iPM = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jcc) {
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
        this.jcb = new CreateGroupActivityModel(this);
        this.jca = new a(this);
        if (this.jcb.cuO() != null) {
            if (bundle != null) {
                this.jcb.cuO().setGroupId(bundle.getLong("gid", 0L));
                this.jcc = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jcc) {
                    this.jcb.cuO().setActivityId(bundle.getInt("aid", 0));
                    this.jcb.cuO().setgActivityTitle(bundle.getString("name"));
                    this.jcb.cuO().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jcb.cuO().setgActivityContent(bundle.getString("content"));
                    this.jcb.cuO().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jcb.cuO().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jcc = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jcc) {
                    this.jcb.cuO().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jcb.cuO().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jcb.cuO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jcb.cuO().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jcb.cuO().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jca.a(this.jcb.cuO(), this.jcc);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jcb == null) {
            this.jcb = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jcb.cuO() != null) {
            this.jcb.cuO().setGroupId(intent.getLongExtra("gid", 0L));
            this.jcc = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jcc) {
                this.jcb.cuO().setActivityId(intent.getIntExtra("aid", 0));
                this.jcb.cuO().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jcb.cuO().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jcb.cuO().setgActivityContent(getIntent().getStringExtra("content"));
                this.jcb.cuO().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jca == null) {
            this.jca = new a(this);
        }
        this.jca.a(this.jcb.cuO(), this.jcc);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jcb.cuO() != null) {
            j = this.jcb.cuO().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jca.getTitle());
        bundle.putString("content", this.jca.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jca.cuT());
        bundle.putLong("time", this.jca.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jca != null) {
            this.jca.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.iPM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jcb.cancelMessage();
        this.jca.destroy();
        MessageManager.getInstance().unRegisterListener(this.iPM);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jca.cuR()) {
            cuN();
        } else if (view == this.jca.cuS() && this.jcb != null && this.jcb.cuO() != null) {
            long time = this.jca.getTime();
            if ((!this.jcc || this.jca.cuU()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jcb.cuO().setgActivityArea(this.jca.cuT());
            this.jcb.cuO().setgActivityContent(this.jca.getContent());
            this.jcb.cuO().setgActivityTime(time);
            this.jcb.cuO().setgActivityTitle(this.jca.getTitle());
            showProgressBar();
            this.jcb.qc(this.jcc);
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
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jcc, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
