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
    private a emq;
    private CreateGroupActivityModel emr;
    private boolean ems = false;
    private c ecb = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.ems) {
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
        this.emr = new CreateGroupActivityModel(this);
        this.emq = new a(this);
        if (this.emr.aJh() != null) {
            if (bundle != null) {
                this.emr.aJh().setGroupId(bundle.getLong("gid", 0L));
                this.ems = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ems) {
                    this.emr.aJh().setActivityId(bundle.getInt("aid", 0));
                    this.emr.aJh().setgActivityTitle(bundle.getString("name"));
                    this.emr.aJh().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.emr.aJh().setgActivityContent(bundle.getString("content"));
                    this.emr.aJh().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.emr.aJh().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.ems = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.ems) {
                    this.emr.aJh().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.emr.aJh().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.emr.aJh().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.emr.aJh().setgActivityContent(getIntent().getStringExtra("content"));
                    this.emr.aJh().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.emq.a(this.emr.aJh(), this.ems);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.emr == null) {
            this.emr = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.emr.aJh() != null) {
            this.emr.aJh().setGroupId(intent.getLongExtra("gid", 0L));
            this.ems = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.ems) {
                this.emr.aJh().setActivityId(intent.getIntExtra("aid", 0));
                this.emr.aJh().setgActivityTitle(getIntent().getStringExtra("name"));
                this.emr.aJh().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.emr.aJh().setgActivityContent(getIntent().getStringExtra("content"));
                this.emr.aJh().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.emq == null) {
            this.emq = new a(this);
        }
        this.emq.a(this.emr.aJh(), this.ems);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.emr.aJh() != null) {
            j = this.emr.aJh().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.emq.getTitle());
        bundle.putString("content", this.emq.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.emq.aJm());
        bundle.putLong("time", this.emq.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.emq != null) {
            this.emq.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.ecb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emr.cancelMessage();
        this.emq.destroy();
        MessageManager.getInstance().unRegisterListener(this.ecb);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.emq.aJk()) {
            aJg();
        } else if (view == this.emq.aJl() && this.emr != null && this.emr.aJh() != null) {
            long time = this.emq.getTime();
            if ((!this.ems || this.emq.aJn()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.k.group_activity_time_val);
                return;
            }
            this.emr.aJh().setgActivityArea(this.emq.aJm());
            this.emr.aJh().setgActivityContent(this.emq.getContent());
            this.emr.aJh().setgActivityTime(time);
            this.emr.aJh().setgActivityTitle(this.emq.getTitle());
            showProgressBar();
            this.emr.hr(this.ems);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aJg();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aJg() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.ems, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
