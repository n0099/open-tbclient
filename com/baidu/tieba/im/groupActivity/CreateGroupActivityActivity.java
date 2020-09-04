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
    private a jri;
    private CreateGroupActivityModel jrj;
    private boolean jrk = false;
    private c jeR = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.jrk) {
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
        this.jrj = new CreateGroupActivityModel(this);
        this.jri = new a(this);
        if (this.jrj.cFG() != null) {
            if (bundle != null) {
                this.jrj.cFG().setGroupId(bundle.getLong("gid", 0L));
                this.jrk = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jrk) {
                    this.jrj.cFG().setActivityId(bundle.getInt("aid", 0));
                    this.jrj.cFG().setgActivityTitle(bundle.getString("name"));
                    this.jrj.cFG().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jrj.cFG().setgActivityContent(bundle.getString("content"));
                    this.jrj.cFG().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.jrj.cFG().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.jrk = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.jrk) {
                    this.jrj.cFG().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.jrj.cFG().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.jrj.cFG().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.jrj.cFG().setgActivityContent(getIntent().getStringExtra("content"));
                    this.jrj.cFG().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.jri.a(this.jrj.cFG(), this.jrk);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.jrj == null) {
            this.jrj = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.jrj.cFG() != null) {
            this.jrj.cFG().setGroupId(intent.getLongExtra("gid", 0L));
            this.jrk = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.jrk) {
                this.jrj.cFG().setActivityId(intent.getIntExtra("aid", 0));
                this.jrj.cFG().setgActivityTitle(getIntent().getStringExtra("name"));
                this.jrj.cFG().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.jrj.cFG().setgActivityContent(getIntent().getStringExtra("content"));
                this.jrj.cFG().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.jri == null) {
            this.jri = new a(this);
        }
        this.jri.a(this.jrj.cFG(), this.jrk);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.jrj.cFG() != null) {
            j = this.jrj.cFG().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.jri.getTitle());
        bundle.putString("content", this.jri.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.jri.cFL());
        bundle.putLong("time", this.jri.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.jri != null) {
            this.jri.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.jeR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jrj.cancelMessage();
        this.jri.destroy();
        MessageManager.getInstance().unRegisterListener(this.jeR);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jri.cFJ()) {
            cFF();
        } else if (view == this.jri.cFK() && this.jrj != null && this.jrj.cFG() != null) {
            long time = this.jri.getTime();
            if ((!this.jrk || this.jri.cFM()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.jrj.cFG().setgActivityArea(this.jri.cFL());
            this.jrj.cFG().setgActivityContent(this.jri.getContent());
            this.jrj.cFG().setgActivityTime(time);
            this.jrj.cFG().setgActivityTitle(this.jri.getTitle());
            showProgressBar();
            this.jrj.qK(this.jrk);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cFF();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cFF() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.jrk, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
