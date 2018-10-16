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
    private a eJe;
    private CreateGroupActivityModel eJf;
    private boolean eJg = false;
    private c eyR = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eJg) {
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
        this.eJf = new CreateGroupActivityModel(this);
        this.eJe = new a(this);
        if (this.eJf.aQq() != null) {
            if (bundle != null) {
                this.eJf.aQq().setGroupId(bundle.getLong("gid", 0L));
                this.eJg = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eJg) {
                    this.eJf.aQq().setActivityId(bundle.getInt("aid", 0));
                    this.eJf.aQq().setgActivityTitle(bundle.getString("name"));
                    this.eJf.aQq().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eJf.aQq().setgActivityContent(bundle.getString("content"));
                    this.eJf.aQq().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eJf.aQq().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eJg = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eJg) {
                    this.eJf.aQq().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eJf.aQq().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eJf.aQq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eJf.aQq().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eJf.aQq().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eJe.a(this.eJf.aQq(), this.eJg);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eJf == null) {
            this.eJf = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eJf.aQq() != null) {
            this.eJf.aQq().setGroupId(intent.getLongExtra("gid", 0L));
            this.eJg = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eJg) {
                this.eJf.aQq().setActivityId(intent.getIntExtra("aid", 0));
                this.eJf.aQq().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eJf.aQq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eJf.aQq().setgActivityContent(getIntent().getStringExtra("content"));
                this.eJf.aQq().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eJe == null) {
            this.eJe = new a(this);
        }
        this.eJe.a(this.eJf.aQq(), this.eJg);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eJf.aQq() != null) {
            j = this.eJf.aQq().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eJe.getTitle());
        bundle.putString("content", this.eJe.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eJe.aQv());
        bundle.putLong("time", this.eJe.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eJe != null) {
            this.eJe.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eyR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eJf.cancelMessage();
        this.eJe.destroy();
        MessageManager.getInstance().unRegisterListener(this.eyR);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJe.aQt()) {
            aQp();
        } else if (view == this.eJe.aQu() && this.eJf != null && this.eJf.aQq() != null) {
            long time = this.eJe.getTime();
            if ((!this.eJg || this.eJe.aQw()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eJf.aQq().setgActivityArea(this.eJe.aQv());
            this.eJf.aQq().setgActivityContent(this.eJe.getContent());
            this.eJf.aQq().setgActivityTime(time);
            this.eJf.aQq().setgActivityTitle(this.eJe.getTitle());
            showProgressBar();
            this.eJf.iu(this.eJg);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aQp();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aQp() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eJg, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
