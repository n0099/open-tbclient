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
    private a euf;
    private CreateGroupActivityModel eug;
    private boolean euh = false;
    private c ejL = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.euh) {
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
        this.eug = new CreateGroupActivityModel(this);
        this.euf = new a(this);
        if (this.eug.aKP() != null) {
            if (bundle != null) {
                this.eug.aKP().setGroupId(bundle.getLong("gid", 0L));
                this.euh = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.euh) {
                    this.eug.aKP().setActivityId(bundle.getInt("aid", 0));
                    this.eug.aKP().setgActivityTitle(bundle.getString("name"));
                    this.eug.aKP().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eug.aKP().setgActivityContent(bundle.getString("content"));
                    this.eug.aKP().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eug.aKP().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.euh = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.euh) {
                    this.eug.aKP().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eug.aKP().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eug.aKP().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eug.aKP().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eug.aKP().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.euf.a(this.eug.aKP(), this.euh);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eug == null) {
            this.eug = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eug.aKP() != null) {
            this.eug.aKP().setGroupId(intent.getLongExtra("gid", 0L));
            this.euh = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.euh) {
                this.eug.aKP().setActivityId(intent.getIntExtra("aid", 0));
                this.eug.aKP().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eug.aKP().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eug.aKP().setgActivityContent(getIntent().getStringExtra("content"));
                this.eug.aKP().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.euf == null) {
            this.euf = new a(this);
        }
        this.euf.a(this.eug.aKP(), this.euh);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eug.aKP() != null) {
            j = this.eug.aKP().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.euf.getTitle());
        bundle.putString("content", this.euf.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.euf.aKU());
        bundle.putLong("time", this.euf.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.euf != null) {
            this.euf.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.ejL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eug.cancelMessage();
        this.euf.destroy();
        MessageManager.getInstance().unRegisterListener(this.ejL);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.euf.aKS()) {
            aKO();
        } else if (view == this.euf.aKT() && this.eug != null && this.eug.aKP() != null) {
            long time = this.euf.getTime();
            if ((!this.euh || this.euf.aKV()) && 1000 * time < System.currentTimeMillis()) {
                showToast(d.j.group_activity_time_val);
                return;
            }
            this.eug.aKP().setgActivityArea(this.euf.aKU());
            this.eug.aKP().setgActivityContent(this.euf.getContent());
            this.eug.aKP().setgActivityTime(time);
            this.eug.aKP().setgActivityTitle(this.euf.getTitle());
            showProgressBar();
            this.eug.hE(this.euh);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aKO();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aKO() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.euh, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
