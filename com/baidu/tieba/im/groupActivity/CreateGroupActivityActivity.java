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
    private a eFq;
    private CreateGroupActivityModel eFr;
    private boolean eFs = false;
    private c evb = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eFs) {
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
        this.eFr = new CreateGroupActivityModel(this);
        this.eFq = new a(this);
        if (this.eFr.aJr() != null) {
            if (bundle != null) {
                this.eFr.aJr().setGroupId(bundle.getInt("gid", 0));
                this.eFs = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFs) {
                    this.eFr.aJr().setActivityId(bundle.getInt("aid", 0));
                    this.eFr.aJr().setgActivityTitle(bundle.getString("name"));
                    this.eFr.aJr().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFr.aJr().setgActivityContent(bundle.getString("content"));
                    this.eFr.aJr().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.eFr.aJr().setGroupId(getIntent().getIntExtra("gid", 0));
                this.eFs = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eFs) {
                    this.eFr.aJr().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eFr.aJr().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eFr.aJr().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eFr.aJr().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eFr.aJr().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.eFq.a(this.eFr.aJr(), this.eFs);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eFr == null) {
            this.eFr = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eFr.aJr() != null) {
            this.eFr.aJr().setGroupId(intent.getIntExtra("gid", 0));
            this.eFs = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eFs) {
                this.eFr.aJr().setActivityId(intent.getIntExtra("aid", 0));
                this.eFr.aJr().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eFr.aJr().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eFr.aJr().setgActivityContent(getIntent().getStringExtra("content"));
                this.eFr.aJr().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.eFq == null) {
            this.eFq = new a(this);
        }
        this.eFq.a(this.eFr.aJr(), this.eFs);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = 0;
        if (this.eFr.aJr() != null) {
            i = this.eFr.aJr().getGroupId();
        }
        bundle.putInt("gid", i);
        bundle.putString("name", this.eFq.getTitle());
        bundle.putString("content", this.eFq.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eFq.aJw());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.eFq.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eFq != null) {
            this.eFq.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.evb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eFr.cancelMessage();
        this.eFq.destroy();
        MessageManager.getInstance().unRegisterListener(this.evb);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eFq.aJu()) {
            aJq();
        } else if (view == this.eFq.aJv() && this.eFr != null && this.eFr.aJr() != null) {
            long time = this.eFq.getTime();
            if ((!this.eFs || this.eFq.aJx()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.eFr.aJr().setgActivityArea(this.eFq.aJw());
            this.eFr.aJr().setgActivityContent(this.eFq.getContent());
            this.eFr.aJr().setgActivityTime(time);
            this.eFr.aJr().setgActivityTitle(this.eFq.getTitle());
            showProgressBar();
            this.eFr.hF(this.eFs);
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
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eFs, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
