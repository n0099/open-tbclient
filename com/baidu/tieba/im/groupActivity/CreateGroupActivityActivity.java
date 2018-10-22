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
    private a eJf;
    private CreateGroupActivityModel eJg;
    private boolean eJh = false;
    private c eyS = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eJh) {
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
        this.eJg = new CreateGroupActivityModel(this);
        this.eJf = new a(this);
        if (this.eJg.aQq() != null) {
            if (bundle != null) {
                this.eJg.aQq().setGroupId(bundle.getLong("gid", 0L));
                this.eJh = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eJh) {
                    this.eJg.aQq().setActivityId(bundle.getInt("aid", 0));
                    this.eJg.aQq().setgActivityTitle(bundle.getString("name"));
                    this.eJg.aQq().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eJg.aQq().setgActivityContent(bundle.getString("content"));
                    this.eJg.aQq().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eJg.aQq().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eJh = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eJh) {
                    this.eJg.aQq().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eJg.aQq().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eJg.aQq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eJg.aQq().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eJg.aQq().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eJf.a(this.eJg.aQq(), this.eJh);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eJg == null) {
            this.eJg = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eJg.aQq() != null) {
            this.eJg.aQq().setGroupId(intent.getLongExtra("gid", 0L));
            this.eJh = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eJh) {
                this.eJg.aQq().setActivityId(intent.getIntExtra("aid", 0));
                this.eJg.aQq().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eJg.aQq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eJg.aQq().setgActivityContent(getIntent().getStringExtra("content"));
                this.eJg.aQq().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eJf == null) {
            this.eJf = new a(this);
        }
        this.eJf.a(this.eJg.aQq(), this.eJh);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eJg.aQq() != null) {
            j = this.eJg.aQq().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eJf.getTitle());
        bundle.putString("content", this.eJf.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eJf.aQv());
        bundle.putLong("time", this.eJf.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eJf != null) {
            this.eJf.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eyS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eJg.cancelMessage();
        this.eJf.destroy();
        MessageManager.getInstance().unRegisterListener(this.eyS);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJf.aQt()) {
            aQp();
        } else if (view == this.eJf.aQu() && this.eJg != null && this.eJg.aQq() != null) {
            long time = this.eJf.getTime();
            if ((!this.eJh || this.eJf.aQw()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eJg.aQq().setgActivityArea(this.eJf.aQv());
            this.eJg.aQq().setgActivityContent(this.eJf.getContent());
            this.eJg.aQq().setgActivityTime(time);
            this.eJg.aQq().setgActivityTitle(this.eJf.getTitle());
            showProgressBar();
            this.eJg.iu(this.eJh);
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
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eJh, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
