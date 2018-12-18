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
    private a eRm;
    private CreateGroupActivityModel eRn;
    private boolean eRo = false;
    private c eHa = new c(103120) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
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
                        if (CreateGroupActivityActivity.this.eRo) {
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
        this.eRn = new CreateGroupActivityModel(this);
        this.eRm = new a(this);
        if (this.eRn.aRE() != null) {
            if (bundle != null) {
                this.eRn.aRE().setGroupId(bundle.getLong("gid", 0L));
                this.eRo = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eRo) {
                    this.eRn.aRE().setActivityId(bundle.getInt("aid", 0));
                    this.eRn.aRE().setgActivityTitle(bundle.getString("name"));
                    this.eRn.aRE().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eRn.aRE().setgActivityContent(bundle.getString("content"));
                    this.eRn.aRE().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.eRn.aRE().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.eRo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.eRo) {
                    this.eRn.aRE().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.eRn.aRE().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.eRn.aRE().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.eRn.aRE().setgActivityContent(getIntent().getStringExtra("content"));
                    this.eRn.aRE().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.eRm.a(this.eRn.aRE(), this.eRo);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.eRn == null) {
            this.eRn = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.eRn.aRE() != null) {
            this.eRn.aRE().setGroupId(intent.getLongExtra("gid", 0L));
            this.eRo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.eRo) {
                this.eRn.aRE().setActivityId(intent.getIntExtra("aid", 0));
                this.eRn.aRE().setgActivityTitle(getIntent().getStringExtra("name"));
                this.eRn.aRE().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.eRn.aRE().setgActivityContent(getIntent().getStringExtra("content"));
                this.eRn.aRE().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.eRm == null) {
            this.eRm = new a(this);
        }
        this.eRm.a(this.eRn.aRE(), this.eRo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.eRn.aRE() != null) {
            j = this.eRn.aRE().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.eRm.getTitle());
        bundle.putString("content", this.eRm.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.eRm.aRJ());
        bundle.putLong("time", this.eRm.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.eRm != null) {
            this.eRm.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.eHa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eRn.cancelMessage();
        this.eRm.destroy();
        MessageManager.getInstance().unRegisterListener(this.eHa);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eRm.aRH()) {
            aRD();
        } else if (view == this.eRm.aRI() && this.eRn != null && this.eRn.aRE() != null) {
            long time = this.eRm.getTime();
            if ((!this.eRo || this.eRm.aRK()) && 1000 * time < System.currentTimeMillis()) {
                showToast(e.j.group_activity_time_val);
                return;
            }
            this.eRn.aRE().setgActivityArea(this.eRm.aRJ());
            this.eRn.aRE().setgActivityContent(this.eRm.getContent());
            this.eRn.aRE().setgActivityTime(time);
            this.eRn.aRE().setgActivityTitle(this.eRm.getTitle());
            showProgressBar();
            this.eRn.iG(this.eRo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aRD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aRD() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.eRo, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
