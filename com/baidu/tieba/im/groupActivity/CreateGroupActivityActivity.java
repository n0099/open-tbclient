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
    private a eFe;
    private CreateGroupActivityModel eFf;
    private boolean eFg = false;
    private c euP = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(d.j.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.eFg) {
                            CreateGroupActivityActivity.this.showToast(d.j.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(d.j.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(d.j.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.eFf = new CreateGroupActivityModel(this);
        this.eFe = new a(this);
        if (this.eFf.aJq() != null) {
            if (bundle != null) {
                this.eFf.aJq().setGroupId(bundle.getInt("gid", 0));
                this.eFg = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFg) {
                    this.eFf.aJq().setActivityId(bundle.getInt("aid", 0));
                    this.eFf.aJq().setgActivityTitle(bundle.getString("name"));
                    this.eFf.aJq().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFf.aJq().setgActivityContent(bundle.getString("content"));
                    this.eFf.aJq().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.eFf.aJq().setGroupId(getIntent().getIntExtra("gid", 0));
                this.eFg = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFg) {
                    this.eFf.aJq().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eFf.aJq().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eFf.aJq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFf.aJq().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eFf.aJq().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.eFe.a(this.eFf.aJq(), this.eFg);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eFf == null) {
            this.eFf = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eFf.aJq() != null) {
            this.eFf.aJq().setGroupId(intent.getIntExtra("gid", 0));
            this.eFg = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eFg) {
                this.eFf.aJq().setActivityId(intent.getIntExtra("aid", 0));
                this.eFf.aJq().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eFf.aJq().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eFf.aJq().setgActivityContent(getIntent().getStringExtra("content"));
                this.eFf.aJq().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.eFe == null) {
            this.eFe = new a(this);
        }
        this.eFe.a(this.eFf.aJq(), this.eFg);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.eFf.aJq() != null) {
            i = this.eFf.aJq().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.eFe.getTitle());
        bundle.putString("content", this.eFe.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eFe.aJv());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eFe.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eFe != null) {
            this.eFe.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.euP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eFf.cancelMessage();
        this.eFe.destroy();
        MessageManager.getInstance().unRegisterListener(this.euP);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFe.aJt()) {
            aJp();
        } else if (view == this.eFe.aJu() && this.eFf != null && this.eFf.aJq() != null) {
            long time = this.eFe.getTime();
            if ((!this.eFg || this.eFe.aJw()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.eFf.aJq().setgActivityArea(this.eFe.aJv());
            this.eFf.aJq().setgActivityContent(this.eFe.getContent());
            this.eFf.aJq().setgActivityTime(time);
            this.eFf.aJq().setgActivityTitle(this.eFe.getTitle());
            showProgressBar();
            this.eFf.hF(this.eFg);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aJp();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJp() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eFg, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
