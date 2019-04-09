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
/* loaded from: classes5.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a gkM;
    private CreateGroupActivityModel gkN;
    private boolean gkO = false;
    private c gat = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gkO) {
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
        this.gkN = new CreateGroupActivityModel(this);
        this.gkM = new a(this);
        if (this.gkN.btu() != null) {
            if (bundle != null) {
                this.gkN.btu().setGroupId(bundle.getLong("gid", 0L));
                this.gkO = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gkO) {
                    this.gkN.btu().setActivityId(bundle.getInt("aid", 0));
                    this.gkN.btu().setgActivityTitle(bundle.getString("name"));
                    this.gkN.btu().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gkN.btu().setgActivityContent(bundle.getString("content"));
                    this.gkN.btu().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gkN.btu().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gkO = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gkO) {
                    this.gkN.btu().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gkN.btu().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gkN.btu().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gkN.btu().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gkN.btu().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gkM.a(this.gkN.btu(), this.gkO);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gkN == null) {
            this.gkN = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gkN.btu() != null) {
            this.gkN.btu().setGroupId(intent.getLongExtra("gid", 0L));
            this.gkO = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gkO) {
                this.gkN.btu().setActivityId(intent.getIntExtra("aid", 0));
                this.gkN.btu().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gkN.btu().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gkN.btu().setgActivityContent(getIntent().getStringExtra("content"));
                this.gkN.btu().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gkM == null) {
            this.gkM = new a(this);
        }
        this.gkM.a(this.gkN.btu(), this.gkO);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gkN.btu() != null) {
            j = this.gkN.btu().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gkM.getTitle());
        bundle.putString("content", this.gkM.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gkM.btz());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gkM.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gkM != null) {
            this.gkM.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gat);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gkN.cancelMessage();
        this.gkM.destroy();
        MessageManager.getInstance().unRegisterListener(this.gat);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gkM.btx()) {
            btt();
        } else if (view == this.gkM.bty() && this.gkN != null && this.gkN.btu() != null) {
            long time = this.gkM.getTime();
            if ((!this.gkO || this.gkM.btA()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.gkN.btu().setgActivityArea(this.gkM.btz());
            this.gkN.btu().setgActivityContent(this.gkM.getContent());
            this.gkN.btu().setgActivityTime(time);
            this.gkN.btu().setgActivityTitle(this.gkM.getTitle());
            showProgressBar();
            this.gkN.lj(this.gkO);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            btt();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void btt() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gkO, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
