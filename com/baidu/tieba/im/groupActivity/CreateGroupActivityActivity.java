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
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes3.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a eUd;
    private CreateGroupActivityModel eUe;
    private boolean eUf = false;
    private c eJR = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(e.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.eUf) {
                            CreateGroupActivityActivity.this.showToast(e.j.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(e.j.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(e.j.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.eUe = new CreateGroupActivityModel(this);
        this.eUd = new a(this);
        if (this.eUe.aSs() != null) {
            if (bundle != null) {
                this.eUe.aSs().setGroupId(bundle.getLong("gid", 0L));
                this.eUf = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUf) {
                    this.eUe.aSs().setActivityId(bundle.getInt("aid", 0));
                    this.eUe.aSs().setgActivityTitle(bundle.getString("name"));
                    this.eUe.aSs().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUe.aSs().setgActivityContent(bundle.getString("content"));
                    this.eUe.aSs().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eUe.aSs().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eUf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eUf) {
                    this.eUe.aSs().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eUe.aSs().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eUe.aSs().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eUe.aSs().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eUe.aSs().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eUd.a(this.eUe.aSs(), this.eUf);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eUe == null) {
            this.eUe = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eUe.aSs() != null) {
            this.eUe.aSs().setGroupId(intent.getLongExtra("gid", 0L));
            this.eUf = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eUf) {
                this.eUe.aSs().setActivityId(intent.getIntExtra("aid", 0));
                this.eUe.aSs().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eUe.aSs().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eUe.aSs().setgActivityContent(getIntent().getStringExtra("content"));
                this.eUe.aSs().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eUd == null) {
            this.eUd = new a(this);
        }
        this.eUd.a(this.eUe.aSs(), this.eUf);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eUe.aSs() != null) {
            j = this.eUe.aSs().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eUd.getTitle());
        bundle.putString("content", this.eUd.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eUd.aSx());
        bundle.putLong("time", this.eUd.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eUd != null) {
            this.eUd.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eJR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eUe.cancelMessage();
        this.eUd.destroy();
        MessageManager.getInstance().unRegisterListener(this.eJR);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eUd.aSv()) {
            aSr();
        } else if (view == this.eUd.aSw() && this.eUe != null && this.eUe.aSs() != null) {
            long time = this.eUd.getTime();
            if ((!this.eUf || this.eUd.aSy()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eUe.aSs().setgActivityArea(this.eUd.aSx());
            this.eUe.aSs().setgActivityContent(this.eUd.getContent());
            this.eUe.aSs().setgActivityTime(time);
            this.eUe.aSs().setgActivityTitle(this.eUd.getTitle());
            showProgressBar();
            this.eUe.iJ(this.eUf);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aSr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aSr() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eUf, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
