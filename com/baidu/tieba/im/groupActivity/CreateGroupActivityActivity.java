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
/* loaded from: classes10.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a iTQ;
    private CreateGroupActivityModel iTR;
    private boolean iTS = false;
    private c iJH = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.iTS) {
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
        this.iTR = new CreateGroupActivityModel(this);
        this.iTQ = new a(this);
        if (this.iTR.cqQ() != null) {
            if (bundle != null) {
                this.iTR.cqQ().setGroupId(bundle.getLong("gid", 0L));
                this.iTS = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iTS) {
                    this.iTR.cqQ().setActivityId(bundle.getInt("aid", 0));
                    this.iTR.cqQ().setgActivityTitle(bundle.getString("name"));
                    this.iTR.cqQ().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iTR.cqQ().setgActivityContent(bundle.getString("content"));
                    this.iTR.cqQ().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.iTR.cqQ().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.iTS = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.iTS) {
                    this.iTR.cqQ().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.iTR.cqQ().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.iTR.cqQ().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.iTR.cqQ().setgActivityContent(getIntent().getStringExtra("content"));
                    this.iTR.cqQ().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.iTQ.a(this.iTR.cqQ(), this.iTS);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.iTR == null) {
            this.iTR = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.iTR.cqQ() != null) {
            this.iTR.cqQ().setGroupId(intent.getLongExtra("gid", 0L));
            this.iTS = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.iTS) {
                this.iTR.cqQ().setActivityId(intent.getIntExtra("aid", 0));
                this.iTR.cqQ().setgActivityTitle(getIntent().getStringExtra("name"));
                this.iTR.cqQ().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.iTR.cqQ().setgActivityContent(getIntent().getStringExtra("content"));
                this.iTR.cqQ().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.iTQ == null) {
            this.iTQ = new a(this);
        }
        this.iTQ.a(this.iTR.cqQ(), this.iTS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.iTR.cqQ() != null) {
            j = this.iTR.cqQ().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.iTQ.getTitle());
        bundle.putString("content", this.iTQ.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.iTQ.cqV());
        bundle.putLong("time", this.iTQ.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.iTQ != null) {
            this.iTQ.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.iJH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iTR.cancelMessage();
        this.iTQ.destroy();
        MessageManager.getInstance().unRegisterListener(this.iJH);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iTQ.cqT()) {
            cqP();
        } else if (view == this.iTQ.cqU() && this.iTR != null && this.iTR.cqQ() != null) {
            long time = this.iTQ.getTime();
            if ((!this.iTS || this.iTQ.cqW()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.iTR.cqQ().setgActivityArea(this.iTQ.cqV());
            this.iTR.cqQ().setgActivityContent(this.iTQ.getContent());
            this.iTR.cqQ().setgActivityTime(time);
            this.iTR.cqQ().setgActivityTitle(this.iTQ.getTitle());
            showProgressBar();
            this.iTR.pv(this.iTS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cqP();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cqP() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.iTS, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
