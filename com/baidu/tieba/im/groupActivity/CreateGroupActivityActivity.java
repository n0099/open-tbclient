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
    private a eFu;
    private CreateGroupActivityModel eFv;
    private boolean eFw = false;
    private c evf = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eFw) {
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
        this.eFv = new CreateGroupActivityModel(this);
        this.eFu = new a(this);
        if (this.eFv.aJr() != null) {
            if (bundle != null) {
                this.eFv.aJr().setGroupId(bundle.getInt("gid", 0));
                this.eFw = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFw) {
                    this.eFv.aJr().setActivityId(bundle.getInt("aid", 0));
                    this.eFv.aJr().setgActivityTitle(bundle.getString("name"));
                    this.eFv.aJr().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFv.aJr().setgActivityContent(bundle.getString("content"));
                    this.eFv.aJr().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.eFv.aJr().setGroupId(getIntent().getIntExtra("gid", 0));
                this.eFw = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFw) {
                    this.eFv.aJr().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eFv.aJr().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eFv.aJr().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFv.aJr().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eFv.aJr().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.eFu.a(this.eFv.aJr(), this.eFw);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eFv == null) {
            this.eFv = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eFv.aJr() != null) {
            this.eFv.aJr().setGroupId(intent.getIntExtra("gid", 0));
            this.eFw = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eFw) {
                this.eFv.aJr().setActivityId(intent.getIntExtra("aid", 0));
                this.eFv.aJr().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eFv.aJr().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eFv.aJr().setgActivityContent(getIntent().getStringExtra("content"));
                this.eFv.aJr().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.eFu == null) {
            this.eFu = new a(this);
        }
        this.eFu.a(this.eFv.aJr(), this.eFw);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.eFv.aJr() != null) {
            i = this.eFv.aJr().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.eFu.getTitle());
        bundle.putString("content", this.eFu.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eFu.aJw());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eFu.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eFu != null) {
            this.eFu.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.evf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eFv.cancelMessage();
        this.eFu.destroy();
        MessageManager.getInstance().unRegisterListener(this.evf);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFu.aJu()) {
            aJq();
        } else if (view == this.eFu.aJv() && this.eFv != null && this.eFv.aJr() != null) {
            long time = this.eFu.getTime();
            if ((!this.eFw || this.eFu.aJx()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.eFv.aJr().setgActivityArea(this.eFu.aJw());
            this.eFv.aJr().setgActivityContent(this.eFu.getContent());
            this.eFv.aJr().setgActivityTime(time);
            this.eFv.aJr().setgActivityTitle(this.eFu.getTitle());
            showProgressBar();
            this.eFv.hK(this.eFw);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aJq();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJq() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eFw, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
