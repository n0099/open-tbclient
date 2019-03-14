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
    private a gkY;
    private CreateGroupActivityModel gkZ;
    private boolean gla = false;
    private c gaF = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.gla) {
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
        this.gkZ = new CreateGroupActivityModel(this);
        this.gkY = new a(this);
        if (this.gkZ.btx() != null) {
            if (bundle != null) {
                this.gkZ.btx().setGroupId(bundle.getLong("gid", 0L));
                this.gla = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gla) {
                    this.gkZ.btx().setActivityId(bundle.getInt("aid", 0));
                    this.gkZ.btx().setgActivityTitle(bundle.getString("name"));
                    this.gkZ.btx().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gkZ.btx().setgActivityContent(bundle.getString("content"));
                    this.gkZ.btx().setgActivityTime(bundle.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            } else if (getIntent() != null) {
                this.gkZ.btx().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.gla = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.gla) {
                    this.gkZ.btx().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.gkZ.btx().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.gkZ.btx().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.gkZ.btx().setgActivityContent(getIntent().getStringExtra("content"));
                    this.gkZ.btx().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
                }
            }
        }
        this.gkY.a(this.gkZ.btx(), this.gla);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.gkZ == null) {
            this.gkZ = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.gkZ.btx() != null) {
            this.gkZ.btx().setGroupId(intent.getLongExtra("gid", 0L));
            this.gla = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.gla) {
                this.gkZ.btx().setActivityId(intent.getIntExtra("aid", 0));
                this.gkZ.btx().setgActivityTitle(getIntent().getStringExtra("name"));
                this.gkZ.btx().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.gkZ.btx().setgActivityContent(getIntent().getStringExtra("content"));
                this.gkZ.btx().setgActivityTime(getIntent().getLongExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L));
            }
        }
        if (this.gkY == null) {
            this.gkY = new a(this);
        }
        this.gkY.a(this.gkZ.btx(), this.gla);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.gkZ.btx() != null) {
            j = this.gkZ.btx().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.gkY.getTitle());
        bundle.putString("content", this.gkY.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.gkY.btC());
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.gkY.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.gkY != null) {
            this.gkY.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.gaF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gkZ.cancelMessage();
        this.gkY.destroy();
        MessageManager.getInstance().unRegisterListener(this.gaF);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gkY.btA()) {
            btw();
        } else if (view == this.gkY.btB() && this.gkZ != null && this.gkZ.btx() != null) {
            long time = this.gkY.getTime();
            if ((!this.gla || this.gkY.btD()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.gkZ.btx().setgActivityArea(this.gkY.btC());
            this.gkZ.btx().setgActivityContent(this.gkY.getContent());
            this.gkZ.btx().setgActivityTime(time);
            this.gkZ.btx().setgActivityTitle(this.gkY.getTitle());
            showProgressBar();
            this.gkZ.lj(this.gla);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            btw();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void btw() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.gla, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
