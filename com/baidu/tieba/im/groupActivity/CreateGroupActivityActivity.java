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
    private a eKx;
    private CreateGroupActivityModel eKy;
    private boolean eKz = false;
    private c eAl = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eKz) {
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
        this.eKy = new CreateGroupActivityModel(this);
        this.eKx = new a(this);
        if (this.eKy.aPN() != null) {
            if (bundle != null) {
                this.eKy.aPN().setGroupId(bundle.getLong("gid", 0L));
                this.eKz = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eKz) {
                    this.eKy.aPN().setActivityId(bundle.getInt("aid", 0));
                    this.eKy.aPN().setgActivityTitle(bundle.getString("name"));
                    this.eKy.aPN().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eKy.aPN().setgActivityContent(bundle.getString("content"));
                    this.eKy.aPN().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eKy.aPN().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eKz = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eKz) {
                    this.eKy.aPN().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eKy.aPN().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eKy.aPN().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eKy.aPN().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eKy.aPN().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eKx.a(this.eKy.aPN(), this.eKz);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eKy == null) {
            this.eKy = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eKy.aPN() != null) {
            this.eKy.aPN().setGroupId(intent.getLongExtra("gid", 0L));
            this.eKz = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eKz) {
                this.eKy.aPN().setActivityId(intent.getIntExtra("aid", 0));
                this.eKy.aPN().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eKy.aPN().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eKy.aPN().setgActivityContent(getIntent().getStringExtra("content"));
                this.eKy.aPN().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eKx == null) {
            this.eKx = new a(this);
        }
        this.eKx.a(this.eKy.aPN(), this.eKz);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eKy.aPN() != null) {
            j = this.eKy.aPN().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eKx.getTitle());
        bundle.putString("content", this.eKx.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eKx.aPS());
        bundle.putLong("time", this.eKx.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eKx != null) {
            this.eKx.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eAl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eKy.cancelMessage();
        this.eKx.destroy();
        MessageManager.getInstance().unRegisterListener(this.eAl);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKx.aPQ()) {
            aPM();
        } else if (view == this.eKx.aPR() && this.eKy != null && this.eKy.aPN() != null) {
            long time = this.eKx.getTime();
            if ((!this.eKz || this.eKx.aPT()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eKy.aPN().setgActivityArea(this.eKx.aPS());
            this.eKy.aPN().setgActivityContent(this.eKx.getContent());
            this.eKy.aPN().setgActivityTime(time);
            this.eKy.aPN().setgActivityTitle(this.eKx.getTitle());
            showProgressBar();
            this.eKy.iD(this.eKz);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aPM();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aPM() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eKz, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
