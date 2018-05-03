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
    private a dZW;
    private CreateGroupActivityModel dZX;
    private boolean dZY = false;
    private c dPI = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.dZY) {
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
        this.dZX = new CreateGroupActivityModel(this);
        this.dZW = new a(this);
        if (this.dZX.aEo() != null) {
            if (bundle != null) {
                this.dZX.aEo().setGroupId(bundle.getLong("gid", 0L));
                this.dZY = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.dZY) {
                    this.dZX.aEo().setActivityId(bundle.getInt("aid", 0));
                    this.dZX.aEo().setgActivityTitle(bundle.getString("name"));
                    this.dZX.aEo().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.dZX.aEo().setgActivityContent(bundle.getString("content"));
                    this.dZX.aEo().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.dZX.aEo().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.dZY = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.dZY) {
                    this.dZX.aEo().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.dZX.aEo().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.dZX.aEo().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.dZX.aEo().setgActivityContent(getIntent().getStringExtra("content"));
                    this.dZX.aEo().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.dZW.a(this.dZX.aEo(), this.dZY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.dZX == null) {
            this.dZX = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.dZX.aEo() != null) {
            this.dZX.aEo().setGroupId(intent.getLongExtra("gid", 0L));
            this.dZY = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.dZY) {
                this.dZX.aEo().setActivityId(intent.getIntExtra("aid", 0));
                this.dZX.aEo().setgActivityTitle(getIntent().getStringExtra("name"));
                this.dZX.aEo().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.dZX.aEo().setgActivityContent(getIntent().getStringExtra("content"));
                this.dZX.aEo().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.dZW == null) {
            this.dZW = new a(this);
        }
        this.dZW.a(this.dZX.aEo(), this.dZY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.dZX.aEo() != null) {
            j = this.dZX.aEo().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.dZW.getTitle());
        bundle.putString("content", this.dZW.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.dZW.aEt());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.dZW.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.dZW != null) {
            this.dZW.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.dPI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dZX.cancelMessage();
        this.dZW.destroy();
        MessageManager.getInstance().unRegisterListener(this.dPI);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dZW.aEr()) {
            aEn();
        } else if (view2 == this.dZW.aEs() && this.dZX != null && this.dZX.aEo() != null) {
            long time = this.dZW.getTime();
            if ((!this.dZY || this.dZW.aEu()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.k.group_activity_time_val);
                return;
            }
            this.dZX.aEo().setgActivityArea(this.dZW.aEt());
            this.dZX.aEo().setgActivityContent(this.dZW.getContent());
            this.dZX.aEo().setgActivityTime(time);
            this.dZX.aEo().setgActivityTitle(this.dZW.getTitle());
            showProgressBar();
            this.dZX.hk(this.dZY);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aEn();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aEn() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.dZY, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
