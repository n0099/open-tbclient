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
/* loaded from: classes7.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a hwh;
    private CreateGroupActivityModel hwi;
    private boolean hwj = false;
    private c hlW = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.hwj) {
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
        this.hwi = new CreateGroupActivityModel(this);
        this.hwh = new a(this);
        if (this.hwi.bSP() != null) {
            if (bundle != null) {
                this.hwi.bSP().setGroupId(bundle.getLong("gid", 0L));
                this.hwj = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hwj) {
                    this.hwi.bSP().setActivityId(bundle.getInt("aid", 0));
                    this.hwi.bSP().setgActivityTitle(bundle.getString("name"));
                    this.hwi.bSP().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hwi.bSP().setgActivityContent(bundle.getString("content"));
                    this.hwi.bSP().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.hwi.bSP().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.hwj = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hwj) {
                    this.hwi.bSP().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.hwi.bSP().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.hwi.bSP().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hwi.bSP().setgActivityContent(getIntent().getStringExtra("content"));
                    this.hwi.bSP().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.hwh.a(this.hwi.bSP(), this.hwj);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.hwi == null) {
            this.hwi = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.hwi.bSP() != null) {
            this.hwi.bSP().setGroupId(intent.getLongExtra("gid", 0L));
            this.hwj = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.hwj) {
                this.hwi.bSP().setActivityId(intent.getIntExtra("aid", 0));
                this.hwi.bSP().setgActivityTitle(getIntent().getStringExtra("name"));
                this.hwi.bSP().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.hwi.bSP().setgActivityContent(getIntent().getStringExtra("content"));
                this.hwi.bSP().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.hwh == null) {
            this.hwh = new a(this);
        }
        this.hwh.a(this.hwi.bSP(), this.hwj);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.hwi.bSP() != null) {
            j = this.hwi.bSP().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.hwh.getTitle());
        bundle.putString("content", this.hwh.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.hwh.bSU());
        bundle.putLong("time", this.hwh.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.hwh != null) {
            this.hwh.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.hlW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hwi.cancelMessage();
        this.hwh.destroy();
        MessageManager.getInstance().unRegisterListener(this.hlW);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hwh.bSS()) {
            bSO();
        } else if (view == this.hwh.bST() && this.hwi != null && this.hwi.bSP() != null) {
            long time = this.hwh.getTime();
            if ((!this.hwj || this.hwh.bSV()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.hwi.bSP().setgActivityArea(this.hwh.bSU());
            this.hwi.bSP().setgActivityContent(this.hwh.getContent());
            this.hwi.bSP().setgActivityTime(time);
            this.hwi.bSP().setgActivityTitle(this.hwh.getTitle());
            showProgressBar();
            this.hwi.nr(this.hwj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bSO();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bSO() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.hwj, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
