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
/* loaded from: classes8.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a hzK;
    private CreateGroupActivityModel hzL;
    private boolean hzM = false;
    private c hpz = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.hzM) {
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
        this.hzL = new CreateGroupActivityModel(this);
        this.hzK = new a(this);
        if (this.hzL.bTY() != null) {
            if (bundle != null) {
                this.hzL.bTY().setGroupId(bundle.getLong("gid", 0L));
                this.hzM = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hzM) {
                    this.hzL.bTY().setActivityId(bundle.getInt("aid", 0));
                    this.hzL.bTY().setgActivityTitle(bundle.getString("name"));
                    this.hzL.bTY().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hzL.bTY().setgActivityContent(bundle.getString("content"));
                    this.hzL.bTY().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.hzL.bTY().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.hzM = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.hzM) {
                    this.hzL.bTY().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.hzL.bTY().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.hzL.bTY().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.hzL.bTY().setgActivityContent(getIntent().getStringExtra("content"));
                    this.hzL.bTY().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.hzK.a(this.hzL.bTY(), this.hzM);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.hzL == null) {
            this.hzL = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.hzL.bTY() != null) {
            this.hzL.bTY().setGroupId(intent.getLongExtra("gid", 0L));
            this.hzM = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.hzM) {
                this.hzL.bTY().setActivityId(intent.getIntExtra("aid", 0));
                this.hzL.bTY().setgActivityTitle(getIntent().getStringExtra("name"));
                this.hzL.bTY().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.hzL.bTY().setgActivityContent(getIntent().getStringExtra("content"));
                this.hzL.bTY().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.hzK == null) {
            this.hzK = new a(this);
        }
        this.hzK.a(this.hzL.bTY(), this.hzM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.hzL.bTY() != null) {
            j = this.hzL.bTY().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.hzK.getTitle());
        bundle.putString("content", this.hzK.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.hzK.bUd());
        bundle.putLong("time", this.hzK.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.hzK != null) {
            this.hzK.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.hpz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hzL.cancelMessage();
        this.hzK.destroy();
        MessageManager.getInstance().unRegisterListener(this.hpz);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hzK.bUb()) {
            bTX();
        } else if (view == this.hzK.bUc() && this.hzL != null && this.hzL.bTY() != null) {
            long time = this.hzK.getTime();
            if ((!this.hzM || this.hzK.bUe()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.hzL.bTY().setgActivityArea(this.hzK.bUd());
            this.hzL.bTY().setgActivityContent(this.hzK.getContent());
            this.hzL.bTY().setgActivityTime(time);
            this.hzL.bTY().setgActivityTitle(this.hzK.getTitle());
            showProgressBar();
            this.hzL.nD(this.hzM);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bTX();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bTX() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.hzM, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
