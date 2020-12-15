package com.baidu.tieba.im.groupActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.util.DialogUtil;
/* loaded from: classes23.dex */
public class CreateGroupActivityActivity extends BaseActivity implements View.OnClickListener {
    private a kvm;
    private CreateGroupActivityModel kvn;
    private boolean kvo = false;
    private c kjh = new c(CmdConfigSocket.CMD_CREATE_GROUP_ACTIVITY) { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            CreateGroupActivityActivity.this.hideProgressBar();
            if (socketResponsedMessage == null) {
                CreateGroupActivityActivity.this.showToast(R.string.neterror);
            } else if (socketResponsedMessage.getCmd() == 103120) {
                if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                    ResponseCreateGroupActivityMessage responseCreateGroupActivityMessage = (ResponseCreateGroupActivityMessage) socketResponsedMessage;
                    if (responseCreateGroupActivityMessage.getError() == 0) {
                        if (CreateGroupActivityActivity.this.kvo) {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_edit_succ);
                        } else {
                            CreateGroupActivityActivity.this.showToast(R.string.group_activity_create_succ);
                        }
                        CreateGroupActivityActivity.this.setResult(-1);
                        CreateGroupActivityActivity.this.finish();
                        return;
                    }
                    CreateGroupActivityActivity.this.showToast(StringUtils.isNull(responseCreateGroupActivityMessage.getErrorString()) ? CreateGroupActivityActivity.this.getResources().getString(R.string.neterror) : responseCreateGroupActivityMessage.getErrorString());
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
        this.kvn = new CreateGroupActivityModel(this);
        this.kvm = new a(this);
        if (this.kvn.cXw() != null) {
            if (bundle != null) {
                this.kvn.cXw().setGroupId(bundle.getLong("gid", 0L));
                this.kvo = bundle.getBoolean(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kvo) {
                    this.kvn.cXw().setActivityId(bundle.getInt("aid", 0));
                    this.kvn.cXw().setgActivityTitle(bundle.getString("name"));
                    this.kvn.cXw().setgActivityArea(bundle.getString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kvn.cXw().setgActivityContent(bundle.getString("content"));
                    this.kvn.cXw().setgActivityTime(bundle.getLong("time", 0L));
                }
            } else if (getIntent() != null) {
                this.kvn.cXw().setGroupId(getIntent().getLongExtra("gid", 0L));
                this.kvo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
                if (this.kvo) {
                    this.kvn.cXw().setActivityId(getIntent().getIntExtra("aid", 0));
                    this.kvn.cXw().setgActivityTitle(getIntent().getStringExtra("name"));
                    this.kvn.cXw().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    this.kvn.cXw().setgActivityContent(getIntent().getStringExtra("content"));
                    this.kvn.cXw().setgActivityTime(getIntent().getLongExtra("time", 0L));
                }
            }
        }
        this.kvm.a(this.kvn.cXw(), this.kvo);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initListener();
        if (this.kvn == null) {
            this.kvn = new CreateGroupActivityModel(this);
        }
        if (intent == null) {
            intent = getIntent();
        }
        if (intent != null && this.kvn.cXw() != null) {
            this.kvn.cXw().setGroupId(intent.getLongExtra("gid", 0L));
            this.kvo = getIntent().getBooleanExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_ISEDIT, false);
            if (this.kvo) {
                this.kvn.cXw().setActivityId(intent.getIntExtra("aid", 0));
                this.kvn.cXw().setgActivityTitle(getIntent().getStringExtra("name"));
                this.kvn.cXw().setgActivityArea(getIntent().getStringExtra(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                this.kvn.cXw().setgActivityContent(getIntent().getStringExtra("content"));
                this.kvn.cXw().setgActivityTime(getIntent().getLongExtra("time", 0L));
            }
        }
        if (this.kvm == null) {
            this.kvm = new a(this);
        }
        this.kvm.a(this.kvn.cXw(), this.kvo);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        long j = 0;
        if (this.kvn.cXw() != null) {
            j = this.kvn.cXw().getGroupId();
        }
        bundle.putLong("gid", j);
        bundle.putString("name", this.kvm.getTitle());
        bundle.putString("content", this.kvm.getContent());
        bundle.putString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, this.kvm.cXB());
        bundle.putLong("time", this.kvm.getTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.kvm != null) {
            this.kvm.onChangeSkinType(i);
        }
    }

    private void initListener() {
        registerListener(this.kjh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kvn.cancelMessage();
        this.kvm.destroy();
        MessageManager.getInstance().unRegisterListener(this.kjh);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kvm.cXz()) {
            cXv();
        } else if (view == this.kvm.cXA() && this.kvn != null && this.kvn.cXw() != null) {
            long time = this.kvm.getTime();
            if ((!this.kvo || this.kvm.cXC()) && 1000 * time < System.currentTimeMillis()) {
                showToast(R.string.group_activity_time_val);
                return;
            }
            this.kvn.cXw().setgActivityArea(this.kvm.cXB());
            this.kvn.cXw().setgActivityContent(this.kvm.getContent());
            this.kvn.cXw().setgActivityTime(time);
            this.kvn.cXw().setgActivityTitle(this.kvm.getTitle());
            showProgressBar();
            this.kvn.sE(this.kvo);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cXv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cXv() {
        DialogUtil.quitCreateGroupActivity(getPageContext().getPageActivity(), this.kvo, new a.b() { // from class: com.baidu.tieba.im.groupActivity.CreateGroupActivityActivity.2
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
