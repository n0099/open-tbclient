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
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes5.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a gKW;
    private CreateGroupActivityModel gKX;
    private boolean gKY = false;
    private c gAG = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gKY) {
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
        this.gKX = new CreateGroupActivityModel(this);
        this.gKW = new a(this);
        if (this.gKX.bET() != null) {
            if (bundle != null) {
                this.gKX.bET().setGroupId(bundle.getLong("gid", 0L));
                this.gKY = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gKY) {
                    this.gKX.bET().setActivityId(bundle.getInt("aid", 0));
                    this.gKX.bET().setgActivityTitle(bundle.getString("name"));
                    this.gKX.bET().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gKX.bET().setgActivityContent(bundle.getString("content"));
                    this.gKX.bET().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.gKX.bET().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gKY = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gKY) {
                    this.gKX.bET().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gKX.bET().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gKX.bET().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gKX.bET().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gKX.bET().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.gKW.a(this.gKX.bET(), this.gKY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gKX == null) {
            this.gKX = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gKX.bET() != null) {
            this.gKX.bET().setGroupId(intent.getLongExtra("gid", 0L));
            this.gKY = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gKY) {
                this.gKX.bET().setActivityId(intent.getIntExtra("aid", 0));
                this.gKX.bET().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gKX.bET().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gKX.bET().setgActivityContent(getIntent().getStringExtra("content"));
                this.gKX.bET().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.gKW == null) {
            this.gKW = new a(this);
        }
        this.gKW.a(this.gKX.bET(), this.gKY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gKX.bET() != null) {
            j = this.gKX.bET().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gKW.getTitle());
        bundle.putString("content", this.gKW.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gKW.bEY());
        bundle.putLong("time", this.gKW.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gKW != null) {
            this.gKW.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gAG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gKX.cancelMessage();
        this.gKW.destroy();
        MessageManager.getInstance().unRegisterListener(this.gAG);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gKW.bEW()) {
            bES();
        } else if (view == this.gKW.bEX() && this.gKX != null && this.gKX.bET() != null) {
            long time = this.gKW.getTime();
            if ((!this.gKY || this.gKW.bEZ()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.gKX.bET().setgActivityArea(this.gKW.bEY());
            this.gKX.bET().setgActivityContent(this.gKW.getContent());
            this.gKX.bET().setgActivityTime(time);
            this.gKX.bET().setgActivityTitle(this.gKW.getTitle());
            showProgressBar();
            this.gKX.mq(this.gKY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bES();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void bES() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gKY, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
